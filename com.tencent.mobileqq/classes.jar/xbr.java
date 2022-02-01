import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xbr
  extends wzl
  implements woy<xdf, xev>
{
  protected String a;
  protected List<String> a;
  
  public xbr(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    xdf localxdf = new xdf();
    localxdf.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    wow.a().a(localxdf, this);
  }
  
  public void a(@NonNull xdf paramxdf, @Nullable xev paramxev, @NonNull ErrorMessage paramErrorMessage)
  {
    xbt localxbt = new xbt();
    if ((paramxev == null) || (paramErrorMessage.isFail()))
    {
      c();
      wjj.a().dispatch(localxbt);
      return;
    }
    yuk.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramxdf.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramxdf.jdField_a_of_type_JavaUtilList.toString());
    yuk.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramxev.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramxev.toString());
    b();
    paramxev.jdField_a_of_type_JavaUtilList = ((wte)wth.a(5)).a(paramxev.jdField_a_of_type_JavaUtilList);
    localxbt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramxdf = paramxev.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxdf.hasNext())
    {
      paramxev = (StoryVideoItem)paramxdf.next();
      paramxev = new ykj(paramxev.mVid, paramxev);
      localxbt.jdField_a_of_type_JavaUtilList.add(paramxev);
    }
    wjj.a().dispatch(localxbt);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbr
 * JD-Core Version:    0.7.0.1
 */