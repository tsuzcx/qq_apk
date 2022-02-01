import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView.f;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class vdj
  implements DragSortListView.f
{
  public vdj(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void drop(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int j = this.a.oW.size();
    this.a.cb = new byte[j];
    this.a.cc = new byte[j];
    int i = 0;
    while (i < j)
    {
      this.a.cb[i] = ((byte)((Groups)this.a.oW.get(i)).group_id);
      i += 1;
    }
    if (paramInt2 < paramInt1)
    {
      i = j - 1;
      if (i >= 0)
      {
        if ((paramInt2 < i) && (i <= paramInt1)) {
          this.a.cc[i] = this.a.cb[(i - 1)];
        }
        for (;;)
        {
          i -= 1;
          break;
          if (i == paramInt2) {
            this.a.cc[i] = this.a.cb[paramInt1];
          } else {
            this.a.cc[i] = this.a.cb[i];
          }
        }
      }
    }
    else if (paramInt1 < paramInt2)
    {
      i = 0;
      if (i < j)
      {
        if ((i < paramInt1) || (paramInt2 < i)) {
          this.a.cc[i] = this.a.cb[i];
        }
        for (;;)
        {
          i += 1;
          break;
          if (i == paramInt2) {
            this.a.cc[i] = this.a.cb[paramInt1];
          } else {
            this.a.cc[i] = this.a.cb[(i + 1)];
          }
        }
      }
    }
    i = 0;
    while (i < j)
    {
      this.a.cb[i] = ((byte)i);
      i += 1;
    }
    Groups localGroups;
    if (paramInt2 < paramInt1)
    {
      localGroups = (Groups)this.a.oW.remove(paramInt1);
      this.a.oW.add(paramInt2, localGroups);
      GroupManagerActivity.a(this.a).notifyDataSetChanged();
      if (QLog.isColorLevel())
      {
        QLog.d("GroupManagerActivity", 2, "DragSortListView.DropListener onDrop groupIdList = " + Arrays.toString(this.a.cc));
        QLog.d("GroupManagerActivity", 2, "DragSortListView.DropListener onDrop sortIdList = " + Arrays.toString(this.a.cb));
      }
      GroupManagerActivity.a(this.a, this.a.b(this.a.cc, this.a.cb));
      if (QLog.isColorLevel()) {
        QLog.d("GroupManagerActivity", 2, "SortFriendGroup needShowDialog = " + GroupManagerActivity.a(this.a));
      }
      if (!GroupManagerActivity.a(this.a)) {
        break label586;
      }
      this.a.Ba(2131694551);
    }
    for (;;)
    {
      anot.a(this.a.app, "CliOper", "", "", "category", "Move_category", 0, 0, "", "", "", "");
      return;
      if (paramInt1 >= paramInt2) {
        break;
      }
      localGroups = (Groups)this.a.oW.remove(paramInt1);
      this.a.oW.add(paramInt2, localGroups);
      break;
      label586:
      this.a.refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdj
 * JD-Core Version:    0.7.0.1
 */