import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.SquareImageView;

public class amyd
  extends amyf
{
  public URLImageView bF;
  public int dDZ;
  public int dEa;
  public LinearLayout kq;
  public LinearLayout kr;
  public LinearLayout ks;
  public LinearLayout kt;
  public SquareImageView r;
  public TextView titleView;
  
  public amyd(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void aDR()
  {
    View localView = P(this.acL);
    this.titleView = ((TextView)localView.findViewById(2131379769));
    this.r = ((SquareImageView)localView.findViewById(2131378446));
    this.kq = ((LinearLayout)localView.findViewById(2131368917));
    this.dDZ = this.kq.getChildCount();
    this.kr = ((LinearLayout)localView.findViewById(2131370368));
    this.dEa = this.kr.getChildCount();
    this.bF = ((URLImageView)this.kr.findViewById(2131368920));
    this.ks = ((LinearLayout)this.kr.findViewById(2131373268));
    this.kt = ((LinearLayout)this.kr.findViewById(2131373269));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyd
 * JD-Core Version:    0.7.0.1
 */