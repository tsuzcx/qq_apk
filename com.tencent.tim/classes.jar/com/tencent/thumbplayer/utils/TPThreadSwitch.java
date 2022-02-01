package com.tencent.thumbplayer.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class TPThreadSwitch
{
  private static final int API_CALL_TIME_OUT_MS = 500;
  private static final boolean ENV_DEBUG = false;
  private Class<?> mClass;
  private EventHandler mEventHandler;
  private Object mHandleListener;
  private TPReadWriteLock mLock;
  private String mLogTag;
  private Looper mLooper;
  
  public TPThreadSwitch(String paramString, Looper paramLooper, @NonNull Object paramObject)
  {
    this.mLogTag = paramString;
    this.mLooper = paramLooper;
    this.mLock = new TPReadWriteLock();
    this.mEventHandler = new EventHandler(this.mLooper, null);
    this.mHandleListener = paramObject;
    this.mClass = this.mHandleListener.getClass();
    if (!TPThreadAnnotations.register(this.mClass, 0))
    {
      TPLogUtil.e(this.mLogTag, "Register " + this.mClass.getName() + " @ThreadSwitch method failed, version: " + "2.20.0.1123");
      throw new RuntimeException("register @ThreadSwitch method failed, player can not work");
    }
  }
  
  private Object dealResult(String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1;
    }
    paramString = TPThreadAnnotations.getMethod(this.mClass, paramString, getMethodParams(paramObject2)).getReturnType().getName();
    if (paramString.equals("boolean")) {
      return Boolean.valueOf(false);
    }
    if (paramString.equals("int")) {
      return Integer.valueOf(0);
    }
    if (paramString.equals("long")) {
      return Long.valueOf(0L);
    }
    if (paramString.equals("float")) {
      return Float.valueOf(0.0F);
    }
    return null;
  }
  
  private Object[] getMethodParams(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof MessageParams))
    {
      paramObject = ((MessageParams)paramObject).params;
      if (paramObject == null) {}
      for (paramObject = null;; paramObject = (Object[])paramObject) {
        return paramObject;
      }
    }
    return (Object[])paramObject;
  }
  
  private void handleEventMessage(Message paramMessage)
  {
    if (this.mHandleListener == null)
    {
      TPLogUtil.e(this.mLogTag, "handle listener is null, return");
      return;
    }
    invokeMethod(paramMessage.what, paramMessage.obj);
  }
  
  private boolean internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (this.mEventHandler == null)
    {
      TPLogUtil.e(this.mLogTag, messageToCommand(paramInt1) + " , send failed , handler null");
      return false;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      TPLogUtil.e(this.mLogTag, messageToCommand(paramInt1) + ", send failed , params null");
      return false;
    }
    if (!this.mLooper.getThread().isAlive())
    {
      TPLogUtil.e(this.mLogTag, messageToCommand(paramInt1) + ", send failed , thread had dead");
      return false;
    }
    if (!isSameLooper()) {
      this.mLock.readLock().lock();
    }
    if (paramBoolean2) {
      this.mEventHandler.removeMessages(paramInt1);
    }
    Message localMessage = this.mEventHandler.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (isSameLooper()) {
      handleEventMessage(localMessage);
    }
    for (;;)
    {
      return true;
      this.mEventHandler.sendMessageDelayed(localMessage, paramLong);
      this.mLock.readLock().unlock();
    }
  }
  
  private boolean internalMessage(int paramInt, Object paramObject)
  {
    return internalMessage(paramInt, 0, 0, paramObject, false, false, 0L);
  }
  
  private Object internalMessageLock(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws Throwable
  {
    TPFutureResult localTPFutureResult = new TPFutureResult();
    MessageParams localMessageParams = new MessageParams(null);
    localMessageParams.params = paramObject;
    localMessageParams.result = localTPFutureResult;
    internalMessage(paramInt1, paramInt2, paramInt3, localMessageParams, paramBoolean1, paramBoolean2, paramLong);
    return localTPFutureResult.getResult(500L);
  }
  
  private void invokeMethod(int paramInt, Object paramObject)
  {
    TPFutureResult localTPFutureResult = null;
    if ((paramObject instanceof MessageParams)) {
      localTPFutureResult = ((MessageParams)paramObject).result;
    }
    Method localMethod = TPThreadAnnotations.getMethodByMsgId(this.mClass, paramInt);
    if (localMethod == null)
    {
      TPLogUtil.e(this.mLogTag, "invokeMethod, handle method name is empty, msg:" + paramInt);
      if (localTPFutureResult != null) {
        localTPFutureResult.setException(new RuntimeException("invokeMethod, handle method name is empty"));
      }
    }
    label239:
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (localMethod.getParameterTypes().length == 0)
          {
            paramObject = localMethod.invoke(this.mHandleListener, new Object[0]);
            if (localTPFutureResult == null) {
              continue;
            }
            localTPFutureResult.setResult(paramObject);
          }
        }
        catch (InvocationTargetException paramObject)
        {
          for (;;)
          {
            TPLogUtil.e(this.mLogTag, "invokeMethod " + localMethod.getName() + " has excecption: " + paramObject.getTargetException().toString());
            if (localTPFutureResult == null) {
              break;
            }
            if (!(paramObject.getTargetException() instanceof IllegalArgumentException)) {
              break label239;
            }
            localTPFutureResult.setException(new IllegalArgumentException("invokeMethod " + localMethod.getName() + " failed, params invalid", paramObject.getCause()));
            return;
            paramObject = getMethodParams(paramObject);
            paramObject = localMethod.invoke(this.mHandleListener, paramObject);
          }
          if ((paramObject.getTargetException() instanceof IllegalStateException))
          {
            localTPFutureResult.setException(new IllegalStateException("invokeMethod " + localMethod.getName() + " failed, state invalid", paramObject.getCause()));
            return;
          }
          localTPFutureResult.setException(paramObject.getTargetException());
          return;
        }
        catch (Exception paramObject)
        {
          TPLogUtil.e(this.mLogTag, "invokeMethod " + localMethod.getName() + " has excecption: " + paramObject.toString());
        }
      }
    } while (localTPFutureResult == null);
    localTPFutureResult.setException(paramObject);
  }
  
  private boolean isSameLooper()
  {
    return Looper.myLooper() == this.mLooper;
  }
  
  private String messageToCommand(int paramInt)
  {
    String str2 = TPThreadAnnotations.getApi(this.mClass, paramInt);
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!str2.equals("unknown")) {}
    }
    else
    {
      str1 = paramInt + " not find";
    }
    return str1;
  }
  
  private void recycle()
  {
    this.mEventHandler.removeCallbacksAndMessages(null);
  }
  
  public Object dealThreadSwitch(String paramString, Object paramObject)
    throws Throwable
  {
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.e(this.mLogTag, "dealThreadSwitch failed , methodName is null");
      throw new RuntimeException("dealThreadSwitch failed , methodName is null");
    }
    Object[] arrayOfObject = getMethodParams(paramObject);
    int i = TPThreadAnnotations.getMethodMsgId(this.mClass, paramString, arrayOfObject);
    if (i < 0)
    {
      TPLogUtil.e(this.mLogTag, "dealThreadSwitch failed , not match method:" + paramString);
      throw new RuntimeException("dealThreadSwitch failed , not match method:" + paramString);
    }
    boolean bool1 = TPThreadAnnotations.removeRepeat(this.mClass, i);
    boolean bool2 = TPThreadAnnotations.checkObj(this.mClass, i);
    if (TPThreadAnnotations.isNeedWait(this.mClass, i)) {
      return internalMessageLock(i, 0, 0, paramObject, bool2, bool1, 0L);
    }
    internalMessage(i, 0, 0, paramObject, bool2, bool1, 0L);
    return null;
  }
  
  public Object dealThreadSwitchWithResult(String paramString, Object paramObject)
    throws Throwable
  {
    return dealResult(paramString, dealThreadSwitch(paramString, paramObject), paramObject);
  }
  
  class EventHandler
    extends Handler
  {
    private EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      TPThreadSwitch.this.handleEventMessage(paramMessage);
    }
  }
  
  static class MessageParams
  {
    Object params;
    TPFutureResult result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPThreadSwitch
 * JD-Core Version:    0.7.0.1
 */