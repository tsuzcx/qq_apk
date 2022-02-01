package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.PTSLiteAppInstance;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.ui.PTSNodeAttribute;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.view.IView;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class PTSNodeVirtual<T extends View>
{
  protected final String TAG = getClass().getSimpleName();
  private PTSAppInstance mAppInstance;
  private List<PTSNodeVirtual> mChildren;
  private PTSNodeInfo mNodeInfo;
  private PTSNodeVirtual mParent;
  private T mView;
  private String mViewID;
  private View.OnClickListener onClickListener;
  private boolean reusable = true;
  
  protected PTSNodeVirtual(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance == null) {
      return;
    }
    this.mAppInstance = paramPTSAppInstance;
    this.mView = initView();
  }
  
  private void applyLayout()
  {
    ViewGroup.LayoutParams localLayoutParams = null;
    if (this.mView.getLayoutParams() != null) {
      localLayoutParams = this.mView.getLayoutParams();
    }
    Object localObject;
    if (localLayoutParams == null)
    {
      localObject = new ViewGroup.MarginLayoutParams(getWidth(), getHeight());
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(getLeft(), getTop(), 0, 0);
    }
    for (;;)
    {
      getView().setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.width = getWidth();
      localLayoutParams.height = getHeight();
      localObject = localLayoutParams;
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(getLeft(), getTop(), 0, 0);
        localObject = localLayoutParams;
      }
    }
  }
  
  private void bindAttributes(PTSNodeAttribute paramPTSNodeAttribute)
  {
    paramPTSNodeAttribute = paramPTSNodeAttribute.entrySet().iterator();
    while (paramPTSNodeAttribute.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramPTSNodeAttribute.next();
      setAttributes((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  private void bindExposeEvent() {}
  
  private void bindStyle(PTSNodeStyle paramPTSNodeStyle)
  {
    paramPTSNodeStyle = paramPTSNodeStyle.entrySet().iterator();
    while (paramPTSNodeStyle.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramPTSNodeStyle.next();
      setStyle((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  private void bindTapEvent()
  {
    PTSLog.i(this.TAG, "[bindTapEvent]");
    if (this.onClickListener == null) {
      this.onClickListener = new PTSNodeVirtual.1(this);
    }
    getView().setOnClickListener(this.onClickListener);
  }
  
  private void handleTapEvent()
  {
    Object localObject2 = null;
    PTSNodeInfo localPTSNodeInfo = getNodeInfo();
    if (localPTSNodeInfo == null)
    {
      PTSLog.i(this.TAG, "[handleTapEvent], nodeInfo is null.");
      return;
    }
    String str1;
    for (Object localObject1 = localPTSNodeInfo.getUniqueID();; str1 = null)
    {
      HashMap localHashMap;
      try
      {
        int j = Integer.parseInt((String)localObject1);
        String str2 = localPTSNodeInfo.getAttributes().getAttributeID();
        localHashMap = localPTSNodeInfo.getEventInfo();
        if ((localHashMap == null) || (localHashMap.size() <= 0)) {
          continue;
        }
        int i = localHashMap.size();
        localObject3 = new String[i];
        Object localObject4 = new String[i];
        Iterator localIterator = localHashMap.entrySet().iterator();
        i = 0;
        for (;;)
        {
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (Map.Entry)localIterator.next();
          localObject3[i] = ((String)((Map.Entry)localObject1).getKey());
          localObject4[i] = ((String)((Map.Entry)localObject1).getValue());
          i += 1;
        }
        if (this.mAppInstance.isJsAppInstance())
        {
          localObject3 = localPTSNodeInfo.getAttributes().getEventBindTap();
          localObject4 = this.mAppInstance.getJsBridge();
          if (localObject4 == null) {
            break;
          }
          ((PTSJSBridge)localObject4).callJSEventFunction((String)localObject3, j, "tap", str2, (String[])localObject1, (String[])localObject2, null, null, this.mAppInstance);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        PTSLog.e(this.TAG, "[handleTapEvent], e = " + localNumberFormatException);
        return;
      }
      if (!this.mAppInstance.isLiteAppInstance()) {
        break;
      }
      str1 = localPTSNodeInfo.getAttributes().getEventPtsOnTap();
      localObject2 = ((PTSAppInstance.PTSLiteAppInstance)this.mAppInstance).getLiteEventListener();
      Object localObject3 = ((PTSAppInstance.PTSLiteAppInstance)this.mAppInstance).getLiteItemViewManager();
      if (localObject3 != null)
      {
        ((PTSLiteItemViewManager)localObject3).triggerLiteEvent(1, str1, localHashMap, getView());
        return;
      }
      if (localObject2 == null) {
        break;
      }
      ((PTSAppInstance.PTSLiteAppInstance)this.mAppInstance).triggerLiteEvent(1, str1, localHashMap, getView());
      return;
    }
  }
  
  private T initView()
  {
    Object localObject = PTSNodeFactory.getNodeViewConstructor(getClass());
    if ((localObject == null) && (PTSLog.isDebug())) {
      throw new IllegalArgumentException("[initView] exception, className = " + getClass().getName());
    }
    try
    {
      localObject = (View)((Constructor)localObject).newInstance(new Object[] { this });
      return localObject;
    }
    catch (Exception localException)
    {
      if (PTSLog.isDebug()) {
        throw new IllegalArgumentException("[initView] exception, className = " + getClass().getName());
      }
    }
    return null;
  }
  
  private final void reset()
  {
    View localView = getView();
    localView.setBackgroundColor(0);
    if (!isContainer()) {
      localView.setPadding(0, 0, 0, 0);
    }
    setViewID("");
    if (localView.hasOnClickListeners()) {
      localView.setOnClickListener(null);
    }
    resetAll();
  }
  
  private void setAttributes(String paramString, Object paramObject)
  {
    if (!setAttribute(paramString, paramObject)) {
      setEventListener(paramString);
    }
  }
  
  private void setEventListener(String paramString)
  {
    if (("bindtap".equalsIgnoreCase(paramString)) || ("pts:on-tap".equalsIgnoreCase(paramString))) {
      bindTapEvent();
    }
    while (!"pts:on-exposure".equalsIgnoreCase(paramString)) {
      return;
    }
    bindExposeEvent();
  }
  
  private void setParent(PTSNodeVirtual paramPTSNodeVirtual)
  {
    this.mParent = paramPTSNodeVirtual;
  }
  
  public void addChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if ((isLeafNode()) || (!(this.mView instanceof ViewGroup))) {
      throw new IllegalStateException("can not add child for leaf node, or mView is not ViewGroup, nodeInfo = \n" + this.mNodeInfo.toString());
    }
    if (this.mChildren == null) {
      this.mChildren = new ArrayList();
    }
    if (paramPTSNodeVirtual == null)
    {
      PTSLog.e(this.TAG, "[addChild], the child is null.");
      return;
    }
    this.mChildren.add(paramPTSNodeVirtual);
    paramPTSNodeVirtual.setParent(this);
    ((ViewGroup)this.mView).addView(paramPTSNodeVirtual.getView());
  }
  
  protected void bindExtra(PTSNodeInfo paramPTSNodeInfo) {}
  
  public final void bindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo != null)
    {
      PTSTimeCostUtil.start("[bindNodeInfo]-" + paramPTSNodeInfo.getUniqueID());
      reset();
      this.mNodeInfo = paramPTSNodeInfo;
      bindStyle(paramPTSNodeInfo.getStyle());
      bindAttributes(paramPTSNodeInfo.getAttributes());
      bindExtra(paramPTSNodeInfo);
      applyLayout();
      if ((getView() instanceof IView)) {
        ((IView)getView()).onBindNodeInfo(paramPTSNodeInfo);
      }
      PTSTimeCostUtil.end("[bindNodeInfo]-" + paramPTSNodeInfo.getUniqueID());
    }
  }
  
  public PTSAppInstance getAppInstance()
  {
    return this.mAppInstance;
  }
  
  public List<PTSNodeVirtual> getChildren()
  {
    if (this.mChildren == null) {
      return new ArrayList();
    }
    return new ArrayList(this.mChildren);
  }
  
  public Context getContext()
  {
    return this.mAppInstance.getContext();
  }
  
  public int getHeight()
  {
    return this.mNodeInfo.getStyle().getHeight();
  }
  
  public int getLeft()
  {
    return this.mNodeInfo.getStyle().getLeft();
  }
  
  public int getMeasuredHeight()
  {
    return this.mView.getMeasuredHeight();
  }
  
  public int getMeasuredWidth()
  {
    return this.mView.getMeasuredWidth();
  }
  
  public PTSNodeInfo getNodeInfo()
  {
    return this.mNodeInfo;
  }
  
  public PTSNodeVirtual getParent()
  {
    return this.mParent;
  }
  
  public boolean getReusable()
  {
    return this.reusable;
  }
  
  public int getTop()
  {
    return this.mNodeInfo.getStyle().getTop();
  }
  
  public T getView()
  {
    return this.mView;
  }
  
  public String getViewID()
  {
    if (TextUtils.isEmpty(this.mViewID)) {
      return "";
    }
    return this.mViewID;
  }
  
  public int getVisibility()
  {
    return this.mView.getVisibility();
  }
  
  public int getWidth()
  {
    return this.mNodeInfo.getStyle().getWidth();
  }
  
  public void hideNode()
  {
    this.mView.setVisibility(8);
  }
  
  public boolean isContainer()
  {
    return this instanceof PTSNodeContainer;
  }
  
  public boolean isLeafNode()
  {
    return !isContainer();
  }
  
  public boolean isVisible()
  {
    return getVisibility() == 0;
  }
  
  public void removeChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if ((isLeafNode()) || (!(this.mView instanceof ViewGroup))) {
      throw new IllegalStateException("can not remove child for leaf node, or mView is not ViewGroup.");
    }
    if ((this.mChildren == null) || (paramPTSNodeVirtual == null)) {
      return;
    }
    this.mChildren.remove(paramPTSNodeVirtual);
    paramPTSNodeVirtual.setParent(null);
    ((ViewGroup)this.mView).removeView(paramPTSNodeVirtual.getView());
  }
  
  protected void resetAll() {}
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    if ("viewID".equalsIgnoreCase(paramString))
    {
      this.mViewID = PTSValueConvertUtil.getString(paramObject);
      return true;
    }
    return false;
  }
  
  public void setPTSAppInstance(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance != null) {
      this.mAppInstance = paramPTSAppInstance;
    }
  }
  
  public void setReusable(boolean paramBoolean)
  {
    this.reusable = paramBoolean;
  }
  
  protected boolean setStyle(String paramString, Object paramObject)
  {
    View localView = getView();
    if ("background-color".equalsIgnoreCase(paramString))
    {
      localView.setBackgroundColor(PTSValueConvertUtil.getColor(paramObject));
      return true;
    }
    if ("padding".equalsIgnoreCase(paramString))
    {
      if (isContainer()) {
        return false;
      }
      paramString = this.mNodeInfo.getStyle().getPadding();
      localView.setPadding(paramString[0], paramString[1], paramString[2], paramString[3]);
      return true;
    }
    return false;
  }
  
  public void setViewID(String paramString)
  {
    this.mViewID = paramString;
  }
  
  public void showNode()
  {
    this.mView.setVisibility(0);
  }
  
  public void update() {}
  
  public static abstract interface IBuilder<T extends PTSNodeVirtual>
  {
    public abstract T build(PTSAppInstance paramPTSAppInstance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeVirtual
 * JD-Core Version:    0.7.0.1
 */