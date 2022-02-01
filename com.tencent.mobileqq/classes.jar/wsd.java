import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wsd
  extends wpw
  implements wfk<wtr, wvh>
{
  protected String a;
  protected List<String> a;
  
  public wsd(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    wtr localwtr = new wtr();
    localwtr.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    wfi.a().a(localwtr, this);
  }
  
  public void a(@NonNull wtr paramwtr, @Nullable wvh paramwvh, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwtr = new wse();
    if ((paramwvh == null) || (paramErrorMessage.isFail()))
    {
      c();
      wad.a().dispatch(paramwtr);
      return;
    }
    b();
    paramwvh.jdField_a_of_type_JavaUtilList = ((wjp)wjs.a(5)).a(paramwvh.jdField_a_of_type_JavaUtilList);
    paramwtr.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramwvh = paramwvh.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwvh.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramwvh.next();
      paramErrorMessage = new yap(paramErrorMessage.mVid, paramErrorMessage);
      paramwtr.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    wad.a().dispatch(paramwtr);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsd
 * JD-Core Version:    0.7.0.1
 */