import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class ydi
  extends wag<ydd, wgy>
{
  public ydi(ydd paramydd)
  {
    super(paramydd);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull wgy paramwgy)
  {
    if (((ydd.a(paramydd) == 12) && (paramwgy.jdField_a_of_type_Int == 3)) || ((ydd.a(paramydd) == 10) && (paramwgy.jdField_a_of_type_Int == 0) && (paramwgy.b != 1))) {
      return;
    }
    Object localObject = paramydd.a(paramwgy.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramwgy.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof ybu))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramwgy.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (ybu)localObject;
    if ((paramwgy.b == 1) || (paramwgy.b == 2))
    {
      if (paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((ybu)localObject).a).mCommentCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((ybu)localObject).a(((wip)wjs.a(17)).a(paramwgy.jdField_a_of_type_JavaLangString, false), true);
      ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramwgy.jdField_a_of_type_JavaLangString, Integer.valueOf(((ybu)localObject).b().size()));
    }
    for (;;)
    {
      ydd.a(paramydd).b(paramwgy.jdField_a_of_type_JavaLangString);
      return;
      if (paramwgy.b == 3)
      {
        if (paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((ybu)localObject).a).mHadLike = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((ybu)localObject).a).mLikeCount = paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((ybu)localObject).b(((wje)wjs.a(15)).a(paramwgy.jdField_a_of_type_JavaLangString, false), true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wgy.class;
  }
  
  public void b(@NonNull ydd paramydd, @NonNull wgy paramwgy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydi
 * JD-Core Version:    0.7.0.1
 */