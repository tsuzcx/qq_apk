package com.idlefish.flutterboost;

import android.app.Activity;
import android.content.Intent;
import com.idlefish.flutterboost.containers.FlutterSplashView;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import java.util.HashMap;
import java.util.Map;

public class ContainerRecord
  implements IContainerRecord
{
  private final IFlutterViewContainer mContainer;
  private final FlutterViewContainerManager mManager;
  private MethodChannelProxy mProxy = new MethodChannelProxy(null);
  private int mState = 0;
  private final String mUniqueId;
  
  ContainerRecord(FlutterViewContainerManager paramFlutterViewContainerManager, IFlutterViewContainer paramIFlutterViewContainer)
  {
    Map localMap = paramIFlutterViewContainer.getContainerUrlParams();
    if ((localMap != null) && (localMap.containsKey("__container_uniqueId_key__"))) {}
    for (this.mUniqueId = String.valueOf(localMap.get("__container_uniqueId_key__"));; this.mUniqueId = genUniqueId(this))
    {
      this.mManager = paramFlutterViewContainerManager;
      this.mContainer = paramIFlutterViewContainer;
      return;
    }
  }
  
  public static String genUniqueId(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("-");
    localStringBuilder.append(paramObject.hashCode());
    return localStringBuilder.toString();
  }
  
  public IFlutterViewContainer getContainer()
  {
    return this.mContainer;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAppear()
  {
    
    if ((this.mState != 1) && (this.mState != 3)) {
      Debuger.exception("state error");
    }
    this.mState = 2;
    this.mManager.pushRecord(this);
    this.mProxy.appear();
    this.mContainer.getBoostFlutterView().onAttach();
  }
  
  public void onBackPressed()
  {
    
    if ((this.mState == 0) || (this.mState == 4)) {
      Debuger.exception("state error");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "backPressedCallback");
    localHashMap.put("name", this.mContainer.getContainerUrl());
    localHashMap.put("uniqueId", this.mUniqueId);
    FlutterBoost.instance().channel().sendEvent("lifecycle", localHashMap);
  }
  
  public void onContainerResult(int paramInt1, int paramInt2, Map<String, Object> paramMap)
  {
    this.mManager.setContainerResult(this, paramInt1, paramInt2, paramMap);
  }
  
  public void onCreate()
  {
    
    if (this.mState != 0) {
      Debuger.exception("state error");
    }
    this.mState = 1;
    this.mProxy.create();
  }
  
  public void onDestroy()
  {
    
    if (this.mState != 3) {
      Debuger.exception("state error");
    }
    this.mState = 4;
    this.mProxy.destroy();
    this.mManager.removeRecord(this);
    this.mManager.setContainerResult(this, -1, -1, null);
    this.mManager.hasContainerAppear();
  }
  
  public void onDisappear()
  {
    
    if (this.mState != 2) {
      Debuger.exception("state error");
    }
    this.mState = 3;
    this.mProxy.disappear();
    if (getContainer().getContextActivity().isFinishing()) {
      this.mProxy.destroy();
    }
    this.mContainer.getBoostFlutterView().onDetach();
    this.mManager.popRecord(this);
  }
  
  public void onLowMemory() {}
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onTrimMemory(int paramInt) {}
  
  public void onUserLeaveHint() {}
  
  public String uniqueId()
  {
    return this.mUniqueId;
  }
  
  class MethodChannelProxy
  {
    private int mState = 0;
    
    private MethodChannelProxy() {}
    
    private void appear()
    {
      invokeChannelUnsafe("didShowPageContainer", ContainerRecord.this.mContainer.getContainerUrl(), ContainerRecord.this.mContainer.getContainerUrlParams(), ContainerRecord.this.mUniqueId);
      this.mState = 2;
    }
    
    private void create()
    {
      if (this.mState == 0)
      {
        invokeChannelUnsafe("didInitPageContainer", ContainerRecord.this.mContainer.getContainerUrl(), ContainerRecord.this.mContainer.getContainerUrlParams(), ContainerRecord.this.mUniqueId);
        this.mState = 1;
      }
    }
    
    private void destroy()
    {
      if (this.mState < 4)
      {
        invokeChannel("willDeallocPageContainer", ContainerRecord.this.mContainer.getContainerUrl(), ContainerRecord.this.mContainer.getContainerUrlParams(), ContainerRecord.this.mUniqueId);
        this.mState = 4;
      }
    }
    
    private void disappear()
    {
      if (this.mState < 3)
      {
        invokeChannel("didDisappearPageContainer", ContainerRecord.this.mContainer.getContainerUrl(), ContainerRecord.this.mContainer.getContainerUrlParams(), ContainerRecord.this.mUniqueId);
        this.mState = 3;
      }
    }
    
    public void invokeChannel(String paramString1, String paramString2, Map paramMap, String paramString3)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pageName", paramString2);
      localHashMap.put("params", paramMap);
      localHashMap.put("uniqueId", paramString3);
      FlutterBoost.instance().channel().invokeMethod(paramString1, localHashMap);
    }
    
    public void invokeChannelUnsafe(String paramString1, String paramString2, Map paramMap, String paramString3)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pageName", paramString2);
      localHashMap.put("params", paramMap);
      localHashMap.put("uniqueId", paramString3);
      FlutterBoost.instance().channel().invokeMethodUnsafe(paramString1, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.ContainerRecord
 * JD-Core Version:    0.7.0.1
 */