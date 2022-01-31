import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class asl
  extends GameCenterObserver
{
  public asl(Leba paramLeba) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!paramBoolean1) || (paramInt == 2)) {}
    for (;;)
    {
      return;
      if (Leba.a(this.a))
      {
        ArrayList localArrayList = new ArrayList();
        LebaUtil.a(localArrayList, LebaShowListManager.a().b());
        this.a.b(new asm(this, localArrayList));
      }
      while (QLog.isColorLevel())
      {
        QLog.i("Q.lebatab.leba", 2, "onGameCenterMsgReceive, " + Leba.b(this.a));
        return;
        LebaShowListManager.c |= 0x2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asl
 * JD-Core Version:    0.7.0.1
 */