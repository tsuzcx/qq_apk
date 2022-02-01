import com.tencent.viola.adapter.IJSApiAdapter.OnInovkeCallback;
import org.json.JSONObject;

class tur
  implements sfu
{
  IJSApiAdapter.OnInovkeCallback a;
  
  public tur(IJSApiAdapter.OnInovkeCallback paramOnInovkeCallback)
  {
    this.a = paramOnInovkeCallback;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (this.a != null) {
      this.a.callback(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tur
 * JD-Core Version:    0.7.0.1
 */