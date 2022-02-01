import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zjz
  extends woo
  implements wld<wzt, xbe>
{
  String jdField_a_of_type_JavaLangString;
  wox jdField_a_of_type_Wox;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wox == null)
    {
      wop localwop = new wop();
      localwop.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localwop.jdField_a_of_type_Boolean = paramBoolean;
      localwop.b = true;
      localwop.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localwop.jdField_a_of_type_Int = paramList.size();
      wfo.a().dispatch(localwop);
      return;
    }
    this.jdField_a_of_type_Wox.a(paramList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Wox = null;
  }
  
  public void a(@NonNull wzt paramwzt, @Nullable xbe paramxbe, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    paramwzt = new StoryVideoItem();
    paramwzt.mVid = this.b;
    paramwzt.mStoryType = 2;
    if ((paramxbe != null) && (paramErrorMessage.isSuccess()))
    {
      paramwzt = paramxbe.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwzt.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramwzt.next();
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
        ((wfy)wpm.a(28)).a(paramxbe.b);
        a(paramxbe.jdField_a_of_type_JavaUtilList, false);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramxbe == null) {}
      for (paramwzt = new ArrayList();; paramwzt = paramxbe.jdField_a_of_type_JavaUtilList)
      {
        a(paramwzt, false);
        return;
      }
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjz
 * JD-Core Version:    0.7.0.1
 */