import android.content.Context;
import android.util.Log;
import com.tencent.TMG.channel.AVAppChannel;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.logger.AVLoggerChooser;
import com.tencent.TMG.sdk.AVAudioCtrl;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.TMG.sdk.AVCustomSpearEngineCtrl;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam.Builder;
import com.tencent.TMG.sdk.AVRoomMulti.EventListener;
import com.tencent.qphone.base.util.QLog;

public class abvy
{
  private static String TAG = "LimixiuAVManager";
  private static abvy jdField_a_of_type_Abvy;
  abvy.a jdField_a_of_type_Abvy$a = null;
  abvy.b jdField_a_of_type_Abvy$b = null;
  abvy.c jdField_a_of_type_Abvy$c = null;
  AVContext jdField_a_of_type_ComTencentTMGSdkAVContext = null;
  private AVRoomMulti.EventListener jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener = new abvz(this);
  String big = null;
  private Context mContext;
  
  private abvy(Context paramContext)
  {
    this.mContext = paramContext;
    this.big = "user";
  }
  
  public static abvy a(Context paramContext)
  {
    if (jdField_a_of_type_Abvy == null) {}
    try
    {
      if (jdField_a_of_type_Abvy == null) {
        jdField_a_of_type_Abvy = new abvy(paramContext);
      }
      return jdField_a_of_type_Abvy;
    }
    finally {}
  }
  
  private AVContext.StartParam a()
  {
    abvp localabvp = new abvp();
    localabvp.sdkAppId = Integer.parseInt(this.jdField_a_of_type_Abvy$a.bih);
    localabvp.accountType = this.jdField_a_of_type_Abvy$a.accountType;
    localabvp.appIdAt3rd = this.jdField_a_of_type_Abvy$a.bih;
    localabvp.identifier = this.jdField_a_of_type_Abvy$a.identifier;
    localabvp.engineCtrlType = 2;
    localabvp.ctd = Integer.valueOf(this.jdField_a_of_type_Abvy$a.bii).intValue();
    localabvp.ON = Long.valueOf(this.jdField_a_of_type_Abvy$a.bij).longValue();
    QLog.i("AVManager", 1, "getStartParams|param.sdkAppId=" + localabvp.sdkAppId + ", param.accountType=" + localabvp.accountType + ", param.appIdAt3rd=" + localabvp.appIdAt3rd + ", param.identifier=" + localabvp.identifier + ", param.engineCtrlType=" + localabvp.engineCtrlType + ", param.nGameID=" + localabvp.ctd + ", param.lGameRoomID=" + localabvp.ON);
    return localabvp;
  }
  
  private AVRoomMulti.EnterParam a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    String str = this.big;
    QLog.e("AVManager", 1, "getEnterRoomParam roomID=" + paramString + ", roomRoleValue=" + str + ", videoRecvMode=" + paramInt + ", screenRecMode=" + 0 + ", mic=" + paramBoolean1 + ", speaker=" + paramBoolean2);
    return new AVRoomMulti.EnterParam.Builder(Integer.parseInt(paramString)).avControlRole(str).autoCreateRoom(true).videoRecvMode(paramInt).screenRecvMode(0).isEnableMic(paramBoolean1).isEnableSpeaker(paramBoolean2).isEnableHwEnc(true).isEnableHwDec(true).build();
  }
  
  public void CU(String paramString)
  {
    this.big = paramString;
  }
  
  public AVContext a()
  {
    return this.jdField_a_of_type_ComTencentTMGSdkAVContext;
  }
  
  public void a(abvy.a parama)
  {
    this.jdField_a_of_type_Abvy$a = parama;
  }
  
  public void a(abvy.c paramc)
  {
    this.jdField_a_of_type_Abvy$c = paramc;
  }
  
  public void a(AVCallback paramAVCallback)
  {
    int i = 0;
    AVChannelManager.setIMChannelType(2);
    com.tencent.TMG.utils.SoUtil.customLibPath = abwe.getSoDir();
    AVLoggerChooser.setUseImsdk(false);
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      this.jdField_a_of_type_ComTencentTMGSdkAVContext = AVContext.createInstance(this.mContext, false);
    }
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      if (AVContext.getSoExtractError() != 0) {
        i = AVContext.getSoExtractError();
      }
    }
    for (;;)
    {
      QLog.i("AVManager", 1, "startContext|ret=" + i);
      if (i != 0) {
        paramAVCallback.onComplete(i, "internal error.");
      }
      return;
      i = 1101;
      continue;
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.setAppVersion(this.jdField_a_of_type_Abvy$a.appVersion);
      AVChannelManager.setAppChannel(new abwa());
      AVChannelManager.getAppChannel().loginWithParam(a());
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.start(a(), null, paramAVCallback);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, abvy.b paramb)
  {
    QLog.i("AVManager", 1, "enterRoom.");
    this.jdField_a_of_type_Abvy$b = paramb;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null)
    {
      Log.e("AVManager", "enterRoom| enter room faild, because of context not started.");
      if (this.jdField_a_of_type_Abvy$b != null) {
        this.jdField_a_of_type_Abvy$b.onEnterRoomComplete(1101, "context not started.");
      }
      return;
    }
    AVChannelManager.getAppChannel().loginWithParam(a());
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl().startTRAEService();
    QLog.e("AVManager", 1, "enterRoom| try enter room implement!!!!!!!!!");
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.enterRoom(this.jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener, a(paramString, paramBoolean1, paramBoolean2, paramInt));
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableMicCompleteCallback paramEnableMicCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableMic(paramBoolean, paramEnableMicCompleteCallback);
    }
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableSpeaker(paramBoolean, paramEnableSpeakerCompleteCallback);
    }
  }
  
  public void cFP()
  {
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.destroy();
    }
    this.jdField_a_of_type_ComTencentTMGSdkAVContext = null;
    QLog.e("AVManager", 1, "destroyContext");
  }
  
  public void dE(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int exitRoom()
  {
    int i = 1003;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      i = this.jdField_a_of_type_ComTencentTMGSdkAVContext.exitRoom();
    }
    QLog.i("AVManager", 1, "exitRoom|ret=" + i);
    return i;
  }
  
  public AVCustomSpearEngineCtrl getCustomSpearEngineCtrl()
  {
    return a().getCustomSpearEngineCtrl();
  }
  
  public void he(long paramLong)
  {
    QLog.i("AVManager", 1, "setGameRoomID|lGameRoomID=" + paramLong);
    this.jdField_a_of_type_Abvy$a.bij = String.valueOf(paramLong);
  }
  
  public void hf(long paramLong)
  {
    QLog.i("AVManager", 1, "setGameID|lGameID=" + paramLong);
    this.jdField_a_of_type_Abvy$a.bii = String.valueOf(paramLong);
  }
  
  public void pauseAudio()
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null)
    {
      localAVAudioCtrl.PauseAudioByUser();
      localAVAudioCtrl.stopTRAEService();
    }
  }
  
  public void resumeAudio()
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null)
    {
      localAVAudioCtrl.ResumeAudioByUser();
      localAVAudioCtrl.startTRAEService();
    }
  }
  
  public int zU()
  {
    int i = 1003;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      i = this.jdField_a_of_type_ComTencentTMGSdkAVContext.stop();
    }
    QLog.i("AVManager", 1, "stopContext|ret=" + i);
    return i;
  }
  
  public static class a
  {
    public String accountType = "";
    public String appVersion = "";
    public String bih = "";
    public String bii = "0";
    public String bij = "0";
    public String identifier = "";
    public String key = "";
  }
  
  public static abstract interface b
  {
    public abstract void onEnterRoomComplete(int paramInt, String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void onEndpointsUpdateInfo(int paramInt, String[] paramArrayOfString);
    
    public abstract void onExitRoomComplete();
    
    public abstract void onRoomDisconnect(int paramInt, String paramString);
    
    public abstract void onSemiAutoRecvCameraVideo(String[] paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvy
 * JD-Core Version:    0.7.0.1
 */