import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.utils.QQCustomDialog;

class cls
  implements Runnable
{
  cls(clr paramclr, Drawable paramDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Clr.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_Clr.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_Clr.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(ForwardOperations.a(this.jdField_a_of_type_Clr.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cls
 * JD-Core Version:    0.7.0.1
 */