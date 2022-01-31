package com.tencent.token;

public final class ar
{
  public static void a(an paraman, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2) || (paramArrayOfByte[0] != 2) || (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3)) {
      return;
    }
    paraman.g = ap.a(paramArrayOfByte, 1);
    paraman.h = ((short)(((paramArrayOfByte[5] & 0xFF) << 8) + ((paramArrayOfByte[6] & 0xFF) << 0)));
    paraman.i = paramArrayOfByte[7];
    paraman.j = ((short)(((paramArrayOfByte[8] & 0xFF) << 8) + ((paramArrayOfByte[9] & 0xFF) << 0)));
    paraman.k = ((short)(((paramArrayOfByte[10] & 0xFF) << 8) + ((paramArrayOfByte[11] & 0xFF) << 0)));
    paraman.l = ((int)ap.a(paramArrayOfByte, 12));
    paraman.m = ((int)ap.a(paramArrayOfByte, 16));
    paraman.n = ((short)(((paramArrayOfByte[20] & 0xFF) << 8) + ((paramArrayOfByte[21] & 0xFF) << 0)));
    paraman.o = ((short)(((paramArrayOfByte[22] & 0xFF) << 8) + ((paramArrayOfByte[23] & 0xFF) << 0)));
    paraman.p = ((short)(((paramArrayOfByte[24] & 0xFF) << 8) + ((paramArrayOfByte[25] & 0xFF) << 0)));
    paraman.q = ((short)(((paramArrayOfByte[26] & 0xFF) << 8) + ((paramArrayOfByte[27] & 0xFF) << 0)));
    paraman.r = ap.a(paramArrayOfByte, 28, 64);
    paraman.b = ((int)ap.a(paramArrayOfByte, 92));
    paraman.c = ap.a(paramArrayOfByte, 96, 256);
    paraman.d = ((int)ap.a(paramArrayOfByte, 352));
    paraman.e = ((short)(((paramArrayOfByte[356] & 0xFF) << 8) + ((paramArrayOfByte[357] & 0xFF) << 0)));
    System.arraycopy(paramArrayOfByte, 358, paraman.t, 0, paraman.t.length);
    int j = paraman.t.length + 358;
    int k = paramArrayOfByte.length - 1 - paraman.s.length - j;
    int i = j;
    if (k > 0)
    {
      paraman.f = new byte[k];
      System.arraycopy(paramArrayOfByte, j, paraman.f, 0, paraman.f.length);
      i = j + paraman.f.length;
    }
    System.arraycopy(paramArrayOfByte, i, paraman.s, 0, paraman.s.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ar
 * JD-Core Version:    0.7.0.1
 */