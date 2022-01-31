package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import btt;
import btu;
import btv;
import btw;
import btx;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AddFriendLogicActivity
  extends BaseActivity
{
  public static final int a = 10004;
  public static final String a = "AddFriendLogicActivity";
  public static final int b = 3001;
  public static final String b = "param_last_activity_name";
  public static final int c = 3002;
  public static final String c = "stat_option";
  public static final int d = 3003;
  public static final int e = 3004;
  public static final int f = 3005;
  public static final int g = 3006;
  public static final int h = 3009;
  public static final int i = 3007;
  public static final int j = 3008;
  public static final int k = 3010;
  public static final int l = 3011;
  public static final int m = 3012;
  public static final int n = 3013;
  public static final int o = 3014;
  public static final int p = 3008;
  public static final int q = 3017;
  public static final int r = 0;
  public static final int s = 1;
  public static final int t = 2;
  public DialogInterface.OnClickListener a;
  public DialogInterface.OnDismissListener a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new btx(this);
  final Friends jdField_a_of_type_ComTencentMobileqqDataFriends = new Friends();
  private final TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo = new TroopInfo();
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  public QQProgressDialog a;
  boolean jdField_a_of_type_Boolean = false;
  public DialogInterface.OnClickListener b;
  String d;
  String e = null;
  String f = null;
  public int u = 10004;
  public int v = 0;
  private int w = 0;
  
  public AddFriendLogicActivity()
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new btu(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new btv(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new btw(this);
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null)
      {
        localObject = ((FriendManager)localObject).c(paramString1);
        if (!paramString1.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          break label76;
        }
        QQToast.a(this, 2131561483, 0).b(d());
        finish();
      }
    }
    label76:
    do
    {
      return;
      localObject = null;
      break;
      if ((localObject != null) && (((Friends)localObject).groupid >= 0))
      {
        QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131561423, 0).b(d());
        finish();
        return;
      }
      if (!NetworkUtil.e(this)) {
        break label178;
      }
      ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString1, paramInt, paramString2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562649);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new btt(this));
    } while (isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    return;
    label178:
    QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131562449, 0).b(d());
    finish();
  }
  
  private void d()
  {
    if (((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode) != null)
    {
      QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131563234, 0).b(d());
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption == 3)
    {
      localObject = getIntent().getStringExtra("name");
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        getString(2131562263);
      }
      QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131563078, 0).b(d());
      return;
    }
    Object localObject = new Intent(this, AddFriendVerifyActivity.class);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode);
    ((Intent)localObject).putExtra("nick_name", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname);
    ((Intent)localObject).putExtra("friend_setting", 9);
    ((Intent)localObject).putExtra("stat_option", getIntent().getIntExtra("stat_option", 0));
    ((Intent)localObject).putExtra("group_option", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
    ((Intent)localObject).putExtra("troop_question", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.joinTroopQuestion);
    ((Intent)localObject).putExtra("troop_answer", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.joinTroopAnswer);
    if ("d2g".equals(getIntent().getStringExtra("jump_from"))) {
      ((Intent)localObject).putExtra("jump_from", "d2g");
    }
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      ((Intent)localObject).putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity((Intent)localObject);
      finish();
      return;
    }
    startActivityForResult((Intent)localObject, 0);
  }
  
  private void e()
  {
    int i1 = getIntent().getIntExtra("type", 0);
    boolean bool;
    if (!TextUtils.isEmpty(this.e))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (i1 != 0) {
        break label168;
      }
      localObject1 = getIntent().getStringExtra("nick_name");
      if (localObject1 == null) {
        break label88;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataFriends.name = ((String)localObject1);
      label55:
      this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin = this.d;
      a(this.d, this.u, this.e);
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      Object localObject2 = getIntent().getStringExtra("troopuin");
      if (localObject2 == null) {
        break label55;
      }
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject2 = (TroopMemberInfo)((EntityManager)localObject1).a(TroopMemberInfo.class, new String[] { localObject2, this.d });
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataFriends.name = ((TroopMemberInfo)localObject2).friendnick;
      }
      ((EntityManager)localObject1).a();
      break label55;
      if (i1 == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname = getIntent().getStringExtra("name");
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode = getIntent().getStringExtra("troop_code");
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin = this.d;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption = getIntent().getShortExtra("group_option", (short)2);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.joinTroopQuestion = getIntent().getStringExtra("join_group_question");
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.joinTroopAnswer = getIntent().getStringExtra("join_group_answer");
        d();
        return;
      }
    } while (!this.jdField_a_of_type_Boolean);
    label168:
    this.e = getIntent().getStringExtra("friend_mobile_number");
    this.f = getIntent().getStringExtra("friend_mobile_name");
    if (TextUtils.isEmpty(this.f))
    {
      localObject1 = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject1 == null) {
        break label471;
      }
    }
    label461:
    label471:
    for (Object localObject1 = ((PhoneContactManager)localObject1).f(this.e);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        this.f = ((PhoneContact)localObject1).name;
        this.f = AutoRemarkActivity.a(this.f);
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendLogicActivity", 2, "on create get mobile name:" + this.f);
        }
        if (10004 == this.u) {
          if (i1 != 4) {
            break label461;
          }
        }
      }
      for (this.u = 3009;; this.u = 3006)
      {
        a(this.d, this.u, this.e);
        return;
        if (this.f != null) {
          break;
        }
        this.f = "";
        break;
      }
    }
  }
  
  private void f()
  {
    String str2;
    Object localObject2;
    String str3;
    String str1;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.w != 0))
    {
      str2 = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.w);
      localObject2 = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.w);
      str3 = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.w);
      str1 = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.w);
      if (str2 != null) {
        break label398;
      }
      if (this.w != 1) {
        break label263;
      }
      i1 = 2131561390;
      str2 = getString(i1);
    }
    label263:
    label398:
    for (;;)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (this.w == 1) {
          localObject1 = getString(2131561392);
        }
      }
      else
      {
        label145:
        if (str3 != null) {
          break label342;
        }
        if (this.w != 1) {
          break label330;
        }
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
        localObject2 = str3;
        label167:
        if (str1 != null) {
          break label380;
        }
        if (this.w != 1) {
          break label369;
        }
        str1 = getString(2131561396);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(str2);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject2, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(str1, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
        if ((this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) || (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131231484).setVisibility(8);
        }
        return;
        i1 = 2131561391;
        break;
        if (this.w == 2)
        {
          localObject1 = getString(2131561393);
          break label145;
        }
        if (this.w == 3)
        {
          localObject1 = getString(2131561394);
          break label145;
        }
        localObject1 = localObject2;
        if (this.w != 4) {
          break label145;
        }
        localObject1 = getString(2131561395);
        break label145;
        label330:
        localObject2 = getString(2131561397);
        break label167;
        label342:
        localObject2 = str3;
        if (!TextUtils.isEmpty(str3.trim())) {
          break label167;
        }
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
        localObject2 = str3;
        break label167;
        label369:
        str1 = getString(2131561398);
        continue;
        label380:
        if (TextUtils.isEmpty(str1.trim())) {
          this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = null;
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList paramArrayList, Class paramClass)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("param_mode", 0);
    paramClass.putExtra("uin", this.d);
    paramClass.putExtra("friend_setting", paramInt);
    paramClass.putExtra("allow_flag", true);
    paramClass.putExtra("msg", (String)null);
    paramClass.putExtra("source_id", this.u);
    paramClass.putExtra("friend_mobile_number", this.e);
    paramClass.putExtra("friend_mobile_name", this.f);
    paramClass.putExtra("sub_source_id", this.v);
    paramClass.putExtra("contact_bothway", paramBoolean);
    paramClass.putExtra("k_add_friend_by_mobile", this.jdField_a_of_type_Boolean);
    paramClass.putExtra("user_question", paramArrayList);
    paramClass.putExtra("nick_name", this.jdField_a_of_type_ComTencentMobileqqDataFriends.name);
    if (getIntent().getIntExtra("source_id", 10004) == 3004) {
      paramClass.putExtra("troop_uin", getIntent().getStringExtra("troop_uin"));
    }
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      paramClass.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity(paramClass);
      finish();
      return;
    }
    startActivityForResult(paramClass, 0);
  }
  
  protected String a_()
  {
    String str2 = getIntent().getStringExtra("param_last_activity_name");
    String str1 = str2;
    if (str2 == null) {
      str1 = super.a_();
    }
    return str1;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    this.d = getIntent().getStringExtra("uin");
    this.e = getIntent().getStringExtra("friend_mobile_number");
    this.u = getIntent().getIntExtra("source_id", 10004);
    this.v = getIntent().getIntExtra("sub_source_id", 0);
    Object localObject;
    if ((!TextUtils.isEmpty(this.d)) || (!TextUtils.isEmpty(this.e)))
    {
      paramBundle = this.d;
      localObject = paramBundle;
      if (getIntent().getIntExtra("type", 0) == 1) {
        break label291;
      }
      if (!TextUtils.isEmpty(this.e)) {
        paramBundle = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b(this.e);
      }
      localObject = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        break label291;
      }
      localObject = paramBundle;
      if (paramBundle.equals("0")) {
        break label291;
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        if (NetworkUtil.e(this))
        {
          localObject = (FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
          long l1;
          if (localObject != null) {
            l1 = 0L;
          }
          try
          {
            long l2 = Long.parseLong(paramBundle);
            l1 = l2;
          }
          catch (Throwable paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
            }
          }
          ((FriendListHandler)localObject).b("OidbSvc.0x476_147", (int)l1, 147);
          return true;
        }
        QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131562449, 0).b(d());
        finish();
        return true;
      }
      e();
      return true;
      finish();
      return true;
      label291:
      paramBundle = (Bundle)localObject;
    }
  }
  
  protected void doOnDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity
 * JD-Core Version:    0.7.0.1
 */