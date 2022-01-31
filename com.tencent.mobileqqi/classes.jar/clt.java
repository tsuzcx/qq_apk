import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.QQCustomDialog;

class clt
  implements Runnable
{
  clt(clr paramclr, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Clr.a != null) && (this.jdField_a_of_type_Clr.a.isShowing()))
    {
      this.jdField_a_of_type_Clr.a.setPreviewImage(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new clu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     clt
 * JD-Core Version:    0.7.0.1
 */