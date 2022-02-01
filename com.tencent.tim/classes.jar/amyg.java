import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;

public class amyg
  extends amyf
{
  public TextView YY;
  public TextView YZ;
  public TextView Za;
  public TextView Zb;
  public URLImageView bG;
  public RelativeLayout ff;
  
  public amyg(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void aDR()
  {
    super.aDR();
    View localView = P(this.acL);
    this.ff = ((RelativeLayout)localView.findViewById(2131370144));
    this.bG = ((URLImageView)localView.findViewById(2131363422));
    this.YY = ((TextView)localView.findViewById(2131368698));
    this.YZ = ((TextView)localView.findViewById(2131367124));
    this.Za = ((TextView)localView.findViewById(2131377895));
    this.Zb = ((TextView)localView.findViewById(2131362048));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyg
 * JD-Core Version:    0.7.0.1
 */