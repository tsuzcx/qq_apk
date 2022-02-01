import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class wpx
  extends vll<wpu, vsd>
{
  public wpx(wpu paramwpu)
  {
    super(paramwpu);
  }
  
  public void a(@NonNull wpu paramwpu, @NonNull vsd paramvsd)
  {
    if ((paramvsd.jdField_a_of_type_Int == 2) || (!paramvsd.jdField_a_of_type_JavaLangString.equals(wpu.a(paramwpu))) || (wpu.a(paramwpu) == null) || (wpu.a(paramwpu).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {
      xvv.b(this.TAG, "ignore this feed info change event. %s.", paramvsd.toString());
    }
    wqd localwqd;
    do
    {
      return;
      xvv.a(this.TAG, "receive feed info change event. %s.", paramvsd.toString());
      localwqd = paramwpu.a();
      switch (paramvsd.b)
      {
      default: 
        return;
      }
      if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        wpu.a(paramwpu).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        wpu.a(paramwpu).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        wpu.a(paramwpu).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      wpu.a(paramwpu).a(paramvsd.c);
    } while (localwqd == null);
    localwqd.a(wpu.a(paramwpu), paramvsd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return vsd.class;
  }
  
  public void b(@NonNull wpu paramwpu, @NonNull vsd paramvsd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpx
 * JD-Core Version:    0.7.0.1
 */