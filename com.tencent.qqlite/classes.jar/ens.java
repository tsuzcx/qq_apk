import NearbyGroup.GroupInfo;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.data.NearbyOpenTroop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.GroupActInfo;

public class ens
  extends Handler
{
  public ens(NearbyOpenTroop paramNearbyOpenTroop) {}
  
  void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, str);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    switch (paramMessage.what)
    {
    default: 
    case 1001: 
    case 1002: 
      do
      {
        return;
        paramMessage = (group_activity_info.GroupActInfo)paramMessage.obj;
        MessageForActivity localMessageForActivity = (MessageForActivity)MessageRecordFactory.a(-4002);
        localMessageForActivity.init(str, this.a.jdField_a_of_type_JavaLangString, str, null, MessageCache.a(), -4002, 1, 0L);
        localMessageForActivity.title = paramMessage.title.get();
        localMessageForActivity.summary = paramMessage.summary.get();
        localMessageForActivity.bigPic = paramMessage.big_pic.get();
        localMessageForActivity.url = paramMessage.url.get();
        a(localMessageForActivity, false, false, false);
        NearbyOpenTroop.b(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("EnterTroopTipsMsg", 2, "显示群活动消息，之后直接生成tips");
        }
        NearbyOpenTroop.a(this.a);
        return;
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      } while (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_JavaLangString));
      NearbyOpenTroop.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("EnterTroopTipsMsg", 2, "拉漫游消息失败，直接生成tips");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.a.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      NearbyOpenTroop.a(this.a);
      return;
    }
    int i = this.a.jdField_a_of_type_NearbyGroupGroupInfo.iMemberCnt;
    if (i == 0) {
      i = 1;
    }
    for (;;)
    {
      paramMessage = (MessageForMyEnterTroop)MessageRecordFactory.a(-4004);
      paramMessage.init(str, this.a.jdField_a_of_type_JavaLangString, str, "", MessageCache.a(), -4004, 1, 0L);
      paramMessage.iMemberCount = i;
      a(paramMessage, false, false, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ens
 * JD-Core Version:    0.7.0.1
 */