import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class wqf
  extends QQUIEventReceiver<wqa, xap>
{
  public wqf(@NonNull wqa paramwqa)
  {
    super(paramwqa);
  }
  
  public void a(@NonNull wqa paramwqa, @NonNull xap paramxap)
  {
    if (paramxap.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    CommentEntry localCommentEntry;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramwqa.a.iterator();
      }
      localCommentEntry = (CommentEntry)localIterator.next();
    } while ((paramxap.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.authorUnionId) == null) && (paramxap.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.replierUnionId) == null));
    paramwqa.f();
    yuk.e(this.TAG, "UserIconUpdateReceiver FeedCommentLego need to update");
  }
  
  public Class acceptEventClass()
  {
    return xap.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqf
 * JD-Core Version:    0.7.0.1
 */