import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class wfu
  extends uhw<wfn, uow>
{
  public wfu(wfn paramwfn)
  {
    super(paramwfn);
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull uow paramuow)
  {
    if ((paramuow.jdField_a_of_type_Int == 2) || (!paramuow.jdField_a_of_type_JavaLangString.equals(wfn.a(paramwfn))) || (wfn.a(paramwfn) == null))
    {
      wsv.b(this.TAG, "ignore this feed info change event. %s.", paramuow.toString());
      return;
    }
    wsv.a(this.TAG, "receive feed info change event. %s.", paramuow.toString());
    switch (paramuow.b)
    {
    default: 
      return;
    case 1: 
      if (paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      localObject = (uqo)urr.a(17);
      localList = ((uqo)localObject).a(paramuow.jdField_a_of_type_JavaLangString, true);
      wfn.a(paramwfn).a(localList, true, true);
      if (wfn.a(paramwfn).a())
      {
        paramuow = ((uqo)localObject).a(paramuow.jdField_a_of_type_JavaLangString, false);
        wfn.a(paramwfn).a(paramuow, true, false);
      }
      paramwfn.a();
      return;
    case 2: 
      if (paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      wfn.a(paramwfn).a(paramuow.c);
      paramwfn.a();
      return;
    }
    if (paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      wfn.a(paramwfn).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    Object localObject = (urd)urr.a(15);
    List localList = ((urd)localObject).a(paramuow.jdField_a_of_type_JavaLangString, true);
    wfn.a(paramwfn).b(localList, true, true);
    if (wfn.a(paramwfn).a())
    {
      paramuow = ((urd)localObject).a(paramuow.jdField_a_of_type_JavaLangString, false);
      wfn.a(paramwfn).b(paramuow, true, false);
    }
    paramwfn.a();
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
  
  public void b(@NonNull wfn paramwfn, @NonNull uow paramuow) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfu
 * JD-Core Version:    0.7.0.1
 */