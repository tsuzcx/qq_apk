import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class dcc
  implements ConditionSearchManager.ISearchListener
{
  public dcc(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    this.a.d();
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 2131364407, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QQToast.a(this.a, 2131364408, 0).b(this.a.getTitleBarHeight());
      return;
    }
    SearchResultActivity.a(this.a, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(), paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dcc
 * JD-Core Version:    0.7.0.1
 */