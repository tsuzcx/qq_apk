import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.ReqBody;

public class uag
  extends tzh
{
  public static final String TAG = "DoraemonOpenAPI." + uag.class.getSimpleName();
  protected uaj a;
  protected uag.a b;
  
  private void e(JSONObject paramJSONObject, tzd paramtzd)
  {
    if (ubu.isMainProcess())
    {
      paramJSONObject = j();
      if (paramJSONObject != null)
      {
        ubu.a(paramtzd, tzf.c(paramJSONObject));
        return;
      }
      ubu.a(paramtzd, 1, "get user info error, try again");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG + ".requestUserInfo", 2, "not main process, send to main process");
    }
    tzj.a(1, null, new uah(this, paramtzd));
  }
  
  private void f(JSONObject paramJSONObject, tzd paramtzd)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG + ".requestAppFriends", 2, "url params = " + paramJSONObject);
    }
    paramJSONObject = new Oidb_0xb6e.ReqBody();
    paramJSONObject.appid.set(Integer.valueOf(this.jdField_b_of_type_Tzg.mAppid).intValue());
    paramJSONObject.openid.set(this.jdField_b_of_type_Uag$a.openid);
    paramJSONObject.openkey.set(this.jdField_b_of_type_Uag$a.openKey);
    paramJSONObject.platform.set("openmobile_android");
    jnm.a(BaseApplicationImpl.getApplication().getRuntime(), new uai(this, paramtzd), paramJSONObject.toByteArray(), "OidbSvc.0xb6e", 2926, 1, null, 0L);
  }
  
  public static Bundle j()
  {
    Object localObject1 = qem.getQQAppInterface();
    Object localObject2 = (acff)((QQAppInterface)localObject1).getManager(51);
    Object localObject3 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    localObject2 = ((acff)localObject2).b((String)localObject3);
    String str1;
    int i;
    if (localObject2 != null)
    {
      str1 = ((Card)localObject2).strNick;
      if (((Card)localObject2).shGender == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      String str2 = ((Card)localObject2).strCity;
      String str3 = ((Card)localObject2).strProvince;
      String str4 = ((Card)localObject2).strCountry;
      localObject2 = "";
      localObject3 = ((QQAppInterface)localObject1).b((String)localObject3);
      if ((localObject3 != null) && (!TextUtils.isEmpty(((Setting)localObject3).url))) {
        localObject1 = MsfSdkUtils.insertMtype("QQHeadIcon", ((FriendListHandler)((QQAppInterface)localObject1).getBusinessHandler(1)).a().a(((Setting)localObject3).url, ((Setting)localObject3).bFaceFlags, ((Setting)localObject3).bUsrType, 0));
      }
      for (;;)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("nickName", str1);
        ((Bundle)localObject2).putInt("gender", i);
        ((Bundle)localObject2).putString("avatarUrl", (String)localObject1);
        ((Bundle)localObject2).putString("city", str2);
        ((Bundle)localObject2).putString("province", str3);
        ((Bundle)localObject2).putString("country", str4);
        if (QLog.isDevelopLevel()) {
          QLog.i(TAG + ".getUserInfoDirectly", 2, ((Bundle)localObject2).toString());
        }
        return localObject2;
        if (((Card)localObject2).shGender != 1) {
          break label280;
        }
        i = 2;
        break;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i(TAG + ".getUserInfoDirectly", 2, "getUserInfo QQHeadSetting is empty");
          localObject1 = localObject2;
        }
      }
      return null;
      label280:
      i = 0;
    }
  }
  
  public uag.a a()
  {
    return this.jdField_b_of_type_Uag$a;
  }
  
  protected void a(uag.a parama)
  {
    this.jdField_b_of_type_Uag$a = parama;
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    case 17: 
    case 18: 
      do
      {
        do
        {
          return bool;
          if ((!isLogin()) || (ubp.aQQ)) {
            break;
          }
          ubu.a(paramtzd, this.jdField_b_of_type_Uag$a.S());
        } while (!QLog.isColorLevel());
        QLog.i(TAG + "." + paramString, 2, "has login, use cache: " + this.jdField_b_of_type_Uag$a.toString());
        return true;
        if (this.a == null) {
          this.a = new uaj(this.jdField_b_of_type_Tzg, this);
        }
        this.a.a(paramJSONObject, paramtzd, false);
        return true;
        if (!isLogin()) {
          break;
        }
        ubu.a(paramtzd, this.jdField_b_of_type_Uag$a.S());
      } while (!QLog.isColorLevel());
      QLog.i(TAG + "." + paramString, 2, "has login, use cache: " + this.jdField_b_of_type_Uag$a.toString());
      return true;
      if (this.a == null) {
        this.a = new uaj(this.jdField_b_of_type_Tzg, this);
      }
      this.a.a(paramJSONObject, paramtzd, true);
      return true;
    case 10: 
      if (!isLogin())
      {
        ubu.a(paramtzd, 5);
        return true;
      }
      e(paramJSONObject, paramtzd);
      return true;
    }
    if (!isLogin())
    {
      ubu.a(paramtzd, 5);
      return true;
    }
    f(paramJSONObject, paramtzd);
    return true;
  }
  
  public void destroy()
  {
    this.jdField_b_of_type_Uag$a = null;
  }
  
  public boolean isLogin()
  {
    return (this.jdField_b_of_type_Uag$a != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_Uag$a.openid)) && (!TextUtils.isEmpty(this.jdField_b_of_type_Uag$a.openKey));
  }
  
  public static final class a
  {
    public long expireIn;
    public long expireTime;
    public String openKey;
    public String openid;
    
    public JSONObject S()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("openid", this.openid);
        localJSONObject.put("access_token", this.openKey);
        localJSONObject.put("expire_in", this.expireIn);
        localJSONObject.put("expire_time", this.expireTime);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(uag.TAG, 2, localJSONException.getMessage(), localJSONException);
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      return "LoginInfo{, openid='" + this.openid + '\'' + ", access_token='" + this.openKey + '\'' + ", expireIn='" + this.expireIn + '\'' + ", expireTime='" + this.expireTime + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uag
 * JD-Core Version:    0.7.0.1
 */