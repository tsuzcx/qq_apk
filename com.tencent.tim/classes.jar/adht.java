import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adht
{
  public FaceStatus[] b;
  public String bsS;
  public String bsT;
  public String bsU;
  public int cGd;
  public int cGe;
  public int cGf;
  public int cGg;
  public ArrayList<adht.a> ur;
  
  public static boolean a(adht paramadht)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramadht != null)
    {
      bool1 = bool2;
      if (paramadht.cGd == 0)
      {
        bool1 = bool2;
        if (paramadht.cGe == 0) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARRspFaceResult", 2, "[ScanStarFace]isRecogSuccess result = " + bool1);
    }
    return bool1;
  }
  
  public String toString()
  {
    return "ARCloudRecogRspFaceResult{errCode_MQ=" + this.cGd + ", errMsg_MQ='" + this.bsS + '\'' + ", errCode_YT=" + this.cGe + ", errMsg_YT=" + this.bsT + ", time_ms_YT=" + this.cGf + ", group_size_YT=" + this.cGg + ", sessionID='" + this.bsU + '\'' + ", starInfoList=" + this.ur + ", faceStatus[]=" + this.b + '}';
  }
  
  public static class a
  {
    public String bsV;
    public String bsW;
    public String bsX;
    public String bsY;
    public float confidence;
    public int faceID;
    public String name;
    public long uin;
    
    public String toString()
    {
      return "StarInfo{faceID=" + this.faceID + ", uin=" + this.uin + ", name='" + this.name + '\'' + ", pinyin_name='" + this.bsV + '\'' + ", wiki='" + this.bsW + '\'' + ", wikiTitle='" + this.bsX + '\'' + ", wikiURL='" + this.bsY + '\'' + ", confidence='" + this.confidence + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adht
 * JD-Core Version:    0.7.0.1
 */