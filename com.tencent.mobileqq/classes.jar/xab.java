import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xab
  extends wzl
  implements woy<xdd, xet>
{
  protected String a;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private xad jdField_a_of_type_Xad;
  
  public xab(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public xab(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    xdd localxdd = new xdd();
    localxdd.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    wow.a().a(localxdd, this);
  }
  
  public void a(@NonNull xdd paramxdd, @Nullable xet paramxet, @NonNull ErrorMessage paramErrorMessage)
  {
    paramxdd = new xac();
    paramxdd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramxdd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramxet != null))
    {
      paramErrorMessage = new ArrayList();
      ydc localydc = (ydc)wth.a(7);
      if ((paramxet.jdField_a_of_type_JavaUtilList != null) && (!paramxet.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramxet = paramxet.jdField_a_of_type_JavaUtilList.iterator();
        while (paramxet.hasNext()) {
          paramErrorMessage.add(localydc.a((ShareGroupItem)paramxet.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramxdd.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramxdd.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      wjj.a().dispatch(paramxdd);
      paramxet = this.jdField_a_of_type_Xad;
      if (paramxet != null) {
        paramxet.a(paramxdd);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xab
 * JD-Core Version:    0.7.0.1
 */