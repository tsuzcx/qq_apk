import org.json.JSONObject;

class uke
  implements acjr
{
  uke(ukd paramukd) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    uya.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onFailure: " + paramInt + " , " + paramString);
    ukd.a(this.a, false);
    if (paramInt == 1) {
      ukd.a(this.a);
    }
  }
  
  public void onPermission(int paramInt)
  {
    uya.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onPermission: " + paramInt);
    ukd.a(this.a, false);
    switch (paramInt)
    {
    default: 
      return;
    }
    ukd.a(this.a);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    ukd.a(this.a, false);
    if (paramJSONObject != null)
    {
      uya.f("WSQQConnectAuthManager", "getOpenIdAndAccessToken onSuccess: " + paramJSONObject.toString());
      ukd.a(this.a, paramJSONObject);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uke
 * JD-Core Version:    0.7.0.1
 */