import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;

public class tip
  implements View.OnSystemUiVisibilityChangeListener
{
  public tip(GdtMotiveVideoFragment paramGdtMotiveVideoFragment, View paramView) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.val$decorView.setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tip
 * JD-Core Version:    0.7.0.1
 */