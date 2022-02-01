import java.util.ArrayList;
import java.util.List;

public abstract interface aszv
{
  public static class a
  {
    public String cGo = "";
    public String cGp = "";
    public String cGq = "";
    public String cGr = "";
    public String cGs = "";
    public String extraInfo = "";
    public String fileName = "";
    public String filePath = "";
    public long fileSize = 0L;
    public long reportId = 0L;
    public String strategy = "";
    public int updateFlag = 4;
  }
  
  public static class b
  {
    public List<aszv.a> Ki = new ArrayList();
    public List<aszv.a> Kj = new ArrayList();
    public List<aszv.a> Kk = new ArrayList();
    public long axN;
    public long axO;
    public long axP;
    public long axQ = 0L;
    public long axR = 0L;
    public long businessId;
    public String cGt = "";
    public String cGu = "";
    public String cGv = "";
    public String cGw = "";
    public boolean dgP;
    public boolean dgQ;
    public boolean dgR;
    public int eot = 0;
    public String minQQVersion = "";
    public String os = "";
    public String packageName = "";
    public long sectionId;
    public int state = 1;
    
    public void esP()
    {
      this.state = 6;
    }
    
    public boolean isDone()
    {
      return this.state == 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszv
 * JD-Core Version:    0.7.0.1
 */