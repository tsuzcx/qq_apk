package com.tencent.qphone.base.util.a.b;

import android.util.Log;
import java.nio.charset.Charset;

public class e
  implements c
{
  public static final Charset a = Charset.forName("UTF-8");
  private static final String b = "XOREncryption";
  private static String e;
  private static byte[] f;
  private final boolean d;
  private int g = 0;
  
  static
  {
    try
    {
      e = com.tencent.qphone.base.util.a.a.c.a();
      f = e.getBytes(a);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("XOREncryption", "init error. ", localThrowable);
    }
  }
  
  public e(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public static String b()
  {
    return e;
  }
  
  public d a(d paramd)
  {
    if (this.d)
    {
      int i = paramd.c;
      while (i < paramd.c + paramd.d)
      {
        if (this.g == f.length) {
          this.g = 0;
        }
        byte[] arrayOfByte1 = paramd.a;
        int j = paramd.a[i];
        byte[] arrayOfByte2 = f;
        int k = this.g;
        this.g = (k + 1);
        arrayOfByte1[i] = ((byte)(j ^ arrayOfByte2[k]));
        i += 1;
      }
    }
    return paramd;
  }
  
  public void a()
  {
    this.g = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.b.e
 * JD-Core Version:    0.7.0.1
 */