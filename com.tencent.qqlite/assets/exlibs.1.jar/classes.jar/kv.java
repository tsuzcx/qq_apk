import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;

public class kv
  implements ViewTreeObserver.OnPreDrawListener
{
  public kv(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  public boolean onPreDraw()
  {
    if (BmqqSegmentUtil.b(this.a.getApplicationContext(), this.a.a.mBmqqUin))
    {
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.a(15.0F, this.a.getResources());
      ImageView localImageView = new ImageView(this.a);
      localImageView.setBackgroundResource(2130837661);
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      if (this.a.a.isCertified())
      {
        Object localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(20.0F, this.a.getResources()), AIOUtils.a(20.0F, this.a.getResources()));
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(10.0F, this.a.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131296624);
        localObject1 = new ImageView(this.a);
        ((ImageView)localObject1).setBackgroundResource(2130838357);
        this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject2 = (ImageView)this.a.findViewById(2131296620);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        this.a.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = localDisplayMetrics.widthPixels - ((ImageView)localObject2).getWidth() - AIOUtils.a(60.0F, this.a.getResources()) - ((ImageView)localObject1).getWidth() - localImageView.getWidth();
        if (i > 0) {
          this.a.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i);
        }
      }
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new kw(this));
    }
    this.a.c.getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kv
 * JD-Core Version:    0.7.0.1
 */