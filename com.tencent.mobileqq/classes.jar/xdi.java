import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xdi
  extends wou
{
  public List<ylw> a = new ArrayList();
  public boolean b;
  
  public xdi(qqstory_service.RspStoryFeedIdList paramRspStoryFeedIdList)
  {
    super(paramRspStoryFeedIdList.result, paramRspStoryFeedIdList.is_end, paramRspStoryFeedIdList.next_cookie);
    if (paramRspStoryFeedIdList.is_today_end.get() == 1) {}
    for (;;)
    {
      this.b = bool;
      paramRspStoryFeedIdList = paramRspStoryFeedIdList.feed_seq_info_list.get().iterator();
      while (paramRspStoryFeedIdList.hasNext())
      {
        ylw localylw = new ylw((qqstory_struct.FeedSeqInfo)paramRspStoryFeedIdList.next());
        this.a.add(localylw);
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdi
 * JD-Core Version:    0.7.0.1
 */