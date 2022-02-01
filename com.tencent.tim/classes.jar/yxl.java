import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.15.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import java.util.List;
import mqq.os.MqqHandler;

public class yxl
  extends acnd
{
  public yxl(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  protected void A(boolean paramBoolean, List<RecommendTroopItem> paramList)
  {
    if ((paramBoolean) && (paramList != null)) {
      this.this$0.gT(paramList);
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {
      ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.15.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxl
 * JD-Core Version:    0.7.0.1
 */