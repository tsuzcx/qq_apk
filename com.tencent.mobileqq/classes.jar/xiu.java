import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class xiu
  extends vll<xin, vsd>
{
  public xiu(xin paramxin)
  {
    super(paramxin);
  }
  
  public void a(@NonNull xin paramxin, @NonNull vsd paramvsd)
  {
    if ((paramvsd.jdField_a_of_type_Int == 2) || (!paramvsd.jdField_a_of_type_JavaLangString.equals(xin.a(paramxin))) || (xin.a(paramxin) == null))
    {
      xvv.b(this.TAG, "ignore this feed info change event. %s.", paramvsd.toString());
      return;
    }
    xvv.a(this.TAG, "receive feed info change event. %s.", paramvsd.toString());
    switch (paramvsd.b)
    {
    default: 
      return;
    case 1: 
      if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      localObject = (vtu)vux.a(17);
      localList = ((vtu)localObject).a(paramvsd.jdField_a_of_type_JavaLangString, true);
      xin.a(paramxin).a(localList, true, true);
      if (xin.a(paramxin).a())
      {
        paramvsd = ((vtu)localObject).a(paramvsd.jdField_a_of_type_JavaLangString, false);
        xin.a(paramxin).a(paramvsd, true, false);
      }
      paramxin.a();
      return;
    case 2: 
      if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      xin.a(paramxin).a(paramvsd.c);
      paramxin.a();
      return;
    }
    if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      xin.a(paramxin).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    Object localObject = (vuj)vux.a(15);
    List localList = ((vuj)localObject).a(paramvsd.jdField_a_of_type_JavaLangString, true);
    xin.a(paramxin).b(localList, true, true);
    if (xin.a(paramxin).a())
    {
      paramvsd = ((vuj)localObject).a(paramvsd.jdField_a_of_type_JavaLangString, false);
      xin.a(paramxin).b(paramvsd, true, false);
    }
    paramxin.a();
  }
  
  public Class acceptEventClass()
  {
    return vsd.class;
  }
  
  public void b(@NonNull xin paramxin, @NonNull vsd paramvsd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xiu
 * JD-Core Version:    0.7.0.1
 */