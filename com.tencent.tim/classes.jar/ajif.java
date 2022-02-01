import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.widget.ListView;

public class ajif
  implements View.OnLayoutChangeListener
{
  public ajif(MultiAIOItemFragment paramMultiAIOItemFragment, ListView paramListView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((this.c.getWidth() > 0) && (this.c.getHeight() > 0))
    {
      this.c.removeOnLayoutChangeListener(this);
      MultiAIOItemFragment.a(this.this$0, this.c.getWidth(), this.c.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajif
 * JD-Core Version:    0.7.0.1
 */