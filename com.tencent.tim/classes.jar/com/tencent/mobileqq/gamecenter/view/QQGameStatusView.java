package com.tencent.mobileqq.gamecenter.view;

import acfp;
import ahtz;
import ahuq;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class QQGameStatusView
  extends LinearLayout
{
  private ImageView Ax;
  private TextView TE;
  private TextView TK;
  private a jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView$a;
  private ScrollTextView jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView;
  private String aJb = "";
  private int dbk = 2;
  private String gameAppId = "";
  private boolean isLoading;
  private RelativeLayout kH;
  
  public QQGameStatusView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public QQGameStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void dqh()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView = new ScrollTextView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setId(2131380507);
    this.kH.removeAllViews();
    this.kH.addView(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView, localLayoutParams);
  }
  
  private void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131559362, this);
    this.Ax = ((ImageView)findViewById(2131369022));
    this.TE = ((TextView)findViewById(2131380727));
    this.kH = ((RelativeLayout)findViewById(2131370154));
    this.TK = ((TextView)findViewById(2131380545));
    this.TK.setText(acfp.m(2131711738));
    this.isLoading = false;
    this.TK.setOnClickListener(new ahuq(this));
  }
  
  public void KD(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.TK.setBackgroundDrawable(ahtz.a(new ColorDrawable(-16776961), new ColorDrawable(-16776961), "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png"));
      return;
    }
    this.TK.setBackgroundDrawable(ahtz.a(new ColorDrawable(Color.parseColor("#fdb106")), new ColorDrawable(Color.parseColor("#fdb106")), "https://i.gtimg.cn/channel/imglib/201908/upload_054783d98dd3b4888304e66fa1f8e7fa.png", "https://i.gtimg.cn/channel/imglib/201908/upload_054783d98dd3b4888304e66fa1f8e7fa.png"));
  }
  
  public void KK(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.aJb = paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    this.gameAppId = paramString1;
    this.Ax.setImageResource(2130847948);
    this.TE.setText("");
    dqh();
    this.TK.setText(acfp.m(2131711743));
    this.dbk = 2;
    KD(true);
    this.isLoading = false;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString1.mLoadingDrawable = getResources().getDrawable(2130847948);
      paramString1.mFailedDrawable = getResources().getDrawable(2130847948);
      this.Ax.setImageDrawable(URLDrawable.getDrawable(paramString2, paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.TE.setText(paramString3 + "");
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setShowPriority(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setFactory(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setInterSwitcTime(2000L);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setText("");
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setTextArray(paramArrayOfString);
    }
    while (paramInt <= 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setText(paramInt + acfp.m(2131711747));
  }
  
  public void eO(String paramString, int paramInt)
  {
    if (!paramString.equals(this.gameAppId)) {
      return;
    }
    paramString = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.TK.setText(paramString);
      this.dbk = paramInt;
      return;
      paramString = acfp.m(2131711740);
      KD(true);
      continue;
      paramString = acfp.m(2131711742);
      KD(true);
      continue;
      paramString = acfp.m(2131711744);
      KD(true);
      continue;
      paramString = acfp.m(2131711746);
      KD(true);
      continue;
      paramString = acfp.m(2131711739);
      KD(true);
      continue;
      paramString = acfp.m(2131711745);
      KD(false);
    }
  }
  
  public void gk(String paramString1, String paramString2)
  {
    if ((this.dbk == 5) && (this.gameAppId.equals(paramString1))) {
      this.TK.setText(paramString2 + "%");
    }
  }
  
  public void hideLoading()
  {
    this.isLoading = false;
    eO(this.gameAppId, this.dbk);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView$a = parama;
  }
  
  public void showLoading()
  {
    this.isLoading = true;
    this.TK.setText("等待中");
  }
  
  public static abstract interface a
  {
    public abstract void KC(String paramString);
    
    public abstract void KD(String paramString);
    
    public abstract void KE(String paramString);
    
    public abstract void KF(String paramString);
    
    public abstract void gj(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGameStatusView
 * JD-Core Version:    0.7.0.1
 */