import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zdj
  extends wiu
  implements wfk<wtz, wvk>
{
  String jdField_a_of_type_JavaLangString;
  wjd jdField_a_of_type_Wjd;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wjd == null)
    {
      wiv localwiv = new wiv();
      localwiv.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localwiv.jdField_a_of_type_Boolean = paramBoolean;
      localwiv.b = true;
      localwiv.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localwiv.jdField_a_of_type_Int = paramList.size();
      wad.a().dispatch(localwiv);
      return;
    }
    this.jdField_a_of_type_Wjd.a(paramList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Wjd = null;
  }
  
  public void a(@NonNull wtz paramwtz, @Nullable wvk paramwvk, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    paramwtz = new StoryVideoItem();
    paramwtz.mVid = this.b;
    paramwtz.mStoryType = 2;
    if ((paramwvk != null) && (paramErrorMessage.isSuccess()))
    {
      paramwtz = paramwvk.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwtz.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramwtz.next();
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
        ((wan)wjs.a(28)).a(paramwvk.b);
        a(paramwvk.jdField_a_of_type_JavaUtilList, false);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramwvk == null) {}
      for (paramwtz = new ArrayList();; paramwtz = paramwvk.jdField_a_of_type_JavaUtilList)
      {
        a(paramwtz, false);
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
 * Qualified Name:     zdj
 * JD-Core Version:    0.7.0.1
 */