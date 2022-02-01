import android.os.Message;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class iet
  extends ier
{
  protected void a(int paramInt, Header[] paramArrayOfHeader, Object paramObject)
  {
    if ((paramObject instanceof JSONObject))
    {
      a(paramInt, paramArrayOfHeader, (JSONObject)paramObject);
      return;
    }
    if ((paramObject instanceof JSONArray))
    {
      a(paramInt, paramArrayOfHeader, (JSONArray)paramObject);
      return;
    }
    a(new JSONException("Unexpected type " + paramObject.getClass().getName()), (JSONObject)null);
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONArray paramJSONArray) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject) {}
  
  public void a(Throwable paramThrowable, JSONArray paramJSONArray) {}
  
  public void a(Throwable paramThrowable, JSONObject paramJSONObject) {}
  
  protected void b(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    if (paramInt != 204) {
      try
      {
        sendMessage(obtainMessage(100, new Object[] { Integer.valueOf(paramInt), paramArrayOfHeader, i(paramString) }));
        return;
      }
      catch (JSONException paramArrayOfHeader)
      {
        f(paramArrayOfHeader, paramString);
        return;
      }
    }
    sendMessage(obtainMessage(100, new Object[] { Integer.valueOf(paramInt), new JSONObject() }));
  }
  
  protected void g(Throwable paramThrowable, String paramString)
  {
    if (paramString != null)
    {
      try
      {
        Object localObject = i(paramString);
        if ((localObject instanceof JSONObject))
        {
          a(paramThrowable, (JSONObject)localObject);
          return;
        }
        if ((localObject instanceof JSONArray))
        {
          a(paramThrowable, (JSONArray)localObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        c(paramThrowable, paramString);
        return;
      }
      c(paramThrowable, paramString);
      return;
    }
    c(paramThrowable, "");
  }
  
  protected void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    a(((Integer)paramMessage[0]).intValue(), (Header[])paramMessage[1], paramMessage[2]);
  }
  
  protected Object i(String paramString)
    throws JSONException
  {
    Object localObject = null;
    String str = paramString.trim();
    if (!str.startsWith("{"))
    {
      paramString = localObject;
      if (!str.startsWith("[")) {}
    }
    else
    {
      paramString = new JSONTokener(str).nextValue();
    }
    if (paramString == null) {
      return str;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iet
 * JD-Core Version:    0.7.0.1
 */