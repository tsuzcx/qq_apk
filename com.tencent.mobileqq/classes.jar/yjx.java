import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class yjx
  extends yka<ShareGroupFeedItem>
{
  public yjx(@NonNull ShareGroupFeedItem paramShareGroupFeedItem)
  {
    super(paramShareGroupFeedItem);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    super.a(paramStoryVideoItem);
    paramStoryVideoItem = (ShareGroupFeedItem)a();
    paramStoryVideoItem.videoCount -= 1;
    if (((ShareGroupFeedItem)a()).videoCount < 0) {
      ((ShareGroupFeedItem)a()).videoCount = 0;
    }
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    super.a(paramStoryVideoItem, paramBoolean);
    paramStoryVideoItem = (ShareGroupFeedItem)a();
    paramStoryVideoItem.videoCount += 1;
    if (((ShareGroupFeedItem)a()).videoCount < 0) {
      ((ShareGroupFeedItem)a()).videoCount = 0;
    }
  }
  
  public boolean a(qqstory_struct.StoryFeed paramStoryFeed)
  {
    ((ShareGroupFeedItem)this.a).covertFrom(paramStoryFeed.feed_id.get().toStringUtf8(), paramStoryFeed);
    ((ShareGroupFeedItem)this.a).feedSourceTagType = paramStoryFeed.feed_source_tag_type.get();
    Object localObject = (qqstory_struct.ShareGroupFeed)paramStoryFeed.share_group_feed.get();
    paramStoryFeed = new ArrayList();
    localObject = ((qqstory_struct.ShareGroupFeed)localObject).video_list.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      qqstory_struct.ShareGroupVideoInfo localShareGroupVideoInfo = (qqstory_struct.ShareGroupVideoInfo)((Iterator)localObject).next();
      StoryVideoItem localStoryVideoItem = new StoryVideoItem();
      localStoryVideoItem.convertFrom("Q.qqstory.home.data.VideoListHomeFeed", localShareGroupVideoInfo);
      paramStoryFeed.add(localStoryVideoItem);
    }
    c(paramStoryFeed, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjx
 * JD-Core Version:    0.7.0.1
 */