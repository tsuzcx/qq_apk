import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tna
  extends sym
{
  public List<uvp> a = new ArrayList();
  public boolean b;
  
  public tna(qqstory_service.RspStoryFeedIdList paramRspStoryFeedIdList)
  {
    super(paramRspStoryFeedIdList.result, paramRspStoryFeedIdList.is_end, paramRspStoryFeedIdList.next_cookie);
    if (paramRspStoryFeedIdList.is_today_end.get() == 1) {}
    for (;;)
    {
      this.b = bool;
      paramRspStoryFeedIdList = paramRspStoryFeedIdList.feed_seq_info_list.get().iterator();
      while (paramRspStoryFeedIdList.hasNext())
      {
        uvp localuvp = new uvp((qqstory_struct.FeedSeqInfo)paramRspStoryFeedIdList.next());
        this.a.add(localuvp);
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tna
 * JD-Core Version:    0.7.0.1
 */