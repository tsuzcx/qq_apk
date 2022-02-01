import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class xoq
  implements woy<xce, xcf>
{
  xoq(xop paramxop, JobContext paramJobContext, yfw paramyfw) {}
  
  public void a(@NonNull xce paramxce, @Nullable xcf paramxcf, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramxcf == null))
    {
      yuk.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      xop.a(this.jdField_a_of_type_Xop, paramErrorMessage);
      return;
    }
    paramxce = (yme)wth.a(11);
    if (paramxcf.a.size() < 1)
    {
      yuk.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramxce.a(xoj.a(this.jdField_a_of_type_Xop.a));
      paramxce = new ErrorMessage(2222, "no feed data back.");
      xop.b(this.jdField_a_of_type_Xop, paramxce);
      return;
    }
    paramxcf = (ylo)paramxcf.a.get(0);
    if ((paramxcf instanceof ynv))
    {
      paramErrorMessage = (ynv)paramxcf;
      this.jdField_a_of_type_Yfw.a = paramxcf.a();
      this.jdField_a_of_type_Yfw.a(paramxce.a(xoj.a(this.jdField_a_of_type_Xop.a), paramErrorMessage.a(), true), true);
      ((ymk)wth.a(12)).a(2, this.jdField_a_of_type_Yfw.a.feedId, this.jdField_a_of_type_Yfw.a().mVideoSeq, this.jdField_a_of_type_Yfw.a(), this.jdField_a_of_type_Yfw.a().mVideoNextCookie, this.jdField_a_of_type_Yfw.a().mIsVideoEnd, this.jdField_a_of_type_Yfw.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Yfw.a = ((CommentLikeFeedItem)paramxce.a(xoj.a(this.jdField_a_of_type_Xop.a).a));
      xop.a(this.jdField_a_of_type_Xop, this.jdField_a_of_type_Yfw);
      return;
      this.jdField_a_of_type_Yfw.a = paramxcf.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoq
 * JD-Core Version:    0.7.0.1
 */