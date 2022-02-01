package cooperation.qzone.panorama.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import avxd;
import java.util.Timer;
import java.util.TimerTask;

public class PanoramaGuideAnimate
  extends LinearLayout
{
  private float Dt;
  private float Du;
  private ImageView HF;
  private int Ll = 0;
  private a a;
  private float alpha = 1.0F;
  private Context context;
  private TextView eA;
  private Handler handler = new avxd(this);
  private Timer timer;
  private TimerTask timerTask;
  
  public PanoramaGuideAnimate(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PanoramaGuideAnimate(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void startTimer()
  {
    if (this.timer != null) {
      this.timer.cancel();
    }
    if (this.timerTask != null) {
      this.timerTask.cancel();
    }
    this.timer = new Timer();
    this.timerTask = new PanoramaGuideAnimate.2(this);
    this.timer.schedule(this.timerTask, 800L, 1L);
  }
  
  @TargetApi(11)
  public void ace(int paramInt)
  {
    setOrientation(1);
    setGravity(1);
    this.HF = new ImageView(this.context);
    this.HF.setImageResource(2130848484);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(100, 100);
    localLayoutParams.bottomMargin = 20;
    addView(this.HF, localLayoutParams);
    this.eA = new TextView(this.context);
    if (paramInt == 1) {
      this.eA.setText(this.context.getResources().getString(2131717999));
    }
    for (;;)
    {
      this.eA.setTextColor(-1);
      this.eA.setTextSize(14.0F);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      addView(this.eA, localLayoutParams);
      this.HF.setRotationY(0.0F);
      this.HF.setTranslationX(0.0F);
      startTimer();
      return;
      this.eA.setText(this.context.getResources().getString(2131718000));
    }
  }
  
  public void setOnAnimateListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Qg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaGuideAnimate
 * JD-Core Version:    0.7.0.1
 */