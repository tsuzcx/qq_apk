package com.tencent.mobileqq.richmedia.capture.view;

import acfp;
import alvx.a;
import alwd;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import anjo;
import anot;
import aqbn;
import aqmr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import wja;

public class PtvTemplateItemView
  extends LinearLayout
  implements View.OnClickListener
{
  ImageView De;
  ImageView Df;
  CircleProgress a;
  public URLImageView aD;
  alvx.a b;
  URLImageView bB;
  boolean bnq;
  RelativeLayout el;
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
  
  public void a(int paramInt, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, alvx.a parama)
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
    this.el.setTag(paramPtvTemplateInfo);
    alwd.a();
    paramInt = alwd.dyy;
    boolean bool;
    label265:
    int i;
    if ((paramPtvTemplateInfo.funcType == PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) && (anjo.lC(paramInt)))
    {
      bool = true;
      this.bnq = bool;
      if (TextUtils.isEmpty(paramPtvTemplateInfo.iconurl)) {
        break label569;
      }
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
      parama = alwd.a().b();
      if ((parama == null) || (!paramPtvTemplateInfo.id.equals(parama.id)) || (!paramPtvTemplateInfo.usable)) {
        break label509;
      }
      this.De.setVisibility(0);
      if (!this.bnq) {
        break label520;
      }
      this.De.setImageResource(2130846854);
      paramInt = getResources().getColor(2131167304);
      i = Color.parseColor("#E62555");
      this.a.setBgAndProgressColor(30, paramInt, 100, i);
      label312:
      bool = alwd.a().needShowRedDot(3, paramPtvTemplateInfo.categoryId, paramPtvTemplateInfo.id);
      if (!paramPtvTemplateInfo.advertisement) {
        break label650;
      }
      this.Df.setVisibility(8);
      this.a.setVisibility(8);
      if (aqmr.isEmpty(paramPtvTemplateInfo.badgeurl)) {
        break label638;
      }
    }
    for (;;)
    {
      try
      {
        this.bB.setVisibility(0);
        parama = URLDrawable.getDrawable(paramPtvTemplateInfo.badgeurl);
        this.bB.setImageDrawable(parama);
        parama = this.bB.getLayoutParams();
        parama.height = 42;
        parama.width = 42;
        this.bB.setLayoutParams(parama);
        anot.a(null, "dc00898", "", "", "0X800859E", "0X800859E", 1, 0, "", "", paramPtvTemplateInfo.id, "");
        parama = paramPtvTemplateInfo.name;
        if (!paramPtvTemplateInfo.usable) {
          break label874;
        }
        paramPtvTemplateInfo = parama + acfp.m(2131710196);
        this.aD.setContentDescription(paramPtvTemplateInfo);
        this.el.setOnClickListener(this);
        return;
        bool = false;
        break;
        label509:
        this.De.setVisibility(4);
        break label265;
        label520:
        this.De.setImageResource(2130846853);
        paramInt = getResources().getColor(2131167304);
        i = getResources().getColor(2131165409);
        this.a.setBgAndProgressColor(30, paramInt, 100, i);
        break label312;
        label569:
        if (!"0".equals(paramPtvTemplateInfo.id)) {
          break label312;
        }
        this.De.setVisibility(4);
        if (alwd.a().b() == null)
        {
          this.aD.setImageResource(2130846851);
          break label312;
        }
        this.aD.setImageResource(2130846852);
      }
      catch (Exception parama)
      {
        this.bB.setVisibility(8);
        continue;
      }
      label638:
      this.bB.setVisibility(8);
      continue;
      label650:
      this.bB.setVisibility(8);
      if (this.bnq)
      {
        this.Df.setImageResource(2130850737);
        this.Df.setVisibility(0);
        if (paramPtvTemplateInfo.downloading) {
          this.a.setVisibility(0);
        } else {
          this.a.setVisibility(8);
        }
      }
      else if (bool)
      {
        if (paramPtvTemplateInfo.downloading)
        {
          this.Df.setVisibility(8);
          this.a.setVisibility(0);
        }
        else
        {
          this.Df.setImageResource(2130846850);
          this.Df.setVisibility(0);
          this.a.setVisibility(8);
        }
      }
      else if ((paramPtvTemplateInfo.usable) || (paramPtvTemplateInfo.id.equals("0")))
      {
        this.Df.setVisibility(8);
        this.a.setVisibility(8);
      }
      else if (paramPtvTemplateInfo.downloading)
      {
        this.Df.setVisibility(8);
        this.a.setVisibility(0);
      }
      else
      {
        this.Df.setImageResource(2130846849);
        this.Df.setVisibility(0);
        this.a.setVisibility(8);
        continue;
        label874:
        if (paramPtvTemplateInfo.downloading) {
          paramPtvTemplateInfo = parama + acfp.m(2131710195);
        } else {
          paramPtvTemplateInfo = parama + acfp.m(2131710197);
        }
      }
    }
  }
  
  public void c(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (((PtvTemplateManager.PtvTemplateInfo)this.el.getTag()).id.equals(paramPtvTemplateInfo.id))
    {
      if (paramInt < 100) {
        break label55;
      }
      this.a.setVisibility(8);
      if (!this.bnq) {
        this.Df.setVisibility(8);
      }
    }
    label55:
    do
    {
      do
      {
        return;
        if (paramInt >= 0) {
          break;
        }
        this.a.setVisibility(8);
      } while (this.bnq);
      this.Df.setImageResource(2130846849);
      this.Df.setVisibility(0);
      return;
      this.a.setVisibility(0);
      this.a.setProgress(paramInt);
    } while (this.bnq);
    this.Df.setVisibility(8);
  }
  
  public void initViews()
  {
    int i = wja.dp2px(60.0F, getResources());
    int j = wja.dp2px(60.0F, getResources());
    setLayoutParams(new AbsListView.LayoutParams(j, j));
    setGravity(17);
    this.el = new RelativeLayout(this.mContext);
    this.aD = new URLImageView(this.mContext);
    Object localObject = new RelativeLayout.LayoutParams(j, j);
    this.aD.setMinimumWidth(j);
    this.aD.setMinimumHeight(j);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.el.addView(this.aD, (ViewGroup.LayoutParams)localObject);
    this.De = new ImageView(this.mContext);
    this.De.setImageResource(2130846853);
    this.De.setAlpha(204);
    this.De.setMinimumWidth(i);
    this.De.setMinimumHeight(i);
    this.De.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.De.setVisibility(4);
    this.el.addView(this.De, (ViewGroup.LayoutParams)localObject);
    j = wja.dp2px(28.0F, getResources());
    int k = getResources().getColor(2131167304);
    int m = getResources().getColor(2131165409);
    this.a = new CircleProgress(this.mContext);
    localObject = new RelativeLayout.LayoutParams(j, j);
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    this.a.setMinimumHeight(j);
    this.a.setMinimumWidth(j);
    this.a.setStrokeWidth(2.0F);
    this.a.setBgAndProgressColor(30, k, 100, m);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.el.addView(this.a, (ViewGroup.LayoutParams)localObject);
    this.Df = new ImageView(this.mContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.el.addView(this.Df, (ViewGroup.LayoutParams)localObject);
    this.bB = new URLImageView(this.mContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.el.addView(this.bB, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    addView(this.el, (ViewGroup.LayoutParams)localObject);
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null) {
      this.b.Gr(this.mPosition);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */