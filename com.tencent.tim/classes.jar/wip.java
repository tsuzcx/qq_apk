import org.json.JSONObject;

public class wip
{
  @aiin("structmsg_switch")
  public int bNu;
  @aiin("structmsg_sampling")
  public int bNv;
  @aiin("structmsg_filternumber")
  public int bNw;
  @aiin("switch_background_start_activity")
  public int bNx;
  @aiin("switch_open_third_app")
  public int bNy;
  @aiin("switch_imei")
  public int bNz;
  @aiin("msf_http_monitor_ban")
  public boolean bcv;
  
  public JSONObject U()
  {
    return aiio.convert2JSONObject(this);
  }
  
  public String toString()
  {
    return U().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     wip
 * JD-Core Version:    0.7.0.1
 */