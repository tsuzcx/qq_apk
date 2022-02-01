import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBannerVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoTarget;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qae
  extends ppu
{
  public boolean isEnd;
  public String nextCookie;
  public List<String> ny = new ArrayList();
  public List<String> nz = new ArrayList();
  public int totalCount;
  
  public qae(qqstory_service.RspBannerVideoList paramRspBannerVideoList)
  {
    super(paramRspBannerVideoList.result);
    if ((paramRspBannerVideoList.video_list.has()) && (!paramRspBannerVideoList.video_list.isEmpty()))
    {
      Iterator localIterator = paramRspBannerVideoList.video_list.get().iterator();
      while (localIterator.hasNext())
      {
        qqstory_struct.VideoTarget localVideoTarget = (qqstory_struct.VideoTarget)localIterator.next();
        this.ny.add(localVideoTarget.vid.get().toStringUtf8());
        this.nz.add(localVideoTarget.feed_id.get().toStringUtf8());
      }
    }
    if (paramRspBannerVideoList.is_end.has()) {
      if (paramRspBannerVideoList.is_end.get() != 1) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      this.isEnd = bool;
      if (paramRspBannerVideoList.next_cookie.has()) {
        this.nextCookie = paramRspBannerVideoList.next_cookie.get().toStringUtf8();
      }
      if (paramRspBannerVideoList.total_count.has()) {
        this.totalCount = paramRspBannerVideoList.total_count.get();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qae
 * JD-Core Version:    0.7.0.1
 */