import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class xew
  implements wfk<wsp, wsq>
{
  xew(xev paramxev, JobContext paramJobContext, xwc paramxwc) {}
  
  public void a(@NonNull wsp paramwsp, @Nullable wsq paramwsq, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwsq == null))
    {
      ykq.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      xev.a(this.jdField_a_of_type_Xev, paramErrorMessage);
      return;
    }
    paramwsp = (yck)wjs.a(11);
    if (paramwsq.a.size() < 1)
    {
      ykq.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramwsp.a(xep.a(this.jdField_a_of_type_Xev.a));
      paramwsp = new ErrorMessage(2222, "no feed data back.");
      xev.b(this.jdField_a_of_type_Xev, paramwsp);
      return;
    }
    paramwsq = (ybu)paramwsq.a.get(0);
    if ((paramwsq instanceof yeb))
    {
      paramErrorMessage = (yeb)paramwsq;
      this.jdField_a_of_type_Xwc.a = paramwsq.a();
      this.jdField_a_of_type_Xwc.a(paramwsp.a(xep.a(this.jdField_a_of_type_Xev.a), paramErrorMessage.a(), true), true);
      ((ycq)wjs.a(12)).a(2, this.jdField_a_of_type_Xwc.a.feedId, this.jdField_a_of_type_Xwc.a().mVideoSeq, this.jdField_a_of_type_Xwc.a(), this.jdField_a_of_type_Xwc.a().mVideoNextCookie, this.jdField_a_of_type_Xwc.a().mIsVideoEnd, this.jdField_a_of_type_Xwc.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xwc.a = ((CommentLikeFeedItem)paramwsp.a(xep.a(this.jdField_a_of_type_Xev.a).a));
      xev.a(this.jdField_a_of_type_Xev, this.jdField_a_of_type_Xwc);
      return;
      this.jdField_a_of_type_Xwc.a = paramwsq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xew
 * JD-Core Version:    0.7.0.1
 */