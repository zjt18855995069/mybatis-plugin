package com.zhujt.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.StringUtility;
import util.ShardingUtil;

import java.util.List;

public class SelectOneByExampleWithBLOBsPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze,  IntrospectedTable introspectedTable) {
        Method selectFirstByExampleByPagination = new Method("selectFirstByExampleByPagination");

        FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
        FullyQualifiedJavaType baseRecordType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());

        Parameter example = new Parameter(exampleType, "example");
        example.addAnnotation("@Param(\"example\")");
        selectFirstByExampleByPagination.addParameter(example);
        selectFirstByExampleByPagination.setReturnType(baseRecordType);
        interfaze.addMethod(selectFirstByExampleByPagination);
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement selectOneElement = new XmlElement("select");
        Attribute id = new Attribute("id", "selectOneByExampleWithBLOBs");
        Attribute resultMap = new Attribute("resultMap", "ResultMapWithBLOBs");
        Attribute parameterType = new Attribute("parameterType", introspectedTable.getExampleType());
        selectOneElement.addAttribute(id);
        selectOneElement.addAttribute(resultMap);
        selectOneElement.addAttribute(parameterType);

        selectOneElement.addElement(new TextElement("select"));

        XmlElement ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "example.distinct"));
        ifElement.addElement(new TextElement("distinct"));
        selectOneElement.addElement(ifElement);

        StringBuilder sb = new StringBuilder();
        if (StringUtility.stringHasValue(introspectedTable.getSelectByExampleQueryId())) {
            sb.append('\'');
            sb.append(introspectedTable.getSelectByExampleQueryId());
            sb.append("' as QUERYID,");
            selectOneElement.addElement(new TextElement(sb.toString()));
        }
        selectOneElement.addElement(getBaseColumnListElement(introspectedTable));
        selectOneElement.addElement(new TextElement(","));
        selectOneElement.addElement(getBlobColumnListElement(introspectedTable));

        sb.setLength(0);
        sb.append("from ");
        sb.append(ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
        selectOneElement.addElement(new TextElement(sb.toString()));
        selectOneElement.addElement(getExampleIncludeElement(introspectedTable));

        ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "example.orderByClause != null"));
        ifElement.addElement(new TextElement("order by ${example.orderByClause}"));
        selectOneElement.addElement(ifElement);
        selectOneElement.addElement(new TextElement("limit 1"));

        document.getRootElement().addElement(selectOneElement);
        return true;
    }

    protected XmlElement getBaseColumnListElement(IntrospectedTable introspectedTable) {
        XmlElement baseColumnListXml = new XmlElement("include");
        baseColumnListXml.addAttribute(new Attribute("refid", introspectedTable.getBaseColumnListId()));
        return baseColumnListXml;
    }

    protected XmlElement getBlobColumnListElement(IntrospectedTable introspectedTable) {
        XmlElement baseColumnListXml = new XmlElement("include");
        baseColumnListXml.addAttribute(new Attribute("refid", introspectedTable.getBlobColumnListId()));
        return baseColumnListXml;
    }

    protected XmlElement getExampleIncludeElement(IntrospectedTable introspectedTable) {
        XmlElement ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "_parameter != null"));

        XmlElement includeElement = new XmlElement("include");
        includeElement.addAttribute(new Attribute("refid",
                introspectedTable.getMyBatis3UpdateByExampleWhereClauseId()));
        ifElement.addElement(includeElement);

        return ifElement;
    }
}