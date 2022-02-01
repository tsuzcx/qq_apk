import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class uoa
  implements URLDrawable.URLDrawableListener
{
  uoa(unz paramunz, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadCanceled:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadFialed:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadProgressed");
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadSuccessed:" + this.jdField_a_of_type_JavaLangString);
    }
    if (paramURLDrawable != null)
    {
      unz.a(this.jdField_a_of_type_Unz, new uny(paramURLDrawable.getCurrDrawable(), unz.a(this.jdField_a_of_type_Unz), unz.b(this.jdField_a_of_type_Unz) - (unz.c(this.jdField_a_of_type_Unz) + unz.d(this.jdField_a_of_type_Unz))));
      unz.a(this.jdField_a_of_type_Unz).setImageDrawable(unz.a(this.jdField_a_of_type_Unz));
      unz.a(this.jdField_a_of_type_Unz, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoa
 * JD-Core Version:    0.7.0.1
 */