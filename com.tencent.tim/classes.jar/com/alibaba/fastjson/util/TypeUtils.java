package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeUtils
{
  public static boolean compatibleWithJavaBean = false;
  private static ConcurrentMap<String, Class<?>> mappings;
  private static boolean setAccessibleEnable = true;
  
  static
  {
    mappings = new ConcurrentHashMap();
    mappings.put("byte", Byte.TYPE);
    mappings.put("short", Short.TYPE);
    mappings.put("int", Integer.TYPE);
    mappings.put("long", Long.TYPE);
    mappings.put("float", Float.TYPE);
    mappings.put("double", Double.TYPE);
    mappings.put("boolean", Boolean.TYPE);
    mappings.put("char", Character.TYPE);
    mappings.put("[byte", [B.class);
    mappings.put("[short", [S.class);
    mappings.put("[int", [I.class);
    mappings.put("[long", [J.class);
    mappings.put("[float", [F.class);
    mappings.put("[double", [D.class);
    mappings.put("[boolean", [Z.class);
    mappings.put("[char", [C.class);
    mappings.put("[B", [B.class);
    mappings.put("[S", [S.class);
    mappings.put("[I", [I.class);
    mappings.put("[J", [J.class);
    mappings.put("[F", [F.class);
    mappings.put("[D", [D.class);
    mappings.put("[C", [C.class);
    mappings.put("[Z", [Z.class);
    mappings.put(HashMap.class.getName(), HashMap.class);
  }
  
  public static final <T> T cast(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    do
    {
      Map localMap;
      do
      {
        do
        {
          do
          {
            return localObject;
            if (paramClass == null) {
              throw new IllegalArgumentException("clazz is null");
            }
            localObject = paramObject;
          } while (paramClass == paramObject.getClass());
          if (!(paramObject instanceof Map)) {
            break;
          }
          localObject = paramObject;
        } while (paramClass == Map.class);
        localMap = (Map)paramObject;
        if (paramClass != Object.class) {
          break;
        }
        localObject = paramObject;
      } while (!localMap.containsKey("@type"));
      return castToJavaBean((Map)paramObject, paramClass, paramParserConfig);
      if (paramClass.isArray())
      {
        if ((paramObject instanceof Collection))
        {
          localObject = (Collection)paramObject;
          int i = 0;
          paramObject = Array.newInstance(paramClass.getComponentType(), ((Collection)localObject).size());
          localObject = ((Collection)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Array.set(paramObject, i, cast(((Iterator)localObject).next(), paramClass.getComponentType(), paramParserConfig));
            i += 1;
          }
          return paramObject;
        }
        if (paramClass == [B.class) {
          return castToBytes(paramObject);
        }
      }
      localObject = paramObject;
    } while (paramClass.isAssignableFrom(paramObject.getClass()));
    if ((paramClass == Boolean.TYPE) || (paramClass == Boolean.class)) {
      return castToBoolean(paramObject);
    }
    if ((paramClass == Byte.TYPE) || (paramClass == Byte.class)) {
      return castToByte(paramObject);
    }
    if ((paramClass == Short.TYPE) || (paramClass == Short.class)) {
      return castToShort(paramObject);
    }
    if ((paramClass == Integer.TYPE) || (paramClass == Integer.class)) {
      return castToInt(paramObject);
    }
    if ((paramClass == Long.TYPE) || (paramClass == Long.class)) {
      return castToLong(paramObject);
    }
    if ((paramClass == Float.TYPE) || (paramClass == Float.class)) {
      return castToFloat(paramObject);
    }
    if ((paramClass == Double.TYPE) || (paramClass == Double.class)) {
      return castToDouble(paramObject);
    }
    if (paramClass == String.class) {
      return castToString(paramObject);
    }
    if (paramClass == BigDecimal.class) {
      return castToBigDecimal(paramObject);
    }
    if (paramClass == BigInteger.class) {
      return castToBigInteger(paramObject);
    }
    if (paramClass == Date.class) {
      return castToDate(paramObject);
    }
    if (paramClass.isEnum()) {
      return castToEnum(paramObject, paramClass, paramParserConfig);
    }
    if (Calendar.class.isAssignableFrom(paramClass))
    {
      paramParserConfig = castToDate(paramObject);
      if (paramClass == Calendar.class) {
        paramObject = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
      }
      for (;;)
      {
        paramObject.setTime(paramParserConfig);
        return paramObject;
        try
        {
          paramObject = (Calendar)paramClass.newInstance();
        }
        catch (Exception paramObject)
        {
          throw new JSONException("can not cast to : " + paramClass.getName(), paramObject);
        }
      }
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ((paramObject.length() == 0) || ("null".equals(paramObject))) {
        return null;
      }
      if (paramClass == Currency.class) {
        return Currency.getInstance(paramObject);
      }
    }
    throw new JSONException("can not cast to : " + paramClass.getName());
  }
  
  public static final <T> T cast(Object paramObject, ParameterizedType paramParameterizedType, ParserConfig paramParserConfig)
  {
    Object localObject3 = paramParameterizedType.getRawType();
    Object localObject1;
    Object localObject2;
    if ((localObject3 == Set.class) || (localObject3 == HashSet.class) || (localObject3 == TreeSet.class) || (localObject3 == List.class) || (localObject3 == ArrayList.class))
    {
      localObject1 = paramParameterizedType.getActualTypeArguments()[0];
      if ((paramObject instanceof Iterable))
      {
        if ((localObject3 == Set.class) || (localObject3 == HashSet.class)) {
          paramParameterizedType = new HashSet();
        }
        for (;;)
        {
          localObject2 = ((Iterable)paramObject).iterator();
          for (;;)
          {
            paramObject = paramParameterizedType;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramParameterizedType.add(cast(((Iterator)localObject2).next(), (Type)localObject1, paramParserConfig));
          }
          if (localObject3 == TreeSet.class) {
            paramParameterizedType = new TreeSet();
          } else {
            paramParameterizedType = new ArrayList();
          }
        }
      }
    }
    if ((localObject3 == Map.class) || (localObject3 == HashMap.class))
    {
      localObject1 = paramParameterizedType.getActualTypeArguments()[0];
      localObject2 = paramParameterizedType.getActualTypeArguments()[1];
      if ((paramObject instanceof Map))
      {
        paramParameterizedType = new HashMap();
        paramObject = ((Map)paramObject).entrySet().iterator();
        while (paramObject.hasNext())
        {
          localObject3 = (Map.Entry)paramObject.next();
          paramParameterizedType.put(cast(((Map.Entry)localObject3).getKey(), (Type)localObject1, paramParserConfig), cast(((Map.Entry)localObject3).getValue(), (Type)localObject2, paramParserConfig));
        }
        paramObject = paramParameterizedType;
        return paramObject;
      }
    }
    if ((paramObject instanceof String))
    {
      localObject1 = (String)paramObject;
      if ((((String)localObject1).length() == 0) || ("null".equals(localObject1))) {
        return null;
      }
    }
    if ((paramParameterizedType.getActualTypeArguments().length == 1) && ((paramParameterizedType.getActualTypeArguments()[0] instanceof WildcardType))) {
      return cast(paramObject, (Type)localObject3, paramParserConfig);
    }
    throw new JSONException("can not cast to : " + paramParameterizedType);
  }
  
  public static final <T> T cast(Object paramObject, Type paramType, ParserConfig paramParserConfig)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    do
    {
      return paramObject;
      if ((paramType instanceof Class)) {
        return cast(paramObject, (Class)paramType, paramParserConfig);
      }
      if ((paramType instanceof ParameterizedType)) {
        return cast(paramObject, (ParameterizedType)paramType, paramParserConfig);
      }
      if ((paramObject instanceof String))
      {
        paramParserConfig = (String)paramObject;
        if ((paramParserConfig.length() == 0) || ("null".equals(paramParserConfig))) {
          return null;
        }
      }
    } while ((paramType instanceof TypeVariable));
    throw new JSONException("can not cast to : " + paramType);
  }
  
  public static final BigDecimal castToBigDecimal(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof BigDecimal)) {
      return (BigDecimal)paramObject;
    }
    if ((paramObject instanceof BigInteger)) {
      return new BigDecimal((BigInteger)paramObject);
    }
    paramObject = paramObject.toString();
    if ((paramObject.length() == 0) || ("null".equals(paramObject))) {
      return null;
    }
    return new BigDecimal(paramObject);
  }
  
  public static final BigInteger castToBigInteger(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof BigInteger)) {
      return (BigInteger)paramObject;
    }
    if (((paramObject instanceof Float)) || ((paramObject instanceof Double))) {
      return BigInteger.valueOf(((Number)paramObject).longValue());
    }
    paramObject = paramObject.toString();
    if ((paramObject.length() == 0) || ("null".equals(paramObject))) {
      return null;
    }
    return new BigInteger(paramObject);
  }
  
  public static final Boolean castToBoolean(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    if ((paramObject instanceof Number))
    {
      if (((Number)paramObject).intValue() == 1) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if ((str.length() == 0) || ("null".equals(str))) {
        return null;
      }
      if (("true".equalsIgnoreCase(str)) || ("1".equals(str))) {
        return Boolean.TRUE;
      }
      if (("false".equalsIgnoreCase(str)) || ("0".equals(str))) {
        return Boolean.FALSE;
      }
    }
    throw new JSONException("can not cast to int, value : " + paramObject);
  }
  
  public static final Byte castToByte(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Byte.valueOf(((Number)paramObject).byteValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      paramObject = (String)paramObject;
    } while ((paramObject.length() == 0) || ("null".equals(paramObject)));
    return Byte.valueOf(Byte.parseByte(paramObject));
    throw new JSONException("can not cast to byte, value : " + paramObject);
  }
  
  public static final byte[] castToBytes(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return (byte[])paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      return JSONLexer.decodeFast(paramObject, 0, paramObject.length());
    }
    throw new JSONException("can not cast to int, value : " + paramObject);
  }
  
  public static final Character castToChar(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Character)) {
      return (Character)paramObject;
    }
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if (str.length() == 0) {
        return null;
      }
      if (str.length() != 1) {
        throw new JSONException("can not cast to byte, value : " + paramObject);
      }
      return Character.valueOf(str.charAt(0));
    }
    throw new JSONException("can not cast to byte, value : " + paramObject);
  }
  
  public static final Date castToDate(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Calendar)) {
      return ((Calendar)paramObject).getTime();
    }
    if ((paramObject instanceof Date)) {
      return (Date)paramObject;
    }
    long l = -1L;
    if ((paramObject instanceof Number)) {
      l = ((Number)paramObject).longValue();
    }
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if (str.indexOf('-') != -1)
      {
        if (str.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
          paramObject = JSON.DEFFAULT_DATE_FORMAT;
        }
        for (;;)
        {
          paramObject = new SimpleDateFormat(paramObject, JSON.defaultLocale);
          paramObject.setTimeZone(JSON.defaultTimeZone);
          try
          {
            paramObject = paramObject.parse(str);
            return paramObject;
          }
          catch (ParseException paramObject)
          {
            throw new JSONException("can not cast to Date, value : " + str);
          }
          if (str.length() == 10) {
            paramObject = "yyyy-MM-dd";
          } else if (str.length() == "yyyy-MM-dd HH:mm:ss".length()) {
            paramObject = "yyyy-MM-dd HH:mm:ss";
          } else {
            paramObject = "yyyy-MM-dd HH:mm:ss.SSS";
          }
        }
      }
      if ((str.length() == 0) || ("null".equals(str))) {
        return null;
      }
      l = Long.parseLong(str);
    }
    if (l < 0L) {
      throw new JSONException("can not cast to Date, value : " + paramObject);
    }
    return new Date(l);
  }
  
  public static final Double castToDouble(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Double.valueOf(((Number)paramObject).doubleValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      paramObject = paramObject.toString();
    } while ((paramObject.length() == 0) || ("null".equals(paramObject)));
    return Double.valueOf(Double.parseDouble(paramObject));
    throw new JSONException("can not cast to double, value : " + paramObject);
  }
  
  public static final <T> T castToEnum(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    try
    {
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        if (paramObject.length() == 0) {
          return null;
        }
        return Enum.valueOf(paramClass, paramObject);
      }
      if ((paramObject instanceof Number))
      {
        int i = ((Number)paramObject).intValue();
        paramObject = paramClass.getEnumConstants();
        if (i < paramObject.length)
        {
          paramObject = paramObject[i];
          return paramObject;
        }
      }
    }
    catch (Exception paramObject)
    {
      throw new JSONException("can not cast to : " + paramClass.getName(), paramObject);
    }
    throw new JSONException("can not cast to : " + paramClass.getName());
  }
  
  public static final Float castToFloat(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Float.valueOf(((Number)paramObject).floatValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      paramObject = paramObject.toString();
    } while ((paramObject.length() == 0) || ("null".equals(paramObject)));
    return Float.valueOf(Float.parseFloat(paramObject));
    throw new JSONException("can not cast to float, value : " + paramObject);
  }
  
  public static final Integer castToInt(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Integer.valueOf(((Number)paramObject).intValue());
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ((paramObject.length() == 0) || ("null".equals(paramObject))) {
        return null;
      }
      return Integer.valueOf(Integer.parseInt(paramObject));
    }
    throw new JSONException("can not cast to int, value : " + paramObject);
  }
  
  public static final <T> T castToJavaBean(Object paramObject, Class<T> paramClass)
  {
    return cast(paramObject, paramClass, ParserConfig.global);
  }
  
  public static final <T> T castToJavaBean(Map<String, Object> paramMap, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    int i = 0;
    if (paramClass == StackTraceElement.class) {}
    Class localClass;
    try
    {
      paramClass = (String)paramMap.get("className");
      paramParserConfig = (String)paramMap.get("methodName");
      localObject = (String)paramMap.get("fileName");
      paramMap = (Number)paramMap.get("lineNumber");
      if (paramMap == null) {}
      for (;;)
      {
        return new StackTraceElement(paramClass, paramParserConfig, (String)localObject, i);
        i = paramMap.intValue();
      }
      localObject = paramMap.get("@type");
      if (!(localObject instanceof String)) {
        break label185;
      }
      localObject = (String)localObject;
      localClass = loadClass((String)localObject, null);
      if (localClass == null) {
        throw new ClassNotFoundException((String)localObject + " not found");
      }
    }
    catch (Exception paramMap)
    {
      throw new JSONException(paramMap.getMessage(), paramMap);
    }
    if (!localClass.equals(paramClass)) {
      return castToJavaBean(paramMap, localClass, paramParserConfig);
    }
    label185:
    if (paramClass.isInterface())
    {
      if ((paramMap instanceof JSONObject)) {}
      for (paramMap = (JSONObject)paramMap;; paramMap = new JSONObject(paramMap)) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { paramClass }, paramMap);
      }
    }
    Object localObject = paramParserConfig;
    if (paramParserConfig == null) {
      localObject = ParserConfig.global;
    }
    paramClass = ((ParserConfig)localObject).getDeserializer(paramClass);
    if ((paramClass instanceof JavaBeanDeserializer)) {}
    for (paramClass = (JavaBeanDeserializer)paramClass;; paramClass = null)
    {
      if (paramClass == null) {
        throw new JSONException("can not get javaBeanDeserializer");
      }
      paramMap = paramClass.createInstance(paramMap, (ParserConfig)localObject);
      return paramMap;
    }
  }
  
  public static final Long castToLong(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Long.valueOf(((Number)paramObject).longValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      localObject = (String)paramObject;
    } while ((((String)localObject).length() == 0) || ("null".equals(localObject)));
    JSONLexer localJSONLexer;
    try
    {
      long l = Long.parseLong((String)localObject);
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localJSONLexer = new JSONLexer((String)localObject);
      if (!localJSONLexer.scanISO8601DateIfMatch(false)) {}
    }
    for (Object localObject = localJSONLexer.calendar;; localObject = null)
    {
      localJSONLexer.close();
      if (localObject != null) {
        return Long.valueOf(((Calendar)localObject).getTimeInMillis());
      }
      throw new JSONException("can not cast to long, value : " + paramObject);
    }
  }
  
  public static final Short castToShort(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Short.valueOf(((Number)paramObject).shortValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      paramObject = (String)paramObject;
    } while ((paramObject.length() == 0) || ("null".equals(paramObject)));
    return Short.valueOf(Short.parseShort(paramObject));
    throw new JSONException("can not cast to short, value : " + paramObject);
  }
  
  public static final String castToString(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return paramObject.toString();
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, int paramInt, boolean paramBoolean1, JSONType paramJSONType, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int k;
    int m;
    label339:
    Object localObject5;
    label411:
    Object localObject3;
    label1167:
    if (!paramBoolean1)
    {
      Method[] arrayOfMethod = paramClass.getMethods();
      int i1 = arrayOfMethod.length;
      int n = 0;
      label657:
      label1169:
      if (n < i1)
      {
        Method localMethod = arrayOfMethod[n];
        Object localObject6 = localMethod.getName();
        i = 0;
        j = 0;
        if (((localMethod.getModifiers() & 0x8) != 0) || (localMethod.getReturnType().equals(Void.TYPE)) || (localMethod.getParameterTypes().length != 0) || (localMethod.getReturnType() == ClassLoader.class) || (localMethod.getDeclaringClass() == Object.class) || ((((String)localObject6).equals("getMetaClass")) && (localMethod.getReturnType().getName().equals("groovy.lang.MetaClass")))) {}
        label469:
        label611:
        do
        {
          Field localField;
          do
          {
            do
            {
              do
              {
                do
                {
                  n += 1;
                  break;
                  if (paramBoolean3) {}
                  for (localObject1 = (JSONField)localMethod.getAnnotation(JSONField.class);; localObject1 = null)
                  {
                    localObject4 = localObject1;
                    if (localObject1 == null)
                    {
                      localObject4 = localObject1;
                      if (paramBoolean3) {
                        localObject4 = getSupperMethodAnnotation(paramClass, localMethod);
                      }
                    }
                    if (localObject4 == null) {
                      break label339;
                    }
                    if (!((JSONField)localObject4).serialize()) {
                      break;
                    }
                    k = ((JSONField)localObject4).ordinal();
                    m = SerializerFeature.of(((JSONField)localObject4).serialzeFeatures());
                    i = k;
                    j = m;
                    if (((JSONField)localObject4).name().length() == 0) {
                      break label339;
                    }
                    localObject2 = ((JSONField)localObject4).name();
                    localObject1 = localObject2;
                    if (paramMap != null)
                    {
                      localObject1 = (String)paramMap.get(localObject2);
                      if (localObject1 == null) {
                        break;
                      }
                    }
                    setAccessible(paramClass, localMethod, paramInt);
                    localLinkedHashMap.put(localObject1, new FieldInfo((String)localObject1, localMethod, null, paramClass, null, k, m, (JSONField)localObject4, null, true));
                    break;
                  }
                  k = i;
                  m = j;
                  if (!((String)localObject6).startsWith("get")) {
                    break label700;
                  }
                } while ((((String)localObject6).length() < 4) || (((String)localObject6).equals("getClass")));
                c = ((String)localObject6).charAt(3);
                if (!Character.isUpperCase(c)) {
                  break label1098;
                }
                if (!compatibleWithJavaBean) {
                  break label1062;
                }
                localObject1 = decapitalize(((String)localObject6).substring(3));
                if (isJSONTypeIgnore(paramClass, paramJSONType, (String)localObject1)) {
                  break label1167;
                }
                localField = getField(paramClass, (String)localObject1, arrayOfField);
                localObject5 = null;
                localObject2 = localObject1;
                k = i;
                m = j;
                if (localField == null) {
                  break label611;
                }
                if (!paramBoolean3) {
                  break label1169;
                }
                localObject3 = (JSONField)localField.getAnnotation(JSONField.class);
                localObject2 = localObject1;
                k = i;
                m = j;
                localObject5 = localObject3;
                if (localObject3 == null) {
                  break label611;
                }
              } while (!((JSONField)localObject3).serialize());
              i = ((JSONField)localObject3).ordinal();
              j = SerializerFeature.of(((JSONField)localObject3).serialzeFeatures());
              localObject2 = localObject1;
              k = i;
              m = j;
              localObject5 = localObject3;
              if (((JSONField)localObject3).name().length() == 0) {
                break label611;
              }
              localObject1 = ((JSONField)localObject3).name();
              localObject2 = localObject1;
              k = i;
              m = j;
              localObject5 = localObject3;
              if (paramMap == null) {
                break label611;
              }
              localObject2 = (String)paramMap.get(localObject1);
            } while (localObject2 == null);
            localObject5 = localObject3;
            m = j;
            k = i;
            localObject1 = localObject2;
            if (paramPropertyNamingStrategy != null) {
              localObject1 = paramPropertyNamingStrategy.translate((String)localObject2);
            }
            localObject2 = localObject1;
            if (paramMap == null) {
              break label657;
            }
            localObject2 = (String)paramMap.get(localObject1);
          } while (localObject2 == null);
          setAccessible(paramClass, localMethod, paramInt);
          localLinkedHashMap.put(localObject2, new FieldInfo((String)localObject2, localMethod, localField, paramClass, null, k, m, (JSONField)localObject4, (JSONField)localObject5, paramBoolean4));
        } while ((!((String)localObject6).startsWith("is")) || (((String)localObject6).length() < 3));
        label700:
        char c = ((String)localObject6).charAt(2);
        if (Character.isUpperCase(c)) {
          if (compatibleWithJavaBean)
          {
            localObject1 = decapitalize(((String)localObject6).substring(2));
            label753:
            localObject2 = getField(paramClass, (String)localObject1, arrayOfField);
            localObject5 = localObject2;
            if (localObject2 == null) {
              localObject5 = getField(paramClass, (String)localObject6, arrayOfField);
            }
            localObject6 = null;
            localObject2 = localObject1;
            i = k;
            j = m;
            if (localObject5 != null) {
              if (!paramBoolean3) {
                break label1247;
              }
            }
          }
        }
        label1062:
        label1098:
        label1247:
        for (localObject3 = (JSONField)((Field)localObject5).getAnnotation(JSONField.class);; localObject3 = null)
        {
          localObject2 = localObject1;
          i = k;
          j = m;
          localObject6 = localObject3;
          if (localObject3 != null)
          {
            if (!((JSONField)localObject3).serialize()) {
              break;
            }
            k = ((JSONField)localObject3).ordinal();
            m = SerializerFeature.of(((JSONField)localObject3).serialzeFeatures());
            localObject2 = localObject1;
            i = k;
            j = m;
            localObject6 = localObject3;
            if (((JSONField)localObject3).name().length() != 0)
            {
              localObject1 = ((JSONField)localObject3).name();
              localObject2 = localObject1;
              i = k;
              j = m;
              localObject6 = localObject3;
              if (paramMap != null)
              {
                localObject2 = (String)paramMap.get(localObject1);
                if (localObject2 == null) {
                  break;
                }
                localObject6 = localObject3;
                j = m;
                i = k;
              }
            }
          }
          localObject1 = localObject2;
          if (paramPropertyNamingStrategy != null) {
            localObject1 = paramPropertyNamingStrategy.translate((String)localObject2);
          }
          localObject2 = localObject1;
          if (paramMap != null)
          {
            localObject2 = (String)paramMap.get(localObject1);
            if (localObject2 == null) {
              break;
            }
          }
          setAccessible(paramClass, (Member)localObject5, paramInt);
          setAccessible(paramClass, localMethod, paramInt);
          localLinkedHashMap.put(localObject2, new FieldInfo((String)localObject2, localMethod, (Field)localObject5, paramClass, null, i, j, (JSONField)localObject4, (JSONField)localObject6, paramBoolean4));
          break;
          localObject1 = Character.toLowerCase(((String)localObject6).charAt(3)) + ((String)localObject6).substring(4);
          break label411;
          if (c == '_')
          {
            localObject1 = ((String)localObject6).substring(4);
            break label411;
          }
          if (c == 'f')
          {
            localObject1 = ((String)localObject6).substring(3);
            break label411;
          }
          if ((((String)localObject6).length() < 5) || (!Character.isUpperCase(((String)localObject6).charAt(4)))) {
            break;
          }
          localObject1 = decapitalize(((String)localObject6).substring(3));
          break label411;
          break;
          localObject3 = null;
          break label469;
          localObject1 = Character.toLowerCase(((String)localObject6).charAt(2)) + ((String)localObject6).substring(3);
          break label753;
          if (c == '_')
          {
            localObject1 = ((String)localObject6).substring(3);
            break label753;
          }
          if (c != 'f') {
            break;
          }
          localObject1 = ((String)localObject6).substring(2);
          break label753;
        }
      }
    }
    Object localObject2 = new ArrayList(arrayOfField.length);
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      localObject1 = arrayOfField[i];
      if ((((Field)localObject1).getModifiers() & 0x8) != 0) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!((Field)localObject1).getName().equals("this$0")) && ((((Field)localObject1).getModifiers() & 0x1) != 0)) {
          ((List)localObject2).add(localObject1);
        }
      }
    }
    for (Object localObject1 = paramClass.getSuperclass(); (localObject1 != null) && (localObject1 != Object.class); localObject1 = ((Class)localObject1).getSuperclass())
    {
      localObject3 = ((Class)localObject1).getDeclaredFields();
      j = localObject3.length;
      i = 0;
      if (i < j)
      {
        localObject4 = localObject3[i];
        if ((((Field)localObject4).getModifiers() & 0x8) != 0) {}
        for (;;)
        {
          i += 1;
          break;
          if ((((Field)localObject4).getModifiers() & 0x1) != 0) {
            ((List)localObject2).add(localObject4);
          }
        }
      }
    }
    Object localObject4 = ((List)localObject2).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Field)((Iterator)localObject4).next();
      if (paramBoolean3) {}
      for (localObject3 = (JSONField)((Field)localObject5).getAnnotation(JSONField.class);; localObject3 = null)
      {
        i = 0;
        j = 0;
        localObject2 = ((Field)localObject5).getName();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          if (!((JSONField)localObject3).serialize()) {
            break;
          }
          k = ((JSONField)localObject3).ordinal();
          m = SerializerFeature.of(((JSONField)localObject3).serialzeFeatures());
          localObject1 = localObject2;
          i = k;
          j = m;
          if (((JSONField)localObject3).name().length() != 0)
          {
            localObject1 = ((JSONField)localObject3).name();
            j = m;
            i = k;
          }
        }
        localObject2 = localObject1;
        if (paramMap != null)
        {
          localObject2 = (String)paramMap.get(localObject1);
          if (localObject2 == null) {
            break;
          }
        }
        localObject1 = localObject2;
        if (paramPropertyNamingStrategy != null) {
          localObject1 = paramPropertyNamingStrategy.translate((String)localObject2);
        }
        if (localLinkedHashMap.containsKey(localObject1)) {
          break;
        }
        setAccessible(paramClass, (Member)localObject5, paramInt);
        localLinkedHashMap.put(localObject1, new FieldInfo((String)localObject1, null, (Field)localObject5, paramClass, null, i, j, null, (JSONField)localObject3, paramBoolean4));
        break;
      }
    }
    paramMap = new ArrayList();
    if (paramJSONType != null)
    {
      paramClass = paramJSONType.orders();
      if ((paramClass != null) && (paramClass.length == localLinkedHashMap.size()))
      {
        j = 1;
        k = paramClass.length;
        i = 0;
        paramInt = j;
        if (i < k)
        {
          if (localLinkedHashMap.containsKey(paramClass[i])) {
            break label1812;
          }
          paramInt = 0;
        }
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        i = paramClass.length;
        paramInt = 0;
        while (paramInt < i)
        {
          paramMap.add((FieldInfo)localLinkedHashMap.get(paramClass[paramInt]));
          paramInt += 1;
        }
        label1812:
        i += 1;
        break;
        paramInt = 0;
        continue;
      }
      paramClass = localLinkedHashMap.values().iterator();
      while (paramClass.hasNext()) {
        paramMap.add((FieldInfo)paramClass.next());
      }
      if (paramBoolean2) {
        Collections.sort(paramMap);
      }
      return paramMap;
      paramClass = null;
      paramInt = 0;
    }
  }
  
  public static String decapitalize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || ((paramString.length() > 1) && (Character.isUpperCase(paramString.charAt(1))) && (Character.isUpperCase(paramString.charAt(0))))) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    paramString[0] = Character.toLowerCase(paramString[0]);
    return new String(paramString);
  }
  
  public static Class<?> getClass(Type paramType)
  {
    if (paramType.getClass() == Class.class) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType)) {
      return getClass(((ParameterizedType)paramType).getRawType());
    }
    if ((paramType instanceof TypeVariable)) {
      return (Class)((TypeVariable)paramType).getBounds()[0];
    }
    return Object.class;
  }
  
  public static Field getField(Class<?> paramClass, String paramString, Field[] paramArrayOfField)
  {
    Object localObject2 = getField0(paramClass, paramString, paramArrayOfField);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getField0(paramClass, "_" + paramString, paramArrayOfField);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getField0(paramClass, "m_" + paramString, paramArrayOfField);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getField0(paramClass, "m" + paramString.substring(0, 1).toUpperCase() + paramString.substring(1), paramArrayOfField);
    }
    return localObject1;
  }
  
  private static Field getField0(Class<?> paramClass, String paramString, Field[] paramArrayOfField)
  {
    int j = paramArrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = paramArrayOfField[i];
      if (paramString.equals(localField.getName())) {
        return localField;
      }
      i += 1;
    }
    paramClass = paramClass.getSuperclass();
    if ((paramClass != null) && (paramClass != Object.class)) {
      return getField(paramClass, paramString, paramClass.getDeclaredFields());
    }
    return null;
  }
  
  public static Type getGenericParamType(Type paramType)
  {
    Type localType = paramType;
    if ((paramType instanceof Class)) {
      localType = getGenericParamType(((Class)paramType).getGenericSuperclass());
    }
    return localType;
  }
  
  public static JSONField getSupperMethodAnnotation(Class<?> paramClass, Method paramMethod)
  {
    Object localObject1 = paramClass.getInterfaces();
    int m = localObject1.length;
    int i = 0;
    Object localObject2;
    int j;
    label35:
    Object localObject3;
    if (i < m)
    {
      localObject2 = localObject1[i].getMethods();
      int n = localObject2.length;
      j = 0;
      if (j < n)
      {
        localObject3 = localObject2[j];
        if (((Method)localObject3).getName().equals(paramMethod.getName())) {}
      }
    }
    label62:
    label321:
    for (;;)
    {
      j += 1;
      break label35;
      Class[] arrayOfClass1 = ((Method)localObject3).getParameterTypes();
      Class[] arrayOfClass2 = paramMethod.getParameterTypes();
      if (arrayOfClass1.length == arrayOfClass2.length)
      {
        int k = 0;
        label94:
        if (k < arrayOfClass1.length) {
          if (arrayOfClass1[k].equals(arrayOfClass2[k])) {}
        }
        for (k = 0;; k = 1)
        {
          if (k == 0) {
            break label321;
          }
          localObject3 = (JSONField)((Method)localObject3).getAnnotation(JSONField.class);
          if (localObject3 == null) {
            break label62;
          }
          return localObject3;
          k += 1;
          break label94;
          i += 1;
          break;
          localObject1 = paramClass.getSuperclass();
          if (localObject1 == null) {
            return null;
          }
          if (Modifier.isAbstract(((Class)localObject1).getModifiers()))
          {
            paramClass = paramMethod.getParameterTypes();
            localObject1 = ((Class)localObject1).getMethods();
            k = localObject1.length;
            i = 0;
            if (i < k)
            {
              localObject2 = localObject1[i];
              localObject3 = ((Method)localObject2).getParameterTypes();
              if (localObject3.length == paramClass.length) {}
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if (((Method)localObject2).getName().equals(paramMethod.getName()))
            {
              j = 0;
              if (j < paramClass.length) {
                if (localObject3[j].equals(paramClass[j])) {}
              }
              for (j = 0;; j = 1)
              {
                if (j == 0) {
                  break label315;
                }
                localObject2 = (JSONField)((Method)localObject2).getAnnotation(JSONField.class);
                if (localObject2 == null) {
                  break;
                }
                return localObject2;
                j += 1;
                break label257;
                return null;
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean isGenericParamType(Type paramType)
  {
    if ((paramType instanceof ParameterizedType)) {}
    do
    {
      return true;
      if (!(paramType instanceof Class)) {
        break;
      }
      paramType = ((Class)paramType).getGenericSuperclass();
    } while ((paramType != Object.class) && (isGenericParamType(paramType)));
    return false;
    return false;
  }
  
  private static boolean isJSONTypeIgnore(Class<?> paramClass, JSONType paramJSONType, String paramString)
  {
    if ((paramJSONType != null) && (paramJSONType.ignores() != null))
    {
      paramJSONType = paramJSONType.ignores();
      int j = paramJSONType.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equalsIgnoreCase(paramJSONType[i])) {
          return true;
        }
        i += 1;
      }
    }
    paramClass = paramClass.getSuperclass();
    if ((paramClass != Object.class) && (paramClass != null) && (isJSONTypeIgnore(paramClass, (JSONType)paramClass.getAnnotation(JSONType.class), paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static Class<?> loadClass(String paramString, ClassLoader paramClassLoader)
  {
    Object localObject2;
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject2 = null;
    }
    do
    {
      return localObject2;
      localObject1 = (Class)mappings.get(paramString);
      localObject2 = localObject1;
    } while (localObject1 != null);
    if (paramString.charAt(0) == '[') {
      return Array.newInstance(loadClass(paramString.substring(1), paramClassLoader), 0).getClass();
    }
    if ((paramString.startsWith("L")) && (paramString.endsWith(";"))) {
      return loadClass(paramString.substring(1, paramString.length() - 1), paramClassLoader);
    }
    if (paramClassLoader != null) {
      try
      {
        paramClassLoader = paramClassLoader.loadClass(paramString);
        localObject1 = paramClassLoader;
        mappings.put(paramString, paramClassLoader);
        return paramClassLoader;
      }
      catch (Exception localException2)
      {
        paramClassLoader = (ClassLoader)localObject1;
        localException2.printStackTrace();
      }
    }
    for (;;)
    {
      try
      {
        ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
        localObject1 = paramClassLoader;
        if (localClassLoader == null) {
          continue;
        }
        localObject1 = localClassLoader.loadClass(paramString);
        try
        {
          mappings.put(paramString, localObject1);
          return localObject1;
        }
        catch (Exception localException3)
        {
          paramClassLoader = (ClassLoader)localObject1;
          localObject1 = localException3;
        }
      }
      catch (Exception localException1)
      {
        continue;
      }
      ((Exception)localObject1).printStackTrace();
      localObject1 = paramClassLoader;
      try
      {
        paramClassLoader = Class.forName(paramString);
        try
        {
          mappings.put(paramString, paramClassLoader);
          return paramClassLoader;
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString)
      {
        paramClassLoader = (ClassLoader)localObject1;
        continue;
      }
      paramString.printStackTrace();
      return paramClassLoader;
      paramClassLoader = (ClassLoader)localObject1;
    }
  }
  
  public static boolean setAccessible(Class<?> paramClass, Member paramMember, int paramInt)
  {
    if ((paramMember == null) || (!setAccessibleEnable)) {}
    do
    {
      return false;
      paramClass = paramClass.getSuperclass();
    } while (((paramClass == null) || (paramClass == Object.class)) && ((paramMember.getModifiers() & 0x1) != 0) && ((paramInt & 0x1) != 0));
    paramClass = (AccessibleObject)paramMember;
    try
    {
      paramClass.setAccessible(true);
      return true;
    }
    catch (AccessControlException paramClass)
    {
      setAccessibleEnable = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.util.TypeUtils
 * JD-Core Version:    0.7.0.1
 */