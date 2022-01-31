package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;

public class ShareMsgHelper
  implements AppConstants
{
  public static final int a = 1;
  public static final int b = 2;
  QQAppInterface a;
  
  public ShareMsgHelper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    String str = paramQQAppInterface.a();
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    paramString = MessageRecordFactory.a(paramQQAppInterface, str, paramString, str, paramInt, i, paramAbsStructMsg);
    paramQQAppInterface.a().b(paramString, paramQQAppInterface.a());
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramBusinessObserver = paramQQAppInterface.a();
        i = MobileQQService.c;
        MobileQQService.c = i + 1;
        paramString = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString, paramBusinessObserver, paramInt, i, paramAbsStructMsg);
        if (paramAbsStructMsg.mMsgServiceID == 41)
        {
          paramQQAppInterface.a().b(paramString, null);
          return;
        }
        paramQQAppInterface.a().a(paramString, null);
        return;
      } while (paramAbsStructMsg == null);
      if (paramAbsStructMsg.mMsgServiceID == 1)
      {
        paramBusinessObserver = paramQQAppInterface.a();
        i = MobileQQService.c;
        MobileQQService.c = i + 1;
        paramString = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString, paramBusinessObserver, paramInt, i, paramAbsStructMsg);
        paramQQAppInterface.a().a(paramString, null);
        return;
      }
    } while (paramAbsStructMsg.mMsgServiceID != 41);
    paramBusinessObserver = paramQQAppInterface.a();
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    paramString = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString, paramBusinessObserver, paramInt, i, paramAbsStructMsg);
    paramQQAppInterface.a().b(paramString, null);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, Intent paramIntent, int paramInt3)
  {
    return a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, "", paramIntent, paramInt3, null);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
  {
    return a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, "", null, -1, paramString18);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, Intent paramIntent, int paramInt3, String paramString19)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent("com.tencent.intent.QQLite_FORWARD");
    }
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", paramInt1);
    localIntent.putExtra("pluginName", paramString1);
    localIntent.putExtra("req_type", paramInt2);
    localIntent.putExtra("detail_url", paramString7);
    localIntent.putExtra("image_url_remote", paramString3);
    localIntent.putExtra("source_url", paramString19);
    localIntent.putExtra("pubUin", paramString2);
    paramString1 = paramString4;
    if (paramString4 != null)
    {
      paramString1 = paramString4;
      if (paramString4.length() > 45) {
        paramString1 = paramString4.substring(0, 45) + "…";
      }
    }
    localIntent.putExtra("title", paramString1);
    paramString1 = paramString5;
    if (paramString5 != null)
    {
      paramString1 = paramString5;
      if (paramString5.length() > 60) {
        paramString1 = paramString5.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("forward_thumb", paramString18);
    localIntent.putExtra("struct_share_key_content_action", paramString8);
    localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString10);
    localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    localIntent.putExtra("struct_share_key_content_action_DATA", paramString9);
    localIntent.putExtra("req_share_id", -1L);
    localIntent.putExtra("struct_share_key_source_action", paramString12);
    localIntent.putExtra("struct_share_key_source_action_data", paramString13);
    localIntent.putExtra("struct_share_key_source_a_action_data", paramString14);
    localIntent.putExtra("struct_share_key_source_i_action_data", paramString15);
    localIntent.putExtra("struct_share_key_source_icon", paramString16);
    localIntent.putExtra("app_name", paramString17);
    localIntent.putExtra("brief_key", paramString6);
    paramString1 = StructMsgFactory.a(localIntent.getExtras());
    if (paramString1 != null)
    {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
      if ((paramInt3 >= 0) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt3);
      }
      for (;;)
      {
        return true;
        paramContext.startActivity(localIntent);
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, 1);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QQLite_FORWARD");
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("category", paramContext.getString(2131362441));
    localIntent.putExtra("detail_url", paramString5);
    localIntent.putExtra("image_url_remote", paramString4);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("desc", paramString3);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pluginName", "public_account");
    paramString3 = "";
    paramString4 = "";
    switch (paramInt)
    {
    default: 
      paramString1 = paramString4;
    }
    for (;;)
    {
      localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString3);
      localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString1);
      localIntent.putExtra("struct_share_key_content_action_DATA", paramString3);
      localIntent.putExtra("req_share_id", -1);
      localIntent.putExtra("isFromShare", true);
      localIntent.putExtra("struct_share_key_source_action", " ");
      localIntent.putExtra("app_name", paramContext.getString(2131362442));
      localIntent.putExtra("brief_key", String.format(paramContext.getString(2131362444), new Object[] { paramString6, paramString2 }));
      localIntent.putExtra("compatible_text", "分享名片");
      paramString1 = StructMsgFactory.a(localIntent.getExtras());
      if (paramString1 == null) {
        break;
      }
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
      paramContext.startActivity(localIntent);
      return true;
      paramString3 = "mqqapi://app/action?pkg=com.tencent.qqlite&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
      paramString1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramString1 + "&version=1";
      localIntent.putExtra("req_type", 1);
      continue;
      paramString3 = "mqqapi://app/action?pkg=com.tencent.qqlite&cmp=com.tencent.biz.eqq.EnterpriseDetailActivity&uin=" + paramString1;
      paramString1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1";
      localIntent.putExtra("req_type", 40);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareMsgHelper
 * JD-Core Version:    0.7.0.1
 */