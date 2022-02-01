package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.widget.QQToast;
import gxf;

public class AddTroopHelper
{
  public int a;
  protected Context a;
  public QQAppInterface a;
  protected TroopHandler a;
  public TroopObserver a;
  public String a;
  
  public AddTroopHelper(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gxf(this);
  }
  
  private final void a(TroopInfo paramTroopInfo)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramTroopInfo.troopuin))) {
      return;
    }
    if (paramTroopInfo.cGroupOption == 3)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131563078, 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).d());
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddFriendLogicActivity.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("uin", paramTroopInfo.troopuin);
    localIntent.putExtra("name", paramTroopInfo.troopname);
    localIntent.putExtra("troop_code", paramTroopInfo.troopuin);
    localIntent.putExtra("group_option", paramTroopInfo.cGroupOption);
    localIntent.putExtra("stat_option", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (paramString != null) {}
    for (paramString = paramString.a(this.jdField_a_of_type_JavaLangString); paramString == null; paramString = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramString.troopuin, (byte)1, paramString.dwTimeStamp, this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (paramString != null) {}
    for (paramString = paramString.a(this.jdField_a_of_type_JavaLangString); paramString == null; paramString = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramString.troopuin, (byte)1, paramString.dwTimeStamp, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AddTroopHelper
 * JD-Core Version:    0.7.0.1
 */