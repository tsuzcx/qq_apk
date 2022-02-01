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

public class smx
{
  public TroopGiftPanel a;
  protected PlusPanel a;
  public snf a;
  private boolean aMe;
  protected ViewGroup mAIORootView;
  public BaseChatPie mBaseChatPie;
  protected Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public smx(BaseChatPie paramBaseChatPie)
  {
    this.mBaseChatPie = paramBaseChatPie;
    this.mAIORootView = this.mBaseChatPie.mAIORootView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)paramBaseChatPie.a().B(8));
  }
  
  public TroopGiftPanel a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
  }
  
  public snf a()
  {
    return this.jdField_a_of_type_Snf;
  }
  
  public void aj(boolean paramBoolean, int paramInt)
  {
    int i = 6;
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.isShow())) {
      return;
    }
    abrb.b(this.mBaseChatPie.app, "GiftPanel_flower", true);
    this.mBaseChatPie.hidePanel();
    label106:
    Object localObject1;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null)
      {
        if ((this.mBaseChatPie instanceof xwn))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.mBaseChatPie.mActivity, this.mBaseChatPie);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.mBaseChatPie.app, this.mBaseChatPie.sessionInfo, true);
        }
      }
      else
      {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        this.mAIORootView.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject1);
        if (!jof.a().dd(this.mBaseChatPie.sessionInfo.aTl)) {
          break label507;
        }
        i = 4;
      }
    }
    for (;;)
    {
      label175:
      this.jdField_a_of_type_Snf = snf.a(this.mBaseChatPie.mContext, i, this.mBaseChatPie.sessionInfo.troopUin);
      label219:
      label233:
      Object localObject2;
      if (this.jdField_a_of_type_Snf != null)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData(this.jdField_a_of_type_Snf, true);
        eG(paramInt, i);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.reset(paramInt);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null) {
          break label614;
        }
        paramBoolean = jof.a().dd(this.mBaseChatPie.sessionInfo.aTl);
        localObject2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
        if (!paramBoolean) {
          break label616;
        }
        localObject1 = "#333333";
        label271:
        ((TroopGiftPanel)localObject2).setMainAreaBackgroundColor(Color.parseColor((String)localObject1));
        if (!(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.qr instanceof TextView)) {
          break;
        }
        localObject2 = (TextView)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.qr;
        if (!paramBoolean) {
          break label623;
        }
      }
      label614:
      label616:
      label623:
      for (localObject1 = "#878B99";; localObject1 = "#000000")
      {
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
        return;
        if ((this.mBaseChatPie instanceof xyi))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.mBaseChatPie.mActivity, this.mBaseChatPie, 13, 6);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.mBaseChatPie.app, this.mBaseChatPie.sessionInfo, false);
          break label106;
        }
        if ((this.mBaseChatPie instanceof xys))
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.mBaseChatPie.mActivity, this.mBaseChatPie, 11, 2);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.mBaseChatPie.app, this.mBaseChatPie.sessionInfo, false);
          break label106;
        }
        if (!(this.mBaseChatPie instanceof ydz)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = new TroopGiftPanel(this.mBaseChatPie.mActivity, this.mBaseChatPie, 12, 7);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.mBaseChatPie.app, this.mBaseChatPie.sessionInfo, false);
        break label106;
        label507:
        if ((this.mBaseChatPie instanceof xyi)) {
          break label175;
        }
        if ((this.mBaseChatPie instanceof xys))
        {
          i = 5;
          break label175;
        }
        if (!(this.mBaseChatPie instanceof ydz)) {
          break label630;
        }
        i = 7;
        break label175;
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.showLoading();
        break label219;
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel == null) {
          break label233;
        }
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.mAIORootView.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
        break label233;
        break;
        localObject1 = "#FFFFFF";
        break label271;
      }
      label630:
      i = 1;
    }
  }
  
  public void bzx()
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.isShow()))
    {
      this.mAIORootView.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
      abrb.b(this.mBaseChatPie.app, "GiftPanel_flower", false);
    }
  }
  
  public void eG(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if ((this.aMe) && (this.jdField_a_of_type_Snf != null))
    {
      QLog.i("AIOGiftPanelContainer", 1, "downloadGiftExtraInfo() , mHasGiftExtraInfo = " + this.aMe);
      if (!this.mBaseChatPie.mActivity.isFinishing()) {
        this.mUIHandler.post(new AIOGiftPanelContainer.1(this, paramInt1));
      }
      return;
    }
    ThreadManager.post(new AIOGiftPanelContainer.2(this, l, paramInt2, paramInt1), 8, null, true);
  }
  
  public boolean isShow()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) {
      return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.isShow();
    }
    return false;
  }
  
  public void yD(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel == null) || (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.bPn) || (this.jdField_a_of_type_Snf == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Snf.date;
    if ((this.jdField_a_of_type_Snf.MX) && (l1 >= this.jdField_a_of_type_Snf.date) && (l1 <= l2 + 2592000000L) && (!((apsz)this.mBaseChatPie.app.getManager(113)).aBx())) {}
    for (paramInt = 1;; paramInt = 0)
    {
      String str2 = this.mBaseChatPie.sessionInfo.aTl;
      if (paramInt != 0) {}
      for (String str1 = "1";; str1 = "0")
      {
        anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_plus", 0, 0, str2, str1, "0", "" + jlk.a(this.mBaseChatPie.app, this.mBaseChatPie.app.getCurrentAccountUin(), this.mBaseChatPie.sessionInfo.aTl));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smx
 * JD-Core Version:    0.7.0.1
 */