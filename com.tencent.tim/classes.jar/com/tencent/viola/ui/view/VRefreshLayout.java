package com.tencent.viola.ui.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.tencent.viola.ui.component.VRefresh;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.refresh.RefreshMoveOberver;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import com.tencent.viola.ui.view.refresh.listener.IHeaderCallBack;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VRefreshLayout
  extends FrameLayout
  implements IVView<VRefresh>, IHeaderCallBack
{
  public static String TAG = "VRefreshLayout";
  private List<OnHeaderStateChangeListener> headerStateChangeListeners;
  public int mComponentType = 1;
  private JSONObject mFireEventJsonObject = new JSONObject();
  private Handler mHandler;
  private boolean mIsRefreshStick = false;
  private onRefreshStateChangeListener mOnRefreshStateChangeListener;
  private RefreshMoveOberver mRefreshMoveOberver;
  private Runnable mRunnable;
  private WeakReference<VRefresh> mWeakReference;
  
  public VRefreshLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    paramContext = new JSONObject();
    try
    {
      paramContext.put("width", FlexConvertUtils.px2dip(getWidth()) + "dp");
      paramContext.put("height", FlexConvertUtils.px2dip(getHeight()) + "dp");
      this.mFireEventJsonObject.put("size", paramContext);
      this.mHandler = new Handler(getContext().getMainLooper());
      this.mRunnable = new VRefreshLayout.1(this);
      this.mRefreshMoveOberver = new VRefreshLayout.2(this);
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void addOnHeaderStateChangeListener(OnHeaderStateChangeListener paramOnHeaderStateChangeListener)
  {
    if (paramOnHeaderStateChangeListener == null) {}
    do
    {
      return;
      if (this.headerStateChangeListeners == null) {
        this.headerStateChangeListeners = new ArrayList();
      }
    } while (this.headerStateChangeListeners.contains(paramOnHeaderStateChangeListener));
    this.headerStateChangeListeners.add(paramOnHeaderStateChangeListener);
  }
  
  public void bindComponent(VRefresh paramVRefresh)
  {
    this.mWeakReference = new WeakReference(paramVRefresh);
  }
  
  public void destroy()
  {
    if (this.mWeakReference != null)
    {
      this.mWeakReference.clear();
      this.mWeakReference = null;
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.mRunnable);
    }
    this.mOnRefreshStateChangeListener = null;
  }
  
  @Nullable
  public VRefresh getComponent()
  {
    if (this.mWeakReference != null) {
      return (VRefresh)this.mWeakReference.get();
    }
    return null;
  }
  
  public int getComponentType()
  {
    return this.mComponentType;
  }
  
  public int getHeaderHeight()
  {
    if (getComponent() != null) {
      return (int)getComponent().getDomObject().getLayoutHeight();
    }
    return 0;
  }
  
  public int getHeaderWidth()
  {
    if (getComponent() != null) {
      return (int)getComponent().getDomObject().getLayoutWidth();
    }
    return 0;
  }
  
  public RefreshMoveOberver getRefreshMoveOberver()
  {
    return this.mRefreshMoveOberver;
  }
  
  public boolean getRefreshStick()
  {
    return this.mIsRefreshStick;
  }
  
  public void notifyShowUpdate(int paramInt)
  {
    boolean bool = true;
    VRefreshViewGroup localVRefreshViewGroup;
    if ((getParent() instanceof VRefreshViewGroup))
    {
      localVRefreshViewGroup = (VRefreshViewGroup)getParent();
      if (paramInt != 1) {
        break label31;
      }
    }
    for (;;)
    {
      localVRefreshViewGroup.updateRefreshShow(bool);
      return;
      label31:
      bool = false;
    }
  }
  
  public void notifyVisiableChangeOnScreen(boolean paramBoolean)
  {
    JSONArray localJSONArray;
    VRefresh localVRefresh;
    if (getComponentType() == 2)
    {
      localJSONArray = new JSONArray();
      if ((getComponent() != null) && (getComponent().getDomObject() != null))
      {
        str = getComponent().getDomObject().getRef();
        if (str != null) {
          localJSONArray.put(str);
        }
        if (!paramBoolean) {
          break label90;
        }
        localJSONArray.put("appear");
        localVRefresh = getComponent();
        if (!paramBoolean) {
          break label100;
        }
      }
    }
    label90:
    label100:
    for (String str = "appear";; str = "disappear")
    {
      localVRefresh.refreshFireEvent(str, localJSONArray, this.mFireEventJsonObject);
      return;
      localJSONArray.put("disappear");
      break;
    }
  }
  
  public void onFingerRelease()
  {
    if (this.headerStateChangeListeners != null)
    {
      Iterator localIterator = this.headerStateChangeListeners.iterator();
      while (localIterator.hasNext()) {
        ((OnHeaderStateChangeListener)localIterator.next()).onHeaderFingerRelease();
      }
    }
  }
  
  public void onStateFinish(boolean paramBoolean)
  {
    this.mHandler.postDelayed(this.mRunnable, 500L);
  }
  
  public void onStateNormal()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
    if (this.mOnRefreshStateChangeListener != null) {
      this.mOnRefreshStateChangeListener.onStateIdel();
    }
    JSONArray localJSONArray = new JSONArray();
    if ((getComponent() != null) && (getComponent().getDomObject() != null))
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
      localJSONArray.put("idle");
      getComponent().refreshFireEvent("idle", localJSONArray, this.mFireEventJsonObject);
    }
  }
  
  public void onStateReady()
  {
    if (this.mOnRefreshStateChangeListener != null) {
      this.mOnRefreshStateChangeListener.onStatePulling();
    }
    JSONArray localJSONArray = new JSONArray();
    if ((getComponent() != null) && (getComponent().getDomObject() != null))
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
      localJSONArray.put("pulling");
      getComponent().refreshFireEvent("pulling", localJSONArray, this.mFireEventJsonObject);
    }
  }
  
  public void onStateRefreshing()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
    if (this.mOnRefreshStateChangeListener != null) {
      this.mOnRefreshStateChangeListener.onStateRefreshing();
    }
    JSONArray localJSONArray = new JSONArray();
    if ((getComponent() != null) && (getComponent().getDomObject() != null))
    {
      String str = getComponent().getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
      localJSONArray.put("refresh");
      getComponent().refreshFireEvent("refresh", localJSONArray, this.mFireEventJsonObject);
    }
  }
  
  public void onStickRefreshing()
  {
    if (this.headerStateChangeListeners != null)
    {
      Iterator localIterator = this.headerStateChangeListeners.iterator();
      while (localIterator.hasNext()) {
        ((OnHeaderStateChangeListener)localIterator.next()).onStickRefreshing();
      }
    }
  }
  
  public void setRefreshStick(boolean paramBoolean)
  {
    this.mIsRefreshStick = paramBoolean;
  }
  
  public void setStateFinish(boolean paramBoolean, String paramString)
  {
    if (this.mOnRefreshStateChangeListener != null) {
      this.mOnRefreshStateChangeListener.onStateFinish(paramBoolean, paramString);
    }
  }
  
  public void setonRefreshStateChangeListener(onRefreshStateChangeListener paramonRefreshStateChangeListener)
  {
    this.mOnRefreshStateChangeListener = paramonRefreshStateChangeListener;
  }
  
  public void show()
  {
    setVisibility(0);
  }
  
  public static abstract interface OnHeaderStateChangeListener
  {
    public abstract void onHeaderFingerRelease();
    
    public abstract void onRefreshMove(int paramInt);
    
    public abstract void onStateEnd();
    
    public abstract void onStickRefreshing();
  }
  
  public static abstract interface onRefreshStateChangeListener
  {
    public abstract void onRefreshMove(int paramInt);
    
    public abstract void onStateEnd();
    
    public abstract void onStateFinish(boolean paramBoolean, String paramString);
    
    public abstract void onStateIdel();
    
    public abstract void onStatePulling();
    
    public abstract void onStateRefreshing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.VRefreshLayout
 * JD-Core Version:    0.7.0.1
 */