import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.av.VideoController;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.QavPanelSoundWaveView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class jcr
{
  Animation A = null;
  Animation B = null;
  Animation C = null;
  Animation D = null;
  Animation E = null;
  Animation F = null;
  Animation G = null;
  Animation H = null;
  Animation I = null;
  Animation J = null;
  Animation K = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  QavPanel jdField_a_of_type_ComTencentAvUiQavPanel = null;
  jcr.d jdField_a_of_type_Jcr$d = null;
  jcr.e jdField_a_of_type_Jcr$e = null;
  SoftReference<Context> c = null;
  View hX = null;
  View hY = null;
  View hZ = null;
  View ia = null;
  View ib = null;
  View ic = null;
  Animation.AnimationListener j = null;
  Animation.AnimationListener k = null;
  Animation.AnimationListener l = null;
  View mHeadView = null;
  int wl = 0;
  Animation y = null;
  Animation z = null;
  
  public jcr(Context paramContext, VideoController paramVideoController, int paramInt, QavPanel paramQavPanel, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6)
  {
    this.c = new SoftReference(paramContext);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.wl = paramInt;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = paramQavPanel;
    this.hX = paramView1;
    this.hY = paramView2;
    this.mHeadView = paramView3;
    this.hZ = paramView4;
    this.ia = paramView5;
    this.ic = paramView6;
    this.y = new AlphaAnimation(0.0F, 0.0F);
    this.y.setDuration(500L);
    this.z = new AlphaAnimation(0.0F, 0.0F);
    this.z.setDuration(500L);
    paramVideoController = new DecelerateInterpolator();
    paramQavPanel = new AccelerateInterpolator();
    this.A = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    this.A.setDuration(620);
    this.A.setInterpolator(paramVideoController);
    this.F = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    this.F.setDuration(620);
    this.F.setInterpolator(paramQavPanel);
    paramInt = jll.getScreenWidth(paramContext);
    if (paramInt <= 320) {
      paramInt = paramContext.getResources().getDimensionPixelSize(2131298155) + paramContext.getResources().getDimensionPixelSize(2131298151);
    }
    for (;;)
    {
      this.B = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -paramInt, 1, 0.0F);
      this.B.setDuration(620);
      this.B.setInterpolator(paramVideoController);
      this.G = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 0, -paramInt);
      this.G.setDuration(620);
      this.G.setInterpolator(paramQavPanel);
      this.C = new AlphaAnimation(0.0F, 1.0F);
      this.C.setDuration(620);
      this.H = new AlphaAnimation(1.0F, 0.0F);
      this.H.setDuration(620);
      this.D = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      this.D.setDuration(620);
      this.D.setInterpolator(paramVideoController);
      this.I = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
      this.I.setDuration(620);
      this.I.setInterpolator(paramQavPanel);
      this.J = new AlphaAnimation(0.0F, 0.0F);
      this.J.setDuration(620);
      this.E = new AlphaAnimation(0.0F, 0.0F);
      this.E.setDuration(620);
      this.K = new AlphaAnimation(0.0F, 0.0F);
      this.K.setDuration(620);
      this.j = new jcr.a();
      this.k = new jcr.b();
      this.l = new jcr.c();
      return;
      if (paramInt <= 480) {
        paramInt = paramContext.getResources().getDimensionPixelSize(2131298156) + paramContext.getResources().getDimensionPixelSize(2131298152);
      } else {
        paramInt = paramContext.getResources().getDimensionPixelSize(2131298158) + paramContext.getResources().getDimensionPixelSize(2131298154);
      }
    }
  }
  
  public void a(jcr.d paramd)
  {
    this.jdField_a_of_type_Jcr$d = paramd;
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b() == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b().Rd) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.D == null) || (this.y == null)) {
      if (this.jdField_a_of_type_Jcr$d != null)
      {
        this.jdField_a_of_type_Jcr$d.atL();
        this.jdField_a_of_type_Jcr$d.atM();
      }
    }
    do
    {
      return;
      this.D.setAnimationListener(this.j);
      this.y.setAnimationListener(this.k);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.y);
      if (this.hX != null) {
        this.hX.startAnimation(this.z);
      }
      if (this.hY != null) {
        this.hY.startAnimation(this.z);
      }
      if (this.mHeadView != null) {
        this.mHeadView.startAnimation(this.z);
      }
      if (this.hZ != null) {
        this.hZ.startAnimation(this.z);
      }
      if (this.ia != null) {
        this.ia.startAnimation(this.z);
      }
    } while (this.ic == null);
    this.ic.startAnimation(this.z);
  }
  
  public void a(jcr.e parame)
  {
    this.jdField_a_of_type_Jcr$e = parame;
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b() == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b().Re) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.I == null))
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b() != null))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.b().Rd = false;
        this.jdField_a_of_type_ComTencentAvVideoController.b().Re = false;
      }
      if (this.jdField_a_of_type_Jcr$e != null)
      {
        this.jdField_a_of_type_Jcr$e.aoD();
        this.jdField_a_of_type_Jcr$e.aoE();
      }
      return;
    }
    parame = this.I;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel.getVisibility() != 0) {
      parame = this.J;
    }
    parame.setAnimationListener(this.l);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(parame);
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel.a() != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a().startAnimation(this.K);
    }
    if ((this.hX != null) && (this.hX.getVisibility() == 0)) {
      this.hX.startAnimation(this.F);
    }
    if ((this.hY != null) && (this.hY.getVisibility() == 0)) {
      this.hY.startAnimation(this.G);
    }
    if ((this.mHeadView != null) && (this.mHeadView.getVisibility() == 0)) {
      this.mHeadView.startAnimation(this.G);
    }
    if ((this.hZ != null) && (this.hZ.getVisibility() == 0)) {
      this.hZ.startAnimation(this.H);
    }
    if ((this.ia != null) && (this.ia.getVisibility() == 0)) {
      this.ia.startAnimation(this.H);
    }
    if ((this.ic != null) && (this.ic.getVisibility() == 0)) {
      this.ic.startAnimation(this.H);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b().Re = true;
  }
  
  public void atK()
  {
    a(null);
  }
  
  public void destroy()
  {
    this.c = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.A != null) {
      this.A.cancel();
    }
    if (this.B != null) {
      this.B.cancel();
    }
    if (this.C != null) {
      this.C.cancel();
    }
    if (this.D != null) {
      this.D.cancel();
    }
    if (this.E != null) {
      this.E.cancel();
    }
    if (this.F != null) {
      this.F.cancel();
    }
    if (this.G != null) {
      this.G.cancel();
    }
    if (this.H != null) {
      this.H.cancel();
    }
    if (this.I != null) {
      this.I.cancel();
    }
    if (this.J != null) {
      this.J.cancel();
    }
    if (this.K != null) {
      this.K.cancel();
    }
    this.y = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.C = null;
    this.D = null;
    this.E = null;
    this.F = null;
    this.G = null;
    this.H = null;
    this.I = null;
    this.J = null;
    this.K = null;
    this.jdField_a_of_type_Jcr$d = null;
    this.jdField_a_of_type_Jcr$e = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.hX = null;
    this.hY = null;
    this.mHeadView = null;
    this.hZ = null;
    this.ia = null;
    this.ic = null;
  }
  
  class a
    implements Animation.AnimationListener
  {
    a() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavInOutAnimation", 2, "InAnimation onAnimationEnd");
      }
      try
      {
        if (jcr.this.a != null) {
          jcr.this.a.atM();
        }
        return;
      }
      catch (Exception paramAnimation)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QavInOutAnimation", 2, "QavInAnimationListener onAnimationEnd Exception :" + paramAnimation);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavInOutAnimation", 2, "InAnimation onAnimationStart");
      }
      try
      {
        if (jcr.this.a != null) {
          jcr.this.a.atL();
        }
        return;
      }
      catch (Exception paramAnimation)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QavInOutAnimation", 2, "QavInAnimationListener onAnimationStart Exception :" + paramAnimation);
      }
    }
  }
  
  class b
    implements Animation.AnimationListener
  {
    b() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (jcr.this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        jcr.this.jdField_a_of_type_ComTencentAvUiQavPanel.clearAnimation();
        jcr.this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(jcr.this.D);
        if (jcr.this.jdField_a_of_type_ComTencentAvUiQavPanel.a() != null) {
          jcr.this.jdField_a_of_type_ComTencentAvUiQavPanel.a().startAnimation(jcr.this.E);
        }
      }
      if (jcr.this.hX != null)
      {
        jcr.this.hX.clearAnimation();
        if (jcr.this.hX.getVisibility() == 0) {
          jcr.this.hX.startAnimation(jcr.this.A);
        }
      }
      if (jcr.this.hY != null)
      {
        jcr.this.hY.clearAnimation();
        if (jcr.this.hY.getVisibility() == 0) {
          jcr.this.hY.startAnimation(jcr.this.B);
        }
      }
      if (jcr.this.mHeadView != null)
      {
        jcr.this.mHeadView.clearAnimation();
        if (jcr.this.mHeadView.getVisibility() == 0) {
          jcr.this.mHeadView.startAnimation(jcr.this.B);
        }
      }
      if (jcr.this.hZ != null)
      {
        jcr.this.hZ.clearAnimation();
        if (jcr.this.hZ.getVisibility() == 0) {
          jcr.this.hZ.startAnimation(jcr.this.C);
        }
      }
      if (jcr.this.ia != null)
      {
        jcr.this.ia.clearAnimation();
        if (jcr.this.ia.getVisibility() == 0) {
          jcr.this.ia.startAnimation(jcr.this.C);
        }
      }
      if (jcr.this.ic != null)
      {
        jcr.this.ic.clearAnimation();
        if (jcr.this.ic.getVisibility() == 0) {
          jcr.this.ic.startAnimation(jcr.this.C);
        }
      }
      if ((jcr.this.jdField_a_of_type_ComTencentAvVideoController != null) && (jcr.this.jdField_a_of_type_ComTencentAvVideoController.b() != null)) {
        jcr.this.jdField_a_of_type_ComTencentAvVideoController.b().Rd = true;
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  class c
    implements Animation.AnimationListener
  {
    c() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationEnd");
      }
      try
      {
        if ((jcr.this.jdField_a_of_type_ComTencentAvVideoController != null) && (jcr.this.jdField_a_of_type_ComTencentAvVideoController.b() != null))
        {
          jcr.this.jdField_a_of_type_ComTencentAvVideoController.b().Rd = false;
          jcr.this.jdField_a_of_type_ComTencentAvVideoController.b().Re = false;
        }
        if (jcr.this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          jcr.this.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(4);
        }
        if (jcr.this.hX != null) {
          jcr.this.hX.setVisibility(4);
        }
        if (jcr.this.hY != null) {
          jcr.this.hY.setVisibility(4);
        }
        if (jcr.this.mHeadView != null) {
          jcr.this.mHeadView.setVisibility(4);
        }
        if (jcr.this.hZ != null) {
          jcr.this.hZ.setVisibility(4);
        }
        if (jcr.this.ia != null) {
          jcr.this.ia.setVisibility(4);
        }
        if (jcr.this.ic != null) {
          jcr.this.ic.setVisibility(4);
        }
        if (jcr.this.jdField_a_of_type_Jcr$e != null) {
          jcr.this.jdField_a_of_type_Jcr$e.aoE();
        }
        return;
      }
      catch (Exception paramAnimation)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QavInOutAnimation", 2, "QavOutAnimationListener onAnimationEnd Exception :" + paramAnimation);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationStart");
      }
      try
      {
        if (jcr.this.jdField_a_of_type_Jcr$e != null) {
          jcr.this.jdField_a_of_type_Jcr$e.aoD();
        }
        return;
      }
      catch (Exception paramAnimation)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QavInOutAnimation", 2, "QavOutAnimationListener onAnimationStart Exception :" + paramAnimation);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void atL();
    
    public abstract void atM();
  }
  
  public static abstract interface e
  {
    public abstract void aoD();
    
    public abstract void aoE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcr
 * JD-Core Version:    0.7.0.1
 */