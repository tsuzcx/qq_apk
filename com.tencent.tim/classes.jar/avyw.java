import BOSSStrategyCenter.tAdvAppInfo;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;
import java.util.Iterator;

public class avyw
  extends QzoneExternalRequest
{
  JceStruct req;
  
  public avyw(long paramLong, ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    MobileQbossAdvReq localMobileQbossAdvReq = new MobileQbossAdvReq();
    localMobileQbossAdvReq.uiUin = paramLong;
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Integer localInteger = (Integer)paramArrayList.next();
      tAdvAppInfo localtAdvAppInfo = new tAdvAppInfo();
      localtAdvAppInfo.app_id = localInteger.intValue();
      localtAdvAppInfo.i_need_adv_cnt = 5;
      localArrayList.add(localtAdvAppInfo);
    }
    localMobileQbossAdvReq.vecReqApp = localArrayList;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMobileQbossAdvReq.iPullAsExposeOper = i;
      localMobileQbossAdvReq.iReqFlag = 1;
      this.req = localMobileQbossAdvReq;
      return;
    }
  }
  
  public static MobileQbossAdvRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (MobileQbossAdvRsp)decode(paramArrayOfByte, "get");
    if (paramArrayOfByte == null) {
      return null;
    }
    avzb.a(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.mobileqboss.get";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "get";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyw
 * JD-Core Version:    0.7.0.1
 */