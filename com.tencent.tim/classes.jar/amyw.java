import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;

public class amyw
  extends amyf
{
  public ImageView Dv;
  public ImageView Dw;
  public TextView YU;
  public FrameLayout bV;
  public int childCount;
  public ImageView iconView;
  public LinearLayout kq;
  public SquareImageView r;
  
  public amyw(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void aDR()
  {
    super.aDR();
    Object localObject = P(this.acL);
    this.Dv = ((ImageView)((View)localObject).findViewById(2131365490));
    this.iconView = ((ImageView)((View)localObject).findViewById(2131368698));
    this.YU = ((TextView)((View)localObject).findViewById(2131379233));
    this.kq = ((LinearLayout)((View)localObject).findViewById(2131373270));
    this.bV = ((FrameLayout)((View)localObject).findViewById(2131378448));
    this.r = ((SquareImageView)this.bV.findViewById(2131368923));
    this.Dw = ((ImageView)this.bV.findViewById(2131370134));
    this.childCount = this.kq.getChildCount();
    localObject = getTitleView();
    TextView localTextView1 = z();
    TextView localTextView2 = N();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      if (localObject != null) {
        ((TextView)localObject).setTextColor(((View)localObject).getContext().getResources().getColor(2131167231));
      }
      if (localTextView1 != null) {
        ((TextView)localTextView1).setTextColor(localTextView1.getContext().getResources().getColor(2131167230));
      }
      if (localTextView2 != null) {
        ((TextView)localTextView2).setTextColor(localTextView2.getContext().getResources().getColor(2131167230));
      }
    }
    do
    {
      return;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#262626"));
      }
      if (localTextView1 != null) {
        ((TextView)localTextView1).setTextColor(Color.parseColor("#737373"));
      }
    } while (localTextView2 == null);
    ((TextView)localTextView2).setTextColor(Color.parseColor("#737373"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyw
 * JD-Core Version:    0.7.0.1
 */