import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class tyf
  extends ste<tyc, tae>
{
  public tyf(tyc paramtyc)
  {
    super(paramtyc);
  }
  
  public void a(@NonNull tyc paramtyc, @NonNull tae paramtae)
  {
    if ((paramtae.jdField_a_of_type_Int == 2) || (!paramtae.jdField_a_of_type_JavaLangString.equals(tyc.a(paramtyc))) || (tyc.a(paramtyc) == null) || (tyc.a(paramtyc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {
      ved.b(this.TAG, "ignore this feed info change event. %s.", paramtae.toString());
    }
    tyl localtyl;
    do
    {
      return;
      ved.a(this.TAG, "receive feed info change event. %s.", paramtae.toString());
      localtyl = paramtyc.a();
      switch (paramtae.b)
      {
      default: 
        return;
      }
      if (paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        tyc.a(paramtyc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        tyc.a(paramtyc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        tyc.a(paramtyc).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      tyc.a(paramtyc).a(paramtae.c);
    } while (localtyl == null);
    localtyl.a(tyc.a(paramtyc), paramtae.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return tae.class;
  }
  
  public void b(@NonNull tyc paramtyc, @NonNull tae paramtae) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyf
 * JD-Core Version:    0.7.0.1
 */