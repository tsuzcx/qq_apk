import android.view.View;
import com.tencent.widget.AbsListView;

public class fjb
  implements Runnable
{
  public fjb(AbsListView paramAbsListView, View paramView, fjm paramfjm) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = -1;
    this.jdField_a_of_type_AndroidViewView.setPressed(false);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.setPressed(false);
    if (!this.jdField_a_of_type_ComTencentWidgetAbsListView.q) {
      this.jdField_a_of_type_Fjm.run();
    }
    AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fjb
 * JD-Core Version:    0.7.0.1
 */