import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wxx
  extends wvq
  implements wld<wzl, xbb>
{
  protected String a;
  protected List<String> a;
  
  public wxx(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    wzl localwzl = new wzl();
    localwzl.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    wlb.a().a(localwzl, this);
  }
  
  public void a(@NonNull wzl paramwzl, @Nullable xbb paramxbb, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwzl = new wxy();
    if ((paramxbb == null) || (paramErrorMessage.isFail()))
    {
      c();
      wfo.a().dispatch(paramwzl);
      return;
    }
    b();
    paramxbb.jdField_a_of_type_JavaUtilList = ((wpj)wpm.a(5)).a(paramxbb.jdField_a_of_type_JavaUtilList);
    paramwzl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramxbb = paramxbb.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxbb.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramxbb.next();
      paramErrorMessage = new ygo(paramErrorMessage.mVid, paramErrorMessage);
      paramwzl.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    wfo.a().dispatch(paramwzl);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxx
 * JD-Core Version:    0.7.0.1
 */