import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vxn
  extends tcb
  implements syq<tng, tor>
{
  String jdField_a_of_type_JavaLangString;
  tck jdField_a_of_type_Tck;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tck == null)
    {
      tcc localtcc = new tcc();
      localtcc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localtcc.jdField_a_of_type_Boolean = paramBoolean;
      localtcc.b = true;
      localtcc.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localtcc.jdField_a_of_type_Int = paramList.size();
      stb.a().dispatch(localtcc);
      return;
    }
    this.jdField_a_of_type_Tck.a(paramList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Tck = null;
  }
  
  public void a(@NonNull tng paramtng, @Nullable tor paramtor, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    paramtng = new StoryVideoItem();
    paramtng.mVid = this.b;
    paramtng.mStoryType = 2;
    if ((paramtor != null) && (paramErrorMessage.isSuccess()))
    {
      paramtng = paramtor.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtng.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramtng.next();
        if (this.b.equals(paramErrorMessage.mVid)) {
          if (paramErrorMessage.mErrorCode != 0) {
            break;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((stl)tcz.a(28)).a(paramtor.b);
        a(paramtor.jdField_a_of_type_JavaUtilList, false);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramtor == null) {}
      for (paramtng = new ArrayList();; paramtng = paramtor.jdField_a_of_type_JavaUtilList)
      {
        a(paramtng, false);
        return;
      }
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxn
 * JD-Core Version:    0.7.0.1
 */