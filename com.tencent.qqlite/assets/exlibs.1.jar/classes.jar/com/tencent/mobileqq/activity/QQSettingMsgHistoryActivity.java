package com.tencent.mobileqq.activity;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import bft;
import bfu;
import bfw;
import bfy;
import bga;
import bgb;
import com.dataline.util.file.FileUtil;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.MusicCacheManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CacheManager;
import cooperation.plugin.IPluginManager;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQSettingMsgHistoryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static int a = 0;
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 1000;
  static final int d = 0;
  static final int e = 1;
  private long jdField_a_of_type_Long = 0L;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bgb(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private View jdField_c_of_type_AndroidViewView;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public QQSettingMsgHistoryActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new bft(this);
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString != null)
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length)
        {
          boolean bool = paramString[i].delete();
          if (QLog.isColorLevel())
          {
            QLog.d("AvatarUtil", 2, "path: " + paramString[i].getAbsolutePath());
            QLog.d("AvatarUtil", 2, "ret : " + bool);
          }
          i += 1;
        }
      }
    }
  }
  
  private void i()
  {
    if (URLDrawableHelper.a != null)
    {
      b(URLDrawableHelper.a.getAbsolutePath());
      Object localObject = this.app.a();
      if ((localObject instanceof BaseApplicationImpl))
      {
        BaseApplicationImpl localBaseApplicationImpl = (BaseApplicationImpl)localObject;
        if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
        {
          localObject = (BaseApplicationImpl)localObject;
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
        }
      }
    }
  }
  
  private void j()
  {
    b(AppConstants.as + this.jdField_a_of_type_JavaLangString + "/" + "ptt/");
  }
  
  private void k()
  {
    try
    {
      this.app.a().f();
      this.app.a().g();
      this.app.a().h();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(AppConstants.as + this.jdField_a_of_type_JavaLangString + "/" + "photo/");
    }
    int i = 0;
    while (i < CardHandler.jdField_a_of_type_JavaUtilVector.size())
    {
      b(CardHandler.jdField_a_of_type_JavaLangString + ((Integer)CardHandler.jdField_a_of_type_JavaUtilVector.get(i)).intValue() + "/");
      i += 1;
    }
    b(CardHandler.jdField_a_of_type_JavaLangString + "background" + "/");
    b(AppConstants.as + "temp" + "/");
    b(CardHandler.jdField_a_of_type_JavaLangString + "temp" + "/");
    b(CardHandler.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    b(AppConstants.bp);
    b(CardHandler.jdField_a_of_type_JavaLangString + "voice" + "/");
  }
  
  protected String b_()
  {
    return getString(2131363053);
  }
  
  public void c()
  {
    this.app.a().g();
    a(true);
    j();
    g();
    k();
    i();
    d();
    Handler localHandler = this.app.a(Conversation.class);
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1009);
    }
  }
  
  void d()
  {
    ((NewFriendManager)this.app.getManager(31)).i();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903537);
    setTitle(2131364291);
    this.jdField_a_of_type_JavaLangString = this.app.a();
    setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298436));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.app.f() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setChecked(bool);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131298437);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131298438);
      this.c = findViewById(2131298439);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void e()
  {
    try
    {
      Object localObject = new Intent("qqplayer_exit_action");
      ((Intent)localObject).putExtra("musicplayer.isDelFileOnDonwloadThreadOver", true);
      sendBroadcast((Intent)localObject);
      QZoneHelper.a(this, this.app.a());
      a(false);
      f();
      g();
      i();
      MusicCacheManager.a();
      if (!((IPluginManager)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a().getManager(25)).a()) {
        QfavHelper.a(this, this.app.a());
      }
      PublicAccountJavascriptInterface.deleteAllH5Data(this.app);
      FileUtil.a(new File(PublicAccountJavascriptInterface.d + "/" + HexUtil.b(this.app.getAccount())));
      FileUtil.a(new File(AppConstants.aq + "/" + "tencent/QQLite/qbiz/"));
      localObject = CacheManager.getCacheFileBaseDir();
      if (localObject != null) {
        FileUtil.a((File)localObject);
      }
      ShortVideoUtils.a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AssitantSettingActivity", 2, "deleteOfflineData got exception:" + localException.getMessage());
    }
  }
  
  void f()
  {
    if (this.app.a() == null) {
      return;
    }
    BaseApplication.getContext().getPackageName();
    b(Utils.a(BaseApplication.getContext()) + "thumbnails/");
  }
  
  void g()
  {
    b(AppConstants.as + "photo/");
  }
  
  public void h()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int j = 1;
    if (!NetworkUtil.e(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131363516, 1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      paramBoolean = bool;
      if (this.app.f() == 1) {
        paramBoolean = true;
      }
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
    paramCompoundButton = this.app;
    if (paramBoolean)
    {
      i = 1;
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "", "", "", "");
      a(getApplication().getResources().getString(2131364073));
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (int i = j;; i = 0)
    {
      this.app.g(i);
      return;
      i = 0;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if ((isFinishing()) || (l1 - l2 < 500L)) {
      return;
    }
    this.jdField_a_of_type_Long = l1;
    bga localbga = null;
    int j;
    switch (paramView.getId())
    {
    default: 
      j = 0;
      paramView = localbga;
    }
    for (;;)
    {
      localbga = new bga(this);
      DialogUtil.a(this, 230, getString(j), getString(i), paramView, localbga).show();
      return;
      i = 2131363746;
      paramView = new bfu(this);
      j = 2131363739;
      continue;
      i = 2131363745;
      paramView = new bfw(this);
      j = 2131363741;
      continue;
      i = 2131364292;
      paramView = new bfy(this);
      j = 2131363740;
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131363252));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity
 * JD-Core Version:    0.7.0.1
 */