package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.List;

public class RecentItemChatMsgData
  extends RecentUserBaseData
{
  public RecentItemChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private boolean a(FriendManager paramFriendManager, String paramString)
  {
    if ((paramFriendManager == null) || (TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramFriendManager = paramFriendManager.a(paramString);
      } while ((paramFriendManager == null) || (!paramFriendManager.isFriend()));
      bool1 = paramFriendManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramFriendManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    String str = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null) {}
    for (QQMessageFacade.Message localMessage = localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localMessage = null)
    {
      Object localObject5 = paramQQAppInterface.a();
      if ((localObject5 != null) && (localMessage != null)) {}
      MsgSummary localMsgSummary;
      for (this.A = ((ConversationFacade)localObject5).a(localMessage.frienduin, localMessage.istroop);; this.A = 0)
      {
        localMsgSummary = a();
        switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)
        {
        default: 
          localObject1 = str;
          a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          a(paramQQAppInterface, paramContext, localMsgSummary);
          this.c = ((String)localObject1);
          return;
        }
      }
      if (localMessage != null)
      {
        if (localMessage.msgtype != -3006) {
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        }
      }
      else
      {
        label310:
        localObject3 = (PublicAccountDataManager)paramQQAppInterface.getManager(51);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((PublicAccountDataManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        }
        if (localObject1 == null) {
          break label615;
        }
        this.jdField_a_of_type_JavaLangString = ((PublicAccountInfo)localObject1).name;
        if (((PublicAccountInfo)localObject1).certifiedGrade <= 0L) {
          break label607;
        }
        this.B = 2130838179;
        label369:
        if ((localMessage == null) || (localMessage.getMessageText() == null)) {
          break label623;
        }
        this.jdField_a_of_type_Long = localMessage.time;
        label391:
        localObject2 = paramContext.getString(2131559005);
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label631;
        }
      }
      label607:
      label615:
      label623:
      label631:
      for (localObject1 = this.jdField_a_of_type_JavaLangString;; localObject1 = "")
      {
        localObject1 = String.format((String)localObject2, new Object[] { localObject1, Integer.valueOf(this.A) });
        break;
        localMsgSummary.b = "";
        localObject3 = XMLMessageUtils.a(localMessage);
        if ((localObject3 == null) || (((PAMessage)localObject3).items == null) || (((PAMessage)localObject3).items.size() == 0))
        {
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          break label310;
        }
        localObject1 = ((PAMessage.Item)((PAMessage)localObject3).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject3).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList != null)) {
          localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList.get(0);
        }
        for (;;)
        {
          localMsgSummary.b = ((CharSequence)localObject1);
          break;
        }
        this.B = 0;
        break label369;
        this.B = 0;
        break label369;
        this.jdField_a_of_type_Long = 0L;
        break label391;
      }
      localObject2 = ContactUtils.d(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      localObject3 = (PhoneContactManager)paramQQAppInterface.getManager(10);
      if (localObject3 != null) {
        localObject1 = ((PhoneContactManager)localObject3).f(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).name;
        label693:
        a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        if ((localMessage == null) || ((localMessage.getMessageText() == null) && ((localMessage.msgtype != -2011) || (localMessage.msgData == null)))) {
          break label831;
        }
        this.jdField_a_of_type_Long = localMessage.time;
        label751:
        localObject2 = paramContext.getString(2131559005);
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label839;
        }
      }
      label831:
      label839:
      for (localObject1 = this.jdField_a_of_type_JavaLangString;; localObject1 = "")
      {
        localObject1 = String.format((String)localObject2, new Object[] { localObject1, Integer.valueOf(this.A) });
        break;
        if (localObject2 != null)
        {
          this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, (String)localObject2, true);
          break label693;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
        break label693;
        this.jdField_a_of_type_Long = 0L;
        break label751;
      }
      localObject1 = (CircleManager)paramQQAppInterface.getManager(33);
      localObject2 = ((CircleManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if ((localObject1 != null) && (localObject2 != null))
      {
        this.jdField_a_of_type_JavaLangString = ((CircleManager)localObject1).a((CircleBuddy)localObject2);
        label887:
        a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        if ((localMessage != null) && ((localMessage.getMessageText() != null) || ((localMessage.msgtype == -2011) && (localMessage.msgData != null)))) {
          this.jdField_a_of_type_Long = localMessage.time;
        }
        localObject2 = paramContext.getString(2131559005);
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label1011;
        }
      }
      label1011:
      for (localObject1 = this.jdField_a_of_type_JavaLangString;; localObject1 = "")
      {
        localObject1 = String.format((String)localObject2, new Object[] { localObject1, Integer.valueOf(this.A) });
        break;
        this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
        break label887;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.displayName = null;
      if ((!AppConstants.N.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (!AppConstants.V.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {
        if (0 != 0) {
          break label2446;
        }
      }
      label2446:
      for (localObject1 = (FriendManager)paramQQAppInterface.getManager(8);; localObject1 = null)
      {
        if (a((FriendManager)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          this.z = 4;
          label1091:
          if ((AppConstants.N.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (localMessage != null) && (!TextUtils.isEmpty(localMessage.senderuin)) && ((TextUtils.isEmpty(localMessage.nickName)) || (localMessage.nickName.equals(localMessage.senderuin))))
          {
            localMessage.nickName = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, true);
            if (TextUtils.isEmpty(localMessage.nickName)) {
              localMessage.nickName = localMessage.senderuin;
            }
          }
          if (!AppConstants.V.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          }
          if ((localMessage == null) || ((localMessage.getMessageText() == null) && (localMessage.msgData == null) && ((localMessage.msgtype != -2011) || (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0)))) {
            break label1378;
          }
          this.jdField_a_of_type_Long = localMessage.time;
          label1270:
          if (!AppConstants.U.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            break label1386;
          }
          this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562249);
          this.A = SystemMsgController.a().b(paramQQAppInterface);
          localObject2 = localObject3;
        }
        for (;;)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          if (!String.valueOf(AppConstants.U).equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            break label2019;
          }
          localObject1 = String.format(paramContext.getString(2131559008), new Object[] { Integer.valueOf(this.A) });
          break;
          this.z = 1;
          break label1091;
          label1378:
          this.jdField_a_of_type_Long = 0L;
          break label1270;
          label1386:
          if (AppConstants.W.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562677);
            localObject2 = localObject3;
          }
          else
          {
            if (AppConstants.V.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
            {
              this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562371);
              if (localQQMessageFacade != null) {
                this.A = localQQMessageFacade.g();
              }
              if ((localMessage != null) && (localMessage.senderuin != null))
              {
                localObject2 = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, true);
                if (TextUtils.isEmpty(localMessage.nickName)) {
                  localMessage.nickName = localMessage.senderuin;
                }
                if (localMessage.isSendFromLocal()) {
                  localMsgSummary.b = paramContext.getString(2131562812, new Object[] { localObject2 });
                }
              }
              for (;;)
              {
                localObject2 = String.format(paramContext.getString(2131559006), new Object[] { Integer.valueOf(this.A) });
                break;
                localObject1 = localObject2;
                if (localObject2 != null)
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).equals(localMessage.senderuin)) {
                    localObject1 = paramContext.getString(2131562593);
                  }
                }
                localMsgSummary.b = ((String)localObject1 + paramContext.getString(2131561411));
                continue;
                localMsgSummary.b = paramContext.getString(2131562484);
              }
            }
            if (AppConstants.N.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
            {
              this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562365);
              if (localQQMessageFacade != null) {
                this.A = localQQMessageFacade.h();
              }
              if ((localMessage == null) || (-999 == localMessage.msgtype) || (localMessage.msg == null)) {
                localMsgSummary.b = paramContext.getString(2131562794);
              }
              localObject2 = String.format(paramContext.getString(2131559007), new Object[] { Integer.valueOf(this.A) });
            }
            else if (AppConstants.S.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
            {
              this.jdField_a_of_type_JavaLangString = paramContext.getString(2131563212);
              localObject2 = localObject3;
              if (localMessage != null)
              {
                localObject2 = localObject3;
                if (localMessage.msg != null)
                {
                  localMsgSummary.b = localMessage.msg;
                  localObject2 = localObject3;
                }
              }
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 1000) {
                break label1891;
              }
              localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
              localObject2 = localObject3;
              if (localObject1 != null)
              {
                localObject1 = ((FriendManager)localObject1).g(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
                this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, true);
                localObject2 = localObject3;
              }
            }
          }
        }
        label1891:
        localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
        if (localObject1 != null) {}
        for (localObject1 = ((FriendManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject1 = null)
        {
          if (localObject1 != null) {
            if (!TextUtils.isEmpty(((Friends)localObject1).remark)) {
              localObject1 = ((Friends)localObject1).remark;
            }
          }
          label1938:
          for (this.jdField_a_of_type_JavaLangString = ((String)localObject1);; this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.displayName)
          {
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
            {
              localObject2 = localObject3;
              if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                break;
              }
            }
            this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
            localObject2 = localObject3;
            break;
            localObject1 = ((Friends)localObject1).name;
            break label1938;
          }
          label2019:
          localObject2 = paramContext.getString(2131559005);
          if (this.jdField_a_of_type_JavaLangString != null) {}
          for (localObject1 = this.jdField_a_of_type_JavaLangString;; localObject1 = "")
          {
            localObject1 = String.format((String)localObject2, new Object[] { localObject1, Integer.valueOf(this.A) });
            break;
          }
          this.jdField_a_of_type_JavaLangString = paramContext.getString(2131560604);
          str = "";
          localObject5 = "";
          if (localQQMessageFacade != null) {}
          for (localObject3 = localQQMessageFacade.a(AppConstants.R, 4000);; localObject3 = null)
          {
            localObject2 = localObject5;
            localObject1 = localObject4;
            if (localObject3 != null)
            {
              localObject2 = localObject5;
              localObject1 = localObject4;
              if (((List)localObject3).size() > 0)
              {
                localObject3 = (MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1);
                localObject2 = localObject5;
                localObject1 = localObject4;
                if (((MessageRecord)localObject3).msg != null)
                {
                  if (((MessageRecord)localObject3).msgtype != -1033) {
                    break label2251;
                  }
                  localObject1 = ((MessageRecord)localObject3).msg;
                  localObject1 = paramContext.getString(2131559009) + (String)localObject1;
                  label2216:
                  localObject2 = localObject1;
                }
              }
            }
            localMsgSummary.b = ((CharSequence)localObject2);
            if ((localMessage != null) && (localMessage.getMessageText() != null))
            {
              this.jdField_a_of_type_Long = localMessage.time;
              break;
              label2251:
              if (((MessageRecord)localObject3).msgtype == -1030)
              {
                localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
                if (localObject1 == null) {
                  break label2429;
                }
              }
            }
            label2429:
            for (localObject1 = ((PhoneContactManager)localObject1).c();; localObject1 = "")
            {
              localObject1 = paramContext.getString(2131559009) + (String)localObject1;
              break label2216;
              if (((MessageRecord)localObject3).msgtype == -1039)
              {
                localObject2 = (RecommendTroopManagerImp)paramQQAppInterface.getManager(19);
                localObject1 = str;
                if (localObject2 == null) {
                  break label2216;
                }
                localObject1 = paramContext.getResources().getString(2131560606) + ((RecommendTroopManagerImp)localObject2).a();
                break label2216;
              }
              if (((MessageRecord)localObject3).msgtype == -1040)
              {
                localObject2 = (RecommendTroopManagerImp)paramQQAppInterface.getManager(19);
                localObject1 = str;
                if (localObject2 == null) {
                  break label2216;
                }
                localObject1 = ((RecommendTroopManagerImp)localObject2).a();
                break label2216;
                this.jdField_a_of_type_Long = 0L;
                break;
              }
              localObject1 = "";
              break label2216;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
 * JD-Core Version:    0.7.0.1
 */