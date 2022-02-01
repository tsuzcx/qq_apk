import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.utils.VipUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class ablz
  implements Handler.Callback, avfd, AudioPlayerBase.a, QQRecorder.a
{
  public static boolean bDL;
  public static boolean bDM;
  public static String bgT = "1400035750";
  public static String bgU = "5d3728db75adf458";
  public static String bgV = "105d1e43c456bc800b4adacd57ac1199";
  public static String sURL = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
  private ablz.a jdField_a_of_type_Ablz$a;
  private ablz.c jdField_a_of_type_Ablz$c;
  private boolean bDK;
  private volatile boolean bDN;
  private boolean bDO;
  boolean bDP = false;
  private String bgW = "";
  private String bgX;
  private String bgY;
  private String bgZ;
  private QQRecorder c;
  private final Object ck = new Object();
  private int cpQ;
  private int cpR = 5;
  private WeakReference<xxh> fB;
  public WeakReference<ablz.b> fC;
  public WeakReference<ablz.d> fD;
  private QQAppInterface mApp;
  private MediaPlayer mAudioPlayer;
  public long mRecordTime;
  private Handler mUIHandler;
  
  public ablz(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mUIHandler = new auru(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Ablz$a = new ablz.a(paramQQAppInterface);
    ((abhh)paramQQAppInterface.getManager(153)).a().a(this.jdField_a_of_type_Ablz$a);
    avfb.a().a(this);
    QP();
  }
  
  private void Hs(int paramInt)
  {
    if ((this.fD != null) && (this.fD.get() != null))
    {
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "[onReportRecordInfoResp] upload record succ.");
        }
        ((ablz.d)this.fD.get()).cDa();
      }
    }
    else {
      return;
    }
    ((ablz.d)this.fD.get()).Hu(paramInt);
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[onReportRecordInfoResp] uploadError,retcode:" + paramInt);
  }
  
  public void D(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[enterRoom] friUin:" + paramString1 + ",roomId:" + paramString2 + ",from:" + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[enterRoom] uin or roomId is empty");
      return;
    }
    Bundle localBundle;
    if ((Build.VERSION.SDK_INT >= 23) && (BaseActivity.sTopActivity != null) && (BaseActivity.sTopActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
    {
      if (paramInt != 318) {
        break label215;
      }
      localBundle = new Bundle();
      localBundle.putString("key_dialog_type", "dialog_type_permission");
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_show_audio_dialog", localBundle, null);
    }
    for (;;)
    {
      localBundle = new Bundle();
      localBundle.putString("uin", paramString1);
      localBundle.putString("friUin", paramString1);
      localBundle.putString("roomId", paramString2);
      localBundle.putInt("from", paramInt);
      paramString1 = Message.obtain();
      paramString1.setData(localBundle);
      paramString1.what = 2;
      this.mUIHandler.removeMessages(2);
      this.mUIHandler.sendMessage(paramString1);
      return;
      label215:
      if ((this.fB != null) && (this.fB.get() != null)) {
        ((xxh)this.fB.get()).yk("dialog_type_permission");
      }
    }
  }
  
  public boolean QP()
  {
    boolean bool2 = false;
    if (this.bDO) {
      return true;
    }
    boolean bool1;
    if (abxh.bn != null)
    {
      bgT = abxh.bn.optString("appid", "1400035750");
      bgU = abxh.bn.optString("key", "5d3728db75adf458");
      sURL = abxh.bn.optString("url", "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip");
      bgV = abxh.bn.optString("md5", "105d1e43c456bc800b4adacd57ac1199");
      if (abxh.bn.optInt("openAudio", 0) != 0)
      {
        bool1 = true;
        bDL = bool1;
        bool1 = bool2;
        if (abxh.bn.optInt("display", 0) != 0) {
          bool1 = true;
        }
        bDM = bool1;
        QLog.i("CmGameTemp_CmGameAudioManager", 1, "[initParams] appId:" + bgT + ",key:" + bgU + ",url:" + sURL + ",md5:" + bgV + ",OPEN_AUDIO:" + bDL + ",sDISPLAY:" + bDM);
        avfb.a().jn(sURL, bgV);
      }
    }
    for (this.bDO = true;; this.bDO = false)
    {
      return this.bDO;
      bool1 = false;
      break;
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[initParams] gameAudioConfig is null");
    }
  }
  
  public boolean YA()
  {
    boolean bool = false;
    if (this.c != null)
    {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[startRecord] stop record");
      if (this.c.isRecording()) {
        this.c.stop();
      }
      this.c.release();
      bool = true;
    }
    return bool;
  }
  
  public boolean YB()
  {
    synchronized (this.ck)
    {
      if (this.mAudioPlayer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "[stopUserRecord] stop record:");
        }
        this.mAudioPlayer.stop();
        this.mAudioPlayer.release();
        this.mAudioPlayer = null;
        return true;
      }
      return false;
    }
  }
  
  public boolean Yz()
  {
    return this.bDN;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onBeginReceiveData");
    return this.cpR * 1000;
  }
  
  public void a(int paramInt, ablz.b paramb)
  {
    this.cpR = paramInt;
    this.fC = new WeakReference(paramb);
    if (this.c == null)
    {
      this.c = new QQRecorder(this.mApp.getApplication());
      paramb = new QQRecorder.RecorderParam(aqlv.dZQ, 0, 0);
      this.c.b(paramb);
      this.c.a(this);
    }
    paramb = new File(abxi.biC);
    if (!paramb.exists()) {
      paramb.mkdirs();
    }
    paramb = rd();
    if (this.c.isRecording()) {
      this.c.stop();
    }
    this.c.start(paramb, true);
    QLog.i("CmGameTemp_CmGameAudioManager", 0, "[startRecord] start record");
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[AudioPlayerListener] onError:" + paramInt);
  }
  
  public void a(String paramString, ablz.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[uploadFile] uploadFile:" + paramString);
    }
    if (this.jdField_a_of_type_Ablz$c == null) {
      this.jdField_a_of_type_Ablz$c = new ablz.c(this.mApp);
    }
    aooi localaooi = this.mApp.a();
    this.fD = new WeakReference(paramd);
    if (localaooi != null)
    {
      if (!this.bDP)
      {
        this.jdField_a_of_type_Ablz$c.addFilter(new Class[] { aojg.class });
        localaooi.a(this.jdField_a_of_type_Ablz$c);
        this.bDP = true;
      }
      paramd = new aool();
      paramd.mFileType = 24;
      paramd.dOM = 36;
      paramd.mSelfUin = this.mApp.getCurrentUin();
      paramd.mPeerUin = this.mApp.getCurrentUin();
      paramd.cNy = true;
      paramd.dQH = ((int)new File(paramString).length());
      paramd.dQ = paramString;
      localaooi.a(paramd);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i = 1;
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderPrepare");
    byte[] arrayOfByte = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
    if (paramRecorderParam.mUserData == null) {}
    while (i == 0)
    {
      anqo.a(this.mApp, paramRecorderParam.mAudioType, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      anqo.a(paramString, arrayOfByte, arrayOfByte.length, (short)0);
      return;
      i = 0;
    }
    alid.nY(paramString);
    alid.a(paramString, arrayOfByte, arrayOfByte.length);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderEnd,totalTime:" + paramDouble);
    if ((this.fC != null) && (this.fC.get() != null)) {
      ((ablz.b)this.fC.get()).onStop();
    }
    int i;
    if (paramRecorderParam != null)
    {
      if (paramRecorderParam.mUserData != null) {
        break label107;
      }
      i = 1;
      if (i != 0) {
        break label113;
      }
      anqo.cU(paramString, false);
      anqo.Rl(paramString);
    }
    for (;;)
    {
      this.mRecordTime = (paramDouble);
      if (this.c != null) {
        this.c.release();
      }
      return;
      label107:
      i = 0;
      break;
      label113:
      alid.nZ(paramString);
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderError");
    if ((this.fC != null) && (this.fC.get() != null)) {
      ((ablz.b)this.fC.get()).Ht(-2);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[QQRecorder] onRecorderSilceEnd size：" + paramInt1);
    }
    if (paramRecorderParam.mUserData == null) {}
    for (paramInt2 = 1; paramInt2 == 0; paramInt2 = 0)
    {
      anqo.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    alid.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public void ar(boolean paramBoolean, String paramString)
  {
    if (this.fB != null)
    {
      xxh localxxh = (xxh)this.fB.get();
      if ((localxxh != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localxxh.oL()))) {
        localxxh.zG(paramBoolean);
      }
    }
    abmm.a().as(paramBoolean, paramString);
  }
  
  public void as(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[QQRecorder] onRecorderVolumeStateChanged");
    }
  }
  
  public void at(String paramString)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderNotReady");
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderAbnormal");
  }
  
  public void b(xxh paramxxh)
  {
    this.fB = new WeakReference(paramxxh);
  }
  
  public void bX(Bundle paramBundle)
  {
    int i = 2;
    String str = paramBundle.getString("gmesdk_event_key");
    int j = paramBundle.getInt("gmesdk_event_ret");
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "key:" + str + ",ret:" + j);
    if ("gmesdk_event_key_enterroom".equals(str))
    {
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "key:" + str + ",ret:" + j + ",roomId:" + this.bgZ);
      if ((j == 0) || (j == 1003))
      {
        this.bDN = true;
        this.bgW = this.bgY;
        this.bgX = this.bgZ;
        ((abhh)this.mApp.getManager(153)).a().g(this.bgW, true, this.cpQ);
        ar(true, this.bgW);
        if (this.cpQ == 319) {
          i = 1;
        }
        VipUtils.a(null, "cmshow", "Apollo", "turnOnAudio", i, 0, new String[0]);
      }
    }
    while (!"gmesdk_event_key_exit_room".equals(str))
    {
      return;
      ((abhh)this.mApp.getManager(153)).a().g(this.bgW, false, this.cpQ);
      ar(false, this.bgW);
      if (this.cpQ == 319) {
        i = 1;
      }
      VipUtils.a(null, "cmshow", "Apollo", "turnOnAudio", i, 1, new String[0]);
      return;
    }
    this.bDK = false;
    this.bDN = false;
    ((abhh)this.mApp.getManager(153)).a().g(this.bgW, false, this.cpQ);
    ar(false, this.bgW);
    this.bgW = "";
    if (this.cpQ == 319) {
      i = 1;
    }
    VipUtils.a(null, "cmshow", "Apollo", "turnOffAudio", i, 0, new String[0]);
  }
  
  public int bz()
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderStart");
    if ((this.fC != null) && (this.fC.get() != null)) {
      ((ablz.b)this.fC.get()).cCZ();
    }
    return 250;
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onInitFailed");
    if ((this.fC != null) && (this.fC.get() != null)) {
      ((ablz.b)this.fC.get()).Ht(-1);
    }
  }
  
  public void cCY()
  {
    this.mUIHandler.removeMessages(1);
    this.mUIHandler.sendEmptyMessage(1);
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void dc(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[audioSwitch] friUin:" + paramString + ",from:" + paramInt + ",mCurrentFriUin:" + this.bgW);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!QP());
      if (!this.bDN) {
        break;
      }
      if (paramString.equals(this.bgW))
      {
        this.mUIHandler.removeMessages(1);
        this.mUIHandler.sendEmptyMessage(1);
        return;
      }
      if (paramInt == 318)
      {
        paramString = new Bundle();
        paramString.putString("key_game_friUin", this.bgW);
        paramString.putString("key_dialog_type", "dialog_type_confirm");
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_show_audio_dialog", paramString, null);
        return;
      }
    } while ((this.fB == null) || (this.fB.get() == null));
    ((xxh)this.fB.get()).yk("dialog_type_confirm");
    return;
    dd(paramString, paramInt);
  }
  
  public void dd(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[queryRoomAndEnter] friUin:" + paramString + ",currentRoom:" + this.bgX);
    }
    if (!QP()) {
      return;
    }
    abhh localabhh = (abhh)this.mApp.getManager(153);
    if (this.bDN)
    {
      this.mUIHandler.removeMessages(1);
      this.mUIHandler.sendEmptyMessage(1);
    }
    localabhh.a().dg(paramString, paramInt);
  }
  
  public void de(String paramString, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[exitRoom] uin:" + paramString + ",from:" + paramInt + ",mCurrentUin:" + this.bgW + ",mCurrentRoomId:" + this.bgX);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.bgW)) || (!paramString.equals(this.bgW)));
      if (paramInt != 318) {
        break;
      }
      paramInt = i;
      if (this.fB != null)
      {
        paramInt = i;
        if (this.fB.get() != null) {
          paramInt = 1;
        }
      }
    } while ((paramInt != 0) && (this.bgW.equals(((xxh)this.fB.get()).oL())));
    this.mUIHandler.removeMessages(1);
    this.mUIHandler.sendEmptyMessage(1);
    return;
    if (abmt.aY(BaseApplicationImpl.getContext()))
    {
      paramString = new abma(this);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", this.bgW);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_check_game_running", localBundle, paramString);
      return;
    }
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[exitRoom] game is not exist. exit room");
    this.mUIHandler.removeMessages(1);
    this.mUIHandler.sendEmptyMessage(1);
  }
  
  public void hB()
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onInitSuccess");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[handleMessage] exitRoom,roomId:" + this.bgX);
      avfb.a().Wu(false);
      avfb.a().Wv(false);
      avfb.a().CT(this.bgX);
      return false;
    }
    paramMessage = paramMessage.getData();
    String str1 = paramMessage.getString("uin");
    String str2 = paramMessage.getString("roomId");
    int i = paramMessage.getInt("from");
    QLog.i("CmGameTemp_CmGameAudioManager", 0, "[handleMessage] enterRoom,uin:" + str1 + ",roomId:" + str2 + ",from:" + i);
    this.bgY = str1;
    this.bgZ = str2;
    this.cpQ = i;
    avfb.a().CT(this.bgX);
    if ((!TextUtils.isEmpty(bgT)) && (!TextUtils.isEmpty(bgU)))
    {
      avfb.a().b(bgT, this.mApp.getCurrentUin(), bgU, str2, true, true);
      return false;
    }
    QLog.e("CmGameTemp_CmGameAudioManager", 0, "[handleMessage] appid or key is null!enter room failed");
    return false;
  }
  
  public boolean ju(String paramString)
  {
    return (!TextUtils.isEmpty(this.bgW)) && (this.bgW.equals(paramString)) && (this.bDN);
  }
  
  public boolean jv(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[playUserRecord] play record:" + paramString);
    }
    synchronized (this.ck)
    {
      if (this.mAudioPlayer == null) {
        this.mAudioPlayer = new MediaPlayer();
      }
      try
      {
        if (this.mAudioPlayer.isPlaying())
        {
          if (QLog.isColorLevel()) {
            QLog.i("CmGameTemp_CmGameAudioManager", 0, "record is playing");
          }
          this.mAudioPlayer.stop();
        }
        this.mAudioPlayer.reset();
        if (TextUtils.isEmpty(paramString))
        {
          if (!new File(rd()).exists())
          {
            QLog.e("CmGameTemp_CmGameAudioManager", 1, "audio file not exist.");
            return false;
          }
          this.mAudioPlayer.setDataSource(rd());
          this.mAudioPlayer.prepare();
          this.mAudioPlayer.start();
          return true;
        }
        this.mAudioPlayer.setDataSource(paramString);
        this.mAudioPlayer.prepare();
        this.mAudioPlayer.start();
        return true;
      }
      catch (IOException paramString)
      {
        QLog.e("CmGameTemp_CmGameAudioManager", 1, paramString.getMessage());
        return false;
      }
    }
  }
  
  public void onDestory()
  {
    ((abhh)this.mApp.getManager(153)).a().b(this.jdField_a_of_type_Ablz$a);
    avfb.a().cOC();
    aooi localaooi = this.mApp.a();
    if (localaooi != null)
    {
      localaooi.b(this.jdField_a_of_type_Ablz$c);
      this.jdField_a_of_type_Ablz$c = null;
      this.bDP = false;
    }
    if (this.c != null)
    {
      this.c.stop();
      this.c.release();
      this.c = null;
    }
  }
  
  public String rc()
  {
    return this.bgW;
  }
  
  public String rd()
  {
    return abxi.biC + this.mApp.getCurrentAccountUin() + ".amr";
  }
  
  static class a
    extends abmi.a
  {
    public QQAppInterface mApp;
    
    a(QQAppInterface paramQQAppInterface)
    {
      this.mApp = paramQQAppInterface;
    }
    
    public void Hs(int paramInt)
    {
      super.Hs(paramInt);
      ablz.a(((abhh)this.mApp.getManager(153)).a(), paramInt);
    }
    
    public void X(String paramString, int paramInt1, int paramInt2)
    {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[onQueryAudioRoomId] friUin:" + paramString + ",roomID:" + paramInt1);
      super.X(paramString, paramInt1, paramInt2);
      ((abhh)this.mApp.getManager(153)).a().D(paramString, String.valueOf(paramInt1), paramInt2);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Ht(int paramInt);
    
    public abstract void cCZ();
    
    public abstract void onStop();
  }
  
  public static class c
    extends aook
  {
    QQAppInterface mApp;
    
    public c(QQAppInterface paramQQAppInterface)
    {
      this.mApp = paramQQAppInterface;
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject = (aoko)paramMessage.obj;
      if ((localObject == null) || (((aoko)localObject).commandId != 36)) {}
      do
      {
        int i;
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            case 1002: 
            default: 
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "start upload cmshow record");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("CmGameTemp_CmGameAudioManager", 0, "finish upload cmshow record" + ((aoko)localObject).serverPath);
          }
          try
          {
            paramMessage = new cmd0x346.RspBody();
            paramMessage.mergeFrom(((aoko)localObject).fL);
            paramMessage = (cmd0x346.ApplyDownloadRsp)paramMessage.msg_apply_download_rsp.get();
            i = paramMessage.int32_ret_code.get();
            if (i != 0) {
              break;
            }
            paramMessage = (cmd0x346.DownloadInfo)paramMessage.msg_download_info.get();
            if ((paramMessage != null) && (paramMessage.str_download_url.has())) {}
            paramMessage = paramMessage.str_download_url.get();
            QLog.i("CmGameTemp_CmGameAudioManager", 1, "[uploadFile] url:" + paramMessage);
            localObject = (abhh)this.mApp.getManager(153);
            ablz localablz = ((abhh)localObject).a();
            ((abhh)localObject).a().g(this.mApp.getCurrentUin(), paramMessage, localablz.mRecordTime);
            return;
          }
          catch (Exception paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.e("CmGameTemp_CmGameAudioManager", 0, "upload cmshow record response error e=" + paramMessage.toString());
        return;
        QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload fail," + i);
        paramMessage = ((abhh)this.mApp.getManager(153)).a();
      } while ((paramMessage.fD == null) || (paramMessage.fD.get() == null));
      ((ablz.d)paramMessage.fD.get()).Hu(-1);
      return;
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload error:" + ((aoko)localObject).serverPath);
      return;
      QLog.i("CmGameTemp_CmGameAudioManager", 1, "upload cmshow cancel:" + ((aoko)localObject).serverPath);
    }
  }
  
  public static abstract interface d
  {
    public abstract void Hu(int paramInt);
    
    public abstract void cDa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ablz
 * JD-Core Version:    0.7.0.1
 */