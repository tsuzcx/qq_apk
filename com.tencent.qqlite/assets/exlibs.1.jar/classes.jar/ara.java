import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ara
  implements DragSortListView.RemoveListener
{
  public ara(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GroupManagerActivity.jdField_a_of_type_JavaLangString, 2, "RemoveListener which = " + paramInt);
    }
    Object localObject = (Groups)this.a.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    byte b = (byte)((Groups)localObject).group_id;
    if (QLog.isColorLevel())
    {
      QLog.d(GroupManagerActivity.jdField_a_of_type_JavaLangString, 2, "RemoveListener remove groupId :" + b);
      QLog.d(GroupManagerActivity.jdField_a_of_type_JavaLangString, 2, "RemoveListener remove friend_count :" + ((Groups)localObject).group_friend_count);
    }
    if (b == 0)
    {
      localObject = new QQToast(this.a);
      ((QQToast)localObject).c(2000);
      ((QQToast)localObject).b(2131364183);
      ((QQToast)localObject).a();
      return;
    }
    GroupManagerActivity.a(this.a, b);
    ReportController.b(this.a.app, "CliOper", "", "", "category", "Delete_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ara
 * JD-Core Version:    0.7.0.1
 */