package com.zhujt.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * @author zhujt
 */
public class RepositoryPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaced, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType repositoryAnnotationType = new FullyQualifiedJavaType("org.springframework.stereotype.Repository");
        interfaced.addImportedType(repositoryAnnotationType);
        interfaced.addAnnotation("@Repository");
        super.clientGenerated(interfaced, introspectedTable);
        return true;
    }
}