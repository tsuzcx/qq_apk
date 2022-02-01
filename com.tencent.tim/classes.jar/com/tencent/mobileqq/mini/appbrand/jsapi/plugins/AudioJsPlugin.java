package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajmi.a;
import ajmj;
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.RemoteException;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import aqge;
import aqgz;
import aqmr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder;
import com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder.AudioPlayerListener;
import com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder.AudioRecordListener;
import com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder.OnErrorListener;
import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer;
import com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class AudioJsPlugin
  extends BaseJsPlugin
{
  private static final String API_CREATE_AUDIO_INSTANCE = "createAudioInstance";
  private static final String API_DESTROY_AUDIO_INSTANCE = "destroyAudioInstance";
  private static final String API_GET_AUDIO_STATE = "getAudioState";
  private static final String API_GET_AVAILABLE_AUDIO_SOURCES = "getAvailableAudioSources";
  private static final String API_GET_BACKGROUND_AUDIO_STATE = "getBackgroundAudioState";
  private static final String API_GET_MUSIC_PLAYER_STATE = "getMusicPlayerState";
  private static final String API_OPERATE_AUDIO = "operateAudio";
  private static final String API_OPERATE_BACKGROUND_AUDIO = "operateBackgroundAudio";
  private static final String API_OPERATE_MUSIC_PLAYER = "operateMusicPlayer";
  private static final String API_SET_AUDIO_STATE = "setAudioState";
  private static final String API_SET_BACKGROUND_AUDIO_STATE = "setBackgroundAudioState";
  private static final String API_SET_INNER_AUDIO_OPTION = "setInnerAudioOption";
  private static final String EVENT_ON_AUDIO_STATE_CHANGE = "onAudioStateChange";
  private static final String EVENT_ON_BACKGROUND_STATE_CHANGE = "onBackgroundAudioStateChange";
  private static final String EVENT_RECORD_STATE_CHANGE = "onRecorderStateChange";
  private static final int RECORD_TO_CANCEL = 1;
  private static final int RECORD_TO_SEND = 0;
  public static final String TAG = "[mini] AudioJsPlugin";
  private static boolean mMixWithOther = true;
  public static AtomicInteger sId = new AtomicInteger();
  private static String sToken;
  private final Set<String> eventMap = new HashSet();
  private boolean isNativePause;
  private long lastBindServiceTime = -1L;
  private BgMusicData lastPlayData;
  private Activity mActivity;
  private volatile AudioManager mAudioManager;
  private JSONObject mBgAudioState;
  private BridgeInfo mBgMusicBridge;
  private volatile BgMusicManager mBgMusicManager;
  private ajmi.a mCallback = new AudioJsPlugin.2(this);
  private ServiceConnection mConn = new AudioJsPlugin.1(this);
  private int mCurrentSongDuration = -1;
  private SongInfo mCurrentSongInfo;
  private int mCurrentSongPosition = -1;
  private volatile SparseArray<InnerAudioManager> mInnerAudioManagers = new SparseArray();
  private int mPlayState;
  private ajmj mService;
  
  public AudioJsPlugin()
  {
    this.eventMap.add("startRecord");
    this.eventMap.add("stopRecord");
    this.eventMap.add("playVoice");
    this.eventMap.add("pauseVoice");
    this.eventMap.add("stopVoice");
    this.eventMap.add("operateMusicPlayer");
    this.eventMap.add("getMusicPlayerState");
    this.eventMap.add("setBackgroundAudioState");
    this.eventMap.add("operateBackgroundAudio");
    this.eventMap.add("operateRecorder");
    this.eventMap.add("getAvailableAudioSources");
    this.eventMap.add("getBackgroundAudioState");
    this.eventMap.add("createAudioInstance");
    this.eventMap.add("destroyAudioInstance");
    this.eventMap.add("setAudioState");
    this.eventMap.add("getAudioState");
    this.eventMap.add("operateAudio");
    this.eventMap.add("setInnerAudioOption");
  }
  
  private void bindQQPlayerService()
  {
    for (;;)
    {
      try
      {
        if (this.mService == null)
        {
          long l = System.currentTimeMillis();
          if ((this.lastBindServiceTime != -1L) && (l - this.lastBindServiceTime <= 10000L)) {
            continue;
          }
          this.lastBindServiceTime = l;
          Intent localIntent = new Intent(BaseApplication.getContext(), QQPlayerService.class);
          BaseApplication.getContext().bindService(localIntent, this.mConn, 33);
          QLog.e("[mini] AudioJsPlugin", 1, "bindQQPlayerService end!");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "bindQQPlayerService exception", localThrowable);
        continue;
      }
      finally {}
      return;
      QLog.e("[mini] AudioJsPlugin", 1, "waiting for binding service");
    }
  }
  
  private boolean checkAvalibleSdCard()
  {
    boolean bool = true;
    if (this.mActivity == null) {
      return false;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label98;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = aqgz.getSDCardMemory();
        if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
        {
          return bool;
          i = 0;
          break;
          label98:
          i = 0;
          continue;
        }
        QLog.d("[mini] AudioJsPlugin", 2, "startRecord() " + this.mActivity.getString(2131719248));
      }
    }
    for (;;)
    {
      bool = false;
      break;
      QLog.w("[mini] AudioJsPlugin", 2, "startRecord() " + this.mActivity.getString(2131696377));
    }
  }
  
  private int convertAudioType(String paramString)
  {
    int i = 0;
    if (("slk".equalsIgnoreCase(paramString)) || ("silk".equalsIgnoreCase(paramString))) {
      i = 1;
    }
    return i;
  }
  
  private String createAudioInstance(BridgeInfo paramBridgeInfo)
  {
    if (this.isNativePause)
    {
      handleNativeResponseFail("createAudioInstance", paramBridgeInfo);
      return ApiUtil.wrapCallbackFail("createAudioInstance", null).toString();
    }
    Object localObject = new InnerAudioManager();
    JSONObject localJSONObject = ((InnerAudioManager)localObject).getAudioContext();
    try
    {
      int i = ((InnerAudioManager)localObject).getDuration();
      double d = ((InnerAudioManager)localObject).getCurrentPosition();
      boolean bool = ((InnerAudioManager)localObject).isPaused();
      int j = sId.incrementAndGet();
      localJSONObject.put("duration", i);
      localJSONObject.put("currentTime", d);
      localJSONObject.put("paused", bool);
      localJSONObject.put("buffered", i);
      localJSONObject.put("audioId", j);
      ((InnerAudioManager)localObject).audioId = j;
      this.mInnerAudioManagers.put(j, localObject);
      handleNativeResponseOk("createAudioInstance", paramBridgeInfo, localJSONObject);
      localObject = ApiUtil.wrapCallbackOk("createAudioInstance", localJSONObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "createAudioInstance failed:", localException);
      handleNativeResponseFail("createAudioInstance", paramBridgeInfo);
    }
    return ApiUtil.wrapCallbackFail("createAudioInstance", null).toString();
  }
  
  private void destroyAudioInstance(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString = new JSONObject(paramString);
      InnerAudioManager localInnerAudioManager = getInnerAudioManager(paramString);
      if (localInnerAudioManager != null)
      {
        localInnerAudioManager.destroy();
        int i = paramString.optInt("audioId", -1);
        this.mInnerAudioManagers.remove(i);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "destroyAudioInstance failed:", paramString);
      handleNativeResponseFail("destroyAudioInstance", paramBridgeInfo);
    }
  }
  
  private void evaluateBgAudioStateJs(String paramString)
  {
    evaluateSubscribeJs("onBackgroundAudioStateChange", JSONUtil.append(null, "state", paramString).toString());
  }
  
  private void evaluateSubscribeJs(String paramString)
  {
    evaluateSubscribeJs(paramString, null);
  }
  
  private void evaluateSubscribeJs(String paramString1, String paramString2)
  {
    if ((this.jsPluginEngine == null) || (this.jsPluginEngine.appBrandRuntime == null) || (this.jsPluginEngine.getServiceRuntime() == null)) {
      return;
    }
    this.jsPluginEngine.appBrandRuntime.evaluateServiceSubcribeJS(paramString1, paramString2);
  }
  
  private AudioManager getAudioManager()
  {
    if (this.mAudioManager == null) {
      this.mAudioManager = new AudioManager(this.mActivity, null);
    }
    return this.mAudioManager;
  }
  
  private void getAudioState(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = getInnerAudioManager(paramString);
      if (localObject != null)
      {
        localObject = ((InnerAudioManager)localObject).getAudioContext();
        paramString = getInnerAudioManager(paramString);
        int i = paramString.getDuration();
        double d = paramString.getCurrentPosition();
        boolean bool = paramString.isPaused();
        ((JSONObject)localObject).put("duration", i);
        ((JSONObject)localObject).put("currentTime", d);
        ((JSONObject)localObject).put("paused", bool);
        ((JSONObject)localObject).put("buffered", i);
        handleNativeResponseOk("getAudioState", paramBridgeInfo, (JSONObject)localObject);
        return;
      }
      handleNativeResponseFail("getAudioState", paramBridgeInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "getAudioState failed:", paramString);
      handleNativeResponseFail("getAudioState", paramBridgeInfo);
    }
  }
  
  private void getAvailableAudioSources(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioSources", Arrays.toString(new String[] { "auto", "mic", "camcorder", "voice_communication", "voice_recognition" }));
      handleNativeResponseOk(paramString, paramBridgeInfo, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "getAvailableAudioSources failed:", localException);
      handleNativeResponseFail(paramString, paramBridgeInfo);
    }
  }
  
  private BgMusicManager getBgMusicManager()
  {
    if (this.mBgMusicManager == null) {
      this.mBgMusicManager = new BgMusicManager(null);
    }
    return this.mBgMusicManager;
  }
  
  private int getCurrentSongDuration()
  {
    if (this.mService != null) {}
    try
    {
      this.mCurrentSongDuration = Math.max(this.mService.getDuration(), 0);
      return this.mCurrentSongDuration;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "getCurrentSongDuration exception ", localException);
      }
    }
  }
  
  private SongInfo getCurrentSongInfo()
  {
    SongInfo localSongInfo2 = this.mCurrentSongInfo;
    SongInfo localSongInfo1 = localSongInfo2;
    if (localSongInfo2 == null)
    {
      localSongInfo1 = localSongInfo2;
      if (this.mService == null) {}
    }
    try
    {
      localSongInfo1 = this.mService.a();
      return localSongInfo1;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "getCurrentSongInfo exception ", localException);
    }
    return localSongInfo2;
  }
  
  private int getCurrentSongPosition()
  {
    if (this.mPlayState == 3) {
      return this.mCurrentSongPosition;
    }
    if (this.mService != null) {}
    try
    {
      this.mCurrentSongPosition = Math.max(this.mService.getCurrentSongPosition(), 0);
      if (this.mCurrentSongPosition % 1000 != 0) {
        this.mCurrentSongPosition = ((this.mCurrentSongPosition / 1000 + 1) * 1000);
      }
      this.mCurrentSongPosition = Math.min(this.mCurrentSongPosition, this.mCurrentSongDuration);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "getCurrentSongPosition exception ", localException);
      }
    }
    return this.mCurrentSongPosition;
  }
  
  private InnerAudioManager getInnerAudioManager(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("audioId", -1);
    return (InnerAudioManager)this.mInnerAudioManagers.get(i);
  }
  
  private LameMp3Recorder getLameMp3Recorder()
  {
    return getAudioManager().getLameMp3Recorder();
  }
  
  private String getMyToken()
  {
    if (sToken == null) {
      sToken = QQPlayerService.I(8, "[mini] AudioJsPlugin" + this.jsPluginEngine.appBrandRuntime.appId);
    }
    return sToken;
  }
  
  private JSONObject getStateJson()
    throws Exception
  {
    SongInfo localSongInfo = this.mService.a();
    if (localSongInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("duration", mSecToSec(getCurrentSongDuration()));
    localJSONObject.put("currentTime", mSecToSec(getCurrentSongPosition()));
    localJSONObject.put("paused", isPaused());
    localJSONObject.put("src", localSongInfo.url);
    localJSONObject.put("title", localSongInfo.title);
    localJSONObject.put("epname", localSongInfo.album);
    localJSONObject.put("singer", localSongInfo.singer);
    localJSONObject.put("coverImgUrl", localSongInfo.coverUrl);
    localJSONObject.put("webUrl", localSongInfo.detailUrl);
    localJSONObject.put("buffered", mSecToSec(getCurrentSongDuration()));
    return localJSONObject;
  }
  
  private void handleMusicPlayerNativeRequest(boolean paramBoolean, BridgeInfo paramBridgeInfo)
  {
    if (paramBoolean)
    {
      handleNativeResponseOk("operateMusicPlayer", paramBridgeInfo, null);
      return;
    }
    handleNativeResponseFail("operateMusicPlayer", paramBridgeInfo);
  }
  
  private void handleNativeResponseFail(String paramString, BridgeInfo paramBridgeInfo)
  {
    if ((this.jsPluginEngine != null) && (paramBridgeInfo != null)) {
      this.jsPluginEngine.callbackJsEventFail(paramBridgeInfo.getWebView(), paramString, null, paramBridgeInfo.callbackId);
    }
  }
  
  private void handleNativeResponseOk(String paramString, BridgeInfo paramBridgeInfo)
  {
    handleNativeResponseOk(paramString, paramBridgeInfo, null);
  }
  
  private void handleNativeResponseOk(String paramString, BridgeInfo paramBridgeInfo, JSONObject paramJSONObject)
  {
    if ((this.jsPluginEngine != null) && (paramBridgeInfo != null)) {
      this.jsPluginEngine.callbackJsEventOK(paramBridgeInfo.getWebView(), paramString, paramJSONObject, paramBridgeInfo.callbackId);
    }
  }
  
  private boolean isPaused()
  {
    return this.mPlayState != 2;
  }
  
  private double mSecToSec(int paramInt)
  {
    return Math.max(paramInt / 1000, 0);
  }
  
  private void operateAudio(String paramString, BridgeInfo paramBridgeInfo)
  {
    for (;;)
    {
      InnerAudioManager localInnerAudioManager;
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        localInnerAudioManager = getInnerAudioManager(paramString);
        if (localInnerAudioManager == null) {
          break;
        }
        if (this.isNativePause)
        {
          handleNativeResponseFail("operateAudio", paramBridgeInfo);
          return;
        }
        str = paramString.optString("operationType");
        if ("play".equals(str))
        {
          localInnerAudioManager.play();
          handleNativeResponseOk("operateAudio", paramBridgeInfo);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "operateAudio failed:", paramString);
        handleNativeResponseFail("operateAudio", paramBridgeInfo);
        return;
      }
      if ("pause".equals(str)) {
        localInnerAudioManager.pause();
      } else if ("stop".equals(str)) {
        localInnerAudioManager.stop();
      } else if ("seek".equals(str)) {
        localInnerAudioManager.seek((int)paramString.optDouble("currentTime"));
      }
    }
  }
  
  private void operateBackgroundAudio(String paramString, BridgeInfo paramBridgeInfo)
  {
    if (paramBridgeInfo == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString);
          str = paramString.optString("operationType");
          if ("play".equals(str))
          {
            if (this.mBgAudioState == null) {
              continue;
            }
            getBgMusicManager().handleMessage(1, paramBridgeInfo, this.mBgAudioState);
          }
        }
        catch (Exception paramString)
        {
          QLog.e("[mini] AudioJsPlugin", 1, "operateBackgroundAudio failed:", paramString);
          handleNativeResponseFail("operateBackgroundAudio", paramBridgeInfo);
          return;
        }
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, paramBridgeInfo);
        return;
      }
      if ("stop".equals(str))
      {
        getBgMusicManager().handleMessage(3, paramBridgeInfo);
        return;
      }
    } while ((!"seek".equals(str)) || (this.mBgAudioState == null));
    getBgMusicManager().handleMessage(4, paramBridgeInfo, paramString);
    handleNativeResponseOk("operateBackgroundAudio", paramBridgeInfo);
  }
  
  private void operateMusicPlayer(String paramString, BridgeInfo paramBridgeInfo)
  {
    bindQQPlayerService();
    String str;
    try
    {
      paramString = new JSONObject(paramString);
      str = paramString.optString("operationType");
      Log.i("[mini] AudioJsPlugin", "operateMusicPlayer: " + str);
      if ("play".equals(str))
      {
        this.mBgAudioState = paramString;
        getBgMusicManager().handleMessage(1, paramBridgeInfo, paramString);
        return;
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, paramBridgeInfo);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "operateMusicPlayer failed:", paramString);
      handleMusicPlayerNativeRequest(false, paramBridgeInfo);
      return;
    }
    if ("stop".equals(str))
    {
      getBgMusicManager().handleMessage(3, paramBridgeInfo);
      return;
    }
    if ("seek".equals(str))
    {
      getBgMusicManager().handleMessage(4, paramBridgeInfo, paramString);
      handleNativeResponseOk("operateMusicPlayer", paramBridgeInfo);
    }
  }
  
  private void operateRecorder(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      operateRecorderByLameMp3(paramString, paramBridgeInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "operateRecorder failed:", paramString);
      handleNativeResponseFail("operateRecorder", paramBridgeInfo);
    }
  }
  
  private void operateRecorderByLameMp3(String paramString, BridgeInfo paramBridgeInfo)
  {
    LameMp3Recorder localLameMp3Recorder = getLameMp3Recorder();
    for (;;)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        str = paramString.optString("operationType");
        if ("start".equals(str))
        {
          if (!checkAvalibleSdCard())
          {
            handleNativeResponseFail("operateRecorder", paramBridgeInfo);
            return;
          }
          updateAudioConfig(localLameMp3Recorder, paramString, paramBridgeInfo);
          getAudioManager().startRecord(paramBridgeInfo, true);
          handleNativeResponseOk("operateRecorder", paramBridgeInfo);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "operateRecorderByLameMp3 failed:", paramString);
        handleNativeResponseFail("operateRecorder", paramBridgeInfo);
        return;
      }
      if ("stop".equals(str)) {
        getAudioManager().stopRecord(0, paramBridgeInfo, true);
      } else if ("pause".equals(str)) {
        localLameMp3Recorder.recordPause();
      } else if ("resume".equals(str)) {
        localLameMp3Recorder.recordResume();
      }
    }
  }
  
  private String parseAudioFormat(String paramString)
  {
    String str2 = "mp3";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase();
      if (!paramString.endsWith("aac")) {
        break label34;
      }
      str1 = "m4a";
    }
    label34:
    do
    {
      return str1;
      str1 = str2;
    } while (!paramString.endsWith("mp3"));
    return "mp3";
  }
  
  private void playVoice(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("filePath");
      if (!aqmr.isEmpty(paramString))
      {
        paramString = MiniAppFileManager.getInstance().getAbsolutePath(paramString);
        getAudioManager().playVoice(paramString, paramBridgeInfo);
        return;
      }
      handleNativeResponseFail("playVoice", paramBridgeInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "playVoice failed:", paramString);
      handleNativeResponseFail("playVoice", paramBridgeInfo);
    }
  }
  
  private void setAudioState(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      getInnerAudioManager((JSONObject)localObject).setAudioContext((JSONObject)localObject);
      String str = ((JSONObject)localObject).optString("src");
      if (!aqmr.isEmpty(str))
      {
        ((JSONObject)localObject).put("src", MiniAppFileManager.getInstance().getAbsolutePath(str));
        boolean bool = ((JSONObject)localObject).optBoolean("autoplay");
        getInnerAudioManager((JSONObject)localObject).playNew(bool);
        paramString = getInnerAudioManager((JSONObject)localObject).getAudioContext();
        localObject = getInnerAudioManager((JSONObject)localObject);
        int i = ((InnerAudioManager)localObject).getDuration();
        double d = ((InnerAudioManager)localObject).getCurrentPosition();
        bool = ((InnerAudioManager)localObject).isPaused();
        paramString.put("duration", i);
        paramString.put("currentTime", d);
        paramString.put("paused", bool);
        paramString.put("buffered", i);
        handleNativeResponseOk("setAudioState", paramBridgeInfo, paramString);
        return;
      }
      QLog.e("[mini] AudioJsPlugin", 2, "setAudioState err" + paramString);
      handleNativeResponseFail("setAudioState", paramBridgeInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 2, "setAudioState err", paramString);
      handleNativeResponseFail("setAudioState", paramBridgeInfo);
    }
  }
  
  private void setBackgroundAudioState(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str = localJSONObject.optString("src");
      Log.i("[mini] AudioJsPlugin", "setBackgroundAudioState: " + paramString);
      if (!aqmr.isEmpty(str))
      {
        localJSONObject.put("src", MiniAppFileManager.getInstance().getAbsolutePath(str));
        this.mBgAudioState = localJSONObject;
        getBgMusicManager().handleMessage(1, paramBridgeInfo, this.mBgAudioState);
        handleNativeResponseOk("setBackgroundAudioState", paramBridgeInfo);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "setBackgroundAudioState failed:", paramString);
      handleNativeResponseFail("setBackgroundAudioState", paramBridgeInfo);
    }
  }
  
  private void setInnerAudioOption(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("mixWithOther");
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramString.equalsIgnoreCase("true")) {
          mMixWithOther = true;
        }
        for (;;)
        {
          handleNativeResponseOk("setInnerAudioOption", paramBridgeInfo);
          return;
          if (paramString.equalsIgnoreCase("false")) {
            mMixWithOther = false;
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "setInnerAudioOption failed:", paramString);
      handleNativeResponseFail("setInnerAudioOption", paramBridgeInfo);
    }
  }
  
  private void startRecord(String paramString1, String paramString2, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      updateAudioConfig(getLameMp3Recorder(), paramString2, paramBridgeInfo);
      getAudioManager().startRecord(paramBridgeInfo, false);
      return;
    }
    catch (Exception paramString2)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "startRecord failed:", paramString2);
      handleNativeResponseFail(paramString1, paramBridgeInfo);
    }
  }
  
  private void unbindQQPlayerService()
  {
    try
    {
      if (this.mService != null)
      {
        BaseApplication.getContext().unbindService(this.mConn);
        this.mService = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "unbindQQPlayerService exception", localThrowable);
      }
    }
    finally {}
  }
  
  private void updateAudioConfig(LameMp3Recorder paramLameMp3Recorder, JSONObject paramJSONObject, BridgeInfo paramBridgeInfo)
    throws Exception
  {
    int i = 600000;
    String str3 = paramJSONObject.optString("format");
    paramBridgeInfo = paramJSONObject.optString("sampleRate");
    String str1 = paramJSONObject.optString("numberOfChannels");
    String str2 = paramJSONObject.optString("encodeBitRate");
    int j = paramJSONObject.optInt("duration");
    int k = paramJSONObject.optInt("frameSize");
    paramJSONObject = paramJSONObject.optString("audioSource");
    str3 = parseAudioFormat(str3);
    if (!TextUtils.isEmpty(paramJSONObject)) {
      paramLameMp3Recorder.setAudioSource(paramJSONObject);
    }
    if (!TextUtils.isEmpty(paramBridgeInfo)) {
      paramLameMp3Recorder.setSampleRate(Integer.parseInt(paramBridgeInfo));
    }
    if (!TextUtils.isEmpty(str1)) {
      paramLameMp3Recorder.setOutChannel(Integer.parseInt(str1));
    }
    if (!TextUtils.isEmpty(str2)) {
      paramLameMp3Recorder.setOutBitRate(Integer.parseInt(str2));
    }
    if (!TextUtils.isEmpty(str3)) {
      paramLameMp3Recorder.setRecordFileFormat(str3);
    }
    if (j < 0) {
      i = 1000;
    }
    for (;;)
    {
      if (i > 1) {
        paramLameMp3Recorder.setMaxRecordTime(i / 1000);
      }
      paramLameMp3Recorder.setCallbackFrameSize(k * 1024);
      paramLameMp3Recorder.setRecordFilPath(MiniAppFileManager.getInstance().getTmpPath(str3));
      return;
      if (j <= 600000) {
        i = j;
      }
    }
  }
  
  @NonNull
  private BridgeInfo wrapBridge(JsRuntime paramJsRuntime, int paramInt)
  {
    return new BridgeInfo(paramJsRuntime, paramInt);
  }
  
  public void getBackgroundAudioState(BridgeInfo paramBridgeInfo)
  {
    for (;;)
    {
      try
      {
        if (((this.mPlayState == 3) || (this.mPlayState == 1)) && (this.mBgAudioState != null))
        {
          this.mBgAudioState.put("paused", isPaused());
          handleNativeResponseOk("getBackgroundAudioState", paramBridgeInfo, this.mBgAudioState);
          Log.i("[mini] AudioJsPlugin", "getBackgroundAudioState: pause");
          return;
        }
        if ((this.mService != null) && (this.mService.nt(getMyToken()))) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("getBackgroundAudioState: null ");
        if (this.mService == null)
        {
          bool = true;
          Log.i("[mini] AudioJsPlugin", bool);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "getBackgroundAudioState failed:", localException);
        handleNativeResponseFail("getBackgroundAudioState", paramBridgeInfo);
        return;
      }
      boolean bool = false;
    }
    JSONObject localJSONObject = getStateJson();
    Log.i("[mini] AudioJsPlugin", "getBackgroundAudioState: " + localJSONObject);
    if (localJSONObject != null)
    {
      Log.i("[mini] AudioJsPlugin", "getBackgroundAudioState: ok " + Thread.currentThread().getId() + " " + localJSONObject.toString());
      handleNativeResponseOk("getBackgroundAudioState", paramBridgeInfo, localJSONObject);
      this.mBgAudioState = localJSONObject;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] AudioJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    BridgeInfo localBridgeInfo = wrapBridge(paramJsRuntime, paramInt);
    if ("startRecord".equals(paramString1)) {
      startRecord(paramString1, paramString2, localBridgeInfo);
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if ("stopRecord".equals(paramString1))
      {
        getAudioManager().stopRecord(0, localBridgeInfo, false);
      }
      else if ("operateRecorder".equals(paramString1))
      {
        operateRecorder(paramString2, localBridgeInfo);
      }
      else if ("playVoice".equals(paramString1))
      {
        playVoice(paramString2, localBridgeInfo);
      }
      else if ("pauseVoice".equals(paramString1))
      {
        getAudioManager().pauseVoice(localBridgeInfo);
      }
      else if ("stopVoice".equals(paramString1))
      {
        getAudioManager().stopVoice(localBridgeInfo);
      }
      else if ("operateMusicPlayer".equals(paramString1))
      {
        operateMusicPlayer(paramString2, localBridgeInfo);
      }
      else if ("getMusicPlayerState".equals(paramString1))
      {
        getBgMusicManager().handleMessage(5, localBridgeInfo);
      }
      else if ("setBackgroundAudioState".equals(paramString1))
      {
        setBackgroundAudioState(paramString2, localBridgeInfo);
      }
      else if ("getBackgroundAudioState".equals(paramString1))
      {
        getBackgroundAudioState(localBridgeInfo);
      }
      else if ("operateBackgroundAudio".equals(paramString1))
      {
        operateBackgroundAudio(paramString2, localBridgeInfo);
      }
      else if ("getAvailableAudioSources".equals(paramString1))
      {
        getAvailableAudioSources(paramString1, localBridgeInfo);
      }
      else
      {
        if ("createAudioInstance".equals(paramString1)) {
          return createAudioInstance(localBridgeInfo);
        }
        if ("destroyAudioInstance".equals(paramString1)) {
          destroyAudioInstance(paramString2, localBridgeInfo);
        } else if ("setAudioState".equals(paramString1)) {
          setAudioState(paramString2, localBridgeInfo);
        } else if ("getAudioState".equals(paramString1)) {
          getAudioState(paramString2, localBridgeInfo);
        } else if ("operateAudio".equals(paramString1)) {
          operateAudio(paramString2, localBridgeInfo);
        } else if ("setInnerAudioOption".equals(paramString1)) {
          setInnerAudioOption(paramString2, localBridgeInfo);
        }
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mActivity = paramBaseJsPluginEngine.getActivityContext();
    bindQQPlayerService();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    for (;;)
    {
      int i;
      try
      {
        QLog.d("[mini] AudioJsPlugin", 1, "audio plugin onDestroy");
        if ((this.mService != null) && (QQPlayerService.nt(getMyToken())))
        {
          Intent localIntent = new Intent("qqplayer_exit_action");
          BaseApplication.getContext().sendBroadcast(localIntent);
        }
        if (this.mAudioManager == null) {
          break label114;
        }
        this.mAudioManager.release();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "onDestroy Exception ", localThrowable);
        return;
      }
      if (i > this.mInnerAudioManagers.size())
      {
        ((InnerAudioManager)this.mInnerAudioManagers.valueAt(i)).release();
        i += 1;
      }
      else
      {
        unbindQQPlayerService();
        return;
        label114:
        i = 0;
      }
    }
  }
  
  public void onPause()
  {
    this.isNativePause = true;
    Object localObject;
    if ((this.mInnerAudioManagers != null) && (this.mInnerAudioManagers.size() > 0))
    {
      int i = 0;
      while (i < this.mInnerAudioManagers.size())
      {
        localObject = (InnerAudioManager)this.mInnerAudioManagers.valueAt(i);
        if ((localObject != null) && (!((InnerAudioManager)localObject).isPaused())) {
          ((InnerAudioManager)localObject).pause();
        }
        i += 1;
      }
    }
    if (this.lastPlayData == null) {}
    String str;
    do
    {
      return;
      if (isPaused())
      {
        this.lastPlayData = null;
        return;
      }
      localObject = getCurrentSongInfo();
      if (localObject == null)
      {
        this.lastPlayData = null;
        return;
      }
      localObject = ((SongInfo)localObject).url;
      str = this.lastPlayData.jsonObject.optString("dataUrl", this.lastPlayData.jsonObject.optString("src"));
    } while ((!TextUtils.isEmpty(str)) && (str.equals(localObject)));
    this.lastPlayData = null;
  }
  
  public void onResume()
  {
    super.onResume();
    this.isNativePause = false;
    if (this.lastPlayData == null) {
      return;
    }
    Log.i("[mini] AudioJsPlugin", "onResume: resume play");
    getBgMusicManager().playQQMusic(this.lastPlayData.jsonObject, this.lastPlayData.bridgeInfo);
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
  
  class AudioManager
    implements LameMp3Recorder.AudioPlayerListener, LameMp3Recorder.AudioRecordListener, LameMp3Recorder.OnErrorListener
  {
    private long audioDuration = 60000L;
    private Activity context;
    private int fateOfRecorder = 0;
    private String fileFormat = "mp3";
    private boolean isRecordManagerApi;
    private int maxTime = 600;
    private BridgeInfo playVoiceBidge;
    private volatile LameMp3Recorder recorder;
    private BridgeInfo startRecordBridge;
    private BridgeInfo stopRecordBridge;
    
    private AudioManager(Activity paramActivity)
    {
      this.context = paramActivity;
    }
    
    private int getFateOfRecorder()
    {
      return this.fateOfRecorder;
    }
    
    private LameMp3Recorder getLameMp3Recorder()
    {
      if (this.recorder == null)
      {
        this.recorder = new LameMp3Recorder(this.context);
        this.recorder.setMaxRecordTime(this.maxTime);
        this.recorder.setRecordTime(this.audioDuration);
        this.recorder.setRecordFileFormat(this.fileFormat);
        this.recorder.setRecordFilPath(getTransferFilePath(this.fileFormat));
        this.recorder.setAudioRecordListener(this);
        this.recorder.setOnErrorListener(this);
        this.recorder.setOnPlayListener(this);
      }
      return this.recorder;
    }
    
    private String getTransferFilePath(String paramString)
    {
      paramString = MiniAppFileManager.getInstance().getTmpPath(paramString);
      try
      {
        FileUtils.createFile(paramString);
        return paramString;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return paramString;
    }
    
    private void handleOnRecordEnd(String paramString, long paramLong1, long paramLong2)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramString = MiniAppFileManager.getInstance().getWxFilePath(paramString);
        QLog.d("[mini] AudioJsPlugin", 1, "handleOnRecordEnd, tempFilePath:" + paramString + ", duration:" + paramLong1 + ", fileSize:" + paramLong2);
        localJSONObject.put("tempFilePath", paramString);
        localJSONObject.put("duration", paramLong1);
        localJSONObject.put("fileSize", paramLong2);
        QLog.d("[mini] AudioJsPlugin", 1, "handleOnRecordEnd : " + this.isRecordManagerApi);
        if (this.isRecordManagerApi)
        {
          localJSONObject.put("state", "stop");
          AudioJsPlugin.this.evaluateSubscribeJs("onRecorderStateChange", localJSONObject.toString());
          return;
        }
        AudioJsPlugin.this.handleNativeResponseOk("startRecord", this.startRecordBridge, localJSONObject);
        if (this.stopRecordBridge != null)
        {
          AudioJsPlugin.this.handleNativeResponseOk("stopRecord", this.stopRecordBridge);
          this.stopRecordBridge = null;
          return;
        }
      }
      catch (Exception paramString)
      {
        handleRecordFail("onRecordEnd exception");
      }
    }
    
    private void handlePlayVoice(int paramInt)
    {
      if (paramInt == 8)
      {
        AudioJsPlugin.this.handleNativeResponseFail("playVoice", this.playVoiceBidge);
        return;
      }
      AudioJsPlugin.this.handleNativeResponseOk("playVoice", this.playVoiceBidge, null);
    }
    
    private void handleRecordFail(String paramString)
    {
      QLog.d("[mini] AudioJsPlugin", 1, "handleRecordFail : " + this.isRecordManagerApi);
      if (this.isRecordManagerApi)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("state", "error");
          localJSONObject.put("errMsg", "recordError:" + paramString);
          AudioJsPlugin.this.evaluateSubscribeJs("onRecorderStateChange", localJSONObject.toString());
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      AudioJsPlugin.this.handleNativeResponseFail("startRecord", this.startRecordBridge);
    }
    
    private int parseAudioType(String paramString)
    {
      int j = 0;
      int i = j;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.toLowerCase();
        if (!paramString.endsWith(".slk")) {
          break label29;
        }
        i = 1;
      }
      label29:
      do
      {
        return i;
        i = j;
      } while (!paramString.endsWith(".amr"));
      return 0;
    }
    
    private void releasePlayer()
    {
      if (this.recorder != null) {
        this.recorder.playStop();
      }
    }
    
    private void setFateOfRecorder(int paramInt)
    {
      this.fateOfRecorder = paramInt;
    }
    
    public boolean isRecording()
    {
      return (this.recorder != null) && (this.recorder.isRecording());
    }
    
    public void onErrorInfo(String paramString)
    {
      paramString = getLameMp3Recorder().getRecordFilPath();
      QLog.e("[mini] AudioJsPlugin", 2, "AudioManager.onRecorderNotReady() is called,path is:" + paramString);
      AudioJsPlugin.this.handleNativeResponseFail("startRecord", this.startRecordBridge);
    }
    
    public void onPlayFinish()
    {
      QLog.d("[mini] AudioJsPlugin", 2, "onPlayFinish");
      releasePlayer();
      AudioJsPlugin.this.handleNativeResponseOk("playVoice", this.playVoiceBidge, null);
    }
    
    public void onPlayPause()
    {
      QLog.d("[mini] AudioJsPlugin", 2, "onPlayPause");
    }
    
    public void onPlayResume()
    {
      QLog.d("[mini] AudioJsPlugin", 2, "onPlayResume");
    }
    
    public void onPlayStart()
    {
      QLog.d("[mini] AudioJsPlugin", 2, "onPlayStart");
    }
    
    public void onPlayStop()
    {
      QLog.d("[mini] AudioJsPlugin", 2, "onPlayStop");
      releasePlayer();
      AudioJsPlugin.this.handleNativeResponseOk("playVoice", this.playVoiceBidge, null);
    }
    
    public void onPlayUpdate(int paramInt1, int paramInt2) {}
    
    public void onRecordFrame(byte[] paramArrayOfByte, boolean paramBoolean)
    {
      JSONObject localJSONObject;
      if (paramArrayOfByte != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("state", "frameRecorded");
        NativeBuffer.packNativeBuffer(paramArrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "frameBuffer", localJSONObject, (ITNativeBufferPool)AudioJsPlugin.this.jsPluginEngine.getNativeBufferPool());
        localJSONObject.put("isLastFrame", paramBoolean);
        AudioJsPlugin.this.evaluateSubscribeJs("onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        while (!AudioJsPlugin.this.isColorLevel()) {}
        AudioJsPlugin.this.miniLogE("[mini] AudioJsPlugin", 2, "onRecordFrame failed! " + Log.getStackTraceString(paramArrayOfByte));
      }
    }
    
    public void onRecordPause()
    {
      QLog.d("[mini] AudioJsPlugin", 2, "onRecordPause : " + this.isRecordManagerApi);
      JSONObject localJSONObject;
      if (this.isRecordManagerApi) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("state", "pause");
        AudioJsPlugin.this.evaluateSubscribeJs("onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public void onRecordResume()
    {
      QLog.d("[mini] AudioJsPlugin", 2, "onRecordResume : " + this.isRecordManagerApi);
      JSONObject localJSONObject;
      if (this.isRecordManagerApi) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("state", "resume");
        AudioJsPlugin.this.evaluateSubscribeJs("onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public void onRecordStart()
    {
      QLog.d("[mini] AudioJsPlugin", 1, "onRecordStart : " + this.isRecordManagerApi);
      JSONObject localJSONObject;
      if (this.isRecordManagerApi) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("state", "start");
        AudioJsPlugin.this.evaluateSubscribeJs("onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("[mini] AudioJsPlugin", 1, localException, new Object[0]);
      }
    }
    
    public void onRecordStop(String paramString, long paramLong1, long paramLong2)
    {
      if (this.recorder == null) {}
      int i;
      do
      {
        return;
        i = getFateOfRecorder();
        QLog.d("[mini] AudioJsPlugin", 2, "onRecordStop, fateOfRecorder is:" + i + ", recordFilePath:" + paramString);
        if (i == 0)
        {
          handleOnRecordEnd(paramString, paramLong1, paramLong2);
          return;
        }
      } while (i != 1);
    }
    
    public void onRecordUpdate(int paramInt1, int paramInt2) {}
    
    public void pauseVoice(BridgeInfo paramBridgeInfo)
    {
      if (this.recorder != null)
      {
        this.recorder.playPause();
        AudioJsPlugin.this.handleNativeResponseOk("pauseVoice", paramBridgeInfo, null);
        return;
      }
      AudioJsPlugin.this.handleNativeResponseFail("pauseVoice", paramBridgeInfo);
    }
    
    public void playVoice(String paramString, BridgeInfo paramBridgeInfo)
    {
      this.playVoiceBidge = paramBridgeInfo;
      if (new File(paramString).exists())
      {
        if (this.recorder == null)
        {
          this.recorder = getLameMp3Recorder();
          this.recorder.setOnPlayListener(this);
          this.recorder.playStart(paramString);
          return;
        }
        this.recorder.playStart(paramString);
        return;
      }
      handlePlayVoice(8);
    }
    
    public void release()
    {
      if (this.recorder != null) {
        this.recorder.onDestory();
      }
    }
    
    public void startRecord(BridgeInfo paramBridgeInfo, boolean paramBoolean)
    {
      QLog.i("[mini] AudioJsPlugin", 2, "startRecord() begin");
      this.startRecordBridge = paramBridgeInfo;
      this.isRecordManagerApi = paramBoolean;
      if ((this.recorder != null) && (this.recorder.isRecording()))
      {
        if (AudioJsPlugin.this.isColorLevel()) {
          AudioJsPlugin.this.miniLogD("[mini] AudioJsPlugin", 2, "startRecord() is recording now");
        }
        return;
      }
      Object localObject = Environment.getExternalStorageDirectory();
      int i;
      if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
      {
        i = 1;
        if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
          break label218;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = aqgz.getSDCardMemory();
          if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
          {
            if (AudioHelper.isForbidByRubbishMeizu(1))
            {
              if (AudioJsPlugin.this.isColorLevel()) {
                AudioJsPlugin.this.miniLogD("[mini] AudioJsPlugin", 2, "startRecord() " + this.context.getString(2131700599));
              }
              AudioJsPlugin.this.handleNativeResponseFail("startRecord", paramBridgeInfo);
              return;
              i = 0;
              break;
              label218:
              i = 0;
              continue;
            }
            QLog.d("[mini] AudioJsPlugin", 2, "startRecord() is called");
            if (this.recorder == null) {
              this.recorder = getLameMp3Recorder();
            }
            paramBridgeInfo = this.recorder.getRecordFilPath();
            QLog.i("QQRecorder", 2, "path: " + paramBridgeInfo);
            aqge.m(this.context, true);
            this.recorder.recordStart();
            setFateOfRecorder(0);
            return;
          }
          QLog.d("[mini] AudioJsPlugin", 2, "startRecord() " + this.context.getString(2131719248));
          AudioJsPlugin.this.handleNativeResponseFail("startRecord", paramBridgeInfo);
          return;
        }
      }
      QLog.w("[mini] AudioJsPlugin", 2, "startRecord() " + this.context.getString(2131696377));
      AudioJsPlugin.this.handleNativeResponseFail("startRecord", paramBridgeInfo);
    }
    
    public void stopRecord(int paramInt, BridgeInfo paramBridgeInfo, boolean paramBoolean)
    {
      this.isRecordManagerApi = paramBoolean;
      this.stopRecordBridge = paramBridgeInfo;
      if (this.recorder != null)
      {
        this.recorder.recordStop();
        AudioJsPlugin.this.handleNativeResponseOk("stopRecord", this.stopRecordBridge);
        return;
      }
      AudioJsPlugin.this.handleNativeResponseFail("stopRecord", this.stopRecordBridge);
    }
    
    public void stopVoice(BridgeInfo paramBridgeInfo)
    {
      if (this.recorder != null)
      {
        this.recorder.playStop();
        AudioJsPlugin.this.handleNativeResponseOk("stopVoice", paramBridgeInfo);
        return;
      }
      AudioJsPlugin.this.handleNativeResponseFail("stopVoice", paramBridgeInfo);
    }
  }
  
  static class BgMusicData
  {
    public final BridgeInfo bridgeInfo;
    public final JSONObject jsonObject;
    
    private BgMusicData(JSONObject paramJSONObject, BridgeInfo paramBridgeInfo)
    {
      this.jsonObject = paramJSONObject;
      this.bridgeInfo = paramBridgeInfo;
    }
  }
  
  class BgMusicManager
  {
    private static final int MSG_GET_MUSIC_PLAYER_STATE = 5;
    private static final int MSG_PAUSE = 2;
    private static final int MSG_PLAY = 1;
    private static final int MSG_SEEK = 4;
    private static final int MSG_STOP = 3;
    
    private BgMusicManager()
    {
      AudioJsPlugin.this.bindQQPlayerService();
    }
    
    private int convertState(int paramInt)
    {
      int i = 2;
      if (paramInt == 2) {
        i = 1;
      }
      while (paramInt != 3) {
        return i;
      }
      return 0;
    }
    
    private void getMusicPlayerState(BridgeInfo paramBridgeInfo)
    {
      try
      {
        if ((AudioJsPlugin.this.mService == null) || (AudioJsPlugin.this.mService.getToken() == null)) {
          return;
        }
        if (!AudioJsPlugin.this.mService.getToken().equals(AudioJsPlugin.this.getMyToken())) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        if (AudioJsPlugin.this.getCurrentSongInfo() != null)
        {
          localJSONObject.put("currentPosition", AudioJsPlugin.this.mSecToSec(AudioJsPlugin.access$2600(AudioJsPlugin.this)));
          localJSONObject.put("duration", AudioJsPlugin.this.mSecToSec(AudioJsPlugin.access$2800(AudioJsPlugin.this)));
          localJSONObject.put("status", convertState(AudioJsPlugin.this.mPlayState));
          localJSONObject.put("dataUrl", AudioJsPlugin.this.getCurrentSongInfo().url);
          AudioJsPlugin.this.handleNativeResponseOk("getMusicPlayerState", paramBridgeInfo, localJSONObject);
          return;
        }
      }
      catch (Exception localException)
      {
        AudioJsPlugin.this.handleNativeResponseFail("getMusicPlayerState", paramBridgeInfo);
        return;
      }
      AudioJsPlugin.this.handleNativeResponseFail("getMusicPlayerState", paramBridgeInfo);
    }
    
    private void pauseQQMusic(BridgeInfo paramBridgeInfo)
    {
      AudioJsPlugin.access$3002(AudioJsPlugin.this, paramBridgeInfo);
      try
      {
        AudioJsPlugin.this.mService.pause();
        return;
      }
      catch (Exception localException)
      {
        AudioJsPlugin.this.handleMusicPlayerNativeRequest(false, paramBridgeInfo);
      }
    }
    
    private void playNew(JSONObject paramJSONObject)
      throws RemoteException
    {
      SongInfo localSongInfo = new SongInfo();
      localSongInfo.id = System.currentTimeMillis();
      localSongInfo.url = paramJSONObject.optString("dataUrl", paramJSONObject.optString("src"));
      localSongInfo.title = paramJSONObject.optString("title");
      localSongInfo.album = paramJSONObject.optString("epname");
      localSongInfo.singer = paramJSONObject.optString("singer");
      localSongInfo.coverUrl = paramJSONObject.optString("coverImgUrl");
      localSongInfo.detailUrl = paramJSONObject.optString("webUrl");
      localSongInfo.type = 9;
      localSongInfo.startTime = (paramJSONObject.optInt("startTime", 0) * 1000);
      localSongInfo.fromMini = true;
      AudioJsPlugin.this.mService.ag(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
      Bundle localBundle = AudioJsPlugin.this.mService.getExtras();
      paramJSONObject = localBundle;
      if (localBundle == null)
      {
        paramJSONObject = new Bundle();
        AudioJsPlugin.this.mService.setExtras(paramJSONObject);
      }
      paramJSONObject.putString("KEY_SOURCE_NAME", AudioJsPlugin.this.jsPluginEngine.appBrandRuntime.getApkgInfo().apkgName);
      AudioJsPlugin.this.mService.setExtras(paramJSONObject);
      AudioJsPlugin.this.mService.setPlayMode(100);
      AudioJsPlugin.this.mService.a(AudioJsPlugin.this.getMyToken(), new SongInfo[] { localSongInfo }, 0);
    }
    
    private void playQQMusic(JSONObject paramJSONObject, BridgeInfo paramBridgeInfo)
    {
      if ((AudioJsPlugin.this.mService == null) || (paramJSONObject == null)) {
        AudioJsPlugin.this.handleMusicPlayerNativeRequest(false, paramBridgeInfo);
      }
      do
      {
        return;
        AudioJsPlugin.access$3002(AudioJsPlugin.this, paramBridgeInfo);
        try
        {
          SongInfo localSongInfo = AudioJsPlugin.this.mService.a();
          String str = paramJSONObject.optString("dataUrl", paramJSONObject.optString("src"));
          if ((localSongInfo == null) || (!str.equals(localSongInfo.url))) {
            break;
          }
          if ((AudioJsPlugin.this.mPlayState == 3) || (AudioJsPlugin.this.mPlayState == 1))
          {
            AudioJsPlugin.this.mService.resume();
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          AudioJsPlugin.this.handleMusicPlayerNativeRequest(false, paramBridgeInfo);
          return;
        }
      } while ((AudioJsPlugin.this.mPlayState != 4) && (AudioJsPlugin.this.mPlayState != 0) && (AudioJsPlugin.this.mPlayState != 8));
      playNew(paramJSONObject);
      return;
      playNew(paramJSONObject);
    }
    
    private void seekMusic(JSONObject paramJSONObject, BridgeInfo paramBridgeInfo)
    {
      float f2 = 0.0F;
      if ((AudioJsPlugin.this.mService != null) && (paramJSONObject != null)) {
        try
        {
          String str = paramJSONObject.optString("position");
          paramJSONObject = paramJSONObject.optString("currentTime");
          float f1;
          if (TextUtils.isEmpty(str))
          {
            f1 = 0.0F;
            if (!TextUtils.isEmpty(paramJSONObject)) {
              break label145;
            }
          }
          for (;;)
          {
            int i = (int)(Math.max(f1, f2) * 1000.0F);
            if (i < 0) {
              break label157;
            }
            AudioJsPlugin.this.evaluateBgAudioStateJs("waiting");
            AudioJsPlugin.this.evaluateBgAudioStateJs("seeking");
            AudioJsPlugin.this.mService.seekTo(i);
            AudioJsPlugin.this.handleMusicPlayerNativeRequest(true, paramBridgeInfo);
            AudioJsPlugin.this.evaluateBgAudioStateJs("seeked");
            AudioJsPlugin.this.evaluateBgAudioStateJs("play");
            return;
            f1 = Float.valueOf(str).floatValue();
            break;
            label145:
            f2 = Float.valueOf(paramJSONObject).floatValue();
          }
          label157:
          AudioJsPlugin.this.handleMusicPlayerNativeRequest(false, paramBridgeInfo);
          return;
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          QLog.e("[mini] AudioJsPlugin", 1, "seekMusic error. " + paramJSONObject);
          AudioJsPlugin.this.handleMusicPlayerNativeRequest(false, paramBridgeInfo);
        }
      }
    }
    
    private void stopQQmMusic(BridgeInfo paramBridgeInfo)
    {
      AudioJsPlugin.access$3002(AudioJsPlugin.this, paramBridgeInfo);
      try
      {
        AudioJsPlugin.this.mService.stop();
        return;
      }
      catch (Exception localException)
      {
        AudioJsPlugin.this.handleMusicPlayerNativeRequest(false, paramBridgeInfo);
      }
    }
    
    public void handleMessage(int paramInt, BridgeInfo paramBridgeInfo)
    {
      handleMessage(paramInt, paramBridgeInfo, null);
    }
    
    public void handleMessage(int paramInt, BridgeInfo paramBridgeInfo, JSONObject paramJSONObject)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        playQQMusic(paramJSONObject, paramBridgeInfo);
        AudioJsPlugin.access$1902(AudioJsPlugin.this, new AudioJsPlugin.BgMusicData(paramJSONObject, paramBridgeInfo, null));
        return;
      case 2: 
        pauseQQMusic(paramBridgeInfo);
        AudioJsPlugin.access$1902(AudioJsPlugin.this, null);
        return;
      case 3: 
        stopQQmMusic(paramBridgeInfo);
        AudioJsPlugin.access$1902(AudioJsPlugin.this, null);
        return;
      case 4: 
        seekMusic(paramJSONObject, paramBridgeInfo);
        return;
      }
      getMusicPlayerState(paramBridgeInfo);
    }
  }
  
  class InnerAudioManager
    implements MiniAppAudioPlayer.AudioPlayerListener
  {
    private JSONObject audioContext = new JSONObject();
    public int audioId;
    private volatile boolean isStart;
    private long lastStartTime;
    private MiniAppAudioPlayer mPlayer;
    private String src = "";
    private int startTime;
    
    public InnerAudioManager() {}
    
    private void destroy()
    {
      release();
    }
    
    private void evaluateAudioState(String paramString)
    {
      paramString = JSONUtil.append(null, "state", paramString);
      JSONUtil.append(paramString, "audioId", Integer.valueOf(this.audioId));
      AudioJsPlugin.this.evaluateSubscribeJs("onAudioStateChange", paramString.toString());
    }
    
    private void evaluateErrorCallback(int paramInt1, int paramInt2)
    {
      int i = -1;
      paramInt2 = i;
      switch (paramInt1)
      {
      default: 
        paramInt2 = i;
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("state", "Error");
          localJSONObject.put("audioId", this.audioId);
          localJSONObject.put("errCode", paramInt2);
          AudioJsPlugin.this.evaluateSubscribeJs("onAudioStateChange", localJSONObject.toString());
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        paramInt2 = 10002;
        continue;
        paramInt2 = 10001;
        continue;
        paramInt2 = 10003;
      }
    }
    
    private int getCurrentPosition()
    {
      int i = 0;
      if (this.mPlayer != null) {
        i = this.mPlayer.getCurrentPosition();
      }
      return i;
    }
    
    private int getDuration()
    {
      int i = 0;
      if (this.mPlayer != null) {
        i = this.mPlayer.getDuration();
      }
      return i;
    }
    
    private boolean isPaused()
    {
      return (this.mPlayer == null) || (!this.mPlayer.isPlaying());
    }
    
    private void pause()
    {
      long l = System.currentTimeMillis() - this.lastStartTime;
      if (l < 50L) {
        AppBrandTask.runTaskOnUiThreadDelay(new AudioJsPlugin.InnerAudioManager.2(this), 50L - l);
      }
      while ((this.mPlayer == null) || (!this.mPlayer.isPlaying())) {
        return;
      }
      this.mPlayer.pause();
    }
    
    private void play()
    {
      boolean bool = true;
      if ((this.mPlayer != null) && ((this.mPlayer.isPaused()) || (this.mPlayer.isPrepared())))
      {
        MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
        if (!AudioJsPlugin.mMixWithOther) {}
        for (;;)
        {
          localMiniAppAudioPlayer.setAudioFocus(bool);
          this.mPlayer.start();
          return;
          bool = false;
        }
      }
      playNew(true);
    }
    
    private void playNew(boolean paramBoolean)
    {
      String str;
      int i;
      boolean bool;
      double d;
      if (this.audioContext != null)
      {
        str = this.audioContext.optString("src");
        i = this.audioContext.optInt("startTime");
        bool = this.audioContext.optBoolean("loop");
        d = this.audioContext.optDouble("volume");
        if (!aqmr.isEmpty(str)) {}
      }
      else
      {
        return;
      }
      if (this.mPlayer == null) {
        this.mPlayer = new MiniAppAudioPlayer(new Handler(ThreadManager.getSubThreadLooper()));
      }
      if ((this.mPlayer.isPlaying()) && (this.src.equals(str)) && (this.startTime == i))
      {
        this.mPlayer.setVolume((float)d);
        this.mPlayer.setLooping(bool);
        return;
      }
      this.src = str;
      this.startTime = i;
      this.mPlayer.setAudioPlayerListener(this);
      this.mPlayer.setAudioContext(BaseApplication.getContext());
      this.mPlayer.setStartTime(this.startTime);
      this.mPlayer.setDataSource(this.src, new AudioJsPlugin.InnerAudioManager.1(this, paramBoolean, bool, d));
      this.lastStartTime = System.currentTimeMillis();
    }
    
    private void release()
    {
      if (this.mPlayer != null)
      {
        this.mPlayer.release();
        this.mPlayer = null;
      }
    }
    
    private void seek(int paramInt)
    {
      long l = System.currentTimeMillis() - this.lastStartTime;
      if (l < 100L) {
        AppBrandTask.runTaskOnUiThreadDelay(new AudioJsPlugin.InnerAudioManager.3(this, paramInt), 100L - l);
      }
      while (this.mPlayer == null) {
        return;
      }
      this.mPlayer.seekTo(paramInt);
    }
    
    private void stop()
    {
      if (this.mPlayer != null) {
        this.mPlayer.stop();
      }
    }
    
    public JSONObject getAudioContext()
    {
      return this.audioContext;
    }
    
    public void onError(int paramInt1, int paramInt2)
    {
      evaluateErrorCallback(paramInt1, paramInt2);
    }
    
    public void onPlayerBufferingUpdate(int paramInt) {}
    
    public void onPlayerProgress(String paramString, int paramInt1, int paramInt2)
    {
      if (this.isStart) {
        evaluateAudioState("TimeUpdate");
      }
    }
    
    public void onPlayerSeek(boolean paramBoolean, int paramInt)
    {
      QLog.i("[mini] AudioJsPlugin", 2, "onPlayerSeek Completed : " + paramBoolean + "; position : " + paramInt);
      if (paramBoolean) {}
      for (String str = "Seeked";; str = "Seeking")
      {
        evaluateAudioState(str);
        return;
      }
    }
    
    public void onPlayerStateChange(int paramInt)
    {
      if (paramInt == 0) {
        evaluateAudioState("Waiting");
      }
      do
      {
        return;
        if (paramInt == 1)
        {
          evaluateAudioState("Canplay");
          return;
        }
        if (paramInt == 2)
        {
          this.isStart = true;
          evaluateAudioState("Play");
          return;
        }
        if (paramInt == 3)
        {
          this.isStart = false;
          evaluateAudioState("Pause");
          return;
        }
        if (paramInt == 4)
        {
          this.isStart = false;
          evaluateAudioState("Stop");
          return;
        }
      } while (paramInt != 5);
      this.isStart = false;
      evaluateAudioState("Ended");
      release();
    }
    
    public void setAudioContext(JSONObject paramJSONObject)
    {
      this.audioContext = paramJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin
 * JD-Core Version:    0.7.0.1
 */