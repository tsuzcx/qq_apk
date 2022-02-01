import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wdi
  extends wbb
  implements vqp<wew, wgm>
{
  protected String a;
  protected List<String> a;
  
  public wdi(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    wew localwew = new wew();
    localwew.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    vqn.a().a(localwew, this);
  }
  
  public void a(@NonNull wew paramwew, @Nullable wgm paramwgm, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwew = new wdj();
    if ((paramwgm == null) || (paramErrorMessage.isFail()))
    {
      c();
      vli.a().dispatch(paramwew);
      return;
    }
    b();
    paramwgm.jdField_a_of_type_JavaUtilList = ((vuu)vux.a(5)).a(paramwgm.jdField_a_of_type_JavaUtilList);
    paramwew.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramwgm = paramwgm.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwgm.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramwgm.next();
      paramErrorMessage = new xlu(paramErrorMessage.mVid, paramErrorMessage);
      paramwew.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    vli.a().dispatch(paramwew);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdi
 * JD-Core Version:    0.7.0.1
 */