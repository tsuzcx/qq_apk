import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;

public class gak
  implements Runnable
{
  public gak(MagicfaceDecoder paramMagicfaceDecoder) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    this.a.jdField_a_of_type_Boolean = true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener.a();
    }
    this.a.e();
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener.b();
    }
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gak
 * JD-Core Version:    0.7.0.1
 */