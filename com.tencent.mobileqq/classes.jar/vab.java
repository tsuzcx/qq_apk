import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vab
  extends uxv
  implements uni<vbp, vdf>
{
  protected String a;
  protected List<String> a;
  
  public vab(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    vbp localvbp = new vbp();
    localvbp.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    ung.a().a(localvbp, this);
  }
  
  public void a(@NonNull vbp paramvbp, @Nullable vdf paramvdf, @NonNull ErrorMessage paramErrorMessage)
  {
    vad localvad = new vad();
    if ((paramvdf == null) || (paramErrorMessage.isFail()))
    {
      c();
      uht.a().dispatch(localvad);
      return;
    }
    wsv.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramvbp.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramvbp.jdField_a_of_type_JavaUtilList.toString());
    wsv.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramvdf.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramvdf.toString());
    b();
    paramvdf.jdField_a_of_type_JavaUtilList = ((uro)urr.a(5)).a(paramvdf.jdField_a_of_type_JavaUtilList);
    localvad.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramvbp = paramvdf.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvbp.hasNext())
    {
      paramvdf = (StoryVideoItem)paramvbp.next();
      paramvdf = new wiu(paramvdf.mVid, paramvdf);
      localvad.jdField_a_of_type_JavaUtilList.add(paramvdf);
    }
    uht.a().dispatch(localvad);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vab
 * JD-Core Version:    0.7.0.1
 */