package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecurityUtile
{
  private static int jdField_a_of_type_Int = 4;
  private static final String jdField_a_of_type_JavaLangString = "kc";
  private static byte[] jdField_a_of_type_ArrayOfByte;
  private static char[] jdField_a_of_type_ArrayOfChar = { 0, 1, 0, 1 };
  private static volatile int b = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[] { 0, 1, 0, 1 };
  }
  
  private static String a(Context paramContext)
  {
    paramContext = paramContext.openFileInput("kc");
    byte[] arrayOfByte = new byte[paramContext.available()];
    paramContext.read(arrayOfByte);
    paramContext.close();
    return new String(arrayOfByte, "UTF-8");
  }
  
  public static String a(String paramString)
  {
    return c(paramString);
  }
  
  public static void a(Context paramContext)
  {
    localObject3 = null;
    localObject1 = null;
    String str;
    label69:
    try
    {
      boolean bool = a(paramContext);
      if (!bool) {}
    }
    finally {}
    try
    {
      str = a(paramContext);
      if (str != null)
      {
        localObject1 = str;
        localObject3 = str;
        if (str.length() >= jdField_a_of_type_ArrayOfChar.length) {}
      }
      else
      {
        localObject3 = str;
        Thread.sleep(200L);
        localObject3 = str;
        localObject1 = a(paramContext);
      }
    }
    catch (Exception localException1)
    {
      localObject2 = localObject3;
      break label69;
      break label187;
      break label212;
    }
    if (localObject1 != null)
    {
      localObject3 = localObject1;
      if (((String)localObject1).length() >= jdField_a_of_type_ArrayOfChar.length) {}
    }
    else
    {
      localObject1 = paramContext.getSharedPreferences("QQLite", 0).getString("security_key", null);
      if (localObject1 != null)
      {
        int i = ((String)localObject1).length();
        int j = jdField_a_of_type_ArrayOfChar.length;
        if (i >= j) {
          break label267;
        }
      }
    }
    try
    {
      localObject3 = ((TelephonyManager)paramContext.getApplicationContext().getSystemService("phone")).getDeviceId();
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (((String)localObject3).length() >= jdField_a_of_type_ArrayOfChar.length) {
          break label264;
        }
      }
      localObject1 = localObject3;
      localObject3 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        label187:
        Object localObject2;
        Object localObject4 = localObject2;
      }
    }
    if (localObject3 != null)
    {
      localObject1 = localObject3;
      if (((String)localObject3).length() >= jdField_a_of_type_ArrayOfChar.length) {}
    }
    else
    {
      localObject1 = "361910168";
    }
    try
    {
      label212:
      a(paramContext, (String)localObject1);
      localObject3 = localObject1;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        localObject3 = localObject1;
      }
    }
    jdField_a_of_type_ArrayOfChar = ((String)localObject3).toCharArray();
    b = jdField_a_of_type_ArrayOfChar.length;
  }
  
  private static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.openFileOutput("kc", 0);
    paramContext.write(paramString.getBytes("UTF-8"));
    paramContext.close();
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramArrayOfByte != null)
    {
      if (b == 0) {
        a(BaseApplicationImpl.getContext());
      }
      int i = 0;
      while (i < paramInt2)
      {
        paramArrayOfByte[(i + paramInt1)] = ((byte)(paramArrayOfByte[(i + paramInt1)] ^ jdField_a_of_type_ArrayOfChar[((int)((i + paramLong) % b))]));
        i += 1;
      }
    }
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramArrayOfByte == null) || (paramLong >= paramInt3)) {
      return;
    }
    paramInt3 = (int)(paramInt3 - paramLong);
    if (paramInt3 > paramInt2) {}
    for (;;)
    {
      paramInt3 = 0;
      while (paramInt3 < paramInt2)
      {
        paramArrayOfByte[(paramInt3 + paramInt1)] = ((byte)(paramArrayOfByte[(paramInt3 + paramInt1)] ^ jdField_a_of_type_ArrayOfByte[((int)((paramInt3 + paramLong) % jdField_a_of_type_Int))]));
        paramInt3 += 1;
      }
      break;
      paramInt2 = paramInt3;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    return (paramContext.getFileStreamPath("kc") != null) && (paramContext.getFileStreamPath("kc").exists());
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (b == 0) {
        a(BaseApplicationImpl.getContext());
      }
      int j = paramArrayOfByte.length;
      arrayOfByte = new byte[j];
      int i = 0;
      while (i < j)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ jdField_a_of_type_ArrayOfChar[(i % b)]));
        i += 1;
      }
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (b == 0) {
        a(BaseApplicationImpl.getContext());
      }
      int j = paramArrayOfByte.length;
      arrayOfByte = new byte[j];
      int i = 0;
      while (i < j)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ jdField_a_of_type_ArrayOfChar[((i + paramInt) % b)]));
        i += 1;
      }
    }
    return arrayOfByte;
  }
  
  public static String b(String paramString)
  {
    return c(paramString);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ jdField_a_of_type_ArrayOfByte[(i % jdField_a_of_type_Int)]));
        i += 1;
      }
    }
    return paramArrayOfByte;
  }
  
  private static String c(String paramString)
  {
    int i = 0;
    int j = 0;
    if (paramString == null) {
      return null;
    }
    if (b == 0) {
      a(BaseApplicationImpl.getContext());
    }
    paramString = paramString.toCharArray();
    char[] arrayOfChar = new char[paramString.length];
    if (b >= paramString.length)
    {
      i = j;
      while (i < paramString.length)
      {
        arrayOfChar[i] = ((char)(paramString[i] ^ jdField_a_of_type_ArrayOfChar[i]));
        i += 1;
      }
    }
    while (i < paramString.length)
    {
      arrayOfChar[i] = ((char)(paramString[i] ^ jdField_a_of_type_ArrayOfChar[(i % b)]));
      i += 1;
    }
    if (arrayOfChar.length == 0) {
      return "";
    }
    return new String(arrayOfChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecurityUtile
 * JD-Core Version:    0.7.0.1
 */