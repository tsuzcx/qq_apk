package com.tencent.viola.ui.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.adapter.VLoopAbleSliderAdapter;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VSliderView;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VSlider
  extends VComponentContainer<VSliderView>
  implements Runnable
{
  private static final String CELL_SCALE = "cellScale";
  private static final String CELL_WIDTH = "cellWidth";
  private static final String LOOP_DISABLE = "loopDisable";
  public static final String TAG = "VSlider";
  private VLoopAbleSliderAdapter mAdapter;
  private Handler mBatchHandler;
  private boolean mIsNotify = false;
  
  public VSlider(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void changeIndicatorIndex(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("index", paramInt);
      JSONArray localJSONArray = new JSONArray();
      if (getDomObject() != null)
      {
        String str = getDomObject().getRef();
        if (str != null) {
          localJSONArray.put(str);
        }
      }
      localJSONArray.put("change");
      sliderFireEvent("change", localJSONArray, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("VSlider", "change error :" + localException.getMessage());
      }
    }
  }
  
  private void detectScrollable(VSliderView paramVSliderView)
  {
    if (paramVSliderView != null)
    {
      if (getChildCount() <= 1) {
        paramVSliderView.setScrollable(false);
      }
    }
    else {
      return;
    }
    paramVSliderView.setScrollable(true);
  }
  
  private void fireAppear(int paramInt)
  {
    VComponent localVComponent = getChild(paramInt);
    if ((localVComponent instanceof VCell)) {
      ((VCell)localVComponent).appearFireEvent();
    }
  }
  
  private boolean loopDisable()
  {
    return (this.mDomObj != null) && (ViolaUtils.getBoolean(this.mDomObj.getAttributes().get("loopDisable")));
  }
  
  private void notifyDataChange()
  {
    if (this.mAdapter != null)
    {
      this.mIsNotify = true;
      this.mAdapter.notifyDataSetChanged();
      this.mIsNotify = false;
    }
  }
  
  private void setCellScale(Object paramObject, VSliderView paramVSliderView)
  {
    if (paramVSliderView == null) {
      return;
    }
    float f = ViolaUtils.getFloat(paramObject, Float.valueOf(1.0F));
    paramVSliderView.setPageTransformer(false, new ScaleTransformer(f));
    this.mAdapter.setMinScale(f);
  }
  
  private void setCellWidth(Object paramObject)
  {
    if ((paramObject == null) || (getHostView() == null)) {
      return;
    }
    ((VSliderView)getHostView()).setClipChildren(false);
    paramObject = (ViewGroup)((VSliderView)getHostView()).getParent();
    if (paramObject != null) {
      paramObject.setClipChildren(false);
    }
    for (;;)
    {
      paramObject = ((VSliderView)getHostView()).getLayoutParams();
      if ((paramObject instanceof FrameLayout.LayoutParams)) {
        ((FrameLayout.LayoutParams)paramObject).gravity = 1;
      }
      this.mAdapter.setCellExactlyWidth(paramObject.width);
      return;
      ViolaLogUtils.d("VSlider", "patent is null");
    }
  }
  
  private void tryResumeState(VSliderView paramVSliderView)
  {
    if (paramVSliderView == null) {}
    while ((this.mDomObj == null) || (this.mDomObj.getDomChildCount() <= 1)) {
      return;
    }
    Object localObject = this.mDomObj.getState("index");
    if ((localObject instanceof Integer))
    {
      int i = ((Integer)localObject).intValue();
      if ((i <= this.mDomObj.mDomChildren.size() - 1) && (i >= 0))
      {
        paramVSliderView.setStartIndexWithNoAnimate(i);
        changeIndicatorIndex(i);
        ViolaLogUtils.d("VSlider", "resumeState, index: " + i);
        return;
      }
      paramVSliderView.setStartIndexWithNoAnimate(0);
      return;
    }
    paramVSliderView.setStartIndexWithNoAnimate(0);
  }
  
  public void addChild(VComponent paramVComponent, int paramInt)
  {
    super.addChild(paramVComponent, paramInt);
    detectScrollable((VSliderView)getHostView());
    notifyDataChange();
  }
  
  public void addEvent(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        super.addEvent(paramString);
        return;
        if (paramString.equals("change")) {
          i = 0;
        }
        break;
      }
    }
    this.mAppendEvents.add(paramString);
  }
  
  public void addSubView(View paramView, int paramInt) {}
  
  public void bindData()
  {
    if (!isLazy())
    {
      updateStyle(this.mDomObj.getStyle(), false);
      updateAttrs(this.mDomObj.getAttributes());
      updateExtra(this.mDomObj.getExtra());
      setBackgroundDrawable();
      checkClipChild();
      checkDisAppearEventFromDomobject();
      updateLifeCycle("mounted");
    }
  }
  
  public void destroy()
  {
    super.destroy();
    this.mAdapter = null;
    if (getHostView() != null) {
      ((VSliderView)getHostView()).destroy();
    }
    if (this.mBatchHandler != null) {
      this.mBatchHandler.removeCallbacks(this);
    }
  }
  
  public void initAdapter()
  {
    this.mAdapter = new VLoopAbleSliderAdapter(this.mChildren, ViolaSDKManager.getInstance().getDomManager().getDomContext(this.mInstance.getInstanceId()), loopDisable());
  }
  
  protected VSliderView initComponentHostView(@NonNull Context paramContext)
  {
    initAdapter();
    paramContext = new VSliderView(paramContext, this.mAdapter);
    this.mAdapter.setSliderView(paramContext);
    paramContext.setClickable(true);
    paramContext.bindComponent(this);
    paramContext.setSliderListener(new VSlider.1(this));
    tryResumeState(paramContext);
    if (getDomObject().getAttributes().containsKey("cellScale")) {
      setCellScale(getDomObject().getAttributes().get("cellScale"), paramContext);
    }
    detectScrollable(paramContext);
    this.mBatchHandler = new Handler(Looper.getMainLooper());
    return paramContext;
  }
  
  public boolean isReuse()
  {
    return false;
  }
  
  public void notifyWhenChange(String paramString, DomObject paramDomObject)
  {
    if (loopDisable()) {
      return;
    }
    if ((paramDomObject != null) && (!"cell".equals(paramDomObject.getType())) && (this.mBatchHandler != null))
    {
      this.mBatchHandler.removeCallbacks(this);
      this.mBatchHandler.postDelayed(this, 16L);
    }
    super.notifyWhenChange(paramString, paramDomObject);
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (getHostView() != null) {
      ((VSliderView)getHostView()).stopPlay();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (getHostView() != null) {
      ((VSliderView)getHostView()).startPlay();
    }
  }
  
  public void remove(VComponent paramVComponent, boolean paramBoolean)
  {
    super.remove(paramVComponent, paramBoolean);
    detectScrollable((VSliderView)getHostView());
    notifyDataChange();
  }
  
  public void run()
  {
    notifyDataChange();
  }
  
  @VComponentProp(name="autoEnable")
  public void setAutoEnable(Boolean paramBoolean)
  {
    ((VSliderView)getHostView()).setIsAutoMode(paramBoolean.booleanValue());
  }
  
  @VComponentProp(initToHostView=true, name="index", nativeReturnMethod="getCurrentIndex")
  public void setIndex(int paramInt)
  {
    ((VSliderView)getHostView()).setStartItemIndex(paramInt);
  }
  
  @VComponentProp(name="interval")
  public void setInterval(int paramInt)
  {
    ((VSliderView)getHostView()).setTimeInterval(paramInt);
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return super.setProperty(paramString, paramObject);
        if (paramString.equals("cellWidth")) {
          i = 0;
        }
        break;
      }
    }
    setCellWidth(paramObject);
    return true;
  }
  
  public void sliderFireEvent(String paramString, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    fireEvent(paramString, paramJSONArray, paramJSONObject);
  }
  
  public class ScaleTransformer
    implements ViewPager.PageTransformer
  {
    private final float minScale;
    
    public ScaleTransformer(float paramFloat)
    {
      this.minScale = paramFloat;
    }
    
    public void transformPage(View paramView, float paramFloat)
    {
      if (paramView == null) {}
      float f;
      do
      {
        do
        {
          return;
        } while ((VSlider.this.mIsNotify) || ((VSlider.this.mAdapter != null) && (VSlider.this.mAdapter.getCount() == 1)));
        if (paramFloat < 0.0F) {}
        for (f = (1.0F - this.minScale) * paramFloat + 1.0F; paramFloat <= 0.0F; f = (this.minScale - 1.0F) * paramFloat + 1.0F)
        {
          paramView.setPivotX(paramView.getWidth());
          paramView.setPivotY(paramView.getHeight() / 2);
          paramView.setScaleX(f);
          paramView.setScaleY(f);
          return;
        }
      } while ((paramFloat <= 1.0F) && (paramFloat > 1.0F));
      paramView.setPivotX(0.0F);
      paramView.setPivotY(paramView.getHeight() / 2);
      paramView.setScaleX(f);
      paramView.setScaleY(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSlider
 * JD-Core Version:    0.7.0.1
 */