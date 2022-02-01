import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.2.1;
import java.util.List;

public class afhx
  extends aceg
{
  afhx(afhv paramafhv) {}
  
  public void EL(boolean paramBoolean)
  {
    if (afhv.e(this.this$0) == null) {}
    while (!paramBoolean) {
      return;
    }
    this.this$0.cYZ();
  }
  
  public void iK(List<CustomEmotionData> paramList)
  {
    if (afhv.f(this.this$0) == null) {
      return;
    }
    afhv.g(this.this$0).removeObserver(afhv.a(this.this$0));
    ThreadManager.excute(new FavroamingManager.2.1(this, paramList), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhx
 * JD-Core Version:    0.7.0.1
 */