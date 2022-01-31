import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class wpw
  extends umf<wpr, utf>
{
  public wpw(wpr paramwpr)
  {
    super(paramwpr);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull utf paramutf)
  {
    if (((wpr.a(paramwpr) == 12) && (paramutf.jdField_a_of_type_Int == 3)) || ((wpr.a(paramwpr) == 10) && (paramutf.jdField_a_of_type_Int == 0) && (paramutf.b != 1))) {
      return;
    }
    Object localObject = paramwpr.a(paramutf.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramutf.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof woi))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramutf.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (woi)localObject;
    if ((paramutf.b == 1) || (paramutf.b == 2))
    {
      if (paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((woi)localObject).a).mCommentCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((woi)localObject).a(((uux)uwa.a(17)).a(paramutf.jdField_a_of_type_JavaLangString, false), true);
      wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramutf.jdField_a_of_type_JavaLangString, Integer.valueOf(((woi)localObject).b().size()));
    }
    for (;;)
    {
      wpr.a(paramwpr).b(paramutf.jdField_a_of_type_JavaLangString);
      return;
      if (paramutf.b == 3)
      {
        if (paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((woi)localObject).a).mHadLike = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((woi)localObject).a).mLikeCount = paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((woi)localObject).b(((uvm)uwa.a(15)).a(paramutf.jdField_a_of_type_JavaLangString, false), true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return utf.class;
  }
  
  public void b(@NonNull wpr paramwpr, @NonNull utf paramutf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpw
 * JD-Core Version:    0.7.0.1
 */