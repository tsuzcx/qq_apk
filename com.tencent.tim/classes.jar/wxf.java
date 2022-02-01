import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.1;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.2;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class wxf
  implements wvs
{
  private QQAppInterface app;
  private BaseActivity mActivity;
  private BaseChatPie mBaseChatPie;
  private Context mContext;
  private SessionInfo mSessionInfo;
  private MqqHandler q;
  
  public wxf(BaseChatPie paramBaseChatPie)
  {
    this.mBaseChatPie = paramBaseChatPie;
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.mSessionInfo = paramBaseChatPie.sessionInfo;
    this.q = paramBaseChatPie.getUIHandler();
  }
  
  private void xN(String paramString)
  {
    Object localObject = (acms)this.app.getBusinessHandler(20);
    if (localObject != null)
    {
      localObject = ((acms)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).TK(paramString);
      }
    }
  }
  
  public int[] C()
  {
    return new int[] { 3, 7, 13 };
  }
  
  public void Ck(int paramInt)
  {
    if (this.mSessionInfo.cZ == 1) {}
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      xN(this.mSessionInfo.aTl);
      return;
    case 7: 
      ccY();
      return;
    }
    xN(null);
  }
  
  public void K(MessageRecord paramMessageRecord)
  {
    String str1 = this.mSessionInfo.aTl;
    if (!str1.equalsIgnoreCase(paramMessageRecord.frienduin)) {}
    for (;;)
    {
      return;
      TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((acms)this.app.getBusinessHandler(20)).a();
      String str2;
      if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -1012) && (localTroopBatchAddFriendMgr.qL("newMember"))) {
        str2 = paramMessageRecord.getExtInfoFromExtStr("troop_new_member_uin");
      }
      try
      {
        QLog.d("TroopAddFriendTipsHelper", 1, "checkTipsTriggerInAio update newMemberUin = " + ahwx.encrypt(str2) + " troop:" + str1);
        if ((localTroopBatchAddFriendMgr.qK(str1)) && (!aprg.V(this.app, str1))) {
          ThreadManager.getSubThreadHandler().postDelayed(new TroopAddFriendTipsHelper.2(this, str2, str1), 1000L);
        }
        if ((paramMessageRecord != null) && (!paramMessageRecord.isSendFromLocal()) && (paramMessageRecord.mMessageInfo != null) && (!jof.a(paramMessageRecord)) && ((paramMessageRecord.mMessageInfo.b.lU(24)) || (paramMessageRecord.mMessageInfo.b.lU(22))) && (localTroopBatchAddFriendMgr.qL("atMeOrReplyMe")) && (localTroopBatchAddFriendMgr.qO(paramMessageRecord.senderuin))) {
          localTroopBatchAddFriendMgr.d(str1, paramMessageRecord.senderuin, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
        if ((paramMessageRecord == null) || (!paramMessageRecord.isSendFromLocal())) {
          continue;
        }
        if (paramMessageRecord.atInfoList != null)
        {
          i = 1;
          if (((i | paramMessageRecord instanceof MessageForReplyText) == 0) || (!localTroopBatchAddFriendMgr.qL("atMeOrReplyMe"))) {
            continue;
          }
          localTroopBatchAddFriendMgr.e(paramMessageRecord, str1);
          return;
        }
      }
      catch (XorCipherException localXorCipherException)
      {
        for (;;)
        {
          localXorCipherException.printStackTrace();
          continue;
          int i = 0;
        }
      }
    }
  }
  
  public void ae(boolean paramBoolean, String paramString)
  {
    ThreadManager.postImmediately(new TroopAddFriendTipsHelper.3(this, paramBoolean, paramString), null, true);
  }
  
  public void ccY()
  {
    ThreadManager.post(new TroopAddFriendTipsHelper.1(this, this.mActivity.getIntent().getStringExtra("uin")), 2, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxf
 * JD-Core Version:    0.7.0.1
 */