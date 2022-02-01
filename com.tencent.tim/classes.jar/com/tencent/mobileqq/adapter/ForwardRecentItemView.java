package com.tencent.mobileqq.adapter;

import abeh;
import abei;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.mini.widget.media.danmu.DecelerateAccelerateInterpolator;

public class ForwardRecentItemView
  extends RelativeLayout
{
  public TextView Pq;
  public TextView Pr;
  public ResultRecord b;
  public CheckBox checkBox;
  public int cnX;
  public RelativeLayout je;
  public View lo;
  public String name;
  public View rootView;
  public int width;
  public ImageView xl;
  
  public ForwardRecentItemView(Context paramContext)
  {
    super(paramContext);
    initViews();
    initData();
  }
  
  private void initData()
  {
    this.width = getResources().getDimensionPixelOffset(2131298646);
    this.cnX = getResources().getDimensionPixelOffset(2131297031);
  }
  
  private void initViews()
  {
    this.rootView = View.inflate(getContext(), 2131562959, this);
    this.je = ((RelativeLayout)this.rootView.findViewById(2131377405));
    this.Pq = ((TextView)this.rootView.findViewById(2131379402));
    this.Pr = ((TextView)this.rootView.findViewById(2131379404));
    this.xl = ((ImageView)this.rootView.findViewById(2131368698));
    this.checkBox = ((CheckBox)this.rootView.findViewById(2131364587));
    this.lo = this.rootView.findViewById(2131380904);
  }
  
  public void Du(boolean paramBoolean)
  {
    this.checkBox.setChecked(paramBoolean);
    Object localObject;
    if (AppSetting.enableTalkBack)
    {
      localObject = getResources();
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (int i = 2131691504;; i = 2131721546)
    {
      localObject = ((Resources)localObject).getString(i);
      setContentDescription(this.name + (String)localObject);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, Drawable paramDrawable, ResultRecord paramResultRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString1, paramString2, paramDrawable, paramResultRecord, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(String paramString1, String paramString2, Drawable paramDrawable, ResultRecord paramResultRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 8;
    this.name = paramString1;
    this.b = paramResultRecord;
    this.Pq.setText(paramString1);
    this.xl.setImageDrawable(paramDrawable);
    if (TextUtils.isEmpty(paramString2))
    {
      this.Pr.setVisibility(8);
      if (this.lo != null)
      {
        paramString2 = this.lo;
        if (paramBoolean3) {
          i = 0;
        }
        paramString2.setVisibility(i);
      }
      paramString2 = (RelativeLayout.LayoutParams)this.je.getLayoutParams();
      paramString2.leftMargin = (-this.width);
      i = this.cnX;
      if (!paramBoolean1) {
        break label207;
      }
      paramString2.leftMargin = 0;
      i -= this.width;
    }
    label207:
    for (;;)
    {
      this.je.setLayoutParams(paramString2);
      this.checkBox.setChecked(paramBoolean2);
      this.Pq.setMaxWidth(i);
      if (AppSetting.enableTalkBack) {
        setContentDescription(paramString1);
      }
      return;
      this.Pr.setVisibility(0);
      if (paramString2.startsWith("("))
      {
        this.Pr.setText(paramString2);
        break;
      }
      this.Pr.setText(String.format("(%s)", new Object[] { paramString2 }));
      break;
    }
  }
  
  public void gM(long paramLong)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.je.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -this.width, 0 });
    localValueAnimator.setInterpolator(new DecelerateAccelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new abeh(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void gN(long paramLong)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.je.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.width });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new abei(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void setMultiSelectStatus()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.je.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.je.setLayoutParams(localLayoutParams);
    this.Pq.setMaxWidth(this.cnX - this.width);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentItemView
 * JD-Core Version:    0.7.0.1
 */