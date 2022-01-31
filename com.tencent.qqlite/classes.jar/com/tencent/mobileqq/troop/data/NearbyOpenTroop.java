package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import enp;
import enq;
import enr;
import ens;
import ent;
import enu;

public class NearbyOpenTroop
{
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private static final int f = 1001;
  private static final int jdField_g_of_type_Int = 1002;
  private static final String jdField_g_of_type_JavaLangString = "NearbyOpenTroop";
  private static final int h = 1003;
  public int a;
  public GroupInfo a;
  protected Activity a;
  public Handler a;
  public Toast a;
  public BizTroopHandler a;
  public BizTroopObserver a;
  public MessageObserver a;
  public QQAppInterface a;
  public TroopObserver a;
  protected QQProgressDialog a;
  public String a;
  public boolean a;
  protected BizTroopObserver b;
  protected String b;
  public boolean b;
  protected String c;
  public boolean c;
  public String d = "";
  protected int e;
  public String e;
  public String f = "";
  
  public NearbyOpenTroop(String paramString1, String paramString2, Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_NearbyGroupGroupInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = null;
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new enp(this);
    this.jdField_b_of_type_ComTencentMobileqqAppBizTroopObserver = new enq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new enr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new enu(this);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_AndroidOsHandler = new ens(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_b_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      this.jdField_a_of_type_AndroidWidgetToast = null;
    }
    paramString1 = new QQToast(this.jdField_a_of_type_AndroidAppActivity);
    paramString1.c(3000);
    paramString1.a(paramString3);
    this.jdField_a_of_type_AndroidWidgetToast = paramString1.b(this.jdField_a_of_type_Int);
    a();
  }
  
  private void b()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1003;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void c()
  {
    if (!a().booleanValue()) {
      return;
    }
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17);
    if (localTroopHandler != null) {
      try
      {
        localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), 0L, 2, null, 0, 0);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyOpenTroop", 2, localException.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  Boolean a()
  {
    OpenTroopInfo localOpenTroopInfo = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_JavaLangString);
    if ((localOpenTroopInfo == null) || (localOpenTroopInfo.troopAdminList == null)) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public void a(GroupInfo paramGroupInfo, int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在进入公开群");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ent(this), 1000L);
    this.jdField_a_of_type_NearbyGroupGroupInfo = paramGroupInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    Object localObject;
    if (this.jdField_a_of_type_NearbyGroupGroupInfo != null)
    {
      FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      OpenTroopInfo localOpenTroopInfo = localFriendManager.a(this.jdField_a_of_type_JavaLangString);
      localObject = localOpenTroopInfo;
      if (localOpenTroopInfo == null) {
        localObject = new OpenTroopInfo();
      }
      ((OpenTroopInfo)localObject).troopCode = this.jdField_a_of_type_JavaLangString;
      ((OpenTroopInfo)localObject).troopUin = this.jdField_b_of_type_JavaLangString;
      ((OpenTroopInfo)localObject).troopName = this.jdField_c_of_type_JavaLangString;
      ((OpenTroopInfo)localObject).troopFace = this.jdField_a_of_type_NearbyGroupGroupInfo.iFaceId;
      ((OpenTroopInfo)localObject).troopIntro = this.jdField_a_of_type_NearbyGroupGroupInfo.strIntro;
      ((OpenTroopInfo)localObject).troopMemberNum = this.jdField_a_of_type_NearbyGroupGroupInfo.iMemberCnt;
      ((OpenTroopInfo)localObject).troopClass = 0;
      ((OpenTroopInfo)localObject).troopLocation = this.jdField_a_of_type_NearbyGroupGroupInfo.strLocation;
      localFriendManager.a((OpenTroopInfo)localObject, true);
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity))
    {
      localObject = new Intent(((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity(), ChatActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      ((Intent)localObject).putExtra("uinname", this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      c();
      if (!paramBoolean) {
        break label470;
      }
      if (this.jdField_e_of_type_Int != 1) {
        break label382;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Open_group", "in_open_group", 45, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
    }
    for (;;)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1002;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      ((Intent)localObject).putExtra("uinname", this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      break;
      label382:
      if (this.jdField_e_of_type_Int == 2) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Open_group", "in_open_group", 54, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      } else if (this.jdField_e_of_type_Int == 3) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Open_group", "in_open_group", 55, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    label470:
    a();
  }
  
  public void a(boolean paramBoolean, GroupInfo paramGroupInfo, String paramString)
  {
    if (paramGroupInfo != null) {
      this.jdField_a_of_type_NearbyGroupGroupInfo = paramGroupInfo;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NearbyOpenTroop
 * JD-Core Version:    0.7.0.1
 */