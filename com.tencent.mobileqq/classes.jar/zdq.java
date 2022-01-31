import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class zdq
  implements Runnable
{
  public zdq(CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject1 = (QQText)this.jdField_a_of_type_JavaLangCharSequence;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (QQText.EmoticonSpan[])((QQText)localObject1).getSpans(0, ((QQText)localObject1).length(), QQText.EmoticonSpan.class);
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i].a();
        if ((TextUtils.a(k)) && (k >= 0) && (k < MessageUtils.a.length)) {
          localArrayList.add(Integer.valueOf(ApolloUtil.f(MessageUtils.a[k])));
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0) {
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQText)localObject1, localArrayList);
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
        localObject2 = ApolloMsgPlayController.a();
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (i == 0) {
          break label273;
        }
      }
      label273:
      for (localObject1 = localArrayList;; localObject1 = null)
      {
        ((ApolloMsgPlayController)localObject2).a(localQQAppInterface, localChatMessage, localArrayList, (ArrayList)localObject1);
        localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject1 != null)
        {
          localObject1 = (QQMessageFacade)((AppRuntime)localObject1).getManager(19);
          if (localObject1 != null) {
            ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extStr);
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zdq
 * JD-Core Version:    0.7.0.1
 */