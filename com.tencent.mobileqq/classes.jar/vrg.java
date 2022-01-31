import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class vrg
  extends umf<vrd, utf>
{
  public vrg(vrd paramvrd)
  {
    super(paramvrd);
  }
  
  public void a(@NonNull vrd paramvrd, @NonNull utf paramutf)
  {
    if ((paramutf.jdField_a_of_type_Int == 2) || (!paramutf.jdField_a_of_type_JavaLangString.equals(vrd.a(paramvrd))) || (vrd.a(paramvrd) == null) || (vrd.a(paramvrd).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {
      wxe.b(this.TAG, "ignore this feed info change event. %s.", paramutf.toString());
    }
    vrm localvrm;
    do
    {
      return;
      wxe.a(this.TAG, "receive feed info change event. %s.", paramutf.toString());
      localvrm = paramvrd.a();
      switch (paramutf.b)
      {
      default: 
        return;
      }
      if (paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        vrd.a(paramvrd).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        vrd.a(paramvrd).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        vrd.a(paramvrd).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      vrd.a(paramvrd).a(paramutf.c);
    } while (localvrm == null);
    localvrm.a(vrd.a(paramvrd), paramutf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return utf.class;
  }
  
  public void b(@NonNull vrd paramvrd, @NonNull utf paramutf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrg
 * JD-Core Version:    0.7.0.1
 */