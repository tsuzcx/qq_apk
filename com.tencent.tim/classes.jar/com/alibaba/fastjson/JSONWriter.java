package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JSONWriter
  implements Closeable, Flushable
{
  private JSONStreamContext context;
  private JSONSerializer serializer;
  private SerializeWriter writer;
  
  public JSONWriter(Writer paramWriter)
  {
    this.writer = new SerializeWriter(paramWriter);
    this.serializer = new JSONSerializer(this.writer);
  }
  
  private void afterWriter()
  {
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
      i = 1002;
      continue;
      i = 1005;
      continue;
      i = -1;
    }
  }
  
  private void beforeWrite()
  {
    if (this.context == null) {
      return;
    }
    switch (this.context.state)
    {
    case 1001: 
    case 1004: 
    default: 
      return;
    case 1002: 
      this.writer.write(58);
      return;
    case 1003: 
      this.writer.write(44);
      return;
    }
    this.writer.write(44);
  }
  
  private void beginStructure()
  {
    int i = this.context.state;
    switch (this.context.state)
    {
    case 1003: 
    default: 
      throw new JSONException("illegal state : " + i);
    case 1002: 
      this.writer.write(58);
    case 1001: 
    case 1004: 
      return;
    }
    this.writer.write(44);
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
    case 1003: 
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
      i = -1;
      continue;
      i = 1002;
    }
  }
  
  public void close()
    throws IOException
  {
    this.writer.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    this.writer.config(paramSerializerFeature, paramBoolean);
  }
  
  public void endArray()
  {
    this.writer.write(93);
    endStructure();
  }
  
  public void endObject()
  {
    this.writer.write(125);
    endStructure();
  }
  
  public void flush()
    throws IOException
  {
    this.writer.flush();
  }
  
  public void startArray()
  {
    if (this.context != null) {
      beginStructure();
    }
    this.context = new JSONStreamContext(this.context, 1004);
    this.writer.write(91);
  }
  
  public void startObject()
  {
    if (this.context != null) {
      beginStructure();
    }
    this.context = new JSONStreamContext(this.context, 1001);
    this.writer.write(123);
  }
  
  public void writeKey(String paramString)
  {
    writeObject(paramString);
  }
  
  public void writeObject(Object paramObject)
  {
    beforeWrite();
    this.serializer.write(paramObject);
    afterWriter();
  }
  
  public void writeObject(String paramString)
  {
    beforeWrite();
    this.serializer.write(paramString);
    afterWriter();
  }
  
  public void writeValue(Object paramObject)
  {
    writeObject(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.JSONWriter
 * JD-Core Version:    0.7.0.1
 */