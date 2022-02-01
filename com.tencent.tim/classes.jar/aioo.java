import android.view.View;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class aioo
  implements ausj.a
{
  public aioo(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, ListenTogetherManager paramListenTogetherManager) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.b.Lh(false);
      ListenTogetherOverlayFragment.a(this.a).dismiss();
      return;
    }
    ListenTogetherOverlayFragment.a(this.a);
    ListenTogetherOverlayFragment.a(this.a).dismiss();
    ListenTogetherOverlayFragment.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aioo
 * JD-Core Version:    0.7.0.1
 */