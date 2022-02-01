package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class DefaultFieldDeserializer
  extends FieldDeserializer
{
  protected ObjectDeserializer fieldValueDeserilizer;
  
  public DefaultFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo, 2);
  }
  
  public ObjectDeserializer getFieldValueDeserilizer(ParserConfig paramParserConfig)
  {
    if (this.fieldValueDeserilizer == null) {
      this.fieldValueDeserilizer = paramParserConfig.getDeserializer(this.fieldInfo.fieldClass, this.fieldInfo.fieldType);
    }
    return this.fieldValueDeserilizer;
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    if (this.fieldValueDeserilizer == null) {
      this.fieldValueDeserilizer = paramDefaultJSONParser.config.getDeserializer(this.fieldInfo.fieldClass, this.fieldInfo.fieldType);
    }
    if ((paramType instanceof ParameterizedType)) {
      paramDefaultJSONParser.contex.type = paramType;
    }
    paramType = this.fieldInfo.format;
    if ((paramType != null) && ((this.fieldValueDeserilizer instanceof DateCodec)))
    {
      paramType = ((DateCodec)this.fieldValueDeserilizer).deserialze(paramDefaultJSONParser, this.fieldInfo.fieldType, this.fieldInfo.name, paramType);
      if (paramDefaultJSONParser.resolveStatus != 1) {
        break label156;
      }
      paramObject = paramDefaultJSONParser.getLastResolveTask();
      paramObject.fieldDeserializer = this;
      paramObject.ownerContext = paramDefaultJSONParser.contex;
      paramDefaultJSONParser.resolveStatus = 0;
    }
    label156:
    do
    {
      return;
      paramType = this.fieldValueDeserilizer.deserialze(paramDefaultJSONParser, this.fieldInfo.fieldType, this.fieldInfo.name);
      break;
      if (paramObject == null)
      {
        paramMap.put(this.fieldInfo.name, paramType);
        return;
      }
      if (paramType != null) {
        break label217;
      }
      paramDefaultJSONParser = this.fieldInfo.fieldClass;
    } while ((paramDefaultJSONParser == Byte.TYPE) || (paramDefaultJSONParser == Short.TYPE) || (paramDefaultJSONParser == Float.TYPE) || (paramDefaultJSONParser == Double.TYPE));
    label217:
    setValue(paramObject, paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.DefaultFieldDeserializer
 * JD-Core Version:    0.7.0.1
 */