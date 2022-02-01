package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DefaultJSONParser
  implements Closeable
{
  public static final int NONE = 0;
  public static final int NeedToResolve = 1;
  public static final int TypeNameRedirect = 2;
  public ParserConfig config;
  protected ParseContext contex;
  private ParseContext[] contextArray;
  private int contextArrayIndex = 0;
  private DateFormat dateFormat;
  private String dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
  protected List<ExtraProcessor> extraProcessors = null;
  protected List<ExtraTypeProvider> extraTypeProviders = null;
  public FieldTypeResolver fieldTypeResolver = null;
  public final JSONLexer lexer;
  public int resolveStatus = 0;
  private List<ResolveTask> resolveTaskList;
  public final SymbolTable symbolTable;
  
  public DefaultJSONParser(JSONLexer paramJSONLexer)
  {
    this(paramJSONLexer, ParserConfig.global);
  }
  
  public DefaultJSONParser(JSONLexer paramJSONLexer, ParserConfig paramParserConfig)
  {
    this.lexer = paramJSONLexer;
    this.config = paramParserConfig;
    this.symbolTable = paramParserConfig.symbolTable;
    int i;
    if (paramJSONLexer.ch == '{')
    {
      i = paramJSONLexer.bp + 1;
      paramJSONLexer.bp = i;
      if (i >= paramJSONLexer.len) {}
      for (;;)
      {
        paramJSONLexer.ch = c;
        paramJSONLexer.token = 12;
        return;
        c = paramJSONLexer.text.charAt(i);
      }
    }
    if (paramJSONLexer.ch == '[')
    {
      i = paramJSONLexer.bp + 1;
      paramJSONLexer.bp = i;
      if (i >= paramJSONLexer.len) {}
      for (;;)
      {
        paramJSONLexer.ch = c;
        paramJSONLexer.token = 14;
        return;
        c = paramJSONLexer.text.charAt(i);
      }
    }
    paramJSONLexer.nextToken();
  }
  
  public DefaultJSONParser(String paramString)
  {
    this(paramString, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig)
  {
    this(new JSONLexer(paramString, JSON.DEFAULT_PARSER_FEATURE), paramParserConfig);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig, int paramInt)
  {
    this(new JSONLexer(paramString, paramInt), paramParserConfig);
  }
  
  public DefaultJSONParser(char[] paramArrayOfChar, int paramInt1, ParserConfig paramParserConfig, int paramInt2)
  {
    this(new JSONLexer(paramArrayOfChar, paramInt1, paramInt2), paramParserConfig);
  }
  
  public final void accept(int paramInt)
  {
    if (this.lexer.token == paramInt)
    {
      this.lexer.nextToken();
      return;
    }
    throw new JSONException("syntax error, expect " + JSONToken.name(paramInt) + ", actual " + JSONToken.name(this.lexer.token));
  }
  
  protected void addResolveTask(ResolveTask paramResolveTask)
  {
    if (this.resolveTaskList == null) {
      this.resolveTaskList = new ArrayList(2);
    }
    this.resolveTaskList.add(paramResolveTask);
  }
  
  protected void checkListResolve(Collection paramCollection)
  {
    if ((paramCollection instanceof List))
    {
      localResolveTask = getLastResolveTask();
      localResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List)paramCollection, paramCollection.size() - 1);
      localResolveTask.ownerContext = this.contex;
      this.resolveStatus = 0;
      return;
    }
    ResolveTask localResolveTask = getLastResolveTask();
    localResolveTask.fieldDeserializer = new ResolveFieldDeserializer(paramCollection);
    localResolveTask.ownerContext = this.contex;
    this.resolveStatus = 0;
  }
  
  protected void checkMapResolve(Map paramMap, Object paramObject)
  {
    paramMap = new ResolveFieldDeserializer(paramMap, paramObject);
    paramObject = getLastResolveTask();
    paramObject.fieldDeserializer = paramMap;
    paramObject.ownerContext = this.contex;
    this.resolveStatus = 0;
  }
  
  public void close()
  {
    try
    {
      if (this.lexer.token != 20) {
        throw new JSONException("not close json text, token : " + JSONToken.name(this.lexer.token));
      }
    }
    finally
    {
      this.lexer.close();
    }
    this.lexer.close();
  }
  
  public void config(Feature paramFeature, boolean paramBoolean)
  {
    this.lexer.config(paramFeature, paramBoolean);
  }
  
  public String getDateFomartPattern()
  {
    return this.dateFormatPattern;
  }
  
  public DateFormat getDateFormat()
  {
    if (this.dateFormat == null)
    {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
      this.dateFormat.setTimeZone(this.lexer.timeZone);
    }
    return this.dateFormat;
  }
  
  public List<ExtraProcessor> getExtraProcessors()
  {
    if (this.extraProcessors == null) {
      this.extraProcessors = new ArrayList(2);
    }
    return this.extraProcessors;
  }
  
  public List<ExtraTypeProvider> getExtraTypeProviders()
  {
    if (this.extraTypeProviders == null) {
      this.extraTypeProviders = new ArrayList(2);
    }
    return this.extraTypeProviders;
  }
  
  protected ResolveTask getLastResolveTask()
  {
    return (ResolveTask)this.resolveTaskList.get(this.resolveTaskList.size() - 1);
  }
  
  public void handleResovleTask(Object paramObject)
  {
    if (this.resolveTaskList == null) {}
    FieldDeserializer localFieldDeserializer;
    for (;;)
    {
      return;
      int k = this.resolveTaskList.size();
      int i = 0;
      while (i < k)
      {
        paramObject = (ResolveTask)this.resolveTaskList.get(i);
        localFieldDeserializer = paramObject.fieldDeserializer;
        if (localFieldDeserializer != null) {
          break label59;
        }
        i += 1;
      }
    }
    label59:
    if (paramObject.ownerContext != null) {}
    for (Object localObject1 = paramObject.ownerContext.object;; localObject1 = null)
    {
      String str = paramObject.referenceValue;
      if (str.startsWith("$"))
      {
        int j = 0;
        paramObject = null;
        for (;;)
        {
          localObject2 = paramObject;
          if (j >= this.contextArrayIndex) {
            break;
          }
          if (str.equals(this.contextArray[j].toString())) {
            paramObject = this.contextArray[j].object;
          }
          j += 1;
        }
      }
      Object localObject2 = paramObject.context.object;
      localFieldDeserializer.setValue(localObject1, localObject2);
      break;
    }
  }
  
  public Object parse()
  {
    return parse(null);
  }
  
  public Object parse(Object paramObject)
  {
    boolean bool = true;
    Object localObject1;
    switch (this.lexer.token)
    {
    case 5: 
    case 10: 
    case 11: 
    case 13: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      throw new JSONException("syntax error, " + this.lexer.info());
    case 21: 
      this.lexer.nextToken();
      localObject1 = new HashSet();
      parseArray((Collection)localObject1, paramObject);
      paramObject = localObject1;
    case 22: 
    case 14: 
    case 12: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        return paramObject;
        this.lexer.nextToken();
        localObject1 = new TreeSet();
        parseArray((Collection)localObject1, paramObject);
        return localObject1;
        localObject1 = new JSONArray();
        parseArray((Collection)localObject1, paramObject);
        return localObject1;
        if ((this.lexer.features & Feature.OrderedField.mask) != 0) {}
        for (localObject1 = new JSONObject(new LinkedHashMap());; localObject1 = new JSONObject()) {
          return parseObject((Map)localObject1, paramObject);
        }
        paramObject = this.lexer.integerValue();
        this.lexer.nextToken();
        return paramObject;
        if ((this.lexer.features & Feature.UseBigDecimal.mask) != 0) {}
        for (;;)
        {
          paramObject = this.lexer.decimalValue(bool);
          this.lexer.nextToken();
          return paramObject;
          bool = false;
        }
        localObject1 = this.lexer.stringVal();
        this.lexer.nextToken(16);
        paramObject = localObject1;
      } while ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) == 0);
      paramObject = new JSONLexer((String)localObject1);
      try
      {
        if (paramObject.scanISO8601DateIfMatch(true))
        {
          localObject1 = paramObject.calendar.getTime();
          return localObject1;
        }
        return localObject1;
      }
      finally
      {
        paramObject.close();
      }
    case 8: 
    case 23: 
      this.lexer.nextToken();
      return null;
    case 6: 
      this.lexer.nextToken(16);
      return Boolean.TRUE;
    case 7: 
      this.lexer.nextToken(16);
      return Boolean.FALSE;
    case 9: 
      this.lexer.nextToken(18);
      if (this.lexer.token != 18) {
        throw new JSONException("syntax error, " + this.lexer.info());
      }
      this.lexer.nextToken(10);
      accept(10);
      long l = this.lexer.integerValue().longValue();
      accept(2);
      accept(11);
      return new Date(l);
    }
    if (this.lexer.isBlankInput()) {
      return null;
    }
    throw new JSONException("syntax error, " + this.lexer.info());
  }
  
  public <T> List<T> parseArray(Class<T> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    parseArray(paramClass, localArrayList);
    return localArrayList;
  }
  
  public void parseArray(Class<?> paramClass, Collection paramCollection)
  {
    parseArray(paramClass, paramCollection);
  }
  
  public void parseArray(Type paramType, Collection paramCollection)
  {
    parseArray(paramType, paramCollection, null);
  }
  
  public void parseArray(Type paramType, Collection paramCollection, Object paramObject)
  {
    if ((this.lexer.token == 21) || (this.lexer.token == 22)) {
      this.lexer.nextToken();
    }
    if (this.lexer.token != 14) {
      throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token) + ", " + this.lexer.info());
    }
    Object localObject;
    ParseContext localParseContext;
    int i;
    if (Integer.TYPE == paramType)
    {
      localObject = IntegerCodec.instance;
      this.lexer.nextToken(2);
      localParseContext = this.contex;
      if (!this.lexer.disableCircularReferenceDetect) {
        setContext(this.contex, paramCollection, paramObject);
      }
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (this.lexer.token != 16) {
          break label221;
        }
        this.lexer.nextToken();
        continue;
        if (String.class != paramType) {
          break label199;
        }
      }
      finally
      {
        this.contex = localParseContext;
      }
      localObject = StringCodec.instance;
      this.lexer.nextToken(4);
      break;
      label199:
      localObject = this.config.getDeserializer(paramType);
      this.lexer.nextToken(12);
      break;
      label221:
      int j = this.lexer.token;
      if (j == 15)
      {
        this.contex = localParseContext;
        this.lexer.nextToken(16);
        return;
      }
      if (Integer.TYPE == paramType)
      {
        paramCollection.add(IntegerCodec.instance.deserialze(this, null, null));
        if (this.lexer.token == 16) {
          this.lexer.nextToken();
        }
      }
      else
      {
        if (String.class == paramType)
        {
          if (this.lexer.token == 4)
          {
            paramObject = this.lexer.stringVal();
            this.lexer.nextToken(16);
          }
          for (;;)
          {
            paramCollection.add(paramObject);
            break;
            paramObject = parse();
            if (paramObject == null) {
              paramObject = null;
            } else {
              paramObject = paramObject.toString();
            }
          }
        }
        if (this.lexer.token == 8) {
          this.lexer.nextToken();
        }
        for (paramObject = null;; paramObject = ((ObjectDeserializer)localObject).deserialze(this, paramType, Integer.valueOf(i)))
        {
          paramCollection.add(paramObject);
          if (this.resolveStatus != 1) {
            break;
          }
          checkListResolve(paramCollection);
          break;
        }
      }
      i += 1;
    }
  }
  
  public final void parseArray(Collection paramCollection)
  {
    parseArray(paramCollection, null);
  }
  
  public final void parseArray(Collection paramCollection, Object paramObject)
  {
    char c2 = '\032';
    int j = this.lexer.token;
    if (j != 21)
    {
      i = j;
      if (j != 22) {}
    }
    else
    {
      this.lexer.nextToken();
      i = this.lexer.token;
    }
    if (i != 14) {
      throw new JSONException("syntax error, expect [, actual " + JSONToken.name(i) + ", pos " + this.lexer.pos);
    }
    boolean bool = this.lexer.disableCircularReferenceDetect;
    ParseContext localParseContext = this.contex;
    if (!bool) {
      setContext(this.contex, paramCollection, paramObject);
    }
    char c1;
    label248:
    Object localObject;
    for (;;)
    {
      try
      {
        i = this.lexer.ch;
        if (i != 34)
        {
          if (i == 93)
          {
            this.lexer.next();
            this.lexer.nextToken(16);
            return;
          }
          if (i == 123)
          {
            paramObject = this.lexer;
            i = paramObject.bp + 1;
            paramObject.bp = i;
            paramObject = this.lexer;
            if (i >= this.lexer.len)
            {
              c1 = '\032';
              paramObject.ch = c1;
              this.lexer.token = 12;
              break label1181;
              i = j;
              if (j == 0) {
                break;
              }
              i = j;
              if (this.lexer.ch != '"') {
                break;
              }
              paramObject = this.lexer.scanStringValue('"');
              i = this.lexer.ch;
              if (i != 44) {
                break label512;
              }
              localObject = this.lexer;
              i = ((JSONLexer)localObject).bp + 1;
              ((JSONLexer)localObject).bp = i;
              localObject = this.lexer;
              if (i < this.lexer.len) {
                break label451;
              }
              c1 = '\032';
              ((JSONLexer)localObject).ch = c1;
              paramCollection.add(paramObject);
              if (this.resolveStatus != 1) {
                break label1194;
              }
              checkListResolve(paramCollection);
              break label1194;
            }
            c1 = this.lexer.text.charAt(i);
            continue;
          }
          this.lexer.nextToken(12);
        }
      }
      finally
      {
        if (!bool) {
          this.contex = localParseContext;
        }
      }
      if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) == 0)
      {
        i = 1;
        break label1184;
      }
      this.lexer.nextToken(4);
      i = 0;
      break label1184;
      label451:
      c1 = this.lexer.text.charAt(i);
    }
    label467:
    this.lexer.nextToken();
    for (int i = 0;; i = j)
    {
      for (j = this.lexer.token; j == 16; j = this.lexer.token) {
        this.lexer.nextToken();
      }
      label512:
      if (i == 93)
      {
        localObject = this.lexer;
        i = ((JSONLexer)localObject).bp + 1;
        ((JSONLexer)localObject).bp = i;
        localObject = this.lexer;
        if (i >= this.lexer.len) {}
        for (c1 = c2;; c1 = this.lexer.text.charAt(i))
        {
          ((JSONLexer)localObject).ch = c1;
          paramCollection.add(paramObject);
          if (this.resolveStatus == 1) {
            checkListResolve(paramCollection);
          }
          this.lexer.nextToken(16);
          if (bool) {
            break;
          }
          this.contex = localParseContext;
          return;
        }
      }
      this.lexer.nextToken();
    }
    for (;;)
    {
      paramObject = parse();
      int k;
      for (;;)
      {
        paramCollection.add(paramObject);
        if (this.resolveStatus == 1) {
          checkListResolve(paramCollection);
        }
        j = i;
        if (this.lexer.token != 16) {
          break label1200;
        }
        j = this.lexer.ch;
        if (j != 34) {
          break;
        }
        this.lexer.pos = this.lexer.bp;
        this.lexer.scanString();
        j = i;
        break label1200;
        paramObject = this.lexer.integerValue();
        this.lexer.nextToken(16);
        continue;
        if ((this.lexer.features & Feature.UseBigDecimal.mask) != 0) {}
        for (paramObject = this.lexer.decimalValue(true);; paramObject = this.lexer.decimalValue(false))
        {
          this.lexer.nextToken(16);
          break;
        }
        localObject = this.lexer.stringVal();
        this.lexer.nextToken(16);
        paramObject = localObject;
        if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0)
        {
          JSONLexer localJSONLexer = new JSONLexer((String)localObject);
          paramObject = localObject;
          if (localJSONLexer.scanISO8601DateIfMatch(true)) {
            paramObject = localJSONLexer.calendar.getTime();
          }
          localJSONLexer.close();
          continue;
          paramObject = Boolean.TRUE;
          this.lexer.nextToken(16);
          continue;
          paramObject = Boolean.FALSE;
          this.lexer.nextToken(16);
          continue;
          if ((this.lexer.features & Feature.OrderedField.mask) != 0) {}
          for (paramObject = new JSONObject(new LinkedHashMap());; paramObject = new JSONObject())
          {
            paramObject = parseObject(paramObject, Integer.valueOf(k));
            break;
          }
          paramObject = new JSONArray();
          parseArray(paramObject, Integer.valueOf(k));
          continue;
          paramObject = null;
          this.lexer.nextToken(4);
          continue;
          paramObject = null;
          this.lexer.nextToken(4);
        }
      }
      this.lexer.nextToken(16);
      if (bool) {
        break;
      }
      this.contex = localParseContext;
      return;
      throw new JSONException("unclosed jsonArray");
      if ((j >= 48) && (j <= 57))
      {
        this.lexer.pos = this.lexer.bp;
        this.lexer.scanNumber();
        j = i;
      }
      else
      {
        if (j == 123)
        {
          this.lexer.token = 12;
          paramObject = this.lexer;
          j = paramObject.bp + 1;
          paramObject.bp = j;
          paramObject = this.lexer;
          if (j >= this.lexer.len) {}
          for (c1 = '\032';; c1 = this.lexer.text.charAt(j))
          {
            paramObject.ch = c1;
            j = i;
            break;
          }
        }
        this.lexer.nextToken();
        j = i;
        break label1200;
        label1181:
        i = 0;
        label1184:
        k = 0;
        j = i;
        break label248;
        label1194:
        if (c1 != '"') {
          break label467;
        }
      }
      label1200:
      k += 1;
      break label248;
      switch (j)
      {
      }
    }
  }
  
  public Object[] parseArray(Type[] paramArrayOfType)
  {
    if (this.lexer.token == 8)
    {
      this.lexer.nextToken(16);
      return null;
    }
    if (this.lexer.token != 14) {
      throw new JSONException("syntax error, " + this.lexer.info());
    }
    Object[] arrayOfObject = new Object[paramArrayOfType.length];
    if (paramArrayOfType.length == 0)
    {
      this.lexer.nextToken(15);
      if (this.lexer.token != 15) {
        throw new JSONException("syntax error, " + this.lexer.info());
      }
      this.lexer.nextToken(16);
      return new Object[0];
    }
    this.lexer.nextToken(2);
    int i = 0;
    Object localObject;
    if (i < paramArrayOfType.length)
    {
      if (this.lexer.token != 8) {
        break label254;
      }
      this.lexer.nextToken(16);
      localObject = null;
    }
    label190:
    label254:
    Type localType;
    for (;;)
    {
      arrayOfObject[i] = localObject;
      if (this.lexer.token != 15) {
        break label597;
      }
      if (this.lexer.token == 15) {
        break label678;
      }
      throw new JSONException("syntax error, " + this.lexer.info());
      localType = paramArrayOfType[i];
      if ((localType == Integer.TYPE) || (localType == Integer.class))
      {
        if (this.lexer.token == 2)
        {
          localObject = Integer.valueOf(this.lexer.intValue());
          this.lexer.nextToken(16);
        }
        else
        {
          localObject = TypeUtils.cast(parse(), localType, this.config);
        }
      }
      else
      {
        if (localType != String.class) {
          break;
        }
        if (this.lexer.token == 4)
        {
          localObject = this.lexer.stringVal();
          this.lexer.nextToken(16);
        }
        else
        {
          localObject = TypeUtils.cast(parse(), localType, this.config);
        }
      }
    }
    boolean bool;
    if ((i == paramArrayOfType.length - 1) && ((localType instanceof Class)))
    {
      localObject = (Class)localType;
      bool = ((Class)localObject).isArray();
      localObject = ((Class)localObject).getComponentType();
    }
    for (;;)
    {
      if ((bool) && (this.lexer.token != 14))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = this.config.getDeserializer((Type)localObject);
        if (this.lexer.token != 15)
        {
          for (;;)
          {
            localArrayList.add(((ObjectDeserializer)localObject).deserialze(this, localType, null));
            if (this.lexer.token != 16) {
              break;
            }
            this.lexer.nextToken(12);
          }
          if (this.lexer.token != 15) {}
        }
        else
        {
          localObject = TypeUtils.cast(localArrayList, localType, this.config);
          break label190;
        }
        throw new JSONException("syntax error, " + this.lexer.info());
      }
      localObject = this.config.getDeserializer(localType).deserialze(this, localType, null);
      break label190;
      label597:
      if (this.lexer.token != 16) {
        throw new JSONException("syntax error, " + this.lexer.info());
      }
      if (i == paramArrayOfType.length - 1) {
        this.lexer.nextToken(15);
      }
      for (;;)
      {
        i += 1;
        break;
        this.lexer.nextToken(2);
      }
      label678:
      this.lexer.nextToken(16);
      return arrayOfObject;
      localObject = null;
      bool = false;
    }
  }
  
  public Object parseArrayWithType(Type paramType)
  {
    if (this.lexer.token == 8)
    {
      this.lexer.nextToken();
      return null;
    }
    Object localObject1 = ((ParameterizedType)paramType).getActualTypeArguments();
    if (localObject1.length != 1) {
      throw new JSONException("not support type " + paramType);
    }
    localObject1 = localObject1[0];
    if ((localObject1 instanceof Class))
    {
      paramType = new ArrayList();
      parseArray((Class)localObject1, paramType);
      return paramType;
    }
    Object localObject2;
    if ((localObject1 instanceof WildcardType))
    {
      localObject2 = (WildcardType)localObject1;
      localObject1 = localObject2.getUpperBounds()[0];
      if (Object.class.equals(localObject1))
      {
        if (((WildcardType)localObject2).getLowerBounds().length == 0) {
          return parse();
        }
        throw new JSONException("not support type : " + paramType);
      }
      paramType = new ArrayList();
      parseArray((Class)localObject1, paramType);
      return paramType;
    }
    if ((localObject1 instanceof TypeVariable))
    {
      localObject2 = (TypeVariable)localObject1;
      Type[] arrayOfType = ((TypeVariable)localObject2).getBounds();
      if (arrayOfType.length != 1) {
        throw new JSONException("not support : " + localObject2);
      }
      localObject2 = arrayOfType[0];
      if ((localObject2 instanceof Class))
      {
        paramType = new ArrayList();
        parseArray((Class)localObject2, paramType);
        return paramType;
      }
    }
    if ((localObject1 instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)localObject1;
      localObject1 = new ArrayList();
      parseArray(paramType, (Collection)localObject1);
      return localObject1;
    }
    throw new JSONException("TODO : " + paramType);
  }
  
  public JSONObject parseObject()
  {
    if ((this.lexer.features & Feature.OrderedField.mask) != 0) {}
    for (JSONObject localJSONObject = new JSONObject(new LinkedHashMap());; localJSONObject = new JSONObject()) {
      return (JSONObject)parseObject(localJSONObject, null);
    }
  }
  
  public <T> T parseObject(Class<T> paramClass)
  {
    return parseObject(paramClass, null);
  }
  
  public <T> T parseObject(Type paramType)
  {
    return parseObject(paramType, null);
  }
  
  public <T> T parseObject(Type paramType, Object paramObject)
  {
    if (this.lexer.token == 8)
    {
      this.lexer.nextToken();
      return null;
    }
    if (this.lexer.token == 4)
    {
      if (paramType == [B.class)
      {
        paramType = this.lexer.bytesValue();
        this.lexer.nextToken();
        return paramType;
      }
      if (paramType == [C.class)
      {
        paramType = this.lexer.stringVal();
        this.lexer.nextToken();
        return paramType.toCharArray();
      }
    }
    ObjectDeserializer localObjectDeserializer = this.config.getDeserializer(paramType);
    try
    {
      paramType = localObjectDeserializer.deserialze(this, paramType, paramObject);
      return paramType;
    }
    catch (JSONException paramType)
    {
      throw paramType;
    }
    catch (Exception paramType)
    {
      throw new JSONException(paramType.getMessage(), paramType);
    }
  }
  
  public Object parseObject(Map paramMap)
  {
    return parseObject(paramMap, null);
  }
  
  public final Object parseObject(Map paramMap, Object paramObject)
  {
    JSONLexer localJSONLexer = this.lexer;
    int j = localJSONLexer.token;
    if (j == 8)
    {
      localJSONLexer.nextToken();
      paramObject = null;
      return paramObject;
    }
    if ((j != 12) && (j != 16)) {
      throw new JSONException("syntax error, expect {, actual " + JSONToken.name(j) + ", " + localJSONLexer.info());
    }
    Map localMap;
    int m;
    int n;
    label126:
    boolean bool1;
    Object localObject2;
    if ((paramMap instanceof JSONObject))
    {
      localMap = ((JSONObject)paramMap).getInnerMap();
      m = 1;
      if ((localJSONLexer.features & Feature.AllowISO8601DateFormat.mask) == 0) {
        break label3843;
      }
      n = 1;
      bool1 = localJSONLexer.disableCircularReferenceDetect;
      localObject2 = this.contex;
      j = 0;
    }
    label142:
    label660:
    label825:
    label961:
    label1101:
    label1636:
    label3818:
    label3947:
    for (;;)
    {
      Object localObject4 = localObject2;
      int i1;
      int k;
      Object localObject3;
      Object localObject1;
      try
      {
        i1 = localJSONLexer.ch;
        k = i1;
        if (i1 != 34)
        {
          k = i1;
          if (i1 != 125)
          {
            localObject4 = localObject2;
            localJSONLexer.skipWhitespace();
            localObject4 = localObject2;
          }
        }
        for (k = localJSONLexer.ch; k == 44; k = localJSONLexer.ch)
        {
          localObject4 = localObject2;
          localJSONLexer.next();
          localObject4 = localObject2;
          localJSONLexer.skipWhitespace();
          localObject4 = localObject2;
        }
        if (k == 34)
        {
          localObject4 = localObject2;
          localObject3 = localJSONLexer.scanSymbol(this.symbolTable, '"');
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (localJSONLexer.ch == ':') {
            break label3818;
          }
          localObject4 = localObject2;
          localJSONLexer.skipWhitespace();
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (localJSONLexer.ch == ':') {
            break label3818;
          }
          localObject4 = localObject2;
          throw new JSONException("expect ':' at " + localJSONLexer.pos + ", name " + localObject3);
        }
      }
      finally
      {
        if (!bool1) {
          this.contex = localObject4;
        }
      }
      int i;
      if (k == 125)
      {
        localObject4 = localObject2;
        j = localJSONLexer.bp + 1;
        localObject4 = localObject2;
        localJSONLexer.bp = j;
        localObject4 = localObject2;
        if (j >= localJSONLexer.len) {}
        for (i = 26;; i = localJSONLexer.text.charAt(j))
        {
          localObject4 = localObject2;
          localJSONLexer.ch = i;
          localObject4 = localObject2;
          localJSONLexer.sp = 0;
          localObject4 = localObject2;
          localJSONLexer.nextToken(16);
          paramObject = paramMap;
          if (bool1) {
            break;
          }
          this.contex = ((ParseContext)localObject2);
          return paramMap;
          localObject4 = localObject2;
        }
      }
      label875:
      label1269:
      label1913:
      ParseContext localParseContext;
      if (k == 39)
      {
        localObject4 = localObject2;
        localObject1 = localJSONLexer.scanSymbol(this.symbolTable, '\'');
        localObject4 = localObject2;
        if (localJSONLexer.ch != ':')
        {
          localObject4 = localObject2;
          localJSONLexer.skipWhitespace();
        }
        localObject4 = localObject2;
        if (localJSONLexer.ch != ':')
        {
          localObject4 = localObject2;
          throw new JSONException("expect ':' at " + localJSONLexer.pos);
        }
      }
      else
      {
        if (k == 26)
        {
          localObject4 = localObject2;
          throw new JSONException("syntax error, " + localJSONLexer.info());
        }
        if (k != 44) {
          break label3849;
        }
        localObject4 = localObject2;
        throw new JSONException("syntax error, " + localJSONLexer.info());
        localObject4 = localObject2;
        localJSONLexer.sp = 0;
        localObject4 = localObject2;
        localJSONLexer.scanNumber();
        localObject4 = localObject2;
        try
        {
          if (localJSONLexer.token == 2) {
            localObject4 = localObject2;
          }
          for (localObject1 = localJSONLexer.integerValue();; localObject1 = localJSONLexer.decimalValue(true))
          {
            localObject3 = localObject1;
            if (m != 0)
            {
              localObject4 = localObject2;
              localObject3 = localObject1.toString();
            }
            localObject4 = localObject2;
            if (localJSONLexer.ch == ':') {
              break;
            }
            localObject4 = localObject2;
            throw new JSONException("parse number key error, " + localJSONLexer.info());
            localObject4 = localObject2;
          }
          localObject4 = localObject2;
        }
        catch (NumberFormatException paramMap)
        {
          localObject4 = localObject2;
          throw new JSONException("parse number key error, " + localJSONLexer.info());
        }
        localJSONLexer.nextToken();
        localObject4 = localObject2;
        localObject3 = parse();
        i1 = 1;
        k = i1;
        localObject1 = localObject3;
        if (m != 0)
        {
          localObject4 = localObject2;
          localObject1 = localObject3.toString();
          k = i1;
        }
        if (k == 0)
        {
          localObject4 = localObject2;
          k = localJSONLexer.bp + 1;
          localObject4 = localObject2;
          localJSONLexer.bp = k;
          localObject4 = localObject2;
          if (k >= localJSONLexer.len) {}
          for (i = 26;; i = localJSONLexer.text.charAt(k))
          {
            localObject4 = localObject2;
            localJSONLexer.ch = i;
            k = i;
            break label3890;
            localObject4 = localObject2;
            localJSONLexer.next();
            localObject4 = localObject2;
            k = localJSONLexer.ch;
            break label3890;
            localObject4 = localObject2;
            localObject3 = localJSONLexer.scanSymbolUnQuoted(this.symbolTable);
            localObject4 = localObject2;
            localJSONLexer.skipWhitespace();
            localObject4 = localObject2;
            i = localJSONLexer.ch;
            if (i != 58)
            {
              localObject4 = localObject2;
              throw new JSONException("expect ':' at " + localJSONLexer.bp + ", actual " + i);
            }
            localObject1 = localObject3;
            if (m == 0) {
              break label3818;
            }
            localObject4 = localObject2;
            localObject1 = localObject3.toString();
            k = 0;
            break;
            localObject4 = localObject2;
          }
        }
        localObject4 = localObject2;
        k = localJSONLexer.ch;
        localObject4 = localObject2;
        localJSONLexer.sp = 0;
        if (localObject1 == "@type")
        {
          localObject4 = localObject2;
          if (!localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))
          {
            localObject4 = localObject2;
            localObject1 = localJSONLexer.scanSymbol(this.symbolTable, '"');
            localObject4 = localObject2;
            localObject3 = TypeUtils.loadClass((String)localObject1, this.config.defaultClassLoader);
            if (localObject3 == null)
            {
              localObject4 = localObject2;
              paramMap.put("@type", localObject1);
              continue;
            }
            localObject4 = localObject2;
            localJSONLexer.nextToken(16);
            localObject4 = localObject2;
            if (localJSONLexer.token == 13)
            {
              localObject4 = localObject2;
              localJSONLexer.nextToken(16);
              localObject4 = localObject2;
              try
              {
                paramMap = this.config.getDeserializer((Type)localObject3);
                localObject4 = localObject2;
                if (!(paramMap instanceof JavaBeanDeserializer)) {
                  break label3810;
                }
                localObject4 = localObject2;
                paramObject = ((JavaBeanDeserializer)paramMap).createInstance(this, (Type)localObject3);
                paramMap = paramObject;
                if (paramObject == null)
                {
                  if (localObject3 != Cloneable.class) {
                    break label1308;
                  }
                  localObject4 = localObject2;
                  paramMap = new HashMap();
                }
                for (;;)
                {
                  if (!bool1) {
                    this.contex = ((ParseContext)localObject2);
                  }
                  return paramMap;
                  localObject4 = localObject2;
                  if ("java.util.Collections$EmptyMap".equals(localObject1))
                  {
                    localObject4 = localObject2;
                    paramMap = Collections.emptyMap();
                  }
                  else
                  {
                    localObject4 = localObject2;
                    paramMap = ((Class)localObject3).newInstance();
                  }
                }
                localObject4 = localObject2;
              }
              catch (Exception paramMap)
              {
                localObject4 = localObject2;
                throw new JSONException("create instance error", paramMap);
              }
            }
            this.resolveStatus = 2;
            localObject4 = localObject2;
            if (this.contex != null)
            {
              localObject4 = localObject2;
              if (!(paramObject instanceof Integer))
              {
                localObject4 = localObject2;
                popContext();
              }
            }
            localObject4 = localObject2;
            if (paramMap.size() > 0)
            {
              localObject4 = localObject2;
              paramMap = TypeUtils.cast(paramMap, (Class)localObject3, this.config);
              localObject4 = localObject2;
              parseObject(paramMap);
              paramObject = paramMap;
              if (bool1) {
                break;
              }
              this.contex = ((ParseContext)localObject2);
              return paramMap;
            }
            localObject4 = localObject2;
            paramMap = this.config.getDeserializer((Type)localObject3).deserialze(this, (Type)localObject3, paramObject);
            paramObject = paramMap;
            if (bool1) {
              break;
            }
            this.contex = ((ParseContext)localObject2);
            return paramMap;
          }
        }
        if (localObject1 == "$ref")
        {
          localObject4 = localObject2;
          if (!localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))
          {
            localObject4 = localObject2;
            localJSONLexer.nextToken(4);
            localObject4 = localObject2;
            if (localJSONLexer.token == 4)
            {
              localObject4 = localObject2;
              localObject1 = localJSONLexer.stringVal();
              localObject4 = localObject2;
              localJSONLexer.nextToken(13);
              paramObject = null;
              paramMap = null;
              localObject4 = localObject2;
              if ("@".equals(localObject1))
              {
                localObject4 = localObject2;
                if (this.contex == null) {
                  break label3950;
                }
                localObject4 = localObject2;
                localObject1 = this.contex;
                localObject4 = localObject2;
                paramObject = ((ParseContext)localObject1).object;
                localObject4 = localObject2;
                if ((paramObject instanceof Object[])) {
                  break label3942;
                }
                localObject4 = localObject2;
                if ((paramObject instanceof Collection)) {
                  break label3942;
                }
              }
              for (;;)
              {
                localObject4 = localObject2;
                if (localJSONLexer.token == 13) {
                  break label1913;
                }
                localObject4 = localObject2;
                throw new JSONException("syntax error, " + localJSONLexer.info());
                localObject4 = localObject2;
                if (((ParseContext)localObject1).parent == null) {
                  break label3944;
                }
                localObject4 = localObject2;
                paramMap = ((ParseContext)localObject1).parent.object;
                break label3944;
                localObject4 = localObject2;
                if (!"..".equals(localObject1)) {
                  break;
                }
                localObject4 = localObject2;
                if (((ParseContext)localObject2).object != null)
                {
                  localObject4 = localObject2;
                  paramMap = ((ParseContext)localObject2).object;
                }
                else
                {
                  localObject4 = localObject2;
                  addResolveTask(new ResolveTask((ParseContext)localObject2, (String)localObject1));
                  localObject4 = localObject2;
                  this.resolveStatus = 1;
                  paramMap = null;
                }
              }
              localObject4 = localObject2;
              if ("$".equals(localObject1))
              {
                for (paramMap = (Map)localObject2;; paramMap = paramMap.parent)
                {
                  localObject4 = localObject2;
                  if (paramMap.parent == null) {
                    break;
                  }
                  localObject4 = localObject2;
                }
                localObject4 = localObject2;
                if (paramMap.object != null)
                {
                  localObject4 = localObject2;
                  paramMap = paramMap.object;
                  break label3947;
                }
                localObject4 = localObject2;
                addResolveTask(new ResolveTask(paramMap, (String)localObject1));
                localObject4 = localObject2;
                this.resolveStatus = 1;
                paramMap = paramObject;
                break label3947;
              }
              localObject4 = localObject2;
              addResolveTask(new ResolveTask((ParseContext)localObject2, (String)localObject1));
              localObject4 = localObject2;
              this.resolveStatus = 1;
              break label3950;
              localObject4 = localObject2;
              localJSONLexer.nextToken(16);
              paramObject = paramMap;
              if (bool1) {
                break;
              }
              this.contex = ((ParseContext)localObject2);
              return paramMap;
            }
            localObject4 = localObject2;
            throw new JSONException("illegal ref, " + JSONToken.name(localJSONLexer.token));
          }
        }
        if ((!bool1) && (j == 0))
        {
          localObject4 = localObject2;
          localObject3 = setContext(this.contex, paramMap, paramObject);
          if (localObject2 == null)
          {
            localObject2 = localObject3;
            break label3955;
            if (k != 34) {
              break label3961;
            }
            localObject4 = localObject2;
            localObject3 = localJSONLexer.scanStringValue('"');
            Object localObject5 = localObject3;
            if (n != 0)
            {
              localObject4 = localObject2;
              localObject5 = new JSONLexer((String)localObject3);
              localObject4 = localObject2;
              if (((JSONLexer)localObject5).scanISO8601DateIfMatch(true))
              {
                localObject4 = localObject2;
                localObject3 = ((JSONLexer)localObject5).calendar.getTime();
              }
              localObject4 = localObject2;
              ((JSONLexer)localObject5).close();
              localObject5 = localObject3;
            }
            if (localMap != null)
            {
              localObject4 = localObject2;
              localMap.put(localObject1, localObject5);
            }
            for (;;)
            {
              localObject4 = localObject2;
              i1 = localJSONLexer.ch;
              k = i1;
              if (i1 != 44)
              {
                k = i1;
                if (i1 != 125)
                {
                  localObject4 = localObject2;
                  localJSONLexer.skipWhitespace();
                  localObject4 = localObject2;
                  k = localJSONLexer.ch;
                }
              }
              if (k != 44) {
                break label3356;
              }
              localObject4 = localObject2;
              k = localJSONLexer.bp + 1;
              localObject4 = localObject2;
              localJSONLexer.bp = k;
              localObject4 = localObject2;
              if (k < localJSONLexer.len) {
                break label3338;
              }
              i = 26;
              localObject4 = localObject2;
              localJSONLexer.ch = i;
              break;
              localObject4 = localObject2;
              paramMap.put(localObject1, localObject5);
              continue;
              localObject4 = localObject2;
              paramMap.put(localObject1, localJSONLexer.scanNumberValue());
            }
            if (k == 91)
            {
              localObject4 = localObject2;
              localJSONLexer.token = 14;
              localObject4 = localObject2;
              k = localJSONLexer.bp + 1;
              localObject4 = localObject2;
              localJSONLexer.bp = k;
              localObject4 = localObject2;
              if (k >= localJSONLexer.len)
              {
                i = 26;
                localObject4 = localObject2;
                localJSONLexer.ch = i;
                localObject4 = localObject2;
                localObject3 = new ArrayList();
                if (paramObject == null) {
                  break label3985;
                }
                localObject4 = localObject2;
                if (paramObject.getClass() != Integer.class) {
                  break label3985;
                }
                k = 1;
                if (k == 0)
                {
                  localObject4 = localObject2;
                  setContext((ParseContext)localObject2);
                }
                localObject4 = localObject2;
                parseArray((Collection)localObject3, localObject1);
                localObject4 = localObject2;
                localObject3 = new JSONArray((List)localObject3);
                if (localMap == null) {
                  break label2502;
                }
                localObject4 = localObject2;
                localMap.put(localObject1, localObject3);
              }
              for (;;)
              {
                localObject4 = localObject2;
                k = localJSONLexer.token;
                if (k != 13) {
                  break label3991;
                }
                localObject4 = localObject2;
                localJSONLexer.nextToken(16);
                paramObject = paramMap;
                if (bool1) {
                  break;
                }
                this.contex = ((ParseContext)localObject2);
                return paramMap;
                localObject4 = localObject2;
                i = localJSONLexer.text.charAt(k);
                break label2333;
                localObject4 = localObject2;
                paramMap.put(localObject1, localObject3);
              }
              localObject4 = localObject2;
              throw new JSONException("syntax error, " + localJSONLexer.info());
            }
            if (k == 123)
            {
              localObject4 = localObject2;
              k = localJSONLexer.bp + 1;
              localObject4 = localObject2;
              localJSONLexer.bp = k;
              localObject4 = localObject2;
              boolean bool2;
              if (k >= localJSONLexer.len)
              {
                i = 26;
                localObject4 = localObject2;
                localJSONLexer.ch = i;
                localObject4 = localObject2;
                localJSONLexer.token = 12;
                localObject4 = localObject2;
                bool2 = paramObject instanceof Integer;
                localObject4 = localObject2;
                if ((localJSONLexer.features & Feature.OrderedField.mask) == 0) {
                  break label2963;
                }
                localObject4 = localObject2;
                localObject5 = new JSONObject(new LinkedHashMap());
                label2674:
                if ((bool1) || (bool2)) {
                  break label3798;
                }
                localObject4 = localObject2;
                localParseContext = setContext((ParseContext)localObject2, localObject5, localObject1);
                localObject4 = localObject2;
                if (this.fieldTypeResolver == null) {
                  break label3789;
                }
                if (localObject1 == null) {
                  break label4001;
                }
                localObject4 = localObject2;
                localObject3 = localObject1.toString();
                localObject4 = localObject2;
                localObject3 = this.fieldTypeResolver.resolve(paramMap, (String)localObject3);
                if (localObject3 == null) {
                  break label3789;
                }
                localObject4 = localObject2;
                localObject3 = this.config.getDeserializer((Type)localObject3).deserialze(this, (Type)localObject3, localObject1);
                k = 1;
                if (k == 0)
                {
                  localObject4 = localObject2;
                  localObject3 = parseObject((Map)localObject5, localObject1);
                }
                if ((localParseContext != null) && (localObject5 != localObject3))
                {
                  localObject4 = localObject2;
                  localParseContext.object = paramMap;
                }
                localObject4 = localObject2;
                if (this.resolveStatus == 1)
                {
                  localObject4 = localObject2;
                  checkMapResolve(paramMap, localObject1.toString());
                }
                if (localMap == null) {
                  break label2979;
                }
                localObject4 = localObject2;
                localMap.put(localObject1, localObject3);
              }
              for (;;)
              {
                if (bool2)
                {
                  localObject4 = localObject2;
                  setContext((ParseContext)localObject2, localObject3, localObject1);
                }
                localObject4 = localObject2;
                k = localJSONLexer.token;
                if (k != 13) {
                  break label4007;
                }
                localObject4 = localObject2;
                localJSONLexer.nextToken(16);
                if (!bool1)
                {
                  localObject4 = localObject2;
                  this.contex = ((ParseContext)localObject2);
                }
                paramObject = paramMap;
                if (bool1) {
                  break;
                }
                this.contex = ((ParseContext)localObject2);
                return paramMap;
                localObject4 = localObject2;
                i = localJSONLexer.text.charAt(k);
                break label2604;
                localObject4 = localObject2;
                localObject5 = new JSONObject();
                break label2674;
                localObject4 = localObject2;
                paramMap.put(localObject1, localObject3);
              }
            }
          }
        }
      }
      label3563:
      label3950:
      label3955:
      label3961:
      while (k != 16)
      {
        localObject4 = localObject2;
        throw new JSONException("syntax error, " + localJSONLexer.info());
        if (k == 116)
        {
          localObject4 = localObject2;
          if (!localJSONLexer.text.startsWith("true", localJSONLexer.bp)) {
            break label2121;
          }
          localObject4 = localObject2;
          localJSONLexer.bp += 3;
          localObject4 = localObject2;
          localJSONLexer.next();
          localObject4 = localObject2;
          paramMap.put(localObject1, Boolean.TRUE);
          break label2121;
        }
        if (k == 102)
        {
          localObject4 = localObject2;
          if (!localJSONLexer.text.startsWith("false", localJSONLexer.bp)) {
            break label2121;
          }
          localObject4 = localObject2;
          localJSONLexer.bp += 4;
          localObject4 = localObject2;
          localJSONLexer.next();
          localObject4 = localObject2;
          paramMap.put(localObject1, Boolean.FALSE);
          break label2121;
        }
        localObject4 = localObject2;
        localJSONLexer.nextToken();
        localObject4 = localObject2;
        localObject3 = parse();
        localObject4 = localObject2;
        if (paramMap.getClass() == JSONObject.class)
        {
          localObject4 = localObject2;
          localObject1 = localObject1.toString();
        }
        for (;;)
        {
          localObject4 = localObject2;
          paramMap.put(localObject1, localObject3);
          localObject4 = localObject2;
          if (localJSONLexer.token != 13) {
            break label3285;
          }
          localObject4 = localObject2;
          localJSONLexer.nextToken(16);
          paramObject = paramMap;
          if (bool1) {
            break;
          }
          this.contex = ((ParseContext)localObject2);
          return paramMap;
        }
        localObject4 = localObject2;
        if (localJSONLexer.token == 16) {
          break label142;
        }
        localObject4 = localObject2;
        throw new JSONException("syntax error, " + localJSONLexer.info());
        localObject4 = localObject2;
        i = localJSONLexer.text.charAt(k);
        break label2222;
        if (k == 125)
        {
          localObject4 = localObject2;
          j = localJSONLexer.bp + 1;
          localObject4 = localObject2;
          localJSONLexer.bp = j;
          localObject4 = localObject2;
          if (j >= localJSONLexer.len)
          {
            i = 26;
            localObject4 = localObject2;
            localJSONLexer.ch = i;
            localObject4 = localObject2;
            localJSONLexer.sp = 0;
            if (i != 44) {
              break label3563;
            }
            localObject4 = localObject2;
            j = localJSONLexer.bp + 1;
            localObject4 = localObject2;
            localJSONLexer.bp = j;
            localObject4 = localObject2;
            if (j < localJSONLexer.len) {
              break label3545;
            }
            i = 26;
            localObject4 = localObject2;
            localJSONLexer.ch = i;
            localObject4 = localObject2;
            localJSONLexer.token = 16;
          }
          for (;;)
          {
            if (!bool1)
            {
              localObject4 = localObject2;
              setContext(this.contex, paramMap, paramObject);
            }
            paramObject = paramMap;
            if (bool1) {
              break;
            }
            this.contex = ((ParseContext)localObject2);
            return paramMap;
            localObject4 = localObject2;
            i = localJSONLexer.text.charAt(j);
            break label3404;
            localObject4 = localObject2;
            i = localJSONLexer.text.charAt(j);
            break label3471;
            if (i == 125)
            {
              localObject4 = localObject2;
              j = localJSONLexer.bp + 1;
              localObject4 = localObject2;
              localJSONLexer.bp = j;
              localObject4 = localObject2;
              if (j >= localJSONLexer.len) {}
              for (i = 26;; i = localJSONLexer.text.charAt(j))
              {
                localObject4 = localObject2;
                localJSONLexer.ch = i;
                localObject4 = localObject2;
                localJSONLexer.token = 13;
                break;
                localObject4 = localObject2;
              }
            }
            if (i == 93)
            {
              localObject4 = localObject2;
              j = localJSONLexer.bp + 1;
              localObject4 = localObject2;
              localJSONLexer.bp = j;
              localObject4 = localObject2;
              if (j >= localJSONLexer.len) {}
              for (i = 26;; i = localJSONLexer.text.charAt(j))
              {
                localObject4 = localObject2;
                localJSONLexer.ch = i;
                localObject4 = localObject2;
                localJSONLexer.token = 15;
                break;
                localObject4 = localObject2;
              }
            }
            localObject4 = localObject2;
            localJSONLexer.nextToken();
          }
        }
        localObject4 = localObject2;
        throw new JSONException("syntax error, " + localJSONLexer.info());
        localObject3 = null;
        k = 0;
        break label2778;
        localParseContext = null;
        break label2700;
        break label3955;
        break label2016;
        paramObject = null;
        break label1269;
        do
        {
          do
          {
            break label1101;
            k = 0;
            break label875;
            localObject1 = localObject3;
            k = 0;
            break label875;
            m = 0;
            localMap = null;
            break;
            n = 0;
            break label126;
            if (((k >= 48) && (k <= 57)) || (k == 45)) {
              break label660;
            }
            if (k == 123) {
              break label825;
            }
            if (k != 91) {
              break label961;
            }
            break label825;
          } while (k > 32);
          if ((k == 32) || (k == 10) || (k == 13) || (k == 9) || (k == 12)) {
            break label937;
          }
        } while (k != 8);
        break label937;
        paramMap = paramObject;
        break label1636;
        break label1636;
        paramMap = null;
        break label1636;
        j = 1;
        break label2016;
        if ((k >= 48) && (k <= 57)) {
          break label2253;
        }
        if (k != 45) {
          break label2274;
        }
        break label2253;
        k = 0;
        break label2377;
        if (k != 16) {
          break label2520;
        }
        break label142;
        localObject3 = null;
        break label2727;
      }
    }
  }
  
  public void parseObject(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    Object localObject1 = this.config.getDeserializer(localClass);
    if ((localObject1 instanceof JavaBeanDeserializer)) {}
    for (JavaBeanDeserializer localJavaBeanDeserializer = (JavaBeanDeserializer)localObject1;; localJavaBeanDeserializer = null)
    {
      int i = this.lexer.token;
      if ((i != 12) && (i != 16)) {
        throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i));
      }
      while (this.lexer.token == 16)
      {
        localObject1 = this.lexer.scanSymbol(this.symbolTable);
        if (localObject1 == null) {
          if (this.lexer.token == 13)
          {
            this.lexer.nextToken(16);
            return;
          }
        }
      }
      if (localJavaBeanDeserializer != null) {}
      for (FieldDeserializer localFieldDeserializer = localJavaBeanDeserializer.getFieldDeserializer((String)localObject1);; localFieldDeserializer = null)
      {
        if (localFieldDeserializer == null)
        {
          if ((this.lexer.features & Feature.IgnoreNotMatch.mask) == 0) {
            throw new JSONException("setter not found, class " + localClass.getName() + ", property " + (String)localObject1);
          }
          this.lexer.nextTokenWithChar(':');
          parse();
          if (this.lexer.token != 13) {
            break;
          }
          this.lexer.nextToken();
          return;
        }
        Object localObject2 = localFieldDeserializer.fieldInfo.fieldClass;
        localObject1 = localFieldDeserializer.fieldInfo.fieldType;
        if (localObject2 == Integer.TYPE)
        {
          this.lexer.nextTokenWithChar(':');
          localObject1 = IntegerCodec.instance.deserialze(this, (Type)localObject1, null);
        }
        for (;;)
        {
          localFieldDeserializer.setValue(paramObject, localObject1);
          if ((this.lexer.token == 16) || (this.lexer.token != 13)) {
            break;
          }
          this.lexer.nextToken(16);
          return;
          if (localObject2 == String.class)
          {
            this.lexer.nextTokenWithChar(':');
            localObject1 = parseString();
          }
          else if (localObject2 == Long.TYPE)
          {
            this.lexer.nextTokenWithChar(':');
            localObject1 = IntegerCodec.instance.deserialze(this, (Type)localObject1, null);
          }
          else
          {
            localObject2 = this.config.getDeserializer((Class)localObject2, (Type)localObject1);
            this.lexer.nextTokenWithChar(':');
            localObject1 = ((ObjectDeserializer)localObject2).deserialze(this, (Type)localObject1, null);
          }
        }
      }
    }
  }
  
  public String parseString()
  {
    char c = '\032';
    int i = this.lexer.token;
    if (i == 4)
    {
      localObject = this.lexer.stringVal();
      JSONLexer localJSONLexer;
      if (this.lexer.ch == ',')
      {
        localJSONLexer = this.lexer;
        i = localJSONLexer.bp + 1;
        localJSONLexer.bp = i;
        localJSONLexer = this.lexer;
        if (i >= this.lexer.len)
        {
          localJSONLexer.ch = c;
          this.lexer.token = 16;
        }
      }
      for (;;)
      {
        return localObject;
        c = this.lexer.text.charAt(i);
        break;
        if (this.lexer.ch == ']')
        {
          localJSONLexer = this.lexer;
          i = localJSONLexer.bp + 1;
          localJSONLexer.bp = i;
          localJSONLexer = this.lexer;
          if (i >= this.lexer.len) {}
          for (;;)
          {
            localJSONLexer.ch = c;
            this.lexer.token = 15;
            break;
            c = this.lexer.text.charAt(i);
          }
        }
        if (this.lexer.ch == '}')
        {
          localJSONLexer = this.lexer;
          i = localJSONLexer.bp + 1;
          localJSONLexer.bp = i;
          localJSONLexer = this.lexer;
          if (i >= this.lexer.len) {}
          for (;;)
          {
            localJSONLexer.ch = c;
            this.lexer.token = 13;
            break;
            c = this.lexer.text.charAt(i);
          }
        }
        this.lexer.nextToken();
      }
    }
    if (i == 2)
    {
      localObject = this.lexer.numberString();
      this.lexer.nextToken(16);
      return localObject;
    }
    Object localObject = parse();
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  protected void popContext()
  {
    this.contex = this.contex.parent;
    this.contextArray[(this.contextArrayIndex - 1)] = null;
    this.contextArrayIndex -= 1;
  }
  
  protected ParseContext setContext(ParseContext paramParseContext, Object paramObject1, Object paramObject2)
  {
    if (this.lexer.disableCircularReferenceDetect) {
      return null;
    }
    this.contex = new ParseContext(paramParseContext, paramObject1, paramObject2);
    int i = this.contextArrayIndex;
    this.contextArrayIndex = (i + 1);
    if (this.contextArray == null) {
      this.contextArray = new ParseContext[8];
    }
    for (;;)
    {
      this.contextArray[i] = this.contex;
      return this.contex;
      if (i >= this.contextArray.length)
      {
        paramParseContext = new ParseContext[this.contextArray.length * 3 / 2];
        System.arraycopy(this.contextArray, 0, paramParseContext, 0, this.contextArray.length);
        this.contextArray = paramParseContext;
      }
    }
  }
  
  public void setContext(ParseContext paramParseContext)
  {
    if (this.lexer.disableCircularReferenceDetect) {
      return;
    }
    this.contex = paramParseContext;
  }
  
  public void setDateFomrat(DateFormat paramDateFormat)
  {
    this.dateFormat = paramDateFormat;
  }
  
  public void setDateFormat(String paramString)
  {
    this.dateFormatPattern = paramString;
    this.dateFormat = null;
  }
  
  public static class ResolveTask
  {
    private final ParseContext context;
    public FieldDeserializer fieldDeserializer;
    public ParseContext ownerContext;
    private final String referenceValue;
    
    public ResolveTask(ParseContext paramParseContext, String paramString)
    {
      this.context = paramParseContext;
      this.referenceValue = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.DefaultJSONParser
 * JD-Core Version:    0.7.0.1
 */