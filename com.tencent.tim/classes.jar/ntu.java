import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

final class ntu
  implements ViolaBaseView.a
{
  public void bbs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "pre load all offline from net is fail");
    }
  }
  
  public void oD(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray = (JSONArray)paramString.get("preload_bids");
      int i = 0;
      while (i < localJSONArray.length())
      {
        ntp.a((String)localJSONArray.get(i), null);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "pre load all offline from net is success");
      }
      ntp.uin = kxm.getAccount();
      ntp.yi = System.currentTimeMillis();
      if (paramString.has("use_main")) {
        ntp.auK = ((Boolean)paramString.get("use_main")).booleanValue();
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ViolaAccessHelper", 2, "pre load all offline from net is exception:" + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntu
 * JD-Core Version:    0.7.0.1
 */