import android.text.TextUtils;
import com.tencent.mobileqq.pic.ReportInfo;
import java.net.URL;

public class akxl
  extends akxh
{
  public String actMsgContentValue;
  public String action;
  public boolean bEnableEnc;
  public String bUH;
  public String bigMsgUrl;
  public int dpC;
  public int fileSizeFlag;
  public long groupFileID;
  public boolean isMixed;
  public boolean isShareAppActionMsg;
  public int issend;
  public String rawMsgUrl;
  public ReportInfo reportInfo;
  public long shareAppID;
  public long size;
  public int subMsgId;
  public String thumbMsgUrl;
  public long time;
  public String uuid;
  
  public boolean check()
  {
    if (TextUtils.isEmpty(this.uuid))
    {
      gT("PicDownloadInfo.check", "uuid invaid:" + this.uuid);
      return false;
    }
    if (this.selfUin == null)
    {
      gT("checkPicInfo", "selfUin invalid,selfUin:" + this.selfUin);
      return false;
    }
    if ((this.isMixed) && (this.shareAppID == 0L))
    {
      gT("PicDownloadInfo.check", "groupFileID invaid:" + this.shareAppID);
      return false;
    }
    return super.check();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicDownloadInfo");
    localStringBuilder.append("\n |-").append("md5:").append(this.md5);
    localStringBuilder.append("\n |-").append("uuid:").append(this.uuid);
    localStringBuilder.append("\n |-").append("groupFileID:").append(this.groupFileID);
    localStringBuilder.append("\n |-").append("uinType:").append(this.uinType);
    localStringBuilder.append("\n |-").append("subMsgId:").append(this.subMsgId);
    localStringBuilder.append("\n |-").append("subVersion:").append(this.subVersion);
    localStringBuilder.append("\n |-").append("protocol:").append(this.protocol);
    localStringBuilder.append("\n |-").append("fileSizeFlag:").append(this.fileSizeFlag);
    localStringBuilder.append("\n |-").append("thumbMsgUrl:").append(this.thumbMsgUrl);
    localStringBuilder.append("\n |-").append("bigthumbMsgUrl:").append(this.bUH);
    localStringBuilder.append("\n |-").append("bigMsgUrl:").append(this.bigMsgUrl);
    localStringBuilder.append("\n |-").append("rawMsgUrl:").append(this.rawMsgUrl);
    localStringBuilder.append("\n |-").append("isMixed:").append(this.isMixed);
    localStringBuilder.append("\n |-").append("shareAppID:").append(this.shareAppID);
    localStringBuilder.append("\n |-").append("action:").append(this.action);
    localStringBuilder.append("\n |-").append("actMsgContentValue:").append(this.isShareAppActionMsg);
    localStringBuilder.append("\n |-").append("picExtraFlag:").append(this.picExtraFlag);
    localStringBuilder.append("\n |-").append("picExtraObject:").append(this.picExtraObject);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
  
  String xN()
  {
    int i = 65537;
    if ("chatthumb".equals(this.protocol)) {}
    while (this.cuF)
    {
      localObject = new akxy();
      ((akxy)localObject).uinType = this.uinType;
      ((akxy)localObject).subVersion = this.subVersion;
      ((akxy)localObject).localUUID = this.localUUID;
      ((akxy)localObject).md5 = this.md5;
      localObject = aoop.a((akxy)localObject, i, null);
      if (localObject == null) {
        break label129;
      }
      return ((URL)localObject).toString();
      if ("chatimg".equals(this.protocol)) {
        i = 1;
      } else if ("chatraw".equals(this.protocol)) {
        i = 131075;
      }
    }
    Object localObject = aoop.a(this, i, null);
    if (localObject != null) {
      return ((URL)localObject).toString();
    }
    label129:
    return null;
  }
  
  public String xO()
  {
    return getFilePath() + "_dp";
  }
  
  public static class a
    extends akxl
  {
    public void NP(String paramString)
    {
      this.peerUin = paramString;
    }
    
    public void So(int paramInt)
    {
      this.busiType = paramInt;
    }
    
    public void Sp(int paramInt)
    {
      this.uinType = paramInt;
    }
    
    public void Sq(int paramInt)
    {
      this.issend = paramInt;
    }
    
    public akxl a()
    {
      return this;
    }
    
    public void kc(String paramString)
    {
      this.selfUin = paramString;
    }
    
    public void kw(long paramLong)
    {
      this.uniseq = paramLong;
    }
    
    public void setMd5(String paramString)
    {
      this.md5 = paramString;
    }
    
    public void setTime(long paramLong)
    {
      this.time = paramLong;
    }
    
    public void setUuid(String paramString)
    {
      this.uuid = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxl
 * JD-Core Version:    0.7.0.1
 */