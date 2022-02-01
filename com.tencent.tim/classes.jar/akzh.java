import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.ProgressViewRed;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;

class akzh
  implements autu
{
  private int aDp;
  
  akzh(akze paramakze) {}
  
  public void GJ(boolean paramBoolean)
  {
    this.this$0.GJ(paramBoolean);
  }
  
  public void Nx(boolean paramBoolean)
  {
    this.this$0.Nx(paramBoolean);
  }
  
  public void a(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onTouchDown, " + this.this$0.mState);
    }
  }
  
  public void b(HongBaoListView paramHongBaoListView)
  {
    this.this$0.mUIHandler.removeCallbacks(this.this$0.hm);
  }
  
  public void c(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onTouchRelease, " + this.this$0.mState);
    }
    int i = paramHongBaoListView.getScrollY();
    this.this$0.dqq = 0;
    if (-i >= this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.etx / 2)
    {
      paramHongBaoListView = (PortalManager)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getAppInterface().getManager(79);
      if (paramHongBaoListView != null) {
        paramHongBaoListView.dEC();
      }
      if ((this.this$0.mState == 2) && (System.currentTimeMillis() - this.this$0.PQ > 500L))
      {
        this.this$0.PQ = System.currentTimeMillis();
        akze.b(this.this$0);
      }
      if (this.this$0.mState == 5) {
        this.this$0.dqq = 1;
      }
    }
    switch (this.this$0.mState)
    {
    default: 
      if ((-i < this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.etx / 2) && (-i > 0))
      {
        if (this.this$0.mState == 5) {
          this.this$0.dqq = 2;
        }
        this.this$0.mUIHandler.removeCallbacks(this.this$0.hm);
        this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
        this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.etw);
      }
      if ((-i < this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.etx / 2) && (!this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.dkA)) {
        GJ(false);
      }
      this.this$0.mUIHandler.removeCallbacks(this.this$0.hm);
      this.this$0.mUIHandler.postDelayed(this.this$0.hm, 2000L);
      if (this.this$0.mState == 5)
      {
        this.this$0.mUIHandler.removeMessages(1005);
        if (this.this$0.dqq != 0)
        {
          paramHongBaoListView = this.this$0.mUIHandler;
          if (this.this$0.dqq != 2) {
            break label497;
          }
        }
      }
      break;
    }
    label497:
    for (long l = 200L;; l = 2500L)
    {
      paramHongBaoListView.sendEmptyMessageDelayed(1005, l);
      return;
      if ((-i >= this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.etx / 2) || (-i <= 0)) {
        break;
      }
      this.this$0.mUIHandler.removeCallbacks(this.this$0.hm);
      this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.this$0.dqo);
      this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.etw);
      break;
    }
  }
  
  public void dEo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "tryCountdown" + this.this$0.mState);
    }
    if (this.this$0.mState == 3) {
      this.this$0.kz(-1L);
    }
    if (this.this$0.bQN) {
      Nx(false);
    }
  }
  
  public void dEp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onHongBaoPendantClick" + this.this$0.mState);
    }
    akze.a(this.this$0);
    PortalManager localPortalManager = (PortalManager)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getManager(79);
    if (localPortalManager != null) {}
    try
    {
      localPortalManager.dEE();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void dEq()
  {
    boolean bool = true;
    if (this.this$0.mState == 4)
    {
      localObject = this.this$0;
      ((akze)localObject).dqp += 1;
      localObject = (PortalManager)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getManager(79);
      ((PortalManager)localObject).ate();
      l1 = System.currentTimeMillis();
      if (this.this$0.dqp == 1)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.w(this.this$0.dqp, akze.a(this.this$0), true);
        this.this$0.afE = l1;
        ((PortalManager)localObject).Sz(this.this$0.dqp);
      }
    }
    label165:
    while (this.this$0.mState != 5)
    {
      Object localObject;
      long l1;
      return;
      long l2 = l1 - this.this$0.afE;
      this.this$0.afE = l1;
      FormalView localFormalView;
      int i;
      String str;
      if (l2 > 600L)
      {
        this.this$0.dqp = 1;
        this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
        localFormalView = this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView;
        i = this.this$0.dqp;
        str = akze.a(this.this$0);
        if (this.this$0.afE - this.this$0.afD <= 500L) {
          break label268;
        }
      }
      for (;;)
      {
        localFormalView.w(i, str, bool);
        ((PortalManager)localObject).SA(0);
        break;
        if (l2 > 400L)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
          break label165;
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(3);
        break label165;
        bool = false;
      }
    }
    label268:
  }
  
  public void onOverScroll(int paramInt1, int paramInt2)
  {
    if ((this.aDp != 0) && (paramInt2 == 0)) {
      GJ(false);
    }
    this.aDp = paramInt2;
    paramInt1 = -paramInt2;
    switch (this.this$0.mState)
    {
    default: 
      if ((this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.dkA) && (this.this$0.mState != 4)) {
        this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.dkz = true;
      }
      break;
    }
    do
    {
      return;
      if ((paramInt1 > 0) || (goto 60) || (paramInt1 > 0)) {
        break;
      }
      if (this.this$0.cvs) {
        this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.ewX();
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.dEr();
      break;
      if (paramInt1 <= 0)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.dEr();
        break;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.mA(true);
      break;
      if (paramInt1 <= this.this$0.dqo)
      {
        akze.a(this.this$0).setAlpha(255);
        akze.a(this.this$0).setVisibility(0);
        this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.dEr();
        break;
      }
      paramInt1 = this.this$0.dqo * 2;
      if (-paramInt2 <= paramInt1)
      {
        paramInt1 = (int)((paramInt1 + paramInt2) * 1.0F / this.this$0.dqo * 255.0F);
        akze.a(this.this$0).setAlpha(paramInt1);
      }
      for (;;)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqPortalFormalView.mA(true);
        break;
        akze.a(this.this$0).setAlpha(0);
      }
      paramInt1 = this.this$0.dqo * 2;
      switch (this.this$0.mState)
      {
      case 4: 
      default: 
        return;
      case 2: 
        this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.dkz = true;
        return;
      case 5: 
        this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.dkz = this.this$0.cvs;
        return;
      }
    } while ((paramInt2 >= 0) || (paramInt2 < -paramInt1));
    paramInt1 = (int)((paramInt1 + paramInt2) * 1.0F / paramInt1 * 255.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzh
 * JD-Core Version:    0.7.0.1
 */