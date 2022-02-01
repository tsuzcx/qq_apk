package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.mm.algorithm.MD5;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.Assert;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class Util
{
  public static final int BEGIN_TIME = 22;
  public static final int BIT_OF_KB = 10;
  public static final int BIT_OF_MB = 20;
  public static final int BYTE_OF_KB = 1024;
  public static final int BYTE_OF_MB = 1048576;
  public static final String CHINA = "zh_CN";
  public static final int DAY = 0;
  public static final int END_TIME = 8;
  public static final String ENGLISH = "en";
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  public static final String HONGKONG = "zh_HK";
  public static final String LANGUAGE_DEFAULT = "language_default";
  public static final int MASK_16BIT = 65535;
  public static final int MASK_32BIT = -1;
  public static final int MASK_4BIT = 15;
  public static final int MASK_8BIT = 255;
  public static final long MAX_32BIT_VALUE = 4294967295L;
  public static final int MAX_ACCOUNT_LENGTH = 20;
  public static final int MAX_DECODE_PICTURE_SIZE = 2764800;
  public static final int MAX_PASSWORD_LENGTH = 9;
  public static final long MILLSECONDS_OF_DAY = 86400000L;
  public static final long MILLSECONDS_OF_HOUR = 3600000L;
  public static final long MILLSECONDS_OF_MINUTE = 60000L;
  public static final long MILLSECONDS_OF_SECOND = 1000L;
  public static final long MINUTE_OF_HOUR = 60L;
  public static final int MIN_ACCOUNT_LENGTH = 6;
  public static final int MIN_PASSWORD_LENGTH = 4;
  public static final String PHOTO_DEFAULT_EXT = ".jpg";
  public static final long SECOND_OF_MINUTE = 60L;
  public static final String TAIWAN = "zh_TW";
  private static final char[] bA = { 9, 10, 13 };
  private static final char[] bB = { 60, 62, 34, 39, 38 };
  private static final String[] bC = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;" };
  private static final long[] bz = { 300L, 200L, 300L, 200L };
  
  public static String GetHostIp()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress();
      return localObject;
    }
    catch (SocketException|Exception localSocketException)
    {
      label59:
      break label59;
    }
    return null;
  }
  
  public static int UnZipFolder(String paramString1, String paramString2)
  {
    try
    {
      android.util.Log.v("XZip", "UnZipFolder(String, String)");
      paramString1 = new ZipInputStream(new FileInputStream(paramString1));
      for (;;)
      {
        Object localObject2 = paramString1.getNextEntry();
        if (localObject2 == null) {
          break;
        }
        Object localObject1 = ((ZipEntry)localObject2).getName();
        if (((ZipEntry)localObject2).isDirectory())
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString2);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append((String)localObject1);
          new File(((StringBuilder)localObject2).toString()).mkdirs();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString2);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = new File(((StringBuilder)localObject2).toString());
          ((File)localObject1).createNewFile();
          localObject1 = new FileOutputStream((File)localObject1);
          localObject2 = new byte[1024];
          for (;;)
          {
            int i = paramString1.read((byte[])localObject2);
            if (i == -1) {
              break;
            }
            ((FileOutputStream)localObject1).write((byte[])localObject2, 0, i);
            ((FileOutputStream)localObject1).flush();
          }
          ((FileOutputStream)localObject1).close();
        }
      }
      paramString1.close();
      return 0;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return -2;
    }
    catch (FileNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  private static int a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return 0;
    }
    if (paramArrayOfChar[paramInt1] == '#') {
      if (paramInt2 > 1)
      {
        int i = paramInt1 + 1;
        if ((paramArrayOfChar[i] != 'x') && (paramArrayOfChar[i] != 'X')) {}
      }
    }
    try
    {
      paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 2, paramInt2 - 2), 16);
      return paramInt1;
    }
    catch (NumberFormatException paramArrayOfChar)
    {
      return 0;
    }
    try
    {
      paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 1, paramInt2 - 1), 10);
      return paramInt1;
    }
    catch (NumberFormatException paramArrayOfChar) {}
    new String(paramArrayOfChar, paramInt1, paramInt2);
    return 0;
    return 0;
  }
  
  private static void a(Map<String, String> paramMap, String paramString, Node paramNode, int paramInt)
  {
    if (paramNode.getNodeName().equals("#text")) {}
    while (paramNode.getNodeName().equals("#cdata-section"))
    {
      paramMap.put(paramString, paramNode.getNodeValue());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramNode.getNodeName());
    if (paramInt > 0) {
      paramString = Integer.valueOf(paramInt);
    } else {
      paramString = "";
    }
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    paramMap.put(paramString, paramNode.getNodeValue());
    localObject = paramNode.getAttributes();
    int i = 0;
    Node localNode;
    if (localObject != null)
    {
      paramInt = 0;
      while (paramInt < ((NamedNodeMap)localObject).getLength())
      {
        localNode = ((NamedNodeMap)localObject).item(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".$");
        localStringBuilder.append(localNode.getNodeName());
        paramMap.put(localStringBuilder.toString(), localNode.getNodeValue());
        paramInt += 1;
      }
    }
    localObject = new HashMap();
    paramNode = paramNode.getChildNodes();
    paramInt = i;
    while (paramInt < paramNode.getLength())
    {
      localNode = paramNode.item(paramInt);
      i = nullAsNil((Integer)((HashMap)localObject).get(localNode.getNodeName()));
      a(paramMap, paramString, localNode, i);
      ((HashMap)localObject).put(localNode.getNodeName(), Integer.valueOf(i + 1));
      paramInt += 1;
    }
  }
  
  public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramBitmap;
  }
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    Assert.assertNotNull(paramContext);
    String str = paramContext.getPackageName();
    boolean bool;
    if (paramContext.getPackageManager().checkPermission(paramString, str) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" has ");
    if (bool) {
      paramContext = "permission ";
    } else {
      paramContext = "no permission ";
    }
    localStringBuilder.append(paramContext);
    localStringBuilder.append(paramString);
    Log.d("MicroMsg.Util", localStringBuilder.toString());
    return bool;
  }
  
  public static boolean checkSDCardFull()
  {
    if (!"mounted".equals(Environment.getExternalStorageState())) {
      return false;
    }
    Object localObject = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l1 = ((StatFs)localObject).getBlockCount();
    long l2 = ((StatFs)localObject).getAvailableBlocks();
    if (l1 <= 0L) {
      return false;
    }
    long l3 = l1 - l2;
    if (l3 < 0L) {
      return false;
    }
    int i = (int)(l3 * 100L / l1);
    l3 = ((StatFs)localObject).getBlockSize() * ((StatFs)localObject).getFreeBlocks();
    localObject = new StringBuilder("checkSDCardFull per:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" blockCount:");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" availCount:");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(" availSize:");
    ((StringBuilder)localObject).append(l3);
    Log.d("MicroMsg.Util", ((StringBuilder)localObject).toString());
    if (95 > i) {
      return false;
    }
    return l3 <= 52428800L;
  }
  
  /* Error */
  public static String convertStreamToString(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 453	java/io/BufferedReader
    //   3: dup
    //   4: new 455	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 456	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 459	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 209	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 462	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +41 -> 71
    //   33: new 209	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   40: astore 4
    //   42: aload 4
    //   44: aload_3
    //   45: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: ldc_w 464
    //   54: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_1
    //   59: aload 4
    //   61: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto -44 -> 24
    //   71: aload_0
    //   72: invokevirtual 467	java/io/InputStream:close	()V
    //   75: goto +24 -> 99
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   83: goto +16 -> 99
    //   86: astore_1
    //   87: goto +17 -> 104
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   95: aload_0
    //   96: invokevirtual 467	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: areturn
    //   104: aload_0
    //   105: invokevirtual 467	java/io/InputStream:close	()V
    //   108: goto +8 -> 116
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramInputStream	java.io.InputStream
    //   23	36	1	localStringBuilder1	StringBuilder
    //   86	31	1	localObject	Object
    //   15	10	2	localBufferedReader	java.io.BufferedReader
    //   90	2	2	localIOException	IOException
    //   28	17	3	str	String
    //   40	20	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   71	75	78	java/io/IOException
    //   95	99	78	java/io/IOException
    //   24	29	86	finally
    //   33	68	86	finally
    //   91	95	86	finally
    //   24	29	90	java/io/IOException
    //   33	68	90	java/io/IOException
    //   104	108	111	java/io/IOException
  }
  
  public static long currentDayInMills()
  {
    return nowMilliSecond() / 86400000L * 86400000L;
  }
  
  public static long currentMonthInMills()
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar = new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), 1);
    localGregorianCalendar.setTimeZone(GMT);
    return localGregorianCalendar.getTimeInMillis();
  }
  
  public static long currentTicks()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public static long currentWeekInMills()
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    localGregorianCalendar2.setTimeZone(GMT);
    localGregorianCalendar2.add(6, -(localGregorianCalendar1.get(7) - localGregorianCalendar1.getFirstDayOfWeek()));
    return localGregorianCalendar2.getTimeInMillis();
  }
  
  public static long currentYearInMills()
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(new GregorianCalendar().get(1), 1, 1);
    localGregorianCalendar.setTimeZone(GMT);
    return localGregorianCalendar.getTimeInMillis();
  }
  
  public static byte[] decodeHexString(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        int i = 0;
        while (i < arrayOfByte.length)
        {
          int j = i * 2;
          arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(j, j + 2), 16) & 0xFF));
          i += 1;
        }
        return arrayOfByte;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        return new byte[0];
      }
    }
    return new byte[0];
  }
  
  public static boolean deleteFile(String paramString)
  {
    if (isNullOrNil(paramString)) {
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return true;
    }
    if (paramString.isDirectory()) {
      return false;
    }
    return paramString.delete();
  }
  
  public static void deleteOutOfDateFile(String paramString1, String paramString2, long paramLong)
  {
    if (isNullOrNil(paramString1)) {
      return;
    }
    paramString1 = new File(paramString1);
    if (paramString1.exists())
    {
      if (!paramString1.isDirectory()) {
        return;
      }
      paramString1 = paramString1.listFiles();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        if ((localObject.isFile()) && (localObject.getName().startsWith(paramString2)) && (nowMilliSecond() - localObject.lastModified() - paramLong >= 0L)) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  public static String dumpArray(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfObject[i]);
      localStringBuilder.append(",");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String dumpHex(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "(null)";
    }
    char[] arrayOfChar1 = new char[16];
    char[] tmp16_14 = arrayOfChar1;
    tmp16_14[0] = 48;
    char[] tmp22_16 = tmp16_14;
    tmp22_16[1] = 49;
    char[] tmp28_22 = tmp22_16;
    tmp28_22[2] = 50;
    char[] tmp34_28 = tmp28_22;
    tmp34_28[3] = 51;
    char[] tmp40_34 = tmp34_28;
    tmp40_34[4] = 52;
    char[] tmp46_40 = tmp40_34;
    tmp46_40[5] = 53;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[6] = 54;
    char[] tmp59_52 = tmp52_46;
    tmp59_52[7] = 55;
    char[] tmp66_59 = tmp59_52;
    tmp66_59[8] = 56;
    char[] tmp73_66 = tmp66_59;
    tmp73_66[9] = 57;
    char[] tmp80_73 = tmp73_66;
    tmp80_73[10] = 97;
    char[] tmp87_80 = tmp80_73;
    tmp87_80[11] = 98;
    char[] tmp94_87 = tmp87_80;
    tmp94_87[12] = 99;
    char[] tmp101_94 = tmp94_87;
    tmp101_94[13] = 100;
    char[] tmp108_101 = tmp101_94;
    tmp108_101[14] = 101;
    char[] tmp115_108 = tmp108_101;
    tmp115_108[15] = 102;
    tmp115_108;
    int k = paramArrayOfByte.length;
    char[] arrayOfChar2 = new char[k * 3];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = ' ';
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m >>> 4 & 0xF)];
      arrayOfChar2[j] = arrayOfChar1[(m & 0xF)];
      i += 1;
      j += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static String encodeHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfByte[i] & 0xFF) }));
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String escapeSqlValue(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
    }
    return str;
  }
  
  public static String escapeStringForXml(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramString.length();
    int i = 0;
    while (i < n)
    {
      char c = paramString.charAt(i);
      int m = 1;
      if (c < ' ')
      {
        char[] arrayOfChar = bA;
        if ((c != arrayOfChar[0]) && (c != arrayOfChar[1]) && (c != arrayOfChar[2])) {}
      }
      else
      {
        if (c <= '') {
          break label113;
        }
      }
      localStringBuffer.append("&#");
      localStringBuffer.append(Integer.toString(c));
      c = ';';
      label113:
      int k;
      do
      {
        localStringBuffer.append(c);
        break;
        int j = bB.length - 1;
        for (;;)
        {
          k = m;
          if (j < 0) {
            break;
          }
          if (bB[j] == c)
          {
            localStringBuffer.append(bC[j]);
            k = 0;
            break;
          }
          j -= 1;
        }
      } while (k != 0);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String expandEntities(String paramString)
  {
    int n = paramString.length();
    char[] arrayOfChar = new char[n];
    int k = 0;
    int m = 0;
    int j = -1;
    while (k < n)
    {
      char c = paramString.charAt(k);
      int i = m + 1;
      arrayOfChar[m] = c;
      if ((c == '&') && (j == -1))
      {
        j = i;
      }
      else if ((j != -1) && (!Character.isLetter(c)) && (!Character.isDigit(c)) && (c != '#'))
      {
        if (c == ';')
        {
          m = a(arrayOfChar, j, i - j - 1);
          if (m > 65535)
          {
            i = m - 65536;
            arrayOfChar[(j - 1)] = ((char)((i >> 10) + 55296));
            arrayOfChar[j] = ((char)((i & 0x3FF) + 56320));
            i = j + 1;
          }
          else if (m != 0)
          {
            arrayOfChar[(j - 1)] = ((char)m);
            i = j;
          }
        }
        j = -1;
      }
      k += 1;
      m = i;
    }
    return new String(arrayOfChar, 0, m);
  }
  
  public static String formatSecToMin(int paramInt)
  {
    long l = paramInt;
    return String.format("%d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) });
  }
  
  public static String formatUnixTime(long paramLong)
  {
    return new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(paramLong * 1000L));
  }
  
  public static void freeBitmapMap(Map<String, Bitmap> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
    paramMap.clear();
  }
  
  public static String getCutPasswordMD5(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (str.length() <= 16) {
      return getFullPasswordMD5(str);
    }
    return getFullPasswordMD5(str.substring(0, 16));
  }
  
  public static String getDeviceId(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getDeviceId();
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.trim();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
      Log.e("MicroMsg.Util", "getDeviceId failed, security exception");
      return null;
    }
    catch (SecurityException paramContext)
    {
      label48:
      break label48;
    }
  }
  
  public static String getFullPasswordMD5(String paramString)
  {
    return MD5.getMessageDigest(paramString.getBytes());
  }
  
  public static int getHex(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      long l = Long.decode(paramString).longValue();
      return (int)(l & 0xFFFFFFFF);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static BitmapFactory.Options getImageOptions(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (!paramString.equals(""))) {
      bool = true;
    } else {
      bool = false;
    }
    Assert.assertTrue(bool);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      if (paramString != null)
      {
        paramString.recycle();
        return localOptions;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder("decode bitmap failed: ");
      localStringBuilder.append(paramString.getMessage());
      Log.e("MicroMsg.Util", localStringBuilder.toString());
    }
    return localOptions;
  }
  
  public static Intent getInstallPackIntent(String paramString, Context paramContext)
  {
    boolean bool;
    if ((paramString != null) && (!paramString.equals(""))) {
      bool = true;
    } else {
      bool = false;
    }
    Assert.assertTrue(bool);
    paramContext = new Intent("android.intent.action.VIEW");
    paramContext.addFlags(268435456);
    paramContext.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    return paramContext;
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static int getIntRandom(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt1 > paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    Assert.assertTrue(bool);
    return new Random(System.currentTimeMillis()).nextInt(paramInt1 - paramInt2 + 1) + paramInt2;
  }
  
  public static String getLine1Number(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      if ((TelephonyManager)paramContext.getSystemService("phone") == null)
      {
        Log.e("MicroMsg.Util", "get line1 number failed, null tm");
        return null;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
      Log.e("MicroMsg.Util", "getLine1Number failed, security exception");
      return null;
    }
    catch (SecurityException paramContext)
    {
      label37:
      break label37;
    }
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    if (paramString == null) {
      return paramLong;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramLong;
  }
  
  public static Element getRootElementFromXML(byte[] paramArrayOfByte)
  {
    Object localObject = DocumentBuilderFactory.newInstance();
    try
    {
      localObject = ((DocumentBuilderFactory)localObject).newDocumentBuilder();
      if (localObject == null) {
        paramArrayOfByte = "new Document Builder failed";
      }
      for (;;)
      {
        Log.e("MicroMsg.Util", paramArrayOfByte);
        return null;
        try
        {
          paramArrayOfByte = ((DocumentBuilder)localObject).parse(new ByteArrayInputStream(paramArrayOfByte));
          if (paramArrayOfByte == null) {
            paramArrayOfByte = "new Document failed";
          } else {
            return paramArrayOfByte.getDocumentElement();
          }
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return null;
        }
        catch (SAXException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return null;
        }
      }
      return null;
    }
    catch (ParserConfigurationException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    Assert.assertNotNull(paramBitmap);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-4144960);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    return localBitmap;
  }
  
  public static int getSeconds(String paramString, int paramInt)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime() / 1000L;
      return (int)l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static String getSizeKB(long paramLong)
  {
    if (paramLong >> 20 > 0L) {
      return getSizeMB(paramLong);
    }
    if (paramLong >> 9 > 0L)
    {
      float f = Math.round((float)paramLong * 10.0F / 1024.0F) / 10.0F;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(f);
      localStringBuilder.append("KB");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("B");
    return localStringBuilder.toString();
  }
  
  public static String getSizeMB(long paramLong)
  {
    float f = Math.round((float)paramLong * 10.0F / 1048576.0F) / 10.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(f);
    localStringBuilder.append("MB");
    return localStringBuilder.toString();
  }
  
  public static String getStack()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length >= 2))
    {
      String str = "";
      int i = 1;
      while ((i < arrayOfStackTraceElement.length) && (arrayOfStackTraceElement[i].getClassName().contains("com.tencent.mm")))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("[");
        localStringBuilder.append(arrayOfStackTraceElement[i].getClassName().substring(15));
        localStringBuilder.append(":");
        localStringBuilder.append(arrayOfStackTraceElement[i].getMethodName());
        localStringBuilder.append("]");
        str = localStringBuilder.toString();
        i += 1;
      }
      return str;
    }
    return "";
  }
  
  public static int getSystemVersion(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return paramInt;
    }
    return Settings.System.getInt(paramContext.getContentResolver(), "sys.settings_system_version", paramInt);
  }
  
  public static String getTimeZone()
  {
    Object localObject = getTimeZoneDef();
    int j = ((String)localObject).indexOf('+');
    int i = j;
    if (j == -1) {
      i = ((String)localObject).indexOf('-');
    }
    if (i == -1) {
      return "";
    }
    String str = ((String)localObject).substring(i, i + 3);
    localObject = str;
    if (str.charAt(1) == '0')
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str.substring(0, 1));
      ((StringBuilder)localObject).append(str.substring(2, 3));
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String getTimeZoneDef()
  {
    int i = (int)(TimeZone.getDefault().getRawOffset() / 60000L);
    char c;
    if (i < 0)
    {
      c = '-';
      i = -i;
    }
    else
    {
      c = '+';
    }
    long l = i;
    return String.format("GMT%s%02d:%02d", new Object[] { Character.valueOf(c), Long.valueOf(l / 60L), Long.valueOf(l % 60L) });
  }
  
  public static String getTimeZoneOffset()
  {
    TimeZone localTimeZone = TimeZone.getDefault();
    int j = localTimeZone.getRawOffset() / 1000;
    int i;
    if ((localTimeZone.useDaylightTime()) && (localTimeZone.inDaylightTime(new java.sql.Date(System.currentTimeMillis())))) {
      i = 1;
    } else {
      i = 0;
    }
    double d1 = j;
    Double.isNaN(d1);
    d1 /= 3600.0D;
    double d2 = i;
    Double.isNaN(d2);
    return String.format("%.2f", new Object[] { Double.valueOf(d1 + d2) });
  }
  
  public static String getTopActivityName(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "(null)";
  }
  
  public static byte[] getUuidRandom()
  {
    return MD5.getRawDigest(UUID.randomUUID().toString().getBytes());
  }
  
  public static int guessHttpContinueRecvLength(int paramInt)
  {
    return ((paramInt - 1) / 1462 + 1) * 52 + 52 + paramInt;
  }
  
  public static int guessHttpRecvLength(int paramInt)
  {
    return ((paramInt - 1) / 1462 + 1) * 52 + 208 + paramInt;
  }
  
  public static int guessHttpSendLength(int paramInt)
  {
    return ((paramInt - 1) / 1462 + 1) * 52 + 224 + paramInt;
  }
  
  public static int guessTcpConnectLength()
  {
    return 172;
  }
  
  public static int guessTcpDisconnectLength()
  {
    return 156;
  }
  
  public static int guessTcpRecvLength(int paramInt)
  {
    return ((paramInt - 1) / 1462 + 1) * 52 + 40 + paramInt;
  }
  
  public static int guessTcpSendLength(int paramInt)
  {
    return ((paramInt - 1) / 1462 + 1) * 52 + 40 + paramInt;
  }
  
  public static void installPack(String paramString, Context paramContext)
  {
    paramContext.startActivity(getInstallPackIntent(paramString, paramContext));
  }
  
  public static boolean isAlpha(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  public static boolean isChinese(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static boolean isDayTimeNow()
  {
    long l = new GregorianCalendar().get(11);
    return (l >= 6L) && (l < 18L);
  }
  
  public static boolean isImgFile(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramString.length() < 3) {
        return false;
      }
      if (!new File(paramString).exists()) {
        return false;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      return (localOptions.outWidth > 0) && (localOptions.outHeight > 0);
    }
    Log.e("MicroMsg.Util", "isImgFile, invalid argument");
    return false;
  }
  
  public static boolean isIntentAvailable(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0;
  }
  
  public static boolean isLockScreen(Context paramContext)
  {
    try
    {
      boolean bool = ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isNightTime(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt3)
    {
      if (paramInt1 < paramInt2) {
        return paramInt1 <= paramInt3;
      }
      return true;
    }
    if (paramInt2 < paramInt3) {
      return (paramInt1 <= paramInt3) && (paramInt1 >= paramInt2);
    }
    return true;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static boolean isNullOrNil(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static boolean isNum(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public static boolean isProcessRunning(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.equals(paramString)))
      {
        paramContext = new StringBuilder("process ");
        paramContext.append(paramString);
        paramContext.append(" is running");
        Log.w("MicroMsg.Util", paramContext.toString());
        return true;
      }
    }
    paramContext = new StringBuilder("process ");
    paramContext.append(paramString);
    paramContext.append(" is not running");
    Log.w("MicroMsg.Util", paramContext.toString());
    return false;
  }
  
  public static boolean isSDCardAvail()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        boolean bool3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isSDCardHaveEnoughSpace(long paramLong)
  {
    if (!"mounted".equals(Environment.getExternalStorageState())) {
      return false;
    }
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l1 = localStatFs.getBlockCount();
    long l2 = localStatFs.getAvailableBlocks();
    if (l1 <= 0L) {
      return false;
    }
    if (l1 - l2 < 0L) {
      return false;
    }
    return localStatFs.getBlockSize() * localStatFs.getFreeBlocks() >= paramLong;
  }
  
  public static boolean isServiceRunning(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
      if ((localRunningServiceInfo != null) && (localRunningServiceInfo.service != null) && (localRunningServiceInfo.service.getClassName().toString().equals(paramString)))
      {
        paramContext = new StringBuilder("service ");
        paramContext.append(paramString);
        paramContext.append(" is running");
        Log.w("MicroMsg.Util", paramContext.toString());
        return true;
      }
    }
    paramContext = new StringBuilder("service ");
    paramContext.append(paramString);
    paramContext.append(" is not running");
    Log.w("MicroMsg.Util", paramContext.toString());
    return false;
  }
  
  public static boolean isTopActivity(Context paramContext)
  {
    String str = paramContext.getClass().getName();
    paramContext = getTopActivityName(paramContext);
    StringBuilder localStringBuilder = new StringBuilder("top activity=");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", context=");
    localStringBuilder.append(str);
    Log.d("MicroMsg.Util", localStringBuilder.toString());
    return paramContext.equalsIgnoreCase(str);
  }
  
  public static boolean isTopApplication(Context paramContext)
  {
    try
    {
      String str = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      paramContext = paramContext.getPackageName();
      StringBuilder localStringBuilder = new StringBuilder("top activity=");
      localStringBuilder.append(str);
      localStringBuilder.append(", context=");
      localStringBuilder.append(paramContext);
      Log.d("MicroMsg.Util", localStringBuilder.toString());
      boolean bool = str.contains(paramContext);
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isValidAccount(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.trim();
    if (paramString.length() >= 6)
    {
      if (paramString.length() > 20) {
        return false;
      }
      if (!isAlpha(paramString.charAt(0))) {
        return false;
      }
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!isAlpha(c)) && (!isNum(c)) && (c != '-') && (c != '_')) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean isValidEmail(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    }
    return false;
  }
  
  public static boolean isValidPassword(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.length() < 4) {
      return false;
    }
    if (paramString.length() >= 9) {
      return true;
    }
    try
    {
      Integer.parseInt(paramString);
      return false;
    }
    catch (NumberFormatException paramString) {}
    return true;
  }
  
  public static boolean isValidQQNum(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return false;
      }
      paramString = paramString.trim();
      try
      {
        long l = Long.valueOf(paramString).longValue();
        return (l > 0L) && (l <= 4294967295L);
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean jump(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (!isIntentAvailable(paramContext, localIntent))
    {
      paramContext = new StringBuilder("jump to url failed, ");
      paramContext.append(paramString);
      Log.e("MicroMsg.Util", paramContext.toString());
      return false;
    }
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public static String listToString(List<String> paramList, String paramString)
  {
    if (paramList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject;
      if (i == paramList.size() - 1)
      {
        localObject = ((String)paramList.get(i)).trim();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(((String)paramList.get(i)).trim());
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String mapToXml(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<key>");
    Iterator localIterator = paramLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramString = (Map.Entry)localIterator.next();
      paramLinkedHashMap = paramString.getKey();
      Object localObject = paramString.getValue();
      paramString = paramLinkedHashMap;
      if (paramLinkedHashMap == null) {
        paramString = "unknow";
      }
      paramLinkedHashMap = (LinkedHashMap<String, String>)localObject;
      if (localObject == null) {
        paramLinkedHashMap = "unknow";
      }
      localObject = new StringBuilder("<");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(">");
      localStringBuilder.append(((StringBuilder)localObject).toString());
      localStringBuilder.append(paramLinkedHashMap);
      paramLinkedHashMap = new StringBuilder("</");
      paramLinkedHashMap.append(paramString);
      paramLinkedHashMap.append(">");
      localStringBuilder.append(paramLinkedHashMap.toString());
    }
    localStringBuilder.append("</key>");
    return localStringBuilder.toString();
  }
  
  public static long milliSecondsToNow(long paramLong)
  {
    return System.currentTimeMillis() - paramLong;
  }
  
  public static long nowMilliSecond()
  {
    return System.currentTimeMillis();
  }
  
  public static long nowSecond()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static int nullAs(Integer paramInteger, int paramInt)
  {
    if (paramInteger == null) {
      return paramInt;
    }
    return paramInteger.intValue();
  }
  
  public static long nullAs(Long paramLong, long paramLong1)
  {
    if (paramLong == null) {
      return paramLong1;
    }
    return paramLong.longValue();
  }
  
  public static String nullAs(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static boolean nullAs(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null) {
      return paramBoolean1;
    }
    return paramBoolean.booleanValue();
  }
  
  public static boolean nullAsFalse(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return false;
    }
    return paramBoolean.booleanValue();
  }
  
  public static int nullAsInt(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      return paramInt;
    }
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    if ((paramObject instanceof Long)) {
      return ((Long)paramObject).intValue();
    }
    return paramInt;
  }
  
  public static int nullAsNil(Integer paramInteger)
  {
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.intValue();
  }
  
  public static long nullAsNil(Long paramLong)
  {
    if (paramLong == null) {
      return 0L;
    }
    return paramLong.longValue();
  }
  
  public static String nullAsNil(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean nullAsTrue(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return true;
    }
    return paramBoolean.booleanValue();
  }
  
  public static Map<String, String> parseIni(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      HashMap localHashMap = new HashMap();
      paramString = paramString.split("\n");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramString[i];
        if ((localObject1 != null) && (localObject1.length() > 0))
        {
          Object localObject2 = localObject1.trim().split("=", 2);
          if ((localObject2 != null) && (localObject2.length >= 2))
          {
            localObject1 = localObject2[0];
            localObject2 = localObject2[1];
            if ((localObject1 != null) && (localObject1.length() > 0) && (localObject1.matches("^[a-zA-Z0-9_]*"))) {
              localHashMap.put(localObject1, localObject2);
            }
          }
        }
        i += 1;
      }
      return localHashMap;
    }
    return null;
  }
  
  public static Map<String, String> parseXml(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null)
    {
      if (paramString1.length() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap();
      Object localObject = DocumentBuilderFactory.newInstance();
      try
      {
        localObject = ((DocumentBuilderFactory)localObject).newDocumentBuilder();
        if (localObject == null) {
          paramString1 = "new Document Builder failed";
        }
        for (;;)
        {
          Log.e("MicroMsg.Util", paramString1);
          return null;
          try
          {
            paramString1 = new InputSource(new ByteArrayInputStream(paramString1.getBytes()));
            if (paramString3 != null) {
              paramString1.setEncoding(paramString3);
            }
            paramString1 = ((DocumentBuilder)localObject).parse(paramString1);
            try
            {
              paramString1.normalize();
            }
            catch (DOMException paramString3) {}
            paramString3.printStackTrace();
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            return null;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return null;
          }
          catch (SAXException paramString1)
          {
            paramString1.printStackTrace();
            return null;
          }
          catch (DOMException paramString3)
          {
            paramString1 = null;
          }
          if (paramString1 == null)
          {
            paramString1 = "new Document failed";
          }
          else
          {
            paramString1 = paramString1.getDocumentElement();
            if (paramString1 != null) {
              break;
            }
            paramString1 = "getDocumentElement failed";
          }
        }
        if ((paramString2 != null) && (paramString2.equals(paramString1.getNodeName()))) {}
        for (;;)
        {
          a(localHashMap, "", paramString1, 0);
          break label239;
          paramString1 = paramString1.getElementsByTagName(paramString2);
          if (paramString1.getLength() <= 0)
          {
            paramString1 = "parse item null";
            break;
          }
          if (paramString1.getLength() > 1) {
            Log.w("MicroMsg.Util", "parse items more than one");
          }
          paramString1 = paramString1.item(0);
        }
        label239:
        paramString1 = localHashMap.entrySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (Map.Entry)paramString1.next();
          paramString3 = new StringBuilder("key=");
          paramString3.append((String)paramString2.getKey());
          paramString3.append(" value=");
          paramString3.append((String)paramString2.getValue());
          Log.v("MicroMsg.Util", paramString3.toString());
        }
        return localHashMap;
      }
      catch (ParserConfigurationException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  public static MediaPlayer playSound(Context paramContext, int paramInt, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    return playSound(paramContext, paramInt, false, paramOnCompletionListener);
  }
  
  public static MediaPlayer playSound(Context paramContext, int paramInt, boolean paramBoolean, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      Object localObject = paramContext.getString(paramInt);
      paramContext = paramContext.getAssets().openFd((String)localObject);
      localObject = new MediaPlayer();
      ((MediaPlayer)localObject).setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
      paramContext.close();
      ((MediaPlayer)localObject).prepare();
      ((MediaPlayer)localObject).setLooping(paramBoolean);
      ((MediaPlayer)localObject).start();
      ((MediaPlayer)localObject).setOnCompletionListener(paramOnCompletionListener);
      return localObject;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void playSound(Context paramContext, int paramInt)
  {
    playSound(paramContext, paramInt, new Util.1());
  }
  
  public static String processXml(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return paramString;
      }
      str = paramString;
      if (Build.VERSION.SDK_INT < 8) {
        str = expandEntities(paramString);
      }
    }
    return str;
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 512	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4: ifeq +14 -> 18
    //   7: ldc_w 394
    //   10: ldc_w 1393
    //   13: invokestatic 1160	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aconst_null
    //   17: areturn
    //   18: new 216	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 515	java/io/File:exists	()Z
    //   31: ifne +22 -> 53
    //   34: ldc_w 394
    //   37: ldc_w 1395
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: aastore
    //   48: invokestatic 1398	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aconst_null
    //   52: areturn
    //   53: aload_3
    //   54: invokevirtual 1400	java/io/File:length	()J
    //   57: l2i
    //   58: istore_1
    //   59: new 181	java/io/FileInputStream
    //   62: dup
    //   63: aload_3
    //   64: invokespecial 1401	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore 4
    //   69: aload 4
    //   71: astore_3
    //   72: iload_1
    //   73: newarray byte
    //   75: astore 5
    //   77: aload 4
    //   79: astore_3
    //   80: aload 4
    //   82: aload 5
    //   84: invokevirtual 1402	java/io/FileInputStream:read	([B)I
    //   87: istore_2
    //   88: iload_2
    //   89: iload_1
    //   90: if_icmpeq +51 -> 141
    //   93: aload 4
    //   95: astore_3
    //   96: ldc_w 394
    //   99: ldc_w 1404
    //   102: iconst_3
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: iload_1
    //   113: invokestatic 295	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: aastore
    //   117: dup
    //   118: iconst_2
    //   119: iload_2
    //   120: invokestatic 295	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: invokestatic 1398	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload 4
    //   129: invokevirtual 1405	java/io/FileInputStream:close	()V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   139: aconst_null
    //   140: areturn
    //   141: aload 4
    //   143: astore_3
    //   144: ldc_w 394
    //   147: ldc_w 1407
    //   150: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 4
    //   155: invokevirtual 1405	java/io/FileInputStream:close	()V
    //   158: aload 5
    //   160: areturn
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   166: aload 5
    //   168: areturn
    //   169: astore_3
    //   170: aload 4
    //   172: astore_0
    //   173: aload_3
    //   174: astore 4
    //   176: goto +13 -> 189
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_3
    //   182: goto +32 -> 214
    //   185: astore 4
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_0
    //   190: astore_3
    //   191: aload 4
    //   193: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   196: aload_0
    //   197: ifnull +14 -> 211
    //   200: aload_0
    //   201: invokevirtual 1405	java/io/FileInputStream:close	()V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: aload_3
    //   215: ifnull +15 -> 230
    //   218: aload_3
    //   219: invokevirtual 1405	java/io/FileInputStream:close	()V
    //   222: goto +8 -> 230
    //   225: astore_3
    //   226: aload_3
    //   227: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   230: aload_0
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramString	String
    //   58	55	1	i	int
    //   87	33	2	j	int
    //   26	118	3	localObject1	Object
    //   169	5	3	localException1	Exception
    //   181	38	3	str	String
    //   225	2	3	localIOException	IOException
    //   67	108	4	localObject2	Object
    //   185	7	4	localException2	Exception
    //   75	92	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   127	132	134	java/io/IOException
    //   153	158	161	java/io/IOException
    //   72	77	169	java/lang/Exception
    //   80	88	169	java/lang/Exception
    //   96	127	169	java/lang/Exception
    //   144	153	169	java/lang/Exception
    //   53	69	179	finally
    //   53	69	185	java/lang/Exception
    //   200	204	206	java/io/IOException
    //   72	77	213	finally
    //   80	88	213	finally
    //   96	127	213	finally
    //   144	153	213	finally
    //   191	196	213	finally
    //   218	222	225	java/io/IOException
  }
  
  public static void saveBitmapToImage(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    Assert.assertTrue(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder("saving to ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    Log.d("MicroMsg.Util", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString1 = new File(localStringBuilder.toString());
    paramString1.createNewFile();
    try
    {
      paramString1 = new FileOutputStream(paramString1);
      paramBitmap.compress(paramCompressFormat, paramInt, paramString1);
      paramString1.flush();
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  /* Error */
  public static void saveBitmapToImage(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 512	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4: iconst_1
    //   5: ixor
    //   6: invokestatic 728	junit/framework/Assert:assertTrue	(Z)V
    //   9: new 209	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 1411
    //   16: invokespecial 435	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: astore 5
    //   21: aload 5
    //   23: aload_3
    //   24: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc_w 394
    //   31: aload 5
    //   33: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: new 216	java/io/File
    //   42: dup
    //   43: aload_3
    //   44: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 5
    //   49: aload 5
    //   51: invokevirtual 229	java/io/File:createNewFile	()Z
    //   54: pop
    //   55: aconst_null
    //   56: astore 6
    //   58: aconst_null
    //   59: astore_3
    //   60: new 231	java/io/FileOutputStream
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: astore 5
    //   71: aload_0
    //   72: aload_2
    //   73: iload_1
    //   74: aload 5
    //   76: invokevirtual 356	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   79: pop
    //   80: aload 5
    //   82: invokevirtual 245	java/io/FileOutputStream:flush	()V
    //   85: aload 5
    //   87: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   90: return
    //   91: astore_0
    //   92: aload 5
    //   94: astore_3
    //   95: goto +33 -> 128
    //   98: astore_2
    //   99: aload 5
    //   101: astore_0
    //   102: goto +11 -> 113
    //   105: astore_0
    //   106: goto +22 -> 128
    //   109: astore_2
    //   110: aload 6
    //   112: astore_0
    //   113: aload_0
    //   114: astore_3
    //   115: aload_2
    //   116: invokevirtual 253	java/io/FileNotFoundException:printStackTrace	()V
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   127: return
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   136: aload_0
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramBitmap	Bitmap
    //   0	138	1	paramInt	int
    //   0	138	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	138	3	paramString	String
    //   0	138	4	paramBoolean	boolean
    //   19	81	5	localObject1	Object
    //   56	55	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   71	85	91	finally
    //   71	85	98	java/io/FileNotFoundException
    //   60	71	105	finally
    //   115	119	105	finally
    //   60	71	109	java/io/FileNotFoundException
  }
  
  public static long secondsToMilliSeconds(int paramInt)
  {
    return paramInt * 1000L;
  }
  
  public static long secondsToNow(long paramLong)
  {
    return System.currentTimeMillis() / 1000L - paramLong;
  }
  
  public static void selectPicture(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.setType("image/*");
    localIntent = Intent.createChooser(localIntent, null);
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
  }
  
  public static void shake(Context paramContext, boolean paramBoolean)
  {
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null) {
      return;
    }
    if (paramBoolean)
    {
      paramContext.vibrate(bz, -1);
      return;
    }
    paramContext.cancel();
  }
  
  public static int[] splitToIntArray(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString.split(":");
    paramString = new ArrayList();
    int k = localObject.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      String str = localObject[i];
      if ((str != null) && (str.length() > 0)) {
        try
        {
          paramString.add(Integer.valueOf(Integer.valueOf(str).intValue()));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          Log.e("MicroMsg.Util", "invalid port num, ignore");
        }
      }
      i += 1;
    }
    localObject = new int[paramString.size()];
    i = j;
    while (i < localObject.length)
    {
      localObject[i] = ((Integer)paramString.get(i)).intValue();
      i += 1;
    }
    return localObject;
  }
  
  public static List<String> stringsToList(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        localArrayList.add(paramArrayOfString[i]);
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static long ticksToNow(long paramLong)
  {
    return SystemClock.elapsedRealtime() - paramLong;
  }
  
  public static void transClickToSelect(View paramView1, View paramView2)
  {
    paramView1.setOnTouchListener(new Util.2(paramView2, paramView1));
  }
  
  public static void writeToFile(String paramString1, String paramString2)
  {
    if ((isNullOrNil(paramString1)) && (isNullOrNil(paramString2)))
    {
      Object localObject = new File("/sdcard/Tencent/");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      localObject = new StringBuilder("/sdcard/Tencent/");
      ((StringBuilder)localObject).append(paramString2);
      paramString2 = new File(((StringBuilder)localObject).toString());
      if (paramString2.exists()) {}
    }
    try
    {
      paramString2.createNewFile();
      try
      {
        label78:
        paramString2 = new FileOutputStream(paramString2);
        paramString2.write(paramString1.getBytes());
        paramString2.close();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return;
    }
    catch (IOException localIOException)
    {
      break label78;
    }
  }
  
  /* Error */
  public static boolean writeToFile(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 512	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4: ifne +129 -> 133
    //   7: aload_1
    //   8: invokestatic 1486	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   11: ifeq +6 -> 17
    //   14: goto +119 -> 133
    //   17: aconst_null
    //   18: astore_3
    //   19: aconst_null
    //   20: astore_2
    //   21: new 231	java/io/FileOutputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 1487	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   29: astore_0
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 1483	java/io/FileOutputStream:write	([B)V
    //   35: aload_0
    //   36: invokevirtual 245	java/io/FileOutputStream:flush	()V
    //   39: aload_0
    //   40: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   43: goto +8 -> 51
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   51: ldc_w 394
    //   54: ldc_w 1489
    //   57: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: iconst_1
    //   61: ireturn
    //   62: astore_1
    //   63: aload_0
    //   64: astore_2
    //   65: aload_1
    //   66: astore_0
    //   67: goto +48 -> 115
    //   70: astore_1
    //   71: goto +10 -> 81
    //   74: astore_0
    //   75: goto +40 -> 115
    //   78: astore_1
    //   79: aload_3
    //   80: astore_0
    //   81: aload_0
    //   82: astore_2
    //   83: aload_1
    //   84: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   87: aload_0
    //   88: astore_2
    //   89: ldc_w 394
    //   92: ldc_w 1491
    //   95: invokestatic 1160	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: ifnull +14 -> 113
    //   102: aload_0
    //   103: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload_2
    //   116: ifnull +15 -> 131
    //   119: aload_2
    //   120: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   123: goto +8 -> 131
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   131: aload_0
    //   132: athrow
    //   133: ldc_w 394
    //   136: ldc_w 1493
    //   139: invokestatic 1160	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: iconst_0
    //   143: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramString	String
    //   0	144	1	paramArrayOfByte	byte[]
    //   20	100	2	str	String
    //   18	62	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	43	46	java/io/IOException
    //   30	39	62	finally
    //   30	39	70	java/lang/Exception
    //   21	30	74	finally
    //   83	87	74	finally
    //   89	98	74	finally
    //   21	30	78	java/lang/Exception
    //   102	106	108	java/io/IOException
    //   119	123	126	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Util
 * JD-Core Version:    0.7.0.1
 */