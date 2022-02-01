import org.json.JSONObject;

class udm
  implements adea
{
  udm(udl paramudl) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    upe.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onFailure: " + paramInt + " , " + paramString);
    udl.a(this.a, false);
    if (paramInt == 1) {
      udl.a(this.a);
    }
  }
  
  public void onPermission(int paramInt)
  {
    upe.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onPermission: " + paramInt);
    udl.a(this.a, false);
    switch (paramInt)
    {
    default: 
      return;
    }
    udl.a(this.a);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    udl.a(this.a, false);
    if (paramJSONObject != null)
    {
      upe.f("WSQQConnectAuthManager", "getOpenIdAndAccessToken onSuccess: " + paramJSONObject.toString());
      udl.a(this.a, paramJSONObject);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     udm
 * JD-Core Version:    0.7.0.1
 */