import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;

public class amyf
  extends amzk
{
  public TextView YV;
  public TextView YW;
  public TextView YX;
  public SquareImageView a;
  public ImageView jC;
  public RelativeLayout lV;
  public SquareImageView s;
  
  public amyf(ViewGroup paramViewGroup, int paramInt)
  {
    this.acL = paramInt;
    paramViewGroup.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, null, false), new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setBackgroundResource(2130851241);
    localLinearLayout.setClickable(true);
    localLinearLayout.setFocusable(true);
    this.view = localLinearLayout;
    aDR();
  }
  
  protected void aDR()
  {
    super.aDR();
  }
  
  protected void hE(View paramView)
  {
    this.lV = ((RelativeLayout)paramView.findViewById(2131377440));
    if (this.lV == null) {
      this.lV = ((RelativeLayout)paramView.findViewById(2131368906));
    }
    this.a = ((SquareImageView)paramView.findViewById(2131369792));
    this.jC = ((ImageView)paramView.findViewById(2131369717));
    this.YV = ((TextView)paramView.findViewById(2131380958));
    this.YW = ((TextView)paramView.findViewById(2131380901));
    this.s = ((SquareImageView)paramView.findViewById(2131377288));
    this.YX = ((TextView)paramView.findViewById(2131377289));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.YW.setTextColor(this.YW.getContext().getResources().getColor(2131167231));
      this.YX.setTextColor(this.YX.getContext().getResources().getColor(2131167231));
      return;
    }
    this.YW.setTextColor(this.YW.getContext().getResources().getColor(2131167654));
    this.YX.setTextColor(this.YX.getContext().getResources().getColor(2131167654));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyf
 * JD-Core Version:    0.7.0.1
 */