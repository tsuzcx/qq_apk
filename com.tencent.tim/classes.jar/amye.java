import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class amye
  extends amyf
{
  public TextView Bj;
  public TextView YJ;
  public TextView YU;
  public ImageView iconView;
  public RelativeLayout lU;
  public ImageView leftImageView;
  public TextView titleView;
  
  public amye(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void aDR()
  {
    super.aDR();
    View localView = P(this.acL);
    this.titleView = ((TextView)localView.findViewById(2131379769));
    this.lU = ((RelativeLayout)localView.findViewById(2131370367));
    this.leftImageView = ((ImageView)localView.findViewById(2131368846));
    this.iconView = ((ImageView)localView.findViewById(2131365490));
    this.YU = ((TextView)localView.findViewById(2131379233));
    this.YJ = ((TextView)localView.findViewById(2131379012));
    this.Bj = ((TextView)localView.findViewById(2131365748));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      if (this.YJ != null) {
        this.YJ.setTextColor(this.YJ.getContext().getResources().getColor(2131167230));
      }
      if (this.Bj != null) {
        this.Bj.setTextColor(this.Bj.getContext().getResources().getColor(2131167230));
      }
    }
    do
    {
      return;
      if (this.YJ != null) {
        this.YJ.setTextColor(Color.parseColor("#737373"));
      }
    } while (this.Bj == null);
    this.Bj.setTextColor(Color.parseColor("#737373"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amye
 * JD-Core Version:    0.7.0.1
 */