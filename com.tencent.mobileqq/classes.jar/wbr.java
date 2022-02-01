import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wbr
  extends wbb
  implements vqp<wet, wgj>
{
  protected String a;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private wbt jdField_a_of_type_Wbt;
  
  public wbr(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public wbr(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public wbr a(wbt paramwbt)
  {
    this.jdField_a_of_type_Wbt = paramwbt;
    return this;
  }
  
  public void a()
  {
    wet localwet = new wet();
    localwet.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    vqn.a().a(localwet, this);
  }
  
  public void a(@NonNull wet paramwet, @Nullable wgj paramwgj, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwet = new wbs();
    paramwet.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramwet.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramwgj != null))
    {
      paramErrorMessage = new ArrayList();
      xen localxen = (xen)vux.a(7);
      if ((paramwgj.jdField_a_of_type_JavaUtilList != null) && (!paramwgj.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramwgj = paramwgj.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwgj.hasNext()) {
          paramErrorMessage.add(localxen.a((ShareGroupItem)paramwgj.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramwet.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramwet.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      vli.a().dispatch(paramwet);
      paramwgj = this.jdField_a_of_type_Wbt;
      if (paramwgj != null) {
        paramwgj.a(paramwet);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbr
 * JD-Core Version:    0.7.0.1
 */