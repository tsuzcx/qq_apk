import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class wln
  extends uhw<wli, uow>
{
  public wln(wli paramwli)
  {
    super(paramwli);
  }
  
  public void a(@NonNull wli paramwli, @NonNull uow paramuow)
  {
    if (((wli.a(paramwli) == 12) && (paramuow.jdField_a_of_type_Int == 3)) || ((wli.a(paramwli) == 10) && (paramuow.jdField_a_of_type_Int == 0) && (paramuow.b != 1))) {
      return;
    }
    Object localObject = paramwli.a(paramuow.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramuow.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof wjz))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramuow.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (wjz)localObject;
    if ((paramuow.b == 1) || (paramuow.b == 2))
    {
      if (paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((wjz)localObject).a).mCommentCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((wjz)localObject).a(((uqo)urr.a(17)).a(paramuow.jdField_a_of_type_JavaLangString, false), true);
      wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramuow.jdField_a_of_type_JavaLangString, Integer.valueOf(((wjz)localObject).b().size()));
    }
    for (;;)
    {
      wli.a(paramwli).b(paramuow.jdField_a_of_type_JavaLangString);
      return;
      if (paramuow.b == 3)
      {
        if (paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((wjz)localObject).a).mHadLike = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((wjz)localObject).a).mLikeCount = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((wjz)localObject).b(((urd)urr.a(15)).a(paramuow.jdField_a_of_type_JavaLangString, false), true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
  
  public void b(@NonNull wli paramwli, @NonNull uow paramuow) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wln
 * JD-Core Version:    0.7.0.1
 */