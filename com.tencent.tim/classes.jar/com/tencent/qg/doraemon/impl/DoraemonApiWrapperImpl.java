package com.tencent.qg.doraemon.impl;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import asgd;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper;
import com.tencent.qg.sdk.doraemon.MyApiCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tzg;
import tzk;

public class DoraemonApiWrapperImpl
  extends DoraemonApiWrapper
{
  public static final String TAG = "DoraemonApiWrapperImpl";
  private Activity mActivity;
  private tzg mCurrentManager;
  public Map<String, tzg> mDoraemonAPIManagerMap;
  private boolean mHasInit;
  private QGGLSurfaceView mQGGLSurfaceView;
  
  public DoraemonApiWrapperImpl(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void call(String paramString1, String paramString2, long paramLong)
  {
    QLog.d("DoraemonApiWrapperImpl", 1, new Object[] { "call. apiName", paramString1 });
    if (this.mCurrentManager == null)
    {
      QLog.e("DoraemonApiWrapperImpl", 1, "manager not set");
      return;
    }
    MyApiCallback localMyApiCallback = new MyApiCallback(paramLong);
    for (;;)
    {
      try
      {
        tzg localtzg = this.mCurrentManager;
        if (paramString2 != null) {
          break label92;
        }
        paramString2 = null;
        localtzg.a(paramString1, paramString2, new asgd(this, localMyApiCallback, paramString1));
        return;
      }
      catch (JSONException paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("DoraemonApiWrapperImpl", 1, "call json exception");
      return;
      label92:
      paramString2 = new JSONObject(paramString2);
    }
  }
  
  public tzg getDoraemonApiManager(String paramString)
  {
    if (this.mDoraemonAPIManagerMap == null) {
      return null;
    }
    return (tzg)this.mDoraemonAPIManagerMap.get(paramString);
  }
  
  public void init()
  {
    if (!this.mHasInit)
    {
      tzk.prepare();
      attachNative();
      this.mHasInit = true;
    }
  }
  
  public void release()
  {
    super.release();
    if (this.mDoraemonAPIManagerMap != null)
    {
      Iterator localIterator = this.mDoraemonAPIManagerMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (tzg)this.mDoraemonAPIManagerMap.get(localObject);
        if (localObject != null) {
          ((tzg)localObject).release();
        }
      }
      this.mDoraemonAPIManagerMap.clear();
    }
    this.mActivity = null;
  }
  
  public void setDoraemonApiManager(@NonNull String paramString)
  {
    if ((this.mCurrentManager != null) && (TextUtils.equals(this.mCurrentManager.mAppid, paramString))) {}
    do
    {
      return;
      if (this.mDoraemonAPIManagerMap == null) {
        this.mDoraemonAPIManagerMap = new ConcurrentHashMap();
      }
      this.mCurrentManager = ((tzg)this.mDoraemonAPIManagerMap.get(paramString));
    } while (this.mCurrentManager != null);
    this.mCurrentManager = tzk.a(this.mActivity, 3, paramString);
    this.mDoraemonAPIManagerMap.put(paramString, this.mCurrentManager);
  }
  
  public void setQGGLSurfaceView(QGGLSurfaceView paramQGGLSurfaceView)
  {
    this.mQGGLSurfaceView = paramQGGLSurfaceView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl
 * JD-Core Version:    0.7.0.1
 */