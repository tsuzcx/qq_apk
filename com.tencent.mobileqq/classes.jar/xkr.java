import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class xkr
  extends wfr<xko, wmr>
{
  public xkr(xko paramxko)
  {
    super(paramxko);
  }
  
  public void a(@NonNull xko paramxko, @NonNull wmr paramwmr)
  {
    if ((paramwmr.jdField_a_of_type_Int == 2) || (!paramwmr.jdField_a_of_type_JavaLangString.equals(xko.a(paramxko))) || (xko.a(paramxko) == null) || (xko.a(paramxko).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {
      yqp.b(this.TAG, "ignore this feed info change event. %s.", paramwmr.toString());
    }
    xkx localxkx;
    do
    {
      return;
      yqp.a(this.TAG, "receive feed info change event. %s.", paramwmr.toString());
      localxkx = paramxko.a();
      switch (paramwmr.b)
      {
      default: 
        return;
      }
      if (paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        xko.a(paramxko).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        xko.a(paramxko).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        xko.a(paramxko).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      xko.a(paramxko).a(paramwmr.c);
    } while (localxkx == null);
    localxkx.a(xko.a(paramxko), paramwmr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return wmr.class;
  }
  
  public void b(@NonNull xko paramxko, @NonNull wmr paramwmr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkr
 * JD-Core Version:    0.7.0.1
 */