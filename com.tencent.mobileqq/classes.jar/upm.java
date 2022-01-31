import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class upm
  implements syq<tlw, tlx>
{
  upm(upl paramupl, JobContext paramJobContext) {}
  
  public void a(@NonNull tlw paramtlw, @Nullable tlx paramtlx, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtlx == null))
    {
      ved.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      upl.a(this.jdField_a_of_type_Upl, paramErrorMessage);
      return;
    }
    paramtlw = (uvx)tcz.a(11);
    if (paramtlx.a.size() < 1)
    {
      ved.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramtlw.a(upk.a(this.jdField_a_of_type_Upl.a));
      paramtlw = new ErrorMessage(2222, "no feed data back.");
      upl.b(this.jdField_a_of_type_Upl, paramtlw);
      return;
    }
    paramtlx = (uvh)paramtlx.a.get(0);
    if ((paramtlx instanceof uxo))
    {
      paramErrorMessage = (uxo)paramtlx;
      if ((upk.a(this.jdField_a_of_type_Upl.a).a == null) || (upk.a(this.jdField_a_of_type_Upl.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        upk.a(this.jdField_a_of_type_Upl.a).a = paramtlx.a();
        upk.a(this.jdField_a_of_type_Upl.a).a(paramtlw.a(upk.a(this.jdField_a_of_type_Upl.a), paramtlx.a(), true), true);
        ((uwd)tcz.a(12)).a(2, upk.a(this.jdField_a_of_type_Upl.a).a.feedId, upk.a(this.jdField_a_of_type_Upl.a).a().mVideoSeq, upk.a(this.jdField_a_of_type_Upl.a).a(), upk.a(this.jdField_a_of_type_Upl.a).a().mVideoNextCookie, upk.a(this.jdField_a_of_type_Upl.a).a().mIsVideoEnd, upk.a(this.jdField_a_of_type_Upl.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      upk.a(this.jdField_a_of_type_Upl.a).a = ((CommentLikeFeedItem)paramtlw.a(upk.a(this.jdField_a_of_type_Upl.a).a));
      upl.a(this.jdField_a_of_type_Upl, upk.a(this.jdField_a_of_type_Upl.a));
      return;
      upk.a(this.jdField_a_of_type_Upl.a).a = paramtlx.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upm
 * JD-Core Version:    0.7.0.1
 */