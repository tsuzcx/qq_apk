import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tlk
  extends tjd
  implements syq<tmy, too>
{
  protected String a;
  protected List<String> a;
  
  public tlk(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    tmy localtmy = new tmy();
    localtmy.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    syo.a().a(localtmy, this);
  }
  
  public void a(@NonNull tmy paramtmy, @Nullable too paramtoo, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtmy = new tll();
    if ((paramtoo == null) || (paramErrorMessage.isFail()))
    {
      c();
      stb.a().dispatch(paramtmy);
      return;
    }
    b();
    paramtoo.jdField_a_of_type_JavaUtilList = ((tcw)tcz.a(5)).a(paramtoo.jdField_a_of_type_JavaUtilList);
    paramtmy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramtoo = paramtoo.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtoo.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramtoo.next();
      paramErrorMessage = new uuc(paramErrorMessage.mVid, paramErrorMessage);
      paramtmy.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    stb.a().dispatch(paramtmy);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlk
 * JD-Core Version:    0.7.0.1
 */