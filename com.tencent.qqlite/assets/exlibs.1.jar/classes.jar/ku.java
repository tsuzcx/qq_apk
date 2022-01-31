import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ku
  implements ViewTreeObserver.OnPreDrawListener
{
  public ku(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  public boolean onPreDraw()
  {
    ImageView localImageView1 = (ImageView)this.a.findViewById(2131296614);
    ImageView localImageView2 = (ImageView)this.a.findViewById(2131296622);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.a.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels - localImageView1.getWidth() - AIOUtils.a(50.0F, this.a.getResources()) - localImageView2.getWidth();
    if (i > 0) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i);
    }
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ku
 * JD-Core Version:    0.7.0.1
 */