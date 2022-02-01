import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

class vex
  implements aqxy
{
  vex(veu paramveu, IphonePickerView paramIphonePickerView, blir paramblir) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
      this.jdField_a_of_type_Blir.dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    veu.a(this.jdField_a_of_type_Veu).setText(veu.a(this.jdField_a_of_type_Veu).a(0, paramInt1));
    if (veu.a(this.jdField_a_of_type_Veu) == null) {
      veu.a(this.jdField_a_of_type_Veu, new QQCirclePrivateMsgShow.StPMSettingData());
    }
    veu.a(this.jdField_a_of_type_Veu).fuelCost.set(Integer.parseInt(veu.a(this.jdField_a_of_type_Veu).a(0, paramInt1)));
    QLog.i("QCirclePrivateMessageSettingContentPart", 1, "fuelUseNumSelect() setSelection  row : " + paramInt2 + " , fuelCost : " + veu.a(this.jdField_a_of_type_Veu).fuelCost.get());
    vtq.a(String.valueOf(uzg.a()), 11, 39, 2, veu.a(this.jdField_a_of_type_Veu).a(0, paramInt1), "", "", "", "", this.jdField_a_of_type_Veu.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vex
 * JD-Core Version:    0.7.0.1
 */