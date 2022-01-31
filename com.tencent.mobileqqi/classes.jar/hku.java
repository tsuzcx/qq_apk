import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import com.tencent.mobileqq.widget.GridListView.WraperAdapter;

public class hku
  extends DataSetObserver
{
  public hku(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    GridListView.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    GridListView.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hku
 * JD-Core Version:    0.7.0.1
 */