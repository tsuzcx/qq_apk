import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class uej
  extends sgl<uec, snl>
{
  public uej(uec paramuec)
  {
    super(paramuec);
  }
  
  public void a(@NonNull uec paramuec, @NonNull snl paramsnl)
  {
    if ((paramsnl.jdField_a_of_type_Int == 2) || (!paramsnl.jdField_a_of_type_JavaLangString.equals(uec.a(paramuec))) || (uec.a(paramuec) == null))
    {
      urk.b(this.TAG, "ignore this feed info change event. %s.", paramsnl.toString());
      return;
    }
    urk.a(this.TAG, "receive feed info change event. %s.", paramsnl.toString());
    switch (paramsnl.b)
    {
    default: 
      return;
    case 1: 
      if (paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      localObject = (spd)sqg.a(17);
      localList = ((spd)localObject).a(paramsnl.jdField_a_of_type_JavaLangString, true);
      uec.a(paramuec).a(localList, true, true);
      if (uec.a(paramuec).a())
      {
        paramsnl = ((spd)localObject).a(paramsnl.jdField_a_of_type_JavaLangString, false);
        uec.a(paramuec).a(paramsnl, true, false);
      }
      paramuec.a();
      return;
    case 2: 
      if (paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      uec.a(paramuec).a(paramsnl.c);
      paramuec.a();
      return;
    }
    if (paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      uec.a(paramuec).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    Object localObject = (sps)sqg.a(15);
    List localList = ((sps)localObject).a(paramsnl.jdField_a_of_type_JavaLangString, true);
    uec.a(paramuec).b(localList, true, true);
    if (uec.a(paramuec).a())
    {
      paramsnl = ((sps)localObject).a(paramsnl.jdField_a_of_type_JavaLangString, false);
      uec.a(paramuec).b(paramsnl, true, false);
    }
    paramuec.a();
  }
  
  public Class acceptEventClass()
  {
    return snl.class;
  }
  
  public void b(@NonNull uec paramuec, @NonNull snl paramsnl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uej
 * JD-Core Version:    0.7.0.1
 */