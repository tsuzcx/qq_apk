package com.facebook.stetho.json;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ObjectMapper
{
  @GuardedBy("mJsonValueMethodCache")
  private final Map<Class<?>, Method> mJsonValueMethodCache = new IdentityHashMap();
  
  private <T> T _convertFromJSONObject(JSONObject paramJSONObject, Class<T> paramClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, JSONException
  {
    Constructor localConstructor = paramClass.getDeclaredConstructor((Class[])null);
    localConstructor.setAccessible(true);
    Object localObject2 = localConstructor.newInstance(new Object[0]);
    Field[] arrayOfField = paramClass.getFields();
    int i = 0;
    while (i < arrayOfField.length)
    {
      localConstructor = arrayOfField[i];
      Object localObject1 = getValueForField(localConstructor, paramJSONObject.opt(localConstructor.getName()));
      try
      {
        localConstructor.set(localObject2, localObject1);
        i += 1;
      }
      catch (IllegalArgumentException paramJSONObject)
      {
        throw new IllegalArgumentException("Class: " + paramClass.getSimpleName() + " " + "Field: " + localConstructor.getName() + " type " + localObject1.getClass().getName(), paramJSONObject);
      }
    }
    return localObject2;
  }
  
  private JSONObject _convertToJSONObject(Object paramObject)
    throws JSONException, InvocationTargetException, IllegalAccessException
  {
    JSONObject localJSONObject = new JSONObject();
    Field[] arrayOfField = paramObject.getClass().getFields();
    int i = 0;
    if (i < arrayOfField.length)
    {
      JsonProperty localJsonProperty = (JsonProperty)arrayOfField[i].getAnnotation(JsonProperty.class);
      Object localObject2;
      Object localObject1;
      String str;
      if (localJsonProperty != null)
      {
        localObject2 = arrayOfField[i].get(paramObject);
        localObject1 = arrayOfField[i].getType();
        if (localObject2 != null) {
          localObject1 = localObject2.getClass();
        }
        str = arrayOfField[i].getName();
        if ((!localJsonProperty.required()) || (localObject2 != null)) {
          break label119;
        }
        localObject1 = JSONObject.NULL;
      }
      for (;;)
      {
        localJSONObject.put(str, localObject1);
        i += 1;
        break;
        label119:
        if (localObject2 == JSONObject.NULL) {
          localObject1 = localObject2;
        } else {
          localObject1 = getJsonValue(localObject2, (Class)localObject1, arrayOfField[i]);
        }
      }
    }
    return localJSONObject;
  }
  
  private static boolean canDirectlySerializeClass(Class paramClass)
  {
    return (isWrapperOrPrimitiveType(paramClass)) || (paramClass.equals(String.class));
  }
  
  private List<Object> convertArrayToList(Field paramField, JSONArray paramJSONArray)
    throws IllegalAccessException, JSONException
  {
    int i = 0;
    Object localObject;
    if (List.class.isAssignableFrom(paramField.getType()))
    {
      localObject = ((ParameterizedType)paramField.getGenericType()).getActualTypeArguments();
      if (localObject.length != 1) {
        throw new IllegalArgumentException("Only able to handle a single type in a list " + paramField.getName());
      }
      paramField = (Class)localObject[0];
      localObject = new ArrayList();
      if (i < paramJSONArray.length())
      {
        if (paramField.isEnum()) {
          ((List)localObject).add(getEnumValue(paramJSONArray.getString(i), paramField));
        }
        for (;;)
        {
          i += 1;
          break;
          if (canDirectlySerializeClass(paramField))
          {
            ((List)localObject).add(paramJSONArray.get(i));
          }
          else
          {
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            if (localJSONObject == null) {
              ((List)localObject).add(null);
            } else {
              ((List)localObject).add(convertValue(localJSONObject, paramField));
            }
          }
        }
      }
    }
    else
    {
      throw new IllegalArgumentException("only know how to deserialize List<?> on field " + paramField.getName());
    }
    return localObject;
  }
  
  private JSONArray convertListToJsonArray(Object paramObject)
    throws InvocationTargetException, IllegalAccessException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = ((List)paramObject).iterator();
    if (localIterator.hasNext())
    {
      paramObject = localIterator.next();
      if (paramObject != null) {}
      for (paramObject = getJsonValue(paramObject, paramObject.getClass(), null);; paramObject = null)
      {
        localJSONArray.put(paramObject);
        break;
      }
    }
    return localJSONArray;
  }
  
  private Enum getEnumByMethod(String paramString, Class<? extends Enum> paramClass, Method paramMethod)
  {
    int i = 0;
    Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
    while (i < arrayOfEnum.length)
    {
      Enum localEnum = arrayOfEnum[i];
      try
      {
        Object localObject = paramMethod.invoke(localEnum, new Object[0]);
        if (localObject != null)
        {
          boolean bool = localObject.toString().equals(paramString);
          if (bool) {
            return localEnum;
          }
        }
      }
      catch (Exception paramString)
      {
        throw new IllegalArgumentException(paramString);
      }
      i += 1;
    }
    throw new IllegalArgumentException("No enum constant " + paramClass.getName() + "." + paramString);
  }
  
  private Enum getEnumValue(String paramString, Class<? extends Enum> paramClass)
  {
    Method localMethod = getJsonValueMethod(paramClass);
    if (localMethod != null) {
      return getEnumByMethod(paramString, paramClass, localMethod);
    }
    return Enum.valueOf(paramClass, paramString);
  }
  
  private Object getJsonValue(Object paramObject, Class<?> paramClass, Field paramField)
    throws InvocationTargetException, IllegalAccessException
  {
    if (paramObject == null) {
      paramField = null;
    }
    double d;
    do
    {
      do
      {
        return paramField;
        if (List.class.isAssignableFrom(paramClass)) {
          return convertListToJsonArray(paramObject);
        }
        paramField = getJsonValueMethod(paramClass);
        if (paramField != null) {
          return paramField.invoke(paramObject, new Object[0]);
        }
        if (!canDirectlySerializeClass(paramClass)) {
          return convertValue(paramObject, JSONObject.class);
        }
        if (paramClass.equals(Double.class)) {
          break;
        }
        paramField = paramObject;
      } while (!paramClass.equals(Float.class));
      d = ((Number)paramObject).doubleValue();
      if (Double.isNaN(d)) {
        return "NaN";
      }
      if (d == (1.0D / 0.0D)) {
        return "Infinity";
      }
      paramField = paramObject;
    } while (d != (-1.0D / 0.0D));
    return "-Infinity";
  }
  
  @Nullable
  private Method getJsonValueMethod(Class<?> paramClass)
  {
    synchronized (this.mJsonValueMethodCache)
    {
      Method localMethod2 = (Method)this.mJsonValueMethodCache.get(paramClass);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod1 = localMethod2;
        if (!this.mJsonValueMethodCache.containsKey(paramClass))
        {
          localMethod1 = getJsonValueMethodImpl(paramClass);
          this.mJsonValueMethodCache.put(paramClass, localMethod1);
        }
      }
      return localMethod1;
    }
  }
  
  @Nullable
  private static Method getJsonValueMethodImpl(Class<?> paramClass)
  {
    paramClass = paramClass.getMethods();
    int i = 0;
    while (i < paramClass.length)
    {
      if (paramClass[i].getAnnotation(JsonValue.class) != null) {
        return paramClass[i];
      }
      i += 1;
    }
    return null;
  }
  
  private Object getValueForField(Field paramField, Object paramObject)
    throws JSONException
  {
    if (paramObject != null) {
      try
      {
        if (paramObject == JSONObject.NULL) {
          return null;
        }
        if (paramObject.getClass() != paramField.getType())
        {
          if ((paramObject instanceof JSONObject)) {
            return convertValue(paramObject, paramField.getType());
          }
          if (paramField.getType().isEnum()) {
            return getEnumValue((String)paramObject, paramField.getType().asSubclass(Enum.class));
          }
          if ((paramObject instanceof JSONArray)) {
            return convertArrayToList(paramField, (JSONArray)paramObject);
          }
          if ((paramObject instanceof Number))
          {
            paramObject = (Number)paramObject;
            Class localClass = paramField.getType();
            if ((localClass == Integer.class) || (localClass == Integer.TYPE)) {
              return Integer.valueOf(paramObject.intValue());
            }
            if ((localClass == Long.class) || (localClass == Long.TYPE)) {
              return Long.valueOf(paramObject.longValue());
            }
            if ((localClass == Double.class) || (localClass == Double.TYPE)) {
              return Double.valueOf(paramObject.doubleValue());
            }
            if ((localClass == Float.class) || (localClass == Float.TYPE)) {
              return Float.valueOf(paramObject.floatValue());
            }
            if ((localClass == Byte.class) || (localClass == Byte.TYPE)) {
              return Byte.valueOf(paramObject.byteValue());
            }
            if ((localClass == Short.class) || (localClass == Short.TYPE)) {
              return Short.valueOf(paramObject.shortValue());
            }
            throw new IllegalArgumentException("Not setup to handle class " + localClass.getName());
          }
        }
      }
      catch (IllegalAccessException paramObject)
      {
        throw new IllegalArgumentException("Unable to set value for field " + paramField.getName(), paramObject);
      }
    }
    return paramObject;
  }
  
  private static boolean isWrapperOrPrimitiveType(Class<?> paramClass)
  {
    return (paramClass.isPrimitive()) || (paramClass.equals(Boolean.class)) || (paramClass.equals(Integer.class)) || (paramClass.equals(Character.class)) || (paramClass.equals(Byte.class)) || (paramClass.equals(Short.class)) || (paramClass.equals(Double.class)) || (paramClass.equals(Long.class)) || (paramClass.equals(Float.class));
  }
  
  public <T> T convertValue(Object paramObject, Class<T> paramClass)
    throws IllegalArgumentException
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      if (paramClass == Object.class) {
        break;
      }
      localObject = paramObject;
    } while (paramClass.isAssignableFrom(paramObject.getClass()));
    try
    {
      if ((paramObject instanceof JSONObject)) {
        return _convertFromJSONObject((JSONObject)paramObject, paramClass);
      }
      if (paramClass == JSONObject.class) {
        return _convertToJSONObject(paramObject);
      }
      throw new IllegalArgumentException("Expecting either fromValue or toValueType to be a JSONObject");
    }
    catch (NoSuchMethodException paramObject)
    {
      throw new IllegalArgumentException(paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      throw new IllegalArgumentException(paramObject);
    }
    catch (InstantiationException paramObject)
    {
      throw new IllegalArgumentException(paramObject);
    }
    catch (JSONException paramObject)
    {
      throw new IllegalArgumentException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      throw ExceptionUtil.propagate(paramObject.getCause());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.json.ObjectMapper
 * JD-Core Version:    0.7.0.1
 */