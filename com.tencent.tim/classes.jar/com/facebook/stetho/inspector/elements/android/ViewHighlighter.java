package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

abstract class ViewHighlighter
{
  public static ViewHighlighter newInstance()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new OverlayHighlighter();
    }
    LogUtil.w("Running on pre-JBMR2: View highlighting is not supported");
    return new NoopHighlighter(null);
  }
  
  public abstract void clearHighlight();
  
  public abstract void setHighlightedView(View paramView, int paramInt);
  
  static final class NoopHighlighter
    extends ViewHighlighter
  {
    public void clearHighlight() {}
    
    public void setHighlightedView(View paramView, int paramInt) {}
  }
  
  @TargetApi(18)
  static final class OverlayHighlighter
    extends ViewHighlighter
  {
    private AtomicInteger mContentColor = new AtomicInteger();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ViewHighlightOverlays mHighlightOverlays = ViewHighlightOverlays.newInstance();
    private final Runnable mHighlightViewOnUiThreadRunnable = new ViewHighlighter.OverlayHighlighter.1(this);
    private View mHighlightedView;
    private AtomicReference<View> mViewToHighlight = new AtomicReference();
    
    private void highlightViewOnUiThread()
    {
      View localView = (View)this.mViewToHighlight.getAndSet(null);
      if (localView == this.mHighlightedView) {
        return;
      }
      if (this.mHighlightedView != null) {
        this.mHighlightOverlays.removeHighlight(this.mHighlightedView);
      }
      if (localView != null) {
        this.mHighlightOverlays.highlightView(localView, this.mContentColor.get());
      }
      this.mHighlightedView = localView;
    }
    
    private void setHighlightedViewImpl(@Nullable View paramView, int paramInt)
    {
      this.mHandler.removeCallbacks(this.mHighlightViewOnUiThreadRunnable);
      this.mViewToHighlight.set(paramView);
      this.mContentColor.set(paramInt);
      this.mHandler.postDelayed(this.mHighlightViewOnUiThreadRunnable, 100L);
    }
    
    public void clearHighlight()
    {
      setHighlightedViewImpl(null, 0);
    }
    
    public void setHighlightedView(View paramView, int paramInt)
    {
      setHighlightedViewImpl((View)Util.throwIfNull(paramView), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.ViewHighlighter
 * JD-Core Version:    0.7.0.1
 */