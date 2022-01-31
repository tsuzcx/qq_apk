import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class uwv
  extends ste<uwq, tae>
{
  public uwv(uwq paramuwq)
  {
    super(paramuwq);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull tae paramtae)
  {
    if (((uwq.a(paramuwq) == 12) && (paramtae.jdField_a_of_type_Int == 3)) || ((uwq.a(paramuwq) == 10) && (paramtae.jdField_a_of_type_Int == 0) && (paramtae.b != 1))) {
      return;
    }
    Object localObject = paramuwq.a(paramtae.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramtae.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof uvh))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramtae.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (uvh)localObject;
    if ((paramtae.b == 1) || (paramtae.b == 2))
    {
      if (paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((uvh)localObject).a).mCommentCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((uvh)localObject).a(((tbw)tcz.a(17)).a(paramtae.jdField_a_of_type_JavaLangString, false), true);
      ved.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramtae.jdField_a_of_type_JavaLangString, Integer.valueOf(((uvh)localObject).b().size()));
    }
    for (;;)
    {
      uwq.a(paramuwq).b(paramtae.jdField_a_of_type_JavaLangString);
      return;
      if (paramtae.b == 3)
      {
        if (paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((uvh)localObject).a).mHadLike = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((uvh)localObject).a).mLikeCount = paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((uvh)localObject).b(((tcl)tcz.a(15)).a(paramtae.jdField_a_of_type_JavaLangString, false), true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tae.class;
  }
  
  public void b(@NonNull uwq paramuwq, @NonNull tae paramtae) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwv
 * JD-Core Version:    0.7.0.1
 */