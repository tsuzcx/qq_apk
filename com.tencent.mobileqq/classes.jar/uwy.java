import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class uwy
  extends sth<uwt, tah>
{
  public uwy(uwt paramuwt)
  {
    super(paramuwt);
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull tah paramtah)
  {
    if (((uwt.a(paramuwt) == 12) && (paramtah.jdField_a_of_type_Int == 3)) || ((uwt.a(paramuwt) == 10) && (paramtah.jdField_a_of_type_Int == 0) && (paramtah.b != 1))) {
      return;
    }
    Object localObject = paramuwt.a(paramtah.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramtah.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof uvk))
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramtah.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (uvk)localObject;
    if ((paramtah.b == 1) || (paramtah.b == 2))
    {
      if (paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((uvk)localObject).a).mCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((uvk)localObject).a(((tbz)tdc.a(17)).a(paramtah.jdField_a_of_type_JavaLangString, false), true);
      veg.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramtah.jdField_a_of_type_JavaLangString, Integer.valueOf(((uvk)localObject).b().size()));
    }
    for (;;)
    {
      uwt.a(paramuwt).b(paramtah.jdField_a_of_type_JavaLangString);
      return;
      if (paramtah.b == 3)
      {
        if (paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((uvk)localObject).a).mHadLike = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((uvk)localObject).a).mLikeCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((uvk)localObject).b(((tco)tdc.a(15)).a(paramtah.jdField_a_of_type_JavaLangString, false), true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tah.class;
  }
  
  public void b(@NonNull uwt paramuwt, @NonNull tah paramtah) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwy
 * JD-Core Version:    0.7.0.1
 */