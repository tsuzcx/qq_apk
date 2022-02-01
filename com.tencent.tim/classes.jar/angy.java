import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.b;
import com.tencent.qphone.base.util.QLog;

class angy
  implements ShortVideoTrimmer.b
{
  angy(angw.a parama) {}
  
  public void b(Process paramProcess)
  {
    this.this$0.a = paramProcess;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: ShortVideoTrimmer Start!");
    }
  }
  
  public void onDestroy()
  {
    this.this$0.a = null;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: ShortVideoTrimmer onDestroy!");
    }
  }
  
  public void onStop()
  {
    this.this$0.a = null;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: ShortVideoTrimmer onStop!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angy
 * JD-Core Version:    0.7.0.1
 */