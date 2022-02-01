import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;

public final class asyy
  implements asyj.a
{
  public void ess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QSecFramework", 2, "Something wrong when load native so.");
    }
    asxt.report(1, 1);
  }
  
  public void run()
  {
    if (QSecFramework.access$000()) {
      return;
    }
    try
    {
      if (!QSecFramework.access$100()) {
        System.loadLibrary("QSec");
      }
      QSecFramework.access$002(true);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyy
 * JD-Core Version:    0.7.0.1
 */