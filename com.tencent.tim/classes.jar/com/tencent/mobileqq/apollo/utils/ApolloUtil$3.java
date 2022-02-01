package com.tencent.mobileqq.apollo.utils;

import abhh;
import abvl;
import abxk;
import afky;
import aofk;
import aofk.a;
import aofy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ApolloUtil$3
  implements Runnable
{
  ApolloUtil$3(int paramInt, boolean paramBoolean, CharSequence paramCharSequence, abxk paramabxk, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    if ((this.ctL == 2) && (!this.bGv)) {}
    for (int j = 0;; j = 1)
    {
      Object localObject1 = (aofk)this.val$text;
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = (aofk.a[])((aofk)localObject1).getSpans(0, ((aofk)localObject1).length(), aofk.a.class);
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int n = localObject2.length;
        int k = 0;
        for (i = 0;; i = m)
        {
          m = i;
          if (k >= n) {
            break;
          }
          int i1 = localObject2[k].getIndex();
          m = i;
          if (aofy.jq(i1))
          {
            i1 = afky.hl(i1);
            m = i;
            if (i1 >= 0)
            {
              if (j != 0)
              {
                i = ApolloUtil.b(this.jdField_a_of_type_Abxk, i1, this.ctL);
                if (i > 0) {
                  localArrayList.add(Integer.valueOf(i));
                }
              }
              m = 1;
            }
          }
          k += 1;
        }
      }
      int m = 0;
      if ((j == 0) && (m != 0)) {
        ApolloUtil.m(this.val$app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if ((localArrayList.size() == 0) && (1 == abhh.x(this.val$app))) {
        ApolloUtil.b(this.val$app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (aofk)localObject1, localArrayList);
      }
      for (int i = 1;; i = 0)
      {
        QQAppInterface localQQAppInterface;
        ChatMessage localChatMessage;
        if (localArrayList.size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] send action list to play, actionList=", localArrayList });
          }
          localObject2 = abvl.a();
          localQQAppInterface = this.val$app;
          localChatMessage = this.b;
          if (i == 0) {
            break label360;
          }
        }
        label360:
        for (localObject1 = localArrayList;; localObject1 = null)
        {
          ((abvl)localObject2).a(localQQAppInterface, localChatMessage, localArrayList, (ArrayList)localObject1);
          localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if (localObject1 != null)
          {
            localObject1 = (QQMessageFacade)((AppRuntime)localObject1).getManager(20);
            if (localObject1 != null) {
              ((QQMessageFacade)localObject1).a(this.b.frienduin, this.b.istroop, this.b.uniseq, "extStr", this.b.extStr);
            }
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.3
 * JD-Core Version:    0.7.0.1
 */