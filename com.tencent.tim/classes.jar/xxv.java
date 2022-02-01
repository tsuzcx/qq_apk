import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.CircleGuideView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class xxv
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  xxv(xxt paramxxt, View paramView1, View paramView2) {}
  
  public void onGlobalLayout()
  {
    int j;
    Object localObject1;
    Object localObject2;
    aegp localaegp;
    if ((this.xl != null) && (this.xl.getParent() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.TAG, 2, "show holmes guide!");
      }
      j = ImmersiveUtils.getStatusBarHeight(this.this$0.mContext);
      if (this.this$0.sessionInfo.cZ != 1034) {
        break label430;
      }
      localObject1 = (CircleGuideView)this.xl.findViewById(2131364614);
      float f1 = this.xm.getX();
      float f2 = this.xm.getWidth() / 2;
      float f3 = j;
      float f4 = this.xm.getY();
      float f5 = this.xm.getHeight() / 2;
      i = 24;
      if (Build.VERSION.SDK_INT <= 18) {
        i = 20;
      }
      ((CircleGuideView)localObject1).setCircle(f2 + f1, f5 + (f3 + f4), wja.dp2px(i, xxt.a(this.this$0).getResources()));
      localObject1 = this.this$0.mContext.getResources().getString(2131691969);
      this.xl.findViewById(2131368562).setPadding(0, j, 0, 0);
      localObject2 = (ImageView)this.xl.findViewById(2131368565);
      localaegp = ((aegs)this.this$0.app.getManager(269)).b();
      if (localaegp != null) {
        break label527;
      }
    }
    label527:
    for (int i = 5;; i = localaegp.cML)
    {
      ((ImageView)localObject2).setImageResource(xxt.a(this.this$0, i));
      ((ImageView)this.xl.findViewById(2131368564)).setContentDescription(String.format((String)localObject1, new Object[] { Integer.valueOf(i) }));
      this.this$0.g = new PopupWindow(this.this$0.mContext);
      this.this$0.g.setWindowLayoutMode(-1, -1);
      this.this$0.g.setFocusable(true);
      this.this$0.g.setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.g.setContentView(this.xl);
      this.this$0.g.setClippingEnabled(false);
      this.this$0.g.showAtLocation(new View(this.this$0.mContext), 0, 0, 0);
      if (Build.VERSION.SDK_INT >= 16) {
        this.this$0.cL.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      return;
      label430:
      localObject1 = this.xl.findViewById(2131373662);
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = (this.xm.getLeft() + xxt.a(this.this$0).getLeft());
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (this.xm.getTop() + j + xxt.a(this.this$0).getTop());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.this$0.mContext.getResources().getString(2131691968);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxv
 * JD-Core Version:    0.7.0.1
 */