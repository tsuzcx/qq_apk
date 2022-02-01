import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.ar.ScanningData;

public class adgb
  extends ScanningData
{
  private AnimatorSet O;
  private AnimatorSet P;
  private AnimatorSet Q;
  private AnimatorSet R;
  private long SO;
  private ObjectAnimator aQ;
  private ObjectAnimator aR;
  private ObjectAnimator aS;
  private ObjectAnimator aT;
  private AnimatorSet aj;
  private AnimatorSet b;
  private ObjectAnimator bC;
  private ObjectAnimator bD;
  private ObjectAnimator bE;
  private ObjectAnimator bF;
  private AnimatorSet c;
  private AnimatorSet l;
  
  public adgb(Context paramContext)
  {
    super(paramContext);
    init();
    initAnimation();
  }
  
  private void init()
  {
    this.bMB = true;
    this.bY = (aqnm.dip2px(1.5F) * this.scale);
    this.FG = -1;
  }
  
  @TargetApi(11)
  public void AR()
  {
    if (this.bC == null)
    {
      this.bC = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 0.0F, 1.0F });
      this.bC.setInterpolator(new LinearInterpolator());
      this.bC.setDuration(600L);
    }
    if (this.b == null)
    {
      this.b = new AnimatorSet();
      this.b.play(this.bC);
    }
    if (this.bD == null)
    {
      this.bD = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 0.0F, -360.0F });
      this.bD.setInterpolator(new LinearInterpolator());
      this.bD.setDuration(18000L);
      this.bD.setRepeatCount(-1);
    }
    if (this.c == null)
    {
      this.c = new AnimatorSet();
      this.c.play(this.bD);
    }
  }
  
  @TargetApi(11)
  public void AT()
  {
    if (this.bE == null)
    {
      this.bE = ObjectAnimator.ofFloat(this, "iBCAlpha", new float[] { 0.0F, 1.0F });
      this.bE.setInterpolator(new LinearInterpolator());
      this.bE.setDuration(600L);
    }
    if (this.aj == null)
    {
      this.aj = new AnimatorSet();
      this.aj.play(this.bE);
    }
    if (this.bF == null)
    {
      this.bF = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { 0.0F, 360.0F });
      this.bF.setInterpolator(new LinearInterpolator());
      this.bF.setDuration(18000L);
      this.bF.setRepeatCount(-1);
    }
    if (this.l == null)
    {
      this.l = new AnimatorSet();
      this.l.play(this.bF);
    }
  }
  
  @TargetApi(11)
  public void AX()
  {
    if (this.b != null) {
      this.b.start();
    }
    if (this.c != null) {
      this.c.start();
    }
  }
  
  @TargetApi(11)
  public void AZ()
  {
    if (this.aj != null) {
      this.aj.start();
    }
    if (this.l != null) {
      this.l.start();
    }
  }
  
  @TargetApi(11)
  public void Gb(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.bMD)) {}
    for (this.SO = 3666L;; this.SO = 0L)
    {
      if (this.b != null) {
        this.b.setStartDelay(this.SO);
      }
      if (this.c != null) {
        this.c.setStartDelay(this.SO);
      }
      if (this.aj != null) {
        this.aj.setStartDelay(this.SO);
      }
      if (this.l != null) {
        this.l.setStartDelay(this.SO);
      }
      if (this.O != null) {
        this.O.setStartDelay(this.SO + 320L);
      }
      if (this.P != null) {
        this.P.setStartDelay(this.SO + 320L);
      }
      if (this.Q != null) {
        this.Q.setStartDelay(this.SO + 800L);
      }
      if (this.R != null) {
        this.R.setStartDelay(this.SO + 800L);
      }
      return;
    }
  }
  
  @TargetApi(11)
  public void cRf()
  {
    if (this.aQ == null)
    {
      this.aQ = ObjectAnimator.ofFloat(this, "fNCHAlpha", new float[] { 0.0F, 1.0F });
      this.aQ.setInterpolator(new LinearInterpolator());
      this.aQ.setDuration(400L);
    }
    if (this.O == null)
    {
      this.O = new AnimatorSet();
      this.O.play(this.aQ);
    }
    if (this.aR == null)
    {
      this.aR = ObjectAnimator.ofFloat(this, "fLAlpha", new float[] { 0.0F, 1.0F });
      this.aR.setInterpolator(new LinearInterpolator());
      this.aR.setDuration(200L);
    }
    if (this.P == null)
    {
      this.P = new AnimatorSet();
      this.P.play(this.aR);
    }
  }
  
  @TargetApi(11)
  public void cRg()
  {
    if (this.aS == null)
    {
      this.aS = ObjectAnimator.ofFloat(this, "fCPositionY", new float[] { -aqnm.dip2px(25.0F), 0.0F });
      this.aS.setInterpolator(new LinearInterpolator());
      this.aS.setDuration(280L);
    }
    if (this.Q == null)
    {
      this.Q = new AnimatorSet();
      this.Q.play(this.aS);
    }
    if (this.aT == null)
    {
      this.aT = ObjectAnimator.ofFloat(this, "fCAlpha", new float[] { 0.0F, 1.0F });
      this.aT.setInterpolator(new LinearInterpolator());
      this.aT.setDuration(280L);
    }
    if (this.R == null)
    {
      this.R = new AnimatorSet();
      this.R.play(this.aT);
    }
  }
  
  @TargetApi(11)
  public void cRi()
  {
    if (this.O != null) {
      this.O.start();
    }
    if (this.P != null) {
      this.P.start();
    }
  }
  
  @TargetApi(11)
  public void cRj()
  {
    if (this.Q != null) {
      this.Q.start();
    }
    if (this.R != null) {
      this.R.start();
    }
  }
  
  public void gd(boolean paramBoolean)
  {
    this.ql = true;
    init();
    Gb(paramBoolean);
    AX();
    AZ();
    if (!this.bMD)
    {
      cRi();
      cRj();
    }
  }
  
  public void initAnimation()
  {
    AR();
    AT();
    cRf();
    cRg();
  }
  
  public void reset()
  {
    super.reset();
    if (this.isClicked)
    {
      this.bY = aqnm.dip2px(5.0F);
      return;
    }
    this.bY = aqnm.dip2px(1.5F);
  }
  
  @TargetApi(11)
  public void stopAnimation()
  {
    if ((this.b != null) && (this.b.isRunning())) {
      this.b.end();
    }
    if ((this.c != null) && (this.c.isRunning())) {
      this.c.end();
    }
    if ((this.aj != null) && (this.aj.isRunning())) {
      this.aj.end();
    }
    if ((this.l != null) && (this.l.isRunning())) {
      this.l.end();
    }
    if ((this.O != null) && (this.O.isRunning())) {
      this.O.end();
    }
    if ((this.P != null) && (this.P.isRunning())) {
      this.P.end();
    }
    if ((this.Q != null) && (this.Q.isRunning())) {
      this.Q.end();
    }
    if ((this.R != null) && (this.R.isRunning())) {
      this.R.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgb
 * JD-Core Version:    0.7.0.1
 */