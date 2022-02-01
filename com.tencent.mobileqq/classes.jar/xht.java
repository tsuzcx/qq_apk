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

class xht
  implements vqp<wdu, wdv>
{
  xht(xhs paramxhs) {}
  
  public void a(@NonNull wdu paramwdu, @Nullable wdv arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (xhs.a(this.a))
    {
      xvv.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramwdu = new xhv(paramErrorMessage, xhs.a(this.a));
    paramwdu.d = this.a.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      xvv.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", xhs.a(this.a));
      xhs.a(this.a, paramwdu);
      return;
    }
    ??? = (xpe)???.jdField_a_of_type_JavaUtilList.get(0);
    if (!(??? instanceof xpg))
    {
      paramwdu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940001, amtj.a(2131715322));
      xhs.a(this.a, paramwdu);
      yos.a(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (xpg)???;
    xhs.a(this.a, ???.a().mVideoNextCookie);
    xhs.a(this.a, ???.a().mVideoPullType);
    xhs.b(this.a, ???.a().mVideoSeq);
    paramwdu.jdField_a_of_type_Boolean = ???.a().mIsVideoEnd;
    paramwdu.jdField_a_of_type_JavaUtilList = ???.a();
    paramwdu.c = true;
    if ((!paramwdu.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(xhs.b(this.a)))) {
      paramwdu.jdField_a_of_type_Boolean = true;
    }
    paramwdu.b = ???.a().getOwner().getUnionId();
    paramwdu.jdField_a_of_type_JavaUtilList = ((xnp)vux.a(11)).a(xhs.a(this.a), paramwdu.jdField_a_of_type_JavaUtilList, paramwdu.c);
    paramwdu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(xhs.a(this.a), xhs.b(this.a), xhs.a(this.a), xhs.b(this.a), paramwdu.jdField_a_of_type_Boolean);
    ??? = new ArrayList(paramwdu.jdField_a_of_type_JavaUtilList.size());
    paramErrorMessage = paramwdu.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    wcj.a(???);
    synchronized (this.a)
    {
      this.a.b = true;
      xhs.a(this.a, paramwdu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xht
 * JD-Core Version:    0.7.0.1
 */