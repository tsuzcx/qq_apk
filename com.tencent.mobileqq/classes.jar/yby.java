import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class yby
  implements wld<wyj, wyk>
{
  yby(ybx paramybx, JobContext paramJobContext) {}
  
  public void a(@NonNull wyj paramwyj, @Nullable wyk paramwyk, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwyk == null))
    {
      yqp.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      ybx.a(this.jdField_a_of_type_Ybx, paramErrorMessage);
      return;
    }
    paramwyj = (yij)wpm.a(11);
    if (paramwyk.a.size() < 1)
    {
      yqp.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramwyj.a(ybw.a(this.jdField_a_of_type_Ybx.a));
      paramwyj = new ErrorMessage(2222, "no feed data back.");
      ybx.b(this.jdField_a_of_type_Ybx, paramwyj);
      return;
    }
    paramwyk = (yht)paramwyk.a.get(0);
    if ((paramwyk instanceof yka))
    {
      paramErrorMessage = (yka)paramwyk;
      if ((ybw.a(this.jdField_a_of_type_Ybx.a).a == null) || (ybw.a(this.jdField_a_of_type_Ybx.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        ybw.a(this.jdField_a_of_type_Ybx.a).a = paramwyk.a();
        ybw.a(this.jdField_a_of_type_Ybx.a).a(paramwyj.a(ybw.a(this.jdField_a_of_type_Ybx.a), paramwyk.a(), true), true);
        ((yip)wpm.a(12)).a(2, ybw.a(this.jdField_a_of_type_Ybx.a).a.feedId, ybw.a(this.jdField_a_of_type_Ybx.a).a().mVideoSeq, ybw.a(this.jdField_a_of_type_Ybx.a).a(), ybw.a(this.jdField_a_of_type_Ybx.a).a().mVideoNextCookie, ybw.a(this.jdField_a_of_type_Ybx.a).a().mIsVideoEnd, ybw.a(this.jdField_a_of_type_Ybx.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      ybw.a(this.jdField_a_of_type_Ybx.a).a = ((CommentLikeFeedItem)paramwyj.a(ybw.a(this.jdField_a_of_type_Ybx.a).a));
      ybx.a(this.jdField_a_of_type_Ybx, ybw.a(this.jdField_a_of_type_Ybx.a));
      return;
      ybw.a(this.jdField_a_of_type_Ybx.a).a = paramwyk.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yby
 * JD-Core Version:    0.7.0.1
 */