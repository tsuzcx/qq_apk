package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;

public final class d
  extends c
{
  private static HashMap<String, byte[]> f = null;
  private static HashMap<String, HashMap<String, byte[]>> g = null;
  private f e = new f();
  
  public d()
  {
    this.e.a = 2;
  }
  
  public final void a(int paramInt)
  {
    this.e.b = 1;
  }
  
  public final <T> void a(String paramString, T paramT)
  {
    if (paramString.startsWith(".")) {
      throw new IllegalArgumentException("put name can not startwith . , now is " + paramString);
    }
    super.a(paramString, paramT);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new i(paramArrayOfByte, 4);
      paramArrayOfByte.a(this.b);
      this.e.a(paramArrayOfByte);
      HashMap localHashMap;
      if (this.e.a == 3)
      {
        paramArrayOfByte = new i(this.e.e);
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
      paramArrayOfByte = new i(this.e.e);
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
    Object localObject = new j(0);
    ((j)localObject).a(this.b);
    if (this.e.a == 2) {
      ((j)localObject).a(this.a, 0);
    }
    for (;;)
    {
      this.e.e = l.a(((j)localObject).a());
      localObject = new j(0);
      ((j)localObject).a(this.b);
      this.e.a((j)localObject);
      localObject = l.a(((j)localObject).a());
      int i = localObject.length;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
      localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
      return localByteBuffer.array();
      ((j)localObject).a(this.d, 0);
    }
  }
  
  public final void b(String paramString)
  {
    this.e.c = paramString;
  }
  
  public final void c(String paramString)
  {
    this.e.d = paramString;
  }
  
  public final void d()
  {
    super.d();
    this.e.a = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.d
 * JD-Core Version:    0.7.0.1
 */