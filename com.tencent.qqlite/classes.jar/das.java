import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.persistence.Entity;

public class das
  implements Runnable
{
  public das(DataLineMsgProxy paramDataLineMsgProxy, Entity paramEntity, ProxyListener paramProxyListener, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgRecord)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).clone();
    this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a.a(String.valueOf(0), 0, DataLineMsgRecord.tableName(), localDataLineMsgRecord, 0, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
    this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     das
 * JD-Core Version:    0.7.0.1
 */