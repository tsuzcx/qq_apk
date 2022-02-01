import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sol
  implements View.OnClickListener
{
  public sol(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView, sop paramsop, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        if (this.this$0.a != null) {
          break label199;
        }
        if (this.this$0.Bx)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        this.this$0.Bx = true;
        this.oB.setImageResource(2130844066);
        if (CustomMenuBar.isDefaultTheme())
        {
          this.AR.setTextColor(this.this$0.getResources().getColor(2131167449));
          this.this$0.By = false;
          this.this$0.mHandler.removeCallbacks(this.this$0.mRunnable);
          this.a.aO(paramView);
          this.this$0.fc.setVisibility(0);
          this.this$0.a = this.a;
          kbp.a(null, "P_CliOper", "Pb_account_lifeservice", this.val$uin, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.RY), this.val$title, String.valueOf(0), false);
          continue;
        }
        this.AR.setTextColor(this.this$0.getResources().getColor(2131167324));
      }
      finally {}
      continue;
      label199:
      if (this.this$0.a == this.a)
      {
        if (!this.this$0.By)
        {
          if (this.this$0.Bx) {}
          this.this$0.Bx = true;
          this.oB.setImageResource(2130844066);
          if (CustomMenuBar.isDefaultTheme()) {
            this.AR.setTextColor(this.this$0.getResources().getColor(2131167449));
          }
          for (;;)
          {
            this.this$0.By = false;
            this.this$0.mHandler.removeCallbacks(this.this$0.mRunnable);
            this.a.aO(paramView);
            this.this$0.fc.setVisibility(0);
            kbp.a(null, "P_CliOper", "Pb_account_lifeservice", this.val$uin, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.RY), this.val$title, String.valueOf(0), false);
            break;
            this.AR.setTextColor(this.this$0.getResources().getColor(2131167324));
          }
        }
        else
        {
          this.this$0.By = false;
        }
      }
      else {
        if (!this.this$0.Bx) {
          break;
        }
      }
    }
    this.this$0.Bx = true;
    this.oB.setImageResource(2130844066);
    if (CustomMenuBar.isDefaultTheme()) {
      this.AR.setTextColor(this.this$0.getResources().getColor(2131167449));
    }
    for (;;)
    {
      this.this$0.By = false;
      this.this$0.mHandler.removeCallbacks(this.this$0.mRunnable);
      this.a.aO(paramView);
      this.this$0.fc.setVisibility(0);
      this.this$0.a = this.a;
      kbp.a(null, "P_CliOper", "Pb_account_lifeservice", this.val$uin, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.RY), this.val$title, String.valueOf(0), false);
      break;
      this.AR.setTextColor(this.this$0.getResources().getColor(2131167324));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sol
 * JD-Core Version:    0.7.0.1
 */