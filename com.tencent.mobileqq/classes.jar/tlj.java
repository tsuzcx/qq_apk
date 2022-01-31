import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tlj
  extends tjd
  implements syq<tmx, ton>
{
  protected String a;
  protected List<String> a;
  
  public tlj(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    tmx localtmx = new tmx();
    localtmx.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    syo.a().a(localtmx, this);
  }
  
  public void a(@NonNull tmx paramtmx, @Nullable ton paramton, @NonNull ErrorMessage paramErrorMessage)
  {
    tll localtll = new tll();
    if ((paramton == null) || (paramErrorMessage.isFail()))
    {
      c();
      stb.a().dispatch(localtll);
      return;
    }
    ved.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramtmx.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramtmx.jdField_a_of_type_JavaUtilList.toString());
    ved.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramton.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramton.toString());
    b();
    paramton.jdField_a_of_type_JavaUtilList = ((tcw)tcz.a(5)).a(paramton.jdField_a_of_type_JavaUtilList);
    localtll.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramtmx = paramton.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtmx.hasNext())
    {
      paramton = (StoryVideoItem)paramtmx.next();
      paramton = new uuc(paramton.mVid, paramton);
      localtll.jdField_a_of_type_JavaUtilList.add(paramton);
    }
    stb.a().dispatch(localtll);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlj
 * JD-Core Version:    0.7.0.1
 */