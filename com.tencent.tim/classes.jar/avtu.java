import NS_QZONE_MQMSG.QzoneMessageReq;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public class avtu
  extends avpr
{
  public JceStruct req;
  private int type;
  
  public avtu(long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    QzoneMessageReq localQzoneMessageReq = new QzoneMessageReq();
    localQzoneMessageReq.uin = paramLong1;
    localQzoneMessageReq.trace_info = paramString;
    localQzoneMessageReq.num = paramLong2;
    localQzoneMessageReq.ext = new HashMap();
    localQzoneMessageReq.ext.put("qua", avpq.getQUA3());
    localQzoneMessageReq.scence = paramInt;
    this.req = localQzoneMessageReq;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.GetNewMQmsg";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String uniKey()
  {
    return "GetNewMQmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtu
 * JD-Core Version:    0.7.0.1
 */