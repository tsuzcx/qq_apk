import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.3;

public class nmr
{
  private static AnimationSet a(View paramView, Context paramContext)
  {
    paramView = new TranslateAnimation(0.0F, -(paramView.getX() - aqnm.dpToPx(40.0F)), 0.0F, 0.0F);
    paramView.setFillAfter(true);
    paramView.setDuration(200L);
    paramContext = (AlphaAnimation)AnimationUtils.loadAnimation(paramContext, 2130772255);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(paramContext);
    localAnimationSet.addAnimation(paramView);
    localAnimationSet.setFillAfter(true);
    return localAnimationSet;
  }
  
  public static void aS(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    TextView localTextView1 = (TextView)paramActivity.findViewById(2131369579);
    TextView localTextView2 = (TextView)paramActivity.findViewById(2131369585);
    ImageView localImageView = (ImageView)paramActivity.findViewById(2131369584);
    new Handler().postDelayed(new FastWebAnimationUtils.1(paramActivity, localTextView1), 500L);
    new Handler().postDelayed(new FastWebAnimationUtils.2(localTextView2, paramActivity), 2500L);
    new Handler().postDelayed(new FastWebAnimationUtils.3(paramActivity, localTextView2, localImageView), 4200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmr
 * JD-Core Version:    0.7.0.1
 */