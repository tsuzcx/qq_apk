import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareGroupInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;

public class pzd
  extends ppw<qam>
{
  private final String CMD = ppf.fQ("StorySvc.get_share_group_info");
  public List<String> nt;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetShareGroupInfo localRspGetShareGroupInfo = new qqstory_service.RspGetShareGroupInfo();
    try
    {
      localRspGetShareGroupInfo.mergeFrom(paramArrayOfByte);
      return new qam(localRspGetShareGroupInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory.shareGroup:GetShareGroupInfoRequest", mg(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqGetShareGroupInfo localReqGetShareGroupInfo = new qqstory_service.ReqGetShareGroupInfo();
    Iterator localIterator = this.nt.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqGetShareGroupInfo.share_group_id_list.add(str);
    }
    return localReqGetShareGroupInfo.toByteArray();
  }
  
  public String mg()
  {
    return this.CMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzd
 * JD-Core Version:    0.7.0.1
 */