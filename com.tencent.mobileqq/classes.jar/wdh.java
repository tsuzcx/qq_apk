import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wdh
  extends wbb
  implements vqp<wev, wgl>
{
  protected String a;
  protected List<String> a;
  
  public wdh(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    wev localwev = new wev();
    localwev.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    vqn.a().a(localwev, this);
  }
  
  public void a(@NonNull wev paramwev, @Nullable wgl paramwgl, @NonNull ErrorMessage paramErrorMessage)
  {
    wdj localwdj = new wdj();
    if ((paramwgl == null) || (paramErrorMessage.isFail()))
    {
      c();
      vli.a().dispatch(localwdj);
      return;
    }
    xvv.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramwev.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramwev.jdField_a_of_type_JavaUtilList.toString());
    xvv.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramwgl.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramwgl.toString());
    b();
    paramwgl.jdField_a_of_type_JavaUtilList = ((vuu)vux.a(5)).a(paramwgl.jdField_a_of_type_JavaUtilList);
    localwdj.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramwev = paramwgl.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwev.hasNext())
    {
      paramwgl = (StoryVideoItem)paramwev.next();
      paramwgl = new xlu(paramwgl.mVid, paramwgl);
      localwdj.jdField_a_of_type_JavaUtilList.add(paramwgl);
    }
    vli.a().dispatch(localwdj);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdh
 * JD-Core Version:    0.7.0.1
 */