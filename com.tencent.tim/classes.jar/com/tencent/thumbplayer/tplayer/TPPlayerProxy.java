package com.tencent.thumbplayer.tplayer;

import android.os.ParcelFileDescriptor;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPThreadAnnotations;
import com.tencent.thumbplayer.utils.TPThreadSwitch;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TPPlayerProxy
  implements InvocationHandler
{
  private TPPlayer mPlayer;
  private TPThreadSwitch mSwitch;
  
  public TPPlayerProxy(TPPlayer paramTPPlayer)
  {
    this.mPlayer = paramTPPlayer;
    this.mSwitch = new TPThreadSwitch(this.mPlayer.getTag(), this.mPlayer.getLooper(), this.mPlayer);
  }
  
  private Object[] beforeSetDataSource(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject[0] != null) && ((paramArrayOfObject[0] instanceof ParcelFileDescriptor))) {}
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)paramArrayOfObject[0];
      paramArrayOfObject[0] = ParcelFileDescriptor.fromFd(localParcelFileDescriptor.detachFd());
      localParcelFileDescriptor.close();
      return paramArrayOfObject;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.mPlayer.getTag(), "setDataSource, fromFd has exception:" + localException.toString());
    }
    return paramArrayOfObject;
  }
  
  private Object dealThreadSwitch(Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    String str = paramMethod.getName();
    Object[] arrayOfObject = paramArrayOfObject;
    if (str.equals("setDataSource")) {
      arrayOfObject = beforeSetDataSource(paramArrayOfObject);
    }
    if (paramMethod.getReturnType().getName().equals("void"))
    {
      this.mSwitch.dealThreadSwitch(str, arrayOfObject);
      return null;
    }
    paramMethod = this.mSwitch.dealThreadSwitchWithResult(str, arrayOfObject);
    TPLogUtil.i(this.mPlayer.getTag(), "dealThreadSwitch: " + str + ", var count:" + getVarCount(arrayOfObject) + ", result:" + paramMethod);
    return paramMethod;
  }
  
  private int getVarCount(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return 0;
    }
    return paramArrayOfObject.length;
  }
  
  private boolean isNeedSwitchThread(Method paramMethod, Object[] paramArrayOfObject)
  {
    return TPThreadAnnotations.getMethod(this.mPlayer.getClass(), paramMethod.getName(), paramArrayOfObject) != null;
  }
  
  public Object getProxyInstance()
  {
    return Proxy.newProxyInstance(this.mPlayer.getClass().getClassLoader(), this.mPlayer.getClass().getInterfaces(), this);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    if (!isNeedSwitchThread(paramMethod, paramArrayOfObject)) {
      return paramMethod.invoke(this.mPlayer, paramArrayOfObject);
    }
    return dealThreadSwitch(paramMethod, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayerProxy
 * JD-Core Version:    0.7.0.1
 */