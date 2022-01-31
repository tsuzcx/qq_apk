import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class crr
  extends GameCenterObserver
{
  public crr(Leba paramLeba) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!paramBoolean1) || (paramInt == 2)) {}
    for (;;)
    {
      return;
      if (Leba.c(this.a))
      {
        ArrayList localArrayList = new ArrayList();
        List localList = LebaShowListManager.a().b();
        LebaShowListManager.a().a(localArrayList, localList);
        this.a.b(new crs(this, localArrayList));
      }
      while (QLog.isColorLevel())
      {
        QLog.i("Q.lebatab.leba", 2, "onGameCenterMsgReceive, " + Leba.d(this.a));
        return;
        LebaShowListManager.c |= 0x2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     crr
 * JD-Core Version:    0.7.0.1
 */