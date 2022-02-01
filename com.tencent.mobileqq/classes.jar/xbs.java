import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xbs
  extends wzl
  implements woy<xdg, xew>
{
  protected String a;
  protected List<String> a;
  
  public xbs(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    xdg localxdg = new xdg();
    localxdg.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    wow.a().a(localxdg, this);
  }
  
  public void a(@NonNull xdg paramxdg, @Nullable xew paramxew, @NonNull ErrorMessage paramErrorMessage)
  {
    paramxdg = new xbt();
    if ((paramxew == null) || (paramErrorMessage.isFail()))
    {
      c();
      wjj.a().dispatch(paramxdg);
      return;
    }
    b();
    paramxew.jdField_a_of_type_JavaUtilList = ((wte)wth.a(5)).a(paramxew.jdField_a_of_type_JavaUtilList);
    paramxdg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramxew = paramxew.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxew.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramxew.next();
      paramErrorMessage = new ykj(paramErrorMessage.mVid, paramErrorMessage);
      paramxdg.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    wjj.a().dispatch(paramxdg);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbs
 * JD-Core Version:    0.7.0.1
 */