import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class vrk
  implements urr<vex, vey>
{
  vrk(vrj paramvrj, JobContext paramJobContext, wiq paramwiq) {}
  
  public void a(@NonNull vex paramvex, @Nullable vey paramvey, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvey == null))
    {
      wxe.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      vrj.a(this.jdField_a_of_type_Vrj, paramErrorMessage);
      return;
    }
    paramvex = (woy)uwa.a(11);
    if (paramvey.a.size() < 1)
    {
      wxe.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramvex.a(vrd.a(this.jdField_a_of_type_Vrj.a));
      paramvex = new ErrorMessage(2222, "no feed data back.");
      vrj.b(this.jdField_a_of_type_Vrj, paramvex);
      return;
    }
    paramvey = (woi)paramvey.a.get(0);
    if ((paramvey instanceof wqp))
    {
      paramErrorMessage = (wqp)paramvey;
      this.jdField_a_of_type_Wiq.a = paramvey.a();
      this.jdField_a_of_type_Wiq.a(paramvex.a(vrd.a(this.jdField_a_of_type_Vrj.a), paramErrorMessage.a(), true), true);
      ((wpe)uwa.a(12)).a(2, this.jdField_a_of_type_Wiq.a.feedId, this.jdField_a_of_type_Wiq.a().mVideoSeq, this.jdField_a_of_type_Wiq.a(), this.jdField_a_of_type_Wiq.a().mVideoNextCookie, this.jdField_a_of_type_Wiq.a().mIsVideoEnd, this.jdField_a_of_type_Wiq.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Wiq.a = ((CommentLikeFeedItem)paramvex.a(vrd.a(this.jdField_a_of_type_Vrj.a).a));
      vrj.a(this.jdField_a_of_type_Vrj, this.jdField_a_of_type_Wiq);
      return;
      this.jdField_a_of_type_Wiq.a = paramvey.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrk
 * JD-Core Version:    0.7.0.1
 */