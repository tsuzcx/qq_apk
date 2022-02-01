package com.tencent.mobileqq.activity;

import aegu;
import ajdg;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import jof;
import top;

class ChatActivityFacade$20$1
  implements Runnable
{
  ChatActivityFacade$20$1(ChatActivityFacade.20 param20, MessageForMarketFace paramMessageForMarketFace, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.sendFaceName = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.msgVia = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.entrance;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.istroop == 1)
    {
      jof.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace);
      if (top.eD(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ) != 1032) {
        break label296;
      }
      aegu.a(this.this$0.val$app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.topicId);
    }
    for (;;)
    {
      this.this$0.val$app.b().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, null);
      ajdg localajdg = (ajdg)this.this$0.val$app.getManager(14);
      if (localajdg == null) {
        break label376;
      }
      Object localObject = localajdg.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label376;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(str))
        {
          RecentEmotion localRecentEmotion = new RecentEmotion();
          localRecentEmotion.epId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
          localRecentEmotion.eId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;
          localRecentEmotion.keyword = str.toLowerCase();
          localRecentEmotion.exposeNum = 0;
          localajdg.a(localRecentEmotion);
        }
      }
      if (!jof.a().aaQ) {
        break;
      }
      jof.a().aaQ = false;
      break;
      label296:
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.bey) {
        aegu.b(this.this$0.val$app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl);
      } else if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.bez) {
        aegu.c(this.this$0.val$app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl);
      }
    }
    label376:
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "mainRunnable, epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " ePackage.copywritingType = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.copywritingType + " currentTime = " + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.20.1
 * JD-Core Version:    0.7.0.1
 */