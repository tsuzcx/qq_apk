import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.view.MagicfaceView;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

class gfn
  implements Runnable
{
  gfn(gfl paramgfl, ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Gfl.jdField_a_of_type_Int == 1)
    {
      MagicfaceViewController.a(this.jdField_a_of_type_Gfl.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).setBackgroundColor(0);
      this.jdField_a_of_type_Gfl.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.h)) && (PreferenceManager.getDefaultSharedPreferences(MagicfaceViewController.a(this.jdField_a_of_type_Gfl.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController)).getBoolean(MagicfaceViewController.a(this.jdField_a_of_type_Gfl.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).getString(2131563409), false))) {
      MagicfaceViewController.a(this.jdField_a_of_type_Gfl.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).y();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gfn
 * JD-Core Version:    0.7.0.1
 */