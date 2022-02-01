import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aicm
  implements View.OnClickListener
{
  private TextView TZ;
  private TextView Ua;
  private TextView Ub;
  private TextView Uc;
  private TextView Ud;
  private TextView Ue;
  private ProgressBar ai;
  private Button gp;
  private LinearLayout jh;
  private LinearLayout ji;
  private Activity mActivity;
  
  public static String formatSize(long paramLong)
  {
    if (paramLong > 107374182.40000001D) {
      return String.format("%.1f G", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) });
    }
    if (paramLong > 104857.60000000001D) {
      return String.format("%.1f M", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) });
    }
    return String.format("%.1f K", new Object[] { Float.valueOf((float)paramLong / 1024.0F) });
  }
  
  public void aj(int paramInt, long paramLong)
  {
    this.ji.setVisibility(0);
    this.gp.setVisibility(8);
    if (paramLong == 0L) {
      this.Ud.setVisibility(4);
    }
    for (;;)
    {
      this.ai.setProgress(paramInt);
      return;
      this.Ud.setText(String.format("%1$s/%2$s", new Object[] { formatSize(paramInt * paramLong / 100L), formatSize(paramLong) }));
    }
  }
  
  public void c(Activity paramActivity, View paramView)
  {
    this.jh = ((LinearLayout)paramView.findViewById(2131368292));
    this.TZ = ((TextView)paramView.findViewById(2131368299));
    this.Ua = ((TextView)paramView.findViewById(2131368300));
    this.Ub = ((TextView)paramView.findViewById(2131368293));
    this.Uc = ((TextView)paramView.findViewById(2131368298));
    this.ji = ((LinearLayout)paramView.findViewById(2131368294));
    this.Ud = ((TextView)paramView.findViewById(2131368295));
    this.ai = ((ProgressBar)paramView.findViewById(2131368296));
    this.gp = ((Button)paramView.findViewById(2131368297));
    this.Ue = ((TextView)paramView.findViewById(2131368291));
    this.mActivity = paramActivity;
    this.jh.setOnClickListener(this);
    this.TZ.setOnClickListener(this);
  }
  
  public void drY()
  {
    this.jh.setVisibility(0);
    this.TZ.setVisibility(8);
  }
  
  public void drZ()
  {
    this.gp.setVisibility(8);
  }
  
  public void gn(String paramString1, String paramString2)
  {
    this.Ub.setText(paramString1);
    this.Uc.setText(paramString2);
  }
  
  public void h(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.ji.setVisibility(8);
    this.gp.setVisibility(0);
    this.gp.setText(paramString);
    this.gp.setOnClickListener(paramOnClickListener);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jh) || (paramView == this.TZ)) {
      this.mActivity.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showLeftText()
  {
    this.jh.setVisibility(8);
    this.TZ.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicm
 * JD-Core Version:    0.7.0.1
 */