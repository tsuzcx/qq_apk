import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class tym
  implements syt<tlz, tma>
{
  tym(tyl paramtyl, JobContext paramJobContext, ups paramups) {}
  
  public void a(@NonNull tlz paramtlz, @Nullable tma paramtma, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtma == null))
    {
      veg.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      tyl.a(this.jdField_a_of_type_Tyl, paramErrorMessage);
      return;
    }
    paramtlz = (uwa)tdc.a(11);
    if (paramtma.a.size() < 1)
    {
      veg.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramtlz.a(tyf.a(this.jdField_a_of_type_Tyl.a));
      paramtlz = new ErrorMessage(2222, "no feed data back.");
      tyl.b(this.jdField_a_of_type_Tyl, paramtlz);
      return;
    }
    paramtma = (uvk)paramtma.a.get(0);
    if ((paramtma instanceof uxr))
    {
      paramErrorMessage = (uxr)paramtma;
      this.jdField_a_of_type_Ups.a = paramtma.a();
      this.jdField_a_of_type_Ups.a(paramtlz.a(tyf.a(this.jdField_a_of_type_Tyl.a), paramErrorMessage.a(), true), true);
      ((uwg)tdc.a(12)).a(2, this.jdField_a_of_type_Ups.a.feedId, this.jdField_a_of_type_Ups.a().mVideoSeq, this.jdField_a_of_type_Ups.a(), this.jdField_a_of_type_Ups.a().mVideoNextCookie, this.jdField_a_of_type_Ups.a().mIsVideoEnd, this.jdField_a_of_type_Ups.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ups.a = ((CommentLikeFeedItem)paramtlz.a(tyf.a(this.jdField_a_of_type_Tyl.a).a));
      tyl.a(this.jdField_a_of_type_Tyl, this.jdField_a_of_type_Ups);
      return;
      this.jdField_a_of_type_Ups.a = paramtma.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tym
 * JD-Core Version:    0.7.0.1
 */