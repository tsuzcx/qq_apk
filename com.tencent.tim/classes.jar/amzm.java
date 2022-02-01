import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class amzm
  extends amxs
{
  private View Hf;
  public Button er;
  
  public amzm(ViewGroup paramViewGroup, int paramInt)
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
  
  protected void aDR()
  {
    this.titleView = ((TextView)this.view.findViewById(2131372384));
    this.imageView = ((ImageView)this.view.findViewById(2131361802));
    this.tD = ((TextView)this.view.findViewById(2131377214));
    this.er = ((Button)this.view.findViewById(2131377201));
    this.er.setText(acfp.m(2131721053));
    this.Zu = ((TextView)this.view.findViewById(2131378586));
    this.Bj = ((TextView)this.view.findViewById(2131377211));
    this.Hf = this.view.findViewById(2131380904);
  }
  
  public Button d()
  {
    return this.er;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzm
 * JD-Core Version:    0.7.0.1
 */