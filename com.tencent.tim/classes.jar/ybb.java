import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.14;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.5;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.9;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceAnimView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class ybb
  extends BaseChatPie
  implements Handler.Callback
{
  private Comparator<MessageRecord> B = new ybc(this);
  private long JH;
  private acfd a;
  private String aLX = "";
  private String aXa = "0";
  private String aXb = "";
  private volatile ExtendFriendUserInfo b;
  private int bYj = 0;
  private volatile int bYk;
  private int bYl;
  private int bYm;
  private int bYn;
  private int bYo = 0;
  private boolean bla;
  private boolean blb;
  private boolean blc;
  private boolean bld = true;
  private boolean ble;
  private Observer c = new ybg(this);
  afsr d = new ybj(this);
  private MessageRecord l;
  private achq mMsgObserver = new ybh(this);
  private long mStartTime = -1L;
  private int mTipsType = 0;
  
  public ybb(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Acfd = new ybi(this);
  }
  
  private boolean Th()
  {
    boolean bool1 = false;
    int j = 0;
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 0)
    {
      int i = j;
      if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 2)
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
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.bK(true);
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
  
  private boolean Ti()
  {
    boolean bool = false;
    afwh localafwh;
    if (this.sessionInfo.cZ == 1044) {
      if (this.app != null)
      {
        localafwh = (afwh)this.app.getManager(292);
        if (localafwh == null) {
          break label66;
        }
      }
    }
    label66:
    for (bool = localafwh.c(this.app).booleanValue();; bool = false)
    {
      return bool;
      QLog.d(this.TAG, 2, "UINTYPE NOT Y");
      return false;
    }
  }
  
  private void cZ(ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "handleExtendFriendOnlineState onlineUinList =" + paramArrayList);
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      String str = ((Long)paramArrayList.get(0)).toString();
      if (this.sessionInfo == null) {}
      for (paramArrayList = ""; str.equals(paramArrayList); paramArrayList = this.sessionInfo.aTl)
      {
        a().runOnUiThread(new LimitChatPie.10(this));
        return;
      }
    }
  }
  
  private void cgA()
  {
    if (this.jdField_a_of_type_Wki != null) {
      this.jdField_a_of_type_Wki.Y = Boolean.valueOf(false);
    }
    this.aSc = false;
    vU(true);
    if (this.Cv != null) {
      this.Cv.setVisibility(8);
    }
  }
  
  private void cgB()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.sessionInfo.aTl, 96);
    ProfileActivity.a(this.mContext, localAllInOne, this.bYo, 2);
  }
  
  private void cgC()
  {
    Object localObject;
    if (this.sessionInfo == null) {
      localObject = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "updateSession_updateSubTitle toUin =" + (String)localObject);
      }
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.add(Long.valueOf((String)localObject));
        label63:
        if (!localArrayList.isEmpty())
        {
          localObject = (afsg)this.app.getBusinessHandler(127);
          if (localObject != null) {
            ((afsg)localObject).kz(localArrayList);
          }
        }
        return;
        localObject = this.sessionInfo.aTl;
      }
      catch (Exception localException)
      {
        break label63;
      }
    }
  }
  
  private void cgD()
  {
    if ((this.ps != null) && (this.ps.getVisibility() == 0) && (this.jdField_b_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataExtendFriendUserInfo.tagID == 10000))
    {
      cgG();
      cgE();
    }
  }
  
  private void cgE()
  {
    aqju localaqju;
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      localaqju = aqha.a(this.mActivity, 230).setMessage(this.mActivity.getString(2131700548)).setPositiveButton(this.mActivity.getString(2131721079), new ybf(this)).setNegativeButton(this.mActivity.getString(2131721058), new ybe(this));
      localaqju.setCancelable(false);
    }
    try
    {
      localaqju.show();
      anot.a(this.app, "dc00898", "", "", "0X800ADC8", "0X800ADC8", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.TAG, 1, "ShowVoiceDialog fail" + localException.toString());
      }
    }
  }
  
  private void cgF()
  {
    this.bld = ((accy)this.app.getBusinessHandler(4)).ZN();
    ((afwh)this.app.getManager(292)).IE(this.bld);
  }
  
  private void cgG()
  {
    if ((this.ps.getParent() instanceof RelativeLayout))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.ps.getParent();
      ExtendFriendVoiceAnimView localExtendFriendVoiceAnimView = new ExtendFriendVoiceAnimView(this.mContext);
      int i = aqnm.dip2px(29.0F);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.addRule(13, -1);
      localRelativeLayout.addView(localExtendFriendVoiceAnimView, 0, localLayoutParams);
      localExtendFriendVoiceAnimView.setCircleParams(wE(), 800);
      localExtendFriendVoiceAnimView.startAnimation(500L);
    }
  }
  
  private void cgH()
  {
    if (!this.mActivity.isFinishing()) {
      QQToast.a(this.mContext, 1, this.mContext.getString(2131701212), 0).show();
    }
  }
  
  private void cgI()
  {
    ThreadManager.getSubThreadHandler().post(new LimitChatPie.14(this));
  }
  
  private void cgj()
  {
    aibl localaibl = (aibl)a(16);
    if (localaibl != null) {
      localaibl.drQ();
    }
  }
  
  private void cgx()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "gotoFriendAio : " + this.sessionInfo.aTl);
    }
    Intent localIntent = wja.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.sessionInfo.aTl);
    localIntent.putExtra("uintype", 0);
    a().startActivity(localIntent);
  }
  
  private void initData()
  {
    if (this.sessionInfo == null) {}
    for (String str = "";; str = this.sessionInfo.aTl)
    {
      this.aXa = afwy.k(this.app, str);
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.6(this, str));
      this.bYl = afwy.i(this.app, this.sessionInfo.aTl);
      this.JH = System.currentTimeMillis();
      return;
    }
  }
  
  private int wE()
  {
    String str1 = "#FFFFFFFF";
    String str2 = ThemeUtil.getCurrentThemeId();
    if ("1103".equals(str2)) {
      str1 = "#FFA1A1A1";
    }
    for (;;)
    {
      try
      {
        int i = Color.parseColor(str1);
        return i;
      }
      catch (Exception localException) {}
      if ("2920".equals(str2)) {
        str1 = "#FF848484";
      } else if ("2101".equals(str2)) {
        str1 = "#FFDBB86B";
      } else if ("2105".equals(str2)) {
        str1 = "#FF12B7F5";
      } else if (anlm.pq(str2)) {
        if (("2921".equals(str2)) || ("2971".equals(str2))) {
          str1 = "#FF03081A";
        } else {
          str1 = "#FFFFFFFF";
        }
      }
    }
    return 0;
  }
  
  public void Ib()
  {
    this.TAG = "LimitChatPie";
  }
  
  public boolean OI()
  {
    boolean bool = false;
    if ((this.aey) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean OL()
  {
    return false;
  }
  
  public void R(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "setSubTitlonShowSubTitleTexteText statusText =" + paramString);
    }
    amey localamey = (amey)a(45);
    if ((localamey != null) && (localamey.c(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new LimitChatPie.9(this, paramString, paramBoolean));
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.Pc();
    return aqlv.a(this.app, bool);
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = super.a(paramQQAppInterface, paramBoolean);
    Collections.sort(paramQQAppInterface, this.B);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
      this.l = ((MessageRecord)paramQQAppInterface.get(paramQQAppInterface.size() - 1));
    }
    return paramQQAppInterface;
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    super.a(paramMessage);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.jdField_a_of_type_Wki != null) {
      this.jdField_a_of_type_Wki.Y = Boolean.valueOf(false);
    }
  }
  
  public void aG()
  {
    super.aG();
  }
  
  public void aQ() {}
  
  public boolean af(boolean paramBoolean)
  {
    paramBoolean = super.af(paramBoolean);
    cgA();
    ((ysf)this.mActivity.app.getManager(34)).addObserver(this.c);
    this.app.addObserver(this.d);
    initData();
    return paramBoolean;
  }
  
  public void bGE()
  {
    super.bGE();
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setChoiceMode(0);
  }
  
  public void bGK()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.app, this.sessionInfo, this.jdField_a_of_type_Yjh, this.mActivity, this.uiHandler);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
  }
  
  public void bGT()
  {
    if (Boolean.valueOf(Ti()).booleanValue())
    {
      this.ps.setVisibility(0);
      this.ps.setOnClickListener(new ybd(this));
      return;
    }
    this.ps.setVisibility(8);
  }
  
  public void bGY()
  {
    if ((aqft.rj(this.sessionInfo.aTl)) && (aqft.bK(this.mContext))) {
      return;
    }
    Intent localIntent = new Intent(this.mContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.aTl);
    String str2 = this.aLX;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.sessionInfo.aTn;
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("uintype", this.sessionInfo.cZ);
    localIntent.putExtra("ExtendFriendLimitChatFromeType", this.bYo);
    if (this.jdField_b_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) {
      localIntent.putExtra("subId", ExtendFriendUserInfo.fromTypeToSubID(this.jdField_b_of_type_ComTencentMobileqqDataExtendFriendUserInfo.fromType));
    }
    this.mActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void bHP()
  {
    super.bHP();
  }
  
  public void bHZ()
  {
    super.bHZ();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addBusinessObservers");
    }
    this.app.addObserver(this.mMsgObserver);
    this.app.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  public void bHs()
  {
    Intent localIntent = this.mActivity.getIntent();
    localIntent.putExtra("key_limit_chat_result_action", this.bYj);
    this.mActivity.setResult(-1, localIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "chat pie finish, finishaction:" + this.bYj);
    }
    this.blb = true;
  }
  
  public void bIM()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "updateUI_titleBarForTheme" + this.aey);
    }
    if ((this.sessionInfo == null) || (this.mContext == null)) {
      return;
    }
    super.bIM();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.aY(this.app);
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Acfd);
    this.app.removeObserver(this.mMsgObserver);
  }
  
  public void bIb()
  {
    super.bIb();
  }
  
  public void bJf()
  {
    super.bJf();
    this.jdField_a_of_type_Wvm.a(this);
  }
  
  public void bo(Intent paramIntent)
  {
    super.bo(paramIntent);
    this.mTitleText.setOnClickListener(new ybk(this));
  }
  
  public void br(Intent paramIntent)
  {
    super.br(paramIntent);
    this.bYo = paramIntent.getIntExtra("key_limitchat_from_type", 0);
    this.blc = paramIntent.getBooleanExtra("key_limitchat_auto_open", false);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "updateSession, mfromType :" + this.bYo);
    }
  }
  
  public void bt(Intent paramIntent)
  {
    this.aSe = true;
    this.Cr.setText("");
  }
  
  public List<ChatMessage> cF()
  {
    return a(this.app, false);
  }
  
  public void cgy()
  {
    int i = 1;
    Object localObject = (afsi)this.app.getManager(264);
    int k = ((afsi)localObject).Dz();
    int j;
    if (k > 0)
    {
      j = this.bYk / k + 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "checkShowGrayTips " + this.bYk + " " + j + " " + this.bYl);
      }
      if (this.bYk % k != 0) {
        break label171;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        String str = ((afsi)localObject).uD();
        localObject = ((afsi)localObject).uE();
        if (!TextUtils.isEmpty(str))
        {
          afwy.w(this.app, this.sessionInfo.aTl, j);
          this.bYl = j;
          ThreadManager.getSubThreadHandler().post(new LimitChatPie.5(this, str, (String)localObject));
        }
      }
      return;
      label171:
      if (j - this.bYl <= 1) {
        i = 0;
      }
    }
  }
  
  public void cgz()
  {
    anot.a(this.app, "dc00898", "", "", "0X800A693", "0X800A693", 0, 0, "", "", "", "");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnDestroy, userfinish:" + this.blb);
    }
    ((ysf)this.mActivity.app.getManager(34)).deleteObserver(this.c);
    this.c = null;
    this.app.removeObserver(this.d);
    long l1;
    long l2;
    if (this.sessionInfo == null) {
      if (this.blc)
      {
        l1 = System.currentTimeMillis();
        l2 = this.JH;
        if ((this.bYm <= 0) || (this.bYn <= 0)) {
          break label195;
        }
        anot.a(this.app, "dc00898", "", "", "0X800A695", "0X800A695", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", "0X800A692", "0X800A692", 0, 0, String.valueOf(l1 - l2), "", this.aXa, "");
      return;
      String str = this.sessionInfo.aTl;
      break;
      label195:
      if ((this.bYm > 0) || (this.bYn > 0)) {
        anot.a(this.app, "dc00898", "", "", "0X800A694", "0X800A694", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    afyj.stopAll();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (((acff)this.app.getManager(51)).isFriend(this.sessionInfo.aTl)) {
      cgx();
    }
    cgF();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ((afsg)this.app.getBusinessHandler(127)).k(this.sessionInfo.aTl, true);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  public void k(Object paramObject)
  {
    super.k(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 4: 
      anot.a(this.app, "dc00898", "", "", "0X80096AA", "0X80096AA", this.bYo, 0, "", "", "", "");
      return;
    case 2: 
      anot.a(this.app, "dc00898", "", "", "0X80096A9", "0X80096A9", this.bYo, 0, "", "", "", "");
      return;
    case 5: 
      anot.a(this.app, "dc00898", "", "", "0X80096AB", "0X80096AB", this.bYo, 0, "", "", "", "");
      return;
    case 24: 
      anot.a(this.app, "dc00898", "", "", "0X80096AC", "0X80096AC", this.bYo, 0, "", "", "", "");
      return;
    }
    anot.a(this.app, "dc00898", "", "", "0X80096AD", "0X80096AD", this.bYo, 0, "", "", "", "");
  }
  
  public List<ChatMessage> n(boolean paramBoolean)
  {
    return a(this.app, paramBoolean);
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    super.n(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onPanelChanged, old:" + paramInt1 + " new:" + paramInt2);
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
    return super.onBackEvent();
  }
  
  public void onChangeMultiScreen(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131372043) {
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
    }
  }
  
  public void onPlayStart()
  {
    afyj.stopAll();
    super.onPlayStart();
  }
  
  public void onPostThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onPostThemeChanged" + this.aey);
    }
    bIM();
  }
  
  public void onPreThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onPreThemeChanged" + this.aey);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (aibl)a(16);
      if (paramObject != null)
      {
        if (!paramObservable.isSend()) {
          break label44;
        }
        paramObject.drS();
      }
    }
    label44:
    do
    {
      do
      {
        return;
        if (paramObservable.time > paramObject.timeStamp) {
          cgj();
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqDataExtendFriendUserInfo == null) || (this.jdField_b_of_type_ComTencentMobileqqDataExtendFriendUserInfo.enableQQCall)) {
          break;
        }
      } while (!paramObservable.senderuin.equals(this.jdField_b_of_type_ComTencentMobileqqDataExtendFriendUserInfo.uin));
      this.jdField_b_of_type_ComTencentMobileqqDataExtendFriendUserInfo.enableQQCall = true;
      cgI();
      return;
    } while ((this.jdField_b_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) || (this.sessionInfo == null) || (!paramObservable.senderuin.equals(this.sessionInfo.aTl)));
    this.ble = true;
  }
  
  public void vc(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "setSubTitleText text =" + paramString);
    }
    aibl localaibl = (aibl)a(16);
    if (localaibl != null) {
      localaibl.vc(paramString);
    }
  }
  
  public void zZ(int paramInt)
  {
    super.zZ(paramInt);
    cgC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybb
 * JD-Core Version:    0.7.0.1
 */