import org.json.JSONObject;

public abstract interface zrt
{
  public abstract void onComplete();
  
  public abstract void onFailure(int paramInt, String paramString);
  
  public abstract void onPermission(int paramInt);
  
  public abstract void onSuccess(JSONObject paramJSONObject);
  
  public abstract void onTrigger(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zrt
 * JD-Core Version:    0.7.0.1
 */