import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

class vct
  implements aqiv
{
  vct(vcq paramvcq, IphonePickerView paramIphonePickerView, bkho parambkho) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bkho != null) && (this.jdField_a_of_type_Bkho.isShowing())) {
      this.jdField_a_of_type_Bkho.dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    vcq.a(this.jdField_a_of_type_Vcq).setText(vcq.a(this.jdField_a_of_type_Vcq).a(0, paramInt1));
    if (vcq.a(this.jdField_a_of_type_Vcq) == null) {
      vcq.a(this.jdField_a_of_type_Vcq, new QQCirclePrivateMsgShow.StPMSettingData());
    }
    vcq.a(this.jdField_a_of_type_Vcq).fuelCost.set(Integer.parseInt(vcq.a(this.jdField_a_of_type_Vcq).a(0, paramInt1)));
    QLog.i("QCirclePrivateMessageSettingContentPart", 1, "fuelUseNumSelect() setSelection  row : " + paramInt2 + " , fuelCost : " + vcq.a(this.jdField_a_of_type_Vcq).fuelCost.get());
    vrf.a(String.valueOf(uxx.a()), 11, 39, 2, vcq.a(this.jdField_a_of_type_Vcq).a(0, paramInt1), "", "", "", "", this.jdField_a_of_type_Vcq.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vct
 * JD-Core Version:    0.7.0.1
 */