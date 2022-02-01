import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class amzh
  extends amzj
{
  private View Ho;
  private TextView YP;
  private TextView titleView;
  
  public amzh(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.view = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559419, paramViewGroup, false);
    this.view.setOnTouchListener(new amzi(this));
    this.titleView = ((TextView)this.view.findViewById(2131379769));
    this.titleView.setVisibility(0);
    this.YP = ((TextView)this.view.findViewById(2131371927));
    if (paramBoolean2) {
      this.YP.setVisibility(0);
    }
    this.Ho = this.view.findViewById(2131366004);
    if (paramBoolean1) {
      this.Ho.setVisibility(0);
    }
  }
  
  public void PB(boolean paramBoolean)
  {
    View localView = this.Ho;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public TextView R()
  {
    return this.YP;
  }
  
  public TextView getTitleView()
  {
    return this.titleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzh
 * JD-Core Version:    0.7.0.1
 */