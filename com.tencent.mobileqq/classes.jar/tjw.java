import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tjw
  extends tjg
  implements syt<tmy, too>
{
  protected String a;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private tjy jdField_a_of_type_Tjy;
  
  public tjw(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public tjw(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    tmy localtmy = new tmy();
    localtmy.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    syr.a().a(localtmy, this);
  }
  
  public void a(@NonNull tmy paramtmy, @Nullable too paramtoo, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtmy = new tjx();
    paramtmy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramtmy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramtoo != null))
    {
      paramErrorMessage = new ArrayList();
      umy localumy = (umy)tdc.a(7);
      if ((paramtoo.jdField_a_of_type_JavaUtilList != null) && (!paramtoo.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramtoo = paramtoo.jdField_a_of_type_JavaUtilList.iterator();
        while (paramtoo.hasNext()) {
          paramErrorMessage.add(localumy.a((ShareGroupItem)paramtoo.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramtmy.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramtmy.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      ste.a().dispatch(paramtmy);
      paramtoo = this.jdField_a_of_type_Tjy;
      if (paramtoo != null) {
        paramtoo.a(paramtmy);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjw
 * JD-Core Version:    0.7.0.1
 */