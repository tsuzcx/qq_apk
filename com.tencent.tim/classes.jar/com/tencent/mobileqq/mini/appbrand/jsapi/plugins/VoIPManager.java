package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import allc;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import asei.a;
import asei.b;
import asej;
import asem;
import aser;
import aseu;
import asev;
import asex;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.mini.sdk.JsonORM.Column;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;
import org.json.JSONArray;

public class VoIPManager
{
  public static final String TAG = "VoIPManager";
  public static final int UNKNOWN = -1;
  public static volatile VoIPManager sInstance;
  private EventListener mEventListener;
  private JoinRoomListener mJoinRoomListener;
  private MuteConfig mMuteConfig;
  private boolean mQAvHasEnterRoom;
  private boolean mQAvHasInitSDK;
  private AtomicBoolean mQAvRealEnterRoom = new AtomicBoolean(false);
  private aseu mQavMultiObserver = new VoIPManager.3(this);
  private final BroadcastReceiver mReceiver = new VoIPManager.1(this);
  private Map<Long, UserModel> mRoomUserModelList = new ConcurrentHashMap();
  private int mSelfMicStat = -1;
  private int mSelfMuteStat = -1;
  private long mSelfUin = -1L;
  
  private void doExitRoom()
  {
    QLog.i("VoIPManager", 1, "exitRoom!");
    aser localaser = asej.a().a();
    if (localaser != null) {
      localaser.exitRoom();
    }
    qavDeInitSDK();
    this.mQAvHasInitSDK = false;
    this.mQAvRealEnterRoom.set(false);
  }
  
  public static VoIPManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new VoIPManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private JSONArray getRoomOpenIdList()
  {
    Object localObject1 = null;
    if (this.mRoomUserModelList != null)
    {
      localObject2 = this.mRoomUserModelList.keySet();
      localObject1 = new HashSet();
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        UserModel localUserModel = getUserModel(((Long)((Iterator)localObject2).next()).longValue());
        if (localUserModel != null) {
          ((Set)localObject1).add(localUserModel.mOpenId);
        }
      }
      localObject1 = new JSONArray((Collection)localObject1);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new JSONArray();
    }
    return localObject2;
  }
  
  private JSONArray getSpeakingOpenIdList()
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.mRoomUserModelList != null)
    {
      Iterator localIterator = this.mRoomUserModelList.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((UserModel)localEntry.getValue()).mSpeaking) {
          localJSONArray.put(((UserModel)localEntry.getValue()).mOpenId);
        }
      }
    }
    return localJSONArray;
  }
  
  private UserModel getUserModel(long paramLong)
  {
    UserModel localUserModel = null;
    if (this.mRoomUserModelList != null) {
      localUserModel = (UserModel)this.mRoomUserModelList.get(Long.valueOf(paramLong));
    }
    return localUserModel;
  }
  
  private boolean isBluetoothOn()
  {
    return ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isBluetoothA2dpOn();
  }
  
  private boolean isHeadsetPlugged()
  {
    return ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  private boolean isMicAvailable()
  {
    AudioRecord localAudioRecord = new AudioRecord(1, 44100, 16, 1, 44100);
    for (;;)
    {
      try
      {
        if (localAudioRecord.getRecordingState() != 1)
        {
          Boolean localBoolean1 = Boolean.valueOf(false);
          allc.a(localAudioRecord);
          if (localAudioRecord.getRecordingState() != 3)
          {
            localAudioRecord.stop();
            localBoolean1 = Boolean.valueOf(false);
          }
          localAudioRecord.stop();
          return localBoolean1.booleanValue();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VoIPManager", 1, "validateMicAvailability", localThrowable);
        return false;
      }
      finally
      {
        localAudioRecord.release();
      }
      Boolean localBoolean2 = Boolean.valueOf(true);
    }
  }
  
  private void putUserModel(UserModel paramUserModel)
  {
    if (this.mRoomUserModelList != null) {
      this.mRoomUserModelList.put(Long.valueOf(paramUserModel.mUin), paramUserModel);
    }
  }
  
  private void qavDeInitSDK()
  {
    QLog.i("VoIPManager", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.getAppId(), BaseApplicationImpl.getApplication().getQQProcessName());
    asej localasej = asej.a();
    localasej.b(this.mQavMultiObserver);
    localasej.emQ();
  }
  
  private void qavInitSDK(long paramLong)
  {
    QLog.i("VoIPManager", 1, "qavInitSDK");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.getAppId(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    asev.a(new asex());
    asem localasem = asem.a();
    localasem.s((AppRuntime)localObject);
    localasem.a(new VoIPManager.2(this));
    localObject = asej.a();
    ((asej)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localasem);
    ((asej)localObject).a(this.mQavMultiObserver);
  }
  
  private int qavOpMic(boolean paramBoolean)
  {
    if (!this.mQAvRealEnterRoom.get())
    {
      QLog.e("VoIPManager", 1, "cant op mic currently");
      return -1;
    }
    Object localObject = asej.a().a();
    if (localObject != null)
    {
      ((aser)localObject).Uw(paramBoolean);
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        this.mSelfMicStat = i;
        localObject = getUserModel(this.mSelfUin);
        if (localObject != null) {
          ((UserModel)localObject).mMicStat = this.mSelfMicStat;
        }
        QLog.i("VoIPManager", 1, "OpMic " + paramBoolean);
        return 0;
      }
    }
    QLog.e("VoIPManager", 1, "multiOperator null");
    return -2;
  }
  
  private int qavOpMute(boolean paramBoolean)
  {
    if (!this.mQAvRealEnterRoom.get())
    {
      QLog.e("VoIPManager", 1, "cant op mute currently");
      return -1;
    }
    aser localaser = asej.a().a();
    if (localaser != null)
    {
      boolean bool;
      if (!paramBoolean)
      {
        bool = true;
        localaser.Ux(bool);
        if (!paramBoolean) {
          break label92;
        }
      }
      label92:
      for (int i = 1;; i = 2)
      {
        this.mSelfMuteStat = i;
        QLog.i("VoIPManager", 1, "OpMute " + paramBoolean);
        return 0;
        bool = false;
        break;
      }
    }
    QLog.e("VoIPManager", 1, "multiOperator null");
    return -2;
  }
  
  private UserModel removeUserModel(long paramLong)
  {
    UserModel localUserModel = null;
    if (this.mRoomUserModelList != null) {
      localUserModel = (UserModel)this.mRoomUserModelList.remove(Long.valueOf(paramLong));
    }
    return localUserModel;
  }
  
  private void switchAudioRoute()
  {
    QLog.d("VoIPManager", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Boolean.valueOf(isHeadsetPlugged()), Boolean.valueOf(isBluetoothOn()) }));
    aser localaser = asej.a().a();
    if (localaser != null)
    {
      if (isHeadsetPlugged()) {
        localaser.setAudioRoute(0);
      }
    }
    else {
      return;
    }
    if (isBluetoothOn())
    {
      localaser.setAudioRoute(2);
      return;
    }
    localaser.setAudioRoute(1);
  }
  
  private void switchAudioRoute(int paramInt)
  {
    QLog.d("VoIPManager", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(isHeadsetPlugged()), Boolean.valueOf(isBluetoothOn()) }));
    aser localaser = asej.a().a();
    if (localaser != null) {
      localaser.setAudioRoute(paramInt);
    }
  }
  
  private void updateUserModelList(List<asei.b> paramList)
  {
    Object localObject1 = this.mRoomUserModelList.keySet();
    Object localObject2 = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((Set)localObject2).add(Long.valueOf(((asei.b)localIterator.next()).mUin));
    }
    ((Set)localObject1).retainAll((Collection)localObject2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (asei.b)paramList.next();
      if (getUserModel(((asei.b)localObject1).mUin) == null)
      {
        localObject2 = new UserModel(null);
        ((UserModel)localObject2).mUin = ((asei.b)localObject1).mUin;
        ((UserModel)localObject2).mOpenId = ((asei.b)localObject1).mOpenId;
        ((UserModel)localObject2).mMicStat = 1;
        putUserModel((UserModel)localObject2);
      }
    }
  }
  
  public void exitRoom()
  {
    try
    {
      if (this.mQAvHasEnterRoom)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.mReceiver);
        doExitRoom();
        this.mQAvHasEnterRoom = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isEarPhoneMute()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 83	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager:mSelfMuteStat	I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpne +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	VoIPManager
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public boolean isInRoom()
  {
    try
    {
      boolean bool = this.mQAvHasEnterRoom;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isMicMute()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 81	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager:mSelfMicStat	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_2
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	VoIPManager
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public void joinRoom(IdResult paramIdResult, MuteConfig paramMuteConfig, byte[] paramArrayOfByte, JoinRoomListener paramJoinRoomListener)
  {
    for (;;)
    {
      try
      {
        if (this.mQAvHasEnterRoom)
        {
          QLog.e("VoIPManager", 1, "不能重复进房");
          if (paramJoinRoomListener != null) {
            paramJoinRoomListener.onError(-3);
          }
          return;
        }
        exitRoom();
        if (!this.mQAvHasInitSDK)
        {
          if (isMicAvailable())
          {
            qavInitSDK(paramIdResult.tinyId);
            this.mQAvHasInitSDK = true;
          }
        }
        else
        {
          this.mJoinRoomListener = paramJoinRoomListener;
          this.mSelfUin = paramIdResult.tinyId;
          aser localaser = asej.a().a();
          if (localaser == null) {
            break label271;
          }
          asei.a locala = new asei.a();
          locala.aqx = 11;
          locala.aww = 14;
          locala.elI = 1;
          locala.elJ = paramIdResult.roomId;
          locala.mUin = paramIdResult.tinyId;
          locala.mOpenId = paramIdResult.openId;
          locala.bDB = 1;
          locala.bc = paramArrayOfByte;
          int i = localaser.a(locala);
          if (i != 0) {
            paramJoinRoomListener.onError(i);
          }
          this.mMuteConfig = paramMuteConfig;
          this.mQAvHasEnterRoom = true;
          paramIdResult = new IntentFilter();
          paramIdResult.addAction("android.intent.action.HEADSET_PLUG");
          paramIdResult.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
          paramIdResult.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
          BaseApplicationImpl.getContext().registerReceiver(this.mReceiver, paramIdResult);
          this.mRoomUserModelList.clear();
          continue;
        }
        if (paramJoinRoomListener == null) {
          continue;
        }
      }
      finally {}
      paramJoinRoomListener.onError(-2);
      continue;
      label271:
      QLog.e("VoIPManager", 1, "multiOperator null");
      if (this.mJoinRoomListener != null)
      {
        this.mJoinRoomListener.onError(-4);
        this.mJoinRoomListener = null;
      }
    }
  }
  
  public void setEventListener(EventListener paramEventListener)
  {
    this.mEventListener = paramEventListener;
  }
  
  /* Error */
  public void updateMuteConfig(MuteConfig paramMuteConfig, MuteConfigListener paramMuteConfigListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 575	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager$MuteConfig:isMuteMicrophone	Z
    //   6: ifne +46 -> 52
    //   9: iconst_1
    //   10: istore 5
    //   12: aload_0
    //   13: iload 5
    //   15: invokespecial 577	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager:qavOpMic	(Z)I
    //   18: istore_3
    //   19: aload_0
    //   20: aload_1
    //   21: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager$MuteConfig:isMuteEarphone	Z
    //   24: invokespecial 582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager:qavOpMute	(Z)I
    //   27: istore 4
    //   29: iload_3
    //   30: ifne +8 -> 38
    //   33: iload 4
    //   35: ifeq +23 -> 58
    //   38: aload_2
    //   39: ifnull +10 -> 49
    //   42: aload_2
    //   43: iconst_m1
    //   44: invokeinterface 585 2 0
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: iconst_0
    //   53: istore 5
    //   55: goto -43 -> 12
    //   58: aload_2
    //   59: ifnull -10 -> 49
    //   62: aload_2
    //   63: invokeinterface 588 1 0
    //   68: goto -19 -> 49
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	VoIPManager
    //   0	76	1	paramMuteConfig	MuteConfig
    //   0	76	2	paramMuteConfigListener	MuteConfigListener
    //   18	12	3	i	int
    //   27	7	4	j	int
    //   10	44	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	71	finally
    //   12	29	71	finally
    //   42	49	71	finally
    //   62	68	71	finally
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EnableStat
  {
    public static final int DISABLED = 2;
    public static final int ENABLED = 1;
    public static final int NONE = -1;
  }
  
  public static abstract interface EventListener
  {
    public abstract void onInterrupt(int paramInt, String paramString);
    
    public abstract void onRoomMemberChange(JSONArray paramJSONArray);
    
    public abstract void onRoomMemberSpeaking(JSONArray paramJSONArray);
  }
  
  public static class IdResult
  {
    @JsonORM.Column(key="openId")
    public String openId;
    @JsonORM.Column(key="roomId")
    public int roomId;
    @JsonORM.Column(key="tinyId")
    public long tinyId;
    
    public String toString()
    {
      return "IdResult{openId='" + this.openId + '\'' + ", tinyId=" + this.tinyId + ", roomId=" + this.roomId + '}';
    }
  }
  
  public static abstract interface JoinRoomListener
  {
    public abstract void onError(int paramInt);
    
    public abstract void onJoinRoom(JSONArray paramJSONArray);
  }
  
  public static class MuteConfig
  {
    @JsonORM.Column(key="muteEarphone")
    public boolean isMuteEarphone;
    @JsonORM.Column(key="muteMicrophone")
    public boolean isMuteMicrophone;
    
    public String toString()
    {
      return "muteConfig{isMuteMicrophone=" + this.isMuteMicrophone + ", isMuteEarphone=" + this.isMuteEarphone + '}';
    }
  }
  
  public static abstract interface MuteConfigListener
  {
    public abstract void onFail(int paramInt);
    
    public abstract void onSuccess();
  }
  
  public static class RoomConfig
  {
    @JsonORM.Column(key="groupId")
    public String groupId;
    @JsonORM.Column(key="muteConfig")
    public VoIPManager.MuteConfig muteConfig;
    @JsonORM.Column(key="nonceStr")
    public String nonceStr;
    @JsonORM.Column(key="signature")
    public String signature;
    @JsonORM.Column(key="timeStamp")
    public int timeStamp;
    
    public String toString()
    {
      return "RoomConfig{signature='" + this.signature + '\'' + ", nonceStr='" + this.nonceStr + '\'' + ", timeStamp=" + this.timeStamp + ", groupId=" + this.groupId + ", muteConfig=" + this.muteConfig + '}';
    }
  }
  
  class UserModel
  {
    public int mMicStat;
    public String mOpenId;
    public boolean mSpeaking;
    public long mUin;
    
    private UserModel() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager
 * JD-Core Version:    0.7.0.1
 */