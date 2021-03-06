package com.tencent.mobileqq.msgbackup.transport;

import ajee;
import ajgs;
import ajgt;
import ajgv;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArraySet;

public class MsgBackupJniProxy
{
  public MsgBackupJniProxy(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {
        loadTxlib4Android7(paramContext, "c++_shared", "/lib/");
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 24) {
          loadTxlib4Android7(paramContext, "xplatform", "/txlib/");
        }
        for (;;)
        {
          try
          {
            SoLoadUtilNew.loadSoByName(paramContext, "msgbackup");
            return;
          }
          catch (UnsatisfiedLinkError paramContext)
          {
            QLog.e("MsgBackup-Proxy", 1, paramContext, new Object[0]);
          }
          SoLoadUtil.loadNativeLibrary(paramContext, "c++_shared", 0, false);
          break;
          localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
          localUnsatisfiedLinkError1.printStackTrace();
          break;
          SoLoadUtil.loadNativeLibrary(paramContext, "xplatform", 0, false);
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        for (;;)
        {
          localUnsatisfiedLinkError2.printStackTrace();
        }
      }
    }
  }
  
  public static native byte[] decryptFromByteArray(byte[] paramArrayOfByte, String paramString);
  
  public static native String decryptFromString(String paramString1, String paramString2);
  
  public static native byte[] encryptFromByteArray(byte[] paramArrayOfByte, String paramString);
  
  public static native String encryptFromString(String paramString1, String paramString2);
  
  /* Error */
  public static boolean loadTxlib4Android7(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 48
    //   11: iconst_2
    //   12: new 67	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   19: ldc 70
    //   21: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: invokestatic 88	android/os/SystemClock:uptimeMillis	()J
    //   37: lstore 4
    //   39: ldc 90
    //   41: astore 13
    //   43: new 67	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   50: ldc 92
    //   52: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 94
    //   61: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 14
    //   69: iconst_0
    //   70: istore 10
    //   72: aload_0
    //   73: astore 12
    //   75: aload_0
    //   76: ifnonnull +8 -> 84
    //   79: invokestatic 100	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   82: astore 12
    //   84: new 67	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   91: aload 12
    //   93: invokevirtual 106	android/content/Context:getFilesDir	()Ljava/io/File;
    //   96: invokevirtual 111	java/io/File:getParent	()Ljava/lang/String;
    //   99: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 17
    //   111: ldc 48
    //   113: iconst_1
    //   114: ldc 113
    //   116: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: new 108	java/io/File
    //   122: dup
    //   123: new 67	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   130: aload 17
    //   132: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 14
    //   137: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: astore_2
    //   147: new 67	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   154: ldc 121
    //   156: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore 15
    //   168: aload 12
    //   170: ldc 123
    //   172: iconst_0
    //   173: invokevirtual 127	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   176: astore 16
    //   178: aload 12
    //   180: aload_1
    //   181: invokestatic 130	com/tencent/mobileqq/utils/SoLoadUtil:aY	(Landroid/content/Context;Ljava/lang/String;)Z
    //   184: ifeq +15 -> 199
    //   187: aload_2
    //   188: invokevirtual 133	java/io/File:exists	()Z
    //   191: ifeq +8 -> 199
    //   194: aload_2
    //   195: invokevirtual 136	java/io/File:delete	()Z
    //   198: pop
    //   199: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +11 -> 213
    //   205: ldc 48
    //   207: iconst_2
    //   208: ldc 138
    //   210: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload 13
    //   215: astore_0
    //   216: aload_2
    //   217: invokevirtual 133	java/io/File:exists	()Z
    //   220: ifne +77 -> 297
    //   223: aload 12
    //   225: aload 17
    //   227: ldc 140
    //   229: aload 14
    //   231: invokestatic 144	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   234: istore_3
    //   235: ldc 48
    //   237: iconst_1
    //   238: new 67	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   245: ldc 146
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload_3
    //   251: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: iload_3
    //   261: ifeq +138 -> 399
    //   264: aload_2
    //   265: invokevirtual 136	java/io/File:delete	()Z
    //   268: pop
    //   269: new 67	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   276: ldc 90
    //   278: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc 151
    //   283: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: astore_0
    //   290: ldc 48
    //   292: iconst_1
    //   293: aload_0
    //   294: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: ldc 48
    //   299: iconst_1
    //   300: ldc 155
    //   302: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload_2
    //   306: invokevirtual 133	java/io/File:exists	()Z
    //   309: istore 11
    //   311: iload 11
    //   313: ifeq +330 -> 643
    //   316: aload_2
    //   317: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   320: invokestatic 163	java/lang/System:load	(Ljava/lang/String;)V
    //   323: iconst_1
    //   324: istore 10
    //   326: iload 10
    //   328: istore 11
    //   330: iload 10
    //   332: ifne +18 -> 350
    //   335: ldc 48
    //   337: iconst_1
    //   338: ldc 165
    //   340: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_1
    //   344: invokestatic 168	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   347: iconst_1
    //   348: istore 11
    //   350: invokestatic 88	android/os/SystemClock:uptimeMillis	()J
    //   353: lstore 6
    //   355: ldc 48
    //   357: iconst_1
    //   358: new 67	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   365: ldc 170
    //   367: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_1
    //   371: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: ldc 172
    //   376: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: lload 6
    //   381: lload 4
    //   383: lsub
    //   384: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   387: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: ldc 2
    //   395: monitorexit
    //   396: iload 11
    //   398: ireturn
    //   399: aload_2
    //   400: invokestatic 181	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   403: lstore 6
    //   405: aload 16
    //   407: invokeinterface 187 1 0
    //   412: aload 15
    //   414: lload 6
    //   416: invokeinterface 193 4 0
    //   421: invokeinterface 196 1 0
    //   426: pop
    //   427: aload 13
    //   429: astore_0
    //   430: goto -133 -> 297
    //   433: astore_0
    //   434: ldc 2
    //   436: monitorexit
    //   437: aload_0
    //   438: athrow
    //   439: astore 12
    //   441: aload_2
    //   442: invokestatic 181	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   445: lstore 6
    //   447: aload 16
    //   449: aload 15
    //   451: ldc2_w 197
    //   454: invokeinterface 202 4 0
    //   459: lstore 8
    //   461: lload 6
    //   463: ldc2_w 197
    //   466: lcmp
    //   467: ifeq +86 -> 553
    //   470: lload 6
    //   472: lload 8
    //   474: lcmp
    //   475: ifeq +78 -> 553
    //   478: aload_2
    //   479: invokevirtual 136	java/io/File:delete	()Z
    //   482: pop
    //   483: new 67	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   490: aload_0
    //   491: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc 204
    //   496: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: lload 6
    //   501: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   504: ldc 206
    //   506: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: lload 8
    //   511: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   514: ldc 208
    //   516: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_2
    //   520: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   523: ldc 213
    //   525: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload 12
    //   530: invokestatic 217	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   533: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: astore_0
    //   540: ldc 48
    //   542: iconst_1
    //   543: aload_0
    //   544: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: iconst_0
    //   548: istore 10
    //   550: goto -224 -> 326
    //   553: new 67	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   560: aload_0
    //   561: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: ldc 219
    //   566: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload_2
    //   570: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   573: ldc 213
    //   575: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload 12
    //   580: invokestatic 217	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   583: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: astore_0
    //   590: ldc 48
    //   592: iconst_1
    //   593: aload_0
    //   594: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: iconst_0
    //   598: istore 10
    //   600: goto -274 -> 326
    //   603: astore_2
    //   604: ldc 48
    //   606: iconst_1
    //   607: new 67	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   614: aload_0
    //   615: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc 221
    //   620: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload_2
    //   624: invokestatic 217	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   627: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: iload 10
    //   638: istore 11
    //   640: goto -290 -> 350
    //   643: goto -317 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	646	0	paramContext	Context
    //   0	646	1	paramString1	String
    //   0	646	2	paramString2	String
    //   234	27	3	i	int
    //   37	345	4	l1	long
    //   353	147	6	l2	long
    //   459	51	8	l3	long
    //   70	567	10	bool1	boolean
    //   309	330	11	bool2	boolean
    //   73	151	12	localObject	Object
    //   439	140	12	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   41	387	13	str1	String
    //   67	163	14	str2	String
    //   166	284	15	str3	String
    //   176	272	16	localSharedPreferences	android.content.SharedPreferences
    //   109	117	17	str4	String
    // Exception table:
    //   from	to	target	type
    //   3	34	433	finally
    //   34	39	433	finally
    //   43	69	433	finally
    //   79	84	433	finally
    //   84	199	433	finally
    //   199	213	433	finally
    //   216	260	433	finally
    //   264	297	433	finally
    //   297	311	433	finally
    //   316	323	433	finally
    //   335	343	433	finally
    //   343	347	433	finally
    //   350	393	433	finally
    //   399	427	433	finally
    //   441	461	433	finally
    //   478	547	433	finally
    //   553	597	433	finally
    //   604	636	433	finally
    //   316	323	439	java/lang/UnsatisfiedLinkError
    //   343	347	603	java/lang/UnsatisfiedLinkError
  }
  
  public void a(long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    sendMessage(paramLong1, paramInt, paramString, paramLong2, 0L);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup-Proxy", 2, "received File url = " + paramString1 + ", fid = " + paramLong2 + ", path = " + paramString2 + ", trivial = " + paramBoolean1 + ", isResTask = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      ajgt.dxs();
      ajee.a().k.add(Long.valueOf(paramLong2));
      ajgs localajgs = ajgt.a;
      localajgs.acy += 1L;
    }
    recvFile(paramLong1, paramLong2, paramString1, paramString2, paramBoolean1, paramLong3, 0L);
  }
  
  public void az(long paramLong, String paramString)
  {
    setEncryptKey(paramLong, paramString, ajgv.cow);
  }
  
  public native void cancelAllRecvTasks(long paramLong);
  
  public native void cancelAllSendTasks(long paramLong);
  
  public native int cancelRecvFile(long paramLong1, long paramLong2);
  
  public native int cancelSendFile(long paramLong1, long paramLong2, long paramLong3);
  
  public native long createSession(int paramInt, long paramLong, MsgBackupNotifier paramMsgBackupNotifier);
  
  public void d(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup-Proxy", 2, "sendFile path = " + paramString + ", fid = " + paramLong3 + ", sessionId = " + paramLong2);
    }
    sendFile(paramLong1, paramLong2, paramLong3, paramString, 0L);
  }
  
  public native void destroySession(long paramLong);
  
  public void e(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup-Proxy", 2, "sendBuffer buffer = " + paramString + ", fid = " + paramLong3 + ", sessionId = " + paramLong2);
    }
    sendBuffer(paramLong1, paramLong2, paramLong3, paramString, 0L);
  }
  
  public native byte[] getRecvBuffer(long paramLong1, long paramLong2);
  
  public native int getVersoEndpoint(long paramLong, MsgBackupEndPoint paramMsgBackupEndPoint);
  
  public void m(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup-Proxy", 2, "received from Buffer url = " + paramString + ", fid = " + paramLong2);
    }
    recvToBuffer(paramLong1, paramLong2, paramString, 0L);
  }
  
  public native int queryReachability(long paramLong, MsgBackupNetState paramMsgBackupNetState);
  
  public native void recvFile(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean, long paramLong3, long paramLong4);
  
  public native void recvToBuffer(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  public native void refuseFileRequest(long paramLong1, long paramLong2, long paramLong3, String paramString);
  
  public native void sendBuffer(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4);
  
  public native void sendFile(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4);
  
  public native void sendMessage(long paramLong1, int paramInt, String paramString, long paramLong2, long paramLong3);
  
  public native void setEncryptKey(long paramLong, String paramString, boolean paramBoolean);
  
  public native void setPeerEndpoint(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native int start(long paramLong, MsgBackupEndPoint paramMsgBackupEndPoint1, MsgBackupEndPoint paramMsgBackupEndPoint2);
  
  public native void stop(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy
 * JD-Core Version:    0.7.0.1
 */