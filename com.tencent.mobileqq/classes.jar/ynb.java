import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class ynb
  extends wjm<ymx, yff>
{
  public ynb(ymx paramymx)
  {
    super(paramymx);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull yff paramyff)
  {
    int i = 1;
    if (paramyff.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      localObject = paramymx.a(paramyff.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramyff.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof ylo))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramyff.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (ylo)localObject;
    ((ylo)localObject).a(paramyff.jdField_a_of_type_JavaUtilList, paramyff.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((ylo)localObject).a;
    if (paramyff.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((ylo)localObject).a).mCommentLastCookie = paramyff.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((ylo)localObject).a).mCommentCount = paramyff.jdField_b_of_type_Int;
      ((yme)wth.a(11)).a(((ylo)localObject).a);
      ymx.a(paramymx).b(paramyff.jdField_a_of_type_JavaLangString);
      yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramyff.jdField_a_of_type_JavaLangString, Integer.valueOf(((ylo)localObject).b().size()), Boolean.valueOf(paramyff.jdField_a_of_type_Boolean), paramyff.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return yff.class;
  }
  
  public void b(@NonNull ymx paramymx, @NonNull yff paramyff) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynb
 * JD-Core Version:    0.7.0.1
 */