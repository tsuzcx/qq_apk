import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wsc
  extends wpw
  implements wfk<wtq, wvg>
{
  protected String a;
  protected List<String> a;
  
  public wsc(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    wtq localwtq = new wtq();
    localwtq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    wfi.a().a(localwtq, this);
  }
  
  public void a(@NonNull wtq paramwtq, @Nullable wvg paramwvg, @NonNull ErrorMessage paramErrorMessage)
  {
    wse localwse = new wse();
    if ((paramwvg == null) || (paramErrorMessage.isFail()))
    {
      c();
      wad.a().dispatch(localwse);
      return;
    }
    ykq.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramwtq.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramwtq.jdField_a_of_type_JavaUtilList.toString());
    ykq.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramwvg.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramwvg.toString());
    b();
    paramwvg.jdField_a_of_type_JavaUtilList = ((wjp)wjs.a(5)).a(paramwvg.jdField_a_of_type_JavaUtilList);
    localwse.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramwtq = paramwvg.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwtq.hasNext())
    {
      paramwvg = (StoryVideoItem)paramwtq.next();
      paramwvg = new yap(paramwvg.mVid, paramwvg);
      localwse.jdField_a_of_type_JavaUtilList.add(paramwvg);
    }
    wad.a().dispatch(localwse);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsc
 * JD-Core Version:    0.7.0.1
 */