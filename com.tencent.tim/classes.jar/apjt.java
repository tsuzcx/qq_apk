import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.c;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;

public class apjt
  implements TextWatcher
{
  public apjt(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() == 0)
    {
      this.a.eak();
      this.a.RO(false);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$c.clearData();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$c.notifyDataSetChanged();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.uh(false);
    this.a.mStartIndex = 0;
    this.a.RO(true);
    paramEditable = paramEditable.toString();
    this.a.SW(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apjt
 * JD-Core Version:    0.7.0.1
 */