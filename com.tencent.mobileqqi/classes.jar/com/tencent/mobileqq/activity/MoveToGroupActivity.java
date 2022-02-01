package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import cwi;
import cwj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoveToGroupActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  public static final int a = 0;
  public static final String a = "PARAM_EXECUTE_IMMEDIATELY";
  public byte a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cwi(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private cwj jdField_a_of_type_Cwj = null;
  public List a;
  private byte jdField_b_of_type_Byte;
  private String jdField_b_of_type_JavaLangString;
  
  public MoveToGroupActivity()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  private void d()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = localQQProgressDialog;
    localQQProgressDialog.a(d());
    localQQProgressDialog.show();
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  private void f()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.jdField_a_of_type_Byte);
    setResult(-1, localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "AIO_edit_category_move");
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
    finish();
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject != null) {}
    for (localObject = ((FriendManager)localObject).c();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Groups localGroups = (Groups)((Iterator)localObject).next();
          if (localGroups.group_id != -1006) {
            this.jdField_a_of_type_JavaUtilList.add(localGroups);
          }
        }
      }
      return;
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Byte = ((byte)((Groups)this.jdField_a_of_type_JavaUtilList.get(paramInt)).group_id);
    if (this.jdField_a_of_type_Cwj != null) {
      this.jdField_a_of_type_Cwj.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true))
    {
      if ((this.jdField_a_of_type_Byte >= 0) && (this.jdField_a_of_type_Byte != this.jdField_b_of_type_Byte))
      {
        if (NetworkUtil.e(this))
        {
          paramAdapterView = (FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
          a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          paramAdapterView.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Byte, this.jdField_b_of_type_Byte);
          d();
          return;
        }
        QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), getString(2131562445), 1).b(d());
        finish();
        return;
      }
      if (this.jdField_a_of_type_Byte == this.jdField_b_of_type_Byte) {
        QQToast.a(this, getString(2131562211), 0).b(d());
      }
    }
    f();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903284);
    setTitle(getString(2131561812));
    this.jdField_b_of_type_JavaLangString = getIntent().getExtras().getString("friendUin");
    this.jdField_b_of_type_Byte = getIntent().getExtras().getByte("mgid");
    this.jdField_a_of_type_Byte = this.jdField_b_of_type_Byte;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    g();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131231934));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Cwj = new cwj(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Cwj);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */