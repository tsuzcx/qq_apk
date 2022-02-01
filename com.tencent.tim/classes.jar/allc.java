import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.tencent.qphone.base.util.QLog;

public class allc
{
  public static void a(AudioRecord paramAudioRecord)
  {
    paramAudioRecord.startRecording();
    if (!alky.isAppOnForeground())
    {
      paramAudioRecord = new Throwable();
      QLog.e("BytecodeAudioMonitor", 1, "[startRecording()] stack: ", paramAudioRecord);
      allb.h("qm_audio", "AudioRecord.startRecording()", paramAudioRecord);
    }
  }
  
  public static void a(MediaRecorder paramMediaRecorder)
  {
    paramMediaRecorder.start();
    if (!alky.isAppOnForeground())
    {
      paramMediaRecorder = new Throwable();
      QLog.e("BytecodeAudioMonitor", 1, "[start] stack: ", paramMediaRecorder);
      allb.h("qm_audio", "MediaRecorder.start()", paramMediaRecorder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allc
 * JD-Core Version:    0.7.0.1
 */