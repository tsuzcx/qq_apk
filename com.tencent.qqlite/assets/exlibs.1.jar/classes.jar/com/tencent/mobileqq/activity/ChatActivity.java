package com.tencent.mobileqq.activity;

import abn;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.mobileqq.activity.aio.AIOTimeReporter;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoji.EmojiUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.startup.step.SetSplashImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ChatActivity
  extends BaseActivity
{
  private View jdField_a_of_type_AndroidViewView;
  protected BaseChatPie a;
  private AIOTimeReporter jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter;
  public QQProgressDialog a;
  private boolean jdField_a_of_type_Boolean = false;
  
  private boolean a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      if (!this.app.isLogin())
      {
        this.jdField_a_of_type_Boolean = true;
        paramIntent = new Intent();
        paramIntent.setClass(this, LoginActivity.class);
        paramIntent.addFlags(262144);
        super.startActivity(paramIntent);
        finish();
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (b(paramIntent)) {
            break label175;
          }
          this.jdField_a_of_type_Boolean = true;
          finish();
          return true;
          if (!isFinishing()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("qqBaseActivity", 2, "onNewIntent isFinishing");
        return true;
        if (!ThridAppShareHelper.a().a(paramIntent, this, this.app)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("qqBaseActivity", 2, "onNewIntent ThridApp to chatactivity");
      return true;
      Bundle localBundle = paramIntent.getExtras();
      if ((localBundle == null) || (!localBundle.getBoolean("back_from_emojimall", false))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "onNewIntent KEY_EMOJIMALL_CLOSE_BACK to chatactivity");
    return true;
    if (!b(paramIntent))
    {
      finish();
      return true;
    }
    label175:
    return false;
  }
  
  private boolean b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("uintype", -1);
    if (str == null) {
      return false;
    }
    if (i == -1)
    {
      QQToast.a(this, getString(2131362939), 0).b(getTitleBarHeight());
      return false;
    }
    if (paramIntent.hasExtra("account"))
    {
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "1", "", "", "");
      if (!((FriendManager)this.app.getManager(8)).b(str))
      {
        paramIntent.removeExtra("account");
        paramIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
        paramIntent.setClassName(this, ShortcutRouterActivity.class.getName());
        super.startActivity(paramIntent);
        return false;
      }
    }
    if ((paramIntent.getBooleanExtra("shortcut", false)) && (!((FriendManager)this.app.getManager(8)).b(str)))
    {
      QQToast.a(getApplicationContext(), getString(2131362830), 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.x();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.v();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.s();
    }
  }
  
  public BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  }
  
  public QQAppInterface a()
  {
    return this.app;
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d();
  }
  
  protected boolean a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if ((!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) || (paramIntent.getIntExtra("uintype", -1) != 1)) {
        break label223;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(false);
    }
    switch (paramIntent.getIntExtra("chat_subType", 0))
    {
    case 2: 
    default: 
      switch (paramIntent.getIntExtra("uintype", -1))
      {
      default: 
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BaseChatPie))) {}
        break;
      }
    case 1: 
    case 3: 
      label223:
      do
      {
        do
        {
          do
          {
            return false;
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(true);
            break;
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie)));
          c();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BusinessCmrTmpChatPie(this.app, this);
          return true;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof MultiForwardChatPie)));
        c();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new MultiForwardChatPie(this.app, this);
        return true;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof FriendChatPie)) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie)));
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new FriendChatPie(this.app, this);
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {
        break;
      }
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new TroopChatPie(this.app, this);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DiscussChatPie))) {
        break;
      }
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new DiscussChatPie(this.app, this);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie))) {
        break;
      }
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BusinessCmrTmpChatPie(this.app, this);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof StrangerChatPie))) {
        break;
      }
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new StrangerChatPie(this.app, this);
      continue;
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BaseChatPie(this.app, this);
    }
  }
  
  protected String c_()
  {
    return "com.tencent.qqlite:peak";
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramConfiguration);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    StartupTracker.a(null, "AIO_Start_cost");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter = new AIOTimeReporter();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(0);
    }
    ThreadPriorityManager.a(true);
    StartupTracker.a(null, "AIO_Super_doOnCreate");
    super.doOnCreate(paramBundle);
    StartupTracker.a("AIO_Super_doOnCreate", null);
    if (a(true, super.getIntent())) {
      return false;
    }
    StartupTracker.a(null, "AIO_doOnCreate");
    StartupTracker.a(null, "AIO_doOnCreate_uiCost");
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    super.setContentView(2130903080);
    super.getWindow().setFeatureInt(7, 2130903146);
    super.getWindow().setBackgroundDrawable(null);
    StartupTracker.a("AIO_doOnCreate_uiCost", "AIO_doOnCreate_getPieCost");
    a(super.getIntent());
    StartupTracker.a("AIO_doOnCreate_getPieCost", null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(1);
    }
    StartupTracker.a("AIO_doOnCreate", null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    StartupTracker.a(null, "AIO_Super_doOnDestroy");
    super.doOnDestroy();
    StartupTracker.a("AIO_Super_doOnDestroy", "AIO_doOnDestroy");
    if (this.jdField_a_of_type_Boolean)
    {
      StartupTracker.a("AIO_doOnDestroy", null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.s();
    }
    StartupTracker.a("AIO_doOnDestroy", null);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_Super_doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    StartupTracker.a("AIO_Super_doOnNewIntent", null);
    if (a(false, paramIntent)) {
      return;
    }
    StartupTracker.a(null, "AIO_doOnNewIntent");
    super.setIntent(paramIntent);
    if (a(paramIntent))
    {
      super.setContentView(2130903080);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.w();
    }
    for (;;)
    {
      StartupTracker.a("AIO_doOnNewIntent", null);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h(paramIntent);
    }
  }
  
  protected void doOnPause()
  {
    StartupTracker.a(null, "AIO_Super_doOnPause");
    super.doOnPause();
    StartupTracker.a("AIO_Super_doOnPause", "AIO_doOnPause");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.y();
    }
    StartupTracker.a("AIO_doOnPause", null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a();
    }
  }
  
  protected void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(4);
    }
    StartupTracker.a(null, "AIO_Super_doOnResume");
    super.doOnResume();
    StartupTracker.a("AIO_Super_doOnResume", "AIO_doOnResume");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.A();
    }
    StartupTracker.a("AIO_doOnResume", "AIO_onDrawView");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(5);
    }
    if ((EmojiUtil.a(521705)) && (EmojiUtil.a(this) != EmotcationConstants.f)) {
      new abn(this).execute(new Object[0]);
    }
  }
  
  protected void doOnStart()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(2);
    }
    StartupTracker.a(null, "AIO_Super_doOnStart");
    super.doOnStart();
    StartupTracker.a("AIO_Super_doOnStart", "AIO_doOnStart");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.w();
    StartupTracker.a("AIO_doOnStart", null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(3);
    }
  }
  
  protected void doOnStop()
  {
    StartupTracker.a(null, "AIO_Super_doOnStop");
    super.doOnStop();
    StartupTracker.a("AIO_Super_doOnStop", "AIO_doOnStop");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.x();
    }
    StartupTracker.a("AIO_doOnStop", null);
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g(paramBoolean);
      }
      StartupTracker.a("AIO_onDrawView", null);
      StartupTracker.a("AIO_Start_cost", "AIO_SysMsgCost");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(6);
      }
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.v();
    }
    super.finish();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt);
    }
    return null;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt, paramDialog);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
    getWindow().setFormat(-3);
  }
  
  public boolean showPreview()
  {
    SetSplashImpl.a(this);
    getWindow().setFeatureInt(7, 2130903144);
    try
    {
      this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131296932).getParent());
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivity
 * JD-Core Version:    0.7.0.1
 */