import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;

public class eic
  extends GameCenterObserver
{
  public eic(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i;
    if ((paramBoolean1) && (paramBoolean2) && (paramInt != 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "inform onGameCenterMsgReceive.type=" + paramInt);
      }
      i = this.a.a() + this.a.b();
      this.a.a(34, 16, Integer.valueOf(i));
    }
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
    case 0: 
    case 1: 
    case 4: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (i <= 0);
              this.a.a(34, 17, Boolean.valueOf(false));
              this.a.a(34, 18, Boolean.valueOf(false));
              return;
            } while (i != 0);
            paramBoolean1 = MainAssistObserver.a(this.a);
            this.a.a(34, 17, Boolean.valueOf(paramBoolean1));
          } while (!paramBoolean1);
          this.a.a(34, 18, Boolean.valueOf(false));
          this.a.a(34, 16, Integer.valueOf(0));
          return;
        } while (i != 0);
        paramBoolean1 = MainAssistObserver.b(this.a);
        this.a.a(34, 18, Boolean.valueOf(paramBoolean1));
      } while (!paramBoolean1);
      this.a.a(34, 17, Boolean.valueOf(false));
      this.a.a(34, 16, Integer.valueOf(0));
      return;
    }
    this.a.h();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eic
 * JD-Core Version:    0.7.0.1
 */