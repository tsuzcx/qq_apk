import QQWalletPay.ReqCheckChangePwdAuth;
import QQWalletPay.RespCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class acvt
  extends acuk
{
  private acvt.a a;
  private Dialog al;
  private ackf b;
  
  public acvt(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void Kl(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse("midas://open_modify_status?status=" + paramInt));
    if (this.context.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.context.startActivity(localIntent);
    }
    ((BaseActivity)this.context).finish();
  }
  
  private boolean acF()
  {
    if (!(this.context instanceof BaseActivity)) {
      return false;
    }
    if (this.attrs.containsKey("uin")) {}
    for (String str = (String)this.attrs.get("uin"); !str.equals(this.app.getCurrentAccountUin()); str = "")
    {
      cOE();
      return false;
    }
    cOF();
    return false;
  }
  
  private void cOE()
  {
    this.al = aqha.a(this.context, 2131694214, this.context.getString(2131694198), 2131694200, 2131694199, new acvu(this), new acvv(this));
    this.al.show();
  }
  
  private void cOF()
  {
    Object localObject;
    String str1;
    label50:
    String str2;
    label75:
    String str3;
    label101:
    String str4;
    if (this.attrs.containsKey("packageName"))
    {
      localObject = (String)this.attrs.get("packageName");
      if (!this.attrs.containsKey("signareMode")) {
        break label311;
      }
      str1 = (String)this.attrs.get("signareMode");
      if (!this.attrs.containsKey("appid")) {
        break label317;
      }
      str2 = (String)this.attrs.get("appid");
      if (!this.attrs.containsKey("timeStamp")) {
        break label323;
      }
      str3 = (String)this.attrs.get("timeStamp");
      if (!this.attrs.containsKey("resetWordMode")) {
        break label330;
      }
      str4 = (String)this.attrs.get("resetWordMode");
      label127:
      if (!this.attrs.containsKey("offerid")) {
        break label337;
      }
    }
    label311:
    label317:
    label323:
    label330:
    label337:
    for (String str5 = (String)this.attrs.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("QwalletModifyPassAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((acke)this.app.getBusinessHandler(42)).a((ReqCheckChangePwdAuth)localObject);
      this.a = new acvt.a(null);
      this.b = new ackf(this.a);
      this.app.addObserver(this.b);
      return;
      localObject = "";
      break;
      str1 = "";
      break label50;
      str2 = "";
      break label75;
      str3 = "";
      break label101;
      str4 = "";
      break label127;
    }
  }
  
  private void cOG()
  {
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.app.getCurrentAccountUin());
      localJSONObject.put("viewTag", "pswManage");
      if (!PayBridgeActivity.tenpay((Activity)this.context, localJSONObject.toString(), 5, "")) {}
      for (int i = 1;; i = 0)
      {
        Kl(i);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Kl(1);
    }
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acF();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QwalletModifyPassAction", 1, "doAction error: " + localException.getMessage());
      Ge("QwalletModifyPassAction");
    }
    return false;
  }
  
  class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1) {
        return;
      }
      if (acvt.a(acvt.this) != null)
      {
        acvt.a(acvt.this).cLZ();
        acvt.this.app.removeObserver(acvt.a(acvt.this));
      }
      if (paramMessage.arg1 != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QwalletModifyPassAction", 2, "msf return error ");
        }
        acvt.a(acvt.this, 1);
        return;
      }
      if ((paramMessage.obj instanceof RespCheckChangePwdAuth))
      {
        paramMessage = (RespCheckChangePwdAuth)paramMessage.obj;
        if (paramMessage.retCode == 0)
        {
          acvt.b(acvt.this);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QwalletModifyPassAction", 2, "server return error, errorCode: " + paramMessage.retCode + " errorMsg: " + paramMessage.retMsg);
        }
      }
      acvt.a(acvt.this, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvt
 * JD-Core Version:    0.7.0.1
 */