import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface;
import org.json.JSONObject;

public class zsx
  extends zrx
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull zrt paramzrt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 7: 
      SosoInterface.a(new zta(paramzrt, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
    for (;;)
    {
      return true;
      SosoInterface.a(new zsz(paramzrt, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zsx
 * JD-Core Version:    0.7.0.1
 */