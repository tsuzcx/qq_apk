import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class tyj
  implements syq<tlw, tlx>
{
  tyj(tyi paramtyi, JobContext paramJobContext, upp paramupp) {}
  
  public void a(@NonNull tlw paramtlw, @Nullable tlx paramtlx, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtlx == null))
    {
      ved.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      tyi.a(this.jdField_a_of_type_Tyi, paramErrorMessage);
      return;
    }
    paramtlw = (uvx)tcz.a(11);
    if (paramtlx.a.size() < 1)
    {
      ved.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramtlw.a(tyc.a(this.jdField_a_of_type_Tyi.a));
      paramtlw = new ErrorMessage(2222, "no feed data back.");
      tyi.b(this.jdField_a_of_type_Tyi, paramtlw);
      return;
    }
    paramtlx = (uvh)paramtlx.a.get(0);
    if ((paramtlx instanceof uxo))
    {
      paramErrorMessage = (uxo)paramtlx;
      this.jdField_a_of_type_Upp.a = paramtlx.a();
      this.jdField_a_of_type_Upp.a(paramtlw.a(tyc.a(this.jdField_a_of_type_Tyi.a), paramErrorMessage.a(), true), true);
      ((uwd)tcz.a(12)).a(2, this.jdField_a_of_type_Upp.a.feedId, this.jdField_a_of_type_Upp.a().mVideoSeq, this.jdField_a_of_type_Upp.a(), this.jdField_a_of_type_Upp.a().mVideoNextCookie, this.jdField_a_of_type_Upp.a().mIsVideoEnd, this.jdField_a_of_type_Upp.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Upp.a = ((CommentLikeFeedItem)paramtlw.a(tyc.a(this.jdField_a_of_type_Tyi.a).a));
      tyi.a(this.jdField_a_of_type_Tyi, this.jdField_a_of_type_Upp);
      return;
      this.jdField_a_of_type_Upp.a = paramtlx.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyj
 * JD-Core Version:    0.7.0.1
 */