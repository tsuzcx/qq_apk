import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.ims.devlock_verify_scheme.SchemePkg;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class xvj
  extends Handler
{
  public xvj(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    int i;
    byte[] arrayOfByte;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      i = ((Bundle)localObject).getInt("ret", 1);
      ((Bundle)localObject).getByteArray("appName");
      arrayOfByte = ((Bundle)localObject).getByteArray("tlv");
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
        if (i < arrayOfByte.length)
        {
          j = arrayOfByte[i];
          i += 1;
          k = j << 8 & 0xFF00 | arrayOfByte[i] & 0xFF;
          j = i + 1;
          i = arrayOfByte[j];
          j += 1;
          n = arrayOfByte[j] & 0xFF | i << 8 & 0xFF00;
          if (k == 3)
          {
            i = j + 1;
            new String(arrayOfByte, i, n);
          }
          else if (k == 5)
          {
            paramMessage = this.a;
            i = j + 1;
            paramMessage.d = new String(arrayOfByte, i, n);
          }
        }
      }
      catch (Exception paramMessage)
      {
        if (this.a.jdField_b_of_type_Int == 65793) {
          break label263;
        }
      }
      if (this.a.jdField_b_of_type_Int == 77313)
      {
        label263:
        this.a.c = "Windows";
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130846464));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131717594, new Object[] { this.a.c }));
        if (TextUtils.isEmpty(this.a.d)) {
          this.a.d = this.a.getString(2131721200);
        }
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.getString(2131717600, new Object[] { this.a.d }));
        if (!this.a.jdField_a_of_type_Boolean) {
          break label958;
        }
        this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        label410:
        azmj.b(null, "dc00898", "", "", "0X800A46D", "0X800A46D", xwz.a(this.a.jdField_b_of_type_Int), 0, "", "", "", "");
        return;
        if (k == 32) {
          i = j;
        }
      }
      for (;;)
      {
        try
        {
          paramMessage = new byte[n];
          j += 1;
          i = j;
          System.arraycopy(arrayOfByte, j, paramMessage, 0, n);
          i = j;
          localObject = new devlock_verify_scheme.SchemePkg();
          i = j;
          ((devlock_verify_scheme.SchemePkg)localObject).mergeFrom(paramMessage);
          i = j;
          if (!((devlock_verify_scheme.SchemePkg)localObject).u32_button2_type.has()) {
            break label1307;
          }
          i = j;
          if (((devlock_verify_scheme.SchemePkg)localObject).u32_button2_type.get() == 0) {
            break label1307;
          }
          k = 1;
          i = j;
          if (!((devlock_verify_scheme.SchemePkg)localObject).str_button2_caption.has()) {
            break label1301;
          }
          i = j;
          if (TextUtils.isEmpty(((devlock_verify_scheme.SchemePkg)localObject).str_button2_caption.get())) {
            break label1301;
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
        break label1313;
        i = j;
        if (k != 53) {
          break label1313;
        }
        paramMessage = new byte[4];
        j += 1;
        System.arraycopy(arrayOfByte, j, paramMessage, 0, n);
        localObject = this.a;
        i = paramMessage[3];
        k = paramMessage[2];
        int m = paramMessage[1];
        ((QRLoginAuthActivity)localObject).jdField_b_of_type_Int = ((paramMessage[0] & 0xFF) << 24 | i & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16);
        i = j;
        if (!QLog.isColorLevel()) {
          break label1313;
        }
        QLog.d("QRLoginAuthActivity", 2, new Object[] { "wtlogin apptype:", Integer.valueOf(this.a.jdField_b_of_type_Int) });
        i = j;
        break label1313;
        if (this.a.jdField_b_of_type_Int == 5)
        {
          this.a.c = "Mac";
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130846462));
          break;
        }
        if (this.a.jdField_b_of_type_Int == 3)
        {
          this.a.c = "iPad";
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130846461));
          break;
        }
        if (xwz.b(this.a.jdField_b_of_type_Int))
        {
          this.a.c = alpo.a(2131711583);
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130846463));
          break;
        }
        this.a.c = alpo.a(2131711584);
        QLog.d("QRLoginAuthActivity", 1, new Object[] { "wtlogin unknown apptype:", Integer.valueOf(this.a.jdField_b_of_type_Int) });
        break;
        label958:
        this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        break label410;
        this.a.a(new String(paramMessage));
        break label410;
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
            this.a.f = ((JSONObject)localObject).optString("login_tips");
            this.a.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("sub_appid");
            if (QLog.isColorLevel()) {
              QLog.d("QRLoginAuthActivity", 2, "ON CLOSE appType:" + this.a.jdField_b_of_type_Int + ",bannerTips:" + this.a.f + ",subappid:" + this.a.jdField_a_of_type_Long);
            }
            if (this.a.jdField_a_of_type_Bepp.isShowing()) {
              this.a.jdField_a_of_type_Bepp.dismiss();
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
        if ((this.a.jdField_a_of_type_Bepp != null) && (this.a.jdField_a_of_type_Bepp.isShowing())) {
          this.a.jdField_a_of_type_Bepp.dismiss();
        }
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.a.a(null);
        return;
        label1301:
        m = 0;
        continue;
        label1307:
        k = 0;
      }
      label1313:
      i += n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xvj
 * JD-Core Version:    0.7.0.1
 */