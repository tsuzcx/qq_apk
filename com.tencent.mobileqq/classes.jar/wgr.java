import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class wgr
  extends QQUIEventReceiver<wgm, wra>
{
  public wgr(@NonNull wgm paramwgm)
  {
    super(paramwgm);
  }
  
  public void a(@NonNull wgm paramwgm, @NonNull wra paramwra)
  {
    if (paramwra.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    CommentEntry localCommentEntry;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramwgm.a.iterator();
      }
      localCommentEntry = (CommentEntry)localIterator.next();
    } while ((paramwra.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.authorUnionId) == null) && (paramwra.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.replierUnionId) == null));
    paramwgm.f();
    ykq.e(this.TAG, "UserIconUpdateReceiver FeedCommentLego need to update");
  }
  
  public Class acceptEventClass()
  {
    return wra.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgr
 * JD-Core Version:    0.7.0.1
 */