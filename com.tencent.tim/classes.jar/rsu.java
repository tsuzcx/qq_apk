import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class rsu
  extends ReportDialog
{
  private boolean aJD;
  private LinearLayout fe;
  private ImageView nA;
  private TextView zk;
  
  public rsu(Context paramContext)
  {
    super(paramContext);
    super.requestWindowFeature(1);
    super.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramContext = LayoutInflater.from(paramContext).inflate(2131561796, null);
    super.setCanceledOnTouchOutside(true);
    super.setContentView(paramContext);
    this.fe = ((LinearLayout)super.findViewById(2131368237));
    this.nA = ((ImageView)super.findViewById(2131368235));
    this.zk = ((TextView)super.findViewById(2131368277));
    paramContext = new ScaleAnimation(1.0F, 1.6F, 1.0F, 1.6F, 1, 0.5F, 1, 0.5F);
    paramContext.setDuration(1000L);
    paramContext.setRepeatCount(-1);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.8F, 0.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setRepeatCount(-1);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(paramContext);
    this.nA.startAnimation(localAnimationSet);
    this.fe.setOnTouchListener(new rsv(this));
  }
  
  private void aKx()
  {
    if (this.aJD) {
      return;
    }
    this.aJD = true;
    this.nA.clearAnimation();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setFillAfter(true);
    this.fe.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new rsw(this));
  }
  
  public void sI(String paramString)
  {
    this.zk.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsu
 * JD-Core Version:    0.7.0.1
 */