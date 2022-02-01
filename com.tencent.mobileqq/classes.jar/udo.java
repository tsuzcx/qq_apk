import org.json.JSONObject;

class udo
  implements admy
{
  udo(udn paramudn) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    uqf.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onFailure: " + paramInt + " , " + paramString);
    udn.a(this.a, false);
    if (paramInt == 1) {
      udn.a(this.a);
    }
  }
  
  public void onPermission(int paramInt)
  {
    uqf.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onPermission: " + paramInt);
    udn.a(this.a, false);
    switch (paramInt)
    {
    default: 
      return;
    }
    udn.a(this.a);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    udn.a(this.a, false);
    if (paramJSONObject != null)
    {
      uqf.f("WSQQConnectAuthManager", "getOpenIdAndAccessToken onSuccess: " + paramJSONObject.toString());
      udn.a(this.a, paramJSONObject);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udo
 * JD-Core Version:    0.7.0.1
 */