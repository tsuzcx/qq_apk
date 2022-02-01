package com.tencent.tissue.v8rt.engine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tissue.v8rt.anno.CallByNative;
import com.tencent.tissue.v8rt.anno.NotNull;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Engine
{
  public static final String ENGINE_ASSETS = "tv8rt";
  public static final int ENG_INIT_ERR = 100;
  public static final int ENG_INIT_ERR_LOAD_SO = 101;
  public static final int ENG_INIT_STATUS_OK = 0;
  public static final int ENG_INIT_STATUS_RELEASED = 1;
  public static final int ENG_INIT_STATUS_UNKNOWN = -1;
  public static final int ENG_NDK_INIT = 102;
  public static final String TAG = "TV8ENG";
  static InspectorBridge sInspectorBridge = null;
  private static Engine sInstance;
  private static Executor sIoExecutor;
  private boolean isEnableDebugger = false;
  private boolean isWaitForDebugger = false;
  public Context mContext = null;
  private V8JsRuntime mDefaultJsRuntime;
  public EnginePathProvider mEnginePathProvider = null;
  public int mInitStatus = -1;
  public boolean mIsEnableCodeCache = true;
  private LibLoader mLibLoader;
  private Map<Integer, V8JsRuntime> mV8RuntimeMap = new ConcurrentHashMap();
  private V8TimerThread mV8TimerThread;
  
  private void createApp()
  {
    long l = SystemClock.g().uptimeMillis();
    nativeInit(2500);
    this.mEnginePathProvider.copyEngineAssets("tv8rt", true);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.mV8TimerThread = new V8TimerThread(new Engine.1(this, localCountDownLatch));
    this.mV8TimerThread.start();
    try
    {
      localCountDownLatch.await();
      Logger.i("TV8ENG", "injectJS BaseLib cost time:" + (SystemClock.g().uptimeMillis() - l) + "ms");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  @CallByNative
  public static String getEngineJsPath(String paramString)
  {
    Logger.i("TV8ENG", "getEngineJsPath " + paramString);
    return getInstance().mEnginePathProvider.getEngineJSDir() + File.separator + paramString;
  }
  
  public static Engine getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new Engine();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static Executor getIoExecutor()
  {
    if (sIoExecutor == null) {
      sIoExecutor = Executors.newSingleThreadExecutor();
    }
    return sIoExecutor;
  }
  
  @CallByNative
  public static void handleJavaScriptException(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      Logger.e("Log", "js exception:\n" + paramArrayOfByte);
    }
  }
  
  public static int loadScriptPathWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalStateException("all parameter must not be null or empty");
    }
    return nativeLoadScriptPathWithCodeCache(paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int loadScriptStringWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalStateException("all parameter must not be null or empty");
    }
    return nativeLoadScriptStringWithCodeCache(paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static native int nativeCreateScriptEngine(InspectorBridge paramInspectorBridge);
  
  public static native void nativeDispose();
  
  public static native boolean nativeEnvInit();
  
  public static native void nativeFinalize();
  
  public static native String nativeGetVersion();
  
  public static native void nativeInit(int paramInt);
  
  public static native boolean nativeInjectConsole(int paramInt1, int paramInt2);
  
  public static native boolean nativeInjectJsBridge(int paramInt1, int paramInt2);
  
  public static native boolean nativeInjectNativeBuffer(int paramInt1, int paramInt2);
  
  public static native boolean nativeInjectTimer(int paramInt1, int paramInt2);
  
  public static native int nativeLoadScriptPathWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3);
  
  public static native int nativeLoadScriptStringWithCodeCache(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3);
  
  public static native long nativeOnVSync(long paramLong);
  
  public static native void nativeSaveScriptCodeCache();
  
  @CallByNative
  public static String onScriptCall(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return V8JsBridge.onScriptCall(new String(paramArrayOfByte1), new String(paramArrayOfByte2), paramInt1, paramInt2);
  }
  
  @CallByNative
  public static String onScriptPublish(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    return V8JsBridge.onScriptPublish(new String(paramArrayOfByte1), new String(paramArrayOfByte2), new String(paramArrayOfByte3), paramInt);
  }
  
  public static native boolean runLoop();
  
  public static void setIoExecutor(Executor paramExecutor)
  {
    if (sIoExecutor != null) {
      Logger.i("TV8ENG", "setIoExecutor " + paramExecutor);
    }
    sIoExecutor = paramExecutor;
  }
  
  public static native void stopLoop();
  
  /* Error */
  public V8JsRuntime createJsRuntime()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 61	com/tencent/tissue/v8rt/engine/Engine:mInitStatus	I
    //   10: ifeq +36 -> 46
    //   13: ldc 27
    //   15: new 123	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 256
    //   25: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 61	com/tencent/tissue/v8rt/engine/Engine:mInitStatus	I
    //   32: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 192	com/tencent/tissue/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: areturn
    //   46: aload_0
    //   47: getfield 74	com/tencent/tissue/v8rt/engine/Engine:isEnableDebugger	Z
    //   50: ifeq +31 -> 81
    //   53: getstatic 55	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   56: ifnonnull +25 -> 81
    //   59: new 6	com/tencent/tissue/v8rt/engine/Engine$InspectorBridge
    //   62: dup
    //   63: new 261	com/tencent/tissue/v8rt/debug/WebSocketServerInspectAgent
    //   66: dup
    //   67: aload_0
    //   68: getfield 76	com/tencent/tissue/v8rt/engine/Engine:isWaitForDebugger	Z
    //   71: invokespecial 264	com/tencent/tissue/v8rt/debug/WebSocketServerInspectAgent:<init>	(Z)V
    //   74: aconst_null
    //   75: invokespecial 267	com/tencent/tissue/v8rt/engine/Engine$InspectorBridge:<init>	(Lcom/tencent/tissue/v8rt/engine/IInspectorAgent;Lcom/tencent/tissue/v8rt/engine/Engine$1;)V
    //   78: putstatic 55	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   81: ldc 27
    //   83: new 123	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 269
    //   93: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 74	com/tencent/tissue/v8rt/engine/Engine:isEnableDebugger	Z
    //   100: invokevirtual 272	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   103: ldc_w 274
    //   106: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 76	com/tencent/tissue/v8rt/engine/Engine:isWaitForDebugger	Z
    //   113: invokevirtual 272	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   116: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 145	com/tencent/tissue/v8rt/engine/Logger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   122: pop
    //   123: getstatic 55	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   126: invokestatic 276	com/tencent/tissue/v8rt/engine/Engine:nativeCreateScriptEngine	(Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;)I
    //   129: istore_1
    //   130: aload_3
    //   131: astore_2
    //   132: getstatic 55	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   135: ifnull +10 -> 145
    //   138: getstatic 55	com/tencent/tissue/v8rt/engine/Engine:sInspectorBridge	Lcom/tencent/tissue/v8rt/engine/Engine$InspectorBridge;
    //   141: invokevirtual 280	com/tencent/tissue/v8rt/engine/Engine$InspectorBridge:getInspectorAgent	()Lcom/tencent/tissue/v8rt/engine/IInspectorAgent;
    //   144: astore_2
    //   145: new 282	com/tencent/tissue/v8rt/engine/V8JsRuntime
    //   148: dup
    //   149: iload_1
    //   150: aload_2
    //   151: invokespecial 285	com/tencent/tissue/v8rt/engine/V8JsRuntime:<init>	(ILcom/tencent/tissue/v8rt/engine/IInspectorAgent;)V
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 65	com/tencent/tissue/v8rt/engine/Engine:mEnginePathProvider	Lcom/tencent/tissue/v8rt/engine/EnginePathProvider;
    //   159: aload_2
    //   160: invokevirtual 289	com/tencent/tissue/v8rt/engine/V8JsRuntime:getDefaultContext	()Lcom/tencent/tissue/v8rt/engine/V8JsContext;
    //   163: invokestatic 295	com/tencent/tissue/v8rt/engine/JsRuntimeLoader:initDefaultContext	(Lcom/tencent/tissue/v8rt/engine/EnginePathProvider;Lcom/tencent/tissue/v8rt/engine/V8JsContext;)Z
    //   166: pop
    //   167: aload_0
    //   168: getfield 70	com/tencent/tissue/v8rt/engine/Engine:mV8RuntimeMap	Ljava/util/Map;
    //   171: iload_1
    //   172: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aload_2
    //   176: invokeinterface 307 3 0
    //   181: pop
    //   182: goto -140 -> 42
    //   185: astore_2
    //   186: aload_0
    //   187: monitorexit
    //   188: aload_2
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	Engine
    //   129	43	1	i	int
    //   3	173	2	localObject1	Object
    //   185	4	2	localObject2	Object
    //   1	130	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	42	185	finally
    //   46	81	185	finally
    //   81	130	185	finally
    //   132	145	185	finally
    //   145	182	185	finally
  }
  
  public V8JsRuntime getJsRuntime()
  {
    try
    {
      if (this.mDefaultJsRuntime == null) {
        this.mDefaultJsRuntime = createJsRuntime();
      }
      V8JsRuntime localV8JsRuntime = this.mDefaultJsRuntime;
      return localV8JsRuntime;
    }
    finally {}
  }
  
  public V8JsRuntime getJsRuntime(int paramInt)
  {
    return (V8JsRuntime)this.mV8RuntimeMap.get(Integer.valueOf(paramInt));
  }
  
  public int getStatus()
  {
    return this.mInitStatus;
  }
  
  public Engine initEngine(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      if (this.mInitStatus == 0) {
        return this;
      }
      this.mContext = paramContext;
      this.mEnginePathProvider = new EnginePathProvider(paramContext);
      if (this.mLibLoader != null)
      {
        Logger.e("TV8ENG", "initEngine using libLoader " + this.mLibLoader);
        bool1 = this.mLibLoader.loadSo();
      }
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.mLibLoader = new DefaultSoLoader();
        bool2 = this.mLibLoader.loadSo();
      }
      if (!bool2)
      {
        Logger.e("TV8ENG", "initEngine loadSo fail!");
        this.mInitStatus = 101;
        return this;
      }
    }
    finally {}
    Logger.i("TV8ENG", "initEngine version : " + nativeGetVersion());
    if (!nativeEnvInit())
    {
      Logger.e("TV8ENG", "initEngine nativeEnvInit fail!");
      this.mInitStatus = 102;
      return this;
    }
    createApp();
    this.mInitStatus = 0;
    return this;
  }
  
  public void release()
  {
    this.mInitStatus = 1;
  }
  
  public void removeJsRuntime(V8JsRuntime paramV8JsRuntime)
  {
    this.mV8RuntimeMap.remove(Integer.valueOf(paramV8JsRuntime.getId()));
  }
  
  public void saveScriptCodeCache()
  {
    if (this.mIsEnableCodeCache) {
      getIoExecutor().execute(new Engine.2(this));
    }
  }
  
  public void setDebuggerOption(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isEnableDebugger = paramBoolean1;
    this.isWaitForDebugger = paramBoolean2;
    Logger.i("TV8ENG", "setDebuggerOption:" + paramBoolean1 + "," + paramBoolean2);
  }
  
  public void setLibLoader(LibLoader paramLibLoader)
  {
    this.mLibLoader = paramLibLoader;
  }
  
  public static final class InspectorBridge
  {
    @CallByNative
    private final boolean isWaitForDebugger;
    private final IInspectorAgent mProxy;
    @CallByNative
    private final long nativeInstance;
    
    private InspectorBridge(IInspectorAgent paramIInspectorAgent)
    {
      this.mProxy = paramIInspectorAgent;
      this.nativeInstance = nativeCreate();
      this.isWaitForDebugger = paramIInspectorAgent.isWaitForDebugger();
      this.mProxy.setOnDebuggerMessageListener(new Engine.InspectorBridge.1(this));
    }
    
    private native long nativeCreate();
    
    private void sendMessageToDebugger(@NotNull String paramString)
    {
      try
      {
        this.mProxy.sendMessageToDebugger(paramString);
        return;
      }
      catch (Throwable paramString)
      {
        Logger.e("TV8ENG", "sendMessageToDebugger", paramString);
      }
    }
    
    private static native void sendMessageToEngine(long paramLong, String paramString);
    
    public IInspectorAgent getInspectorAgent()
    {
      return this.mProxy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.Engine
 * JD-Core Version:    0.7.0.1
 */