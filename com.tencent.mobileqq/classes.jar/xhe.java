import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class xhe
  implements vqp<wdu, wdv>
{
  xhe(xhd paramxhd, JobContext paramJobContext) {}
  
  public void a(@NonNull wdu paramwdu, @Nullable wdv paramwdv, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwdv == null))
    {
      xvv.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      xhd.a(this.jdField_a_of_type_Xhd, paramErrorMessage);
      return;
    }
    paramwdu = (xnp)vux.a(11);
    if (paramwdv.a.size() < 1)
    {
      xvv.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramwdu.a(xhc.a(this.jdField_a_of_type_Xhd.a));
      paramwdu = new ErrorMessage(2222, "no feed data back.");
      xhd.b(this.jdField_a_of_type_Xhd, paramwdu);
      return;
    }
    paramwdv = (xmz)paramwdv.a.get(0);
    if ((paramwdv instanceof xpg))
    {
      paramErrorMessage = (xpg)paramwdv;
      if ((xhc.a(this.jdField_a_of_type_Xhd.a).a == null) || (xhc.a(this.jdField_a_of_type_Xhd.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        xhc.a(this.jdField_a_of_type_Xhd.a).a = paramwdv.a();
        xhc.a(this.jdField_a_of_type_Xhd.a).a(paramwdu.a(xhc.a(this.jdField_a_of_type_Xhd.a), paramwdv.a(), true), true);
        ((xnv)vux.a(12)).a(2, xhc.a(this.jdField_a_of_type_Xhd.a).a.feedId, xhc.a(this.jdField_a_of_type_Xhd.a).a().mVideoSeq, xhc.a(this.jdField_a_of_type_Xhd.a).a(), xhc.a(this.jdField_a_of_type_Xhd.a).a().mVideoNextCookie, xhc.a(this.jdField_a_of_type_Xhd.a).a().mIsVideoEnd, xhc.a(this.jdField_a_of_type_Xhd.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      xhc.a(this.jdField_a_of_type_Xhd.a).a = ((CommentLikeFeedItem)paramwdu.a(xhc.a(this.jdField_a_of_type_Xhd.a).a));
      xhd.a(this.jdField_a_of_type_Xhd, xhc.a(this.jdField_a_of_type_Xhd.a));
      return;
      xhc.a(this.jdField_a_of_type_Xhd.a).a = paramwdv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhe
 * JD-Core Version:    0.7.0.1
 */