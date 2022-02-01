import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController.1;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController.2;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController.3;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class abvl
{
  private static abvl a;
  public WeakReference<QQAppInterface> mAppRef;
  public long mLastMsgTime = -1L;
  
  public static abvl a()
  {
    try
    {
      if (a == null) {
        a = new abvl();
      }
      abvl localabvl = a;
      return localabvl;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[playWhiteFace]");
    }
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    do
    {
      return;
      paramQQAppInterface = ((abrg)paramQQAppInterface.getManager(249)).a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramChatMessage, paramArrayList1, paramArrayList2);
  }
  
  public void l(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] app:" + paramQQAppInterface + "sessionInfo:" + paramSessionInfo);
    }
    if ((paramSessionInfo == null) || (paramQQAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] sessionInfo or app is null,return.");
      }
    }
    abxk localabxk;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      localabxk = (abxk)paramQQAppInterface.getManager(155);
      localObject1 = localabxk.a(paramSessionInfo);
      if (localObject1 != null)
      {
        ThreadManager.getSubThreadHandler().postDelayed(new ApolloMsgPlayController.1(this, paramQQAppInterface, (ApolloActionPush)localObject1), 500L);
        return;
      }
      localObject2 = paramQQAppInterface.b().a(paramSessionInfo.aTl, paramSessionInfo.cZ, null, 5);
      if (((List)localObject2).size() > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] no message,return.");
    return;
    int i = ((List)localObject2).size() - 1;
    label164:
    MessageRecord localMessageRecord;
    if (i >= 0)
    {
      localMessageRecord = (MessageRecord)((List)localObject2).get(i);
      if (!(localMessageRecord instanceof MessageForApollo)) {
        break label429;
      }
      localObject1 = (MessageForApollo)localMessageRecord;
      if ((i != ((List)localObject2).size() - 1) || (!ApolloGameUtil.ib(((MessageForApollo)localObject1).msgType))) {
        break label262;
      }
      ApolloGameData localApolloGameData = localabxk.a(((MessageForApollo)localObject1).gameId);
      if ((localApolloGameData == null) || (!abxh.l("3.4.4", localApolloGameData.minVer, localApolloGameData.maxVer))) {
        break label262;
      }
    }
    label262:
    label329:
    int j;
    label393:
    label429:
    do
    {
      do
      {
        boolean bool2;
        do
        {
          do
          {
            do
            {
              i -= 1;
              break label164;
              break;
              if ((((MessageForApollo)localObject1).hasPlayed) || (i == ((List)localObject2).size() - 1)) {
                break label393;
              }
              if (!ApolloGameUtil.ib(((MessageForApollo)localObject1).msgType)) {
                break label329;
              }
              localObject1 = localabxk.a(((MessageForApollo)localObject1).gameId);
            } while ((localObject1 != null) && (abxh.l("3.4.4", ((ApolloGameData)localObject1).minVer, ((ApolloGameData)localObject1).maxVer)));
            paramQQAppInterface = ((abrg)paramQQAppInterface.getManager(249)).a();
            if (paramQQAppInterface != null) {
              paramQQAppInterface.b(1, (MessageForApollo)localMessageRecord);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] play MessageForApollo:" + localMessageRecord.toString());
            return;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] has already played MessageForApollo:" + localMessageRecord.toString());
            return;
            if ((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForLongMsg))) {
              break label681;
            }
          } while ((paramSessionInfo.cZ != 0) && (paramSessionInfo.cZ != 1) && (paramSessionInfo.cZ != 3000));
          localObject1 = new ArrayList();
          bool2 = ApolloUtil.a(paramQQAppInterface, paramSessionInfo, localMessageRecord, (List)localObject1);
        } while ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0));
        paramSessionInfo = localMessageRecord.getExtInfoFromExtStr("is_apollo_emoticon_action_played");
        if ((!TextUtils.isEmpty(paramSessionInfo)) && ("2".equals(paramSessionInfo)))
        {
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] apollo emoticon action played=", Boolean.valueOf(bool1), ", uniseq=", Long.valueOf(localMessageRecord.uniseq) });
          }
          if ((bool1) || (i == ((List)localObject2).size() - 1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] send action list to play, actionList=", localObject1 });
          }
          localObject2 = (ChatMessage)localMessageRecord;
          if (!bool2) {
            break label676;
          }
        }
        for (paramSessionInfo = (SessionInfo)localObject1;; paramSessionInfo = null)
        {
          a(paramQQAppInterface, (ChatMessage)localObject2, (ArrayList)localObject1, paramSessionInfo);
          localMessageRecord.saveExtInfoToExtStr("is_apollo_emoticon_action_played", "2");
          ThreadManager.post(new ApolloMsgPlayController.2(this, localMessageRecord), 5, null, false);
          return;
          bool1 = false;
          break;
        }
      } while ((!(localMessageRecord instanceof MessageForArkApp)) || ((paramSessionInfo.cZ != 0) && (paramSessionInfo.cZ != 1) && (paramSessionInfo.cZ != 3000)));
      j = ApolloUtil.a(paramQQAppInterface, (MessageForArkApp)localMessageRecord);
    } while (j <= 0);
    label676:
    label681:
    paramSessionInfo = localMessageRecord.getExtInfoFromExtStr("is_share_ark_message_action_played");
    if ((!TextUtils.isEmpty(paramSessionInfo)) && ("2".equals(paramSessionInfo))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] share ark action played=", Boolean.valueOf(bool1), ", uniseq=", Long.valueOf(localMessageRecord.uniseq) });
      }
      if ((bool1) || (i == ((List)localObject2).size() - 1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] send action list to play, actionId=", Integer.valueOf(j) });
      }
      paramQQAppInterface = ((abrg)paramQQAppInterface.getManager(249)).a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.d((ChatMessage)localMessageRecord, j);
      }
      localMessageRecord.saveExtInfoToExtStr("is_share_ark_message_action_played", "2");
      ThreadManager.excute(new ApolloMsgPlayController.3(this, localMessageRecord), 32, null, false);
      return;
    }
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvl
 * JD-Core Version:    0.7.0.1
 */