package com.tencent.mobileqq.activity.contact.newfriend;

import acfp;
import achg;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import arhz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import yqv;
import yrz;
import ysf;

public class NewFriendActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener, BaseNewFriendView.a
{
  public static int caU = -1;
  private TextView LQ;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$a;
  private SystemMsgListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView;
  private Drawable ad;
  ysf b;
  private FrameLayout bg;
  private TextView mLeftBackText;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  private TextView mTitleText;
  public arhz progressDialog;
  
  public static void g(Context paramContext, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, NewFriendActivity.class);
    localIntent.putExtra("EntranceId", paramInt);
    localIntent.setFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.excute(new NewFriendActivity.2(paramQQAppInterface, paramString), 16, null, false);
  }
  
  void Ey(int paramInt)
  {
    if ((!isFinishing()) && (this.progressDialog == null))
    {
      this.progressDialog = new arhz(this, getTitleBarHeight());
      this.progressDialog.setOnDismissListener(new yrz(this));
      this.progressDialog.setMessage(paramInt);
      this.progressDialog.setCanceledOnTouchOutside(false);
      this.progressDialog.setCancelable(false);
      this.progressDialog.show();
    }
  }
  
  public boolean Uj()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$a.hasMessages(1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$a.removeMessages(1);
      bool = true;
    }
    if (this.progressDialog != null)
    {
      this.progressDialog.cancel();
      this.progressDialog = null;
      return true;
    }
    return bool;
  }
  
  public void clf()
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$a.obtainMessage(1, 2131719519, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$a.sendMessageDelayed(localMessage, 1000L);
  }
  
  void clj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = new SystemMsgListView(this, this.mFlingHandler);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(getIntent(), this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.onStart();
      if (isResume()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.onResume();
      }
      this.bg.removeAllViews();
      this.bg.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$a = new a(this);
    this.b = ((ysf)this.app.getManager(34));
    setContentView(2131561500);
    setContentBackgroundResource(2130838900);
    paramBundle = (LinearLayout)findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.bg = ((FrameLayout)findViewById(2131369269));
    this.mTitleText = ((TextView)findViewById(2131369627));
    this.mLeftBackText = ((TextView)findViewById(2131369579));
    this.mLeftBackText.setOnClickListener(this);
    this.LQ = ((TextView)findViewById(2131369612));
    this.LQ.setVisibility(0);
    this.LQ.setOnClickListener(this);
    this.LQ.setText(2131721053);
    this.mTitleText.setText(2131696301);
    clj();
    if (AppSetting.enableTalkBack)
    {
      this.mTitleText.setContentDescription(this.mTitleText.getText());
      this.LQ.setContentDescription(this.LQ.getText());
      this.mLeftBackText.setContentDescription(getString(2131695648) + acfp.m(2131709053));
    }
    paramBundle = (achg)this.app.getManager(159);
    if (paramBundle != null) {
      paramBundle.iu(4);
    }
    yqv.a(this.app).zf(this.app.getCurrentAccountUin());
    paramBundle = getIntent().getStringExtra("from");
    int j = getIntent().getIntExtra("fromSubType", -1);
    int i;
    if (("from_lsa".equals(paramBundle)) || ("from_notification".equals(paramBundle)))
    {
      i = j;
      if (j == -1) {
        i = caU;
      }
      if (i != 6) {
        break label407;
      }
      h(this.app, "0X800A182");
    }
    for (;;)
    {
      paramBundle = (ysf)this.app.getManager(34);
      paramBundle.boA = false;
      paramBundle.boz = false;
      return true;
      label407:
      if ((i == 9) || (i == 10) || (i == 1)) {
        h(this.app, "0X8009CBC");
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.onPause();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.onResume();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.onStart();
    }
  }
  
  public void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.onStop();
    }
    super.doOnStop();
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public QQAppInterface getApp()
  {
    return this.app;
  }
  
  public void hf()
  {
    if (this.ad == null)
    {
      this.ad = getResources().getDrawable(2130839657);
      this.mOldDrawables = this.mTitleText.getCompoundDrawables();
      this.mOldPadding = this.mTitleText.getCompoundDrawablePadding();
      this.mTitleText.setCompoundDrawablePadding(10);
      this.mTitleText.setCompoundDrawablesWithIntrinsicBounds(this.ad, this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
      ((Animatable)this.ad).start();
    }
  }
  
  public void hg()
  {
    if (this.ad != null)
    {
      ((Animatable)this.ad).stop();
      this.ad = null;
      this.mTitleText.setCompoundDrawablePadding(this.mOldPadding);
      this.mTitleText.setCompoundDrawablesWithIntrinsicBounds(this.mOldDrawables[0], this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      Intent localIntent = new Intent(this, AddContactsActivity.class);
      localIntent.putExtra("entrence_data_report", 3);
      localIntent.putExtra("EntranceId", 6);
      startActivityForResult(localIntent, 221);
      this.b.cls();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  static class a
    extends Handler
  {
    private WeakReference<NewFriendActivity> r;
    
    public a(NewFriendActivity paramNewFriendActivity)
    {
      this.r = new WeakReference(paramNewFriendActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      NewFriendActivity localNewFriendActivity = (NewFriendActivity)this.r.get();
      if (localNewFriendActivity == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        throw new RuntimeException("Unknown message: " + paramMessage.what);
      case 1: 
        localNewFriendActivity.Ey(paramMessage.arg1);
        return;
      }
      localNewFriendActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity
 * JD-Core Version:    0.7.0.1
 */