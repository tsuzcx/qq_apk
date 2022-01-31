package com.tencent.mobileqq.structmsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

public class StructMsgForGeneralShare$GeneralClickHandler
  extends StructMsgClickHandler
{
  StructingMsgItemBuilder.StructingMsgViewHolder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder;
  StructMsgForGeneralShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
  
  public StructMsgForGeneralShare$GeneralClickHandler(View paramView)
  {
    super(paramView);
  }
  
  public StructMsgForGeneralShare$GeneralClickHandler(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramQQAppInterface, paramView);
  }
  
  public StructMsgForGeneralShare$GeneralClickHandler(QQAppInterface paramQQAppInterface, View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    super(paramQQAppInterface, paramView);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare = paramStructMsgForGeneralShare;
    paramQQAppInterface = paramView.getTag();
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructingMsgItemBuilder.StructingMsgViewHolder))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder = ((StructingMsgItemBuilder.StructingMsgViewHolder)paramQQAppInterface);
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "GeneralClickHandler clickWebMsg url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    StructMsgForGeneralShare localStructMsgForGeneralShare = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
    StructingMsgItemBuilder.StructingMsgViewHolder localStructingMsgViewHolder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder;
    paramString = paramString.trim();
    boolean bool = paramString.startsWith("http://gamecenter.qq.com");
    long l = AppShareIDUtil.a(localStructMsgForGeneralShare.mSourceAppid);
    Object localObject3 = ((QQAppInterface)localObject1).getSid();
    String str = ((QQAppInterface)localObject1).a();
    Object localObject2 = ((QQAppInterface)localObject1).c();
    if ((55901189L == l) || (274201605L == l) || (440495416L == l))
    {
      localObject1 = QZoneHelper.UserInfo.a();
      ((QZoneHelper.UserInfo)localObject1).a = str;
      ((QZoneHelper.UserInfo)localObject1).b = ((String)localObject2);
      ((QZoneHelper.UserInfo)localObject1).c = ((String)localObject3);
      QZoneHelper.a((Activity)localContext, (QZoneHelper.UserInfo)localObject1, paramString, "mqqChat", -1);
    }
    for (;;)
    {
      return true;
      if ((2274034950L == l) || (2223703302L == l))
      {
        localObject1 = QZoneHelper.UserInfo.a();
        ((QZoneHelper.UserInfo)localObject1).a = str;
        ((QZoneHelper.UserInfo)localObject1).b = ((String)localObject2);
        ((QZoneHelper.UserInfo)localObject1).c = ((String)localObject3);
        QZoneHelper.a((Activity)localContext, (QZoneHelper.UserInfo)localObject1, paramString, -1, "mqqChat");
      }
      else
      {
        int i;
        label257:
        label267:
        StringBuilder localStringBuilder;
        if ((paramString.startsWith("http://m.qzone.com")) || (paramString.startsWith("http://mobile.qzone.qq.com")))
        {
          i = 1;
          if ((!bool) && (i == 0)) {
            break label693;
          }
          i = 1;
          localObject2 = new Intent(localContext, QQBrowserDelegationActivity.class);
          localStringBuilder = new StringBuilder(paramString);
          if (paramString.indexOf("?") <= 0) {
            break label698;
          }
          paramString = "";
          label302:
          localStringBuilder = localStringBuilder.append(paramString).append("&from=androidqq");
          if (i == 0) {
            break label704;
          }
        }
        label693:
        label698:
        label704:
        for (paramString = "&sid=" + (String)localObject3;; paramString = "")
        {
          paramString = localStringBuilder.append(paramString);
          ((Intent)localObject2).putExtra("param_force_internal_browser", true);
          if (bool) {
            paramString.append("&platformId=qq_m");
          }
          paramString = paramString.toString().trim();
          ((Intent)localObject2).putExtra("injectrecommend", false);
          ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
          ((Intent)localObject2).putExtra("url", paramString);
          ((Intent)localObject2).putExtra("uin", localStructMsgForGeneralShare.currentAccountUin);
          ((Intent)localObject2).putExtra("friendUin", localStructMsgForGeneralShare.uin);
          ((Intent)localObject2).putExtra("isAppShare", true);
          ((Intent)localObject2).putExtra("appShareID", l);
          if (paramString.startsWith("http://browserApp.p.qq.com/"))
          {
            ((Intent)localObject2).setClass(localContext, PublicAccountBrowser.class);
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("uin", localStructMsgForGeneralShare.uin);
            ((Bundle)localObject3).putInt("uin_type", localStructingMsgViewHolder.a.a);
            ((Bundle)localObject3).putString("uin_name", localStructingMsgViewHolder.a.d);
            ((Bundle)localObject3).putString("openid", null);
            ((Bundle)localObject3).putString("token", null);
            ((Intent)localObject2).putExtras((Bundle)localObject3);
          }
          if (localStructMsgForGeneralShare.mSourceAppid == 1101244924L)
          {
            ((Intent)localObject2).putExtra("BUDNLE_KEY_IS_MY_PROFILE", paramString.contains("gene/index.html?uin=" + localStructMsgForGeneralShare.currentAccountUin));
            ((Intent)localObject2).setClass(localContext, MusicGeneQQBrowserActivity.class);
          }
          PublicAccountUtil.a((Intent)localObject2, paramString);
          ((Intent)localObject2).putExtra("fromAio", true);
          localContext.startActivity((Intent)localObject2);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString, "", "", "");
          if (!bool) {
            break label710;
          }
          StatisticCollector.a(BaseApplication.getContext()).a((AppRuntime)localObject1, str, "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(localStructMsgForGeneralShare.mSourceAppid), null, null, null);
          break;
          i = 0;
          break label257;
          i = 0;
          break label267;
          paramString = "?";
          break label302;
        }
        label710:
        StatisticCollector.a(BaseApplication.getContext()).a((AppRuntime)localObject1, "sha_click", 1, "", "", String.valueOf(localStructMsgForGeneralShare.mSourceAppid));
      }
    }
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = (ChatActivity)this.jdField_a_of_type_AndroidContentContext;
    int i = paramString3.a().a();
    paramString2 = paramString3.a().b();
    paramString3 = paramString3.a().a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString3);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("video_play_url", paramString1);
    localIntent.putExtra("video_play_msg", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uniseq);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "GeneralClickHandler clickPluginMsg actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString1 = JumpParser.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
      if (paramString1 == null) {
        break;
      }
      return paramString1.b();
      paramString1 = paramString2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "GeneralShareMsg _ACTION_PLUGIN_ mContentOnClickListener: JumpAction is null.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler
 * JD-Core Version:    0.7.0.1
 */