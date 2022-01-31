import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vku
  extends spi
  implements slx<tan, tby>
{
  String jdField_a_of_type_JavaLangString;
  spr jdField_a_of_type_Spr;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Spr == null)
    {
      spj localspj = new spj();
      localspj.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localspj.jdField_a_of_type_Boolean = paramBoolean;
      localspj.b = true;
      localspj.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localspj.jdField_a_of_type_Int = paramList.size();
      sgi.a().dispatch(localspj);
      return;
    }
    this.jdField_a_of_type_Spr.a(paramList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Spr = null;
  }
  
  public void a(@NonNull tan paramtan, @Nullable tby paramtby, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    paramtan = new StoryVideoItem();
    paramtan.mVid = this.b;
    paramtan.mStoryType = 2;
    if ((paramtby != null) && (paramErrorMessage.isSuccess()))
    {
      paramtan = paramtby.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtan.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramtan.next();
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
        ((sgs)sqg.a(28)).a(paramtby.b);
        a(paramtby.jdField_a_of_type_JavaUtilList, false);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramtby == null) {}
      for (paramtan = new ArrayList();; paramtan = paramtby.jdField_a_of_type_JavaUtilList)
      {
        a(paramtan, false);
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
 * Qualified Name:     vku
 * JD-Core Version:    0.7.0.1
 */