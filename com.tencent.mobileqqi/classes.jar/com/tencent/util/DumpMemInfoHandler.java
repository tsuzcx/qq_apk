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
import com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import huq;
import hur;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class DumpMemInfoHandler
{
  public static final String a = "/Tencent/MobileQQ/log/";
  private static final String b = "DumpMemInfoHandler";
  private static final String c = "com.tencent.mobileqqi";
  private static String d = "";
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = false;
  private hur[] jdField_a_of_type_ArrayOfHur = new hur[DumpMemInfoHandler.Heap.values().length];
  private Hashtable[] jdField_a_of_type_ArrayOfJavaUtilHashtable = new Hashtable[DumpMemInfoHandler.Heap.values().length];
  private String e;
  
  public DumpMemInfoHandler()
  {
    d = Environment.getExternalStorageDirectory().getPath() + "/Tencent/MobileQQ/log/";
    while (i < this.jdField_a_of_type_ArrayOfHur.length)
    {
      this.jdField_a_of_type_ArrayOfHur[i] = new hur(this, null);
      this.jdField_a_of_type_ArrayOfJavaUtilHashtable[i] = new Hashtable();
      i += 1;
    }
  }
  
  private String a(String paramString)
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
  
  private String a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("\n====== [" + paramString1 + " " + paramString2 + " smaps begin] =======\n");
    DumpMemInfoHandler.Heap[] arrayOfHeap = DumpMemInfoHandler.Heap.values();
    ((StringBuffer)localObject).append(String.format("TotalPss%8dK\n", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfHur.length)
    {
      ((StringBuffer)localObject).append(String.format("\n\n%-11s    %dK\n", new Object[] { arrayOfHeap[i].name(), Long.valueOf(this.jdField_a_of_type_ArrayOfHur[i].a) }));
      if (this.jdField_a_of_type_ArrayOfJavaUtilHashtable[i].size() > 0)
      {
        Map.Entry[] arrayOfEntry = a(this.jdField_a_of_type_ArrayOfJavaUtilHashtable[i]);
        int j = 0;
        while (j < arrayOfEntry.length)
        {
          ((StringBuffer)localObject).append(String.format("%10dK    %s\n", new Object[] { arrayOfEntry[j].getValue(), arrayOfEntry[j].getKey() }));
          j += 1;
        }
      }
      i += 1;
    }
    ((StringBuffer)localObject).append("\n====== [" + paramString1 + " smaps end] =======\n");
    localObject = ((StringBuffer)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.i("DumpMemInfoHandler", 2, (String)localObject);
    }
    paramString1 = d + "dump_" + a(paramString1) + "_" + paramString2 + ".smaps";
    paramString2 = new BufferedWriter(new FileWriter(paramString1));
    paramString2.write((String)localObject);
    paramString2.close();
    return paramString1;
  }
  
  public static void a(String paramString)
  {
    int j = 0;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DumpMemInfoHandler", 2, "ReportLog dumpHprof : " + paramString);
      }
      if (paramString.endsWith("_send")) {
        paramString = paramString.substring(0, paramString.length() - "_send".length());
      }
      for (int i = 1;; i = 0)
      {
        ArrayList localArrayList = new ArrayList();
        String str1 = new SimpleDateFormat("yy-MM-dd_HH.mm.ss").format(new Date(System.currentTimeMillis()));
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          localObject1 = new File(Environment.getExternalStorageDirectory().getPath() + "/Tencent/MobileQQ/log/");
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
              if (str2.startsWith("com.tencent.mobileqqi"))
              {
                localObject2 = new DumpMemInfoHandler().a(((ActivityManager.RunningAppProcessInfo)localObject2).pid, str2, str1);
                if (localObject2 != null) {
                  localArrayList.add(localObject2);
                }
              }
            }
          }
        }
        if ((localArrayList == null) || (localArrayList.size() <= 0)) {
          break;
        }
        Object localObject1 = new ArrayList();
        while (j < localArrayList.size())
        {
          ((ArrayList)localObject1).add(new File((String)localArrayList.get(j)));
          j += 1;
        }
        ((ArrayList)localObject1).add(new File(AppConstants.ao + "log.txt"));
        Object localObject2 = d + "dump_" + paramString + "_" + str1 + ".zip";
        boolean bool = a((ArrayList)localObject1, (String)localObject2);
        if ((bool) && (paramString.startsWith("mobileqq_leak")) && (i != 0))
        {
          localObject1 = new Intent(BaseActivity.a, ShareDumpMemoryActivity.class);
          ((Intent)localObject1).putExtra("dumpFilePath", (String)localObject2);
          BaseActivity.a.startActivity((Intent)localObject1);
        }
        if ((!bool) || (!paramString.startsWith("mobileqq_qzone_leak")) || (i == 0)) {
          break;
        }
        paramString = new Intent(BaseApplicationImpl.getContext(), ShareDumpMemoryActivity.class);
        paramString.putExtra("dumpFilePath", (String)localObject2);
        paramString.addFlags(268435456);
        BaseApplicationImpl.getContext().startActivity(paramString);
        return;
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n====== [" + paramString1 + " " + paramString3 + " meminfo begin] =======\n");
    localStringBuffer.append(FileUtils.a(new File(paramString2)));
    localStringBuffer.append("\n====== [" + paramString1 + " meminfo end] =======\n");
    if (QLog.isColorLevel()) {
      QLog.i("DumpMemInfoHandler", 2, localStringBuffer.toString());
    }
  }
  
  /* Error */
  public static boolean a(ArrayList paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 366	java/io/FileOutputStream
    //   3: dup
    //   4: new 59	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 229	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 369	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: astore_1
    //   16: new 371	java/util/zip/ZipOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 374	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore 8
    //   26: aload_0
    //   27: invokevirtual 375	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   30: astore_0
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_0
    //   34: invokeinterface 286 1 0
    //   39: ifeq +164 -> 203
    //   42: aload_0
    //   43: invokeinterface 289 1 0
    //   48: checkcast 59	java/io/File
    //   51: astore 9
    //   53: aload 9
    //   55: invokevirtual 232	java/io/File:exists	()Z
    //   58: ifeq +180 -> 238
    //   61: aload 8
    //   63: new 377	java/util/zip/ZipEntry
    //   66: dup
    //   67: aload 9
    //   69: invokevirtual 380	java/io/File:getName	()Ljava/lang/String;
    //   72: invokespecial 381	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 385	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   78: aload 8
    //   80: bipush 9
    //   82: invokevirtual 389	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   85: aload 9
    //   87: invokevirtual 391	java/io/File:length	()J
    //   90: lstore 6
    //   92: new 393	java/io/FileInputStream
    //   95: dup
    //   96: aload 9
    //   98: invokespecial 394	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   121: invokevirtual 398	java/io/FileInputStream:read	([BII)I
    //   124: istore_3
    //   125: iload_3
    //   126: iconst_m1
    //   127: if_icmpeq +29 -> 156
    //   130: aload 8
    //   132: aload 10
    //   134: iconst_0
    //   135: iload_3
    //   136: invokevirtual 401	java/util/zip/ZipOutputStream:write	([BII)V
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
    //   158: invokevirtual 402	java/io/FileInputStream:close	()V
    //   161: aload 8
    //   163: invokevirtual 405	java/util/zip/ZipOutputStream:flush	()V
    //   166: aload 8
    //   168: invokevirtual 408	java/util/zip/ZipOutputStream:closeEntry	()V
    //   171: goto +67 -> 238
    //   174: astore_0
    //   175: aload 9
    //   177: invokevirtual 402	java/io/FileInputStream:close	()V
    //   180: aload 8
    //   182: invokevirtual 405	java/util/zip/ZipOutputStream:flush	()V
    //   185: aload 8
    //   187: invokevirtual 408	java/util/zip/ZipOutputStream:closeEntry	()V
    //   190: aload_0
    //   191: athrow
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 411	java/io/IOException:printStackTrace	()V
    //   197: aload_1
    //   198: invokevirtual 412	java/io/FileOutputStream:close	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: iload_2
    //   204: ifeq +8 -> 212
    //   207: aload 8
    //   209: invokevirtual 413	java/util/zip/ZipOutputStream:close	()V
    //   212: aload_1
    //   213: invokevirtual 412	java/io/FileOutputStream:close	()V
    //   216: iconst_1
    //   217: ireturn
    //   218: astore_0
    //   219: aload_1
    //   220: invokevirtual 412	java/io/FileOutputStream:close	()V
    //   223: aload_0
    //   224: athrow
    //   225: astore_0
    //   226: aload_0
    //   227: invokevirtual 414	java/lang/Exception:printStackTrace	()V
    //   230: goto -29 -> 201
    //   233: iconst_1
    //   234: istore_2
    //   235: goto -122 -> 113
    //   238: goto -205 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramArrayList	ArrayList
    //   0	241	1	paramString	String
    //   32	203	2	i	int
    //   124	16	3	j	int
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
    Arrays.sort(paramHashtable, new huq(this));
    return paramHashtable;
  }
  
  private String b(int paramInt, String paramString1, String paramString2)
  {
    String str1 = "/proc/" + paramInt + "/smaps";
    String str2 = d + a(paramString1) + paramString2;
    b("cat " + str1 + " > " + str2);
    if (this.jdField_a_of_type_Boolean)
    {
      this.e = (d + a(paramString1) + paramString2 + ".meminfo");
      b("dumpsys meminfo " + paramString1 + " > " + this.e);
    }
    return str2;
  }
  
  private void b(String paramString)
  {
    paramString = Runtime.getRuntime().exec(new String[] { "/system/bin/sh", "-c", paramString });
    new StreamGobbler(paramString.getErrorStream(), "ERROR").start();
    new StreamGobbler(paramString.getInputStream(), "STDOUT").start();
    paramString.waitFor();
  }
  
  private void c(String paramString)
  {
    int n = 0;
    int m = 0;
    int j = 0;
    int k = 0;
    long l1 = 0L;
    Object localObject1 = DumpMemInfoHandler.Heap.UNKNOWN;
    Object localObject2 = DumpMemInfoHandler.Heap.UNKNOWN;
    int i = 0;
    File localFile = new File(paramString);
    label44:
    BufferedReader localBufferedReader;
    Object localObject4;
    label78:
    Object localObject3;
    if (localFile.exists())
    {
      localBufferedReader = new BufferedReader(new FileReader(paramString));
      localObject4 = localBufferedReader.readLine();
      localObject2 = "";
      paramString = "";
      i = m;
      for (;;)
      {
        if (n != 0) {
          break label1101;
        }
        localObject3 = DumpMemInfoHandler.Heap.UNKNOWN;
        if (((String)localObject4).length() >= 1) {
          break;
        }
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(500L);
        if (i >= 10) {
          break label44;
        }
        i += 1;
        break;
        if ((((String)localObject4).length() > 30) && (((String)localObject4).charAt(8) == '-') && (((String)localObject4).charAt(17) == ' '))
        {
          paramString = ((String)localObject4).split(" ");
          localObject4 = paramString[0].split("-");
          long l3 = Long.parseLong(localObject4[0], 16);
          long l2 = Long.parseLong(localObject4[1], 16);
          m = 5;
          if ((m < paramString.length) && (paramString[m].equals("")))
          {
            m += 1;
            continue;
          }
          if (m < paramString.length)
          {
            paramString = paramString[m];
            m = paramString.length();
            if (!paramString.equals("[heap]")) {
              continue;
            }
            localObject3 = DumpMemInfoHandler.Heap.NATIVE;
            localObject1 = paramString;
            paramString = (String)localObject3;
            m = k;
            i1 = 0;
            localObject3 = paramString;
            l1 = l2;
            paramString = (String)localObject1;
            k = j;
            j = m;
            localObject1 = localObject3;
            localObject3 = localBufferedReader.readLine();
            if (localObject3 != null) {
              continue;
            }
            m = 1;
            if (i1 != 0) {
              continue;
            }
            n = ((DumpMemInfoHandler.Heap)localObject1).ordinal();
            localObject2 = this.jdField_a_of_type_ArrayOfJavaUtilHashtable[n];
            if (!((Hashtable)localObject2).containsKey(paramString)) {
              continue;
            }
            ((Hashtable)localObject2).put(paramString, Integer.valueOf(((Integer)((Hashtable)localObject2).get(paramString)).intValue() + i));
            localObject2 = this.jdField_a_of_type_ArrayOfHur[n];
            ((hur)localObject2).a += i;
            localObject2 = this.jdField_a_of_type_ArrayOfHur[n];
            ((hur)localObject2).b += j;
            localObject2 = this.jdField_a_of_type_ArrayOfHur[n];
            ((hur)localObject2).c += k;
            this.jdField_a_of_type_Int += i;
            localObject2 = paramString;
            n = k;
            localObject4 = localObject3;
            k = j;
            j = n;
            n = m;
            break label78;
          }
          paramString = "";
          continue;
          if (paramString.startsWith("/dev/ashmem/dalvik-"))
          {
            localObject3 = DumpMemInfoHandler.Heap.DALVIK;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if (paramString.startsWith("/dev/ashmem/CursorWindow"))
          {
            localObject3 = DumpMemInfoHandler.Heap.CURSOR;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if (paramString.startsWith("/dev/ashmem/"))
          {
            localObject3 = DumpMemInfoHandler.Heap.ASHMEM;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if (paramString.startsWith("/dev/"))
          {
            localObject3 = DumpMemInfoHandler.Heap.OTHER_DEV;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if (paramString.endsWith(".so"))
          {
            localObject3 = DumpMemInfoHandler.Heap.SO_MMAP;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if (paramString.endsWith(".jar"))
          {
            localObject3 = DumpMemInfoHandler.Heap.JAR_MMAP;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if (paramString.endsWith(".apk"))
          {
            localObject3 = DumpMemInfoHandler.Heap.APK_MMAP;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if (paramString.endsWith(".ttf"))
          {
            localObject3 = DumpMemInfoHandler.Heap.TTF_MMAP;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if (paramString.endsWith(".dex"))
          {
            localObject3 = DumpMemInfoHandler.Heap.DEX_MMAP;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if (m > 0)
          {
            localObject3 = DumpMemInfoHandler.Heap.OTHER_MMAP;
            localObject1 = paramString;
            paramString = (String)localObject3;
            continue;
          }
          if ((l3 != l1) || (localObject1 != DumpMemInfoHandler.Heap.SO_MMAP)) {
            break label1176;
          }
          paramString = DumpMemInfoHandler.Heap.SO_MMAP;
          localObject1 = localObject2;
          continue;
        }
        m = j;
        int i1 = 1;
        localObject1 = localObject3;
        j = k;
        k = m;
        continue;
        String[] arrayOfString = ((String)localObject3).split(" ");
        localObject4 = arrayOfString[0];
        i2 = 0;
        m = 1;
        try
        {
          if ((m < arrayOfString.length) && (arrayOfString[m].equals("")))
          {
            m += 1;
            continue;
          }
          if (m >= arrayOfString.length) {
            continue;
          }
          m = Integer.parseInt(arrayOfString[m]);
        }
        catch (Exception localException)
        {
          m = i2;
          continue;
        }
        if (((String)localObject4).equals("Size:"))
        {
          m = j;
          j = k;
          k = i;
          i = m;
          m = k;
          k = j;
          j = i;
          i = m;
          continue;
          m = 0;
          continue;
        }
        if (((String)localObject4).equals("Rss:"))
        {
          m = i;
          i = j;
          j = k;
          k = m;
          continue;
        }
        if (((String)localObject4).equals("Pss:"))
        {
          i = j;
          j = k;
          k = m;
          continue;
        }
        if (((String)localObject4).equals("Shared_Clean:"))
        {
          m = i;
          i = j;
          j = k;
          k = m;
          continue;
        }
        if (((String)localObject4).equals("Shared_Dirty:"))
        {
          k = i;
          i = j;
          j = m;
          continue;
        }
        if (((String)localObject4).equals("Private_Clean:"))
        {
          m = i;
          i = j;
          j = k;
          k = m;
          continue;
        }
        if (((String)localObject4).equals("Private_Dirty:"))
        {
          j = k;
          k = i;
          i = m;
          continue;
        }
        if (((String)localObject4).equals("Referenced:"))
        {
          m = i;
          i = j;
          j = k;
          k = m;
          continue;
        }
        if ((((String)localObject3).length() <= 30) || (((String)localObject3).charAt(8) != '-') || (((String)localObject3).charAt(17) != ' ')) {
          break label1161;
        }
        System.out.println((String)localObject3);
        m = n;
        continue;
        ((Hashtable)localObject2).put(paramString, Integer.valueOf(i));
        continue;
        label1101:
        localBufferedReader.close();
        if ((localFile != null) && (localFile.exists())) {
          localFile.delete();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        int i2;
        continue;
        n = k;
        localObject4 = localObject3;
        k = j;
        j = n;
        n = m;
      }
      break label78;
      label1161:
      m = i;
      i = j;
      j = k;
      k = m;
      continue;
      label1176:
      localObject1 = paramString;
      paramString = (String)localObject3;
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
      c((String)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.util.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */