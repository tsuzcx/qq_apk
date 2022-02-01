import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGroupStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pzk
  extends ppw
{
  public String cookie;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspGroupStoryFeedIdList localRspGroupStoryFeedIdList = new qqstory_group.RspGroupStoryFeedIdList();
    try
    {
      localRspGroupStoryFeedIdList.mergeFrom(paramArrayOfByte);
      return new pzk.a(localRspGroupStoryFeedIdList);
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
    qqstory_group.ReqGroupStoryFeedIdList localReqGroupStoryFeedIdList = new qqstory_group.ReqGroupStoryFeedIdList();
    localReqGroupStoryFeedIdList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.cookie));
    return localReqGroupStoryFeedIdList.toByteArray();
  }
  
  public String mg()
  {
    return ppf.fQ("StoryGroupSvc.get_dynamic_group_feedid_list");
  }
  
  public static class a
    extends ppt
  {
    public List<qvd> nk = new ArrayList();
    
    public a(qqstory_group.RspGroupStoryFeedIdList paramRspGroupStoryFeedIdList)
    {
      super(paramRspGroupStoryFeedIdList.is_end, paramRspGroupStoryFeedIdList.next_cookie);
      paramRspGroupStoryFeedIdList = paramRspGroupStoryFeedIdList.feed_seq_info_list.get().iterator();
      while (paramRspGroupStoryFeedIdList.hasNext())
      {
        qqstory_struct.FeedSeqInfo localFeedSeqInfo = (qqstory_struct.FeedSeqInfo)paramRspGroupStoryFeedIdList.next();
        this.nk.add(new qvd(localFeedSeqInfo));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzk
 * JD-Core Version:    0.7.0.1
 */