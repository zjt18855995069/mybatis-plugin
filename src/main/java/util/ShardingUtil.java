/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yanjun
 */
public final class ShardingUtil {

    private ShardingUtil() {

    }

    public static String toLogicalTableName(String tableName) {
        int index = tableName.lastIndexOf("_");

        // 表名没有下划线，直接返回
        if (-1 == index) {
            return tableName;
        }

        // 获取最后1个下划线之后的内容
        String number = tableName.substring(index + 1);

        if (StringUtils.isBlank(number)) {
            return tableName;
        }

        // 如果已数字结尾，去掉表名最后的'_数字'
        if (StringUtils.isNumeric(number)) {
            return tableName.substring(0, index);
        }

        return tableName;
    }

}
