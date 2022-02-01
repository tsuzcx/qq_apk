import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class ync
  extends wjm<ymx, wqm>
{
  public ync(ymx paramymx)
  {
    super(paramymx);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull wqm paramwqm)
  {
    if (((ymx.a(paramymx) == 12) && (paramwqm.jdField_a_of_type_Int == 3)) || ((ymx.a(paramymx) == 10) && (paramwqm.jdField_a_of_type_Int == 0) && (paramwqm.b != 1))) {
      return;
    }
    Object localObject = paramymx.a(paramwqm.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramwqm.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof ylo))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramwqm.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (ylo)localObject;
    if ((paramwqm.b == 1) || (paramwqm.b == 2))
    {
      if (paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((ylo)localObject).a).mCommentCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((ylo)localObject).a(((wse)wth.a(17)).a(paramwqm.jdField_a_of_type_JavaLangString, false), true);
      yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramwqm.jdField_a_of_type_JavaLangString, Integer.valueOf(((ylo)localObject).b().size()));
    }
    for (;;)
    {
      ymx.a(paramymx).b(paramwqm.jdField_a_of_type_JavaLangString);
      return;
      if (paramwqm.b == 3)
      {
        if (paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((ylo)localObject).a).mHadLike = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((ylo)localObject).a).mLikeCount = paramwqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((ylo)localObject).b(((wst)wth.a(15)).a(paramwqm.jdField_a_of_type_JavaLangString, false), true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wqm.class;
  }
  
  public void b(@NonNull ymx paramymx, @NonNull wqm paramwqm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ync
 * JD-Core Version:    0.7.0.1
 */