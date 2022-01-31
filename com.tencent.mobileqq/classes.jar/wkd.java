import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class wkd
  extends umf<wjw, utf>
{
  public wkd(wjw paramwjw)
  {
    super(paramwjw);
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull utf paramutf)
  {
    if ((paramutf.jdField_a_of_type_Int == 2) || (!paramutf.jdField_a_of_type_JavaLangString.equals(wjw.a(paramwjw))) || (wjw.a(paramwjw) == null))
    {
      wxe.b(this.TAG, "ignore this feed info change event. %s.", paramutf.toString());
      return;
    }
    wxe.a(this.TAG, "receive feed info change event. %s.", paramutf.toString());
    switch (paramutf.b)
    {
    default: 
      return;
    case 1: 
      if (paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      localObject = (uux)uwa.a(17);
      localList = ((uux)localObject).a(paramutf.jdField_a_of_type_JavaLangString, true);
      wjw.a(paramwjw).a(localList, true, true);
      if (wjw.a(paramwjw).a())
      {
        paramutf = ((uux)localObject).a(paramutf.jdField_a_of_type_JavaLangString, false);
        wjw.a(paramwjw).a(paramutf, true, false);
      }
      paramwjw.a();
      return;
    case 2: 
      if (paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      wjw.a(paramwjw).a(paramutf.c);
      paramwjw.a();
      return;
    }
    if (paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      wjw.a(paramwjw).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    Object localObject = (uvm)uwa.a(15);
    List localList = ((uvm)localObject).a(paramutf.jdField_a_of_type_JavaLangString, true);
    wjw.a(paramwjw).b(localList, true, true);
    if (wjw.a(paramwjw).a())
    {
      paramutf = ((uvm)localObject).a(paramutf.jdField_a_of_type_JavaLangString, false);
      wjw.a(paramwjw).b(paramutf, true, false);
    }
    paramwjw.a();
  }
  
  public Class acceptEventClass()
  {
    return utf.class;
  }
  
  public void b(@NonNull wjw paramwjw, @NonNull utf paramutf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkd
 * JD-Core Version:    0.7.0.1
 */