package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class JSONSerializer
{
  protected List<AfterFilter> afterFilters = null;
  protected List<BeforeFilter> beforeFilters = null;
  public final SerializeConfig config;
  protected SerialContext context;
  private DateFormat dateFormat;
  private String dateFormatPattern;
  private int indentCount = 0;
  public Locale locale = JSON.defaultLocale;
  protected List<NameFilter> nameFilters = null;
  public final SerializeWriter out;
  protected List<PropertyFilter> propertyFilters = null;
  protected List<PropertyPreFilter> propertyPreFilters = null;
  protected IdentityHashMap<Object, SerialContext> references = null;
  public TimeZone timeZone = JSON.defaultTimeZone;
  protected List<ValueFilter> valueFilters = null;
  
  public JSONSerializer()
  {
    this(new SerializeWriter((Writer)null, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY), SerializeConfig.globalInstance);
  }
  
  public JSONSerializer(SerializeConfig paramSerializeConfig)
  {
    this(new SerializeWriter((Writer)null, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY), paramSerializeConfig);
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter)
  {
    this(paramSerializeWriter, SerializeConfig.globalInstance);
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter, SerializeConfig paramSerializeConfig)
  {
    this.out = paramSerializeWriter;
    this.config = paramSerializeConfig;
    this.timeZone = JSON.defaultTimeZone;
  }
  
  public static Object processValue(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    List localList = paramJSONSerializer.valueFilters;
    Object localObject = paramObject3;
    if (localList != null) {
      if ((paramObject2 == null) || ((paramObject2 instanceof String))) {
        break label77;
      }
    }
    label77:
    for (paramJSONSerializer = JSON.toJSONString(paramObject2);; paramJSONSerializer = paramObject2)
    {
      paramObject2 = localList.iterator();
      for (;;)
      {
        localObject = paramObject3;
        if (!paramObject2.hasNext()) {
          break;
        }
        paramObject3 = ((ValueFilter)paramObject2.next()).process(paramObject1, (String)paramJSONSerializer, paramObject3);
      }
      return localObject;
    }
  }
  
  public static final void write(SerializeWriter paramSerializeWriter, Object paramObject)
  {
    new JSONSerializer(paramSerializeWriter, SerializeConfig.globalInstance).write(paramObject);
  }
  
  public static final void write(Writer paramWriter, Object paramObject)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter((Writer)null, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    try
    {
      new JSONSerializer(localSerializeWriter, SerializeConfig.globalInstance).write(paramObject);
      localSerializeWriter.writeTo(paramWriter);
      return;
    }
    catch (IOException paramWriter)
    {
      throw new JSONException(paramWriter.getMessage(), paramWriter);
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public boolean apply(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject = this.propertyFilters;
    if (localObject == null) {
      return true;
    }
    if ((paramObject2 != null) && (!(paramObject2 instanceof String))) {
      paramObject2 = JSON.toJSONString(paramObject2);
    }
    for (;;)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((PropertyFilter)((Iterator)localObject).next()).apply(paramObject1, (String)paramObject2, paramObject3)) {
          return false;
        }
      }
      return true;
    }
  }
  
  public boolean applyName(Object paramObject1, Object paramObject2)
  {
    Object localObject = this.propertyPreFilters;
    if (localObject == null) {
      return true;
    }
    localObject = ((List)localObject).iterator();
    PropertyPreFilter localPropertyPreFilter;
    if (((Iterator)localObject).hasNext())
    {
      localPropertyPreFilter = (PropertyPreFilter)((Iterator)localObject).next();
      if ((paramObject2 == null) || ((paramObject2 instanceof String))) {
        break label77;
      }
      paramObject2 = JSON.toJSONString(paramObject2);
    }
    label77:
    for (;;)
    {
      if (!localPropertyPreFilter.apply(this, paramObject1, (String)paramObject2)) {
        return false;
      }
      break;
      return true;
    }
  }
  
  public void close()
  {
    this.out.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    this.out.config(paramSerializerFeature, paramBoolean);
  }
  
  public void decrementIdent()
  {
    this.indentCount -= 1;
  }
  
  public List<AfterFilter> getAfterFilters()
  {
    if (this.afterFilters == null) {
      this.afterFilters = new ArrayList();
    }
    return this.afterFilters;
  }
  
  public List<BeforeFilter> getBeforeFilters()
  {
    if (this.beforeFilters == null) {
      this.beforeFilters = new ArrayList();
    }
    return this.beforeFilters;
  }
  
  public SerialContext getContext()
  {
    return this.context;
  }
  
  public DateFormat getDateFormat()
  {
    if ((this.dateFormat == null) && (this.dateFormatPattern != null))
    {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.locale);
      this.dateFormat.setTimeZone(this.timeZone);
    }
    return this.dateFormat;
  }
  
  public String getDateFormatPattern()
  {
    if ((this.dateFormat instanceof SimpleDateFormat)) {
      return ((SimpleDateFormat)this.dateFormat).toPattern();
    }
    return this.dateFormatPattern;
  }
  
  public List<NameFilter> getNameFilters()
  {
    if (this.nameFilters == null) {
      this.nameFilters = new ArrayList();
    }
    return this.nameFilters;
  }
  
  public List<PropertyFilter> getPropertyFilters()
  {
    if (this.propertyFilters == null) {
      this.propertyFilters = new ArrayList();
    }
    return this.propertyFilters;
  }
  
  public List<PropertyPreFilter> getPropertyPreFilters()
  {
    if (this.propertyPreFilters == null) {
      this.propertyPreFilters = new ArrayList();
    }
    return this.propertyPreFilters;
  }
  
  public List<ValueFilter> getValueFilters()
  {
    if (this.valueFilters == null) {
      this.valueFilters = new ArrayList();
    }
    return this.valueFilters;
  }
  
  public SerializeWriter getWriter()
  {
    return this.out;
  }
  
  public void incrementIndent()
  {
    this.indentCount += 1;
  }
  
  public void println()
  {
    this.out.write(10);
    int i = 0;
    while (i < this.indentCount)
    {
      this.out.write(9);
      i += 1;
    }
  }
  
  public Object processKey(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject2 = this.nameFilters;
    if (localObject2 != null)
    {
      localObject1 = paramObject2;
      if (paramObject2 != null)
      {
        localObject1 = paramObject2;
        if (!(paramObject2 instanceof String)) {
          localObject1 = JSON.toJSONString(paramObject2);
        }
      }
      localObject2 = ((List)localObject2).iterator();
      for (paramObject2 = localObject1;; paramObject2 = ((NameFilter)((Iterator)localObject2).next()).process(paramObject1, (String)paramObject2, paramObject3))
      {
        localObject1 = paramObject2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      }
    }
    Object localObject1 = paramObject2;
    return localObject1;
  }
  
  public void setContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt)
  {
    if ((this.out.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0)
    {
      this.context = new SerialContext(paramSerialContext, paramObject1, paramObject2, paramInt);
      if (this.references == null) {
        this.references = new IdentityHashMap();
      }
      this.references.put(paramObject1, this.context);
    }
  }
  
  public void setDateFormat(String paramString)
  {
    this.dateFormatPattern = paramString;
    if (this.dateFormat != null) {
      this.dateFormat = null;
    }
  }
  
  public void setDateFormat(DateFormat paramDateFormat)
  {
    this.dateFormat = paramDateFormat;
    if (this.dateFormatPattern != null) {
      this.dateFormatPattern = null;
    }
  }
  
  public String toString()
  {
    return this.out.toString();
  }
  
  public final void write(Object paramObject)
  {
    if (paramObject == null)
    {
      this.out.writeNull();
      return;
    }
    Object localObject = paramObject.getClass();
    localObject = this.config.get((Class)localObject);
    try
    {
      ((ObjectSerializer)localObject).write(this, paramObject, null, null);
      return;
    }
    catch (IOException paramObject)
    {
      throw new JSONException(paramObject.getMessage(), paramObject);
    }
  }
  
  public final void write(String paramString)
  {
    if (paramString == null)
    {
      if ((this.out.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0)
      {
        this.out.writeString("");
        return;
      }
      this.out.writeNull();
      return;
    }
    if ((this.out.features & SerializerFeature.UseSingleQuotes.mask) != 0)
    {
      this.out.writeStringWithSingleQuote(paramString);
      return;
    }
    this.out.writeStringWithDoubleQuote(paramString, '\000', true);
  }
  
  protected final void writeKeyValue(char paramChar, String paramString, Object paramObject)
  {
    if (paramChar != 0) {
      this.out.write(paramChar);
    }
    this.out.writeFieldName(paramString, true);
    write(paramObject);
  }
  
  public void writeReference(Object paramObject)
  {
    SerialContext localSerialContext2 = this.context;
    if (paramObject == localSerialContext2.object)
    {
      this.out.write("{\"$ref\":\"@\"}");
      return;
    }
    SerialContext localSerialContext3 = localSerialContext2.parent;
    SerialContext localSerialContext1 = localSerialContext2;
    if (localSerialContext3 != null)
    {
      localSerialContext1 = localSerialContext2;
      if (paramObject == localSerialContext3.object)
      {
        this.out.write("{\"$ref\":\"..\"}");
        return;
      }
    }
    while (localSerialContext1.parent != null) {
      localSerialContext1 = localSerialContext1.parent;
    }
    if (paramObject == localSerialContext1.object)
    {
      this.out.write("{\"$ref\":\"$\"}");
      return;
    }
    paramObject = ((SerialContext)this.references.get(paramObject)).toString();
    this.out.write("{\"$ref\":\"");
    this.out.write(paramObject);
    this.out.write("\"}");
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2)
  {
    writeWithFieldName(paramObject1, paramObject2, null, 0);
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2, Type paramType, int paramInt)
  {
    if (paramObject1 == null) {}
    try
    {
      this.out.writeNull();
      return;
    }
    catch (IOException paramObject1)
    {
      Class localClass;
      throw new JSONException(paramObject1.getMessage(), paramObject1);
    }
    localClass = paramObject1.getClass();
    this.config.get(localClass).write(this, paramObject1, paramObject2, paramType);
  }
  
  public final void writeWithFormat(Object paramObject, String paramString)
  {
    if ((paramObject instanceof Date))
    {
      DateFormat localDateFormat = getDateFormat();
      Object localObject = localDateFormat;
      if (localDateFormat == null)
      {
        localObject = new SimpleDateFormat(paramString, this.locale);
        ((DateFormat)localObject).setTimeZone(this.timeZone);
      }
      paramObject = ((DateFormat)localObject).format((Date)paramObject);
      this.out.writeString(paramObject);
      return;
    }
    write(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.JSONSerializer
 * JD-Core Version:    0.7.0.1
 */