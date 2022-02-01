import java.util.Date;
import java.util.List;
import org.json.JSONObject;

public class yho
{
  private yho.a a;
  
  public yho(yho.a parama)
  {
    this.a = parama;
  }
  
  public void aB(JSONObject paramJSONObject) {}
  
  public List<String> cO()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.sF;
  }
  
  public String getName()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.aXV;
  }
  
  public String getTitle()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.title;
  }
  
  public String pC()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.aXU;
  }
  
  public String pD()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.aXW;
  }
  
  public static class a
  {
    String aXU;
    String aXV;
    String aXW;
    int bZc;
    Date e;
    List<String> sF;
    Date startDate;
    String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yho
 * JD-Core Version:    0.7.0.1
 */