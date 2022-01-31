import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tmu
  extends syp
{
  public List<uvs> a = new ArrayList();
  
  public tmu(qqstory_service.RspProfileStoryFeedIdList paramRspProfileStoryFeedIdList)
  {
    super(paramRspProfileStoryFeedIdList.result, paramRspProfileStoryFeedIdList.is_end, paramRspProfileStoryFeedIdList.next_cookie);
    paramRspProfileStoryFeedIdList = paramRspProfileStoryFeedIdList.feed_seq_info_list.get().iterator();
    while (paramRspProfileStoryFeedIdList.hasNext())
    {
      qqstory_struct.FeedSeqInfo localFeedSeqInfo = (qqstory_struct.FeedSeqInfo)paramRspProfileStoryFeedIdList.next();
      this.a.add(new uvs(localFeedSeqInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmu
 * JD-Core Version:    0.7.0.1
 */