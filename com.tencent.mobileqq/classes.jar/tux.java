import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.viola.ui.component.image.ImageAction;
import java.util.Set;

class tux
  implements URLDrawable.URLDrawableListener
{
  private ImageAction jdField_a_of_type_ComTencentViolaUiComponentImageImageAction;
  private boolean jdField_a_of_type_Boolean;
  
  public tux(tuv paramtuv, boolean paramBoolean, ImageAction paramImageAction)
  {
    this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction = paramImageAction;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction.onCancel();
    tuv.a(this.jdField_a_of_type_Tuv).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    tuv.a(this.jdField_a_of_type_Tuv, this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction, paramURLDrawable, paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    tuv.a(this.jdField_a_of_type_Tuv, this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction, paramURLDrawable, this.jdField_a_of_type_Boolean);
    tuv.a(this.jdField_a_of_type_Tuv).remove(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tux
 * JD-Core Version:    0.7.0.1
 */