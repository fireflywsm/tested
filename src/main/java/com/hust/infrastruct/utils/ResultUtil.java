/*Copyright ©  2017 Lyons. All rights reserved. */
package com.hust.infrastruct.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.hust.infrastruct.utils.enums.AccountStaEnum;

/**
 * 
 * @description 
 * @author ZZH
 * @date 2017年5月8日上午11:39:45
 * @version
 */
public class ResultUtil
{
    private static Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
    
    public ResultUtil(){}
    
    /**
     * 
     * @Title: putLinkedMap
     * @Description: Message 消息结果
     * @param object
     * @return: Map<String,Object>
     */
    public static Map<String, Object> putMessageMap(Object object)
    {
        resultMap.put("Message", object);
        return resultMap;
    }
    
    /**
     * 
     * @Title: putLinkedMap
     * @Description: State 消息状态
     * @param object
     * @return: Map<String,Object>
     */
    public static Map<String, Object> putStateMap(Object object)
    {
        resultMap.put("State", object);
        return resultMap;
    }
    
    /**
     * 
     * @Title: putLinkedMap
     * @Description: Url 请求地址
     * @param object
     * @return: Map<String,Object>
     */
    public static Map<String, Object> putUrlMap(Object object)
    {
        resultMap.put("Url", object);
        return resultMap;
    }
    
    /**
     * 
     * @Title: clearMap
     * @Description: 清空消息集
     * @return: void
     */
    public static void clearMap()
    {
        resultMap.clear();
    }
    
    /**
     * 
     * @Title: getLinkedMap
     * @Description: 返回消息集
     * @return: Map<String,Object>
     */
    public static  Map<String, Object> getLinkedMap()
    {
        return resultMap;
    }
    
    /**
     * 
     * @Title: getJson
     * @Description: String -> Map("message",Object) -> json
     * @param message
     * @return
     * @return: String(json)
     */
    public static String getJson(String message)
    {
        resultMap.clear();
        resultMap.put("message", message);
        return toJson(resultMap);
    }
    
    /**
     * 
     * @Title: getJson
     * @Description: int -> Map("message",Object) -> json
     * @param state
     * @return: String(json)
     */
    public static String getJson(int state)
    {
        resultMap.clear();
        resultMap.put("state", state);
        return toJson(resultMap);
    }
    
    /**
     * 
     * @Title: getUrlJson
     * @Description: after login success,return the url(json)
     * @param request
     * @return: String
     */
    public static String getUrlJson(HttpServletRequest request)
    {
        resultMap.clear();
        resultMap.put("state", AccountStaEnum.success.getState());
        resultMap.put("url", VisitorUtil.getSaveURL(request));
        return toJson(resultMap);
    }
    
    /**
     * 
     * @Title: toJson
     * @Description: object -> json
     * @param object
     * @return: String
     */
    public static String toJson(Object object)
    {
        return new Gson().toJson(object);
    }
}
