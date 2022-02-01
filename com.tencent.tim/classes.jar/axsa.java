import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axsa
  implements axsb
{
  private File bm;
  
  public void E(File paramFile)
  {
    this.bm = paramFile;
  }
  
  public void ctT()
  {
    try
    {
      axsf localaxsf = (axsf)axov.a().c(10);
      localaxsf.E(this.bm);
      localaxsf.bw(7000.0F);
      localaxsf.eOB();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HumVoiceRecognizer", 2, "recognize: invoked. info: throwable = " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsa
 * JD-Core Version:    0.7.0.1
 */