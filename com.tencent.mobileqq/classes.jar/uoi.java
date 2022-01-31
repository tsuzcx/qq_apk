import android.graphics.drawable.Drawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView;
import com.tencent.qphone.base.util.QLog;

class uoi
  implements Runnable
{
  uoi(uoh paramuoh, Drawable paramDrawable) {}
  
  public void run()
  {
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent start update drawable:" + this.jdField_a_of_type_Uoh.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Uoh.jdField_a_of_type_Int != DoodleMsgLayout.a(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout)) {
      return;
    }
    if (DoodleMsgLayout.b(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout) != null) {
      DoodleMsgLayout.b(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout).setImageDrawable(null);
    }
    if (DoodleMsgLayout.c(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout) != null) {
      DoodleMsgLayout.c(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout).setImageDrawable(null);
    }
    if (DoodleMsgLayout.a(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout) != null) {
      DoodleMsgLayout.a(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    DoodleMsgLayout.a(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout, 0);
    if (DoodleMsgLayout.a(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout) != null) {
      this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(DoodleMsgLayout.a(this.jdField_a_of_type_Uoh.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout).a());
    }
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent finish update drawable:" + this.jdField_a_of_type_Uoh.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uoi
 * JD-Core Version:    0.7.0.1
 */