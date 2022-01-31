package com.tencent.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity;
import com.tencent.qphone.base.util.QLog;
import fiz;
import fja;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class DumpMemInfoHandler
{
  public static final int a = 0;
  public static final String a = "/Tencent/QQLite/log/";
  public static final String[] a;
  public static final int b = 1;
  private static final String b = "DumpMemInfoHandler";
  public static final int c = 2;
  private static final String c = "com.tencent.qqlite";
  public static final int d = 3;
  private static String d = "";
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  private boolean jdField_a_of_type_Boolean = false;
  private fja[] jdField_a_of_type_ArrayOfFja = new fja[12];
  private Hashtable[] jdField_a_of_type_ArrayOfJavaUtilHashtable = new Hashtable[12];
  private String e;
  private int n = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
  }
  
  public DumpMemInfoHandler()
  {
    d = Environment.getExternalStorageDirectory().getPath() + "/Tencent/QQLite/log/";
    while (i1 < this.jdField_a_of_type_ArrayOfFja.length)
    {
      this.jdField_a_of_type_ArrayOfFja[i1] = new fja(this, null);
      this.jdField_a_of_type_ArrayOfJavaUtilHashtable[i1] = new Hashtable();
      i1 += 1;
    }
  }
  
  private static String a(long paramLong)
  {
    String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + BaseApplicationImpl.getContext().getPackageName().replace(".", "/") + "/";
    Object localObject1 = new SimpleDateFormat("yy.MM.dd.HH");
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(paramLong);
    localObject1 = ((SimpleDateFormat)localObject1).format(((Calendar)localObject2).getTime());
    localObject2 = MsfSdkUtils.getProcessName(BaseApplicationImpl.getContext());
    return str + ((String)localObject2).replace(":", "_") + "." + (String)localObject1 + ".log";
  }
  
  /* Error */
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 183	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 184	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 5
    //   11: new 186	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 9
    //   21: aload 5
    //   23: astore 7
    //   25: aload 9
    //   27: astore 6
    //   29: aload_0
    //   30: invokevirtual 193	java/io/File:length	()J
    //   33: lstore_3
    //   34: aload 5
    //   36: astore 7
    //   38: aload 9
    //   40: astore 6
    //   42: sipush 2048
    //   45: newarray byte
    //   47: astore_0
    //   48: iload_1
    //   49: i2l
    //   50: lload_3
    //   51: lcmp
    //   52: ifge +41 -> 93
    //   55: aload 5
    //   57: astore 7
    //   59: aload 9
    //   61: astore 6
    //   63: aload 9
    //   65: aload_0
    //   66: invokevirtual 197	java/io/FileInputStream:read	([B)I
    //   69: istore_2
    //   70: aload 5
    //   72: astore 7
    //   74: aload 9
    //   76: astore 6
    //   78: aload 5
    //   80: aload_0
    //   81: iconst_0
    //   82: iload_2
    //   83: invokevirtual 201	java/io/ByteArrayOutputStream:write	([BII)V
    //   86: iload_1
    //   87: iload_2
    //   88: iadd
    //   89: istore_1
    //   90: goto -42 -> 48
    //   93: aload 5
    //   95: astore 7
    //   97: aload 9
    //   99: astore 6
    //   101: new 51	java/lang/String
    //   104: dup
    //   105: aload 5
    //   107: invokevirtual 205	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   110: ldc 207
    //   112: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   115: astore_0
    //   116: aload 5
    //   118: ifnull +8 -> 126
    //   121: aload 5
    //   123: invokevirtual 213	java/io/ByteArrayOutputStream:close	()V
    //   126: aload 9
    //   128: ifnull +8 -> 136
    //   131: aload 9
    //   133: invokevirtual 214	java/io/FileInputStream:close	()V
    //   136: aload_0
    //   137: areturn
    //   138: astore 5
    //   140: aload 5
    //   142: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   145: aload_0
    //   146: areturn
    //   147: astore 8
    //   149: aconst_null
    //   150: astore 5
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 5
    //   156: astore 7
    //   158: aload_0
    //   159: astore 6
    //   161: aload 8
    //   163: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   166: aload 5
    //   168: ifnull +8 -> 176
    //   171: aload 5
    //   173: invokevirtual 213	java/io/ByteArrayOutputStream:close	()V
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 214	java/io/FileInputStream:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_0
    //   194: aconst_null
    //   195: astore 5
    //   197: aconst_null
    //   198: astore 6
    //   200: aload 5
    //   202: ifnull +8 -> 210
    //   205: aload 5
    //   207: invokevirtual 213	java/io/ByteArrayOutputStream:close	()V
    //   210: aload 6
    //   212: ifnull +8 -> 220
    //   215: aload 6
    //   217: invokevirtual 214	java/io/FileInputStream:close	()V
    //   220: aload_0
    //   221: athrow
    //   222: astore 5
    //   224: aload 5
    //   226: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   229: goto -9 -> 220
    //   232: astore_0
    //   233: aconst_null
    //   234: astore 6
    //   236: goto -36 -> 200
    //   239: astore_0
    //   240: aload 7
    //   242: astore 5
    //   244: goto -44 -> 200
    //   247: astore 8
    //   249: aconst_null
    //   250: astore_0
    //   251: goto -97 -> 154
    //   254: astore 8
    //   256: aload 9
    //   258: astore_0
    //   259: goto -105 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramFile	File
    //   1	89	1	i1	int
    //   69	20	2	i2	int
    //   33	18	3	l1	long
    //   9	113	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   138	3	5	localIOException1	java.io.IOException
    //   150	56	5	localObject1	Object
    //   222	3	5	localIOException2	java.io.IOException
    //   242	1	5	localObject2	Object
    //   27	208	6	localObject3	Object
    //   23	218	7	localObject4	Object
    //   147	15	8	localIOException3	java.io.IOException
    //   247	1	8	localIOException4	java.io.IOException
    //   254	1	8	localIOException5	java.io.IOException
    //   19	238	9	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   121	126	138	java/io/IOException
    //   131	136	138	java/io/IOException
    //   2	11	147	java/io/IOException
    //   171	176	186	java/io/IOException
    //   180	184	186	java/io/IOException
    //   2	11	193	finally
    //   205	210	222	java/io/IOException
    //   215	220	222	java/io/IOException
    //   11	21	232	finally
    //   29	34	239	finally
    //   42	48	239	finally
    //   63	70	239	finally
    //   78	86	239	finally
    //   101	116	239	finally
    //   161	166	239	finally
    //   11	21	247	java/io/IOException
    //   29	34	254	java/io/IOException
    //   42	48	254	java/io/IOException
    //   63	70	254	java/io/IOException
    //   78	86	254	java/io/IOException
    //   101	116	254	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    int i2 = 0;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DumpMemInfoHandler", 2, "ReportLog dumpHprof : " + paramString);
      }
      if (paramString.endsWith("_send")) {
        paramString = paramString.substring(0, paramString.length() - "_send".length());
      }
      Object localObject2;
      for (int i1 = 1;; i1 = 0)
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = new SimpleDateFormat("yy-MM-dd_HH.mm.ss");
        long l1 = System.currentTimeMillis();
        String str1 = ((SimpleDateFormat)localObject1).format(new Date(l1));
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          localObject1 = new File(Environment.getExternalStorageDirectory().getPath() + "/Tencent/QQLite/log/");
          if (!((File)localObject1).exists()) {
            ((File)localObject1).mkdirs();
          }
          localObject2 = ((File)localObject1).getAbsolutePath();
          localObject1 = localObject2;
          if (!((String)localObject2).endsWith("/")) {
            localObject1 = (String)localObject2 + "/";
          }
          localObject1 = (String)localObject1 + "dump_" + paramString + "_" + str1 + ".hprof";
          Debug.dumpHprofData((String)localObject1);
          localArrayList.add(localObject1);
          if (paramString.startsWith("mobileqq"))
          {
            localObject1 = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
              String str2 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
              if (str2.startsWith("com.tencent.qqlite"))
              {
                localObject2 = new DumpMemInfoHandler().a(((ActivityManager.RunningAppProcessInfo)localObject2).pid, str2, str1);
                if (localObject2 != null) {
                  localArrayList.add(localObject2);
                }
              }
            }
          }
        }
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          localObject2 = new ArrayList();
          while (i2 < localArrayList.size())
          {
            ((ArrayList)localObject2).add(new File((String)localArrayList.get(i2)));
            i2 += 1;
          }
          ((ArrayList)localObject2).add(new File(AppConstants.at + "log.txt"));
          ((ArrayList)localObject2).add(new File(a(l1)));
          ((ArrayList)localObject2).add(new File(a(l1 - 3600000L)));
          localObject1 = d + "dump_" + paramString + "_" + str1 + ".zip";
          try
          {
            boolean bool = a((ArrayList)localObject2, (String)localObject1);
            if ((bool) && (paramString.startsWith("mobileqq_leak")) && (i1 != 0))
            {
              localObject2 = new Intent(BaseActivity.sTopActivity, ShareDumpMemoryActivity.class);
              ((Intent)localObject2).putExtra("dumpFilePath", (String)localObject1);
              BaseActivity.sTopActivity.startActivity((Intent)localObject2);
            }
            localObject2 = localObject1;
            if (!bool) {
              break;
            }
            localObject2 = localObject1;
            if (!paramString.startsWith("mobileqq_qzone_leak")) {
              break;
            }
            localObject2 = localObject1;
            if (i1 == 0) {
              break;
            }
            paramString = new Intent(BaseApplicationImpl.getContext(), ShareDumpMemoryActivity.class);
            paramString.putExtra("dumpFilePath", (String)localObject1);
            paramString.addFlags(268435456);
            BaseApplicationImpl.getContext().startActivity(paramString);
            return localObject1;
          }
          catch (Throwable paramString)
          {
            return localObject1;
          }
        }
        return "";
      }
      return localObject2;
    }
    catch (Throwable paramString)
    {
      localObject2 = "";
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("\n====== [" + paramString1 + " " + paramString2 + " smaps begin] =======\n");
    ((StringBuffer)localObject).append(String.format("TotalPss%8dK\n", new Object[] { Integer.valueOf(this.n) }));
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfFja.length)
    {
      ((StringBuffer)localObject).append(String.format("\n\n%-11s    %dK\n", new Object[] { jdField_a_of_type_ArrayOfJavaLangString[i1], Long.valueOf(this.jdField_a_of_type_ArrayOfFja[i1].a) }));
      if (this.jdField_a_of_type_ArrayOfJavaUtilHashtable[i1].size() > 0)
      {
        Map.Entry[] arrayOfEntry = a(this.jdField_a_of_type_ArrayOfJavaUtilHashtable[i1]);
        int i2 = 0;
        while (i2 < arrayOfEntry.length)
        {
          ((StringBuffer)localObject).append(String.format("%10dK    %s\n", new Object[] { arrayOfEntry[i2].getValue(), arrayOfEntry[i2].getKey() }));
          i2 += 1;
        }
      }
      i1 += 1;
    }
    ((StringBuffer)localObject).append("\n====== [" + paramString1 + " smaps end] =======\n");
    localObject = ((StringBuffer)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.i("DumpMemInfoHandler", 2, (String)localObject);
    }
    paramString1 = d + "dump_" + b(paramString1) + "_" + paramString2 + ".smaps";
    paramString2 = new BufferedWriter(new FileWriter(paramString1));
    paramString2.write((String)localObject);
    paramString2.close();
    return paramString1;
  }
  
  private void a(String paramString)
  {
    paramString = Runtime.getRuntime().exec(new String[] { "/system/bin/sh", "-c", paramString });
    new StreamGobbler(paramString.getErrorStream(), "ERROR").start();
    new StreamGobbler(paramString.getInputStream(), "STDOUT").start();
    paramString.waitFor();
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n====== [" + paramString1 + " " + paramString3 + " meminfo begin] =======\n");
    localStringBuffer.append(a(new File(paramString2)));
    localStringBuffer.append("\n====== [" + paramString1 + " meminfo end] =======\n");
    if (QLog.isColorLevel()) {
      QLog.i("DumpMemInfoHandler", 2, localStringBuffer.toString());
    }
  }
  
  /* Error */
  public static boolean a(ArrayList paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 506	java/io/FileOutputStream
    //   3: dup
    //   4: new 104	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 268	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 507	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: astore_1
    //   16: new 509	java/util/zip/ZipOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 512	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore 8
    //   26: aload_0
    //   27: invokevirtual 513	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   30: astore_0
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_0
    //   34: invokeinterface 317 1 0
    //   39: ifeq +164 -> 203
    //   42: aload_0
    //   43: invokeinterface 321 1 0
    //   48: checkcast 104	java/io/File
    //   51: astore 9
    //   53: aload 9
    //   55: invokevirtual 271	java/io/File:exists	()Z
    //   58: ifeq +180 -> 238
    //   61: aload 8
    //   63: new 515	java/util/zip/ZipEntry
    //   66: dup
    //   67: aload 9
    //   69: invokevirtual 518	java/io/File:getName	()Ljava/lang/String;
    //   72: invokespecial 519	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 523	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   78: aload 8
    //   80: bipush 9
    //   82: invokevirtual 527	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   85: aload 9
    //   87: invokevirtual 193	java/io/File:length	()J
    //   90: lstore 6
    //   92: new 186	java/io/FileInputStream
    //   95: dup
    //   96: aload 9
    //   98: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   101: astore 9
    //   103: sipush 20480
    //   106: newarray byte
    //   108: astore 10
    //   110: lconst_0
    //   111: lstore 4
    //   113: aload 9
    //   115: aload 10
    //   117: iconst_0
    //   118: sipush 20480
    //   121: invokevirtual 530	java/io/FileInputStream:read	([BII)I
    //   124: istore_3
    //   125: iload_3
    //   126: iconst_m1
    //   127: if_icmpeq +29 -> 156
    //   130: aload 8
    //   132: aload 10
    //   134: iconst_0
    //   135: iload_3
    //   136: invokevirtual 531	java/util/zip/ZipOutputStream:write	([BII)V
    //   139: iload_3
    //   140: i2l
    //   141: lload 4
    //   143: ladd
    //   144: lstore 4
    //   146: lload 4
    //   148: lload 6
    //   150: lcmp
    //   151: iflt +82 -> 233
    //   154: iconst_1
    //   155: istore_2
    //   156: aload 9
    //   158: invokevirtual 214	java/io/FileInputStream:close	()V
    //   161: aload 8
    //   163: invokevirtual 534	java/util/zip/ZipOutputStream:flush	()V
    //   166: aload 8
    //   168: invokevirtual 537	java/util/zip/ZipOutputStream:closeEntry	()V
    //   171: goto +67 -> 238
    //   174: astore_0
    //   175: aload 9
    //   177: invokevirtual 214	java/io/FileInputStream:close	()V
    //   180: aload 8
    //   182: invokevirtual 534	java/util/zip/ZipOutputStream:flush	()V
    //   185: aload 8
    //   187: invokevirtual 537	java/util/zip/ZipOutputStream:closeEntry	()V
    //   190: aload_0
    //   191: athrow
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   197: aload_1
    //   198: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: iload_2
    //   204: ifeq +8 -> 212
    //   207: aload 8
    //   209: invokevirtual 539	java/util/zip/ZipOutputStream:close	()V
    //   212: aload_1
    //   213: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   216: iconst_1
    //   217: ireturn
    //   218: astore_0
    //   219: aload_1
    //   220: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   223: aload_0
    //   224: athrow
    //   225: astore_0
    //   226: aload_0
    //   227: invokevirtual 540	java/lang/Exception:printStackTrace	()V
    //   230: goto -29 -> 201
    //   233: iconst_1
    //   234: istore_2
    //   235: goto -122 -> 113
    //   238: goto -205 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramArrayList	ArrayList
    //   0	241	1	paramString	String
    //   32	203	2	i1	int
    //   124	16	3	i2	int
    //   111	36	4	l1	long
    //   90	59	6	l2	long
    //   24	184	8	localZipOutputStream	java.util.zip.ZipOutputStream
    //   51	125	9	localObject	Object
    //   108	25	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   103	110	174	finally
    //   113	125	174	finally
    //   130	139	174	finally
    //   26	31	192	java/io/IOException
    //   33	103	192	java/io/IOException
    //   156	171	192	java/io/IOException
    //   175	192	192	java/io/IOException
    //   207	212	192	java/io/IOException
    //   26	31	218	finally
    //   33	103	218	finally
    //   156	171	218	finally
    //   175	192	218	finally
    //   193	197	218	finally
    //   207	212	218	finally
    //   0	26	225	java/lang/Exception
    //   197	201	225	java/lang/Exception
    //   212	216	225	java/lang/Exception
    //   219	225	225	java/lang/Exception
  }
  
  private Map.Entry[] a(Hashtable paramHashtable)
  {
    paramHashtable = paramHashtable.entrySet();
    paramHashtable = (Map.Entry[])paramHashtable.toArray(new Map.Entry[paramHashtable.size()]);
    Arrays.sort(paramHashtable, new fiz(this));
    return paramHashtable;
  }
  
  private String b(int paramInt, String paramString1, String paramString2)
  {
    String str1 = "/proc/" + paramInt + "/smaps";
    String str2 = d + b(paramString1) + paramString2;
    a("cat " + str1 + " > " + str2);
    if (this.jdField_a_of_type_Boolean)
    {
      this.e = (d + b(paramString1) + paramString2 + ".meminfo");
      a("dumpsys meminfo " + paramString1 + " > " + this.e);
    }
    return str2;
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String[] arrayOfString;
    String str;
    do
    {
      return paramString;
      arrayOfString = paramString.split(":");
      paramString = arrayOfString[0].split("\\.");
      str = paramString[(paramString.length - 1)];
      paramString = str;
    } while (arrayOfString.length <= 1);
    return str + "_" + arrayOfString[1];
  }
  
  private void b(String paramString)
  {
    int i5 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    long l1 = 0L;
    int i1 = 0;
    File localFile = new File(paramString);
    label34:
    BufferedReader localBufferedReader;
    Object localObject2;
    Object localObject1;
    label68:
    int i6;
    if (localFile.exists())
    {
      localBufferedReader = new BufferedReader(new FileReader(paramString));
      localObject2 = localBufferedReader.readLine();
      i1 = 11;
      localObject1 = "";
      paramString = "";
      for (;;)
      {
        if (i5 != 0) {
          break label957;
        }
        i6 = 11;
        if (((String)localObject2).length() >= 1) {
          break;
        }
        i1 = 11;
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(500L);
        if (i1 >= 10) {
          break label34;
        }
        i1 += 1;
        break;
        if ((((String)localObject2).length() > 30) && (((String)localObject2).charAt(8) == '-') && (((String)localObject2).charAt(17) == ' '))
        {
          paramString = ((String)localObject2).split(" ");
          localObject2 = paramString[0].split("-");
          long l3 = Long.parseLong(localObject2[0], 16);
          long l2 = Long.parseLong(localObject2[1], 16);
          i6 = 5;
          if ((i6 < paramString.length) && (paramString[i6].equals("")))
          {
            i6 += 1;
            continue;
          }
          if (i6 < paramString.length)
          {
            paramString = paramString[i6];
            i6 = paramString.length();
            if (!paramString.equals("[heap]")) {
              continue;
            }
            i1 = 0;
            i7 = 0;
            i6 = i1;
            l1 = l2;
            i1 = i2;
            i2 = i4;
            localObject2 = localBufferedReader.readLine();
            if (localObject2 != null) {
              continue;
            }
            i4 = 1;
            if (i7 != 0) {
              continue;
            }
            localObject1 = this.jdField_a_of_type_ArrayOfJavaUtilHashtable[i6];
            if (!((Hashtable)localObject1).containsKey(paramString)) {
              continue;
            }
            ((Hashtable)localObject1).put(paramString, Integer.valueOf(((Integer)((Hashtable)localObject1).get(paramString)).intValue() + i1));
            localObject1 = this.jdField_a_of_type_ArrayOfFja[i6];
            ((fja)localObject1).a += i1;
            localObject1 = this.jdField_a_of_type_ArrayOfFja[i6];
            ((fja)localObject1).b += i2;
            localObject1 = this.jdField_a_of_type_ArrayOfFja[i6];
            ((fja)localObject1).c += i3;
            this.n += i1;
            localObject1 = paramString;
            i5 = i4;
            i4 = i2;
            i2 = i1;
            i1 = i6;
            break label68;
          }
          paramString = "";
          continue;
          if (paramString.startsWith("/dev/ashmem/dalvik-"))
          {
            i1 = 1;
            continue;
          }
          if (paramString.startsWith("/dev/ashmem/CursorWindow"))
          {
            i1 = 2;
            continue;
          }
          if (paramString.startsWith("/dev/ashmem/"))
          {
            i1 = 3;
            continue;
          }
          if (paramString.startsWith("/dev/"))
          {
            i1 = 4;
            continue;
          }
          if (paramString.endsWith(".so"))
          {
            i1 = 5;
            continue;
          }
          if (paramString.endsWith(".jar"))
          {
            i1 = 6;
            continue;
          }
          if (paramString.endsWith(".apk"))
          {
            i1 = 7;
            continue;
          }
          if (paramString.endsWith(".ttf"))
          {
            i1 = 8;
            continue;
          }
          if (paramString.endsWith(".dex"))
          {
            i1 = 9;
            continue;
          }
          if (i6 > 0)
          {
            i1 = 10;
            continue;
          }
          if ((l3 != l1) || (i1 != 5)) {
            break label1026;
          }
          i1 = 5;
          paramString = (String)localObject1;
          continue;
        }
        i1 = i2;
        int i7 = 1;
        i2 = i4;
        continue;
        String[] arrayOfString = ((String)localObject2).split(" ");
        String str = arrayOfString[0];
        i8 = 0;
        i4 = 1;
        try
        {
          if ((i4 < arrayOfString.length) && (arrayOfString[i4].equals("")))
          {
            i4 += 1;
            continue;
          }
          if (i4 >= arrayOfString.length) {
            continue;
          }
          i4 = Integer.parseInt(arrayOfString[i4]);
        }
        catch (Exception localException)
        {
          i4 = i8;
          continue;
        }
        if (str.equals("Size:"))
        {
          i4 = i2;
          i2 = i3;
          i3 = i1;
          i1 = i4;
          i4 = i3;
          i3 = i2;
          i2 = i1;
          i1 = i4;
          continue;
          i4 = 0;
          continue;
        }
        if (str.equals("Rss:"))
        {
          i4 = i1;
          i1 = i2;
          i2 = i3;
          i3 = i4;
          continue;
        }
        if (str.equals("Pss:"))
        {
          i1 = i2;
          i2 = i3;
          i3 = i4;
          continue;
        }
        if (str.equals("Shared_Clean:"))
        {
          i4 = i1;
          i1 = i2;
          i2 = i3;
          i3 = i4;
          continue;
        }
        if (str.equals("Shared_Dirty:"))
        {
          i3 = i1;
          i1 = i2;
          i2 = i4;
          continue;
        }
        if (str.equals("Private_Clean:"))
        {
          i4 = i1;
          i1 = i2;
          i2 = i3;
          i3 = i4;
          continue;
        }
        if (str.equals("Private_Dirty:"))
        {
          i2 = i3;
          i3 = i1;
          i1 = i4;
          continue;
        }
        if (str.equals("Referenced:"))
        {
          i4 = i1;
          i1 = i2;
          i2 = i3;
          i3 = i4;
          continue;
        }
        if ((((String)localObject2).length() <= 30) || (((String)localObject2).charAt(8) != '-') || (((String)localObject2).charAt(17) != ' ')) {
          break label1011;
        }
        System.out.println((String)localObject2);
        i4 = i5;
        continue;
        ((Hashtable)localObject1).put(paramString, Integer.valueOf(i1));
        continue;
        label957:
        localBufferedReader.close();
        if ((localFile != null) && (localFile.exists())) {
          localFile.delete();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        int i8;
        continue;
        i5 = i4;
        i4 = i2;
        i2 = i1;
        i1 = i6;
      }
      break label68;
      label1011:
      i4 = i1;
      i1 = i2;
      i2 = i3;
      i3 = i4;
      continue;
      label1026:
      i1 = 11;
    }
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new File(d);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        ((File)localObject).mkdirs();
      }
      localObject = b(paramInt, paramString1, paramString2);
      if (this.jdField_a_of_type_Boolean) {
        a(paramString1, this.e, paramString2);
      }
      b((String)localObject);
      paramString1 = a(paramString1, paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.util.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */