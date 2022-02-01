import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class avcs
{
  static Vector<avcs.a> V = new Vector();
  static JSONObject cl = new JSONObject();
  static EIPCResultCallback i = new avct();
  
  public static void ZH(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      int j;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("VipComicCommonConfig");
        if ((paramString != null) && (paramString.length() > 0))
        {
          j = 0;
          if (j < paramString.length())
          {
            Object localObject = paramString.optJSONObject(j);
            if ((localObject == null) || (!arcp.b((JSONObject)localObject, "VipComicCommonConfig"))) {
              break label118;
            }
            cl = (JSONObject)localObject;
            paramString = V.iterator();
            if (paramString.hasNext())
            {
              localObject = (avcs.a)paramString.next();
              if (localObject == null) {
                continue;
              }
              ((avcs.a)localObject).cd(cl);
              continue;
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.d("VipComicConfigHelper", 2, "parse config json file failed.", paramString);
      }
      label118:
      j += 1;
    }
  }
  
  public static int av(String paramString, int paramInt)
  {
    return cl.optInt(paramString, paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void cd(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcs
 * JD-Core Version:    0.7.0.1
 */