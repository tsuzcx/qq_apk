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

public class txs
{
  public static twi a(Object paramObject)
  {
    ved.d("Q.qqstory.player.data.SimpleDataProvider", "play info:%s", new Object[] { paramObject });
    if ((paramObject instanceof HomeFeedPlayInfo)) {
      return new txh(new twe((HomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAssistantHomeFeedPlayInfo)) {
      return new txh(new txo((TroopAssistantHomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof ProfileFeedPlayInfo)) {
      return new txh(new txc((ProfileFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof SingleFeedPlayInfo)) {
      return new txh(new txn((SingleFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof MsgTabPlayInfo)) {
      return new txh(new twy((MsgTabPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemoriesFeedPlayInfo)) {
      return new txh(new twu((MemoriesFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof HotRecommendFeedPlayInfo)) {
      return new txh(new twh((HotRecommendFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof VidListPlayInfo)) {
      return new txh(new txr((VidListPlayInfo)paramObject));
    }
    if ((paramObject instanceof DiscoverBannerPlayInfo)) {
      return new txh(new tvy((DiscoverBannerPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAIOPlayInfo)) {
      return new txq(((TroopAIOPlayInfo)paramObject).storyId);
    }
    if ((paramObject instanceof ShareFromMemoryPlayInfo)) {
      return new txh(new txe((ShareFromMemoryPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemorySelectVideoPlayInfo)) {
      return new txh(new twx((MemorySelectVideoPlayInfo)paramObject));
    }
    vxp.a("play info unknown", new Object[0]);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txs
 * JD-Core Version:    0.7.0.1
 */