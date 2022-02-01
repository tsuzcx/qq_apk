import android.view.View;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;

public class akih
  implements AbsListView.e
{
  public akih(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int i = 0;
    if (paramInt == 0)
    {
      paramInt = i;
      if (NearbyMomentFragment.a(this.this$0).getLastVisiblePosition() == NearbyMomentFragment.a(this.this$0).getCount() - 1)
      {
        paramAbsListView = NearbyMomentFragment.a(this.this$0).getChildAt(NearbyMomentFragment.a(this.this$0).getLastVisiblePosition() - NearbyMomentFragment.a(this.this$0).getFirstVisiblePosition());
        paramInt = i;
        if (NearbyMomentFragment.a(this.this$0).getHeight() >= paramAbsListView.getBottom()) {
          paramInt = 1;
        }
      }
      if (paramInt != 0) {
        NearbyMomentFragment.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akih
 * JD-Core Version:    0.7.0.1
 */