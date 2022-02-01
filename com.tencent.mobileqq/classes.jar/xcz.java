import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xcz
  extends wou
{
  public List<ylw> a = new ArrayList();
  
  public xcz(qqstory_service.RspProfileStoryFeedIdList paramRspProfileStoryFeedIdList)
  {
    super(paramRspProfileStoryFeedIdList.result, paramRspProfileStoryFeedIdList.is_end, paramRspProfileStoryFeedIdList.next_cookie);
    paramRspProfileStoryFeedIdList = paramRspProfileStoryFeedIdList.feed_seq_info_list.get().iterator();
    while (paramRspProfileStoryFeedIdList.hasNext())
    {
      qqstory_struct.FeedSeqInfo localFeedSeqInfo = (qqstory_struct.FeedSeqInfo)paramRspProfileStoryFeedIdList.next();
      this.a.add(new ylw(localFeedSeqInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcz
 * JD-Core Version:    0.7.0.1
 */