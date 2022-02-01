package com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.d;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

public class b
  extends AdCanvasComponentView
{
  private static final String TAG = "GdtCanvasButtonComponentView";
  private View fixedView = null;
  private a gdtCanvasFixedButtonComponentData;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference)
  {
    super(paramContext, paramWeakReference);
  }
  
  public void doClick()
  {
    if (this.fixedView != null)
    {
      if (!(this.fixedView instanceof c)) {
        break label28;
      }
      ((c)this.fixedView).doClick();
    }
    label28:
    while (!(this.fixedView instanceof d)) {
      return;
    }
    ((d)this.fixedView).doClick();
  }
  
  public String getButtonStyle()
  {
    return this.gdtCanvasFixedButtonComponentData.buttonStyle;
  }
  
  public a getData()
  {
    return this.gdtCanvasFixedButtonComponentData;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void init(Context paramContext, a parama, Ad paramAd, WeakReference<AdCanvasViewListener> paramWeakReference)
  {
    startLoad();
    if ((parama == null) || (!parama.isValid()))
    {
      AdLog.e("GdtCanvasButtonComponentView", "init error");
      stopLoad(false);
      return;
    }
    this.gdtCanvasFixedButtonComponentData = parama;
    if (this.gdtCanvasFixedButtonComponentData.buttonStyle.equals("fixedBtn-1"))
    {
      this.fixedView = new c(paramContext, this.gdtCanvasFixedButtonComponentData, paramAd, paramWeakReference);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
    }
    for (;;)
    {
      addView(this.fixedView, paramContext);
      this.status = new AdViewStatus(new WeakReference(this.fixedView), new WeakReference(this));
      stopLoad(true);
      return;
      if (!this.gdtCanvasFixedButtonComponentData.buttonStyle.equals("fixedBtn-2")) {
        break;
      }
      this.fixedView = new d(paramContext, paramWeakReference, parama, true);
      paramContext = new RelativeLayout.LayoutParams(-1, this.gdtCanvasFixedButtonComponentData.height + this.gdtCanvasFixedButtonComponentData.paddingTop + this.gdtCanvasFixedButtonComponentData.paddingBottom);
      this.fixedView.setBackgroundColor(-1);
    }
    AdLog.e("GdtCanvasButtonComponentView", "buttonStyle unknown");
    stopLoad(false);
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    if (this.fixedView != null) {
      ((AdCanvasComponentView)this.fixedView).onActivityDestroy();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (this.fixedView != null) {
      ((AdCanvasComponentView)this.fixedView).onActivityResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.b
 * JD-Core Version:    0.7.0.1
 */