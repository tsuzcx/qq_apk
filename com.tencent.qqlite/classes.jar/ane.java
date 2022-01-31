import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;

class ane
  implements Runnable
{
  ane(ana paramana, Drawable paramDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ana.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_Ana.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_Ana.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a.get("PhotoConst.PHOTO_PATHS");
      if (localArrayList != null) {
        this.jdField_a_of_type_Ana.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true, localArrayList.size());
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Ana.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ane
 * JD-Core Version:    0.7.0.1
 */