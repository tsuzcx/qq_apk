import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class vjm
  implements Runnable
{
  public vjm(ReplyTextItemBuilder paramReplyTextItemBuilder, MessageForReplyText paramMessageForReplyText, int paramInt, vjt paramvjt) {}
  
  public void run()
  {
    int i = 0;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.a.a().c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    ArrayList localArrayList;
    if ((localMessageRecord == null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.mHasPullHistorySourceMsg))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.mHasPullHistorySourceMsg = true;
      Bundle localBundle = new Bundle();
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.a.a();
      localArrayList = new ArrayList();
      int j = localQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      localBundle.putInt("counter", j);
      localBundle.putBoolean("success", false);
      localQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(j), localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq, true, localBundle, 0);
      localQQMessageFacade.b.put(MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.istroop), Boolean.valueOf(false));
      if (!NetworkUtil.g(BaseApplication.getContext())) {}
    }
    label332:
    for (;;)
    {
      try
      {
        localArrayList.wait(35000L);
        if ((localArrayList.size() <= 0) || (i >= localArrayList.size())) {
          break label332;
        }
        if (((MessageRecord)localArrayList.get(i)).shmsgseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq)
        {
          localMessageRecord = (MessageRecord)localArrayList.get(i);
          ThreadManager.getUIHandler().post(new vjn(this, localMessageRecord));
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vjm
 * JD-Core Version:    0.7.0.1
 */