package com.tencent.biz.pubaccount.assistant;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import bkt;
import bku;
import bkv;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PubAccountAssistantSettingActivity
  extends IphoneTitleBarActivity
{
  private Handler jdField_a_of_type_AndroidOsHandler = new bkt(this);
  private PubAccountAssistantSettingAdapter jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new bku(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Comparator jdField_a_of_type_JavaUtilComparator = new bkv(this);
  private List jdField_a_of_type_JavaUtilList;
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilList = ((PublicAccountDataManager)this.b.getManager(51)).a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((PublicAccountInfo)localIterator.next()).mShowMsgFlag == -1) {
        localIterator.remove();
      }
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter = new PubAccountAssistantSettingAdapter(this.b, getApplicationContext(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903425);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232568));
    paramBundle = View.inflate(this, 2130903426, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(paramBundle);
    d();
    setTitle(2131560557);
    paramBundle = (PublicAccountHandler)this.b.a(10);
    a(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    paramBundle.a();
    String str = this.k.getText().toString();
    paramBundle = str;
    if (!getString(2131560958).equals(str)) {
      paramBundle = String.format(getResources().getString(2131560564), new Object[] { str });
    }
    this.k.setContentDescription(paramBundle);
    ReportController.b(this.b, "P_CliOper", "Pb_account_lifeservice", this.b.getAccount(), "mp_msg_zhushou_2", "share_succ", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */