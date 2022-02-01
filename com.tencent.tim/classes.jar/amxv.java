import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class amxv
  implements amxx
{
  private List<amxy> Go;
  private TextView YP;
  private ViewGroup ba;
  private LinearLayout kp;
  private TextView titleView;
  protected View view;
  
  public amxv(ViewGroup paramViewGroup)
  {
    this.view = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563026, paramViewGroup, false);
    this.YP = ((TextView)this.view.findViewById(2131371927));
    this.Go = new ArrayList();
    this.kp = ((LinearLayout)this.view.findViewById(2131370619));
    this.ba = paramViewGroup;
  }
  
  public TextView R()
  {
    return this.YP;
  }
  
  public TextView getTitleView()
  {
    return this.titleView;
  }
  
  public View getView()
  {
    return this.view;
  }
  
  public List<amxy> gh()
  {
    return this.Go;
  }
  
  public LinearLayout p()
  {
    return this.kp;
  }
  
  public ViewGroup v()
  {
    return this.ba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxv
 * JD-Core Version:    0.7.0.1
 */