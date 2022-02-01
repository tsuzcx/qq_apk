import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wze
  extends wkz
{
  public List<yib> a = new ArrayList();
  
  public wze(qqstory_service.RspProfileStoryFeedIdList paramRspProfileStoryFeedIdList)
  {
    super(paramRspProfileStoryFeedIdList.result, paramRspProfileStoryFeedIdList.is_end, paramRspProfileStoryFeedIdList.next_cookie);
    paramRspProfileStoryFeedIdList = paramRspProfileStoryFeedIdList.feed_seq_info_list.get().iterator();
    while (paramRspProfileStoryFeedIdList.hasNext())
    {
      qqstory_struct.FeedSeqInfo localFeedSeqInfo = (qqstory_struct.FeedSeqInfo)paramRspProfileStoryFeedIdList.next();
      this.a.add(new yib(localFeedSeqInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wze
 * JD-Core Version:    0.7.0.1
 */