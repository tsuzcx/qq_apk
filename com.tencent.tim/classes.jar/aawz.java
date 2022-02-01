import android.view.View;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedFooterExpandableListView.a;

public class aawz
  implements PinnedFooterExpandableListView.a
{
  public aawz(FriendTabView paramFriendTabView) {}
  
  public void a(PinnedFooterExpandableListView paramPinnedFooterExpandableListView, View paramView, int paramInt)
  {
    if (!this.a.bAG)
    {
      if (paramInt - 1 >= 0) {
        paramPinnedFooterExpandableListView.collapseGroup(paramInt - 1);
      }
      for (;;)
      {
        this.a.bAG = true;
        FriendTabView.a(this.a).setFooterEnable(false);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FriendTabView", 2, "header group unusal: " + paramInt);
        }
      }
    }
    if (paramPinnedFooterExpandableListView.isGroupExpanded(paramInt))
    {
      paramPinnedFooterExpandableListView.collapseGroup(paramInt);
      return;
    }
    paramPinnedFooterExpandableListView.expandGroup(paramInt);
  }
  
  public void czW()
  {
    this.a.bAG = true;
    FriendTabView.a(this.a).setFooterEnable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawz
 * JD-Core Version:    0.7.0.1
 */