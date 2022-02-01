package com.tencent.mobileqq.upgrade;

import accy;
import aiim;
import aiim.b;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anot;
import aqao;
import aqap;
import aqat;
import aqen;
import avpw;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;
import wja;

public class UpgradeTipsDialog
  extends ReportDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private CheckBox V;
  private aiim jdField_a_of_type_Aiim;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  private a jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog$a;
  private boolean cTv;
  private Button hs;
  private Button ht;
  private Activity mActivity;
  private QQAppInterface mApp;
  private boolean mIsReady;
  public WebView mWebView;
  
  public UpgradeTipsDialog(Activity paramActivity, QQAppInterface paramQQAppInterface, UpgradeDetailWrapper paramUpgradeDetailWrapper, a parama)
  {
    super(paramActivity, 2131756467);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = paramUpgradeDetailWrapper;
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    b(parama);
  }
  
  private void b(a parama)
  {
    requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog$a = parama;
    parama = getLayoutInflater().inflate(2131561783, null);
    initUI(parama);
    parama.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(parama);
    parama = getWindow();
    WindowManager.LayoutParams localLayoutParams = parama.getAttributes();
    parama.setGravity(17);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = getContext().getResources().getDisplayMetrics().heightPixels;
    localLayoutParams.width = wja.dp2px(260.0F, getContext().getResources());
    if (i <= j) {}
    for (localLayoutParams.height = wja.dp2px(368.0F, getContext().getResources());; localLayoutParams.height = wja.dp2px(300.0F, getContext().getResources()))
    {
      parama.setAttributes(localLayoutParams);
      setCancelable(false);
      this.mWebView.loadUrl(aqap.pc(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL));
      return;
    }
  }
  
  private void initUI(View paramView)
  {
    this.mWebView = ((WebView)paramView.findViewById(2131381311));
    this.mWebView.setVerticalFadingEdgeEnabled(false);
    this.mWebView.setFadingEdgeLength(0);
    this.mWebView.setHorizontalFadingEdgeEnabled(false);
    this.mWebView.setHorizontalScrollBarEnabled(false);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.mWebView.removeJavascriptInterface("accessibility");
      this.mWebView.removeJavascriptInterface("accessibilityTraversal");
    }
    this.mWebView.setWebViewClient(new aqat(this));
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + avpw.getQUA());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(2);
    this.jdField_a_of_type_Aiim = new aiim();
    this.jdField_a_of_type_Aiim.a(new JsCover(), "qqupgrade");
    this.V = ((CheckBox)paramView.findViewById(2131381307));
    boolean bool = accy.b(this.mApp, true);
    this.V.setChecked(bool);
    this.V.setOnCheckedChangeListener(this);
    this.ht = ((Button)paramView.findViewById(2131381308));
    this.ht.setOnClickListener(this);
    this.hs = ((Button)paramView.findViewById(2131381309));
    this.hs.setOnClickListener(this);
    if (aqap.a().getDownloadState() == 4) {
      this.hs.setText(2131695031);
    }
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog$a = parama;
  }
  
  public void dismiss()
  {
    aqen.cr(this.mActivity);
    super.dismiss();
  }
  
  public boolean isReady()
  {
    return this.mIsReady;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.cTv) {}
    for (boolean bool = true;; bool = false)
    {
      this.cTv = bool;
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
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
      try
      {
        dismiss();
        boolean bool = this.V.isChecked();
        accy.t(this.mApp, bool);
        if (bool) {
          accy.m(this.mApp, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
        }
        if (this.cTv) {
          ((MessageHandler)this.mApp.getBusinessHandler(0)).Fk(bool);
        }
        QQAppInterface localQQAppInterface = this.mApp;
        String str1 = aqao.BH();
        String str2 = aqap.BI();
        if (bool) {}
        for (Object localObject = "1";; localObject = "0")
        {
          anot.a(localQQAppInterface, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, str1, String.valueOf(1), str2, (String)localObject);
          if (aqap.a().getDownloadState() != 4) {
            break label200;
          }
          localObject = this.mApp.getHandler(Conversation.class);
          if (localObject == null) {
            break;
          }
          ((MqqHandler)localObject).obtainMessage(1134018).sendToTarget();
          break;
        }
        label200:
        anot.a(this.mApp, "CliOper", "", "", "Update_tips", "Clk_upd_hold", 0, 0, "", "", "", "");
        if (bool)
        {
          aqap.a().ecY();
          continue;
        }
        aqap.a().ecZ();
      }
      catch (Exception localException1)
      {
        try
        {
          dismiss();
          label262:
          anot.a(this.mApp, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, aqao.BH(), String.valueOf(1), aqap.BI(), "");
          accy.t(this.mApp, this.V.isChecked());
          if (aqap.a().getDownloadState() == 4)
          {
            aqap.a().ft(getContext());
            continue;
          }
          anot.a(this.mApp, "CliOper", "", "", "Update_tips", "Clk_upd_now", 0, 0, "", "", "", "");
          accy.m(this.mApp, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
          UpgradeDetailActivity.a(this.mActivity, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper, true, true, true);
          continue;
          localException1 = localException1;
        }
        catch (Exception localException2)
        {
          break label262;
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Aiim.Lf("qqupgrade");
    this.mWebView.destroy();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    aqen.cq(this.mActivity);
  }
  
  public class JsCover
    extends aiim.b
  {
    protected JsCover() {}
    
    public int tipsLoadComplete()
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "loadTipsComplete");
      }
      UpgradeTipsDialog.a(UpgradeTipsDialog.this, true);
      anot.a(UpgradeTipsDialog.a(UpgradeTipsDialog.this), "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, aqao.BH(), String.valueOf(1), aqap.BI(), "");
      if (UpgradeTipsDialog.a(UpgradeTipsDialog.this) != null)
      {
        UpgradeTipsDialog.a(UpgradeTipsDialog.this).a(UpgradeTipsDialog.this);
        return 0;
      }
      try
      {
        UpgradeTipsDialog.this.show();
        return 0;
      }
      catch (Exception localException) {}
      return 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(UpgradeTipsDialog paramUpgradeTipsDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTipsDialog
 * JD-Core Version:    0.7.0.1
 */