import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.galleryactivity.GalleryPageView.3;
import com.tencent.widget.AdapterView;

public class sya
  extends sxh
{
  sxi c;
  Runnable fadeTask = new GalleryPageView.3(this);
  private boolean firstTimeShowPage = true;
  public AlphaAnimation hideAnimation = new AlphaAnimation(1.0F, 0.0F);
  public int pageBottomMargin = 3;
  AlphaAnimation showAnimation = new AlphaAnimation(0.0F, 1.0F);
  public TextView textView;
  
  public void a(Activity paramActivity, sxi paramsxi, int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramsxi.getRootView();
    this.textView = new TextView(paramActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, this.pageBottomMargin, paramActivity.getResources().getDisplayMetrics()) + paramInt);
    this.textView.setTextColor(Color.parseColor("#e6e9e9e9"));
    this.textView.setTextSize(2, 15.0F);
    this.textView.setId(2131367841);
    localRelativeLayout.addView(this.textView, localLayoutParams);
    this.textView.setVisibility(4);
    this.showAnimation.setDuration(300L);
    this.hideAnimation.setDuration(300L);
    this.c = paramsxi;
    this.showAnimation.setAnimationListener(new syb(this));
    this.hideAnimation.setAnimationListener(new syc(this));
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
  {
    if (paramAdapterView.getCount() > 1)
    {
      this.textView.setText(paramInt + 1 + "/" + paramAdapterView.getCount());
      if (this.textView.getVisibility() == 4)
      {
        this.textView.setVisibility(0);
        this.textView.startAnimation(this.showAnimation);
        if (this.firstTimeShowPage)
        {
          this.textView.postDelayed(this.fadeTask, 3000L);
          this.firstTimeShowPage = false;
          return;
        }
        this.textView.postDelayed(this.fadeTask, 2000L);
        return;
      }
      this.textView.removeCallbacks(this.fadeTask);
      this.textView.clearAnimation();
      this.textView.postDelayed(this.fadeTask, 2000L);
      return;
    }
    this.textView.setVisibility(4);
  }
  
  public void setVisibility(int paramInt)
  {
    this.textView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sya
 * JD-Core Version:    0.7.0.1
 */