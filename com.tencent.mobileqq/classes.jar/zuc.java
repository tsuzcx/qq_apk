import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class zuc
  extends ztz
{
  private boolean a(JSONObject paramJSONObject)
  {
    bber localbber = null;
    if ((this.jdField_a_of_type_Zua.a() instanceof bber)) {
      localbber = (bber)this.jdField_a_of_type_Zua.a();
    }
    if (localbber == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_Zrw.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_Zrw.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localbber.a(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  private boolean a(zrt paramzrt)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_Zua.a() instanceof bber)) {
      localObject = (bber)this.jdField_a_of_type_Zua.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((bber)localObject).a();
    if (localObject == null) {
      return false;
    }
    ((xdt)localObject).a(paramzrt);
    return true;
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull zrt paramzrt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        zva.a(paramzrt, zrv.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      zva.a(paramzrt, -1, "");
      continue;
      zva.a(paramzrt, zrv.a);
      paramString = this.jdField_a_of_type_Zrw.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      zva.a(paramzrt, zrv.a);
      continue;
      if (a(paramzrt)) {
        zva.a(paramzrt, zrv.a);
      } else {
        zva.a(paramzrt, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zuc
 * JD-Core Version:    0.7.0.1
 */