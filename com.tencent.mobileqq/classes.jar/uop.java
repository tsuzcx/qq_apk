import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class uop
  extends QQUIEventReceiver<uok, uyz>
{
  public uop(@NonNull uok paramuok)
  {
    super(paramuok);
  }
  
  public void a(@NonNull uok paramuok, @NonNull uyz paramuyz)
  {
    if (paramuyz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    CommentEntry localCommentEntry;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramuok.a.iterator();
      }
      localCommentEntry = (CommentEntry)localIterator.next();
    } while ((paramuyz.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.authorUnionId) == null) && (paramuyz.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.replierUnionId) == null));
    paramuok.f();
    wsv.e(this.TAG, "UserIconUpdateReceiver FeedCommentLego need to update");
  }
  
  public Class acceptEventClass()
  {
    return uyz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uop
 * JD-Core Version:    0.7.0.1
 */