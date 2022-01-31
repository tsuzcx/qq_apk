import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class czn
  implements Runnable
{
  public czn(DataLineMsgProxy paramDataLineMsgProxy, DataLineMsgRecord paramDataLineMsgRecord, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    DataLineMsgProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, null);
    this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     czn
 * JD-Core Version:    0.7.0.1
 */