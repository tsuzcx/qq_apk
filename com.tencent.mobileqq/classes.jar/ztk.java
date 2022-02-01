import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.ims.devlock_verify_scheme.SchemePkg;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ztk
  extends Handler
{
  public ztk(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
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
        i = 0;
      }
      break;
    }
    for (;;)
    {
      int j;
      int k;
      int n;
      try
      {
        if (i < arrayOfByte2.length)
        {
          j = arrayOfByte2[i];
          i += 1;
          k = j << 8 & 0xFF00 | arrayOfByte2[i] & 0xFF;
          j = i + 1;
          i = arrayOfByte2[j];
          j += 1;
          n = arrayOfByte2[j] & 0xFF | i << 8 & 0xFF00;
          if (k == 3)
          {
            i = j + 1;
            new String(arrayOfByte2, i, n);
          }
          else if (k == 5)
          {
            paramMessage = this.a;
            i = j + 1;
            paramMessage.f = new String(arrayOfByte2, i, n);
          }
        }
      }
      catch (Exception paramMessage)
      {
        QRLoginAuthActivity.a(this.a, arrayOfByte1);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131715831, new Object[] { this.a.e }));
        if (TextUtils.isEmpty(this.a.f)) {
          this.a.f = this.a.getString(2131718944);
        }
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.getString(2131715837, new Object[] { this.a.f }));
        if (!this.a.jdField_a_of_type_Boolean) {
          break label730;
        }
      }
      this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      bcst.b(null, "dc00898", "", "", "0X800A46D", "0X800A46D", zva.a(this.a.jdField_b_of_type_Int), 0, "", "", "", "");
      return;
      if (k == 32) {
        i = j;
      }
      for (;;)
      {
        try
        {
          paramMessage = new byte[n];
          j += 1;
          i = j;
          System.arraycopy(arrayOfByte2, j, paramMessage, 0, n);
          i = j;
          localObject = new devlock_verify_scheme.SchemePkg();
          i = j;
          ((devlock_verify_scheme.SchemePkg)localObject).mergeFrom(paramMessage);
          i = j;
          if (!((devlock_verify_scheme.SchemePkg)localObject).u32_button2_type.has()) {
            break label1075;
          }
          i = j;
          if (((devlock_verify_scheme.SchemePkg)localObject).u32_button2_type.get() == 0) {
            break label1075;
          }
          k = 1;
          i = j;
          if (!((devlock_verify_scheme.SchemePkg)localObject).str_button2_caption.has()) {
            break label1069;
          }
          i = j;
          if (TextUtils.isEmpty(((devlock_verify_scheme.SchemePkg)localObject).str_button2_caption.get())) {
            break label1069;
          }
          m = 1;
          i = j;
          if (((devlock_verify_scheme.SchemePkg)localObject).u32_button2_auth.has())
          {
            i = j;
            this.a.jdField_a_of_type_Int = ((devlock_verify_scheme.SchemePkg)localObject).u32_button2_auth.get();
          }
          if ((k != 0) && (m != 0))
          {
            i = j;
            if (this.a.jdField_a_of_type_Int == 2)
            {
              i = j;
              this.a.jdField_a_of_type_Boolean = true;
              i = j;
            }
          }
        }
        catch (Throwable paramMessage)
        {
          paramMessage.printStackTrace();
        }
        i = j;
        this.a.jdField_a_of_type_Boolean = false;
        i = j;
        break label1081;
        i = j;
        if (k != 53) {
          break label1081;
        }
        paramMessage = new byte[4];
        j += 1;
        System.arraycopy(arrayOfByte2, j, paramMessage, 0, n);
        localObject = this.a;
        i = paramMessage[3];
        k = paramMessage[2];
        int m = paramMessage[1];
        ((QRLoginAuthActivity)localObject).jdField_b_of_type_Int = ((paramMessage[0] & 0xFF) << 24 | i & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16);
        i = j;
        if (!QLog.isColorLevel()) {
          break label1081;
        }
        QLog.d("QRLoginAuthActivity", 2, new Object[] { "wtlogin apptype:", Integer.valueOf(this.a.jdField_b_of_type_Int) });
        i = j;
        break label1081;
        label730:
        this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        break;
        this.a.a(new String(paramMessage));
        break;
        i = ((Bundle)localObject).getInt("ret", 1);
        paramMessage = ((Bundle)localObject).getByteArray("errMsg");
        localObject = ((Bundle)localObject).getByteArray("devInfo");
        if (localObject != null) {}
        for (;;)
        {
          try
          {
            localObject = new JSONObject(new String((byte[])localObject, "UTF-8"));
            this.a.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("app_type");
            this.a.h = ((JSONObject)localObject).optString("login_tips");
            this.a.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("sub_appid");
            if (QLog.isColorLevel()) {
              QLog.d("QRLoginAuthActivity", 2, "ON CLOSE appType:" + this.a.jdField_b_of_type_Int + ",bannerTips:" + this.a.h + ",subappid:" + this.a.jdField_a_of_type_Long);
            }
            if (this.a.jdField_a_of_type_Biau.isShowing()) {
              this.a.jdField_a_of_type_Biau.dismiss();
            }
            if (i != 0) {
              break;
            }
            this.a.c();
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            continue;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("QRLoginAuthActivity", 4, "ON CLOSE devInfo == null");
          }
        }
        this.a.a(new String(paramMessage));
        return;
        if ((this.a.jdField_a_of_type_Biau != null) && (this.a.jdField_a_of_type_Biau.isShowing())) {
          this.a.jdField_a_of_type_Biau.dismiss();
        }
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.a.a(null);
        return;
        label1069:
        m = 0;
        continue;
        label1075:
        k = 0;
      }
      label1081:
      i += n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztk
 * JD-Core Version:    0.7.0.1
 */