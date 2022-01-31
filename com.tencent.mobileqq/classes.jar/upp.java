import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class upp
  implements syt<tlz, tma>
{
  upp(upo paramupo, JobContext paramJobContext) {}
  
  public void a(@NonNull tlz paramtlz, @Nullable tma paramtma, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtma == null))
    {
      veg.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      upo.a(this.jdField_a_of_type_Upo, paramErrorMessage);
      return;
    }
    paramtlz = (uwa)tdc.a(11);
    if (paramtma.a.size() < 1)
    {
      veg.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramtlz.a(upn.a(this.jdField_a_of_type_Upo.a));
      paramtlz = new ErrorMessage(2222, "no feed data back.");
      upo.b(this.jdField_a_of_type_Upo, paramtlz);
      return;
    }
    paramtma = (uvk)paramtma.a.get(0);
    if ((paramtma instanceof uxr))
    {
      paramErrorMessage = (uxr)paramtma;
      if ((upn.a(this.jdField_a_of_type_Upo.a).a == null) || (upn.a(this.jdField_a_of_type_Upo.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        upn.a(this.jdField_a_of_type_Upo.a).a = paramtma.a();
        upn.a(this.jdField_a_of_type_Upo.a).a(paramtlz.a(upn.a(this.jdField_a_of_type_Upo.a), paramtma.a(), true), true);
        ((uwg)tdc.a(12)).a(2, upn.a(this.jdField_a_of_type_Upo.a).a.feedId, upn.a(this.jdField_a_of_type_Upo.a).a().mVideoSeq, upn.a(this.jdField_a_of_type_Upo.a).a(), upn.a(this.jdField_a_of_type_Upo.a).a().mVideoNextCookie, upn.a(this.jdField_a_of_type_Upo.a).a().mIsVideoEnd, upn.a(this.jdField_a_of_type_Upo.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      upn.a(this.jdField_a_of_type_Upo.a).a = ((CommentLikeFeedItem)paramtlz.a(upn.a(this.jdField_a_of_type_Upo.a).a));
      upo.a(this.jdField_a_of_type_Upo, upn.a(this.jdField_a_of_type_Upo.a));
      return;
      upn.a(this.jdField_a_of_type_Upo.a).a = paramtma.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upp
 * JD-Core Version:    0.7.0.1
 */