import com.tencent.mobileqq.activity.contact.newfriend.ContactBindedBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreInfoBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendSubTitleBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.PushRecommendBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.QIMFollowerAddBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.QIMNotifyAddFriendBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgItemBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.newfriend.ContactBindedMessage;
import com.tencent.mobileqq.newfriend.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.MayKnowMessage;
import com.tencent.mobileqq.newfriend.NewFriendBindContactGuideMsg;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.newfriend.NewFriendSubTitleMessage;
import com.tencent.mobileqq.newfriend.PhoneContactAddMessage;
import com.tencent.mobileqq.newfriend.QIMFollowMessage;
import com.tencent.mobileqq.newfriend.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

class yoo
  implements Runnable
{
  yoo(yon paramyon, ArrayList paramArrayList) {}
  
  public void run()
  {
    SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a).clear();
    SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    label873:
    for (;;)
    {
      NewFriendMessage localNewFriendMessage;
      Object localObject;
      if (localIterator.hasNext())
      {
        localNewFriendMessage = (NewFriendMessage)localIterator.next();
        localObject = null;
        if ((localNewFriendMessage instanceof MayKnowMessage))
        {
          PushRecommendBuilder localPushRecommendBuilder = new PushRecommendBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage, SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a));
          localObject = localPushRecommendBuilder;
          if (((MayKnowMessage)localNewFriendMessage).a.sourceId == 3045)
          {
            localObject = localPushRecommendBuilder;
            if (!localNewFriendMessage.a())
            {
              ReportController.b(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), "CliOper", "", "", "0X80085C3", "0X80085C3", 0, 0, String.valueOf(((MayKnowMessage)localNewFriendMessage).a.subSourceId), "", "", "");
              localObject = localPushRecommendBuilder;
            }
          }
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label873;
        }
        SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a).add(localObject);
        break;
        if ((localNewFriendMessage instanceof ContactMatchMessage))
        {
          localObject = new ContactMatchBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage);
        }
        else if ((localNewFriendMessage instanceof ContactBindedMessage))
        {
          if (SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a) == null)
          {
            localObject = new ContactBindedBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage);
            SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a, (ContactBindedBuilder)localObject);
          }
          else
          {
            localObject = SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a);
            ((NewFriendBaseBuilder)localObject).a(localNewFriendMessage);
          }
        }
        else if ((localNewFriendMessage instanceof FriendSystemMessage))
        {
          localObject = new SystemMsgItemBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage);
          if (((SystemMsgItemBuilder)localObject).a != 0L) {
            SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a).add(Long.valueOf(((SystemMsgItemBuilder)localObject).a));
          }
        }
        else if ((localNewFriendMessage instanceof NewFriendSubTitleMessage))
        {
          localObject = new NewFriendSubTitleBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage);
        }
        else if ((localNewFriendMessage instanceof NewFriendMoreInfoMessage))
        {
          localObject = new NewFriendMoreInfoBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage);
        }
        else if ((localNewFriendMessage instanceof NewFriendBindContactGuideMsg))
        {
          localObject = new NewFriendBindContactGuideBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage);
        }
        else if ((localNewFriendMessage instanceof PhoneContactAddMessage))
        {
          localObject = new PhoneContactAddBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage);
        }
        else if ((localNewFriendMessage instanceof QIMFollowMessage))
        {
          localObject = new QIMFollowerAddBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage);
        }
        else if ((localNewFriendMessage instanceof QIMNotifyAddFriendMsg))
        {
          localObject = new QIMNotifyAddFriendBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a), this.jdField_a_of_type_Yon.a, localNewFriendMessage);
          continue;
          this.jdField_a_of_type_Yon.a.a.i();
          this.jdField_a_of_type_Yon.a.notifyDataSetChanged();
          if (SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a))
          {
            if ((SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a) == 2) && (SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a).c() == 0) && (SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a).d() > 0) && (SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a).a() >= 3))
            {
              int i = SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a).b();
              this.jdField_a_of_type_Yon.a.a.setSelection(i);
            }
            SystemMsgListAdapter.a(this.jdField_a_of_type_Yon.a, false);
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yoo
 * JD-Core Version:    0.7.0.1
 */