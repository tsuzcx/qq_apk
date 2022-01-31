import com.tencent.av.ui.MultiVideoEnterPage;
import com.tencent.qphone.base.util.QLog;

public class bkj
  implements Runnable
{
  public bkj(MultiVideoEnterPage paramMultiVideoEnterPage) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "RemoveTipsRunnable");
    }
    MultiVideoEnterPage.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkj
 * JD-Core Version:    0.7.0.1
 */