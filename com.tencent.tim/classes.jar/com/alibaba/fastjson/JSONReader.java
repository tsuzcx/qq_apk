package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONReader
  implements Closeable
{
  private JSONStreamContext context;
  private final DefaultJSONParser parser;
  private Reader reader;
  
  public JSONReader(DefaultJSONParser paramDefaultJSONParser)
  {
    this.parser = paramDefaultJSONParser;
  }
  
  public JSONReader(JSONLexer paramJSONLexer)
  {
    this(new DefaultJSONParser(paramJSONLexer));
  }
  
  public JSONReader(Reader paramReader)
  {
    this(new JSONLexer(readAll(paramReader)));
    this.reader = paramReader;
  }
  
  private void endStructure()
  {
    this.context = this.context.parent;
    if (this.context == null) {
      return;
    }
    int i;
    switch (this.context.state)
    {
    default: 
      i = -1;
    }
    while (i != -1)
    {
      this.context.state = i;
      return;
      i = 1003;
      continue;
      i = 1005;
      continue;
      i = 1002;
    }
  }
  
  private void readAfter()
  {
    int i = 1002;
    int j = this.context.state;
    switch (j)
    {
    default: 
      throw new JSONException("illegal state : " + j);
    case 1002: 
      i = 1003;
    }
    for (;;)
    {
      if (i != -1) {
        this.context.state = i;
      }
      return;
      i = -1;
      continue;
      i = 1005;
    }
  }
  
  /* Error */
  static String readAll(Reader paramReader)
  {
    // Byte code:
    //   0: new 57	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: sipush 2048
    //   11: newarray char
    //   13: astore_3
    //   14: aload_0
    //   15: aload_3
    //   16: iconst_0
    //   17: aload_3
    //   18: arraylength
    //   19: invokevirtual 80	java/io/Reader:read	([CII)I
    //   22: istore_1
    //   23: iload_1
    //   24: ifge +8 -> 32
    //   27: aload_2
    //   28: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: areturn
    //   32: aload_2
    //   33: aload_3
    //   34: iconst_0
    //   35: iload_1
    //   36: invokevirtual 83	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: goto -26 -> 14
    //   43: astore_0
    //   44: new 55	com/alibaba/fastjson/JSONException
    //   47: dup
    //   48: ldc 85
    //   50: aload_0
    //   51: invokespecial 88	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramReader	Reader
    //   22	14	1	i	int
    //   7	26	2	localStringBuilder	java.lang.StringBuilder
    //   13	21	3	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   8	14	43	java/lang/Exception
    //   14	23	43	java/lang/Exception
    //   32	40	43	java/lang/Exception
  }
  
  private void readBefore()
  {
    int i = this.context.state;
    switch (i)
    {
    default: 
      throw new JSONException("illegal state : " + i);
    case 1002: 
      this.parser.accept(17);
    case 1001: 
    case 1004: 
      return;
    }
    this.parser.accept(16);
  }
  
  private void startStructure()
  {
    switch (this.context.state)
    {
    default: 
      throw new JSONException("illegal state : " + this.context.state);
    case 1002: 
      this.parser.accept(17);
    case 1001: 
    case 1004: 
      return;
    }
    this.parser.accept(16);
  }
  
  public void close()
  {
    this.parser.lexer.close();
    if (this.reader != null) {}
    try
    {
      this.reader.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new JSONException("closed reader error", localIOException);
    }
  }
  
  public void config(Feature paramFeature, boolean paramBoolean)
  {
    this.parser.config(paramFeature, paramBoolean);
  }
  
  public void endArray()
  {
    this.parser.accept(15);
    endStructure();
  }
  
  public void endObject()
  {
    this.parser.accept(13);
    endStructure();
  }
  
  public boolean hasNext()
  {
    if (this.context == null) {
      throw new JSONException("context is null");
    }
    int i = this.parser.lexer.token();
    int j = this.context.state;
    switch (j)
    {
    case 1002: 
    default: 
      throw new JSONException("illegal state : " + j);
    case 1004: 
    case 1005: 
      if (i == 15) {
        break;
      }
    }
    do
    {
      return true;
      return false;
    } while (i != 13);
    return false;
  }
  
  public int peek()
  {
    return this.parser.lexer.token();
  }
  
  public Integer readInteger()
  {
    Object localObject;
    if (this.context == null) {
      localObject = this.parser.parse();
    }
    for (;;)
    {
      return TypeUtils.castToInt(localObject);
      readBefore();
      localObject = this.parser.parse();
      readAfter();
    }
  }
  
  public Long readLong()
  {
    Object localObject;
    if (this.context == null) {
      localObject = this.parser.parse();
    }
    for (;;)
    {
      return TypeUtils.castToLong(localObject);
      readBefore();
      localObject = this.parser.parse();
      readAfter();
    }
  }
  
  public Object readObject()
  {
    if (this.context == null) {
      return this.parser.parse();
    }
    readBefore();
    Object localObject = this.parser.parse();
    readAfter();
    return localObject;
  }
  
  public <T> T readObject(TypeReference<T> paramTypeReference)
  {
    return readObject(paramTypeReference.type);
  }
  
  public <T> T readObject(Class<T> paramClass)
  {
    if (this.context == null) {
      return this.parser.parseObject(paramClass);
    }
    readBefore();
    paramClass = this.parser.parseObject(paramClass);
    readAfter();
    return paramClass;
  }
  
  public <T> T readObject(Type paramType)
  {
    if (this.context == null) {
      return this.parser.parseObject(paramType);
    }
    readBefore();
    paramType = this.parser.parseObject(paramType);
    readAfter();
    return paramType;
  }
  
  public Object readObject(Map paramMap)
  {
    if (this.context == null) {
      return this.parser.parseObject(paramMap);
    }
    readBefore();
    paramMap = this.parser.parseObject(paramMap);
    readAfter();
    return paramMap;
  }
  
  public void readObject(Object paramObject)
  {
    if (this.context == null)
    {
      this.parser.parseObject(paramObject);
      return;
    }
    readBefore();
    this.parser.parseObject(paramObject);
    readAfter();
  }
  
  public String readString()
  {
    Object localObject;
    if (this.context == null) {
      localObject = this.parser.parse();
    }
    for (;;)
    {
      return TypeUtils.castToString(localObject);
      readBefore();
      localObject = this.parser.parse();
      readAfter();
    }
  }
  
  public void startArray()
  {
    if (this.context == null) {}
    for (this.context = new JSONStreamContext(null, 1004);; this.context = new JSONStreamContext(this.context, 1004))
    {
      this.parser.accept(14);
      return;
      startStructure();
    }
  }
  
  public void startObject()
  {
    if (this.context == null) {}
    for (this.context = new JSONStreamContext(null, 1001);; this.context = new JSONStreamContext(this.context, 1001))
    {
      this.parser.accept(12);
      return;
      startStructure();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.JSONReader
 * JD-Core Version:    0.7.0.1
 */