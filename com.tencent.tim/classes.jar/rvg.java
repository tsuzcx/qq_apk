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

public class rvg
  extends Handler
{
  public rvg(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
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
      this.a.fg.setVisibility(0);
      this.a.progressBar.setVisibility(8);
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
            paramMessage.aCE = new String(arrayOfByte, i, n);
          }
        }
      }
      catch (Exception paramMessage)
      {
        if (this.a.appType == 65793) {
          break label263;
        }
      }
      if (this.a.appType == 77313)
      {
        label263:
        this.a.aCD = "Windows";
        this.a.nL.setImageDrawable(this.a.getResources().getDrawable(2130847862));
        this.a.zx.setText(this.a.getString(2131717184, new Object[] { this.a.aCD }));
        if (TextUtils.isEmpty(this.a.aCE)) {
          this.a.aCE = this.a.getString(2131721558);
        }
        this.a.zy.setText(this.a.getString(2131717190, new Object[] { this.a.aCE }));
        if (!this.a.aJS) {
          break label958;
        }
        this.a.cB.setVisibility(0);
        label410:
        anot.a(null, "dc00898", "", "", "0X800A46D", "0X800A46D", rwr.en(this.a.appType), 0, "", "", "", "");
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
            break label1309;
          }
          i = j;
          if (((devlock_verify_scheme.SchemePkg)localObject).u32_button2_type.get() == 0) {
            break label1309;
          }
          k = 1;
          i = j;
          if (!((devlock_verify_scheme.SchemePkg)localObject).str_button2_caption.has()) {
            break label1303;
          }
          i = j;
          if (TextUtils.isEmpty(((devlock_verify_scheme.SchemePkg)localObject).str_button2_caption.get())) {
            break label1303;
          }
          m = 1;
          i = j;
          if (((devlock_verify_scheme.SchemePkg)localObject).u32_button2_auth.has())
          {
            i = j;
            this.a.bvy = ((devlock_verify_scheme.SchemePkg)localObject).u32_button2_auth.get();
          }
          if ((k != 0) && (m != 0))
          {
            i = j;
            if (this.a.bvy == 2)
            {
              i = j;
              this.a.aJS = true;
              i = j;
            }
          }
        }
        catch (Throwable paramMessage)
        {
          paramMessage.printStackTrace();
        }
        i = j;
        this.a.aJS = false;
        i = j;
        break label1315;
        i = j;
        if (k != 53) {
          break label1315;
        }
        paramMessage = new byte[4];
        j += 1;
        System.arraycopy(arrayOfByte, j, paramMessage, 0, n);
        localObject = this.a;
        i = paramMessage[3];
        k = paramMessage[2];
        int m = paramMessage[1];
        ((QRLoginAuthActivity)localObject).appType = ((paramMessage[0] & 0xFF) << 24 | i & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16);
        i = j;
        if (!QLog.isColorLevel()) {
          break label1315;
        }
        QLog.d("QRLoginAuthActivity", 2, new Object[] { "wtlogin apptype:", Integer.valueOf(this.a.appType) });
        i = j;
        break label1315;
        if (this.a.appType == 5)
        {
          this.a.aCD = "Mac";
          this.a.nL.setImageDrawable(this.a.getResources().getDrawable(2130847860));
          break;
        }
        if (this.a.appType == 3)
        {
          this.a.aCD = "iPad";
          this.a.nL.setImageDrawable(this.a.getResources().getDrawable(2130847859));
          break;
        }
        if (rwr.fd(this.a.appType))
        {
          this.a.aCD = acfp.m(2131712603);
          this.a.nL.setImageDrawable(this.a.getResources().getDrawable(2130847861));
          break;
        }
        this.a.aCD = acfp.m(2131712604);
        QLog.d("QRLoginAuthActivity", 1, new Object[] { "wtlogin unknown apptype:", Integer.valueOf(this.a.appType) });
        break;
        label958:
        this.a.cB.setVisibility(8);
        break label410;
        this.a.sM(new String(paramMessage));
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
            this.a.appType = ((JSONObject)localObject).optInt("app_type");
            this.a.aCG = ((JSONObject)localObject).optString("login_tips");
            this.a.Cx = ((JSONObject)localObject).optLong("sub_appid");
            if (QLog.isColorLevel()) {
              QLog.d("QRLoginAuthActivity", 2, "ON CLOSE appType:" + this.a.appType + ",bannerTips:" + this.a.aCG + ",subappid:" + this.a.Cx);
            }
            if (this.a.mProgress.isShowing()) {
              this.a.mProgress.dismiss();
            }
            if (i != 0) {
              break;
            }
            this.a.bwT();
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
        this.a.sM(new String(paramMessage));
        return;
        if ((this.a.mProgress != null) && (this.a.mProgress.isShowing())) {
          this.a.mProgress.dismiss();
        }
        this.a.progressBar.setVisibility(8);
        this.a.fg.setVisibility(0);
        this.a.sM(null);
        return;
        label1303:
        m = 0;
        continue;
        label1309:
        k = 0;
      }
      label1315:
      i += n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rvg
 * JD-Core Version:    0.7.0.1
 */