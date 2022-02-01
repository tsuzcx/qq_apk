import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.SquareImageView;

public class amyi
  extends amyf
{
  public ImageView Dv;
  public ImageView Dw;
  public TextView YU;
  public TextView Zc;
  public TextView Zd;
  public URLImageView bH;
  public URLImageView bI;
  public FrameLayout bV;
  public int childCount;
  public TextView fW;
  public ImageView iconView;
  public LinearLayout kq;
  public LinearLayout ku;
  public RelativeLayout lW;
  public SquareImageView r;
  
  public amyi(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void aDR()
  {
    super.aDR();
    View localView = P(this.acL);
    this.Dv = ((ImageView)localView.findViewById(2131365490));
    this.iconView = ((ImageView)localView.findViewById(2131368698));
    this.YU = ((TextView)localView.findViewById(2131379233));
    this.kq = ((LinearLayout)localView.findViewById(2131373270));
    this.bV = ((FrameLayout)localView.findViewById(2131378448));
    this.r = ((SquareImageView)this.bV.findViewById(2131368923));
    this.Dw = ((ImageView)this.bV.findViewById(2131370134));
    this.childCount = this.kq.getChildCount();
    this.ku = ((LinearLayout)localView.findViewById(2131366164));
    this.lW = ((RelativeLayout)localView.findViewById(2131366176));
    this.Zc = ((TextView)localView.findViewById(2131376662));
    this.bH = ((URLImageView)localView.findViewById(2131382429));
    this.Zd = ((TextView)localView.findViewById(2131382431));
    this.bI = ((URLImageView)localView.findViewById(2131365015));
    this.fW = ((TextView)localView.findViewById(2131365047));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyi
 * JD-Core Version:    0.7.0.1
 */