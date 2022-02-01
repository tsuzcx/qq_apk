import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.12;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.17;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.19;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.20;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.25;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.7;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class xys
  extends BaseChatPie
{
  acbw jdField_a_of_type_Acbw = new xyv(this);
  protected achq a;
  public ajop a;
  protected aklo a;
  private aney jdField_a_of_type_Aney = new xzj(this);
  aobo jdField_a_of_type_Aobo = new xzd(this);
  public asgx a;
  private ashx jdField_a_of_type_Ashx = new xza(this);
  wiw.a jdField_a_of_type_Wiw$a = new xze(this);
  wnz jdField_a_of_type_Wnz;
  public xrh a;
  protected yih a;
  yij jdField_a_of_type_Yij;
  String aWW = null;
  private acmc jdField_b_of_type_Acmc = new xyt(this);
  ahpp jdField_b_of_type_Ahpp = new xyy(this);
  protected BabyQAIOPanel b;
  private Observer jdField_b_of_type_JavaUtilObserver = new xyz(this);
  toa.a jdField_b_of_type_Toa$a;
  protected int bXX = 0;
  boolean bey = false;
  private boolean bkI;
  private boolean bkJ;
  private boolean bkK;
  private boolean bkL = true;
  public boolean bkM;
  public boolean bkN;
  public boolean bkO;
  boolean bkP = false;
  private boolean bkQ;
  acfd c = new xyx(this);
  private View.OnClickListener ef = new xzf(this);
  private View.OnClickListener eg = new xzg(this);
  Runnable ey = new FriendChatPie.3(this);
  private long ie = -1L;
  View.OnTouchListener s = null;
  View xn;
  
  public xys(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Aklo = new xzi(this);
    this.jdField_a_of_type_Achq = new xyu(this);
    if (paramQQAppInterface.iz(165)) {
      this.jdField_a_of_type_Asgx = ((asgx)paramQQAppInterface.getManager(165));
    }
  }
  
  private void bc(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Object localObject = this.mContext.getResources();
      int i;
      if (paramBoolean1)
      {
        i = 2130844679;
        localObject = ((Resources)localObject).getDrawable(i);
        if ((!anlm.ayn()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label130;
        }
        ((Drawable)localObject).setColorFilter(this.mActivity.getResources().getColor(2131167301), PorterDuff.Mode.MULTIPLY);
        label62:
        if (!paramBoolean1) {
          break label164;
        }
        label66:
        this.Cu.setClickable(false);
        if (!paramBoolean2) {
          break label194;
        }
        this.Cu.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        this.Cu.setCompoundDrawablePadding(rpq.dip2px(this.mContext, 4.0F));
        this.cK.setClickable(true);
        this.cK.setOnClickListener(this);
        return;
        i = 2130844686;
        break;
        label130:
        if (!ThemeUtil.isNowThemeIsNight(this.app, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label62;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label62;
        label164:
        ((Drawable)localObject).setBounds(0, 0, rpq.dip2px(this.mContext, 10.0F), rpq.dip2px(this.mContext, 10.0F));
        break label66;
        label194:
        this.Cu.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void cgd()
  {
    Object localObject = ((acff)this.app.getManager(51)).e(this.sessionInfo.aTl);
    Drawable[] arrayOfDrawable;
    if ((localObject != null) && ((aqgv.aU(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || ((!TextUtils.isEmpty(((Friends)localObject).strTermDesc)) && (((Friends)localObject).strTermDesc.contains("TIM")))))
    {
      localObject = aqgv.d((Friends)localObject);
      arrayOfDrawable = this.Cu.getCompoundDrawables();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!aqft.rj(this.sessionInfo.aTl)))
      {
        vU(true);
        this.aWW = ((String)localObject);
        vc((String)localObject);
        this.Cu.setCompoundDrawablePadding(0);
        this.Cu.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        if (aTl) {
          this.Cu.setContentDescription((CharSequence)localObject);
        }
      }
    }
    do
    {
      do
      {
        return;
        vU(false);
        this.Cu.setCompoundDrawablePadding(0);
        this.Cu.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        return;
      } while (this.Cu.getVisibility() != 0);
      vU(false);
    } while (this.jdField_a_of_type_Yjh.wN() != 5);
    yih.u(this.app, this.sessionInfo.aTl);
    this.jdField_a_of_type_Yjh.ciA();
  }
  
  private void cge()
  {
    if (this.sessionInfo.isNightMode)
    {
      this.Cu.setTextColor(a().getResources().getColor(2131167301));
      this.Cv.setTextColor(a().getResources().getColor(2131167301));
      Friends localFriends = ((acff)this.app.getManager(51)).e(this.sessionInfo.aTl);
      if ((localFriends == null) || ((aqgv.aU(localFriends.detalStatusFlag, localFriends.iTermType) == 0) && (TextUtils.isEmpty(localFriends.strTermDesc)))) {
        break label255;
      }
      vc(aqgv.d(localFriends));
      this.Cu.setCompoundDrawablePadding(wja.dp2px(2.0F, BaseApplicationImpl.getContext().getResources()));
      this.Cu.setCompoundDrawables(xva.a().o(5), null, null, null);
      anot.a(this.app, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
      this.Cu.setOnClickListener(this.ef);
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "not setOnClickListener");
      }
      vU(true);
    }
    label255:
    do
    {
      do
      {
        return;
        this.Cu.setTextColor(a().getResources().getColor(2131167302));
        this.Cv.setTextColor(a().getResources().getColor(2131167302));
        break;
      } while (this.Cu.getVisibility() != 0);
      vU(false);
    } while (this.jdField_a_of_type_Yjh.wN() != 5);
    yih.u(this.app, this.sessionInfo.aTl);
    this.jdField_a_of_type_Yjh.ciA();
  }
  
  private void cgf()
  {
    if (this.sessionInfo.isNightMode)
    {
      this.Cu.setTextColor(a().getResources().getColor(2131167301));
      this.Cv.setTextColor(a().getResources().getColor(2131167301));
      Friends localFriends = ((acff)this.app.getManager(51)).e(this.sessionInfo.aTl);
      if ((localFriends == null) || ((aqgv.aU(localFriends.detalStatusFlag, localFriends.iTermType) == 0) && (TextUtils.isEmpty(localFriends.strTermDesc)))) {
        break label192;
      }
      vc(aqgv.d(localFriends));
      this.Cu.setCompoundDrawablePadding(wja.dp2px(2.0F, BaseApplicationImpl.getContext().getResources()));
      this.Cu.setCompoundDrawables(yhv.a().r(5), null, null, null);
      vU(true);
    }
    label192:
    while (this.Cu.getVisibility() != 0)
    {
      return;
      this.Cu.setTextColor(a().getResources().getColor(2131167302));
      this.Cv.setTextColor(a().getResources().getColor(2131167302));
      break;
    }
    vU(false);
  }
  
  private void cgg()
  {
    Message localMessage = this.uiHandler.obtainMessage(85);
    if (aoij.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false))
    {
      aenw.a locala = ((aenw)aeif.a().o(551)).a(4);
      if ((locala != null) && (locala.bVh)) {
        localMessage.arg1 = 1;
      }
    }
    localMessage.sendToTarget();
  }
  
  private void cgh()
  {
    ThreadManager.post(new FriendChatPie.21(this), 5, null, false);
  }
  
  private void cgi()
  {
    if (this.bkQ) {
      return;
    }
    ((aegs)this.app.getManager(269)).Hn(this.sessionInfo.aTl);
    this.bkQ = true;
  }
  
  private void cgj()
  {
    aibl localaibl = (aibl)a(16);
    if (localaibl != null) {
      localaibl.drQ();
    }
  }
  
  private void ct(Intent paramIntent)
  {
    this.bkQ = false;
    String str = paramIntent.getStringExtra("uin");
    this.bkP = paramIntent.getBooleanExtra("open_chat_from_frd_rank_confess", false);
    aegs localaegs = (aegs)this.app.getManager(269);
    if (this.bkP)
    {
      this.bey = localaegs.c(str, paramIntent);
      return;
    }
    this.bey = localaegs.a(str, paramIntent);
  }
  
  private void gb(long paramLong)
  {
    aqxh localaqxh = (aqxh)this.app.getManager(76);
    aqxg localaqxg = localaqxh.a();
    if ((localaqxg != null) && (this.mActivity.isResume()) && (localaqxg.senderuin.equalsIgnoreCase(oL())) && (localaqxg.status == 2L) && (paramLong == localaqxg.uniseq)) {
      localaqxh.a(localaqxg, this.mActivity);
    }
  }
  
  private void v(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onUpdateSendMsgError uin " + paramString + " type " + paramInt + " uniseq " + paramLong);
    }
    MessageRecord localMessageRecord;
    boolean bool;
    if (paramInt == 0)
    {
      localMessageRecord = this.app.b().a(paramString, paramInt, paramLong);
      if ((localMessageRecord != null) && (localMessageRecord.msgtype == -2058) && ((localMessageRecord.extraflag == 32768) || (localMessageRecord.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "onUpdateSendMsgError, sticker msg is failed!");
        }
        this.app.b().b(localMessageRecord, false);
        paramString = top.u(paramString, paramInt);
        if (!EmojiStickerManager.a().fk.containsKey(paramString)) {
          break label266;
        }
        paramLong = ((Long)EmojiStickerManager.a().fk.get(paramString)).longValue();
        if (System.currentTimeMillis() - paramLong <= 300000L) {
          break label272;
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (bool)
      {
        EmojiStickerManager.a().fk.put(paramString, Long.valueOf(System.currentTimeMillis()));
        ThreadManager.getUIHandler().post(new FriendChatPie.12(this, localMessageRecord));
      }
      return;
      label266:
      bool = true;
      continue;
      label272:
      bool = false;
    }
  }
  
  public void Ib()
  {
    this.TAG = "FriendChatPie";
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
    return ChatActivityUtils.e(this.app, this.sessionInfo);
  }
  
  public void R(boolean paramBoolean, String paramString)
  {
    amey localamey = (amey)a(45);
    if ((localamey != null) && (localamey.c(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new FriendChatPie.25(this, paramString));
  }
  
  @TargetApi(16)
  public boolean Te()
  {
    Object localObject = ajnn.a(this.app, this.sessionInfo.aTl);
    if ((localObject == null) || ((((Pair)localObject).first == null) && (((Pair)localObject).second == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.mTitleIcon.setOnTouchListener(null);
      this.pt.setOnTouchListener(null);
      return false;
    }
    if (this.s == null) {
      this.s = new xzc(this);
    }
    ajoh localajoh = (ajoh)((Pair)localObject).first;
    localObject = (ajoh)((Pair)localObject).second;
    if (localajoh != null)
    {
      VipUtils.a(this.sessionInfo.aTl, localajoh, this.app, "C2C_show");
      this.mTitleIcon.setTag(localajoh);
      this.mTitleIcon.setOnTouchListener(this.s);
      if (localObject == null) {
        break label259;
      }
      VipUtils.a(this.sessionInfo.aTl, (ajoh)localObject, this.app, "C2C_show");
      this.pt.setTag(localObject);
      this.pt.setOnTouchListener(this.s);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localajoh, (ajoh)localObject);
      ajnk.a(this.app, this.sessionInfo.aTl, localajoh, (ajoh)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "updateSession_updateInteractive one:" + localajoh + " two:" + localObject);
      }
      return true;
      this.mTitleIcon.setOnTouchListener(null);
      break;
      label259:
      this.pt.setOnTouchListener(null);
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 29)
    {
      long l = System.currentTimeMillis();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel = ((BabyQAIOPanel)View.inflate(this.mContext, 2131558637, null));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "openBabyQPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel;
    }
    return super.a(paramInt);
  }
  
  public EntryModel a()
  {
    if (this.sessionInfo.cZ == 0) {
      return new EntryModel(0, Long.parseLong(this.sessionInfo.aTl), this.sessionInfo.aTn, false);
    }
    return super.a();
  }
  
  public QQRecorder.RecorderParam a()
  {
    if (this.sessionInfo.cZ == 0)
    {
      boolean bool = super.Pc();
      return aqlv.a(this.app, bool);
    }
    return new QQRecorder.RecorderParam(aqlv.dZQ, 0, 0);
  }
  
  public wsr a()
  {
    return null;
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, Runnable paramRunnable)
  {
    if (!aqiw.isNetworkAvailable(this.mActivity))
    {
      QQToast.a(this.mActivity, 2131699442, 0).show(this.mActivity.getTitleBarHeight());
      if (paramInt2 == 1) {
        xmb.a(this.app, null, "0X800A36B");
      }
    }
    do
    {
      return;
      if (yfp.a(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong2, paramLong1) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "refreshHeadMessage==> db is find! origUid" + paramLong1 + ", time" + paramLong2);
        }
        this.jdField_b_of_type_Toa$a.f(paramLong1, paramLong2, false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, paramRunnable, 10);
        return;
      }
      QQToast.a(this.mActivity, 2131699910, 0).show(this.mActivity.getTitleBarHeight());
    } while (paramInt2 != 1);
    xmb.a(this.app, null, "0X800A36B");
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, MessageRecord paramMessageRecord)
  {
    a(paramInt, paramLong1, paramLong2, paramMessageRecord, 0, 0);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, MessageRecord paramMessageRecord, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "refreshHeadMessage==>type:" + paramInt1 + "|origUid:" + paramLong1);
    }
    paramMessageRecord = new FriendChatPie.17(this);
    boolean bool = u(paramLong1, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.YN(paramInt2);
    if (!bool)
    {
      a(paramInt1, paramLong1, paramLong2, paramInt3, paramMessageRecord);
      return;
    }
    d(paramInt1, paramLong1, paramLong2, paramInt3);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showAddFriendActivity-->uinType=" + paramInt1 + " peerUin=" + paramString1 + " name=" + paramString2 + " phoneNum=" + paramString3 + " srcId=" + paramInt2);
    }
  }
  
  public void a(afmi paramafmi)
  {
    super.a(paramafmi);
    if (this.bkI)
    {
      yfn.a(this.app, this.mActivity, this.sessionInfo, this.bkI);
      this.bkI = false;
    }
    if (this.bkK)
    {
      this.bkK = false;
      this.app.reportClickEvent("CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "FriendChatPie onViewCompleteVisableAndReleased");
    }
    if (((this.jdField_a_of_type_Wki != null) && (this.jdField_a_of_type_Wki.getCount() > 0)) || (!aqft.rj(this.sessionInfo.aTl)))
    {
      if (this.jdField_b_of_type_Toa$a.valid)
      {
        this.Fp = SystemClock.uptimeMillis();
        ((wkk)this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.context).fU(this.Fp);
        this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = true;
        this.app.b().a().a(this.sessionInfo.aTl, this.sessionInfo.cZ, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b, this.jdField_b_of_type_Toa$a, this.mActivity);
        this.jdField_b_of_type_Toa$a.valid = false;
        return true;
      }
      super.a(paramInt, paramView, paramListView);
      return true;
    }
    vY(false);
    return true;
  }
  
  protected void aE(Object paramObject)
  {
    if (((paramObject instanceof MessageForStructing)) && (((MessageForStructing)paramObject).isread))
    {
      paramObject = (MessageForStructing)paramObject;
      if ((paramObject.structingMsg == null) || (paramObject.structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(paramObject.structingMsg.mResid)) || (!((aqxh)this.app.getManager(76)).f(paramObject))) {}
    }
  }
  
  protected void aF(Object paramObject)
  {
    aibl localaibl;
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      localaibl = (aibl)a(16);
      if (localaibl != null)
      {
        if (!paramObject.isSend()) {
          break label38;
        }
        localaibl.drS();
      }
    }
    label38:
    while (paramObject.time <= localaibl.timeStamp) {
      return;
    }
    cgj();
  }
  
  protected void aG(Object paramObject)
  {
    if ((paramObject instanceof MessageForText))
    {
      paramObject = (MessageForText)paramObject;
      String str = paramObject.msg;
      if (paramObject.frienduin.equals(this.sessionInfo.aTl))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in FriendChatPie.update()");
        }
        aquv.a().a(this.app, this.sessionInfo, paramObject, str, this.mContext, paramObject.isSend());
      }
    }
  }
  
  public boolean af(boolean paramBoolean)
  {
    Intent localIntent = this.mActivity.getIntent();
    String str = localIntent.getStringExtra("PREVIOUS_WINDOW");
    if ((str != null) && (str.equals(FriendProfileCardActivity.class.getName()))) {
      this.ie = NetConnInfoCenter.getServerTime();
    }
    this.bkM = true;
    if (localIntent.getBooleanExtra("open_chat_from_avator", false))
    {
      str = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "upload avator " + str);
      }
      if (str != null)
      {
        if (!aqep.a(this.app, str, localIntent)) {
          break label285;
        }
        QQToast.a(a(), 2, 2131719574, 0).show(getTitleBarHeight());
        if (aqft.rj(this.sessionInfo.aTl)) {
          ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
        }
        anot.a(this.app, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.bey = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
      if (this.bey) {
        ct(localIntent);
      }
      this.sessionInfo.bey = this.bey;
      this.jdField_b_of_type_Toa$a = new toa.a();
      this.jdField_a_of_type_Wnz = new won(a());
      localIntent.getStringExtra("uin");
      this.jdField_a_of_type_Ajop = new ajop(this.app);
      return super.af(paramBoolean);
      label285:
      QQToast.a(a(), 1, 2131719573, 0).show(getTitleBarHeight());
    }
  }
  
  public void bFq()
  {
    if (((aiqi)a(32)).apu()) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "updateOnlineStatus, isListenTogetherTime");
      }
    }
    do
    {
      return;
      if (!((wxc)a(43)).Sl()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.TAG, 2, "updateOnlineStatus, isTogetherTime");
    return;
    if ((this.sessionInfo.beq) && (this.sessionInfo.beu))
    {
      cge();
      return;
    }
    if ((this.sessionInfo.ber) && (this.sessionInfo.bet))
    {
      cgf();
      return;
    }
    this.Cu.setTextColor(a().getResources().getColor(2131167301));
    this.Cv.setTextColor(a().getResources().getColor(2131167301));
    this.Cu.setCompoundDrawables(null, null, null, null);
    if ((aqqb.a().aFv()) || (akti.a().M(this.app, this.sessionInfo.aTl))) {
      this.Cu.setOnClickListener(this.eg);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "setOnClickListener");
      }
      if ((!this.aSd) || ((this.jdField_a_of_type_Asgx != null) && (this.jdField_a_of_type_Asgx.sH(this.sessionInfo.aTl))) || (OU())) {
        break;
      }
      cgd();
      return;
      this.Cu.setOnClickListener(null);
    }
  }
  
  public void bGJ()
  {
    super.bGJ();
    this.aSc = false;
    this.aSd = true;
    xmj.Jd = 0L;
    if (this.jdField_a_of_type_Wiw != null) {
      this.jdField_a_of_type_Wiw.a(this.jdField_a_of_type_Wiw$a);
    }
  }
  
  public void bGK()
  {
    super.bGK();
    if (this.jdField_a_of_type_Yir == null) {
      this.jdField_a_of_type_Yir = new yir(this.app, this.jdField_a_of_type_Yjh, this.sessionInfo, this.mActivity);
    }
    this.jdField_a_of_type_Yij = new yij(this.app, this.jdField_a_of_type_Yjh, this.mActivity, this.sessionInfo);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yir);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yij);
  }
  
  public void bGR()
  {
    if ((this.jdField_a_of_type_Asgx != null) && (this.jdField_a_of_type_Asgx.Q(this.sessionInfo.aTl, false))) {
      this.aSc = true;
    }
    bFq();
  }
  
  public void bGT()
  {
    int i;
    if ((!aqft.rj(this.sessionInfo.aTl)) && (!this.app.getCurrentUin().equals(this.sessionInfo.aTl))) {
      i = 1;
    }
    while (i != 0)
    {
      this.ps.setOnClickListener(new xzh(this));
      if (ixa.a().cD(this.app.getCurrentAccountUin()))
      {
        this.ps.setVisibility(0);
        this.ps.setContentDescription(this.mActivity.getResources().getString(2131700698));
        return;
        i = 0;
      }
      else
      {
        this.ps.setVisibility(8);
        return;
      }
    }
    this.ps.setVisibility(4);
    ThreadManager.post(new FriendChatPie.7(this), 5, null, false);
  }
  
  public void bGW()
  {
    bIY();
  }
  
  public void bHM()
  {
    aqmq.track(null, "AIO_onShow_business");
    super.bHM();
    ujt.b(this.app, this.mActivity, this.sessionInfo);
    this.bkJ = this.mActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.bkI = yfn.a(this.app, this.sessionInfo, this.mActivity.getIntent());
    aqmq.track("AIO_onShow_business", null);
    if ((this.sessionInfo.cZ == 1024) && (!jqs.c(this.app, this.app.getCurrentAccountUin(), this.sessionInfo.cZ))) {}
  }
  
  public void bHP()
  {
    boolean bool1;
    if ((!this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.ZY()) && (!this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.ZZ())) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      String str;
      if (!bool1)
      {
        bool2 = aqqb.a().rC(this.sessionInfo.aTl);
        if (QLog.isDevelopLevel())
        {
          QLog.d("CustomOnlineStatusManager", 4, "not update friend online info\nisGetOnlineListRecently = " + this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.ZY() + "\nshouldGetOnlineInfo = " + this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.ZZ());
          StringBuilder localStringBuilder = new StringBuilder();
          if (!bool2) {
            break label225;
          }
          str = "need update online status";
          QLog.d("CustomOnlineStatusManager", 4, str + " for " + this.sessionInfo.aTl);
        }
      }
      if (bool2) {}
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.bE(this.sessionInfo.aTl, false);
        if (this.bkL)
        {
          this.bkL = false;
          ThreadManager.post(this.ey, 8, null, true);
        }
        super.bHP();
        ((ysf)this.app.getManager(34)).ig(this.sessionInfo.aTl);
        cgg();
        return;
        bool1 = false;
        continue;
        label225:
        str = "not need update online status";
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "friendchatpie onShow_otherThings, " + localNumberFormatException.toString());
          }
        }
      }
    }
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addDefaultObservers(this.jdField_a_of_type_Achq);
    this.app.addObserver(this.jdField_b_of_type_Acmc);
    this.app.addObserver(this.c);
    this.app.addObserver(this.jdField_b_of_type_Ahpp);
    this.app.registObserver(this.jdField_a_of_type_Aney);
    this.app.registObserver(this.jdField_a_of_type_Aklo);
    this.app.addObserver(this.jdField_a_of_type_Ashx);
    ((ahvn)this.app.getManager(156)).a().addObserver(this.jdField_b_of_type_JavaUtilObserver);
    this.app.addObserver(this.jdField_a_of_type_Acbw);
    this.app.addObserver(this.jdField_a_of_type_Aobo);
  }
  
  public void bHt()
  {
    super.bHt();
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.TQ(true);
    if (this.jdField_a_of_type_Wnz != null) {
      this.jdField_a_of_type_Wnz.doOnResume();
    }
  }
  
  public void bIH()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "==refreshTitleReativeIcon==");
    }
    Te();
  }
  
  public void bIM()
  {
    super.bIM();
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
    this.app.removeObserver(this.c);
    this.app.removeObserver(this.jdField_b_of_type_Ahpp);
    if (this.jdField_a_of_type_Aney != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_Aney);
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Aklo);
    this.app.removeObserver(this.jdField_b_of_type_Acmc);
    this.app.removeObserver(this.jdField_a_of_type_Ashx);
    ((ahvn)this.app.getManager(156)).a().deleteObserver(this.jdField_b_of_type_JavaUtilObserver);
    this.app.removeObserver(this.jdField_a_of_type_Acbw);
    this.app.removeObserver(this.jdField_a_of_type_Aobo);
  }
  
  public void bJd()
  {
    super.bJd();
    Object localObject1 = "";
    Object localObject2 = aqep.a(this.app, this.sessionInfo.aTl);
    if (localObject2 != null) {
      localObject1 = ((Card)localObject2).strReMark;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(this.mContext);
      localObject2 = this.app.getCurrentAccountUin() + "-" + this.sessionInfo.aTl + "-grayTipsRemarkMention";
      if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, false))
      {
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, true).apply();
        FriendsStatusUtil.T(this.app, this.sessionInfo.aTl);
      }
    }
  }
  
  public void bJf()
  {
    super.bJf();
    this.jdField_a_of_type_Wvm.a(this);
  }
  
  public void bn(Intent paramIntent)
  {
    super.bn(paramIntent);
    long l1 = System.currentTimeMillis();
    if ((this.sessionInfo.beq) && (this.sessionInfo.bes) && (!this.sessionInfo.isNightMode))
    {
      anot.a(this.app, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(xva.a().n(2130851105));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130851146);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.YW(2130851762);
      if (this.rA != null)
      {
        this.rA.setVisibility(0);
        this.rA.setBackgroundDrawable(xva.a().o(2));
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("shinkencai", 2, "set title time:" + (l2 - l1));
      return;
      this.rA = this.B.inflate();
      this.rA.setBackgroundDrawable(xva.a().o(2));
      continue;
      if ((this.sessionInfo.ber) && (this.sessionInfo.bet) && (!this.sessionInfo.isNightMode))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(yhv.a().q(2130851105));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130851146);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.YW(2130851762);
        if (this.rB != null)
        {
          this.rB.setVisibility(0);
          this.rB.setBackgroundDrawable(yhv.a().r(2));
        }
        else
        {
          this.rB = this.B.inflate();
          this.rB.setBackgroundDrawable(yhv.a().r(2));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130851105);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130851145, 2130851146);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.kD(2130851761, 2130851762);
        if (this.B != null) {
          this.B.setVisibility(8);
        }
        if (this.rA != null) {
          this.rA.setVisibility(8);
        }
        if (this.rB != null) {
          this.rB.setVisibility(8);
        }
      }
    }
  }
  
  public void bo(Intent paramIntent)
  {
    super.bo(paramIntent);
    this.mTitleText.setOnClickListener(new xzb(this));
  }
  
  public void br(Intent paramIntent)
  {
    super.br(paramIntent);
    if (!aqft.rj(this.sessionInfo.aTl)) {
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.a = new yfq(this.app, this.mActivity, this.sessionInfo.aTl);
    }
    if ((this.jdField_a_of_type_Asgx != null) && (this.jdField_a_of_type_Asgx.oU.containsKey(this.sessionInfo.aTl))) {
      this.jdField_a_of_type_Asgx.dI(this.sessionInfo.aTl, true);
    }
    if ((this.jdField_a_of_type_Asgx != null) && (this.jdField_a_of_type_Asgx.sH(this.sessionInfo.aTl)))
    {
      jqs.c(this.app, this.mContext, this.app.getCurrentAccountUin(), this.sessionInfo.aTl);
      ((FriendListHandler)this.app.getBusinessHandler(1)).DG(this.sessionInfo.aTl);
    }
    ThreadManager.post(new FriendChatPie.19(this), 5, null, false);
  }
  
  public void bs(Intent paramIntent)
  {
    super.bs(paramIntent);
    this.bkO = false;
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    this.aQ.setVisibility(0);
  }
  
  public void ccU()
  {
    if ((this.pv == null) || (this.Cu == null) || (this.cK == null) || (this.mTitleText == null) || (this.Cv == null)) {}
    for (;;)
    {
      return;
      Object localObject = (aiqi)a(32);
      boolean bool1 = ((aiqi)localObject).apu();
      boolean bool2 = ((aiqi)localObject).Si();
      wxc localwxc = (wxc)a(43);
      boolean bool3 = localwxc.Sl();
      int i;
      if (bool1)
      {
        this.bXX = 1;
        vU(true);
        vc(((aiqi)localObject).u(bool2));
        bc(bool2, false);
        i = wja.dp2px(8.0F, this.Cu.getResources());
        aiqd.i(this.cK, 0, i, 0, 0);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseListenTogetherPanel_C2C", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
        return;
        if (bool3)
        {
          this.bXX = 2;
          vU(true);
          bool3 = localwxc.Si();
          vc(localwxc.pr());
          this.Cu.setTextColor(this.mActivity.getResources().getColor(2131167301));
          bc(bool3, localwxc.Sm());
          localObject = (amey)a(45);
          i = wja.dp2px(8.0F, this.Cu.getResources());
          aiqd.i(this.cK, 0, i, 0, 0);
        }
        else
        {
          this.pv.setVisibility(8);
          this.Cu.setClickable(true);
          this.cK.setClickable(false);
          this.cK.setOnClickListener(null);
          aiqd.gX(this.cK);
          this.bXX = 0;
          vc("");
          bFq();
          localObject = (amey)a(45);
          if (localObject != null) {
            ((amey)localObject).Pz("");
          }
        }
      }
    }
  }
  
  public void ccZ()
  {
    if (this.jdField_a_of_type_Xrh == null) {
      this.jdField_a_of_type_Xrh = new xrh(this, this.app, this.mContext, this.sessionInfo, this.fs);
    }
    this.jdField_a_of_type_Xrh.Dq(1);
    this.jdField_a_of_type_Xrh.refresh();
  }
  
  public void cgk()
  {
    Object localObject = aqep.a(this.app, this.sessionInfo.aTl);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.sessionInfo.aTl, 8);
    localAllInOne.nickname = aqgv.s(this.app, this.sessionInfo.aTl);
    if ((TextUtils.isEmpty(localAllInOne.nickname)) || (localAllInOne.nickname.equals(this.sessionInfo.aTl))) {
      localAllInOne.nickname = this.sessionInfo.aTn;
    }
    localAllInOne.aOF = this.sessionInfo.aTl;
    localAllInOne.bIX = this.sessionInfo.cZ;
    localAllInOne.bIZ = 2;
    localAllInOne.bJa = 117;
    alcn localalcn = new alcn();
    localalcn.d = ((Card)localObject);
    localalcn.e = localAllInOne;
    localObject = adzx.a(this.app, localalcn);
    aqep.a(a(), (BusinessCard)localObject, localAllInOne);
  }
  
  protected void d(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "refreshHeadMessage==> aio cache is find! origUid" + paramLong1 + ", time" + paramLong2);
    }
    List localList = this.app.b().d(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong2, paramLong1);
    int i;
    MessageRecord localMessageRecord;
    if ((localList != null) && (localList.size() > 0))
    {
      i = 0;
      if (i >= localList.size()) {
        break label286;
      }
      localMessageRecord = (MessageRecord)localList.get(i);
      if ((top.t(localMessageRecord)) || ((localMessageRecord instanceof MessageForSafeGrayTips))) {
        break label183;
      }
    }
    for (;;)
    {
      if ((localMessageRecord != null) && (!ahwb.aB(localMessageRecord)))
      {
        i = this.jdField_a_of_type_Wki.K(localMessageRecord.uniseq);
        if (i != -1) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, i, i, null, 10);
        }
      }
      label183:
      do
      {
        do
        {
          return;
          i += 1;
          break;
          if (localMessageRecord.msgtype == -2006) {
            QQToast.a(this.mActivity, acfp.m(2131706571), 0).show(this.mActivity.getTitleBarHeight());
          }
        } while (paramInt2 != 1);
        xmb.a(this.app, null, "0X800A36B");
        return;
        QQToast.a(this.mActivity, 2131699910, 0).show(this.mActivity.getTitleBarHeight());
      } while (paramInt2 != 1);
      xmb.a(this.app, null, "0X800A36B");
      return;
      label286:
      localMessageRecord = null;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (avsq.a(this, paramInt1, paramInt2, paramIntent)) {}
    for (;;)
    {
      return;
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt1 == 13008) {
        if (paramIntent != null)
        {
          String str = paramIntent.getStringExtra("result");
          Object localObject = str;
          if (str == null) {
            localObject = "";
          }
          if (!aqiw.isNetSupport(BaseApplication.getContext())) {
            break label168;
          }
          if (this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler == null) {
            break label142;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.C(this.sessionInfo.aTl, (String)localObject, false);
          localObject = new awcy.a();
          ((awcy.a)localObject).cmd = 5;
          awcy.a(this.sessionInfo.aTl).a((awcy.a)localObject);
        }
      }
      while (this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.a != null)
      {
        ((yfq)this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.a).onActivityResult(paramInt1, paramInt2, paramIntent);
        return;
        label142:
        new arie(this.mContext).V(2131694914, getTitleBarHeight(), 0, 1);
        continue;
        label168:
        new arie(this.mContext).V(2131696346, getTitleBarHeight(), 0, 1);
        continue;
        if (paramInt1 != 13009) {}
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.ie > 0L) {
      ThreadManager.getSubThreadHandler().post(new FriendChatPie.2(this));
    }
    if (this.aSY) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.TQ(false);
      }
      if (this.bey) {
        cgi();
      }
      if (!TextUtils.isEmpty(this.sessionInfo.aTl))
      {
        top.b(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, -4021);
        top.b(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, -4022);
      }
      if (aqft.rj(this.sessionInfo.aTl)) {
        ((acbs)this.app.getBusinessHandler(53)).cGZ();
      }
      this.bkM = false;
      super.doOnDestroy();
      if ((this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b != null) && (this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.a != null))
      {
        ((yfq)this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.a).onDestroy();
        this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.a = null;
      }
      if ((this.sessionInfo != null) && (this.sessionInfo.a != null) && (this.sessionInfo.a.img != null))
      {
        this.sessionInfo.a.img.setCallback(null);
        this.sessionInfo.a.img = null;
      }
      if (this.jdField_a_of_type_Yir != null) {
        this.jdField_a_of_type_Yir = null;
      }
      if (this.jdField_a_of_type_Wnz != null) {
        this.jdField_a_of_type_Wnz.doOnDestroy();
      }
      this.bkK = false;
      ((plz)this.app.getManager(253)).blN();
      if (this.ps != null) {
        this.ps.setOnClickListener(null);
      }
      if (this.jdField_a_of_type_Xrh != null) {
        this.jdField_a_of_type_Xrh.onDestroy();
      }
    } while (this.jdField_a_of_type_Wiw == null);
    this.jdField_a_of_type_Wiw.a(null);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Wnz != null) {
      this.jdField_a_of_type_Wnz.doOnPause();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (aqft.rj(this.sessionInfo.aTl)) {
      ((acbs)this.app.getBusinessHandler(53)).cHa();
    }
  }
  
  public void ex(View paramView)
  {
    if (paramView.getId() == 2131378923)
    {
      if (this.bXX == 1) {
        ((aiqi)a(32)).dtG();
      }
      while (this.bXX != 2) {
        return;
      }
      ((wxc)a(43)).xM(this.sessionInfo.aTl);
      return;
    }
    super.ex(paramView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.handleMessage(paramMessage);
    case 70: 
      if (this.jdField_a_of_type_Wnz != null)
      {
        this.jdField_a_of_type_Wnz.gq(1);
        return true;
      }
      break;
    case 88: 
      if (this.jdField_a_of_type_Wnz != null)
      {
        this.jdField_a_of_type_Wnz.gq(2);
        return true;
      }
      break;
    case 85: 
      int i = paramMessage.arg1;
      paramMessage = this.px;
      if (i == 0) {}
      for (i = 8;; i = 0)
      {
        paramMessage.setVisibility(i);
        return true;
      }
    case 201: 
      if ((this.jdField_a_of_type_Wnz != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
      {
        paramMessage = (String[])paramMessage.obj;
        if (paramMessage.length >= 2) {
          this.jdField_a_of_type_Wnz.d(3, paramMessage[0], paramMessage[1]);
        }
        return true;
      }
      break;
    }
    return true;
  }
  
  public void k(Object paramObject)
  {
    super.k(paramObject);
    int i = ((Integer)paramObject).intValue();
    if (i == 29)
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(29);
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.bYN();
      }
      anot.a(this.app, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
    }
    do
    {
      do
      {
        return;
      } while (i != 8);
      paramObject = ((aenw)aeif.a().o(551)).a(4);
    } while ((paramObject == null) || (paramObject.appId <= 0));
    if (paramObject.version == 1) {}
    for (i = 1109995692;; i = paramObject.appId)
    {
      ((aigv)this.app.getManager(348)).e(Long.parseLong(this.sessionInfo.aTl), i, true);
      return;
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.bkJ) && (this.mActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (yfn.a(this.app, this.mActivity, this.sessionInfo))) {
      return true;
    }
    if (this.bey) {
      cgi();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    aenw.a locala;
    if (paramView.getId() == 2131369594)
    {
      locala = ((aenw)aeif.a().o(551)).a(4);
      if ((locala != null) && (locala.appId > 0))
      {
        if (locala.version != 1) {
          break label109;
        }
        ((aigv)this.app.getManager(348)).e(Long.parseLong(this.sessionInfo.aTl), locala.appId, true);
      }
      if ((this.px != null) && (this.px.getVisibility() == 0)) {
        break label117;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label109:
      int i = locala.appId;
      break;
      label117:
      if ((aoij.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) && (locala != null) && (locala.bVh)) {
        aoij.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
      }
    }
  }
  
  public void send()
  {
    super.send();
    if (this.bkI)
    {
      yfn.a(this.app, this.mActivity, this.sessionInfo, this.bkI);
      this.bkI = false;
    }
    if (this.bkK)
    {
      this.bkK = false;
      this.app.reportClickEvent("CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
    anpc.report("tim_msg_tab_c2c_aio_send_msg");
  }
  
  protected boolean u(long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_Wki.getList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      ChatMessage localChatMessage;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
      } while ((top.t(localChatMessage)) || (localChatMessage.msgUid != paramLong1) || (localChatMessage.time != paramLong2));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "refreshHeadMessage==>isFind:" + bool);
      }
      return bool;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageForPokeEmo))
    {
      localObject = (MessageForPokeEmo)paramObject;
      if ((((MessageForPokeEmo)localObject).frienduin.equals(this.sessionInfo.aTl)) && (((MessageForPokeEmo)localObject).isread)) {
        ((MessageForPokeEmo)localObject).setIsNeedPlayed(true);
      }
    }
    aE(paramObject);
    if (((paramObject instanceof ChatMessage)) && (mc()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.sessionInfo.aTl)) && (this.bkN)) {
        ajoo.b(this.app, this.sessionInfo, this);
      }
    }
    super.update(paramObservable, paramObject);
    aG(paramObject);
    ujt.a(this, this.app, this.sessionInfo, false);
    aF(paramObject);
  }
  
  public void vW(boolean paramBoolean)
  {
    if ((this.bkJ) && (this.mActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (yfn.a(this.app, this.mActivity, this.sessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.bey) {
      cgi();
    }
    super.vW(paramBoolean);
  }
  
  public void vc(String paramString)
  {
    aibl localaibl = (aibl)a(16);
    if (localaibl != null) {
      localaibl.vc(paramString);
    }
  }
  
  public void zZ(int paramInt)
  {
    super.zZ(paramInt);
    if (jou.df(this.sessionInfo.aTl)) {
      this.jdField_a_of_type_Asgx = ((asgx)this.app.getManager(165));
    }
    ajoo.a(this.app, this.sessionInfo, this);
    cgh();
    if (aqft.rj(this.sessionInfo.aTl))
    {
      localObject = (acbs)this.app.getBusinessHandler(53);
      if ((localObject != null) && (((acbs)localObject).O(this.mContext, this.app.getCurrentAccountUin())))
      {
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(29);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.bYN();
        ((acbs)localObject).c(this.mContext, this.app.getCurrentAccountUin(), false);
      }
    }
    if (((this instanceof xwq)) || (jou.df(this.sessionInfo.aTl)))
    {
      bIr();
      if (this.jdField_a_of_type_Asgx != null) {
        break label238;
      }
    }
    label238:
    for (Object localObject = "";; localObject = this.jdField_a_of_type_Asgx.qW(this.sessionInfo.aTl))
    {
      anot.a(this.app, "dc00899", "Qidian", this.sessionInfo.aTl, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "3.4.4", "");
      ThreadManager.post(new FriendChatPie.20(this), 5, null, true);
      ccZ();
      amim.b(this, this.mActivity.getIntent());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xys
 * JD-Core Version:    0.7.0.1
 */