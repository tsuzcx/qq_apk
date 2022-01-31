import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;

public class hvd
  extends hvh
  implements Runnable
{
  public int a;
  
  private hvd(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView.p) {}
    ListAdapter localListAdapter;
    int i;
    boolean bool;
    View localView;
    do
    {
      do
      {
        return;
        localListAdapter = this.jdField_a_of_type_ComTencentWidgetAbsListView.a;
        i = this.jdField_a_of_type_Int;
        bool = AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, i, this.jdField_a_of_type_ComTencentWidgetAbsListView.a.getCount());
      } while ((localListAdapter == null) || ((!bool) && (!AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView))) || (!a()));
      localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(i - this.jdField_a_of_type_ComTencentWidgetAbsListView.ap);
    } while ((localView == null) && (!AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView)));
    AbsListView localAbsListView = this.jdField_a_of_type_ComTencentWidgetAbsListView;
    if (bool) {}
    for (long l = localListAdapter.getItemId(i);; l = 0L)
    {
      localAbsListView.a(localView, i, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hvd
 * JD-Core Version:    0.7.0.1
 */