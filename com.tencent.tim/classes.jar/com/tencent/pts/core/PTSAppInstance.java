package com.tencent.pts.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.jni.PTSJsJniHandler;
import com.tencent.pts.core.jni.PTSLiteJniHandler;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteBridge;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PTSAppInstance
{
  private static final AtomicInteger NEXT_ID = new AtomicInteger(1);
  private static final String TAG = "PTSAppInstance";
  private float containerWidth;
  private Context context;
  private String frameTreeJson;
  private PTSItemData itemData;
  private String pageJs;
  private String pageName;
  private PTSRootNode rootNode;
  private int rootNodeType;
  private ViewGroup rootView;
  private int uniqueId = NEXT_ID.getAndIncrement();
  
  private void init(int paramInt)
  {
    this.rootNode = new PTSRootNode(this, this.rootView, paramInt);
    initPTSAppInstance(this.frameTreeJson, this.pageJs);
  }
  
  public void addOnRecyclerViewScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.rootNode.addOnRecyclerViewScrollListener(paramOnScrollListener);
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public PTSItemData getItemData()
  {
    return this.itemData;
  }
  
  public PTSJSBridge getJsBridge()
  {
    return null;
  }
  
  public PTSLiteBridge getLiteBridge()
  {
    return null;
  }
  
  public String getPageName()
  {
    return this.pageName;
  }
  
  public PTSRootNode getRootNode()
  {
    return this.rootNode;
  }
  
  public int getRootNodeType()
  {
    return this.rootNodeType;
  }
  
  public float getRootViewWidth()
  {
    if (this.containerWidth > 0.0F) {
      return this.containerWidth;
    }
    return PTSDeviceUtil.getScreenWidthDp();
  }
  
  float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return PTSNodeFactory.getTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4);
  }
  
  public int getUniqueID()
  {
    return this.uniqueId;
  }
  
  abstract void initPTSAppInstance(String paramString1, String paramString2);
  
  public boolean isJsAppInstance()
  {
    return this instanceof PTSJsAppInstance;
  }
  
  public boolean isLiteAppInstance()
  {
    return this instanceof PTSLiteAppInstance;
  }
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    PTSLog.i("PTSAppInstance", "[onDestroy], destroy PTSJNIHandler.");
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void setItemData(PTSItemData paramPTSItemData)
  {
    this.itemData = paramPTSItemData;
  }
  
  public static class Builder
  {
    private float containerWidth;
    private Context context;
    private String frameTreeJson;
    private PTSItemData itemData;
    private IPTSLiteEventListener liteEventListener;
    private PTSLiteItemViewManager liteItemViewManager;
    private String pageJs;
    private String pageName;
    private PTSJSBridge ptsJSBridge;
    private int rootNodeType;
    private ViewGroup rootView;
    
    private void check()
    {
      if (TextUtils.isEmpty(this.pageName)) {
        throw new IllegalStateException("PTSAppInstance pageName is empty.");
      }
      if (TextUtils.isEmpty(this.frameTreeJson)) {
        throw new IllegalStateException("PTSAppInstance frameTreeJson is empty.");
      }
    }
    
    public PTSAppInstance build()
    {
      Object localObject;
      if (this.ptsJSBridge != null)
      {
        localObject = new PTSAppInstance.PTSJsAppInstance(null);
        PTSAppInstance.PTSJsAppInstance.access$200((PTSAppInstance.PTSJsAppInstance)localObject, this.ptsJSBridge);
      }
      for (;;)
      {
        PTSAppInstance.access$602((PTSAppInstance)localObject, this.context);
        PTSAppInstance.access$702((PTSAppInstance)localObject, this.rootView);
        PTSAppInstance.access$802((PTSAppInstance)localObject, this.rootNodeType);
        PTSAppInstance.access$902((PTSAppInstance)localObject, this.pageName);
        PTSAppInstance.access$1002((PTSAppInstance)localObject, this.itemData);
        PTSAppInstance.access$1102((PTSAppInstance)localObject, this.frameTreeJson);
        PTSAppInstance.access$1202((PTSAppInstance)localObject, this.pageJs);
        PTSAppInstance.access$1302((PTSAppInstance)localObject, this.containerWidth);
        check();
        ((PTSAppInstance)localObject).init(this.rootNodeType);
        return localObject;
        localObject = new PTSAppInstance.PTSLiteAppInstance(null);
        PTSAppInstance.PTSLiteAppInstance.access$400((PTSAppInstance.PTSLiteAppInstance)localObject, this.liteItemViewManager);
        PTSAppInstance.PTSLiteAppInstance.access$500((PTSAppInstance.PTSLiteAppInstance)localObject, this.liteEventListener);
      }
    }
    
    public Builder withContainerWidth(float paramFloat)
    {
      this.containerWidth = paramFloat;
      return this;
    }
    
    public Builder withContext(Context paramContext)
    {
      this.context = paramContext;
      return this;
    }
    
    public Builder withFrameTreeJson(String paramString)
    {
      this.frameTreeJson = paramString;
      return this;
    }
    
    public Builder withItemData(PTSItemData paramPTSItemData)
    {
      this.itemData = paramPTSItemData;
      if (paramPTSItemData != null)
      {
        this.pageName = paramPTSItemData.getPageName();
        this.frameTreeJson = paramPTSItemData.getFrameTreeJson();
        this.pageJs = paramPTSItemData.getPageJs();
      }
      return this;
    }
    
    public Builder withLiteEventListener(IPTSLiteEventListener paramIPTSLiteEventListener)
    {
      this.liteEventListener = paramIPTSLiteEventListener;
      return this;
    }
    
    public Builder withLiteItemViewManager(PTSLiteItemViewManager paramPTSLiteItemViewManager)
    {
      this.liteItemViewManager = paramPTSLiteItemViewManager;
      return this;
    }
    
    public Builder withPTSJSBridge(PTSJSBridge paramPTSJSBridge)
    {
      this.ptsJSBridge = paramPTSJSBridge;
      return this;
    }
    
    public Builder withPageJs(String paramString)
    {
      this.pageJs = paramString;
      return this;
    }
    
    public Builder withPageName(String paramString)
    {
      this.pageName = paramString;
      return this;
    }
    
    public Builder withRootNodeType(int paramInt)
    {
      this.rootNodeType = paramInt;
      return this;
    }
    
    public Builder withRootView(ViewGroup paramViewGroup)
    {
      this.rootView = paramViewGroup;
      return this;
    }
  }
  
  public static class PTSJsAppInstance
    extends PTSAppInstance
  {
    private PTSJSBridge ptsJsBridge;
    
    private PTSJsAppInstance()
    {
      super();
    }
    
    private void setJsBridge(PTSJSBridge paramPTSJSBridge)
    {
      this.ptsJsBridge = paramPTSJSBridge;
    }
    
    public PTSJSBridge getJsBridge()
    {
      return this.ptsJsBridge;
    }
    
    void initPTSAppInstance(String paramString1, String paramString2)
    {
      this.ptsJsBridge.initAppJSBundle(paramString1, paramString2, this);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      PTSJsJniHandler.destroy(this, this.ptsJsBridge.getJsEnvID());
      this.ptsJsBridge = null;
    }
    
    public void setItemData(PTSItemData paramPTSItemData)
    {
      super.setItemData(paramPTSItemData);
      this.ptsJsBridge.callOnLoadJsFunction(this);
    }
  }
  
  public static class PTSLiteAppInstance
    extends PTSAppInstance
  {
    private IPTSLiteEventListener liteEventListener;
    private PTSLiteItemViewManager liteItemViewManager;
    private PTSLiteBridge ptsLiteBridge = new PTSLiteBridge();
    
    private PTSLiteAppInstance()
    {
      super();
    }
    
    private void setLiteEventListener(IPTSLiteEventListener paramIPTSLiteEventListener)
    {
      this.liteEventListener = paramIPTSLiteEventListener;
    }
    
    private void setLiteItemViewManager(PTSLiteItemViewManager paramPTSLiteItemViewManager)
    {
      this.liteItemViewManager = paramPTSLiteItemViewManager;
    }
    
    public PTSLiteBridge getLiteBridge()
    {
      return this.ptsLiteBridge;
    }
    
    public IPTSLiteEventListener getLiteEventListener()
    {
      return this.liteEventListener;
    }
    
    public PTSLiteItemViewManager getLiteItemViewManager()
    {
      return this.liteItemViewManager;
    }
    
    void initPTSAppInstance(String paramString1, String paramString2)
    {
      this.ptsLiteBridge.initAppLiteBundle(paramString1, this);
      this.ptsLiteBridge.setData(getItemData(), this);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      PTSLiteJniHandler.destroy(this);
      this.liteItemViewManager = null;
      this.liteEventListener = null;
    }
    
    public void setItemData(PTSItemData paramPTSItemData)
    {
      super.setItemData(paramPTSItemData);
      this.ptsLiteBridge.setData(getItemData(), this);
    }
    
    public void triggerLiteEvent(int paramInt, String paramString, HashMap<String, String> paramHashMap, View paramView)
    {
      if (this.liteEventListener == null)
      {
        PTSLog.i("PTSAppInstance", "[triggerLiteEvent], liteEventListener is null.");
        return;
      }
      switch (paramInt)
      {
      default: 
        PTSLog.i("PTSAppInstance", "[triggerLiteEvent] unknown, eventType = " + paramInt);
        return;
      case 1: 
        this.liteEventListener.onTapEventTriggered(paramString, paramHashMap, paramView);
        return;
      }
      this.liteEventListener.onExposureTriggered(paramString, paramHashMap, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance
 * JD-Core Version:    0.7.0.1
 */