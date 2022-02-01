import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class xom
  extends wjm<xoj, wqm>
{
  public xom(xoj paramxoj)
  {
    super(paramxoj);
  }
  
  public void a(@NonNull xoj paramxoj, @NonNull wqm paramwqm)
  {
    if ((paramwqm.jdField_a_of_type_Int == 2) || (!paramwqm.jdField_a_of_type_JavaLangString.equals(xoj.a(paramxoj))) || (xoj.a(paramxoj) == null) || (xoj.a(paramxoj).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {
      yuk.b(this.TAG, "ignore this feed info change event. %s.", paramwqm.toString());
    }
    xos localxos;
    do
    {
      return;
      yuk.a(this.TAG, "receive feed info change event. %s.", paramwqm.toString());
      localxos = paramxoj.a();
      switch (paramwqm.b)
      {
      default: 
        return;
      }
      if (paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        xoj.a(paramxoj).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        xoj.a(paramxoj).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        xoj.a(paramxoj).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      xoj.a(paramxoj).a(paramwqm.c);
    } while (localxos == null);
    localxos.a(xoj.a(paramxoj), paramwqm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return wqm.class;
  }
  
  public void b(@NonNull xoj paramxoj, @NonNull wqm paramwqm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xom
 * JD-Core Version:    0.7.0.1
 */