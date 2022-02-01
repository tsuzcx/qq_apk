import android.view.View;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qphone.base.util.QLog;

public class vda
  implements ausj.a
{
  public vda(GroupManagerActivity paramGroupManagerActivity, byte paramByte) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.bPI();
    if (paramInt == 0)
    {
      GroupManagerActivity.a(this.a).setDragEnabled(true);
      GroupManagerActivity.a(this.a, this.a.c(this.aN));
      if (QLog.isColorLevel()) {
        QLog.d("GroupManagerActivity", 2, "DeleteFriendGroup :" + this.aN + ", " + GroupManagerActivity.a(this.a));
      }
      if (!GroupManagerActivity.a(this.a)) {
        break label110;
      }
      this.a.Ba(2131694547);
    }
    label110:
    while (GroupManagerActivity.a(this.a) == null) {
      return;
    }
    GroupManagerActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vda
 * JD-Core Version:    0.7.0.1
 */