package tmsdkdual;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tmsdk.dual.TMSDualSDKContext;
import com.tmsdk.dual.sharkcpp.SharkCppProxy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
{
  public static SharedPreferences H = TMSDualSDKContext.getApplicaionContext().getSharedPreferences("b_d_pre", 0);
  
  /* Error */
  public static ArrayList<String> a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 31	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 34	java/util/ArrayList:<init>	()V
    //   10: astore_1
    //   11: aload_0
    //   12: invokestatic 37	tmsdkdual/h:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 41	java/util/ArrayList:size	()I
    //   20: ifle +53 -> 73
    //   23: aload_0
    //   24: invokevirtual 45	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   27: astore_0
    //   28: aload_0
    //   29: invokeinterface 51 1 0
    //   34: ifeq +39 -> 73
    //   37: aload_0
    //   38: invokeinterface 55 1 0
    //   43: checkcast 57	[B
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull -20 -> 28
    //   51: aload_1
    //   52: new 59	java/lang/String
    //   55: dup
    //   56: aload_2
    //   57: aload_2
    //   58: arraylength
    //   59: invokestatic 65	com/tmsdk/dual/sharkcpp/SharkCppProxy:tccDecrypt	([BI)[B
    //   62: invokespecial 68	java/lang/String:<init>	([B)V
    //   65: invokevirtual 72	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   68: pop
    //   69: goto -41 -> 28
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_1
    //   77: areturn
    //   78: astore_0
    //   79: ldc 2
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    //   10	67	1	localArrayList	ArrayList
    //   46	12	2	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	28	72	java/lang/Throwable
    //   28	47	72	java/lang/Throwable
    //   51	69	72	java/lang/Throwable
    //   3	11	78	finally
    //   11	28	78	finally
    //   28	47	78	finally
    //   51	69	78	finally
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString1);
        if (!bool) {
          continue;
        }
      }
      catch (Throwable paramString1)
      {
        ArrayList localArrayList;
        File localFile;
        continue;
      }
      finally {}
      return;
      localArrayList = b(paramString2);
      if (localArrayList.size() < 500)
      {
        localFile = new File(paramString2);
        if (!localFile.exists()) {
          localFile.createNewFile();
        }
        paramString2 = localArrayList;
        if (paramInt == 163) {
          paramString2 = new ArrayList();
        }
        paramString2.add(SharkCppProxy.tccEncrypt(paramString1.getBytes(), paramString1.getBytes().length));
        paramString1 = new ObjectOutputStream(new FileOutputStream(localFile));
        paramString1.writeObject(paramString2);
        paramString1.flush();
        paramString1.close();
      }
    }
  }
  
  public static void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        try
        {
          String[] arrayOfString = str.split(";");
          switch (d(arrayOfString[0]))
          {
          case 139: 
            H.edit().putString("h", str).apply();
            break;
          case 141: 
            H.edit().putString("aaa", str).apply();
            break;
          case 163: 
            H.edit().putString("g", str).apply();
            if (d(arrayOfString[1]) == 0) {
              c(i.getPath());
            }
            break;
          }
        }
        catch (Throwable localThrowable) {}
      }
    }
  }
  
  /* Error */
  static ArrayList<byte[]> b(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 31	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 34	java/util/ArrayList:<init>	()V
    //   10: astore_2
    //   11: new 83	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 89	java/io/File:exists	()Z
    //   22: istore_1
    //   23: iload_1
    //   24: ifne +8 -> 32
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_2
    //   31: areturn
    //   32: new 168	java/io/ObjectInputStream
    //   35: dup
    //   36: new 170	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 174	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 177	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   52: checkcast 31	java/util/ArrayList
    //   55: astore_3
    //   56: aload_3
    //   57: ifnull +16 -> 73
    //   60: aload_3
    //   61: invokevirtual 41	java/util/ArrayList:size	()I
    //   64: ifle +9 -> 73
    //   67: aload_2
    //   68: aload_3
    //   69: invokevirtual 181	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   72: pop
    //   73: aload_0
    //   74: invokevirtual 182	java/io/ObjectInputStream:close	()V
    //   77: goto -50 -> 27
    //   80: astore_0
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    //   86: astore_0
    //   87: goto -10 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramString	String
    //   22	2	1	bool	boolean
    //   10	58	2	localArrayList1	ArrayList
    //   55	14	3	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   3	11	80	finally
    //   11	23	80	finally
    //   32	56	80	finally
    //   60	73	80	finally
    //   73	77	80	finally
    //   11	23	86	java/lang/Throwable
    //   32	56	86	java/lang/Throwable
    //   60	73	86	java/lang/Throwable
    //   73	77	86	java/lang/Throwable
  }
  
  /* Error */
  public static void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   6: ldc2_w 191
    //   9: ldiv
    //   10: lstore 6
    //   12: invokestatic 14	com/tmsdk/dual/TMSDualSDKContext:getApplicaionContext	()Landroid/content/Context;
    //   15: pop
    //   16: invokestatic 14	com/tmsdk/dual/TMSDualSDKContext:getApplicaionContext	()Landroid/content/Context;
    //   19: ldc 194
    //   21: invokevirtual 198	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 200	android/net/ConnectivityManager
    //   27: invokevirtual 204	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   30: astore 8
    //   32: aload 8
    //   34: ifnull +441 -> 475
    //   37: aload 8
    //   39: invokevirtual 209	android/net/NetworkInfo:isConnected	()Z
    //   42: istore 4
    //   44: sipush 141
    //   47: invokestatic 212	tmsdkdual/h:d	(I)Ltmsdkdual/g;
    //   50: astore 8
    //   52: aload 8
    //   54: ifnull +78 -> 132
    //   57: aload 8
    //   59: getfield 218	tmsdkdual/g:E	Z
    //   62: istore 5
    //   64: iload 5
    //   66: ifeq +66 -> 132
    //   69: iload 4
    //   71: ifeq +61 -> 132
    //   74: iload_0
    //   75: ifne +57 -> 132
    //   78: aload 8
    //   80: getfield 222	tmsdkdual/g:G	Ljava/lang/String;
    //   83: invokestatic 228	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   86: invokevirtual 231	java/lang/Integer:intValue	()I
    //   89: istore_1
    //   90: iload_1
    //   91: istore_2
    //   92: iload_1
    //   93: ifgt +7 -> 100
    //   96: sipush 168
    //   99: istore_2
    //   100: lload 6
    //   102: getstatic 24	tmsdkdual/h:H	Landroid/content/SharedPreferences;
    //   105: ldc 233
    //   107: ldc2_w 234
    //   110: invokeinterface 239 4 0
    //   115: lsub
    //   116: iload_2
    //   117: i2l
    //   118: ldc2_w 240
    //   121: lmul
    //   122: lcmp
    //   123: ifle +9 -> 132
    //   126: sipush 141
    //   129: invokestatic 245	tmsdkdual/i:e	(I)V
    //   132: sipush 163
    //   135: invokestatic 212	tmsdkdual/h:d	(I)Ltmsdkdual/g;
    //   138: astore 8
    //   140: aload 8
    //   142: ifnull +144 -> 286
    //   145: aload 8
    //   147: getfield 218	tmsdkdual/g:E	Z
    //   150: istore 5
    //   152: iload 5
    //   154: ifeq +132 -> 286
    //   157: aload 8
    //   159: getfield 249	tmsdkdual/g:F	I
    //   162: istore_1
    //   163: aload 8
    //   165: getfield 222	tmsdkdual/g:G	Ljava/lang/String;
    //   168: invokestatic 228	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   171: invokevirtual 231	java/lang/Integer:intValue	()I
    //   174: istore_3
    //   175: iload_1
    //   176: istore_2
    //   177: iload_3
    //   178: istore_1
    //   179: iload_2
    //   180: istore_3
    //   181: iload_2
    //   182: ifgt +6 -> 188
    //   185: bipush 6
    //   187: istore_3
    //   188: iload_1
    //   189: istore_2
    //   190: iload_1
    //   191: ifgt +6 -> 197
    //   194: bipush 6
    //   196: istore_2
    //   197: getstatic 24	tmsdkdual/h:H	Landroid/content/SharedPreferences;
    //   200: ldc 251
    //   202: ldc2_w 234
    //   205: invokeinterface 239 4 0
    //   210: lconst_0
    //   211: lcmp
    //   212: ifle +29 -> 241
    //   215: lload 6
    //   217: getstatic 24	tmsdkdual/h:H	Landroid/content/SharedPreferences;
    //   220: ldc 251
    //   222: ldc2_w 234
    //   225: invokeinterface 239 4 0
    //   230: lsub
    //   231: iload_3
    //   232: i2l
    //   233: ldc2_w 240
    //   236: lmul
    //   237: lcmp
    //   238: iflt +6 -> 244
    //   241: invokestatic 254	tmsdkdual/i:k	()V
    //   244: getstatic 24	tmsdkdual/h:H	Landroid/content/SharedPreferences;
    //   247: ldc_w 256
    //   250: ldc2_w 234
    //   253: invokeinterface 239 4 0
    //   258: lconst_0
    //   259: lcmp
    //   260: ifgt +157 -> 417
    //   263: getstatic 24	tmsdkdual/h:H	Landroid/content/SharedPreferences;
    //   266: invokeinterface 141 1 0
    //   271: ldc_w 256
    //   274: lload 6
    //   276: invokeinterface 260 4 0
    //   281: invokeinterface 152 1 0
    //   286: sipush 139
    //   289: invokestatic 212	tmsdkdual/h:d	(I)Ltmsdkdual/g;
    //   292: astore 8
    //   294: aload 8
    //   296: ifnull +79 -> 375
    //   299: aload 8
    //   301: getfield 218	tmsdkdual/g:E	Z
    //   304: istore 5
    //   306: iload 5
    //   308: ifeq +67 -> 375
    //   311: iload 4
    //   313: ifeq +62 -> 375
    //   316: iload_0
    //   317: ifne +58 -> 375
    //   320: aload 8
    //   322: getfield 222	tmsdkdual/g:G	Ljava/lang/String;
    //   325: invokestatic 228	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   328: invokevirtual 231	java/lang/Integer:intValue	()I
    //   331: istore_1
    //   332: iload_1
    //   333: istore_2
    //   334: iload_1
    //   335: ifgt +7 -> 342
    //   338: sipush 336
    //   341: istore_2
    //   342: lload 6
    //   344: getstatic 24	tmsdkdual/h:H	Landroid/content/SharedPreferences;
    //   347: ldc_w 262
    //   350: ldc2_w 234
    //   353: invokeinterface 239 4 0
    //   358: lsub
    //   359: iload_2
    //   360: i2l
    //   361: ldc2_w 240
    //   364: lmul
    //   365: lcmp
    //   366: ifle +9 -> 375
    //   369: sipush 139
    //   372: invokestatic 245	tmsdkdual/i:e	(I)V
    //   375: ldc 2
    //   377: monitorexit
    //   378: return
    //   379: astore 8
    //   381: ldc_w 263
    //   384: new 265	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 268
    //   394: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 8
    //   399: invokevirtual 275	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   402: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 283	tmsdkdual/m:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   411: aconst_null
    //   412: astore 8
    //   414: goto -382 -> 32
    //   417: iload 4
    //   419: ifeq -133 -> 286
    //   422: lload 6
    //   424: getstatic 24	tmsdkdual/h:H	Landroid/content/SharedPreferences;
    //   427: ldc_w 256
    //   430: ldc2_w 234
    //   433: invokeinterface 239 4 0
    //   438: lsub
    //   439: iload_2
    //   440: i2l
    //   441: ldc2_w 240
    //   444: lmul
    //   445: lcmp
    //   446: ifle -160 -> 286
    //   449: invokestatic 286	tmsdkdual/i:l	()V
    //   452: goto -166 -> 286
    //   455: astore 8
    //   457: ldc 2
    //   459: monitorexit
    //   460: aload 8
    //   462: athrow
    //   463: astore 8
    //   465: iconst_0
    //   466: istore_1
    //   467: goto -135 -> 332
    //   470: astore 8
    //   472: goto +20 -> 492
    //   475: iconst_0
    //   476: istore 4
    //   478: goto -434 -> 44
    //   481: astore 8
    //   483: iconst_0
    //   484: istore_1
    //   485: goto -395 -> 90
    //   488: astore 8
    //   490: iconst_0
    //   491: istore_1
    //   492: iload_1
    //   493: istore_2
    //   494: iconst_0
    //   495: istore_1
    //   496: goto -317 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	paramBoolean	boolean
    //   89	407	1	i	int
    //   91	403	2	j	int
    //   174	58	3	k	int
    //   42	435	4	bool1	boolean
    //   62	245	5	bool2	boolean
    //   10	413	6	l	long
    //   30	291	8	localObject1	Object
    //   379	19	8	localThrowable1	Throwable
    //   412	1	8	localObject2	Object
    //   455	6	8	localObject3	Object
    //   463	1	8	localThrowable2	Throwable
    //   470	1	8	localThrowable3	Throwable
    //   481	1	8	localThrowable4	Throwable
    //   488	1	8	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   16	32	379	java/lang/Throwable
    //   3	16	455	finally
    //   16	32	455	finally
    //   37	44	455	finally
    //   44	52	455	finally
    //   57	64	455	finally
    //   78	90	455	finally
    //   100	132	455	finally
    //   132	140	455	finally
    //   145	152	455	finally
    //   157	163	455	finally
    //   163	175	455	finally
    //   197	241	455	finally
    //   241	244	455	finally
    //   244	286	455	finally
    //   286	294	455	finally
    //   299	306	455	finally
    //   320	332	455	finally
    //   342	375	455	finally
    //   381	411	455	finally
    //   422	452	455	finally
    //   320	332	463	java/lang/Throwable
    //   163	175	470	java/lang/Throwable
    //   78	90	481	java/lang/Throwable
    //   157	163	488	java/lang/Throwable
  }
  
  /* Error */
  public static void c(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 83	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 89	java/io/File:exists	()Z
    //   16: ifeq +8 -> 24
    //   19: aload_0
    //   20: invokevirtual 289	java/io/File:delete	()Z
    //   23: pop
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    //   34: astore_0
    //   35: goto -11 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	24	28	finally
    //   3	24	34	java/lang/Throwable
  }
  
  public static int d(String paramString)
  {
    int j = -1;
    int i = j;
    if (paramString != null) {
      i = j;
    }
    try
    {
      if (paramString.trim().length() > 0) {
        i = Integer.valueOf(paramString).intValue();
      }
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  public static g d(int paramInt)
  {
    Object localObject1;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    }
    while (TextUtils.isEmpty((CharSequence)localObject1))
    {
      return null;
      localObject1 = H.getString("aaa", "141;1;;;");
      continue;
      localObject1 = H.getString("g", "163;1;1;1;");
      continue;
      localObject1 = H.getString("h", "139;1;;;");
    }
    for (;;)
    {
      try
      {
        arrayOfString = ((String)localObject1).split(";");
        localg = new g();
      }
      catch (Throwable localThrowable1)
      {
        String[] arrayOfString;
        boolean bool;
        Object localObject2 = null;
        continue;
      }
      try
      {
        localg.D = d(arrayOfString[0]);
        if (d(arrayOfString[1]) != 1) {
          continue;
        }
        bool = true;
        localg.E = bool;
        if (arrayOfString.length >= 3) {
          localg.F = d(arrayOfString[2]);
        }
        localObject1 = localg;
        if (arrayOfString.length >= 4)
        {
          localg.G = arrayOfString[3];
          localObject1 = localg;
        }
      }
      catch (Throwable localThrowable2)
      {
        Object localObject3 = localg;
        continue;
      }
      return localObject1;
      bool = false;
    }
  }
  
  public static boolean i()
  {
    long l1 = H.getLong("gc", -1L);
    long l2 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    if (Math.abs(l2 - l1) < 2000L) {
      return false;
    }
    H.edit().putLong("gc", l2).apply();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.h
 * JD-Core Version:    0.7.0.1
 */