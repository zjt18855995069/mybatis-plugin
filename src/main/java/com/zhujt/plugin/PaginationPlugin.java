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

public class PaginationPlugin extends PluginAdapter {
    private static final FullyQualifiedJavaType integerType = new FullyQualifiedJavaType("java.lang.Integer");

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {
        Method selectByExampleByPagination = new Method("selectByExampleByPagination");

        introspectedTable.getBaseRecordType();

        FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
        FullyQualifiedJavaType baseRecordType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());

        Parameter example = new Parameter(exampleType, "example");
        example.addAnnotation("@Param(\"example\")");
        Parameter startRow = new Parameter(integerType, "startRow");
        startRow.addAnnotation("@Param(\"startRow\")");
        Parameter endRow = new Parameter(integerType, "endRow");
        endRow.addAnnotation("@Param(\"endRow\")");
        selectByExampleByPagination.addParameter(example);
        selectByExampleByPagination.addParameter(startRow);
        selectByExampleByPagination.addParameter(endRow);
        FullyQualifiedJavaType listType = new FullyQualifiedJavaType("java.util.List");
        listType.addTypeArgument(baseRecordType);
        selectByExampleByPagination.setReturnType(listType);
        interfaze.addMethod(selectByExampleByPagination);
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement paginationXml = new XmlElement("select");
        Attribute id = new Attribute("id", "selectByExampleByPagination");
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

        ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "startRow != null &amp;&amp; endRow != null"));
        ifElement.addElement(new TextElement("limit ${startRow}, ${endRow}"));
        paginationXml.addElement(ifElement);

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