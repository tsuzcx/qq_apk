import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;

public class appq
  implements AbsListView.e
{
  int dVm = 0;
  
  public appq(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  private int a(AbsListView paramAbsListView)
  {
    int i = 0;
    View localView = paramAbsListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int j = paramAbsListView.getFirstVisiblePosition();
    int k = localView.getTop();
    if (j >= 1) {
      i = paramAbsListView.getHeight();
    }
    k = -k;
    return i + (localView.getHeight() * j + k);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((VisitorTroopCardFragment.a(this.this$0) == null) || (VisitorTroopCardFragment.a(this.this$0).gF().size() == 0)) {
      return;
    }
    paramInt1 = a(paramAbsListView);
    VisitorTroopCardFragment localVisitorTroopCardFragment = null;
    if ((paramInt1 > this.dVm) && (paramInt1 >= this.this$0.bGV) && (this.this$0.e.getVisibility() != 0))
    {
      paramAbsListView = this.this$0.A;
      if ((paramAbsListView != null) && (paramAbsListView != this.this$0.gt.getAnimation()))
      {
        paramAbsListView.reset();
        this.this$0.gt.startAnimation(paramAbsListView);
        this.this$0.e.startAnimation(paramAbsListView);
        localVisitorTroopCardFragment = this.this$0;
        if (paramAbsListView != this.this$0.A) {
          break label215;
        }
      }
    }
    label215:
    for (boolean bool = true;; bool = false)
    {
      VisitorTroopCardFragment.a(localVisitorTroopCardFragment, bool);
      VisitorTroopCardFragment.a(this.this$0);
      this.dVm = paramInt1;
      return;
      paramAbsListView = localVisitorTroopCardFragment;
      if (paramInt1 >= this.dVm) {
        break;
      }
      paramAbsListView = localVisitorTroopCardFragment;
      if (paramInt1 > this.this$0.bGV) {
        break;
      }
      paramAbsListView = localVisitorTroopCardFragment;
      if (this.this$0.e.getVisibility() != 0) {
        break;
      }
      paramAbsListView = this.this$0.B;
      break;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (VisitorTroopCardFragment.a(this.this$0) != null) && (VisitorTroopCardFragment.a(this.this$0).bpf)) {
      VisitorTroopCardFragment.a(this.this$0, paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appq
 * JD-Core Version:    0.7.0.1
 */