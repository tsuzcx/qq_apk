import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class vrw
  extends QQUIEventReceiver<vrr, wcf>
{
  public vrw(@NonNull vrr paramvrr)
  {
    super(paramvrr);
  }
  
  public void a(@NonNull vrr paramvrr, @NonNull wcf paramwcf)
  {
    if (paramwcf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    CommentEntry localCommentEntry;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramvrr.a.iterator();
      }
      localCommentEntry = (CommentEntry)localIterator.next();
    } while ((paramwcf.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.authorUnionId) == null) && (paramwcf.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.replierUnionId) == null));
    paramvrr.f();
    xvv.e(this.TAG, "UserIconUpdateReceiver FeedCommentLego need to update");
  }
  
  public Class acceptEventClass()
  {
    return wcf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrw
 * JD-Core Version:    0.7.0.1
 */