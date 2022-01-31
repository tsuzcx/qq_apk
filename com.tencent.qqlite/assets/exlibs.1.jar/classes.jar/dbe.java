import com.dataline.mpfile.MpfileTaskRecord;
import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy;

public class dbe
  implements Runnable
{
  public dbe(MpfileTaskProxy paramMpfileTaskProxy, MpfileTaskRecord paramMpfileTaskRecord, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy.a(this.jdField_a_of_type_ComDatalineMpfileMpfileTaskRecord, null);
    this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbe
 * JD-Core Version:    0.7.0.1
 */