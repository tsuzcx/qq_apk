import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class ukb
  extends sgl<ujx, ucf>
{
  public ukb(ujx paramujx)
  {
    super(paramujx);
  }
  
  public void a(@NonNull ujx paramujx, @NonNull ucf paramucf)
  {
    int i = 1;
    if (paramucf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      localObject = paramujx.a(paramucf.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        urk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramucf.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof uio))
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramucf.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (uio)localObject;
    ((uio)localObject).a(paramucf.jdField_a_of_type_JavaUtilList, paramucf.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((uio)localObject).a;
    if (paramucf.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((uio)localObject).a).mCommentLastCookie = paramucf.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((uio)localObject).a).mCommentCount = paramucf.jdField_b_of_type_Int;
      ((uje)sqg.a(11)).a(((uio)localObject).a);
      ujx.a(paramujx).b(paramucf.jdField_a_of_type_JavaLangString);
      urk.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramucf.jdField_a_of_type_JavaLangString, Integer.valueOf(((uio)localObject).b().size()), Boolean.valueOf(paramucf.jdField_a_of_type_Boolean), paramucf.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return ucf.class;
  }
  
  public void b(@NonNull ujx paramujx, @NonNull ucf paramucf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukb
 * JD-Core Version:    0.7.0.1
 */