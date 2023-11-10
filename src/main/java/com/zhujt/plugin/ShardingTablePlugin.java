/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.zhujt.plugin;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.XmlElement;
import util.ShardingUtil;

import java.util.List;

public class ShardingTablePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapResultMapWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapResultMapWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapCountByExampleElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapDeleteByExampleElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapDeleteByPrimaryKeyElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapExampleWhereClauseElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapInsertElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapResultMapWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapResultMapWithBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapSelectByPrimaryKeyElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapUpdateByExampleSelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapUpdateByExampleWithBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapBaseColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapBaseColumnListElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapBlobColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapBlobColumnListElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectAllElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = ShardingUtil.toLogicalTableName(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(tableName);
        tableName = ShardingUtil.toLogicalTableName(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(tableName);
        return super.sqlMapSelectAllElementGenerated(element, introspectedTable);
    }


}
