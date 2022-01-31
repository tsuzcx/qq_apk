import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tjt
  extends tjd
  implements syq<tmv, tol>
{
  protected String a;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private tjv jdField_a_of_type_Tjv;
  
  public tjt(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public tjt(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    tmv localtmv = new tmv();
    localtmv.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    syo.a().a(localtmv, this);
  }
  
  public void a(@NonNull tmv paramtmv, @Nullable tol paramtol, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtmv = new tju();
    paramtmv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramtmv.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramtol != null))
    {
      paramErrorMessage = new ArrayList();
      umv localumv = (umv)tcz.a(7);
      if ((paramtol.jdField_a_of_type_JavaUtilList != null) && (!paramtol.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramtol = paramtol.jdField_a_of_type_JavaUtilList.iterator();
        while (paramtol.hasNext()) {
          paramErrorMessage.add(localumv.a((ShareGroupItem)paramtol.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramtmv.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramtmv.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      stb.a().dispatch(paramtmv);
      paramtol = this.jdField_a_of_type_Tjv;
      if (paramtol != null) {
        paramtol.a(paramtmv);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjt
 * JD-Core Version:    0.7.0.1
 */