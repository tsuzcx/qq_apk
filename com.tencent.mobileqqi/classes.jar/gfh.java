import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceTextUpdateListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

public class gfh
  implements MagicfaceActionManager.MagicfaceTextUpdateListener
{
  public gfh(MagicfaceViewController paramMagicfaceViewController, int paramInt, TextView paramTextView) {}
  
  public void a(String paramString)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new gfi(this, paramString));
  }
  
  public void b(String paramString)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new gfj(this, paramString));
  }
  
  public void c(String paramString)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new gfk(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gfh
 * JD-Core Version:    0.7.0.1
 */