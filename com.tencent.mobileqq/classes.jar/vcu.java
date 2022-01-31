import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vcu
  extends vce
  implements urr<vfw, vhm>
{
  protected String a;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private vcw jdField_a_of_type_Vcw;
  
  public vcu(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public vcu(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    vfw localvfw = new vfw();
    localvfw.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    urp.a().a(localvfw, this);
  }
  
  public void a(@NonNull vfw paramvfw, @Nullable vhm paramvhm, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvfw = new vcv();
    paramvfw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramvfw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramvhm != null))
    {
      paramErrorMessage = new ArrayList();
      wfw localwfw = (wfw)uwa.a(7);
      if ((paramvhm.jdField_a_of_type_JavaUtilList != null) && (!paramvhm.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramvhm = paramvhm.jdField_a_of_type_JavaUtilList.iterator();
        while (paramvhm.hasNext()) {
          paramErrorMessage.add(localwfw.a((ShareGroupItem)paramvhm.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramvfw.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramvfw.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      umc.a().dispatch(paramvfw);
      paramvhm = this.jdField_a_of_type_Vcw;
      if (paramvhm != null) {
        paramvhm.a(paramvfw);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vcu
 * JD-Core Version:    0.7.0.1
 */