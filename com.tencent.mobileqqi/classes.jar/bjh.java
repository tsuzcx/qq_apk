import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class bjh
  implements Runnable
{
  public bjh(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "2s has past, startTimer now!");
    }
    this.a.Q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjh
 * JD-Core Version:    0.7.0.1
 */