package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class ListTypeFieldDeserializer
  extends FieldDeserializer
{
  private final boolean array;
  private ObjectDeserializer deserializer;
  private final Type itemType;
  
  public ListTypeFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo, 14);
    paramParserConfig = paramFieldInfo.fieldType;
    paramClass = paramFieldInfo.fieldClass;
    if ((paramParserConfig instanceof ParameterizedType))
    {
      this.itemType = ((ParameterizedType)paramParserConfig).getActualTypeArguments()[0];
      this.array = false;
      return;
    }
    if (paramClass.isArray())
    {
      this.itemType = paramClass.getComponentType();
      this.array = true;
      return;
    }
    this.itemType = Object.class;
    this.array = false;
  }
  
  final void parseArray(DefaultJSONParser paramDefaultJSONParser, Type paramType, Collection paramCollection)
  {
    Object localObject4 = this.itemType;
    Object localObject3 = this.deserializer;
    Object localObject1 = localObject4;
    Object localObject2 = localObject3;
    Object localObject5;
    if ((paramType instanceof ParameterizedType))
    {
      if (!(localObject4 instanceof TypeVariable)) {
        break label262;
      }
      localObject5 = (TypeVariable)localObject4;
      localObject2 = (ParameterizedType)paramType;
      if (!(((ParameterizedType)localObject2).getRawType() instanceof Class)) {
        break label1136;
      }
    }
    label262:
    label960:
    label983:
    label998:
    label1136:
    for (localObject1 = (Class)((ParameterizedType)localObject2).getRawType();; localObject1 = null)
    {
      int i;
      int j;
      if (localObject1 != null)
      {
        i = 0;
        j = ((Class)localObject1).getTypeParameters().length;
        if (i < j) {
          if (!localObject1.getTypeParameters()[i].getName().equals(((TypeVariable)localObject5).getName())) {}
        }
      }
      for (;;)
      {
        localObject1 = localObject4;
        if (i != -1)
        {
          localObject2 = localObject2.getActualTypeArguments()[i];
          localObject1 = localObject2;
          if (!localObject2.equals(this.itemType))
          {
            localObject3 = paramDefaultJSONParser.config.getDeserializer((Type)localObject2);
            localObject1 = localObject2;
            localObject2 = localObject3;
          }
        }
        for (;;)
        {
          localObject4 = paramDefaultJSONParser.lexer;
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            localObject3 = paramDefaultJSONParser.config.getDeserializer((Type)localObject1);
            this.deserializer = ((ObjectDeserializer)localObject3);
          }
          Type[] arrayOfType;
          ParameterizedType localParameterizedType;
          if (((JSONLexer)localObject4).token != 14) {
            if (((JSONLexer)localObject4).token == 12)
            {
              paramCollection.add(((ObjectDeserializer)localObject3).deserialze(paramDefaultJSONParser, (Type)localObject1, Integer.valueOf(0)));
              return;
              i += 1;
              break;
              localObject1 = localObject4;
              localObject2 = localObject3;
              if (!(localObject4 instanceof ParameterizedType)) {
                continue;
              }
              localObject5 = (ParameterizedType)localObject4;
              arrayOfType = ((ParameterizedType)localObject5).getActualTypeArguments();
              localObject1 = localObject4;
              localObject2 = localObject3;
              if (arrayOfType.length != 1) {
                continue;
              }
              localObject1 = localObject4;
              localObject2 = localObject3;
              if (!(arrayOfType[0] instanceof TypeVariable)) {
                continue;
              }
              localObject2 = (TypeVariable)arrayOfType[0];
              localParameterizedType = (ParameterizedType)paramType;
              if (!(localParameterizedType.getRawType() instanceof Class)) {
                break label1117;
              }
            }
          }
          for (localObject1 = (Class)localParameterizedType.getRawType();; localObject1 = null)
          {
            if (localObject1 != null)
            {
              i = 0;
              j = ((Class)localObject1).getTypeParameters().length;
              label383:
              if (i < j) {
                if (!localObject1.getTypeParameters()[i].getName().equals(((TypeVariable)localObject2).getName())) {}
              }
            }
            for (;;)
            {
              localObject1 = localObject4;
              localObject2 = localObject3;
              if (i == -1) {
                break;
              }
              arrayOfType[0] = localParameterizedType.getActualTypeArguments()[i];
              localObject1 = new ParameterizedTypeImpl(arrayOfType, ((ParameterizedType)localObject5).getOwnerType(), ((ParameterizedType)localObject5).getRawType());
              localObject2 = localObject3;
              break;
              i += 1;
              break label383;
              paramCollection = "exepct '[', but " + JSONToken.name(((JSONLexer)localObject4).token);
              paramDefaultJSONParser = paramCollection;
              if (paramType != null) {
                paramDefaultJSONParser = paramCollection + ", type : " + paramType;
              }
              throw new JSONException(paramDefaultJSONParser);
              i = ((JSONLexer)localObject4).ch;
              if (i == 91)
              {
                i = ((JSONLexer)localObject4).bp + 1;
                ((JSONLexer)localObject4).bp = i;
                if (i >= ((JSONLexer)localObject4).len)
                {
                  c = '\032';
                  ((JSONLexer)localObject4).ch = c;
                  ((JSONLexer)localObject4).token = 14;
                }
              }
              for (;;)
              {
                i = 0;
                while (((JSONLexer)localObject4).token == 16) {
                  ((JSONLexer)localObject4).nextToken();
                }
                c = ((JSONLexer)localObject4).text.charAt(i);
                break;
                if (i == 123)
                {
                  i = ((JSONLexer)localObject4).bp + 1;
                  ((JSONLexer)localObject4).bp = i;
                  if (i >= ((JSONLexer)localObject4).len) {}
                  for (c = '\032';; c = ((JSONLexer)localObject4).text.charAt(i))
                  {
                    ((JSONLexer)localObject4).ch = c;
                    ((JSONLexer)localObject4).token = 12;
                    break;
                  }
                }
                if (i == 34)
                {
                  ((JSONLexer)localObject4).scanString();
                }
                else
                {
                  if (i == 93)
                  {
                    i = ((JSONLexer)localObject4).bp + 1;
                    ((JSONLexer)localObject4).bp = i;
                    if (i >= ((JSONLexer)localObject4).len) {}
                    for (c = '\032';; c = ((JSONLexer)localObject4).text.charAt(i))
                    {
                      ((JSONLexer)localObject4).ch = c;
                      ((JSONLexer)localObject4).token = 15;
                      break;
                    }
                  }
                  ((JSONLexer)localObject4).nextToken();
                }
              }
              if (((JSONLexer)localObject4).token == 15)
              {
                if (((JSONLexer)localObject4).ch != ',') {
                  break label1105;
                }
                i = ((JSONLexer)localObject4).bp + 1;
                ((JSONLexer)localObject4).bp = i;
                if (i < ((JSONLexer)localObject4).len) {
                  break label1090;
                }
              }
              for (char c = '\032';; c = ((JSONLexer)localObject4).text.charAt(i))
              {
                ((JSONLexer)localObject4).ch = c;
                ((JSONLexer)localObject4).token = 16;
                return;
                paramCollection.add(((ObjectDeserializer)localObject3).deserialze(paramDefaultJSONParser, (Type)localObject1, Integer.valueOf(i)));
                if (paramDefaultJSONParser.resolveStatus == 1) {
                  paramDefaultJSONParser.checkListResolve(paramCollection);
                }
                if (((JSONLexer)localObject4).token == 16)
                {
                  j = ((JSONLexer)localObject4).ch;
                  if (j != 91) {
                    break label998;
                  }
                  j = ((JSONLexer)localObject4).bp + 1;
                  ((JSONLexer)localObject4).bp = j;
                  if (j < ((JSONLexer)localObject4).len) {
                    break label983;
                  }
                  c = '\032';
                  ((JSONLexer)localObject4).ch = c;
                  ((JSONLexer)localObject4).token = 14;
                }
                for (;;)
                {
                  i += 1;
                  break;
                  c = ((JSONLexer)localObject4).text.charAt(j);
                  break label960;
                  if (j == 123)
                  {
                    j = ((JSONLexer)localObject4).bp + 1;
                    ((JSONLexer)localObject4).bp = j;
                    if (j >= ((JSONLexer)localObject4).len) {}
                    for (c = '\032';; c = ((JSONLexer)localObject4).text.charAt(j))
                    {
                      ((JSONLexer)localObject4).ch = c;
                      ((JSONLexer)localObject4).token = 12;
                      break;
                    }
                  }
                  if (j == 34) {
                    ((JSONLexer)localObject4).scanString();
                  } else {
                    ((JSONLexer)localObject4).nextToken();
                  }
                }
              }
              ((JSONLexer)localObject4).nextToken();
              return;
              i = -1;
            }
          }
          localObject2 = localObject3;
        }
        i = -1;
      }
    }
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    if (paramDefaultJSONParser.lexer.token == 8)
    {
      setValue(paramObject, null);
      paramDefaultJSONParser.lexer.nextToken();
      return;
    }
    JSONArray localJSONArray;
    Object localObject;
    if (this.array)
    {
      localJSONArray = new JSONArray();
      localJSONArray.setComponentType(this.itemType);
      localObject = localJSONArray;
    }
    for (;;)
    {
      ParseContext localParseContext = paramDefaultJSONParser.contex;
      paramDefaultJSONParser.setContext(localParseContext, paramObject, this.fieldInfo.name);
      parseArray(paramDefaultJSONParser, paramType, (Collection)localObject);
      paramDefaultJSONParser.setContext(localParseContext);
      paramDefaultJSONParser = (DefaultJSONParser)localObject;
      if (this.array)
      {
        paramDefaultJSONParser = ((List)localObject).toArray((Object[])Array.newInstance((Class)this.itemType, ((List)localObject).size()));
        localJSONArray.setRelatedArray(paramDefaultJSONParser);
      }
      if (paramObject != null) {
        break;
      }
      paramMap.put(this.fieldInfo.name, paramDefaultJSONParser);
      return;
      localObject = new ArrayList();
      localJSONArray = null;
    }
    setValue(paramObject, paramDefaultJSONParser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.ListTypeFieldDeserializer
 * JD-Core Version:    0.7.0.1
 */