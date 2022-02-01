package com.tencent.ad.tangram.json;

import android.support.annotation.Keep;
import android.text.TextUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
public class AdJSON
{
  private static JSONArray fromArrayObject(Object paramObject, Set<Object> paramSet)
    throws Exception
  {
    if (!a.wrapClass(paramObject.getClass()).isArray()) {
      throw new Exception("not an array");
    }
    if (paramSet.contains(paramObject)) {
      return null;
    }
    paramSet.add(paramObject);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < Array.getLength(paramObject))
    {
      Object localObject = fromObject(Array.get(paramObject, i), paramSet);
      if ((localObject == null) || (localObject == JSONObject.NULL)) {
        localJSONArray.put(i, JSONObject.NULL);
      }
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(i, localObject);
      }
    }
    paramSet.remove(paramObject);
    return localJSONArray;
  }
  
  private static JSONObject fromClassObject(Object paramObject, Set<Object> paramSet)
    throws Exception
  {
    if (paramSet.contains(paramObject)) {
      return null;
    }
    paramSet.add(paramObject);
    Object localObject1 = a.wrapClass(paramObject.getClass());
    JSONObject localJSONObject = new JSONObject();
    localObject1 = a.getFields((Class)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Field localField = (Field)((Iterator)localObject1).next();
      if ((!TextUtils.equals(localField.getName(), "this$0")) && (!TextUtils.equals(localField.getName(), "$change")) && (!TextUtils.equals(localField.getName(), "serialVersionUID")))
      {
        boolean bool = localField.isAccessible();
        localField.setAccessible(true);
        Object localObject2 = localField.get(paramObject);
        localField.setAccessible(bool);
        localObject2 = fromObject(localObject2, paramSet);
        if ((localObject2 != null) || (localObject2 == JSONObject.NULL)) {
          localJSONObject.put(localField.getName(), localObject2);
        }
      }
    }
    paramSet.remove(paramObject);
    return localJSONObject;
  }
  
  private static Object fromNumberObject(Object paramObject)
    throws Exception
  {
    Class localClass = a.wrapClass(paramObject.getClass());
    if (!a.isNumberClass(localClass)) {
      throw new Exception("not a number");
    }
    if (localClass == Short.class) {
      return Integer.valueOf(((Short)Short.class.cast(paramObject)).shortValue());
    }
    if (localClass == Integer.class) {
      return Integer.class.cast(paramObject);
    }
    if (localClass == Long.class) {
      return paramObject.toString();
    }
    if (localClass == Float.class) {
      return Double.valueOf(((Float)Float.class.cast(paramObject)).floatValue());
    }
    if (localClass == Double.class) {
      return Double.class.cast(paramObject);
    }
    throw new Exception("not supported");
  }
  
  public static Object fromObject(Object paramObject)
    throws Exception
  {
    return fromObject(paramObject, new HashSet());
  }
  
  private static Object fromObject(Object paramObject, Set<Object> paramSet)
    throws Exception
  {
    if (paramObject == null) {
      return null;
    }
    if (paramSet == null) {
      throw new Exception("objects can not be null");
    }
    Class localClass = a.wrapClass(paramObject.getClass());
    if (a.isPrimitiveClass(localClass)) {
      return fromPrimitiveObject(paramObject);
    }
    if (localClass == String.class) {
      return String.valueOf(paramObject);
    }
    if (localClass.isArray()) {
      return fromArrayObject(paramObject, paramSet);
    }
    return fromClassObject(paramObject, paramSet);
  }
  
  private static Object fromPrimitiveObject(Object paramObject)
    throws Exception
  {
    Class localClass = a.wrapClass(paramObject.getClass());
    if (!a.isPrimitiveClass(localClass)) {
      throw new Exception("not primitive");
    }
    if (localClass == Boolean.class) {
      return Boolean.class.cast(paramObject);
    }
    if (localClass == Character.class) {
      return String.valueOf(Character.class.cast(paramObject));
    }
    if (localClass == Byte.class) {
      throw new Exception("not supported");
    }
    if (a.isNumberClass(localClass)) {
      return fromNumberObject(paramObject);
    }
    throw new Exception("not supported");
  }
  
  private static Object toArrayObject(JSONArray paramJSONArray, Class paramClass)
    throws Exception
  {
    if (!paramClass.isArray()) {
      throw new Exception("not an array");
    }
    Object localObject2 = Array.newInstance(paramClass.getComponentType(), paramJSONArray.length());
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject1 = paramJSONArray.get(i);
      if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {}
      for (localObject1 = null;; localObject1 = toObject(localObject1, paramClass.getComponentType()))
      {
        Array.set(localObject2, i, localObject1);
        i += 1;
        break;
      }
    }
    return localObject2;
  }
  
  private static Boolean toBooleanObject(Object paramObject, Class paramClass)
    throws Exception
  {
    if (a.wrapClass(paramClass) != Boolean.class) {
      throw new Exception("not boolean");
    }
    if (a.wrapClass(paramObject.getClass()) == Boolean.class) {
      return (Boolean)Boolean.class.cast(paramObject);
    }
    throw new Exception("format error");
  }
  
  private static Character toCharacterbject(Object paramObject, Class paramClass)
    throws Exception
  {
    if (a.wrapClass(paramClass) != Character.class) {
      throw new Exception("not a character");
    }
    if (a.wrapClass(paramObject.getClass()) == Character.class) {
      return (Character)Character.class.cast(paramObject);
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)String.class.cast(paramObject);
      if (paramObject.length() == 0) {
        return null;
      }
      if (paramObject.length() == 1) {
        return Character.valueOf(paramObject.charAt(0));
      }
      throw new Exception("format error");
    }
    throw new Exception("format error");
  }
  
  private static Object toClassObject(JSONObject paramJSONObject, Class paramClass)
    throws Exception
  {
    if ((a.isPrimitiveClass(paramClass)) || (paramClass == String.class)) {
      throw new Exception("not a class");
    }
    Object localObject2 = paramClass.newInstance();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Field localField = a.getField(paramClass, (String)localObject1);
      if (localField != null)
      {
        localObject1 = paramJSONObject.get((String)localObject1);
        if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {}
        for (localObject1 = null;; localObject1 = toObject(localObject1, localField.getType()))
        {
          boolean bool = localField.isAccessible();
          localField.setAccessible(true);
          localField.set(localObject2, localObject1);
          localField.setAccessible(bool);
          break;
        }
      }
    }
    return localObject2;
  }
  
  private static Object toNumberObject(Object paramObject, Class paramClass)
    throws Exception
  {
    Class localClass1 = a.wrapClass(paramClass);
    if (!a.isNumberClass(localClass1)) {
      throw new Exception("not a number");
    }
    Class localClass2 = a.wrapClass(paramObject.getClass());
    Class[] arrayOfClass = new Class[3];
    arrayOfClass[0] = Short.class;
    arrayOfClass[1] = Integer.class;
    arrayOfClass[2] = Long.class;
    if ((a.isClass(localClass1, arrayOfClass)) && ((a.isClass(localClass2, arrayOfClass)) || (localClass2 == String.class))) {
      paramClass = localClass1.getDeclaredMethod("valueOf", new Class[] { String.class }).invoke(localClass1, new Object[] { paramObject.toString() });
    }
    do
    {
      return paramClass;
      if (localClass1 != Float.class) {
        break;
      }
      paramClass = paramObject;
    } while (localClass2 == Float.class);
    if (localClass2 == Double.class)
    {
      double d = ((Double)Double.class.cast(paramObject)).doubleValue();
      if (TextUtils.equals(String.valueOf(d), String.valueOf(1.4E-45F))) {
        return Float.valueOf(1.4E-45F);
      }
      if (TextUtils.equals(String.valueOf(d), String.valueOf(3.4028235E+38F))) {
        return Float.valueOf(3.4028235E+38F);
      }
      if ((d < 1.401298464324817E-045D) || (d > 3.402823466385289E+038D)) {
        throw new Exception("out of range");
      }
      return localClass1.getDeclaredMethod("valueOf", new Class[] { String.class }).invoke(localClass1, new Object[] { paramObject.toString() });
    }
    if ((localClass2 == String.class) || (a.isClass(localClass2, arrayOfClass))) {
      return toNumberObject(Double.valueOf(paramObject.toString()), localClass1);
    }
    throw new Exception("format error");
    if (localClass1 == Double.class) {
      if (!a.isClass(localClass2, arrayOfClass))
      {
        if ((!a.isClass(localClass2, new Class[] { Float.class, Double.class })) && (localClass2 != String.class)) {}
      }
      else {
        return localClass1.getDeclaredMethod("valueOf", new Class[] { String.class }).invoke(localClass1, new Object[] { paramObject.toString() });
      }
    }
    throw new Exception("format error");
  }
  
  public static Object toObject(Object paramObject, Class paramClass)
    throws Exception
  {
    if (paramClass == null) {
      throw new Exception("cls can not be null");
    }
    if (paramObject == null) {
      return null;
    }
    if (a.isPrimitiveClass(paramClass)) {
      return toPrimitiveObject(paramObject, paramClass);
    }
    if (paramClass == String.class) {
      return toStringObject(paramObject, paramClass);
    }
    if (paramClass.isArray()) {
      return toArrayObject((JSONArray)JSONArray.class.cast(paramObject), paramClass);
    }
    if (paramObject.getClass() == JSONObject.class) {
      return toClassObject((JSONObject)JSONObject.class.cast(paramObject), paramClass);
    }
    throw new Exception("format error");
  }
  
  private static Object toPrimitiveObject(Object paramObject, Class paramClass)
    throws Exception
  {
    paramClass = a.wrapClass(paramClass);
    if (!a.isPrimitiveClass(paramClass)) {
      throw new Exception("not primitive");
    }
    if (paramClass == Boolean.class) {
      return toBooleanObject(paramObject, paramClass);
    }
    if (paramClass == Character.class) {
      return toCharacterbject(paramObject, paramClass);
    }
    if (paramClass == Byte.class) {
      throw new Exception("byte is not supported");
    }
    if (a.isNumberClass(paramClass)) {
      return toNumberObject(paramObject, paramClass);
    }
    throw new Exception("not supported");
  }
  
  private static String toStringObject(Object paramObject, Class paramClass)
    throws Exception
  {
    if (paramClass != String.class) {
      throw new Exception("not a string");
    }
    if (!(paramObject instanceof String)) {
      throw new Exception("format error");
    }
    return (String)String.class.cast(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.json.AdJSON
 * JD-Core Version:    0.7.0.1
 */