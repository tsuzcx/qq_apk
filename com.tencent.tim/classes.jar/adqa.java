import java.util.LinkedHashMap;

public class adqa
{
  public LinkedHashMap<String, String> M = new LinkedHashMap();
  public String appName = "";
  public String appPath = "";
  public String appVer = "1.0.0.1";
  public String appView = "";
  public String bvd = "";
  public String contextName = "";
  public String extra = "";
  public String meta = "";
  public String title = "";
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof adqa)) {}
    do
    {
      return false;
      paramObject = (adqa)paramObject;
    } while ((!this.appName.equals(paramObject.appName)) || (!this.appView.equals(paramObject.appView)) || (!this.contextName.equals(paramObject.contextName)) || (!this.M.equals(paramObject.M)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqa
 * JD-Core Version:    0.7.0.1
 */