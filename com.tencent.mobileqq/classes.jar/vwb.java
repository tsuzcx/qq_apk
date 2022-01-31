import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.TroopObserver;
import mqq.os.MqqHandler;

public class vwb
  extends TroopObserver
{
  public vwb(NearbyChatPie paramNearbyChatPie) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    paramString = this.a;
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramString.U = paramBoolean1;
      NearbyChatPie.c(this.a).post(new vwc(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwb
 * JD-Core Version:    0.7.0.1
 */