import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class wmk
  extends QQUIEventReceiver<wmf, wwu>
{
  public wmk(@NonNull wmf paramwmf)
  {
    super(paramwmf);
  }
  
  public void a(@NonNull wmf paramwmf, @NonNull wwu paramwwu)
  {
    if (paramwwu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    CommentEntry localCommentEntry;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramwmf.a.iterator();
      }
      localCommentEntry = (CommentEntry)localIterator.next();
    } while ((paramwwu.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.authorUnionId) == null) && (paramwwu.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.replierUnionId) == null));
    paramwmf.f();
    yqp.e(this.TAG, "UserIconUpdateReceiver FeedCommentLego need to update");
  }
  
  public Class acceptEventClass()
  {
    return wwu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmk
 * JD-Core Version:    0.7.0.1
 */