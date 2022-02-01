import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class axdd
{
  public List<String> Mu;
  public String cTN = "default";
  public int eEC = 6;
  public int esM = 3;
  
  public axdd()
  {
    this.Mu = new ArrayList();
  }
  
  public axdd(List<String> paramList, String paramString, JSONObject paramJSONObject)
  {
    this.Mu = paramList;
    this.cTN = paramString;
    if (paramJSONObject != null)
    {
      cl(paramJSONObject);
      return;
    }
    this.esM = 3;
    this.eEC = 6;
  }
  
  public void cl(JSONObject paramJSONObject)
  {
    try
    {
      if (this.cTN != null) {}
      for (paramJSONObject = paramJSONObject.getJSONObject(this.cTN);; paramJSONObject = paramJSONObject.getJSONObject("default"))
      {
        this.esM = paramJSONObject.getInt("wordNum");
        this.eEC = paramJSONObject.getInt("pendantNum");
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdd
 * JD-Core Version:    0.7.0.1
 */