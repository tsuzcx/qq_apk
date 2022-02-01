package retrofit;

import android.os.Build.VERSION;
import com.google.gson.Gson;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import retrofit.android.AndroidApacheClient;
import retrofit.android.AndroidLog;
import retrofit.android.MainThreadExecutor;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.UrlConnectionClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

abstract class Platform
{
  static final boolean HAS_RX_JAVA = hasRxJavaOnClasspath();
  private static final Platform PLATFORM = ;
  
  private static Platform findPlatform()
  {
    try
    {
      Class.forName("android.os.Build");
      if (Build.VERSION.SDK_INT != 0)
      {
        Android localAndroid = new Android(null);
        return localAndroid;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return new Base(null);
  }
  
  static Platform get()
  {
    return PLATFORM;
  }
  
  private static boolean hasOkHttpOnClasspath()
  {
    try
    {
      Class.forName("com.squareup.okhttp.OkHttpClient");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private static boolean hasRxJavaOnClasspath()
  {
    try
    {
      Class.forName("rx.Observable");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  abstract Executor defaultCallbackExecutor();
  
  abstract Client defaultClient();
  
  abstract Converter defaultConverter();
  
  abstract Executor defaultHttpExecutor();
  
  abstract RestAdapter.Log defaultLog();
  
  static class Android
    extends Platform
  {
    Executor defaultCallbackExecutor()
    {
      return new MainThreadExecutor();
    }
    
    Client defaultClient()
    {
      if (Platform.access$200()) {
        return Platform.OkClientInstantiator.instantiate();
      }
      if (Build.VERSION.SDK_INT < 9) {
        return new AndroidApacheClient();
      }
      return new UrlConnectionClient();
    }
    
    Converter defaultConverter()
    {
      return new GsonConverter(new Gson());
    }
    
    Executor defaultHttpExecutor()
    {
      return Executors.newCachedThreadPool(new Platform.Android.1(this));
    }
    
    RestAdapter.Log defaultLog()
    {
      return new AndroidLog("Retrofit");
    }
  }
  
  static class Base
    extends Platform
  {
    Executor defaultCallbackExecutor()
    {
      return new Utils.SynchronousExecutor();
    }
    
    Client defaultClient()
    {
      if (Platform.access$200()) {
        return Platform.OkClientInstantiator.instantiate();
      }
      return new UrlConnectionClient();
    }
    
    Converter defaultConverter()
    {
      return new GsonConverter(new Gson());
    }
    
    Executor defaultHttpExecutor()
    {
      return Executors.newCachedThreadPool(new Platform.Base.1(this));
    }
    
    RestAdapter.Log defaultLog()
    {
      return new Platform.Base.2(this);
    }
  }
  
  static class OkClientInstantiator
  {
    static Client instantiate()
    {
      return new OkClient();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.Platform
 * JD-Core Version:    0.7.0.1
 */