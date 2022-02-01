import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.1;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.3;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.4;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.5;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.6;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class adco
  implements adcn
{
  private View Be;
  private TextView QC;
  private TextView QD;
  private adcn.a jdField_a_of_type_Adcn$a;
  private ARVideoRecordButtonView jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView;
  private boolean bLt;
  private final String brX = acfp.m(2131702891);
  private final String brY = "0.00M";
  private volatile int cCw = 0;
  private final int cCx = 5000;
  private Runnable fT = new ARVideoRecordViewProxy.1(this);
  private View mContainer;
  private Handler mUIHandler;
  private View xf;
  
  public adco(View paramView)
  {
    this.mContainer = paramView;
    this.mContainer.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView = ((ARVideoRecordButtonView)paramView.findViewById(2131370988));
    this.Be = paramView.findViewById(2131364276);
    this.xf = paramView.findViewById(2131362905);
    this.bLt = adch.ady();
    if (this.bLt) {
      this.xf.setVisibility(8);
    }
    this.Be.setOnClickListener(null);
    this.Be.setOnTouchListener(new adcp(this));
    this.QC = ((TextView)paramView.findViewById(2131362907));
    this.QD = ((TextView)paramView.findViewById(2131362906));
    this.mUIHandler = new Handler();
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "init self");
    }
  }
  
  private void cQj()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "resetToInnerTipsStatus");
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView.setShowState(2);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView.setVisibility(0);
    this.QC.setText(this.brX);
    this.QD.setText("0.00M");
    this.QC.setVisibility(8);
    this.QD.setVisibility(8);
    this.cCw = 0;
    if (this.bLt)
    {
      this.xf.setVisibility(8);
      this.xf.clearAnimation();
    }
    do
    {
      return;
      this.xf.setVisibility(0);
      w(this.xf, 600, -40);
      adch.FV(true);
      this.bLt = true;
      this.mUIHandler.postDelayed(this.fT, 5000L);
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "ARButtonTips resetToInnerTipsStatus start animation");
  }
  
  private void w(View paramView, int paramInt1, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2);
    localTranslateAnimation1.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation1.setDuration(paramInt1 / 2);
    int i = 0 + paramInt1 / 2;
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2);
    localTranslateAnimation2.setDuration(paramInt1 / 2);
    localTranslateAnimation2.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation2.setStartOffset(i);
    i += paramInt1 / 2;
    TranslateAnimation localTranslateAnimation3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2 * 2 / 3);
    localTranslateAnimation3.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation3.setDuration(paramInt1 / 2);
    localTranslateAnimation3.setStartOffset(i);
    i += paramInt1 / 2;
    TranslateAnimation localTranslateAnimation4 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2 * 2 / 3);
    localTranslateAnimation4.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation4.setDuration(paramInt1 / 2);
    localTranslateAnimation4.setStartOffset(i);
    paramInt1 /= 2;
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation1);
    localAnimationSet.addAnimation(localTranslateAnimation2);
    localAnimationSet.addAnimation(localTranslateAnimation3);
    localAnimationSet.addAnimation(localTranslateAnimation4);
    if (paramView != null) {
      paramView.startAnimation(localAnimationSet);
    }
  }
  
  public int Bw()
  {
    return this.cCw;
  }
  
  public void KE(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode" + paramInt);
    }
    if (this.cCw == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode mCurrentUIDisplayMode equal");
      }
      return;
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.6(this, paramInt));
  }
  
  public void a(adcn.a parama)
  {
    this.jdField_a_of_type_Adcn$a = parama;
  }
  
  public void he(int paramInt1, int paramInt2)
  {
    if (this.cCw == 1) {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView.setProgress(paramInt1, 60000L);
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.5(this, paramInt1, paramInt2));
  }
  
  public void hide()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "hide");
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      this.mContainer.setVisibility(8);
    }
    for (;;)
    {
      this.mUIHandler.removeCallbacks(this.fT);
      return;
      ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.4(this));
    }
  }
  
  public boolean isVisiable()
  {
    return (this.mContainer != null) && (this.mContainer.getVisibility() == 0);
  }
  
  public void show()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "show");
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.mContainer.setVisibility(0);
      cQj();
      return;
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adco
 * JD-Core Version:    0.7.0.1
 */