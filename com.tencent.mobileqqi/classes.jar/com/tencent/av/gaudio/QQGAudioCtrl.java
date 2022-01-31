package com.tencent.av.gaudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import bhw;
import bhx;
import com.tencent.av.VideoController;
import com.tencent.av.config.Common;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class QQGAudioCtrl
{
  static final int EV_GA_ENGINE_DESTORY = 11;
  static final int EV_GA_ENGINE_GetMulRoomInfo = 9;
  static final int EV_GA_ENGINE_GetRoomInfo = 8;
  static final int EV_GA_ENGINE_OLRecvInvite = 5;
  static final int EV_GA_ENGINE_OnlineNotice = 13;
  static final int EV_GA_ENGINE_OtherTermEnter = 12;
  static final int EV_GA_ENGINE_ProERR = 7;
  static final int EV_GA_ENGINE_RecvInvite = 6;
  static final int EV_GA_ENGINE_RoomInfoChange = 10;
  static final int EV_GA_SDK_ALL_MEM_UPDATE = 44;
  static final int EV_GA_SDK_CONN_TIMEOUT = 39;
  static final int EV_GA_SDK_Creat_FAIL = 31;
  static final int EV_GA_SDK_Creat_SUC = 30;
  static final int EV_GA_SDK_Creat_TIMEOUT = 32;
  static final int EV_GA_SDK_Enter_FAIL = 34;
  static final int EV_GA_SDK_Enter_SUC = 33;
  static final int EV_GA_SDK_Enter_TIMEOUT = 35;
  static final int EV_GA_SDK_GO_OFF_STAGE_FAIL = 94;
  static final int EV_GA_SDK_GO_OFF_STAGE_SUC = 93;
  static final int EV_GA_SDK_GO_OFF_STAGE_TIMEOUT = 95;
  static final int EV_GA_SDK_GO_ON_STAGE_FAIL = 91;
  static final int EV_GA_SDK_GO_ON_STAGE_SUC = 90;
  static final int EV_GA_SDK_GO_ON_STAGE_TIMEOUT = 92;
  static final int EV_GA_SDK_MEM_BAN_AUDIO_IN = 74;
  static final int EV_GA_SDK_MEM_BAN_AUDIO_OUT = 75;
  static final int EV_GA_SDK_MEM_GET_OUT = 71;
  static final int EV_GA_SDK_MEM_KICKED_OUT = 45;
  static final int EV_GA_SDK_MEM_PPT_IN = 76;
  static final int EV_GA_SDK_MEM_PPT_OUT = 77;
  static final int EV_GA_SDK_MEM_SCREEN_IN = 78;
  static final int EV_GA_SDK_MEM_SCREEN_OUT = 79;
  static final int EV_GA_SDK_MEM_VIDEO_IN = 72;
  static final int EV_GA_SDK_MEM_VIDEO_OUT = 73;
  static final int EV_GA_SDK_NEW_GET_IN = 70;
  static final int EV_GA_SDK_NEW_SPEAKING = 42;
  static final int EV_GA_SDK_OLD_STOP_SPEAKING = 43;
  static final int EV_GA_SDK_Quit_FAIL = 37;
  static final int EV_GA_SDK_Quit_SUC = 36;
  static final int EV_GA_SDK_Quit_TIMEOUT = 38;
  static final int EV_GA_SDK_RECV_NET_TRAFFIC_DATA_SIZE = 50;
  static final int EV_GA_SDK_SEND_NET_TRAFFIC_DATA_SIZE = 51;
  static final int EV_GA_SDK_SERVER_REFUSED = 46;
  static final int EV_GA_SDK_START_REMOTE_VIDEO_FAIL = 97;
  static final int EV_GA_SDK_START_REMOTE_VIDEO_SUC = 96;
  static final int EV_GA_SDK_START_REMOTE_VIDEO_TIMEOUT = 98;
  static final int EV_GA_SDK_TOTAL_NET_TRAFFIC_DATA_SIZE = 52;
  static final int EV_GA_SDK_VIDEO_DEC_FRAME_DATA = 61;
  static final int EV_GA_SDK_VIDEO_DEC_FRAME_DATA_FIRST = 81;
  static final String TAG = "QQGAudioCtrl";
  static QQGAudioCtrl sQQGAudioCtrl = null;
  private int appid;
  bhw mEventHandler = null;
  public long mGroupId = 0L;
  public Vector mInviteGAudioUinList = new Vector();
  public boolean mIsSwitchGroup = false;
  private VcSystemInfo mSysInfo;
  public VideoController mVideoController = null;
  
  private QQGAudioCtrl()
  {
    regCallbacks();
    init_deviceinfos(BaseApplicationImpl.getContext());
    Looper localLooper;
    if (this.mEventHandler == null)
    {
      localLooper = Looper.getMainLooper();
      if (localLooper == null) {
        break label85;
      }
      this.mEventHandler = new bhw(this, localLooper);
    }
    for (;;)
    {
      this.mSysInfo = new VcSystemInfo();
      return;
      label85:
      localLooper = Looper.myLooper();
      if (localLooper != null) {
        this.mEventHandler = new bhw(this, localLooper);
      } else {
        this.mEventHandler = null;
      }
    }
  }
  
  public static QQGAudioCtrl getGAudioCtrlInstance()
  {
    if (sQQGAudioCtrl == null)
    {
      loadGAEngine();
      sQQGAudioCtrl = new QQGAudioCtrl();
    }
    return sQQGAudioCtrl;
  }
  
  private long getLongFromByte(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
  
  private long[] getUinListFromBuf(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong2 = null;
    long[] arrayOfLong1 = arrayOfLong2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length >= 8) {
        break label25;
      }
      arrayOfLong1 = arrayOfLong2;
    }
    label25:
    int i;
    do
    {
      return arrayOfLong1;
      i = paramArrayOfByte.length;
      arrayOfLong1 = arrayOfLong2;
    } while (i % 8 != 0);
    arrayOfLong2 = new long[i / 8];
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    for (;;)
    {
      arrayOfLong1 = arrayOfLong2;
      if (i < 8) {
        break;
      }
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 8);
      long l = getLongFromByte(arrayOfByte);
      arrayOfLong2[(j / 8)] = l;
      j += 8;
      i -= 8;
    }
  }
  
  private static void loadGAEngine()
  {
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "xplatform", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        try
        {
          UpdateAvSo.a(BaseApplicationImpl.getContext(), "qav_gaudio_engine");
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          localUnsatisfiedLinkError2.printStackTrace();
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        localUnsatisfiedLinkError1.printStackTrace();
      }
    }
  }
  
  private static native void regCallbacks();
  
  private static native void setandroidapppath(String paramString);
  
  public byte[] GetConfigInfoFromFile()
  {
    return Common.a(BaseApplicationImpl.getContext(), "VideoConfigInfo");
  }
  
  public native void Init(Context paramContext, long paramLong, int paramInt);
  
  public void SetVideoController(VideoController paramVideoController)
  {
    this.mVideoController = paramVideoController;
  }
  
  public native void Uninit();
  
  public native int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public int acceptGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramInt2 == -1) || (paramInt1 == -1) || (paramInt3 == -1)) {
      return -1;
    }
    this.mGroupId = paramLong1;
    if ((paramInt1 == 2) && (paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] != paramLong2) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[i]));
        }
        i += 1;
      }
    }
    accept(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4);
    return 0;
  }
  
  public native int changeSpeakerMode(int paramInt);
  
  public native AVGQuality getAVGQuality();
  
  public String getAppId()
  {
    try
    {
      int i = this.appid;
      return String.valueOf(i);
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String getDeviceName()
  {
    return VcSystemInfo.a();
  }
  
  public native int getEncodeFrameFunctionPtrFunPtr();
  
  public native int getNetState();
  
  public native long getNetTrafficSize(long paramLong);
  
  public native int getRoomInfo(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public native int getVideoAbilityLevel();
  
  public native int getVolume();
  
  public native int goOffStage();
  
  public native int goOnStage();
  
  public native int ignore(int paramInt, long paramLong);
  
  @SuppressLint({"NewApi"})
  public void init_deviceinfos(Context paramContext)
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
      setandroidapppath(paramContext);
      return;
    }
  }
  
  public native int invite(int paramInt, long paramLong, long[] paramArrayOfLong, boolean paramBoolean);
  
  public native int onApnChanged(int paramInt);
  
  public void onGAudioNativeEvent(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong1, int paramInt4, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "onGAudioNativeEvent: " + paramInt3);
    }
    if (this.mEventHandler != null)
    {
      localbhx = new bhx(this);
      localbhx.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      localbhx.jdField_a_of_type_Long = paramLong1;
      localbhx.jdField_b_of_type_Long = paramLong2;
      localbhx.c = paramInt4;
      localbhx.jdField_a_of_type_Int = paramInt1;
      localbhx.jdField_b_of_type_Int = paramInt2;
      if ((localbhx.jdField_a_of_type_ArrayOfByte != null) && (QLog.isColorLevel())) {
        QLog.d("QQGAudioCtrl", 2, "onGAudioNativeEvent-->BufferLen=" + paramArrayOfByte.length + "Buffer=" + paramArrayOfByte);
      }
      paramArrayOfByte = this.mEventHandler.obtainMessage();
      paramArrayOfByte.what = paramInt3;
      paramArrayOfByte.obj = localbhx;
      this.mEventHandler.sendMessage(paramArrayOfByte);
    }
    while (!QLog.isColorLevel())
    {
      bhx localbhx;
      return;
    }
    QLog.d("QQGAudioCtrl", 2, "mEventHandler == null");
  }
  
  public native int onRecvGAudioCMD(int paramInt, byte[] paramArrayOfByte);
  
  public void onRecvUserList(int paramInt1, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt2)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvUserList-->mVideoController is null");
      }
    }
    do
    {
      do
      {
        return;
        if (paramArrayOfLong != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QQGAudioCtrl", 2, "onRecvUserList-->userList is null");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "onRecvUserList-->EvtId=" + paramInt1 + "lGroupId" + paramLong1 + "inviteUin=" + paramLong2 + "multiSubType=" + paramInt2 + "inviteUinSize=" + paramArrayOfLong.length);
      }
      if (paramInt1 == 44)
      {
        this.mVideoController.a(paramLong1, paramArrayOfLong);
        return;
      }
      if (paramInt1 == 6)
      {
        this.mVideoController.a(paramLong1, paramLong2, paramArrayOfLong, false, paramInt2);
        return;
      }
    } while (paramInt1 != 5);
    this.mVideoController.a(paramLong1, paramLong2, paramArrayOfLong, true, paramInt2);
  }
  
  public native int quit(int paramInt, long paramLong);
  
  public native int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public void sendGAudioCMD(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.mVideoController.a(paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public void setAppid(int paramInt)
  {
    this.appid = paramInt;
  }
  
  public void setInviteUserList(long paramLong, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] != paramLong) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[i]));
        }
        i += 1;
      }
    }
  }
  
  public native int setMicState(boolean paramBoolean);
  
  public native int setNetIPAndPort(String paramString, int paramInt);
  
  public native void setProcessDecoderFrameFunctionptr(int paramInt);
  
  public int startGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2, boolean paramBoolean)
  {
    if (paramInt1 == 2)
    {
      if (paramArrayOfLong == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioCtrl", 2, "startGAudio uinList == null");
        }
        return -1;
      }
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] != paramLong2) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[i]));
        }
        i += 1;
      }
    }
    request(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4);
    this.mGroupId = paramLong1;
    this.mIsSwitchGroup = paramBoolean;
    return 0;
  }
  
  public native int startRemoteVideo(long paramLong, int paramInt);
  
  public native int stopOrStartTRAE(boolean paramBoolean1, boolean paramBoolean2);
  
  public native int stopRemoteVideo();
  
  public native int switchToAudioMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrl
 * JD-Core Version:    0.7.0.1
 */