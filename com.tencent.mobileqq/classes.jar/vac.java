import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vac
  extends uxv
  implements uni<vbq, vdg>
{
  protected String a;
  protected List<String> a;
  
  public vac(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    vbq localvbq = new vbq();
    localvbq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    ung.a().a(localvbq, this);
  }
  
  public void a(@NonNull vbq paramvbq, @Nullable vdg paramvdg, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvbq = new vad();
    if ((paramvdg == null) || (paramErrorMessage.isFail()))
    {
      c();
      uht.a().dispatch(paramvbq);
      return;
    }
    b();
    paramvdg.jdField_a_of_type_JavaUtilList = ((uro)urr.a(5)).a(paramvdg.jdField_a_of_type_JavaUtilList);
    paramvbq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramvdg = paramvdg.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvdg.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramvdg.next();
      paramErrorMessage = new wiu(paramErrorMessage.mVid, paramErrorMessage);
      paramvbq.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    uht.a().dispatch(paramvbq);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vac
 * JD-Core Version:    0.7.0.1
 */