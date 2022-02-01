import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.BannerFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;

public class yln
  extends ylo<BannerFeedItem>
{
  public yln(@NonNull BannerFeedItem paramBannerFeedItem)
  {
    super(paramBannerFeedItem);
  }
  
  public List<StoryVideoItem> a()
  {
    return new ArrayList(0);
  }
  
  public void a() {}
  
  public boolean a(qqstory_struct.StoryFeed paramStoryFeed)
  {
    qqstory_struct.BannerFeed localBannerFeed = (qqstory_struct.BannerFeed)paramStoryFeed.banner_feed.get();
    ((BannerFeedItem)this.a).covertFrom(paramStoryFeed.feed_id.get().toStringUtf8(), localBannerFeed);
    ((BannerFeedItem)this.a).feedSourceTagType = paramStoryFeed.feed_source_tag_type.get();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yln
 * JD-Core Version:    0.7.0.1
 */