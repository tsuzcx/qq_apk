import PUSHAPI.PushRsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class avqg
  extends QzoneExternalRequest
{
  private String cMW;
  private long flag;
  private long lastTimeStamp;
  
  public avqg(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong1);
    super.setRefer(paramString1);
    this.lastTimeStamp = paramLong2;
    this.flag = paramLong3;
    this.cMW = paramString2;
    this.needCompress = false;
  }
  
  public String getCmdString()
  {
    return "wns.pushrsp";
  }
  
  public byte[] getEncodedUniParameter()
  {
    PushRsp localPushRsp = new PushRsp();
    localPushRsp.ptime = this.lastTimeStamp;
    localPushRsp.is_bgd = 0;
    localPushRsp.sUID = "<JIEHEBAN>";
    localPushRsp.flag = this.flag;
    localPushRsp.Mark = this.cMW;
    return avcf.encodeWup(localPushRsp);
  }
  
  public JceStruct getReq()
  {
    return null;
  }
  
  public String uniKey()
  {
    return "wns.pushrsp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqg
 * JD-Core Version:    0.7.0.1
 */