import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class amxq
  implements amxx
{
  private List<amxy> Go;
  private TextView YP;
  private amxy a;
  private LinearLayout kp;
  private TextView titleView;
  protected View view;
  
  public amxq() {}
  
  public amxq(ViewGroup paramViewGroup, int paramInt)
  {
    this.view = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.YP = ((TextView)this.view.findViewById(2131371927));
    this.Go = new ArrayList();
    this.kp = ((LinearLayout)this.view.findViewById(2131370619));
    this.a = new amxs(this.view.findViewById(2131369402));
  }
  
  public TextView R()
  {
    return this.YP;
  }
  
  public amxy a()
  {
    return this.a;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxq
 * JD-Core Version:    0.7.0.1
 */