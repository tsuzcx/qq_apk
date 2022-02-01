import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import org.json.JSONException;
import org.json.JSONObject;

class obv
  implements aqnt.a
{
  obv(obu paramobu) {}
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    paramString = new JSONObject();
    if (paramInt1 == 8) {}
    for (;;)
    {
      try
      {
        paramString.put("retCode", -1);
        paramString.put("msg", "fail");
        paramString.put("localId", this.this$0.lh());
        if (this.this$0.mRuntime.getWebView() != null) {
          this.this$0.mRuntime.getWebView().callJs(obw.apw, new String[] { paramString.toString() });
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2F", "0X8005D2F", 0, 0, "1", "", "", "");
        if (this.this$0.a != null) {
          this.this$0.a.release();
        }
        this.this$0.a = null;
        return;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      if (paramInt1 == 4) {
        try
        {
          paramString.put("retCode", 0);
          paramString.put("localId", this.this$0.lh());
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2) {}
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obv
 * JD-Core Version:    0.7.0.1
 */