import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.ActionCountdownOver;
import java.util.TimerTask;

public class dxf
  extends TimerTask
{
  public dxf(ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    ActionGlobalData.a(this.a);
    ActionGlobalData localActionGlobalData = this.a;
    localActionGlobalData.a -= 0.1F;
    if (ActionGlobalData.a(this.a) != null) {
      ActionGlobalData.a(this.a).b();
    }
    if (ActionGlobalData.b(this.a) * 100 == this.a.c * 1000)
    {
      this.a.a = 0.0F;
      if (ActionGlobalData.a(this.a) != null) {
        ActionGlobalData.a(this.a).a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dxf
 * JD-Core Version:    0.7.0.1
 */