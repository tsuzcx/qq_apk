import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class amxs
  extends amzk
{
  private View Hf;
  private TextView IY;
  
  public amxs(View paramView)
  {
    super(paramView);
  }
  
  public amxs(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void PA(boolean paramBoolean)
  {
    View localView;
    if (this.Hf != null)
    {
      localView = this.Hf;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public TextView S()
  {
    return this.IY;
  }
  
  protected void aDR()
  {
    super.aDR();
    this.IY = ((TextView)this.view.findViewById(2131378456));
    this.Hf = this.view.findViewById(2131380904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxs
 * JD-Core Version:    0.7.0.1
 */