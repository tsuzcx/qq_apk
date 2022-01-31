import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class urc
  extends ste<uqv, tae>
{
  public urc(uqv paramuqv)
  {
    super(paramuqv);
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull tae paramtae)
  {
    if ((paramtae.jdField_a_of_type_Int == 2) || (!paramtae.jdField_a_of_type_JavaLangString.equals(uqv.a(paramuqv))) || (uqv.a(paramuqv) == null))
    {
      ved.b(this.TAG, "ignore this feed info change event. %s.", paramtae.toString());
      return;
    }
    ved.a(this.TAG, "receive feed info change event. %s.", paramtae.toString());
    switch (paramtae.b)
    {
    default: 
      return;
    case 1: 
      if (paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      localObject = (tbw)tcz.a(17);
      localList = ((tbw)localObject).a(paramtae.jdField_a_of_type_JavaLangString, true);
      uqv.a(paramuqv).a(localList, true, true);
      if (uqv.a(paramuqv).a())
      {
        paramtae = ((tbw)localObject).a(paramtae.jdField_a_of_type_JavaLangString, false);
        uqv.a(paramuqv).a(paramtae, true, false);
      }
      paramuqv.a();
      return;
    case 2: 
      if (paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      uqv.a(paramuqv).a(paramtae.c);
      paramuqv.a();
      return;
    }
    if (paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      uqv.a(paramuqv).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    Object localObject = (tcl)tcz.a(15);
    List localList = ((tcl)localObject).a(paramtae.jdField_a_of_type_JavaLangString, true);
    uqv.a(paramuqv).b(localList, true, true);
    if (uqv.a(paramuqv).a())
    {
      paramtae = ((tcl)localObject).a(paramtae.jdField_a_of_type_JavaLangString, false);
      uqv.a(paramuqv).b(paramtae, true, false);
    }
    paramuqv.a();
  }
  
  public Class acceptEventClass()
  {
    return tae.class;
  }
  
  public void b(@NonNull uqv paramuqv, @NonNull tae paramtae) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urc
 * JD-Core Version:    0.7.0.1
 */