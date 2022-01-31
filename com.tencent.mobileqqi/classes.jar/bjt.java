import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;

class bjt
  implements DialogInterface.OnClickListener
{
  bjt(bjq parambjq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Bjq.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    String str = "CPU_NOTICE" + this.jdField_a_of_type_Bjq.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    localSharedPreferences.edit().putBoolean(str, false).commit();
    this.jdField_a_of_type_Bjq.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_Bjq.jdField_a_of_type_JavaLangString = "CPU";
    this.jdField_a_of_type_Bjq.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_Bjq.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bjq.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Bjq.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_Bjq, 0L);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjt
 * JD-Core Version:    0.7.0.1
 */