package com.tencent.mobileqq.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hfm;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Utils
{
  public static final int a = 1048576;
  private static final String jdField_a_of_type_JavaLangString = Utils.class.getSimpleName();
  private static StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private static final char[] jdField_a_of_type_ArrayOfChar = { 12290, -225, -255, 33, 63, -244, -229, 44, 32 };
  public static final int b = 8192;
  private static final int c = 12;
  private static int d = 0;
  
  public static int a(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    return i;
  }
  
  private static int a(int paramInt)
  {
    int i = 2;
    if (jdField_a_of_type_JavaLangStringBuilder.length() > 560) {}
    try
    {
      int j = jdField_a_of_type_JavaLangStringBuilder.toString().getBytes("utf-8").length;
      if ((d != j) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "calculate byte num not equal byte num returned by getBytes(),totalByteNum is:" + d + ",byteNum" + j);
      }
      label77:
      jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      d = 0;
      if ((paramInt >= 0) && (paramInt < 128)) {
        i = 1;
      }
      for (;;)
      {
        jdField_a_of_type_JavaLangStringBuilder.append(Character.toChars(paramInt));
        d += i;
        return i;
        if ((paramInt < 128) || (paramInt >= 2048)) {
          if ((paramInt >= 2048) && (paramInt < 65536)) {
            i = 3;
          } else if ((paramInt >= 65536) && (paramInt < 2097152)) {
            i = 4;
          } else if ((paramInt >= 2097152) && (paramInt < 67108864)) {
            i = 5;
          } else if ((paramInt >= 67108864) && (paramInt <= 2147483647)) {
            i = 6;
          } else {
            i = 6;
          }
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label77;
    }
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt3 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static int a(long paramLong)
  {
    return (int)paramLong;
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    PackageManager localPackageManager;
    if (paramContext != null) {
      localPackageManager = paramContext.getPackageManager();
    }
    try
    {
      i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  @SuppressLint({"NewApi"})
  public static int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return -1;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private static int a(String paramString)
  {
    int i = 0;
    int n = paramString.length();
    int j = 0;
    if (i < n)
    {
      int i1 = paramString.codePointAt(i);
      int k;
      if (i1 == 20)
      {
        j += 12;
        k = i + 1;
      }
      for (;;)
      {
        i = k + 1;
        break;
        int m = j + a(i1);
        k = i;
        j = m;
        if (i1 > 255)
        {
          k = i + 1;
          j = m;
        }
      }
    }
    return j;
  }
  
  private static int a(String paramString, int paramInt)
  {
    int i = 0;
    if (paramInt >= paramString.length()) {
      i = paramString.length() - 1;
    }
    int j;
    do
    {
      do
      {
        return i;
        paramString = paramString.substring(0, paramInt);
        String[] arrayOfString = new String[9];
        arrayOfString[0] = "。";
        arrayOfString[1] = "？";
        arrayOfString[2] = "！";
        arrayOfString[3] = "!";
        arrayOfString[4] = "?";
        arrayOfString[5] = "，";
        arrayOfString[6] = "；";
        arrayOfString[7] = ",";
        arrayOfString[8] = " ";
        while (i < arrayOfString.length)
        {
          j = paramString.lastIndexOf(arrayOfString[i]);
          if ((j > 0) && (j > paramString.length() - 20)) {
            return j + 1;
          }
          i += 1;
        }
        j = paramString.lastIndexOf(String.valueOf('\024'));
        i = paramInt;
      } while (j <= 0);
      i = paramInt;
    } while (j <= paramString.length() - 20);
    return j;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte[(paramInt + 3)]) | a(paramArrayOfByte[(paramInt + 2)]) << 8 | a(paramArrayOfByte[(paramInt + 1)]) << 16 | paramArrayOfByte[paramInt] << 24;
  }
  
  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear(10);
    localCalendar.clear(12);
    localCalendar.clear(13);
    localCalendar.clear(14);
    return localCalendar.getTimeInMillis();
  }
  
  public static long a(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  @SuppressLint({"NewApi"})
  public static long a(File paramFile)
  {
    paramFile = new StatFs(paramFile.getPath());
    return paramFile.getBlockSize() * paramFile.getAvailableBlocks();
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[7] & 0xFF) << 56;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte[(paramInt + 3)]) | a(paramArrayOfByte[(paramInt + 2)]) << 8 | a(paramArrayOfByte[(paramInt + 1)]) << 16 | a(paramArrayOfByte[paramInt]) << 24;
  }
  
  @SuppressLint({"NewApi"})
  public static File a(Context paramContext)
  {
    if (c()) {
      return paramContext.getExternalCacheDir();
    }
    paramContext = "/Android/data/" + paramContext.getPackageName() + "/cache/";
    return new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
  }
  
  public static String a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    int i = 1;
    while (i <= paramInt)
    {
      ((StringBuilder)localObject).append("0");
      i += 1;
    }
    if (paramInt >= 1) {}
    double d1;
    double d2;
    for (localObject = "##0." + ((StringBuilder)localObject).toString();; localObject = "##0")
    {
      localObject = new DecimalFormat((String)localObject);
      d1 = 1024.0D * 1024.0D;
      d2 = 1024.0D * d1;
      if (paramLong >= 1024.0D) {
        break;
      }
      return ((DecimalFormat)localObject).format(paramLong) + "B";
    }
    if (paramLong < d1)
    {
      localStringBuilder = new StringBuilder().append(((DecimalFormat)localObject).format(paramLong / 1024.0D));
      if (paramBoolean) {}
      for (localObject = "KB";; localObject = "K") {
        return (String)localObject;
      }
    }
    if (paramLong < d2)
    {
      localStringBuilder = new StringBuilder().append(((DecimalFormat)localObject).format(paramLong / d1));
      if (paramBoolean) {}
      for (localObject = "MB";; localObject = "M") {
        return (String)localObject;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append(((DecimalFormat)localObject).format(paramLong / d2));
    if (paramBoolean) {}
    for (localObject = "GB";; localObject = "G") {
      return (String)localObject;
    }
  }
  
  public static String a(Context paramContext)
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      paramContext = "/Android/data/" + paramContext.getPackageName() + "/cache/";
      return Environment.getExternalStorageDirectory().getPath() + paramContext;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "0|0";
    }
    return paramString.charAt(0) + "|" + paramString.length();
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (paramString == null) {
      str = paramString;
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (paramString.length() == 0);
        str = paramString;
      } while (paramString.length() <= paramInt);
      paramString = paramString.substring(0, paramInt);
      str = paramString;
    } while (paramString.codePointAt(paramString.length() - 1) != 20);
    return paramString.substring(0, paramString.length() - 1);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { "QQ注册验证码" }, 3);
  }
  
  private static String a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    label141:
    label195:
    label324:
    label333:
    label339:
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "oriAdd=" + paramString1 + "smsbody=" + paramString2);
      }
      if (paramArrayOfString1 != null)
      {
        int j = paramArrayOfString1.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfString1[i];
          if ((str == null) || (str.length() <= 0) || (!paramString1.startsWith(str))) {}
        }
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (paramArrayOfString2 == null) || (paramArrayOfString2.length == 0) || (paramString2 == null)) {
            break label339;
          }
          j = paramArrayOfString2.length;
          i = 0;
          if (i < j)
          {
            paramString1 = paramArrayOfString2[i];
            if ((paramString1 == null) || (paramString1.length() <= 0) || (!paramString2.contains(paramString1))) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label333;
            }
            paramArrayOfString1 = paramString2.toCharArray();
            paramString1 = "";
            j = 0;
            int k = 0;
            if (j < paramArrayOfString1.length)
            {
              char c1 = paramArrayOfString1[j];
              if ((c1 >= '0') && (c1 <= '9'))
              {
                paramString2 = paramString1 + String.valueOf(c1);
                i = 1;
              }
              do
              {
                j += 1;
                paramString1 = paramString2;
                k = i;
                break label195;
                i += 1;
                break;
                i += 1;
                break label141;
                paramString2 = paramString1;
                i = k;
              } while (k == 0);
              if (paramString1.length() < paramInt) {}
            }
            else
            {
              if ((paramString1 == null) || (paramString1.length() <= 0)) {
                break label324;
              }
            }
            for (;;)
            {
              return paramString1;
              paramString2 = "";
              i = 0;
              break;
              paramString1 = null;
            }
          }
          break;
        }
      }
    }
  }
  
  private static ArrayList a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramString;
    if (paramString.length() <= paramInt)
    {
      localArrayList.add(paramString);
      return localArrayList;
    }
    while (str.length() > paramInt)
    {
      int i = a(str, paramInt);
      localArrayList.add(str.substring(0, i));
      str = str.substring(i);
    }
    localArrayList.add(str);
    return localArrayList;
  }
  
  public static ArrayList a(String paramString, int paramInt1, int paramInt2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ArrayList localArrayList2 = new ArrayList();
    int i2 = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    ArrayList localArrayList1 = null;
    int m = 0;
    int j = 0;
    int i1 = 0;
    int i3;
    int k;
    label62:
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
    if (j < i2)
    {
      i3 = paramString.codePointAt(j);
      k = i;
      if (paramArrayList1 == null) {
        break label850;
      }
      k = i;
      if (i >= paramArrayList1.size()) {
        break label850;
      }
      localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)paramArrayList1.get(i);
      if ((localAtTroopMemberInfo == null) || (!localAtTroopMemberInfo.isValid())) {}
    }
    label794:
    for (;;)
    {
      String str2;
      if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.startPos == j))
      {
        str2 = paramString.substring(localAtTroopMemberInfo.startPos, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen);
        k = a(str2);
        localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + m));
        if (localArrayList1 != null) {
          break label847;
        }
        localArrayList1 = new ArrayList();
      }
      label195:
      label589:
      label847:
      for (;;)
      {
        localArrayList1.add(localAtTroopMemberInfo);
        int n = k + 11 + 8;
        i += 1;
        if (i1 + n > paramInt1)
        {
          String str1 = localStringBuilder.toString();
          k = -1;
          int i4;
          label231:
          String str3;
          if (localArrayList1 == null)
          {
            i4 = str1.length() - paramInt2;
            i1 = 0;
            if (i1 < jdField_a_of_type_ArrayOfChar.length)
            {
              k = str1.lastIndexOf(jdField_a_of_type_ArrayOfChar[i1]);
              if (k <= i4) {}
            }
            else
            {
              if (k <= i4) {
                break label506;
              }
              str1 = localStringBuilder.substring(0, k + 1);
              str3 = localStringBuilder.substring(k + 1);
              localStringBuilder.setLength(0);
              k = a(str3);
              localStringBuilder.append(str3);
              i4 = str1.length();
              localArrayList2.add(str1);
              paramArrayList2.add(localArrayList1);
              if (str2 == null) {
                break label589;
              }
              localStringBuilder.append(str2);
              j = localAtTroopMemberInfo.textLen - 1 + j;
              label359:
              i1 = j;
              if (i3 == 20)
              {
                if (j + 1 < i2) {
                  break label626;
                }
                i1 = j;
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "there is no other char behind EMO_HEAD_CODE,msg is:" + paramString);
                }
              }
            }
          }
          for (i1 = j;; i1 = j + 1)
          {
            localArrayList1 = null;
            k += n;
            j = m - i4;
            n = i1 + 1;
            m = j;
            j = n;
            i1 = k;
            break;
            i += 1;
            break label62;
            if (i3 == 20)
            {
              str2 = null;
              n = 12;
              break label195;
            }
            n = a(i3);
            str2 = null;
            break label195;
            i1 += 1;
            break label231;
            label506:
            k = str1.lastIndexOf('\024');
            if (k > i4)
            {
              str1 = localStringBuilder.substring(0, k);
              str3 = localStringBuilder.substring(k);
              localStringBuilder.setLength(0);
              k = a(str3);
              localStringBuilder.append(str3);
              break label311;
            }
            localStringBuilder.setLength(0);
            k = 0;
            break label311;
            localStringBuilder.setLength(0);
            k = 0;
            break label311;
            if (i3 > 65535)
            {
              localStringBuilder.appendCodePoint(i3);
              j += 1;
              break label359;
            }
            localStringBuilder.append((char)i3);
            break label359;
            label626:
            localStringBuilder.append(paramString.charAt(j + 1));
          }
        }
        if (str2 != null)
        {
          localStringBuilder.append(str2);
          j = localAtTroopMemberInfo.textLen - 1 + j;
          k = j;
          if (i3 == 20)
          {
            if (j + 1 < i2) {
              break label794;
            }
            k = j;
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "there is no other char behind EMO_HEAD_CODE,msg is:" + paramString);
            }
          }
        }
        for (k = j;; k = j + 1)
        {
          n = i1 + n;
          j = m;
          i1 = k;
          k = n;
          break;
          if (i3 > 65535)
          {
            localStringBuilder.appendCodePoint(i3);
            j += 1;
            break label674;
          }
          localStringBuilder.append((char)i3);
          break label674;
          localStringBuilder.append(paramString.charAt(j + 1));
        }
        if (localStringBuilder.length() > 0)
        {
          localArrayList2.add(localStringBuilder.toString());
          paramArrayList2.add(localArrayList1);
        }
        return localArrayList2;
      }
      label311:
      label850:
      localAtTroopMemberInfo = null;
      label674:
      i = k;
    }
  }
  
  public static ArrayList a(ArrayList paramArrayList)
  {
    Object[] arrayOfObject = new Object[paramArrayList.size()];
    int i = 0;
    Object localObject;
    while (i < paramArrayList.size())
    {
      localObject = (Pair)paramArrayList.get(i);
      arrayOfObject[i] = { (String)((Pair)localObject).first, String.valueOf(((Pair)localObject).second) };
      i += 1;
    }
    Arrays.sort(arrayOfObject, new hfm());
    paramArrayList.clear();
    i = 0;
    while (i < arrayOfObject.length)
    {
      localObject = (String[])arrayOfObject[i];
      paramArrayList.add(Pair.create(localObject[0], Long.valueOf(Long.parseLong(localObject[1]))));
      i += 1;
    }
    return paramArrayList;
  }
  
  public static short a(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(a(paramArrayOfByte[(paramInt + 1)]) | a(paramArrayOfByte[paramInt]) << 8);
  }
  
  public static void a()
  {
    if (b()) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  @SuppressLint({"NewApi"})
  public static boolean a()
  {
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.equals(paramString))
      {
        Process.killProcess(localRunningAppProcessInfo.pid);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.equals(AppConstants.S)) || (paramString.equals(String.valueOf(AppConstants.T))) || (paramString.equals(String.valueOf(AppConstants.U))) || (paramString.equals(String.valueOf(AppConstants.V))) || (paramString.equals(String.valueOf(AppConstants.W))) || (paramString.equals(String.valueOf(AppConstants.R))) || (paramString.equals(String.valueOf(AppConstants.Q))) || (paramString.equals(String.valueOf(AppConstants.af))) || (paramString.equals(String.valueOf(AppConstants.P))) || (paramString.equals(String.valueOf(AppConstants.O))) || (paramString.equals(String.valueOf(AppConstants.N))) || (paramString.equals(String.valueOf(AppConstants.ae))) || (paramString.equals(String.valueOf(AppConstants.ag)));
  }
  
  public static byte[] a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), k, j, i };
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload 8
    //   5: astore_2
    //   6: aload_0
    //   7: ifnull +11 -> 18
    //   10: aload_0
    //   11: arraylength
    //   12: ifgt +8 -> 20
    //   15: aload 8
    //   17: astore_2
    //   18: aload_2
    //   19: areturn
    //   20: sipush 1024
    //   23: newarray byte
    //   25: astore_2
    //   26: new 517	java/io/ByteArrayInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 520	java/io/ByteArrayInputStream:<init>	([B)V
    //   34: astore 4
    //   36: new 522	java/util/zip/GZIPInputStream
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 525	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_3
    //   46: new 527	java/io/ByteArrayOutputStream
    //   49: dup
    //   50: invokespecial 528	java/io/ByteArrayOutputStream:<init>	()V
    //   53: astore_0
    //   54: aload_0
    //   55: astore 7
    //   57: aload_3
    //   58: astore 6
    //   60: aload 4
    //   62: astore 5
    //   64: aload_3
    //   65: aload_2
    //   66: iconst_0
    //   67: aload_2
    //   68: arraylength
    //   69: invokevirtual 532	java/util/zip/GZIPInputStream:read	([BII)I
    //   72: istore_1
    //   73: iload_1
    //   74: ifle +76 -> 150
    //   77: aload_0
    //   78: astore 7
    //   80: aload_3
    //   81: astore 6
    //   83: aload 4
    //   85: astore 5
    //   87: aload_0
    //   88: aload_2
    //   89: iconst_0
    //   90: iload_1
    //   91: invokevirtual 536	java/io/ByteArrayOutputStream:write	([BII)V
    //   94: goto -40 -> 54
    //   97: astore_2
    //   98: aload_0
    //   99: astore 7
    //   101: aload_3
    //   102: astore 6
    //   104: aload 4
    //   106: astore 5
    //   108: aload_2
    //   109: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 542	java/io/ByteArrayOutputStream:close	()V
    //   120: aload_3
    //   121: ifnull +7 -> 128
    //   124: aload_3
    //   125: invokevirtual 543	java/util/zip/GZIPInputStream:close	()V
    //   128: aload 8
    //   130: astore_2
    //   131: aload 4
    //   133: ifnull -115 -> 18
    //   136: aload 4
    //   138: invokevirtual 544	java/io/ByteArrayInputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   148: aconst_null
    //   149: areturn
    //   150: aload_0
    //   151: astore 7
    //   153: aload_3
    //   154: astore 6
    //   156: aload 4
    //   158: astore 5
    //   160: aload_0
    //   161: invokevirtual 548	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   164: astore_2
    //   165: aload_2
    //   166: astore 5
    //   168: aload_0
    //   169: ifnull +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 542	java/io/ByteArrayOutputStream:close	()V
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 543	java/util/zip/GZIPInputStream:close	()V
    //   184: aload 5
    //   186: astore_2
    //   187: aload 4
    //   189: ifnull -171 -> 18
    //   192: aload 4
    //   194: invokevirtual 544	java/io/ByteArrayInputStream:close	()V
    //   197: aload 5
    //   199: areturn
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   205: aload 5
    //   207: areturn
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_2
    //   211: aconst_null
    //   212: astore_3
    //   213: aconst_null
    //   214: astore 4
    //   216: aload_2
    //   217: ifnull +7 -> 224
    //   220: aload_2
    //   221: invokevirtual 542	java/io/ByteArrayOutputStream:close	()V
    //   224: aload_3
    //   225: ifnull +7 -> 232
    //   228: aload_3
    //   229: invokevirtual 543	java/util/zip/GZIPInputStream:close	()V
    //   232: aload 4
    //   234: ifnull +8 -> 242
    //   237: aload 4
    //   239: invokevirtual 544	java/io/ByteArrayInputStream:close	()V
    //   242: aload_0
    //   243: athrow
    //   244: astore_2
    //   245: aload_2
    //   246: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   249: goto -7 -> 242
    //   252: astore_0
    //   253: aconst_null
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_3
    //   257: goto -41 -> 216
    //   260: astore_0
    //   261: aconst_null
    //   262: astore_2
    //   263: goto -47 -> 216
    //   266: astore_0
    //   267: aload 7
    //   269: astore_2
    //   270: aload 6
    //   272: astore_3
    //   273: aload 5
    //   275: astore 4
    //   277: goto -61 -> 216
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_0
    //   283: aconst_null
    //   284: astore_3
    //   285: aconst_null
    //   286: astore 4
    //   288: goto -190 -> 98
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_3
    //   296: goto -198 -> 98
    //   299: astore_2
    //   300: aconst_null
    //   301: astore_0
    //   302: goto -204 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramArrayOfByte	byte[]
    //   72	19	1	i	int
    //   5	84	2	localObject1	Object
    //   97	12	2	localIOException1	java.io.IOException
    //   130	91	2	localObject2	Object
    //   244	2	2	localIOException2	java.io.IOException
    //   254	16	2	localObject3	Object
    //   280	1	2	localIOException3	java.io.IOException
    //   291	1	2	localIOException4	java.io.IOException
    //   299	1	2	localIOException5	java.io.IOException
    //   45	251	3	localObject4	Object
    //   34	253	4	localObject5	Object
    //   62	212	5	localObject6	Object
    //   58	213	6	localObject7	Object
    //   55	213	7	arrayOfByte	byte[]
    //   1	128	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   64	73	97	java/io/IOException
    //   87	94	97	java/io/IOException
    //   160	165	97	java/io/IOException
    //   116	120	143	java/io/IOException
    //   124	128	143	java/io/IOException
    //   136	141	143	java/io/IOException
    //   172	176	200	java/io/IOException
    //   180	184	200	java/io/IOException
    //   192	197	200	java/io/IOException
    //   26	36	208	finally
    //   220	224	244	java/io/IOException
    //   228	232	244	java/io/IOException
    //   237	242	244	java/io/IOException
    //   36	46	252	finally
    //   46	54	260	finally
    //   64	73	266	finally
    //   87	94	266	finally
    //   108	112	266	finally
    //   160	165	266	finally
    //   26	36	280	java/io/IOException
    //   36	46	291	java/io/IOException
    //   46	54	299	java/io/IOException
  }
  
  public static byte[] a(int[] paramArrayOfInt, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length << 2];
    int i = 0;
    while (paramInt < arrayOfByte.length)
    {
      arrayOfByte[(paramInt + 3)] = ((byte)(paramArrayOfInt[i] & 0xFF));
      arrayOfByte[(paramInt + 2)] = ((byte)(paramArrayOfInt[i] >> 8 & 0xFF));
      arrayOfByte[(paramInt + 1)] = ((byte)(paramArrayOfInt[i] >> 16 & 0xFF));
      arrayOfByte[paramInt] = ((byte)(paramArrayOfInt[i] >> 24 & 0xFF));
      i += 1;
      paramInt += 4;
    }
    return arrayOfByte;
  }
  
  public static int[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = new int[paramArrayOfByte.length >> 2];
    int i = 0;
    while (paramInt < paramArrayOfByte.length)
    {
      arrayOfInt[i] = (a(paramArrayOfByte[(paramInt + 3)]) | a(paramArrayOfByte[(paramInt + 2)]) << 8 | a(paramArrayOfByte[(paramInt + 1)]) << 16 | paramArrayOfByte[paramInt] << 24);
      i += 1;
      paramInt += 4;
    }
    return arrayOfInt;
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static long b()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    int i = localStatFs.getBlockSize();
    int j = localStatFs.getAvailableBlocks();
    return i * j;
  }
  
  public static String b(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static String b(String paramString, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("len must be greater than 0,len is:" + paramInt);
    }
    if (paramString == null) {}
    while (paramString.length() <= paramInt) {
      return paramString;
    }
    return paramString.substring(0, paramInt) + "...";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { "手机QQ短信验证码" }, 3);
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT < 8;
  }
  
  public static boolean b(String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      label9:
      break label9;
    }
    return ((l1 >= 2726500000L) && (l1 <= 2726511999L)) || ((l1 >= 800000000L) && (l1 <= 800099999L)) || ((l1 >= 938000000L) && (l1 <= 938099999L)) || ((l1 >= 1068660000L) && (l1 <= 1068669960L)) || ((l1 >= 2355000000L) && (l1 <= 2355199999L)) || (l1 == 56268888L);
  }
  
  public static String c(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { "短信登录验证码", "Login Verification Code" }, 3);
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public static String d(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new String[] { "1062", "1065", "1066", "1069" }, new String[] { "设备锁", "密保手机" }, 3);
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean e()
  {
    return (Environment.getExternalStorageState().equals("mounted")) && (Environment.getExternalStorageDirectory().exists());
  }
  
  public static boolean f()
  {
    boolean bool2 = false;
    Context localContext = BaseApplication.getContext();
    boolean bool1 = bool2;
    PackageManager localPackageManager;
    if (Build.VERSION.SDK_INT > 7) {
      localPackageManager = localContext.getPackageManager();
    }
    try
    {
      int i = localPackageManager.getPackageInfo(localContext.getPackageName(), 0).applicationInfo.flags;
      bool1 = bool2;
      if ((i & 0x40000) == 262144) {
        bool1 = true;
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.Utils
 * JD-Core Version:    0.7.0.1
 */