package com.tencent.biz.qqstory.storyHome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aqis;
import awsw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import plr;
import pqy;
import psr;
import psx;
import qqs;
import qqt;
import ral;
import ram;
import swe;

public class QQStoryMainActivity
  extends QQStoryBaseActivity
{
  public static long Bj;
  protected QQStoryMainController a = new QQStoryMainController(new qqs(this), QQStoryMainController.dQ);
  NavBarCommon jdField_b_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  private swe jdField_b_of_type_Swe;
  
  public QQStoryMainActivity()
  {
    this.a.onAttach(this);
  }
  
  private void bi(Intent paramIntent)
  {
    try
    {
      if (paramIntent.getBooleanExtra("is_from_share", false))
      {
        String str = paramIntent.getStringExtra("struct_share_key_source_name");
        this.mHandler.postDelayed(new QQStoryMainActivity.3(this, paramIntent, str), 1800L);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  private void cw(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramString1, paramString1, paramString2, paramString2);
  }
  
  private void i(Intent paramIntent, String paramString)
  {
    if (this.jdField_b_of_type_Swe == null) {
      this.jdField_b_of_type_Swe = new swe(this);
    }
    String str2 = this.app.getApplication().getString(2131720024);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramIntent = new qqt(this, paramIntent);
    this.jdField_b_of_type_Swe.c(str1, paramIntent);
    this.jdField_b_of_type_Swe.a(paramIntent);
    this.jdField_b_of_type_Swe.show();
  }
  
  private void initView()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131377361));
    this.jdField_b_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this.a.a);
    rS(plr.asY);
  }
  
  private void rS(@NonNull String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramString, paramString);
  }
  
  protected void O(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    this.a.Ki();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnCreate");
    }
    ram.w("Q.qqstory.home.QQStoryMainActivity", "QQStoryMainActivity start");
    this.mUseOptimizMode = true;
    Bj = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131561883);
    this.a.onCreate(paramBundle);
    initView();
    int i = ((Integer)((psr)psx.a(10)).c("string_story_global_log_level", Integer.valueOf(-1))).intValue();
    ral.a().wL(i);
    awsw.a(BaseApplicationImpl.getContext(), new QQStoryMainActivity.2(this), null);
    bi(getIntent());
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnDestroy");
    }
    super.doOnDestroy();
    Bj = 0L;
    this.a.onDestroy(this);
    ral.a().wL(-1);
    pqy.a().destory();
    if (this.jdField_b_of_type_Swe != null)
    {
      this.jdField_b_of_type_Swe.dismiss();
      this.jdField_b_of_type_Swe = null;
    }
    aqis.a().edT();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.a.onNewIntent(paramIntent);
    bi(paramIntent);
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnPause");
    }
    super.doOnPause();
    this.a.onPause();
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnResume");
    }
    super.doOnResume();
    this.a.onResume(this);
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    this.a.onSaveInstanceState(paramBundle);
  }
  
  public void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnStop");
    }
    super.doOnStop();
    this.a.be(this);
    aqis.a().edT();
  }
  
  public void finish()
  {
    super.setResult(-1);
    super.finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public static class a
  {
    public String iconText;
    public String iconUrl;
    public String jumpUrl;
    public int show = 3;
    
    public a(String paramString)
    {
      paramString = (String)((psr)psx.a(10)).c(paramString, "");
      if (!TextUtils.isEmpty(paramString)) {}
      try
      {
        paramString = new JSONObject(paramString);
        this.show = paramString.optInt("show", 3);
        if (this.show >= 0)
        {
          this.jumpUrl = paramString.optString("url");
          this.iconUrl = paramString.optString("icon");
          this.iconText = paramString.optString("text");
        }
        return;
      }
      catch (Exception paramString)
      {
        do
        {
          this.show = 3;
        } while (!QLog.isColorLevel());
        QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, "ButtonConfig exc: " + QLog.getStackTraceString(paramString));
      }
    }
    
    public String toString()
    {
      return "ButtonConfig: show = " + this.show + ", iconText = " + this.iconText + ", iconUrl = " + this.iconUrl + ", jumpUrl = " + this.jumpUrl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity
 * JD-Core Version:    0.7.0.1
 */