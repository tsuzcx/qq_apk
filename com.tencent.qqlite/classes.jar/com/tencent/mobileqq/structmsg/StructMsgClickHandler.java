package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import efc;

public class StructMsgClickHandler
  implements StructMsgOnClickListener
{
  private static ActionSheet a;
  protected Context a;
  protected QQAppInterface a;
  
  public StructMsgClickHandler(View paramView)
  {
    this(null, paramView);
  }
  
  public StructMsgClickHandler(QQAppInterface paramQQAppInterface, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    if ((paramQQAppInterface == null) && (ChatActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).a().a();
    }
  }
  
  private static void a(Context paramContext, String paramString)
  {
    if ((jdField_a_of_type_ComTencentWidgetActionSheet == null) || (!jdField_a_of_type_ComTencentWidgetActionSheet.getContext().equals(paramContext)))
    {
      jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(paramContext, 2131624119);
      jdField_a_of_type_ComTencentWidgetActionSheet.a(2131363563, 1);
      jdField_a_of_type_ComTencentWidgetActionSheet.a(2131363564, 1);
      jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362794);
      jdField_a_of_type_ComTencentWidgetActionSheet.a(String.format(paramContext.getString(2131363579), new Object[] { paramString }));
      jdField_a_of_type_ComTencentWidgetActionSheet.a(new efc(paramString, paramContext));
    }
    if (!jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    PublicAccountUtil.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      Object localObject = (ChatActivity)this.jdField_a_of_type_AndroidContentContext;
      int i = ((ChatActivity)localObject).a().a();
      paramString2 = ((ChatActivity)localObject).a().b();
      localObject = ((ChatActivity)localObject).a().a();
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      localIntent.putExtra("uin", (String)localObject);
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("forward_type", -1);
      localIntent.putExtra("forward_text", paramString1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      paramString1 = paramString2;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    int i;
    Object localObject;
    if (TextUtils.isEmpty(paramString3))
    {
      i = paramString2.indexOf("://");
      localObject = "";
      if (i != -1) {
        break label87;
      }
      paramString3 = paramString2;
    }
    for (paramString2 = (String)localObject;; paramString2 = paramString2.substring(i + 3))
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
      try
      {
        if (((PackageManager)localObject).getPackageInfo(paramString3, 1) == null) {
          break label124;
        }
        paramString3 = ((PackageManager)localObject).getLaunchIntentForPackage(paramString3);
        if (!TextUtils.isEmpty(paramString2)) {
          paramString3.setData(Uri.parse(paramString2));
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramString3);
        return true;
      }
      catch (PackageManager.NameNotFoundException paramString2)
      {
        if (!QLog.isColorLevel()) {
          break label124;
        }
        QLog.d("StructMsg", 2, paramString2.getMessage());
        if (TextUtils.isEmpty(paramString1)) {
          break label208;
        }
        paramString2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramString2.putExtra("key_isReadModeEnabled", true);
        paramString2.putExtra("url", paramString1);
        paramString2.putExtra("fromAio", true);
        PublicAccountUtil.a(paramString2, paramString1);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
        return true;
      }
      paramString2 = paramString3;
      break;
      label87:
      paramString3 = paramString2.substring(0, i);
    }
    label124:
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructMsgClickHandler doAction action = " + paramString1 + ", url = " + paramString2 + ", actionData = " + paramString3 + ", actionDataA = " + paramString4);
    }
    if ("web".equals(paramString1)) {
      bool = a(paramString2);
    }
    do
    {
      return bool;
      if ("app".equals(paramString1)) {
        return a(paramString2, paramString3, paramString4);
      }
      if ("plugin".equals(paramString1)) {
        return c(paramString3, paramString4);
      }
      if ("auto".equals(paramString1)) {
        return b(paramString2);
      }
      if ("replyMsg".equals(paramString1)) {
        return a(paramString3, paramString4);
      }
      if ("replyCmd".equals(paramString1)) {
        return b(paramString3, paramString4);
      }
    } while (!"playVideo".equals(paramString1));
    return b(paramString2, paramString3, paramString4);
  }
  
  public boolean b(String paramString)
  {
    if (paramString.startsWith("tel:"))
    {
      paramString = paramString.substring("tel:".length());
      a(this.jdField_a_of_type_AndroidContentContext, paramString);
    }
    for (;;)
    {
      return true;
      try
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("com.android.browser.application_id", this.jdField_a_of_type_AndroidContentContext.getPackageName());
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      }
      catch (Exception paramString) {}
      if (QLog.isColorLevel()) {
        QLog.d("HyperTextMsg", 2, paramString.getMessage());
      }
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString2 = ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).a().a();
      PublicAccountManager.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, null);
      return true;
      paramString1 = paramString2;
    }
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3)
  {
    return true;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructMsgClickHandler clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      try
      {
        paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
        if (paramString1 != null) {
          paramString1.b();
        }
      }
      catch (Exception paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, paramString1.getMessage(), paramString1);
        continue;
      }
      return true;
      paramString1 = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgClickHandler
 * JD-Core Version:    0.7.0.1
 */