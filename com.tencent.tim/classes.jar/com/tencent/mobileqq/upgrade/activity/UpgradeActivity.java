package com.tencent.mobileqq.upgrade.activity;

import acfp;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.view.Window;
import anot;
import aqai;
import aqao;
import aqap;
import aqau;
import aqav;
import aqaw;
import aqax;
import aqay;
import aqaz;
import aqba;
import aqbb;
import aqbc;
import aqbd;
import aqbe;
import aqbf;
import aqbg;
import aqbh;
import aqbi;
import aqbj;
import aqbk;
import aqbl;
import aqha;
import aqju;
import aqma;
import aqmj;
import arub;
import arud;
import arwt;
import arxa;
import arzk;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.a;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeActivity
  extends BaseActivity
{
  private static long lastTimeStamp;
  private int aCm;
  private boolean cTw;
  private String cse;
  private String csf;
  private String csm;
  private int iTipsType;
  private int iUpgradeSdkId;
  private int iUpgradeType;
  private boolean isInstall;
  private int mActivityType;
  private long showTime;
  private String strCancelButtonDesc;
  private String strDesc;
  private String strTitle;
  private String strUpgradeDesc;
  String strUrl = null;
  
  private void Sw(boolean paramBoolean)
  {
    if (aqap.a().getDownloadState() == 4)
    {
      Object localObject = this.app.getHandler(Conversation.class);
      if (localObject != null)
      {
        localObject = ((MqqHandler)localObject).obtainMessage(1134018);
        ((Message)localObject).obj = this;
        ((Message)localObject).sendToTarget();
      }
      return;
    }
    UpgradeDetailActivity.a(this, aqap.a().b(), false, true, true);
  }
  
  private void edi()
  {
    this.strTitle = acfp.m(2131716259);
    this.strUpgradeDesc = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void edj()
  {
    this.strTitle = "下载QQ失败";
    this.strUpgradeDesc = acfp.m(2131716262);
    showDialog(16384);
  }
  
  private void edk()
  {
    this.strTitle = getIntent().getStringExtra("StrTitle");
    this.strUpgradeDesc = getIntent().getStringExtra("StrUpgradeDesc");
    this.strUrl = getIntent().getStringExtra("StrUrl");
    this.strDesc = getIntent().getStringExtra("strDesc");
    this.cse = getIntent().getStringExtra("lBtnText");
    this.csf = getIntent().getStringExtra("rBtnText");
    this.iUpgradeType = getIntent().getIntExtra("iUpgradeType", 0);
    this.iTipsType = getIntent().getIntExtra("iTipsType", 0);
    if (getIntent().hasExtra("strConfirmBtnText")) {
      this.csm = getIntent().getStringExtra("strConfirmBtnText");
    }
    if (getIntent().hasExtra("strCancelButtonDesc")) {
      this.strCancelButtonDesc = getIntent().getStringExtra("strCancelButtonDesc");
    }
    if (aqap.a().getDownloadState() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.isInstall = bool;
      this.showTime = getIntent().getLongExtra("showTime", 0L);
      this.iUpgradeSdkId = getIntent().getIntExtra("iUpgradeSdkId", 0);
      this.aCm = getIntent().getIntExtra("rate", 1);
      getIntent().getIntExtra("mode", 0);
      if (this.iUpgradeType != 2) {
        break;
      }
      showDialog(2);
      return;
    }
    if (this.iUpgradeType == 1)
    {
      showDialog(1);
      return;
    }
    if (this.iUpgradeType == 3)
    {
      showDialog(3);
      return;
    }
    finish();
  }
  
  private void edn() {}
  
  private void retryDownload() {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = aqap.a().b();
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      finish();
      return true;
    }
    getWindow().setBackgroundDrawableResource(2131167595);
    this.mActivityType = getIntent().getIntExtra("activity_type", 4096);
    switch (this.mActivityType)
    {
    default: 
      finish();
      return true;
    case 4096: 
      edk();
      return true;
    case 8192: 
      edi();
      return true;
    }
    edj();
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.cTw)
    {
      arzk.a();
      if (arzk.aHx())
      {
        if (!arzk.a().aHA()) {
          aqai.v(this);
        }
        finish();
      }
    }
  }
  
  public void edl()
  {
    finish();
    this.app.exit(false);
  }
  
  void edm()
  {
    if (this.app != null)
    {
      localSharedPreferences = this.app.getPreferences();
      i = localSharedPreferences.getInt("upgrade_tip_count", 0);
      if (i < 1) {
        localSharedPreferences.edit().putInt("upgrade_tip_count", i + 1).commit();
      }
    }
    while (!QLog.isColorLevel())
    {
      SharedPreferences localSharedPreferences;
      int i;
      return;
    }
    QLog.i("UpgradeActivty", 2, "UpgradeTipCounter --- app is null");
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    finish();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject1 = null;
    switch (paramInt)
    {
    }
    while (localObject1 != null)
    {
      ((aqju)localObject1).setCanceledOnTouchOutside(false);
      ((aqju)localObject1).setOnDismissListener(new aqbd(this));
      return localObject1;
      anot.a(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, aqao.BH(), String.valueOf(0), aqap.BI(), "");
      localObject1 = aqha.a(this, 230).setTitle(this.strTitle).setMessage(this.strUpgradeDesc);
      ((aqju)localObject1).setPositiveButton(2131721586, new aqbf(this)).setNegativeButton(2131717261, new aqbe(this)).setOnKeyListener(new aqau(this));
      continue;
      if (this.iTipsType == 0)
      {
        anot.a(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, aqao.BH(), String.valueOf(0), aqap.BI(), "");
        localObject1 = aqha.a(this, 230).setTitle(this.strTitle).setMessage(this.strUpgradeDesc);
        edm();
        if (aqap.a().getDownloadState() == 4) {}
        for (paramInt = 2131695031;; paramInt = 2131721586)
        {
          ((aqju)localObject1).setPositiveButton(paramInt, new aqbi(this)).setNegativeButton(2131721585, new aqbh(this)).setOnKeyListener(new aqbg(this));
          break;
        }
      }
      if (this.iTipsType == 2)
      {
        anot.a(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, aqao.BH(), String.valueOf(2), aqap.BI(), "");
        anot.a(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.strUpgradeDesc = String.format(this.strUpgradeDesc, new Object[0]);
          aqbj localaqbj = new aqbj(this);
          aqbk localaqbk = new aqbk(this);
          if (this.isInstall) {
            if ((this.cse == null) || ("".equals(this.cse)))
            {
              localObject1 = acfp.m(2131716263);
              if ((this.csf != null) && (!"".equals(this.csf))) {
                break label621;
              }
              str = acfp.m(2131716256);
              paramInt = aqmj.by(this, this.app.getCurrentUin());
              aqmj.aJ(this, this.app.getCurrentUin(), paramInt + 1);
              aqmj.y(this, this.app.getCurrentUin(), System.currentTimeMillis());
              localObject1 = aqha.a(this, this.strTitle, this.strUpgradeDesc, (String)localObject1, str, this.strDesc, localaqbk, localaqbj);
              edm();
              ((Dialog)localObject1).setCanceledOnTouchOutside(false);
              ((Dialog)localObject1).setOnDismissListener(new aqbl(this));
              return localObject1;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
            localException1.printStackTrace();
            continue;
            localObject2 = this.cse;
            continue;
            label621:
            str = this.csf;
          }
          if ((this.strCancelButtonDesc == null) || ("".equals(this.strCancelButtonDesc)))
          {
            localObject2 = acfp.m(2131716254);
            label658:
            if ((this.csm != null) && (!"".equals(this.csm))) {
              break label738;
            }
          }
          label738:
          for (String str = acfp.m(2131716261);; str = this.csm)
          {
            paramInt = aqmj.bx(this, this.app.getCurrentUin());
            aqmj.aI(this, this.app.getCurrentUin(), paramInt + 1);
            aqmj.x(this, this.app.getCurrentUin(), System.currentTimeMillis());
            break;
            localObject2 = this.strCancelButtonDesc;
            break label658;
          }
        }
        Object localObject2 = aqha.a(this, 230).setTitle(this.strTitle).setMessage(this.strUpgradeDesc);
        ((aqju)localObject2).setPositiveButton(acfp.m(2131716260), new aqaw(this)).setNegativeButton(acfp.m(2131716265), new aqav(this));
        continue;
        localObject2 = aqha.a(this, 230).setTitle(this.strTitle).setMessage(this.strUpgradeDesc);
        ((aqju)localObject2).setPositiveButton(acfp.m(2131716257), new aqay(this)).setNegativeButton(acfp.m(2131716258), new aqax(this));
        continue;
        long l = System.currentTimeMillis();
        if (l - lastTimeStamp <= 1000L)
        {
          finish();
          return null;
        }
        lastTimeStamp = l;
        localObject2 = aqap.a().b();
        if ((localObject2 == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null))
        {
          arxa.a().showToast(acfp.m(2131716264));
          finish();
          return null;
        }
        this.strTitle = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        this.strUpgradeDesc = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        try
        {
          this.strUpgradeDesc = String.format(this.strUpgradeDesc, new Object[0]);
          l = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.asx;
          aqma.SK(true);
          paramInt = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn;
          aqma.XB(paramInt);
          arzk.a();
          if (arzk.aHx())
          {
            localObject2 = aqha.a(this, this.strTitle, l, this.strUpgradeDesc, new aqaz(this), new aqba(this));
            ((aqju)localObject2).setOnDismissListener(new aqbb(this));
            arwt.i("qqBaseActivity", arud.b(10010, 1, 1, 100));
            arwt.i("qqBaseActivity", arud.b(10010, 1, 2, 100));
            arwt.i("qqBaseActivity", arud.b(10010, 1, 3, 100));
            arub.a().postReport(16, arud.b(10010, 1, 1, 100));
            arub.a().postReport(16, arud.b(10010, 1, 2, 100));
            arub.a().postReport(16, arud.b(10010, 1, 3, 100));
            return localObject2;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
            localException2.printStackTrace();
          }
          this.cTw = true;
          arzk.a().Up(false);
          localObject2 = aqha.a(this, this.strTitle, l, this.strUpgradeDesc, "");
          ((aqai)localObject2).a(new aqbc(this, (aqai)localObject2, paramInt), true);
          return localObject2;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeActivity
 * JD-Core Version:    0.7.0.1
 */