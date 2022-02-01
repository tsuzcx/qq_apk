import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderCore;
import com.tencent.qphone.base.util.QLog;

public class adcr
  implements Handler.Callback
{
  private adcr.a jdField_a_of_type_Adcr$a;
  private VideoEncoderCore jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  
  private void awn()
  {
    QLog.d("VideoEncoder", 2, "handleStopRecording");
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.stop();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore = null;
      if (this.mHandlerThread != null)
      {
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
      }
      if (this.mHandler != null)
      {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
      }
      if (this.jdField_a_of_type_Adcr$a != null)
      {
        this.jdField_a_of_type_Adcr$a.cQl();
        this.jdField_a_of_type_Adcr$a = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VideoEncoder", 1, "handleStopRecording stop encoder fail.", localException);
        if (this.jdField_a_of_type_Adcr$a != null) {
          this.jdField_a_of_type_Adcr$a.KF(2);
        }
      }
    }
  }
  
  private void e(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.d(paramArrayOfByte, paramLong);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        QLog.e("VideoEncoder", 1, "handleAudioFrameAvailable encode audio fail.", paramArrayOfByte);
      } while (this.jdField_a_of_type_Adcr$a == null);
      this.jdField_a_of_type_Adcr$a.KF(3);
    }
  }
  
  private void iB(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.iA(paramLong);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        QLog.e("VideoEncoder", 1, "handleVideoFrameAvailable encode video fail.", localException);
      } while (this.jdField_a_of_type_Adcr$a == null);
      this.jdField_a_of_type_Adcr$a.KF(4);
    }
  }
  
  public void a(amae paramamae, adcr.a parama)
  {
    QLog.d("VideoEncoder", 2, "startRecording");
    this.jdField_a_of_type_Adcr$a = parama;
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("EncodeThread");
      this.mHandlerThread.start();
      this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
    }
    if (this.mHandler != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore = new VideoEncoderCore();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.b(paramamae, parama);
      if (this.jdField_a_of_type_Adcr$a != null) {
        this.jdField_a_of_type_Adcr$a.auv();
      }
      return;
    }
    catch (Exception paramamae)
    {
      for (;;)
      {
        QLog.e("VideoEncoder", 1, "startRecording start encoder fail.", paramamae);
        if (this.jdField_a_of_type_Adcr$a != null) {
          this.jdField_a_of_type_Adcr$a.KF(1);
        }
      }
    }
  }
  
  public void d(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mHandler != null)
    {
      QLog.d("VideoEncoder", 2, String.format("audioFrameAvailable timestampNanos=%s", new Object[] { Long.valueOf(paramLong) }));
      this.mHandler.obtainMessage(3, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
  
  public Surface getInputSurface()
  {
    Surface localSurface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore != null) {
      localSurface = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderCore.getInputSurface();
    }
    return localSurface;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 2: 
      awn();
      return true;
    case 3: 
      paramMessage = (Object[])paramMessage.obj;
      e((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
      return true;
    }
    iB(((Long)paramMessage.obj).longValue());
    return true;
  }
  
  public void iA(long paramLong)
  {
    if (this.mHandler != null)
    {
      QLog.d("VideoEncoder", 2, String.format("videoFrameAvailable timestampNanos=%s", new Object[] { Long.valueOf(paramLong) }));
      this.mHandler.removeMessages(4);
      this.mHandler.obtainMessage(4, Long.valueOf(paramLong)).sendToTarget();
    }
  }
  
  public void stopRecording()
  {
    QLog.d("VideoEncoder", 2, "stopRecording");
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.sendEmptyMessage(2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void KF(int paramInt);
    
    public abstract void auv();
    
    public abstract void auy();
    
    public abstract void cQl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcr
 * JD-Core Version:    0.7.0.1
 */