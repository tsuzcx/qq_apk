import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class win
  implements urr<vex, vey>
{
  win(wim paramwim, JobContext paramJobContext) {}
  
  public void a(@NonNull vex paramvex, @Nullable vey paramvey, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvey == null))
    {
      wxe.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      wim.a(this.jdField_a_of_type_Wim, paramErrorMessage);
      return;
    }
    paramvex = (woy)uwa.a(11);
    if (paramvey.a.size() < 1)
    {
      wxe.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramvex.a(wil.a(this.jdField_a_of_type_Wim.a));
      paramvex = new ErrorMessage(2222, "no feed data back.");
      wim.b(this.jdField_a_of_type_Wim, paramvex);
      return;
    }
    paramvey = (woi)paramvey.a.get(0);
    if ((paramvey instanceof wqp))
    {
      paramErrorMessage = (wqp)paramvey;
      if ((wil.a(this.jdField_a_of_type_Wim.a).a == null) || (wil.a(this.jdField_a_of_type_Wim.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        wil.a(this.jdField_a_of_type_Wim.a).a = paramvey.a();
        wil.a(this.jdField_a_of_type_Wim.a).a(paramvex.a(wil.a(this.jdField_a_of_type_Wim.a), paramvey.a(), true), true);
        ((wpe)uwa.a(12)).a(2, wil.a(this.jdField_a_of_type_Wim.a).a.feedId, wil.a(this.jdField_a_of_type_Wim.a).a().mVideoSeq, wil.a(this.jdField_a_of_type_Wim.a).a(), wil.a(this.jdField_a_of_type_Wim.a).a().mVideoNextCookie, wil.a(this.jdField_a_of_type_Wim.a).a().mIsVideoEnd, wil.a(this.jdField_a_of_type_Wim.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      wil.a(this.jdField_a_of_type_Wim.a).a = ((CommentLikeFeedItem)paramvex.a(wil.a(this.jdField_a_of_type_Wim.a).a));
      wim.a(this.jdField_a_of_type_Wim, wil.a(this.jdField_a_of_type_Wim.a));
      return;
      wil.a(this.jdField_a_of_type_Wim.a).a = paramvey.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     win
 * JD-Core Version:    0.7.0.1
 */