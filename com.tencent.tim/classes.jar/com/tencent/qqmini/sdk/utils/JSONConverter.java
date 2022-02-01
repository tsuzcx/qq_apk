package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONConverter
{
  public static <T> JSONArray convert2JSONArray(List<T> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localJSONArray;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject != null) {
        if (isPrimitiveType(localObject)) {
          localJSONArray.put(localObject);
        } else if ((localObject instanceof List)) {
          localJSONArray.put(convert2JSONArray((List)localObject));
        } else {
          localJSONArray.put(convert2JSONObject(localObject));
        }
      }
    }
    return localJSONArray;
  }
  
  public static <T> JSONObject convert2JSONObject(T paramT)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramT == null) {
      return localJSONObject;
    }
    Field[] arrayOfField = paramT.getClass().getDeclaredFields();
    if ((arrayOfField == null) || (arrayOfField.length == 0)) {
      return localJSONObject;
    }
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = arrayOfField[i];
      if (localObject1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = (Alias)((Field)localObject1).getAnnotation(Alias.class);
        if (localObject2 != null)
        {
          localObject2 = ((Alias)localObject2).value();
          if (!isEmpty((String)localObject2))
          {
            try
            {
              localObject1 = ((Field)localObject1).get(paramT);
              if (localObject1 == null) {
                continue;
              }
              if (isPrimitiveType(localObject1)) {
                localJSONObject.put((String)localObject2, localObject1);
              }
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
              continue;
              if (!(localJSONException instanceof List)) {
                break label178;
              }
              localJSONObject.put((String)localObject2, convert2JSONArray((List)localJSONException));
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              localIllegalAccessException.printStackTrace();
            }
            continue;
            label178:
            localJSONObject.put((String)localObject2, convert2JSONObject(localIllegalAccessException));
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public static <T> List<T> convertFromJSONArray(String paramString, Type paramType)
  {
    if ((isEmpty(paramString)) || (paramType == null)) {
      return null;
    }
    try
    {
      paramString = convertFromJSONArray(new JSONArray(paramString), paramType);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static <T> List<T> convertFromJSONArray(JSONArray paramJSONArray, Type paramType)
  {
    if ((paramJSONArray == null) || (paramType == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    if (i < j)
    {
      Object localObject = paramJSONArray.opt(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof JSONObject))
        {
          Class localClass = (Class)paramType;
          localArrayList.add(convertFromJSONObject((JSONObject)localObject, localClass));
        }
        else if ((localObject instanceof JSONArray))
        {
          localArrayList.add(convertFromJSONArray((JSONArray)localObject, ((ParameterizedType)paramType).getActualTypeArguments()[0]));
        }
        else
        {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static <T> T convertFromJSONObject(String paramString, Class<T> paramClass)
  {
    if ((isEmpty(paramString)) || (paramClass == null)) {
      return null;
    }
    try
    {
      paramString = convertFromJSONObject(new JSONObject(paramString), paramClass);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static <T> T convertFromJSONObject(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if ((paramJSONObject == null) || (paramClass == null)) {
      return null;
    }
    try
    {
      Object localObject1 = paramClass.newInstance();
      if (localObject1 == null) {
        return null;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        localInstantiationException.printStackTrace();
        Object localObject2 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Object localObject3;
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
        localObject3 = null;
      }
      Field[] arrayOfField = paramClass.getDeclaredFields();
      if ((arrayOfField == null) || (arrayOfField.length == 0)) {
        return null;
      }
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Field localField = arrayOfField[i];
        if (localField == null) {}
        for (;;)
        {
          i += 1;
          break;
          int k = localField.getModifiers();
          if ((!Modifier.isStatic(k)) || (!Modifier.isFinal(k)))
          {
            paramClass = localField.getName();
            localObject4 = (Alias)localField.getAnnotation(Alias.class);
            if (localObject4 != null) {
              paramClass = ((Alias)localObject4).value();
            }
            if ((!isEmpty(paramClass)) && (paramJSONObject.has(paramClass)))
            {
              try
              {
                localObject4 = localField.getType().getSimpleName();
                localField.setAccessible(true);
                if ("int".equals(localObject4)) {
                  localField.set(localObject3, Integer.valueOf(paramJSONObject.optInt(paramClass)));
                }
              }
              catch (IllegalAccessException paramJSONObject)
              {
                paramJSONObject.printStackTrace();
                return null;
              }
              if ("boolean".equals(localObject4))
              {
                localField.set(localObject3, Boolean.valueOf(paramJSONObject.optBoolean(paramClass)));
              }
              else if ("long".equals(localObject4))
              {
                localField.set(localObject3, Long.valueOf(paramJSONObject.optLong(paramClass)));
              }
              else if ("double".equals(localObject4))
              {
                localField.set(localObject3, Double.valueOf(paramJSONObject.optDouble(paramClass)));
              }
              else if ("float".equals(localObject4))
              {
                localField.set(localObject3, Float.valueOf((float)paramJSONObject.optDouble(paramClass)));
              }
              else if ("String".equals(localObject4))
              {
                localField.set(localObject3, paramJSONObject.optString(paramClass));
              }
              else
              {
                if (!"Object".equals(localObject4)) {
                  break label382;
                }
                localField.set(localObject3, new Object());
              }
            }
          }
        }
        label382:
        Object localObject4 = paramJSONObject.opt(paramClass);
        if ((localObject4 instanceof JSONObject)) {
          paramClass = convertFromJSONObject((JSONObject)localObject4, localField.getType());
        }
        for (;;)
        {
          localField.set(localObject3, paramClass);
          break;
          if ((localObject4 instanceof JSONArray))
          {
            paramClass = (ParameterizedType)localField.getGenericType();
            paramClass = convertFromJSONArray((JSONArray)localObject4, paramClass.getActualTypeArguments()[0]);
          }
          else
          {
            printLog("convertFromJSONObject unknown field " + paramClass);
            paramClass = null;
          }
        }
      }
      return localObject3;
    }
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  private static boolean isPrimitiveType(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || ((paramObject instanceof Long)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Character)) || ((paramObject instanceof Short));
  }
  
  private static void printLog(String paramString)
  {
    QMLog.d("JSONConverter", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.JSONConverter
 * JD-Core Version:    0.7.0.1
 */