package com.tencent.mobileqq.activity.phone;

import acfp;
import aelc;
import aelc.a;
import aeld;
import akwl;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqiw;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import yuw;

@SuppressLint({"ViewConstructor"})
public class PhoneMatchView
  extends BaseActivityView
  implements Handler.Callback, View.OnClickListener
{
  private Handler cf = new auru(Looper.getMainLooper(), this);
  private Button eM;
  akwl k;
  
  public PhoneMatchView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    aY(2131559422, true);
  }
  
  private void crs()
  {
    if (!aqiw.isNetSupport(getContext()))
    {
      showToast(2131696348);
      return;
    }
    PhoneMatchView.1 local1 = new PhoneMatchView.1(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.mActivity, new DenyRunnable.a(this.app));
    yuw.a(this.mActivity, this.app, local1, localDenyRunnable);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    paramIntent = (PhoneContactManagerImp)this.app.getManager(11);
    Object localObject = aeld.b();
    if (paramIntent.Uw())
    {
      paramIntent = ((aelc)localObject).b.title;
      paramPhoneInnerFrame = ((aelc)localObject).b.subTitle;
      localObject = ((aelc)localObject).b.buttonTitle;
      ((TextView)E(2131365248)).setText(paramIntent);
      ((TextView)E(2131365247)).setText(paramPhoneInnerFrame);
      this.eM = ((Button)E(2131365245));
      this.eM.setOnClickListener(this);
      this.eM.setText((CharSequence)localObject);
      paramIntent = E(2131370144);
      if ((paramIntent == null) || (!"1000".equals(ThemeUtil.curThemeId))) {
        break label185;
      }
      paramIntent.setBackgroundResource(2130839642);
    }
    for (;;)
    {
      PhoneContactManagerImp.a(this.app, getResources(), (ImageView)E(2131365246));
      return;
      paramIntent = ((aelc)localObject).a.title;
      paramPhoneInnerFrame = ((aelc)localObject).a.subTitle;
      localObject = ((aelc)localObject).a.buttonTitle;
      break;
      label185:
      if (paramIntent != null) {
        paramIntent.setBackgroundResource(2130838900);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      int i = ((PhoneContactManagerImp)this.app.getManager(11)).xy();
      if ((i == 2) || (i == 4) || (i == 9) || (i == 8)) {
        i(true, 0, "MSG_TIME_OUT");
      }
    }
    else
    {
      return true;
    }
    i(false, -1, "MSG_TIME_OUT");
    return true;
  }
  
  public void i(boolean paramBoolean, int paramInt, String paramString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("PhoneMatchView", 2, String.format("onUploadResult [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    this.cf.removeMessages(0);
    if (this.k != null)
    {
      this.app.unRegistObserver(this.k);
      this.k = null;
    }
    dismissProgressDialog();
    if (paramBoolean) {
      startActivity(new Intent(getContext(), ContactListView.class));
    }
    BaseApplication localBaseApplication;
    if (paramBoolean)
    {
      paramString = acfp.m(2131709519);
      localBaseApplication = BaseApplicationImpl.getContext();
      if (!paramBoolean) {
        break label154;
      }
    }
    label154:
    for (paramInt = i;; paramInt = 1)
    {
      QQToast.a(localBaseApplication, paramInt, paramString, 0).show(localBaseApplication.getResources().getDimensionPixelSize(2131299627));
      return;
      paramString = acfp.m(2131709520);
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0)) {
      if (paramInt2 == 2)
      {
        paramIntent = new Intent(getContext(), BindNumberActivity.class);
        paramIntent.putExtra("kNeedUnbind", true);
        startActivity(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
        startActivity(new Intent(getContext(), PhoneLaunchActivity.class));
        return;
      } while (paramInt1 != 99999);
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
    } while ((!((PhoneContactManagerImp)this.app.getManager(11)).aC(true)) || (!(getContext() instanceof Activity)));
    paramIntent = (Activity)getContext();
    ContactBindedActivity.a(this.app, -1, 2, null);
    paramIntent.setResult(-1);
    paramIntent.finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.eM) {
      crs();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      startActivityForResult(new Intent(getContext(), SettingActivity2.class), 1);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.centerView.setText(acfp.m(2131709517));
    if (this.reqType == 2)
    {
      this.MZ.setVisibility(4);
      this.MZ.setText(2131696840);
      return;
    }
    if (this.reqType == 3)
    {
      this.MZ.setVisibility(8);
      return;
    }
    this.MZ.setOnClickListener(this);
  }
  
  protected void onStop()
  {
    if (this.k != null)
    {
      this.app.unRegistObserver(this.k);
      this.k = null;
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView
 * JD-Core Version:    0.7.0.1
 */