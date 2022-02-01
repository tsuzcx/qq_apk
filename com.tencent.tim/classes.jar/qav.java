import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qav
  extends ppu
{
  public long Ak;
  public long createTime;
  public String date;
  public String feedId = "";
  public List<pzx.a> nF;
  public String storyId;
  public String vid;
  
  public qav(qqstory_service.RspPublishVideo paramRspPublishVideo)
  {
    super(paramRspPublishVideo.result);
    this.createTime = paramRspPublishVideo.create_time.get();
    this.feedId = paramRspPublishVideo.feed_id.get().toStringUtf8();
    this.date = String.valueOf(paramRspPublishVideo.date.get());
    this.Ak = paramRspPublishVideo.video_index.get();
    if (paramRspPublishVideo.story_id.has()) {
      this.storyId = paramRspPublishVideo.story_id.get().toStringUtf8();
    }
    if (paramRspPublishVideo.vid.has()) {
      this.vid = paramRspPublishVideo.vid.get().toStringUtf8();
    }
    this.nF = new ArrayList();
    paramRspPublishVideo = paramRspPublishVideo.group_feed_list.get().iterator();
    while (paramRspPublishVideo.hasNext())
    {
      qqstory_group.GroupFeed localGroupFeed = (qqstory_group.GroupFeed)paramRspPublishVideo.next();
      this.nF.add(new pzx.a(localGroupFeed));
    }
  }
  
  public String toString()
  {
    return "PublishStoryVideoRespond{createTime=" + this.createTime + ", feedId='" + this.feedId + '\'' + ", date='" + this.date + '\'' + ", storyId='" + this.storyId + '\'' + ", videoIndex=" + this.Ak + ", vid=" + this.vid + ", addShareGroupFeeds=" + this.nF + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qav
 * JD-Core Version:    0.7.0.1
 */