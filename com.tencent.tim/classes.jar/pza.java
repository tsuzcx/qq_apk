import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqProfileStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pza
  extends ppw
{
  public String cookie;
  public String unionId;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspProfileStoryFeedIdList localRspProfileStoryFeedIdList = new qqstory_service.RspProfileStoryFeedIdList();
    try
    {
      localRspProfileStoryFeedIdList.mergeFrom(paramArrayOfByte);
      return new pza.a(localRspProfileStoryFeedIdList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqProfileStoryFeedIdList localReqProfileStoryFeedIdList = new qqstory_service.ReqProfileStoryFeedIdList();
    localReqProfileStoryFeedIdList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.cookie));
    localReqProfileStoryFeedIdList.union_id.set(ByteStringMicro.copyFromUtf8(this.unionId));
    return localReqProfileStoryFeedIdList.toByteArray();
  }
  
  public String mg()
  {
    return ppf.fQ("StorySvc.get_profile_feed_id_list");
  }
  
  public static class a
    extends ppt
  {
    public List<qvd> nk = new ArrayList();
    
    public a(qqstory_service.RspProfileStoryFeedIdList paramRspProfileStoryFeedIdList)
    {
      super(paramRspProfileStoryFeedIdList.is_end, paramRspProfileStoryFeedIdList.next_cookie);
      paramRspProfileStoryFeedIdList = paramRspProfileStoryFeedIdList.feed_seq_info_list.get().iterator();
      while (paramRspProfileStoryFeedIdList.hasNext())
      {
        qqstory_struct.FeedSeqInfo localFeedSeqInfo = (qqstory_struct.FeedSeqInfo)paramRspProfileStoryFeedIdList.next();
        this.nk.add(new qvd(localFeedSeqInfo));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pza
 * JD-Core Version:    0.7.0.1
 */