package com.tencent.av.core;

import android.os.Build;
import android.os.Build.VERSION;
import bhk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class VcSystemInfo
{
  static long c = 0L;
  private static final String d = "VcSystemInfo";
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 5;
  public static final int m = 6;
  public static final int n = 7;
  static int o = 0;
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d = 480;
  public int e = 320;
  public int f = 240;
  
  static
  {
    jdField_c_of_type_Long = 0L;
  }
  
  public VcSystemInfo()
  {
    this.jdField_a_of_type_JavaLangString = "N/A";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 320;
  }
  
  public static int a()
  {
    try
    {
      int i1 = new File("/sys/devices/system/cpu/").listFiles(new bhk()).length;
      return i1;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  public static long a()
  {
    long l2 = 0L;
    long l3 = l2;
    long l4 = l2;
    long l5 = l2;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
      long l1 = l2;
      if (localBufferedReader != null)
      {
        l3 = l2;
        l4 = l2;
        l5 = l2;
        String str = localBufferedReader.readLine().trim();
        l1 = l2;
        if (str != null)
        {
          l1 = l2;
          l3 = l2;
          l4 = l2;
          l5 = l2;
          if (str.length() > 0)
          {
            l3 = l2;
            l4 = l2;
            l5 = l2;
            l1 = Long.parseLong(str);
          }
        }
        l3 = l1;
        l4 = l1;
        l5 = l1;
        localBufferedReader.close();
      }
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      return l3;
    }
    catch (IOException localIOException)
    {
      return l4;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return l5;
  }
  
  public static String a()
  {
    return Build.MODEL;
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return true;
      if (o == 0) {
        o = a();
      }
      if (jdField_c_of_type_Long == 0L) {
        jdField_c_of_type_Long = a();
      }
    } while ((o <= 1) && (jdField_c_of_type_Long <= 1025000L));
    return false;
  }
  
  public static long b()
  {
    long l2 = 0L;
    long l3 = l2;
    long l4 = l2;
    long l5 = l2;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
      long l1 = l2;
      if (localBufferedReader != null)
      {
        l3 = l2;
        l4 = l2;
        l5 = l2;
        String str = localBufferedReader.readLine().trim();
        l1 = l2;
        if (str != null)
        {
          l1 = l2;
          l3 = l2;
          l4 = l2;
          l5 = l2;
          if (str.length() > 0)
          {
            l3 = l2;
            l4 = l2;
            l5 = l2;
            l1 = Long.parseLong(str);
          }
        }
        l3 = l1;
        l4 = l1;
        l5 = l1;
        localBufferedReader.close();
      }
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      return l3;
    }
    catch (IOException localIOException)
    {
      return l4;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return l5;
  }
  
  public static String b()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
  }
  
  /* Error */
  public static boolean b()
  {
    // Byte code:
    //   0: new 96	java/io/BufferedReader
    //   3: dup
    //   4: new 98	java/io/FileReader
    //   7: dup
    //   8: ldc 161
    //   10: invokespecial 101	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: invokespecial 104	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +16 -> 41
    //   28: iconst_0
    //   29: istore_0
    //   30: aload_3
    //   31: invokevirtual 125	java/io/BufferedReader:close	()V
    //   34: iload_0
    //   35: iconst_4
    //   36: if_icmpge +71 -> 107
    //   39: iconst_0
    //   40: ireturn
    //   41: aload 4
    //   43: ldc 163
    //   45: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   48: ifeq -31 -> 17
    //   51: aload 4
    //   53: bipush 58
    //   55: invokevirtual 171	java/lang/String:indexOf	(I)I
    //   58: istore_0
    //   59: iload_0
    //   60: iconst_1
    //   61: if_icmple +78 -> 139
    //   64: aload 4
    //   66: iload_0
    //   67: iconst_1
    //   68: iadd
    //   69: aload 4
    //   71: invokevirtual 116	java/lang/String:length	()I
    //   74: invokevirtual 175	java/lang/String:substring	(II)Ljava/lang/String;
    //   77: invokevirtual 113	java/lang/String:trim	()Ljava/lang/String;
    //   80: astore 4
    //   82: aload 4
    //   84: ifnull +55 -> 139
    //   87: aload 4
    //   89: invokevirtual 116	java/lang/String:length	()I
    //   92: ifle +47 -> 139
    //   95: aload 4
    //   97: invokestatic 122	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   100: lstore_1
    //   101: lload_1
    //   102: l2i
    //   103: istore_0
    //   104: goto -74 -> 30
    //   107: iconst_1
    //   108: ireturn
    //   109: astore_3
    //   110: iconst_0
    //   111: istore_0
    //   112: goto -78 -> 34
    //   115: astore_3
    //   116: goto -82 -> 34
    //   119: astore_3
    //   120: iconst_0
    //   121: istore_0
    //   122: goto -88 -> 34
    //   125: astore_3
    //   126: goto -92 -> 34
    //   129: astore_3
    //   130: iconst_0
    //   131: istore_0
    //   132: goto -98 -> 34
    //   135: astore_3
    //   136: goto -102 -> 34
    //   139: iconst_0
    //   140: istore_0
    //   141: goto -111 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	112	0	i1	int
    //   100	2	1	l1	long
    //   16	15	3	localBufferedReader	BufferedReader
    //   109	1	3	localNumberFormatException1	NumberFormatException
    //   115	1	3	localNumberFormatException2	NumberFormatException
    //   119	1	3	localIOException1	IOException
    //   125	1	3	localIOException2	IOException
    //   129	1	3	localFileNotFoundException1	FileNotFoundException
    //   135	1	3	localFileNotFoundException2	FileNotFoundException
    //   21	75	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	17	109	java/lang/NumberFormatException
    //   17	23	109	java/lang/NumberFormatException
    //   41	59	109	java/lang/NumberFormatException
    //   64	82	109	java/lang/NumberFormatException
    //   87	101	109	java/lang/NumberFormatException
    //   30	34	115	java/lang/NumberFormatException
    //   0	17	119	java/io/IOException
    //   17	23	119	java/io/IOException
    //   41	59	119	java/io/IOException
    //   64	82	119	java/io/IOException
    //   87	101	119	java/io/IOException
    //   30	34	125	java/io/IOException
    //   0	17	129	java/io/FileNotFoundException
    //   17	23	129	java/io/FileNotFoundException
    //   41	59	129	java/io/FileNotFoundException
    //   64	82	129	java/io/FileNotFoundException
    //   87	101	129	java/io/FileNotFoundException
    //   30	34	135	java/io/FileNotFoundException
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 98	java/io/FileReader
    //   7: dup
    //   8: ldc 161
    //   10: invokespecial 101	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 96	java/io/BufferedReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 104	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +34 -> 58
    //   27: aload_1
    //   28: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: ldc 177
    //   33: iconst_2
    //   34: invokevirtual 181	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   37: iconst_1
    //   38: aaload
    //   39: astore_2
    //   40: aload_0
    //   41: ifnull +7 -> 48
    //   44: aload_0
    //   45: invokevirtual 182	java/io/FileReader:close	()V
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 125	java/io/BufferedReader:close	()V
    //   56: aload_2
    //   57: areturn
    //   58: aload_0
    //   59: ifnull +7 -> 66
    //   62: aload_0
    //   63: invokevirtual 182	java/io/FileReader:close	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 125	java/io/BufferedReader:close	()V
    //   74: ldc 184
    //   76: areturn
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 182	java/io/FileReader:close	()V
    //   90: aload_1
    //   91: ifnull -17 -> 74
    //   94: aload_1
    //   95: invokevirtual 125	java/io/BufferedReader:close	()V
    //   98: goto -24 -> 74
    //   101: astore_0
    //   102: goto -28 -> 74
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_3
    //   109: astore_1
    //   110: aload_0
    //   111: ifnull +7 -> 118
    //   114: aload_0
    //   115: invokevirtual 182	java/io/FileReader:close	()V
    //   118: aload_1
    //   119: ifnull -45 -> 74
    //   122: aload_1
    //   123: invokevirtual 125	java/io/BufferedReader:close	()V
    //   126: goto -52 -> 74
    //   129: astore_0
    //   130: goto -56 -> 74
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 182	java/io/FileReader:close	()V
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 125	java/io/BufferedReader:close	()V
    //   154: aload_2
    //   155: athrow
    //   156: astore_0
    //   157: goto -109 -> 48
    //   160: astore_0
    //   161: aload_2
    //   162: areturn
    //   163: astore_0
    //   164: goto -98 -> 66
    //   167: astore_0
    //   168: goto -94 -> 74
    //   171: astore_0
    //   172: goto -82 -> 90
    //   175: astore_0
    //   176: goto -58 -> 118
    //   179: astore_0
    //   180: goto -34 -> 146
    //   183: astore_0
    //   184: goto -30 -> 154
    //   187: astore_2
    //   188: aconst_null
    //   189: astore_1
    //   190: goto -52 -> 138
    //   193: astore_2
    //   194: goto -56 -> 138
    //   197: astore_1
    //   198: aload_3
    //   199: astore_1
    //   200: goto -90 -> 110
    //   203: astore_2
    //   204: goto -94 -> 110
    //   207: astore_1
    //   208: aload_2
    //   209: astore_1
    //   210: goto -128 -> 82
    //   213: astore_2
    //   214: goto -132 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	50	0	localFileReader	FileReader
    //   77	1	0	localFileNotFoundException1	FileNotFoundException
    //   79	8	0	localObject1	Object
    //   101	1	0	localIOException1	IOException
    //   105	1	0	localIOException2	IOException
    //   107	8	0	localObject2	Object
    //   129	1	0	localIOException3	IOException
    //   135	8	0	localObject3	Object
    //   156	1	0	localIOException4	IOException
    //   160	1	0	localIOException5	IOException
    //   163	1	0	localIOException6	IOException
    //   167	1	0	localIOException7	IOException
    //   171	1	0	localIOException8	IOException
    //   175	1	0	localIOException9	IOException
    //   179	1	0	localIOException10	IOException
    //   183	1	0	localIOException11	IOException
    //   22	168	1	localObject4	Object
    //   197	1	1	localIOException12	IOException
    //   199	1	1	localObject5	Object
    //   207	1	1	localFileNotFoundException2	FileNotFoundException
    //   209	1	1	localIOException13	IOException
    //   3	78	2	str1	String
    //   133	29	2	str2	String
    //   187	1	2	localObject6	Object
    //   193	1	2	localObject7	Object
    //   203	6	2	localIOException14	IOException
    //   213	1	2	localFileNotFoundException3	FileNotFoundException
    //   1	198	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	77	java/io/FileNotFoundException
    //   94	98	101	java/io/IOException
    //   4	14	105	java/io/IOException
    //   122	126	129	java/io/IOException
    //   4	14	133	finally
    //   44	48	156	java/io/IOException
    //   52	56	160	java/io/IOException
    //   62	66	163	java/io/IOException
    //   70	74	167	java/io/IOException
    //   86	90	171	java/io/IOException
    //   114	118	175	java/io/IOException
    //   142	146	179	java/io/IOException
    //   150	154	183	java/io/IOException
    //   14	23	187	finally
    //   27	40	193	finally
    //   14	23	197	java/io/IOException
    //   27	40	203	java/io/IOException
    //   14	23	207	java/io/FileNotFoundException
    //   27	40	213	java/io/FileNotFoundException
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
        if (localBufferedReader == null)
        {
          return;
          if (!str.startsWith("Processor")) {
            continue;
          }
          i1 = str.indexOf(':');
          if (i1 > 1)
          {
            this.jdField_a_of_type_JavaLangString = str.substring(i1 + 1, str.length());
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.trim();
          }
        }
        str = localBufferedReader.readLine();
        if (str != null) {
          continue;
        }
        localBufferedReader.close();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        String str;
        int i1;
        long l1;
        continue;
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        continue;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      l1 = a();
      if (l1 > 0L) {
        this.jdField_a_of_type_Long = l1;
      }
      l1 = b();
      if (l1 > 0L) {
        this.jdField_b_of_type_Long = l1;
      }
      i1 = a();
      if (i1 <= 0) {
        continue;
      }
      this.jdField_b_of_type_Int = i1;
      return;
      if (str.startsWith("CPU architecture"))
      {
        i1 = str.indexOf(':');
        if (i1 > 1)
        {
          str = str.substring(i1 + 1, str.length()).trim();
          if ((str != null) && (str.length() > 0)) {
            this.jdField_a_of_type_Int = ((int)Long.parseLong(str));
          }
        }
      }
      else if (str.startsWith("Features"))
      {
        i1 = str.indexOf(':');
        if (i1 > 1) {
          this.jdField_b_of_type_JavaLangString = str.substring(i1 + 1, str.length()).trim();
        }
      }
      else if (str.startsWith("vendor_id"))
      {
        i1 = str.indexOf(':');
        if (i1 > 1) {
          this.jdField_c_of_type_JavaLangString = str.substring(i1 + 1, str.length()).trim();
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
  }
  
  public int b()
  {
    int i3 = 0;
    int i4 = 0;
    int i1 = 0;
    int i2 = i3;
    for (;;)
    {
      try
      {
        Object localObject1 = Class.forName("android.hardware.Camera");
        if (localObject1 == null) {
          return 0;
        }
        i2 = i3;
        Object localObject2 = Class.forName("android.hardware.Camera$CameraInfo");
        i2 = i4;
        if (localObject2 != null)
        {
          i2 = i3;
          Object localObject3 = ((Class)localObject1).getMethod("getNumberOfCameras", new Class[0]);
          i2 = i4;
          if (localObject3 != null)
          {
            i2 = i3;
            int i5 = Integer.parseInt(((Method)localObject3).invoke(null, new Object[0]).toString());
            i2 = i4;
            if (i5 >= 1)
            {
              i2 = i3;
              localObject1 = ((Class)localObject1).getMethod("getCameraInfo", new Class[] { Integer.TYPE, localObject2 });
              i2 = i4;
              if (localObject1 != null)
              {
                i2 = i3;
                localObject2 = ((Class)localObject2).newInstance();
                i2 = i3;
                localObject3 = localObject2.getClass().getField("facing");
                i2 = i3;
                Field localField1 = localObject2.getClass().getField("CAMERA_FACING_BACK");
                i2 = i3;
                Field localField2 = localObject2.getClass().getField("CAMERA_FACING_FRONT");
                i2 = i4;
                if (localObject3 != null)
                {
                  i2 = i4;
                  if (localField1 != null)
                  {
                    i2 = i4;
                    if (localField2 != null)
                    {
                      i3 = 0;
                      i2 = i1;
                      if (i3 < i5)
                      {
                        i2 = i1;
                        ((Method)localObject1).invoke(null, new Object[] { Integer.valueOf(i3), localObject2 });
                        i2 = i1;
                        if (((Field)localObject3).getInt(localObject2) == localField1.getInt(localObject2))
                        {
                          i2 = i1 + 1;
                        }
                        else
                        {
                          i2 = i1;
                          i4 = ((Field)localObject3).getInt(localObject2);
                          i2 = i1;
                          int i6 = localField2.getInt(localObject2);
                          i2 = i1;
                          if (i4 == i6) {
                            i2 = i1 + 2;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      catch (Exception localException) {}
      return i2;
      i3 += 1;
      i1 = i2;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public int c()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      if (str.equals("L")) {
        return 118;
      }
      if (Build.VERSION.SDK_INT == 20) {
        return 118;
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        int i2 = str.charAt(0);
        int i3 = str.charAt(2);
        int i1 = 0;
        if (str.length() >= 5) {
          i1 = str.charAt(4);
        }
        switch (i2)
        {
        default: 
          return 200;
        case 49: 
          if (i3 == 49) {
            return 101;
          }
          if (i3 == 53) {
            return 102;
          }
          if (i3 == 54) {
            return 103;
          }
          break;
        case 50: 
          if (i3 == 48)
          {
            if (i1 == 49) {
              return 105;
            }
            return 104;
          }
          if (i3 == 49) {
            return 106;
          }
          if (i3 == 50)
          {
            if (i1 == 49) {
              return 108;
            }
            return 107;
          }
          if ((i3 == 51) && (i1 >= 48) && (i1 <= 57)) {
            return 109;
          }
          break;
        case 51: 
          if (i3 == 48) {
            return 110;
          }
          if (i3 == 49) {
            return 111;
          }
          if (i3 == 50) {
            return 112;
          }
          break;
        case 52: 
          if (i3 == 48) {
            return 113;
          }
          if (i3 == 49) {
            return 114;
          }
          if (i3 == 50) {
            return 115;
          }
          if (i3 == 51) {
            return 116;
          }
          if (i3 == 52) {
            return 117;
          }
          break;
        case 53: 
          if (i3 == 48) {
            return 118;
          }
          break;
        }
      }
    }
    catch (Exception localException) {}
    return 200;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public int d()
  {
    int i2 = 2;
    if ((a().equals("XT882")) || (a().equals("ME860")) || (a().equals("MB860")) || (a().equals("Lenovo P70")) || (a().equals("Lenovo A60")) || (a().equals("Lenovo A366t"))) {
      i1 = 1;
    }
    do
    {
      return i1;
      if (this.jdField_a_of_type_Int != 7) {
        break;
      }
      i1 = i2;
    } while (this.jdField_b_of_type_JavaLangString.indexOf("neon") < 0);
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    int i1 = i2;
    switch (this.jdField_a_of_type_Int)
    {
    case 6: 
    default: 
      if ((this.jdField_c_of_type_JavaLangString != null) && ((this.jdField_c_of_type_JavaLangString.equalsIgnoreCase("AuthenticAMD")) || (this.jdField_c_of_type_JavaLangString.equalsIgnoreCase("GenuineIntel")))) {
        return 7;
      }
      break;
    case 5: 
      return 1;
    case 7: 
      return 4;
    case 8: 
      return 5;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.core.VcSystemInfo
 * JD-Core Version:    0.7.0.1
 */