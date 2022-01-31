package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class VideoMsgTools
{
  static final String a = "VideoMsgTools";
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString.contains(paramContext.getString(2131560131))) {
      return 2131362115;
    }
    if (paramBoolean) {
      return 2131362080;
    }
    return 2131362077;
  }
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 13) {
      if (!paramBoolean2) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return 2130838216;
                return 2130838215;
                if (!paramString.contains(paramContext.getString(2131560132))) {
                  break;
                }
                if (paramBoolean1)
                {
                  if (paramBoolean2) {
                    return 2130838296;
                  }
                  return 2130838295;
                }
              } while (paramBoolean2);
              return 2130838215;
              if (!paramString.contains(paramContext.getString(2131560133))) {
                break;
              }
              if (paramBoolean1)
              {
                if (paramBoolean2) {
                  return 2130838296;
                }
                return 2130838295;
              }
            } while (paramBoolean2);
            return 2130838215;
            if (paramString.contains(paramContext.getString(2131560131)))
            {
              if (paramBoolean1) {
                return 2130838294;
              }
              return 2130838214;
            }
            if (!paramString.contains(paramContext.getString(2131560135))) {
              break;
            }
            if (paramBoolean1)
            {
              if (paramBoolean2) {
                return 2130838296;
              }
              return 2130838295;
            }
          } while (paramBoolean2);
          return 2130838215;
          if (!paramString.contains(paramContext.getString(2131560130))) {
            break;
          }
          if (paramBoolean1)
          {
            if (paramBoolean2) {
              return 2130838296;
            }
            return 2130838295;
          }
        } while (paramBoolean2);
        return 2130838215;
        if (!paramString.contains(paramContext.getString(2131560134))) {
          break;
        }
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130838296;
          }
          return 2130838295;
        }
      } while (paramBoolean2);
      return 2130838215;
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          return 2130838296;
        }
        return 2130838295;
      }
    } while (paramBoolean2);
    return 2130838215;
  }
  
  public static String a(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
    case 48: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131560132);
        return paramContext + " " + paramString;
      }
      return paramContext.getString(2131560133);
    case 2: 
    case 47: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131560132);
        return paramContext + " " + paramString;
      }
      if (paramBoolean) {
        return paramContext.getString(2131560133);
      }
      return paramContext.getString(2131560131);
    case 1: 
      return paramContext.getString(2131560131);
    case 3: 
      return paramContext.getString(2131560135);
    case 10: 
      return paramContext.getString(2131560131);
    case 7: 
      return paramContext.getString(2131560130);
    case 12: 
      if (paramBoolean) {
        return paramContext.getString(2131560133);
      }
      return paramContext.getString(2131560131);
    }
    return paramContext.getString(2131560133);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addTipsMultiVideoMsg msgType = " + paramInt2 + ", discussionUin = " + paramString1 + ", memberUin = " + paramString2);
    }
    String str = paramQQAppInterface.a();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null) {
      switch (paramInt2)
      {
      default: 
        paramQQAppInterface = paramQQAppInterface.a().getString(2131560202);
      }
    }
    for (;;)
    {
      paramString2 = MessageRecordFactory.a(-4008);
      paramString2.selfuin = str;
      paramString2.frienduin = paramString1;
      paramString2.senderuin = str;
      paramString2.msg = paramQQAppInterface;
      paramString2.msgtype = -4008;
      paramString2.isread = true;
      paramString2.issend = 1;
      paramString2.istroop = 3000;
      paramString2.extraflag = 3;
      paramString2.time = MessageCache.a();
      localQQMessageFacade.a(paramString2, str);
      return;
      if (str.equals(paramString2))
      {
        paramQQAppInterface = paramQQAppInterface.a().getString(2131560200);
      }
      else
      {
        paramString2 = ((FriendManager)paramQQAppInterface.getManager(8)).d(paramString1, paramString2);
        paramQQAppInterface = paramString2 + paramQQAppInterface.a().getString(2131560201);
        continue;
        paramQQAppInterface = paramQQAppInterface.a().getString(2131560202);
        continue;
        paramQQAppInterface = paramQQAppInterface.a().getString(2131560203);
        continue;
        paramQQAppInterface = paramQQAppInterface.a().getString(2131560204);
        continue;
        paramQQAppInterface = paramQQAppInterface.a().getString(2131560205);
        continue;
        paramQQAppInterface = paramQQAppInterface.a().getString(2131560207);
        continue;
        paramQQAppInterface = paramQQAppInterface.a().getString(2131560206);
        continue;
        paramQQAppInterface = paramQQAppInterface.a().getString(2131560136) + paramString3;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addTipsVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1);
    }
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null) {
      switch (paramInt2)
      {
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 26: 
      case 27: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 36: 
      case 37: 
      case 38: 
      case 42: 
      case 43: 
      case 44: 
      default: 
        paramString2 = paramQQAppInterface.a().getString(2131560254);
      }
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a();
      paramString2 = TransfileUtile.a(paramString2, 0L, 3, paramBoolean);
      MessageRecord localMessageRecord = MessageRecordFactory.a(-1001);
      localMessageRecord.selfuin = paramQQAppInterface;
      localMessageRecord.frienduin = paramString1;
      localMessageRecord.senderuin = paramQQAppInterface;
      localMessageRecord.msg = paramString2;
      localMessageRecord.msgtype = -1001;
      localMessageRecord.isread = true;
      localMessageRecord.issend = 0;
      localMessageRecord.istroop = paramInt1;
      localMessageRecord.extraflag = 3;
      localMessageRecord.time = MessageCache.a();
      localQQMessageFacade.a(localMessageRecord, paramQQAppInterface);
      return;
      paramString2 = paramQQAppInterface.a().getString(2131560062);
      continue;
      paramString2 = paramQQAppInterface.a().getString(2131560065);
      continue;
      paramString2 = paramQQAppInterface.a().getString(2131560063);
      continue;
      paramString2 = paramQQAppInterface.a().getString(2131560064);
      continue;
      paramString2 = paramQQAppInterface.a().getString(2131560066);
      continue;
      paramString2 = paramQQAppInterface.a().getString(2131560067);
      continue;
      paramString2 = paramQQAppInterface.a().getString(2131560069);
      continue;
      paramString2 = paramQQAppInterface.a().getString(2131560068);
      continue;
      paramString2 = paramQQAppInterface.a().getString(2131560120);
      continue;
      if (paramBoolean)
      {
        paramString2 = paramQQAppInterface.a().getString(2131560070);
      }
      else
      {
        paramString2 = paramQQAppInterface.a().getString(2131560071);
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560072);
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560073);
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560095);
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560096);
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560097);
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560099);
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560098);
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560240);
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560136) + paramString2;
        continue;
        paramString2 = paramQQAppInterface.a().getString(2131560254);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addBubbleVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", time = " + paramString3);
    }
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    String str1;
    MessageRecord localMessageRecord;
    if (localQQMessageFacade != null)
    {
      str1 = paramQQAppInterface.a();
      paramString3 = a(paramQQAppInterface.a(), paramInt2, paramBoolean2, paramString3);
      String str2 = TransfileUtile.a(paramString3, paramInt2, 3, paramBoolean1);
      localMessageRecord = MessageRecordFactory.a(-2009);
      localMessageRecord.selfuin = str1;
      localMessageRecord.frienduin = paramString1;
      localMessageRecord.senderuin = paramString2;
      localMessageRecord.msg = str2;
      localMessageRecord.msgtype = -2009;
      if ((paramBoolean2) || (paramString1.equals(localQQMessageFacade.a())) || (paramInt2 == 1) || (!paramString3.contains(paramQQAppInterface.a().getString(2131560131)))) {
        break label288;
      }
      localMessageRecord.isread = false;
      if (!paramBoolean2) {
        break label297;
      }
      localMessageRecord.issend = 1;
      label223:
      localMessageRecord.istroop = paramInt1;
      localMessageRecord.extraflag = 3;
      localMessageRecord.time = MessageCache.a();
      if (!QQUtils.a(paramQQAppInterface.a())) {
        break label306;
      }
      paramQQAppInterface.a().b(localMessageRecord);
    }
    for (;;)
    {
      if ((paramInt2 != 47) && (paramInt2 != 48)) {
        QQUtils.a(paramQQAppInterface, localMessageRecord, new Handler());
      }
      return;
      label288:
      localMessageRecord.isread = true;
      break;
      label297:
      localMessageRecord.issend = 0;
      break label223;
      label306:
      localQQMessageFacade.a(localMessageRecord, str1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", isVideoMsg = " + paramBoolean1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", extra = " + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
      }
      return;
    }
    if (paramInt1 == 1000)
    {
      FriendManager localFriendManager = (FriendManager)paramQQAppInterface.getManager(8);
      if ((localFriendManager != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString2 = localFriendManager.a(paramString2);
        if (paramString2 != null) {
          paramString2 = paramString2.troopcode;
        }
      }
    }
    for (;;)
    {
      if (a(paramInt2))
      {
        if (b(paramInt2))
        {
          a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramBoolean2, paramBoolean3);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoMsgTools", 2, "can't find troop info!");
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoMsgTools", 2, "can't get friend manager!");
          return;
        }
        a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3);
        return;
      }
      if (b(paramInt2))
      {
        a(paramQQAppInterface, paramInt1, paramInt2, paramString1, paramString2, paramString3);
        return;
      }
      a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString3);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMultiVideoMsg discussionUin = " + paramString1 + ", senderUin = " + paramString2);
    }
    String str = paramQQAppInterface.a();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    MessageRecord localMessageRecord;
    if (localQQMessageFacade != null)
    {
      paramQQAppInterface = TransfileUtile.a(paramQQAppInterface.a().getString(2131560201), 13L, 3, true);
      localMessageRecord = MessageRecordFactory.a(-2016);
      localMessageRecord.selfuin = str;
      localMessageRecord.frienduin = paramString1;
      localMessageRecord.senderuin = paramString2;
      localMessageRecord.msg = paramQQAppInterface;
      localMessageRecord.msgtype = -2016;
      localMessageRecord.isread = paramBoolean2;
      if (!paramBoolean1) {
        break label167;
      }
    }
    label167:
    for (localMessageRecord.issend = 1;; localMessageRecord.issend = 0)
    {
      localMessageRecord.istroop = 3000;
      localMessageRecord.extraflag = 3;
      localMessageRecord.time = MessageCache.a();
      localQQMessageFacade.a(localMessageRecord, str);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    switch (paramInt)
    {
    case 1006: 
    default: 
      return;
    }
    paramQQAppInterface.j(paramString1, paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addDiscussMember discussUin = " + paramString);
    }
    Object localObject = ((FriendManager)paramQQAppInterface.getManager(8)).a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      int j = ((ArrayList)localObject).size();
      int i = 0;
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((ArrayList)localObject).get(i);
        if (localDiscussionMemberInfo != null) {
          localArrayList.add(localDiscussionMemberInfo.memberUin);
        }
        i += 1;
      }
    }
    localObject = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    ((Intent)localObject).putStringArrayListExtra("param_uins_selected_default", localArrayList);
    ((Intent)localObject).putExtra("param_groupcode", paramString);
    ((Intent)localObject).putExtra("param_type", 3000);
    ((Intent)localObject).putExtra("param_subtype", 1);
    ((Intent)localObject).putExtra("param_max", 50 - localArrayList.size());
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("sendToVideo", true);
    ((Intent)localObject).putExtra("ShowJoinDiscTips", true);
    paramQQAppInterface.getApplication().startActivity((Intent)localObject);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 7) || (paramInt == 10) || (paramInt == 12) || (paramInt == 42) || (paramInt == 43) || (paramInt == 13) || (paramInt == 47) || (paramInt == 48);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (((DiscussionHandler)paramQQAppInterface.a(6)).a(paramString1)) {
      return true;
    }
    paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a(paramString1, paramString2) != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    byte[] arrayOfByte = null;
    Object localObject = paramQQAppInterface.a();
    paramQQAppInterface = arrayOfByte;
    switch (paramInt)
    {
    default: 
      paramQQAppInterface = arrayOfByte;
    case 1006: 
    case 1001: 
      do
      {
        return paramQQAppInterface;
        arrayOfByte = new byte[3];
        byte[] tmp60_58 = arrayOfByte;
        tmp60_58[0] = 1;
        byte[] tmp66_60 = tmp60_58;
        tmp66_60[1] = 1;
        byte[] tmp72_66 = tmp66_60;
        tmp72_66[2] = 124;
        tmp72_66;
        localObject = ((MessageCache)localObject).k(paramString);
        int i = arrayOfByte.length;
        paramInt = i;
        if (localObject != null) {
          paramInt = i + localObject.length;
        }
        paramString = new byte[paramInt];
        System.arraycopy(arrayOfByte, 0, paramString, 0, arrayOfByte.length);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      System.arraycopy(localObject, 0, paramString, arrayOfByte.length, localObject.length);
      return paramString;
    }
    return ((MessageCache)localObject).h(paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addDiscussMemberFromC2C uin = " + paramString);
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 50 - localArrayList.size() - 1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sendToVideo", true);
    localIntent.putExtra("ShowJoinDiscTips", false);
    paramQQAppInterface.getApplication().startActivity(localIntent);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 20) || (paramInt == 19) || (paramInt == 44);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools
 * JD-Core Version:    0.7.0.1
 */