import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.doutu.combo.ComboEggView;
import com.tencent.mobileqq.doutu.combo.ComboMasterView;
import com.tencent.mobileqq.doutu.combo.ComboNavigateBar;
import com.tencent.mobileqq.doutu.combo.ComboUIManager.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

@TargetApi(11)
public class afef
  implements Handler.Callback, View.OnTouchListener, Observer
{
  ComboEggView jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView;
  ComboNavigateBar jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar;
  private afed jdField_b_of_type_Afed;
  apat jdField_b_of_type_Apat;
  ComboMasterView jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView;
  yjh c;
  private int cQF = 8;
  BaseChatPie e;
  RelativeLayout el;
  AIOAnimationConatiner f;
  Activity mActivity;
  QQAppInterface mApp;
  Context mContext;
  RelativeLayout mRoot;
  Handler mUiHandler = new auru(Looper.getMainLooper(), this);
  
  public afef(QQAppInterface paramQQAppInterface, Activity paramActivity, BaseChatPie paramBaseChatPie, RelativeLayout paramRelativeLayout, apat paramapat, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramActivity;
    this.el = paramRelativeLayout;
    this.mContext = paramRelativeLayout.getContext();
    this.jdField_b_of_type_Apat = paramapat;
    this.f = paramAIOAnimationConatiner;
    this.e = paramBaseChatPie;
    if (this.jdField_b_of_type_Apat != null) {
      this.jdField_b_of_type_Apat.a(this);
    }
    if (paramBaseChatPie != null)
    {
      this.c = paramBaseChatPie.a();
      this.c.a(this);
    }
  }
  
  private ComboEggView a(afed paramafed)
  {
    aPF();
    ComboEggView localComboEggView = (ComboEggView)LayoutInflater.from(this.mContext).inflate(2131558640, null);
    localComboEggView.a(this, this.mApp);
    if (localComboEggView.a(paramafed))
    {
      paramafed = new RelativeLayout.LayoutParams(-1, -1);
      paramafed.addRule(13);
      this.mRoot.addView(localComboEggView, paramafed);
      localComboEggView.pI();
      return localComboEggView;
    }
    a(paramafed);
    return null;
  }
  
  private ComboMasterView a(afed paramafed)
  {
    aPF();
    ComboMasterView localComboMasterView = (ComboMasterView)LayoutInflater.from(this.mContext).inflate(2131558641, null);
    localComboMasterView.a(this);
    if (localComboMasterView.b(paramafed))
    {
      paramafed = new RelativeLayout.LayoutParams(-1, -1);
      paramafed.addRule(13);
      this.mRoot.addView(localComboMasterView, paramafed);
      localComboMasterView.pI();
      return localComboMasterView;
    }
    a(paramafed);
    return null;
  }
  
  private void a(afed paramafed)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar = ((ComboNavigateBar)LayoutInflater.from(this.mContext).inflate(2131558642, null));
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.z(this.mApp);
    }
    if (this.el.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar) == -1)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, wja.dp2px(32.0F, this.mContext.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.topMargin = ((int)this.mContext.getResources().getDimension(2131299627) + wja.dp2px(22.0F, this.mContext.getResources()));
      this.el.addView(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar, localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.setInfo(paramafed);
  }
  
  private void aPF()
  {
    if (this.mRoot == null)
    {
      this.mRoot = new RelativeLayout(this.mContext);
      this.mRoot.setOnTouchListener(this);
    }
    FrameLayout localFrameLayout = (FrameLayout)this.mActivity.getWindow().getDecorView();
    if (localFrameLayout.indexOfChild(this.mRoot) == -1)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localFrameLayout.addView(this.mRoot, localLayoutParams);
    }
  }
  
  private boolean aiT()
  {
    boolean bool2 = true;
    Object localObject = Runtime.getRuntime();
    long l1 = (((Runtime)localObject).totalMemory() - ((Runtime)localObject).freeMemory()) / 1048576L;
    long l2 = ((Runtime)localObject).maxMemory() / 1048576L;
    long l3 = l2 - l1;
    boolean bool1;
    if (l3 < 10L)
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("ComboUIManager", 2, " hasOOMDanger: " + bool1 + " availHeapSizeInMB:" + l3 + " maxHeapSizeInMB:" + l2 + " usedMemInMB:" + l1);
      }
      localObject = anpc.a(BaseApplication.getContext());
      if (bool1) {
        break label150;
      }
    }
    for (;;)
    {
      ((anpc)localObject).collectPerformance(null, "ComboEggOOM", bool2, l3, l1, null, "");
      return bool1;
      bool1 = false;
      break;
      label150:
      bool2 = false;
    }
  }
  
  private void cYJ()
  {
    if (this.e == null) {}
    while (this.e.a == null) {
      return;
    }
    this.e.a.cCg();
  }
  
  public afed a()
  {
    afed localafed;
    if (this.jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView.M(this.mRoot);
      localafed = new afed(this.jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView.a.uin, this.jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView.a.cQE);
      this.jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
      return localafed;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.M(this.mRoot);
      localafed = new afed(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.a.uin, this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.a.cQE);
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = null;
      return localafed;
    }
    return null;
  }
  
  public void a(Animator paramAnimator, ComboMasterView paramComboMasterView)
  {
    if (this.mRoot != null)
    {
      paramAnimator = paramComboMasterView.a;
      if ((paramAnimator != null) && (this.jdField_b_of_type_Afed.cQE == paramAnimator.cQE)) {
        a(paramAnimator);
      }
      this.mRoot.removeView(paramComboMasterView);
    }
    cYJ();
    this.jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
  }
  
  public void a(ComboEggView paramComboEggView)
  {
    if (this.mRoot != null)
    {
      afed localafed = paramComboEggView.a;
      if ((localafed != null) && (this.jdField_b_of_type_Afed.cQE == localafed.cQE)) {
        a(localafed);
      }
      this.mRoot.removeView(paramComboEggView);
    }
    cYJ();
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = null;
  }
  
  public void cYI()
  {
    afed localafed = a();
    if (localafed != null) {
      a(localafed);
    }
  }
  
  public void clearViews()
  {
    if (this.mRoot != null)
    {
      FrameLayout localFrameLayout = (FrameLayout)this.mActivity.getWindow().getDecorView();
      a();
      localFrameLayout.removeView(this.mRoot);
      this.mRoot = null;
    }
    afee.cleanCache();
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar != null)
    {
      if (this.el != null) {
        this.el.removeView(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar);
      }
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    afed localafed1 = (afed)paramMessage.obj;
    afed localafed2 = a();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (localafed1.cQE > 999) {
        localafed1.cQE = 999;
      }
      if ((this.f != null) && (this.f.Rz()))
      {
        a(localafed1);
      }
      else if (abrb.v(this.mApp, "combo"))
      {
        a(localafed1);
      }
      else
      {
        if (localafed2 != null) {
          a(localafed2);
        }
        if (this.e != null)
        {
          if (this.e.a != null) {
            this.e.a.DF(false);
          }
          this.e.bIf();
          if (paramMessage.what == 2)
          {
            this.jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localafed1);
          }
          else
          {
            anot.a(this.mApp, "dc00898", "", "", "0X8008096", "0X8008096", 0, 0, "", "", "", "");
            if (aiT())
            {
              if (localafed1.uin.equals(this.mApp.getCurrentAccountUin())) {
                this.jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localafed1);
              } else {
                a(localafed1);
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = a(localafed1);
              if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView == null)
              {
                a(localafed1);
                continue;
                if (localafed1.cQE > 999) {
                  localafed1.cQE = 999;
                }
                a(localafed1);
                continue;
                clearViews();
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("ComboUIManager", 2, "[Doutu] + handleMessage : 12");
                }
                if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar != null) {
                  this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.hide();
                }
                this.jdField_b_of_type_Afed = null;
                clearViews();
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqDoutuComboComboMasterView != null) || (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView != null))
    {
      cYI();
      cYJ();
      return true;
    }
    return false;
  }
  
  public void uninit()
  {
    this.mUiHandler.removeCallbacksAndMessages(null);
    clearViews();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    new Handler(Looper.getMainLooper()).post(new ComboUIManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afef
 * JD-Core Version:    0.7.0.1
 */