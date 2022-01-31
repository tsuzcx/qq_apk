import com.dataline.mpfile.MpfileTaskRecord;
import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.persistence.Entity;

public class zsd
  implements Runnable
{
  public zsd(MpfileTaskProxy paramMpfileTaskProxy, Entity paramEntity, ProxyListener paramProxyListener, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    MpfileTaskRecord localMpfileTaskRecord = ((MpfileTaskRecord)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).clone();
    this.jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy.a.a(String.valueOf(0), 0, MpfileTaskRecord.tableName(), localMpfileTaskRecord, 0, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
    this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsd
 * JD-Core Version:    0.7.0.1
 */