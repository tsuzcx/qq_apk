package com.tencent.qmsp.sdk.b;

import com.tencent.qmsp.sdk.c.f;
import com.tencent.qmsp.sdk.f.g;
import com.tencent.qmsp.sdk.f.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class d
{
  private static byte[][] a = { { 16, 99, -74, 82, 99, 26, 112, -8, 43, 100 }, { 8, 127, -87, 73, 34, 55, 118, -78, 113, 62, -29, 0, 102, 56, 120, -16, 53, 113, -89, 73, 44, 55, 114, -90, 101, 93, -128, 105, 11, 123, 34, -77, 117, 43, -13, 119, 39, 53, 115, -14, 50, 99, -13, 110, 26, 96, 55, -39, 44, 119, -106, 88, 58, 114 }, { 20, 96, -3, 68, 33, 44, 121 } };
  
  public static String a(int paramInt)
  {
    return k.a(a[paramInt]);
  }
  
  public static void a(b paramb)
  {
    str = paramb.a;
    Object localObject1 = paramb.d;
    Object localObject2 = paramb.c;
    paramb = new c(paramb);
    try
    {
      Object localObject3 = (HttpURLConnection)new URL(str).openConnection();
      if (!(localObject3 instanceof HttpURLConnection)) {
        return;
      }
      ((HttpURLConnection)localObject3).setConnectTimeout(3000);
      ((HttpURLConnection)localObject3).setRequestProperty(a(0), a(1));
      localObject3 = ((HttpURLConnection)localObject3).getInputStream();
      byte[] arrayOfByte = a((InputStream)localObject3);
      localObject2 = new File((String)localObject2);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      localObject1 = new FileOutputStream(new File(localObject2 + File.separator + (String)localObject1));
      ((FileOutputStream)localObject1).write(arrayOfByte);
      ((FileOutputStream)localObject1).close();
      if (localObject3 != null) {
        ((InputStream)localObject3).close();
      }
      paramb.a = 0;
      localObject1 = a(2);
      localObject2 = new StringBuilder();
      localObject2 = ((StringBuilder)localObject2).append("dwl:").append(str);
      g.c((String)localObject1, 0, "  ok");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramb.a = 1;
        g.c(a(2), 0, "dwl:" + str + "  fail");
      }
    }
    f.i().d().a(paramb);
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.b.d
 * JD-Core Version:    0.7.0.1
 */