import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class aeut
{
  private int cPp = -1;
  private final List<String> ze = new ArrayList();
  
  public static aeut a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0))
    {
      QLog.e("TencentDocUrl2DocConfigBean", 1, "parse error, confFiles is no-valid.");
      return null;
    }
    aeut localaeut = new aeut();
    int k = paramArrayOfaeic.length;
    int i = 0;
    while (i < k)
    {
      Object localObject1 = paramArrayOfaeic[i];
      try
      {
        localObject1 = new JSONObject(((aeic)localObject1).content);
        if ((localObject1 != null) && (((JSONObject)localObject1).has("url_2_doc_enable")))
        {
          if (((JSONObject)localObject1).optBoolean("url_2_doc_enable"))
          {
            j = 1;
            localaeut.cPp = j;
          }
        }
        else
        {
          if ((localObject1 == null) || (!((JSONObject)localObject1).has("support_host"))) {
            break label189;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("support_host");
          if (localObject1 == null) {
            break label189;
          }
          j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            String str = ((JSONArray)localObject1).optString(j);
            if (!TextUtils.isEmpty(str)) {
              localaeut.ze.add(str);
            }
            j += 1;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("TencentDocUrl2DocConfigBean", 1, "parse error", localJSONException);
          Object localObject2 = null;
          continue;
          int j = 0;
        }
        label189:
        i += 1;
      }
    }
    return localaeut;
  }
  
  public boolean isEnable()
  {
    return this.cPp == 1;
  }
  
  public boolean lL(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (this.ze.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeut
 * JD-Core Version:    0.7.0.1
 */