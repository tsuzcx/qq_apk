package com.tencent.mobileqq.activity.recent.data;

import acfp;
import aegp;
import aegs;
import aegu;
import aehb;
import android.content.Context;
import android.text.TextUtils;
import aqgv;
import aqiu;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.RecentUser;
import tog;

public class RecentItemConfessMsgBox
  extends RecentUserBaseData
{
  public RecentItemConfessMsgBox(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    MsgSummary localMsgSummary = a();
    Object localObject2 = null;
    Object localObject3 = paramQQAppInterface.b();
    Object localObject1 = paramQQAppInterface.a();
    paramQQAppInterface.getAccount();
    long l2 = aegp.c(paramQQAppInterface, "redpoint_box_show");
    this.mTitleName = paramContext.getString(2131700847);
    if (localObject3 != null) {
      localObject2 = ((QQMessageFacade)localObject3).a(this.mUser.uin, this.mUser.getType());
    }
    int i = 1;
    int j;
    label139:
    long l1;
    label151:
    int k;
    if (localObject2 != null)
    {
      if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject2).getExtInfoFromExtStr("ext_key_confess_info"))) {
        i = 0;
      }
      j = i;
      if ((localObject1 == null) || (localObject2 == null)) {
        break label252;
      }
      this.mUnreadNum = ((tog)localObject1).A(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
      if (j == 0) {
        break label260;
      }
      l1 = ((QQMessageFacade.Message)localObject2).time;
      if (l1 >= l2) {
        break label266;
      }
      k = 1;
      label162:
      if (this.mUnreadNum <= 0) {
        break label272;
      }
      this.mUnreadFlag = 1;
      i = 0;
      localObject1 = null;
      label179:
      if (k == 0) {
        break label391;
      }
      localObject1 = ((aegs)paramQQAppInterface.getManager(269)).b();
      if (localObject1 != null) {
        break label381;
      }
      localObject1 = aegp.bwO;
      label209:
      localMsgSummary.strContent = ((CharSequence)localObject1);
      this.mDisplayTime = l2;
    }
    for (;;)
    {
      this.mStatus = 0;
      localMsgSummary.bShowDraft = false;
      a(paramQQAppInterface, paramContext, localMsgSummary);
      cuS();
      return;
      j = 0;
      break;
      label252:
      this.mUnreadNum = 0;
      break label139;
      label260:
      l1 = 0L;
      break label151;
      label266:
      k = 0;
      break label162;
      label272:
      localObject1 = ((aegs)paramQQAppInterface.getManager(269)).a();
      if ((localObject1 != null) && (((aehb)localObject1).agG()))
      {
        if (!aegu.c(paramQQAppInterface, false))
        {
          this.mUnreadNum = ((aehb)localObject1).cMU;
          this.mUnreadFlag = 3;
        }
        if ((this.mUnreadNum > 0) || (localObject2 == null) || (((QQMessageFacade.Message)localObject2).msg == null) || (((QQMessageFacade.Message)localObject2).time < ((aehb)localObject1).Wd)) {}
        for (i = 1;; i = 0) {
          break;
        }
      }
      this.mUnreadNum = 0;
      this.mUnreadFlag = 1;
      i = 0;
      break label179;
      label381:
      localObject1 = ((aegp)localObject1).bxa;
      break label209;
      label391:
      if ((localObject2 != null) && (j != 0) && (i == 0))
      {
        localObject1 = ((QQMessageFacade.Message)localObject2).getExtInfoFromExtStr("ext_key_confess_info");
        localObject3 = new ConfessInfo();
        ((ConfessInfo)localObject3).parseFromJsonStr((String)localObject1);
        if (((QQMessageFacade.Message)localObject2).isSend()) {}
        for (localObject1 = "";; localObject1 = aegu.a(paramQQAppInterface, (ConfessInfo)localObject3, ((QQMessageFacade.Message)localObject2).senderuin))
        {
          aqiu.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, this.mUser.getType(), localMsgSummary, (String)localObject1, false, false);
          this.mDisplayTime = ((QQMessageFacade.Message)localObject2).time;
          break;
        }
      }
      if (i != 0)
      {
        localObject3 = aqgv.b(paramQQAppInterface, ((aehb)localObject1).bxr, true);
        localObject2 = localObject3;
        if (TextUtils.equals((CharSequence)localObject3, ((aehb)localObject1).bxr))
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(((aehb)localObject1).bxs)) {
            localObject2 = ((aehb)localObject1).bxs;
          }
        }
        localMsgSummary.strContent = String.format(acfp.m(2131713687), new Object[] { localObject2, ((aehb)localObject1).bxt });
        this.mDisplayTime = ((aehb)localObject1).Wd;
      }
      else
      {
        localObject1 = ((aegs)paramQQAppInterface.getManager(269)).b();
        if (localObject1 == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label654;
          }
          localMsgSummary.strContent = ((aegp)localObject1).title;
          this.mDisplayTime = ((aegp)localObject1).VY;
          break;
          if (((aegp)localObject1).cMI >= 1) {
            i = 1;
          } else {
            i = 0;
          }
        }
        label654:
        localMsgSummary.strContent = "";
        this.mDisplayTime = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsgBox
 * JD-Core Version:    0.7.0.1
 */