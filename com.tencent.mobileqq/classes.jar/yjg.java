import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class yjg
  extends wfr<yjc, ybk>
{
  public yjg(yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull ybk paramybk)
  {
    int i = 1;
    if (paramybk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      localObject = paramyjc.a(paramybk.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramybk.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof yht))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramybk.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (yht)localObject;
    ((yht)localObject).a(paramybk.jdField_a_of_type_JavaUtilList, paramybk.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((yht)localObject).a;
    if (paramybk.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((yht)localObject).a).mCommentLastCookie = paramybk.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((yht)localObject).a).mCommentCount = paramybk.jdField_b_of_type_Int;
      ((yij)wpm.a(11)).a(((yht)localObject).a);
      yjc.a(paramyjc).b(paramybk.jdField_a_of_type_JavaLangString);
      yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramybk.jdField_a_of_type_JavaLangString, Integer.valueOf(((yht)localObject).b().size()), Boolean.valueOf(paramybk.jdField_a_of_type_Boolean), paramybk.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return ybk.class;
  }
  
  public void b(@NonNull yjc paramyjc, @NonNull ybk paramybk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjg
 * JD-Core Version:    0.7.0.1
 */