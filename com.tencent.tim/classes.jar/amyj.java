import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.d;

public class amyj
  extends amyf
  implements HorizontalListView.d
{
  public amqk a;
  public HorizontalListView w;
  
  public amyj(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.w = ((HorizontalListView)((LinearLayout)P(paramInt)).findViewById(2131377855));
    this.w.setOnScrollStateChangedListener(this);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097) {
      this.a.dDy = this.w.getCurrentX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyj
 * JD-Core Version:    0.7.0.1
 */