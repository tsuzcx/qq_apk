import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.util.ImageCreator;
import com.tencent.mobileqq.util.ImageWorker;

public class hao
  implements Runnable
{
  public hao(ImageWorker paramImageWorker, har paramhar, String paramString, ImageCreator paramImageCreator) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Har.a(new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilImageCreator, Boolean.valueOf(true) });
    ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker).post(new hap(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hao
 * JD-Core Version:    0.7.0.1
 */