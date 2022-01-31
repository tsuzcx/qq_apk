import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.List;

public class dmv
  implements AbsListView.OnScrollListener
{
  public dmv(SearchTroopListActivity paramSearchTroopListActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_Boolean))
    {
      paramInt = this.a.jdField_a_of_type_ComTencentWidgetXListView.r();
      if (this.a.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
        this.a.e();
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmv
 * JD-Core Version:    0.7.0.1
 */