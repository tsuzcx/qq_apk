import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uyl
  extends uxv
  implements uni<vbn, vdd>
{
  protected String a;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private uyn jdField_a_of_type_Uyn;
  
  public uyl(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public uyl(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    vbn localvbn = new vbn();
    localvbn.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    ung.a().a(localvbn, this);
  }
  
  public void a(@NonNull vbn paramvbn, @Nullable vdd paramvdd, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvbn = new uym();
    paramvbn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramvbn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramvdd != null))
    {
      paramErrorMessage = new ArrayList();
      wbn localwbn = (wbn)urr.a(7);
      if ((paramvdd.jdField_a_of_type_JavaUtilList != null) && (!paramvdd.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramvdd = paramvdd.jdField_a_of_type_JavaUtilList.iterator();
        while (paramvdd.hasNext()) {
          paramErrorMessage.add(localwbn.a((ShareGroupItem)paramvdd.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramvbn.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramvbn.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      uht.a().dispatch(paramvbn);
      paramvdd = this.jdField_a_of_type_Uyn;
      if (paramvdd != null) {
        paramvdd.a(paramvbn);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uyl
 * JD-Core Version:    0.7.0.1
 */