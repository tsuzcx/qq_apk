import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MultiRecommend;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MultiRecommendItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qvx
  extends qwc<HotRecommendFeedItem>
{
  public qvx(@NonNull HotRecommendFeedItem paramHotRecommendFeedItem)
  {
    super(paramHotRecommendFeedItem);
  }
  
  public boolean a(qqstory_struct.StoryFeed paramStoryFeed)
  {
    Object localObject1 = (qqstory_struct.MultiRecommend)paramStoryFeed.multi_recommend_feed.get();
    ((HotRecommendFeedItem)this.c).covertFrom(paramStoryFeed.feed_id.get().toStringUtf8(), (qqstory_struct.MultiRecommend)localObject1);
    ((HotRecommendFeedItem)this.c).feedSourceTagType = paramStoryFeed.feed_source_tag_type.get();
    paramStoryFeed = (ptf)psx.a(2);
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((qqstory_struct.MultiRecommend)localObject1).recommend_feed.get().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (qqstory_struct.MultiRecommendItem)((Iterator)localObject1).next();
      StoryVideoItem localStoryVideoItem = new StoryVideoItem();
      localStoryVideoItem.convertFrom("HotRecommendHomeFeed", (qqstory_struct.MultiRecommendItem)localObject2);
      localArrayList.add(localStoryVideoItem);
      QQUserUIItem localQQUserUIItem = new QQUserUIItem();
      localQQUserUIItem.convertFrom(((qqstory_struct.MultiRecommendItem)localObject2).user);
      localObject2 = paramStoryFeed.a(localQQUserUIItem);
      localStoryVideoItem.mOwnerUid = ((QQUserUIItem)localObject2).uid;
      localStoryVideoItem.mOwnerName = ((QQUserUIItem)localObject2).getDisplayName();
    }
    I(localArrayList, true);
    return !localArrayList.isEmpty();
  }
  
  public void brb()
  {
    super.brb();
    ptf localptf = (ptf)psx.a(2);
    if (!this.mVideoItemList.isEmpty())
    {
      Iterator localIterator = this.mVideoItemList.iterator();
      while (localIterator.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
        if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
          localptf.b(localStoryVideoItem.mOwnerUid);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvx
 * JD-Core Version:    0.7.0.1
 */