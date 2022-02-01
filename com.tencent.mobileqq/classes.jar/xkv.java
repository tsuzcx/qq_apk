import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class xkv
  implements wld<wyj, wyk>
{
  xkv(xku paramxku, JobContext paramJobContext, ycb paramycb) {}
  
  public void a(@NonNull wyj paramwyj, @Nullable wyk paramwyk, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwyk == null))
    {
      yqp.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      xku.a(this.jdField_a_of_type_Xku, paramErrorMessage);
      return;
    }
    paramwyj = (yij)wpm.a(11);
    if (paramwyk.a.size() < 1)
    {
      yqp.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramwyj.a(xko.a(this.jdField_a_of_type_Xku.a));
      paramwyj = new ErrorMessage(2222, "no feed data back.");
      xku.b(this.jdField_a_of_type_Xku, paramwyj);
      return;
    }
    paramwyk = (yht)paramwyk.a.get(0);
    if ((paramwyk instanceof yka))
    {
      paramErrorMessage = (yka)paramwyk;
      this.jdField_a_of_type_Ycb.a = paramwyk.a();
      this.jdField_a_of_type_Ycb.a(paramwyj.a(xko.a(this.jdField_a_of_type_Xku.a), paramErrorMessage.a(), true), true);
      ((yip)wpm.a(12)).a(2, this.jdField_a_of_type_Ycb.a.feedId, this.jdField_a_of_type_Ycb.a().mVideoSeq, this.jdField_a_of_type_Ycb.a(), this.jdField_a_of_type_Ycb.a().mVideoNextCookie, this.jdField_a_of_type_Ycb.a().mIsVideoEnd, this.jdField_a_of_type_Ycb.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ycb.a = ((CommentLikeFeedItem)paramwyj.a(xko.a(this.jdField_a_of_type_Xku.a).a));
      xku.a(this.jdField_a_of_type_Xku, this.jdField_a_of_type_Ycb);
      return;
      this.jdField_a_of_type_Ycb.a = paramwyk.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkv
 * JD-Core Version:    0.7.0.1
 */