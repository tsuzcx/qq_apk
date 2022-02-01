import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopListWrapper.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class yvi
  extends acnd
{
  yvi(yvg paramyvg) {}
  
  protected void A(boolean paramBoolean, List<RecommendTroopItem> paramList)
  {
    this.b.As(paramBoolean);
  }
  
  protected void b(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    this.b.a(paramBoolean1, paramInt1, paramInt2, paramBoolean2, paramArrayList, paramBoolean3);
  }
  
  protected void b(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    this.b.a(paramBoolean1, paramInt1, paramString, paramInt2, paramBoolean2, paramArrayList, paramBoolean3);
  }
  
  protected void b(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList)
  {
    this.b.a(paramBoolean1, paramLong, paramInt, paramBoolean2, paramArrayList);
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {
      ThreadManager.getUIHandler().post(new RecommendTroopListWrapper.2.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvi
 * JD-Core Version:    0.7.0.1
 */