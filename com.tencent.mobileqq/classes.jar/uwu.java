import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class uwu
  extends ste<uwq, uoy>
{
  public uwu(uwq paramuwq)
  {
    super(paramuwq);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull uoy paramuoy)
  {
    int i = 1;
    if (paramuoy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      localObject = paramuwq.a(paramuoy.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        ved.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramuoy.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof uvh))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramuoy.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (uvh)localObject;
    ((uvh)localObject).a(paramuoy.jdField_a_of_type_JavaUtilList, paramuoy.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((uvh)localObject).a;
    if (paramuoy.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((uvh)localObject).a).mCommentLastCookie = paramuoy.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((uvh)localObject).a).mCommentCount = paramuoy.jdField_b_of_type_Int;
      ((uvx)tcz.a(11)).a(((uvh)localObject).a);
      uwq.a(paramuwq).b(paramuoy.jdField_a_of_type_JavaLangString);
      ved.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramuoy.jdField_a_of_type_JavaLangString, Integer.valueOf(((uvh)localObject).b().size()), Boolean.valueOf(paramuoy.jdField_a_of_type_Boolean), paramuoy.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return uoy.class;
  }
  
  public void b(@NonNull uwq paramuwq, @NonNull uoy paramuoy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwu
 * JD-Core Version:    0.7.0.1
 */