import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

public class yvf
  extends yvb
{
  public yvf(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramBoolean);
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem)
  {
    anot.a(null, "dc00899", "Grp_recom", "", "no_search_result", "clk_grp", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected void b(RecommendTroopItem paramRecommendTroopItem)
  {
    anot.a(null, "dc00899", "Grp_recom", "", "no_search_result", "clk_add", 0, 0, String.valueOf(paramRecommendTroopItem.uin), paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected void c(RecommendTroopItem paramRecommendTroopItem)
  {
    anot.a(null, "dc00899", "Grp_recom", "", "no_search_result", "exp_grp", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int xD()
  {
    return 10021;
  }
  
  protected int xE()
  {
    return 109;
  }
  
  protected int xF()
  {
    return 10022;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvf
 * JD-Core Version:    0.7.0.1
 */