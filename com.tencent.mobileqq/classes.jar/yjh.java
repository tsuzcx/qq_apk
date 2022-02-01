import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class yjh
  extends wfr<yjc, wmr>
{
  public yjh(yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull wmr paramwmr)
  {
    if (((yjc.a(paramyjc) == 12) && (paramwmr.jdField_a_of_type_Int == 3)) || ((yjc.a(paramyjc) == 10) && (paramwmr.jdField_a_of_type_Int == 0) && (paramwmr.b != 1))) {
      return;
    }
    Object localObject = paramyjc.a(paramwmr.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramwmr.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof yht))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramwmr.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (yht)localObject;
    if ((paramwmr.b == 1) || (paramwmr.b == 2))
    {
      if (paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((yht)localObject).a).mCommentCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((yht)localObject).a(((woj)wpm.a(17)).a(paramwmr.jdField_a_of_type_JavaLangString, false), true);
      yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramwmr.jdField_a_of_type_JavaLangString, Integer.valueOf(((yht)localObject).b().size()));
    }
    for (;;)
    {
      yjc.a(paramyjc).b(paramwmr.jdField_a_of_type_JavaLangString);
      return;
      if (paramwmr.b == 3)
      {
        if (paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((yht)localObject).a).mHadLike = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((yht)localObject).a).mLikeCount = paramwmr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((yht)localObject).b(((woy)wpm.a(15)).a(paramwmr.jdField_a_of_type_JavaLangString, false), true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wmr.class;
  }
  
  public void b(@NonNull yjc paramyjc, @NonNull wmr paramwmr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjh
 * JD-Core Version:    0.7.0.1
 */