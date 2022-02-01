package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public abstract class JSON
  implements JSONAware, JSONStreamAware
{
  public static int DEFAULT_GENERATE_FEATURE = SerializerFeature.QuoteFieldNames.mask | 0x0 | SerializerFeature.SkipTransientField.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.SortField.mask;
  public static int DEFAULT_PARSER_FEATURE = 0;
  public static final String DEFAULT_TYPE_KEY = "@type";
  public static String DEFFAULT_DATE_FORMAT;
  public static final String VERSION = "1.1.56";
  public static Locale defaultLocale;
  public static TimeZone defaultTimeZone = ;
  
  static
  {
    defaultLocale = Locale.getDefault();
    DEFAULT_PARSER_FEATURE = Feature.UseBigDecimal.mask | 0x0 | Feature.SortFeidFastMatch.mask | Feature.IgnoreNotMatch.mask;
    DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  }
  
  public static final Object parse(String paramString)
  {
    return parse(paramString, DEFAULT_PARSER_FEATURE);
  }
  
  public static final Object parse(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new DefaultJSONParser(paramString, ParserConfig.global, paramInt);
    Object localObject = paramString.parse(null);
    paramString.handleResovleTask(localObject);
    paramString.close();
    return localObject;
  }
  
  public static final Object parse(String paramString, Feature... paramVarArgs)
  {
    int j = DEFAULT_PARSER_FEATURE;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j |= paramVarArgs[i].mask;
      i += 1;
    }
    return parse(paramString, j);
  }
  
  public static final Object parse(byte[] paramArrayOfByte, Feature... paramVarArgs)
  {
    try
    {
      paramArrayOfByte = parseObject(new String(paramArrayOfByte, "UTF-8"), paramVarArgs);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new JSONException("UTF-8 not support", paramArrayOfByte);
    }
  }
  
  public static final JSONArray parseArray(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      return null;
    }
    DefaultJSONParser localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.global);
    paramString = localDefaultJSONParser.lexer;
    int i = paramString.token();
    if (i == 8)
    {
      paramString.nextToken();
      paramString = localObject;
    }
    for (;;)
    {
      localDefaultJSONParser.close();
      return paramString;
      paramString = localObject;
      if (i != 20)
      {
        paramString = new JSONArray();
        localDefaultJSONParser.parseArray(paramString);
        localDefaultJSONParser.handleResovleTask(paramString);
      }
    }
  }
  
  public static final <T> List<T> parseArray(String paramString, Class<T> paramClass)
  {
    Object localObject = null;
    if (paramString == null) {
      return null;
    }
    DefaultJSONParser localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.global);
    JSONLexer localJSONLexer = localDefaultJSONParser.lexer;
    int i = localJSONLexer.token();
    if (i == 8)
    {
      localJSONLexer.nextToken();
      paramString = localObject;
    }
    for (;;)
    {
      localDefaultJSONParser.close();
      return paramString;
      if (i == 20)
      {
        paramString = localObject;
        if (localJSONLexer.isBlankInput()) {}
      }
      else
      {
        paramString = new ArrayList();
        localDefaultJSONParser.parseArray(paramClass, paramString);
        localDefaultJSONParser.handleResovleTask(paramString);
      }
    }
  }
  
  public static final List<Object> parseArray(String paramString, Type[] paramArrayOfType)
  {
    Object localObject = null;
    if (paramString == null) {
      return null;
    }
    DefaultJSONParser localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.global);
    paramString = localDefaultJSONParser.parseArray(paramArrayOfType);
    if (paramString == null) {}
    for (paramString = localObject;; paramString = Arrays.asList(paramString))
    {
      localDefaultJSONParser.handleResovleTask(paramString);
      localDefaultJSONParser.close();
      return paramString;
    }
  }
  
  public static final JSONObject parseObject(String paramString)
  {
    paramString = parse(paramString);
    if ((paramString instanceof JSONObject)) {
      return (JSONObject)paramString;
    }
    return (JSONObject)toJSON(paramString);
  }
  
  public static final JSONObject parseObject(String paramString, Feature... paramVarArgs)
  {
    return (JSONObject)parse(paramString, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, TypeReference<T> paramTypeReference, Feature... paramVarArgs)
  {
    return parseObject(paramString, paramTypeReference.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Class<T> paramClass)
  {
    return parseObject(paramString, paramClass, new Feature[0]);
  }
  
  public static final <T> T parseObject(String paramString, Class<T> paramClass, ParseProcess paramParseProcess, Feature... paramVarArgs)
  {
    return parseObject(paramString, paramClass, ParserConfig.global, paramParseProcess, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Class<T> paramClass, Feature... paramVarArgs)
  {
    return parseObject(paramString, paramClass, ParserConfig.global, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, int paramInt, Feature... paramVarArgs)
  {
    if (paramString == null) {
      return null;
    }
    int k = paramVarArgs.length;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i |= paramVarArgs[paramInt].mask;
      paramInt += 1;
    }
    paramString = new DefaultJSONParser(paramString, ParserConfig.global, i);
    paramType = paramString.parseObject(paramType);
    paramString.handleResovleTask(paramType);
    paramString.close();
    return paramType;
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, int paramInt, Feature... paramVarArgs)
  {
    return parseObject(paramString, paramType, paramParserConfig, null, paramInt, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, ParseProcess paramParseProcess, int paramInt, Feature... paramVarArgs)
  {
    if (paramString == null) {
      return null;
    }
    int k = paramVarArgs.length;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i |= paramVarArgs[paramInt].mask;
      paramInt += 1;
    }
    paramString = new DefaultJSONParser(paramString, paramParserConfig, i);
    if ((paramParseProcess instanceof ExtraTypeProvider)) {
      paramString.getExtraTypeProviders().add((ExtraTypeProvider)paramParseProcess);
    }
    if ((paramParseProcess instanceof ExtraProcessor)) {
      paramString.getExtraProcessors().add((ExtraProcessor)paramParseProcess);
    }
    if ((paramParseProcess instanceof FieldTypeResolver)) {
      paramString.fieldTypeResolver = ((FieldTypeResolver)paramParseProcess);
    }
    paramType = paramString.parseObject(paramType);
    paramString.handleResovleTask(paramType);
    paramString.close();
    return paramType;
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, ParseProcess paramParseProcess, Feature... paramVarArgs)
  {
    return parseObject(paramString, paramType, ParserConfig.global, paramParseProcess, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, Feature... paramVarArgs)
  {
    return parseObject(paramString, paramType, ParserConfig.global, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(byte[] paramArrayOfByte, Type paramType, Feature... paramVarArgs)
  {
    try
    {
      paramArrayOfByte = parseObject(new String(paramArrayOfByte, "UTF-8"), paramType, paramVarArgs);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new JSONException("UTF-8 not support");
    }
  }
  
  public static final <T> T parseObject(char[] paramArrayOfChar, int paramInt, Type paramType, Feature... paramVarArgs)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
      return null;
    }
    int j = DEFAULT_PARSER_FEATURE;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j |= paramVarArgs[i].mask;
      i += 1;
    }
    paramArrayOfChar = new DefaultJSONParser(paramArrayOfChar, paramInt, ParserConfig.global, j);
    paramType = paramArrayOfChar.parseObject(paramType);
    paramArrayOfChar.handleResovleTask(paramType);
    paramArrayOfChar.close();
    return paramType;
  }
  
  public static final Object toJSON(Object paramObject)
  {
    return toJSON(paramObject, SerializeConfig.globalInstance);
  }
  
  @Deprecated
  public static final Object toJSON(Object paramObject, ParserConfig paramParserConfig)
  {
    return toJSON(paramObject, SerializeConfig.globalInstance);
  }
  
  public static Object toJSON(Object paramObject, SerializeConfig paramSerializeConfig)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    Class localClass;
    do
    {
      return localObject;
      if ((paramObject instanceof JSON)) {
        return (JSON)paramObject;
      }
      if ((paramObject instanceof Map))
      {
        paramSerializeConfig = (Map)paramObject;
        paramObject = new JSONObject(paramSerializeConfig.size());
        paramSerializeConfig = paramSerializeConfig.entrySet().iterator();
        while (paramSerializeConfig.hasNext())
        {
          localObject = (Map.Entry)paramSerializeConfig.next();
          paramObject.put(TypeUtils.castToString(((Map.Entry)localObject).getKey()), toJSON(((Map.Entry)localObject).getValue()));
        }
        return paramObject;
      }
      if ((paramObject instanceof Collection))
      {
        paramSerializeConfig = (Collection)paramObject;
        paramObject = new JSONArray(paramSerializeConfig.size());
        paramSerializeConfig = paramSerializeConfig.iterator();
        while (paramSerializeConfig.hasNext()) {
          paramObject.add(toJSON(paramSerializeConfig.next()));
        }
        return paramObject;
      }
      localClass = paramObject.getClass();
      if (localClass.isEnum()) {
        return ((Enum)paramObject).name();
      }
      if (localClass.isArray())
      {
        int j = Array.getLength(paramObject);
        paramSerializeConfig = new JSONArray(j);
        int i = 0;
        while (i < j)
        {
          paramSerializeConfig.add(toJSON(Array.get(paramObject, i)));
          i += 1;
        }
        return paramSerializeConfig;
      }
      localObject = paramObject;
    } while (ParserConfig.isPrimitive(localClass));
    paramSerializeConfig = paramSerializeConfig.get(localClass);
    if ((paramSerializeConfig instanceof JavaBeanSerializer))
    {
      localObject = (JavaBeanSerializer)paramSerializeConfig;
      paramSerializeConfig = new JSONObject();
      try
      {
        paramObject = ((JavaBeanSerializer)localObject).getFieldValuesMap(paramObject).entrySet().iterator();
        while (paramObject.hasNext())
        {
          localObject = (Map.Entry)paramObject.next();
          paramSerializeConfig.put((String)((Map.Entry)localObject).getKey(), toJSON(((Map.Entry)localObject).getValue()));
        }
        return paramSerializeConfig;
      }
      catch (Exception paramObject)
      {
        throw new JSONException("toJSON error", paramObject);
      }
    }
    return null;
  }
  
  public static final byte[] toJSONBytes(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs)
  {
    paramVarArgs = new SerializeWriter((Writer)null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
    try
    {
      new JSONSerializer(paramVarArgs, paramSerializeConfig).write(paramObject);
      paramObject = paramVarArgs.toBytes("UTF-8");
      return paramObject;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
  
  public static final byte[] toJSONBytes(Object paramObject, SerializerFeature... paramVarArgs)
  {
    paramVarArgs = new SerializeWriter((Writer)null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
    try
    {
      new JSONSerializer(paramVarArgs, SerializeConfig.globalInstance).write(paramObject);
      paramObject = paramVarArgs.toBytes("UTF-8");
      return paramObject;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
  
  public static final String toJSONString(Object paramObject)
  {
    return toJSONString(paramObject, SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, new SerializerFeature[0]);
  }
  
  public static final String toJSONString(Object paramObject, int paramInt, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, SerializeConfig.globalInstance, null, null, paramInt, paramVarArgs);
  }
  
  public static final String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter paramSerializeFilter, SerializerFeature... paramVarArgs)
  {
    int i = DEFAULT_GENERATE_FEATURE;
    return toJSONString(paramObject, paramSerializeConfig, new SerializeFilter[] { paramSerializeFilter }, null, i, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, String paramString, int paramInt, SerializerFeature... paramVarArgs)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter(null, paramInt, paramVarArgs);
    int i;
    try
    {
      paramSerializeConfig = new JSONSerializer(localSerializeWriter, paramSerializeConfig);
      i = paramVarArgs.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramSerializeConfig.config(paramVarArgs[paramInt], true);
        paramInt += 1;
      }
      if ((paramString != null) && (paramString.length() != 0))
      {
        paramSerializeConfig.setDateFormat(paramString);
        paramSerializeConfig.config(SerializerFeature.WriteDateUseDateFormat, true);
      }
      if (paramArrayOfSerializeFilter == null) {
        break label234;
      }
      i = paramArrayOfSerializeFilter.length;
      paramInt = 0;
    }
    finally
    {
      localSerializeWriter.close();
    }
    if ((paramString instanceof PropertyPreFilter)) {
      paramSerializeConfig.getPropertyPreFilters().add((PropertyPreFilter)paramString);
    }
    if ((paramString instanceof NameFilter)) {
      paramSerializeConfig.getNameFilters().add((NameFilter)paramString);
    }
    if ((paramString instanceof ValueFilter)) {
      paramSerializeConfig.getValueFilters().add((ValueFilter)paramString);
    }
    if ((paramString instanceof PropertyFilter)) {
      paramSerializeConfig.getPropertyFilters().add((PropertyFilter)paramString);
    }
    if ((paramString instanceof BeforeFilter)) {
      paramSerializeConfig.getBeforeFilters().add((BeforeFilter)paramString);
    }
    if ((paramString instanceof AfterFilter)) {
      paramSerializeConfig.getAfterFilters().add((AfterFilter)paramString);
    }
    label275:
    for (;;)
    {
      label234:
      paramSerializeConfig.write(paramObject);
      paramObject = localSerializeWriter.toString();
      localSerializeWriter.close();
      return paramObject;
      for (;;)
      {
        if (paramInt >= i) {
          break label275;
        }
        paramString = paramArrayOfSerializeFilter[paramInt];
        if (paramString != null) {
          break;
        }
        paramInt += 1;
      }
    }
  }
  
  public static final String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, paramSerializeConfig, paramArrayOfSerializeFilter, null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static final String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, paramSerializeConfig, null, null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static final String toJSONString(Object paramObject, SerializeFilter paramSerializeFilter, SerializerFeature... paramVarArgs)
  {
    SerializeConfig localSerializeConfig = SerializeConfig.globalInstance;
    int i = DEFAULT_GENERATE_FEATURE;
    return toJSONString(paramObject, localSerializeConfig, new SerializeFilter[] { paramSerializeFilter }, null, i, paramVarArgs);
  }
  
  public static final String toJSONString(Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return toJSONString(paramObject);
    }
    return toJSONString(paramObject, new SerializerFeature[] { SerializerFeature.PrettyFormat });
  }
  
  public static final String toJSONString(Object paramObject, SerializeFilter[] paramArrayOfSerializeFilter, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, SerializeConfig.globalInstance, paramArrayOfSerializeFilter, null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static final String toJSONString(Object paramObject, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static final String toJSONStringWithDateFormat(Object paramObject, String paramString, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, SerializeConfig.globalInstance, null, paramString, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static final String toJSONStringZ(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, SerializeConfig.globalInstance, null, null, 0, paramVarArgs);
  }
  
  public static final <T> T toJavaObject(JSON paramJSON, Class<T> paramClass)
  {
    return TypeUtils.cast(paramJSON, paramClass, ParserConfig.global);
  }
  
  public static final void writeJSONStringTo(Object paramObject, Writer paramWriter, SerializerFeature... paramVarArgs)
  {
    paramWriter = new SerializeWriter(paramWriter, DEFAULT_GENERATE_FEATURE, paramVarArgs);
    try
    {
      new JSONSerializer(paramWriter, SerializeConfig.globalInstance).write(paramObject);
      return;
    }
    finally
    {
      paramWriter.close();
    }
  }
  
  public String toJSONString()
  {
    SerializeWriter localSerializeWriter = new SerializeWriter((Writer)null, DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    try
    {
      new JSONSerializer(localSerializeWriter, SerializeConfig.globalInstance).write(this);
      String str = localSerializeWriter.toString();
      return str;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public <T> T toJavaObject(Class<T> paramClass)
  {
    return TypeUtils.cast(this, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public String toString()
  {
    return toJSONString();
  }
  
  public void writeJSONString(Appendable paramAppendable)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter((Writer)null, DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    try
    {
      new JSONSerializer(localSerializeWriter, SerializeConfig.globalInstance).write(this);
      paramAppendable.append(localSerializeWriter.toString());
      return;
    }
    catch (IOException paramAppendable)
    {
      throw new JSONException(paramAppendable.getMessage(), paramAppendable);
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.JSON
 * JD-Core Version:    0.7.0.1
 */