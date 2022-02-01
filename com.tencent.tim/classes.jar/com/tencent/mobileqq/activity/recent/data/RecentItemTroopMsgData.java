package com.tencent.mobileqq.activity.recent.data;

import aale;
import aalj;
import aalo;
import aalt;
import aalu;
import aalv;
import aalx;
import aaly;
import aalz;
import aama;
import aamb;
import aamc;
import acfp;
import acqh;
import alkm;
import alkm.a;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import anot;
import aofe;
import aofk;
import aofy;
import apmb;
import apmc;
import apnu;
import aptq;
import aptr;
import apuh;
import apuk;
import aqgv;
import aqpm;
import awke;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import jof;
import tog;
import wvo;

public class RecentItemTroopMsgData
  extends RecentUserBaseData
{
  public static final String STR_TOPIC = "[topic]";
  private static final String TAG = "RecentItemTroopMsgData";
  private boolean hasTroopOrg;
  public boolean isForceSetUnreadNumRed;
  public boolean mContainsKeyword;
  protected int mGroupNotify;
  public long mTroopCreditLevel = 5L;
  public String troopHonorStr;
  
  public RecentItemTroopMsgData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  private String a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage, TroopInfo paramTroopInfo, String paramString1, String paramString2)
  {
    int i = this.mMenuFlag;
    if (paramTroopInfo != null)
    {
      paramString1 = paramTroopInfo.getTroopName();
      paramString2 = paramTroopInfo.troopmemo;
    }
    this.mMenuFlag = (i & 0xFFFFF0FF | 0x100);
    i = paramQQAppInterface.cs(this.mUser.uin);
    boolean bool;
    if ((i == 1) || (this.isForceSetUnreadNumRed))
    {
      this.mUnreadFlag = 1;
      bool = wvo.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface);
      if ((!bool) || (acqh.e(paramQQAppInterface.getCurrentUin(), paramContext))) {
        break label332;
      }
      this.mUnreadFlag = 0;
      label111:
      if (!TextUtils.isEmpty(paramString1)) {
        break label345;
      }
      this.mTitleName = aqgv.a(paramQQAppInterface, this.mUser.uin, true);
    }
    for (this.mTitleName_cs = new aofe(aqgv.a(paramQQAppInterface, this.mUser.uin, true), 16).k();; this.mTitleName_cs = new aofe(paramString1, 16).k())
    {
      if ((paramMessage != null) && (TextUtils.isEmpty(paramMessage.nickName))) {
        paramMessage.nickName = paramMessage.senderuin;
      }
      cvo();
      if ((paramTroopInfo == null) || (paramTroopInfo.hasSetTroopName()) || (paramTroopInfo.wMemberNumClient <= 0)) {
        break label372;
      }
      this.mExtraInfo = ("(" + paramTroopInfo.wMemberNumClient + ")");
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemTroopMsgData", 2, "update wMemberNumClient:" + paramTroopInfo.wMemberNumClient + "  wMemberNum:" + paramTroopInfo.wMemberNum + " troopUin:" + paramTroopInfo.troopuin);
      }
      return paramString2;
      if ((i != 2) && (i != 3) && (i != 4)) {
        break;
      }
      this.mUnreadFlag = 3;
      break;
      label332:
      if (!bool) {
        break label111;
      }
      this.mUnreadFlag = 3;
      break label111;
      label345:
      this.mTitleName = paramString1;
    }
    label372:
    this.mExtraInfo = "";
    return paramString2;
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage)
  {
    String str;
    if ((paramMessage != null) && (paramMessage.msgtype == -2025) && (this.mUnreadNum > 0))
    {
      str = paramContext.getString(2131694637);
      if ((!TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(str)))
      {
        if (paramMessage.bizType > 0) {
          break label176;
        }
        if ((!TextUtils.isEmpty(this.mMsgExtroInfo)) && (this.mMsgExtroInfo.equals(paramContext.getString(2131719507)))) {
          this.mMsgExtroInfo = "";
        }
        if ((!TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(str)))
        {
          if (this.mExtraInfoColor == 0) {
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
          }
          if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
            break label211;
          }
        }
      }
    }
    label176:
    label211:
    for (paramContext = str;; paramContext = this.mMsgExtroInfo + str)
    {
      this.mMsgExtroInfo = paramContext;
      this.mLastMsg = this.mLastMsg.toString().replace(str, "");
      return;
      if ((TextUtils.isEmpty(this.mMsgExtroInfo)) || (!this.mMsgExtroInfo.equals(paramContext.getString(2131719507)))) {
        break;
      }
      this.mLastMsg = "";
      break;
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    SpannableString localSpannableString;
    Object localObject;
    if ((paramMsgSummary.nState == 0) && ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix))))
    {
      localSpannableString = null;
      if (TextUtils.isEmpty(paramMsgSummary.strContent)) {
        break label224;
      }
      String str = paramMsgSummary.strContent.toString();
      localObject = str;
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix))
      {
        localObject = str;
        if (TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0)
        {
          if (paramMsgSummary.strContent.length() <= paramMsgSummary.strPrefix.length() + 2) {
            break label218;
          }
          localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new aofe(paramMsgSummary.strPrefix, 16).k();
      }
      paramMessage = aqpm.a((String)localObject, paramMessage, 16, 3);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
      paramMsgSummary.strContent = new aofk((CharSequence)localObject, 3, 16);
      return;
      label218:
      localObject = "";
      continue;
      label224:
      localObject = paramMsgSummary.suffix.toString();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage != null)
    {
      this.mDisplayTime = paramMessage.time;
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mUser.opTime;
      }
      tog localtog = paramQQAppInterface.a();
      if (localtog != null) {}
      for (this.mUnreadNum = localtog.A(paramMessage.frienduin, this.mUser.getType());; this.mUnreadNum = 0)
      {
        paramQQAppInterface = alkm.a(paramQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
        this.mUnreadNum += paramQQAppInterface.HF();
        if (paramQQAppInterface.HF() > 0) {
          this.mMsgExtroInfo = "";
        }
        return;
      }
    }
    this.mDisplayTime = this.mUser.opTime;
    this.mUnreadNum = 0;
  }
  
  private void bL(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder;
    if (AppSetting.enableTalkBack)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName).append(",");
      if (this.mUnreadNum != 0) {
        break label130;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        localStringBuilder.append(this.mMsgExtroInfo + ",");
      }
      localStringBuilder.append(aofy.og(this.mLastMsg.toString())).append(",").append(this.mShowTime);
      localStringBuilder.append(apmc.i(paramQQAppInterface, this.mUser.uin, paramQQAppInterface.getCurrentAccountUin()));
      this.mContentDesc = localStringBuilder.toString();
      return;
      label130:
      if (this.mUnreadNum == 1) {
        localStringBuilder.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append("有").append(this.mUnreadNum).append("条未读,");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.bShowDraft = false;
          paramMsgSummary.mDraft = null;
        } while (this.mDisplayTime > eJ());
        paramQQAppInterface = paramQQAppInterface.b();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(qx(), ng());
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.mDisplayTime = paramQQAppInterface.getTime();
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = aqpm.a(paramQQAppInterface.getSummary(), paramQQAppInterface.getAtInfoStr(), 16, null, 3);
  }
  
  public void bI(QQAppInterface paramQQAppInterface)
  {
    super.bI(paramQQAppInterface);
    try
    {
      l = Long.parseLong(qx());
      this.mIsGroupVideo = paramQQAppInterface.a().au(l);
      boolean bool = this.mIsGroupVideoNotify;
      this.mIsGroupVideoNotify = paramQQAppInterface.a().at(l);
      Object localObject;
      if (this.mIsGroupVideoNotify)
      {
        localObject = (apuk)paramQQAppInterface.getManager(164);
        if ((localObject != null) && (((apuk)localObject).eV(qx()) == 2)) {
          this.mIsGroupVideoNotify = false;
        }
      }
      if ((this.mIsGroupVideoNotify) && (!bool))
      {
        localObject = String.valueOf(l);
        anot.a(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, "" + apuh.n(paramQQAppInterface, (String)localObject), "", "");
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    Object localObject1 = paramQQAppInterface.b();
    QQMessageFacade.Message localMessage = null;
    Object localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = null;
    if (localObject2 != null) {
      localTroopInfo = ((TroopManager)localObject2).a(this.mUser.uin, true);
    }
    if (localObject1 != null) {
      localMessage = ((QQMessageFacade)localObject1).a(this.mUser.uin, this.mUser.getType());
    }
    a(paramQQAppInterface, localMessage);
    localObject1 = (HotChatManager)paramQQAppInterface.getManager(60);
    localObject2 = ((HotChatManager)localObject1).a(this.mUser.uin);
    label135:
    boolean bool;
    if (localObject2 != null)
    {
      this.mUnreadFlag = 3;
      this.mTitleName = ((HotChatInfo)localObject2).name;
      localObject2 = new MsgSummary();
      a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      a(localMessage, (MsgSummary)localObject2);
      bI(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject2);
      if (((a().msg instanceof aamb)) && (this.mUnreadNum > 0))
      {
        ((MsgSummary)localObject2).suffix = "";
        ((MsgSummary)localObject2).strPrefix = "";
      }
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if ((((MsgSummary)localObject2).bShowDraft) && (a().msg == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemTroopMsgData.troop.special_msg.special_attention", 2, "msgSummary.bShowDraft && (null == getRecentUser().msg)");
        }
        this.mMsgExtroInfo = "";
      }
      if (!((MsgSummary)localObject2).bShowDraft) {
        d(paramQQAppInterface, paramContext);
      }
      a(paramContext, localMessage);
      if (((HotChatManager)localObject1).kj(this.mUser.uin))
      {
        localObject1 = ((HotChatManager)localObject1).a(this.mUser.uin);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((HotChatInfo)localObject1).memo)) && (!((HotChatInfo)localObject1).memoShowed))
        {
          this.mMsgExtroInfo = paramContext.getString(2131721137);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167383);
        }
      }
      if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localMessage != null) && (localObject2 != null) && (jof.a(localMessage))) {
        this.mLastMsg = ((MsgSummary)localObject2).a(paramContext, paramContext.getResources().getString(2131699453), -1);
      }
      localObject1 = a();
      if ((localObject1 != null) && (((RecentUser)localObject1).msg == null)) {
        ((RecentUser)localObject1).reParse();
      }
      aale.a().t(this.mUser.uin, this.mDisplayTime);
      if (localTroopInfo != null)
      {
        this.mTroopCreditLevel = localTroopInfo.troopCreditLevel;
        if (this.mTroopCreditLevel == 0L) {
          this.mTroopCreditLevel = 5L;
        }
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "RecentItemTroopMsgData->update," + this.mUser.uin + "," + this.mTroopCreditLevel);
        }
      }
      if ((localTroopInfo == null) || (!localTroopInfo.hasOrgs())) {
        break label680;
      }
      bool = true;
      label550:
      this.hasTroopOrg = bool;
      localObject1 = (apmb)paramQQAppInterface.getManager(346);
      if ((localTroopInfo == null) || (!((apmb)localObject1).qD(this.mUser.uin))) {
        break label685;
      }
    }
    label680:
    label685:
    for (this.troopHonorStr = localTroopInfo.myHonorList;; this.troopHonorStr = null)
    {
      bL(paramQQAppInterface);
      if ((localMessage == null) || (localMessage.msgtype != -5021)) {
        break;
      }
      paramQQAppInterface = this.mLastMsg.toString();
      paramContext = paramContext.getString(2131699629);
      if (!paramQQAppInterface.endsWith(paramContext)) {
        break;
      }
      this.mLastMsg = paramQQAppInterface.subSequence(0, paramQQAppInterface.length() - paramContext.length() - 1);
      return;
      a(paramQQAppInterface, paramContext, localMessage, localTroopInfo, null, null);
      break label135;
      bool = false;
      break label550;
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i = 0;
    if (this.mUser == null) {}
    apnu localapnu;
    boolean bool2;
    do
    {
      return;
      localapnu = (apnu)paramQQAppInterface.getManager(363);
      Object localObject = a().msg;
      bool2 = false;
      if (localObject == null) {
        break;
      }
      paramQQAppInterface = new a(paramQQAppInterface, paramContext, 0, localapnu, localObject, false).a();
    } while (paramQQAppInterface.WE());
    i = paramQQAppInterface.getColor();
    boolean bool1 = paramQQAppInterface.WF();
    for (;;)
    {
      if ((!this.mContainsKeyword) && (bool1)) {
        anot.b(null, "dc00898", "", this.mUser.uin, "qq_vip", "0X800A906", 0, 1, 0, "", "", "", "");
      }
      this.mContainsKeyword = bool1;
      if ((TextUtils.isEmpty(this.mMsgExtroInfo)) || (i <= 0)) {
        break;
      }
      this.mExtraInfoColor = paramContext.getResources().getColor(i);
      return;
      if (this.mIsGroupVideoNotify)
      {
        i = 2131167410;
        this.mMsgExtroInfo = paramContext.getString(2131700021);
      }
      int k;
      int j;
      for (;;)
      {
        k = localapnu.eQ(this.mUser.uin);
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, navigateMsgType:" + k + ", mUnreadNum:" + this.mUnreadNum);
        }
        if ((k != 17) || (this.mUnreadNum == 0)) {
          break label336;
        }
        paramQQAppInterface = localapnu.x(this.mUser.uin, 17);
        j = i;
        if (paramQQAppInterface != null)
        {
          j = i;
          if (paramQQAppInterface.size() != 0)
          {
            this.mMsgExtroInfo = paramContext.getString(2131701855);
            j = 2131167410;
            this.mContentDesc = this.mMsgExtroInfo.toString();
          }
        }
        bool1 = false;
        i = j;
        break;
        this.mMsgExtroInfo = "";
        this.mContentDesc = "";
      }
      label336:
      if ((k == 100) && (this.mUnreadNum != 0))
      {
        paramQQAppInterface = localapnu.x(this.mUser.uin, 100);
        j = i;
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          j = i;
          bool1 = bool2;
          if (paramQQAppInterface.size() != 0)
          {
            this.mMsgExtroInfo = paramContext.getString(2131701843);
            j = 2131167410;
            this.mContentDesc = this.mMsgExtroInfo.toString();
            bool1 = true;
          }
        }
        i = j;
      }
      else
      {
        j = i;
        if (k == 11)
        {
          j = i;
          if (this.mUnreadNum != 0)
          {
            paramQQAppInterface = localapnu.x(this.mUser.uin, 11);
            j = i;
            if (paramQQAppInterface != null)
            {
              j = i;
              if (paramQQAppInterface.size() != 0)
              {
                this.mMsgExtroInfo = paramContext.getString(2131701835);
                j = 2131167410;
                this.mContentDesc = this.mMsgExtroInfo.toString();
              }
            }
          }
        }
        bool1 = false;
        i = j;
      }
    }
  }
  
  public long eK()
  {
    return this.mTroopCreditLevel;
  }
  
  class a
  {
    private apnu jdField_a_of_type_Apnu;
    private QQAppInterface app;
    private boolean bwj;
    private boolean bwk;
    private int color;
    private Context context;
    private Object msg;
    
    public a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, apnu paramapnu, Object paramObject, boolean paramBoolean)
    {
      this.app = paramQQAppInterface;
      this.context = paramContext;
      this.color = paramInt;
      this.jdField_a_of_type_Apnu = paramapnu;
      this.msg = paramObject;
      this.bwk = paramBoolean;
    }
    
    boolean WE()
    {
      return this.bwj;
    }
    
    public boolean WF()
    {
      return this.bwk;
    }
    
    public a a()
    {
      aalj localaalj;
      Object localObject;
      if ((this.msg instanceof aalj))
      {
        if ((RecentItemTroopMsgData.this.mUnreadNum == 0) && (!(this.msg instanceof aalz)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, mUnreadNum:" + RecentItemTroopMsgData.this.mUnreadNum);
          }
          RecentItemTroopMsgData.this.mMsgExtroInfo = "";
          RecentItemTroopMsgData.this.mContentDesc = "";
          this.bwj = true;
          return this;
        }
        localaalj = (aalj)this.msg;
        RecentItemTroopMsgData.this.mMsgExtroInfo = localaalj.content;
        this.color = 2131167410;
        RecentItemTroopMsgData.this.mContentDesc = localaalj.contentDescription;
        long l = this.jdField_a_of_type_Apnu.aQ(RecentItemTroopMsgData.this.mUser.uin);
        localObject = null;
        if (l != 0L) {
          localObject = this.app.b().d(RecentItemTroopMsgData.this.mUser.uin, RecentItemTroopMsgData.this.mUser.getType(), l);
        }
        if (!MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject)) {
          break label258;
        }
        localObject = (MessageForQQWalletMsg)localObject;
        if ((((MessageForQQWalletMsg)localObject).messageType == 7) || (((MessageForQQWalletMsg)localObject).messageType == 8))
        {
          RecentItemTroopMsgData.this.mMsgExtroInfo = this.context.getString(2131719507);
          RecentItemTroopMsgData.this.mContentDesc = this.context.getString(2131719507);
        }
      }
      for (;;)
      {
        this.bwj = false;
        return this;
        label258:
        if ((localObject instanceof MessageForFuDai))
        {
          ((MessageForFuDai)localObject).parse();
          localObject = ((MessageForFuDai)localObject).highlightMsg();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = acfp.m(2131713699) + (String)localObject + "]";
            RecentItemTroopMsgData.this.mMsgExtroInfo = ((CharSequence)localObject);
            RecentItemTroopMsgData.this.mContentDesc = ((String)localObject);
          }
          else
          {
            RecentItemTroopMsgData.this.mMsgExtroInfo = "";
            RecentItemTroopMsgData.this.mContentDesc = "";
          }
        }
        else if ((this.msg instanceof aalo))
        {
          localObject = String.format(acfp.m(2131713672), new Object[] { RecentItemTroopMsgData.this.mTitleName });
          RecentItemTroopMsgData.this.mContentDesc = ((String)localObject);
        }
        else if ((RecentItemTroopMsgData.this.a().msg instanceof aalz))
        {
          localObject = (aalz)RecentItemTroopMsgData.this.a().msg;
          aptq localaptq = aptr.a(this.app, RecentItemTroopMsgData.this.mUser.uin);
          if (((aalz)localObject).ctl_flag == 1)
          {
            RecentItemTroopMsgData.this.mMsgExtroInfo = this.context.getString(2131699535);
            this.color = 2131167383;
          }
          else if (aptr.qX(RecentItemTroopMsgData.this.mUser.uin))
          {
            RecentItemTroopMsgData.this.mMsgExtroInfo = localaalj.content;
            this.color = 2131167383;
          }
          else if (localaptq != null)
          {
            if (localaptq.crj.isEmpty()) {
              RecentItemTroopMsgData.this.mMsgExtroInfo = "";
            } else {
              RecentItemTroopMsgData.this.mMsgExtroInfo = localaalj.content;
            }
          }
          else
          {
            RecentItemTroopMsgData.this.mMsgExtroInfo = "";
          }
        }
        else if (((this.msg instanceof awke)) && (((awke)this.msg).content.equalsIgnoreCase(this.context.getString(2131699649))))
        {
          this.color = 2131167383;
        }
        else if (((this.msg instanceof aaly)) && (((aaly)this.msg).content.equalsIgnoreCase(this.context.getString(2131699634))))
        {
          this.color = 2131167383;
        }
        else if (((this.msg instanceof aalu)) && ((((aalu)this.msg).content.equalsIgnoreCase(this.context.getString(2131699630))) || (((aalu)this.msg).content.equalsIgnoreCase(this.context.getString(2131694202)))))
        {
          this.color = 2131167383;
        }
        else if ((this.msg instanceof aalv))
        {
          RecentItemTroopMsgData.this.mMsgExtroInfo = "";
        }
        else if (((this.msg instanceof aamc)) && (((aamc)this.msg).content.equalsIgnoreCase(this.context.getString(2131699632))))
        {
          RecentItemTroopMsgData.this.mMsgExtroInfo = "";
        }
        else if (((this.msg instanceof aalt)) && (((aalt)this.msg).content.equalsIgnoreCase(this.context.getString(2131699635))))
        {
          RecentItemTroopMsgData.this.mMsgExtroInfo = "";
        }
        else if (((this.msg instanceof aama)) && (((aama)this.msg).content.equalsIgnoreCase(this.context.getString(2131699637))))
        {
          RecentItemTroopMsgData.this.mMsgExtroInfo = "";
        }
        else if ((this.msg instanceof aalx))
        {
          this.bwk = true;
        }
      }
    }
    
    public int getColor()
    {
      return this.color;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData
 * JD-Core Version:    0.7.0.1
 */