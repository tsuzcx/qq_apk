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
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class zsj
{
  protected Handler a;
  protected ViewGroup a;
  public TroopGiftPanel a;
  protected PlusPanel a;
  public BaseChatPie a;
  public zsz a;
  private boolean a;
  
  public zsj(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)paramBaseChatPie.getPanelManager().a(8));
  }
  
  public TroopGiftPanel a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
  }
  
  public zsz a()
  {
    return this.jdField_a_of_type_Zsz;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
      amat.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "GiftPanel_flower", false);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel == null) || (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a()) || (this.jdField_a_of_type_Zsz == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Zsz.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_Zsz.jdField_a_of_type_Boolean) && (l1 >= this.jdField_a_of_type_Zsz.jdField_a_of_type_Long) && (l1 <= l2 + 2592000000L) && (!((bfci)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(113)).a())) {}
    for (paramInt = 1;; paramInt = 0)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
      if (paramInt != 0) {}
      for (String str1 = "1";; str1 = "0")
      {
        bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_plus", 0, 0, str2, str1, "0", "" + muk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin));
        return;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Zsz != null))
    {
      QLog.i("AIOGiftPanelContainer", 1, "downloadGiftExtraInfo() , mHasGiftExtraInfo = " + this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.isFinishing()) {
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
    amat.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "GiftPanel_flower", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hidePanel();
    label106:
    Object localObject1;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afii))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, true);
        }
      }
      else
      {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject1);
        if (!nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)) {
          break label509;
        }
        i = 4;
      }
    }
    for (;;)
    {
      label175:
      this.jdField_a_of_type_Zsz = zsz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.troopUin);
      label219:
      label233:
      Object localObject2;
      if (this.jdField_a_of_type_Zsz != null)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData(this.jdField_a_of_type_Zsz, true);
        a(paramInt, i);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(paramInt);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null) {
          break label616;
        }
        paramBoolean = nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
        localObject2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
        if (!paramBoolean) {
          break label618;
        }
        localObject1 = "#333333";
        label272:
        ((TroopGiftPanel)localObject2).setMainAreaBackgroundColor(Color.parseColor((String)localObject1));
        if (!(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e instanceof TextView)) {
          break;
        }
        localObject2 = (TextView)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e;
        if (!paramBoolean) {
          break label626;
        }
      }
      label616:
      label618:
      label626:
      for (localObject1 = "#878B99";; localObject1 = "#000000")
      {
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afim))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, 13, 6);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, false);
          break label106;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afiw))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, 11, 2);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, false);
          break label106;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahkz)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, 12, 7);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, false);
        break label106;
        label509:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afim)) {
          break label175;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afiw))
        {
          i = 5;
          break label175;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahkz)) {
          break label634;
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
        break label272;
      }
      label634:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsj
 * JD-Core Version:    0.7.0.1
 */