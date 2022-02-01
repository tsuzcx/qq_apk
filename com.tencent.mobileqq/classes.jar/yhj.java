import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class yhj
  extends wjm<yhc, wqm>
{
  public yhj(yhc paramyhc)
  {
    super(paramyhc);
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull wqm paramwqm)
  {
    if ((paramwqm.jdField_a_of_type_Int == 2) || (!paramwqm.jdField_a_of_type_JavaLangString.equals(yhc.a(paramyhc))) || (yhc.a(paramyhc) == null))
    {
      yuk.b(this.TAG, "ignore this feed info change event. %s.", paramwqm.toString());
      return;
    }
    yuk.a(this.TAG, "receive feed info change event. %s.", paramwqm.toString());
    switch (paramwqm.b)
    {
    default: 
      return;
    case 1: 
      if (paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      localObject = (wse)wth.a(17);
      localList = ((wse)localObject).a(paramwqm.jdField_a_of_type_JavaLangString, true);
      yhc.a(paramyhc).a(localList, true, true);
      if (yhc.a(paramyhc).a())
      {
        paramwqm = ((wse)localObject).a(paramwqm.jdField_a_of_type_JavaLangString, false);
        yhc.a(paramyhc).a(paramwqm, true, false);
      }
      paramyhc.a();
      return;
    case 2: 
      if (paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      yhc.a(paramyhc).a(paramwqm.c);
      paramyhc.a();
      return;
    }
    if (paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      yhc.a(paramyhc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    Object localObject = (wst)wth.a(15);
    List localList = ((wst)localObject).a(paramwqm.jdField_a_of_type_JavaLangString, true);
    yhc.a(paramyhc).b(localList, true, true);
    if (yhc.a(paramyhc).a())
    {
      paramwqm = ((wst)localObject).a(paramwqm.jdField_a_of_type_JavaLangString, false);
      yhc.a(paramyhc).b(paramwqm, true, false);
    }
    paramyhc.a();
  }
  
  public Class acceptEventClass()
  {
    return wqm.class;
  }
  
  public void b(@NonNull yhc paramyhc, @NonNull wqm paramwqm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhj
 * JD-Core Version:    0.7.0.1
 */