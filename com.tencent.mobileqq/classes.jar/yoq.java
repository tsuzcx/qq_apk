import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class yoq
  extends vtz
  implements vqp<wfe, wgp>
{
  String jdField_a_of_type_JavaLangString;
  vui jdField_a_of_type_Vui;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vui == null)
    {
      vua localvua = new vua();
      localvua.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localvua.jdField_a_of_type_Boolean = paramBoolean;
      localvua.b = true;
      localvua.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localvua.jdField_a_of_type_Int = paramList.size();
      vli.a().dispatch(localvua);
      return;
    }
    this.jdField_a_of_type_Vui.a(paramList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Vui = null;
  }
  
  public void a(@NonNull wfe paramwfe, @Nullable wgp paramwgp, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    paramwfe = new StoryVideoItem();
    paramwfe.mVid = this.b;
    paramwfe.mStoryType = 2;
    if ((paramwgp != null) && (paramErrorMessage.isSuccess()))
    {
      paramwfe = paramwgp.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwfe.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramwfe.next();
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
        ((vls)vux.a(28)).a(paramwgp.b);
        a(paramwgp.jdField_a_of_type_JavaUtilList, false);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramwgp == null) {}
      for (paramwfe = new ArrayList();; paramwfe = paramwgp.jdField_a_of_type_JavaUtilList)
      {
        a(paramwfe, false);
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
 * Qualified Name:     yoq
 * JD-Core Version:    0.7.0.1
 */