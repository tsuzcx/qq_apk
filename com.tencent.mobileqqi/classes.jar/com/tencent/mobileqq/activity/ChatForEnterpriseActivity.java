package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import cax;
import cay;
import caz;
import cba;
import cbb;
import cbc;
import cbd;
import cbe;
import cbf;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public class ChatForEnterpriseActivity
  extends ChatActivity
{
  private static final String z = "Q.enterprise.ChatForEnterpriseActivity";
  private cbf jdField_a_of_type_Cbf;
  private CustomMenuBar jdField_a_of_type_ComTencentBizUiCustomMenuBar;
  private EnterpriseQQObserver jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver = new cbc(this);
  private PublicAccountInfo jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  List jdField_a_of_type_JavaUtilList = null;
  private Handler jdField_b_of_type_AndroidOsHandler = new cax(this);
  private View jdField_b_of_type_AndroidViewView;
  protected MessageObserver b;
  private ImageView c;
  
  public ChatForEnterpriseActivity()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver = new cay(this);
  }
  
  private void C()
  {
    Object localObject = new ImageView(this);
    ((ImageView)localObject).setId(2131230790);
    ((ImageView)localObject).setImageResource(2130839784);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setOnClickListener(this);
    ((ImageView)localObject).setContentDescription(getString(2131561903));
    new LinearLayout.LayoutParams(-2, -1).rightMargin = ((int)(2.0F * this.jdField_a_of_type_Float));
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, 1);
    }
    this.c = ((ImageView)localObject);
    getLayoutInflater().inflate(2130903089, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231110);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231112));
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231109);
    ((View)localObject).setOnClickListener(new caz(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new cba(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new cbb(this));
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (CrmUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
    {
      List localList = EnterpriseQQManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, c());
      if ((localList != null) && (localList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.addAll(localList);
        a(this.jdField_a_of_type_JavaUtilList);
        d(true);
      }
    }
  }
  
  private void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.ChatForEnterpriseActivity", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    Object localObject = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.ChatForEnterpriseActivity", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs))
      {
        localObject = DialogUtil.a(this, 230, getString(2131558608), String.format(getString(2131558609), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d }), 2131558610, 2131558611, new cbd(this, (PublicAccountDataManager)localObject), new cbe(this, (PublicAccountDataManager)localObject));
        ((QQCustomDialog)localObject).setCanceledOnTouchOutside(true);
        ((QQCustomDialog)localObject).show();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.ChatForEnterpriseActivity", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.enterprise.ChatForEnterpriseActivity", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localPublicAccountDataManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountDataManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      G();
    }
  }
  
  private void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.ChatForEnterpriseActivity", 2, "getMyLocationAndSend(): BEGIN");
    }
    this.jdField_a_of_type_Cbf = new cbf(this, 1, 1, 1, 8);
    SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ");
    SOSOMapLBSApi.getInstance().requestLocationUpdate(getApplicationContext(), this.jdField_a_of_type_Cbf);
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.ChatForEnterpriseActivity", 2, "getMyLocationAndSend(): END");
    }
  }
  
  private StructMsg.ButtonInfo a(int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label156;
      }
      StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)this.jdField_a_of_type_JavaUtilList.get(i);
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
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 3, paramInt, 2, paramBusinessObserver);
    }
  }
  
  private void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.c.setVisibility(0);
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
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem);
        i += 1;
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
  }
  
  protected void a(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.a(paramIntent);
    E();
    F();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!isFinishing())
    {
      C();
      a(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
      a(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
      D();
      EnterpriseQQManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, c(), false);
    }
    sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
    b(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    sendBroadcast(new Intent("com.tencent.mobileqq.RemoveLbsObserver"));
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    this.jdField_a_of_type_Cbf = null;
  }
  
  protected void e()
  {
    Intent localIntent = new Intent(this, EnterpriseDetailActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localIntent.putExtra("need_finish", true);
    startActivityForResult(localIntent, 2000);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838032);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(super.getText(2131560576));
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131230790) {
      d(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatForEnterpriseActivity
 * JD-Core Version:    0.7.0.1
 */