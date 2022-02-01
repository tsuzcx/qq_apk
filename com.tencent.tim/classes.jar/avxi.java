import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_REQ;
import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.os.Build.VERSION;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.config.AppSetting;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class avxi
  extends QzoneExternalRequest
{
  public JceStruct req;
  
  public avxi(long paramLong, ArrayList<UPDATE_INFO> paramArrayList1, ArrayList<UPDATE_INFO> paramArrayList2)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    SQ_CLIENT_UPDATE_REQ localSQ_CLIENT_UPDATE_REQ = new SQ_CLIENT_UPDATE_REQ();
    localSQ_CLIENT_UPDATE_REQ.qua = avpq.getQUA3();
    localSQ_CLIENT_UPDATE_REQ.version = AppSetting.getVersion();
    localSQ_CLIENT_UPDATE_REQ.apiLevel = Build.VERSION.SDK_INT;
    localSQ_CLIENT_UPDATE_REQ.triggerType = 1;
    localSQ_CLIENT_UPDATE_REQ.vPlugin = paramArrayList1;
    localSQ_CLIENT_UPDATE_REQ.vModule = paramArrayList2;
    this.req = localSQ_CLIENT_UPDATE_REQ;
  }
  
  public static SQ_CLIENT_UPDATE_RSP a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = decode(paramArrayOfByte, "mqBatchUpdate");
    if ((paramArrayOfByte instanceof SQ_CLIENT_UPDATE_RSP)) {
      return (SQ_CLIENT_UPDATE_RSP)paramArrayOfByte;
    }
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.update.mqBatchUpdate";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "mqBatchUpdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxi
 * JD-Core Version:    0.7.0.1
 */