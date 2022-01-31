import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.remind.RemindHelper;
import com.tencent.mobileqq.remind.TimeHelper;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;

public final class gfx
  implements DialogInterface.OnDismissListener
{
  public gfx(IosTimepicker paramIosTimepicker, JsBridgeListener paramJsBridgeListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener != null))
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker.a() / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d(RemindHelper.a(), 2, "onDismiss Time :" + TimeHelper.a(l * 1000L));
      }
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker.setOnTimePickerSelectListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener.a(Long.valueOf(l));
      RemindHelper.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gfx
 * JD-Core Version:    0.7.0.1
 */