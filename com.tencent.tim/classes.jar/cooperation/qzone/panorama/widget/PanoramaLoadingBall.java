package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import avxe;
import awcp;
import cooperation.qzone.util.QZLog;
import java.util.Timer;
import java.util.TimerTask;

public class PanoramaLoadingBall
  extends View
{
  private float Dx;
  private int JO = PanoramaLoadingLayout.WIDTH;
  private PanoramaLoadingBackground a;
  private Context context;
  private int ezi;
  private int ezo;
  private int ezp;
  private int ezr;
  private Handler handler = new avxe(this, Looper.getMainLooper());
  private boolean isStop;
  private Paint mPaint;
  private float mR;
  private int mViewHeight = PanoramaLoadingLayout.HEIGHT;
  private Timer timer;
  private TimerTask timerTask;
  private int type;
  
  public PanoramaLoadingBall(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PanoramaLoadingBall(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void bS(Canvas paramCanvas)
  {
    this.mPaint.setColor(-1);
    this.mPaint.setStrokeWidth(3.0F);
    this.mPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(this.JO / 2, this.JO / 2, this.ezo, this.mPaint);
  }
  
  private void eCo()
  {
    stopTimer();
    this.isStop = false;
    this.timer = new Timer();
    this.timerTask = new PanoramaLoadingBall.2(this);
    try
    {
      this.timer.schedule(this.timerTask, 0L, 15L);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QZLog.e("PanoramaLoadingBall", "startTimerTask IllegalStateException", localIllegalStateException);
    }
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    setPivotX(this.JO / 2 + 5);
    setPivotY(this.mViewHeight / 2 - 5);
  }
  
  private int measureHeight(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.mViewHeight = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewHeight);
      } else {
        paramInt = this.mViewHeight;
      }
    }
  }
  
  private int measureWidth(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.JO = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.JO);
      } else {
        paramInt = this.JO;
      }
    }
  }
  
  public void a(float paramFloat, int paramInt, PanoramaLoadingBackground paramPanoramaLoadingBackground)
  {
    this.Dx = paramFloat;
    this.mR = paramFloat;
    this.type = paramInt;
    this.a = paramPanoramaLoadingBackground;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt != 0) {
        break label42;
      }
      setRotationX(paramFloat);
    }
    for (;;)
    {
      eCo();
      return;
      label42:
      setRotationY(paramFloat);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.ezi = (this.JO / 2);
    this.ezo = (this.ezi - this.ezi / 5);
    this.ezp = (this.ezi - this.ezi * 2 / 5);
    bS(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(measureWidth(paramInt1), measureHeight(paramInt2));
  }
  
  public void setRotationX(float paramFloat)
  {
    float f = 255.0F;
    if (!awcp.a().aMi()) {
      super.setRotationX(paramFloat);
    }
    paramFloat = paramFloat / this.Dx * (255 - PanoramaLoadingBackground.ezn) + PanoramaLoadingBackground.ezn;
    if (paramFloat > 255.0F) {
      paramFloat = f;
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.setContentAlpha((int)paramFloat);
      }
      return;
    }
  }
  
  public void setRotationY(float paramFloat)
  {
    if (!awcp.a().aMi()) {
      super.setRotationY(paramFloat);
    }
  }
  
  public void stopTimer()
  {
    this.isStop = true;
    if (this.timer != null) {
      this.timer.cancel();
    }
    if (this.timerTask != null) {
      this.timerTask.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBall
 * JD-Core Version:    0.7.0.1
 */