import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vel
  extends vce
  implements urr<vfz, vhp>
{
  protected String a;
  protected List<String> a;
  
  public vel(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    vfz localvfz = new vfz();
    localvfz.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    urp.a().a(localvfz, this);
  }
  
  public void a(@NonNull vfz paramvfz, @Nullable vhp paramvhp, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvfz = new vem();
    if ((paramvhp == null) || (paramErrorMessage.isFail()))
    {
      c();
      umc.a().dispatch(paramvfz);
      return;
    }
    b();
    paramvhp.jdField_a_of_type_JavaUtilList = ((uvx)uwa.a(5)).a(paramvhp.jdField_a_of_type_JavaUtilList);
    paramvfz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramvhp = paramvhp.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvhp.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramvhp.next();
      paramErrorMessage = new wnd(paramErrorMessage.mVid, paramErrorMessage);
      paramvfz.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    umc.a().dispatch(paramvfz);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vel
 * JD-Core Version:    0.7.0.1
 */