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

public class quw
  extends qux<BannerFeedItem>
{
  public quw(@NonNull BannerFeedItem paramBannerFeedItem)
  {
    super(paramBannerFeedItem);
  }
  
  public boolean a(qqstory_struct.StoryFeed paramStoryFeed)
  {
    qqstory_struct.BannerFeed localBannerFeed = (qqstory_struct.BannerFeed)paramStoryFeed.banner_feed.get();
    ((BannerFeedItem)this.c).covertFrom(paramStoryFeed.feed_id.get().toStringUtf8(), localBannerFeed);
    ((BannerFeedItem)this.c).feedSourceTagType = paramStoryFeed.feed_source_tag_type.get();
    return true;
  }
  
  public List<StoryVideoItem> bS()
  {
    return new ArrayList(0);
  }
  
  public void bra() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     quw
 * JD-Core Version:    0.7.0.1
 */