import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class uct
  implements slx<szd, sze>
{
  uct(ucs paramucs, JobContext paramJobContext) {}
  
  public void a(@NonNull szd paramszd, @Nullable sze paramsze, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramsze == null))
    {
      urk.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      ucs.a(this.jdField_a_of_type_Ucs, paramErrorMessage);
      return;
    }
    paramszd = (uje)sqg.a(11);
    if (paramsze.a.size() < 1)
    {
      urk.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramszd.a(ucr.a(this.jdField_a_of_type_Ucs.a));
      paramszd = new ErrorMessage(2222, "no feed data back.");
      ucs.b(this.jdField_a_of_type_Ucs, paramszd);
      return;
    }
    paramsze = (uio)paramsze.a.get(0);
    if ((paramsze instanceof ukv))
    {
      paramErrorMessage = (ukv)paramsze;
      if ((ucr.a(this.jdField_a_of_type_Ucs.a).a == null) || (ucr.a(this.jdField_a_of_type_Ucs.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        ucr.a(this.jdField_a_of_type_Ucs.a).a = paramsze.a();
        ucr.a(this.jdField_a_of_type_Ucs.a).a(paramszd.a(ucr.a(this.jdField_a_of_type_Ucs.a), paramsze.a(), true), true);
        ((ujk)sqg.a(12)).a(2, ucr.a(this.jdField_a_of_type_Ucs.a).a.feedId, ucr.a(this.jdField_a_of_type_Ucs.a).a().mVideoSeq, ucr.a(this.jdField_a_of_type_Ucs.a).a(), ucr.a(this.jdField_a_of_type_Ucs.a).a().mVideoNextCookie, ucr.a(this.jdField_a_of_type_Ucs.a).a().mIsVideoEnd, ucr.a(this.jdField_a_of_type_Ucs.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      ucr.a(this.jdField_a_of_type_Ucs.a).a = ((CommentLikeFeedItem)paramszd.a(ucr.a(this.jdField_a_of_type_Ucs.a).a));
      ucs.a(this.jdField_a_of_type_Ucs, ucr.a(this.jdField_a_of_type_Ucs.a));
      return;
      ucr.a(this.jdField_a_of_type_Ucs.a).a = paramsze.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uct
 * JD-Core Version:    0.7.0.1
 */