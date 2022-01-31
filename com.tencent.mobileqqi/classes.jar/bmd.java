import android.os.Handler;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.av.utils.QQFrameByFrameAnimation;

public class bmd
  implements Runnable
{
  public bmd(QQFrameByFrameAnimation paramQQFrameByFrameAnimation) {}
  
  public void run()
  {
    if ((this.a.d > 0) && (this.a.c >= this.a.d)) {
      this.a.c();
    }
    do
    {
      do
      {
        return;
        if ((this.a.b > 0) && (this.a.c / this.a.jdField_a_of_type_ArrayOfInt.length >= this.a.b))
        {
          this.a.c();
          return;
        }
        this.a.a();
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.a.jdField_a_of_type_Int);
      } while (this.a.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener == null);
      this.a.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.c();
    } while ((this.a.jdField_a_of_type_ArrayOfInt.length <= 0) || (this.a.c % this.a.jdField_a_of_type_ArrayOfInt.length != 0));
    this.a.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmd
 * JD-Core Version:    0.7.0.1
 */