package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class Response
  extends JceStruct
  implements Cloneable
{
  private static byte[] cache_body;
  private static RspHead cache_head;
  public byte[] body = null;
  public RspHead head = null;
  
  static
  {
    if (!Response.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public Response() {}
  
  public Response(RspHead paramRspHead, byte[] paramArrayOfByte)
  {
    this.head = paramRspHead;
    this.body = paramArrayOfByte;
  }
  
  public final String className()
  {
    return "jce.Response";
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.head, "head");
    paramStringBuilder.display(this.body, "body");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.head, true);
    paramStringBuilder.displaySimple(this.body, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Response)paramObject;
    } while ((!JceUtil.equals(this.head, paramObject.head)) || (!JceUtil.equals(this.body, paramObject.body)));
    return true;
  }
  
  public final String fullClassName()
  {
    return "com.tencent.tmassistantsdk.protocol.jce.Response";
  }
  
  public final byte[] getBody()
  {
    return this.body;
  }
  
  public final RspHead getHead()
  {
    return this.head;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_head == null) {
      cache_head = new RspHead();
    }
    this.head = ((RspHead)paramJceInputStream.read(cache_head, 0, true));
    if (cache_body == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_body = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.body = ((byte[])paramJceInputStream.read(cache_body, 1, true));
  }
  
  public final void setBody(byte[] paramArrayOfByte)
  {
    this.body = paramArrayOfByte;
  }
  
  public final void setHead(RspHead paramRspHead)
  {
    this.head = paramRspHead;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.head, 0);
    paramJceOutputStream.write(this.body, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.Response
 * JD-Core Version:    0.7.0.1
 */