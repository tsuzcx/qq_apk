import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.robotchat.RobotChatPanelLayout;
import com.tencent.mobileqq.robotchat.RobotChatTipLayout;
import com.tencent.mobileqq.robotchat.RobotChatTipLayout.a;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class ydw
  extends xys
  implements Handler.Callback, RobotChatTipLayout.a
{
  public RobotChatPanelLayout a;
  private RobotChatTipLayout a;
  private View xB;
  
  public ydw(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean Th()
  {
    boolean bool1 = false;
    int j = 0;
    if (this.b.vm() != 0)
    {
      int i = j;
      if (this.b.vm() == 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.onBackEvent()) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        this.b.bK(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_Smx != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Smx.isShow())
      {
        this.jdField_a_of_type_Smx.bzx();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private void chl()
  {
    if (aqmj.u(this.mContext, this.app.getCurrentUin(), this.sessionInfo.aTl)) {}
    while (!(this.rz instanceof ViewGroup)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = new RobotChatTipLayout(this.mContext);
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a(this);
    ((ViewGroup)this.rz).addView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout, 0);
  }
  
  private void chm()
  {
    Object localObject = (ViewGroup)this.mTitleText.getParent();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.ejC();
    localObject = (ImageView)this.mAIORootView.findViewById(2131379816);
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(amip.f(this.mContext));
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = (wxk)this.jdField_a_of_type_Wvm.a(23);
    if (localObject != null) {
      ((wxk)localObject).cdg();
    }
    if (this.jdField_a_of_type_Adrl != null)
    {
      this.jdField_a_of_type_Adrl.doOnDestroy();
      this.jdField_a_of_type_Adrl = null;
    }
  }
  
  public void Ib()
  {
    this.TAG = "RobotChatPie";
  }
  
  public boolean OO()
  {
    return false;
  }
  
  public void R(MotionEvent paramMotionEvent)
  {
    wxk localwxk = (wxk)this.jdField_a_of_type_Wvm.a(23);
    if ((localwxk != null) && (localwxk.c(paramMotionEvent, this.aSN))) {
      return;
    }
    super.R(paramMotionEvent);
  }
  
  public boolean Te()
  {
    return false;
  }
  
  public wsr a()
  {
    return null;
  }
  
  public void a(RobotChatTipLayout paramRobotChatTipLayout)
  {
    aqmj.f(this.mContext, this.app.getCurrentUin(), this.sessionInfo.aTl, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.rz != null) && ((this.rz instanceof ViewGroup)))
    {
      ((ViewGroup)this.rz).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.unInit();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    anot.a(this.app, "dc00898", "", "", "0X800A486", "0X800A486", 0, 0, "", "", "", "");
  }
  
  public void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.rE != null) {
      super.aF(paramBoolean1, paramBoolean2);
    }
    wxk localwxk;
    do
    {
      return;
      super.aF(paramBoolean1, paramBoolean2);
      localwxk = (wxk)this.jdField_a_of_type_Wvm.a(23);
    } while (localwxk == null);
    localwxk.fg(this.rE);
  }
  
  public boolean af(boolean paramBoolean)
  {
    return super.af(paramBoolean);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.afterTextChanged(paramEditable);
      if (this.bEl == 0)
      {
        paramEditable = (wwt)a(36);
        if ((paramEditable != null) && (paramEditable.isEnabled())) {
          paramEditable.zf(bool);
        }
      }
      return;
    }
  }
  
  public void bGE()
  {
    super.bGE();
    chm();
  }
  
  public void bGQ() {}
  
  public void bGT()
  {
    if (this.ps != null)
    {
      this.ps.setVisibility(4);
      ThreadManager.post(new RobotChatPie.3(this), 5, null, false);
    }
  }
  
  public void bGY()
  {
    aprg.H(this.mContext, null, this.sessionInfo.aTl);
    anot.a(null, "dc00898", "", "", "0X800A48B", "0X800A48B", 0, 0, "", "", "", "");
  }
  
  public void bHP()
  {
    super.bHP();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onShow_otherThings:");
    }
  }
  
  public void bHa()
  {
    super.bHa();
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.setRobotName(px());
    }
  }
  
  public void bHt()
  {
    super.bHt();
    wwt localwwt = (wwt)a(36);
    if ((localwwt != null) && (localwwt.isEnabled())) {
      localwwt.v(this.Cr);
    }
  }
  
  public void bIY() {}
  
  public void bJf()
  {
    super.bJf();
    this.jdField_a_of_type_Wvm.a(this);
  }
  
  public void bn(Intent paramIntent)
  {
    super.bn(paramIntent);
    chl();
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.setRobotName(px());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(this.sessionInfo.aTl, px(), this, new ydx(this));
    }
  }
  
  public void bo(Intent paramIntent)
  {
    super.bo(paramIntent);
    this.mTitleText.setOnClickListener(new ydy(this));
  }
  
  public void br(Intent paramIntent)
  {
    super.br(paramIntent);
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    wxk localwxk = (wxk)this.jdField_a_of_type_Wvm.a(23);
    if (localwxk != null) {
      localwxk.bz(paramIntent);
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnDestroy:");
    }
    wxk localwxk = (wxk)this.jdField_a_of_type_Wvm.a(23);
    if (localwxk != null) {
      localwxk.cdh();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.rz != null))
    {
      ((ViewGroup)this.rz).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.unInit();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    if ((this.xB != null) && (this.xB.getParent() != null))
    {
      ((ViewGroup)this.xB.getParent()).removeView(this.xB);
      this.xB = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    wwt localwwt = (wwt)a(36);
    if ((localwwt != null) && (localwwt.isEnabled())) {
      localwwt.l(i());
    }
  }
  
  public void o(int paramInt1, int paramInt2)
  {
    super.o(paramInt1, paramInt2);
    wwt localwwt = (wwt)a(36);
    if ((localwwt != null) && (localwwt.isEnabled())) {
      localwwt.o(paramInt1, paramInt2);
    }
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onBackEvent begin");
    }
    if (Th()) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "no confirm dialog");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      wwt localwwt = (wwt)a(36);
      if ((localwwt != null) && (localwwt.isEnabled())) {
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0)
        {
          localwwt.zg(false);
          anot.a(this.app, "dc00898", "", "", "0X800A487", "0X800A487", 0, 0, "", "", "", "");
        }
        else
        {
          localwwt.zg(true);
        }
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    wwt localwwt = (wwt)a(36);
    if ((localwwt != null) && (localwwt.isEnabled())) {
      localwwt.l(i());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, " onTextChanged:  start=" + paramInt1 + " before=" + paramInt2 + " count=" + paramInt3);
    }
    paramCharSequence = (wxk)a(23);
    if (paramCharSequence != null) {
      paramCharSequence.CX(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
    }
  }
  
  public String px()
  {
    if (this.sessionInfo != null)
    {
      if (!TextUtils.isEmpty(this.sessionInfo.aTn)) {
        return this.sessionInfo.aTn;
      }
      return this.sessionInfo.aTl;
    }
    return null;
  }
  
  public void vW(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "leftBackEvent begin:" + paramBoolean);
    }
    if (paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "no confirm dialog");
    }
    super.vW(paramBoolean);
  }
  
  public void zL(int paramInt)
  {
    super.zL(paramInt);
    wwt localwwt = (wwt)a(36);
    if ((localwwt != null) && (localwwt.isEnabled())) {
      localwwt.ccG();
    }
  }
  
  public void zU(int paramInt)
  {
    super.zU(paramInt);
    wxk localwxk = (wxk)this.jdField_a_of_type_Wvm.a(23);
    if (localwxk != null) {
      localwxk.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, this.fs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydw
 * JD-Core Version:    0.7.0.1
 */