package com.tencent.qqmini.miniapp.widget.media.live;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TXLivePushListenerReflect
{
  public static final String ITXLIVE_PUSHER_LISTENER_CLASS_NAME = "com.tencent.rtmp.ITXLivePushListener";
  public static final String ITXSNAP_SHOT_LISTENER_CLASS_NAME = "com.tencent.rtmp.TXLivePusher$ITXSnapshotListener";
  public static final String ON_BGM_NOTIFY_CLASS_NAME = "com.tencent.rtmp.TXLivePusher$OnBGMNotify";
  private static final String TAG = "TXLivePushListenerRefle";
  
  public static Object newITXLivePushListener(ITXLivePushListener paramITXLivePushListener)
  {
    try
    {
      ClassLoader localClassLoader = TXLiveConstantsReflect.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.ITXLivePushListener");
      paramITXLivePushListener = new TXLivePushListenerInvocationHandler(paramITXLivePushListener);
      paramITXLivePushListener = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, paramITXLivePushListener);
      return paramITXLivePushListener;
    }
    catch (ClassNotFoundException paramITXLivePushListener)
    {
      QMLog.e("TXLivePushListenerRefle", "newInstance", paramITXLivePushListener);
    }
    return null;
  }
  
  public static Object newITXSnapshotListener(ITXSnapshotListener paramITXSnapshotListener)
  {
    try
    {
      ClassLoader localClassLoader = TXLiveConstantsReflect.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener");
      paramITXSnapshotListener = new ITXSnapshotListenerInvocationHandler(paramITXSnapshotListener);
      paramITXSnapshotListener = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, paramITXSnapshotListener);
      return paramITXSnapshotListener;
    }
    catch (ClassNotFoundException paramITXSnapshotListener)
    {
      QMLog.e("TXLivePushListenerRefle", "newInstance", paramITXSnapshotListener);
    }
    return null;
  }
  
  public static Object newOnBGMNotify(OnBGMNotify paramOnBGMNotify)
  {
    try
    {
      ClassLoader localClassLoader = TXLiveConstantsReflect.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify");
      paramOnBGMNotify = new OnBGMNotifyInvocationHandler(paramOnBGMNotify);
      paramOnBGMNotify = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, paramOnBGMNotify);
      return paramOnBGMNotify;
    }
    catch (ClassNotFoundException paramOnBGMNotify)
    {
      QMLog.e("TXLivePushListenerRefle", "newInstance", paramOnBGMNotify);
    }
    return null;
  }
  
  public static abstract interface ITXLivePushListener
  {
    public abstract void onNetStatus(Bundle paramBundle);
    
    public abstract void onPushEvent(int paramInt, Bundle paramBundle);
  }
  
  public static abstract interface ITXSnapshotListener
  {
    public abstract void onSnapshot(Bitmap paramBitmap);
  }
  
  static class ITXSnapshotListenerInvocationHandler
    implements InvocationHandler
  {
    private TXLivePushListenerReflect.ITXSnapshotListener listener;
    
    public ITXSnapshotListenerInvocationHandler(TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener)
    {
      this.listener = paramITXSnapshotListener;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      QMLog.e("TXLivePushListenerRefle", "ITXSnapshotListenerInvocationHandler invoke:" + paramMethod.getName());
      if (Object.class.equals(paramMethod.getDeclaringClass())) {
        try
        {
          paramObject = paramMethod.invoke(this, paramArrayOfObject);
          return paramObject;
        }
        catch (Throwable paramObject)
        {
          QMLog.e("TXLivePushListenerRefle", "invoke", paramObject);
        }
      }
      if (("onSnapshot".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Bitmap)) && (this.listener != null)) {
        this.listener.onSnapshot((Bitmap)paramArrayOfObject[0]);
      }
      return null;
    }
  }
  
  public static abstract interface OnBGMNotify
  {
    public abstract void onBGMComplete(int paramInt);
    
    public abstract void onBGMProgress(long paramLong1, long paramLong2);
    
    public abstract void onBGMStart();
  }
  
  static class OnBGMNotifyInvocationHandler
    implements InvocationHandler
  {
    private TXLivePushListenerReflect.OnBGMNotify listener;
    
    public OnBGMNotifyInvocationHandler(TXLivePushListenerReflect.OnBGMNotify paramOnBGMNotify)
    {
      this.listener = paramOnBGMNotify;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      QMLog.e("TXLivePushListenerRefle", "OnBGMNotifyInvocationHandler invoke:" + paramMethod.getName());
      if (Object.class.equals(paramMethod.getDeclaringClass())) {
        try
        {
          paramObject = paramMethod.invoke(this, paramArrayOfObject);
          return paramObject;
        }
        catch (Throwable paramObject)
        {
          QMLog.e("TXLivePushListenerRefle", "invoke", paramObject);
        }
      }
      if ("onBGMStart".equals(paramMethod.getName())) {
        if (this.listener != null) {
          this.listener.onBGMStart();
        }
      }
      for (;;)
      {
        if (("onBGMComplete".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Integer)) && (this.listener != null)) {
          this.listener.onBGMComplete(((Integer)paramArrayOfObject[0]).intValue());
        }
        return null;
        if (("onBGMProgress".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 2) && ((paramArrayOfObject[0] instanceof Long)) && ((paramArrayOfObject[1] instanceof Long)) && (this.listener != null)) {
          this.listener.onBGMProgress(((Long)paramArrayOfObject[0]).longValue(), ((Long)paramArrayOfObject[1]).longValue());
        }
      }
    }
  }
  
  static class TXLivePushListenerInvocationHandler
    implements InvocationHandler
  {
    private TXLivePushListenerReflect.ITXLivePushListener listener;
    
    public TXLivePushListenerInvocationHandler(TXLivePushListenerReflect.ITXLivePushListener paramITXLivePushListener)
    {
      this.listener = paramITXLivePushListener;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      QMLog.e("TXLivePushListenerRefle", "TXLivePushListenerInvocationHandler invoke:" + paramMethod.getName());
      if (Object.class.equals(paramMethod.getDeclaringClass())) {
        try
        {
          paramObject = paramMethod.invoke(this, paramArrayOfObject);
          return paramObject;
        }
        catch (Throwable paramObject)
        {
          QMLog.e("TXLivePushListenerRefle", "invoke", paramObject);
        }
      }
      if ("onNetStatus".equals(paramMethod.getName())) {
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Bundle)))
        {
          paramObject = (Bundle)paramArrayOfObject[0];
          if (QMLog.isColorLevel()) {
            QMLog.e("TXLivePushListenerRefle", "onNetStatus params:" + paramObject.toString());
          }
          if (this.listener != null) {
            this.listener.onNetStatus(paramObject);
          }
        }
      }
      for (;;)
      {
        return null;
        if (("onPushEvent".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
        {
          if (((paramArrayOfObject[0] instanceof Integer)) && ((paramArrayOfObject[1] instanceof Bundle)))
          {
            if (QMLog.isColorLevel()) {
              QMLog.e("TXLivePushListenerRefle", "onPushEvent code:" + paramArrayOfObject[0]);
            }
            if (this.listener != null) {
              this.listener.onPushEvent(((Integer)paramArrayOfObject[0]).intValue(), (Bundle)paramArrayOfObject[1]);
            }
          }
          if ((paramArrayOfObject[1] instanceof Bundle))
          {
            paramObject = (Bundle)paramArrayOfObject[1];
            if (QMLog.isColorLevel()) {
              QMLog.e("TXLivePushListenerRefle", "onPushEvent params:" + paramObject.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePushListenerReflect
 * JD-Core Version:    0.7.0.1
 */