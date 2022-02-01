import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wqm
  extends wpw
  implements wfk<wto, wve>
{
  protected String a;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private wqo jdField_a_of_type_Wqo;
  
  public wqm(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public wqm(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public wqm a(wqo paramwqo)
  {
    this.jdField_a_of_type_Wqo = paramwqo;
    return this;
  }
  
  public void a()
  {
    wto localwto = new wto();
    localwto.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    wfi.a().a(localwto, this);
  }
  
  public void a(@NonNull wto paramwto, @Nullable wve paramwve, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwto = new wqn();
    paramwto.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramwto.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramwve != null))
    {
      paramErrorMessage = new ArrayList();
      xti localxti = (xti)wjs.a(7);
      if ((paramwve.jdField_a_of_type_JavaUtilList != null) && (!paramwve.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramwve = paramwve.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwve.hasNext()) {
          paramErrorMessage.add(localxti.a((ShareGroupItem)paramwve.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramwto.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramwto.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      wad.a().dispatch(paramwto);
      paramwve = this.jdField_a_of_type_Wqo;
      if (paramwve != null) {
        paramwve.a(paramwto);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqm
 * JD-Core Version:    0.7.0.1
 */