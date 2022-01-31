import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceTextUpdateListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

public class gav
  implements MagicfaceActionManager.MagicfaceTextUpdateListener
{
  public gav(MagicfaceViewController paramMagicfaceViewController, int paramInt, TextView paramTextView) {}
  
  public void a(String paramString)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new gaw(this, paramString));
  }
  
  public void b(String paramString)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new gax(this, paramString));
  }
  
  public void c(String paramString)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new gay(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gav
 * JD-Core Version:    0.7.0.1
 */