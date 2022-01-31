import android.os.Handler;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceActionListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

public class gaz
  implements MagicfaceActionManager.MagicfaceActionListener
{
  public gaz(MagicfaceViewController paramMagicfaceViewController, int paramInt) {}
  
  public void a(ActionGlobalData paramActionGlobalData)
  {
    boolean bool;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool = MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).b();
      MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).c(bool);
    }
    for (;;)
    {
      MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new gba(this, paramActionGlobalData));
      return;
      bool = MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).c();
      MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).c(bool);
    }
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new gbb(this, paramActionGlobalData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gaz
 * JD-Core Version:    0.7.0.1
 */