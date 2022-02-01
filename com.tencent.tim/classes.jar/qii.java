import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;

public class qii
{
  public static void a(ViewGroup paramViewGroup, @NonNull AnimationParam paramAnimationParam, Animator.AnimatorListener paramAnimatorListener)
  {
    ram.d("Q.qqstory.playernew.AnimationUtils", "doExitAnimation");
    View localView = paramViewGroup.findViewById(2131377546);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(2131362719);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131381900);
    Drawable localDrawable = paramAnimationParam.getAnimationDrawable();
    ImageView localImageView1 = null;
    if (localDrawable != null)
    {
      localImageView1 = new ImageView(paramViewGroup.getContext());
      localViewGroup.addView(localImageView1, new RelativeLayout.LayoutParams(-1, -1));
      localImageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localImageView1.setImageDrawable(localDrawable);
    }
    int i = localView.getMeasuredWidth();
    int j = localView.getMeasuredHeight();
    float f1 = paramAnimationParam.viewWidth * 1.0F / i;
    float f2 = paramAnimationParam.viewHeight * 1.0F / j;
    paramViewGroup = new ValueAnimator();
    paramViewGroup.setInterpolator(new DecelerateInterpolator());
    paramViewGroup.setDuration(250L);
    paramViewGroup.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, f1 }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, f2 }), PropertyValuesHolder.ofInt("width", new int[] { i, paramAnimationParam.viewWidth }), PropertyValuesHolder.ofInt("height", new int[] { j, paramAnimationParam.viewHeight }), PropertyValuesHolder.ofFloat("translateX", new float[] { 0.0F, paramAnimationParam.positionX }), PropertyValuesHolder.ofFloat("translateY", new float[] { 0.0F, paramAnimationParam.positionY }), PropertyValuesHolder.ofFloat("backgroundAlpha", new float[] { 1.0F, 0.0F }) });
    paramViewGroup.addUpdateListener(new qij(localViewGroup, localDrawable, localImageView1, localImageView2));
    paramViewGroup.addListener(new qik(paramAnimatorListener));
    paramViewGroup.start();
  }
  
  public static void b(ViewGroup paramViewGroup, @NonNull AnimationParam paramAnimationParam, Animator.AnimatorListener paramAnimatorListener)
  {
    ram.d("Q.qqstory.playernew.AnimationUtils", "doEnterAnimation");
    Object localObject = paramViewGroup.findViewById(2131377546);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131362719);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131381900);
    paramViewGroup = new ImageView(paramViewGroup.getContext());
    localViewGroup.addView(paramViewGroup, 0, new RelativeLayout.LayoutParams(-1, -1));
    paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup.setImageDrawable(paramAnimationParam.getAnimationDrawable());
    int i = ((View)localObject).getMeasuredWidth();
    int j = ((View)localObject).getMeasuredHeight();
    float f1 = paramAnimationParam.viewWidth * 1.0F / i;
    float f2 = paramAnimationParam.viewHeight * 1.0F / j;
    localObject = new ValueAnimator();
    ((ValueAnimator)localObject).setInterpolator(new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { f1, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { f2, 1.0F }), PropertyValuesHolder.ofInt("width", new int[] { paramAnimationParam.viewWidth, i }), PropertyValuesHolder.ofInt("height", new int[] { paramAnimationParam.viewHeight, j }), PropertyValuesHolder.ofFloat("translateX", new float[] { paramAnimationParam.positionX, 0.0F }), PropertyValuesHolder.ofFloat("translateY", new float[] { paramAnimationParam.positionY, 0.0F }), PropertyValuesHolder.ofFloat("backgroundAlpha", new float[] { 0.0F, 1.0F }) });
    ((ValueAnimator)localObject).addUpdateListener(new qil(localViewGroup, paramViewGroup, localImageView));
    ((ValueAnimator)localObject).addListener(new qim(paramAnimatorListener, localViewGroup, paramViewGroup));
    ((ValueAnimator)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qii
 * JD-Core Version:    0.7.0.1
 */