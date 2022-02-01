import org.json.JSONObject;

public abstract interface tzd
{
  public abstract void onComplete();
  
  public abstract void onFailure(int paramInt, String paramString);
  
  public abstract void onPermission(int paramInt);
  
  public abstract void onSuccess(JSONObject paramJSONObject);
  
  public abstract void onTrigger(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzd
 * JD-Core Version:    0.7.0.1
 */