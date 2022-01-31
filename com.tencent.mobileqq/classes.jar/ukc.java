import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class ukc
  extends sgl<ujx, snl>
{
  public ukc(ujx paramujx)
  {
    super(paramujx);
  }
  
  public void a(@NonNull ujx paramujx, @NonNull snl paramsnl)
  {
    if (((ujx.a(paramujx) == 12) && (paramsnl.jdField_a_of_type_Int == 3)) || ((ujx.a(paramujx) == 10) && (paramsnl.jdField_a_of_type_Int == 0) && (paramsnl.b != 1))) {
      return;
    }
    Object localObject = paramujx.a(paramsnl.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramsnl.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof uio))
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramsnl.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (uio)localObject;
    if ((paramsnl.b == 1) || (paramsnl.b == 2))
    {
      if (paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((uio)localObject).a).mCommentCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((uio)localObject).a(((spd)sqg.a(17)).a(paramsnl.jdField_a_of_type_JavaLangString, false), true);
      urk.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramsnl.jdField_a_of_type_JavaLangString, Integer.valueOf(((uio)localObject).b().size()));
    }
    for (;;)
    {
      ujx.a(paramujx).b(paramsnl.jdField_a_of_type_JavaLangString);
      return;
      if (paramsnl.b == 3)
      {
        if (paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((uio)localObject).a).mHadLike = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((uio)localObject).a).mLikeCount = paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((uio)localObject).b(((sps)sqg.a(15)).a(paramsnl.jdField_a_of_type_JavaLangString, false), true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return snl.class;
  }
  
  public void b(@NonNull ujx paramujx, @NonNull snl paramsnl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukc
 * JD-Core Version:    0.7.0.1
 */