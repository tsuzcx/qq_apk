import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.MemorySelectVideoPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAIOPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAssistantHomeFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;

public class vmk
{
  public static vla a(Object paramObject)
  {
    wsv.d("Q.qqstory.player.data.SimpleDataProvider", "play info:%s", new Object[] { paramObject });
    if ((paramObject instanceof HomeFeedPlayInfo)) {
      return new vlz(new vkw((HomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAssistantHomeFeedPlayInfo)) {
      return new vlz(new vmg((TroopAssistantHomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof ProfileFeedPlayInfo)) {
      return new vlz(new vlu((ProfileFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof SingleFeedPlayInfo)) {
      return new vlz(new vmf((SingleFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof MsgTabPlayInfo)) {
      return new vlz(new vlq((MsgTabPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemoriesFeedPlayInfo)) {
      return new vlz(new vlm((MemoriesFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof HotRecommendFeedPlayInfo)) {
      return new vlz(new vkz((HotRecommendFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof VidListPlayInfo)) {
      return new vlz(new vmj((VidListPlayInfo)paramObject));
    }
    if ((paramObject instanceof DiscoverBannerPlayInfo)) {
      return new vlz(new vkq((DiscoverBannerPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAIOPlayInfo)) {
      return new vmi(((TroopAIOPlayInfo)paramObject).storyId);
    }
    if ((paramObject instanceof ShareFromMemoryPlayInfo)) {
      return new vlz(new vlw((ShareFromMemoryPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemorySelectVideoPlayInfo)) {
      return new vlz(new vlp((MemorySelectVideoPlayInfo)paramObject));
    }
    xmh.a("play info unknown", new Object[0]);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmk
 * JD-Core Version:    0.7.0.1
 */