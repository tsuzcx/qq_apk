import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.ApolloGameObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ygr
  extends DownloadListener
{
  public ygr(ApolloGameObserver paramApolloGameObserver) {}
  
  /* Error */
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +11 -> 12
    //   4: aload_1
    //   5: invokevirtual 23	com/tencent/mobileqq/vip/DownloadTask:a	()I
    //   8: iconst_3
    //   9: if_icmpeq +80 -> 89
    //   12: aload_0
    //   13: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   16: invokestatic 28	com/tencent/mobileqq/apollo/ApolloGameObserver:a	(Lcom/tencent/mobileqq/apollo/ApolloGameObserver;)Ljava/lang/String;
    //   19: astore 6
    //   21: new 30	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   28: ldc 33
    //   30: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: astore 7
    //   35: aload_1
    //   36: ifnonnull +44 -> 80
    //   39: ldc 39
    //   41: astore 5
    //   43: aload 6
    //   45: iconst_1
    //   46: aload 7
    //   48: aload 5
    //   50: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 49	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_1
    //   60: ifnull +19 -> 79
    //   63: aload_0
    //   64: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   67: aload_1
    //   68: invokevirtual 52	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   71: ldc 54
    //   73: invokevirtual 60	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   76: invokevirtual 63	com/tencent/mobileqq/apollo/ApolloGameObserver:a	(I)V
    //   79: return
    //   80: aload_1
    //   81: getfield 67	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   84: astore 5
    //   86: goto -43 -> 43
    //   89: aload_1
    //   90: invokevirtual 52	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   93: astore 5
    //   95: aload 5
    //   97: ldc 54
    //   99: invokevirtual 60	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   102: istore_2
    //   103: aload 5
    //   105: ldc 69
    //   107: invokevirtual 73	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   110: istore 4
    //   112: aload 5
    //   114: ldc 75
    //   116: invokevirtual 79	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_1
    //   120: aload 5
    //   122: ldc 81
    //   124: invokevirtual 79	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 5
    //   129: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +34 -> 166
    //   135: aload_0
    //   136: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   139: invokestatic 28	com/tencent/mobileqq/apollo/ApolloGameObserver:a	(Lcom/tencent/mobileqq/apollo/ApolloGameObserver;)Ljava/lang/String;
    //   142: iconst_2
    //   143: new 30	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   150: ldc 87
    //   152: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 5
    //   157: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 90	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: new 30	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   173: getstatic 95	com/tencent/mobileqq/apollo/utils/ApolloConstant:n	Ljava/lang/String;
    //   176: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload_2
    //   180: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 6
    //   188: new 100	java/io/File
    //   191: dup
    //   192: aload 6
    //   194: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: astore 7
    //   199: aload 7
    //   201: invokevirtual 106	java/io/File:exists	()Z
    //   204: ifeq +19 -> 223
    //   207: aload 7
    //   209: invokevirtual 109	java/io/File:isDirectory	()Z
    //   212: ifeq +11 -> 223
    //   215: aload 7
    //   217: invokevirtual 112	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   220: invokestatic 116	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   223: iload 4
    //   225: ifeq +27 -> 252
    //   228: iload_2
    //   229: invokestatic 122	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   232: aload_1
    //   233: invokestatic 127	com/tencent/mobileqq/apollo/ApolloManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   236: istore 4
    //   238: iload 4
    //   240: ifne +12 -> 252
    //   243: aload_0
    //   244: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   247: iload_2
    //   248: invokevirtual 63	com/tencent/mobileqq/apollo/ApolloGameObserver:a	(I)V
    //   251: return
    //   252: aload 5
    //   254: aload 6
    //   256: iconst_0
    //   257: invokestatic 130	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   260: invokestatic 134	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()V
    //   263: aload_0
    //   264: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   267: getfield 137	com/tencent/mobileqq/apollo/ApolloGameObserver:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   270: astore_1
    //   271: aload_1
    //   272: ifnonnull +12 -> 284
    //   275: aload_0
    //   276: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   279: iload_2
    //   280: invokevirtual 63	com/tencent/mobileqq/apollo/ApolloGameObserver:a	(I)V
    //   283: return
    //   284: aload_0
    //   285: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   288: getfield 137	com/tencent/mobileqq/apollo/ApolloGameObserver:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   291: sipush 154
    //   294: invokevirtual 143	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   297: checkcast 145	com/tencent/mobileqq/apollo/utils/ApolloDaoManager
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 146	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	()V
    //   305: aload_1
    //   306: getfield 149	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   309: ifnull +86 -> 395
    //   312: aload_1
    //   313: getfield 149	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   316: iload_2
    //   317: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   320: invokevirtual 160	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   323: ifeq +72 -> 395
    //   326: aload_1
    //   327: getfield 149	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   330: iload_2
    //   331: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: invokevirtual 164	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   337: checkcast 118	java/lang/String
    //   340: astore 5
    //   342: aload_0
    //   343: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   346: getfield 137	com/tencent/mobileqq/apollo/ApolloGameObserver:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   349: invokevirtual 168	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   352: ldc 170
    //   354: iconst_0
    //   355: invokevirtual 176	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   358: invokeinterface 182 1 0
    //   363: new 30	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   370: ldc 184
    //   372: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: iload_2
    //   376: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: aload 5
    //   384: invokeinterface 190 3 0
    //   389: invokeinterface 193 1 0
    //   394: pop
    //   395: aload_1
    //   396: getfield 149	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   399: iload_2
    //   400: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: invokevirtual 164	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   406: checkcast 118	java/lang/String
    //   409: invokestatic 199	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   412: f2i
    //   413: istore_3
    //   414: aload_0
    //   415: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   418: getfield 137	com/tencent/mobileqq/apollo/ApolloGameObserver:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   421: ldc 201
    //   423: ldc 203
    //   425: ldc 205
    //   427: iconst_3
    //   428: iconst_3
    //   429: iconst_2
    //   430: anewarray 118	java/lang/String
    //   433: dup
    //   434: iconst_0
    //   435: iload_2
    //   436: invokestatic 122	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   439: aastore
    //   440: dup
    //   441: iconst_1
    //   442: iload_3
    //   443: invokestatic 122	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   446: aastore
    //   447: invokestatic 210	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   450: aload_0
    //   451: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   454: iload_2
    //   455: invokevirtual 63	com/tencent/mobileqq/apollo/ApolloGameObserver:a	(I)V
    //   458: return
    //   459: astore_1
    //   460: aload_0
    //   461: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   464: invokestatic 28	com/tencent/mobileqq/apollo/ApolloGameObserver:a	(Lcom/tencent/mobileqq/apollo/ApolloGameObserver;)Ljava/lang/String;
    //   467: iconst_1
    //   468: ldc 212
    //   470: aload_1
    //   471: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   474: aload_0
    //   475: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   478: iload_2
    //   479: invokevirtual 63	com/tencent/mobileqq/apollo/ApolloGameObserver:a	(I)V
    //   482: return
    //   483: astore_1
    //   484: aload_0
    //   485: getfield 10	ygr:a	Lcom/tencent/mobileqq/apollo/ApolloGameObserver;
    //   488: iload_2
    //   489: invokevirtual 63	com/tencent/mobileqq/apollo/ApolloGameObserver:a	(I)V
    //   492: aload_1
    //   493: athrow
    //   494: astore_1
    //   495: goto -45 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	this	ygr
    //   0	498	1	paramDownloadTask	DownloadTask
    //   102	387	2	i	int
    //   413	30	3	j	int
    //   110	129	4	bool	boolean
    //   41	342	5	localObject1	java.lang.Object
    //   19	236	6	str	java.lang.String
    //   33	183	7	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   103	166	459	java/lang/Exception
    //   166	223	459	java/lang/Exception
    //   228	238	459	java/lang/Exception
    //   252	271	459	java/lang/Exception
    //   284	395	459	java/lang/Exception
    //   103	166	483	finally
    //   166	223	483	finally
    //   228	238	483	finally
    //   252	271	483	finally
    //   284	395	483	finally
    //   395	450	483	finally
    //   460	474	483	finally
    //   395	450	494	java/lang/Exception
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)paramDownloadTask.a;
    int j = paramDownloadTask.a().getInt("gameId");
    paramDownloadTask = this.a.a.getHandler(ChatActivity.class);
    if ((paramDownloadTask != null) && (i < 100))
    {
      paramDownloadTask = paramDownloadTask.obtainMessage(75);
      paramDownloadTask.arg1 = i;
      paramDownloadTask.arg2 = j;
      paramDownloadTask.sendToTarget();
      if (QLog.isColorLevel()) {
        QLog.d(ApolloGameObserver.a(this.a), 2, "down load game res percent = " + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ygr
 * JD-Core Version:    0.7.0.1
 */