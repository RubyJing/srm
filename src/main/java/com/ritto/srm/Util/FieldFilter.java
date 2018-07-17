package com.ritto.srm.Util;

import java.lang.reflect.Field;
/**
 * @Auther: Eiden J.P Zhou
 * @Date: 2018/7/13
 * @Description:
 * @Modified By:
 */

public interface FieldFilter
{
    boolean accept(Field field);
}
