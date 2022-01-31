import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.FlowSendTask;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class xme
  implements Runnable
{
  public xme(FlowSendTask paramFlowSendTask) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_k_of_type_JavaLangString, 2, "FlowSendTask(): isPTV:" + this.a.d + ", mVideoFileDir:" + this.a.jdField_a_of_type_JavaLangString + ",is to call AVideoCodec.recordSubmit()");
      }
      RecordManager.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        this.a.jdField_k_of_type_Int = -6;
        synchronized (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.set(true);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(this.a.jdField_k_of_type_JavaLangString, 2, "FlowSendTask(): isPTV:" + this.a.d + ", mVideoFileDir:" + this.a.jdField_a_of_type_JavaLangString + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xme
 * JD-Core Version:    0.7.0.1
 */