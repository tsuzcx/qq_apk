package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqnm;

public class QIMCameraCountTimeLayout
  extends LinearLayout
{
  private View ND;
  private boolean dBR;
  private TextView mTimeText;
  
  public QIMCameraCountTimeLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QIMCameraCountTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QIMCameraCountTimeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOrientation(0);
    this.ND = new View(getContext());
    this.ND.setBackgroundResource(2130845316);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(aqnm.dip2px(6.0F), aqnm.dip2px(6.0F));
    localLayoutParams.gravity = 16;
    addView(this.ND, localLayoutParams);
    this.mTimeText = new TextView(getContext());
    this.mTimeText.setText("0秒");
    this.mTimeText.setTextSize(14.0F);
    this.mTimeText.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165397);
    this.mTimeText.setTextColor(getResources().getColor(2131167654));
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = aqnm.dip2px(4.0F);
    addView(this.mTimeText, localLayoutParams);
  }
  
  public void setDotView(int paramInt)
  {
    this.ND.setBackgroundResource(paramInt);
  }
  
  public void setIsCircleStyle(boolean paramBoolean)
  {
    this.dBR = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.mTimeText.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTimeText.setTextColor(paramInt);
  }
  
  public void setTextShadow(boolean paramBoolean)
  {
    if (this.mTimeText == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mTimeText.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165397);
      return;
    }
    this.mTimeText.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      if (this.dBR) {
        break label35;
      }
    }
    label35:
    for (Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772292);; localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772019))
    {
      this.ND.startAnimation(localAnimation);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCountTimeLayout
 * JD-Core Version:    0.7.0.1
 */