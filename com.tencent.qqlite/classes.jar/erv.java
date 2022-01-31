import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.util.ImageCreator;
import com.tencent.mobileqq.util.ImageWorker;

public class erv
  implements Runnable
{
  public erv(ImageWorker paramImageWorker, ery paramery, String paramString, ImageCreator paramImageCreator) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Ery.a(new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilImageCreator, Boolean.valueOf(true) });
    ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker).post(new erw(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     erv
 * JD-Core Version:    0.7.0.1
 */