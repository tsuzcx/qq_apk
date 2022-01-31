import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class gpy
  extends TimerTask
{
  gpy(gpx paramgpx) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "LoopCycleGetMessage.startGetMsg: start get msg");
    }
    gpx.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gpy
 * JD-Core Version:    0.7.0.1
 */