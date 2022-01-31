import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class glr
  extends TimerTask
{
  glr(glq paramglq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "LoopCycleGetMessage.startGetMsg: start get msg");
    }
    glq.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     glr
 * JD-Core Version:    0.7.0.1
 */