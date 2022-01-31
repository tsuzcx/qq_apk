import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.AIOGiftPanelContainer.1;
import com.tencent.biz.troopgift.AIOGiftPanelContainer.2;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class xbm
{
  protected Handler a;
  protected ViewGroup a;
  public TroopGiftPanel a;
  public BaseChatPie a;
  protected PlusPanel a;
  public xcc a;
  private boolean a;
  
  public xbm(BaseChatPie paramBaseChatPie, PlusPanel paramPlusPanel)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = paramPlusPanel;
  }
  
  public TroopGiftPanel a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
  }
  
  public xcc a()
  {
    return this.jdField_a_of_type_Xcc;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
      ajey.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GiftPanel_flower", false);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel == null) || (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a) || (this.jdField_a_of_type_Xcc == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Xcc.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_Xcc.jdField_a_of_type_Boolean) && (l1 >= this.jdField_a_of_type_Xcc.jdField_a_of_type_Long) && (l1 <= l2 + 2592000000L) && (!((balh)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113)).a())) {}
    for (paramInt = 1;; paramInt = 0)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if (paramInt != 0) {}
      for (String str1 = "1";; str1 = "0")
      {
        axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_plus", 0, 0, str2, str1, "0", "" + mua.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
        return;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xcc != null))
    {
      QLog.i("AIOGiftPanelContainer", 1, "downloadGiftExtraInfo() , mHasGiftExtraInfo = " + this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        this.jdField_a_of_type_AndroidOsHandler.post(new AIOGiftPanelContainer.1(this, paramInt1));
      }
      return;
    }
    ThreadManager.post(new AIOGiftPanelContainer.2(this, l, paramInt2, paramInt1), 8, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int i = 6;
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a())) {
      return;
    }
    ajey.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GiftPanel_flower", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ap();
    label106:
    Object localObject1;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aemd))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        }
      }
      else
      {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject1);
        if (!myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
          break label508;
        }
        i = 4;
      }
    }
    for (;;)
    {
      label175:
      this.jdField_a_of_type_Xcc = xcc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, i, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      label219:
      label233:
      Object localObject2;
      if (this.jdField_a_of_type_Xcc != null)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData(this.jdField_a_of_type_Xcc, true);
        a(paramInt, i);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(paramInt);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null) {
          break label615;
        }
        paramBoolean = myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        localObject2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
        if (!paramBoolean) {
          break label617;
        }
        localObject1 = "#333333";
        label271:
        ((TroopGiftPanel)localObject2).setMainAreaBackgroundColor(Color.parseColor((String)localObject1));
        if (!(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e instanceof TextView)) {
          break;
        }
        localObject2 = (TextView)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e;
        if (!paramBoolean) {
          break label625;
        }
      }
      label615:
      label617:
      label625:
      for (localObject1 = "#878B99";; localObject1 = "#000000")
      {
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeoc))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, 13, 6);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          break label106;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeom))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, 11, 2);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          break label106;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aetq)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, 12, 7);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
        break label106;
        label508:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeoc)) {
          break label175;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeom))
        {
          i = 5;
          break label175;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aetq)) {
          break label633;
        }
        i = 7;
        break label175;
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d();
        break label219;
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null) {
          break label233;
        }
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        break label233;
        break;
        localObject1 = "#FFFFFF";
        break label271;
      }
      label633:
      i = 1;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) {
      return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xbm
 * JD-Core Version:    0.7.0.1
 */