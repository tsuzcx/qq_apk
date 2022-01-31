import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class clu
  implements URLDrawable.URLDrawableListener
{
  clu(clt paramclt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setBounds(ImageUtil.a(this.a.jdField_a_of_type_ComTencentImageURLDrawable, 36, 100, ForwardOperations.a(this.a.jdField_a_of_type_Clr.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations)));
    this.a.jdField_a_of_type_Clr.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     clu
 * JD-Core Version:    0.7.0.1
 */