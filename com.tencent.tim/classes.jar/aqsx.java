import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqsx
  extends aqsm
{
  public static final aqsx a = new aqsx();
  private List<aqsx.a> fR;
  
  private ArrayList<aqsx.a> eb()
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(Cx()).getJSONArray("namePlateUrlConfig");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        aqsx.a locala = new aqsx.a();
        locala.vipType = localJSONObject.optString("vipType");
        locala.itemId = localJSONObject.optString("itemId");
        locala.cwJ = localJSONObject.optString("drawerUrl");
        locala.cwK = localJSONObject.optString("VaProfileUrl");
        locala.cwL = localJSONObject.optString("ctocUrl");
        locala.cwI = localJSONObject.optString("nameplateType");
        locala.cwM = localJSONObject.optString("VaProfileGuestUrl");
        locala.cwN = localJSONObject.optString("ctocGuestUrl");
        locala.cwO = localJSONObject.optString("ctocSettingUrl");
        locala.cwP = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(locala);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  String Cx()
  {
    try
    {
      String str = aqhq.readFileToString(new File(getSavePath(BaseApplicationImpl.getContext(), "namePlate_UrlConfig")));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public aqsx.a a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.fR == null) {}
    try
    {
      if (this.fR == null) {
        this.fR = eb();
      }
      Iterator localIterator = this.fR.iterator();
      while (localIterator.hasNext())
      {
        aqsx.a locala = (aqsx.a)localIterator.next();
        if ((locala.vipType.equals(String.valueOf(paramInt1))) && (locala.itemId.equals(String.valueOf(paramInt2))) && (locala.cwI.equals(String.valueOf(paramInt3)))) {
          return locala;
        }
      }
    }
    finally {}
    return null;
  }
  
  public boolean ad(QQAppInterface paramQQAppInterface, String paramString)
  {
    return super.isFileExists(paramQQAppInterface, getBID(), paramString);
  }
  
  public long getBID()
  {
    return 34L;
  }
  
  protected String getRootDir()
  {
    return "vipicon";
  }
  
  protected String getScidPrefix()
  {
    return "namePlate_UrlConfig";
  }
  
  protected boolean isZip_KeepZip()
  {
    return false;
  }
  
  public static class a
  {
    String cwI;
    public String cwJ;
    public String cwK;
    public String cwL;
    public String cwM;
    public String cwN;
    public String cwO;
    public String cwP;
    String itemId;
    String vipType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsx
 * JD-Core Version:    0.7.0.1
 */