import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class altj
  extends alti
{
  public int act_id = 1001;
  public String bYf = "";
  public String path = "";
  
  private void D(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq reportRedInfo", 2, "path = " + paramString + "act_id == " + paramInt);
    }
    if (paramString == null) {
      return;
    }
    try
    {
      if (paramString.contains("\\.")) {}
      for (i = Integer.parseInt(paramString.split("\\.")[0]);; i = Integer.parseInt(paramString))
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          paramString = ((altq)paramQQAppInterface.getManager(36)).getAppInfoByPath(paramString);
          localJSONObject.put("service_type", 0);
          localJSONObject.put("act_id", paramInt);
          localJSONObject.put("obj_id", "");
          localJSONObject.put("pay_amt", 0);
          localJSONObject.put("service_id", i);
          ((altq)paramQQAppInterface.getManager(36)).h(paramString, localJSONObject.toString());
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        int i = 0;
      }
    }
  }
  
  private RedAppInfo a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq getRedPointInfo", 2, "path = " + paramString);
    }
    if ("7720.772004".equals(paramString)) {}
    for (paramString = aizy.b(paramQQAppInterface, paramString);; paramString = ((altq)paramQQAppInterface.getManager(36)).getAppInfoByPath(paramString)) {
      return altt.a(paramString);
    }
  }
  
  private void aA(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq clearRed", 2, "path = " + paramString);
    }
    ((altq)paramQQAppInterface.getManager(36)).OS(paramString);
  }
  
  public int Id()
  {
    return 1;
  }
  
  public void e(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("cmd");
    if ("getRedInfo".equals(localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + (String)localObject);
      }
      paramQQAppInterface = a(this.path, paramQQAppInterface);
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("redInfoResp", paramQQAppInterface);
      paramBundle.putBundle("keyResponse", (Bundle)localObject);
      super.doCallback(paramBundle);
    }
    do
    {
      return;
      if ("reportRedInfo".equals(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + (String)localObject);
        }
        D(paramQQAppInterface, this.path, this.act_id);
        return;
      }
    } while (!"clearRedInfo".equals(localObject));
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + (String)localObject);
    }
    aA(paramQQAppInterface, this.path);
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.path = paramBundle.getString("path");
    this.act_id = paramBundle.getInt("act_id");
    this.bYf = paramBundle.getString("reportPath");
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("path", this.path);
    paramBundle.putInt("act_id", this.act_id);
    paramBundle.putString("reportPath", this.bYf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altj
 * JD-Core Version:    0.7.0.1
 */