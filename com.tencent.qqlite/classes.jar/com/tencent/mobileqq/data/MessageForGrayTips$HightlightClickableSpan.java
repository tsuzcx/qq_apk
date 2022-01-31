package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import dck;

public class MessageForGrayTips$HightlightClickableSpan
  extends ClickableSpan
  implements MessageForGrayTips.HightlightClickInterface
{
  protected static final int PACKAGE_NAME_INDEX = 0;
  protected static final int URL_DATA_INDEX = 1;
  int color = -1;
  private Context context;
  private dck item;
  private QQAppInterface mApp;
  
  public MessageForGrayTips$HightlightClickableSpan(MessageForGrayTips paramMessageForGrayTips, QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, dck paramdck)
  {
    this.mApp = paramQQAppInterface;
    this.context = paramContext;
    this.color = paramInt;
    this.item = paramdck;
  }
  
  public MessageForGrayTips$HightlightClickableSpan(MessageForGrayTips paramMessageForGrayTips, QQAppInterface paramQQAppInterface, Context paramContext, dck paramdck)
  {
    this(paramMessageForGrayTips, paramQQAppInterface, -1, paramContext, paramdck);
  }
  
  public boolean clickAppMsg(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("HightlightClickableSpan", 2, " clickAppMsg actionData = " + paramString1 + "actionDataA" + paramString2);
    }
    paramString2 = parsePackageNameAndData(paramString1, paramString2);
    Object localObject = this.context.getPackageManager();
    try
    {
      if (((PackageManager)localObject).getPackageInfo(paramString2[0], 1) != null)
      {
        localObject = ((PackageManager)localObject).getLaunchIntentForPackage(paramString2[0]);
        if (!TextUtils.isEmpty(paramString2[1])) {
          ((Intent)localObject).setData(Uri.parse(paramString2[1]));
        }
      }
      try
      {
        ((StartAppCheckHandler)this.mApp.a(20)).b(paramString2[0].trim(), this.context, (Intent)localObject);
        bool = true;
        return bool;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
          }
          this.context.startActivity((Intent)localObject);
        }
      }
      return clickWebMsg(paramString1);
    }
    catch (PackageManager.NameNotFoundException paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(MessageForGrayTips.access$000(), 2, paramString2.getMessage());
      }
    }
  }
  
  public boolean clickPluginMsg(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HightlightClickableSpan", 2, "HightlightClickableSpan clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {}
    try
    {
      for (;;)
      {
        JumpParser.a(this.mApp, this.context, paramString1).b();
        return true;
        paramString1 = paramString2;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HightlightClickableSpan", 2, paramString1.getMessage(), paramString1);
        }
      }
    }
  }
  
  public boolean clickWebMsg(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("fromAio", true);
    PublicAccountUtil.a(localIntent, paramString);
    this.context.startActivity(localIntent);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (this.item == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(MessageForGrayTips.access$000(), 2, "onClick==>item actionType:" + this.item.c);
    }
    switch (this.item.c)
    {
    default: 
      return;
    case 1: 
      clickWebMsg(this.item.jdField_a_of_type_JavaLangString);
      return;
    case 3: 
      clickPluginMsg(this.item.jdField_a_of_type_JavaLangString, this.item.b);
      return;
    case 2: 
      clickAppMsg(this.item.jdField_a_of_type_JavaLangString, this.item.b);
      return;
    case 4: 
      if (((TroopManager)this.mApp.getManager(44)).a(this.this$0.frienduin) != null) {
        break;
      }
    }
    for (int i = 2;; i = 1)
    {
      paramView = TroopInfoActivity.a(this.this$0.frienduin, 4);
      ChatSettingForTroop.a(this.context, paramView, i);
      return;
      if (this.context == null) {
        break;
      }
      paramView = new Intent(this.context, TroopMemberCardActivity.class);
      paramView.putExtra("troopUin", this.this$0.frienduin);
      paramView.putExtra("memberUin", "" + this.item.jdField_a_of_type_Long);
      paramView.putExtra("fromFlag", 4);
      this.context.startActivity(paramView);
      return;
    }
  }
  
  protected final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label52;
      }
    }
    label52:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label63;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label63:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.color == -1) {
      paramTextPaint.setColor(paramTextPaint.linkColor);
    }
    for (;;)
    {
      paramTextPaint.setUnderlineText(false);
      return;
      paramTextPaint.setColor(this.color);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */