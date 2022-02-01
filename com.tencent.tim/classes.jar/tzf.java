import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class tzf
{
  public static final JSONObject EMPTY = new JSONObject();
  
  public static JSONObject c(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle == null) {
      return EMPTY;
    }
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramBundle.get(str);
      Object localObject1 = localObject2;
      if ((localObject2 instanceof Bundle)) {
        localObject1 = c((Bundle)localObject2);
      }
      try
      {
        localJSONObject.put(str, localObject1);
      }
      catch (JSONException localJSONException) {}
      if (QLog.isColorLevel()) {
        QLog.e("APIParam", 2, localJSONException.getMessage(), localJSONException);
      }
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzf
 * JD-Core Version:    0.7.0.1
 */