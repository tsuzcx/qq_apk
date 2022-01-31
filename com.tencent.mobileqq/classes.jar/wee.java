import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class wee
  implements uni<vao, vap>
{
  wee(wed paramwed, JobContext paramJobContext) {}
  
  public void a(@NonNull vao paramvao, @Nullable vap paramvap, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvap == null))
    {
      wsv.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      wed.a(this.jdField_a_of_type_Wed, paramErrorMessage);
      return;
    }
    paramvao = (wkp)urr.a(11);
    if (paramvap.a.size() < 1)
    {
      wsv.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramvao.a(wec.a(this.jdField_a_of_type_Wed.a));
      paramvao = new ErrorMessage(2222, "no feed data back.");
      wed.b(this.jdField_a_of_type_Wed, paramvao);
      return;
    }
    paramvap = (wjz)paramvap.a.get(0);
    if ((paramvap instanceof wmg))
    {
      paramErrorMessage = (wmg)paramvap;
      if ((wec.a(this.jdField_a_of_type_Wed.a).a == null) || (wec.a(this.jdField_a_of_type_Wed.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        wec.a(this.jdField_a_of_type_Wed.a).a = paramvap.a();
        wec.a(this.jdField_a_of_type_Wed.a).a(paramvao.a(wec.a(this.jdField_a_of_type_Wed.a), paramvap.a(), true), true);
        ((wkv)urr.a(12)).a(2, wec.a(this.jdField_a_of_type_Wed.a).a.feedId, wec.a(this.jdField_a_of_type_Wed.a).a().mVideoSeq, wec.a(this.jdField_a_of_type_Wed.a).a(), wec.a(this.jdField_a_of_type_Wed.a).a().mVideoNextCookie, wec.a(this.jdField_a_of_type_Wed.a).a().mIsVideoEnd, wec.a(this.jdField_a_of_type_Wed.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      wec.a(this.jdField_a_of_type_Wed.a).a = ((CommentLikeFeedItem)paramvao.a(wec.a(this.jdField_a_of_type_Wed.a).a));
      wed.a(this.jdField_a_of_type_Wed, wec.a(this.jdField_a_of_type_Wed.a));
      return;
      wec.a(this.jdField_a_of_type_Wed.a).a = paramvap.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wee
 * JD-Core Version:    0.7.0.1
 */