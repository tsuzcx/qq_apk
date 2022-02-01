import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class xwo
  implements wfk<wsp, wsq>
{
  xwo(xwn paramxwn) {}
  
  public void a(@NonNull wsp paramwsp, @Nullable wsq arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (xwn.a(this.a))
    {
      ykq.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramwsp = new xwq(paramErrorMessage, xwn.a(this.a));
    paramwsp.d = this.a.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      ykq.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", xwn.a(this.a));
      xwn.a(this.a, paramwsp);
      return;
    }
    ??? = (ydz)???.jdField_a_of_type_JavaUtilList.get(0);
    if (!(??? instanceof yeb))
    {
      paramwsp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940001, anvx.a(2131715670));
      xwn.a(this.a, paramwsp);
      zdl.a(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (yeb)???;
    xwn.a(this.a, ???.a().mVideoNextCookie);
    xwn.a(this.a, ???.a().mVideoPullType);
    xwn.b(this.a, ???.a().mVideoSeq);
    paramwsp.jdField_a_of_type_Boolean = ???.a().mIsVideoEnd;
    paramwsp.jdField_a_of_type_JavaUtilList = ???.a();
    paramwsp.c = true;
    if ((!paramwsp.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(xwn.b(this.a)))) {
      paramwsp.jdField_a_of_type_Boolean = true;
    }
    paramwsp.b = ???.a().getOwner().getUnionId();
    paramwsp.jdField_a_of_type_JavaUtilList = ((yck)wjs.a(11)).a(xwn.a(this.a), paramwsp.jdField_a_of_type_JavaUtilList, paramwsp.c);
    paramwsp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(xwn.a(this.a), xwn.b(this.a), xwn.a(this.a), xwn.b(this.a), paramwsp.jdField_a_of_type_Boolean);
    ??? = new ArrayList(paramwsp.jdField_a_of_type_JavaUtilList.size());
    paramErrorMessage = paramwsp.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    wre.a(???);
    synchronized (this.a)
    {
      this.a.b = true;
      xwn.a(this.a, paramwsp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwo
 * JD-Core Version:    0.7.0.1
 */