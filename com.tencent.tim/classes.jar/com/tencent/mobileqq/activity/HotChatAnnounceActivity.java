package com.tencent.mobileqq.activity;

import acfp;
import acfv;
import acgf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import anot;
import aqiw;
import arhz;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vdw;
import vdx;
import vdy;

public class HotChatAnnounceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public TextView DK;
  acgf jdField_a_of_type_Acgf = new vdw(this);
  BlockableEditTextView jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView;
  String aNC;
  public String aND;
  public String aNE;
  boolean aXw;
  BlockableEditTextView b;
  String mLink;
  public String mTroopUin;
  View tt;
  public View tu;
  arhz w;
  
  private void bwV()
  {
    try
    {
      if ((this.w != null) && (this.w.isShowing()))
      {
        this.w.dismiss();
        this.w.cancel();
      }
      this.w = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void showProgressDialog()
  {
    try
    {
      if ((this.w == null) && (!isFinishing()))
      {
        this.w = new arhz(this, getTitleBarHeight());
        this.w.setMessage(2131696693);
      }
      if ((this.w != null) && (!this.w.isShowing())) {
        this.w.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561378);
    setTitle(acfp.m(2131707187));
    setRightButton(2131695251, this);
    setLeftViewName(2131690700);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)super.findViewById(2131362728));
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.addTextChangedListener(new vdx(this));
    this.b = ((BlockableEditTextView)super.findViewById(2131370516));
    this.b.addTextChangedListener(new vdy(this));
    this.tu = super.findViewById(2131382048);
    this.tu.setOnClickListener(this);
    this.DK = ((TextView)super.findViewById(2131370396));
    this.tt = super.findViewById(2131370526);
    paramBundle = getIntent();
    this.mTroopUin = paramBundle.getStringExtra("TROOPUIN");
    this.aXw = paramBundle.getBooleanExtra("CANADDLINK", false);
    this.aNC = paramBundle.getStringExtra("ANNOUCE");
    this.mLink = paramBundle.getStringExtra("LINK");
    if (this.aXw) {
      this.tt.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setText(this.aNC);
      this.b.setText(this.mLink);
      if ((this.mLink != null) && (this.mLink.trim().length() > 0)) {
        this.tu.setEnabled(true);
      }
      this.app.addObserver(this.jdField_a_of_type_Acgf);
      return true;
      this.tt.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Acgf != null) {
      this.app.removeObserver(this.jdField_a_of_type_Acgf);
    }
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    if (paramView == this.rightViewText)
    {
      if (!aqiw.isNetSupport(this)) {
        QQToast.a(this, 0, 2131693404, 0).show(getTitleBarHeight());
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
        localObject1 = this.b.getText().toString();
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QQToast.a(this, 0, acfp.m(2131707192), 0).show(getTitleBarHeight());
        }
        else
        {
          if (((String)localObject2).getBytes().length / 3 <= 40) {
            break;
          }
          QQToast.a(this, 0, acfp.m(2131707186), 0).show(getTitleBarHeight());
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((String)localObject1).trim()))) {
        break label484;
      }
      localObject1 = null;
    }
    label484:
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).length() > 1024))
      {
        QQToast.a(this, 0, acfp.m(2131707194), 0).show(getTitleBarHeight());
        break;
      }
      acfv localacfv = (acfv)this.app.getBusinessHandler(35);
      HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(60)).a(this.mTroopUin);
      showProgressDialog();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatAnnounceActivity", 2, "onClick.contnet=" + (String)localObject2 + ",link=" + (String)localObject1);
      }
      anot.a(this.app, "CliOper", "", "", "0X8005D54", "0X8005D54", 0, 0, "", "", "", "");
      if (localHotChatInfo.userCreate == 1) {}
      for (boolean bool = localacfv.aw(localHotChatInfo.troopUin, (String)localObject2);; bool = localacfv.a(localHotChatInfo.uuid.getBytes(), (String)localObject2, (String)localObject1))
      {
        this.aND = ((String)localObject2);
        this.aNE = ((String)localObject1);
        if (bool) {
          break;
        }
        bwV();
        QQToast.a(this, 0, acfp.m(2131707190), 0).show(getTitleBarHeight());
        break;
      }
      if (paramView != this.tu) {
        break;
      }
      localObject2 = this.b.getText().toString();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("http")) {
        localObject1 = "http://" + (String)localObject2;
      }
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      startActivity((Intent)localObject2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity
 * JD-Core Version:    0.7.0.1
 */