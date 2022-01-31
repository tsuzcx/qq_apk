import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;

public class wwh
  extends GameCenterObserver
{
  public wwh(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramInt != 2)) {
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "inform onGameCenterMsgReceive.type=" + paramInt);
      }
    }
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 0: 
      this.a.g();
      this.a.i();
      return;
    case 1: 
      this.a.g();
      this.a.i();
      return;
    case 4: 
      this.a.g();
      this.a.i();
      return;
    }
    this.a.g();
    this.a.e();
    this.a.f();
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wwh
 * JD-Core Version:    0.7.0.1
 */