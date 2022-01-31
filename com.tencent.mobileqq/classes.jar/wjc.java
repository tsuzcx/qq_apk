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

class wjc
  implements urr<vex, vey>
{
  wjc(wjb paramwjb) {}
  
  public void a(@NonNull vex paramvex, @Nullable vey arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (wjb.a(this.a))
    {
      wxe.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramvex = new wje(paramErrorMessage, wjb.a(this.a));
    paramvex.d = this.a.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      wxe.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", wjb.a(this.a));
      wjb.a(this.a, paramvex);
      return;
    }
    ??? = (wqn)???.jdField_a_of_type_JavaUtilList.get(0);
    if (!(??? instanceof wqp))
    {
      paramvex.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940001, alud.a(2131716702));
      wjb.a(this.a, paramvex);
      xqq.a(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (wqp)???;
    wjb.a(this.a, ???.a().mVideoNextCookie);
    wjb.a(this.a, ???.a().mVideoPullType);
    wjb.b(this.a, ???.a().mVideoSeq);
    paramvex.jdField_a_of_type_Boolean = ???.a().mIsVideoEnd;
    paramvex.jdField_a_of_type_JavaUtilList = ???.a();
    paramvex.c = true;
    if ((!paramvex.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(wjb.b(this.a)))) {
      paramvex.jdField_a_of_type_Boolean = true;
    }
    paramvex.b = ???.a().getOwner().getUnionId();
    paramvex.jdField_a_of_type_JavaUtilList = ((woy)uwa.a(11)).a(wjb.a(this.a), paramvex.jdField_a_of_type_JavaUtilList, paramvex.c);
    paramvex.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(wjb.a(this.a), wjb.b(this.a), wjb.a(this.a), wjb.b(this.a), paramvex.jdField_a_of_type_Boolean);
    ??? = new ArrayList(paramvex.jdField_a_of_type_JavaUtilList.size());
    paramErrorMessage = paramvex.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    vdm.a(???);
    synchronized (this.a)
    {
      this.a.b = true;
      wjb.a(this.a, paramvex);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wjc
 * JD-Core Version:    0.7.0.1
 */