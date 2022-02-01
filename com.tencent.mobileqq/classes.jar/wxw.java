import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wxw
  extends wvq
  implements wld<wzk, xba>
{
  protected String a;
  protected List<String> a;
  
  public wxw(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    wzk localwzk = new wzk();
    localwzk.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    wlb.a().a(localwzk, this);
  }
  
  public void a(@NonNull wzk paramwzk, @Nullable xba paramxba, @NonNull ErrorMessage paramErrorMessage)
  {
    wxy localwxy = new wxy();
    if ((paramxba == null) || (paramErrorMessage.isFail()))
    {
      c();
      wfo.a().dispatch(localwxy);
      return;
    }
    yqp.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramwzk.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramwzk.jdField_a_of_type_JavaUtilList.toString());
    yqp.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramxba.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramxba.toString());
    b();
    paramxba.jdField_a_of_type_JavaUtilList = ((wpj)wpm.a(5)).a(paramxba.jdField_a_of_type_JavaUtilList);
    localwxy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramwzk = paramxba.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwzk.hasNext())
    {
      paramxba = (StoryVideoItem)paramwzk.next();
      paramxba = new ygo(paramxba.mVid, paramxba);
      localwxy.jdField_a_of_type_JavaUtilList.add(paramxba);
    }
    wfo.a().dispatch(localwxy);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxw
 * JD-Core Version:    0.7.0.1
 */