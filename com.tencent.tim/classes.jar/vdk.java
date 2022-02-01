import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView.j;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class vdk
  implements DragSortListView.j
{
  public vdk(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void remove(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "RemoveListener which = " + paramInt);
    }
    paramInt -= 1;
    byte b;
    if ((paramInt >= 0) && (paramInt < this.a.oW.size()))
    {
      Object localObject = (Groups)this.a.oW.get(paramInt);
      b = (byte)((Groups)localObject).group_id;
      if (QLog.isColorLevel())
      {
        QLog.d("GroupManagerActivity", 2, "RemoveListener remove groupId :" + b);
        QLog.d("GroupManagerActivity", 2, "RemoveListener remove friend_count :" + ((Groups)localObject).group_friend_count);
      }
      if (b == 0)
      {
        localObject = new QQToast(this.a);
        ((QQToast)localObject).setDuration(2000);
        ((QQToast)localObject).setToastMsg(2131721199);
        ((QQToast)localObject).show();
      }
    }
    else
    {
      return;
    }
    GroupManagerActivity.a(this.a, b);
    anot.a(this.a.app, "CliOper", "", "", "category", "Delete_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdk
 * JD-Core Version:    0.7.0.1
 */