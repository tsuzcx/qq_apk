import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import java.util.List;

public class akik
  implements akio.b
{
  public akik(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void c(boolean paramBoolean1, List<akjj> paramList, boolean paramBoolean2, int paramInt)
  {
    NearbyMomentFragment.a(this.this$0, false);
    if (paramBoolean1)
    {
      NearbyMomentFragment.b(this.this$0, paramBoolean2);
      if (paramBoolean2) {
        NearbyMomentFragment.a(this.this$0).setText(acfp.m(2131708766));
      }
      NearbyMomentFragment.a(this.this$0, paramInt);
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = NearbyMomentFragment.a(this.this$0, paramList);
        NearbyMomentFragment.a(this.this$0).addAll(paramList);
        NearbyMomentFragment.a(this.this$0).ca(paramList);
        NearbyMomentFragment.a(this.this$0, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akik
 * JD-Core Version:    0.7.0.1
 */