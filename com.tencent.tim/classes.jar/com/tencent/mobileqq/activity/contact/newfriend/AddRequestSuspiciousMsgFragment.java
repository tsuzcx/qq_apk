package com.tencent.mobileqq.activity.contact.newfriend;

import acfd;
import acff;
import anaz;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqdj;
import aqgv;
import aqiw;
import aqnm;
import arhz;
import ausj;
import auss;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;
import yrs;
import yrt;

public class AddRequestSuspiciousMsgFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private acfd jdField_a_of_type_Acfd = new yrs(this);
  private SysSuspiciousMsg jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg;
  private arhz c;
  private QQAppInterface mApp;
  
  private void cld()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("base_uin", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin));
    localBundle.putString("base_nick", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
    localBundle.putInt("verfy_type", 0);
    localBundle.putString("verfy_msg", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg);
    AutoRemarkActivity.a(getActivity(), 0, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "", 0L, localBundle);
  }
  
  private void cle()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AddRequestSuspiciousMsgFragment", 2, "gotoReply ");
    }
    anot.a(this.mApp, "dc00898", "", "", "0X800A330", "0X800A330", 0, 0, "", "", "", "");
    Object localObject = (acff)this.mApp.getManager(51);
    boolean bool = ((acff)localObject).isFriend(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    Intent localIntent = wja.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    localIntent.putExtra("add_friend_source_id", 3041);
    if (bool)
    {
      localObject = ((acff)localObject).e(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
      if (localObject != null)
      {
        localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
        localIntent.putExtra("uinname", aqgv.c((Friends)localObject));
      }
      if (!bool) {
        break label333;
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", i);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key.length > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddRequestSuspiciousMsgFragment", 2, "has session key " + this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
        }
        this.mApp.a().z(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin), this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key);
      }
      startActivity(localIntent);
      return;
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
      break;
      label333:
      i = 1022;
    }
  }
  
  private void dismissProgressDialog()
  {
    if ((this.c != null) && (this.c.isShowing())) {
      this.c.dismiss();
    }
  }
  
  private void initView()
  {
    if (this.mContentView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddRequestSuspiciousMsgFragment", 2, "initView msg null");
        }
        this.mContentView.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.mContentView.setBackgroundResource(2130838901);
    setTitle(getString(2131720687));
    this.mContentView.findViewById(2131364064).setOnClickListener(this);
    Object localObject1 = aqdj.a(this.mApp, 1, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    ((ImageView)this.mContentView.findViewById(2131366624)).setBackgroundDrawable((Drawable)localObject1);
    ((TextView)this.mContentView.findViewById(2131372384)).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
    TextView localTextView2 = (TextView)this.mContentView.findViewById(2131364063);
    Object localObject2 = (TextView)this.mContentView.findViewById(2131364061);
    TextView localTextView1 = (TextView)this.mContentView.findViewById(2131364062);
    localObject1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 1)
    {
      localObject1 = getString(2131695654);
      localTextView2.setVisibility(0);
      localTextView2.setText((CharSequence)localObject1);
      localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age <= 0) {
        break label674;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age + getString(2131720665);
      ((TextView)localObject2).setVisibility(0);
      label269:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localTextView1.setVisibility(8);
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131381502);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131381511);
      ((TextView)localObject2).setSingleLine(false);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg != null) {
        break label683;
      }
      localObject1 = "";
      label329:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key == null) {
        break label694;
      }
      this.mContentView.findViewById(2131377157).setOnClickListener(this);
      label358:
      localObject2 = (TextView)this.mContentView.findViewById(2131372033);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.source != null) {
        break label712;
      }
      localObject1 = "";
      label385:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131365366);
      if ((((LinearLayout)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).getLayoutParams()).topMargin = 0;
      }
      localObject1 = (TextView)this.mContentView.findViewById(2131379996);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason)) {
        break label723;
      }
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason);
    }
    for (;;)
    {
      localObject2 = getResources().getDrawable(2130848673);
      ((Drawable)localObject2).setBounds(0, 0, aqnm.dip2px(16.0F), aqnm.dip2px(16.0F));
      ((TextView)localObject1).setCompoundDrawablePadding(aqnm.dip2px(5.0F));
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      this.mContentView.findViewById(2131377045).setVisibility(8);
      localObject1 = (Button)this.mContentView.findViewById(2131362354);
      ((Button)localObject1).setText(2131690093);
      if ((((Button)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)((Button)localObject1).getLayoutParams();
        int i = aqnm.dip2px(10.0F);
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i;
      }
      ((Button)localObject1).setOnClickListener(this);
      this.mContentView.findViewById(2131378251).setVisibility(8);
      this.mContentView.findViewById(2131361950).setVisibility(8);
      this.mContentView.findViewById(2131361951).setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 2)
      {
        localObject1 = getString(2131693477);
        localTextView2.setVisibility(0);
        break;
      }
      localTextView2.setVisibility(8);
      break;
      label674:
      ((TextView)localObject2).setVisibility(8);
      break label269;
      label683:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg;
      break label329;
      label694:
      this.mContentView.findViewById(2131377157).setVisibility(8);
      break label358;
      label712:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.source;
      break label385;
      label723:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  private void showProgressDialog()
  {
    if (this.c == null) {
      this.c = new arhz(getActivity());
    }
    if (!this.c.isShowing()) {
      this.c.show();
    }
  }
  
  void bFN()
  {
    ausj localausj = (ausj)auss.a(getActivity(), null);
    localausj.addButton(getString(2131691293), 3);
    localausj.a(new yrt(this, localausj));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    initView();
  }
  
  public int getContentLayoutId()
  {
    return 2131561716;
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
      anot.a(this.mApp, "dc00898", "", "", "0X800A32F", "0X800A32F", 0, 0, "", "", "", "");
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "", 108);
      ProfileActivity.b(getActivity(), localAllInOne);
      continue;
      cle();
      continue;
      anot.a(this.mApp, "dc00898", "", "", "0X800A32C", "0X800A32C", 2, 0, "", "", "", "");
      if (!aqiw.isNetworkAvailable(getActivity()))
      {
        QQToast.a(getActivity(), 2131696284, 0).show();
      }
      else
      {
        ((FriendListHandler)this.mApp.getBusinessHandler(1)).ht(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
        showProgressDialog();
        continue;
        bFN();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getSerializableExtra("msg_extra");
    if ((paramBundle instanceof SysSuspiciousMsg))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg = ((SysSuspiciousMsg)paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("AddRequestSuspiciousMsgFragment", 2, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.toString());
      }
    }
    this.mApp = getActivity().app;
    this.mApp.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  public void onDestroy()
  {
    dismissProgressDialog();
    this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment
 * JD-Core Version:    0.7.0.1
 */