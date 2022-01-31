import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.QzoneSyncQQStoryTool;

public class xky
  implements View.OnClickListener
{
  public xky(EditLocalVideoActivity paramEditLocalVideoActivity, long paramLong) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (EditLocalVideoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity))
    {
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).setSelected(false);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity;
      if (EditLocalVideoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity)) {
        break label73;
      }
    }
    for (;;)
    {
      EditLocalVideoActivity.b(paramView, bool);
      QzoneSyncQQStoryTool.a(this.jdField_a_of_type_Long, EditLocalVideoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity));
      return;
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).setSelected(true);
      break;
      label73:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xky
 * JD-Core Version:    0.7.0.1
 */