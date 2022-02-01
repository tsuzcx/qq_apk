import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class znu
  extends wsj
  implements woy<xdo, xez>
{
  String jdField_a_of_type_JavaLangString;
  wss jdField_a_of_type_Wss;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wss == null)
    {
      wsk localwsk = new wsk();
      localwsk.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localwsk.jdField_a_of_type_Boolean = paramBoolean;
      localwsk.b = true;
      localwsk.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localwsk.jdField_a_of_type_Int = paramList.size();
      wjj.a().dispatch(localwsk);
      return;
    }
    this.jdField_a_of_type_Wss.a(paramList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Wss = null;
  }
  
  public void a(@NonNull xdo paramxdo, @Nullable xez paramxez, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    paramxdo = new StoryVideoItem();
    paramxdo.mVid = this.b;
    paramxdo.mStoryType = 2;
    if ((paramxez != null) && (paramErrorMessage.isSuccess()))
    {
      paramxdo = paramxez.jdField_a_of_type_JavaUtilList.iterator();
      while (paramxdo.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramxdo.next();
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
        ((wjt)wth.a(28)).a(paramxez.b);
        a(paramxez.jdField_a_of_type_JavaUtilList, false);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramxez == null) {}
      for (paramxdo = new ArrayList();; paramxdo = paramxez.jdField_a_of_type_JavaUtilList)
      {
        a(paramxdo, false);
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
 * Qualified Name:     znu
 * JD-Core Version:    0.7.0.1
 */