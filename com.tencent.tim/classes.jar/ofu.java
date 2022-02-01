import org.json.JSONObject;

class ofu
  implements tzd
{
  ofu(oft paramoft) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    ooz.ca("WSQQConnectAuthManager", "getOpenIdAndAccessToken onFailure: " + paramInt + " , " + paramString);
    oft.a(this.b, false);
    if (paramInt == 1) {
      oft.a(this.b);
    }
  }
  
  public void onPermission(int paramInt)
  {
    ooz.ca("WSQQConnectAuthManager", "getOpenIdAndAccessToken onPermission: " + paramInt);
    oft.a(this.b, false);
    switch (paramInt)
    {
    default: 
      return;
    }
    oft.a(this.b);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    oft.a(this.b, false);
    if (paramJSONObject != null)
    {
      ooz.bZ("WSQQConnectAuthManager", "getOpenIdAndAccessToken onSuccess: " + paramJSONObject.toString());
      oft.a(this.b, paramJSONObject);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofu
 * JD-Core Version:    0.7.0.1
 */