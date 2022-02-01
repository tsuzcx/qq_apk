import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBlackList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class pyo
  extends ppw<qab>
{
  public static final String CMD = ppf.fQ("StorySvc.get_user_black_status");
  public String mUnionId;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetBlackList localRspGetBlackList = new qqstory_service.RspGetBlackList();
    try
    {
      localRspGetBlackList.mergeFrom(paramArrayOfByte);
      return new qab(localRspGetBlackList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqGetBlackList localReqGetBlackList = new qqstory_service.ReqGetBlackList();
    localReqGetBlackList.union_id.set(ByteStringMicro.copyFromUtf8(this.mUnionId));
    return localReqGetBlackList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyo
 * JD-Core Version:    0.7.0.1
 */