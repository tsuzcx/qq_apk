import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class qrt
  implements ppv.b<pyk, pyk.a>
{
  qrt(qrs.a parama, JobContext paramJobContext) {}
  
  public void a(@NonNull pyk parampyk, @Nullable pyk.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (parama == null))
    {
      ram.b("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      qrs.a.a(this.jdField_a_of_type_Qrs$a, paramErrorMessage);
      return;
    }
    parampyk = (qvf)psx.a(11);
    if (parama.nm.size() < 1)
    {
      ram.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      parampyk.sc(qrs.a(this.jdField_a_of_type_Qrs$a.this$0));
      parampyk = new ErrorMessage(2222, "no feed data back.");
      qrs.a.b(this.jdField_a_of_type_Qrs$a, parampyk);
      return;
    }
    parama = (qux)parama.nm.get(0);
    if ((parama instanceof qwc))
    {
      paramErrorMessage = (qwc)parama;
      if ((qrs.a(this.jdField_a_of_type_Qrs$a.this$0).d == null) || (qrs.a(this.jdField_a_of_type_Qrs$a.this$0).b().mVideoSeq != paramErrorMessage.c().mVideoSeq))
      {
        qrs.a(this.jdField_a_of_type_Qrs$a.this$0).d = parama.a();
        qrs.a(this.jdField_a_of_type_Qrs$a.this$0).I(parampyk.a(qrs.a(this.jdField_a_of_type_Qrs$a.this$0), parama.bS(), true), true);
        ((qvi)psx.a(12)).a(2, qrs.a(this.jdField_a_of_type_Qrs$a.this$0).d.feedId, qrs.a(this.jdField_a_of_type_Qrs$a.this$0).b().mVideoSeq, qrs.a(this.jdField_a_of_type_Qrs$a.this$0).bS(), qrs.a(this.jdField_a_of_type_Qrs$a.this$0).b().mVideoNextCookie, qrs.a(this.jdField_a_of_type_Qrs$a.this$0).b().mIsVideoEnd, qrs.a(this.jdField_a_of_type_Qrs$a.this$0).b().mVideoPullType, true);
      }
    }
    for (;;)
    {
      qrs.a(this.jdField_a_of_type_Qrs$a.this$0).d = ((CommentLikeFeedItem)parampyk.a(qrs.a(this.jdField_a_of_type_Qrs$a.this$0).d));
      qrs.a.a(this.jdField_a_of_type_Qrs$a, qrs.a(this.jdField_a_of_type_Qrs$a.this$0));
      return;
      qrs.a(this.jdField_a_of_type_Qrs$a.this$0).d = parama.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrt
 * JD-Core Version:    0.7.0.1
 */