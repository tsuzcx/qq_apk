import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axrz
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
      localaxsf.eOB();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HumSongRecognizer", 2, "recognize: Failed. info: exception = ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrz
 * JD-Core Version:    0.7.0.1
 */