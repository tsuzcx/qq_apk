import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aesw
{
  private int cOR;
  private int cOS = 1;
  private int cOT = 1;
  private int cOU = 1;
  private int cOV = 1;
  private int cOW = 1;
  private ArrayMap<String, ArrayList<aesw.a>> j = new ArrayMap(5);
  
  public static aesw a()
  {
    return (aesw)aeif.a().o(432);
  }
  
  public static aesw a(aeic paramaeic)
  {
    int i = 0;
    aesw localaesw = new aesw();
    if (paramaeic != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramaeic = new JSONObject(paramaeic.content);
        int k = paramaeic.optInt("switch", 0);
        int m = paramaeic.optInt("ftsEnableMsgSwitch", 1);
        int n = paramaeic.optInt("showMessageResult", 1);
        int i1 = paramaeic.optInt("ftsEnableSwitch", 1);
        int i2 = paramaeic.optInt("ftsEnableTroopSwitch", 1);
        int i3 = paramaeic.optInt("ftsEnableFtsFilter", 1);
        localaesw.Mf(k);
        localaesw.Mg(m);
        localaesw.Mh(n);
        localaesw.cOT = i1;
        localaesw.cOV = i2;
        localaesw.cOW = i3;
        paramaeic = paramaeic.optJSONArray("templateinfo");
        if (paramaeic != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          k = paramaeic.length();
          if (i >= k) {
            break label375;
          }
          JSONObject localJSONObject = paramaeic.optJSONObject(i);
          if (localJSONObject == null) {
            break label396;
          }
          aesw.a locala = new aesw.a();
          locala.cOX = localJSONObject.optInt("templateid");
          locala.bAV = localJSONObject.optString("templatetype");
          locala.bAX = localJSONObject.optString("templatever");
          locala.bAW = localJSONObject.optString("templatename");
          locala.bAY = localJSONObject.optString("templateview");
          if ("ark".equals(locala.bAV)) {
            localArrayList1.add(locala);
          } else if ("native".equals(locala.bAV)) {
            localArrayList2.add(locala);
          }
        }
      }
      catch (Exception paramaeic)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramaeic.toString());
        }
      }
      return localaesw;
      label375:
      localaesw.t("ark", localArrayList1);
      localaesw.t("native", localArrayList2);
      return localaesw;
      label396:
      i += 1;
    }
  }
  
  public ArrayList<aesw.a> I(String paramString)
  {
    if (this.j != null) {
      return (ArrayList)this.j.get(paramString);
    }
    return null;
  }
  
  void Mf(int paramInt)
  {
    this.cOR = paramInt;
  }
  
  void Mg(int paramInt)
  {
    this.cOU = paramInt;
  }
  
  void Mh(int paramInt)
  {
    this.cOS = paramInt;
  }
  
  public boolean ahG()
  {
    return this.cOR == 1;
  }
  
  public boolean ahH()
  {
    return this.cOT == 1;
  }
  
  public boolean ahI()
  {
    return this.cOV == 1;
  }
  
  public boolean ahJ()
  {
    return this.cOW == 1;
  }
  
  public boolean ahK()
  {
    return this.cOU == 1;
  }
  
  public boolean ahL()
  {
    return this.cOS == 1;
  }
  
  void t(String paramString, ArrayList<aesw.a> paramArrayList)
  {
    if ((this.j != null) && (paramString != null)) {
      this.j.put(paramString, paramArrayList);
    }
  }
  
  public String toString()
  {
    int i = this.cOR;
    if (this.j != null) {}
    for (String str = this.j.toString();; str = "null") {
      return String.format("mRichSwitch:%d  templateData:%s", new Object[] { Integer.valueOf(i), str });
    }
  }
  
  public static class a
  {
    public String bAV;
    public String bAW;
    public String bAX;
    public String bAY;
    public int cOX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesw
 * JD-Core Version:    0.7.0.1
 */