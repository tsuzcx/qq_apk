import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class wgq
  implements View.OnTouchListener
{
  public wgq(VisitorsActivity paramVisitorsActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.rF.setAlpha(127);
        this.this$0.He.setAlpha(0.5F);
        this.this$0.rG.setAlpha(127);
        continue;
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.this$0.rF.setAlpha(255);
          this.this$0.He.setAlpha(1.0F);
          this.this$0.rG.setAlpha(255);
        }
        anot.a(this.this$0.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
        paramView = new Intent(this.this$0, LikeRankingListActivity.class);
        this.this$0.startActivity(paramView);
        this.this$0.vV.setVisibility(8);
        this.this$0.vX.clearAnimation();
        this.this$0.mWaveCount = 0;
        this.this$0.mHandler.removeCallbacks(this.this$0.ee);
        continue;
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.this$0.rF.setAlpha(255);
          this.this$0.He.setAlpha(1.0F);
          this.this$0.rG.setAlpha(255);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgq
 * JD-Core Version:    0.7.0.1
 */