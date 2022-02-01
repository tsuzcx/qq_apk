package com.tencent.av.gaudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anot;
import com.tencent.av.config.Common;
import com.tencent.av.core.SDKConfigInfo;
import com.tencent.av.core.SDKConfigInfo.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import imm;
import ing;
import ini;
import inw;
import inx;
import iny;
import ioa;
import itl;
import itn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import jkn;
import tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfo;
import tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfoList;
import tencent.im.groupvideo.memposinfo.memposinfo.CommonInfo;

public class QQGAudioCtrl
{
  static final int EM_SDK_EVENT_ID_ALL_CAN_GO_ON_STAGE = 103;
  static final int EM_SDK_EVENT_ID_ALL_MEM_UPDATE = 44;
  static final int EM_SDK_EVENT_ID_ALL_ONLINE_NOTICE = 16;
  static final int EM_SDK_EVENT_ID_AUDIO_PLAYBACK_FAILURE = 175;
  static final int EM_SDK_EVENT_ID_AUDIO_RECORD_FAILURE = 174;
  static final int EM_SDK_EVENT_ID_AUTHORITY_CHANGED = 173;
  static final int EM_SDK_EVENT_ID_CAMERAQOS_FPS_CHANGE = 171;
  static final int EM_SDK_EVENT_ID_CHANGE_MIC_ORDER = 151;
  static final int EM_SDK_EVENT_ID_CHECK_SHARE_SCREEN_AVAILABLE_RSP = 178;
  static final int EM_SDK_EVENT_ID_CONN_TIMEOUT = 39;
  static final int EM_SDK_EVENT_ID_CREATE_FAIL = 31;
  static final int EM_SDK_EVENT_ID_CREATE_ROOM_FAILED = 138;
  static final int EM_SDK_EVENT_ID_CREATE_SUC = 30;
  static final int EM_SDK_EVENT_ID_CREATE_TIMEOUT = 32;
  static final int EM_SDK_EVENT_ID_DESTORY = 11;
  static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_HOWLING = 153;
  static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_NOISY = 145;
  static final int EM_SDK_EVENT_ID_ENTER_FAIL = 34;
  static final int EM_SDK_EVENT_ID_ENTER_ROOM_FAILED = 139;
  static final int EM_SDK_EVENT_ID_ENTER_SUC = 33;
  static final int EM_SDK_EVENT_ID_ENTER_TIMEOUT = 35;
  static final int EM_SDK_EVENT_ID_GET_MUL_ROOM_INFO = 9;
  static final int EM_SDK_EVENT_ID_GET_ROOM_INFO = 8;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_FAIL = 94;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_SUC = 93;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_TIMEOUT = 95;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_FAIL = 91;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_SUC = 90;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_TIMEOUT = 92;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_FREE_MODE = 107;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_MIC_ORDER_MODE = 108;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE = 109;
  static final int EM_SDK_EVENT_ID_HAS_GETTED_SHARP_CONFIG_PAYLOAD = 123;
  public static final int EM_SDK_EVENT_ID_KickOut_FAIL = 22;
  public static final int EM_SDK_EVENT_ID_KickOut_SUC = 21;
  static final int EM_SDK_EVENT_ID_MEETINGCONTROLMODE_CHANGE = 142;
  static final int EM_SDK_EVENT_ID_MEM_AUDIO_IN = 141;
  static final int EM_SDK_EVENT_ID_MEM_AUDIO_OUT = 140;
  static final int EM_SDK_EVENT_ID_MEM_BAN_AUDIO = 74;
  static final int EM_SDK_EVENT_ID_MEM_CANCEL_BAN_AUDIO = 75;
  static final int EM_SDK_EVENT_ID_MEM_GET_OUT = 71;
  static final int EM_SDK_EVENT_ID_MEM_KICKED_OUT = 45;
  static final int EM_SDK_EVENT_ID_MEM_POS_CHANGE = 80;
  static final int EM_SDK_EVENT_ID_MEM_PPT_IN = 76;
  static final int EM_SDK_EVENT_ID_MEM_PPT_OUT = 77;
  static final int EM_SDK_EVENT_ID_MEM_SCREEN_IN = 78;
  static final int EM_SDK_EVENT_ID_MEM_SCREEN_OUT = 79;
  static final int EM_SDK_EVENT_ID_MEM_VIDEO_IN = 72;
  static final int EM_SDK_EVENT_ID_MEM_VIDEO_OUT = 73;
  static final int EM_SDK_EVENT_ID_MICOFFBYSELF_NOTIFY = 157;
  static final int EM_SDK_EVENT_ID_MICONBYADMINFAIL_NOTIFY = 158;
  static final int EM_SDK_EVENT_ID_NEW_GET_IN = 70;
  static final int EM_SDK_EVENT_ID_NEW_SPEAKING = 42;
  static final int EM_SDK_EVENT_ID_OFFLINE_RECV_INVITE = 5;
  static final int EM_SDK_EVENT_ID_OLD_STOP_SPEAKING = 43;
  static final int EM_SDK_EVENT_ID_ONLINE_NOTICE = 13;
  static final int EM_SDK_EVENT_ID_ONLY_MANAGER_CAN_GO_ON_STAGE = 102;
  static final int EM_SDK_EVENT_ID_ONLY_MANAGER_STAGER_CAN_SPEAK = 104;
  static final int EM_SDK_EVENT_ID_OTHER_TERM_ENTER = 12;
  static final int EM_SDK_EVENT_ID_PBInvite_Rsp = 20;
  static final int EM_SDK_EVENT_ID_PBInvite_Rsp_CALL_BACK = 24;
  static final int EM_SDK_EVENT_ID_PLAY_MEDIA_FILE = 105;
  static final int EM_SDK_EVENT_ID_PPT_UPLOAD_STATE = 110;
  static final int EM_SDK_EVENT_ID_PROTOCOL_ERR = 7;
  static final int EM_SDK_EVENT_ID_PSTN_BILL = 19;
  static final int EM_SDK_EVENT_ID_QUIT_FAIL = 37;
  static final int EM_SDK_EVENT_ID_QUIT_SUC = 36;
  static final int EM_SDK_EVENT_ID_QUIT_TIMEOUT = 38;
  static final int EM_SDK_EVENT_ID_RECV_INVITE = 6;
  static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PAV = 25;
  static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PSHARE = 26;
  static final int EM_SDK_EVENT_ID_RECV_MEETING_TIME = 124;
  static final int EM_SDK_EVENT_ID_RECV_NET_TRAFFIC_DATA_SIZE = 50;
  static final int EM_SDK_EVENT_ID_REQUEST_MICDATA = 150;
  static final int EM_SDK_EVENT_ID_ROOM_INFO_CHANGE = 10;
  static final int EM_SDK_EVENT_ID_SELF_SPEAKING = 176;
  static final int EM_SDK_EVENT_ID_SEND_EMBED_CHNNEL = 152;
  static final int EM_SDK_EVENT_ID_SEND_NET_TRAFFIC_DATA_SIZE = 51;
  static final int EM_SDK_EVENT_ID_SERVER_REFUSED = 46;
  static final int EM_SDK_EVENT_ID_SETMICBYADMIN_NOTIFY = 143;
  static final int EM_SDK_EVENT_ID_SETMICFAIL_NOTIFY = 144;
  static final int EM_SDK_EVENT_ID_SHARE_QOS = 177;
  static final int EM_SDK_EVENT_ID_SPEAK_MODE_PRESS_SPEAK = 101;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_FAIL = 97;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_SUC = 96;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_TIMEOUT = 98;
  static final int EM_SDK_EVENT_ID_START_SHARE_FAIL = 85;
  static final int EM_SDK_EVENT_ID_START_SHARE_SUC = 84;
  static final int EM_SDK_EVENT_ID_START_SHARE_TIMEOUT = 86;
  static final int EM_SDK_EVENT_ID_STOP_PLAY_MEDIA_FILE = 106;
  static final int EM_SDK_EVENT_ID_STOP_SHARE_FAIL = 88;
  static final int EM_SDK_EVENT_ID_STOP_SHARE_SUC = 87;
  static final int EM_SDK_EVENT_ID_STOP_SHARE_TIMEOUT = 89;
  static final int EM_SDK_EVENT_ID_TOTAL_NET_TRAFFIC_DATA_SIZE = 52;
  static final int EM_SDK_EVENT_ID_VIDEOCHANNEL_CTRL_CHANGE = 172;
  static final int EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA = 61;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_LESS = 122;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_NULL = 121;
  private static String SPDEFVALUE = "preview-size-values=320x240,640x480;";
  private static String SPKEY;
  private static String SPNAME;
  static final String TAG = "QQGAudioCtrl";
  private static String mCameraParameters;
  static a mEventCountLog_EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA = new a(String.valueOf(61), 10000L);
  static QQGAudioCtrl sQQGAudioCtrl;
  private int appid;
  b mEventHandler = null;
  long mGroupId = 0L;
  public Vector<Long> mInviteGAudioUinList = new Vector();
  public boolean mIsSwitchGroup;
  private final itn mShareRecordParam = new itn();
  private imm mSysInfo;
  iny mVideoController = null;
  
  static
  {
    SPNAME = "AV_CameraParameters";
    SPKEY = "CP";
  }
  
  protected QQGAudioCtrl()
  {
    regCallbacks();
    setandroidapppath(SDKConfigInfo.getDeviceInfo(BaseApplicationImpl.getContext()));
    Looper localLooper;
    if (this.mEventHandler == null)
    {
      localLooper = Looper.getMainLooper();
      if (localLooper == null) {
        break label93;
      }
      this.mEventHandler = new b(localLooper);
    }
    for (;;)
    {
      this.mSysInfo = new imm();
      return;
      label93:
      localLooper = Looper.myLooper();
      if (localLooper != null) {
        this.mEventHandler = new b(localLooper);
      } else {
        this.mEventHandler = null;
      }
    }
  }
  
  private native int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private ArrayList<ini> getAVInfoListFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "getAVInfoListFromByte--> buf is null");
      }
    }
    int i;
    ArrayList localArrayList;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return null;
          if (paramInt != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQGAudioCtrl", 2, "getAVInfoListFromByte--> structLen is 0");
        return null;
        i = paramArrayOfByte.length;
        if (i % paramInt == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QQGAudioCtrl", 2, "getAVInfoListFromByte--> buf len is incorrect");
      return null;
      int j = i / paramInt;
      localArrayList = new ArrayList();
      i = 0;
      if (i >= j) {
        break label173;
      }
      localObject = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, i * paramInt, localObject, 0, paramInt);
      localObject = getAVInfoFromByte((byte[])localObject, paramInt);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQGAudioCtrl", 2, "Can not get AVUserInfo...Error");
    return null;
    if ((((ini)localObject).accountType == 1) && (((ini)localObject).aqC != 3)) {}
    for (;;)
    {
      i += 1;
      break;
      localArrayList.add(localObject);
    }
    label173:
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "getAVInfoListFromByte --> length = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private ArrayList<ini> getAVInfoListFromByte2(byte[] paramArrayOfByte, int paramInt)
  {
    Iterator localIterator = null;
    Object localObject4 = null;
    memposinfo.CommonInfo localCommonInfo = null;
    Object localObject2 = localObject4;
    Object localObject1;
    if (paramArrayOfByte != null)
    {
      localObject1 = localIterator;
      localObject2 = localObject4;
      try
      {
        if (paramArrayOfByte.length != paramInt) {
          break label214;
        }
        localObject1 = localIterator;
        localObject2 = new memposinfo.AccountExtInfoList();
        localObject1 = localIterator;
        ((memposinfo.AccountExtInfoList)localObject2).mergeFrom(paramArrayOfByte);
        localObject1 = localIterator;
        localIterator = ((memposinfo.AccountExtInfoList)localObject2).msg_account_ext_info.get().iterator();
        paramArrayOfByte = localCommonInfo;
      }
      catch (Exception localException1)
      {
        try
        {
          paramArrayOfByte.add(localObject2);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localObject1 = paramArrayOfByte;
          }
        }
        localException1 = localException1;
      }
      localObject1 = paramArrayOfByte;
      localObject2 = paramArrayOfByte;
      if (localIterator.hasNext())
      {
        localObject1 = paramArrayOfByte;
        localObject2 = (memposinfo.AccountExtInfo)localIterator.next();
        localObject1 = paramArrayOfByte;
        if (!((memposinfo.AccountExtInfo)localObject2).msg_common_info.has()) {
          break label227;
        }
        localObject1 = paramArrayOfByte;
        localCommonInfo = (memposinfo.CommonInfo)((memposinfo.AccountExtInfo)localObject2).msg_common_info.get();
        localObject1 = paramArrayOfByte;
        localObject2 = new ini();
        localObject1 = paramArrayOfByte;
        ((ini)localObject2).account = localCommonInfo.uint64_account.get();
        localObject1 = paramArrayOfByte;
        ((ini)localObject2).openId = localCommonInfo.bytes_account.get().toStringUtf8();
        if (paramArrayOfByte != null) {
          break label224;
        }
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = new ArrayList();
      }
    }
    label214:
    label224:
    label227:
    for (;;)
    {
      QLog.e("QQGAudioCtrl", 1, "getAVInfoListFromByte2 fail.", localException1);
      Object localObject3 = localObject1;
      return localObject3;
    }
  }
  
  private ArrayList<AVPhoneUserInfo> getAvPhoneUserInfoFromString(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "getAvPhoneUserInfoFromString --> info = " + paramString);
    }
    paramString = paramString.split("\\|");
    if (paramString.length % 2 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "getAvPhoneUserInfoFromString --> Length is not currect");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length / 2)
    {
      Object localObject1 = paramString[(i * 2 + 0)];
      Object localObject2 = paramString[(i * 2 + 1)];
      AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.accountType = 3;
      localAVPhoneUserInfo.telInfo.mobile = localObject2;
      localAVPhoneUserInfo.telInfo.nation = localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "getAvPhoneUserInfoFromString --> InfoItem = " + localAVPhoneUserInfo.toString());
      }
      localArrayList.add(localAVPhoneUserInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  public static QQGAudioCtrl getGAudioCtrlInstance()
  {
    if (sQQGAudioCtrl == null)
    {
      if (!loadGAEngine()) {
        return null;
      }
      sQQGAudioCtrl = new QQGAudioCtrl();
      mCameraParameters = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).getString(SPKEY, SPDEFVALUE);
    }
    return sQQGAudioCtrl;
  }
  
  private int getIntFromByte(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
  
  private Object[] getRoomParams(iiv paramiiv)
  {
    int i = 8;
    if (paramiiv == null) {
      return null;
    }
    long l1;
    int j;
    if (paramiiv.Qw)
    {
      l1 = Long.parseLong(paramiiv.peerUin);
      j = 3;
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(i) };
      int k = paramiiv.relationType;
      long l2 = paramiiv.ll;
      if (k == 2)
      {
        i = 1;
        j = k;
        l1 = l2;
      }
      else if (k == 1)
      {
        i = paramiiv.anb;
        j = k;
        l1 = l2;
      }
      else
      {
        j = k;
        l1 = l2;
        if (k != 3)
        {
          i = 0;
          j = k;
          l1 = l2;
        }
      }
    }
  }
  
  private native int getRoomUserClientVersion(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
  
  private native int getRoomUserTerminalType(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
  
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
      if (l == 0L)
      {
        QLog.e("QQGAudioCtrl", 1, "getUinListFromBuf-->get the wrong uin==0");
        return arrayOfLong2;
      }
      arrayOfLong2[(j / 8)] = l;
      j += 8;
      i -= 8;
    }
  }
  
  protected static boolean loadGAEngine()
  {
    try
    {
      AVSoUtils.a(-1047L, BaseApplicationImpl.getContext(), "qav_gaudio_engine", true);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGAudioCtrl", 1, "loadGAEngine fail.", localThrowable);
    }
    return false;
  }
  
  private void onRecPushEncParam(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQGAudioCtrl", 4, "onRecPushEncParam, relationType[" + paramInt1 + "], relationId[" + paramLong1 + "], lValue[" + paramLong2 + "], flag[" + paramInt2 + "]");
    }
    int i = this.mShareRecordParam.width;
    int j = this.mShareRecordParam.height;
    int k = this.mShareRecordParam.fps;
    int m = (int)(paramLong2 & 0xFFFFFFFF);
    int n = (int)(paramLong2 >> 32 & 0xFFFFFFFF);
    this.mShareRecordParam.width = n;
    this.mShareRecordParam.height = m;
    this.mShareRecordParam.fps = paramInt2;
    this.mVideoController.a(paramInt1, paramLong1, this.mShareRecordParam);
    if ((QLog.isColorLevel()) && ((i != this.mShareRecordParam.width) || (j != this.mShareRecordParam.height) || (k != this.mShareRecordParam.fps))) {
      QLog.i("AVShare", 1, "onRecPushEncParam, relationType[" + paramInt1 + "], groupId[" + paramLong1 + "], param[" + this.mShareRecordParam + "]");
    }
  }
  
  private native int onRecvGAudioCMD(int paramInt, byte[] paramArrayOfByte);
  
  /* Error */
  private String queryCameraParameters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 556	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   5: ifnull +11 -> 16
    //   8: getstatic 556	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: getstatic 266	com/tencent/av/gaudio/QQGAudioCtrl:SPDEFVALUE	Ljava/lang/String;
    //   19: astore_1
    //   20: goto -8 -> 12
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	QQGAudioCtrl
    //   11	9	1	str	String
    //   23	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	23	finally
    //   16	20	23	finally
  }
  
  protected static native void regCallbacks();
  
  private native int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  private native int sendShareFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native int sendShareFrame2NativeBmp(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public static void setCameraParameters(String paramString, boolean paramBoolean)
  {
    mCameraParameters = paramString;
    if (paramBoolean)
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).edit();
      localEditor.putString(SPKEY, paramString);
      localEditor.commit();
    }
  }
  
  private native int setShareEncParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public static native void setandroidapppath(String paramString);
  
  private native int startShareSend(int paramInt);
  
  private native int stopShareSend(int paramInt);
  
  private native int stopVideoSend();
  
  private native int updateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private native int updateRoomUserTerminalInfo(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int paramInt4);
  
  public byte[] GetConfigInfoFromFile()
  {
    return Common.readFile(BaseApplicationImpl.getContext(), "VideoConfigInfo");
  }
  
  native int GetInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public native int GetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public String GetSharpConfigPayloadFromFile()
  {
    Object localObject1 = Common.readFile(BaseApplicationImpl.getContext(), Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
    if (localObject1 != null)
    {
      String str2 = new String((byte[])localObject1);
      int i = str2.indexOf('|');
      Object localObject2 = "";
      String str1 = "";
      try
      {
        localObject1 = str2.substring(0, i);
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localObject2 = str2.substring(i + 1);
            if (QLog.isColorLevel()) {
              QLog.d("QQGAudioCtrl", 2, "GetSharpConfigPayloadFromFile multi version: " + (String)localObject1 + ". payload: " + (String)localObject2);
            }
            return localObject2;
            localException2 = localException2;
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("QQGAudioCtrl", 2, "GetSharpConfigPayloadFromFile version e = " + localException2);
              localObject1 = localObject2;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localObject2 = str1;
            if (QLog.isColorLevel())
            {
              QLog.d("QQGAudioCtrl", 2, "GetSharpConfigPayloadFromFile payload e = " + localException1);
              localObject2 = str1;
            }
          }
        }
      }
    }
    return "";
  }
  
  public int GetSharpConfigVersionFromFile()
  {
    try
    {
      Object localObject = Common.readFile(BaseApplicationImpl.getContext(), Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
      if (localObject != null)
      {
        String str = new String((byte[])localObject);
        if (!TextUtils.isEmpty(str))
        {
          int i = str.indexOf('|');
          localObject = str.substring(0, i);
          str = str.substring(i + 1);
          if (QLog.isColorLevel()) {
            QLog.d("", 2, "GetSharpConfigPayloadFromFile multi version: " + (String)localObject + ". payload: " + str);
          }
          return Integer.parseInt((String)localObject);
        }
        QLog.w("QQGAudioCtrl", 1, "GetSharpConfigVersionFromFile, payloadBufTmp[" + str + "]");
        return 0;
      }
    }
    catch (Exception localException)
    {
      QLog.w("QQGAudioCtrl", 1, "GetSharpConfigVersionFromFile, Exception", localException);
    }
    return 0;
  }
  
  public native int Invite(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4);
  
  @Deprecated
  public native int InvitePstn(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public native int KickOutPstnUsers();
  
  public native void LockVideoMaxQP(int paramInt);
  
  public native int ReadDataFromTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public int SendShareFrame2Native(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return sendShareFrame2NativeBmp(paramBitmap, paramInt1, paramInt2);
  }
  
  public int SendShareFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return sendShareFrame2Native(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public native void SetAudioDataSendByDefault(boolean paramBoolean);
  
  public native void SetAudioDataSink(boolean paramBoolean);
  
  public native int SetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void SetShareEncParam(itn paramitn, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "SetShareEncParam, param[" + paramitn + "], maxW[" + paramInt1 + "], maxH[" + paramInt2 + "], activeNow[" + paramInt3 + "]");
    }
    setShareEncParam(1, paramitn.width, paramitn.height, paramitn.fps, 4, paramInt1, paramInt2, paramInt3);
  }
  
  public void SetVideoController(iny paraminy)
  {
    this.mVideoController = paraminy;
  }
  
  public native void SetVideoDataSendByDefault(boolean paramBoolean);
  
  public native void SetVideoDataSink(boolean paramBoolean);
  
  public boolean StartOrStopShareSend(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = stopShareSend(paramInt);; i = startShareSend(paramInt))
    {
      QLog.i("QQGAudioCtrl", 1, "StartOrStopShareSend, stop[" + paramBoolean + "], emShareType[" + paramInt + "], ret[" + i + "]");
      if (i != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public native int WriteDataToTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = jkn.mE();
    if (i > 0) {}
    for (;;)
    {
      QLog.w("QQGAudioCtrl", 1, "accept, maxShowVideo[" + i + "]");
      return accept(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, i);
      i = 5;
    }
  }
  
  public int acceptGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2, int paramInt5)
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
      int i = paramArrayOfLong.length;
      paramInt4 = 0;
      while (paramInt4 < i)
      {
        if (paramArrayOfLong[paramInt4] != paramLong2) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[paramInt4]));
        }
        paramInt4 += 1;
      }
    }
    paramInt4 = jkn.mE();
    if (paramInt4 > 0) {}
    for (;;)
    {
      QLog.w("QQGAudioCtrl", 1, "acceptGAudio, emAVRelationType[" + paramInt1 + "], emMultiAVType[" + paramInt2 + "], emMultiAVSubType[" + paramInt3 + "], nConfID[" + paramInt5 + "], groupId[" + paramLong1 + "], maxShowVideo[" + paramInt4 + "]");
      accept(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5, paramInt4);
      return 0;
      paramInt4 = 5;
    }
  }
  
  public native void checkScreenShareAvailable();
  
  public native int commonRequest(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, byte[] paramArrayOfByte, int paramInt8);
  
  public native int debugSwitch(boolean paramBoolean);
  
  public native boolean enableLoopback(boolean paramBoolean);
  
  public native String getAVGQuality();
  
  protected ini getAVInfoFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if ((paramArrayOfByte.length != paramInt) || (paramArrayOfByte.length < 16)) {
      return null;
    }
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 8);
    long l = getLongFromByte(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 8, arrayOfByte, 0, 4);
    int i = getIntFromByte(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 12, arrayOfByte, 0, 4);
    int j = getIntFromByte(arrayOfByte);
    paramInt = 2;
    if (paramArrayOfByte.length > 16)
    {
      arrayOfByte = new byte[1];
      System.arraycopy(paramArrayOfByte, 16, arrayOfByte, 0, 1);
      paramInt = arrayOfByte[0];
    }
    for (;;)
    {
      paramArrayOfByte = new ini();
      paramArrayOfByte.account = l;
      paramArrayOfByte.accountType = i;
      paramArrayOfByte.aqC = j;
      paramArrayOfByte.ane = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "AVUserInfo-->Uin = " + l + " ,isPstn = " + i + " ,pstnState = " + j + " ,micOffByAdmin = " + paramInt);
      }
      return paramArrayOfByte;
      QLog.w("QQGAudioCtrl", 1, "getAVInfoFromByte", new Throwable("打印调用栈"));
    }
  }
  
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
    return imm.getDeviceName();
  }
  
  public native long getEncodeFrameFunctionPtrFunPtr();
  
  public native long getEnterRoomTime();
  
  @Deprecated
  public int getInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "getInviteStrategy --> QQAccountNum = " + paramInt1 + " , PhoneNum = " + paramInt2);
    }
    return GetInviteStrategy(paramArrayOfLong, paramInt1, paramArrayOfString, paramInt2);
  }
  
  protected long getLongFromByte(byte[] paramArrayOfByte)
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
  
  public native int getNetLevel();
  
  public native int getNetState();
  
  public native long getNetTrafficSize(long paramLong);
  
  public int getOsType()
  {
    if (this.mSysInfo != null)
    {
      int j = this.mSysInfo.getOsType();
      int i = j;
      if (j == 200)
      {
        if ((Build.VERSION.SDK_INT < 21) || (Build.VERSION.SDK_INT > 22)) {
          break label45;
        }
        i = 118;
      }
      label45:
      do
      {
        return i;
        if (Build.VERSION.SDK_INT == 23) {
          return 119;
        }
        if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25)) {
          return 120;
        }
        if ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)) {
          return 121;
        }
        i = j;
      } while (Build.VERSION.SDK_INT != 28);
      return 122;
    }
    return 0;
  }
  
  public int getProductId()
  {
    QLog.d("QQGAudioCtrl", 1, "Product id is 1(TIM)");
    return 1;
  }
  
  public String getRELEASEVERSION()
  {
    return Build.VERSION.RELEASE;
  }
  
  public native long getRoomId();
  
  public int getRoomUserSdkVersion(iiv paramiiv, String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      paramiiv = getRoomParams(paramiiv);
      if ((paramiiv == null) || (l1 == 0L))
      {
        i = -1;
        return i;
      }
    }
    catch (Throwable paramString)
    {
      long l1;
      int k;
      long l2;
      int m;
      int j;
      do
      {
        for (;;)
        {
          l1 = 0L;
        }
        k = ((Integer)paramiiv[0]).intValue();
        l2 = ((Long)paramiiv[1]).longValue();
        m = ((Integer)paramiiv[2]).intValue();
        j = getRoomUserClientVersion(k, l2, m, l1);
        int i = j;
      } while (!QLog.isColorLevel());
      QLog.i("QQGAudioCtrl", 2, String.format("getRoomUserSdkVersion [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(j) }));
      return j;
    }
  }
  
  public int getRoomUserTerminalType(iiv paramiiv, String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      paramiiv = getRoomParams(paramiiv);
      if ((paramiiv == null) || (l1 == 0L))
      {
        i = -1;
        return i;
      }
    }
    catch (Throwable paramString)
    {
      long l1;
      int k;
      long l2;
      int m;
      int j;
      do
      {
        for (;;)
        {
          l1 = 0L;
        }
        k = ((Integer)paramiiv[0]).intValue();
        l2 = ((Long)paramiiv[1]).longValue();
        m = ((Integer)paramiiv[2]).intValue();
        j = getRoomUserTerminalType(k, l2, m, l1);
        int i = j;
      } while (!QLog.isColorLevel());
      QLog.i("QQGAudioCtrl", 2, String.format("getRoomUserTerminalType [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(j) }));
      return j;
    }
  }
  
  public native int getVideoAbilityLevel();
  
  public native int getVolume();
  
  public native int ignore(int paramInt1, long paramLong, int paramInt2);
  
  public void init(Context paramContext, long paramLong, int paramInt)
  {
    init(paramContext, paramLong, paramInt, "3.4.4", new SDKConfigInfo.a().a());
  }
  
  public void init(Context paramContext, long paramLong, int paramInt, String paramString)
  {
    init(paramContext, paramLong, paramInt, paramString, new SDKConfigInfo.a().a());
  }
  
  public native void init(Context paramContext, long paramLong, int paramInt, String paramString, SDKConfigInfo paramSDKConfigInfo);
  
  public native int invite(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3);
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt)
  {
    String str1 = "uinList";
    if (paramArrayOfLong != null)
    {
      int j = paramArrayOfLong.length;
      i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= j) {
          break;
        }
        long l = paramArrayOfLong[i];
        str1 = str1 + "[" + l + "]";
        i += 1;
      }
    }
    String str2 = "[null]";
    int i = invite(paramArrayOfLong, paramInt, 0, 0);
    QLog.w("QQGAudioCtrl", 1, "inviteUser, " + str2 + ", nReason[" + paramInt + "], ret[" + i + "]");
    return i;
  }
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = invite(paramArrayOfLong, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel())
    {
      if (paramArrayOfLong != null)
      {
        int k = paramArrayOfLong.length;
        String str1 = "uinList";
        int i = 0;
        for (;;)
        {
          str2 = str1;
          if (i >= k) {
            break;
          }
          long l = paramArrayOfLong[i];
          str1 = str1 + "[" + l + "]";
          i += 1;
        }
      }
      String str2 = "[null]";
      QLog.i("QQGAudioCtrl", 2, "inviteUser, " + str2 + "], nReason[" + paramInt1 + "], original[" + paramInt2 + "], pstnLevel[" + paramInt3 + "], ret[" + j + "]");
    }
    return j;
  }
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    int j;
    int i;
    if (paramArrayOfLong != null)
    {
      j = paramArrayOfLong.length;
      str1 = "uinList";
      i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= j) {
          break;
        }
        long l = paramArrayOfLong[i];
        str1 = str1 + "[" + l + "]";
        i += 1;
      }
    }
    String str2 = "uinList" + "[null]";
    String str1 = str2 + ", phoneList";
    if (paramArrayOfString != null)
    {
      j = paramArrayOfString.length;
      i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= j) {
          break;
        }
        str2 = paramArrayOfString[i];
        str1 = str1 + "[" + str2 + "]";
        i += 1;
      }
    }
    str2 = str1 + "[null]";
    paramInt1 = Invite(paramArrayOfLong, paramInt1, paramArrayOfString, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4);
    QLog.w("QQGAudioCtrl", 1, "inviteUser2, " + str2 + ", nReason[" + paramInt4 + "], roomFlag[" + paramInt3 + "], transSelf[" + paramBoolean2 + "], ret[" + paramInt1 + "]");
    return paramInt1;
  }
  
  public native boolean isEnableLoopback();
  
  public void lockVideoMaxQP(int paramInt, String paramString)
  {
    QLog.e("QQGAudioCtrl", 1, "LockVideoMaxQP nNewQP=" + paramInt + " , strDesc= " + paramString);
    LockVideoMaxQP(paramInt);
  }
  
  public native int modifyGroupAdmin(long paramLong, boolean paramBoolean);
  
  public int nativeStopAudioSend(boolean paramBoolean)
  {
    try
    {
      int i = stopAudioSend(paramBoolean);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      igd.aL("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  public int nativeStopVideoSend()
  {
    try
    {
      int i = stopVideoSend();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      igd.aL("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  public int nativeUpdateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      paramInt1 = updateRoomInfo(paramInt1, paramLong, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3);
      return paramInt1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      igd.aL("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  public void onGAudioNativeEvent(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, long paramLong2, int paramInt6)
  {
    if (this.mEventHandler != null)
    {
      localc = new c();
      localc.aN = paramArrayOfByte;
      localc.info = paramLong2;
      localc.groupId = paramLong1;
      localc.relationType = paramInt2;
      localc.anb = paramInt3;
      localc.aqM = paramInt4;
      if (paramArrayOfByte == null)
      {
        paramInt2 = 0;
        localc.aqN = paramInt2;
        localc.flag = paramInt6;
        paramArrayOfByte = this.mEventHandler.obtainMessage();
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.what = paramInt1;
          paramArrayOfByte.obj = localc;
          this.mEventHandler.sendMessage(paramArrayOfByte);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        c localc;
        return;
        paramInt2 = paramArrayOfByte.length;
      }
    }
    QLog.d("QQGAudioCtrl", 2, "mEventHandler == null");
  }
  
  public int onNativeRecvGAudioCMD(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      paramInt = onRecvGAudioCMD(paramInt, paramArrayOfByte);
      return paramInt;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      igd.aL("QQGAudioCtrl", paramArrayOfByte.getMessage());
    }
    return -1;
  }
  
  void onRecvDoubleVideoMeeting(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvDoubleVideoMeeting-->mVideoController is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "onRecvDoubleVideoMeeting-->eventId=" + paramInt1 + " ,relationType=" + paramInt2 + " ,inviteUin=" + paramLong + "], multiAVType[" + paramInt3 + "], multiSubType[" + paramInt4);
      }
      if (paramInt1 == 6)
      {
        this.mVideoController.g(paramLong, paramInt3, paramInt4);
        return;
      }
    } while ((paramInt1 == 44) || (paramInt1 != 5));
    this.mVideoController.g(paramLong, paramInt3, paramInt4);
  }
  
  void onRecvUserList(int paramInt1, int paramInt2, long paramLong1, ArrayList<ini> paramArrayList, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvUserList --> mVideoController is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("QQGAudioCtrl", 1, "onRecvUserList.GET_ROOM_INFO, evtId[" + paramInt1 + "], relationType[" + paramInt2 + "], relationId[" + paramLong1 + "], inviteUin[" + paramLong2 + "], multiAVType[" + paramInt4 + "], multiSubType[" + paramInt3 + "], userCount[" + paramInt5 + "]");
      }
      if (paramInt1 == 44)
      {
        this.mVideoController.a(paramLong1, paramArrayList, paramInt4, paramInt5);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQGAudioCtrl", 2, "onRecvUserList --> WRONG EVTID. evtId = " + paramInt1);
  }
  
  void onRecvUserList(int paramInt1, int paramInt2, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvUserList-->mVideoController is null");
      }
    }
    label205:
    label211:
    do
    {
      return;
      int i = 0;
      if (paramArrayOfLong != null) {
        i = paramArrayOfLong.length;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onRecvUserList, evtId[").append(paramInt1).append("], relationType[").append(paramInt2).append("], relationId[").append(paramLong1).append("], inviteUin[").append(paramLong2).append("], multiAVType[").append(paramInt3).append("], multiSubType[").append(paramInt4).append("], userListSize[").append(i).append("], userList[");
        if (paramArrayOfLong == null) {
          break label205;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        QLog.w("QQGAudioCtrl", 1, bool + "], flag[" + paramInt6 + "]");
        if ((paramArrayOfLong == null) && (paramInt2 == 2)) {
          break;
        }
        if (paramInt1 != 44) {
          break label211;
        }
        this.mVideoController.a(paramLong1, paramArrayOfLong, paramInt3, paramInt5);
        return;
      }
      if (paramInt1 == 6)
      {
        this.mVideoController.a(paramInt2, paramLong1, paramLong2, paramArrayOfLong, false, paramInt3, paramInt4, paramInt6);
        return;
      }
    } while (paramInt1 != 5);
    this.mVideoController.a(paramInt2, paramLong1, paramLong2, paramArrayOfLong, true, paramInt3, paramInt4, paramInt6);
  }
  
  void onRecvUserListFail(int paramInt, long paramLong1, long paramLong2)
  {
    QLog.w("QQGAudioCtrl", 1, "onRecvUserListFail, relationType[" + paramInt + "], relationId[" + paramLong1 + "], errCode[" + paramLong2 + "]");
    this.mVideoController.o(paramInt, paramLong1);
  }
  
  public native byte[] postData(long paramLong, byte[] paramArrayOfByte);
  
  void processMicAuthAfterEnterRoom(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 8))
    {
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
      if (getIntFromByte(arrayOfByte) != 1) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, 4, arrayOfByte, 0, 4);
      int i = getIntFromByte(arrayOfByte);
      this.mVideoController.m(0L, i);
      this.mVideoController.a(0L, bool, true);
      return;
    }
  }
  
  public native int quit(int paramInt);
  
  public native int registerAudioDataCallback(int paramInt, boolean paramBoolean);
  
  public native int registerTRAE(int paramInt);
  
  public int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = jkn.mE();
    if (i > 0) {}
    for (;;)
    {
      QLog.w("QQGAudioCtrl", 1, "request, maxShowVideo[" + i + "]");
      return request(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt5, i, 0);
      i = 5;
    }
  }
  
  public native int requestCamera(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public native int requestMemPosInfoList();
  
  public native int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public void sendGAudioCMD(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.mVideoController.b(paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public native void sendTransferMsg(long[] paramArrayOfLong, byte[] paramArrayOfByte);
  
  public native int setAECMode(int paramInt);
  
  public native int setApType(int paramInt);
  
  public void setAppid(int paramInt)
  {
    this.appid = paramInt;
  }
  
  public native int setAudioDataFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native boolean setAudioNoiseCtrlParam(int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAudioOutputMode(int paramInt);
  
  public native int setHowlingDetectEnable(boolean paramBoolean);
  
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
  
  public native boolean setMicByAdmin(long paramLong, boolean paramBoolean);
  
  public native boolean setMicMode(int paramInt);
  
  public native int setNetIPAndPort(String paramString, int paramInt);
  
  public native void setProcessDecoderFrameFunctionptr(long paramLong);
  
  public native void setVideoJitterLength(int paramInt);
  
  public native int setVoiceType(int paramInt);
  
  public native int startAudioRecv();
  
  public int startAudioSend()
  {
    return startAudioSend(false);
  }
  
  public native int startAudioSend(boolean paramBoolean);
  
  public int startCommonGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString, int paramInt4, byte[] paramArrayOfByte, int paramInt5)
  {
    if ((paramInt1 != 11) || (paramInt2 != 14) || (paramInt3 != 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "startCommonGAudio type error!");
      }
      paramInt2 = -1;
      return paramInt2;
    }
    int i = jkn.mE();
    label46:
    StringBuilder localStringBuilder;
    if (i > 0) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("startCommonGAudio emAVRelationType:").append(paramInt1).append(" emMultiAVType:").append(paramInt2).append(" emMultiAVSubType:").append(paramInt3).append(" roomId:").append(paramLong1).append(" selfUin:").append(paramLong2).append(" llAppid:").append(paramInt4).append(" nConfig:").append(0).append(" maxShowVideo:").append(i).append(" openId:").append(paramString).append(" sourceId:").append(paramInt4).append(" commonSig.length:");
        if (paramArrayOfByte == null) {
          break label290;
        }
      }
    }
    for (int j = paramArrayOfByte.length;; j = 0)
    {
      for (;;)
      {
        QLog.d("QQGAudioCtrl", 2, j + " svrRecogFlag:" + paramInt5);
        try
        {
          for (;;)
          {
            paramInt1 = commonRequest(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4, 0, i, paramString, paramInt4, paramArrayOfByte, paramInt5);
            paramInt2 = paramInt1;
            try
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QQGAudioCtrl", 2, "startCommonGAudio result:" + paramInt1);
              return paramInt1;
            }
            catch (Throwable paramString) {}
          }
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            label290:
            paramInt1 = -1;
          }
        }
      }
      QLog.e("QQGAudioCtrl", 1, "startCommonGAudio fail.", paramString);
      return paramInt1;
      i = 5;
      break label46;
    }
  }
  
  public int startGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7)
  {
    if (this.mInviteGAudioUinList.size() > 0) {
      this.mInviteGAudioUinList.clear();
    }
    if (paramArrayOfLong != null)
    {
      int j = paramArrayOfLong.length;
      i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] != paramLong2) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[i]));
        }
        i += 1;
      }
    }
    int i = jkn.mE();
    if (i > 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQGAudioCtrl", 1, "startGAudio, emAVRelationType[" + paramInt1 + "], groupId[" + paramLong1 + "], emMultiAVType[" + paramInt2 + "], emMultiAVSubType[" + paramInt3 + "], isSwitchGroup[" + paramBoolean + "], apnType[" + paramInt4 + "], nConfigID[" + paramInt6 + "], llConfAppid[" + paramInt5 + "], maxShowVideo[" + i + "]");
      }
      try
      {
        paramInt1 = request(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5, paramInt6, i, paramInt7);
      }
      catch (UnsatisfiedLinkError paramArrayOfLong)
      {
        paramInt1 = -1;
      }
      try
      {
        this.mGroupId = paramLong1;
        this.mIsSwitchGroup = paramBoolean;
        return paramInt1;
      }
      catch (UnsatisfiedLinkError paramArrayOfLong)
      {
        break;
      }
      i = 5;
    }
    igd.aL("QQGAudioCtrl", paramArrayOfLong.getMessage());
    return paramInt1;
  }
  
  public int startVideoRecv(ArrayList<ioa> paramArrayList)
  {
    return startVideoRecv(paramArrayList, false);
  }
  
  public int startVideoRecv(ArrayList<ioa> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return 0;
    }
    int j = paramArrayList.size() * 3;
    long[] arrayOfLong = new long[j];
    String str = new String();
    int i = 0;
    if (i < paramArrayList.size())
    {
      arrayOfLong[(i * 3)] = ((ioa)paramArrayList.get(i)).uin;
      str = str + "uin=" + arrayOfLong[(i * 3)] + " ,";
      arrayOfLong[(i * 3 + 1)] = ((ioa)paramArrayList.get(i)).videoSrcType;
      str = str + "videoSrcType=" + arrayOfLong[(i * 3 + 1)] + " ,";
      if (paramBoolean)
      {
        if (this.mVideoController == null) {
          return 0;
        }
        iiv localiiv = this.mVideoController.b();
        if (localiiv == null) {
          return 0;
        }
        if (localiiv.d(((ioa)paramArrayList.get(i)).uin, i)) {
          arrayOfLong[(i * 3 + 2)] = 1L;
        }
      }
      for (;;)
      {
        str = str + "isBig=" + arrayOfLong[(i * 3 + 2)] + " ,";
        i += 1;
        break;
        arrayOfLong[(i * 3 + 2)] = 0L;
        continue;
        if (((ioa)paramArrayList.get(i)).Tp) {
          arrayOfLong[(i * 3 + 2)] = 1L;
        } else {
          arrayOfLong[(i * 3 + 2)] = 0L;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "startVideoRecv-->info=" + str);
    }
    return startVideoRecv(arrayOfLong, j);
  }
  
  public native int startVideoRecv(long[] paramArrayOfLong, int paramInt);
  
  public native int startVideoSend();
  
  public native int stopAudioRecv();
  
  public native int stopAudioSend(boolean paramBoolean);
  
  public native int stopVideoRecv();
  
  public native int switchToAudioMode();
  
  public native void uninit();
  
  public native int unregisterAudioDataCallback(int paramInt);
  
  public native int unregisterTRAE(int paramInt);
  
  public void updateRoomUserTerminalInfo(iiv paramiiv, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      paramiiv = getRoomParams(paramiiv);
      if ((paramiiv == null) || (l1 == 0L)) {
        return;
      }
    }
    catch (Throwable paramString)
    {
      long l1;
      int i;
      long l2;
      int j;
      do
      {
        for (;;)
        {
          l1 = 0L;
        }
        i = ((Integer)paramiiv[0]).intValue();
        l2 = ((Long)paramiiv[1]).longValue();
        j = ((Integer)paramiiv[2]).intValue();
        updateRoomUserTerminalInfo(i, l2, j, l1, paramInt1, paramInt2);
      } while (!QLog.isColorLevel());
      QLog.i("QQGAudioCtrl", 2, String.format("updateRoomUserTerminalInfo [%s, %s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  static class a
  {
    String TAG;
    int aqL = 0;
    long logTime = 0L;
    long mi;
    
    a(String paramString, long paramLong)
    {
      this.TAG = ("EventCountLog_" + paramString);
      this.mi = paramLong;
    }
    
    void log()
    {
      if (!AudioHelper.aCz()) {}
      long l1;
      do
      {
        return;
        l1 = System.currentTimeMillis();
        this.aqL += 1;
      } while (this.logTime >= l1);
      long l2 = this.mi;
      long l3 = this.logTime;
      this.logTime = (l1 + this.mi);
      QLog.w(this.TAG, 1, "EventCountLog, eventCount[" + this.aqL + "], intervalMS[" + (l2 + l1 - l3) + "]");
      this.aqL = 0;
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage == null) {}
      label20:
      int n;
      Object localObject1;
      long l3;
      long l1;
      int k;
      int m;
      int i2;
      int j;
      label153:
      int i;
      label274:
      label576:
      label750:
      boolean bool;
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioCtrl", 2, "handleMessage-->Message is empty!");
          }
          return;
        }
        finally {}
        if (QQGAudioCtrl.this.mVideoController == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioCtrl", 2, "handleMessage-->mVideoControl = null");
          }
        }
        else
        {
          n = paramMessage.what;
          paramMessage = (QQGAudioCtrl.c)paramMessage.obj;
          if (paramMessage == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QQGAudioCtrl", 2, "handleMessage-->NativeEventParams is null");
            }
          }
          else
          {
            localObject1 = paramMessage.aN;
            l3 = paramMessage.info;
            l1 = paramMessage.groupId;
            k = paramMessage.anb;
            int i1 = paramMessage.aqM;
            m = paramMessage.relationType;
            i2 = paramMessage.aqN;
            j = paramMessage.flag;
            if (n == 61)
            {
              QQGAudioCtrl.mEventCountLog_EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA.log();
              break label2680;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("QQGAudioCtrl", 2, "Wrong type of eventid=" + n);
            }
            else
            {
              if ((n == 43) || (!AudioHelper.aCz())) {
                break label2680;
              }
              Object localObject2 = new StringBuilder().append("handleMessage, groupId[").append(l1).append("], multiAVType[").append(k).append("], multiSubType[").append(i1).append("], relationType[").append(m).append("], info[").append(l3).append("], detail[");
              if (localObject1 == null) {
                break label3395;
              }
              i = localObject1.length;
              QLog.w("QQGAudioCtrl", 1, i + "], eventId[" + n + "], buflen[" + i2 + "], flag[" + j + "]");
              break label2680;
              if (localObject1 != null)
              {
                paramMessage = QQGAudioCtrl.this.getAVInfoFromByte((byte[])localObject1, i2);
                if (paramMessage == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("QQGAudioCtrl", 2, "handleMessage, fail, empty userInfo");
                  }
                }
                else if ((paramMessage.accountType == 0) || ((paramMessage.accountType == 1) && (paramMessage.aqC == 3) && (n == 70)) || ((paramMessage.accountType == 1) && (n == 71)))
                {
                  QQGAudioCtrl.this.mVideoController.a(paramMessage, l1, n, m, l3, new int[] { k });
                  continue;
                  if ((localObject1 != null) && (localObject1.length >= 8))
                  {
                    paramMessage = QQGAudioCtrl.this.getUinListFromBuf((byte[])localObject1);
                    if (paramMessage == null)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("QQGAudioCtrl", 2, "handleMessage, fail, empty uinList");
                      }
                    }
                    else
                    {
                      if (!QLog.isColorLevel()) {
                        break label3400;
                      }
                      localObject1 = new StringBuilder();
                      j = paramMessage.length;
                      i = 0;
                      long l2;
                      while (i < j)
                      {
                        l2 = paramMessage[i];
                        ((StringBuilder)localObject1).append("UserUin = ");
                        ((StringBuilder)localObject1).append(l2);
                        ((StringBuilder)localObject1).append(", ");
                        i += 1;
                      }
                      ((StringBuilder)localObject1).append("eventid = ");
                      ((StringBuilder)localObject1).append(n);
                      QLog.d("QQGAudioCtrl", 2, ((StringBuilder)localObject1).toString());
                      break label3400;
                      QQGAudioCtrl.this.mVideoController.a(l1, paramMessage, n, m, l3, k, i);
                      continue;
                      QQGAudioCtrl.this.mVideoController.i(l1, m, n);
                      continue;
                      if ((localObject1 != null) && (localObject1.length >= 8) && (m == 1))
                      {
                        l2 = QQGAudioCtrl.this.getLongFromByte((byte[])localObject1);
                        if (k != 10)
                        {
                          QQGAudioCtrl.this.mVideoController.a((int)l3, m, l2, l1);
                          continue;
                          if ((localObject1 != null) && (localObject1.length >= 8))
                          {
                            l2 = QQGAudioCtrl.this.getLongFromByte((byte[])localObject1);
                            QQGAudioCtrl.this.mVideoController.a(l1, l2, m, (int)l3);
                            continue;
                            for (;;)
                            {
                              QQGAudioCtrl.this.mVideoController.b(l1, l3, paramMessage);
                              if (i == 0) {
                                break;
                              }
                              QQGAudioCtrl.this.mVideoController.b(m, l1, i, k);
                              break;
                              label776:
                              paramMessage = new String((byte[])localObject1);
                            }
                            label959:
                            if ((paramMessage.aN != null) && (paramMessage.aN.length >= 16))
                            {
                              paramMessage = QQGAudioCtrl.this.getAVInfoFromByte(paramMessage.aN, paramMessage.aN.length);
                              if (n != 140) {
                                break label3598;
                              }
                              bool = true;
                              label834:
                              if (paramMessage != null)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.w("QQGAudioCtrl", 1, "MemberAudioChange, uin[" + paramMessage.account + "], accountType[" + paramMessage.accountType + "], isMicOff[" + bool + "]");
                                }
                                QQGAudioCtrl.this.mVideoController.a(paramMessage.account, paramMessage.accountType, paramMessage.aqC, bool);
                                continue;
                                l2 = 0L;
                                l1 = l2;
                                if (paramMessage.aN == null) {
                                  break label3604;
                                }
                                if (paramMessage.aN.length != 8)
                                {
                                  l1 = l2;
                                  break label3604;
                                  QQGAudioCtrl.this.mVideoController.a(l1, bool, false);
                                }
                                else
                                {
                                  l1 = QQGAudioCtrl.this.getLongFromByte(paramMessage.aN);
                                  break label3604;
                                  i = (int)l3;
                                  if (paramMessage.aN == null) {
                                    break label2674;
                                  }
                                  if (paramMessage.aN.length != 8) {}
                                  for (l1 = 0L;; l1 = QQGAudioCtrl.this.getLongFromByte(paramMessage.aN))
                                  {
                                    label1019:
                                    if (QLog.isColorLevel()) {
                                      QLog.e("QQGAudioCtrl", 2, "SetMicByAdmin : uin = " + l1 + ", micAuthByAdmin = " + i);
                                    }
                                    QQGAudioCtrl.this.mVideoController.m(l1, i);
                                    break;
                                  }
                                  j = (int)l3;
                                  if ((paramMessage.aN != null) && (j != 0))
                                  {
                                    localObject2 = QQGAudioCtrl.this;
                                    byte[] arrayOfByte = paramMessage.aN;
                                    if (paramMessage.aN == null) {
                                      break label3623;
                                    }
                                    i = localObject1.length / j;
                                    label1134:
                                    paramMessage = ((QQGAudioCtrl)localObject2).getAVInfoListFromByte(arrayOfByte, i);
                                    if ((paramMessage != null) && (paramMessage.size() == j))
                                    {
                                      QQGAudioCtrl.this.mVideoController.e(j, paramMessage);
                                      continue;
                                      if ((paramMessage.aN != null) && (paramMessage.aN.length == 16))
                                      {
                                        l1 = QQGAudioCtrl.this.getLongFromByte(paramMessage.aN);
                                        localObject1 = new byte[4];
                                        System.arraycopy(paramMessage.aN, 12, localObject1, 0, 4);
                                        i = QQGAudioCtrl.this.getIntFromByte((byte[])localObject1);
                                        if (l3 != 1L) {
                                          break label3628;
                                        }
                                        bool = true;
                                        label1240:
                                        if (QLog.isColorLevel()) {
                                          QLog.e("QQGAudioCtrl", 2, "onGAudioUserAudioSuspectNoisy : uin = " + l1 + ", isSuspectNoisy = " + bool + ",validDuration = " + i);
                                        }
                                        QQGAudioCtrl.this.mVideoController.b(l1, bool, i);
                                        continue;
                                        QQGAudioCtrl.this.mVideoController.f(m, l1, k);
                                        QQGAudioCtrl.this.processMicAuthAfterEnterRoom(paramMessage.aN);
                                        continue;
                                        paramMessage = QQGAudioCtrl.this.getUinListFromBuf((byte[])localObject1);
                                        if (m == 2) {
                                          break label3634;
                                        }
                                        if (m == 1)
                                        {
                                          break label3634;
                                          for (;;)
                                          {
                                            label1370:
                                            QQGAudioCtrl.this.onRecvUserList(6, m, l1, paramMessage, l3, k, i1, i, j);
                                            break;
                                            label1395:
                                            i = paramMessage.length;
                                          }
                                        }
                                        if (m == 3)
                                        {
                                          QQGAudioCtrl.this.onRecvDoubleVideoMeeting(n, m, l3, k, i1);
                                          continue;
                                          QQGAudioCtrl.this.mVideoController.a(m, l1, new int[] { k });
                                          continue;
                                          QQGAudioCtrl.this.mVideoController.o(m, l1);
                                          continue;
                                          QQGAudioCtrl.this.mVideoController.a(m, l1, 17, (int)paramMessage.info);
                                          continue;
                                          QQGAudioCtrl.this.mVideoController.a(m, l1, 16, (int)paramMessage.info);
                                          continue;
                                          QQGAudioCtrl.this.mVideoController.a(m, l1, 15, (int)paramMessage.info);
                                          continue;
                                          paramMessage = QQGAudioCtrl.this.getUinListFromBuf((byte[])localObject1);
                                          if (paramMessage == null) {}
                                          for (i = 0;; i = paramMessage.length)
                                          {
                                            QQGAudioCtrl.this.onRecvUserList(44, m, l1, paramMessage, 0L, k, 0, i, j);
                                            break;
                                          }
                                          QQGAudioCtrl.this.mVideoController.h(l1, m, k);
                                          continue;
                                          j = (int)l3;
                                          if (j >= 0)
                                          {
                                            paramMessage = null;
                                            if (j > 0)
                                            {
                                              paramMessage = QQGAudioCtrl.this;
                                              if (localObject1 == null) {
                                                break label3643;
                                              }
                                              i = localObject1.length / j;
                                              label1647:
                                              paramMessage = paramMessage.getAVInfoListFromByte((byte[])localObject1, i);
                                            }
                                            if (paramMessage != null) {
                                              QQGAudioCtrl.this.onRecvUserList(44, m, l1, paramMessage, 0L, 0, k, j);
                                            } else {
                                              QQGAudioCtrl.this.onRecvUserListFail(m, l1, -99L);
                                            }
                                          }
                                          else
                                          {
                                            QQGAudioCtrl.this.onRecvUserListFail(m, l1, j);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.j(l1, m, k);
                                            QQGAudioCtrl.this.processMicAuthAfterEnterRoom(paramMessage.aN);
                                            continue;
                                            if (QLog.isColorLevel()) {
                                              QLog.d("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA-->Uin=" + l3 + " ,VideoSrcType=" + m);
                                            }
                                            QQGAudioCtrl.this.mVideoController.c(61, l3, m);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.a(n, l3, l1, m);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.b(n, l3, l1, m);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.a(84, (int)l3, m, l1, k, i1);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.a(85, (int)l3, m, l1, k, i1);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.a(86, (int)l3, m, l1, k, i1);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.a(87, (int)l3, m, l1, k, i1);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.a(88, (int)l3, m, l1, k, i1);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.a(89, (int)l3, m, l1, k, i1);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.c(n, l3, l1, m);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.ku(3);
                                            continue;
                                            QQGAudioCtrl.this.mVideoController.ku(4);
                                            continue;
                                            i = (int)paramMessage.info;
                                            BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
                                            itl.a().al("load", i);
                                            continue;
                                            if (l3 != 0L) {
                                              break label3664;
                                            }
                                            paramMessage = inw.a((byte[])localObject1, i2);
                                            QQGAudioCtrl.this.mVideoController.a(paramMessage);
                                            if (paramMessage == null)
                                            {
                                              paramMessage = null;
                                              break label3648;
                                              label2159:
                                              if (paramMessage != null)
                                              {
                                                l2 = QQGAudioCtrl.this.mVideoController.a(m, k, l1);
                                                localObject1 = new ArrayList(paramMessage.size());
                                                l3 = AudioHelper.hF() / 1000L;
                                                paramMessage = paramMessage.iterator();
                                                while (paramMessage.hasNext()) {
                                                  ((ArrayList)localObject1).add(new inx(((ing)paramMessage.next()).lZ, l3));
                                                }
                                              }
                                            }
                                            else
                                            {
                                              paramMessage = paramMessage.iz;
                                              break label3648;
                                              QQGAudioCtrl.this.mVideoController.a(l1, l2, (ArrayList)localObject1);
                                              if (QLog.isColorLevel()) {
                                                QLog.i("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_PBInvite_Rsp = MULTIAV_GROUP_AUDIO saveInviteMembers");
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        QQGAudioCtrl.this.mVideoController.c(l1, l3, paramMessage);
        break;
        label2313:
        paramMessage = new String((byte[])localObject1);
      }
      for (;;)
      {
        label2326:
        QQGAudioCtrl.this.mVideoController.a(l1, m, k, (int)l3, paramMessage);
        break;
        label2351:
        paramMessage = new String((byte[])localObject1);
      }
      label2364:
      label3648:
      for (;;)
      {
        QQGAudioCtrl.this.mVideoController.b(l1, m, k, (int)l3, paramMessage);
        break;
        label2674:
        label2680:
        do
        {
          paramMessage = new String((byte[])localObject1);
          break label2364;
          QQGAudioCtrl.this.mVideoController.alT();
          break;
          QQGAudioCtrl.this.mVideoController.alU();
          break;
          if (localObject1 == null) {
            break;
          }
          QQGAudioCtrl.this.mVideoController.bC(QQGAudioCtrl.this.getLongFromByte((byte[])localObject1));
          break;
          if (l3 == 0L) {
            break;
          }
          i = (int)l3;
          QQGAudioCtrl.this.mVideoController.ks(i);
          break;
          if (localObject1 == null) {
            break;
          }
          QQGAudioCtrl.this.mVideoController.A((byte[])localObject1);
          break;
          paramMessage = QQGAudioCtrl.this.getAVInfoListFromByte2((byte[])localObject1, i2);
          if (paramMessage == null) {
            break;
          }
          QQGAudioCtrl.this.mVideoController.e(l1, paramMessage);
          break;
          anot.a(null, "CliOper", "", "", "0X800A7A6", "0X800A7A6", 0, (int)l3, "", "", "", "");
          break;
          anot.a(null, "CliOper", "", "", "0X800A7A7", "0X800A7A7", 0, (int)l3, "", "", "", "");
          break;
          QQGAudioCtrl.this.mVideoController.bD(l3);
          break;
          QQGAudioCtrl.this.onRecPushEncParam(m, l1, l3, j);
          break;
          QQGAudioCtrl.this.mVideoController.c((int)l3, (byte[])localObject1);
          break label153;
          break;
          l1 = 0L;
          break label1019;
          switch (n)
          {
          case 7: 
          case 13: 
          case 36: 
          case 37: 
          case 38: 
          case 9: 
          case 10: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 19: 
          case 23: 
          case 24: 
          case 25: 
          case 26: 
          case 27: 
          case 28: 
          case 29: 
          case 40: 
          case 41: 
          case 46: 
          case 47: 
          case 48: 
          case 49: 
          case 50: 
          case 51: 
          case 52: 
          case 53: 
          case 54: 
          case 55: 
          case 56: 
          case 57: 
          case 58: 
          case 59: 
          case 60: 
          case 62: 
          case 63: 
          case 64: 
          case 65: 
          case 66: 
          case 67: 
          case 68: 
          case 69: 
          case 81: 
          case 82: 
          case 83: 
          case 99: 
          case 100: 
          case 105: 
          case 106: 
          case 111: 
          case 112: 
          case 113: 
          case 114: 
          case 115: 
          case 116: 
          case 117: 
          case 118: 
          case 119: 
          case 120: 
          case 124: 
          case 125: 
          case 126: 
          case 127: 
          case 128: 
          case 129: 
          case 130: 
          case 131: 
          case 132: 
          case 133: 
          case 134: 
          case 135: 
          case 136: 
          case 137: 
          case 146: 
          case 147: 
          case 148: 
          case 149: 
          case 150: 
          case 151: 
          case 152: 
          case 154: 
          case 155: 
          case 156: 
          case 159: 
          case 160: 
          case 161: 
          case 162: 
          case 163: 
          case 164: 
          case 165: 
          case 166: 
          case 167: 
          case 168: 
          case 169: 
          case 170: 
          case 173: 
          case 70: 
          case 71: 
          case 42: 
          case 43: 
          case 72: 
          case 73: 
          case 74: 
          case 75: 
          case 76: 
          case 77: 
          case 78: 
          case 79: 
          case 101: 
          case 102: 
          case 103: 
          case 104: 
          case 107: 
          case 108: 
          case 109: 
          case 110: 
          case 140: 
          case 141: 
          case 142: 
          case 143: 
          case 144: 
          case 145: 
          case 30: 
          case 5: 
          case 6: 
          case 12: 
          case 11: 
          case 31: 
          case 32: 
          case 34: 
          case 35: 
          case 39: 
          case 44: 
          case 45: 
          case 8: 
          case 33: 
          case 61: 
          case 90: 
          case 91: 
          case 92: 
          case 93: 
          case 94: 
          case 95: 
          case 84: 
          case 85: 
          case 86: 
          case 87: 
          case 88: 
          case 89: 
          case 96: 
          case 97: 
          case 98: 
          case 121: 
          case 122: 
          case 123: 
          case 20: 
          case 153: 
          case 158: 
          case 157: 
          case 171: 
          case 172: 
          case 80: 
          case 174: 
          case 175: 
          case 176: 
          case 177: 
          case 178: 
          default: 
            break label153;
            i = -1;
            break label274;
            i = 0;
            if (n != 42) {
              break label576;
            }
            j = (int)l3;
            if (j > 100)
            {
              i = 100;
              break label576;
            }
            i = j;
            if (j >= 0) {
              break label576;
            }
            i = 0;
            break;
          case 138: 
          case 139: 
            i = 0;
            switch ((int)l3)
            {
            default: 
              if ((l3 > 200L) && (l3 < 300L))
              {
                if (localObject1 != null) {
                  break label776;
                }
                paramMessage = "";
              }
              break;
            case 8: 
              if (m != 1) {
                break label750;
              }
              i = 1;
              break;
            case 7: 
              i = 2;
              break;
            case 32: 
              i = 7;
              break;
            case 35: 
              i = 35;
              break;
            case 42: 
              i = 42;
              break;
            case 43: 
              i = 43;
              break;
            case 3: 
            case 15: 
              i = 3;
              break label750;
              i = (int)l3;
              break label750;
              bool = false;
              break label834;
              if (l3 == 0L)
              {
                bool = false;
                break label959;
              }
              bool = true;
              break label959;
              i = 0;
              break label1134;
              bool = false;
              break label1240;
              if (paramMessage != null) {
                break label1395;
              }
              i = 0;
              break label1370;
              i = 0;
              break label1647;
              if (k == 10) {
                break label2159;
              }
              if (k != 1) {
                break label20;
              }
              break label2159;
              if (localObject1 != null) {
                break label2313;
              }
              paramMessage = "";
            }
            break;
          case 21: 
            if (localObject1 != null) {
              break label2351;
            }
            paramMessage = "";
            break label2326;
          }
        } while (localObject1 != null);
        label3395:
        label3400:
        label3664:
        paramMessage = "";
      }
    }
  }
  
  class c
  {
    public byte[] aN;
    public int anb;
    public int aqM;
    public int aqN;
    public int flag;
    public long groupId;
    public long info;
    public int relationType;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrl
 * JD-Core Version:    0.7.0.1
 */