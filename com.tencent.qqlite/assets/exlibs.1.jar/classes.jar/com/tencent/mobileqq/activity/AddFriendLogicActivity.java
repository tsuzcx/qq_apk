package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wo;
import wp;
import wq;
import wr;
import ws;
import wt;
import wu;
import wv;

public class AddFriendLogicActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a = "k_uin_type";
  public static final int b = 2;
  public static String b;
  public static final int c = 3;
  public static final String c = "stat_option";
  public static final int d = 4;
  private static final String d = "last_activity";
  private static final int jdField_e_of_type_Int = 0;
  private static final int jdField_f_of_type_Int = 1;
  public DialogInterface.OnClickListener a;
  public DialogInterface.OnDismissListener a;
  public Handler a;
  protected OpenIdObserver a;
  protected QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private wv jdField_a_of_type_Wv;
  public boolean a;
  public DialogInterface.OnClickListener b;
  private QQCustomDialog b;
  private String jdField_e_of_type_JavaLangString;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private int h;
  private int i;
  
  static
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  public AddFriendLogicActivity()
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new wq(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new wr(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new ws(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new wu(this);
  }
  
  public static Intent a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return a(paramActivity, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public static Intent a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Intent localIntent = new Intent(paramActivity, AddFriendLogicActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("k_uin_type", paramInt1);
    localIntent.putExtra("extra", paramString2);
    localIntent.putExtra("source_id", paramInt2);
    localIntent.putExtra("sub_source_id", paramInt3);
    paramActivity = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramActivity = AutoRemarkActivity.a(paramString3);
    }
    localIntent.putExtra("nick_name", paramActivity);
    paramActivity = paramString4;
    if (paramString4 != null)
    {
      paramActivity = paramString4;
      if (paramString4.length() > 30) {
        paramActivity = paramString4.substring(0, 28);
      }
    }
    localIntent.putExtra("msg", paramActivity);
    localIntent.putExtra("param_return_addr", paramString5);
    localIntent.putExtra("last_activity", paramString6);
    localIntent.putExtra("src_name", paramString7);
    return localIntent;
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString4 = new Intent(paramContext, AddFriendLogicActivity.class);
    paramString4.putExtra("uin", paramString1);
    paramString4.putExtra("k_uin_type", paramInt1);
    paramString4.putExtra("extra", paramString2);
    paramString4.putExtra("source_id", paramInt2);
    paramString4.putExtra("sub_source_id", paramInt3);
    paramContext = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramContext = AutoRemarkActivity.a(paramString3);
    }
    paramString4.putExtra("nick_name", paramContext);
    paramString4.putExtra("last_activity", paramString6);
    return paramString4;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramContext = new Intent(paramContext, AddFriendLogicActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("k_uin_type", 4);
    paramContext.putExtra("group_option", paramShort);
    paramContext.putExtra("troop_question", paramString3);
    paramContext.putExtra("troop_answer", paramString4);
    paramContext.putExtra("nick_name", paramString2);
    paramContext.putExtra("stat_option", paramInt);
    paramContext.putExtra("param_return_addr", paramString5);
    paramContext.putExtra("last_activity", paramString6);
    return paramContext;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      finish();
      return false;
    case 1: 
      if (paramString.equals(this.app.a()))
      {
        QQToast.a(this, 2131363365, 0).b(getTitleBarHeight());
        finish();
        return false;
      }
    case 2: 
      for (;;)
      {
        try
        {
          Long.parseLong(paramString);
          FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
          if (localFriendManager != null)
          {
            paramString = localFriendManager.c(paramString);
            if ((paramString == null) || (paramString.groupid < 0)) {
              break;
            }
            QQToast.a(this.app.getApplication(), 2131363366, 0).b(getTitleBarHeight());
            finish();
            return false;
          }
        }
        catch (Throwable paramString)
        {
          return false;
        }
        paramString = null;
        continue;
        if (this.h == 10004)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacts.", 2, "mobile source id is default!");
          }
          this.h = 3006;
        }
      }
    }
    while (!NetworkUtil.e(this))
    {
      QQToast.a(this.app.getApplication(), 2131363516, 0).b(getTitleBarHeight());
      finish();
      return false;
      if (this.h == 10004)
      {
        this.h = 3016;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "openId source id is default!");
        }
      }
    }
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    ((FriendListHandler)this.app.a(1)).a(this.f, this.h, this.jdField_g_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363369);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new wo(this));
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private boolean c()
  {
    Object localObject1 = getIntent();
    this.h = ((Intent)localObject1).getIntExtra("source_id", 10004);
    this.jdField_g_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("extra");
    if (!a(this.jdField_g_of_type_Int, this.f)) {
      return false;
    }
    localObject1 = ((Intent)localObject1).getStringExtra("nick_name");
    if ((this.h == 3004) && (localObject1 == null) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)))
    {
      localObject1 = this.app.a().createEntityManager();
      Object localObject2 = (TroopMemberInfo)((EntityManager)localObject1).a(TroopMemberInfo.class, new String[] { this.jdField_g_of_type_JavaLangString, this.f });
      if (localObject2 != null)
      {
        localObject2 = ((TroopMemberInfo)localObject2).friendnick;
        getIntent().putExtra("nick_name", (String)localObject2);
      }
      ((EntityManager)localObject1).a();
    }
    this.jdField_a_of_type_Wv = new wv(this, null);
    addObserver(this.jdField_a_of_type_Wv);
    if (this.jdField_g_of_type_Int == 1) {
      ((FriendListHandler)this.app.a(1)).a("OidbSvc.0x476_147", Long.parseLong(this.f), 147);
    }
    for (;;)
    {
      return true;
      if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        d();
      } else {
        c();
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    OpenID localOpenID;
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      localOpenID = this.app.a().a(this.jdField_g_of_type_JavaLangString);
      if ((localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363369);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new wp(this), 3000L);
        this.app.a(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
        this.app.a().e(this.jdField_g_of_type_JavaLangString);
      }
    }
    else
    {
      return;
    }
    if (!jdField_b_of_type_JavaLangString.equals(localOpenID.openID))
    {
      a();
      return;
    }
    c();
  }
  
  private boolean d()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    int j = ((Intent)localObject).getShortExtra("group_option", (short)2);
    if (((FriendManager)this.app.getManager(8)).a(str) != null)
    {
      QQToast.a(this.app.getApplication(), 2131363367, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    if (j == 3)
    {
      localObject = getIntent().getStringExtra("nick_name");
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        getString(2131362806);
      }
      QQToast.a(this.app.getApplication(), 2131363368, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    localObject = new Intent(this, AddFriendVerifyActivity.class);
    ((Intent)localObject).putExtras(getIntent());
    ((Intent)localObject).putExtra("friend_setting", 9);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      ((Intent)localObject).putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity((Intent)localObject);
      finish();
      return false;
    }
    startActivityForResult((Intent)localObject, 1);
    return true;
  }
  
  private void e()
  {
    String str2;
    Object localObject2;
    String str3;
    String str1;
    int j;
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.i != 0))
    {
      str2 = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.i);
      localObject2 = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.i);
      str3 = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.i);
      str1 = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.i);
      if (str2 != null) {
        break label398;
      }
      if (this.i != 1) {
        break label263;
      }
      j = 2131362778;
      str2 = getString(j);
    }
    label263:
    label398:
    for (;;)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (this.i == 1) {
          localObject1 = getString(2131362780);
        }
      }
      else
      {
        label145:
        if (str3 != null) {
          break label342;
        }
        if (this.i != 1) {
          break label330;
        }
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
        localObject2 = str3;
        label167:
        if (str1 != null) {
          break label380;
        }
        if (this.i != 1) {
          break label369;
        }
        str1 = getString(2131362784);
      }
      for (;;)
      {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(str2);
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject1);
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject2, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(str1, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
        if ((this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) || (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131296926).setVisibility(8);
        }
        return;
        j = 2131362779;
        break;
        if (this.i == 2)
        {
          localObject1 = getString(2131362781);
          break label145;
        }
        if (this.i == 3)
        {
          localObject1 = getString(2131362782);
          break label145;
        }
        localObject1 = localObject2;
        if (this.i != 4) {
          break label145;
        }
        localObject1 = getString(2131362783);
        break label145;
        label330:
        localObject2 = getString(2131362785);
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
        str1 = getString(2131362786);
        continue;
        label380:
        if (TextUtils.isEmpty(str1.trim())) {
          this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = null;
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131362444);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131362487);
    wt localwt = new wt(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131362794, localwt);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131362445, localwt);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList paramArrayList, Class paramClass)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtras(getIntent());
    paramClass.putExtra("param_mode", 0);
    paramClass.putExtra("friend_setting", paramInt);
    paramClass.putExtra("contact_bothway", paramBoolean);
    paramClass.putExtra("user_question", paramArrayList);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(paramClass);
      finish();
      return;
    }
    startActivityForResult(paramClass, 1);
  }
  
  protected String b_()
  {
    if (this.e != null) {
      return this.e;
    }
    return super.b_();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("k_uin_type", 0);
    this.f = paramBundle.getStringExtra("uin");
    this.e = paramBundle.getStringExtra("last_activity");
    if ((this.f == null) || (this.f.length() < 5)) {
      return false;
    }
    if (this.jdField_g_of_type_Int == 4) {
      return d();
    }
    return c();
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_Wv != null) {
      removeObserver(this.jdField_a_of_type_Wv);
    }
    if (this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    }
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(paramInt2, paramIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity
 * JD-Core Version:    0.7.0.1
 */