import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class tlq
  implements slx<szd, sze>
{
  tlq(tlp paramtlp, JobContext paramJobContext, ucw paramucw) {}
  
  public void a(@NonNull szd paramszd, @Nullable sze paramsze, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramsze == null))
    {
      urk.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      tlp.a(this.jdField_a_of_type_Tlp, paramErrorMessage);
      return;
    }
    paramszd = (uje)sqg.a(11);
    if (paramsze.a.size() < 1)
    {
      urk.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramszd.a(tlj.a(this.jdField_a_of_type_Tlp.a));
      paramszd = new ErrorMessage(2222, "no feed data back.");
      tlp.b(this.jdField_a_of_type_Tlp, paramszd);
      return;
    }
    paramsze = (uio)paramsze.a.get(0);
    if ((paramsze instanceof ukv))
    {
      paramErrorMessage = (ukv)paramsze;
      this.jdField_a_of_type_Ucw.a = paramsze.a();
      this.jdField_a_of_type_Ucw.a(paramszd.a(tlj.a(this.jdField_a_of_type_Tlp.a), paramErrorMessage.a(), true), true);
      ((ujk)sqg.a(12)).a(2, this.jdField_a_of_type_Ucw.a.feedId, this.jdField_a_of_type_Ucw.a().mVideoSeq, this.jdField_a_of_type_Ucw.a(), this.jdField_a_of_type_Ucw.a().mVideoNextCookie, this.jdField_a_of_type_Ucw.a().mIsVideoEnd, this.jdField_a_of_type_Ucw.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ucw.a = ((CommentLikeFeedItem)paramszd.a(tlj.a(this.jdField_a_of_type_Tlp.a).a));
      tlp.a(this.jdField_a_of_type_Tlp, this.jdField_a_of_type_Ucw);
      return;
      this.jdField_a_of_type_Ucw.a = paramsze.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlq
 * JD-Core Version:    0.7.0.1
 */