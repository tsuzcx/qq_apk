package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import byw;
import byx;
import byy;
import byz;
import bza;
import bzb;
import bzc;
import bzd;
import bze;
import bzf;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public class BusinessCmrTmpChatPie
  extends FriendChatPie
{
  private final String H = "BusinessChatPie";
  private bzf jdField_a_of_type_Bzf;
  private CustomMenuBar jdField_a_of_type_ComTencentBizUiCustomMenuBar;
  private EnterpriseQQObserver jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver = new bzb(this);
  protected MessageObserver a;
  private PublicAccountInfo jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  private Handler b;
  protected MessageObserver b;
  public List b;
  private View c;
  private ImageView f;
  
  public BusinessCmrTmpChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
    this.jdField_b_of_type_AndroidOsHandler = new byw(this);
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new byx(this);
    this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver = new bze(this);
  }
  
  private StructMsg.ButtonInfo a(int paramInt)
  {
    Object localObject;
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
        break label156;
      }
      StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)this.jdField_b_of_type_JavaUtilList.get(i);
      localObject = localButtonInfo;
      if (localButtonInfo.id.get() == paramInt) {
        break;
      }
      localObject = localButtonInfo.sub_button.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int j = 0;
        while (j < ((List)localObject).size())
        {
          if (((StructMsg.ButtonInfo)((List)localObject).get(j)).id.get() == paramInt) {
            return (StructMsg.ButtonInfo)((List)localObject).get(j);
          }
          j += 1;
        }
      }
      i += 1;
    }
    label156:
    return null;
  }
  
  private void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(18);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 3, paramInt, 2, paramBusinessObserver);
    }
  }
  
  private void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.f.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.f.setVisibility(0);
      int j = paramList.size();
      int i = 0;
      while ((i < j) && (i <= 2))
      {
        Object localObject = (StructMsg.ButtonInfo)paramList.get(i);
        MenuItem localMenuItem = new MenuItem(((StructMsg.ButtonInfo)localObject).key.get(), ((StructMsg.ButtonInfo)localObject).name.get(), null, ((StructMsg.ButtonInfo)localObject).id.get());
        if (((StructMsg.ButtonInfo)localObject).sub_button.get().size() > 0)
        {
          localObject = ((StructMsg.ButtonInfo)localObject).sub_button.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)((Iterator)localObject).next();
            localMenuItem.a(new MenuItem(localButtonInfo.key.get(), localButtonInfo.name.get(), null, localButtonInfo.id.get()));
          }
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem, a());
        i += 1;
      }
    }
  }
  
  private void aa()
  {
    Object localObject = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((ImageView)localObject).setId(2131296317);
    ((ImageView)localObject).setImageResource(2130839198);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setOnClickListener(this);
    ((ImageView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364170));
    new LinearLayout.LayoutParams(-2, -1).rightMargin = ((int)(2.0F * this.jdField_a_of_type_Float));
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, 1);
    }
    this.f = ((ImageView)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903066, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.c = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296557);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296560));
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296556);
    ((View)localObject).setOnClickListener(new byy(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new byz(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new bza(this));
  }
  
  private void ab()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    List localList = EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    if ((localList != null) && (localList.size() > 0))
    {
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
      a(this.jdField_b_of_type_JavaUtilList);
      h(true);
    }
  }
  
  private void ac()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs))
      {
        String str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361933);
        String str2 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361934), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, str1, str2, 2131361935, 2131361936, new bzc(this, (PublicAccountDataManager)localObject), new bzd(this, (PublicAccountDataManager)localObject));
        ((QQCustomDialog)localObject).setCanceledOnTouchOutside(true);
        ((QQCustomDialog)localObject).show();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.e("BusinessChatPie", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
  
  private void ad()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
      if (localPublicAccountDataManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountDataManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      ae();
    }
  }
  
  private void ae()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "getMyLocationAndSend(): BEGIN");
    }
    this.jdField_a_of_type_Bzf = new bzf(this, 1, 1, 1, 8);
    SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ");
    SOSOMapLBSApi.getInstance().requestLocationUpdate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), this.jdField_a_of_type_Bzf);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "getMyLocationAndSend(): END");
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.f.setVisibility(0);
  }
  
  protected void Q()
  {
    super.Q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void R()
  {
    super.R();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      aa();
      ab();
      EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), false);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(new Intent("com.tencent.qqlite.addLbsObserver"));
    return true;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.c(paramIntent);
    ac();
    ad();
  }
  
  protected void d(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_business");
    paramIntent = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "From chatActivity : buinessCrm Sigt--->" + HexUtil.a(paramIntent));
    }
    if (paramIntent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("BusinessChatPie", 4, "updateSession()--AIO 已保存 sigt");
      }
    }
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  protected void g()
  {
    super.g();
  }
  
  protected void l() {}
  
  public void m()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, EnterpriseDetailActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localIntent.putExtra("need_finish", true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
  }
  
  protected void n()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839273);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131296317) {
      h(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie
 * JD-Core Version:    0.7.0.1
 */