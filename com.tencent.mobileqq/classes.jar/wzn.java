import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wzn
  extends wkz
{
  public List<yib> a = new ArrayList();
  public boolean b;
  
  public wzn(qqstory_service.RspStoryFeedIdList paramRspStoryFeedIdList)
  {
    super(paramRspStoryFeedIdList.result, paramRspStoryFeedIdList.is_end, paramRspStoryFeedIdList.next_cookie);
    if (paramRspStoryFeedIdList.is_today_end.get() == 1) {}
    for (;;)
    {
      this.b = bool;
      paramRspStoryFeedIdList = paramRspStoryFeedIdList.feed_seq_info_list.get().iterator();
      while (paramRspStoryFeedIdList.hasNext())
      {
        yib localyib = new yib((qqstory_struct.FeedSeqInfo)paramRspStoryFeedIdList.next());
        this.a.add(localyib);
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzn
 * JD-Core Version:    0.7.0.1
 */