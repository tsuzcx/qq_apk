import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vgg
  extends urn
{
  public List<woq> a = new ArrayList();
  
  public vgg(qqstory_group.RspGroupStoryFeedIdList paramRspGroupStoryFeedIdList)
  {
    super(paramRspGroupStoryFeedIdList.result, paramRspGroupStoryFeedIdList.is_end, paramRspGroupStoryFeedIdList.next_cookie);
    paramRspGroupStoryFeedIdList = paramRspGroupStoryFeedIdList.feed_seq_info_list.get().iterator();
    while (paramRspGroupStoryFeedIdList.hasNext())
    {
      qqstory_struct.FeedSeqInfo localFeedSeqInfo = (qqstory_struct.FeedSeqInfo)paramRspGroupStoryFeedIdList.next();
      this.a.add(new woq(localFeedSeqInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgg
 * JD-Core Version:    0.7.0.1
 */