package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import das;
import dat;
import dau;
import dav;
import daw;
import dax;
import day;
import daz;
import dba;
import dbb;
import dbc;
import dbd;
import dbe;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class PublicAccountChatActivity
  extends ChatActivity
{
  private static final String A = "2632129500";
  private static final int bw = 1;
  private static final String z = PublicAccountChatActivity.class.getSimpleName();
  private PublicAccountManager jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager;
  private CustomMenuBar jdField_a_of_type_ComTencentBizUiCustomMenuBar;
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new dba(this);
  private Handler jdField_b_of_type_AndroidOsHandler = new das(this);
  private View jdField_b_of_type_AndroidViewView;
  private ImageView c;
  
  private void C()
  {
    Object localObject = new ImageView(this);
    ((ImageView)localObject).setId(2131230790);
    ((ImageView)localObject).setImageResource(2130839784);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setOnClickListener(this);
    ((ImageView)localObject).setContentDescription(getText(2131560552));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    localLayoutParams.bottomMargin = ((int)(6.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 80;
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).getId() != ((ImageView)localObject).getId())) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, 1);
    }
    this.c = ((ImageView)localObject);
    getLayoutInflater().inflate(2130903089, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231112));
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231109);
    ((View)localObject).setOnClickListener(new dbb(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231110);
    D();
    localObject = getSharedPreferences("menuEventSharePre", 0);
    if (!((SharedPreferences)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      ((SharedPreferences.Editor)localObject).commit();
    }
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new dbc(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new dbd(this));
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, c());
    a((List)localObject);
    this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, c(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      d(true);
    }
  }
  
  private void D()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("public_aio_setting", 0);
    String str = "firstOpen_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (localSharedPreferences.getBoolean(str, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.b(new dbe(this, localSharedPreferences, str));
  }
  
  private void E()
  {
    AccountDetail localAccountDetail;
    String str;
    StringBuilder localStringBuilder;
    if (!PublicAccountUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localAccountDetail = PublicAccountUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localAccountDetail != null) && (QLog.isColorLevel()))
      {
        str = z;
        localStringBuilder = new StringBuilder().append("showPublicAccountLbsDialog !isConfirmed ");
        if (localAccountDetail.isConfirmed) {
          break label218;
        }
        bool = true;
        localStringBuilder = localStringBuilder.append(bool).append(" isSyncLbs ").append(localAccountDetail.isSyncLbs).append(" !isAgreeSyncLbs ");
        if (localAccountDetail.isAgreeSyncLbs) {
          break label223;
        }
      }
    }
    label218:
    label223:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool);
      if ((localAccountDetail != null) && (!localAccountDetail.isConfirmed) && (localAccountDetail.isSyncLbs) && (!localAccountDetail.isAgreeSyncLbs))
      {
        DialogUtil.a(this, 230, null, String.format(getString(2131561527), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d }), 2131561936, 2131561577, new dat(this, localAccountDetail), new dau(this)).show();
        PublicAccountUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      return;
      bool = false;
      break;
    }
  }
  
  private void F()
  {
    if (getIntent().getExtras() == null) {
      finish();
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    paramAccountDetail = new NewIntent(this, PublicAccountServlet.class);
    paramAccountDetail.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localSetFunctionFlagRequset.type.set(3);
    localSetFunctionFlagRequset.value.set(1);
    paramAccountDetail.putExtra("data", localSetFunctionFlagRequset.toByteArray());
    paramAccountDetail.setObserver(new dav(this));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramAccountDetail);
  }
  
  private void a(String paramString, int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("need_report", false))
    {
      PublicAccountHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
      long l1 = paramIntent.getLongExtra("incoming_msguid", 0L);
      long l2 = paramIntent.getLongExtra("incoming_shmsgseq", 0L);
      if (l1 > 0L) {
        new Thread(new daw(this, paramString, paramInt, l1, l2), "report_show_msg_result").start();
      }
    }
    if (paramIntent.hasExtra("need_report")) {
      paramIntent.removeExtra("need_report");
    }
  }
  
  private void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
      if ((paramList == null) || (paramList.isEmpty()))
      {
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (this.c != null) {
          this.c.setVisibility(8);
        }
      }
      else
      {
        if (this.c != null) {
          this.c.setVisibility(0);
        }
        int k = paramList.size();
        int i = 0;
        while ((i < k) && (i <= 2))
        {
          Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i);
          Object localObject1;
          String str;
          label150:
          label170:
          MenuItem localMenuItem;
          label206:
          label230:
          mobileqq_mp.ButtonInfo localButtonInfo;
          if (((mobileqq_mp.ButtonInfo)localObject2).key.has())
          {
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
              break label343;
            }
            str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
              break label351;
            }
            j = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
            localMenuItem = new MenuItem((String)localObject1, str, null, j);
            if (!((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
              break label356;
            }
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
              break label383;
            }
            localObject2 = ((List)localObject1).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label383;
            }
            localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
            if (!localButtonInfo.key.has()) {
              break label362;
            }
            localObject1 = localButtonInfo.key.get();
            label273:
            if (!localButtonInfo.name.has()) {
              break label370;
            }
            str = localButtonInfo.name.get();
            label294:
            if (!localButtonInfo.id.has()) {
              break label378;
            }
          }
          label343:
          label351:
          label356:
          label362:
          label370:
          label378:
          for (int j = localButtonInfo.id.get();; j = 0)
          {
            localMenuItem.a(new MenuItem((String)localObject1, str, null, j));
            break label230;
            localObject1 = "";
            break;
            str = "";
            break label150;
            j = 0;
            break label170;
            localObject1 = null;
            break label206;
            localObject1 = "";
            break label273;
            str = "";
            break label294;
          }
          label383:
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem);
          i += 1;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(20);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramIntent);
    E();
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    F();
    super.doOnCreate(paramBundle);
    if (!isFinishing())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager = PublicAccountManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new dax(this));
    }
    if ((NetworkUtil.b(getApplicationContext()) == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals("2632129500"))) {
      HtmlOffline.b(getApplicationContext(), "108", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, new day(this));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    F();
    super.doOnNewIntent(paramIntent);
    if (!isFinishing())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new daz(this));
    }
  }
  
  protected void e()
  {
    PublicAccountHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
    Intent localIntent = new Intent(this, AccountDetailActivity.class);
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    startActivityForResult(localIntent, 2000);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840117);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(super.getText(2131560576));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(20);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(20, 10000L);
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(20);
        if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131230790) {
      d(true);
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountChatActivity
 * JD-Core Version:    0.7.0.1
 */