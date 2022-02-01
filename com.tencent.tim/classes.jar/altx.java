import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.register.QueryAccount.2.1;
import com.tencent.mobileqq.register.QueryAccount.2.2;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

public class altx
  extends AccountObserver
{
  altx(altw paramaltw) {}
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "onRegQueryAccountResp isSuccess=" + paramBoolean + " code=" + paramInt);
    }
    if (this.this$0.a.isFinishing()) {
      return;
    }
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        QQAppInterface localQQAppInterface = this.this$0.app;
        if (paramBoolean)
        {
          localObject1 = Integer.toString(paramInt);
          if (paramArrayOfByte != null) {
            continue;
          }
          localObject2 = "";
          anot.a(localQQAppInterface, "new_reg", "reg_page", "next_clk", "", 1, "", (String)localObject1, "", (String)localObject2, "", "", "", "", "");
          if (paramBoolean) {
            continue;
          }
          this.this$0.a.gV();
          localObject1 = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            localObject1 = this.this$0.a.getString(2131717096);
          }
          this.this$0.a.cq((String)localObject1, 0);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
        continue;
        Object localObject1 = "-1001";
        continue;
        Object localObject2 = paramArrayOfByte;
        continue;
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          int i = paramArrayOfByte.indexOf("(");
          int j = paramArrayOfByte.indexOf(")");
          if ((i > 0) && (j > 0) && (i + 1 < j)) {
            altw.a(this.this$0, paramArrayOfByte.substring(i + 1, j));
          }
        }
        switch (paramInt)
        {
        case 4: 
        default: 
          this.this$0.a.gV();
          localObject1 = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            localObject1 = this.this$0.a.getResources().getString(2131717096);
          }
          this.this$0.a.cq((String)localObject1, 0);
          return;
        }
      }
      this.this$0.a.aRQ = false;
      this.this$0.a.aRR = true;
      this.this$0.OU(null);
      return;
      this.this$0.a.gV();
      this.this$0.a.aRQ = true;
      this.this$0.a.aRR = true;
      this.this$0.OU(null);
      return;
      altw.a(this.this$0);
      return;
      altw.a(this.this$0);
      return;
      this.this$0.a.gV();
      this.this$0.a.aRQ = true;
      this.this$0.a.aRR = false;
      this.this$0.OU(null);
      return;
      paramArrayOfByte = null;
    }
  }
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueryAccount", 2, "onRegisterCommitMobileResp");
    }
    if (paramArrayOfByte1 != null) {}
    for (;;)
    {
      String str1;
      try
      {
        str1 = new String(paramArrayOfByte1, "utf-8");
        if (!QLog.isColorLevel()) {
          break label122;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("QueryAccount", 2, "onRegisterCommitMobileResp code = " + paramInt + ";strMsg = " + str1);
          }
          if (!this.this$0.a.isFinishing()) {
            break label125;
          }
          return;
        }
        catch (Exception localException2)
        {
          break label90;
        }
        localException1 = localException1;
        str1 = null;
      }
      label90:
      QLog.d("QueryAccount", 2, "onRegisterCommitMobileResp strPromptInfo exception = " + localException1);
      label122:
      continue;
      label125:
      if (paramInt != 3) {
        this.this$0.a.gV();
      }
      if (paramArrayOfByte2 != null) {}
      try
      {
        new String(paramArrayOfByte2, "UTF-8");
        paramArrayOfByte2 = this.this$0.app;
        if (TextUtils.isEmpty(paramString))
        {
          i = 2;
          if (!paramBoolean) {
            break label350;
          }
          j = 0;
          anot.c(paramArrayOfByte2, "dc00898", "", "", "0X8009844", "0X8009844", i, j, "", "", "", "");
          QQAppInterface localQQAppInterface = this.this$0.app;
          if (!paramBoolean) {
            break label356;
          }
          paramArrayOfByte2 = Integer.toString(paramInt);
          if (!TextUtils.isEmpty(paramString)) {
            break label363;
          }
          paramString = "2";
          if (str1 != null) {
            break label370;
          }
          str2 = "";
          anot.a(localQQAppInterface, "new_reg", "reg_page", "next_msg", "", 1, "", paramArrayOfByte2, paramString, str2, "", "", "", "", "");
          if (paramBoolean) {
            break label377;
          }
          paramArrayOfByte1 = str1;
          if (TextUtils.isEmpty(str1)) {
            paramArrayOfByte1 = this.this$0.a.getString(2131717096);
          }
          this.this$0.a.cq(paramArrayOfByte1, 0);
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte2)
      {
        for (;;)
        {
          paramArrayOfByte2.printStackTrace();
        }
      }
      catch (Exception paramArrayOfByte2)
      {
        for (;;)
        {
          paramArrayOfByte2.printStackTrace();
          continue;
          int i = 1;
          continue;
          label350:
          int j = paramInt;
          continue;
          label356:
          paramArrayOfByte2 = "-1001";
          continue;
          label363:
          paramString = "1";
          continue;
          label370:
          String str2 = str1;
        }
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          label377:
          this.this$0.a.J(2131717096, 0);
          return;
        }
      }
      altw.a(this.this$0, 0, 0L);
      return;
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str1)))
      {
        this.this$0.a.J(2131717096, 0);
        return;
      }
      altw.a(this.this$0, str1);
      return;
      altw.a(this.this$0, 0, 0L);
      return;
      if (TextUtils.isEmpty(str1))
      {
        this.this$0.a.J(2131717096, 0);
        return;
      }
      altw.b(this.this$0, str1);
      this.this$0.a.gV();
      return;
      if (paramArrayOfByte1 != null)
      {
        try
        {
          paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
          if (!TextUtils.isEmpty(paramArrayOfByte1))
          {
            this.this$0.a.handler.post(new QueryAccount.2.1(this, paramArrayOfByte1));
            return;
          }
        }
        catch (Throwable paramArrayOfByte1)
        {
          paramArrayOfByte1.printStackTrace();
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("QueryAccount", 2, "captcha url is empty");
          return;
          paramArrayOfByte1 = new Intent(this.this$0.a, RegisterQQNumberActivity.class);
          paramArrayOfByte1.putExtra("phonenum", this.this$0.a.phoneNum);
          paramArrayOfByte1.putExtra("invite_code", this.this$0.a.aLv);
          paramArrayOfByte1.putExtra("key", this.this$0.a.countryCode);
          paramArrayOfByte1.putExtra("key_register_is_phone_num_registered", this.this$0.a.aRQ);
          paramArrayOfByte1.putExtra("key_register_has_pwd", this.this$0.a.aRR);
          paramArrayOfByte1.putExtra("key_register_result", false);
          this.this$0.dH(paramArrayOfByte1);
          this.this$0.a.startActivity(paramArrayOfByte1);
          return;
          if (TextUtils.isEmpty(str1))
          {
            QLog.e("QueryAccount", 1, "onRegisterCommitMobileResp, url is empty");
            this.this$0.a.runOnUiThread(new QueryAccount.2.2(this));
            return;
          }
          paramArrayOfByte1 = new Intent(this.this$0.a, QQBrowserActivity.class);
          paramArrayOfByte1.putExtra("selfSet_leftViewText", acfp.m(2131712622));
          paramArrayOfByte1.putExtra("url", str1);
          this.this$0.a.startActivity(paramArrayOfByte1);
          anot.a(this.this$0.app, "dc00898", "", "", "0X8009C5D", "0X8009C5D", 0, 0, "", "", this.this$0.a.phoneNum, "");
          return;
          str1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altx
 * JD-Core Version:    0.7.0.1
 */