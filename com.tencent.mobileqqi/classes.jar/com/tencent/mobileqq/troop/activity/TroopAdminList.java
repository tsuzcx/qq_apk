package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import gri;
import grj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TroopAdminList
  extends IphoneTitleBarActivity
{
  public View.OnClickListener a;
  protected LinearLayout a;
  protected FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gri(this);
  TroopAdminList.AdminListAdapter jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter;
  protected XListView a;
  protected final String a;
  protected List a;
  protected String[] a;
  protected String b;
  
  public TroopAdminList()
  {
    this.jdField_a_of_type_JavaLangString = "TroopAdminList";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new grj(this);
  }
  
  protected boolean c()
  {
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uin");
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = getIntent().getStringArrayListExtra("troop_info_memo");
    } while ((localArrayList == null) || (localArrayList.size() < 1));
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[localArrayList.size()];
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = this.jdField_b_of_type_JavaLangString;
    int k = localArrayList.size();
    int i = 1;
    int j = 0;
    if (i < k)
    {
      if (((String)localArrayList.get(j)).equals(this.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        j += 1;
        break;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)localArrayList.get(j));
        i += 1;
      }
    }
    return true;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    int i = 0;
    int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    while (i < j)
    {
      String str = this.jdField_a_of_type_ArrayOfJavaLangString[i];
      if (!TextUtils.isEmpty(str))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("uin", str);
        localHashMap.put("nick", localFriendsManagerImp.c(str));
        this.jdField_a_of_type_JavaUtilList.add(localHashMap);
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_ArrayOfJavaLangString);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (c())
    {
      d();
      e();
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("TroopAdminList", 2, "onCreate, illegal param, troopuin = ");
      }
      finish();
    }
  }
  
  protected void e()
  {
    View localView = View.inflate(this, 2130903449, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131231313));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    setContentView(localView);
    setTitle(getString(2131561620));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter = new TroopAdminList.AdminListAdapter(this, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter);
  }
  
  public void f()
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)((Map)this.jdField_a_of_type_JavaUtilList.get(i)).get("uin");
      ((Map)this.jdField_a_of_type_JavaUtilList.get(i)).put("nick", localFriendsManagerImp.c(str));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter.notifyDataSetChanged();
  }
  
  public void onDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList
 * JD-Core Version:    0.7.0.1
 */