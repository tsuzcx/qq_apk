import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class ttj
  implements URLDrawable.URLDrawableListener
{
  ttj(tti paramtti, String paramString) {}
  
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
      tti.a(this.jdField_a_of_type_Tti, new ttg(paramURLDrawable.getCurrDrawable(), tti.a(this.jdField_a_of_type_Tti), tti.b(this.jdField_a_of_type_Tti) - (tti.c(this.jdField_a_of_type_Tti) + tti.d(this.jdField_a_of_type_Tti))));
      tti.a(this.jdField_a_of_type_Tti).setImageDrawable(tti.a(this.jdField_a_of_type_Tti));
      tti.a(this.jdField_a_of_type_Tti, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttj
 * JD-Core Version:    0.7.0.1
 */