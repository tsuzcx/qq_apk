package com.tencent.ad.tangram.canvas.views.canvas.components.text;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

public class b
  extends AdCanvasComponentView
{
  private static final String TAG = "AdCanvasTextComponentView";
  private static String title = "商品描述";
  private a value;
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama);
  }
  
  private void init(Context paramContext, a parama)
  {
    if ((paramContext == null) || (parama == null) || (!parama.isValid())) {
      return;
    }
    this.value = parama;
    parama = new RelativeLayout(paramContext);
    Object localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).leftMargin = this.value.marginLeft;
    ((FrameLayout.LayoutParams)localObject).topMargin = this.value.marginTop;
    ((FrameLayout.LayoutParams)localObject).rightMargin = this.value.marginRight;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = this.value.marginBottom;
    addView(parama);
    parama.setLayoutParams((ViewGroup.LayoutParams)localObject);
    parama.setGravity(15);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setId(4369);
    ((TextView)localObject).setText(title);
    ((TextView)localObject).setTextSize(20.0F);
    ((TextView)localObject).setTextColor(Color.parseColor("#000000"));
    ((TextView)localObject).getPaint().setFakeBoldText(true);
    parama.addView((View)localObject);
    TextView localTextView = new TextView(paramContext);
    localTextView.setId(8738);
    localTextView.setText(this.value.content);
    localTextView.setTextSize(this.value.fontSize);
    localTextView.setGravity(8388611);
    localTextView.setLineSpacing(0.0F, 1.2F);
    localTextView.setTextColor(Color.parseColor("#000000"));
    parama.addView(localTextView);
    parama = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    parama.addRule(3, ((TextView)localObject).getId());
    parama.topMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
  }
  
  public a getData()
  {
    return this.value;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.text.b
 * JD-Core Version:    0.7.0.1
 */