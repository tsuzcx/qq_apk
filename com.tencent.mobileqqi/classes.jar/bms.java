import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class bms
  extends Handler
{
  public bms(QRLoginActivity paramQRLoginActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    int i;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      i = ((Bundle)localObject).getInt("ret", 1);
      arrayOfByte1 = ((Bundle)localObject).getByteArray("appName");
      arrayOfByte2 = ((Bundle)localObject).getByteArray("tlv");
      localObject = ((Bundle)localObject).getByteArray("errMsg");
      paramMessage = (Message)localObject;
      if (localObject == null) {
        paramMessage = new byte[0];
      }
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if (i == 0) {
        if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0))
        {
          this.a.d = this.a.getString(2131560509);
          if ((arrayOfByte2[0] << 8 & 0xFF00 | arrayOfByte2[1] & 0xFF) != 5) {
            break label505;
          }
          i = arrayOfByte2[2];
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramMessage = new String(arrayOfByte2, 4, arrayOfByte2[3] & 0xFF | i << 8 & 0xFF00);
        if (paramMessage != null)
        {
          localObject = paramMessage;
          if (paramMessage.length() != 0) {}
        }
        else
        {
          localObject = this.a.getString(2131560510);
        }
        paramMessage = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.g(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131560499, new Object[] { this.a.d, localObject }));
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.getString(2131560501, new Object[] { this.a.d }));
        this.a.e = ((String)localObject);
        new bmt(this, paramMessage).start();
        return;
        this.a.d = new String(arrayOfByte1);
      }
      catch (Exception paramMessage)
      {
        paramMessage = null;
        continue;
      }
      this.a.a(new String(paramMessage));
      return;
      i = ((Bundle)localObject).getInt("ret", 1);
      paramMessage = ((Bundle)localObject).getByteArray("errMsg");
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if (i == 0)
      {
        this.a.o_();
        return;
      }
      this.a.a(new String(paramMessage));
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.a(null);
      return;
      label505:
      paramMessage = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bms
 * JD-Core Version:    0.7.0.1
 */