package com.tencent.qmsp.sdk.a;

import android.content.Context;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.k;
import java.io.File;

public class b
{
  private static final byte[] a = { 52, 125, -96, 80 };
  private static final byte[] b = { 107, 124, -70, 66, 61 };
  private static final byte[] c = { 107, 67, -107, 117, 97 };
  
  public static String a()
  {
    return QmspSDK.getContext().getDir(com.tencent.qmsp.sdk.c.b.a + k.a(a), 0).toString();
  }
  
  public static String b()
  {
    return a() + File.separator + k.a(b);
  }
  
  public static String c()
  {
    return a() + File.separator + k.a(c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */