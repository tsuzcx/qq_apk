import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class anpi
{
  private static anpi.a a = new anpi.a("/data/anr/traces.txt", 8);
  private static long anA = -1L;
  private static String bvQ;
  private static String cga;
  private static HashMap<Long, String> nz = new HashMap(30);
  private static Object sLock = new Object();
  
  public static String Am()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("|transTid=").append(anA);
    localStringBuilder.append("|transTname=").append(cga);
    localStringBuilder.append("|transWaiting=");
    synchronized (sLock)
    {
      Iterator localIterator = nz.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(localEntry.getKey()).append(",").append((String)localEntry.getValue());
        localStringBuilder.append(";");
      }
    }
    return localObject2.toString();
  }
  
  public static String An()
  {
    if (1 == BaseApplicationImpl.sProcessId) {
      return "|process=QQ";
    }
    if (4 == BaseApplicationImpl.sProcessId) {
      return "|process=MSF";
    }
    if (2 == BaseApplicationImpl.sProcessId) {
      return "|process=qzone";
    }
    return "|process=other";
  }
  
  /* Error */
  private static boolean a(File paramFile1, long paramLong1, long paramLong2, File paramFile2, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_0
    //   4: invokevirtual 130	java/io/File:isFile	()Z
    //   7: ifeq +182 -> 189
    //   10: aload 5
    //   12: invokevirtual 133	java/io/File:exists	()Z
    //   15: ifeq +9 -> 24
    //   18: aload 5
    //   20: invokevirtual 136	java/io/File:delete	()Z
    //   23: pop
    //   24: new 138	java/io/FileOutputStream
    //   27: dup
    //   28: aload 5
    //   30: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore 8
    //   35: new 143	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: astore 9
    //   45: aload 9
    //   47: invokevirtual 148	java/io/FileInputStream:available	()I
    //   50: i2l
    //   51: lload_1
    //   52: lcmp
    //   53: ifle +10 -> 63
    //   56: aload 9
    //   58: lload_1
    //   59: invokevirtual 152	java/io/FileInputStream:skip	(J)J
    //   62: pop2
    //   63: sipush 4096
    //   66: newarray byte
    //   68: astore_0
    //   69: aload 9
    //   71: aload_0
    //   72: invokevirtual 156	java/io/FileInputStream:read	([B)I
    //   75: istore 7
    //   77: iload 7
    //   79: iconst_m1
    //   80: if_icmpeq +59 -> 139
    //   83: aload 8
    //   85: aload_0
    //   86: iconst_0
    //   87: iload 7
    //   89: invokevirtual 160	java/io/FileOutputStream:write	([BII)V
    //   92: goto -23 -> 69
    //   95: astore 10
    //   97: aload 9
    //   99: astore 6
    //   101: aload 8
    //   103: astore_0
    //   104: aload 10
    //   106: astore 8
    //   108: aload 8
    //   110: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   113: aload 5
    //   115: invokevirtual 136	java/io/File:delete	()Z
    //   118: pop
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   127: aload 6
    //   129: ifnull +8 -> 137
    //   132: aload 6
    //   134: invokevirtual 167	java/io/FileInputStream:close	()V
    //   137: iconst_0
    //   138: ireturn
    //   139: aload 6
    //   141: ifnull +23 -> 164
    //   144: aload 8
    //   146: ldc 169
    //   148: invokevirtual 173	java/lang/String:getBytes	()[B
    //   151: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   154: aload 8
    //   156: aload 6
    //   158: invokevirtual 173	java/lang/String:getBytes	()[B
    //   161: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   164: aload 8
    //   166: invokevirtual 179	java/io/FileOutputStream:flush	()V
    //   169: aload 8
    //   171: ifnull +8 -> 179
    //   174: aload 8
    //   176: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   179: aload 9
    //   181: ifnull +8 -> 189
    //   184: aload 9
    //   186: invokevirtual 167	java/io/FileInputStream:close	()V
    //   189: iconst_1
    //   190: ireturn
    //   191: astore_0
    //   192: aconst_null
    //   193: astore 5
    //   195: aconst_null
    //   196: astore 8
    //   198: aload 8
    //   200: ifnull +8 -> 208
    //   203: aload 8
    //   205: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 167	java/io/FileInputStream:close	()V
    //   218: aload_0
    //   219: athrow
    //   220: astore_0
    //   221: goto -42 -> 179
    //   224: astore_0
    //   225: goto -36 -> 189
    //   228: astore 5
    //   230: goto -111 -> 119
    //   233: astore_0
    //   234: goto -107 -> 127
    //   237: astore_0
    //   238: iconst_0
    //   239: ireturn
    //   240: astore 6
    //   242: goto -34 -> 208
    //   245: astore 5
    //   247: goto -29 -> 218
    //   250: astore_0
    //   251: aconst_null
    //   252: astore 5
    //   254: goto -56 -> 198
    //   257: astore_0
    //   258: aload 9
    //   260: astore 5
    //   262: goto -64 -> 198
    //   265: astore 9
    //   267: aload_0
    //   268: astore 8
    //   270: aload 6
    //   272: astore 5
    //   274: aload 9
    //   276: astore_0
    //   277: goto -79 -> 198
    //   280: astore 8
    //   282: aconst_null
    //   283: astore_0
    //   284: aload 10
    //   286: astore 6
    //   288: goto -180 -> 108
    //   291: astore 6
    //   293: aload 8
    //   295: astore_0
    //   296: aload 6
    //   298: astore 8
    //   300: aload 10
    //   302: astore 6
    //   304: goto -196 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramFile1	File
    //   0	307	1	paramLong1	long
    //   0	307	3	paramLong2	long
    //   0	307	5	paramFile2	File
    //   0	307	6	paramString	String
    //   75	13	7	i	int
    //   33	236	8	localObject1	Object
    //   280	14	8	localIOException1	java.io.IOException
    //   298	1	8	str	String
    //   43	216	9	localFileInputStream	java.io.FileInputStream
    //   265	10	9	localObject2	Object
    //   1	1	10	localObject3	Object
    //   95	206	10	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   45	63	95	java/io/IOException
    //   63	69	95	java/io/IOException
    //   69	77	95	java/io/IOException
    //   83	92	95	java/io/IOException
    //   144	164	95	java/io/IOException
    //   164	169	95	java/io/IOException
    //   10	24	191	finally
    //   24	35	191	finally
    //   174	179	220	java/io/IOException
    //   184	189	224	java/io/IOException
    //   113	119	228	java/lang/Exception
    //   123	127	233	java/io/IOException
    //   132	137	237	java/io/IOException
    //   203	208	240	java/io/IOException
    //   213	218	245	java/io/IOException
    //   35	45	250	finally
    //   45	63	257	finally
    //   63	69	257	finally
    //   69	77	257	finally
    //   83	92	257	finally
    //   144	164	257	finally
    //   164	169	257	finally
    //   108	113	265	finally
    //   113	119	265	finally
    //   10	24	280	java/io/IOException
    //   24	35	280	java/io/IOException
    //   35	45	291	java/io/IOException
  }
  
  public static void addWaitingTransThread(long paramLong, String paramString)
  {
    synchronized (sLock)
    {
      nz.put(Long.valueOf(paramLong), paramString);
      return;
    }
  }
  
  /* Error */
  public static boolean bG(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: new 127	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 8
    //   16: aload 8
    //   18: invokevirtual 133	java/io/File:exists	()Z
    //   21: ifeq +9 -> 30
    //   24: aload 8
    //   26: invokevirtual 136	java/io/File:delete	()Z
    //   29: pop
    //   30: new 138	java/io/FileOutputStream
    //   33: dup
    //   34: aload 8
    //   36: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore 6
    //   41: invokestatic 201	java/lang/Thread:activeCount	()I
    //   44: anewarray 198	java/lang/Thread
    //   47: astore_0
    //   48: aload_0
    //   49: invokestatic 205	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   52: pop
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_2
    //   56: aload_0
    //   57: arraylength
    //   58: if_icmpge +201 -> 259
    //   61: aload_0
    //   62: iload_2
    //   63: aaload
    //   64: astore 7
    //   66: aload 7
    //   68: ifnull +318 -> 386
    //   71: aload 6
    //   73: ldc 207
    //   75: invokevirtual 173	java/lang/String:getBytes	()[B
    //   78: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   81: aload 6
    //   83: aload 7
    //   85: invokevirtual 210	java/lang/Thread:getName	()Ljava/lang/String;
    //   88: invokevirtual 173	java/lang/String:getBytes	()[B
    //   91: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   94: aload 6
    //   96: ldc 169
    //   98: invokevirtual 173	java/lang/String:getBytes	()[B
    //   101: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   104: aload 6
    //   106: new 48	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   113: ldc 213
    //   115: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 7
    //   120: invokevirtual 217	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   123: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokevirtual 173	java/lang/String:getBytes	()[B
    //   132: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   135: aload 6
    //   137: ldc 169
    //   139: invokevirtual 173	java/lang/String:getBytes	()[B
    //   142: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   145: aload 6
    //   147: new 48	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   154: ldc 219
    //   156: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 7
    //   161: invokevirtual 223	java/lang/Thread:getId	()J
    //   164: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   167: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 173	java/lang/String:getBytes	()[B
    //   173: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   176: aload 6
    //   178: ldc 169
    //   180: invokevirtual 173	java/lang/String:getBytes	()[B
    //   183: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   186: aload 7
    //   188: invokevirtual 226	java/lang/Thread:isAlive	()Z
    //   191: ifeq +195 -> 386
    //   194: aload 7
    //   196: invokevirtual 230	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   199: astore 7
    //   201: aload 7
    //   203: arraylength
    //   204: istore 4
    //   206: iconst_0
    //   207: istore_3
    //   208: iload_3
    //   209: iload 4
    //   211: if_icmpge +35 -> 246
    //   214: aload 6
    //   216: aload 7
    //   218: iload_3
    //   219: aaload
    //   220: invokevirtual 233	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   223: invokevirtual 173	java/lang/String:getBytes	()[B
    //   226: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   229: aload 6
    //   231: ldc 169
    //   233: invokevirtual 173	java/lang/String:getBytes	()[B
    //   236: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   239: iload_3
    //   240: iconst_1
    //   241: iadd
    //   242: istore_3
    //   243: goto -35 -> 208
    //   246: aload 6
    //   248: ldc 169
    //   250: invokevirtual 173	java/lang/String:getBytes	()[B
    //   253: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   256: goto +130 -> 386
    //   259: aload 6
    //   261: ldc 169
    //   263: invokevirtual 173	java/lang/String:getBytes	()[B
    //   266: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   269: aload 6
    //   271: aload_1
    //   272: invokevirtual 173	java/lang/String:getBytes	()[B
    //   275: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   278: aload 6
    //   280: invokevirtual 179	java/io/FileOutputStream:flush	()V
    //   283: aload 6
    //   285: ifnull +8 -> 293
    //   288: aload 6
    //   290: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   293: iconst_1
    //   294: istore 5
    //   296: iload 5
    //   298: ireturn
    //   299: astore_1
    //   300: aload 7
    //   302: astore_0
    //   303: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +12 -> 318
    //   309: ldc 240
    //   311: iconst_2
    //   312: ldc 242
    //   314: aload_1
    //   315: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload 8
    //   320: invokevirtual 136	java/io/File:delete	()Z
    //   323: pop
    //   324: aload_0
    //   325: ifnull -29 -> 296
    //   328: aload_0
    //   329: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   332: iconst_0
    //   333: ireturn
    //   334: astore_0
    //   335: iconst_0
    //   336: ireturn
    //   337: astore_0
    //   338: aconst_null
    //   339: astore_1
    //   340: aload_1
    //   341: ifnull +7 -> 348
    //   344: aload_1
    //   345: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   348: aload_0
    //   349: athrow
    //   350: astore_0
    //   351: goto -58 -> 293
    //   354: astore_1
    //   355: goto -31 -> 324
    //   358: astore_1
    //   359: goto -11 -> 348
    //   362: astore_0
    //   363: aload 6
    //   365: astore_1
    //   366: goto -26 -> 340
    //   369: astore 6
    //   371: aload_0
    //   372: astore_1
    //   373: aload 6
    //   375: astore_0
    //   376: goto -36 -> 340
    //   379: astore_1
    //   380: aload 6
    //   382: astore_0
    //   383: goto -80 -> 303
    //   386: iload_2
    //   387: iconst_1
    //   388: iadd
    //   389: istore_2
    //   390: goto -335 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	paramString1	String
    //   0	393	1	paramString2	String
    //   54	336	2	i	int
    //   207	36	3	j	int
    //   204	8	4	k	int
    //   1	296	5	bool	boolean
    //   39	325	6	localFileOutputStream	java.io.FileOutputStream
    //   369	12	6	localObject	Object
    //   4	297	7	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   14	305	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   16	30	299	java/lang/Exception
    //   30	41	299	java/lang/Exception
    //   328	332	334	java/io/IOException
    //   16	30	337	finally
    //   30	41	337	finally
    //   288	293	350	java/io/IOException
    //   318	324	354	java/lang/Exception
    //   344	348	358	java/io/IOException
    //   41	53	362	finally
    //   55	61	362	finally
    //   71	206	362	finally
    //   214	239	362	finally
    //   246	256	362	finally
    //   259	283	362	finally
    //   303	318	369	finally
    //   318	324	369	finally
    //   41	53	379	java/lang/Exception
    //   55	61	379	java/lang/Exception
    //   71	206	379	java/lang/Exception
    //   214	239	379	java/lang/Exception
    //   246	256	379	java/lang/Exception
    //   259	283	379	java/lang/Exception
  }
  
  private static void dSN()
  {
    if (TextUtils.isEmpty(bvQ)) {}
    try
    {
      bvQ = aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + "com.tencent.tim".replace(".", "/") + "/");
      return;
    }
    catch (Exception localException)
    {
      bvQ = aqul.getSDKPrivatePath("/sdcard/tencent/msflogs/" + "com.tencent.tim".replace(".", "/") + "/");
    }
  }
  
  public static ArrayList<String> e(Context paramContext)
  {
    dSN();
    ArrayList localArrayList = new ArrayList(10);
    paramContext = paramContext.getSharedPreferences("unified_monitor", 0);
    long l2 = paramContext.getLong("last_report_trace_file", 0L);
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    Object localObject1 = new File(bvQ + "msftrace/");
    int j = 0;
    int i = 0;
    int k = j;
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      k = j;
      if (localObject1 != null)
      {
        int m = localObject1.length;
        j = 0;
        k = i;
        if (j < m)
        {
          Object localObject2 = localObject1[j];
          Object localObject3 = localObject2.getName();
          label165:
          long l3;
          if ((localObject2.isFile()) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).startsWith("traces_")))
          {
            k = 1;
            if (k != 0) {
              l3 = 0L;
            }
          }
          else
          {
            try
            {
              localObject3 = ((String)localObject3).split("_");
              l2 = l3;
              if (localObject3 != null)
              {
                l2 = l3;
                if (localObject3.length > 2) {
                  l2 = Long.valueOf(localObject3[1]).longValue();
                }
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                l2 = l3;
                if (QLog.isColorLevel())
                {
                  QLog.e("UnifiedMonitor.Trace", 2, "parse trace file time exception : ", localException);
                  l2 = l3;
                }
              }
              if (Math.abs(l2 - System.currentTimeMillis()) <= 172800000L) {
                break label308;
              }
              localObject2.delete();
            }
            if ((l2 > 0L) && (l2 > l1))
            {
              localArrayList.add(localObject2.getAbsolutePath());
              i += 1;
            }
          }
          label308:
          for (;;)
          {
            j += 1;
            break;
            k = 0;
            break label165;
          }
        }
      }
    }
    if (k > 0)
    {
      paramContext.edit().putLong("last_report_trace_file", System.currentTimeMillis()).commit();
      QLog.e("UnifiedMonitor.Trace", 1, new Object[] { "report msf trace stack time = ", Long.valueOf(System.currentTimeMillis()), ",report file count=", Integer.valueOf(k) });
    }
    return localArrayList;
  }
  
  public static void fa(Context paramContext)
  {
    dSN();
    Object localObject1 = new File(bvQ);
    int i;
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int k = localObject1.length;
        i = 0;
        if (i < k)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2.isFile()) && (!TextUtils.isEmpty(localObject2.getName())) && (localObject2.getName().startsWith("traces_"))) {}
          for (int j = 1;; j = 0)
          {
            if ((j != 0) && (Math.abs(localObject2.lastModified() - System.currentTimeMillis()) > 86400000L)) {
              localObject2.delete();
            }
            i += 1;
            break;
          }
        }
      }
    }
    paramContext = paramContext.getSharedPreferences("unified_monitor", 0);
    if (paramContext.contains("key_dumping"))
    {
      i = paramContext.getInt("key_crash_count", 0);
      paramContext.edit().remove("key_dumping");
      paramContext.edit().putInt("key_crash_count", i + 1);
      paramContext.edit().commit();
      QLog.d("UnifiedMonitor.Trace", 1, "cleanTraceFile, check crash true");
    }
  }
  
  /* Error */
  public static int h(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 288	anpi:dSN	()V
    //   9: new 127	java/io/File
    //   12: dup
    //   13: new 48	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   20: getstatic 249	anpi:bvQ	Ljava/lang/String;
    //   23: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 309
    //   29: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 11
    //   40: aload 11
    //   42: invokevirtual 133	java/io/File:exists	()Z
    //   45: ifne +9 -> 54
    //   48: aload 11
    //   50: invokevirtual 420	java/io/File:mkdirs	()Z
    //   53: pop
    //   54: aload_0
    //   55: ldc_w 293
    //   58: iconst_0
    //   59: invokevirtual 299	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   62: astore_0
    //   63: aload_0
    //   64: ldc_w 396
    //   67: iconst_0
    //   68: invokeinterface 400 3 0
    //   73: istore 5
    //   75: iload 5
    //   77: istore_3
    //   78: aload_0
    //   79: ldc_w 391
    //   82: invokeinterface 394 2 0
    //   87: ifeq +55 -> 142
    //   90: aload_0
    //   91: invokeinterface 359 1 0
    //   96: ldc_w 391
    //   99: invokeinterface 404 2 0
    //   104: pop
    //   105: aload_0
    //   106: invokeinterface 359 1 0
    //   111: astore 11
    //   113: iload 5
    //   115: iconst_1
    //   116: iadd
    //   117: istore_3
    //   118: aload 11
    //   120: ldc_w 396
    //   123: iload_3
    //   124: invokeinterface 408 3 0
    //   129: pop
    //   130: aload_0
    //   131: invokeinterface 359 1 0
    //   136: invokeinterface 368 1 0
    //   141: pop
    //   142: iload_3
    //   143: iconst_3
    //   144: if_icmplt +19 -> 163
    //   147: ldc 240
    //   149: iconst_1
    //   150: ldc_w 422
    //   153: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: iconst_2
    //   157: istore_3
    //   158: ldc 2
    //   160: monitorexit
    //   161: iload_3
    //   162: ireturn
    //   163: new 127	java/io/File
    //   166: dup
    //   167: ldc 22
    //   169: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   172: astore 11
    //   174: aload 11
    //   176: invokevirtual 427	java/io/File:length	()J
    //   179: lstore 6
    //   181: aload 11
    //   183: invokevirtual 133	java/io/File:exists	()Z
    //   186: ifeq +18 -> 204
    //   189: aload 11
    //   191: invokevirtual 430	java/io/File:canRead	()Z
    //   194: ifeq +10 -> 204
    //   197: lload 6
    //   199: lconst_0
    //   200: lcmp
    //   201: ifne +59 -> 260
    //   204: ldc 240
    //   206: iconst_1
    //   207: iconst_3
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: ldc_w 432
    //   216: aastore
    //   217: dup
    //   218: iconst_1
    //   219: aload 11
    //   221: invokevirtual 133	java/io/File:exists	()Z
    //   224: invokestatic 437	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   227: aastore
    //   228: dup
    //   229: iconst_2
    //   230: new 48	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 439
    //   240: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: lload 6
    //   245: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: aastore
    //   252: invokestatic 380	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   255: iconst_3
    //   256: istore_3
    //   257: goto -99 -> 158
    //   260: aload_0
    //   261: invokeinterface 359 1 0
    //   266: ldc_w 391
    //   269: iconst_1
    //   270: invokeinterface 443 3 0
    //   275: invokeinterface 368 1 0
    //   280: pop
    //   281: getstatic 28	anpi:a	Lanpi$a;
    //   284: invokevirtual 446	anpi$a:startWatching	()V
    //   287: invokestatic 451	android/os/SystemClock:uptimeMillis	()J
    //   290: lstore 8
    //   292: ldc 240
    //   294: iconst_1
    //   295: ldc_w 453
    //   298: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: invokestatic 458	android/os/Process:myPid	()I
    //   304: iconst_3
    //   305: invokestatic 462	android/os/Process:sendSignal	(II)V
    //   308: getstatic 28	anpi:a	Lanpi$a;
    //   311: astore 12
    //   313: aload 12
    //   315: monitorenter
    //   316: getstatic 28	anpi:a	Lanpi$a;
    //   319: ldc2_w 463
    //   322: invokevirtual 468	java/lang/Object:wait	(J)V
    //   325: aload 12
    //   327: monitorexit
    //   328: getstatic 28	anpi:a	Lanpi$a;
    //   331: invokevirtual 471	anpi$a:stopWatching	()V
    //   334: aload_0
    //   335: invokeinterface 359 1 0
    //   340: ldc_w 391
    //   343: invokeinterface 404 2 0
    //   348: ldc_w 396
    //   351: iconst_0
    //   352: invokeinterface 408 3 0
    //   357: invokeinterface 368 1 0
    //   362: pop
    //   363: ldc 240
    //   365: iconst_1
    //   366: new 48	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 473
    //   376: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokestatic 451	android/os/SystemClock:uptimeMillis	()J
    //   382: lload 8
    //   384: lsub
    //   385: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   388: ldc_w 475
    //   391: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 413	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: aload 11
    //   402: invokevirtual 427	java/io/File:length	()J
    //   405: lstore 8
    //   407: lload 8
    //   409: lload 6
    //   411: lcmp
    //   412: ifle +15 -> 427
    //   415: lload 8
    //   417: lload 6
    //   419: lsub
    //   420: ldc2_w 476
    //   423: lcmp
    //   424: ifle +83 -> 507
    //   427: ldc 240
    //   429: iconst_1
    //   430: new 48	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 479
    //   440: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: lload 6
    //   445: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: ldc_w 481
    //   451: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: lload 8
    //   456: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   459: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: lload 8
    //   467: lload 6
    //   469: lcmp
    //   470: ifgt +32 -> 502
    //   473: iconst_4
    //   474: istore_3
    //   475: goto -317 -> 158
    //   478: astore 13
    //   480: aload 12
    //   482: monitorexit
    //   483: aload 13
    //   485: athrow
    //   486: astore 12
    //   488: aload 12
    //   490: invokevirtual 482	java/lang/InterruptedException:printStackTrace	()V
    //   493: goto -165 -> 328
    //   496: astore_0
    //   497: ldc 2
    //   499: monitorexit
    //   500: aload_0
    //   501: athrow
    //   502: iconst_5
    //   503: istore_3
    //   504: goto -346 -> 158
    //   507: aload 11
    //   509: lload 6
    //   511: lload 8
    //   513: lload 6
    //   515: lsub
    //   516: new 127	java/io/File
    //   519: dup
    //   520: aload_1
    //   521: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   524: aload_2
    //   525: invokestatic 484	anpi:a	(Ljava/io/File;JJLjava/io/File;Ljava/lang/String;)Z
    //   528: istore 10
    //   530: ldc 240
    //   532: iconst_1
    //   533: new 48	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   540: ldc_w 486
    //   543: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload 10
    //   548: invokevirtual 489	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   551: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: iload 4
    //   559: istore_3
    //   560: iload 10
    //   562: ifne -404 -> 158
    //   565: bipush 6
    //   567: istore_3
    //   568: goto -410 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	paramContext	Context
    //   0	571	1	paramString1	String
    //   0	571	2	paramString2	String
    //   77	491	3	i	int
    //   1	557	4	j	int
    //   73	44	5	k	int
    //   179	335	6	l1	long
    //   290	222	8	l2	long
    //   528	33	10	bool	boolean
    //   38	470	11	localObject1	Object
    //   486	3	12	localInterruptedException	java.lang.InterruptedException
    //   478	6	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   316	328	478	finally
    //   480	483	478	finally
    //   308	316	486	java/lang/InterruptedException
    //   483	486	486	java/lang/InterruptedException
    //   6	54	496	finally
    //   54	75	496	finally
    //   78	113	496	finally
    //   118	142	496	finally
    //   147	156	496	finally
    //   163	197	496	finally
    //   204	255	496	finally
    //   260	308	496	finally
    //   308	316	496	finally
    //   328	407	496	finally
    //   427	465	496	finally
    //   483	486	496	finally
    //   488	493	496	finally
    //   507	557	496	finally
  }
  
  public static String nC(String paramString)
  {
    dSN();
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(bvQ);
    if (4 == BaseApplicationImpl.sProcessId) {
      localStringBuilder.append("msftrace/");
    }
    localStringBuilder.append("traces_").append(System.currentTimeMillis()).append("_").append(paramString).append(".txt");
    return localStringBuilder.toString();
  }
  
  public static void removeWaitingTransThread(long paramLong)
  {
    synchronized (sLock)
    {
      nz.remove(Long.valueOf(paramLong));
      return;
    }
  }
  
  public static void setCurrentTransThread(long paramLong, String paramString)
  {
    anA = paramLong;
    cga = paramString;
  }
  
  static class a
    extends FileObserver
  {
    public a(String paramString, int paramInt)
    {
      super(paramInt);
    }
    
    public void onEvent(int paramInt, String arg2)
    {
      QLog.e("UnifiedMonitor.Trace", 1, "dumpTraces onEvent " + ???);
      synchronized (anpi.a())
      {
        notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anpi
 * JD-Core Version:    0.7.0.1
 */