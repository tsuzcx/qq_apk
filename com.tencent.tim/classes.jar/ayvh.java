import android.os.Handler;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.1;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.2;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class ayvh
  extends ayvi
{
  private boolean byT;
  private long timestamp;
  
  private void cyd()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + azba.cHa);
    }
    if (!azba.cHa) {}
    synchronized (azba.eS)
    {
      azba.cHa = true;
      azba.eS.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + azba.cHa);
      }
      AVCodec.get().startCapture();
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.startCapture();
      if (localRMVideoStateMgr.hB(2)) {
        localRMVideoStateMgr.cyh();
      }
      if ((localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (localRMVideoStateMgr.Xi())) {
        localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.startRecord();
      }
      this.timestamp = System.currentTimeMillis();
      return;
    }
  }
  
  public void a(azan.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    parama = RMVideoStateMgr.a();
    if (parama.byV) {}
    for (parama.bL = (System.currentTimeMillis() - parama.mStartTime);; parama.bL = paramInt1)
    {
      if (!this.byT)
      {
        this.byT = paramBoolean;
        if ((parama.Xh()) && (!parama.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.czJ) && (!parama.bzc)) {
          parama.mHandler.post(new RMVideoRecordState.2(this));
        }
        if (QLog.isColorLevel()) {
          QLog.d("RMRecordState", 2, "[@] timeExpire: mIsRecordOver=" + this.byT + " mStateMgr.mTotalTime=" + parama.bL);
        }
        parama.jdField_a_of_type_Ayvl.as((int)(parama.bL + azbb.a().a().Jt()), this.byT);
        if (this.byT) {
          parama.mHandler.post(new RMVideoRecordState.3(this));
        }
      }
      return;
    }
  }
  
  public void cxZ()
  {
    cye();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.tl(2);
    localRMVideoStateMgr.startWatching();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]startWatching");
    }
  }
  
  public void cye()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [stopRecordVideo]Lock.CAPTURE_LOCK = " + azba.cHa);
    }
    if (azba.cHa)
    {
      azba.cHa = false;
      long l1 = System.currentTimeMillis();
      this.timestamp = (l1 - this.timestamp);
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] current=" + l1 + " timestamp=" + this.timestamp);
      }
      if (this.byT) {
        localRMVideoStateMgr.bL = aniq.dGY;
      }
      localRMVideoStateMgr.jdField_a_of_type_Ayvl.cwB();
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.stopCapture();
      if (localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
        localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.stopRecord();
      }
      if (localRMVideoStateMgr.hB(3))
      {
        if (localRMVideoStateMgr.jdField_a_of_type_Azbo != null) {
          localRMVideoStateMgr.bdT = localRMVideoStateMgr.jdField_a_of_type_Azbo.a(localRMVideoStateMgr);
        }
        localRMVideoStateMgr.cyi();
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new RMVideoRecordState.1(this, localRMVideoStateMgr));
      AVCodec.get().stopCapture();
      long l2 = localRMVideoStateMgr.jdField_a_of_type_Ayvl.yQ();
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] timeLimit=" + l2 + " timestamp=" + this.timestamp);
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = this.timestamp;
      }
      if ((l1 < 500L) && (!this.byT))
      {
        localRMVideoStateMgr.jdField_a_of_type_Ayvl.CL(true);
        localRMVideoStateMgr.CW(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] stopRecordVideo end Lock.CAPTURE_LOCK = " + azba.cHa);
      }
    }
  }
  
  public void initState()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.jdField_a_of_type_Ayvl.cwv();
    localRMVideoStateMgr.stopWatching();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]stopWatching");
    }
    this.byT = false;
    cyd();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] initState end");
    }
  }
  
  public void onPause()
  {
    cxZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayvh
 * JD-Core Version:    0.7.0.1
 */