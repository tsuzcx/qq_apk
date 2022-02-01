import android.view.View;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import java.lang.reflect.Method;

public class ardz
  implements ausj.a
{
  public ardz(WerewolvesHostInterface paramWerewolvesHostInterface, Object paramObject, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ardp.getMethod(this.fG.getClass(), "onClick", new Class[] { Integer.TYPE });
    try
    {
      paramView.invoke(this.fG, new Object[] { Integer.valueOf(paramInt) });
      this.val$sheet.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardz
 * JD-Core Version:    0.7.0.1
 */