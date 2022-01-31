import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.List;

public class whn
  extends TroopObserver
{
  public whn(RecommendTroopView paramRecommendTroopView) {}
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      this.a.a.a().sendEmptyMessage(105);
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     whn
 * JD-Core Version:    0.7.0.1
 */