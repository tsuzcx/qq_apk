import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import java.util.ArrayList;

class aply
  implements ausj.a
{
  aply(aplx paramaplx, ausj paramausj, boolean paramBoolean, apkp paramapkp) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    int i = paramInt;
    if (!this.cRj) {
      i = paramInt + 1;
    }
    switch (i)
    {
    default: 
      paramView = "";
    }
    for (;;)
    {
      aqfr.b("Grp_edu", "Grp_recite", "Blueword_Clk", 0, 0, new String[] { this.e.mTroopUin, paramView });
      return;
      SelectReciteParagraphFragment.a(paramView.getContext(), this.e.mTroopUin, this.e.cpK, new ArrayList(this.e.HW), this.e.mPosition);
      paramView = "2";
      continue;
      SearchReciteArticleFragment.f(paramView.getContext(), this.e.mTroopUin, "", this.e.mPosition);
      paramView = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aply
 * JD-Core Version:    0.7.0.1
 */