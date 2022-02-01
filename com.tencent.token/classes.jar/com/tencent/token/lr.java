package com.tencent.token;

import com.tencent.halley.common.b.e;
import java.nio.ByteBuffer;
import java.util.HashMap;

public final class lr
{
  public static HashMap d;
  public HashMap a = new HashMap();
  public String b = "GBK";
  public e c = new e();
  private lp e = new lp();
  
  public final void a(String paramString)
  {
    this.c.d = paramString;
  }
  
  public final void a(String paramString, Object paramObject)
  {
    Object localObject = new lq();
    ((lq)localObject).b = this.b;
    ((lq)localObject).a(paramObject, 0);
    paramObject = ((lq)localObject).a;
    localObject = new byte[paramObject.position()];
    System.arraycopy(paramObject.array(), 0, localObject, 0, localObject.length);
    this.a.put(paramString, localObject);
  }
  
  public final byte[] a()
  {
    Object localObject2 = new lq(0);
    ((lq)localObject2).b = this.b;
    ((lq)localObject2).a(this.a, 0);
    Object localObject1 = this.c;
    ((e)localObject1).a = 3;
    localObject2 = ((lq)localObject2).a;
    byte[] arrayOfByte = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, arrayOfByte, 0, arrayOfByte.length);
    ((e)localObject1).e = arrayOfByte;
    localObject1 = new lq(0);
    ((lq)localObject1).b = this.b;
    this.c.a((lq)localObject1);
    localObject2 = ((lq)localObject1).a;
    localObject1 = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject1, 0, localObject1.length);
    int i = localObject1.length + 4;
    localObject2 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject2).putInt(i).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public final Object b(String paramString, Object paramObject)
  {
    if (!this.a.containsKey(paramString)) {
      return null;
    }
    paramString = (byte[])this.a.get(paramString);
    try
    {
      this.e.a = ByteBuffer.wrap(paramString);
      this.e.b = this.b;
      paramString = this.e.a(paramObject, 0, true);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
  
  public final void b(String paramString)
  {
    this.c.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lr
 * JD-Core Version:    0.7.0.1
 */