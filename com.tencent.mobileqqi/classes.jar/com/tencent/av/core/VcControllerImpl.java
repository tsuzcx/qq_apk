package com.tencent.av.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import bhh;
import bhi;
import bhj;
import com.tencent.common.app.BaseApplicationImpl;

public class VcControllerImpl
{
  public static final int EV_M2MVIDEO_DEC_FRAME_DATA = 15;
  public static final int EV_VOIP_ANOTHERISRING = 25;
  public static final int EV_VOIP_ANOTHERRINGDISCONNECTED = 26;
  public static final int EV_VOIP_ANOTHER_HAVEDACCEPT = 13;
  public static final int EV_VOIP_ANOTHER_HAVEDREJECT = 14;
  public static final int EV_VOIP_AUDIO_REQUEST = 2;
  public static final int EV_VOIP_AUDIO_SWITCH = 50;
  public static final int EV_VOIP_CAN_RECV_AUDIO_DATA = 63;
  public static final int EV_VOIP_CLOSED = 4;
  public static final int EV_VOIP_CLOSED_SWITCH_GROUP = 69;
  public static final int EV_VOIP_CONFIGSYS_DEAL_DONE = 18;
  public static final int EV_VOIP_CONNFAIL = 24;
  public static final int EV_VOIP_FRIEND_ACCEPTED = 3;
  public static final int EV_VOIP_HAS_RECV_FIRST_AUDIO_PACKET = 64;
  public static final int EV_VOIP_HAS_RECV_FIRST_VIDEOFRAME = 66;
  public static final int EV_VOIP_InviteReached = 68;
  public static final int EV_VOIP_MEDIA_CAMERA_NOTIFY = 65;
  public static final int EV_VOIP_MOBILE_AUDIO_REQ = 60;
  public static final int EV_VOIP_MOBILE_VIDEO_REQ = 61;
  public static final int EV_VOIP_NETWORK_BAD = 11;
  public static final int EV_VOIP_NETWORK_GOOD = 12;
  public static final int EV_VOIP_NETWORK_MONITOR_INFO = 16;
  public static final int EV_VOIP_NOT_RECV_AUDIO_DATA = 62;
  public static final int EV_VOIP_PAUSEAUDIO = 7;
  public static final int EV_VOIP_PAUSEVIDEO = 8;
  public static final int EV_VOIP_PEER_NET_STATE_CHECK = 67;
  public static final int EV_VOIP_RECEIVER_RECEIVED_REQ = 17;
  public static final int EV_VOIP_RECEIVE_RELAYASVR_INFO = 5;
  public static final int EV_VOIP_RELAY_SVR_CONNECTED = 6;
  public static final int EV_VOIP_RESUMEAUDIO = 9;
  public static final int EV_VOIP_RESUMEVIDEO = 10;
  public static final int EV_VOIP_SWITCHAUDIO = 19;
  public static final int EV_VOIP_SWITCHVIDEO = 20;
  public static final int EV_VOIP_SWITCHVIDEOCANCEL = 22;
  public static final int EV_VOIP_SWITCHVIDEOCONFIRM = 21;
  public static final int EV_VOIP_VIDEO_REQUEST = 1;
  public static int NATIVE_ERR_NOT_INI = 0;
  public static int NATIVE_ERR_NO_ENV = 0;
  public static int NATIVE_ERR_NULL_PARA = 0;
  public static int NATIVE_ERR_OUT_MEM = -101;
  private static String SPDEFVALUE = "preview-size-values=320x240,640x480;";
  private static String SPKEY;
  private static String SPNAME;
  public static final int VOIP_REASON_CALL_TYPE_NOT_SUIT = 17;
  public static final int VOIP_REASON_CANCLE_BY_REQUESTER_BEFORECALLING = 18;
  public static final int VOIP_REASON_CAPA_EXCHANGE_FAILED = 15;
  public static final int VOIP_REASON_CLOSED_BY_FRIEND = 1;
  public static final int VOIP_REASON_CLOSED_BY_SELF = 0;
  public static final int VOIP_REASON_CLOSED_BY_SELF_IGNORE = 16;
  public static final int VOIP_REASON_CLOSED_BY_SWITCHTOGROUP = 20;
  public static final int VOIP_REASON_CONFLICT = 6;
  public static final int VOIP_REASON_FRIEND_CONFLICT = 7;
  public static final int VOIP_REASON_FRIEND_OFFLINE = 14;
  public static final int VOIP_REASON_FRIEND_VERSION_NOT_SUPPORT = 5;
  public static final int VOIP_REASON_FRIEND_WAIT_RELAYINFO_TIMEOUT = 10;
  public static final int VOIP_REASON_FRIEND_WAIT_RELAY_CONNECT_TIMEOUT = 11;
  public static final int VOIP_REASON_NETWORK_DISCONNECT = 13;
  public static final int VOIP_REASON_NETWORK_ERROR = 12;
  public static final int VOIP_REASON_OTHERS = 30;
  public static final int VOIP_REASON_REJECT_BY_FRIEND = 2;
  public static final int VOIP_REASON_REJECT_BY_SELF = 3;
  public static final int VOIP_REASON_SELF_OFFLINE = 19;
  public static final int VOIP_REASON_SELF_VERSION_NOT_SUPPORT = 4;
  public static final int VOIP_REASON_SELF_WAIT_RELAYINFO_TIMEOUT = 8;
  public static final int VOIP_REASON_SELF_WAIT_RELAY_CONNECT_TIMEOUT = 9;
  private static String mCameraParameters;
  private int mColorFmt = -1;
  bhi mEventHandler = null;
  public IVideoEventListener mEventListener;
  AbstractNetChannel mNetChannel;
  public int mPreviewH = 240;
  public int mPreviewW = 320;
  private boolean mSharpFlag = false;
  VcSystemInfo mSysInfo;
  private VcController mVcCtrl = null;
  private int mVideoHeight = -1;
  private int mVideoWidth = -1;
  private boolean mbBackground = false;
  public boolean mfAudio2VideoFlag = true;
  
  static
  {
    NATIVE_ERR_NOT_INI = -102;
    NATIVE_ERR_NO_ENV = -103;
    NATIVE_ERR_NULL_PARA = -104;
    mCameraParameters = null;
    SPNAME = "AV_CameraParameters";
    SPKEY = "CP";
  }
  
  public VcControllerImpl(VcController paramVcController)
  {
    this.mVcCtrl = paramVcController;
    if (getVersion() != 500) {
      throw new UnsatisfiedLinkError();
    }
    cacheMethodIds();
    this.mSysInfo = new VcSystemInfo();
    this.mSysInfo.a();
    mCameraParameters = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).getString(SPKEY, SPDEFVALUE);
  }
  
  private static native void cacheMethodIds();
  
  private void callbackDataTransfered(int paramInt, long paramLong)
  {
    if (this.mEventListener != null) {
      this.mEventListener.a(paramInt, paramLong);
    }
  }
  
  private int callbackGetAPAndGateWayIP()
  {
    if (this.mEventListener != null) {
      return this.mEventListener.f();
    }
    return -1;
  }
  
  private void callbackOnEvent(int paramInt, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte2)
  {
    if (this.mEventListener == null) {}
    while (this.mEventHandler == null) {
      return;
    }
    bhj localbhj = new bhj(this);
    localbhj.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    localbhj.jdField_a_of_type_Long = paramLong1;
    localbhj.jdField_b_of_type_Long = paramLong2;
    localbhj.c = paramLong3;
    localbhj.d = paramLong4;
    localbhj.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramArrayOfByte1 = this.mEventHandler.obtainMessage(paramInt, 0, 0, localbhj);
    this.mEventHandler.sendMessage(paramArrayOfByte1);
  }
  
  private void callbackSendConfigReq(byte[] paramArrayOfByte)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.a(paramArrayOfByte);
    }
  }
  
  private void callbackTcpSend(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.a(paramArrayOfByte, paramLong);
    }
  }
  
  private void callbackTcpSendM2M(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.b(paramArrayOfByte, paramLong);
    }
  }
  
  private void callbackTcpSendSharpCMD(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.c(paramArrayOfByte, paramLong);
    }
  }
  
  private void changePreviewSize(int paramInt1, int paramInt2)
  {
    try
    {
      this.mPreviewW = paramInt1;
      this.mPreviewH = paramInt2;
      this.mEventHandler.post(new bhh(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static native int getVersion();
  
  private void onRecvRequest(int paramInt, bhj parambhj)
  {
    String str1 = null;
    int i = (int)parambhj.c;
    byte[] arrayOfByte1 = parambhj.jdField_a_of_type_ArrayOfByte;
    String str2 = String.valueOf(parambhj.jdField_b_of_type_Long);
    long l = parambhj.d;
    int j;
    if ((i == 5) && (arrayOfByte1 != null))
    {
      j = arrayOfByte1[0];
      if (arrayOfByte1.length <= j + 1) {
        break label254;
      }
      localObject = new byte[j];
      if (localObject == null) {
        break label254;
      }
      System.arraycopy(arrayOfByte1, 1, localObject, 0, j);
    }
    label254:
    for (Object localObject = new String((byte[])localObject);; localObject = null)
    {
      int k = arrayOfByte1[(j + 1)];
      if (arrayOfByte1.length > j + k + 2)
      {
        byte[] arrayOfByte2 = new byte[k];
        if (arrayOfByte2 != null)
        {
          System.arraycopy(arrayOfByte1, j + 2, arrayOfByte2, 0, k);
          str1 = new String(arrayOfByte2);
        }
        if ((str1 != null) && (localObject != null)) {
          str1 = (String)localObject + str1;
        }
      }
      for (;;)
      {
        if ((paramInt == 2) || (paramInt == 60)) {
          this.mEventListener.a(i, str2, str1, parambhj.jdField_b_of_type_ArrayOfByte, true);
        }
        while ((paramInt != 1) && (paramInt != 61)) {
          return;
        }
        this.mEventListener.a(i, str2, str1, parambhj.jdField_b_of_type_ArrayOfByte, false);
        return;
        continue;
        str1 = String.valueOf(l);
      }
    }
  }
  
  /* Error */
  private String queryCameraParameters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 141	com/tencent/av/core/VcControllerImpl:mCameraParameters	Ljava/lang/String;
    //   5: ifnull +11 -> 16
    //   8: getstatic 141	com/tencent/av/core/VcControllerImpl:mCameraParameters	Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: getstatic 153	com/tencent/av/core/VcControllerImpl:SPDEFVALUE	Ljava/lang/String;
    //   19: astore_1
    //   20: goto -8 -> 12
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	VcControllerImpl
    //   11	9	1	str	String
    //   23	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	23	finally
    //   16	20	23	finally
  }
  
  public static void setCameraParameters(String paramString)
  {
    mCameraParameters = paramString;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).edit();
    localEditor.putString(SPKEY, paramString);
    localEditor.commit();
  }
  
  private native int setupDeviceInfos(String paramString);
  
  native int Accept(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native int AudioInData(byte[] paramArrayOfByte, int paramInt);
  
  native int AudioOutData(byte[] paramArrayOfByte, int paramInt);
  
  native int Close(long paramLong, int paramInt);
  
  native int GetAudioDeviceParam(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4);
  
  public String GetManufacture()
  {
    return Build.MANUFACTURER;
  }
  
  public String GetOsName()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String GetRomInfo()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  native int Ignore(long paramLong, int paramInt);
  
  native int Initialize(Context paramContext, long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2);
  
  native int PauseVideo(long paramLong);
  
  native int Reject(long paramLong, int paramInt);
  
  native int Request(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5, long paramLong2, long paramLong3, byte[] paramArrayOfByte);
  
  native int ResumeVideo(long paramLong);
  
  native int SetAudioInputMute(long paramLong, boolean paramBoolean);
  
  native int SetAudioOutputMute(long paramLong, boolean paramBoolean);
  
  native int SetAudioSpeakerVolume(int paramInt);
  
  native int SetNetIPAndPort(String paramString, int paramInt);
  
  native int Uninitialize();
  
  native int UpdateSelfUIN(long paramLong);
  
  public int getCameraFacing()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.b();
    }
    return 0;
  }
  
  public int getCpuArchitecture()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.d();
    }
    return 0;
  }
  
  public int getCpuMaxFrequency()
  {
    if (this.mSysInfo != null) {
      return (int)this.mSysInfo.jdField_a_of_type_Long;
    }
    return 0;
  }
  
  public String getDeviceName()
  {
    return VcSystemInfo.a();
  }
  
  public int getDispHeight()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.f;
    }
    return 0;
  }
  
  public int getDispWidth()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.e;
    }
    return 0;
  }
  
  public native int getEncodeFrameFunctionPtrFunPtr();
  
  public int getNumCores()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.b;
    }
    return 1;
  }
  
  public int getOsType()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.c();
    }
    return 0;
  }
  
  native int getPeerSharpVersion(long paramLong);
  
  native int getPeerTerminalType(long paramLong);
  
  native int getReqType(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  public int getScreenHeight()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.d;
    }
    return 0;
  }
  
  public int getScreenWidth()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.c;
    }
    return 0;
  }
  
  native long getTrafficSize(long paramLong);
  
  public native int hasVShiftAbility(long paramLong);
  
  @SuppressLint({"NewApi"})
  public void init_deviceinfos(Context paramContext, int paramInt1, int paramInt2)
  {
    String str = "PRODUCT=" + Build.PRODUCT + ";";
    str = str + "CPU_ABI=" + Build.CPU_ABI + ";";
    str = str + "TAGS=" + Build.TAGS + ";";
    str = str + "VERSION_CODES_BASE=1;";
    str = str + "MODEL=" + Build.MODEL + ";";
    str = str + "SDK=" + Build.VERSION.SDK_INT + ";";
    str = str + "VERSION_RELEASE=" + Build.VERSION.RELEASE + ";";
    str = str + "DEVICE=" + Build.DEVICE + ";";
    str = str + "DISPLAY=" + Build.DISPLAY + ";";
    str = str + "BRAND=" + Build.BRAND + ";";
    str = str + "BOARD=" + Build.BOARD + ";";
    str = str + "FINGERPRINT=" + Build.FINGERPRINT + ";";
    str = str + "ID=" + Build.ID + ";";
    str = str + "MANUFACTURER=" + Build.MANUFACTURER + ";";
    str = str + "USER=" + Build.USER + ";";
    paramContext = paramContext.getApplicationInfo();
    str = str + "DATADIR=" + paramContext.dataDir + ";";
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";; paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib" + ";")
    {
      paramContext = paramContext + "W=" + paramInt1 + ";";
      setupDeviceInfos(paramContext + "H=" + paramInt2 + ";");
      if (this.mEventHandler == null)
      {
        paramContext = Looper.getMainLooper();
        if (paramContext == null) {
          break;
        }
        this.mEventHandler = new bhi(this, paramContext);
      }
      return;
    }
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.mEventHandler = new bhi(this, paramContext);
      return;
    }
    this.mEventHandler = null;
  }
  
  native boolean isEngineActive();
  
  public boolean ismSharpFlag()
  {
    return this.mSharpFlag;
  }
  
  native int notifyAnotherSelfIsRing(long paramLong, boolean paramBoolean);
  
  public native int onApnChanged(int paramInt);
  
  native int onLogOutByKicked();
  
  native int onRecvVideoCallBytes(byte[] paramArrayOfByte);
  
  native int onRecvVideoCallBytesForSharp(byte[] paramArrayOfByte);
  
  native int onRecvVideoCallBytesForSharpC2SACK(byte[] paramArrayOfByte);
  
  native int onRecvVideoCallBytesM2M(byte[] paramArrayOfByte);
  
  native int onRecvVideoCloudConfig(byte[] paramArrayOfByte);
  
  native int onRecvVideoRequest(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void setBackground(boolean paramBoolean)
  {
    this.mbBackground = paramBoolean;
  }
  
  public native int setCameraAngleFix(int paramInt1, int paramInt2);
  
  public native void setProcessDecoderFrameFunctionptr(int paramInt);
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    if (this.mSysInfo != null) {
      this.mSysInfo.a(paramInt1, paramInt2);
    }
  }
  
  public void setVideoPara(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mColorFmt = paramInt3;
  }
  
  native int switchAudio(long paramLong);
  
  native int switchVideo(long paramLong);
  
  native int switchVideoCancel(long paramLong);
  
  native int switchVideoConfirm(long paramLong);
  
  native int updateConfigInfo();
  
  native int uploadSharpReport(int paramInt1, int paramInt2, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl
 * JD-Core Version:    0.7.0.1
 */