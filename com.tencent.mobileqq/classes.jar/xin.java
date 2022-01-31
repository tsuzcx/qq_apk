import com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;

public class xin
  implements Runnable
{
  public xin(RecentItemKandianMergeData paramRecentItemKandianMergeData, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, long paramLong) {}
  
  public void run()
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.as, 7220, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "time", Long.valueOf(this.jdField_a_of_type_Long));
    localRecentUserProxy.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemKandianMergeData.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xin
 * JD-Core Version:    0.7.0.1
 */