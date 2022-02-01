package com.tencent.mobileqq.activity.richmedia;

import aasb.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqbn;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;

public class PtvTemplateItemView
  extends LinearLayout
  implements View.OnClickListener
{
  View Ab;
  View Ac;
  a jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$a;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  URLImageView aD;
  aasb.a b;
  RelativeLayout el;
  CircleProgress g;
  ImageView gJ;
  Context mContext;
  int mPosition;
  
  public PtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public PtvTemplateItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public void Gs(int paramInt)
  {
    bX(paramInt, 0);
  }
  
  public void a(int paramInt, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, aasb.a parama)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      return;
      setTag(paramPtvTemplateInfo);
      this.mPosition = paramInt;
      this.b = parama;
      if (!TextUtils.isEmpty(paramPtvTemplateInfo.id)) {
        break;
      }
    } while (this.el.getVisibility() == 4);
    this.el.setVisibility(4);
    return;
    if (this.el.getVisibility() != 0) {
      this.el.setVisibility(0);
    }
    if (!TextUtils.isEmpty(paramPtvTemplateInfo.iconurl))
    {
      parama = URLDrawable.URLDrawableOptions.obtain();
      paramInt = wja.dp2px(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131166111));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      parama.mRequestWidth = paramInt;
      parama.mRequestHeight = paramInt;
      parama.mFailedDrawable = localGradientDrawable;
      parama.mLoadingDrawable = localGradientDrawable;
      parama = URLDrawable.getDrawable(paramPtvTemplateInfo.iconurl, parama);
      parama.setTag(aqbn.e(paramInt, paramInt));
      parama.setDecodeHandler(aqbn.b);
      this.aD.setImageDrawable(parama);
      if ((!paramPtvTemplateInfo.usable) && (!paramPtvTemplateInfo.id.equals("0"))) {
        break label253;
      }
      this.gJ.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      this.el.setOnClickListener(this);
      return;
      if (!"0".equals(paramPtvTemplateInfo.id)) {
        break;
      }
      this.aD.setImageResource(2130851770);
      break;
      label253:
      this.gJ.setVisibility(0);
    }
  }
  
  public void bX(int paramInt1, int paramInt2)
  {
    setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    setOrientation(0);
    int k = wja.dp2px(64.0F, getResources());
    int m = wja.dp2px(60.0F, getResources());
    int j = wja.dp2px(70.0F, getResources());
    int n = wja.dp2px(20.0F, getResources());
    int i1 = getResources().getColor(2131167304);
    int i2 = getResources().getColor(2131165409);
    int i3 = wja.dp2px(18.0F, getResources());
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = j;
    }
    this.el = new RelativeLayout(this.mContext);
    this.aD = new URLImageView(this.mContext);
    Object localObject = new RelativeLayout.LayoutParams(m, m);
    this.aD.setMinimumWidth(m);
    this.aD.setMinimumHeight(m);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.el.addView(this.aD, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = new CircleProgress(this.mContext);
    localObject = new RelativeLayout.LayoutParams(n, n);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumHeight(n);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumWidth(n);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(2.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, i1, 100, i2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.el.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress, (ViewGroup.LayoutParams)localObject);
    this.gJ = new ImageView(this.mContext);
    localObject = new RelativeLayout.LayoutParams(i3, i3);
    this.gJ.setImageResource(2130846916);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = wja.dp2px(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(2.0F, getResources());
    this.el.addView(this.gJ, (ViewGroup.LayoutParams)localObject);
    this.g = new CircleProgress(this.mContext);
    this.g.setStrokeWidth(3.0F);
    this.g.setBgAndProgressColor(100, 1226741, 100, 1226741);
    this.g.setMinimumWidth(k);
    this.g.setMinimumHeight(k);
    this.g.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(k, k);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.g.setVisibility(4);
    this.el.addView(this.g, (ViewGroup.LayoutParams)localObject);
    paramInt2 = (paramInt1 - k) / 2;
    localObject = new LinearLayout.LayoutParams(paramInt2, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.Ab = new View(this.mContext);
    addView(this.Ab, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(k, k);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    addView(this.el, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(paramInt2, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.Ac = new View(this.mContext);
    addView(this.Ac, (ViewGroup.LayoutParams)localObject);
    if (AudioHelper.jY(0) == 1) {
      QLog.d("PtvTemplateItemView", 4, String.format("[%s]初始化View, itemWidth[%s], fullHeight[%s], thumbWidthWithCircle[%s], thumbWidth[%s], itemHeight[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) }));
    }
  }
  
  public void mE(int paramInt)
  {
    if (paramInt >= 100)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      }
      this.gJ.setVisibility(8);
      return;
    }
    if (paramInt < 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      }
      this.gJ.setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramInt);
    this.gJ.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null) {
      this.b.Gr(this.mPosition);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$a.Gr(this.mPosition);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setHightlight(boolean paramBoolean)
  {
    CircleProgress localCircleProgress = this.g;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localCircleProgress.setVisibility(i);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Gr(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */