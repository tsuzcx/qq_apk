import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager;

class afmp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  afmp(afmn paramafmn, ImageView paramImageView) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.this$0.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      if (this.this$0.a.a.getMeasuredHeight() != 0)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.yO.getLayoutParams();
        localLayoutParams.height = ((int)(this.this$0.a.a.getMeasuredHeight() * 0.6F));
        localLayoutParams.width = ((int)(localLayoutParams.height * 1.3F));
        localLayoutParams.topMargin = ((int)(this.this$0.a.a.getMeasuredHeight() * 0.08F));
        this.yO.setLayoutParams(localLayoutParams);
      }
      return;
      this.this$0.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmp
 * JD-Core Version:    0.7.0.1
 */