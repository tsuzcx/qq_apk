package com.tencent.widget.immersive;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class ImmersiveTitleBar2
  extends View
{
  public static boolean dlu = true;
  public static boolean dlv = true;
  private int mStatusBarHeight;
  public int mViewHeight;
  
  public ImmersiveTitleBar2(Context paramContext)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  public ImmersiveTitleBar2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext);
  }
  
  public ImmersiveTitleBar2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI(paramContext);
  }
  
  public void abu(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  public void initUI(Context paramContext)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "ImmersiveTitleBar initUI");
    }
    if ((dlu) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      dlv = bool;
      this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(paramContext);
      if (!dlv) {
        break label74;
      }
      setCustomHeight(this.mStatusBarHeight);
    }
    for (;;)
    {
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label82;
      }
      setBackgroundResource(2130851105);
      return;
      bool = false;
      break;
      label74:
      setCustomHeight(0);
    }
    label82:
    setBackgroundColor(getResources().getColor(2131167361));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mViewHeight, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.mViewHeight);
  }
  
  public void setCustomHeight(int paramInt)
  {
    this.mViewHeight = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.immersive.ImmersiveTitleBar2
 * JD-Core Version:    0.7.0.1
 */