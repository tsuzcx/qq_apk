import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class glq
  extends TimerTask
{
  glq(glp paramglp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "LoopCycleGetMessage.startGetMsg: start get msg");
    }
    glp.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     glq
 * JD-Core Version:    0.7.0.1
 */