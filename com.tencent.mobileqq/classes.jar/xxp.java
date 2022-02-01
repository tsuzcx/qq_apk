import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class xxp
  extends wag<xxi, wgy>
{
  public xxp(xxi paramxxi)
  {
    super(paramxxi);
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull wgy paramwgy)
  {
    if ((paramwgy.jdField_a_of_type_Int == 2) || (!paramwgy.jdField_a_of_type_JavaLangString.equals(xxi.a(paramxxi))) || (xxi.a(paramxxi) == null))
    {
      ykq.b(this.TAG, "ignore this feed info change event. %s.", paramwgy.toString());
      return;
    }
    ykq.a(this.TAG, "receive feed info change event. %s.", paramwgy.toString());
    switch (paramwgy.b)
    {
    default: 
      return;
    case 1: 
      if (paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      localObject = (wip)wjs.a(17);
      localList = ((wip)localObject).a(paramwgy.jdField_a_of_type_JavaLangString, true);
      xxi.a(paramxxi).a(localList, true, true);
      if (xxi.a(paramxxi).a())
      {
        paramwgy = ((wip)localObject).a(paramwgy.jdField_a_of_type_JavaLangString, false);
        xxi.a(paramxxi).a(paramwgy, true, false);
      }
      paramxxi.a();
      return;
    case 2: 
      if (paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      xxi.a(paramxxi).a(paramwgy.c);
      paramxxi.a();
      return;
    }
    if (paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      xxi.a(paramxxi).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    Object localObject = (wje)wjs.a(15);
    List localList = ((wje)localObject).a(paramwgy.jdField_a_of_type_JavaLangString, true);
    xxi.a(paramxxi).b(localList, true, true);
    if (xxi.a(paramxxi).a())
    {
      paramwgy = ((wje)localObject).a(paramwgy.jdField_a_of_type_JavaLangString, false);
      xxi.a(paramxxi).b(paramwgy, true, false);
    }
    paramxxi.a();
  }
  
  public Class acceptEventClass()
  {
    return wgy.class;
  }
  
  public void b(@NonNull xxi paramxxi, @NonNull wgy paramwgy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxp
 * JD-Core Version:    0.7.0.1
 */