import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aepf
{
  private ArrayList<aepf.a> vN = new ArrayList(3);
  
  public static aepf a(aeic paramaeic)
  {
    aepf localaepf = new aepf();
    if (paramaeic != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramaeic = new JSONObject(paramaeic.content).optJSONArray("appList");
        if (paramaeic != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramaeic.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramaeic.optJSONObject(i);
            if (localJSONObject == null) {
              break label298;
            }
            aepf.a locala = new aepf.a();
            locala.id = localJSONObject.optLong("appID");
            locala.type = localJSONObject.optString("type");
            locala.bAr = localJSONObject.optString("bgBeginColor");
            locala.bAs = localJSONObject.optString("bgEndColor");
            locala.title = localJSONObject.optString("title");
            locala.subTitle = localJSONObject.optString("subTitle");
            locala.bAs = localJSONObject.optString("bgEndColor");
            locala.iconUrl = localJSONObject.optString("icon");
            locala.bAt = localJSONObject.optString("schemeOrUrl");
            locala.bv = localJSONObject.optJSONObject("extra");
            localArrayList.add(locala);
            break label298;
          }
          localaepf.eb(localArrayList);
        }
      }
      catch (Exception paramaeic)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramaeic.toString());
        return localaepf;
      }
      return localaepf;
      label298:
      i += 1;
    }
  }
  
  private void eb(ArrayList<aepf.a> paramArrayList)
  {
    this.vN = paramArrayList;
  }
  
  public ArrayList<aepf.a> cT()
  {
    return this.vN;
  }
  
  public static class a
  {
    public String bAr;
    public String bAs;
    public String bAt;
    public JSONObject bv;
    public String iconUrl;
    public long id;
    public String subTitle;
    public String title;
    public String type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepf
 * JD-Core Version:    0.7.0.1
 */