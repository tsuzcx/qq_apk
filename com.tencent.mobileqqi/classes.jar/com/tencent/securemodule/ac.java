package com.tencent.securemodule;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.qq.jce.wup.UniPacket;
import com.tencent.securemodule.jni.SecureEngine;
import com.tencent.securemodule.jni.TccCryptor;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicReference;

public final class ac
{
  public static ac a;
  public ab b;
  private Context c;
  
  public ac() {}
  
  public ac(Context paramContext)
  {
    this.c = paramContext;
    this.b = new ab(paramContext);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Notification localNotification = new Notification();
    localNotification.icon = paramInt;
    localNotification.when = System.currentTimeMillis();
    localNotification.flags = 16;
    localNotification.defaults = 4;
    localNotification.tickerText = paramString1;
    localNotification.setLatestEventInfo(paramContext, paramString2, paramString3, PendingIntent.getActivity(paramContext, 0, new Intent(), 134217728));
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    paramContext.cancel(1);
    paramContext.notify(1, localNotification);
    paramContext.cancel(1);
  }
  
  public final int a(int paramInt, UniPacket paramUniPacket1, UniPacket paramUniPacket2)
  {
    paramUniPacket1.setRequestId(paramInt);
    paramUniPacket1.setServantName(ab.a(paramInt));
    paramUniPacket1.setFuncName(ab.b(paramInt));
    paramUniPacket1.setEncodeName("UTF-8");
    paramUniPacket2.setEncodeName("UTF-8");
    return this.b.c();
  }
  
  public final int a(UniPacket paramUniPacket1, UniPacket paramUniPacket2)
  {
    int i;
    try
    {
      paramUniPacket1 = paramUniPacket1.encode();
      Object localObject = TccCryptor.encrypt(this.c, paramUniPacket1, null);
      paramUniPacket1 = new aa(this.c);
      i = paramUniPacket1.a(this.c, "http://pmir.3g.qq.com", (byte[])localObject);
      if (i != 0) {
        return i;
      }
      localObject = new AtomicReference();
      int j = paramUniPacket1.a((AtomicReference)localObject);
      i = j;
      if (j == 0)
      {
        paramUniPacket1 = (byte[])((AtomicReference)localObject).get();
        if ((paramUniPacket1 != null) && (paramUniPacket1.length > 0)) {
          paramUniPacket2.decode(TccCryptor.decrypt(this.c, paramUniPacket1, null));
        }
        return 0;
      }
    }
    catch (IllegalArgumentException paramUniPacket1)
    {
      paramUniPacket1.printStackTrace();
      return -6057;
    }
    catch (Exception paramUniPacket1)
    {
      i = -6000;
      paramUniPacket1.printStackTrace();
    }
    return i;
  }
  
  public static final class a
  {
    String a;
    String b;
    
    public a() {}
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public static long a(r paramr)
    {
      long l1 = 0L;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramr.a());
      localStringBuffer.append("&");
      localStringBuffer.append(paramr.c());
      localStringBuffer.append("&");
      localStringBuffer.append(paramr.g());
      paramr = b(localStringBuffer.toString().getBytes());
      long l2 = l1;
      int i;
      if (paramr != null) {
        i = 0;
      }
      for (;;)
      {
        if (i >= 8)
        {
          l2 = l1;
          return l2;
        }
        l2 = paramr[(i + 8)] & 0xFF;
        i += 1;
        l1 = l2 + (l1 << 8);
      }
    }
    
    public static String a(byte[] paramArrayOfByte)
    {
      StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfByte.length) {
          return localStringBuffer.toString();
        }
        String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        if (str.length() < 2) {
          localStringBuffer.append(0);
        }
        localStringBuffer.append(str.toUpperCase());
        i += 1;
      }
    }
    
    private static boolean a(Context paramContext)
    {
      paramContext = SecureEngine.b(paramContext);
      if (paramContext != null)
      {
        int i = paramContext.indexOf("version=");
        if (i != -1) {
          try
          {
            i = Integer.parseInt(paramContext.substring(i + 8, i + 13).replace(".", "")) / 10;
            if (i == 21) {
              return true;
            }
          }
          catch (Exception paramContext) {}
        }
      }
      return false;
    }
    
    public static boolean a(Context paramContext, String paramString)
    {
      String str1 = paramContext.getFilesDir().getAbsolutePath();
      String str2 = str1 + "/lib" + paramString + ".so";
      if (new File(str2).exists()) {}
      for (;;)
      {
        try
        {
          System.load(str2);
          j = 1;
          i = j;
          if (j != 0) {}
        }
        catch (Throwable localThrowable2) {}
        try
        {
          System.load(str1.replaceFirst("/files", "/lib") + "/lib" + paramString + ".so");
          i = 1;
        }
        catch (Throwable localThrowable1)
        {
          i = j;
          continue;
        }
        j = i;
        if (i == 0) {}
        try
        {
          System.loadLibrary(paramString);
          j = 1;
        }
        catch (Throwable paramString)
        {
          j = i;
          continue;
        }
        if ((j == 0) || (!a(paramContext))) {
          break;
        }
        return true;
        j = 0;
      }
      return false;
    }
    
    public static byte[] a(String paramString)
    {
      int j = paramString.length() / 2;
      byte[] arrayOfByte = new byte[j];
      paramString = paramString.toCharArray();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return arrayOfByte;
        }
        int k = i << 1;
        int m = (byte)"0123456789ABCDEF".indexOf(paramString[k]);
        arrayOfByte[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(paramString[(k + 1)]) | m << 4));
        i += 1;
      }
    }
    
    public static byte[] b(byte[] paramArrayOfByte)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramArrayOfByte);
        paramArrayOfByte = localMessageDigest.digest();
        return paramArrayOfByte;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.ac
 * JD-Core Version:    0.7.0.1
 */