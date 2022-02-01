package com.tencent.mobileqq.activity;

import acbh;
import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqiw;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class JDHongbaoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView DL;
  private TextView DM;
  private TextView DN;
  private String aNF;
  private String aNG;
  private String aNH;
  private boolean aXz;
  private URLImageView ag;
  private Animation an;
  private String aws;
  private RelativeLayout gH;
  private RelativeLayout gI;
  private String kN;
  private ImageView mCloseView;
  long mCreateTime = 0L;
  private String mSubTitle;
  private TextView mSubTitleView;
  private String mTips;
  private String mTitle;
  private TextView mTitleView;
  AlphaAnimation n;
  private TextView ni;
  private View ts;
  
  private void bPN()
  {
    ThreadManager.getUIHandler().postDelayed(new JDHongbaoActivity.1(this), 500L);
  }
  
  private void initViews()
  {
    this.gH = ((RelativeLayout)findViewById(2131377429));
    this.gH.setVisibility(4);
    this.mCloseView = ((ImageView)super.findViewById(2131369705));
    this.ag = ((URLImageView)super.findViewById(2131369804));
    this.mTitleView = ((TextView)super.findViewById(2131380544));
    this.mSubTitleView = ((TextView)super.findViewById(2131380542));
    this.DL = ((TextView)super.findViewById(2131380541));
    this.ni = ((TextView)super.findViewById(2131380543));
    this.DM = ((TextView)super.findViewById(2131380600));
    this.DN = ((TextView)super.findViewById(2131380742));
    this.gI = ((RelativeLayout)super.findViewById(2131377406));
    this.DM.setOnClickListener(this);
    this.DN.setOnClickListener(this);
    this.gI.setOnClickListener(this);
    this.mCloseView.setOnClickListener(this);
    this.an = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.an.setInterpolator(new a());
    this.an.setDuration(800L);
    this.ts = findViewById(2131368592);
    this.n = new AlphaAnimation(0.0F, 0.7F);
    this.n.setDuration(350L);
    this.n.setFillAfter(true);
  }
  
  private void setData()
  {
    this.mTitle = getIntent().getStringExtra("jd_hb_title");
    this.mSubTitle = getIntent().getStringExtra("jd_hb_subtitle");
    this.aXz = getIntent().getBooleanExtra("jd_hb_is_check_delay", true);
    this.aNF = getIntent().getStringExtra("jd_hb_detail_text");
    this.mTips = getIntent().getStringExtra("jd_hongbao_tips");
    this.kN = getIntent().getStringExtra("jd_hb_btn_text");
    this.aws = getIntent().getStringExtra("jd_hb_logo_url");
    this.aNG = getIntent().getStringExtra("jd_hb_detail_url");
    this.aNH = getIntent().getStringExtra("jd_hb_btn_url");
    this.mTitleView.setText(this.mTitle);
    this.mSubTitleView.setText(this.mSubTitle);
    this.DL.setText(this.aNF);
    this.ni.setText(this.mTips);
    if (this.aXz)
    {
      this.DN.setText(this.kN + ">");
      this.DN.setVisibility(0);
      this.DM.setVisibility(8);
      acbh.d(134247337, this.app);
    }
    for (;;)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getApplicationContext().getResources().getDrawable(2130845835);
      localObject = URLDrawable.getDrawable(this.aws, (URLDrawable.URLDrawableOptions)localObject);
      if ((this.ag != null) && (localObject != null)) {
        this.ag.setImageDrawable((Drawable)localObject);
      }
      return;
      this.DN.setVisibility(8);
      this.DM.setVisibility(0);
      this.DM.setText(this.kN);
      acbh.d(134247333, this.app);
    }
  }
  
  private void vM(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JDHongbaoActivity", 2, "showHongbaoResult jumpUrl " + paramString);
    }
    if (!aqiw.isNetSupport(this)) {
      QQToast.a(this, acfp.m(2131707512), 1).show();
    }
    while (paramString == null) {
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", true);
    localIntent.putExtra("finish_animation_up_down", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    setResult(-1);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.mCreateTime = System.currentTimeMillis();
    if (getIntent() == null)
    {
      finish();
      return false;
    }
    setContentView(2131558729);
    initViews();
    setData();
    bPN();
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vM(this.aNG);
      if (this.aXz)
      {
        acbh.d(134247339, this.app);
      }
      else
      {
        acbh.d(134247335, this.app);
        continue;
        acbh.d(134247334, this.app);
        vM(this.aNH);
        continue;
        acbh.d(134247338, this.app);
        vM(this.aNH);
        continue;
        if (System.currentTimeMillis() - this.mCreateTime >= 2000L)
        {
          finish();
          if (this.aXz) {
            acbh.d(134247340, this.app);
          } else {
            acbh.d(134247336, this.app);
          }
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
  
  public class a
    extends OvershootInterpolator
  {
    private boolean aXv;
    
    public a() {}
    
    public float getInterpolation(float paramFloat)
    {
      if ((!this.aXv) && (paramFloat > 0.7D))
      {
        this.aXv = true;
        JDHongbaoActivity.a(JDHongbaoActivity.this).setBackgroundColor(-16777216);
        JDHongbaoActivity.a(JDHongbaoActivity.this).startAnimation(JDHongbaoActivity.this.n);
      }
      return (float)(1.0D - Math.pow(2.718281828459045D, 5.0F * -paramFloat) * Math.cos(8.0F * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JDHongbaoActivity
 * JD-Core Version:    0.7.0.1
 */