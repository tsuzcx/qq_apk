import android.media.AudioRecord;
import android.os.SystemClock;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class zvo
  extends Thread
{
  private int jdField_a_of_type_Int;
  private AudioRecord jdField_a_of_type_AndroidMediaAudioRecord;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public zvo(VideoRecordController paramVideoRecordController)
  {
    super("AudioRecordThread");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoRecordController);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioRecord == null)
    {
      this.jdField_a_of_type_Int = (AudioRecord.getMinBufferSize(48000, 1, 2) * 4);
      this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, 48000, 1, 2, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
      this.jdField_a_of_type_Boolean = true;
      start();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null)
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
        this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        this.jdField_a_of_type_AndroidMediaAudioRecord = null;
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void run()
  {
    while (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
        try
        {
          int i = this.jdField_a_of_type_AndroidMediaAudioRecord.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int);
          if (i > 0)
          {
            VideoRecordController localVideoRecordController = (VideoRecordController)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (localVideoRecordController != null)
            {
              byte[] arrayOfByte = new byte[i];
              System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, i);
              localVideoRecordController.a(arrayOfByte, SystemClock.elapsedRealtimeNanos());
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("VideoRecordController", 1, "AudioRecordController read fail.", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zvo
 * JD-Core Version:    0.7.0.1
 */