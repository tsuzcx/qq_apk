import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class xop
  extends JobSegment<String, yfw>
{
  public xop(xoj paramxoj) {}
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    if ((xoj.a(this.a).a != null) && (TextUtils.equals(xoj.a(this.a).a.feedId, paramString)))
    {
      yuk.d("Q.qqstory.player.CommentFloatDialogController", "feed item already exist , no need to pull again");
      notifyError(new ErrorMessage(2223, "feed item already exist"));
      return;
    }
    paramString = new yfw();
    Object localObject1 = (CommentLikeFeedItem)((yme)wth.a(11)).a(xoj.a(this.a));
    if (localObject1 != null)
    {
      if ((localObject1 instanceof VideoListFeedItem))
      {
        paramJobContext = (VideoListFeedItem)localObject1;
        localObject2 = ((ymk)wth.a(12)).a(xoj.a(this.a), paramJobContext.mVideoPullType);
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
    localObject1 = new xce();
    ((xce)localObject1).a = new ArrayList();
    Object localObject2 = new ylw(xoj.a(this.a), 0, "", "");
    ((xce)localObject1).a.add(localObject2);
    wow.a().a((wpa)localObject1, new xoq(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xop
 * JD-Core Version:    0.7.0.1
 */