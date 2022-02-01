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

class ycn
  implements wld<wyj, wyk>
{
  ycn(ycm paramycm) {}
  
  public void a(@NonNull wyj paramwyj, @Nullable wyk arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (ycm.a(this.a))
    {
      yqp.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramwyj = new ycp(paramErrorMessage, ycm.a(this.a));
    paramwyj.d = this.a.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      yqp.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", ycm.a(this.a));
      ycm.a(this.a, paramwyj);
      return;
    }
    ??? = (yjy)???.jdField_a_of_type_JavaUtilList.get(0);
    if (!(??? instanceof yka))
    {
      paramwyj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940001, anni.a(2131714979));
      ycm.a(this.a, paramwyj);
      zkb.a(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (yka)???;
    ycm.a(this.a, ???.a().mVideoNextCookie);
    ycm.a(this.a, ???.a().mVideoPullType);
    ycm.b(this.a, ???.a().mVideoSeq);
    paramwyj.jdField_a_of_type_Boolean = ???.a().mIsVideoEnd;
    paramwyj.jdField_a_of_type_JavaUtilList = ???.a();
    paramwyj.c = true;
    if ((!paramwyj.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(ycm.b(this.a)))) {
      paramwyj.jdField_a_of_type_Boolean = true;
    }
    paramwyj.b = ???.a().getOwner().getUnionId();
    paramwyj.jdField_a_of_type_JavaUtilList = ((yij)wpm.a(11)).a(ycm.a(this.a), paramwyj.jdField_a_of_type_JavaUtilList, paramwyj.c);
    paramwyj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(ycm.a(this.a), ycm.b(this.a), ycm.a(this.a), ycm.b(this.a), paramwyj.jdField_a_of_type_Boolean);
    ??? = new ArrayList(paramwyj.jdField_a_of_type_JavaUtilList.size());
    paramErrorMessage = paramwyj.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    wwy.a(???);
    synchronized (this.a)
    {
      this.a.b = true;
      ycm.a(this.a, paramwyj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycn
 * JD-Core Version:    0.7.0.1
 */