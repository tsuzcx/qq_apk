import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class qvv
  implements ppv.b<pyi, pyi.a>
{
  qvv(qwc paramqwc) {}
  
  public void a(@NonNull pyi parampyi, @Nullable pyi.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.w("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (parama == null)
    {
      ram.w("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new pyi.a(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          ram.w("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((parama.nf == null) || (parama.nf.isEmpty()));
      parampyi = (psa)psx.a(17);
      parama = (pyi.b)parama.nf.get(0);
    } while (parama.nh == null);
    ram.w("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { parama.feedId, Integer.valueOf(parama.commentCount), Integer.valueOf(parama.nh.size()) });
    parampyi.a(parama.nh, this.a.c.feedId, true, true);
    parampyi = new qrl.b(paramErrorMessage, parama.feedId, 1);
    parampyi.nh = parama.nh;
    parampyi.isFirstPage = true;
    if (((CommentLikeFeedItem)this.a.c).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      parampyi.isEnd = bool;
      parampyi.aym = ((CommentLikeFeedItem)this.a.c).mCommentLastCookie;
      parampyi.mTotalCount = parama.commentCount;
      pmi.a().dispatch(parampyi);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvv
 * JD-Core Version:    0.7.0.1
 */