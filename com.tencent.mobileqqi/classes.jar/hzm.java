import android.view.View;
import com.tencent.widget.AbsListView;

public class hzm
  implements Runnable
{
  public hzm(AbsListView paramAbsListView, View paramView, hzx paramhzx) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = -1;
    this.jdField_a_of_type_AndroidViewView.setPressed(false);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.setPressed(false);
    if (!this.jdField_a_of_type_ComTencentWidgetAbsListView.p) {
      this.jdField_a_of_type_Hzx.run();
    }
    AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzm
 * JD-Core Version:    0.7.0.1
 */