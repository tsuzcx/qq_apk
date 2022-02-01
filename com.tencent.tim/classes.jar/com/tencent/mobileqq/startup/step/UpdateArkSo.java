package com.tencent.mobileqq.startup.step;

import adqu;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import java.util.Locale;

public class UpdateArkSo
  extends Step
{
  public static String Ah()
  {
    return "png-armeabi-v7a";
  }
  
  private static long aM(String paramString)
  {
    if (paramString.equals("ark")) {
      return ark.arkGetARMv7LibCRC32();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getARMv7LibCRC32();
    }
    if (paramString.equals("png-armeabi-v7a")) {
      return ark.arkGetPngARMv7LibCRC32();
    }
    return -1L;
  }
  
  private static String aP(Context paramContext)
  {
    paramContext = paramContext.getFilesDir();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp.ArkEngineExtract", 2, "getFilesDir is null");
      }
      return "";
    }
    return paramContext.getParent() + "/txlib/";
  }
  
  /* Error */
  public static boolean ad(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 57
    //   11: iconst_2
    //   12: new 67	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   19: ldc 90
    //   21: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 67	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   41: aload_0
    //   42: invokestatic 92	com/tencent/mobileqq/startup/step/UpdateArkSo:aP	(Landroid/content/Context;)Ljava/lang/String;
    //   45: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokestatic 96	com/tencent/mobileqq/startup/step/UpdateArkSo:nA	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 7
    //   60: aload_1
    //   61: invokestatic 100	com/tencent/mobileqq/startup/step/UpdateArkSo:er	(Ljava/lang/String;)I
    //   64: istore_2
    //   65: aload_1
    //   66: invokestatic 102	com/tencent/mobileqq/startup/step/UpdateArkSo:aM	(Ljava/lang/String;)J
    //   69: lstore_3
    //   70: new 70	java/io/File
    //   73: dup
    //   74: aload 7
    //   76: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 8
    //   81: aload 8
    //   83: invokevirtual 108	java/io/File:exists	()Z
    //   86: ifeq +94 -> 180
    //   89: iload_2
    //   90: iconst_m1
    //   91: if_icmpeq +14 -> 105
    //   94: iload_2
    //   95: i2l
    //   96: aload 8
    //   98: invokevirtual 111	java/io/File:length	()J
    //   101: lcmp
    //   102: ifne +78 -> 180
    //   105: lload_3
    //   106: ldc2_w 40
    //   109: lcmp
    //   110: ifeq +17 -> 127
    //   113: aload 8
    //   115: invokestatic 117	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   118: lstore 5
    //   120: lload_3
    //   121: lload 5
    //   123: lcmp
    //   124: ifne +56 -> 180
    //   127: ldc 119
    //   129: invokestatic 124	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   132: aload 7
    //   134: invokestatic 127	java/lang/System:load	(Ljava/lang/String;)V
    //   137: ldc 2
    //   139: monitorexit
    //   140: iconst_1
    //   141: ireturn
    //   142: astore 9
    //   144: new 67	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   151: ldc 129
    //   153: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 10
    //   165: ldc 57
    //   167: iconst_1
    //   168: aload 10
    //   170: aload 9
    //   172: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload 10
    //   177: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   180: aload 8
    //   182: invokevirtual 140	java/io/File:delete	()Z
    //   185: pop
    //   186: aload_0
    //   187: aload_1
    //   188: invokestatic 143	com/tencent/mobileqq/startup/step/UpdateArkSo:ae	(Landroid/content/Context;Ljava/lang/String;)Z
    //   191: ifeq +99 -> 290
    //   194: ldc 119
    //   196: invokestatic 124	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   199: aload 7
    //   201: invokestatic 127	java/lang/System:load	(Ljava/lang/String;)V
    //   204: goto -67 -> 137
    //   207: astore_0
    //   208: new 67	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   215: ldc 145
    //   217: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore_1
    //   228: ldc 57
    //   230: iconst_1
    //   231: aload_1
    //   232: aload_0
    //   233: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_1
    //   237: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   240: goto -103 -> 137
    //   243: astore_0
    //   244: ldc 2
    //   246: monitorexit
    //   247: aload_0
    //   248: athrow
    //   249: astore 9
    //   251: new 67	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   258: ldc 147
    //   260: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_1
    //   264: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: astore 10
    //   272: ldc 57
    //   274: iconst_1
    //   275: aload 10
    //   277: aload 9
    //   279: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: aload 10
    //   284: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   287: goto -107 -> 180
    //   290: new 67	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   297: ldc 149
    //   299: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_1
    //   303: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: astore_0
    //   310: ldc 57
    //   312: iconst_1
    //   313: aload_0
    //   314: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload_0
    //   318: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   321: goto -184 -> 137
    //   324: astore_0
    //   325: new 67	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   332: ldc 151
    //   334: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_1
    //   338: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: astore_1
    //   345: ldc 57
    //   347: iconst_1
    //   348: aload_1
    //   349: aload_0
    //   350: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload_1
    //   354: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   357: goto -220 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramContext	Context
    //   0	360	1	paramString	String
    //   64	31	2	i	int
    //   69	52	3	l1	long
    //   118	4	5	l2	long
    //   58	142	7	str1	String
    //   79	102	8	localFile	File
    //   142	29	9	localSecurityException	java.lang.SecurityException
    //   249	29	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   163	120	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   127	137	142	java/lang/SecurityException
    //   186	204	207	java/lang/SecurityException
    //   290	321	207	java/lang/SecurityException
    //   3	34	243	finally
    //   34	89	243	finally
    //   94	105	243	finally
    //   113	120	243	finally
    //   127	137	243	finally
    //   144	180	243	finally
    //   180	186	243	finally
    //   186	204	243	finally
    //   208	240	243	finally
    //   251	287	243	finally
    //   290	321	243	finally
    //   325	357	243	finally
    //   127	137	249	java/lang/UnsatisfiedLinkError
    //   186	204	324	java/lang/UnsatisfiedLinkError
    //   290	321	324	java/lang/UnsatisfiedLinkError
  }
  
  private static boolean ae(Context paramContext, String paramString)
  {
    for (;;)
    {
      Object localObject;
      File localFile1;
      int i;
      label212:
      int j;
      try
      {
        long l1 = SystemClock.uptimeMillis();
        bool = false;
        localObject = null;
        localFile1 = null;
        String str = aP(paramContext);
        long l2;
        if (TextUtils.isEmpty(str))
        {
          paramContext = "arkso.old.getTxlibPath.return.null";
          paramString = localFile1;
          l2 = SystemClock.uptimeMillis();
          if (QLog.isColorLevel())
          {
            if (bool) {
              QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "extract.so.", paramString.getName(), ".spend time.", Long.valueOf(l2 - l1) });
            }
          }
          else
          {
            if (paramContext != null) {
              adqu.GL(paramContext);
            }
            return bool;
          }
        }
        else
        {
          File localFile2 = new File(str);
          if ((!localFile2.exists()) && (!localFile2.mkdir()))
          {
            paramContext = "arkso.old.mkdir.fail";
            paramString = localFile1;
            continue;
          }
          int k = er(paramString);
          l2 = aM(paramString);
          localFile1 = new File(str + nA(paramString));
          if (localFile1.exists())
          {
            if ((k == -1) || (k == localFile1.length())) {
              break label428;
            }
            i = 1;
            if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value(localFile1))) {
              break label433;
            }
            j = 1;
            break label410;
          }
          localFile1.delete();
          if (localFile1.exists())
          {
            paramContext = String.format("arkso.old.delete.%s.fail!!", new Object[] { localFile1.getName() });
            paramString = localFile1;
            continue;
          }
          if (SoLoadUtil.a(paramContext, str, "txlib", nA(paramString)) != 0)
          {
            localFile1.delete();
            paramContext = "arkso.old.extract.fail!!";
            paramString = localFile1;
            continue;
          }
          if (!localFile1.exists())
          {
            paramContext = "arkso.old.file.not.exist!!";
            paramString = localFile1;
            continue;
          }
          if ((k != -1) && (k != localFile1.length()))
          {
            localFile1.delete();
            paramContext = "arkso.old.size.mismatch!!";
            paramString = localFile1;
            continue;
          }
          if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value(localFile1))) {
            break label438;
          }
          localFile1.delete();
          paramContext = "arkso.old.crc32.mismatch!!";
          paramString = localFile1;
          continue;
        }
        if (paramContext == null) {
          continue;
        }
        QLog.d("ArkApp.ArkEngineExtract", 2, paramContext);
        continue;
        if ((j | i) != 0) {
          continue;
        }
      }
      finally {}
      for (;;)
      {
        label410:
        bool = true;
        paramString = localFile1;
        paramContext = localObject;
        break;
        label428:
        i = 0;
        break label212;
        label433:
        j = 0;
      }
      label438:
      boolean bool = true;
      paramString = localFile1;
      paramContext = localObject;
    }
  }
  
  /* Error */
  public static boolean af(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: aload_1
    //   5: invokestatic 216	com/tencent/mobileqq/startup/step/UpdateArkSo:eq	(Ljava/lang/String;)I
    //   8: invokestatic 220	com/tencent/mobileqq/startup/step/UpdateArkSo:ay	(Ljava/lang/String;I)Ljava/lang/String;
    //   11: astore 10
    //   13: new 67	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: invokestatic 92	com/tencent/mobileqq/startup/step/UpdateArkSo:aP	(Landroid/content/Context;)Ljava/lang/String;
    //   24: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload 10
    //   29: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 11
    //   37: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +29 -> 69
    //   43: ldc 57
    //   45: iconst_2
    //   46: new 67	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   53: ldc 222
    //   55: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 10
    //   60: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload_1
    //   70: invokestatic 100	com/tencent/mobileqq/startup/step/UpdateArkSo:er	(Ljava/lang/String;)I
    //   73: istore_2
    //   74: aload_1
    //   75: invokestatic 102	com/tencent/mobileqq/startup/step/UpdateArkSo:aM	(Ljava/lang/String;)J
    //   78: lstore_3
    //   79: new 70	java/io/File
    //   82: dup
    //   83: aload 11
    //   85: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore 12
    //   90: aload 12
    //   92: invokevirtual 108	java/io/File:exists	()Z
    //   95: ifeq +202 -> 297
    //   98: aload 12
    //   100: invokevirtual 111	java/io/File:length	()J
    //   103: lstore 5
    //   105: aload 12
    //   107: invokestatic 117	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   110: lstore 7
    //   112: iload_2
    //   113: iconst_m1
    //   114: if_icmpeq +11 -> 125
    //   117: iload_2
    //   118: i2l
    //   119: lload 5
    //   121: lcmp
    //   122: ifne +236 -> 358
    //   125: lload_3
    //   126: ldc2_w 40
    //   129: lcmp
    //   130: ifeq +10 -> 140
    //   133: lload_3
    //   134: lload 7
    //   136: lcmp
    //   137: ifne +221 -> 358
    //   140: ldc 119
    //   142: invokestatic 124	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   145: aload 11
    //   147: invokestatic 127	java/lang/System:load	(Ljava/lang/String;)V
    //   150: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +56 -> 209
    //   156: ldc 57
    //   158: iconst_2
    //   159: getstatic 228	java/util/Locale:CHINA	Ljava/util/Locale;
    //   162: ldc 230
    //   164: iconst_5
    //   165: anewarray 166	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: iload_2
    //   171: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: lload 5
    //   179: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: lload_3
    //   186: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   189: aastore
    //   190: dup
    //   191: iconst_3
    //   192: lload 7
    //   194: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: aastore
    //   198: dup
    //   199: iconst_4
    //   200: aload 11
    //   202: aastore
    //   203: invokestatic 238	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   206: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: iconst_1
    //   210: istore 9
    //   212: ldc 2
    //   214: monitorexit
    //   215: iload 9
    //   217: ireturn
    //   218: astore_0
    //   219: new 67	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   226: ldc 240
    //   228: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 10
    //   233: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: astore_1
    //   240: ldc 57
    //   242: iconst_1
    //   243: aload_1
    //   244: aload_0
    //   245: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload_1
    //   249: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   252: iconst_0
    //   253: istore 9
    //   255: goto -43 -> 212
    //   258: astore 12
    //   260: new 67	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   267: ldc 242
    //   269: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload 10
    //   274: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: astore 13
    //   282: ldc 57
    //   284: iconst_1
    //   285: aload 13
    //   287: aload 12
    //   289: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   292: aload 13
    //   294: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   297: aload_0
    //   298: aload_1
    //   299: iconst_1
    //   300: invokestatic 246	com/tencent/mobileqq/startup/step/UpdateArkSo:e	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   303: ifeq +123 -> 426
    //   306: ldc 119
    //   308: invokestatic 124	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   311: aload 11
    //   313: invokestatic 127	java/lang/System:load	(Ljava/lang/String;)V
    //   316: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +33 -> 352
    //   322: ldc 57
    //   324: iconst_2
    //   325: getstatic 228	java/util/Locale:CHINA	Ljava/util/Locale;
    //   328: ldc 248
    //   330: iconst_2
    //   331: anewarray 166	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: iload_2
    //   337: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: aload 11
    //   345: aastore
    //   346: invokestatic 238	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   349: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: iconst_1
    //   353: istore 9
    //   355: goto -143 -> 212
    //   358: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq -64 -> 297
    //   364: ldc 57
    //   366: iconst_2
    //   367: getstatic 228	java/util/Locale:CHINA	Ljava/util/Locale;
    //   370: ldc 250
    //   372: iconst_5
    //   373: anewarray 166	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: iload_2
    //   379: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   382: aastore
    //   383: dup
    //   384: iconst_1
    //   385: lload 5
    //   387: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   390: aastore
    //   391: dup
    //   392: iconst_2
    //   393: lload_3
    //   394: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   397: aastore
    //   398: dup
    //   399: iconst_3
    //   400: lload 7
    //   402: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   405: aastore
    //   406: dup
    //   407: iconst_4
    //   408: aload 11
    //   410: aastore
    //   411: invokestatic 238	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   414: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: goto -120 -> 297
    //   420: astore_0
    //   421: ldc 2
    //   423: monitorexit
    //   424: aload_0
    //   425: athrow
    //   426: ldc 57
    //   428: iconst_1
    //   429: ldc 252
    //   431: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: ldc 252
    //   436: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   439: iconst_0
    //   440: istore 9
    //   442: goto -230 -> 212
    //   445: astore_0
    //   446: new 67	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   453: ldc 254
    //   455: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload 10
    //   460: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: astore_1
    //   467: ldc 57
    //   469: iconst_1
    //   470: aload_1
    //   471: aload_0
    //   472: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   475: aload_1
    //   476: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   479: goto -40 -> 439
    //   482: astore_0
    //   483: new 67	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 256
    //   493: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload 10
    //   498: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: astore_1
    //   505: ldc 57
    //   507: iconst_1
    //   508: aload_1
    //   509: aload_0
    //   510: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   513: aload_1
    //   514: invokestatic 137	adqu:GL	(Ljava/lang/String;)V
    //   517: goto -78 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	paramContext	Context
    //   0	520	1	paramString	String
    //   73	306	2	i	int
    //   78	316	3	l1	long
    //   103	283	5	l2	long
    //   110	291	7	l3	long
    //   210	231	9	bool	boolean
    //   11	486	10	str1	String
    //   35	374	11	str2	String
    //   88	18	12	localFile	File
    //   258	30	12	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   280	13	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   140	209	218	java/lang/SecurityException
    //   140	209	258	java/lang/UnsatisfiedLinkError
    //   3	69	420	finally
    //   69	112	420	finally
    //   140	209	420	finally
    //   219	252	420	finally
    //   260	297	420	finally
    //   297	352	420	finally
    //   358	417	420	finally
    //   426	439	420	finally
    //   446	479	420	finally
    //   483	517	420	finally
    //   297	352	445	java/lang/SecurityException
    //   426	439	445	java/lang/SecurityException
    //   297	352	482	java/lang/UnsatisfiedLinkError
    //   426	439	482	java/lang/UnsatisfiedLinkError
  }
  
  private static String ay(String paramString, int paramInt)
  {
    String str2 = String.format(Locale.CHINA, "%07x.so", new Object[] { Integer.valueOf(paramInt) });
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.length() > 6) {
        str1 = str2.substring(0, 6);
      }
    }
    return String.format(Locale.CHINA, "lib%s-%s.so", new Object[] { paramString, str1 });
  }
  
  private static boolean e(Context paramContext, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int j;
      Object localObject;
      File localFile1;
      int i;
      int k;
      try
      {
        j = eq(paramString);
        if (j != 0)
        {
          String str;
          if (paramBoolean)
          {
            break label580;
            paramBoolean = false;
            localObject = null;
            localFile1 = null;
            long l1 = SystemClock.uptimeMillis();
            str = aP(paramContext);
            if (TextUtils.isEmpty(str))
            {
              paramContext = "arkso.getTxlibPath.return.null";
              paramString = localFile1;
              l2 = SystemClock.uptimeMillis();
              if (QLog.isColorLevel())
              {
                if (!paramBoolean) {
                  continue;
                }
                QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "extract.so.", paramString.getName(), ".spend time.", Long.valueOf(l2 - l1) });
              }
              if (paramContext != null) {
                adqu.GL(paramContext);
              }
              return paramBoolean;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          File localFile2 = new File(str);
          if ((!localFile2.exists()) && (!localFile2.mkdir()))
          {
            paramContext = "arkso.getTxlibPath.mkdir.fail";
            paramString = localFile1;
            continue;
          }
          int m = er(paramString);
          long l2 = aM(paramString);
          localFile1 = new File(str + ay(paramString, j));
          if (localFile1.exists())
          {
            if ((m == -1) || (m == localFile1.length())) {
              break label605;
            }
            j = 1;
            if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value(localFile1))) {
              break label611;
            }
            k = 1;
            j = k | j;
            if ((j == 0) || (!QLog.isColorLevel())) {
              break label585;
            }
            QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "arkso.corrupt.", localFile1.getName() });
            break label585;
            localFile1.delete();
          }
          localFile2 = new File(str + nA(paramString));
          localFile2.delete();
          hu(str, paramString);
          if ((localFile2.exists()) || (localFile1.exists()))
          {
            if (localFile2.exists())
            {
              paramContext = localFile2.getName();
              paramContext = String.format("arkso.delete.%s.fail!!", new Object[] { paramContext });
              paramString = localFile1;
              continue;
            }
            paramContext = localFile1.getName();
            continue;
          }
          if (SoLoadUtil.a(paramContext, str, "txlib", nA(paramString)) != 0)
          {
            localFile2.delete();
            paramContext = "arkso.extract.fail!!";
            paramString = localFile1;
            continue;
          }
          if (!localFile2.exists())
          {
            paramContext = "arkso.file.not.exist!!";
            paramString = localFile1;
            continue;
          }
          long l3 = localFile2.length();
          if ((m != -1) && (m != l3))
          {
            localFile2.delete();
            paramContext = "arkso.size.mismatch!!";
            paramString = localFile1;
            continue;
          }
          l3 = IOUtil.getCRC32Value(localFile2);
          if ((l2 != -1L) && (l2 != l3))
          {
            localFile2.delete();
            paramContext = "arkso.crc32.mismatch!!";
            paramString = localFile1;
            continue;
          }
          localFile2.renameTo(localFile1);
          paramBoolean = true;
          paramString = localFile1;
          paramContext = localObject;
          continue;
          if (paramContext == null) {
            continue;
          }
          QLog.d("ArkApp.ArkEngineExtract", 2, paramContext);
          continue;
        }
        i = 1;
      }
      finally {}
      label580:
      continue;
      label585:
      if ((i == 0) && (j == 0))
      {
        paramBoolean = true;
        paramString = localFile1;
        paramContext = localObject;
        continue;
        label605:
        j = 0;
        continue;
        label611:
        k = 0;
      }
    }
  }
  
  private static int eq(String paramString)
  {
    if (paramString.equals("ark")) {
      return ark.arkGetPlatformBuildNumber();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getPlatformBuildNumber();
    }
    return 0;
  }
  
  private static int er(String paramString)
  {
    if (paramString.equals("ark")) {
      return ark.arkGetARMv7LibSize();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getARMv7LibSize();
    }
    if (paramString.equals("png-armeabi-v7a")) {
      return ark.arkGetPngARMv7LibSize();
    }
    return -1;
  }
  
  private static void hu(String paramString1, String paramString2)
  {
    paramString2 = String.format("lib%s", new Object[] { paramString2 });
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkEngineExtract", 2, "path.listFiles return null!!");
      }
    }
    for (;;)
    {
      return;
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        String str = localObject.getName();
        if (str.startsWith(paramString2))
        {
          localObject.delete();
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "remove previous so: ", str });
          }
        }
        i += 1;
      }
    }
  }
  
  private static String nA(String paramString)
  {
    return String.format("lib%s.so", new Object[] { paramString });
  }
  
  protected boolean doStep()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    ae(localBaseApplicationImpl, "png-armeabi-v7a");
    e(localBaseApplicationImpl, "ark", false);
    e(localBaseApplicationImpl, "WordSegment", false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateArkSo
 * JD-Core Version:    0.7.0.1
 */