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
import elf;
import elg;
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
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new elf(this);
  TroopAdminList.AdminListAdapter jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter;
  protected XListView a;
  protected final String a;
  protected List a;
  protected String[] a;
  protected String b;
  
  public TroopAdminList()
  {
    this.jdField_a_of_type_JavaLangString = "TroopAdminList";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new elg(this);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.app.getManager(8);
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
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_a_of_type_ArrayOfJavaLangString);
  }
  
  protected boolean c()
  {
    this.b = getIntent().getStringExtra("uin");
    if (TextUtils.isEmpty(this.b)) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = getIntent().getStringArrayListExtra("troop_info_memo");
    } while ((localArrayList == null) || (localArrayList.size() < 1));
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[localArrayList.size()];
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = this.b;
    int k = localArrayList.size();
    int i = 1;
    int j = 0;
    if (i < k)
    {
      if (((String)localArrayList.get(j)).equals(this.b)) {}
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
    View localView = View.inflate(this, 2130903365, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131296780));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    setContentView(localView);
    setTitle(getString(2131362851));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter = new TroopAdminList.AdminListAdapter(this, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (c())
    {
      c();
      d();
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
  
  public void e()
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.app.getManager(8);
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
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList
 * JD-Core Version:    0.7.0.1
 */