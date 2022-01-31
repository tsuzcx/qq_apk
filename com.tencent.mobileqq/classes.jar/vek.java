import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vek
  extends vce
  implements urr<vfy, vho>
{
  protected String a;
  protected List<String> a;
  
  public vek(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    vfy localvfy = new vfy();
    localvfy.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    urp.a().a(localvfy, this);
  }
  
  public void a(@NonNull vfy paramvfy, @Nullable vho paramvho, @NonNull ErrorMessage paramErrorMessage)
  {
    vem localvem = new vem();
    if ((paramvho == null) || (paramErrorMessage.isFail()))
    {
      c();
      umc.a().dispatch(localvem);
      return;
    }
    wxe.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramvfy.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramvfy.jdField_a_of_type_JavaUtilList.toString());
    wxe.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramvho.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramvho.toString());
    b();
    paramvho.jdField_a_of_type_JavaUtilList = ((uvx)uwa.a(5)).a(paramvho.jdField_a_of_type_JavaUtilList);
    localvem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramvfy = paramvho.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvfy.hasNext())
    {
      paramvho = (StoryVideoItem)paramvfy.next();
      paramvho = new wnd(paramvho.mVid, paramvho);
      localvem.jdField_a_of_type_JavaUtilList.add(paramvho);
    }
    umc.a().dispatch(localvem);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vek
 * JD-Core Version:    0.7.0.1
 */