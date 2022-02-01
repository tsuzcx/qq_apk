import com.tencent.qphone.base.util.QLog;
import java.io.File;

class slu
  extends sli.f
{
  slu(sli.d paramd, long paramLong, sli.a parama, File paramFile)
  {
    super(paramd.this$0);
  }
  
  public void aB(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.val$startTime));
    }
    this.a.e(this.K.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slu
 * JD-Core Version:    0.7.0.1
 */