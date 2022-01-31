import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.QQCustomDialog;

class csg
  implements Runnable
{
  csg(cse paramcse, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Cse.a != null) && (this.jdField_a_of_type_Cse.a.isShowing()))
    {
      this.jdField_a_of_type_Cse.a.setPreviewImage(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new csh(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     csg
 * JD-Core Version:    0.7.0.1
 */