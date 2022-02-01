package com.tencent.mobileqq.activity;

import acll;
import aclm;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import aqiw;
import arhz;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import uhm;
import uhn;
import uho;

public class AuthDevRenameActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  public static String aLk = "uin";
  public static String aLl = "appname";
  public static String aLm = "appid";
  public static String aLn = "sub_appid";
  public static String aLo = "device_guid";
  public static String aLp = "target_name";
  public static String aLq = "target_type_info";
  public static String aLr = "target_desc";
  public static String aLs = "index";
  private aclm b = new uhn(this);
  private ClearableEditText c;
  private Handler mHandler = new uho(this);
  private arhz w;
  
  private void bwV()
  {
    this.mHandler.post(new AuthDevRenameActivity.5(this));
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new AuthDevRenameActivity.4(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561303);
    super.addObserver(this.b);
    super.setRightButton(2131693182, this);
    this.leftView.setText(2131721058);
    this.leftView.setOnClickListener(this);
    if ((this.centerView != null) && ((this.centerView instanceof TextView))) {
      this.centerView.setVisibility(8);
    }
    paramBundle = super.getIntent();
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getStringExtra(aLp);
      paramBundle = paramBundle.getStringExtra(aLq);
    }
    for (;;)
    {
      Object localObject = super.findViewById(2131379823);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131379865);
        if (localTextView != null) {
          localTextView.setText(2131693240);
        }
        localObject = (TextView)((View)localObject).findViewById(2131379802);
        if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((TextView)localObject).setText(paramBundle);
        }
      }
      for (;;)
      {
        this.c = ((ClearableEditText)super.findViewById(2131363108));
        if (!TextUtils.isEmpty(str)) {
          this.c.setHint(str);
        }
        this.c.setImeOptions(6);
        this.c.setOnEditorActionListener(this);
        this.c.setImeActionLabel(getString(2131721076), 6);
        this.c.setFilters(new InputFilter[] { new uhm(this) });
        return true;
        super.setTitle(2131693240);
      }
      paramBundle = null;
      str = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!aqiw.isNetSupport(this))
      {
        QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
      }
      else
      {
        Object localObject1 = this.c.getEditableText().toString();
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QQToast.a(this, getString(2131693202), 0).show(getTitleBarHeight());
        }
        else
        {
          Object localObject2 = super.getIntent();
          if (localObject2 == null) {
            break;
          }
          String str = ((Intent)localObject2).getStringExtra(aLp);
          if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, (CharSequence)localObject1))) {
            break;
          }
          localObject2 = ((Intent)localObject2).getExtras();
          ((Bundle)localObject2).putString(aLp, (String)localObject1);
          ((Bundle)localObject2).putString(aLk, this.app.getCurrentAccountUin());
          localObject1 = (acll)this.app.getBusinessHandler(34);
          if (localObject1 == null) {
            break;
          }
          showProgressDialog();
          ((acll)localObject1).cj((Bundle)localObject2);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    bwV();
    super.onDestroy();
    super.removeObserver(this.b);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      onClick(this.rightViewText);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity
 * JD-Core Version:    0.7.0.1
 */