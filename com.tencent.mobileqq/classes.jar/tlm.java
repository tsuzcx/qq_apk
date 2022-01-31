import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class tlm
  extends sgl<tlj, snl>
{
  public tlm(tlj paramtlj)
  {
    super(paramtlj);
  }
  
  public void a(@NonNull tlj paramtlj, @NonNull snl paramsnl)
  {
    if ((paramsnl.jdField_a_of_type_Int == 2) || (!paramsnl.jdField_a_of_type_JavaLangString.equals(tlj.a(paramtlj))) || (tlj.a(paramtlj) == null) || (tlj.a(paramtlj).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {
      urk.b(this.TAG, "ignore this feed info change event. %s.", paramsnl.toString());
    }
    tls localtls;
    do
    {
      return;
      urk.a(this.TAG, "receive feed info change event. %s.", paramsnl.toString());
      localtls = paramtlj.a();
      switch (paramsnl.b)
      {
      default: 
        return;
      }
      if (paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        tlj.a(paramtlj).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        tlj.a(paramtlj).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        tlj.a(paramtlj).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      tlj.a(paramtlj).a(paramsnl.c);
    } while (localtls == null);
    localtls.a(tlj.a(paramtlj), paramsnl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return snl.class;
  }
  
  public void b(@NonNull tlj paramtlj, @NonNull snl paramsnl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlm
 * JD-Core Version:    0.7.0.1
 */