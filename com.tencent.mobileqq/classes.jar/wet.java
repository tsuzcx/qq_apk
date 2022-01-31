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

class wet
  implements uni<vao, vap>
{
  wet(wes paramwes) {}
  
  public void a(@NonNull vao paramvao, @Nullable vap arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (wes.a(this.a))
    {
      wsv.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramvao = new wev(paramErrorMessage, wes.a(this.a));
    paramvao.d = this.a.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      wsv.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", wes.a(this.a));
      wes.a(this.a, paramvao);
      return;
    }
    ??? = (wme)???.jdField_a_of_type_JavaUtilList.get(0);
    if (!(??? instanceof wmg))
    {
      paramvao.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940001, alpo.a(2131716690));
      wes.a(this.a, paramvao);
      xmh.a(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (wmg)???;
    wes.a(this.a, ???.a().mVideoNextCookie);
    wes.a(this.a, ???.a().mVideoPullType);
    wes.b(this.a, ???.a().mVideoSeq);
    paramvao.jdField_a_of_type_Boolean = ???.a().mIsVideoEnd;
    paramvao.jdField_a_of_type_JavaUtilList = ???.a();
    paramvao.c = true;
    if ((!paramvao.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(wes.b(this.a)))) {
      paramvao.jdField_a_of_type_Boolean = true;
    }
    paramvao.b = ???.a().getOwner().getUnionId();
    paramvao.jdField_a_of_type_JavaUtilList = ((wkp)urr.a(11)).a(wes.a(this.a), paramvao.jdField_a_of_type_JavaUtilList, paramvao.c);
    paramvao.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(wes.a(this.a), wes.b(this.a), wes.a(this.a), wes.b(this.a), paramvao.jdField_a_of_type_Boolean);
    ??? = new ArrayList(paramvao.jdField_a_of_type_JavaUtilList.size());
    paramErrorMessage = paramvao.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    uzd.a(???);
    synchronized (this.a)
    {
      this.a.b = true;
      wes.a(this.a, paramvao);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wet
 * JD-Core Version:    0.7.0.1
 */