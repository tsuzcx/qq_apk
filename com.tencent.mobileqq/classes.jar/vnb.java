import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class vnb
  implements uni<vao, vap>
{
  vnb(vna paramvna, JobContext paramJobContext, weh paramweh) {}
  
  public void a(@NonNull vao paramvao, @Nullable vap paramvap, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvap == null))
    {
      wsv.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      vna.a(this.jdField_a_of_type_Vna, paramErrorMessage);
      return;
    }
    paramvao = (wkp)urr.a(11);
    if (paramvap.a.size() < 1)
    {
      wsv.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramvao.a(vmu.a(this.jdField_a_of_type_Vna.a));
      paramvao = new ErrorMessage(2222, "no feed data back.");
      vna.b(this.jdField_a_of_type_Vna, paramvao);
      return;
    }
    paramvap = (wjz)paramvap.a.get(0);
    if ((paramvap instanceof wmg))
    {
      paramErrorMessage = (wmg)paramvap;
      this.jdField_a_of_type_Weh.a = paramvap.a();
      this.jdField_a_of_type_Weh.a(paramvao.a(vmu.a(this.jdField_a_of_type_Vna.a), paramErrorMessage.a(), true), true);
      ((wkv)urr.a(12)).a(2, this.jdField_a_of_type_Weh.a.feedId, this.jdField_a_of_type_Weh.a().mVideoSeq, this.jdField_a_of_type_Weh.a(), this.jdField_a_of_type_Weh.a().mVideoNextCookie, this.jdField_a_of_type_Weh.a().mIsVideoEnd, this.jdField_a_of_type_Weh.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Weh.a = ((CommentLikeFeedItem)paramvao.a(vmu.a(this.jdField_a_of_type_Vna.a).a));
      vna.a(this.jdField_a_of_type_Vna, this.jdField_a_of_type_Weh);
      return;
      this.jdField_a_of_type_Weh.a = paramvap.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnb
 * JD-Core Version:    0.7.0.1
 */