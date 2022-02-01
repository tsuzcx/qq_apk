package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.qmui.helper.QMUIDisplayHelper;

public class BottomSheetGridItemView
  extends RelativeLayout
{
  private ImageView mIconView;
  private ImageView mRedPoint;
  private TextView mTitleTv;
  
  public BottomSheetGridItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomSheetGridItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2131558784, this);
    this.mIconView = ((ImageView)findViewById(2131368133));
    this.mTitleTv = ((TextView)findViewById(2131368135));
    setClipToPadding(false);
    setPadding(0, getResources().getDimensionPixelSize(2131296715), 0, getResources().getDimensionPixelSize(2131296713));
  }
  
  private void toggleRedPointVisibility(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.mRedPoint != null) {
        this.mRedPoint.setVisibility(8);
      }
      return;
    }
    if (this.mRedPoint == null)
    {
      int i = getResources().getDimensionPixelSize(2131296714);
      this.mRedPoint = new ImageView(getContext());
      this.mRedPoint.setImageResource(2130850417);
      this.mRedPoint.setScaleType(ImageView.ScaleType.FIT_XY);
      int j = getResources().getDimensionPixelSize(2131299301);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(7, this.mTitleTv.getId());
      localLayoutParams.addRule(6, this.mTitleTv.getId());
      localLayoutParams.topMargin = QMUIDisplayHelper.dp2px(getContext(), -1);
      localLayoutParams.rightMargin = (i - j - QMUIDisplayHelper.dp2px(getContext(), 2));
      addView(this.mRedPoint, localLayoutParams);
    }
    this.mRedPoint.setVisibility(0);
  }
  
  public void render(int paramInt, String paramString, boolean paramBoolean)
  {
    this.mIconView.setImageResource(paramInt);
    this.mTitleTv.setText(paramString);
    toggleRedPointVisibility(paramBoolean);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    if (Build.VERSION.SDK_INT > 11) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (float f = 0.6F;; f = 1.0F)
    {
      setAlpha(f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.BottomSheetGridItemView
 * JD-Core Version:    0.7.0.1
 */