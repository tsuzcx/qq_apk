import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xqo
  extends uvc
  implements urr<vgh, vhs>
{
  String jdField_a_of_type_JavaLangString;
  uvl jdField_a_of_type_Uvl;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uvl == null)
    {
      uvd localuvd = new uvd();
      localuvd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localuvd.jdField_a_of_type_Boolean = paramBoolean;
      localuvd.b = true;
      localuvd.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localuvd.jdField_a_of_type_Int = paramList.size();
      umc.a().dispatch(localuvd);
      return;
    }
    this.jdField_a_of_type_Uvl.a(paramList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Uvl = null;
  }
  
  public void a(@NonNull vgh paramvgh, @Nullable vhs paramvhs, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    paramvgh = new StoryVideoItem();
    paramvgh.mVid = this.b;
    paramvgh.mStoryType = 2;
    if ((paramvhs != null) && (paramErrorMessage.isSuccess()))
    {
      paramvgh = paramvhs.jdField_a_of_type_JavaUtilList.iterator();
      while (paramvgh.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramvgh.next();
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
        ((umm)uwa.a(28)).a(paramvhs.b);
        a(paramvhs.jdField_a_of_type_JavaUtilList, false);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramvhs == null) {}
      for (paramvgh = new ArrayList();; paramvgh = paramvhs.jdField_a_of_type_JavaUtilList)
      {
        a(paramvgh, false);
        return;
      }
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqo
 * JD-Core Version:    0.7.0.1
 */