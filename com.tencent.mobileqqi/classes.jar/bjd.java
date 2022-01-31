import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.PhoneStatusTools;

public class bjd
  extends OrientationEventListener
{
  int jdField_a_of_type_Int = -25;
  boolean jdField_a_of_type_Boolean = false;
  
  public bjd(AVActivity paramAVActivity, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Boolean = PhoneStatusTools.g(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1)
    {
      if (this.jdField_a_of_type_Int != paramInt) {}
      this.jdField_a_of_type_Int = paramInt;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Int = 0;
      }
    } while ((paramInt - this.jdField_a_of_type_Int < 20) && (paramInt - this.jdField_a_of_type_Int > -20));
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().i)
    {
      paramInt -= 90;
      i = paramInt;
      if (paramInt < 0) {
        i = paramInt + 360;
      }
    }
    this.jdField_a_of_type_Int = i;
    if ((i > 314) || (i < 45))
    {
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(0);
      }
      this.jdField_a_of_type_ComTencentAvUiAVActivity.k = 0;
      return;
    }
    if ((i > 44) && (i < 135))
    {
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(90);
      }
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(90);
      }
      this.jdField_a_of_type_ComTencentAvUiAVActivity.k = 90;
      return;
    }
    if ((i > 134) && (i < 225))
    {
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(180);
      }
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(180);
      }
      this.jdField_a_of_type_ComTencentAvUiAVActivity.k = 180;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(270);
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(270);
    }
    this.jdField_a_of_type_ComTencentAvUiAVActivity.k = 270;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjd
 * JD-Core Version:    0.7.0.1
 */