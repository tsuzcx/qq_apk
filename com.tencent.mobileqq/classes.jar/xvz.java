import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class xvz
  implements wfk<wsp, wsq>
{
  xvz(xvy paramxvy, JobContext paramJobContext) {}
  
  public void a(@NonNull wsp paramwsp, @Nullable wsq paramwsq, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwsq == null))
    {
      ykq.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      xvy.a(this.jdField_a_of_type_Xvy, paramErrorMessage);
      return;
    }
    paramwsp = (yck)wjs.a(11);
    if (paramwsq.a.size() < 1)
    {
      ykq.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramwsp.a(xvx.a(this.jdField_a_of_type_Xvy.a));
      paramwsp = new ErrorMessage(2222, "no feed data back.");
      xvy.b(this.jdField_a_of_type_Xvy, paramwsp);
      return;
    }
    paramwsq = (ybu)paramwsq.a.get(0);
    if ((paramwsq instanceof yeb))
    {
      paramErrorMessage = (yeb)paramwsq;
      if ((xvx.a(this.jdField_a_of_type_Xvy.a).a == null) || (xvx.a(this.jdField_a_of_type_Xvy.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        xvx.a(this.jdField_a_of_type_Xvy.a).a = paramwsq.a();
        xvx.a(this.jdField_a_of_type_Xvy.a).a(paramwsp.a(xvx.a(this.jdField_a_of_type_Xvy.a), paramwsq.a(), true), true);
        ((ycq)wjs.a(12)).a(2, xvx.a(this.jdField_a_of_type_Xvy.a).a.feedId, xvx.a(this.jdField_a_of_type_Xvy.a).a().mVideoSeq, xvx.a(this.jdField_a_of_type_Xvy.a).a(), xvx.a(this.jdField_a_of_type_Xvy.a).a().mVideoNextCookie, xvx.a(this.jdField_a_of_type_Xvy.a).a().mIsVideoEnd, xvx.a(this.jdField_a_of_type_Xvy.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      xvx.a(this.jdField_a_of_type_Xvy.a).a = ((CommentLikeFeedItem)paramwsp.a(xvx.a(this.jdField_a_of_type_Xvy.a).a));
      xvy.a(this.jdField_a_of_type_Xvy, xvx.a(this.jdField_a_of_type_Xvy.a));
      return;
      xvx.a(this.jdField_a_of_type_Xvy.a).a = paramwsq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvz
 * JD-Core Version:    0.7.0.1
 */