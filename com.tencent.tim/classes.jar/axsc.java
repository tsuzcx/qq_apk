import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axsc
  implements axsb
{
  private float Es;
  private File bm;
  
  public void E(File paramFile)
  {
    this.bm = paramFile;
  }
  
  public void bw(float paramFloat)
  {
    this.Es = paramFloat;
  }
  
  public void ctT()
  {
    if ((this.bm == null) || (!this.bm.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("OriginalBgmRecognizer", 2, "recognize: invoked. info: audioFile not exist. mTargetAudioFile = " + this.bm);
      }
      return;
    }
    axsf localaxsf = (axsf)axov.a().c(10);
    localaxsf.bw(this.Es);
    localaxsf.E(this.bm);
    localaxsf.eOB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsc
 * JD-Core Version:    0.7.0.1
 */