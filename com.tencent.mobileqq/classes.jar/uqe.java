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

class uqe
  implements syt<tlz, tma>
{
  uqe(uqd paramuqd) {}
  
  public void a(@NonNull tlz paramtlz, @Nullable tma arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (uqd.a(this.a))
    {
      veg.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramtlz = new uqg(paramErrorMessage, uqd.a(this.a));
    paramtlz.d = this.a.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      veg.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", uqd.a(this.a));
      uqd.a(this.a, paramtlz);
      return;
    }
    ??? = (uxp)???.jdField_a_of_type_JavaUtilList.get(0);
    if (!(??? instanceof uxr))
    {
      paramtlz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940001, ajyc.a(2131716307));
      uqd.a(this.a, paramtlz);
      vxs.a(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (uxr)???;
    uqd.a(this.a, ???.a().mVideoNextCookie);
    uqd.a(this.a, ???.a().mVideoPullType);
    uqd.b(this.a, ???.a().mVideoSeq);
    paramtlz.jdField_a_of_type_Boolean = ???.a().mIsVideoEnd;
    paramtlz.jdField_a_of_type_JavaUtilList = ???.a();
    paramtlz.c = true;
    if ((!paramtlz.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(uqd.b(this.a)))) {
      paramtlz.jdField_a_of_type_Boolean = true;
    }
    paramtlz.b = ???.a().getOwner().getUnionId();
    paramtlz.jdField_a_of_type_JavaUtilList = ((uwa)tdc.a(11)).a(uqd.a(this.a), paramtlz.jdField_a_of_type_JavaUtilList, paramtlz.c);
    paramtlz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(uqd.a(this.a), uqd.b(this.a), uqd.a(this.a), uqd.b(this.a), paramtlz.jdField_a_of_type_Boolean);
    ??? = new ArrayList(paramtlz.jdField_a_of_type_JavaUtilList.size());
    paramErrorMessage = paramtlz.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    tko.a(???);
    synchronized (this.a)
    {
      this.a.b = true;
      uqd.a(this.a, paramtlz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqe
 * JD-Core Version:    0.7.0.1
 */