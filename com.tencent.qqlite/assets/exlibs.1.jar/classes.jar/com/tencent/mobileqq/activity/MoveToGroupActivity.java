package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import avx;
import avy;
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
import com.tencent.widget.XListView;
import java.util.List;

public class MoveToGroupActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "PARAM_EXECUTE_IMMEDIATELY";
  public byte a;
  private avy jdField_a_of_type_Avy = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new avx(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public List a;
  private byte jdField_b_of_type_Byte;
  private String jdField_b_of_type_JavaLangString;
  
  public MoveToGroupActivity()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  private void c()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = localQQProgressDialog;
    localQQProgressDialog.a(getTitleBarHeight());
    localQQProgressDialog.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.jdField_a_of_type_Byte);
    setResult(-1, localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "AIO_edit_category_move");
    }
    ReportController.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
    finish();
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilList = ((FriendManager)this.app.getManager(8)).c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903240);
    setTitle(getString(2131363446));
    this.jdField_b_of_type_JavaLangString = getIntent().getExtras().getString("friendUin");
    this.jdField_b_of_type_Byte = getIntent().getExtras().getByte("mgid");
    this.jdField_a_of_type_Byte = this.jdField_b_of_type_Byte;
    f();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297312));
    this.jdField_a_of_type_Avy = new avy(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Avy);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    d();
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.jdField_a_of_type_Byte = ((byte)((Groups)this.jdField_a_of_type_JavaUtilList.get(i)).group_id);
    if (this.jdField_a_of_type_Avy != null) {
      this.jdField_a_of_type_Avy.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true))
    {
      if ((this.jdField_a_of_type_Byte >= 0) && (this.jdField_a_of_type_Byte != this.jdField_b_of_type_Byte))
      {
        if (NetworkUtil.e(this))
        {
          paramView = (FriendListHandler)this.app.a(1);
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          paramView.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Byte, this.jdField_b_of_type_Byte);
          c();
          return;
        }
        QQToast.a(this.app.a(), getString(2131363460), 1).b(getTitleBarHeight());
        finish();
        return;
      }
      if (this.jdField_a_of_type_Byte == this.jdField_b_of_type_Byte) {
        QQToast.a(this, getString(2131363432), 0).b(getTitleBarHeight());
      }
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */