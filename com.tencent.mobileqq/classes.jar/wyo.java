import android.widget.TextView;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;

public class wyo
  implements Runnable
{
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public wyo(AvatarPendantActivity paramAvatarPendantActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void run()
  {
    if (this.b) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.b.setVisibility(8);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyo
 * JD-Core Version:    0.7.0.1
 */