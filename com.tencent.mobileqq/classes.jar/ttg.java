import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

public class ttg
  extends AccountObserver
{
  public ttg(RegisterActivity paramRegisterActivity) {}
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.c();
      QQToast.a(this.a.getApplicationContext(), "网络出错了", 1).a();
      return;
    }
    label159:
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        Object localObject;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          QLog.d("RegisterActivity", 2, "RegisterActivity onRegQueryAccountResp code = " + paramInt + ";strMsg = " + paramArrayOfByte);
          switch (paramInt)
          {
          default: 
            this.a.c();
            localObject = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              localObject = "出错了";
            }
            QQToast.a(this.a.getApplicationContext(), (CharSequence)localObject, 1).a();
            return;
          }
        }
        catch (Exception localException2)
        {
          break label159;
        }
        localException1 = localException1;
        paramArrayOfByte = null;
      }
    }
    this.a.a();
    return;
    this.a.c();
    this.a.b("该手机号码已绑定其他QQ号码", "注册成功后将解除该手机号码与原手机号码的绑定，并绑定新注册的QQ号码。");
    return;
    this.a.c();
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    return;
    this.a.c();
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.a.isFinishing()) {}
    do
    {
      return;
      this.a.c();
      if (!paramBoolean)
      {
        QQToast.a(this.a.getApplicationContext(), "网络出错了", 1).a();
        return;
      }
      switch (paramInt)
      {
      default: 
        QQToast.a(this.a.getApplicationContext(), "出错了", 1).a();
        return;
      case 0: 
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      case 2: 
        try
        {
          paramArrayOfByte2 = new String(paramArrayOfByte2, "utf-8");
        }
        catch (UnsupportedEncodingException paramArrayOfByte2)
        {
          try
          {
            for (;;)
            {
              paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
              if ((!TextUtils.isEmpty(paramArrayOfByte2)) && (!TextUtils.isEmpty(paramArrayOfByte1))) {
                break;
              }
              QQToast.a(this.a.getApplicationContext(), "出错了", 1).a();
              return;
              paramArrayOfByte2 = paramArrayOfByte2;
              paramArrayOfByte2.printStackTrace();
              paramArrayOfByte2 = null;
            }
          }
          catch (UnsupportedEncodingException paramArrayOfByte1)
          {
            for (;;)
            {
              paramArrayOfByte1.printStackTrace();
              paramArrayOfByte1 = localObject1;
            }
            this.a.c(paramArrayOfByte2, paramArrayOfByte1);
            return;
          }
        }
      case 1: 
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      case 3: 
        try
        {
          paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
          if (TextUtils.isEmpty(paramArrayOfByte1))
          {
            QQToast.a(this.a.getApplicationContext(), "出错了", 1).a();
            return;
          }
        }
        catch (UnsupportedEncodingException paramArrayOfByte1)
        {
          for (;;)
          {
            paramArrayOfByte1.printStackTrace();
            paramArrayOfByte1 = localObject2;
          }
          this.a.b(paramArrayOfByte1);
          return;
        }
      }
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
        if (!TextUtils.isEmpty(paramArrayOfByte1))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.post(new tth(this, paramArrayOfByte1));
          return;
        }
      }
      catch (Throwable paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "captcha url is empty");
  }
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool = true;
    if (this.a.isFinishing()) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.c();
      QQToast.a(this.a.getApplicationContext(), "网络出错了", 1).a();
      return;
    }
    paramString = new StringBuilder().append("RegisterActivity onRegisterCommitPassResp code = ").append(paramInt).append(";uin = ").append(paramString).append(";contactsig = ");
    if (paramArrayOfByte1 == null) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      QLog.d("RegisterActivity", 2, paramBoolean);
      if (paramInt != 0) {
        break;
      }
      return;
    }
  }
  
  public void onRegisterCommitSmsCodeResp(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.c();
      QQToast.a(this.a.getApplicationContext(), "网络出错了", 1).a();
      return;
    }
    if (paramInt == 0) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
    for (;;)
    {
      QLog.d("RegisterActivity", 2, "RegisterActivity onRegisterCommitSmsCodeResp code = " + paramInt);
      return;
      this.a.jdField_a_of_type_JavaLangString = "短信验证失败";
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    }
  }
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = 60000;
    if (this.a.isFinishing()) {}
    do
    {
      return;
      RegisterActivity.c(this.a);
      if (!paramBoolean)
      {
        RegisterActivity.d(this.a);
        QQToast.a(this.a.getApplicationContext(), "网络出错了", 1).a();
        return;
      }
      paramString1 = null;
      if (paramArrayOfByte != null) {}
      try
      {
        paramString1 = new String(paramArrayOfByte, "utf-8");
        QLog.d("RegisterActivity", 2, "zsw RegisterActivity onRegisterQuerySmsStatResp code = " + paramInt1 + ";strMsg = " + paramString1 + ";next_chk_time =" + paramInt2 + ";total_time_over =" + paramInt3);
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      if (paramInt1 == 0)
      {
        RegisterActivity.d(this.a);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
        return;
      }
    } while (paramInt1 != 4);
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 60000;
    }
    RegisterActivity.a(this.a, paramInt1 * 1000);
    if (paramInt3 <= 0) {}
    for (paramInt1 = i;; paramInt1 = paramInt3) {
      try
      {
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new tti(this), paramInt1 * 1000);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
  }
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.a(this.a.getApplicationContext(), "网络出错了", 1).a();
      return;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      QLog.d("RegisterActivity", 2, "RegisterActivity onRegisterSendResendSmsreqResp code = " + paramInt1 + ";strMsg = " + paramArrayOfByte + ";next_chk_time =" + paramInt2 + ";total_time_over =" + paramInt3);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ttg
 * JD-Core Version:    0.7.0.1
 */