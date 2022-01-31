import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.bless.BlessActivity;

public class wbk
  implements Runnable
{
  public wbk(BlessActivity paramBlessActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    BlessActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    BlessActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbk
 * JD-Core Version:    0.7.0.1
 */