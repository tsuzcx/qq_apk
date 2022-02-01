import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.SquareImageView;

public class amyv
  extends amyf
{
  public ImageView Dz;
  public TextView Zm;
  public TextView Zn;
  public Button he;
  public Button hf;
  public LinearLayout kA;
  public LinearLayout kB;
  public LinearLayout kz;
  public RelativeLayout lY;
  public SquareImageView u;
  
  public amyv(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void aDR()
  {
    super.aDR();
    View localView = P(this.acL);
    hE(localView);
    this.lY = ((RelativeLayout)localView.findViewById(2131377470));
    this.he = ((Button)localView.findViewById(2131363974));
    this.Dz = ((ImageView)localView.findViewById(2131369884));
    this.kz = ((LinearLayout)localView.findViewById(2131370642));
    this.kA = ((LinearLayout)localView.findViewById(2131370643));
    this.Zm = ((TextView)localView.findViewById(2131380593));
    this.Zn = ((TextView)localView.findViewById(2131380592));
    this.u = ((SquareImageView)localView.findViewById(2131369692));
    this.kB = ((LinearLayout)localView.findViewById(2131370641));
    this.hf = ((Button)localView.findViewById(2131363802));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyv
 * JD-Core Version:    0.7.0.1
 */