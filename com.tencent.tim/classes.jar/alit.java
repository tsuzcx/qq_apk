import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class alit
  implements Manager
{
  public static boolean cxq;
  private static ConcurrentHashMap<String, alit.a> gC = new ConcurrentHashMap();
  MessageRecord G;
  boolean Tn;
  alir jdField_a_of_type_Alir;
  alis jdField_a_of_type_Alis;
  aliu jdField_a_of_type_Aliu;
  int aCy = 0;
  volatile boolean cxr = false;
  private volatile boolean hasInit;
  QQAppInterface mApp;
  String mPath;
  String mTempPath;
  int mType = -1;
  
  public alit(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public static alit a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (alit)paramQQAppInterface.getManager(128);
    if (!paramQQAppInterface.hasInit) {
      try
      {
        if (!paramQQAppInterface.hasInit)
        {
          paramQQAppInterface.init();
          paramQQAppInterface.hasInit = true;
        }
        return paramQQAppInterface;
      }
      finally {}
    }
    return paramQQAppInterface;
  }
  
  private boolean bx(QQAppInterface paramQQAppInterface)
  {
    return alig.W(paramQQAppInterface) == 1;
  }
  
  public void Oj(String paramString)
  {
    paramString = (alit.a)gC.remove(paramString);
    if (paramString != null)
    {
      File localFile1 = new File(paramString.mTempPath);
      if (localFile1.exists())
      {
        File localFile2 = new File(paramString.mPath);
        if (localFile2.exists()) {
          localFile2.delete();
        }
        localFile1.renameTo(localFile2);
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "rename presend file ! , from " + paramString.mTempPath + " to " + paramString.mPath);
        }
      }
    }
  }
  
  public void a(SessionInfo paramSessionInfo, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i = 1;
    if (!this.cxr) {
      return;
    }
    int j = this.jdField_a_of_type_Aliu.getPlayTime();
    this.jdField_a_of_type_Aliu.release();
    this.aCy = ((int)new File(this.mTempPath).length());
    if ((this.aCy > 0) && (this.jdField_a_of_type_Alis.c(this.Tn, this.aCy)))
    {
      MessageForPtt localMessageForPtt = ujt.a(this.mApp, this.mPath, paramSessionInfo, -2, paramRecorderParam.mAudioType);
      if (localMessageForPtt == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "createPttMessage null");
        }
        cleanUp();
        return;
      }
      aool localaool = new aool();
      localaool.mSelfUin = this.mApp.getAccount();
      localaool.mPeerUin = paramSessionInfo.aTl;
      localaool.mUinType = paramSessionInfo.cZ;
      localaool.mFileType = 2;
      localaool.mUniseq = localMessageForPtt.uniseq;
      localaool.cNy = true;
      localaool.dQ = this.mTempPath;
      localaool.mBusiType = 1002;
      localaool.cNF = true;
      localaool.dQL = 3;
      localaool.cNG = true;
      localaool.F = localMessageForPtt;
      this.G = localMessageForPtt;
      paramSessionInfo = (MessageForPtt)this.G;
      paramSessionInfo.voiceType = paramRecorderParam.mAudioType;
      paramSessionInfo.voiceLength = QQRecorder.d(j);
      if (this.mType > 0) {}
      for (;;)
      {
        paramSessionInfo.voiceChangeFlag = i;
        this.mApp.a().a(localaool);
        paramSessionInfo = localaool.mPeerUin + localaool.mUniseq;
        gC.put(paramSessionInfo, new alit.a(this.mPath, this.mTempPath));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PttPreSendManager", 2, "doPreSendIfIcan ：true");
        return;
        i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("PttPreSendManager", 2, "doPreSendIfIcan : false, flow don't enough or size < 0, seiz : " + this.aCy);
    }
    cleanUp();
  }
  
  /* Error */
  public boolean a(com.tencent.mobileqq.activity.BaseChatPie paramBaseChatPie, int paramInt)
  {
    // Byte code:
    //   0: getstatic 269	alit:cxq	Z
    //   3: ifeq +48 -> 51
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 50	alit:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokespecial 271	alit:bx	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   14: ifeq +37 -> 51
    //   17: aload_0
    //   18: getfield 273	alit:jdField_a_of_type_Alir	Lalir;
    //   21: aload_0
    //   22: getfield 50	alit:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: iload_2
    //   26: invokevirtual 278	alir:F	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   29: aload_0
    //   30: getfield 44	alit:mType	I
    //   33: iload_2
    //   34: if_icmpne +17 -> 51
    //   37: aload_0
    //   38: getfield 140	alit:jdField_a_of_type_Alis	Lalis;
    //   41: aload_0
    //   42: getfield 142	alit:Tn	Z
    //   45: ldc2_w 279
    //   48: invokevirtual 284	alis:N	(ZJ)V
    //   51: aload_0
    //   52: getfield 48	alit:cxr	Z
    //   55: ifne +11 -> 66
    //   58: iconst_0
    //   59: istore_3
    //   60: aload_0
    //   61: invokevirtual 164	alit:cleanUp	()V
    //   64: iload_3
    //   65: ireturn
    //   66: aload_0
    //   67: getfield 50	alit:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Laooi;
    //   73: astore 5
    //   75: new 104	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 222	alit:G	Lcom/tencent/mobileqq/data/MessageRecord;
    //   86: getfield 287	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   89: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 222	alit:G	Lcom/tencent/mobileqq/data/MessageRecord;
    //   96: getfield 196	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   99: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore 6
    //   107: aload 5
    //   109: aload 6
    //   111: invokevirtual 290	aooi:a	(Ljava/lang/String;)Laqoi;
    //   114: checkcast 292	aojr
    //   117: astore 4
    //   119: aload 4
    //   121: ifnonnull +8 -> 129
    //   124: iconst_0
    //   125: istore_3
    //   126: goto -66 -> 60
    //   129: iload_2
    //   130: aload_0
    //   131: getfield 44	alit:mType	I
    //   134: if_icmpeq +53 -> 187
    //   137: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +12 -> 152
    //   143: ldc 102
    //   145: iconst_2
    //   146: ldc_w 294
    //   149: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload 4
    //   154: invokevirtual 297	aojr:cancel	()I
    //   157: pop
    //   158: aload 5
    //   160: aload 6
    //   162: invokevirtual 301	aooi:oy	(Ljava/lang/String;)Z
    //   165: pop
    //   166: getstatic 39	alit:gC	Ljava/util/concurrent/ConcurrentHashMap;
    //   169: aload 6
    //   171: invokevirtual 76	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload_0
    //   176: getfield 124	alit:jdField_a_of_type_Aliu	Laliu;
    //   179: invokevirtual 304	aliu:deleteFile	()V
    //   182: iconst_0
    //   183: istore_3
    //   184: goto -124 -> 60
    //   187: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +36 -> 226
    //   193: ldc 102
    //   195: iconst_2
    //   196: new 104	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 306
    //   206: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 4
    //   211: getfield 310	aojr:h	Laool;
    //   214: getfield 313	aool:cNH	Z
    //   217: invokevirtual 316	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   220: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_0
    //   227: getfield 140	alit:jdField_a_of_type_Alis	Lalis;
    //   230: aload_0
    //   231: getfield 142	alit:Tn	Z
    //   234: aload_0
    //   235: getfield 46	alit:aCy	I
    //   238: i2l
    //   239: invokevirtual 284	alis:N	(ZJ)V
    //   242: aload_0
    //   243: getfield 50	alit:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   246: invokevirtual 320	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   249: aload_0
    //   250: getfield 222	alit:G	Lcom/tencent/mobileqq/data/MessageRecord;
    //   253: aload_0
    //   254: getfield 50	alit:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   257: invokevirtual 323	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   260: invokevirtual 328	com/tencent/imcore/message/QQMessageFacade:b	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 50	alit:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   267: aload_1
    //   268: getfield 334	com/tencent/mobileqq/activity/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   271: aload_0
    //   272: getfield 149	alit:mPath	Ljava/lang/String;
    //   275: bipush 253
    //   277: aload_0
    //   278: getfield 222	alit:G	Lcom/tencent/mobileqq/data/MessageRecord;
    //   281: getfield 196	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   284: invokestatic 337	ujt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;IJ)V
    //   287: new 339	com/tencent/mobileqq/ptt/preop/PttPreSendManager$1
    //   290: dup
    //   291: aload_0
    //   292: aload_1
    //   293: invokespecial 342	com/tencent/mobileqq/ptt/preop/PttPreSendManager$1:<init>	(Lalit;Lcom/tencent/mobileqq/activity/BaseChatPie;)V
    //   296: aconst_null
    //   297: iconst_0
    //   298: invokestatic 348	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   301: aload 4
    //   303: invokevirtual 351	aojr:dVj	()V
    //   306: aload 4
    //   308: monitorenter
    //   309: aload 4
    //   311: getfield 310	aojr:h	Laool;
    //   314: getfield 313	aool:cNH	Z
    //   317: ifeq +28 -> 345
    //   320: aload 5
    //   322: aload 4
    //   324: getfield 310	aojr:h	Laool;
    //   327: invokevirtual 246	aooi:a	(Laool;)Z
    //   330: pop
    //   331: aload_0
    //   332: aload 6
    //   334: invokevirtual 353	alit:Oj	(Ljava/lang/String;)V
    //   337: aload 4
    //   339: monitorexit
    //   340: iconst_1
    //   341: istore_3
    //   342: goto -282 -> 60
    //   345: aload 4
    //   347: getfield 310	aojr:h	Laool;
    //   350: iconst_1
    //   351: putfield 313	aool:cNH	Z
    //   354: goto -17 -> 337
    //   357: astore_1
    //   358: aload 4
    //   360: monitorexit
    //   361: aload_1
    //   362: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	alit
    //   0	363	1	paramBaseChatPie	com.tencent.mobileqq.activity.BaseChatPie
    //   0	363	2	paramInt	int
    //   59	283	3	bool	boolean
    //   117	242	4	localaojr	aojr
    //   73	248	5	localaooi	aooi
    //   105	228	6	str	String
    // Exception table:
    //   from	to	target	type
    //   309	337	357	finally
    //   337	340	357	finally
    //   345	354	357	finally
    //   358	361	357	finally
  }
  
  public void b(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    this.cxr = false;
    this.mType = -1;
    boolean bool4 = bx(this.mApp);
    boolean bool1 = bool3;
    long l;
    if (cxq)
    {
      bool1 = bool3;
      if (bool4)
      {
        this.mType = this.jdField_a_of_type_Alir.Hz();
        l = SystemClock.uptimeMillis();
        if (aqiw.getSystemNetwork(BaseApplicationImpl.sApplication) != 1) {
          break label310;
        }
      }
    }
    label310:
    for (bool1 = bool2;; bool1 = false)
    {
      this.Tn = bool1;
      if (QLog.isDevelopLevel()) {
        QLog.d("PttPreSendManager", 4, "get network type cost " + (SystemClock.uptimeMillis() - l));
      }
      bool1 = this.jdField_a_of_type_Alis.bg(this.Tn);
      if ((bool1) && (this.mType != -1))
      {
        this.mPath = paramString1;
        int i = this.mPath.lastIndexOf(".");
        this.mTempPath = paramString1.substring(0, i);
        this.mTempPath = this.mTempPath.concat("_pre").concat(paramString1.substring(i, paramString1.length()));
        this.cxr = this.jdField_a_of_type_Aliu.a(this.mApp.getApp(), this.mTempPath, this.mType, paramRecorderParam, paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, " startPreSendIfNeed : " + this.cxr + ", cpu : " + cxq + ", flow enough : " + bool1 + ", type : " + this.mType + ", cfg : " + bool4);
      }
      return;
    }
  }
  
  public void cleanUp()
  {
    if (!this.cxr) {}
    do
    {
      return;
      this.cxr = false;
      this.mPath = null;
      this.mTempPath = null;
      this.G = null;
    } while (!QLog.isDevelopLevel());
    QLog.e("PttPreSendManager", 4, "clean up");
  }
  
  public void dGn()
  {
    this.jdField_a_of_type_Alir.F(null, -1);
    if (!this.cxr) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("PttPreSendManager", 4, "doOnCancelSend");
    }
    Object localObject = this.mApp.a();
    String str = this.G.frienduin + this.G.uniseq;
    localObject = (aojr)((aooi)localObject).a(str);
    if (localObject != null) {
      ((aojr)localObject).cancel();
    }
    gC.remove(str);
    this.jdField_a_of_type_Aliu.deleteFile();
    cleanUp();
  }
  
  public void init()
  {
    if (!cxq) {
      switch (imm.getCpuArchitecture())
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Alis = new alis(this.mApp, 100000, 10000000, 86399999L);
      this.jdField_a_of_type_Alir = new alir(this.mApp);
      this.jdField_a_of_type_Aliu = new aliu();
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "init manager end ");
      }
      return;
      cxq = true;
    }
  }
  
  public void o(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.cxr) {}
    while (this.jdField_a_of_type_Aliu.d(paramArrayOfByte, paramInt)) {
      return;
    }
    cleanUp();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Alis != null) {
      this.jdField_a_of_type_Alis.dGm();
    }
    if (this.jdField_a_of_type_Alir != null) {
      this.jdField_a_of_type_Alir.dJ(this.mApp);
    }
  }
  
  static class a
  {
    String mPath;
    String mTempPath;
    
    public a(String paramString1, String paramString2)
    {
      this.mPath = paramString1;
      this.mTempPath = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alit
 * JD-Core Version:    0.7.0.1
 */