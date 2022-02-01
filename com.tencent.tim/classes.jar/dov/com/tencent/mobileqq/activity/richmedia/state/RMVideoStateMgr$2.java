package dov.com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import java.util.concurrent.atomic.AtomicReference;

class RMVideoStateMgr$2
  implements Runnable
{
  RMVideoStateMgr$2(RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    synchronized (RMVideoStateMgr.a(this.this$0))
    {
      AudioCapture localAudioCapture = this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture;
      if ((localAudioCapture != null) && (localAudioCapture.d != null) && (this.this$0.jdField_a_of_type_Azbo != null) && (localAudioCapture.aRC()) && (localAudioCapture != null))
      {
        localAudioCapture.dQg();
        localAudioCapture.d.getAndSet(this.this$0.jdField_a_of_type_Azbo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@][openAudioRecord]");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.2
 * JD-Core Version:    0.7.0.1
 */