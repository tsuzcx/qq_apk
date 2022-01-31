import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xmf
  extends uqt
  implements uni<vby, vdj>
{
  String jdField_a_of_type_JavaLangString;
  urc jdField_a_of_type_Urc;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Urc == null)
    {
      uqu localuqu = new uqu();
      localuqu.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localuqu.jdField_a_of_type_Boolean = paramBoolean;
      localuqu.b = true;
      localuqu.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localuqu.jdField_a_of_type_Int = paramList.size();
      uht.a().dispatch(localuqu);
      return;
    }
    this.jdField_a_of_type_Urc.a(paramList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Urc = null;
  }
  
  public void a(@NonNull vby paramvby, @Nullable vdj paramvdj, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    paramvby = new StoryVideoItem();
    paramvby.mVid = this.b;
    paramvby.mStoryType = 2;
    if ((paramvdj != null) && (paramErrorMessage.isSuccess()))
    {
      paramvby = paramvdj.jdField_a_of_type_JavaUtilList.iterator();
      while (paramvby.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramvby.next();
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
        ((uid)urr.a(28)).a(paramvdj.b);
        a(paramvdj.jdField_a_of_type_JavaUtilList, false);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramvdj == null) {}
      for (paramvby = new ArrayList();; paramvby = paramvdj.jdField_a_of_type_JavaUtilList)
      {
        a(paramvby, false);
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
 * Qualified Name:     xmf
 * JD-Core Version:    0.7.0.1
 */