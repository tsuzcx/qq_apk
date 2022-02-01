package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Observable;
import java.util.Observer;

public class AppRuntimeEventCenter
  extends Observable
{
  public static final String TAG = "minisdk-start_AppStateManager";
  
  public void notifyChange(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    QMLog.d("minisdk-start_AppStateManager", "notifyChange msg=" + paramObject);
    setChanged();
    if (paramObject != null)
    {
      notifyObservers(paramObject);
      return;
    }
    notifyObservers();
  }
  
  public static class MiniAppStateMessage
  {
    public BaseRuntimeLoader appRuntimeLoader;
    public Object obj;
    public int what;
    
    public MiniAppStateMessage(int paramInt, BaseRuntimeLoader paramBaseRuntimeLoader)
    {
      this.what = paramInt;
      this.appRuntimeLoader = paramBaseRuntimeLoader;
    }
    
    public static MiniAppStateMessage obtainMessage(int paramInt, BaseRuntimeLoader paramBaseRuntimeLoader)
    {
      return new MiniAppStateMessage(paramInt, paramBaseRuntimeLoader);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("{RuntimeLoader(");
      if (this.appRuntimeLoader != null)
      {
        localObject = this.appRuntimeLoader.getClass().getSimpleName();
        localStringBuilder = localStringBuilder.append((String)localObject).append(")@");
        if (this.appRuntimeLoader == null) {
          break label99;
        }
      }
      label99:
      for (Object localObject = Integer.valueOf(this.appRuntimeLoader.hashCode());; localObject = "nil")
      {
        return localObject + this.appRuntimeLoader + " what=" + this.what + "}";
        localObject = "nil";
        break;
      }
    }
  }
  
  public static abstract class RuntimeStateObserver
    implements Observer
  {
    public abstract void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage);
    
    public void update(Observable paramObservable, Object paramObject)
    {
      if ((paramObject instanceof AppRuntimeEventCenter.MiniAppStateMessage)) {
        onStateChange((AppRuntimeEventCenter.MiniAppStateMessage)paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppRuntimeEventCenter
 * JD-Core Version:    0.7.0.1
 */