import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class vmx
  extends uhw<vmu, uow>
{
  public vmx(vmu paramvmu)
  {
    super(paramvmu);
  }
  
  public void a(@NonNull vmu paramvmu, @NonNull uow paramuow)
  {
    if ((paramuow.jdField_a_of_type_Int == 2) || (!paramuow.jdField_a_of_type_JavaLangString.equals(vmu.a(paramvmu))) || (vmu.a(paramvmu) == null) || (vmu.a(paramvmu).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {
      wsv.b(this.TAG, "ignore this feed info change event. %s.", paramuow.toString());
    }
    vnd localvnd;
    do
    {
      return;
      wsv.a(this.TAG, "receive feed info change event. %s.", paramuow.toString());
      localvnd = paramvmu.a();
      switch (paramuow.b)
      {
      default: 
        return;
      }
      if (paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        vmu.a(paramvmu).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        vmu.a(paramvmu).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        vmu.a(paramvmu).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      vmu.a(paramvmu).a(paramuow.c);
    } while (localvnd == null);
    localvnd.a(vmu.a(paramvmu), paramuow.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
  
  public void b(@NonNull vmu paramvmu, @NonNull uow paramuow) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmx
 * JD-Core Version:    0.7.0.1
 */