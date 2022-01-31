package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cau;
import cav;
import caw;
import cax;
import caz;
import cba;
import cbb;
import cbc;
import cbd;
import cbe;
import cbf;
import cbg;
import cbj;
import cbk;
import cbl;
import cbn;
import cbo;
import cbp;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import cooperation.troop.TroopProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class TroopChatPie
  extends BaseChatPie
{
  private static final String I = "TroopChatPie";
  static final int bX = 1;
  AnonymousChatHelper.AnonymousStatusListener jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener;
  public QQAnonymousDialog a;
  private TroopAssistTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new cbk(this);
  protected MessageObserver a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new cbg(this);
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new caw(this);
  public TroopFeedsCenterLogic a;
  private VideoPlayLogic jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
  private TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private Handler jdField_b_of_type_AndroidOsHandler = new cbj(this, Looper.getMainLooper());
  protected Button b;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public View d;
  View e;
  public View f;
  public View g;
  protected boolean o = false;
  protected boolean p;
  protected boolean q = false;
  private boolean r = false;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new cbd(this);
  }
  
  private void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      TroopGagMgr.SelfGagInfo localSelfGagInfo = paramSelfGagInfo;
      if (paramSelfGagInfo == null) {
        localSelfGagInfo = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean);
      }
      if (!localSelfGagInfo.jdField_a_of_type_Boolean) {
        break label151;
      }
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (8 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.jdField_d_of_type_Int != 1) || (this.h != 0)))
      {
        ab();
        if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(localSelfGagInfo.b);
        }
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, localSelfGagInfo.jdField_a_of_type_Long * 1000L);
      }
    }
    else
    {
      return;
    }
    this.q = true;
    return;
    label151:
    this.q = false;
    ac();
  }
  
  private void ag()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null)
    {
      cbp localcbp = new cbp(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localcbp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (!this.p) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363118));
    }
    for (;;)
    {
      b(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPie", 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364411));
    }
  }
  
  private void ah()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null) {
        break label29;
      }
    }
    label29:
    do
    {
      for (;;)
      {
        return;
        localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (((TroopInfo)localObject).wMemberNum == 0)) {
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l));
            ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d("TroopChatPie", 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopChatPie", 2, "getTroopInfoIfNeed failed");
  }
  
  private void ai()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "handleTroopNotificationMsg");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopNotificationHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!TroopNotificationHelper.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ThreadManager.b(new cbo(this));
    }
  }
  
  private void aj()
  {
    cav localcav = new cav(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(localcav, 1000L);
  }
  
  private void ak()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, null, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopChatPie", 2, localException.toString());
    }
  }
  
  private void al()
  {
    i();
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundResource(2130839218);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427467));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427465));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839489);
    if (this.jdField_a_of_type_JavaLangCharSequence != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(false);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      AnonymousChatHelper.a().b();
      af();
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(null);
        this.jdField_a_of_type_AndroidWidgetEditText.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427405));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout.setBackgroundResource(2130839230);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return;
      a(false);
    }
  }
  
  private void am()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "handleGrayTipsMsg");
    }
    TroopTipsMsgMgr localTroopTipsMsgMgr = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if (localTroopTipsMsgMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPie", 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!localTroopTipsMsgMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "troopAIO has unread troopTipMsg");
    }
    ThreadManager.b(new cbc(this, localTroopTipsMsgMgr));
  }
  
  protected void A()
  {
    super.A();
    ag();
  }
  
  protected void N()
  {
    super.N();
    ad();
  }
  
  protected void O()
  {
    super.O();
  }
  
  public void Q()
  {
    super.Q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void R()
  {
    super.R();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903183, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight(), this.jdField_e_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
      }
      if (this.o) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.o);
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    return super.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(false);
    super.a(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a()) && (TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (b(true))) {
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      Bundle localBundle = paramIntent.getExtras();
      Object localObject = Boolean.valueOf(false);
      String str = "";
      if (localBundle.containsKey("TroopFile_DeleteFile")) {
        localObject = Boolean.valueOf(localBundle.getBoolean("TroopFile_DeleteFile"));
      }
      if (localBundle.containsKey("TroopFile_FileName")) {
        str = localBundle.getString("TroopFile_FileName");
      }
      if (((Boolean)localObject).booleanValue())
      {
        localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362276), new Object[] { TroopFileUtils.a(str) });
        TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject);
        continue;
        localObject = paramIntent.getExtras().getString("member_uin");
        if (a((String)localObject, paramIntent.getExtras().getString("member_display_name"), true)) {
          if ((localObject != null) && (((String)localObject).equalsIgnoreCase("0")))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_atallmber_sendatallmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
          else
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Input_atmber_sendatmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            continue;
            if ((paramInt2 == 8001) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)) {
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
            }
          }
        }
      }
    }
  }
  
  void a(int paramInt, long paramLong)
  {
    long l2 = 0L;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    long l1 = l2;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        l1 = l2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
      } while (MsgProxyUtils.i(((ChatMessage)localObject2).msgtype));
      l1 = ((ChatMessage)localObject2).shmsgseq;
    }
    localObject1 = new cbf(this);
    if (paramInt == 1) {
      if ((int)l1 > 1L + paramLong)
      {
        if (l1 - paramLong <= 200L) {
          break label288;
        }
        paramLong = l1 - 200L;
      }
    }
    label288:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramLong, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, (Runnable)localObject1);
      do
      {
        do
        {
          do
          {
            return;
          } while ((paramInt != 4) && (paramInt != 2) && (paramInt != 3));
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
        } while ((localObject2 == null) || (l1 - ((MessageRecord)localObject2).shmsgseq > 200L));
        if ((int)l1 > ((MessageRecord)localObject2).shmsgseq + 1L)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, ((MessageRecord)localObject2).shmsgseq, false);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, (Runnable)localObject1);
          return;
        }
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)localObject2);
      } while (paramInt == -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt, paramInt, null);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog == null) {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = new QQAnonymousDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.show();
    if ((paramInt == 1) || (paramInt == 3)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new cbb(this), 1000L);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if ((this.o) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      h(false);
    }
    for (;;)
    {
      if ((this.o) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362622) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      }
      return;
      if ((!this.o) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        h(true);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundResource(2130838407);
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130838407);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int i = paramIntent.getIntExtra(AlbumConstants.i, -1);
    if (((i == 2) || (i == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramConfiguration);
    }
    super.a(paramConfiguration);
  }
  
  protected void a(QQMessageFacade.Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c())) {}
    while (((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b())) || (this.p)) {
      return;
    }
    super.a(paramMessage);
  }
  
  protected void a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramCharSequence = new ArrayList();
      paramCharSequence = AtTroopMemberSpan.a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), paramCharSequence);
    }
    super.a(paramCharSequence);
  }
  
  public void a(String paramString, long paramLong) {}
  
  protected void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
    }
    while ((paramBoolean) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) || (this.o)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 19.0F);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.a).a(this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.i();
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      return true;
    }
    e(false);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return false;
      } while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
      if (paramBoolean)
      {
        j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().delete(j - 1, j);
      }
      FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if ((!localFriendManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.p)) {
        break;
      }
      paramBoolean = true;
      paramString1 = AtTroopMemberSpan.a(localQQAppInterface, localBaseActivity, str, paramString1, paramString2, paramBoolean, this.jdField_a_of_type_AndroidWidgetEditText);
    } while ((paramString1 == null) || (paramString1.length() == 0));
    i(0);
    int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    if (j < 0) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().insert(i, paramString1);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return true;
      paramBoolean = false;
      break;
      i = j;
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    return true;
  }
  
  protected void ab()
  {
    if (this.jdField_d_of_type_Int != 2) {
      i(2);
    }
  }
  
  protected void ac()
  {
    if (this.jdField_d_of_type_Int == 2) {
      i(0);
    }
  }
  
  protected void ad()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = new TroopAioTips();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.g();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
      ThreadManager.b(new cbl(this));
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().containsKey("forward_type")) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin")))) {
        break label393;
      }
      i = 1;
      label129:
      Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      boolean bool = ((FriendManager)localObject).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((TroopRemindSettingManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!bool))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362971), 3000L);
        TroopRemindSettingManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (bool) {
        ((FriendManager)localObject).g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3) && (!bool)) {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362970), 3000L);
      }
      ah();
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && ((this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d();
      }
      ai();
      am();
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) != null) {
        break label398;
      }
      localObject = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
      if (localObject != null) {
        ((BizTroopHandler)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ThreadManager.b(new cbn(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
      break;
      label393:
      i = 0;
      break label129;
      label398:
      if (-1 == ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).intValue())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b(true);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b(false);
      }
    }
  }
  
  public void ae()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new caz(this));
    this.g.startAnimation(localAlphaAnimation);
    this.jdField_f_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void af()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new cba(this));
    this.g.startAnimation(localAlphaAnimation);
    this.jdField_f_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void b()
  {
    if (b(true)) {
      return;
    }
    super.b();
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
  }
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    if (str != null)
    {
      paramIntent = str;
      if (this.p) {
        paramIntent = str + "热聊";
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      return;
      o();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.d();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.j();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    }
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.q)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131362555, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
      ab();
      bool = true;
    }
    return bool;
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    this.p = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while ((((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).f(paramString)) || (this.p) || (!this.p)) {
      return;
    }
  }
  
  protected boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a())) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a();
    }
    return super.d();
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_AndroidWidgetEditText.getViewTreeObserver().addOnGlobalLayoutListener(new cau(this));
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPie", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.h = paramInt;
      if (!this.q) {
        break label132;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      AudioUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), false);
      b(true);
    }
    label132:
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711686);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void f(Intent paramIntent)
  {
    super.f(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    paramIntent = new cbp(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b();
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar = new TroopAssistTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar);
  }
  
  protected void g(Intent paramIntent)
  {
    int j = 0;
    Object localObject1 = paramIntent.getExtras();
    Object localObject2 = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("uintype", -1);
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    if ((!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != i)) {}
    for (this.m = false; (!this.m) || (((Bundle)localObject1).containsKey("forward_type")); this.m = true)
    {
      c(paramIntent);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (paramIntent.getExtras().containsKey("video_play_url")))
    {
      localObject1 = paramIntent.getStringExtra("video_play_url");
      long l = paramIntent.getLongExtra("video_play_msg", 0L);
      i = j;
      if (paramIntent.getBooleanExtra("video_play_feed", false))
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetLinearLayout);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a((String)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount()) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItemId(i) != l);
    }
    for (;;)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q();
      int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      if ((i < j) || (i > k + j - 1)) {
        break;
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
      if (paramIntent == null) {
        break;
      }
      localObject2 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i);
      if ((localObject2 == null) || (!(localObject2 instanceof MessageForStructing))) {
        break;
      }
      localObject2 = (MessageForStructing)localObject2;
      if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForGeneralShare))) {
        break;
      }
      localObject2 = (StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg;
      if (localObject2 == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a((String)localObject1, (StructMsgForGeneralShare)localObject2, paramIntent);
      return;
      if ((this.jdField_b_of_type_Int != 0) || (bool))
      {
        d(true);
        return;
      }
      if (((Bundle)localObject1).getLong("res_share_id", 0L) <= 0L) {
        break;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
      return;
      i = -1;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout.a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.o = paramBoolean;
    AnonymousChatHelper.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject;
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.g == null)
    {
      this.g = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.g.setBackgroundResource(2130838407);
      this.g.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.g, 0);
    }
    if (this.jdField_f_of_type_AndroidViewView == null)
    {
      this.jdField_f_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838407);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_f_of_type_AndroidViewView, 0);
    }
    if (this.jdField_e_of_type_AndroidViewView == null)
    {
      this.jdField_e_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_e_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131296667);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_b_of_type_AndroidWidgetButton == null)
    {
      this.jdField_b_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838406);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.rgb(0, 0, 0));
      this.jdField_b_of_type_AndroidWidgetButton.setTextSize(15.0F);
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131363082);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362627));
      float f1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density;
      localObject = new LinearLayout.LayoutParams((int)(57.0F * f1), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492982));
      ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(7.0F * f1));
      ((LinearLayout.LayoutParams)localObject).rightMargin = ((int)(5.0F * f1));
      ((LinearLayout.LayoutParams)localObject).bottomMargin = ((int)(f1 * 4.0F));
      ((LinearLayout.LayoutParams)localObject).gravity = 80;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetButton, (ViewGroup.LayoutParams)localObject);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296668).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130838407);
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundResource(2130838420);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_a_of_type_JavaLangCharSequence = this.jdField_c_of_type_AndroidWidgetTextView.getText();
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362622) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      a(true);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(true);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener = new cax(this);
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131362640);
        this.jdField_a_of_type_AndroidWidgetEditText.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout.setBackgroundColor(-16777216);
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout.setSelected(8);
        }
      }
    }
    for (;;)
    {
      n();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      return;
      al();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramMessage.arg1);
        continue;
        if (!this.p)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(false);
        }
      }
    }
  }
  
  protected void l()
  {
    if (!this.p)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838394);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a())) {
        break label95;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362347));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new cbe(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362672));
      return;
      label95:
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362347));
    }
  }
  
  protected void l(int paramInt)
  {
    if (!this.o) {
      super.l(paramInt);
    }
  }
  
  public void m()
  {
    Object localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (((FriendManager)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      TroopProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 2000);
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatSettingForTroop.class);
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("vistor_type", 1);
    Object localObject2;
    int i;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      if (localObject1 == null) {
        break label360;
      }
      localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label360;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label360;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label348;
      }
      i = 1;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (i != 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
        return;
        label348:
        i = 0;
        break;
      }
      label360:
      i = 0;
    }
  }
  
  protected void n()
  {
    if (this.o) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838424);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839328);
  }
  
  protected void o()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if (this.p)
    {
      if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131296670) && (b(true))) {}
    do
    {
      do
      {
        return;
        if ((paramView.getId() == 2131296930) && (this.o)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
        if ((this.jdField_b_of_type_AndroidWidgetButton == null) || (paramView != this.jdField_b_of_type_AndroidWidgetButton)) {
          break;
        }
      } while (b(true));
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {
        b();
      }
      super.onClick(paramView);
    } while ((paramView.getId() != 2131296312) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a()));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    TroopInfo localTroopInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() != 0) && (paramInt3 == 1) && (paramCharSequence.charAt(paramInt1) == '@') && (!this.i))
    {
      paramCharSequence = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (!paramCharSequence.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localTroopInfo = paramCharSequence.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localTroopInfo != null)
        {
          paramCharSequence = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, TroopMemberListActivity.class);
          paramCharSequence.putExtra("troop_code", localTroopInfo.troopuin);
          paramCharSequence.putExtra("troop_uin", localTroopInfo.troopcode);
          paramCharSequence.putExtra("param_from", 3);
          paramCharSequence.putExtra("param_is_pop_up_style", true);
          if (!this.o) {
            break label270;
          }
          paramCharSequence.putExtra("param_chat_mode", 1);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramCharSequence, 6001);
      String str1 = "2";
      try
      {
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((localTroopInfo.troopowneruin != null) && (localTroopInfo.troopowneruin.equals(str2))) {
          paramCharSequence = "0";
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, localTroopInfo.troopuin, "2", paramCharSequence, "");
          return;
          label270:
          paramCharSequence.putExtra("param_chat_mode", 0);
          break;
          paramCharSequence = str1;
          if (localTroopInfo.Administrator != null)
          {
            paramCharSequence = str1;
            if (localTroopInfo.Administrator.contains(str2)) {
              paramCharSequence = "1";
            }
          }
        }
        return;
      }
      catch (Exception paramCharSequence) {}
    }
  }
  
  protected void s()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.j();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = null;
    }
    AnonymousChatHelper.a().b();
    if (this.o) {
      al();
    }
    ac();
    super.s();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {}
    label286:
    label301:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                QQMessageFacade.Message localMessage;
                do
                {
                  do
                  {
                    return;
                    if (!(paramObject instanceof MessageRecord)) {
                      break label301;
                    }
                    if (!(paramObject instanceof ChatMessage)) {
                      break label286;
                    }
                    paramObservable = (MessageRecord)paramObject;
                    if (paramObservable.isSendFromLocal()) {
                      break;
                    }
                  } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != paramObservable.istroop) && ((!MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (!MsgProxyUtils.a(paramObservable.istroop)))) || (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) || (SystemMsg.isTroopSystemMessage(paramObservable.msgtype)) || (paramObservable.msgtype == -1013) || ("1000000".equalsIgnoreCase(paramObservable.senderuin)) || (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null));
                  localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObservable.frienduin, paramObservable.istroop);
                } while (localMessage.uniseq != paramObservable.uniseq);
                paramObject = localMessage.nickName;
                paramObservable = paramObject;
                if (localMessage.selfuin != null)
                {
                  paramObservable = paramObject;
                  if (localMessage.selfuin.equals(localMessage.senderuin)) {
                    paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
                  }
                }
                paramObject = new MsgSummary();
                MsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramObject, paramObservable, true, false);
                paramObject = paramObject.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
                this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramObservable, paramObject);
                return;
              } while ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1));
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
              return;
            } while (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null);
            this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.e();
            return;
          } while (!(paramObject instanceof TroopAioAgent.Message));
          paramObservable = (TroopAioAgent.Message)paramObject;
        } while (paramObservable == null);
        if (paramObservable.jdField_a_of_type_Int == TroopAioAgent.jdField_a_of_type_Int)
        {
          if (paramObservable.c == 1)
          {
            a(paramObservable.c, paramObservable.jdField_a_of_type_Long);
            return;
          }
          a(paramObservable.c, paramObservable.jdField_b_of_type_Long);
          return;
        }
        if (paramObservable.jdField_a_of_type_Int != TroopAioAgent.jdField_b_of_type_Int) {
          break;
        }
      } while (this.jdField_c_of_type_AndroidViewView == null);
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObservable.jdField_b_of_type_Int);
      return;
    } while (paramObservable.jdField_a_of_type_Int != TroopAioAgent.c);
    paramObservable = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatSettingForTroop.class);
    paramObservable.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    paramObservable.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramObservable.putExtra("vistor_type", 1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramObservable, 2000);
  }
  
  protected void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    }
    super.x();
  }
  
  protected void y()
  {
    super.y();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a();
    }
    if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      long l = System.currentTimeMillis() - this.jdField_c_of_type_Long;
      if (l >= 1000L) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Open_group", "Stay_open_group", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + (l / 1000L + 1L), "", "");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.h();
    }
  }
  
  protected void z()
  {
    super.z();
    if (this.o)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundResource(2130838407);
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */