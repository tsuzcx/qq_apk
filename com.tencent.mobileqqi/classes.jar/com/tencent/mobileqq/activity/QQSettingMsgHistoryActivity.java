package com.tencent.mobileqq.activity;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
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
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import djm;
import djn;
import djp;
import djq;
import djs;
import djt;
import djv;
import djw;
import java.io.File;
import java.util.Vector;
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
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new djw(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new djm(this);
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
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localObject instanceof BaseApplicationImpl))
      {
        BaseApplicationImpl localBaseApplicationImpl = (BaseApplicationImpl)localObject;
        if (BaseApplicationImpl.a != null)
        {
          localObject = (BaseApplicationImpl)localObject;
          BaseApplicationImpl.a.evictAll();
        }
      }
    }
  }
  
  private void j()
  {
    b(AppConstants.an + this.jdField_a_of_type_JavaLangString + "/" + "ptt/");
  }
  
  private void k()
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().j();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().k();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().l();
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
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(AppConstants.an + this.jdField_a_of_type_JavaLangString + "/" + "photo/");
    }
    int i = 0;
    while (i < CardHandler.jdField_a_of_type_JavaUtilVector.size())
    {
      b(CardHandler.jdField_a_of_type_JavaLangString + ((Integer)CardHandler.jdField_a_of_type_JavaUtilVector.get(i)).intValue() + "/");
      i += 1;
    }
    b(CardHandler.jdField_a_of_type_JavaLangString + "background" + "/");
    b(AppConstants.an + "temp" + "/");
    b(CardHandler.jdField_a_of_type_JavaLangString + "temp" + "/");
    b(CardHandler.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    b(AppConstants.bg);
    b(CardHandler.jdField_a_of_type_JavaLangString + "voice" + "/");
  }
  
  protected String a_()
  {
    return getString(2131562380);
  }
  
  public void c()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().k();
    a(true);
    j();
    g();
    k();
    i();
    d();
    Handler localHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1009);
    }
  }
  
  void d()
  {
    ((NewFriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).i();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903623);
    setTitle(2131562217);
    this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131233120));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setChecked(bool);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131233121);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131233122);
      this.c = findViewById(2131233123);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void e()
  {
    try
    {
      Object localObject = new Intent("qqplayer_exit_action");
      ((Intent)localObject).putExtra("musicplayer.isDelFileOnDonwloadThreadOver", true);
      sendBroadcast((Intent)localObject);
      QZoneHelper.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      a(false);
      f();
      g();
      i();
      MusicCacheManager.a();
      QfavHelper.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      PublicAccountJavascriptInterface.deleteAllH5Data(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      FileUtil.a(new File(PublicAccountJavascriptInterface.d + "/" + HexUtil.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
      FileUtil.a(new File(AppConstants.al + "/" + "tencent/MobileQQ/qbiz/"));
      localObject = CacheManager.getCacheFileBaseDir();
      if (localObject != null) {
        FileUtil.a((File)localObject);
      }
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
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return;
    }
    BaseApplication.getContext().getPackageName();
    b(Utils.a(BaseApplication.getContext()) + "thumbnails/");
  }
  
  void g()
  {
    b(AppConstants.an + "photo/");
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
    if (!NetworkUtil.e(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131562449, 1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      paramBoolean = bool;
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f() == 1) {
        paramBoolean = true;
      }
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
    paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean)
    {
      i = 1;
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "", "", "", "");
      a(getApplication().getResources().getString(2131562662));
      if (!paramBoolean) {
        break label155;
      }
    }
    label155:
    for (int i = j;; i = 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(i);
      return;
      i = 0;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if ((isFinishing()) || (l1 - l2 < 500L)) {
      return;
    }
    this.jdField_a_of_type_Long = l1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131233121: 
      paramView = DialogUtil.c(this, 230, null, null, 2131561746, 2131562539, null, null);
      paramView.setMessage(getString(2131561824));
      paramView.setDividerGone();
      localObject1 = new djn(this);
      localObject2 = new djp(this);
      paramView.setPositiveButton(2131562539, (DialogInterface.OnClickListener)localObject1);
      paramView.setNegativeButton(2131561746, (DialogInterface.OnClickListener)localObject2);
      paramView.show();
      return;
    case 2131233122: 
      paramView = DialogUtil.c(this, 230, null, null, 2131561746, 2131562539, null, null);
      paramView.setMessage(getString(2131561667));
      paramView.setDividerGone();
      localObject1 = new djq(this);
      localObject2 = new djs(this);
      paramView.setPositiveButton(2131562539, (DialogInterface.OnClickListener)localObject1);
      paramView.setNegativeButton(2131561746, (DialogInterface.OnClickListener)localObject2);
      paramView.show();
      return;
    }
    paramView = DialogUtil.c(this, 230, null, null, 2131561746, 2131562539, null, null);
    paramView.setMessage(getString(2131560603));
    paramView.setDividerGone();
    Object localObject1 = new djt(this);
    Object localObject2 = new djv(this);
    paramView.setPositiveButton(2131562539, (DialogInterface.OnClickListener)localObject1);
    paramView.setNegativeButton(2131561746, (DialogInterface.OnClickListener)localObject2);
    paramView.show();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131561702));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity
 * JD-Core Version:    0.7.0.1
 */