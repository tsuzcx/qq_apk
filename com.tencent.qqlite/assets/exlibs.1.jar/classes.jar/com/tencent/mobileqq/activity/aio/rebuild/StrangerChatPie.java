package com.tencent.mobileqq.activity.aio.rebuild;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import bzr;
import bzs;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class StrangerChatPie
  extends BaseChatPie
{
  private final String H = "StrangerChatPie";
  protected MessageObserver a;
  private ShieldListObserver a;
  boolean n = false;
  private boolean o = false;
  private boolean p = false;
  
  public StrangerChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new bzr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new bzs(this);
  }
  
  private void ab()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (localObject == null) {}
    do
    {
      String str;
      do
      {
        return;
        str = ((Intent)localObject).getStringExtra("gid");
      } while (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str));
      localObject = StructMsgFactory.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
    } while (localObject == null);
    ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (AbsStructMsg)localObject, null);
    if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "1", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "", "1", "", "");
  }
  
  protected void E()
  {
    super.E();
    if ((this.p) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm"))) {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  protected void Q()
  {
    super.Q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
  }
  
  protected void R()
  {
    super.R();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((MsgProxyUtils.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.a(paramMessageRecord.istroop))));
  }
  
  public void aa()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      Intent localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, 3006, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, null, null, null);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.n)
    {
      this.n = false;
      ab();
    }
    if (this.o)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.o);
      this.o = false;
    }
  }
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1020) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004)) {
        break label108;
      }
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
      this.b.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      return;
      label108:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        paramIntent = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramIntent != null) {
          paramIntent = paramIntent.name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) {
          paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        } else {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        if (str != null)
        {
          paramIntent = str;
          if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        }
        else
        {
          paramIntent = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramIntent = str;
          }
        }
      }
    }
  }
  
  protected boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006);
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramIntent.getStringExtra("troop_code");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c.trim().length() == 0))
      {
        localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = ((FriendManager)localObject).g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c != null) {}
      }
    }
    for (;;)
    {
      this.n = paramIntent.getBooleanExtra("fromSencondhandCommunity", false);
      this.p = paramIntent.getBooleanExtra("from3rdApp", false);
      this.o = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      StartupTracker.a("AIO_updateSession_business", null);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) && (QLog.isColorLevel())) {
          QLog.e("StrangerChatPie", 2, "contactUin == null");
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003)
      {
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
        {
          ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        else
        {
          localObject = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject == null)
          {
            if (StringUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
            }
          }
          else if ((localObject != null) && (((Card)localObject).strCertificationInfo != null) && (!((Card)localObject).strCertificationInfo.equals(""))) {
            ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
      {
        localObject = paramIntent.getByteArrayExtra("rich_status_sig");
        if (QLog.isColorLevel()) {
          QLog.d("StrangerChatPie", 2, "From chatActivity : sameState Sig--->" + HexUtil.a((byte[])localObject));
        }
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
      {
        localObject = paramIntent.getByteArrayExtra("rich_accost_sig");
        if (QLog.isColorLevel()) {
          QLog.d("StrangerChatPie", 2, "From chatActivity : accost Sig--->" + HexUtil.a((byte[])localObject));
        }
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        }
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
        {
          ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        else
        {
          localObject = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject == null)
          {
            if (StringUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
            }
          }
          else if ((localObject != null) && (((Card)localObject).strCertificationInfo != null) && (!((Card)localObject).strCertificationInfo.equals(""))) {
            ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
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
  
  protected boolean f()
  {
    return (!this.p) || (!"schemeconfirm".equals(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type")));
  }
  
  protected void k()
  {
    super.k();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) {
      this.e.setVisibility(8);
    }
  }
  
  protected void l()
  {
    this.c.setVisibility(8);
  }
  
  public void m()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals(""))) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("isShieldMsgSwitchUnClickable", bool);
      if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
      return;
    }
  }
  
  protected void o()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
      localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ((String)localObject);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          localObject = ((PhoneContact)localObject).name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) {
          localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        } else {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005) {
          if (str != null)
          {
            localObject = str;
            if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = str;
          }
        }
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.a(paramObservable.istroop)))) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if ((paramObservable == null) || (paramObservable.istroop != 1001) || (paramObservable.msgtype != -3001)) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie
 * JD-Core Version:    0.7.0.1
 */