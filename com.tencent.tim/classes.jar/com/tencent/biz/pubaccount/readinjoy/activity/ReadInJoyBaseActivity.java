package com.tencent.biz.pubaccount.readinjoy.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcl;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import khd;

public class ReadInJoyBaseActivity
  extends FragmentActivity
{
  public LeftRedDotRadioButton a;
  public RedDotRadioButton a;
  public RadioGroup d;
  public TextView leftView;
  public TextView leftViewNotBack;
  protected View mContentView;
  protected int mContentViewID = -1;
  protected float mDensity;
  public View mTitleContainer;
  public TextView nR;
  protected View.OnClickListener onBackListener = new khd(this);
  public ImageView rightViewImg;
  public TextView rightViewText;
  public RelativeLayout titleRoot;
  protected ViewGroup vg;
  
  private View ag()
  {
    this.nR = ((TextView)findViewById(2131369627));
    return this.nR;
  }
  
  @TargetApi(11)
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void init(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130851111));
    if (this.leftView == null)
    {
      this.vg = ((ViewGroup)findViewById(2131377363));
      setLayerType(this.vg);
      ag();
      onCreateLeftView();
      k();
      onCreateRightView();
      setLeftViewName(paramIntent);
    }
  }
  
  protected ViewGroup k()
  {
    this.d = ((RadioGroup)findViewById(2131369620));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton = ((LeftRedDotRadioButton)findViewById(2131369632));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)findViewById(2131369633));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setFocusable(true);
    setLayerType(this.d);
    return this.d;
  }
  
  public boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  protected View onCreateLeftView()
  {
    this.leftView = ((TextView)findViewById(2131369579));
    this.leftView.setOnClickListener(this.onBackListener);
    setLayerType(this.leftView);
    if (AppSetting.enableTalkBack) {
      aqcl.changeAccessibilityForView(this.leftView, Button.class.getName());
    }
    return this.leftView;
  }
  
  protected View onCreateRightView()
  {
    this.rightViewImg = ((ImageView)findViewById(2131369594));
    setLayerType(this.rightViewImg);
    return this.rightViewText;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
  }
  
  public void setContentView(int paramInt)
  {
    if (!this.mNeedStatusTrans)
    {
      super.setContentView(paramInt);
      this.mContentViewID = paramInt;
      getWindow().setFeatureInt(7, 2131559119);
    }
    do
    {
      if (this.mTitleContainer != null) {
        this.mTitleContainer.setVisibility(0);
      }
      this.mDensity = getResources().getDisplayMetrics().density;
      init(getIntent());
      return;
      Object localObject2 = LayoutInflater.from(this);
      Object localObject1 = ((LayoutInflater)localObject2).inflate(2131560386, null);
      try
      {
        localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, (ViewGroup)localObject1, false);
        this.titleRoot = ((RelativeLayout)((View)localObject1).findViewById(2131379881));
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.titleRoot.setFitsSystemWindows(true);
          this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131377363);
        this.titleRoot.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        this.mContentView = ((View)localObject2);
        super.setContentView(this.titleRoot);
        i = 0;
      }
      catch (InflateException localInflateException)
      {
        for (;;)
        {
          localInflateException.printStackTrace();
          i = 1;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          localRuntimeException.printStackTrace();
          int i = 1;
        }
      }
    } while (i == 0);
    if (QLog.isColorLevel()) {
      QLog.e("IphoneTitleBarActivity", 2, "layout with merge ,use framelayout to immersive" + getComponentName());
    }
    super.setContentView(paramInt);
    this.mContentViewID = paramInt;
    getWindow().setFeatureInt(7, 2131559119);
    if (this.mTitleContainer != null) {
      this.mTitleContainer.setVisibility(0);
    }
    this.mDensity = getResources().getDisplayMetrics().density;
    init(getIntent());
  }
  
  public void setLeftViewName(Intent paramIntent)
  {
    if ((this.leftView != null) && ((this.leftView instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.leftView;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent.getExtras().getInt("individuation_url_type");
      paramIntent = str;
      if (str == null) {
        paramIntent = getString(2131691039);
      }
      localTextView.setText(paramIntent);
      localTextView.setVisibility(0);
      if (AppSetting.enableTalkBack)
      {
        str = this.leftView.getText().toString();
        paramIntent = str;
        if (!str.contains(getString(2131691039))) {
          paramIntent = getString(2131691039) + str;
        }
        this.leftView.setContentDescription(paramIntent);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.nR != null) && ((this.nR instanceof TextView)))
    {
      this.nR.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseActivity
 * JD-Core Version:    0.7.0.1
 */