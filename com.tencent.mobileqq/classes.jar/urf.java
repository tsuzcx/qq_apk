import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class urf
  extends sth<uqy, tah>
{
  public urf(uqy paramuqy)
  {
    super(paramuqy);
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull tah paramtah)
  {
    if ((paramtah.jdField_a_of_type_Int == 2) || (!paramtah.jdField_a_of_type_JavaLangString.equals(uqy.a(paramuqy))) || (uqy.a(paramuqy) == null))
    {
      veg.b(this.TAG, "ignore this feed info change event. %s.", paramtah.toString());
      return;
    }
    veg.a(this.TAG, "receive feed info change event. %s.", paramtah.toString());
    switch (paramtah.b)
    {
    default: 
      return;
    case 1: 
      if (paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      localObject = (tbz)tdc.a(17);
      localList = ((tbz)localObject).a(paramtah.jdField_a_of_type_JavaLangString, true);
      uqy.a(paramuqy).a(localList, true, true);
      if (uqy.a(paramuqy).a())
      {
        paramtah = ((tbz)localObject).a(paramtah.jdField_a_of_type_JavaLangString, false);
        uqy.a(paramuqy).a(paramtah, true, false);
      }
      paramuqy.a();
      return;
    case 2: 
      if (paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      uqy.a(paramuqy).a(paramtah.c);
      paramuqy.a();
      return;
    }
    if (paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      uqy.a(paramuqy).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    Object localObject = (tco)tdc.a(15);
    List localList = ((tco)localObject).a(paramtah.jdField_a_of_type_JavaLangString, true);
    uqy.a(paramuqy).b(localList, true, true);
    if (uqy.a(paramuqy).a())
    {
      paramtah = ((tco)localObject).a(paramtah.jdField_a_of_type_JavaLangString, false);
      uqy.a(paramuqy).b(paramtah, true, false);
    }
    paramuqy.a();
  }
  
  public Class acceptEventClass()
  {
    return tah.class;
  }
  
  public void b(@NonNull uqy paramuqy, @NonNull tah paramtah) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urf
 * JD-Core Version:    0.7.0.1
 */