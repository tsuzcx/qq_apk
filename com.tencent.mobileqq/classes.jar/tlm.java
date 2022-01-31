import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tlm
  extends tjg
  implements syt<tna, toq>
{
  protected String a;
  protected List<String> a;
  
  public tlm(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    tna localtna = new tna();
    localtna.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    syr.a().a(localtna, this);
  }
  
  public void a(@NonNull tna paramtna, @Nullable toq paramtoq, @NonNull ErrorMessage paramErrorMessage)
  {
    tlo localtlo = new tlo();
    if ((paramtoq == null) || (paramErrorMessage.isFail()))
    {
      c();
      ste.a().dispatch(localtlo);
      return;
    }
    veg.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramtna.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramtna.jdField_a_of_type_JavaUtilList.toString());
    veg.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramtoq.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramtoq.toString());
    b();
    paramtoq.jdField_a_of_type_JavaUtilList = ((tcz)tdc.a(5)).a(paramtoq.jdField_a_of_type_JavaUtilList);
    localtlo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramtna = paramtoq.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtna.hasNext())
    {
      paramtoq = (StoryVideoItem)paramtna.next();
      paramtoq = new uuf(paramtoq.mVid, paramtoq);
      localtlo.jdField_a_of_type_JavaUtilList.add(paramtoq);
    }
    ste.a().dispatch(localtlo);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlm
 * JD-Core Version:    0.7.0.1
 */