package com.tencent.biz.pubaccount.AccountDetail.activity;

import acja;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import jtf;
import juk;
import kbs;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class PubAccountMoreInfoActivity
  extends IphoneTitleBarActivity
{
  public AccountDetail a;
  juk a;
  protected BusinessObserver a;
  public mobileqq_mp.GetPublicAccountDetailInfoResponse b;
  protected NewIntent d;
  float density;
  ScrollView g;
  String mUin;
  private View mask;
  
  private void initView()
  {
    super.setContentView(2131558434);
    this.g = ((ScrollView)super.findViewById(2131377565));
    setTitle(getResources().getString(2131697430));
    this.mask = super.findViewById(2131374736);
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.mask != null) {
        this.mask.setVisibility(0);
      }
    }
    for (;;)
    {
      this.density = super.getResources().getDisplayMetrics().density;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
      {
        this.jdField_a_of_type_Juk = new juk(this.app, this, this.mUin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, true);
        this.g.addView(this.jdField_a_of_type_Juk.X());
      }
      return;
      if (this.mask != null) {
        this.mask.setVisibility(8);
      }
    }
  }
  
  private void updateView()
  {
    this.jdField_a_of_type_Juk = new juk(this.app, this, this.mUin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, true);
    this.g.addView(this.jdField_a_of_type_Juk.X());
  }
  
  void azE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity", 2, "sendPublicAccountDetailInfoRequest");
    }
    if (this.d != null) {
      this.d.setObserver(null);
    }
    this.d = new NewIntent(super.getApplicationContext(), kbs.class);
    this.d.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("3.4.4,3,3058");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localGetPublicAccountDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.mUin));
        label119:
        this.d.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new jtf(this);
        this.d.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.app.startServlet(this.d);
        return;
        localGetPublicAccountDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label119;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    init();
    initView();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Juk != null) {
      this.jdField_a_of_type_Juk.destroy();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void init()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity", 2, "init");
    }
    Object localObject = getIntent();
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (localObject != null) {
      this.mUin = ((Intent)localObject).getStringExtra("uin");
    }
    localObject = (acja)this.app.getManager(56);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = ((acja)localObject).a(this.mUin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      azE();
    }
  }
  
  public void oh(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.PubAccountMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */