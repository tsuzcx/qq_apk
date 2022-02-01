import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajii
{
  public List<String> Df = new ArrayList();
  public String bRy = "";
  public boolean coO;
  
  public static ajii a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      ajii localajii = new ajii();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("mainswitch", 0) == 1) {}
      for (;;)
      {
        localajii.coO = bool;
        localajii.bRy = paramString.optString("qmcf", "");
        paramString = g(paramString.optJSONArray("black"));
        localajii.Df.addAll(paramString);
        return localajii;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("MultiAIOEntranceConfigProcessor", 2, "MultiAIOEntranceConfigData parse error", paramString);
    }
  }
  
  private static List<String> g(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            localArrayList.add(paramJSONArray.getString(i).trim());
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("MultiAIOEntranceConfigProcessor", 2, "MultiAIOEntranceConfigData processJsonArray error", localException);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public boolean aqN()
  {
    return this.coO;
  }
  
  public List<String> fG()
  {
    return this.Df;
  }
  
  public String xp()
  {
    return this.bRy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajii
 * JD-Core Version:    0.7.0.1
 */