import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ane
  implements Runnable
{
  ane(anc paramanc, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Anc.a != null) && (this.jdField_a_of_type_Anc.a.isShowing()))
    {
      this.jdField_a_of_type_Anc.a.setPreviewImage(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new anf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ane
 * JD-Core Version:    0.7.0.1
 */