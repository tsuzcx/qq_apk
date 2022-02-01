import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.GridListView.b;
import com.tencent.mobileqq.widget.GridListView.c;

public class arfu
  extends DataSetObserver
{
  public arfu(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.c.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b != null) {
      GridListView.a(this.c, this.c.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b.getCount());
    }
    if (this.c.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c != null) {
      this.c.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.c.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b != null) {
      GridListView.a(this.c, this.c.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b.getCount());
    }
    if (this.c.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c != null) {
      this.c.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfu
 * JD-Core Version:    0.7.0.1
 */