import android.os.Bundle;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class jsq
  implements aprb.a
{
  jsq(jsp paramjsp) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    jsp.a(this.a);
    String str = "";
    long l = 0L;
    Object localObject1 = "";
    if (paramBundle != null)
    {
      l = paramBundle.getLong("time", 0L);
      str = paramBundle.getString("room_id");
      localObject1 = paramBundle.getString("friendUin");
    }
    localObject1 = this.a.a((String)localObject1, l);
    if (paramJSONObject == null)
    {
      jsp.b(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(false), localObject1, paramBundle });
      return;
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(false), null, paramBundle });
          return;
          Object localObject2 = paramJSONObject.optJSONObject("result");
          if ((localObject2 != null) && (((JSONObject)localObject2).optInt("retcode") == 0))
          {
            paramJSONObject = new ArrayList();
            localObject2 = ((JSONObject)localObject2).optJSONArray("videoURLList");
            if (localObject2 != null)
            {
              int i = 0;
              for (;;)
              {
                if (i < ((JSONArray)localObject2).length()) {
                  try
                  {
                    paramJSONObject.add(((JSONArray)localObject2).getString(i));
                    i += 1;
                  }
                  catch (JSONException localJSONException)
                  {
                    for (;;)
                    {
                      localJSONException.printStackTrace();
                    }
                  }
                }
              }
              ((jsp.a)localObject1).fM = paramJSONObject;
              ((jsp.a)localObject1).roomId = str;
            }
            this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(true), localObject1, paramBundle });
          }
        }
      } while (paramJSONObject.optInt("retcode") != 0);
      paramJSONObject = paramJSONObject.optJSONObject("result");
    } while (paramJSONObject == null);
    ((jsp.a)localObject1).state = paramJSONObject.optInt("state");
    this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(true), localObject1, paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsq
 * JD-Core Version:    0.7.0.1
 */