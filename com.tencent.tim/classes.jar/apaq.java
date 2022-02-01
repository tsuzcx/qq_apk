import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;

public class apaq
  extends apab
  implements Animation.AnimationListener
{
  protected static int dSA = 2;
  protected static int dSB;
  protected static int dSC = 1;
  protected static int dSD = 2;
  protected static int dSE = 3;
  protected static int dSF;
  protected static final int dSI = (int)BaseApplicationImpl.getApplication().getResources().getDimension(2131297937);
  protected static int dSz = 1;
  protected float Ah;
  protected Animation X;
  protected int aOr;
  protected Animation aT;
  protected Animation aU;
  protected TextView aas;
  protected TextView aat;
  public boolean cPB = true;
  protected int dSG;
  protected int dSH = dSB;
  public LinearLayout kR;
  public LinearLayout kS;
  protected Handler mHandler = new apar(this);
  protected RelativeLayout mn;
  
  private void dYn()
  {
    this.mHandler.removeMessages(dSF);
    if (this.dSH == dSC)
    {
      dYo();
      this.kR.setVisibility(0);
      this.kS.startAnimation(this.X);
      this.dSH = dSE;
    }
    while (this.dSH != dSD) {
      return;
    }
    this.kS.startAnimation(this.X);
    this.dSH = dSE;
  }
  
  private void dYo()
  {
    this.kS.clearAnimation();
    this.mn.clearAnimation();
  }
  
  private void h(TextView paramTextView, int paramInt)
  {
    Object localObject;
    if (paramInt == dSA)
    {
      paramTextView.setText(2131699822);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843218, 0);
      paramTextView.setCompoundDrawablePadding(4);
      paramTextView.setGravity(17);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != dSz);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramTextView.setGravity(19);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ);
    } while (localObject == null);
    MsgSummary localMsgSummary = new MsgSummary();
    aqiu.a(this.context, this.app, (QQMessageFacade.Message)localObject, this.sessionInfo.cZ, localMsgSummary, ((QQMessageFacade.Message)localObject).nickName, false, false);
    paramTextView.setText(localMsgSummary.a(this.context));
  }
  
  public int Ld()
  {
    return this.aOr;
  }
  
  public void Wu(int paramInt)
  {
    if (this.kR != null) {
      this.kR.setVisibility(paramInt);
    }
  }
  
  public boolean aAJ()
  {
    return this.kS != null;
  }
  
  protected void cbf()
  {
    this.mHandler.removeMessages(dSF);
    if (this.kS != null)
    {
      dYo();
      this.kS.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.Ah = 0.0F;
    if (paramAnimation.equals(this.X))
    {
      this.kR.setVisibility(8);
      this.dSH = dSB;
    }
    do
    {
      do
      {
        return;
        if (!paramAnimation.equals(this.aT)) {
          break;
        }
        this.dSH = dSD;
      } while (this.dSG != dSA);
      this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, dSF), 3000L);
      return;
    } while (!paramAnimation.equals(this.aU));
    h(this.aas, this.dSG);
    this.aat.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.aT)) {}
  }
  
  protected void onInit()
  {
    this.Ah = 0.0F;
    this.aT = new TranslateAnimation(0.0F, 0.0F, dSI, 0.0F);
    this.X = new TranslateAnimation(0.0F, 0.0F, 0.0F, dSI);
    this.aT.setDuration(300L);
    this.X.setDuration(300L);
    this.aT.setAnimationListener(this);
    this.X.setAnimationListener(this);
    this.aU = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - dSI);
    this.aU.setDuration(300L);
    this.aU.setAnimationListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apaq
 * JD-Core Version:    0.7.0.1
 */