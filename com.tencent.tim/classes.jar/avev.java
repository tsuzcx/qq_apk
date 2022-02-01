import android.content.Context;
import android.util.Log;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.logger.AVLoggerChooser;
import com.tencent.TMG.sdk.AVAudioCtrl;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam.Builder;
import com.tencent.TMG.sdk.AVRoomMulti.EventListener;
import com.tencent.av.sig.QAVAuthBuffer;
import com.tencent.qphone.base.util.QLog;

public class avev
{
  private static String TAG = "LimixiuAVManager";
  private static avev jdField_a_of_type_Avev;
  avev.a jdField_a_of_type_Avev$a = null;
  avev.b jdField_a_of_type_Avev$b = null;
  avev.c jdField_a_of_type_Avev$c = null;
  AVContext jdField_a_of_type_ComTencentTMGSdkAVContext = null;
  private AVRoomMulti.EventListener jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener = new avew(this);
  String big = null;
  private Context mContext;
  
  private avev(Context paramContext)
  {
    this.mContext = paramContext;
    this.big = "user";
  }
  
  public static avev a(Context paramContext)
  {
    if (jdField_a_of_type_Avev == null) {}
    try
    {
      if (jdField_a_of_type_Avev == null) {
        jdField_a_of_type_Avev = new avev(paramContext);
      }
      return jdField_a_of_type_Avev;
    }
    finally {}
  }
  
  private AVContext.StartParam a()
  {
    aven localaven = new aven();
    localaven.sdkAppId = Integer.parseInt(this.jdField_a_of_type_Avev$a.bih);
    localaven.accountType = this.jdField_a_of_type_Avev$a.accountType;
    localaven.appIdAt3rd = this.jdField_a_of_type_Avev$a.bih;
    localaven.identifier = this.jdField_a_of_type_Avev$a.identifier;
    localaven.engineCtrlType = 2;
    localaven.ctd = Integer.valueOf(this.jdField_a_of_type_Avev$a.bii).intValue();
    localaven.ON = Long.valueOf(this.jdField_a_of_type_Avev$a.bij).longValue();
    QLog.i("AVManager", 1, "getStartParams|param.sdkAppId=" + localaven.sdkAppId + ", param.accountType=" + localaven.accountType + ", param.appIdAt3rd=" + localaven.appIdAt3rd + ", param.identifier=" + localaven.identifier + ", param.engineCtrlType=" + localaven.engineCtrlType + ", param.nGameID=" + localaven.ctd + ", param.lGameRoomID=" + localaven.ON);
    return localaven;
  }
  
  private AVRoomMulti.EnterParam a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    byte[] arrayOfByte = QAVAuthBuffer.a().genAuthBuffer(Integer.parseInt(this.jdField_a_of_type_Avev$a.bih), Integer.parseInt(paramString), this.jdField_a_of_type_Avev$a.identifier, Integer.parseInt(this.jdField_a_of_type_Avev$a.accountType), this.jdField_a_of_type_Avev$a.key, 1800, -1);
    return new AVRoomMulti.EnterParam.Builder(Integer.parseInt(paramString)).auth(-1L, arrayOfByte).avControlRole("user").autoCreateRoom(true).videoRecvMode(0).screenRecvMode(0).isEnableMic(paramBoolean1).isEnableSpeaker(paramBoolean2).isEnableHwEnc(true).isEnableHwDec(true).build();
  }
  
  public void a(avev.a parama)
  {
    this.jdField_a_of_type_Avev$a = parama;
  }
  
  public void a(avev.c paramc)
  {
    this.jdField_a_of_type_Avev$c = paramc;
  }
  
  public void a(AVCallback paramAVCallback)
  {
    int i = 0;
    AVChannelManager.setIMChannelType(1);
    com.tencent.TMG.utils.SoUtil.customLibPath = avez.getSoDir();
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
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.setAppVersion(this.jdField_a_of_type_Avev$a.appVersion);
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.start(a(), null, paramAVCallback);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, avev.b paramb)
  {
    QLog.i("AVManager", 1, "enterRoom.");
    this.jdField_a_of_type_Avev$b = paramb;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null)
    {
      Log.e("AVManager", "enterRoom| enter room faild, because of context not started.");
      if (this.jdField_a_of_type_Avev$b != null) {
        this.jdField_a_of_type_Avev$b.onEnterRoomComplete(1101, "context not started.");
      }
      return;
    }
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
  
  public boolean aKx()
  {
    boolean bool = false;
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {}
    for (int i = localAVAudioCtrl.getMicState();; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean aKy()
  {
    boolean bool = false;
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {}
    for (int i = localAVAudioCtrl.getSpeakerState();; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avev
 * JD-Core Version:    0.7.0.1
 */