import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.QQCustomDialog;

class anh
  implements Runnable
{
  anh(anf paramanf, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Anf.a != null) && (this.jdField_a_of_type_Anf.a.isShowing()))
    {
      this.jdField_a_of_type_Anf.a.setPreviewImage(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new ani(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anh
 * JD-Core Version:    0.7.0.1
 */