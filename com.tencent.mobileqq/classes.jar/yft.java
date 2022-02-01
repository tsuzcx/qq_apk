import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.async.JobContext;
import java.util.List;

class yft
  implements woy<xce, xcf>
{
  yft(yfs paramyfs, JobContext paramJobContext) {}
  
  public void a(@NonNull xce paramxce, @Nullable xcf paramxcf, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramxcf == null))
    {
      yuk.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      yfs.a(this.jdField_a_of_type_Yfs, paramErrorMessage);
      return;
    }
    paramxce = (yme)wth.a(11);
    if (paramxcf.a.size() < 1)
    {
      yuk.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramxce.a(yfr.a(this.jdField_a_of_type_Yfs.a));
      paramxce = new ErrorMessage(2222, "no feed data back.");
      yfs.b(this.jdField_a_of_type_Yfs, paramxce);
      return;
    }
    paramxcf = (ylo)paramxcf.a.get(0);
    if ((paramxcf instanceof ynv))
    {
      paramErrorMessage = (ynv)paramxcf;
      if ((yfr.a(this.jdField_a_of_type_Yfs.a).a == null) || (yfr.a(this.jdField_a_of_type_Yfs.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        yfr.a(this.jdField_a_of_type_Yfs.a).a = paramxcf.a();
        yfr.a(this.jdField_a_of_type_Yfs.a).a(paramxce.a(yfr.a(this.jdField_a_of_type_Yfs.a), paramxcf.a(), true), true);
        ((ymk)wth.a(12)).a(2, yfr.a(this.jdField_a_of_type_Yfs.a).a.feedId, yfr.a(this.jdField_a_of_type_Yfs.a).a().mVideoSeq, yfr.a(this.jdField_a_of_type_Yfs.a).a(), yfr.a(this.jdField_a_of_type_Yfs.a).a().mVideoNextCookie, yfr.a(this.jdField_a_of_type_Yfs.a).a().mIsVideoEnd, yfr.a(this.jdField_a_of_type_Yfs.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      yfr.a(this.jdField_a_of_type_Yfs.a).a = ((CommentLikeFeedItem)paramxce.a(yfr.a(this.jdField_a_of_type_Yfs.a).a));
      yfs.a(this.jdField_a_of_type_Yfs, yfr.a(this.jdField_a_of_type_Yfs.a));
      return;
      yfr.a(this.jdField_a_of_type_Yfs.a).a = paramxcf.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yft
 * JD-Core Version:    0.7.0.1
 */