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

class ygi
  implements woy<xce, xcf>
{
  ygi(ygh paramygh) {}
  
  public void a(@NonNull xce paramxce, @Nullable xcf arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (ygh.a(this.a))
    {
      yuk.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramxce = new ygk(paramErrorMessage, ygh.a(this.a));
    paramxce.d = this.a.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      yuk.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", ygh.a(this.a));
      ygh.a(this.a, paramxce);
      return;
    }
    ??? = (ynt)???.jdField_a_of_type_JavaUtilList.get(0);
    if (!(??? instanceof ynv))
    {
      paramxce.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940001, anzj.a(2131715088));
      ygh.a(this.a, paramxce);
      znw.a(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (ynv)???;
    ygh.a(this.a, ???.a().mVideoNextCookie);
    ygh.a(this.a, ???.a().mVideoPullType);
    ygh.b(this.a, ???.a().mVideoSeq);
    paramxce.jdField_a_of_type_Boolean = ???.a().mIsVideoEnd;
    paramxce.jdField_a_of_type_JavaUtilList = ???.a();
    paramxce.c = true;
    if ((!paramxce.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(ygh.b(this.a)))) {
      paramxce.jdField_a_of_type_Boolean = true;
    }
    paramxce.b = ???.a().getOwner().getUnionId();
    paramxce.jdField_a_of_type_JavaUtilList = ((yme)wth.a(11)).a(ygh.a(this.a), paramxce.jdField_a_of_type_JavaUtilList, paramxce.c);
    paramxce.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(ygh.a(this.a), ygh.b(this.a), ygh.a(this.a), ygh.b(this.a), paramxce.jdField_a_of_type_Boolean);
    ??? = new ArrayList(paramxce.jdField_a_of_type_JavaUtilList.size());
    paramErrorMessage = paramxce.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    xat.a(???);
    synchronized (this.a)
    {
      this.a.b = true;
      ygh.a(this.a, paramxce);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygi
 * JD-Core Version:    0.7.0.1
 */