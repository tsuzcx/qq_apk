package com.tencent.analysis.a;

import java.nio.ByteBuffer;
import java.util.Map;

public enum b
{
  private short X = 0;
  private final f Y;
  
  static
  {
    E = new b("_105", 5, 105);
    f = new b("_106", 6, 106);
    g = new b("_107", 7, 107);
    h = new b("_108", 8, 108);
    i = new b("_109", 9, 109);
    j = new b("_110", 10, 110);
    k = new b("_111", 11, 111);
    l = new b("_112", 12, 112);
    m = new b("_113", 13, 113);
    n = new b("_114", 14, 114);
    o = new b("_115", 15, 115);
    p = new b("_116", 16, 116);
    q = new b("_117", 17, 117);
    r = new b("_118", 18, 118);
    s = new b("_119", 19, 119);
    t = new b("_120", 20, 120);
    u = new b("_121", 21, 121);
    v = new b("_122", 22, 122);
    w = new b("_123", 23, 123);
    x = new b("_124", 24, 124);
    F = new b("_125", 25, 125);
    G = new b("_126", 26, 126);
    H = new b("_127", 27, 127);
    I = new b("_128", 28, 128);
    J = new b("_129", 29, 129);
    y = new b("_130", 30, 130);
    K = new b("_131", 31, 131);
    L = new b("_132", 32, 132);
    M = new b("_133", 33, 133);
    N = new b("_134", 34, 134);
    O = new b("_135", 35, 135);
    P = new b("_136", 36, 136);
    Q = new b("_137", 37, 137);
    R = new b("_138", 38, 138);
    S = new b("_139", 39, 139);
    T = new b("_140", 40, 140);
    U = new b("_141", 41, 141);
    z = new b("_142", 42, 142);
    A = new b("_143", 43, 143);
    B = new c("_400", 44, 400, f.b);
    C = new b("_401", 45, 401, f.b);
    V = new d("_402", 46, 402, f.b);
    W = new e("_403", 47, 403, f.b);
  }
  
  private b(int paramInt)
  {
    this.X = ((short)paramInt);
    this.Y = f.a;
  }
  
  private b(int paramInt, f paramf)
  {
    this.X = ((short)paramInt);
    this.Y = paramf;
  }
  
  public static final void a(ByteBuffer paramByteBuffer, Map paramMap)
  {
    int i1 = paramByteBuffer.getShort();
    Object localObject = new StringBuilder("_");
    ((StringBuilder)localObject).append(i1 & 0xFFFF);
    localObject = valueOf(((StringBuilder)localObject).toString());
    paramMap.put(localObject, ((b)localObject).a(paramByteBuffer));
  }
  
  protected String a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.getShort() & 0xFFFF];
    paramByteBuffer.get(arrayOfByte);
    return new String(arrayOfByte, "UTF-8");
  }
  
  public final short a()
  {
    return this.X;
  }
  
  public byte[] a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = paramString.getBytes("UTF-8");
      byte[] arrayOfByte = new byte[paramString.length + 4];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer.putShort(this.X);
      localByteBuffer.putShort((short)paramString.length);
      localByteBuffer.put(paramString);
      return arrayOfByte;
    }
    return null;
  }
  
  public final f b()
  {
    return this.Y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a.b
 * JD-Core Version:    0.7.0.1
 */