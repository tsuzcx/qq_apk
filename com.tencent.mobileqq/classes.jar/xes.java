import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class xes
  extends wag<xep, wgy>
{
  public xes(xep paramxep)
  {
    super(paramxep);
  }
  
  public void a(@NonNull xep paramxep, @NonNull wgy paramwgy)
  {
    if ((paramwgy.jdField_a_of_type_Int == 2) || (!paramwgy.jdField_a_of_type_JavaLangString.equals(xep.a(paramxep))) || (xep.a(paramxep) == null) || (xep.a(paramxep).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {
      ykq.b(this.TAG, "ignore this feed info change event. %s.", paramwgy.toString());
    }
    xey localxey;
    do
    {
      return;
      ykq.a(this.TAG, "receive feed info change event. %s.", paramwgy.toString());
      localxey = paramxep.a();
      switch (paramwgy.b)
      {
      default: 
        return;
      }
      if (paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        xep.a(paramxep).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        xep.a(paramxep).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        xep.a(paramxep).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      xep.a(paramxep).a(paramwgy.c);
    } while (localxey == null);
    localxey.a(xep.a(paramxep), paramwgy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return wgy.class;
  }
  
  public void b(@NonNull xep paramxep, @NonNull wgy paramwgy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xes
 * JD-Core Version:    0.7.0.1
 */