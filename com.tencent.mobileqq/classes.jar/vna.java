import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class vna
  extends JobSegment<String, weh>
{
  public vna(vmu paramvmu) {}
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    if ((vmu.a(this.a).a != null) && (TextUtils.equals(vmu.a(this.a).a.feedId, paramString)))
    {
      wsv.d("Q.qqstory.player.CommentFloatDialogController", "feed item already exist , no need to pull again");
      notifyError(new ErrorMessage(2223, "feed item already exist"));
      return;
    }
    paramString = new weh();
    Object localObject1 = (CommentLikeFeedItem)((wkp)urr.a(11)).a(vmu.a(this.a));
    if (localObject1 != null)
    {
      if ((localObject1 instanceof VideoListFeedItem))
      {
        paramJobContext = (VideoListFeedItem)localObject1;
        localObject2 = ((wkv)urr.a(12)).a(vmu.a(this.a), paramJobContext.mVideoPullType);
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
    localObject1 = new vao();
    ((vao)localObject1).a = new ArrayList();
    Object localObject2 = new wkh(vmu.a(this.a), 0, "", "");
    ((vao)localObject1).a.add(localObject2);
    ung.a().a((unk)localObject1, new vnb(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vna
 * JD-Core Version:    0.7.0.1
 */