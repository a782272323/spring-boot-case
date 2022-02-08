package learn.lhb.springbootcase.common.utils.sql;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author lianghongbin
 * @Date 16:43 2022/2/8
 * @Description 
 */
@Slf4j
public class CommonSqlUtils {

    public static String sqlLike(String keyword) {
        if (StringUtils.isBlank(keyword)) {
            return null;
        }
        return keyword.startsWith("%") ? keyword : "%" + keyword.trim() + "%";
    }
}
