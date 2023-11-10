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

/**
 * @author zhujt
 */
public class SelectByExampleForUpdatePlugin
        extends PluginAdapter {
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaced, IntrospectedTable introspectedTable) {
        Method selectByExampleForUpdate = new Method("selectByExampleForUpdate");

        introspectedTable.getBaseRecordType();

        FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
        FullyQualifiedJavaType baseRecordType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());

        Parameter example = new Parameter(exampleType, "example");
        example.addAnnotation("@Param(\"example\")");
        selectByExampleForUpdate.addParameter(example);
        FullyQualifiedJavaType listType = new FullyQualifiedJavaType("java.util.List");
        listType.addTypeArgument(baseRecordType);
        selectByExampleForUpdate.setReturnType(listType);
        interfaced.addMethod(selectByExampleForUpdate);
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement paginationXml = new XmlElement("select");
        Attribute id = new Attribute("id", "selectByExampleForUpdate");
        Attribute resultMap = new Attribute("resultMap", "BaseResultMap");
        Attribute parameterType = new Attribute("parameterType", introspectedTable.getExampleType());
        paginationXml.addAttribute(id);
        paginationXml.addAttribute(resultMap);
        paginationXml.addAttribute(parameterType);

        paginationXml.addElement(new TextElement("select"));

        XmlElement ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "example.distinct"));
        ifElement.addElement(new TextElement("distinct"));
        paginationXml.addElement(ifElement);

        StringBuilder sb = new StringBuilder();
        if (StringUtility.stringHasValue(introspectedTable.getSelectByExampleQueryId())) {
            sb.append('\'');
            sb.append(introspectedTable.getSelectByExampleQueryId());
            sb.append("' as QUERYID,");
            paginationXml.addElement(new TextElement(sb.toString()));
        }
        paginationXml.addElement(getBaseColumnListElement(introspectedTable));

        sb.setLength(0);
        sb.append("from ");
        sb.append(ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
        paginationXml.addElement(new TextElement(sb.toString()));
        paginationXml.addElement(getExampleIncludeElement(introspectedTable));

        ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "example.orderByClause != null"));
        ifElement.addElement(new TextElement("order by ${example.orderByClause}"));
        paginationXml.addElement(ifElement);

        paginationXml.addElement(new TextElement(" for update"));
        document.getRootElement().addElement(paginationXml);

        return true;
    }

    private XmlElement getBaseColumnListElement(IntrospectedTable introspectedTable) {
        XmlElement baseColumnListXml = new XmlElement("include");
        baseColumnListXml.addAttribute(new Attribute("refid", introspectedTable.getBaseColumnListId()));
        return baseColumnListXml;
    }

    private XmlElement getExampleIncludeElement(IntrospectedTable introspectedTable) {
        XmlElement ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "_parameter != null"));

        XmlElement includeElement = new XmlElement("include");
        includeElement.addAttribute(new Attribute("refid",
                introspectedTable.getMyBatis3UpdateByExampleWhereClauseId()));
        ifElement.addElement(includeElement);

        return ifElement;
    }
}