package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopCreateEnterActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eoc;
import eod;
import eoe;
import java.util.Timer;
import mqq.manager.Manager;

public class TroopCreateLogic
  implements Manager
{
  public static final int a = 0;
  public static final String a = "troop_create_from";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 0;
  private static final String d = "TroopCreate_Log";
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 51;
  public Activity a;
  public Dialog a;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new eoc(this);
  public QQAppInterface a;
  public TroopCreateLogic.TroopCreateCallback a;
  private TroopCreateLogic.TroopCreateInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo = new TroopCreateLogic.TroopCreateInfo();
  TroopCreatePermissionData jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData;
  public Timer a;
  public String b = "DEFAULT";
  public String c;
  public int l = 0;
  public int m = 0;
  
  public TroopCreateLogic(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private String a()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData != null)
    {
      str = "" + String.format("\n    200:  max: %d  created: %d    permission: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.f), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.j), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.n) });
      str = str + String.format("\n    500:  max: %d  created: %d    permission: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.g), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.k), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.o) });
      str = str + String.format("\n    1000: max: %d  created: %d    permission: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.h), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.l), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.p) });
      str = str + String.format("\n    2000: max: %d  created: %d    permission: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.i), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.m), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData.q) });
    }
    return str;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void b(String paramString)
  {
    b();
    if (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      return;
    }
    Object localObject = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
    localObject = new QQProgressDialog((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
    ((QQProgressDialog)localObject).a(paramString);
    ((QQProgressDialog)localObject).setCancelable(false);
    ((QQProgressDialog)localObject).setOnDismissListener(new eod(this));
    this.jdField_a_of_type_AndroidAppDialog = ((Dialog)localObject);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public final TroopCreateLogic.TroopCreateInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo;
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreatePermissionData = null;
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.l = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.a();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if ((paramActivity instanceof TroopCreateEnterActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreateEnterActivity", 2, "checkFinishActivity");
      }
      paramActivity.setResult(0);
      paramActivity.finish();
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    this.m = paramInt;
    a();
    b(paramActivity);
  }
  
  public void a(Activity paramActivity, int paramInt, String paramString)
  {
    this.m = paramInt;
    this.b = paramString;
    a();
    b(paramActivity);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      return;
    }
    QQToast.a(paramBaseActivity, paramBaseActivity.getString(2131362326), 1).b(paramBaseActivity.getTitleBarHeight());
  }
  
  public void a(TroopCreateLogic.TroopCreateCallback paramTroopCreateCallback)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateAdvanceData == null)) {
      return;
    }
    TroopCreateAdvanceData localTroopCreateAdvanceData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateAdvanceData;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = paramTroopCreateCallback;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    for (;;)
    {
      try
      {
        long l3 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
        if (localBizTroopHandler == null) {
          break;
        }
        String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_d_of_type_JavaLangString.split("\\|");
        n = 0;
        l1 = 0L;
        l2 = 0L;
        paramTroopCreateCallback = "";
        if (arrayOfString.length == 4)
        {
          try
          {
            n = Integer.parseInt(arrayOfString[0]);
          }
          catch (NumberFormatException paramTroopCreateCallback)
          {
            float f1;
            int i2;
            int i1;
            l1 = 0L;
            n = 0;
            continue;
          }
          try
          {
            f1 = Float.valueOf(arrayOfString[1]).floatValue();
            l1 = (f1 * 1000000.0F);
          }
          catch (NumberFormatException paramTroopCreateCallback)
          {
            l1 = 0L;
            continue;
          }
          try
          {
            f1 = Float.valueOf(arrayOfString[2]).floatValue();
            l2 = (f1 * 1000000.0F);
          }
          catch (NumberFormatException paramTroopCreateCallback)
          {
            continue;
          }
          paramTroopCreateCallback = arrayOfString[3];
          i2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.e;
          i1 = i2;
          if (i2 == 2) {
            i1 = i2 + 1;
          }
          localBizTroopHandler.a(localTroopCreateAdvanceData.b, localTroopCreateAdvanceData.f, l3, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.b, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_c_of_type_Int, 0, i1, l1, l2, n, paramTroopCreateCallback, localTroopCreateAdvanceData.a, this.m, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_Boolean);
          return;
        }
      }
      catch (NumberFormatException paramTroopCreateCallback)
      {
        int n;
        long l1;
        return;
      }
      long l2 = 0L;
    }
  }
  
  public final void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.a(paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing());
  }
  
  public void b(Activity paramActivity)
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      if (!(paramActivity instanceof BaseActivity)) {
        break label159;
      }
    }
    label159:
    for (int n = ((BaseActivity)paramActivity).getTitleBarHeight();; n = 0)
    {
      if (paramActivity != null) {
        QQToast.a(paramActivity, 2131362923, 0).b(n);
      }
      a(paramActivity);
      return;
      BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
      if (localBizTroopHandler == null)
      {
        a(paramActivity);
        return;
      }
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        this.jdField_a_of_type_AndroidAppActivity = paramActivity;
        b(paramActivity.getString(2131362325));
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_JavaUtilTimer.schedule(new eoe(this), 10000L);
        this.l = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        localBizTroopHandler.a(l1);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        a(paramActivity);
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic
 * JD-Core Version:    0.7.0.1
 */