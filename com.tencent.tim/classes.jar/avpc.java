import QzoneCombine.ClientOnlineNotfiyReq;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class avpc
  extends QzoneExternalRequest
{
  ClientOnlineNotfiyReq a;
  
  public avpc(long paramLong, byte[] paramArrayOfByte)
  {
    this.needCompress = false;
    this.a = new ClientOnlineNotfiyReq(paramArrayOfByte, paramLong);
  }
  
  public String getCmdString()
  {
    return "QzoneNewService." + uniKey();
  }
  
  public byte[] getEncodedUniParameter()
  {
    return avcf.encodeWup(this.a);
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "MqqOnlineNtf";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avpc
 * JD-Core Version:    0.7.0.1
 */