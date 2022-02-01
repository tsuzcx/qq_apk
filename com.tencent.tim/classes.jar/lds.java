import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.b;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

public class lds
  implements ViewTreeObserver.OnPreDrawListener
{
  public lds(ReadInJoyChannelPanelFragment.b paramb) {}
  
  public boolean onPreDraw()
  {
    View localView = ReadInJoyChannelPanelFragment.a(this.a.this$0).getChildAt(ReadInJoyChannelPanelFragment.a(this.a.this$0).getChildCount() - 1);
    Object localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject = this.a.this$0.a(ReadInJoyChannelPanelFragment.b.a(this.a), (int[])localObject);
    ReadInJoyChannelPanelFragment.a(localObject[0], 0.0F, localObject[1], 0.0F, localView);
    ReadInJoyChannelPanelFragment.a(this.a.this$0).getViewTreeObserver().removeOnPreDrawListener(ReadInJoyChannelPanelFragment.b.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lds
 * JD-Core Version:    0.7.0.1
 */