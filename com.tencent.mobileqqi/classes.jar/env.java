import android.widget.ImageView;
import com.tencent.mobileqq.activity.qquserguide.UserguideVideoFragment;
import com.tencent.mobileqq.widget.QQVideoView;

class env
  implements Runnable
{
  env(enu paramenu) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.isPlaying())
    {
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     env
 * JD-Core Version:    0.7.0.1
 */