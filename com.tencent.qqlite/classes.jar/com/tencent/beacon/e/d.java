package com.tencent.beacon.e;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class d
{
  private static HashMap<String, byte[]> e = null;
  private HashMap<String, byte[]> a = new HashMap();
  private a b = new a();
  private String c = "GBK";
  private e d = new e();
  
  public final void a(int paramInt)
  {
    this.d.b = 1;
  }
  
  public final void a(String paramString)
  {
    this.d.d = paramString;
  }
  
  public final <T> void a(String paramString, T paramT)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("put key can not is null");
    }
    if (paramT == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramT instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new b();
    ((b)localObject).a(this.c);
    ((b)localObject).a(paramT, 0);
    paramT = ((b)localObject).a();
    localObject = new byte[paramT.position()];
    System.arraycopy(paramT.array(), 0, localObject, 0, localObject.length);
    this.a.put(paramString, localObject);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new a(paramArrayOfByte, 4);
      paramArrayOfByte.a(this.c);
      this.d.a(paramArrayOfByte);
      paramArrayOfByte = new a(this.d.e);
      paramArrayOfByte.a(this.c);
      if (e == null)
      {
        HashMap localHashMap = new HashMap();
        e = localHashMap;
        localHashMap.put("", new byte[0]);
      }
      this.a = paramArrayOfByte.a(e, 0, false);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a()
  {
    Object localObject2 = new b(0);
    ((b)localObject2).a(this.c);
    ((b)localObject2).a(this.a, 0);
    this.d.a = 3;
    Object localObject1 = this.d;
    localObject2 = ((b)localObject2).a();
    byte[] arrayOfByte = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, arrayOfByte, 0, arrayOfByte.length);
    ((e)localObject1).e = arrayOfByte;
    localObject1 = new b(0);
    ((b)localObject1).a(this.c);
    this.d.a((b)localObject1);
    localObject2 = ((b)localObject1).a();
    localObject1 = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject1, 0, localObject1.length);
    int i = localObject1.length;
    localObject2 = ByteBuffer.allocate(i + 4);
    ((ByteBuffer)localObject2).putInt(i + 4).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public final <T> T b(String paramString, T paramT)
    throws Exception
  {
    if (!this.a.containsKey(paramString)) {
      return null;
    }
    paramString = (byte[])this.a.get(paramString);
    try
    {
      this.b.a(paramString);
      this.b.a(this.c);
      paramString = this.b.a(paramT, 0, true);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
  
  public final void b(String paramString)
  {
    this.d.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.e.d
 * JD-Core Version:    0.7.0.1
 */