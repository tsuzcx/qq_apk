import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem.a;

public class qcb
  extends qdg
{
  public qcb(@NonNull BannerFeedItem paramBannerFeedItem)
  {
    this.mTitle = paramBannerFeedItem.shareInfo.title;
    this.mSummary = paramBannerFeedItem.shareInfo.content;
    this.mJumpUrl = paramBannerFeedItem.shareInfo.jumpUrl;
    this.mImageUrl = paramBannerFeedItem.shareInfo.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qcb
 * JD-Core Version:    0.7.0.1
 */