import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class tlp
  extends JobSegment<String, ucw>
{
  public tlp(tlj paramtlj) {}
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    if ((tlj.a(this.a).a != null) && (TextUtils.equals(tlj.a(this.a).a.feedId, paramString)))
    {
      urk.d("Q.qqstory.player.CommentFloatDialogController", "feed item already exist , no need to pull again");
      notifyError(new ErrorMessage(2223, "feed item already exist"));
      return;
    }
    paramString = new ucw();
    Object localObject1 = (CommentLikeFeedItem)((uje)sqg.a(11)).a(tlj.a(this.a));
    if (localObject1 != null)
    {
      if ((localObject1 instanceof VideoListFeedItem))
      {
        paramJobContext = (VideoListFeedItem)localObject1;
        localObject2 = ((ujk)sqg.a(12)).a(tlj.a(this.a), paramJobContext.mVideoPullType);
        if (localObject2 != null)
        {
          paramJobContext.mVideoNextCookie = ((FeedVideoInfo)localObject2).mVideoNextCookie;
          paramJobContext.mIsVideoEnd = ((FeedVideoInfo)localObject2).mIsVideoEnd;
          paramJobContext.mVideoPullType = ((FeedVideoInfo)localObject2).mVideoPullType;
          paramJobContext.mVideoSeq = ((FeedVideoInfo)localObject2).mVideoSeq;
          paramString.a(((FeedVideoInfo)localObject2).mVideoItemList, true);
        }
      }
      paramString.a = ((CommentLikeFeedItem)localObject1);
      notifyResult(paramString);
      return;
    }
    localObject1 = new szd();
    ((szd)localObject1).a = new ArrayList();
    Object localObject2 = new uiw(tlj.a(this.a), 0, "", "");
    ((szd)localObject1).a.add(localObject2);
    slv.a().a((slz)localObject1, new tlq(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlp
 * JD-Core Version:    0.7.0.1
 */