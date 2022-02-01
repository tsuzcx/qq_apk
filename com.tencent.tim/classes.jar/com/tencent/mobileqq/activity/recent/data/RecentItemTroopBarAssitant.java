package com.tencent.mobileqq.activity.recent.data;

import acfp;
import acja;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anqu;
import anqv;
import aqiu;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oac;
import oan;
import obt;
import wna;

public class RecentItemTroopBarAssitant
  extends RecentUserBaseData
{
  public RecentItemTroopBarAssitant(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
    this.mUnreadFlag = 2;
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
          paramMsgSummary = paramQQAppInterface.b();
        } while (paramMsgSummary == null);
        paramQQAppInterface = oan.a().a(paramQQAppInterface);
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.mUin)) || (this.mDisplayTime >= paramQQAppInterface.mLastDraftTime));
      paramQQAppInterface = paramMsgSummary.a(paramQQAppInterface.mUin, 1008);
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.mDisplayTime = paramQQAppInterface.getTime();
  }
  
  public void bI(QQAppInterface paramQQAppInterface)
  {
    this.mStatus = 0;
    TroopBarData localTroopBarData = oan.a().a(paramQQAppInterface);
    if ((localTroopBarData == null) || (TextUtils.isEmpty(localTroopBarData.mUin))) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.b();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(localTroopBarData.mUin, 1008);
    } while ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.mStatus = 0;
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    this.mTitleName = obt.a(paramQQAppInterface, paramContext);
    Object localObject5 = oan.a();
    MsgSummary localMsgSummary = a();
    Object localObject1;
    label91:
    Object localObject2;
    if (oac.n(paramQQAppInterface))
    {
      this.mUnreadNum = 1;
      ((oan)localObject5).bdB = this.mUnreadNum;
      localObject1 = oac.g(paramQQAppInterface);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localMsgSummary.strContent = paramContext.getString(2131700034);; localMsgSummary.strContent = ((CharSequence)localObject1))
      {
        this.mDisplayTime = ((oan)localObject5).f(paramQQAppInterface);
        bI(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.enableTalkBack)
        {
          localObject1 = this.mTitleName;
          if (this.mUnreadNum != 0) {
            break label948;
          }
          localObject2 = paramContext.getString(2131698671);
          if (this.mLastMsg != null) {
            break;
          }
          paramQQAppInterface = "";
          label148:
          this.mContentDesc = String.format((String)localObject2, new Object[] { localObject1, paramQQAppInterface, this.mShowTime });
        }
        label177:
        dx(paramContext);
        return;
      }
    }
    label207:
    Object localObject3;
    Object localObject4;
    label350:
    int i;
    if (((oan)localObject5).g(paramQQAppInterface) == 0)
    {
      this.mUnreadNum = 0;
      ((oan)localObject5).bdB = 0;
      localObject2 = null;
      localObject3 = paramQQAppInterface.b();
      localObject4 = ((oan)localObject5).a(paramQQAppInterface);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((QQMessageFacade)localObject3).a(((TroopBarData)localObject4).mUin, 1008);
        }
      }
      if (localObject1 == null) {
        break label927;
      }
      this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
      if (TextUtils.isEmpty(((oan)localObject5).getNickName(((QQMessageFacade.Message)localObject1).frienduin)))
      {
        localObject2 = (acja)paramQQAppInterface.getManager(56);
        if (localObject2 != null)
        {
          localObject5 = ((acja)localObject2).b(((QQMessageFacade.Message)localObject1).frienduin);
          if (localObject5 != null) {
            break label629;
          }
          localObject2 = ((acja)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin);
          if (localObject2 == null) {
            break label619;
          }
          localObject2 = ((AccountDetail)localObject2).name;
        }
      }
      if (localObject1 != null)
      {
        aqiu.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.mUser.getType(), localMsgSummary, "", true, false);
        i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == -3006) || (i == -5004))
        {
          localMsgSummary.suffix = "";
          localMsgSummary.strContent = "";
          localObject5 = wna.a((MessageRecord)localObject1);
          if ((localObject5 != null) && (((PAMessage)localObject5).items != null) && (((PAMessage)localObject5).items.size() != 0)) {
            break label639;
          }
          a((QQMessageFacade.Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
        }
        if (((!TextUtils.isEmpty(localMsgSummary.strContent)) || (!TextUtils.isEmpty(localMsgSummary.suffix))) && (!TextUtils.equals(localMsgSummary.a(paramContext), AbsStructMsg.PA_DEFAULT_MSG_BRIEF))) {
          break label755;
        }
        i = 1;
        label496:
        if (i != 0)
        {
          localObject2 = ((QQMessageFacade)localObject3).d(((TroopBarData)localObject4).mUin, 1008);
          if ((localObject2 != null) && ((localObject2 instanceof MessageForStructing))) {
            break label760;
          }
        }
      }
    }
    label528:
    label825:
    label1098:
    label1099:
    for (;;)
    {
      if ((localObject1 == null) && (TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
      {
        localMsgSummary.strPrefix = null;
        localMsgSummary.strContent = (acfp.m(2131713668) + obt.a(paramQQAppInterface, paramContext) + acfp.m(2131713684));
        break label91;
        this.mUnreadNum = ((oan)localObject5).a(paramQQAppInterface, false);
        break label207;
        label619:
        localObject2 = ((QQMessageFacade.Message)localObject1).frienduin;
        break label350;
        label629:
        localObject2 = ((PublicAccountInfo)localObject5).name;
        break label350;
        label639:
        localObject2 = ((PAMessage.Item)((PAMessage)localObject5).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject5).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject5).items.get(0)).digestList != null)) {
          localObject2 = (String)localObject2 + "：" + (String)((PAMessage.Item)((PAMessage)localObject5).items.get(0)).digestList.get(0);
        }
        for (;;)
        {
          localMsgSummary.strContent = ((CharSequence)localObject2);
          break;
        }
        label755:
        i = 0;
        break label496;
        label760:
        ((MessageForStructing)localObject2).parse();
        if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg))) {
          break;
        }
        localObject2 = ((AbsShareMsg)((MessageForStructing)localObject2).structingMsg).getStructMsgItemLists();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((List)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (anqu)((Iterator)localObject2).next();
          if (!(localObject3 instanceof anqv)) {
            break label1098;
          }
          localObject3 = ((anqv)localObject3).rz.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (anqu)((Iterator)localObject3).next();
            if ((localObject4 instanceof StructMsgItemTitle))
            {
              localMsgSummary.strContent = ((StructMsgItemTitle)localObject4).getText();
              localMsgSummary.suffix = "";
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label1099;
        }
        break label825;
        break label528;
        this.mDisplayTime = ((oan)localObject5).f(paramQQAppInterface);
        break label528;
        break;
        paramQQAppInterface = this.mLastMsg;
        break label148;
        if (this.mUnreadNum == 1)
        {
          this.mContentDesc = String.format(paramContext.getString(2131698670), new Object[] { localObject1, acfp.m(2131713685), this.mShowTime });
          break label177;
        }
        if (this.mUnreadNum == 2)
        {
          this.mContentDesc = String.format(paramContext.getString(2131698670), new Object[] { localObject1, acfp.m(2131713698), this.mShowTime });
          break label177;
        }
        if (this.mUnreadNum <= 0) {
          break label177;
        }
        this.mContentDesc = String.format(paramContext.getString(2131698670), new Object[] { localObject1, Integer.toString(this.mUnreadNum), this.mShowTime });
        break label177;
      }
    }
  }
  
  public void dx(Context paramContext)
  {
    if ((this.mUnreadNum > 0) && (!oac.n((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      if (this.mUnreadNum <= 99)
      {
        this.mMsgExtroInfo = String.format(paramContext.getString(2131698672), new Object[] { Integer.valueOf(this.mUnreadNum) });
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
      }
    }
    for (;;)
    {
      if (this.mDisplayTime == 0L) {
        this.mShowTime = "";
      }
      return;
      this.mMsgExtroInfo = paramContext.getString(2131698667);
      break;
      this.mMsgExtroInfo = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant
 * JD-Core Version:    0.7.0.1
 */