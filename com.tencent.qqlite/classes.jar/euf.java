import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.util.ImageCreator;
import com.tencent.mobileqq.util.ImageWorker;

public class euf
  implements Runnable
{
  public euf(ImageWorker paramImageWorker, eui parameui, String paramString, ImageCreator paramImageCreator) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Eui.a(new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilImageCreator, Boolean.valueOf(true) });
    ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker).post(new eug(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     euf
 * JD-Core Version:    0.7.0.1
 */