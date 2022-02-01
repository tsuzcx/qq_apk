import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ubb
  extends uaz
{
  private boolean a(tzd paramtzd)
  {
    Object localObject = null;
    if ((this.a.a() instanceof ardm.k)) {
      localObject = (ardm.k)this.a.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((ardm.k)localObject).b();
    if (localObject == null) {
      return false;
    }
    ((svi)localObject).a(paramtzd);
    return true;
  }
  
  private boolean p(JSONObject paramJSONObject)
  {
    ardm.k localk = null;
    if ((this.a.a() instanceof ardm.k)) {
      localk = (ardm.k)this.a.a();
    }
    if (localk == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.b.a().appName;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.b.a().bQF);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localk.a(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (p(paramJSONObject)) {
        ubu.a(paramtzd, tzf.EMPTY);
      }
      break;
    }
    for (;;)
    {
      return true;
      ubu.a(paramtzd, -1, "");
      continue;
      ubu.a(paramtzd, tzf.EMPTY);
      paramString = this.b.getActivity();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      ubu.a(paramtzd, tzf.EMPTY);
      continue;
      if (a(paramtzd)) {
        ubu.a(paramtzd, tzf.EMPTY);
      } else {
        ubu.a(paramtzd, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubb
 * JD-Core Version:    0.7.0.1
 */