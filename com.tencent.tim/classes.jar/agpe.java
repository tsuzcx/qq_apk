import java.util.HashMap;

public class agpe
{
  public long ZA;
  public long ZB;
  public long ZC;
  public long ZD;
  public String bIP;
  public int cYw;
  public int cYx;
  private int cYy = 3;
  
  public HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_Result", String.valueOf(this.ZA));
    localHashMap.put("param_SubReason", String.valueOf(this.ZB));
    localHashMap.put("param_XTFReceiverType", String.valueOf(this.cYw));
    localHashMap.put("param_Suffix", String.valueOf(this.bIP));
    localHashMap.put("param_TargetUin", String.valueOf(this.ZC));
    localHashMap.put("param_TargetType", String.valueOf(this.cYx));
    localHashMap.put("param_FileSize", String.valueOf(this.ZD));
    localHashMap.put("param_TranferPlatform", String.valueOf(this.cYy));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpe
 * JD-Core Version:    0.7.0.1
 */