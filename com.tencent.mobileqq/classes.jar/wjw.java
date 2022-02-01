import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class wjw
  implements wfk<wtc, wte>
{
  wjw(wjv paramwjv) {}
  
  public void a(@NonNull wtc paramwtc, @Nullable wte paramwte, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwtc = paramwtc.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwtc.hasNext())
    {
      localObject = (String)paramwtc.next();
      wjv.a(this.a).remove(localObject);
    }
    paramwtc = new wjx();
    paramwtc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramwte == null))
    {
      ykq.d("Q.qqstory:TagManager", "request fail for get tag request");
      wad.a().dispatch(paramwtc);
      return;
    }
    paramErrorMessage = paramwtc.jdField_a_of_type_JavaUtilMap;
    Object localObject = (wjv)wjs.a(27);
    paramwte = paramwte.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwte.hasNext())
    {
      wtd localwtd = (wtd)paramwte.next();
      ((wjv)localObject).a(localwtd.jdField_a_of_type_JavaLangString, localwtd.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localwtd.jdField_a_of_type_JavaLangString, localwtd);
      ykq.a("Q.qqstory:TagManager", "save feedId :%s , %s", localwtd.jdField_a_of_type_JavaLangString, localwtd.jdField_a_of_type_JavaUtilList);
    }
    wad.a().dispatch(paramwtc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjw
 * JD-Core Version:    0.7.0.1
 */