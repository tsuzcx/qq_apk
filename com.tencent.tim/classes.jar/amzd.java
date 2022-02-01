import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class amzd
  extends amzf
{
  public LinearLayout kp;
  
  public amzd(ViewGroup paramViewGroup)
  {
    this.view = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563025, paramViewGroup, false);
    this.YP = ((TextView)this.view.findViewById(2131371927));
    this.kp = ((LinearLayout)this.view.findViewById(2131370619));
    this.Go = new ArrayList();
    this.Hn = this.view.findViewById(2131371948);
    this.Zr = ((TextView)this.Hn.findViewById(2131370083));
  }
  
  public LinearLayout p()
  {
    return this.kp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzd
 * JD-Core Version:    0.7.0.1
 */