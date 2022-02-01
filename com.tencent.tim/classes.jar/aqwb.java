import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;

public class aqwb
{
  private AppRuntime app;
  
  public aqwb(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void a(Intent paramIntent, String paramString, aqwb.c paramc)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      if (paramc != null) {
        paramc.a(paramIntent, false, paramString, null, null);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isDevelopLevel()) {
        aqwc.h("LHLoginMng -- lockLH", paramIntent);
      }
      Object localObject2 = paramIntent.getStringExtra("key_register_smscode");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject3 = paramIntent.getStringExtra("key_register_nick");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      String str = paramIntent.getStringExtra("key_register_password");
      localObject3 = str;
      if (str == null) {
        localObject3 = "";
      }
      boolean bool = paramIntent.getBooleanExtra("key_register_chose_bind_phone", false);
      if (bool)
      {
        paramIntent = new aqwb.b(paramIntent, paramString, paramc);
        ((WtloginManager)this.app.getManager(1)).RegGetSMSVerifyLoginAccountWithLH(((String)localObject1).getBytes(), ((String)localObject2).getBytes(), paramString, "3.4.4", paramIntent);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "lockLH, lhUin: %s, isBindPhoneNum: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
        return;
        paramIntent = new aqwb.a(paramIntent, paramString, paramc);
        paramc = (AccountManager)this.app.getManager(0);
        akwp.a().b(this.app, false);
        paramc.sendRegisterBySetPassWithLH((String)localObject3, (String)localObject2, (String)localObject1, paramString, false, "3.4.4", paramIntent);
      }
    }
  }
  
  static class a
    extends AccountObserver
  {
    final aqwb.c a;
    final String cyl;
    final Intent intent;
    
    a(Intent paramIntent, String paramString, aqwb.c paramc)
    {
      this.intent = paramIntent;
      this.cyl = paramString;
      this.a = paramc;
    }
    
    public void onRegisterCommitPassRespWithLhSig(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      Intent localIntent = new Intent(this.intent);
      if (paramArrayOfByte2 != null) {}
      for (;;)
      {
        try
        {
          paramArrayOfByte2 = new String(paramArrayOfByte2, "utf-8");
          if (QLog.isDevelopLevel()) {
            QLog.i("LHLoginMng", 4, String.format(Locale.getDefault(), "onRegisterCommitPassRespWithLhSig isSuccess: %s, code: %s, uin: %s, error: %s, contactSig: %s, lhsig: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString, paramArrayOfByte2, MD5.toMD5(paramArrayOfByte1), MD5.toMD5(paramArrayOfByte3) }));
          }
          if (paramInt != 0) {
            break label311;
          }
          paramBoolean = true;
          if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.cyl))) {
            break label283;
          }
          paramBoolean = false;
          if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0)) {
            break label298;
          }
          paramBoolean = false;
          if (!TextUtils.isEmpty(paramArrayOfByte2)) {
            break label316;
          }
          paramString = BaseApplicationImpl.getContext().getString(2131717096);
          localIntent.putExtra("key_register_prompt_info", paramString);
          if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0)) {
            localIntent.putExtra("key_register_lhsig", paramArrayOfByte3);
          }
          if (QLog.isDevelopLevel()) {
            aqwc.h("LHLoginMng -- onRegisterCommitPassRespWithLhSig", localIntent);
          }
          if (this.a != null) {
            this.a.a(localIntent, paramBoolean, this.cyl, paramArrayOfByte3, paramString);
          }
          if (QLog.isColorLevel()) {
            QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "onRegisterCommitPassRespWithLhSig, lhUin: %s, isSuc: %s, error: %s, code: %s", new Object[] { this.cyl, Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
          }
          return;
        }
        catch (UnsupportedEncodingException paramArrayOfByte2)
        {
          paramArrayOfByte2.printStackTrace();
        }
        paramArrayOfByte2 = null;
        continue;
        label283:
        localIntent.putExtra("uin", this.cyl);
        continue;
        label298:
        localIntent.putExtra("key_register_sign", paramArrayOfByte1);
        continue;
        label311:
        paramBoolean = false;
        continue;
        label316:
        paramString = paramArrayOfByte2;
      }
    }
  }
  
  static class b
    extends WtloginObserver
  {
    final aqwb.c a;
    final String cyl;
    final Intent intent;
    
    b(Intent paramIntent, String paramString, aqwb.c paramc)
    {
      this.intent = paramIntent;
      this.cyl = paramString;
      this.a = paramc;
    }
    
    public void OnRegGetSMSVerifyLoginAccountWithLhSig(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    {
      Intent localIntent = new Intent(this.intent);
      if (paramArrayOfByte3 != null) {}
      label295:
      label310:
      label323:
      label329:
      for (;;)
      {
        try
        {
          paramArrayOfByte1 = new String(paramArrayOfByte3, "utf-8");
          if (QLog.isDevelopLevel()) {
            QLog.i("LHLoginMng", 4, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccountWithLhSig ret: %s, uin: %s, error: %s, contactssig: %s, lhsig: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramArrayOfByte1, MD5.toMD5(paramArrayOfByte2), MD5.toMD5(paramArrayOfByte4) }));
          }
          if (paramInt != 0) {
            break label323;
          }
          bool = true;
          paramArrayOfByte3 = String.valueOf(paramLong);
          if ((!TextUtils.isEmpty(paramArrayOfByte3)) && (paramArrayOfByte3.equals(this.cyl))) {
            break label295;
          }
          bool = false;
          if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
            break label310;
          }
          bool = false;
          if (!TextUtils.isEmpty(paramArrayOfByte1)) {
            break label329;
          }
          paramArrayOfByte1 = BaseApplicationImpl.getContext().getString(2131717096);
          localIntent.putExtra("key_register_prompt_info", paramArrayOfByte1);
          if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
            localIntent.putExtra("key_register_lhsig", paramArrayOfByte4);
          }
          if (QLog.isDevelopLevel()) {
            aqwc.h("LHLoginMng -- OnRegGetSMSVerifyLoginAccountWithLhSig", localIntent);
          }
          if (this.a != null) {
            this.a.a(localIntent, bool, this.cyl, paramArrayOfByte4, paramArrayOfByte1);
          }
          if (QLog.isColorLevel()) {
            QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccountWithLhSig, lhUin: %s, isSuc: %s, error: %s, ret: %s", new Object[] { this.cyl, Boolean.valueOf(bool), paramArrayOfByte1, Integer.valueOf(paramInt) }));
          }
          return;
        }
        catch (UnsupportedEncodingException paramArrayOfByte1)
        {
          paramArrayOfByte1.printStackTrace();
        }
        paramArrayOfByte1 = null;
        continue;
        localIntent.putExtra("uin", this.cyl);
        continue;
        localIntent.putExtra("key_register_sign", paramArrayOfByte2);
        continue;
        boolean bool = false;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(Intent paramIntent, boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwb
 * JD-Core Version:    0.7.0.1
 */