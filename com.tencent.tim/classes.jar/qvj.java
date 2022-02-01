import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GeneralFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qvj
  extends qwc<GeneralFeedItem>
{
  public boolean aFN;
  
  public qvj(@NonNull GeneralFeedItem paramGeneralFeedItem)
  {
    super(paramGeneralFeedItem);
  }
  
  public boolean a(qqstory_struct.StoryFeed paramStoryFeed)
  {
    Object localObject = (qqstory_struct.GeneralFeed)paramStoryFeed.general_feed.get();
    ((GeneralFeedItem)this.c).covertFrom(paramStoryFeed.feed_id.get().toStringUtf8(), (qqstory_struct.GeneralFeed)localObject);
    ((GeneralFeedItem)this.c).feedSourceTagType = paramStoryFeed.feed_source_tag_type.get();
    ram.b("Q.qqstory.home.data.GeneralHomeFeed", "GeneralHomeFeed convertFrom, feedSourceType:%s, feedId:%s", Integer.valueOf(((GeneralFeedItem)this.c).feedSourceTagType), ((GeneralFeedItem)this.c).feedId);
    paramStoryFeed = new ArrayList();
    localObject = ((qqstory_struct.GeneralFeed)localObject).feed_video_info_list.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      qqstory_struct.FeedVideoInfo localFeedVideoInfo = (qqstory_struct.FeedVideoInfo)((Iterator)localObject).next();
      StoryVideoItem localStoryVideoItem = new StoryVideoItem();
      localStoryVideoItem.convertFrom("Q.qqstory.home.data.GeneralHomeFeed", localFeedVideoInfo);
      paramStoryFeed.add(localStoryVideoItem);
    }
    I(paramStoryFeed, true);
    return true;
  }
  
  public GeneralFeedItem c()
  {
    return (GeneralFeedItem)super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvj
 * JD-Core Version:    0.7.0.1
 */