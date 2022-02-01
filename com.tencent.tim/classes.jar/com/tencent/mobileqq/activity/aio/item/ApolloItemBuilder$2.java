package com.tencent.mobileqq.activity.aio.item;

import abhh;
import abxk;
import abzy;
import acad;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

final class ApolloItemBuilder$2
  implements Runnable
{
  ApolloItemBuilder$2(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (this.val$app == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = (abxk)this.val$app.getManager(155);
        } while (localObject2 == null);
        localObject1 = ((abxk)localObject2).dK();
        if ((localObject1 == null) || (((List)localObject1).size() < 143)) {
          break;
        }
        ApolloItemBuilder.a(this.val$context.getString(2131690320), 1, this.val$context);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloItemBuilder", 2, "fav number is 144");
      return;
      if (((abxk)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId) != null) {
        break;
      }
      ApolloItemBuilder.a(this.val$context.getString(2131690323), 1, this.val$context);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloItemBuilder", 2, "cant find the add aciton id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
    return;
    Object localObject1 = ((abxk)localObject2).dK();
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject3 = (ApolloFavActionData)((Iterator)localObject1).next();
      } while (this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId != ((ApolloFavActionData)localObject3).acitonId);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ApolloItemBuilder.a(this.val$context.getString(2131690319), 1, this.val$context);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "the add aciton is exist id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.favId = l;
      ((abxk)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData);
      ApolloItemBuilder.a(this.val$context.getString(2131690324), 2, this.val$context);
      localObject3 = this.val$app;
      i = ApolloUtil.gi(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ);
      String str = "" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.text)) {}
      for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.text)
      {
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "add_action", i, 0, new String[] { str, "", localObject1 });
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, " add aciton success id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
        }
        localObject3 = this.val$app.getHandler(ChatActivity.class);
        if (localObject3 == null) {
          break;
        }
        localObject1 = new acad(this.val$app.getCurrentUin());
        ((abzy)localObject1).c = ((abxk)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
        ((abzy)localObject1).bkj = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.text;
        ((abzy)localObject1).cue = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.textType;
        ((abzy)localObject1).cre = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.audioId;
        ((abzy)localObject1).cuf = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.playOriginalAudio;
        ((abzy)localObject1).sC = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.audioStartTime;
        localObject2 = ((MqqHandler)localObject3).obtainMessage(66);
        ((Message)localObject2).obj = localObject1;
        ((Message)localObject2).sendToTarget();
        if (((abzy)localObject1).c.status != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, "add action download res " + ((abzy)localObject1).toString());
        }
        if (this.val$app == null) {
          break;
        }
        localObject2 = (abhh)this.val$app.getManager(153);
        localObject3 = new ArrayList();
        ((List)localObject3).add(((abzy)localObject1).c);
        ((abhh)localObject2).w((List)localObject3, "apollo_key");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */