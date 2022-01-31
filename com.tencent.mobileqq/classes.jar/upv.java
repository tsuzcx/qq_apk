import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;

public class upv
  extends syn
{
  public List<LikeEntry> a;
  public int b;
  public int c;
  
  public upv(qqstory_service.RspFeedLikeList paramRspFeedLikeList)
  {
    super(paramRspFeedLikeList.result);
    paramRspFeedLikeList = (qqstory_struct.FeedLikeInfo)paramRspFeedLikeList.feed_like_info.get();
    this.a = a(paramRspFeedLikeList);
    this.b = paramRspFeedLikeList.like_total_count.get();
    this.c = paramRspFeedLikeList.has_like.get();
  }
  
  public List<LikeEntry> a(qqstory_struct.FeedLikeInfo paramFeedLikeInfo)
  {
    paramFeedLikeInfo = paramFeedLikeInfo.like_list.get();
    ArrayList localArrayList1 = new ArrayList();
    tdl localtdl = (tdl)tcz.a(2);
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramFeedLikeInfo.size())
    {
      LikeEntry localLikeEntry = LikeEntry.convertFrom((qqstory_struct.StoryVideoLikeInfo)paramFeedLikeInfo.get(i));
      if (localtdl.b(localLikeEntry.unionId) == null) {
        localArrayList2.add(new teg("", localLikeEntry.unionId));
      }
      localArrayList1.add(localLikeEntry);
      i += 1;
    }
    if (!localArrayList2.isEmpty()) {
      new tki().a(1, localArrayList2);
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upv
 * JD-Core Version:    0.7.0.1
 */