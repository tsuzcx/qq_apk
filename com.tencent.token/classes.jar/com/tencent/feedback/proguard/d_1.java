package com.tencent.feedback.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;

public final class d
  extends c
{
  private static HashMap f = null;
  private static HashMap g = null;
  private f e = new f();
  
  public d()
  {
    this.e.a = 2;
  }
  
  public final void a(int paramInt)
  {
    this.e.b = 1;
  }
  
  public final void a(String paramString, Object paramObject)
  {
    if (paramString.startsWith(".")) {
      throw new IllegalArgumentException("put name can not startwith . , now is " + paramString);
    }
    super.a(paramString, paramObject);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new h(paramArrayOfByte, 4);
      paramArrayOfByte.a(this.b);
      this.e.a(paramArrayOfByte);
      HashMap localHashMap;
      if (this.e.a == 3)
      {
        paramArrayOfByte = new h(this.e.e);
        paramArrayOfByte.a(this.b);
        if (f == null)
        {
          localHashMap = new HashMap();
          f = localHashMap;
          localHashMap.put("", new byte[0]);
        }
        this.d = paramArrayOfByte.a(f, 0, false);
        return;
      }
      paramArrayOfByte = new h(this.e.e);
      paramArrayOfByte.a(this.b);
      if (g == null)
      {
        g = new HashMap();
        localHashMap = new HashMap();
        localHashMap.put("", new byte[0]);
        g.put("", localHashMap);
      }
      this.a = paramArrayOfByte.a(g, 0, false);
      new HashMap();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a()
  {
    if (this.e.a == 2)
    {
      if (this.e.c.equals("")) {
        throw new IllegalArgumentException("servantName can not is null");
      }
      if (this.e.d.equals("")) {
        throw new IllegalArgumentException("funcName can not is null");
      }
    }
    else
    {
      if (this.e.c == null) {
        this.e.c = "";
      }
      if (this.e.d == null) {
        this.e.d = "";
      }
    }
    Object localObject = new i(0);
    ((i)localObject).a(this.b);
    if (this.e.a == 2) {
      ((i)localObject).a(this.a, 0);
    }
    for (;;)
    {
      this.e.e = k.a(((i)localObject).a());
      localObject = new i(0);
      ((i)localObject).a(this.b);
      this.e.a((i)localObject);
      localObject = k.a(((i)localObject).a());
      int i = localObject.length;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
      localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
      return localByteBuffer.array();
      ((i)localObject).a(this.d, 0);
    }
  }
  
  public final void c(String paramString)
  {
    this.e.c = paramString;
  }
  
  public final void d(String paramString)
  {
    this.e.d = paramString;
  }
  
  public final void e()
  {
    super.e();
    this.e.a = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.d
 * JD-Core Version:    0.7.0.1
 */