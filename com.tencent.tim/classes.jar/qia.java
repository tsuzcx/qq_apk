import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class qia
  implements ppv.b<pyk, pyk.a>
{
  qia(qhy.e parame, JobContext paramJobContext, qru paramqru) {}
  
  public void a(@NonNull pyk parampyk, @Nullable pyk.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (parama == null))
    {
      ram.b("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      qhy.e.a(this.jdField_a_of_type_Qhy$e, paramErrorMessage);
      return;
    }
    parampyk = (qvf)psx.a(11);
    if (parama.nm.size() < 1)
    {
      ram.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      parampyk.sc(qhy.a(this.jdField_a_of_type_Qhy$e.b));
      parampyk = new ErrorMessage(2222, "no feed data back.");
      qhy.e.b(this.jdField_a_of_type_Qhy$e, parampyk);
      return;
    }
    parama = (qux)parama.nm.get(0);
    if ((parama instanceof qwc))
    {
      paramErrorMessage = (qwc)parama;
      this.b.d = parama.a();
      this.b.I(parampyk.a(qhy.a(this.jdField_a_of_type_Qhy$e.b), paramErrorMessage.bS(), true), true);
      ((qvi)psx.a(12)).a(2, this.b.d.feedId, this.b.b().mVideoSeq, this.b.bS(), this.b.b().mVideoNextCookie, this.b.b().mIsVideoEnd, this.b.b().mVideoPullType, true);
    }
    for (;;)
    {
      this.b.d = ((CommentLikeFeedItem)parampyk.a(qhy.a(this.jdField_a_of_type_Qhy$e.b).d));
      qhy.e.a(this.jdField_a_of_type_Qhy$e, this.b);
      return;
      this.b.d = parama.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qia
 * JD-Core Version:    0.7.0.1
 */