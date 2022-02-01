import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

public class yve
  extends yvb
{
  public yve(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramBoolean);
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem)
  {
    super.a(paramRecommendTroopItem);
    anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "Clk_join", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected void b(RecommendTroopItem paramRecommendTroopItem)
  {
    super.b(paramRecommendTroopItem);
    anot.a(null, "dc00899", "Grp_recom", "", "search", "recom_clk_add", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected void c(RecommendTroopItem paramRecommendTroopItem)
  {
    super.c(paramRecommendTroopItem);
    anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "exp_grp", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int xD()
  {
    return 10028;
  }
  
  protected int xE()
  {
    return 21;
  }
  
  protected int xF()
  {
    return 10003;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yve
 * JD-Core Version:    0.7.0.1
 */