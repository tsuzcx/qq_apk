package cooperation.qlink;

import ahbf;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class QlAndQQInterface
{
  public static String cKP = "TRANS_DATA";
  
  public static class DailogClickInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public int type;
    
    public DailogClickInfo(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  public static class InsertFMFileInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public boolean bSend;
    public String filePath;
    public int fileType = -1;
    public long sessionId;
    public String thumbPath;
    public int transSeq;
    public String uin;
    
    public InsertFMFileInfo(String paramString1, boolean paramBoolean, long paramLong, String paramString2, String paramString3, int paramInt)
    {
      this.uin = paramString1;
      this.bSend = paramBoolean;
      this.sessionId = paramLong;
      this.filePath = ahbf.getRealPath(paramString2);
      this.thumbPath = paramString3;
      this.transSeq = paramInt;
    }
  }
  
  public static class ReportInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public Serializable data;
    public int type;
  }
  
  public static class ReportPerformanceInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public long mDuration;
    public HashMap<String, String> mParams;
    public long mSize;
    public boolean mSuccess;
    public String mTagName;
    public String mUin;
    
    public ReportPerformanceInfo(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
    {
      this.mUin = paramString1;
      this.mTagName = paramString2;
      this.mSuccess = paramBoolean;
      this.mDuration = paramLong1;
      this.mSize = paramLong2;
      this.mParams = paramHashMap;
    }
  }
  
  public static class SendFileInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public String filePath;
    public long fileSize;
    public int msgseq;
    public int msgtime;
    public long msguid;
    public long sessionid;
  }
  
  public static class SendFileInfos
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public ArrayList<QlAndQQInterface.SendFileInfo> infos = new ArrayList();
    public String strUin;
  }
  
  public static class UserInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public boolean isFriend;
    public String nick;
    public String uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qlink.QlAndQQInterface
 * JD-Core Version:    0.7.0.1
 */