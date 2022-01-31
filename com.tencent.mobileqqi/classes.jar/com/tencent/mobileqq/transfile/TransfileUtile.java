package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;

public class TransfileUtile
{
  public static final byte a = 0;
  public static final int a = 0;
  private static final String a = "TransfileUtile";
  public static final byte b = 1;
  public static final int b = 120;
  public static final byte c = 2;
  public static final int c = 160;
  public static final byte d = 3;
  public static final int d = 640;
  public static final byte e = 4;
  public static final int e = 960;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  public static final int k = 5;
  public static final int l = 6;
  public static final int m = 7;
  public static final int n = 8;
  public static final int o = 9;
  public static final int p = 65538;
  
  public static byte a(String paramString)
  {
    byte b2 = 0;
    int i1 = paramString.lastIndexOf(".");
    byte b1 = b2;
    if (i1 < paramString.length())
    {
      paramString = paramString.substring(i1 + 1).toLowerCase();
      if (!"bmp".equals(paramString)) {
        break label43;
      }
      b1 = 1;
    }
    label43:
    do
    {
      return b1;
      if ("gif".equals(paramString)) {
        return 2;
      }
      if (("jpg".equals(paramString)) || ("jpeg".equals(paramString))) {
        return 3;
      }
      b1 = b2;
    } while (!"png".equals(paramString));
    return 4;
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.length < 6)) {}
    do
    {
      return null;
      paramString = paramString[5];
      if (QLog.isColorLevel()) {
        QLog.d("TransfileUtile", 2, "getPicMD5ByMsgContent:" + paramString);
      }
      if (paramString.length() == 32) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TransfileUtile", 2, "getPicMD5ByMsgContent: error md5: length is not 32.");
    return null;
    return paramString;
  }
  
  @Deprecated
  public static String a(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('\026');
    localStringBuffer.append(paramString);
    localStringBuffer.append('|');
    localStringBuffer.append(paramLong);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt);
    localStringBuffer.append('|');
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localStringBuffer.append(paramInt);
      return localStringBuffer.toString();
    }
  }
  
  @Deprecated
  public static String a(String paramString1, long paramLong, int paramInt, boolean paramBoolean, String paramString2)
  {
    paramString1 = a(paramString1, paramLong, paramInt, paramBoolean);
    paramString1 = paramString1 + "|";
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return paramString1 + "null";
    }
    return paramString1 + paramString2;
  }
  
  public static String a(String paramString1, long paramLong, int paramInt, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = a(paramString1, paramLong, paramInt, paramBoolean);
    paramString1 = paramString1 + "|";
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      paramString1 = paramString1 + "null";
      paramString1 = paramString1 + "|";
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        break label191;
      }
    }
    label191:
    for (paramString1 = paramString1 + "null";; paramString1 = paramString1 + paramString3)
    {
      paramString1 = paramString1 + "|";
      if ((paramString4 != null) && (paramString4.length() > 0)) {
        break label214;
      }
      return paramString1 + "null";
      paramString1 = paramString1 + paramString2;
      break;
    }
    label214:
    return paramString1 + paramString4;
  }
  
  public static String a(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3)
  {
    return a(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt2, paramInt3, null);
  }
  
  public static String a(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, String paramString8)
  {
    paramString1 = a(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4);
    paramString1 = paramString1 + "|";
    if ((paramString5 == null) || (paramString5.length() <= 0))
    {
      paramString1 = paramString1 + "null";
      paramString1 = paramString1 + "|";
      if ((paramString6 != null) && (paramString6.length() > 0)) {
        break label329;
      }
      paramString1 = paramString1 + "null";
      label121:
      paramString1 = paramString1 + "|";
      if ((paramString7 != null) && (paramString7.length() > 0)) {
        break label352;
      }
    }
    label329:
    label352:
    for (paramString1 = paramString1 + "null";; paramString1 = paramString1 + paramString7)
    {
      paramString1 = paramString1 + "|";
      paramString1 = paramString1 + paramInt2;
      paramString1 = paramString1 + "|";
      paramString2 = paramString1 + paramInt3;
      paramString1 = paramString2;
      if (paramString8 != null)
      {
        paramString1 = paramString2 + "|";
        paramString1 = paramString1 + paramString8;
      }
      return paramString1;
      paramString1 = paramString1 + paramString5;
      break;
      paramString1 = paramString1 + paramString6;
      break label121;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    paramString1 = a(paramString1, 0L, 1, true, paramString2);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('|');
    localStringBuffer.append(paramString2);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString3);
    localStringBuffer.append('|');
    localStringBuffer.append(paramLong);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt);
    return paramString1 + localStringBuffer.toString();
  }
  
  public static String[] a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.split("\026");
    } while ((paramString == null) || (paramString.length < 2));
    return paramString[1].split("\\|");
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\026');
    paramString1 = a(paramString1);
    int i1 = 0;
    while ((i1 < paramString1.length) && (i1 < 5))
    {
      localStringBuilder.append(paramString1[i1]);
      localStringBuilder.append('|');
      i1 += 1;
    }
    if (paramString1.length == 4)
    {
      localStringBuilder.append("");
      localStringBuilder.append('|');
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(paramString2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString3);
      localStringBuilder.append('|');
      localStringBuilder.append(paramLong);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransfileUtile
 * JD-Core Version:    0.7.0.1
 */