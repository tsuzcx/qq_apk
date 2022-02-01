import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class xom
  extends vll<xoi, xgq>
{
  public xom(xoi paramxoi)
  {
    super(paramxoi);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull xgq paramxgq)
  {
    int i = 1;
    if (paramxgq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      localObject = paramxoi.a(paramxgq.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramxgq.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof xmz))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramxgq.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (xmz)localObject;
    ((xmz)localObject).a(paramxgq.jdField_a_of_type_JavaUtilList, paramxgq.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((xmz)localObject).a;
    if (paramxgq.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((xmz)localObject).a).mCommentLastCookie = paramxgq.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((xmz)localObject).a).mCommentCount = paramxgq.jdField_b_of_type_Int;
      ((xnp)vux.a(11)).a(((xmz)localObject).a);
      xoi.a(paramxoi).b(paramxgq.jdField_a_of_type_JavaLangString);
      xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramxgq.jdField_a_of_type_JavaLangString, Integer.valueOf(((xmz)localObject).b().size()), Boolean.valueOf(paramxgq.jdField_a_of_type_Boolean), paramxgq.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return xgq.class;
  }
  
  public void b(@NonNull xoi paramxoi, @NonNull xgq paramxgq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xom
 * JD-Core Version:    0.7.0.1
 */