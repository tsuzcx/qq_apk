import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.widget.DoodlePicView;
import com.tencent.mobileqq.widget.DoodleTextView;

public class ake
  implements View.OnClickListener
{
  public ake(DoodleActivity paramDoodleActivity) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.a()))
    {
      Toast.makeText(BaseApplicationImpl.getContext(), this.a.getString(2131363463) + "...", 0).show();
      return;
    }
    if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView.a()))
    {
      Toast.makeText(BaseApplicationImpl.getContext(), this.a.getString(2131363462) + "...", 0).show();
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.b.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView.d();
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ake
 * JD-Core Version:    0.7.0.1
 */