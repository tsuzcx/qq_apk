import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class pbp
{
  private AnimatorSet H;
  private URLImageView P;
  private pbp.a a;
  private ObjectAnimator aF;
  private ObjectAnimator aG;
  private ObjectAnimator aH;
  private ObjectAnimator aI;
  private volatile boolean azj = true;
  private ViewGroup bD;
  private LinearLayout eG;
  private volatile boolean isShowing;
  private int mRepeatCount = 3;
  private View mTargetView;
  
  public pbp(ViewGroup paramViewGroup)
  {
    this.bD = paramViewGroup;
    initView();
  }
  
  private Interpolator b()
  {
    return PathInterpolatorCompat.create(0.25F, 0.1F, 0.25F, 1.0F);
  }
  
  private void bjq()
  {
    TextView localTextView = new TextView(this.bD.getContext());
    localTextView.setTextSize(1, 16.0F);
    localTextView.setText("上下滑动查看更多哟");
    localTextView.setGravity(1);
    this.eG.addView(localTextView, new LinearLayout.LayoutParams(-2, -2));
  }
  
  private void initView()
  {
    this.eG = new LinearLayout(this.bD.getContext());
    this.eG.setGravity(17);
    this.eG.setOrientation(1);
    this.eG.setBackgroundColor(Color.parseColor("#33000000"));
    k();
    bjq();
    this.eG.setOnClickListener(new pbq(this));
    this.eG.setOnTouchListener(new pbr(this));
  }
  
  private ImageView k()
  {
    this.P = new URLImageView(this.bD.getContext());
    Object localObject = new LinearLayout.LayoutParams(ImmersiveUtils.dpToPx(50.0F), ImmersiveUtils.dpToPx(165.0F));
    this.P.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.P.setBackgroundResource(2130851773);
    this.P.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130851770);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.P.getLayoutParams().width;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.P.getLayoutParams().height;
    ous.a("https://qzonestyle.gtimg.cn/aoi/sola/20200228153849_2Ep5Zbq1da.png", this.P, (URLDrawable.URLDrawableOptions)localObject, false);
    this.eG.addView(this.P);
    return this.P;
  }
  
  public void a(pbp.a parama)
  {
    this.a = parama;
  }
  
  public void b(RecyclerViewCompat paramRecyclerViewCompat)
  {
    if (paramRecyclerViewCompat != null)
    {
      this.mTargetView = paramRecyclerViewCompat.getChildAt(0);
      this.aF = ObjectAnimator.ofFloat(this.P, "alpha", new float[] { 0.0F, 1.0F });
      this.aF.setInterpolator(b());
      this.aF.setDuration(300L);
      this.aG = ObjectAnimator.ofInt(this.mTargetView, "scrollY", new int[] { 0, ImmersiveUtils.dpToPx(134.0F) });
      this.aG.setInterpolator(b());
      this.aG.setDuration(800L);
      this.aH = ObjectAnimator.ofFloat(this.P, "alpha", new float[] { 1.0F, 0.0F });
      this.aH.setInterpolator(b());
      this.aH.setDuration(300L);
      this.aI = ObjectAnimator.ofInt(this.mTargetView, "scrollY", new int[] { ImmersiveUtils.dpToPx(134.0F), 0 });
      this.aI.setInterpolator(b());
      this.aI.setDuration(200L);
      this.H = new AnimatorSet();
      this.H.playSequentially(new Animator[] { this.aF, this.aG, this.aH, this.aI });
      this.H.addListener(new pbs(this, paramRecyclerViewCompat));
    }
  }
  
  public void bjr()
  {
    if (this.bD == null) {}
    do
    {
      do
      {
        return;
      } while (!this.azj);
      if (this.eG == null) {
        initView();
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.bD.addView(this.eG, localLayoutParams);
      this.isShowing = true;
    } while (this.H == null);
    this.mRepeatCount -= 1;
    this.H.start();
  }
  
  public void dismiss()
  {
    this.isShowing = false;
    if ((this.bD != null) && (this.eG != null)) {
      this.bD.removeView(this.eG);
    }
    if (!this.azj) {
      this.H = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bjo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbp
 * JD-Core Version:    0.7.0.1
 */