package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqbn;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.CircleProgress;

public class QavPtvTemplateItemView
  extends QavListItemBase
{
  public boolean SW;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  RelativeLayout el;
  ImageView gJ;
  TextView mW;
  
  public QavPtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, QavListItemBase.c paramc, QavListItemBase.a parama)
  {
    if (paramc == null) {}
    do
    {
      return;
      super.a(paramInt, parama);
      setId(paramInt);
      setTag(paramc);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setTag(paramc);
      if (!TextUtils.isEmpty(paramc.id)) {
        break;
      }
    } while (this.el.getVisibility() == 4);
    this.el.setVisibility(4);
    return;
    if (this.el.getVisibility() != 0) {
      this.el.setVisibility(0);
    }
    if ("0".equals(paramc.id)) {
      if (TextUtils.isEmpty(paramc.iconurl)) {
        break label405;
      }
    }
    label385:
    label395:
    label405:
    for (paramInt = Integer.valueOf(paramc.iconurl).intValue();; paramInt = 0)
    {
      if (paramInt > 0)
      {
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(paramInt);
        if ((!paramc.usable) && (!paramc.id.equals("0"))) {
          break label374;
        }
        this.gJ.setVisibility(8);
        label160:
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
        setDimmed(paramc.XB);
        setHighlight(paramBoolean1);
        if (!paramc.XC) {
          break label395;
        }
        this.mW.setVisibility(0);
        parama = this.mW;
        if (!TextUtils.isEmpty(paramc.name)) {
          break label385;
        }
      }
      for (paramc = " ";; paramc = paramc.name)
      {
        parama.setText(paramc);
        return;
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(2130851770);
        break;
        if (TextUtils.isEmpty(paramc.iconurl)) {
          break;
        }
        parama = URLDrawable.URLDrawableOptions.obtain();
        paramInt = getResources().getDimensionPixelSize(2131298131);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(getResources().getColor(2131166111));
        localGradientDrawable.setShape(1);
        localGradientDrawable.setSize(paramInt, paramInt);
        parama.mRequestWidth = paramInt;
        parama.mRequestHeight = paramInt;
        parama.mFailedDrawable = localGradientDrawable;
        parama.mLoadingDrawable = localGradientDrawable;
        parama = URLDrawable.getDrawable(paramc.iconurl, parama);
        parama.setTag(aqbn.e(paramInt, paramInt));
        if (paramBoolean2) {
          parama.setDecodeHandler(aqbn.b);
        }
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parama);
        break;
        label374:
        this.gJ.setVisibility(0);
        break label160;
      }
      this.mW.setVisibility(8);
      return;
    }
  }
  
  public void a(QavListItemBase.c paramc, int paramInt)
  {
    if (paramInt % 2 == 0)
    {
      this.el.setBackgroundColor(Color.argb(255, 224, 176, 216));
      if (this.SW) {
        break label105;
      }
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setBackgroundColor(Color.argb(255, 168, 168, 236));
    }
    for (;;)
    {
      if ((paramc == null) || (!"0".equals(paramc.id))) {
        break label124;
      }
      setBackgroundColor(-16711681);
      return;
      this.el.setBackgroundColor(Color.argb(155, 224, 176, 216));
      break;
      label105:
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setBackgroundColor(getResources().getColor(2131166318));
    }
    label124:
    if (paramInt % 2 == 0)
    {
      setBackgroundColor(-7829368);
      return;
    }
    setBackgroundColor(-3355444);
  }
  
  public void bX(int paramInt1, int paramInt2)
  {
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131559972, this);
    int k = getResources().getColor(2131167304);
    int i;
    if (!this.SW) {
      i = getResources().getColor(2131165409);
    }
    for (int j = 2130846916;; j = 2130846917)
    {
      this.el = ((RelativeLayout)findViewById(2131374147));
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131373984));
      this.gJ = ((ImageView)findViewById(2131373980));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131373987));
      this.mW = ((TextView)findViewById(2131373986));
      this.gJ.setImageResource(j);
      updateSize(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(1.6F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, k, 100, i);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setOnClickListener(this);
      if (this.SW)
      {
        if ((this.el.getParent() instanceof LinearLayout)) {
          ((LinearLayout)this.el.getParent()).setGravity(83);
        }
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setDimmedColor(-47980);
      }
      return;
      i = getResources().getColor(2131166318);
    }
  }
  
  public int getPosition()
  {
    return this.mPosition;
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
  
  public void setDimmed(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setDimmed(paramBoolean);
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setHighlight(paramBoolean);
  }
  
  public void updateSize(int paramInt1, int paramInt2)
  {
    View localView = findViewById(2131374148);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavPtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */