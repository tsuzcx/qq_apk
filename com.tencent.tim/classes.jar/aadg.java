import android.os.Bundle;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;

public class aadg
  extends aoiz
{
  /* Error */
  public File a(java.io.OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_2
    //   7: getfield 21	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   10: invokevirtual 27	java/net/URL:getHost	()Ljava/lang/String;
    //   13: astore 8
    //   15: new 29	java/io/File
    //   18: dup
    //   19: aload 8
    //   21: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 7
    //   26: aload_2
    //   27: getfield 36	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   30: instanceof 38
    //   33: ifeq +42 -> 75
    //   36: aload_2
    //   37: getfield 36	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   40: checkcast 38	android/os/Bundle
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +35 -> 80
    //   48: aload_1
    //   49: ldc 40
    //   51: ldc 42
    //   53: invokevirtual 46	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_1
    //   57: aload 7
    //   59: invokevirtual 50	java/io/File:exists	()Z
    //   62: ifeq +24 -> 86
    //   65: aload_1
    //   66: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +17 -> 86
    //   72: aload 7
    //   74: areturn
    //   75: aconst_null
    //   76: astore_1
    //   77: goto -33 -> 44
    //   80: ldc 42
    //   82: astore_1
    //   83: goto -26 -> 57
    //   86: aload_2
    //   87: getfield 21	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   90: invokevirtual 59	java/net/URL:getFile	()Ljava/lang/String;
    //   93: astore_3
    //   94: aload_3
    //   95: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifeq +40 -> 138
    //   101: ldc 61
    //   103: iconst_2
    //   104: new 63	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   111: ldc 66
    //   113: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_3
    //   117: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 72
    //   122: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 8
    //   127: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aconst_null
    //   137: areturn
    //   138: aload_3
    //   139: astore_2
    //   140: aload_3
    //   141: getstatic 85	java/io/File:separator	Ljava/lang/String;
    //   144: invokevirtual 91	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   147: ifeq +9 -> 156
    //   150: aload_3
    //   151: iconst_1
    //   152: invokevirtual 95	java/lang/String:substring	(I)Ljava/lang/String;
    //   155: astore_2
    //   156: aload_2
    //   157: ldc 97
    //   159: invokevirtual 91	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: ifne +46 -> 208
    //   165: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +38 -> 206
    //   171: ldc 61
    //   173: iconst_2
    //   174: new 63	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   181: ldc 102
    //   183: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_2
    //   187: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 72
    //   192: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 8
    //   197: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aconst_null
    //   207: areturn
    //   208: new 104	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam
    //   211: dup
    //   212: invokespecial 105	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam:<init>	()V
    //   215: astore_3
    //   216: aload_3
    //   217: aload_2
    //   218: putfield 107	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam:url	Ljava/lang/String;
    //   221: invokestatic 113	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   224: invokevirtual 117	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   227: astore_2
    //   228: aload_2
    //   229: instanceof 119
    //   232: ifeq +50 -> 282
    //   235: aload_3
    //   236: aload_1
    //   237: putfield 122	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam:md5	Ljava/lang/String;
    //   240: aload_2
    //   241: checkcast 119	com/tencent/mobileqq/app/QQAppInterface
    //   244: astore_1
    //   245: aload_3
    //   246: getfield 122	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam:md5	Ljava/lang/String;
    //   249: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifne +30 -> 282
    //   255: aload_1
    //   256: sipush 245
    //   259: invokevirtual 126	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   262: checkcast 128	aaai
    //   265: astore_1
    //   266: aload_1
    //   267: ifnull +83 -> 350
    //   270: aload_1
    //   271: invokevirtual 132	aaai:getLastReqTime	()J
    //   274: lstore 4
    //   276: aload_3
    //   277: lload 4
    //   279: putfield 136	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam:md5Time	J
    //   282: new 138	java/util/concurrent/atomic/AtomicBoolean
    //   285: dup
    //   286: iconst_0
    //   287: invokespecial 141	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   290: astore_1
    //   291: invokestatic 146	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	()Laacl;
    //   294: aload_3
    //   295: new 148	aadh
    //   298: dup
    //   299: aload_0
    //   300: aload 7
    //   302: aload_1
    //   303: invokespecial 151	aadh:<init>	(Laadg;Ljava/io/File;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   306: invokevirtual 156	aacl:a	(Lcom/tencent/mobileqq/activity/qwallet/preload/DownloadParam;Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager$d;)V
    //   309: aload_1
    //   310: invokevirtual 159	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   313: ifne -241 -> 72
    //   316: aload 7
    //   318: monitorenter
    //   319: aload_1
    //   320: invokevirtual 159	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   323: istore 6
    //   325: iload 6
    //   327: ifne +11 -> 338
    //   330: aload 7
    //   332: ldc2_w 160
    //   335: invokevirtual 167	java/lang/Object:wait	(J)V
    //   338: aload 7
    //   340: monitorexit
    //   341: goto -269 -> 72
    //   344: astore_1
    //   345: aload 7
    //   347: monitorexit
    //   348: aload_1
    //   349: athrow
    //   350: lconst_0
    //   351: lstore 4
    //   353: goto -77 -> 276
    //   356: astore_1
    //   357: goto -19 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	aadg
    //   0	360	1	paramOutputStream	java.io.OutputStream
    //   0	360	2	paramDownloadParams	DownloadParams
    //   0	360	3	paramURLDrawableHandler	URLDrawableHandler
    //   274	78	4	l	long
    //   323	3	6	bool	boolean
    //   24	322	7	localFile	File
    //   13	183	8	str	String
    // Exception table:
    //   from	to	target	type
    //   319	325	344	finally
    //   330	338	344	finally
    //   338	341	344	finally
    //   345	348	344	finally
    //   330	338	356	java/lang/InterruptedException
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if (paramDownloadParams != null)
    {
      if ((paramFile != null) && (paramFile.exists()) && (paramDownloadParams.useApngImage) && ("png".equals(aqhq.estimateFileType(paramFile.getPath()))))
      {
        if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {}
        for (paramDownloadParams = (Bundle)paramDownloadParams.mExtraInfo;; paramDownloadParams = null)
        {
          paramDownloadParams = new ApngImage(paramFile, true, paramDownloadParams);
          if (paramDownloadParams.firstFrame == null) {
            ChatBackgroundManager.Mk(paramFile.getAbsolutePath());
          }
          return paramDownloadParams;
        }
      }
      paramDownloadParams.useApngImage = false;
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aadg
 * JD-Core Version:    0.7.0.1
 */