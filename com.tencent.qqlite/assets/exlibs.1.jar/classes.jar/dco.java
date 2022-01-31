import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import java.util.List;

public class dco
  implements ConditionSearchManager.ISearchListener
{
  public dco(SearchResultActivity paramSearchResultActivity) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.b = 3;
      this.a.jdField_a_of_type_Dcq.notifyDataSetChanged();
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    paramList = this.a;
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      paramList.b = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dco
 * JD-Core Version:    0.7.0.1
 */