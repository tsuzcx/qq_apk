import com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class xvd
  implements Runnable
{
  public xvd(RMVideoRecordState paramRMVideoRecordState, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.unlockFrameSync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xvd
 * JD-Core Version:    0.7.0.1
 */