package com.tencent.viola.ui.context;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.IRenderTask;
import com.tencent.viola.ui.action.RenderAction;
import com.tencent.viola.ui.action.RenderActionTask;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import com.tencent.viola.ui.dom.Style;
import com.tencent.viola.ui.dom.style.FlexLayoutContext;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DOMActionContextImpl
  implements DOMActionContext
{
  private Set<Pair<String, Map<String, Object>>> animations;
  private DomObject.Consumer mAddDOMConsumer;
  private Map<String, AddDomInfo> mAddDom = new HashMap();
  private DomObject.Consumer mApplyStyleConsumer;
  private boolean mDestroy = false;
  private volatile boolean mDirty;
  private String mInstanceId;
  private FlexLayoutContext mLayoutContext;
  private List<IRenderTask> mNormalTasks;
  final ConcurrentHashMap<String, DomObject> mRegistry;
  private ViolaRenderManager mRenderManager;
  private DomObject.Consumer mUnregisterDomConsumer;
  private String rootDomRef;
  
  public DOMActionContextImpl(String paramString, ViolaRenderManager paramViolaRenderManager)
  {
    this.mInstanceId = paramString;
    this.mLayoutContext = new FlexLayoutContext();
    this.mRegistry = new ConcurrentHashMap();
    this.mNormalTasks = new CopyOnWriteArrayList();
    this.animations = new LinkedHashSet();
    this.mRenderManager = paramViolaRenderManager;
    this.mAddDOMConsumer = new AddDOMConsumer(this.mRegistry);
    this.mUnregisterDomConsumer = new RemoveElementConsumer(this.mRegistry);
    this.mApplyStyleConsumer = new ApplyStyleConsumer(this.mRegistry);
  }
  
  private void parseAnimation()
  {
    Iterator localIterator = this.animations.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.isEmpty((CharSequence)((Pair)localIterator.next()).first)) {}
    }
  }
  
  private void updateDomObj()
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.mAddDom.entrySet().iterator();
    while (localIterator.hasNext()) {
      updateDomObj(((AddDomInfo)((Map.Entry)localIterator.next()).getValue()).component);
    }
    ViolaLogUtils.d("updateDomObj", "time:" + (System.currentTimeMillis() - l));
  }
  
  private void updateDomObj(VComponent paramVComponent)
  {
    if (paramVComponent == null) {}
    for (;;)
    {
      return;
      DomObject localDomObject = (DomObject)this.mRegistry.get(paramVComponent.getRef());
      if (localDomObject != null)
      {
        localDomObject.old();
        paramVComponent.updateDom(localDomObject);
        if ((paramVComponent instanceof VComponentContainer))
        {
          paramVComponent = (VComponentContainer)paramVComponent;
          int j = paramVComponent.getChildCount();
          int i = 0;
          while (i < j)
          {
            updateDomObj(paramVComponent.getChild(i));
            i += 1;
          }
        }
      }
    }
  }
  
  public void addAnimationForElement(String paramString, Map<String, Object> paramMap)
  {
    this.animations.add(new Pair(paramString, paramMap));
    this.mDirty = true;
  }
  
  public void addDomInfo(String paramString, VComponent paramVComponent)
  {
    AddDomInfo localAddDomInfo = new AddDomInfo();
    localAddDomInfo.component = paramVComponent;
    this.mAddDom.put(paramString, localAddDomInfo);
  }
  
  public void batch()
  {
    if ((!this.mDirty) || (this.mDestroy) || (TextUtils.isEmpty(this.rootDomRef))) {
      return;
    }
    layout((DomObject)this.mRegistry.get(this.rootDomRef));
  }
  
  public void consumeRenderTasks()
  {
    this.mRenderManager.runOnUIThreadBatch(this.mInstanceId, new ArrayList(this.mNormalTasks));
    this.mNormalTasks.clear();
  }
  
  public void destroy()
  {
    this.mDestroy = true;
    this.mRegistry.clear();
    this.mAddDOMConsumer = null;
    this.mNormalTasks.clear();
    this.mAddDom.clear();
    this.mLayoutContext = null;
    this.mRenderManager = null;
    this.mApplyStyleConsumer = null;
    this.animations.clear();
  }
  
  public DomObject.Consumer getAddDOMConsumer()
  {
    return this.mAddDOMConsumer;
  }
  
  public DomObject.Consumer getApplyStyleConsumer()
  {
    return this.mApplyStyleConsumer;
  }
  
  public VComponent getComponent(String paramString)
  {
    return this.mRenderManager.getComponent(this.mInstanceId, paramString);
  }
  
  public DomObject getDomByRef(String paramString)
  {
    return (DomObject)this.mRegistry.get(paramString);
  }
  
  public ViolaInstance getInstance()
  {
    return this.mRenderManager.getInstance(this.mInstanceId);
  }
  
  public String getInstanceId()
  {
    return this.mInstanceId;
  }
  
  public DomObject.Consumer getRemoveElementConsumer()
  {
    return this.mUnregisterDomConsumer;
  }
  
  public String getRootRef()
  {
    return this.rootDomRef;
  }
  
  public boolean isDestory()
  {
    return false;
  }
  
  void layout(DomObject paramDomObject)
  {
    if (paramDomObject == null) {}
    ViolaInstance localViolaInstance;
    do
    {
      return;
      System.currentTimeMillis();
      paramDomObject.traverseTree(new DomObject.Consumer[] { new DOMActionContextImpl.1(this) });
      System.currentTimeMillis();
      paramDomObject.calculateLayout(this.mLayoutContext);
      localViolaInstance = ViolaSDKManager.getInstance().getViolaInstance(this.mInstanceId);
      if (localViolaInstance != null) {}
      System.currentTimeMillis();
      paramDomObject.traverseTree(new DomObject.Consumer[] { new DOMActionContextImpl.2(this), new ApplyUpdateConsumer(null) });
      if (localViolaInstance != null) {}
      System.currentTimeMillis();
      updateDomObj();
      if (localViolaInstance != null) {}
      parseAnimation();
      consumeRenderTasks();
      this.mAddDom.clear();
      this.animations.clear();
      this.mDirty = false;
    } while (localViolaInstance == null);
  }
  
  public void markDirty()
  {
    if ((!this.mDestroy) && (!this.mDirty)) {
      this.mDirty = true;
    }
  }
  
  public void postRenderTask(RenderAction paramRenderAction)
  {
    this.mNormalTasks.add(new RenderActionTask(paramRenderAction, this.mRenderManager.getRenderContext(this.mInstanceId)));
    this.mDirty = true;
  }
  
  public void registerComponent(String paramString, VComponent paramVComponent)
  {
    this.mRenderManager.registerComponent(this.mInstanceId, paramString, paramVComponent);
  }
  
  public void registerDOMObject(String paramString, DomObject paramDomObject)
  {
    this.mRegistry.put(paramString, paramDomObject);
  }
  
  public void setRootRef(@NonNull String paramString)
  {
    this.rootDomRef = paramString;
  }
  
  public VComponent unregisterComponent(String paramString)
  {
    return this.mRenderManager.unRegisterComponent(this.mInstanceId, paramString);
  }
  
  public DomObject unregisterDOMObject(String paramString)
  {
    return (DomObject)this.mRegistry.remove(paramString);
  }
  
  class AddDOMConsumer
    implements DomObject.Consumer
  {
    final ConcurrentHashMap<String, DomObject> mRegistry;
    
    AddDOMConsumer()
    {
      Object localObject;
      this.mRegistry = localObject;
    }
    
    public void accept(DomObject paramDomObject)
    {
      this.mRegistry.put(paramDomObject.getRef(), paramDomObject);
      if ((!TextUtils.isEmpty(DOMActionContextImpl.this.rootDomRef)) && ((DomObject)this.mRegistry.get(DOMActionContextImpl.this.rootDomRef) != null) && (paramDomObject.isFixed())) {}
    }
  }
  
  static class AddDomInfo
  {
    public VComponent component;
  }
  
  class ApplyStyleConsumer
    implements DomObject.Consumer
  {
    final ConcurrentHashMap<String, DomObject> mRegistry;
    
    ApplyStyleConsumer()
    {
      Object localObject;
      this.mRegistry = localObject;
    }
    
    public void accept(DomObject paramDomObject)
    {
      paramDomObject.getStyle();
      if (paramDomObject.getStyle().size() > 0) {
        paramDomObject.applyStyleToNode();
      }
    }
  }
  
  class ApplyUpdateConsumer
    implements DomObject.Consumer
  {
    private ApplyUpdateConsumer() {}
    
    public void accept(DomObject paramDomObject)
    {
      DomObject localDomObject;
      if (paramDomObject.hasUpdate())
      {
        paramDomObject.markUpdateSeen();
        if (!paramDomObject.isYoung())
        {
          localDomObject = paramDomObject.clone();
          if (localDomObject != null) {
            break label28;
          }
        }
      }
      return;
      label28:
      DOMActionContextImpl.this.mNormalTasks.add(new DOMActionContextImpl.ApplyUpdateConsumer.1(this, localDomObject, paramDomObject));
    }
  }
  
  static class RemoveElementConsumer
    implements DomObject.Consumer
  {
    final ConcurrentHashMap<String, DomObject> mRegistry;
    
    RemoveElementConsumer(ConcurrentHashMap<String, DomObject> paramConcurrentHashMap)
    {
      this.mRegistry = paramConcurrentHashMap;
    }
    
    public void accept(DomObject paramDomObject)
    {
      this.mRegistry.remove(paramDomObject.getRef());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl
 * JD-Core Version:    0.7.0.1
 */