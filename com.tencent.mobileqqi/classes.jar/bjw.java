import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;

public class bjw
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bjw(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvVideoController.f)
      {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.w();
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.R();
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().n = 0;
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().n;
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.v();
      return;
    case 1: 
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.r();
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjw
 * JD-Core Version:    0.7.0.1
 */