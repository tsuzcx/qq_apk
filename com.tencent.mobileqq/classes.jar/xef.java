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

public class xef
{
  public static xcv a(Object paramObject)
  {
    ykq.d("Q.qqstory.player.data.SimpleDataProvider", "play info:%s", new Object[] { paramObject });
    if ((paramObject instanceof HomeFeedPlayInfo)) {
      return new xdu(new xcr((HomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAssistantHomeFeedPlayInfo)) {
      return new xdu(new xeb((TroopAssistantHomeFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof ProfileFeedPlayInfo)) {
      return new xdu(new xdp((ProfileFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof SingleFeedPlayInfo)) {
      return new xdu(new xea((SingleFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof MsgTabPlayInfo)) {
      return new xdu(new xdl((MsgTabPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemoriesFeedPlayInfo)) {
      return new xdu(new xdh((MemoriesFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof HotRecommendFeedPlayInfo)) {
      return new xdu(new xcu((HotRecommendFeedPlayInfo)paramObject));
    }
    if ((paramObject instanceof VidListPlayInfo)) {
      return new xdu(new xee((VidListPlayInfo)paramObject));
    }
    if ((paramObject instanceof DiscoverBannerPlayInfo)) {
      return new xdu(new xcl((DiscoverBannerPlayInfo)paramObject));
    }
    if ((paramObject instanceof TroopAIOPlayInfo)) {
      return new xed(((TroopAIOPlayInfo)paramObject).storyId);
    }
    if ((paramObject instanceof ShareFromMemoryPlayInfo)) {
      return new xdu(new xdr((ShareFromMemoryPlayInfo)paramObject));
    }
    if ((paramObject instanceof MemorySelectVideoPlayInfo)) {
      return new xdu(new xdk((MemorySelectVideoPlayInfo)paramObject));
    }
    zdl.a("play info unknown", new Object[0]);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xef
 * JD-Core Version:    0.7.0.1
 */