import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

final class ifa
  extends iet
{
  ifa(ier paramier) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramArrayOfHeader, paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("id");
      this.c.a(paramInt, paramArrayOfHeader, paramJSONObject);
      return;
    }
    catch (JSONException paramArrayOfHeader)
    {
      paramArrayOfHeader.printStackTrace();
    }
  }
  
  public void a(Throwable paramThrowable, JSONObject paramJSONObject)
  {
    super.a(paramThrowable, paramJSONObject);
    if ((paramThrowable != null) && (paramThrowable.getMessage() != null)) {
      this.c.c(paramThrowable, paramThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifa
 * JD-Core Version:    0.7.0.1
 */