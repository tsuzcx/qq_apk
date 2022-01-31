import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.QQCustomDialog;

class anc
  implements Runnable
{
  anc(ana paramana, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ana.a != null) && (this.jdField_a_of_type_Ana.a.isShowing()))
    {
      this.jdField_a_of_type_Ana.a.setPreviewImage(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new and(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anc
 * JD-Core Version:    0.7.0.1
 */