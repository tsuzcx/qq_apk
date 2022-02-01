package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.os.Environment;
import android.os.RemoteException;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioPlayerListener;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioRecordListener;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.OnErrorListener;
import com.tencent.qqmini.miniapp.util.AudioHelper;
import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer;
import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.AudioPlayerListener;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.SongInfo;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@JsPlugin
public class AudioJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_ON_AUDIO_STATE_CHANGE = "onAudioStateChange";
  private static final String EVENT_ON_BACKGROUND_STATE_CHANGE = "onBackgroundAudioStateChange";
  private static final String EVENT_RECORD_STATE_CHANGE = "onRecorderStateChange";
  private static final int RECORD_TO_CANCEL = 1;
  private static final int RECORD_TO_SEND = 0;
  public static final int STATE_ERROR = 8;
  public static final String TAG = "AudioJsPlugin";
  private static boolean mMixWithOther = true;
  public static AtomicInteger sId = new AtomicInteger();
  private BgMusicData lastPlayData;
  private volatile AudioManager mAudioManager;
  private JSONObject mBgAudioState;
  private volatile BgMusicManager mBgMusicManager;
  private RequestEvent mBgMusicReq;
  private int mCurrentSongDuration = -1;
  private SongInfo mCurrentSongInfo;
  private int mCurrentSongPosition = -1;
  private volatile SparseArray<InnerAudioManager> mInnerAudioManagers = new SparseArray();
  private MusicPlayerProxy.MusicPlayerListener mMusicPlayerListener = new AudioJsPlugin.1(this);
  private int mPlayState;
  
  private boolean checkAvalibleSdCard()
  {
    boolean bool = true;
    if (this.mMiniAppContext.getAttachedActivity() == null) {
      return false;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label102;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = DeviceInfoUtil.getSDCardMemory();
        if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
        {
          return bool;
          i = 0;
          break;
          label102:
          i = 0;
          continue;
        }
        QMLog.d("AudioJsPlugin", "startRecord() " + this.mMiniAppContext.getAttachedActivity().getString(R.string.mini_sdk_sdcard_full_no_send));
      }
    }
    for (;;)
    {
      bool = false;
      break;
      QMLog.w("AudioJsPlugin", "startRecord() " + this.mMiniAppContext.getAttachedActivity().getString(R.string.mini_sdk_nosdcardnosend));
    }
  }
  
  private void evaluateBgAudioStateJs(String paramString)
  {
    sendSubscribeEvent("onBackgroundAudioStateChange", JSONUtil.append(null, "state", paramString).toString());
  }
  
  private AudioManager getAudioManager()
  {
    if (this.mAudioManager == null) {
      this.mAudioManager = new AudioManager(this.mMiniAppContext.getAttachedActivity(), null);
    }
    return this.mAudioManager;
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
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    if (localMusicPlayerProxy != null) {}
    try
    {
      this.mCurrentSongDuration = Math.max(localMusicPlayerProxy.getDuration(), 0);
      return this.mCurrentSongDuration;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("AudioJsPlugin", "getCurrentSongDuration exception ", localException);
      }
    }
  }
  
  private SongInfo getCurrentSongInfo()
  {
    SongInfo localSongInfo = this.mCurrentSongInfo;
    if (localSongInfo == null)
    {
      Object localObject = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
      if (localObject != null) {
        try
        {
          localObject = ((MusicPlayerProxy)localObject).getCurrentSong();
          return localObject;
        }
        catch (Exception localException)
        {
          QMLog.e("AudioJsPlugin", "getCurrentSongInfo exception ", localException);
        }
      }
    }
    return localSongInfo;
  }
  
  private int getCurrentSongPosition()
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    if (this.mPlayState == 3) {
      return this.mCurrentSongPosition;
    }
    if (localMusicPlayerProxy != null) {}
    try
    {
      this.mCurrentSongPosition = Math.max(localMusicPlayerProxy.getCurrentSongPosition(), 0);
      if (this.mCurrentSongPosition % 1000 != 0) {
        this.mCurrentSongPosition = ((this.mCurrentSongPosition / 1000 + 1) * 1000);
      }
      this.mCurrentSongPosition = Math.min(this.mCurrentSongPosition, this.mCurrentSongDuration);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("AudioJsPlugin", "getCurrentSongPosition exception ", localException);
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
  
  private JSONObject getStateJson()
    throws Exception
  {
    SongInfo localSongInfo = ((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).getCurrentSong();
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
  
  private boolean isPaused()
  {
    return this.mPlayState != 2;
  }
  
  private double mSecToSec(int paramInt)
  {
    return Math.max(paramInt / 1000, 0);
  }
  
  private void operateRecorderByLameMp3(String paramString, RequestEvent paramRequestEvent)
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
            paramRequestEvent.fail();
            return;
          }
          updateAudioConfig(localLameMp3Recorder, paramString);
          getAudioManager().startRecord(paramRequestEvent, true);
          paramRequestEvent.ok();
          return;
        }
      }
      catch (Exception paramString)
      {
        QMLog.e("AudioJsPlugin", "operateRecorderByLameMp3 failed:", paramString);
        paramRequestEvent.fail();
        return;
      }
      if ("stop".equals(str)) {
        getAudioManager().stopRecord(0, paramRequestEvent, true);
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
  
  private void updateAudioConfig(LameMp3Recorder paramLameMp3Recorder, JSONObject paramJSONObject)
    throws Exception
  {
    int i = 600000;
    String str4 = paramJSONObject.optString("format");
    String str1 = paramJSONObject.optString("sampleRate");
    String str2 = paramJSONObject.optString("numberOfChannels");
    String str3 = paramJSONObject.optString("encodeBitRate");
    int j = paramJSONObject.optInt("duration");
    int k = paramJSONObject.optInt("frameSize");
    paramJSONObject = paramJSONObject.optString("audioSource");
    str4 = parseAudioFormat(str4);
    if (!TextUtils.isEmpty(paramJSONObject)) {
      paramLameMp3Recorder.setAudioSource(paramJSONObject);
    }
    if (!TextUtils.isEmpty(str1)) {
      paramLameMp3Recorder.setSampleRate(Integer.parseInt(str1));
    }
    if (!TextUtils.isEmpty(str2)) {
      paramLameMp3Recorder.setOutChannel(Integer.parseInt(str2));
    }
    if (!TextUtils.isEmpty(str3)) {
      paramLameMp3Recorder.setOutBitRate(Integer.parseInt(str3));
    }
    if (!TextUtils.isEmpty(str4)) {
      paramLameMp3Recorder.setRecordFileFormat(str4);
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
      paramLameMp3Recorder.setRecordFilPath(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str4));
      return;
      if (j <= 600000) {
        i = j;
      }
    }
  }
  
  @JsEvent({"createAudioInstance"})
  public String createAudioInstance(RequestEvent paramRequestEvent)
  {
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
      paramRequestEvent.ok(localJSONObject);
      localObject = ApiUtil.wrapCallbackOk("createAudioInstance", localJSONObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "createAudioInstance failed:", localException);
      paramRequestEvent.fail();
    }
    return ApiUtil.wrapCallbackFail("createAudioInstance", null).toString();
  }
  
  @JsEvent({"destroyAudioInstance"})
  public void destroyAudioInstance(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      InnerAudioManager localInnerAudioManager = getInnerAudioManager(localJSONObject);
      if (localInnerAudioManager != null)
      {
        localInnerAudioManager.destroy();
        int i = localJSONObject.optInt("audioId", -1);
        this.mInnerAudioManagers.remove(i);
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "destroyAudioInstance failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"getAudioState"})
  public void getAudioState(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject2 = getInnerAudioManager((JSONObject)localObject1);
      if (localObject2 != null)
      {
        localObject2 = ((InnerAudioManager)localObject2).getAudioContext();
        localObject1 = getInnerAudioManager((JSONObject)localObject1);
        int i = ((InnerAudioManager)localObject1).getDuration();
        double d = ((InnerAudioManager)localObject1).getCurrentPosition();
        boolean bool = ((InnerAudioManager)localObject1).isPaused();
        ((JSONObject)localObject2).put("duration", i);
        ((JSONObject)localObject2).put("currentTime", d);
        ((JSONObject)localObject2).put("paused", bool);
        ((JSONObject)localObject2).put("buffered", i);
        paramRequestEvent.ok((JSONObject)localObject2);
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "getAudioState failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"getAvailableAudioSources"})
  public void getAvailableAudioSources(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioSources", Arrays.toString(new String[] { "auto", "mic", "camcorder", "voice_communication", "voice_recognition" }));
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "getAvailableAudioSources failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"getBackgroundAudioState"})
  public void getBackgroundAudioState(RequestEvent paramRequestEvent)
  {
    try
    {
      if (((this.mPlayState == 3) || (this.mPlayState == 1)) && (this.mBgAudioState != null))
      {
        this.mBgAudioState.put("paused", isPaused());
        paramRequestEvent.ok(this.mBgAudioState);
        Log.i("AudioJsPlugin", "getBackgroundAudioState: pause");
        return;
      }
      if (!((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).isPlaying())
      {
        Log.i("AudioJsPlugin", "getBackgroundAudioState: isPlaying = false ");
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "getBackgroundAudioState failed:", localException);
      paramRequestEvent.fail();
      return;
    }
    JSONObject localJSONObject = getStateJson();
    Log.i("AudioJsPlugin", "getBackgroundAudioState: " + localJSONObject);
    if (localJSONObject != null)
    {
      Log.i("AudioJsPlugin", "getBackgroundAudioState: ok " + Thread.currentThread().getId() + " " + localJSONObject.toString());
      paramRequestEvent.ok(localJSONObject);
      this.mBgAudioState = localJSONObject;
    }
  }
  
  @JsEvent({"getMusicPlayerState"})
  public void getMusicPlayerState(RequestEvent paramRequestEvent)
  {
    getBgMusicManager().handleMessage(5, paramRequestEvent);
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    ((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).init(this.mMusicPlayerListener, this.mMiniAppInfo.appId, this.mMiniAppInfo.name);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    for (;;)
    {
      int i;
      try
      {
        localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
        QMLog.d("AudioJsPlugin", "audio plugin onDestroy");
        if (this.mAudioManager == null) {
          break label89;
        }
        this.mAudioManager.release();
      }
      catch (Throwable localThrowable)
      {
        MusicPlayerProxy localMusicPlayerProxy;
        QMLog.e("AudioJsPlugin", "onDestroy Exception ", localThrowable);
        return;
      }
      if (i > this.mInnerAudioManagers.size())
      {
        ((InnerAudioManager)this.mInnerAudioManagers.valueAt(i)).release();
        i += 1;
      }
      else
      {
        localMusicPlayerProxy.unInit();
        return;
        label89:
        i = 0;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
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
    if (this.lastPlayData == null) {
      return;
    }
    Log.i("AudioJsPlugin", "onResume: resume play");
    getBgMusicManager().playQQMusic(this.lastPlayData.jsonObject, this.lastPlayData.req);
  }
  
  @JsEvent({"operateAudio"})
  public void operateAudio(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      InnerAudioManager localInnerAudioManager;
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        localInnerAudioManager = getInnerAudioManager(localJSONObject);
        if (localInnerAudioManager == null) {
          break;
        }
        str = localJSONObject.optString("operationType");
        if ("play".equals(str))
        {
          localInnerAudioManager.play();
          paramRequestEvent.ok();
          return;
        }
        if ("pause".equals(str))
        {
          localInnerAudioManager.pause();
          continue;
        }
        if (!"stop".equals(str)) {
          break label104;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("AudioJsPlugin", "operateAudio failed:", localException);
        paramRequestEvent.fail();
        return;
      }
      localInnerAudioManager.stop();
      continue;
      label104:
      if ("seek".equals(str)) {
        localInnerAudioManager.seek((int)localException.optDouble("currentTime"));
      }
    }
  }
  
  @JsEvent({"operateBackgroundAudio"})
  public void operateBackgroundAudio(RequestEvent paramRequestEvent)
  {
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      str = localJSONObject.optString("operationType");
      if ("play".equals(str))
      {
        if (this.mBgAudioState == null) {
          return;
        }
        getBgMusicManager().handleMessage(1, paramRequestEvent, this.mBgAudioState);
        return;
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, paramRequestEvent);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "operateBackgroundAudio failed:", localException);
      paramRequestEvent.fail();
      return;
    }
    if ("stop".equals(str))
    {
      getBgMusicManager().handleMessage(3, paramRequestEvent);
      return;
    }
    if (("seek".equals(str)) && (this.mBgAudioState != null))
    {
      getBgMusicManager().handleMessage(4, paramRequestEvent, localException);
      paramRequestEvent.ok();
    }
  }
  
  @JsEvent({"operateMusicPlayer"})
  public void operateMusicPlayer(RequestEvent paramRequestEvent)
  {
    ((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).init(this.mMusicPlayerListener, this.mMiniAppInfo.appId, this.mMiniAppInfo.name);
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      str = localJSONObject.optString("operationType");
      Log.i("AudioJsPlugin", "operateMusicPlayer: " + str);
      if ("play".equals(str))
      {
        this.mBgAudioState = localJSONObject;
        getBgMusicManager().handleMessage(1, paramRequestEvent, localJSONObject);
        return;
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, paramRequestEvent);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "operateMusicPlayer failed:", localException);
      paramRequestEvent.fail();
      return;
    }
    if ("stop".equals(str))
    {
      getBgMusicManager().handleMessage(3, paramRequestEvent);
      return;
    }
    if ("seek".equals(str))
    {
      getBgMusicManager().handleMessage(4, paramRequestEvent, localException);
      paramRequestEvent.ok();
    }
  }
  
  @JsEvent({"operateRecorder"})
  public void operateRecorder(RequestEvent paramRequestEvent)
  {
    try
    {
      operateRecorderByLameMp3(paramRequestEvent.jsonParams, paramRequestEvent);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "operateRecorder failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"pauseVoice"})
  public void pauseVoice(RequestEvent paramRequestEvent)
  {
    getAudioManager().pauseVoice(paramRequestEvent);
  }
  
  @JsEvent({"playVoice"})
  public void playVoice(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("filePath");
      if (!TextUtils.isEmpty(str))
      {
        str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
        getAudioManager().playVoice(str, paramRequestEvent);
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "playVoice failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"setAudioState"})
  public void setAudioState(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      getInnerAudioManager((JSONObject)localObject1).setAudioContext((JSONObject)localObject1);
      Object localObject2 = ((JSONObject)localObject1).optString("src");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((JSONObject)localObject1).put("src", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject2));
        boolean bool = ((JSONObject)localObject1).optBoolean("autoplay");
        getInnerAudioManager((JSONObject)localObject1).playNew(bool);
        localObject2 = getInnerAudioManager((JSONObject)localObject1).getAudioContext();
        localObject1 = getInnerAudioManager((JSONObject)localObject1);
        int i = ((InnerAudioManager)localObject1).getDuration();
        double d = ((InnerAudioManager)localObject1).getCurrentPosition();
        bool = ((InnerAudioManager)localObject1).isPaused();
        ((JSONObject)localObject2).put("duration", i);
        ((JSONObject)localObject2).put("currentTime", d);
        ((JSONObject)localObject2).put("paused", bool);
        ((JSONObject)localObject2).put("buffered", i);
        paramRequestEvent.ok((JSONObject)localObject2);
        return;
      }
      QMLog.e("AudioJsPlugin", "setAudioState err" + paramRequestEvent.jsonParams);
      paramRequestEvent.fail();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "setAudioState err", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"setBackgroundAudioState"})
  public void setBackgroundAudioState(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("src");
      Log.i("AudioJsPlugin", "setBackgroundAudioState: " + paramRequestEvent.jsonParams);
      if (!TextUtils.isEmpty(str))
      {
        localJSONObject.put("src", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str));
        this.mBgAudioState = localJSONObject;
        getBgMusicManager().handleMessage(1, paramRequestEvent, this.mBgAudioState);
        paramRequestEvent.ok();
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "setBackgroundAudioState failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"setInnerAudioOption"})
  public void setInnerAudioOption(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("mixWithOther");
      if (!TextUtils.isEmpty(str))
      {
        if (str.equalsIgnoreCase("true")) {
          mMixWithOther = true;
        }
        for (;;)
        {
          paramRequestEvent.ok();
          return;
          if (str.equalsIgnoreCase("false")) {
            mMixWithOther = false;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "setInnerAudioOption failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"startRecord"})
  public void startRecord(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      updateAudioConfig(getLameMp3Recorder(), localJSONObject);
      getAudioManager().startRecord(paramRequestEvent, false);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "startRecord failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"stopRecord"})
  public void stopRecord(RequestEvent paramRequestEvent)
  {
    getAudioManager().stopRecord(0, paramRequestEvent, false);
  }
  
  @JsEvent({"stopVoice"})
  public void stopVoice(RequestEvent paramRequestEvent)
  {
    getAudioManager().stopVoice(paramRequestEvent);
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
    private RequestEvent playVoiceReq;
    private volatile LameMp3Recorder recorder;
    private RequestEvent startRecordReq;
    private RequestEvent stopRecordReq;
    
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
      paramString = ((MiniAppFileManager)AudioJsPlugin.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(paramString);
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
        paramString = ((MiniAppFileManager)AudioJsPlugin.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(paramString);
        QMLog.d("AudioJsPlugin", "handleOnRecordEnd, tempFilePath:" + paramString + ", duration:" + paramLong1 + ", fileSize:" + paramLong2);
        localJSONObject.put("tempFilePath", paramString);
        localJSONObject.put("duration", paramLong1);
        localJSONObject.put("fileSize", paramLong2);
        QMLog.d("AudioJsPlugin", "handleOnRecordEnd : " + this.isRecordManagerApi);
        if (this.isRecordManagerApi)
        {
          localJSONObject.put("state", "stop");
          AudioJsPlugin.this.sendSubscribeEvent("onRecorderStateChange", localJSONObject.toString());
          return;
        }
        this.startRecordReq.ok(localJSONObject);
        if (this.stopRecordReq != null)
        {
          this.stopRecordReq.ok();
          this.stopRecordReq = null;
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
        this.playVoiceReq.fail();
        return;
      }
      this.playVoiceReq.ok();
    }
    
    private void handleRecordFail(String paramString)
    {
      QMLog.d("AudioJsPlugin", "handleRecordFail : " + this.isRecordManagerApi);
      if (this.isRecordManagerApi)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("state", "error");
          localJSONObject.put("errMsg", "recordError:" + paramString);
          AudioJsPlugin.this.sendSubscribeEvent("onRecorderStateChange", localJSONObject.toString());
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      this.startRecordReq.fail();
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
      QMLog.e("AudioJsPlugin", "AudioManager.onRecorderNotReady() is called,path is:" + paramString);
      this.startRecordReq.fail();
    }
    
    public void onPlayFinish()
    {
      QMLog.d("AudioJsPlugin", "onPlayFinish");
      releasePlayer();
      this.playVoiceReq.ok();
    }
    
    public void onPlayPause()
    {
      QMLog.d("AudioJsPlugin", "onPlayPause");
    }
    
    public void onPlayResume()
    {
      QMLog.d("AudioJsPlugin", "onPlayResume");
    }
    
    public void onPlayStart()
    {
      QMLog.d("AudioJsPlugin", "onPlayStart");
    }
    
    public void onPlayStop()
    {
      QMLog.d("AudioJsPlugin", "onPlayStop");
      releasePlayer();
      this.playVoiceReq.ok();
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
        NativeBuffer.packNativeBuffer(AudioJsPlugin.this.mMiniAppContext, paramArrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "frameBuffer", localJSONObject);
        localJSONObject.put("isLastFrame", paramBoolean);
        AudioJsPlugin.this.sendSubscribeEvent("onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        while (!QMLog.isColorLevel()) {}
        QMLog.e("AudioJsPlugin", "onRecordFrame failed! " + Log.getStackTraceString(paramArrayOfByte));
      }
    }
    
    public void onRecordPause()
    {
      QMLog.d("AudioJsPlugin", "onRecordPause : " + this.isRecordManagerApi);
      JSONObject localJSONObject;
      if (this.isRecordManagerApi) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("state", "pause");
        AudioJsPlugin.this.sendSubscribeEvent("onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public void onRecordResume()
    {
      QMLog.d("AudioJsPlugin", "onRecordResume : " + this.isRecordManagerApi);
      JSONObject localJSONObject;
      if (this.isRecordManagerApi) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("state", "resume");
        AudioJsPlugin.this.sendSubscribeEvent("onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public void onRecordStart()
    {
      QMLog.d("AudioJsPlugin", "onRecordStart : " + this.isRecordManagerApi);
      JSONObject localJSONObject;
      if (this.isRecordManagerApi) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("state", "start");
        AudioJsPlugin.this.sendSubscribeEvent("onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.e("AudioJsPlugin", localException.getMessage());
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
        QMLog.d("AudioJsPlugin", "onRecordStop, fateOfRecorder is:" + i + ", recordFilePath:" + paramString);
        if (i == 0)
        {
          handleOnRecordEnd(paramString, paramLong1, paramLong2);
          return;
        }
      } while (i != 1);
    }
    
    public void onRecordUpdate(int paramInt1, int paramInt2) {}
    
    public void pauseVoice(RequestEvent paramRequestEvent)
    {
      if (this.recorder != null)
      {
        this.recorder.playPause();
        paramRequestEvent.ok();
        return;
      }
      paramRequestEvent.fail();
    }
    
    public void playVoice(String paramString, RequestEvent paramRequestEvent)
    {
      this.playVoiceReq = paramRequestEvent;
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
    
    public void startRecord(RequestEvent paramRequestEvent, boolean paramBoolean)
    {
      QMLog.i("AudioJsPlugin", "startRecord() begin");
      this.startRecordReq = paramRequestEvent;
      this.isRecordManagerApi = paramBoolean;
      if ((this.recorder != null) && (this.recorder.isRecording()))
      {
        QMLog.i("AudioJsPlugin", "startRecord() is recording now");
        return;
      }
      Object localObject = Environment.getExternalStorageDirectory();
      int i;
      if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
      {
        i = 1;
        if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
          break label182;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = DeviceInfoUtil.getSDCardMemory();
          if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
          {
            if (AudioHelper.isForbidByRubbishMeizu(1))
            {
              QMLog.i("AudioJsPlugin", "startRecord() " + this.context.getString(R.string.mini_sdk_microphone_forbidden));
              paramRequestEvent.fail();
              return;
              i = 0;
              break;
              label182:
              i = 0;
              continue;
            }
            QMLog.d("AudioJsPlugin", "startRecord() is called");
            if (this.recorder == null) {
              this.recorder = getLameMp3Recorder();
            }
            paramRequestEvent = this.recorder.getRecordFilPath();
            QMLog.i("AudioJsPlugin", "path: " + paramRequestEvent);
            ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.context, true);
            this.recorder.recordStart();
            setFateOfRecorder(0);
            return;
          }
          QMLog.d("AudioJsPlugin", "startRecord() " + this.context.getString(R.string.mini_sdk_sdcard_full_no_send));
          paramRequestEvent.fail();
          return;
        }
      }
      QMLog.w("AudioJsPlugin", "startRecord() " + this.context.getString(R.string.mini_sdk_nosdcardnosend));
      paramRequestEvent.fail();
    }
    
    public void stopRecord(int paramInt, RequestEvent paramRequestEvent, boolean paramBoolean)
    {
      this.isRecordManagerApi = paramBoolean;
      this.stopRecordReq = paramRequestEvent;
      if (this.recorder != null)
      {
        this.recorder.recordStop();
        paramRequestEvent.ok();
        return;
      }
      paramRequestEvent.fail();
    }
    
    public void stopVoice(RequestEvent paramRequestEvent)
    {
      if (this.recorder != null)
      {
        this.recorder.playStop();
        paramRequestEvent.ok();
        return;
      }
      paramRequestEvent.fail();
    }
  }
  
  static class BgMusicData
  {
    public final JSONObject jsonObject;
    public final RequestEvent req;
    
    private BgMusicData(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
    {
      this.jsonObject = paramJSONObject;
      this.req = paramRequestEvent;
    }
  }
  
  class BgMusicManager
  {
    private static final int MSG_GET_MUSIC_PLAYER_STATE = 5;
    private static final int MSG_PAUSE = 2;
    private static final int MSG_PLAY = 1;
    private static final int MSG_SEEK = 4;
    private static final int MSG_STOP = 3;
    private MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    
    private BgMusicManager()
    {
      this.musicPlayerProxy.init(AudioJsPlugin.this.mMusicPlayerListener, AudioJsPlugin.this.mMiniAppInfo.appId, AudioJsPlugin.this.mMiniAppInfo.name);
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
    
    private void getMusicPlayerState(RequestEvent paramRequestEvent)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (AudioJsPlugin.this.getCurrentSongInfo() != null)
        {
          localJSONObject.put("currentPosition", AudioJsPlugin.this.mSecToSec(AudioJsPlugin.access$4300(AudioJsPlugin.this)));
          localJSONObject.put("duration", AudioJsPlugin.this.mSecToSec(AudioJsPlugin.access$4500(AudioJsPlugin.this)));
          localJSONObject.put("status", convertState(AudioJsPlugin.this.mPlayState));
          localJSONObject.put("dataUrl", AudioJsPlugin.this.getCurrentSongInfo().url);
          paramRequestEvent.ok(localJSONObject);
          return;
        }
        paramRequestEvent.fail();
        return;
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
      }
    }
    
    private void pauseQQMusic(RequestEvent paramRequestEvent)
    {
      MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
      AudioJsPlugin.access$602(AudioJsPlugin.this, paramRequestEvent);
      try
      {
        localMusicPlayerProxy.pause();
        return;
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
      }
    }
    
    private void playNew(JSONObject paramJSONObject)
      throws RemoteException
    {
      MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
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
      localMusicPlayerProxy.setPlayMode(100);
      localMusicPlayerProxy.startPlay(new SongInfo[] { localSongInfo }, 0);
    }
    
    private void playQQMusic(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
    {
      MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
      if ((!localMusicPlayerProxy.isInit()) || (paramJSONObject == null)) {
        paramRequestEvent.fail();
      }
      do
      {
        return;
        AudioJsPlugin.access$602(AudioJsPlugin.this, paramRequestEvent);
        try
        {
          SongInfo localSongInfo = localMusicPlayerProxy.getCurrentSong();
          String str = paramJSONObject.optString("dataUrl", paramJSONObject.optString("src"));
          if ((localSongInfo == null) || (!str.equals(localSongInfo.url))) {
            break;
          }
          if ((AudioJsPlugin.this.mPlayState == 3) || (AudioJsPlugin.this.mPlayState == 1))
          {
            localMusicPlayerProxy.resume();
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          paramRequestEvent.fail();
          return;
        }
      } while ((AudioJsPlugin.this.mPlayState != 4) && (AudioJsPlugin.this.mPlayState != 0) && (AudioJsPlugin.this.mPlayState != 8));
      playNew(paramJSONObject);
      return;
      playNew(paramJSONObject);
    }
    
    private void seekMusic(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
    {
      float f2 = 0.0F;
      if ((this.musicPlayerProxy != null) && (paramJSONObject != null)) {
        try
        {
          String str = paramJSONObject.optString("position");
          paramJSONObject = paramJSONObject.optString("currentTime");
          float f1;
          if (TextUtils.isEmpty(str))
          {
            f1 = 0.0F;
            if (!TextUtils.isEmpty(paramJSONObject)) {
              break label131;
            }
          }
          for (;;)
          {
            int i = (int)(Math.max(f1, f2) * 1000.0F);
            if (i < 0) {
              break label143;
            }
            AudioJsPlugin.this.evaluateBgAudioStateJs("waiting");
            AudioJsPlugin.this.evaluateBgAudioStateJs("seeking");
            this.musicPlayerProxy.seekTo(i);
            paramRequestEvent.ok();
            AudioJsPlugin.this.evaluateBgAudioStateJs("seeked");
            AudioJsPlugin.this.evaluateBgAudioStateJs("play");
            return;
            f1 = Float.valueOf(str).floatValue();
            break;
            label131:
            f2 = Float.valueOf(paramJSONObject).floatValue();
          }
          label143:
          paramRequestEvent.fail();
          return;
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          QMLog.e("AudioJsPlugin", "seekMusic error. " + paramJSONObject);
          paramRequestEvent.fail();
        }
      }
    }
    
    private void stopQQmMusic(RequestEvent paramRequestEvent)
    {
      MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
      AudioJsPlugin.access$602(AudioJsPlugin.this, paramRequestEvent);
      try
      {
        localMusicPlayerProxy.stop();
        return;
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
      }
    }
    
    public void handleMessage(int paramInt, RequestEvent paramRequestEvent)
    {
      handleMessage(paramInt, paramRequestEvent, null);
    }
    
    public void handleMessage(int paramInt, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        playQQMusic(paramJSONObject, paramRequestEvent);
        AudioJsPlugin.access$4002(AudioJsPlugin.this, new AudioJsPlugin.BgMusicData(paramJSONObject, paramRequestEvent, null));
        return;
      case 2: 
        pauseQQMusic(paramRequestEvent);
        AudioJsPlugin.access$4002(AudioJsPlugin.this, null);
        return;
      case 3: 
        stopQQmMusic(paramRequestEvent);
        AudioJsPlugin.access$4002(AudioJsPlugin.this, null);
        return;
      case 4: 
        seekMusic(paramJSONObject, paramRequestEvent);
        return;
      }
      getMusicPlayerState(paramRequestEvent);
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
      AudioJsPlugin.this.sendSubscribeEvent("onAudioStateChange", paramString.toString());
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
          AudioJsPlugin.this.sendSubscribeEvent("onAudioStateChange", localJSONObject.toString());
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
        if (!TextUtils.isEmpty(str)) {}
      }
      else
      {
        return;
      }
      if (this.mPlayer == null) {
        this.mPlayer = new MiniAppAudioPlayer(ThreadManager.getSubThreadHandler());
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
      this.mPlayer.setAudioContext(AppLoaderFactory.g().getContext());
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
      QMLog.i("AudioJsPlugin", "onPlayerSeek Completed : " + paramBoolean + "; position : " + paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin
 * JD-Core Version:    0.7.0.1
 */