import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class ydo
  extends wfr<ydh, wmr>
{
  public ydo(ydh paramydh)
  {
    super(paramydh);
  }
  
  public void a(@NonNull ydh paramydh, @NonNull wmr paramwmr)
  {
    if ((paramwmr.jdField_a_of_type_Int == 2) || (!paramwmr.jdField_a_of_type_JavaLangString.equals(ydh.a(paramydh))) || (ydh.a(paramydh) == null))
    {
      yqp.b(this.TAG, "ignore this feed info change event. %s.", paramwmr.toString());
      return;
    }
    yqp.a(this.TAG, "receive feed info change event. %s.", paramwmr.toString());
    switch (paramwmr.b)
    {
    default: 
      return;
    case 1: 
      if (paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      localObject = (woj)wpm.a(17);
      localList = ((woj)localObject).a(paramwmr.jdField_a_of_type_JavaLangString, true);
      ydh.a(paramydh).a(localList, true, true);
      if (ydh.a(paramydh).a())
      {
        paramwmr = ((woj)localObject).a(paramwmr.jdField_a_of_type_JavaLangString, false);
        ydh.a(paramydh).a(paramwmr, true, false);
      }
      paramydh.a();
      return;
    case 2: 
      if (paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      ydh.a(paramydh).a(paramwmr.c);
      paramydh.a();
      return;
    }
    if (paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      ydh.a(paramydh).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    Object localObject = (woy)wpm.a(15);
    List localList = ((woy)localObject).a(paramwmr.jdField_a_of_type_JavaLangString, true);
    ydh.a(paramydh).b(localList, true, true);
    if (ydh.a(paramydh).a())
    {
      paramwmr = ((woy)localObject).a(paramwmr.jdField_a_of_type_JavaLangString, false);
      ydh.a(paramydh).b(paramwmr, true, false);
    }
    paramydh.a();
  }
  
  public Class acceptEventClass()
  {
    return wmr.class;
  }
  
  public void b(@NonNull ydh paramydh, @NonNull wmr paramwmr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydo
 * JD-Core Version:    0.7.0.1
 */