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

class uqb
  implements syq<tlw, tlx>
{
  uqb(uqa paramuqa) {}
  
  public void a(@NonNull tlw paramtlw, @Nullable tlx arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (uqa.a(this.a))
    {
      ved.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramtlw = new uqd(paramErrorMessage, uqa.a(this.a));
    paramtlw.d = this.a.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      ved.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", uqa.a(this.a));
      uqa.a(this.a, paramtlw);
      return;
    }
    ??? = (uxm)???.jdField_a_of_type_JavaUtilList.get(0);
    if (!(??? instanceof uxo))
    {
      paramtlw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940001, ajya.a(2131716318));
      uqa.a(this.a, paramtlw);
      vxp.a(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (uxo)???;
    uqa.a(this.a, ???.a().mVideoNextCookie);
    uqa.a(this.a, ???.a().mVideoPullType);
    uqa.b(this.a, ???.a().mVideoSeq);
    paramtlw.jdField_a_of_type_Boolean = ???.a().mIsVideoEnd;
    paramtlw.jdField_a_of_type_JavaUtilList = ???.a();
    paramtlw.c = true;
    if ((!paramtlw.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(uqa.b(this.a)))) {
      paramtlw.jdField_a_of_type_Boolean = true;
    }
    paramtlw.b = ???.a().getOwner().getUnionId();
    paramtlw.jdField_a_of_type_JavaUtilList = ((uvx)tcz.a(11)).a(uqa.a(this.a), paramtlw.jdField_a_of_type_JavaUtilList, paramtlw.c);
    paramtlw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(uqa.a(this.a), uqa.b(this.a), uqa.a(this.a), uqa.b(this.a), paramtlw.jdField_a_of_type_Boolean);
    ??? = new ArrayList(paramtlw.jdField_a_of_type_JavaUtilList.size());
    paramErrorMessage = paramtlw.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    tkl.a(???);
    synchronized (this.a)
    {
      this.a.b = true;
      uqa.a(this.a, paramtlw);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqb
 * JD-Core Version:    0.7.0.1
 */