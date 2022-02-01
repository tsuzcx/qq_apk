import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class kla
{
  public String Vb = "2";
  public String aba = "";
  public String abb = "";
  public String abc = "";
  public String abd = "";
  public String abe = "";
  public String abf = "";
  public String abg = "";
  public String abh = "";
  public String abj = "";
  public String abk = "";
  public String abl = "";
  public String abm = "";
  public String moreUrl = "";
  public String traceId = "";
  
  public static kla a(String paramString)
  {
    kla localkla = new kla();
    try
    {
      paramString = new JSONObject(paramString);
      localkla.abd = paramString.optString("game_id1");
      localkla.abe = paramString.optString("game_id2");
      localkla.abf = paramString.optString("game_id3");
      localkla.aba = paramString.optString("game_url1");
      localkla.abb = paramString.optString("game_url2");
      localkla.abc = paramString.optString("game_url3");
      localkla.abg = paramString.optString("game_title1");
      localkla.abh = paramString.optString("game_title2");
      localkla.abj = paramString.optString("game_title3");
      localkla.moreUrl = paramString.optString("more_btn_url");
      localkla.abk = paramString.optString("game_slot_type1");
      localkla.abl = paramString.optString("game_slot_type2");
      localkla.abm = paramString.optString("game_slot_type3");
      localkla.traceId = paramString.getString("trace_id");
      int i = paramString.optInt("obj_type");
      if (i != 0) {
        localkla.Vb = String.valueOf(i);
      }
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SmallMiniGameInfo", 2, "json error:" + paramString.getMessage());
    }
    return localkla;
    return localkla;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kla
 * JD-Core Version:    0.7.0.1
 */