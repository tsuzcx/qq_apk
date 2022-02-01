import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class xev
  extends JobSegment<String, xwc>
{
  public xev(xep paramxep) {}
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    if ((xep.a(this.a).a != null) && (TextUtils.equals(xep.a(this.a).a.feedId, paramString)))
    {
      ykq.d("Q.qqstory.player.CommentFloatDialogController", "feed item already exist , no need to pull again");
      notifyError(new ErrorMessage(2223, "feed item already exist"));
      return;
    }
    paramString = new xwc();
    Object localObject1 = (CommentLikeFeedItem)((yck)wjs.a(11)).a(xep.a(this.a));
    if (localObject1 != null)
    {
      if ((localObject1 instanceof VideoListFeedItem))
      {
        paramJobContext = (VideoListFeedItem)localObject1;
        localObject2 = ((ycq)wjs.a(12)).a(xep.a(this.a), paramJobContext.mVideoPullType);
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
    localObject1 = new wsp();
    ((wsp)localObject1).a = new ArrayList();
    Object localObject2 = new ycc(xep.a(this.a), 0, "", "");
    ((wsp)localObject1).a.add(localObject2);
    wfi.a().a((wfm)localObject1, new xew(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xev
 * JD-Core Version:    0.7.0.1
 */