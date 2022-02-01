package com.tencent.aladdin.config;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.aladdin.config.network.AladdinConfigVersionManager;
import com.tencent.aladdin.config.network.AladdinRequestHandler;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;
import com.tencent.aladdin.config.parse.AladdinConfigParser;
import com.tencent.aladdin.config.parse.SimpleObjectParser;
import com.tencent.aladdin.config.parse.SimpleParser;
import com.tencent.aladdin.config.utils.AladdinLogger;
import com.tencent.aladdin.config.utils.DeviceInfoUtils;
import com.tencent.aladdin.config.utils.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Aladdin
{
  private static final AsyncTaskExecutor DEFAULT_EXECUTOR;
  private static final AladdinConfigHandler DEFAULT_SIMPLE_CONFIG_HANDLER;
  public static final AladdinConfigParser DEFAULT_SIMPLE_OBJECT_PARSER = new SimpleObjectParser(sBeanTypeMap);
  private static final AladdinConfigParser DEFAULT_SIMPLE_PARSER;
  private static String ROOT_DIR = null;
  private static final String TAG = "Aladdin";
  private static String sAppFlavorId;
  private static Integer sAppId;
  private static String sAppVersion;
  private static final Map<String, Class<?>> sBeanTypeMap;
  private static final SparseArrayCompat<AladdinConfigHandler> sConfigHandlerMap;
  private static final SparseArrayCompat<AladdinConfigParser> sConfigParserMap;
  private static AsyncTaskExecutor sExecutor = null;
  private static AladdinLogger sLogger;
  private static AladdinRequestHandler sRequestHandler = null;
  private static final Map<String, AladdinUserConfig> sUserConfigCache;
  private static String sUserId = null;
  
  static
  {
    sAppId = null;
    sAppVersion = null;
    sLogger = null;
    sAppFlavorId = null;
    sUserConfigCache = new HashMap();
    DEFAULT_EXECUTOR = new Aladdin.1();
    sConfigParserMap = new SparseArrayCompat();
    DEFAULT_SIMPLE_PARSER = new SimpleParser();
    sConfigHandlerMap = new SparseArrayCompat();
    DEFAULT_SIMPLE_CONFIG_HANDLER = new SimpleConfigHandler();
    sBeanTypeMap = new HashMap();
  }
  
  private static void ensureExecutorNonNull()
  {
    if (sExecutor == null) {
      sExecutor = DEFAULT_EXECUTOR;
    }
  }
  
  @Deprecated
  public static AladdinConfig get(int paramInt)
  {
    return getConfig(paramInt);
  }
  
  public static String getAppFlavorId()
  {
    return sAppFlavorId;
  }
  
  public static Integer getAppId()
  {
    return sAppId;
  }
  
  public static String getAppVersion()
  {
    return sAppVersion;
  }
  
  static String getBasePath()
  {
    return withUserId(sUserId).getBasePath();
  }
  
  public static AladdinConfig getConfig(int paramInt)
  {
    return withUserId(sUserId).get(paramInt);
  }
  
  public static AladdinConfigHandler getConfigHandlerById(int paramInt)
  {
    synchronized (sConfigHandlerMap)
    {
      AladdinConfigHandler localAladdinConfigHandler = (AladdinConfigHandler)sConfigHandlerMap.get(paramInt);
      if (localAladdinConfigHandler == null)
      {
        localAladdinConfigHandler = DEFAULT_SIMPLE_CONFIG_HANDLER;
        return localAladdinConfigHandler;
      }
      return localAladdinConfigHandler;
    }
  }
  
  public static int[] getConfigIdList()
  {
    return withUserId(sUserId).getConfigIdList();
  }
  
  public static String getCurrentUserId()
  {
    return sUserId;
  }
  
  public static AladdinLogger getLogger()
  {
    return sLogger;
  }
  
  static AladdinConfigParser getParserById(int paramInt)
  {
    synchronized (sConfigParserMap)
    {
      AladdinConfigParser localAladdinConfigParser = (AladdinConfigParser)sConfigParserMap.get(paramInt);
      if (localAladdinConfigParser == null)
      {
        localAladdinConfigParser = DEFAULT_SIMPLE_PARSER;
        return localAladdinConfigParser;
      }
      return localAladdinConfigParser;
    }
  }
  
  public static AladdinConfigVersionManager getVersionManager()
  {
    return withUserId(sUserId).getVersionInfo();
  }
  
  public static void initialize(@NonNull InitParams paramInitParams)
  {
    if (!TextUtils.isEmpty(paramInitParams.rootDir))
    {
      ROOT_DIR = paramInitParams.rootDir;
      if (paramInitParams.executor == null) {
        break label149;
      }
      sExecutor = paramInitParams.executor;
      label31:
      if (paramInitParams.appId == null) {
        break label158;
      }
      sAppId = paramInitParams.appId;
      label45:
      if (paramInitParams.userId == null) {
        break label168;
      }
      sUserId = paramInitParams.userId;
      label59:
      if (paramInitParams.appFlavorId == null) {
        break label176;
      }
    }
    label149:
    label158:
    label168:
    label176:
    for (sAppFlavorId = paramInitParams.appFlavorId;; sAppFlavorId = "0")
    {
      sRequestHandler = paramInitParams.requestHandler;
      sAppVersion = paramInitParams.appVersion;
      sLogger = paramInitParams.logger;
      Log.i("Aladdin", "initialize: GitHash=4a875d8");
      DeviceInfoUtils.initDisplayParams(paramInitParams.context);
      return;
      ROOT_DIR = paramInitParams.context.getFilesDir().getAbsolutePath() + File.separator + "aladdin_configs";
      break;
      sExecutor = DEFAULT_EXECUTOR;
      break label31;
      sAppId = Integer.valueOf(0);
      break label45;
      sUserId = "0";
      break label59;
    }
  }
  
  public static void registerBeanClass(String paramString, Class<?> paramClass)
  {
    Log.d("Aladdin", "registerBeanClass: " + paramString);
    synchronized (sBeanTypeMap)
    {
      sBeanTypeMap.put(paramString, paramClass);
      return;
    }
  }
  
  public static void registerConfigHandler(int paramInt, @NonNull AladdinConfigHandler paramAladdinConfigHandler)
  {
    synchronized (sConfigHandlerMap)
    {
      sConfigHandlerMap.put(paramInt, paramAladdinConfigHandler);
      return;
    }
  }
  
  public static void registerConfigParser(int paramInt, @NonNull AladdinConfigParser paramAladdinConfigParser)
  {
    synchronized (sConfigParserMap)
    {
      sConfigParserMap.put(paramInt, paramAladdinConfigParser);
      return;
    }
  }
  
  public static void requestForUpdate(int[] paramArrayOfInt)
  {
    if (sRequestHandler != null)
    {
      sRequestHandler.requestForUpdate(paramArrayOfInt);
      return;
    }
    Log.e("Aladdin", "requestForUpdate: ", new IllegalStateException("sRequestHandler is null"));
  }
  
  private static AladdinUserConfig withUserId(String paramString)
  {
    AladdinUserConfig localAladdinUserConfig = (AladdinUserConfig)sUserConfigCache.get(paramString);
    Object localObject = localAladdinUserConfig;
    if (localAladdinUserConfig == null)
    {
      if ((ROOT_DIR == null) || (sExecutor == null) || (sRequestHandler == null))
      {
        localObject = new IllegalStateException("Aladdin.initialize() is not called!");
        if (Log.isDebugVersion()) {
          throw ((Throwable)localObject);
        }
        Log.e("Aladdin", "ROOT_DIR=" + ROOT_DIR + ", sExecutor=" + sExecutor + ", sRequestHandler=" + sRequestHandler, (Throwable)localObject);
        ensureExecutorNonNull();
      }
      localObject = new AladdinUserConfig(ROOT_DIR, paramString, sExecutor);
      sUserConfigCache.put(paramString, localObject);
    }
    return localObject;
  }
  
  public static class InitParams
  {
    @NonNull
    private String appFlavorId = "";
    @NonNull
    private Integer appId = Integer.valueOf(0);
    @NonNull
    private String appVersion = "";
    @NonNull
    private final Context context;
    private final AsyncTaskExecutor executor;
    private final AladdinLogger logger;
    @NonNull
    private final AladdinRequestHandler requestHandler;
    private final String rootDir;
    @NonNull
    private final String userId;
    
    private InitParams(Builder paramBuilder)
    {
      this.context = paramBuilder.context;
      this.rootDir = paramBuilder.rootDir;
      this.userId = paramBuilder.userId;
      this.appId = paramBuilder.appId;
      this.appVersion = paramBuilder.appVersion;
      this.executor = paramBuilder.executor;
      this.requestHandler = paramBuilder.requestHandler;
      this.logger = paramBuilder.logger;
      this.appFlavorId = paramBuilder.appFlavorId;
    }
    
    public static Builder newBuilder()
    {
      return new Builder(null);
    }
    
    public static final class Builder
    {
      private String appFlavorId;
      private Integer appId;
      private String appVersion;
      private Context context;
      private AsyncTaskExecutor executor;
      private AladdinLogger logger;
      private AladdinRequestHandler requestHandler;
      private String rootDir;
      private String userId;
      
      public Aladdin.InitParams build()
      {
        return new Aladdin.InitParams(this, null);
      }
      
      public Builder withAppFlavorId(String paramString)
      {
        this.appFlavorId = paramString;
        return this;
      }
      
      public Builder withAppId(Integer paramInteger)
      {
        this.appId = paramInteger;
        return this;
      }
      
      public Builder withAppVersion(String paramString)
      {
        this.appVersion = paramString;
        return this;
      }
      
      public Builder withContext(Context paramContext)
      {
        this.context = paramContext;
        return this;
      }
      
      public Builder withExecutor(AsyncTaskExecutor paramAsyncTaskExecutor)
      {
        this.executor = paramAsyncTaskExecutor;
        return this;
      }
      
      public Builder withLogger(AladdinLogger paramAladdinLogger)
      {
        this.logger = paramAladdinLogger;
        return this;
      }
      
      public Builder withRequestHandler(AladdinRequestHandler paramAladdinRequestHandler)
      {
        this.requestHandler = paramAladdinRequestHandler;
        return this;
      }
      
      public Builder withRootDir(String paramString)
      {
        this.rootDir = paramString;
        return this;
      }
      
      public Builder withUserId(String paramString)
      {
        this.userId = paramString;
        return this;
      }
    }
  }
  
  static class SimpleAsyncTask
    extends AsyncTask<Void, Void, Void>
  {
    private final Runnable task;
    
    private SimpleAsyncTask(Runnable paramRunnable)
    {
      this.task = paramRunnable;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      this.task.run();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.Aladdin
 * JD-Core Version:    0.7.0.1
 */