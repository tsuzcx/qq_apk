import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class zcz
  implements Runnable
{
  public zcz(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  public void run()
  {
    if (MayknowRecommendManager.a(this.a).a.a() == 1)
    {
      MayknowRecommendManager.b(this.a);
      return;
    }
    MayknowRecommendManager.a(this.a).postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcz
 * JD-Core Version:    0.7.0.1
 */