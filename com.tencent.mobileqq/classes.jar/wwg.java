import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wwg
  extends wvq
  implements wld<wzi, xay>
{
  protected String a;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private wwi jdField_a_of_type_Wwi;
  
  public wwg(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public wwg(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    wzi localwzi = new wzi();
    localwzi.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    wlb.a().a(localwzi, this);
  }
  
  public void a(@NonNull wzi paramwzi, @Nullable xay paramxay, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwzi = new wwh();
    paramwzi.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramwzi.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramxay != null))
    {
      paramErrorMessage = new ArrayList();
      xzh localxzh = (xzh)wpm.a(7);
      if ((paramxay.jdField_a_of_type_JavaUtilList != null) && (!paramxay.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramxay = paramxay.jdField_a_of_type_JavaUtilList.iterator();
        while (paramxay.hasNext()) {
          paramErrorMessage.add(localxzh.a((ShareGroupItem)paramxay.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramwzi.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramwzi.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      wfo.a().dispatch(paramwzi);
      paramxay = this.jdField_a_of_type_Wwi;
      if (paramxay != null) {
        paramxay.a(paramwzi);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwg
 * JD-Core Version:    0.7.0.1
 */