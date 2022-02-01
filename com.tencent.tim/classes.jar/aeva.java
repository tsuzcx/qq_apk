import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class aeva
{
  private int cPp = -1;
  private final Map<String, String> mConfig = new HashMap();
  
  public static aeva a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0))
    {
      QLog.e("TdsReaderView_TdsReaderGrayConfigBean", 1, "parse error, confFiles is no-valid.");
      return null;
    }
    aeva localaeva = new aeva();
    int k = paramArrayOfaeic.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        Object localObject1 = paramArrayOfaeic[i];
        try
        {
          localObject1 = new JSONObject(((aeic)localObject1).content);
          if (localObject1 != null)
          {
            if (((JSONObject)localObject1).has("is_enable"))
            {
              if (((JSONObject)localObject1).optBoolean("is_enable"))
              {
                j = 1;
                localaeva.cPp = j;
              }
            }
            else {
              aeuy.b((JSONObject)localObject1, localaeva.mConfig);
            }
          }
          else {
            i += 1;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("TdsReaderView_TdsReaderGrayConfigBean", 1, "parse error", localJSONException);
            Object localObject2 = null;
            continue;
            int j = 0;
          }
        }
      }
    }
    return localaeva;
  }
  
  public static void a(boolean paramBoolean, aeva paramaeva)
  {
    paramBoolean = true;
    if (paramaeva == null) {
      QLog.w("TdsReaderView_TdsReaderGrayConfigBean", 1, "source error, configBean is null.");
    }
    do
    {
      return;
      if (!paramaeva.mConfig.isEmpty()) {
        TdsReaderGlobal.c(true, paramaeva.mConfig);
      }
    } while (paramaeva.cPp == -1);
    if (paramaeva.cPp == 1) {}
    for (;;)
    {
      TdsReaderGlobal.setEnable(paramBoolean);
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeva
 * JD-Core Version:    0.7.0.1
 */