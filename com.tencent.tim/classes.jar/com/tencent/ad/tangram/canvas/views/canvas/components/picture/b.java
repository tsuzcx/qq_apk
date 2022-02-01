package com.tencent.ad.tangram.canvas.views.canvas.components.picture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.components.pictures.c;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Callback;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class b
  extends AdCanvasComponentView
  implements AdImageViewAdapter.Callback
{
  private static final String TAG = "GdtCanvasPictureComponentView";
  private com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b containerHelper;
  private a data;
  private com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b helper;
  private View imageView;
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama, null);
  }
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, View.OnTouchListener paramOnTouchListener)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama, paramOnTouchListener);
  }
  
  private void init(Context paramContext, a parama, View.OnTouchListener paramOnTouchListener)
  {
    startLoad();
    if ((parama == null) || (!parama.isValid()))
    {
      stopLoad(false);
      return;
    }
    this.data = parama;
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    addView(localLinearLayout);
    Object localObject = new RelativeLayout(paramContext);
    if (parama.isHotAreaValild())
    {
      ArrayList localArrayList = parama.hotAreaList;
      int i = 0;
      while (i < localArrayList.size())
      {
        Button localButton = new Button(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((c)localArrayList.get(i)).width, ((c)localArrayList.get(i)).height);
        localLayoutParams.topMargin = ((c)localArrayList.get(i)).y;
        localLayoutParams.leftMargin = ((c)localArrayList.get(i)).x;
        localButton.setLayoutParams(localLayoutParams);
        localButton.setBackgroundColor(0);
        ((RelativeLayout)localObject).addView(localButton);
        localButton.setOnClickListener(new a(((c)localArrayList.get(i)).linkType, ((c)localArrayList.get(i)).formModId, ((c)localArrayList.get(i)).url));
        i += 1;
      }
    }
    addView((View)localObject);
    localLinearLayout.setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
    localObject = new AdImageViewAdapter.Params();
    ((AdImageViewAdapter.Params)localObject).context = new WeakReference(paramContext);
    ((AdImageViewAdapter.Params)localObject).url = parama.url;
    ((AdImageViewAdapter.Params)localObject).guassianUrl = parama.guassianUrl;
    ((AdImageViewAdapter.Params)localObject).callback = new WeakReference(this);
    this.imageView = AdImageViewBuilder.buildImageView((AdImageViewAdapter.Params)localObject);
    if ((this.imageView == null) || (!(this.imageView instanceof ImageView)))
    {
      AdLog.e("GdtCanvasPictureComponentView", "buildImageView Failed");
      stopLoad(false);
      return;
    }
    if (parama.enableRoundRectBackground)
    {
      this.containerHelper = new com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b(new WeakReference(localLinearLayout));
      this.containerHelper.setRadius(this.data.radius);
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramContext = (ViewGroup.MarginLayoutParams)localLinearLayout.getLayoutParams();
        paramContext.leftMargin = this.data.borderWidth;
        paramContext.topMargin = this.data.borderWidth;
        paramContext.rightMargin = this.data.borderWidth;
        paramContext.bottomMargin = this.data.borderWidth;
        localLinearLayout.setLayoutParams(paramContext);
      }
      this.helper = new com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b(new WeakReference(this));
      this.helper.setBorderColor(Color.parseColor(this.data.borderColor));
      this.helper.setBorderWidth(this.data.borderWidth);
      this.helper.setRadius(this.data.radius);
    }
    localLinearLayout.addView(this.imageView);
    paramContext = this.imageView.getLayoutParams();
    paramContext.width = getData().width;
    paramContext.height = getData().height;
    this.imageView.setLayoutParams(paramContext);
    if (paramOnTouchListener != null) {
      this.imageView.setOnTouchListener(paramOnTouchListener);
    }
    for (;;)
    {
      this.status = new AdViewStatus(new WeakReference(this.imageView), new WeakReference(this));
      return;
      this.imageView.setOnTouchListener(new b(new b.1(this, parama), getResources()));
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.helper != null) {
      this.helper.dispatchDraw(paramCanvas);
    }
    if (this.containerHelper != null) {
      this.containerHelper.dispatchDraw(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public a getData()
  {
    return this.data;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.helper != null) {
      this.helper.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.containerHelper != null) {
      this.containerHelper.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onStopLoad(boolean paramBoolean)
  {
    stopLoad(paramBoolean);
  }
  
  class a
    implements View.OnClickListener
  {
    private String formId;
    private String linkType;
    private String url;
    
    a(String paramString1, String paramString2, String paramString3)
    {
      this.linkType = paramString1;
      this.formId = paramString2;
      this.url = paramString3;
    }
    
    public void onClick(View paramView)
    {
      if ((b.this.canvasViewListener != null) && (b.this.canvasViewListener.get() != null)) {
        ((AdCanvasViewListener)b.this.canvasViewListener.get()).hotAreaClick(this.linkType, b.this.data.id, this.url, this.formId);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  static class b
    implements View.OnTouchListener
  {
    private int ALLOW_CLICK_MOVE = 3;
    private int action_down_x = 0;
    private int action_down_y = 0;
    private Runnable clickRunnable;
    
    public b(Runnable paramRunnable, Resources paramResources)
    {
      this.clickRunnable = paramRunnable;
      this.ALLOW_CLICK_MOVE = AdUIUtils.dp2px(3.0F, paramResources);
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int j = (int)paramMotionEvent.getX();
      int i = (int)paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return false;
        this.action_down_x = j;
        this.action_down_y = i;
        return true;
        j = Math.abs(j - this.action_down_x);
        i = Math.abs(i - this.action_down_y);
        if ((j < this.ALLOW_CLICK_MOVE) && (i < this.ALLOW_CLICK_MOVE) && (this.clickRunnable != null)) {
          this.clickRunnable.run();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.picture.b
 * JD-Core Version:    0.7.0.1
 */