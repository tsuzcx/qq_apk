package com.tencent.mobileqq.activity.registerGuideLogin;

import aamp;
import aciu;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.io.InputStream;

public class RegisterGuideView
  extends GuideBaseFragment
  implements View.OnClickListener
{
  private View bottomBar;
  private Button fa;
  private Button fb;
  
  public RegisterGuideView() {}
  
  @SuppressLint({"ValidFragment"})
  public RegisterGuideView(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131363905) && (i == 2131363964)) {}
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.mAppInterface, "CliOper", "", "", "0X8007575", "0X8007575", 0, 0, "", "", "", "");
      anot.c(this.mAppInterface, "dc00898", "", "", "0X800AA26", "0X800AA26", 0, 0, "", "", "", "");
      Object localObject = this.m.getIntent();
      ((Intent)localObject).putExtra("from_register_guide", true);
      ((Intent)localObject).putExtra("is_need_show_logo_animation", true);
      localObject = aamp.a(this.m, this.mAppInterface);
      if (this.a != null)
      {
        this.a.a((GuideBaseFragment)localObject);
        continue;
        anot.a(this.mAppInterface, "CliOper", "", "", "0X8007576", "0X8007576", 0, 0, "", "", "", "");
        anot.c(this.mAppInterface, "dc00898", "", "", "0X800AA25", "0X800AA25", 0, 0, "", "", "", "");
        localObject = new Intent(this.m, RegisterPhoneNumActivity.class);
        ((Intent)localObject).putExtra("key_register_from", 2);
        ((Intent)localObject).putExtra("leftViewText", this.m.getString(2131691039));
        ((Intent)localObject).addFlags(67108864);
        this.m.startActivity((Intent)localObject);
      }
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    if (getActivity() != null)
    {
      localObject = getActivity();
      if (this.mAppInterface != null) {}
      for (str = this.mAppInterface.getCurrentAccountUin();; str = "") {
        return aciu.a((Context)localObject, str);
      }
    }
    Object localObject = BaseApplicationImpl.getContext();
    if (this.mAppInterface != null) {}
    for (String str = this.mAppInterface.getCurrentAccountUin();; str = "") {
      return aciu.a((Context)localObject, str);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559503, paramViewGroup, false);
    this.bottomBar = paramViewGroup.findViewById(2131363629);
    this.bottomBar.setVisibility(0);
    this.fa = ((Button)paramViewGroup.findViewById(2131363905));
    this.fb = ((Button)paramViewGroup.findViewById(2131363964));
    this.fa.setOnClickListener(this);
    this.fb.setOnClickListener(this);
    paramBundle = (ImageView)paramViewGroup.findViewById(2131378652);
    paramLayoutInflater = "splash.jpg";
    for (;;)
    {
      try
      {
        if (paramViewGroup.getContext().getResources().getDisplayMetrics().widthPixels > 1500) {
          paramLayoutInflater = "splash_big.jpg";
        }
        paramLayoutInflater = getActivity().getAssets().open(paramLayoutInflater);
        paramBundle.setImageDrawable(new BitmapDrawable(getResources(), paramLayoutInflater));
      }
      catch (Throwable paramLayoutInflater)
      {
        QLog.e("LoginActivity.RegisterGuideView", 1, "onCreateView error2:" + paramLayoutInflater.getMessage());
        continue;
      }
      try
      {
        paramLayoutInflater.close();
        anot.c(this.mAppInterface, "dc00898", "", "", "0X800AA24", "0X800AA24", 0, 0, "", "", "", "");
        V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
        return paramViewGroup;
      }
      catch (Throwable paramLayoutInflater)
      {
        QLog.e("LoginActivity.RegisterGuideView", 1, "onCreateView error1:" + paramLayoutInflater.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.RegisterGuideView
 * JD-Core Version:    0.7.0.1
 */