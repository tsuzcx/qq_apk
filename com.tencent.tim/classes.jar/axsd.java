import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axsd
  implements axsb
{
  private File bm;
  
  public void E(File paramFile)
  {
    this.bm = paramFile;
  }
  
  public void ctT()
  {
    if ((this.bm == null) || (!this.bm.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VoiceBgmRecognizer", 2, "recognize: invoked. info: mTargetAudioFile = " + this.bm);
      }
      return;
    }
    axsf localaxsf = (axsf)axov.a().c(10);
    localaxsf.E(this.bm);
    try
    {
      axrr.a(this.bm.getAbsolutePath(), this.bm.getAbsolutePath() + "_8kHz", localaxsf);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      QLog.d("VoiceBgmRecognizer", 1, String.format("e = %s", new Object[] { localFFmpegCommandAlreadyRunningException }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsd
 * JD-Core Version:    0.7.0.1
 */