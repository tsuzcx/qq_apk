import java.util.ArrayList;

public class kxz
{
  public boolean Tx = true;
  public String adD = "";
  public String adE = "";
  public String adF = "";
  public boolean aiJ;
  public int errorCode;
  public int height;
  public ArrayList<kxz> ko = new ArrayList();
  public long time;
  public String url = "";
  public String vid = "";
  public String videoReportInfo = "";
  public int videoType = 0;
  public int width;
  
  public boolean aN(long paramLong)
  {
    return (paramLong - this.time > 0L) && (paramLong - this.time < 25200L);
  }
  
  public boolean q(long paramLong1, long paramLong2)
  {
    return (paramLong1 - this.time > 0L) && (paramLong1 - this.time < paramLong2);
  }
  
  public String toString()
  {
    return "VidUrl {\n vid: " + this.vid + "\n url: " + this.url + "\n isH265: " + this.aiJ + "\n fileBitRate: " + this.adD + "\n isHWCodec: " + this.Tx + "\n videoReportInfo:" + this.videoReportInfo + "\n speedList:" + this.adE + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kxz
 * JD-Core Version:    0.7.0.1
 */