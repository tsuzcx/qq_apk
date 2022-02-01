import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acvr
  extends acuk
{
  public acvr(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acC()
  {
    if (!TextUtils.isEmpty((CharSequence)this.attrs.get("appid"))) {
      mAppId = (String)this.attrs.get("appid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.attrs.get("openid"))) {
      mOpenId = (String)this.attrs.get("openid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.attrs.get("openkey"))) {
      cto = (String)this.attrs.get("openkey");
    }
    if ("true".equals(this.attrs.get("is_from_game"))) {
      return acD();
    }
    return acE();
  }
  
  private boolean acD()
  {
    Object localObject = (String)this.attrs.get("uin");
    if ((localObject == null) || ("".equals(localObject)) || (((String)localObject).length() < 5)) {
      return false;
    }
    localObject = TroopInfoActivity.c((String)localObject, 14);
    if (this.attrs.containsKey("appid")) {
      ((Bundle)localObject).putString("appid", (String)this.attrs.get("appid"));
    }
    if (this.attrs.containsKey("openid")) {
      ((Bundle)localObject).putString("openid", toBase64Decode(aqhv.mOpenId));
    }
    if (this.attrs.containsKey("openkey")) {
      ((Bundle)localObject).putString("openkey", (String)this.attrs.get("openkey"));
    }
    if (this.attrs.containsKey("is_from_game")) {
      ((Bundle)localObject).putString("is_from_game", (String)this.attrs.get("is_from_game"));
    }
    if (this.attrs.containsKey("guild_id")) {
      ((Bundle)localObject).putString("guild_id", (String)this.attrs.get("guild_id"));
    }
    if (this.attrs.containsKey("zone_id")) {
      ((Bundle)localObject).putString("zone_id", (String)this.attrs.get("zone_id"));
    }
    if (this.attrs.containsKey("role_id")) {
      ((Bundle)localObject).putString("role_id", (String)this.attrs.get("role_id"));
    }
    if (this.attrs.containsKey("gc")) {
      ((Bundle)localObject).putString("gc", (String)this.attrs.get("gc"));
    }
    apuh.a(this.context, (Bundle)localObject, 2);
    return true;
  }
  
  private boolean acE()
  {
    Intent localIntent = new Intent(this.context, QRJumpActivity.class);
    String str = (String)this.attrs.get("url");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.source;
    }
    localIntent.putExtra("url", (String)localObject);
    localObject = (String)this.attrs.get("attr_original_url");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localIntent.putExtra("attr_original_url", (String)localObject);
    }
    if ((this.context instanceof Activity))
    {
      localObject = ((Activity)this.context).getIntent();
      if ((localObject != null) && (((Intent)localObject).hasExtra("fromQrcode"))) {
        localIntent.putExtra("fromQrcode", ((Intent)localObject).getBooleanExtra("fromQrcode", false));
      }
    }
    this.context.startActivity(localIntent);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acC();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QrCodeAction", 1, "doAction error: " + localException.getMessage());
      Ge("QrCodeAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvr
 * JD-Core Version:    0.7.0.1
 */