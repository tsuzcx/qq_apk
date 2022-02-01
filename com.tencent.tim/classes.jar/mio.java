import java.util.HashMap;

public class mio
{
  public String aiT;
  public boolean amQ;
  public long costTime;
  public boolean success;
  public long vW;
  public String vid;
  
  public HashMap<String, String> u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_vid", this.vid);
    localHashMap.put("param_success", String.valueOf(this.success).toLowerCase());
    localHashMap.put("param_costTime", String.valueOf(this.costTime));
    localHashMap.put("param_ret_code", String.valueOf(this.vW));
    localHashMap.put("param_err_info", this.aiT);
    localHashMap.put("param_retry", String.valueOf(this.amQ));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mio
 * JD-Core Version:    0.7.0.1
 */