package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import jo;
import jp;

public class JoinGroupHandler
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private JoinGroupHandler.IJoinGroupCB jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new jp(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private String jdField_a_of_type_JavaLangString;
  
  public JoinGroupHandler(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, JoinGroupHandler.IJoinGroupCB paramIJoinGroupCB)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB = paramIJoinGroupCB;
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, a(), 0, paramInt2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.jdField_a_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopInfo);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.b();
      return;
    }
    a(2131363379, 1);
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
  }
  
  private void b(long paramLong)
  {
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17);
      this.jdField_a_of_type_Long = paramLong;
      localTroopHandler.a(paramLong, 8388736);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(2131362903, 0);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363569);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new jo(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    c();
  }
  
  public void a(long paramLong)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131362923, 0);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
      return;
    }
    if (0L == paramLong)
    {
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    e();
    b(paramLong);
  }
  
  public void b()
  {
    d();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.JoinGroupHandler
 * JD-Core Version:    0.7.0.1
 */