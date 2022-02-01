import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class amzj
  implements amxx
{
  protected List<amxy> Go;
  protected TextView YP;
  private TextView titleView;
  protected View view;
  
  public amzj() {}
  
  public amzj(ViewGroup paramViewGroup, int paramInt)
  {
    this.view = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.YP = ((TextView)this.view.findViewById(2131371927));
    this.Go = new ArrayList();
    this.Go.add(new amzk(this.view.findViewById(2131369382)));
    this.Go.add(new amzk(this.view.findViewById(2131369388)));
    this.Go.add(new amzk(this.view.findViewById(2131369394)));
    if ((paramInt == 2131559838) || (paramInt == 2131563022))
    {
      this.Go.add(new amzk(this.view.findViewById(2131369400)));
      this.Go.add(new amzk(this.view.findViewById(2131369401)));
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
  
  public View getView()
  {
    return this.view;
  }
  
  public List<amxy> gh()
  {
    return this.Go;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzj
 * JD-Core Version:    0.7.0.1
 */