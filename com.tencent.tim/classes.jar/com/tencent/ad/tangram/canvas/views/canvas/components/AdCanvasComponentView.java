package com.tencent.ad.tangram.canvas.views.canvas.components;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.canvas.statistics.AdTimeStatistics;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.AdViewStatus.Listener;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasPageView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@Keep
public abstract class AdCanvasComponentView
  extends FrameLayout
  implements AdViewStatus.Listener
{
  private static final String TAG = "GdtCanvasComponentView";
  public WeakReference<AdCanvasViewListener> canvasViewListener;
  protected AdTimeStatistics loadTimeStatistics = new AdTimeStatistics();
  protected AdViewStatus status;
  
  public AdCanvasComponentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdCanvasComponentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdCanvasComponentView(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference)
  {
    super(paramContext);
    this.canvasViewListener = paramWeakReference;
  }
  
  private void notifyLoaded(boolean paramBoolean)
  {
    if ((this.canvasViewListener == null) || (this.canvasViewListener.get() == null) || (this.loadTimeStatistics == null)) {
      AdLog.e("GdtCanvasComponentView", "notifyLoaded error");
    }
    long l;
    do
    {
      return;
      l = this.loadTimeStatistics.getTime();
    } while (l < 0L);
    ((AdCanvasViewListener)this.canvasViewListener.get()).onLoaded(getData(), l, paramBoolean);
  }
  
  public boolean back()
  {
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.canvasViewListener == null) || (this.canvasViewListener.get() == null) || (((AdCanvasViewListener)this.canvasViewListener.get()).getContentView() == null) || (!(this.canvasViewListener.get() instanceof AdCanvasView))) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      String str = ((AdCanvasView)this.canvasViewListener.get()).lastTouchFormModuleId;
      if ((getData() != null) && (!TextUtils.isEmpty(getData().id)) && (!getData().id.equals(str)) && (getContext() != null)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      }
      ((AdCanvasViewListener)this.canvasViewListener.get()).getContentView().setFormFocusd(str, false);
      if (getData().id.contains("XJWebForm")) {
        ((AdCanvasViewListener)this.canvasViewListener.get()).getContentView().setFormFocusd(getData().id, true);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public AdCanvasData getCanvasData()
  {
    if ((this.canvasViewListener != null) && (this.canvasViewListener.get() != null)) {
      return ((AdCanvasViewListener)this.canvasViewListener.get()).getData();
    }
    return null;
  }
  
  public abstract AdCanvasComponentData getData();
  
  public abstract AdViewStatus getStatus();
  
  public void onActivityDestroy()
  {
    if (getStatus() != null) {
      getStatus().onActivityDestroy();
    }
  }
  
  public void onActivityPause()
  {
    if (getStatus() != null) {
      getStatus().onActivityPaused();
    }
  }
  
  public void onActivityResume()
  {
    if (getStatus() != null) {
      getStatus().onActivityResumed();
    }
  }
  
  public void onLocationChanged()
  {
    if (getStatus() != null) {
      getStatus().onLocationChanged();
    }
  }
  
  public void onViewPause()
  {
    if (getData() == null) {
      return;
    }
    AdLog.i("GdtCanvasComponentView", getData().id + ": onViewPause");
  }
  
  public void onViewResume()
  {
    if (getData() == null) {
      return;
    }
    AdLog.i("GdtCanvasComponentView", getData().id + ": onViewResume");
  }
  
  protected void startLoad()
  {
    if (this.loadTimeStatistics != null) {
      this.loadTimeStatistics.start();
    }
  }
  
  protected void stopLoad(boolean paramBoolean)
  {
    if (this.loadTimeStatistics != null) {
      this.loadTimeStatistics.stop();
    }
    notifyLoaded(paramBoolean);
    this.loadTimeStatistics = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView
 * JD-Core Version:    0.7.0.1
 */