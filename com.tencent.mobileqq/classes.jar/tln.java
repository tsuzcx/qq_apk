import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tln
  extends tjg
  implements syt<tnb, tor>
{
  protected String a;
  protected List<String> a;
  
  public tln(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    tnb localtnb = new tnb();
    localtnb.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    syr.a().a(localtnb, this);
  }
  
  public void a(@NonNull tnb paramtnb, @Nullable tor paramtor, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtnb = new tlo();
    if ((paramtor == null) || (paramErrorMessage.isFail()))
    {
      c();
      ste.a().dispatch(paramtnb);
      return;
    }
    b();
    paramtor.jdField_a_of_type_JavaUtilList = ((tcz)tdc.a(5)).a(paramtor.jdField_a_of_type_JavaUtilList);
    paramtnb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramtor = paramtor.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtor.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramtor.next();
      paramErrorMessage = new uuf(paramErrorMessage.mVid, paramErrorMessage);
      paramtnb.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    ste.a().dispatch(paramtnb);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tln
 * JD-Core Version:    0.7.0.1
 */