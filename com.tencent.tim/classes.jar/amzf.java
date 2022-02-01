import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class amzf
  extends amzj
{
  public ImageView DE;
  public View Hn;
  public TextView Zr;
  public TextView Zs;
  public LinearLayout kp;
  
  public amzf() {}
  
  public amzf(ViewGroup paramViewGroup)
  {
    this.view = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563027, paramViewGroup, false);
    this.Hn = this.view.findViewById(2131371948);
    this.Zr = ((TextView)this.Hn.findViewById(2131370083));
    this.DE = ((ImageView)this.Hn.findViewById(2131368820));
    this.Zs = ((TextView)this.Hn.findViewById(2131365748));
    this.kp = ((LinearLayout)this.view.findViewById(2131370619));
  }
  
  public LinearLayout p()
  {
    return this.kp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzf
 * JD-Core Version:    0.7.0.1
 */