package com.tencent.mobileqq.listentogether.ui;

import acfp;
import aiqd;
import aiqj;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aogk;
import aqbn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableImageView;
import com.tencent.widget.PatchedButton;
import wja;

public class MusicPanelView
  extends RelativeLayout
  implements View.OnClickListener
{
  ImageView AS;
  ImageView AT;
  ImageView AU;
  TextView AV;
  TextView Un;
  TextView Uo;
  AlphaClickableImageView a;
  private ObjectAnimator bK;
  int deT;
  Drawable dm;
  PatchedButton g;
  CircleProgress i;
  URLDrawable k;
  public View.OnClickListener mOnClickListener;
  private float wW;
  
  public MusicPanelView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(2131561195, this, true);
    setBackgroundResource(2130845691);
    this.AS = ((ImageView)findViewById(2131365364));
    this.a = ((AlphaClickableImageView)findViewById(2131378718));
    this.AV = ((TextView)findViewById(2131372126));
    this.AU = ((ImageView)findViewById(2131372105));
    this.AT = ((ImageView)findViewById(2131375399));
    this.i = ((CircleProgress)findViewById(2131372120));
    this.g = ((PatchedButton)findViewById(2131369980));
    this.Un = ((TextView)findViewById(2131372123));
    this.Uo = ((TextView)findViewById(2131372122));
    this.a.setOnClickListener(this);
    this.AU.setOnClickListener(this);
    this.AT.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.dm = getResources().getDrawable(2130845704);
    int j = wja.dp2px(8.0F, this.a.getResources());
    aiqd.i(this.a, j, j, j, j);
    this.deT = wja.dp2px(31.0F, getResources());
    j = getResources().getColor(2131167289);
    if ((ThemeUtil.curThemeId.equals("1103")) || (ThemeUtil.curThemeId.equals("2920"))) {
      j = getResources().getColor(2131167288);
    }
    this.i.setBgAndProgressColor(100, j, 100, getResources().getColor(2131167287));
    this.i.setBgAndProgressUseAlpha(false, false);
    this.i.setStrokeWidth(1.5F);
    this.i.setmShadowColor(0);
  }
  
  public void LT(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equals((String)this.AS.getTag()))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        int j = this.deT;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = j;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.dm;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.dm;
        localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTag(new int[] { this.deT / 2 });
        ((URLDrawable)localObject).setDecodeHandler(aqbn.z);
        ((URLDrawable)localObject).startDownload();
        this.AS.setImageDrawable((Drawable)localObject);
        this.AS.setTag(paramString);
        this.k = ((URLDrawable)localObject);
      }
      return;
    }
    this.AS.setImageDrawable(this.dm);
    this.AS.setTag("");
  }
  
  public void Q(int paramInt1, int paramInt2)
  {
    this.i.setVisibility(paramInt1);
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.i.setProgress(paramInt1);
      return;
      paramInt1 = paramInt2;
      if (paramInt2 > 100) {
        paramInt1 = 100;
      }
    }
  }
  
  public void Qd(int paramInt)
  {
    this.AU.setVisibility(paramInt);
    this.AU.setContentDescription(acfp.m(2131708603));
  }
  
  public void Qe(int paramInt)
  {
    this.Uo.setVisibility(paramInt);
    this.Uo.setContentDescription(acfp.m(2131708602));
  }
  
  public void Qf(int paramInt)
  {
    this.AT.setVisibility(paramInt);
    this.AT.setContentDescription(acfp.m(2131708598));
  }
  
  public void Qg(int paramInt)
  {
    this.g.setVisibility(paramInt);
    this.g.setContentDescription(acfp.m(2131708600));
  }
  
  public boolean apx()
  {
    if (this.bK == null) {
      return false;
    }
    return this.bK.isRunning();
  }
  
  public void di(int paramInt, String paramString)
  {
    this.Un.setVisibility(paramInt);
    this.Un.setText(paramString);
    this.Un.setContentDescription(paramString);
  }
  
  public void dtJ()
  {
    if (apx()) {
      return;
    }
    this.bK = ObjectAnimator.ofFloat(this.AS, "Rotation", new float[] { this.wW - 360.0F, this.wW });
    this.bK.setDuration(10000L);
    this.bK.setRepeatCount(-1);
    this.bK.setInterpolator(new LinearInterpolator());
    this.bK.addUpdateListener(new aiqj(this));
    this.bK.start();
  }
  
  public void dtK()
  {
    if (this.bK != null) {
      this.bK.end();
    }
    this.wW = 0.0F;
  }
  
  public void dtL()
  {
    if ((this.bK != null) && (apx())) {
      this.bK.cancel();
    }
  }
  
  public void eX(String paramString, int paramInt)
  {
    this.AV.setText(paramString);
    this.AV.setContentDescription(paramString);
    this.AV.setTextColor(getResources().getColor(paramInt));
    setContentDescription(paramString);
    aogk.a().p(getContext(), this);
  }
  
  public void iz(int paramInt1, int paramInt2)
  {
    this.a.setVisibility(paramInt1);
    if (paramInt2 == 1)
    {
      this.a.setImageResource(2130845705);
      this.a.setContentDescription(acfp.m(2131708601));
    }
    while (paramInt2 != 2) {
      return;
    }
    this.a.setImageResource(2130845706);
    this.a.setContentDescription(acfp.m(2131708599));
  }
  
  public void onClick(View paramView)
  {
    if (this.mOnClickListener != null) {
      this.mOnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.bK != null) {
      this.bK.cancel();
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      super.setBackgroundDrawable(null);
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void updateProgress(int paramInt)
  {
    this.i.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.MusicPanelView
 * JD-Core Version:    0.7.0.1
 */