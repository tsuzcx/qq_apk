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
import java.nio.ByteBuffer;

public class qn
  extends Handler
{
  public qn(QRLoginActivity paramQRLoginActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    String str = null;
    Object localObject2 = paramMessage.getData();
    int i;
    byte[] arrayOfByte2;
    byte[] arrayOfByte1;
    int j;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      i = ((Bundle)localObject2).getInt("ret", 1);
      arrayOfByte2 = ((Bundle)localObject2).getByteArray("appName");
      arrayOfByte1 = ((Bundle)localObject2).getByteArray("tlv");
      localObject2 = ((Bundle)localObject2).getByteArray("errMsg");
      paramMessage = (Message)localObject2;
      if (localObject2 == null) {
        paramMessage = new byte[0];
      }
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if (i == 0) {
        if ((arrayOfByte2 == null) || (arrayOfByte2.length == 0))
        {
          this.a.d = this.a.getString(2131362421);
          i = 0;
          j = 0;
          paramMessage = str;
        }
      }
      break;
    }
    label667:
    for (;;)
    {
      try
      {
        if (i < arrayOfByte1.length)
        {
          int k = arrayOfByte1[i];
          i += 1;
          int m = k << 8 & 0xFF00 | arrayOfByte1[i] & 0xFF;
          i += 1;
          k = arrayOfByte1[i];
          i += 1;
          k = k << 8 & 0xFF00 | arrayOfByte1[i] & 0xFF;
          if (m == 5)
          {
            i += 1;
            str = new String(arrayOfByte1, i, k);
            paramMessage = str;
            i += k;
            continue;
            this.a.d = new String(arrayOfByte2);
            break;
          }
          if (m != 20) {
            break label667;
          }
          i += 1;
          m = ByteBuffer.wrap(arrayOfByte1, i, k).getInt();
          if (m == 1)
          {
            j = 1;
            continue;
          }
          j = 0;
          continue;
        }
        if (j == 0) {
          break label492;
        }
      }
      catch (Exception localException) {}
      this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.a.c.setVisibility(0);
      for (;;)
      {
        Object localObject1;
        if (paramMessage != null)
        {
          localObject1 = paramMessage;
          if (paramMessage.length() != 0) {}
        }
        else
        {
          localObject1 = this.a.getString(2131362422);
        }
        paramMessage = this.a.app.a();
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.g(this.a.app, paramMessage));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131362410, new Object[] { this.a.d, localObject1 }));
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.getString(2131362412, new Object[] { this.a.d }));
        this.a.e = ((String)localObject1);
        new qo(this, paramMessage).start();
        return;
        label492:
        this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.a.c.setVisibility(8);
      }
      this.a.a(new String(paramMessage));
      return;
      i = ((Bundle)localObject2).getInt("ret", 1);
      paramMessage = ((Bundle)localObject2).getByteArray("errMsg");
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if (i == 0)
      {
        this.a.b();
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     qn
 * JD-Core Version:    0.7.0.1
 */