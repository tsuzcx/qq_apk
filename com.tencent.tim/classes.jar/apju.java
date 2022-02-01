import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.a;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.a.a;

public class apju
  implements SearchReciteArticleFragment.a.a
{
  public apju(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    paramView = this.a.a.getItem(paramInt);
    this.a.bC.setText(paramView);
    this.a.bC.setSelection(paramView.length());
    aqfr.b("Grp_edu", "Grp_recite", "Recommend_Clk", 0, 0, new String[] { this.a.mTroopUin, paramView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apju
 * JD-Core Version:    0.7.0.1
 */