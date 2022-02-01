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

public class xnz
{
  public static xmp a(Object paramObject)
  {
    yuk.d("Q.qqstory.player.data.SimpleDataProvider", "play info:%s", new Object[] { paramObject });
    if ((paramObject instanceof HomeFeedPlayInfo)) {
      return new xno(new xml((HomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAssistantHomeFeedPlayInfo)) {
      return new xno(new xnv((TroopAssistantHomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof ProfileFeedPlayInfo)) {
      return new xno(new xnj((ProfileFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof SingleFeedPlayInfo)) {
      return new xno(new xnu((SingleFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof MsgTabPlayInfo)) {
      return new xno(new xnf((MsgTabPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemoriesFeedPlayInfo)) {
      return new xno(new xnb((MemoriesFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof HotRecommendFeedPlayInfo)) {
      return new xno(new xmo((HotRecommendFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof VidListPlayInfo)) {
      return new xno(new xny((VidListPlayInfo)paramObject));
    }
    if ((paramObject instanceof DiscoverBannerPlayInfo)) {
      return new xno(new xmf((DiscoverBannerPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAIOPlayInfo)) {
      return new xnx(((TroopAIOPlayInfo)paramObject).storyId);
    }
    if ((paramObject instanceof ShareFromMemoryPlayInfo)) {
      return new xno(new xnl((ShareFromMemoryPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemorySelectVideoPlayInfo)) {
      return new xno(new xne((MemorySelectVideoPlayInfo)paramObject));
    }
    znw.a("play info unknown", new Object[0]);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnz
 * JD-Core Version:    0.7.0.1
 */