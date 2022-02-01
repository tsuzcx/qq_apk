import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCTipsUtils.2;
import com.tencent.widget.immersive.ImmersiveUtils;

public class mky
{
  public static void aL(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.getWindow() == null)) {}
    do
    {
      return;
      localObject = paramActivity.getWindow().getDecorView();
    } while (!(localObject instanceof FrameLayout));
    Object localObject = (FrameLayout)localObject;
    View localView = paramActivity.getLayoutInflater().inflate(2131560493, (ViewGroup)localObject, false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = wja.dp2px(6.0F, paramActivity.getResources());
    localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(paramActivity) + paramActivity.getResources().getDimensionPixelSize(2131299627) - wja.dp2px(12.0F, paramActivity.getResources()));
    localView.setLayoutParams(localLayoutParams);
    paramActivity = (TextView)localView.findViewById(2131380973);
    if (paramActivity != null) {
      paramActivity.setText(mku.kg());
    }
    ((FrameLayout)localObject).addView(localView);
    localView.setOnClickListener(new mkz(localView));
    kxm.p().postDelayed(new RIJUGCTipsUtils.2(localView), mku.pv() * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mky
 * JD-Core Version:    0.7.0.1
 */