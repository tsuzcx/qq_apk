import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aaay
{
  private SendHbActivity mActivity;
  
  public aaay(SendHbActivity paramSendHbActivity)
  {
    this.mActivity = paramSendHbActivity;
  }
  
  public void Z(Map<String, String> paramMap)
  {
    Object localObject = new JSONObject(paramMap);
    paramMap = this.mActivity.Z();
    paramMap.put("extra_data", ((JSONObject)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("json", new JSONObject(paramMap).toString());
    ((Bundle)localObject).putString("callbackSn", "0");
    ((Bundle)localObject).putLong("vacreport_key_seq", this.mActivity.mReportSeq);
    PayBridgeActivity.a(this.mActivity, 5, (Bundle)localObject);
  }
  
  public void ctq()
  {
    Map localMap = this.mActivity.Y();
    localMap.put("channel", this.mActivity.cfF + "");
    localMap.put("bus_type", "1");
    localMap.put("type", "1");
    Z(localMap);
  }
  
  public void dY(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    try
    {
      localJSONObject.put("userId", paramString2);
      localJSONObject.put("viewTag", "qrcodeHb");
      localJSONObject.put("comeForm", 1);
      paramString2 = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        paramString2.putOpt("qrToken", paramString1);
      }
      paramString2.putOpt("comeFrom", Integer.valueOf(1));
      localJSONObject.put("extra_data", paramString2.toString());
      paramString1 = new Bundle();
      paramString1.putString("json", localJSONObject.toString());
      paramString1.putString("callbackSn", "0");
      paramString1.putLong("vacreport_key_seq", this.mActivity.mReportSeq);
      PayBridgeActivity.a(this.mActivity, 5, paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static abstract class a
    implements TextWatcher
  {
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaay
 * JD-Core Version:    0.7.0.1
 */