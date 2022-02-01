import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.b;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;

public class apjx
  implements ausj.a
{
  public apjx(SearchReciteArticleFragment paramSearchReciteArticleFragment, ausj paramausj, SearchReciteArticleFragment.b paramb, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$b.type == 2) {
      i = paramInt + 1;
    }
    switch (i)
    {
    default: 
      return;
    case 0: 
      SelectReciteParagraphFragment.f(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.mTroopUin, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$b.kid, SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment));
      aqfr.b("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.mTroopUin, "0", String.valueOf(this.val$position), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$b.type) });
      return;
    }
    aqfr.b("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.mTroopUin, "1", String.valueOf(this.val$position), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$b.type) });
    aqfr.b("Grp_edu", "Grp_recite", "Clk_Success", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.mTroopUin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$b.type) });
    try
    {
      SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment, apkp.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.mTroopUin, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$b.title, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$b.kid, null));
      SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment);
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
 * Qualified Name:     apjx
 * JD-Core Version:    0.7.0.1
 */