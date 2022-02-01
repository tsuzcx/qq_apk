package com.tencent.intervideo.nowproxy.ability;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.QQKandianInterface;
import com.tencent.intervideo.nowproxy.common.NowThreadPool.ThreadPoolProvider;
import com.tencent.intervideo.nowproxy.common.login.LoginObserver;
import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedRecord;
import com.tencent.intervideo.nowproxy.qqshare.CustomizedShareForQQ;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.IHostCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

public class SdkBizAbilityImpl
{
  public static SdkBizAbilityImpl sInstance = new SdkBizAbilityImpl();
  protected Bundle customiseByHost = new Bundle();
  Map<Long, ActionCallback> mActionCallbacks = new HashMap();
  AtomicLong mActionSeq = new AtomicLong(1000L);
  CustomizedRecord mCustomRecord;
  CustomizedShareForQQ mCustomizedShareToQQ;
  IHostCallback mHostCallBack;
  LoginObserver mLoginObserver;
  QQKandianInterface mQQKandianInterface;
  NowThreadPool.ThreadPoolProvider mThreadPoolProvider;
  
  public static SdkBizAbilityImpl getInstance()
  {
    return sInstance;
  }
  
  public ExecutorService getFixedThreadPool(int paramInt)
  {
    if (this.mThreadPoolProvider != null) {
      return this.mThreadPoolProvider.getFixedThreadPool(paramInt);
    }
    return null;
  }
  
  public LoginObserver getLoginObserver()
  {
    return this.mLoginObserver;
  }
  
  public void getRecordInfo(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    if (this.mCustomRecord != null) {
      this.mCustomRecord.getRecordInfo(paramBundle, paramCommonCallback);
    }
  }
  
  public void jumpToKandianBiu(Bundle paramBundle)
  {
    this.mQQKandianInterface.jumpToKandianBiu(paramBundle);
  }
  
  public void notifyLoadingCancel()
  {
    if (this.mHostCallBack != null) {
      this.mHostCallBack.notifyLoadingActivityBackPress();
    }
  }
  
  public void onDoActionResult(long paramLong, String paramString)
  {
    if (paramLong != 0L)
    {
      ActionCallback localActionCallback = (ActionCallback)this.mActionCallbacks.remove(Long.valueOf(paramLong));
      if (localActionCallback != null) {
        localActionCallback.onResult(paramString);
      }
    }
  }
  
  public void onLoginExpired(int paramInt)
  {
    this.mLoginObserver.onLoginDataInvalid(paramInt);
  }
  
  public void onNoLogin()
  {
    this.mLoginObserver.onNoLogin();
  }
  
  public long putActionCallback(ActionCallback paramActionCallback)
  {
    if (paramActionCallback != null)
    {
      long l = this.mActionSeq.incrementAndGet();
      this.mActionCallbacks.put(Long.valueOf(l), paramActionCallback);
      return l;
    }
    return 0L;
  }
  
  public void setCustomRecord(CustomizedRecord paramCustomizedRecord)
  {
    this.mCustomRecord = paramCustomizedRecord;
  }
  
  public void setCustomShareForQQ(CustomizedShareForQQ paramCustomizedShareForQQ)
  {
    this.mCustomizedShareToQQ = paramCustomizedShareForQQ;
  }
  
  public void setHostCallBack(IHostCallback paramIHostCallback)
  {
    this.mHostCallBack = paramIHostCallback;
  }
  
  public void setLoginObserver(LoginObserver paramLoginObserver)
  {
    this.mLoginObserver = paramLoginObserver;
  }
  
  public void setQQKandianInterface(QQKandianInterface paramQQKandianInterface)
  {
    this.mQQKandianInterface = paramQQKandianInterface;
  }
  
  public void setThreadPoolProvider(NowThreadPool.ThreadPoolProvider paramThreadPoolProvider)
  {
    this.mThreadPoolProvider = paramThreadPoolProvider;
  }
  
  public void shareToQQ(Bundle paramBundle)
  {
    this.mCustomizedShareToQQ.shareToQQ(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.ability.SdkBizAbilityImpl
 * JD-Core Version:    0.7.0.1
 */