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

class udi
  implements slx<szd, sze>
{
  udi(udh paramudh) {}
  
  public void a(@NonNull szd paramszd, @Nullable sze arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (udh.a(this.a))
    {
      urk.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramszd = new udk(paramErrorMessage, udh.a(this.a));
    paramszd.d = this.a.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      urk.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", udh.a(this.a));
      udh.a(this.a, paramszd);
      return;
    }
    ??? = (ukt)???.jdField_a_of_type_JavaUtilList.get(0);
    if (!(??? instanceof ukv))
    {
      paramszd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940001, ajjy.a(2131650516));
      udh.a(this.a, paramszd);
      vkw.a(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (ukv)???;
    udh.a(this.a, ???.a().mVideoNextCookie);
    udh.a(this.a, ???.a().mVideoPullType);
    udh.b(this.a, ???.a().mVideoSeq);
    paramszd.jdField_a_of_type_Boolean = ???.a().mIsVideoEnd;
    paramszd.jdField_a_of_type_JavaUtilList = ???.a();
    paramszd.c = true;
    if ((!paramszd.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(udh.b(this.a)))) {
      paramszd.jdField_a_of_type_Boolean = true;
    }
    paramszd.b = ???.a().getOwner().getUnionId();
    paramszd.jdField_a_of_type_JavaUtilList = ((uje)sqg.a(11)).a(udh.a(this.a), paramszd.jdField_a_of_type_JavaUtilList, paramszd.c);
    paramszd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(udh.a(this.a), udh.b(this.a), udh.a(this.a), udh.b(this.a), paramszd.jdField_a_of_type_Boolean);
    ??? = new ArrayList(paramszd.jdField_a_of_type_JavaUtilList.size());
    paramErrorMessage = paramszd.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    sxs.a(???);
    synchronized (this.a)
    {
      this.a.b = true;
      udh.a(this.a, paramszd);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     udi
 * JD-Core Version:    0.7.0.1
 */