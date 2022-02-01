import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class wqb
  implements vqp<wdu, wdv>
{
  wqb(wqa paramwqa, JobContext paramJobContext, xhh paramxhh) {}
  
  public void a(@NonNull wdu paramwdu, @Nullable wdv paramwdv, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwdv == null))
    {
      xvv.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      wqa.a(this.jdField_a_of_type_Wqa, paramErrorMessage);
      return;
    }
    paramwdu = (xnp)vux.a(11);
    if (paramwdv.a.size() < 1)
    {
      xvv.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramwdu.a(wpu.a(this.jdField_a_of_type_Wqa.a));
      paramwdu = new ErrorMessage(2222, "no feed data back.");
      wqa.b(this.jdField_a_of_type_Wqa, paramwdu);
      return;
    }
    paramwdv = (xmz)paramwdv.a.get(0);
    if ((paramwdv instanceof xpg))
    {
      paramErrorMessage = (xpg)paramwdv;
      this.jdField_a_of_type_Xhh.a = paramwdv.a();
      this.jdField_a_of_type_Xhh.a(paramwdu.a(wpu.a(this.jdField_a_of_type_Wqa.a), paramErrorMessage.a(), true), true);
      ((xnv)vux.a(12)).a(2, this.jdField_a_of_type_Xhh.a.feedId, this.jdField_a_of_type_Xhh.a().mVideoSeq, this.jdField_a_of_type_Xhh.a(), this.jdField_a_of_type_Xhh.a().mVideoNextCookie, this.jdField_a_of_type_Xhh.a().mIsVideoEnd, this.jdField_a_of_type_Xhh.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xhh.a = ((CommentLikeFeedItem)paramwdu.a(wpu.a(this.jdField_a_of_type_Wqa.a).a));
      wqa.a(this.jdField_a_of_type_Wqa, this.jdField_a_of_type_Xhh);
      return;
      this.jdField_a_of_type_Xhh.a = paramwdv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqb
 * JD-Core Version:    0.7.0.1
 */