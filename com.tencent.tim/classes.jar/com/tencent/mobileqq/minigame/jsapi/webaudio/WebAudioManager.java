package com.tencent.mobileqq.minigame.jsapi.webaudio;

import android.support.annotation.RequiresApi;
import aqgz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class WebAudioManager
{
  public static int SCRIPT_PROCESSOR_AUDIO_NODE_TYPE = 5;
  private static WebAudioManager mInstance;
  private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(aqgz.getCpuNumber(), aqgz.getCpuNumber() + 5, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  private ArrayList<Integer> audioBufferList = new ArrayList();
  private AudioContext audioContext;
  private HashMap<Integer, AudioContext> audioContextHashMap = new HashMap();
  private HashMap<Integer, ArrayList<Integer>> decodeBufferIdArrayMap = new HashMap();
  private HashMap<Integer, DecodeAsPlayStatus> decodeBufferIdStatusMap = new HashMap();
  private IAudioNativeManager mAudioNativeManager;
  public AtomicInteger sId = new AtomicInteger();
  private boolean scriptNodeHasStarted;
  private HashMap<Integer, Integer> scriptProcessNodeSizeMap = new HashMap();
  
  public static WebAudioManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new WebAudioManager();
    }
    return mInstance;
  }
  
  private void startTimer(JsRuntime paramJsRuntime, int paramInt1, int paramInt2)
  {
    if (this.mAudioNativeManager == null) {
      return;
    }
    paramJsRuntime = new WebAudioManager.3(this, paramInt1, paramInt2, paramJsRuntime);
    ThreadManager.getSubThreadHandler().post(paramJsRuntime);
  }
  
  public void closeAudioContext(int paramInt)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt));
    if (localAudioContext != null) {
      localAudioContext.stopAllChannels();
    }
    this.audioContextHashMap.remove(Integer.valueOf(paramInt));
    this.decodeBufferIdArrayMap.clear();
    this.decodeBufferIdStatusMap.clear();
  }
  
  public void closeAudioContext(ITTEngine paramITTEngine)
  {
    if (this.mAudioNativeManager == null) {}
    while ((paramITTEngine == null) || (!paramITTEngine.getOptionalSoLoadStatus("webAudio")) || (this.audioContextHashMap.isEmpty())) {
      return;
    }
    this.mAudioNativeManager.closeAudioContext();
    this.audioContextHashMap.clear();
    this.decodeBufferIdArrayMap.clear();
    this.decodeBufferIdStatusMap.clear();
  }
  
  public int copyToChannel(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mAudioNativeManager == null) {
      return -1;
    }
    return this.mAudioNativeManager.copyToChannel(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public JSONObject createAudioContext(String paramString)
  {
    if (this.mAudioNativeManager == null) {
      return null;
    }
    int i = this.sId.incrementAndGet();
    this.audioContext = new AudioContext(this.mAudioNativeManager);
    this.audioContextHashMap.put(Integer.valueOf(i), this.audioContext);
    paramString = new JSONObject();
    try
    {
      paramString.put("audioId", i);
      return paramString;
    }
    catch (Throwable localThrowable) {}
    return paramString;
  }
  
  public JSONObject createBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mAudioNativeManager == null) {
      return null;
    }
    if ((AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1)) == null) {
      return null;
    }
    paramInt1 = this.mAudioNativeManager.createBuffer(paramInt2, paramInt3 * paramInt2 * 2, paramInt4);
    this.audioBufferList.add(Integer.valueOf(paramInt1));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bufferId", paramInt1);
      return localJSONObject;
    }
    catch (Throwable localThrowable) {}
    return localJSONObject;
  }
  
  public JSONObject createBufferSource(int paramInt)
  {
    Object localObject = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      return null;
    }
    paramInt = ((AudioContext)localObject).createBufferSource();
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("channelId", paramInt);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return localObject;
  }
  
  public void createScriptProcessor(JsRuntime paramJsRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mAudioNativeManager == null) {
      return;
    }
    paramInt2 *= paramInt4;
    this.mAudioNativeManager.createScriptProcessorNode(paramInt2, paramInt3, paramInt4);
    this.scriptProcessNodeSizeMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  @RequiresApi(api=16)
  public void decodeAudioDataAndReturnBufferIdAsync(int paramInt, byte[] paramArrayOfByte, JsRuntime paramJsRuntime)
  {
    if (this.mAudioNativeManager == null) {
      return;
    }
    threadPoolExecutor.execute(new WebAudioManager.5(this, paramInt, paramJsRuntime, paramArrayOfByte));
  }
  
  public double getAudioContextCurrentTime(int paramInt)
  {
    if (this.audioContextHashMap.get(Integer.valueOf(paramInt)) != null) {
      return ((AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt))).getCurrentTime() / 1000.0D;
    }
    return -1.0D;
  }
  
  public byte[] getBufferChannelData(int paramInt1, int paramInt2)
  {
    if (this.mAudioNativeManager == null) {
      return null;
    }
    return this.mAudioNativeManager.getBufferChannelData(paramInt1, paramInt2);
  }
  
  public float getCurrentGain(int paramInt1, int paramInt2)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return -1.0F;
    }
    return localAudioContext.getCurrentGain(paramInt2);
  }
  
  public void resumeAudioContext(ITTEngine paramITTEngine)
  {
    if (this.mAudioNativeManager == null) {}
    while ((paramITTEngine == null) || (!paramITTEngine.getOptionalSoLoadStatus("webAudio")) || (this.audioContextHashMap.isEmpty())) {
      return;
    }
    this.mAudioNativeManager.resumeAudioContext();
  }
  
  public void setAudioNativeManager(ITTEngine paramITTEngine)
  {
    if ((this.mAudioNativeManager == null) && (paramITTEngine != null) && (paramITTEngine.getOptionalSoLoadStatus("webAudio"))) {
      this.mAudioNativeManager = paramITTEngine.getAudioNativeManager();
    }
  }
  
  public void setBufferSourceLoop(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return;
    }
    localAudioContext.setBufferSourceLoop(paramInt2, paramBoolean);
  }
  
  public void setCurrentGain(int paramInt1, int paramInt2, double paramDouble)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return;
    }
    localAudioContext.setCurrentGain(paramInt2, paramDouble);
  }
  
  public JSONObject setDecodingQueueBuffer(int paramInt1, int paramInt2)
  {
    if (this.mAudioNativeManager == null) {
      return null;
    }
    for (;;)
    {
      synchronized (mInstance)
      {
        Object localObject1;
        if ((this.decodeBufferIdStatusMap != null) && (this.decodeBufferIdStatusMap.containsKey(Integer.valueOf(paramInt2))))
        {
          localObject1 = (DecodeAsPlayStatus)this.decodeBufferIdStatusMap.get(Integer.valueOf(paramInt2));
          if ((localObject1 != null) && (this.decodeBufferIdArrayMap != null) && (this.decodeBufferIdArrayMap.containsKey(Integer.valueOf(paramInt2))))
          {
            localObject2 = (ArrayList)this.decodeBufferIdArrayMap.get(Integer.valueOf(paramInt2));
            if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {}
          }
        }
        switch (((DecodeAsPlayStatus)localObject1).status)
        {
        case 3: 
          return new JSONObject();
          localObject1 = ((ArrayList)localObject2).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          paramInt2 = ((Integer)((Iterator)localObject1).next()).intValue();
          this.mAudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
        }
      }
      Object localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramInt2 = ((Integer)((Iterator)localObject2).next()).intValue();
        this.mAudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
      }
      DecodeAsPlayStatus.access$502(localDecodeAsPlayStatus, 2);
      localDecodeAsPlayStatus.channelIdList.add(Integer.valueOf(paramInt1));
    }
  }
  
  public void setQueueBuffer(int paramInt1, int paramInt2)
  {
    if (this.mAudioNativeManager == null) {
      return;
    }
    this.mAudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
    if (!this.scriptNodeHasStarted) {
      this.mAudioNativeManager.play(-2, 0.0F);
    }
    this.scriptNodeHasStarted = true;
  }
  
  public JSONObject setSourceBuffer(int paramInt1, int paramInt2)
  {
    if (this.mAudioNativeManager == null) {
      return null;
    }
    this.mAudioNativeManager.bindBufferToSource(paramInt2, paramInt1);
    return new JSONObject();
  }
  
  public JSONObject sourceStart(JsRuntime paramJsRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mAudioNativeManager == null) {
      return null;
    }
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return null;
    }
    long l2 = localAudioContext.getCurrentTime();
    long l1 = paramInt3 * 1000 - l2;
    if (l1 > 0L)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new WebAudioManager.1(this, paramInt2, paramInt4, paramJsRuntime, paramInt1), l1);
      if (l1 <= 0L) {
        break label161;
      }
    }
    label161:
    for (l1 = paramInt3 * 1000;; l1 = l2)
    {
      if (paramInt5 > 0) {
        ThreadManager.getSubThreadHandler().postDelayed(new WebAudioManager.2(this, paramInt2), l1 - l2 + paramInt5 * 1000);
      }
      return new JSONObject();
      this.mAudioNativeManager.play(paramInt2, paramInt4);
      startTimer(paramJsRuntime, paramInt2, paramInt1);
      break;
    }
  }
  
  public JSONObject sourceStop(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mAudioNativeManager == null) {
      return null;
    }
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return null;
    }
    long l = localAudioContext.getCurrentTime();
    l = paramInt3 * 1000 - l;
    if (l > 0L) {
      ThreadManager.getSubThreadHandler().postDelayed(new WebAudioManager.4(this, paramInt2), l);
    }
    for (;;)
    {
      return new JSONObject();
      this.mAudioNativeManager.stopSource(paramInt2);
    }
  }
  
  public void startAudioProcess(JsRuntime paramJsRuntime, int paramInt)
  {
    if (this.mAudioNativeManager == null) {
      return;
    }
    paramJsRuntime = new WebAudioManager.6(this, paramJsRuntime, ((Integer)this.scriptProcessNodeSizeMap.get(Integer.valueOf(paramInt))).intValue() * 2 * 60 / 44100);
    ThreadManager.getSubThreadHandler().post(paramJsRuntime);
  }
  
  public void suspendAudioContext(ITTEngine paramITTEngine)
  {
    if (this.mAudioNativeManager == null) {}
    while ((paramITTEngine == null) || (!paramITTEngine.getOptionalSoLoadStatus("webAudio")) || (this.audioContextHashMap.isEmpty())) {
      return;
    }
    this.mAudioNativeManager.suspendAudioContext();
  }
  
  class DecodeAsPlayStatus
  {
    public static final int STATUS_DECODE_DONE = 3;
    public static final int STATUS_DECODING_WITHOUT_SET_QUEUE = 1;
    public static final int STATUS_DECODING_WITH_ALREADY_SETTED_QUEUE = 2;
    public static final int STATUS_INIT = 0;
    private ArrayList<Integer> channelIdList = new ArrayList();
    private int decodeId = -1;
    private int status = 0;
    
    public DecodeAsPlayStatus() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager
 * JD-Core Version:    0.7.0.1
 */