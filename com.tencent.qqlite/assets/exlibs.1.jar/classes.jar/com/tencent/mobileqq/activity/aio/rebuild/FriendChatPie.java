package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import cal;
import cam;
import can;
import cao;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.servlet.ReduFriendObserver;
import com.tencent.mobileqq.utils.StartupTracker;
import java.util.Observable;

public class FriendChatPie
  extends BaseChatPie
{
  private StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new can(this);
  private ReduFriendObserver jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver = new cam(this);
  Runnable b;
  protected MessageObserver c = new cao(this);
  private boolean o = false;
  private boolean p = false;
  private boolean q = true;
  
  public FriendChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
    this.jdField_b_of_type_JavaLangRunnable = new cal(this);
  }
  
  protected void A()
  {
    super.A();
  }
  
  protected void E()
  {
    super.E();
    if ((this.p) && ("schemeconfirm".equals(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type")))) {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  protected void L()
  {
    StartupTracker.a(null, "AIO_onShow_business");
    super.L();
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.p = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.o = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    StartupTracker.a("AIO_onShow_business", null);
  }
  
  protected void M()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, false);
    }
    if (this.q)
    {
      this.q = false;
      ThreadManager.b(this.jdField_b_of_type_JavaLangRunnable);
    }
    super.M();
  }
  
  protected void Q()
  {
    super.Q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.c);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
  }
  
  protected void R()
  {
    super.R();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.c);
    if (this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
  }
  
  protected void a(Intent paramIntent)
  {
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    super.a(paramIntent);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    super.a(paramEmoticonInfo);
    if (this.o)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.o);
      this.o = false;
    }
  }
  
  protected boolean a()
  {
    return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  protected boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  public void b()
  {
    super.b();
    if (this.o)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.o);
      this.o = false;
    }
  }
  
  protected boolean d()
  {
    if ((this.p) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")))
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return true;
    }
    return super.d();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected boolean f()
  {
    return (!this.p) || (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm"));
  }
  
  protected void g()
  {
    super.g();
  }
  
  protected void g(Intent paramIntent)
  {
    super.g(paramIntent);
  }
  
  protected void j()
  {
    if (this.jdField_b_of_type_Boolean) {
      r();
    }
  }
  
  protected void s()
  {
    super.s();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
  }
  
  protected void w()
  {
    super.w();
  }
  
  protected void x()
  {
    super.x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie
 * JD-Core Version:    0.7.0.1
 */