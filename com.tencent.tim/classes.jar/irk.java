import android.os.Environment;
import android.text.TextUtils;
import com.qq.wx.voice.embedqqegg.recognizer.SDKVersion;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizer;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecordState;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.recog.AVVoiceRecog.1;
import com.tencent.av.recog.AVVoiceRecog.2;
import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.os.MqqHandler;

public class irk
  implements jhb
{
  private static volatile irk jdField_a_of_type_Irk;
  private boolean Ux;
  private irk.a jdField_a_of_type_Irk$a;
  private irk.b jdField_a_of_type_Irk$b = new irk.b();
  private int asC = 1;
  public int asD;
  public int asE;
  public int asF;
  public int asG;
  Runnable bu = new AVVoiceRecog.1(this);
  Runnable bv = new AVVoiceRecog.2(this);
  String filename = hd();
  private VideoAppInterface mApp;
  private boolean mIsDebug;
  private boolean mIsPause = true;
  
  public static irk a()
  {
    if (jdField_a_of_type_Irk == null) {}
    try
    {
      if (jdField_a_of_type_Irk == null) {
        jdField_a_of_type_Irk = new irk();
      }
      return jdField_a_of_type_Irk;
    }
    finally {}
  }
  
  private void bK(int paramInt1, int paramInt2)
  {
    VideoController.a().unregisterDAudioDataCallback(0, false);
    QLog.w("AVVoiceRecog", 1, "pauseContinue, oldReasons[" + paramInt1 + "], reason[" + paramInt2 + "]");
  }
  
  private void bL(int paramInt1, int paramInt2)
  {
    a().vn();
    if (!this.Ux)
    {
      this.mIsPause = true;
      QLog.w("AVVoiceRecog", 1, "resumeContinue failed, !mIsInitAndStart, mPauseReason[" + this.asC + "], reason[" + paramInt2 + "]");
      return;
    }
    this.mIsPause = false;
    int i = VideoController.a().registerDAudioDataCallback(0, false);
    int j = VideoController.a().c(0, 16000, 1, 16);
    VideoController.a().a(1, this);
    QLog.w("AVVoiceRecog", 1, "resumeContinue, oldReasons[" + paramInt1 + "], mPauseReason[" + this.asC + "], reason[" + paramInt2 + "], mIsPause[" + this.mIsPause + "], regret[" + i + "], setret[" + j + "]");
  }
  
  /* Error */
  private void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 154	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 154	java/io/File
    //   13: dup
    //   14: new 93	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   21: aload_1
    //   22: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload 4
    //   38: invokevirtual 160	java/io/File:exists	()Z
    //   41: ifne +9 -> 50
    //   44: aload 4
    //   46: invokevirtual 163	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload_1
    //   51: invokevirtual 160	java/io/File:exists	()Z
    //   54: ifne +8 -> 62
    //   57: aload_1
    //   58: invokevirtual 166	java/io/File:createNewFile	()Z
    //   61: pop
    //   62: new 168	java/io/FileOutputStream
    //   65: dup
    //   66: aload_1
    //   67: iconst_1
    //   68: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   71: astore_2
    //   72: aload_3
    //   73: ifnull +10 -> 83
    //   76: aload_2
    //   77: astore_1
    //   78: aload_2
    //   79: aload_3
    //   80: invokevirtual 175	java/io/FileOutputStream:write	([B)V
    //   83: aload_2
    //   84: astore_1
    //   85: aload_2
    //   86: invokevirtual 178	java/io/FileOutputStream:flush	()V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   97: return
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   103: goto -41 -> 62
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   111: return
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: invokevirtual 185	java/io/FileNotFoundException:printStackTrace	()V
    //   121: aload_2
    //   122: ifnull -25 -> 97
    //   125: aload_2
    //   126: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   129: return
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   135: return
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: astore_1
    //   141: aload_3
    //   142: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   145: aload_2
    //   146: ifnull -49 -> 97
    //   149: aload_2
    //   150: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   159: return
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   171: aload_2
    //   172: athrow
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_2
    //   182: goto -19 -> 163
    //   185: astore_3
    //   186: goto -47 -> 139
    //   189: astore_3
    //   190: goto -75 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	irk
    //   0	193	1	paramString1	String
    //   0	193	2	paramString2	String
    //   0	193	3	paramArrayOfByte	byte[]
    //   8	37	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   57	62	98	java/io/IOException
    //   93	97	106	java/io/IOException
    //   62	72	112	java/io/FileNotFoundException
    //   125	129	130	java/io/IOException
    //   62	72	136	java/io/IOException
    //   149	153	154	java/io/IOException
    //   62	72	160	finally
    //   167	171	173	java/io/IOException
    //   78	83	181	finally
    //   85	89	181	finally
    //   117	121	181	finally
    //   141	145	181	finally
    //   78	83	185	java/io/IOException
    //   85	89	185	java/io/IOException
    //   78	83	189	java/io/FileNotFoundException
    //   85	89	189	java/io/FileNotFoundException
  }
  
  private static boolean d(VideoAppInterface paramVideoAppInterface)
  {
    return ((ikt)paramVideoAppInterface.a(5)).d(3, "normal");
  }
  
  private String hd()
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    return "audiodata" + str + ".pcm";
  }
  
  public static boolean vm()
  {
    return iwi.a(iwd.a().a()) == 1;
  }
  
  private boolean vo()
  {
    VoiceRecognizer.shareInstance().setListener(this.jdField_a_of_type_Irk$b);
    if (this.mIsDebug)
    {
      VoiceRecognizer.shareInstance().setOpenLogCat(true);
      VoiceRecognizer.shareInstance().setSaveVoice(true);
    }
    VoiceRecognizer.shareInstance().setContReco(true);
    DownloadInfo localDownloadInfo = iwd.a().a();
    if (localDownloadInfo == null)
    {
      QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. downloadInfo == null.");
      return false;
    }
    String str1 = iwi.getSoDir() + localDownloadInfo.filename_so_wxvoiceembedqqegg;
    String str2 = iwi.getModelDir() + localDownloadInfo.filename_model_wxvoiceembed;
    if (!iwd.a().ug())
    {
      iwd.a().uh();
      QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. soFile or modelFile no exist. soFullName = " + str1 + ", modelFullName = " + str2);
      return false;
    }
    int k = localDownloadInfo.thre;
    VoiceRecognizer.shareInstance().setWakeupThres(k);
    int i = -1;
    try
    {
      QLog.i("AVVoiceRecog", 1, "initRecognizer. soFullName = " + str1 + ", modelFullName = " + str2);
      bool = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getApplication().getApplicationContext(), "c++_shared");
      if (bool) {
        break label327;
      }
      try
      {
        QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. ret1 = " + bool);
        return false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      for (;;)
      {
        label327:
        int j;
        SDKVersion localSDKVersion;
        boolean bool = false;
      }
    }
    QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. ret1 = " + bool + ", ret2 = " + i + ", err = " + localUnsatisfiedLinkError1.getMessage());
    return false;
    j = VoiceRecognizer.shareInstance().init(BaseApplicationImpl.getApplication().getApplicationContext(), str1, str2);
    i = j;
    QLog.i("AVVoiceRecog", 1, "VoiceRecog. init. ret1 = " + bool + ", ret2 = " + j + ", thre = " + k);
    if ((!bool) || (j < 0))
    {
      i = j;
      QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. ret1 = " + bool + ", ret2 = " + j);
      return false;
    }
    localSDKVersion = new SDKVersion();
    i = VoiceRecognizer.shareInstance().getVersion(localSDKVersion);
    if (i < 0)
    {
      QLog.i("AVVoiceRecog", 1, "initRecognizer. getVersion failed. ret = " + i);
      return false;
    }
    QLog.i("AVVoiceRecog", 1, "initRecognizer OK. soVer = " + localSDKVersion.soVer + ", binVer = " + localSDKVersion.binVer);
    return true;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, irk.a parama)
  {
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_Irk$a = parama;
  }
  
  public void apM()
  {
    if (!this.Ux) {
      return;
    }
    VideoController.a().unregisterDAudioDataCallback(0, false);
    VideoController.a().a(1, null);
    VoiceRecognizer.shareInstance().cancel();
    VoiceRecognizer.shareInstance().destroy();
    this.Ux = false;
    QLog.i("AVVoiceRecog", 1, "stopAndUninit OK.");
  }
  
  public boolean cr(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mIsPause)
    {
      bool1 = bool2;
      if (this.asC != paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((QLog.isColorLevel()) || (!this.Ux) || (this.mIsPause)) {
      QLog.w("AVVoiceRecog", 1, "onReceiveAudioFrame, srcType[" + paramInt1 + "], size[" + paramInt2 + "]");
    }
    if ((!this.Ux) || (this.mIsPause)) {
      return;
    }
    if (this.mIsDebug) {
      c(Environment.getExternalStorageDirectory().getPath() + File.separator + "audiodata" + File.separator, this.filename, paramArrayOfByte);
    }
    VoiceRecognizer.shareInstance().appendData(paramArrayOfByte, 0, paramInt2, false);
  }
  
  public boolean isEnable()
  {
    return this.Ux;
  }
  
  public void pause(int paramInt)
  {
    this.asC |= paramInt;
    if (!this.Ux) {}
    do
    {
      return;
      int i = this.asC;
      this.asD = i;
      this.asE = paramInt;
      if (this.asC != i) {
        QLog.w("AVVoiceRecog", 1, "pause, reason[" + paramInt + "], mPauseReason[" + i + "->" + this.asC + "]");
      }
    } while (this.mIsPause);
    this.mIsPause = true;
    ThreadManager.getUIHandler().removeCallbacks(this.bv);
    ThreadManager.getUIHandler().post(this.bu);
  }
  
  public void resume(int paramInt)
  {
    if (!this.mIsPause) {
      return;
    }
    int i = this.asC;
    this.asF = i;
    this.asG = paramInt;
    this.asC &= (paramInt ^ 0xFFFFFFFF);
    QLog.w("AVVoiceRecog", 1, "resume, reason[" + paramInt + "], mIsPause[" + this.mIsPause + "], mPauseReason[" + i + "->" + this.asC + "]");
    if (this.asC == 0)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.bu);
      ThreadManager.getUIHandler().post(this.bv);
      return;
    }
    this.mIsPause = true;
  }
  
  public boolean vn()
  {
    if (this.Ux) {
      return this.Ux;
    }
    if (this.mApp == null) {
      return this.Ux;
    }
    if (!d(this.mApp))
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. not DeviceSupport.");
      this.Ux = false;
      return false;
    }
    Object localObject = iwd.a().a();
    QLog.i("AVVoiceRecog", 1, "initAndStart. downloadInfo = " + localObject);
    if (localObject == null)
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. downloadInfo == null.");
      this.Ux = false;
      return false;
    }
    if (!vm())
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. not EnableFromConfig.");
      String str = iwi.getSoDir() + ((DownloadInfo)localObject).filename_so_wxvoiceembedqqegg;
      localObject = iwi.getModelDir() + ((DownloadInfo)localObject).filename_model_wxvoiceembed;
      if (!iwd.a().ug())
      {
        iwd.a().uh();
        QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. soFile or modelFile no exist. soFullName = " + str + ", modelFullName = " + (String)localObject);
      }
      this.Ux = false;
      return false;
    }
    boolean bool = vo();
    if (!bool)
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. initret = " + bool);
      this.Ux = false;
      return false;
    }
    VoiceRecognizer.shareInstance().setKeywordSetIndex(0);
    int i = VoiceRecognizer.shareInstance().startReceiving();
    if (i < 0)
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. startReceiving failed. ret = " + i);
      this.Ux = false;
      return false;
    }
    QLog.i("AVVoiceRecog", 1, "initAndStart OK.");
    this.Ux = true;
    return this.Ux;
  }
  
  public static abstract interface a
  {
    public abstract void jv(String paramString);
  }
  
  class b
    implements VoiceRecognizerListener
  {
    b() {}
    
    public void onGetError(int paramInt)
    {
      QLog.d("AVVoiceRecog", 2, "onGetError. err = " + paramInt);
    }
    
    public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
    {
      if ((!irk.a(irk.this)) || (irk.b(irk.this))) {
        QLog.i("AVVoiceRecog", 1, "onGetResult. discard. !mIsInitAndStart || mIsPause.");
      }
      label162:
      for (;;)
      {
        return;
        if (paramVoiceRecognizerResult.isHalf)
        {
          QLog.i("AVVoiceRecog", 1, "onGetResult. result.isHalf.");
          return;
        }
        if (TextUtils.isEmpty(paramVoiceRecognizerResult.text)) {
          QLog.i("AVVoiceRecog", 1, "onGetResult. result.text == null.");
        }
        for (;;)
        {
          if (!paramVoiceRecognizerResult.isEnd) {
            break label162;
          }
          int i = VoiceRecognizer.shareInstance().startReceiving();
          if (i >= 0) {
            break;
          }
          QLog.i("AVVoiceRecog", 1, "restart falied. ret = " + i);
          return;
          QLog.i("AVVoiceRecog", 1, "onGetResult. result.text = " + paramVoiceRecognizerResult.text);
          if (irk.a(irk.this) != null) {
            irk.a(irk.this).jv(paramVoiceRecognizerResult.text);
          }
        }
      }
    }
    
    public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState)
    {
      QLog.d("AVVoiceRecog", 2, "onGetVoiceRecordState. state = " + paramVoiceRecordState);
    }
    
    public void onVolumeChanged(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVVoiceRecog", 2, "onVolumeChanged. volume = " + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irk
 * JD-Core Version:    0.7.0.1
 */