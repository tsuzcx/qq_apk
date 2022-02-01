import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wnf
{
  private static volatile wnf a;
  private long If = -1L;
  public volatile long Ig = -1L;
  public volatile boolean beC;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  public static wnf a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new wnf();
      }
      return a;
    }
    finally {}
  }
  
  public String a(AbsShareMsg paramAbsShareMsg)
  {
    if ((paramAbsShareMsg != null) && (paramAbsShareMsg.getItemCount() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramAbsShareMsg = paramAbsShareMsg.iterator();
      while (paramAbsShareMsg.hasNext())
      {
        Object localObject = (anqu)paramAbsShareMsg.next();
        if ((localObject instanceof anqv))
        {
          localObject = ((anqv)localObject).rz.iterator();
          while (((Iterator)localObject).hasNext())
          {
            anqu localanqu = (anqu)((Iterator)localObject).next();
            String str = localanqu.mTypeName;
            if ("title".equals(str)) {
              localStringBuilder.append(((StructMsgItemTitle)localanqu).getText());
            } else if ("summary".equals(str)) {
              localStringBuilder.append(((anux)localanqu).getText());
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public ArrayList<wnh> a(ChatMessage paramChatMessage)
  {
    wnh localwnh = null;
    Object localObject1 = null;
    Iterator localIterator = null;
    Object localObject2 = localIterator;
    if (paramChatMessage != null)
    {
      if (l(paramChatMessage)) {
        break label32;
      }
      localObject2 = localIterator;
    }
    label32:
    Object localObject3;
    do
    {
      return localObject2;
      localObject3 = wne.a().bH();
      if (localObject3 != null) {
        break;
      }
      localObject2 = localIterator;
    } while (!QLog.isColorLevel());
    QLog.d("AioAnimationDetector", 2, "match : rules == null, just return;");
    return null;
    paramChatMessage.parse();
    long l1 = System.currentTimeMillis();
    if (m(paramChatMessage)) {
      localObject2 = a((AbsShareMsg)((MessageForStructing)paramChatMessage).structingMsg);
    }
    label115:
    long l2;
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localIterator = ((ArrayList)localObject3).iterator();
        paramChatMessage = localwnh;
        localObject1 = paramChatMessage;
        if (localIterator.hasNext())
        {
          localwnh = (wnh)localIterator.next();
          if (localwnh.qi == null) {
            break label400;
          }
          localObject1 = localwnh.qi.iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label400;
            }
            localObject3 = (String)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((String)localObject2).contains((CharSequence)localObject3)))
            {
              if (localwnh.a == null) {
                break;
              }
              l2 = System.currentTimeMillis() / 1000L;
              if ((localwnh.a.bid != 1) || ((localwnh.a.bPA <= l2) && (localwnh.a.endTs >= l2))) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "JD red pack,But not in date.");
              }
            }
          }
          localObject2 = paramChatMessage.msg;
          continue;
          if (paramChatMessage != null) {
            break label397;
          }
          paramChatMessage = new ArrayList();
          label292:
          paramChatMessage.add(localwnh);
          localObject1 = paramChatMessage;
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "matched ===> rule: id=" + localwnh.id);
          }
        }
      }
    }
    label397:
    label400:
    for (localObject1 = paramChatMessage;; localObject1 = paramChatMessage)
    {
      paramChatMessage = (ChatMessage)localObject1;
      break label115;
      l2 = System.currentTimeMillis();
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AioAnimationDetector", 2, "match duration: " + (l2 - l1) + " ms");
      return localObject1;
      break label292;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramAIOAnimationConatiner == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "handleUnreadMsgList, hasUnRead=" + this.beC);
      }
      if ((this.beC) && (paramSessionInfo.cZ != 1008))
      {
        int j = 0;
        int i;
        if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000)) {
          i = 1;
        }
        while ((i != 0) || (j != 0))
        {
          List localList = paramQQAppInterface.b().a(paramSessionInfo.aTl, paramSessionInfo.cZ, -1L, true);
          long l = this.Ig;
          j = 0;
          int n = localList.size();
          int m = 0;
          label140:
          ChatMessage localChatMessage;
          int k;
          ArrayList localArrayList;
          if (m < n)
          {
            localChatMessage = (ChatMessage)localList.get(m);
            if (i != 0)
            {
              k = j;
              if (localChatMessage.shmsgseq >= l)
              {
                k = j;
                if (!localChatMessage.isAioAnimChecked)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AioAnimationDetector", 2, "handleUnreadMsgList, troop&discussion message ===> (" + localChatMessage.shmsgseq + ")");
                  }
                  boolean bool = false;
                  if (m == n - 1) {
                    bool = true;
                  }
                  localArrayList = a(localChatMessage);
                  this.Ig = localChatMessage.shmsgseq;
                  if (localArrayList == null) {
                    break label473;
                  }
                  a(paramQQAppInterface, localArrayList, true, localChatMessage, bool, paramAIOAnimationConatiner, j * 800, paramSessionInfo.troopUin, paramBaseChatPie);
                  j += 1;
                }
              }
            }
          }
          label473:
          for (;;)
          {
            k = j;
            for (;;)
            {
              m += 1;
              j = k;
              break label140;
              if (!top.fv(paramSessionInfo.cZ)) {
                break label476;
              }
              j = 1;
              i = 0;
              break;
              k = j;
              if (localChatMessage.time >= l)
              {
                k = j;
                if (!localChatMessage.isAioAnimChecked)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AioAnimationDetector", 2, "handleUnreadMsgList, c2c message ===> (" + localChatMessage.time + ")");
                  }
                  localArrayList = a(localChatMessage);
                  this.Ig = localChatMessage.time;
                  k = j;
                  if (localArrayList != null)
                  {
                    a(paramQQAppInterface, localArrayList, false, localChatMessage, false, paramAIOAnimationConatiner, j * 800, paramSessionInfo.troopUin, paramBaseChatPie);
                    k = j + 1;
                  }
                }
              }
            }
            this.beC = false;
            return;
          }
          label476:
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    if ((paramSessionInfo.cZ == 1033) || (paramSessionInfo.cZ == 1034))
    {
      break label20;
      break label20;
      break label20;
    }
    label20:
    label198:
    label464:
    label468:
    for (;;)
    {
      return;
      if ((!(paramMessageRecord instanceof MessageForArkFlashChat)) && (!this.beC))
      {
        if (this.Ig == -1L)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AioAnimationDetector", 2, "handleNewMsg, lastMsgIdOrTime == -1, just return");
          return;
        }
        if ((paramSessionInfo.cZ == 1008) || (top.eD(paramSessionInfo.cZ) == 1032)) {
          break;
        }
        int j = 0;
        int i;
        if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000)) {
          i = 1;
        }
        for (;;)
        {
          label109:
          if (((i == 0) && (j == 0)) || (!paramSessionInfo.aTl.equals(paramMessageRecord.frienduin)) || ((paramSessionInfo.cZ != paramMessageRecord.istroop) && ((j == 0) || (!top.fv(paramMessageRecord.istroop))))) {
            break label468;
          }
          paramMessageRecord = paramQQAppInterface.b().b(paramSessionInfo.aTl, paramSessionInfo.cZ, true);
          wnf localwnf = a();
          long l = localwnf.Ig;
          j = paramMessageRecord.size() - 1;
          ChatMessage localChatMessage;
          ArrayList localArrayList;
          if (j >= 0)
          {
            localChatMessage = (ChatMessage)paramMessageRecord.get(j);
            if (i == 0) {
              break label355;
            }
            if (localChatMessage.shmsgseq <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "handle troop&discussion new message ===> (" + localChatMessage.shmsgseq + ")");
              }
              localArrayList = localwnf.a(localChatMessage);
              if (localArrayList != null) {
                localwnf.a(paramQQAppInterface, localArrayList, true, localChatMessage, true, paramAIOAnimationConatiner, 0, paramSessionInfo.troopUin, paramBaseChatPie);
              }
              localwnf.Ig = localChatMessage.shmsgseq;
            }
          }
          for (;;)
          {
            j -= 1;
            break label198;
            break label20;
            if (!top.fv(paramSessionInfo.cZ)) {
              break label464;
            }
            j = 1;
            i = 0;
            break label109;
            label355:
            if (localChatMessage.time <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "handle c2c new message ===> (" + localChatMessage.time + ")");
              }
              localArrayList = localwnf.a(localChatMessage);
              if (localArrayList != null) {
                localwnf.a(paramQQAppInterface, localArrayList, false, localChatMessage, true, paramAIOAnimationConatiner, 0, paramSessionInfo.troopUin, paramBaseChatPie);
              }
              localwnf.Ig = localChatMessage.time;
            }
          }
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList<wnh> paramArrayList, boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, String paramString, BaseChatPie paramBaseChatPie)
  {
    if ((paramQQAppInterface != null) && (paramChatMessage != null) && (paramAIOAnimationConatiner != null) && (paramArrayList != null) && (l(paramChatMessage))) {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = i * 800;
      this.mUiHandler.postDelayed(new AioAnimationDetector.1(this, paramAIOAnimationConatiner, paramDrawable, j), j + paramInt1);
      i += 1;
    }
  }
  
  public void destory()
  {
    if (this.mUiHandler != null) {
      this.mUiHandler.removeCallbacksAndMessages(null);
    }
    this.Ig = -1L;
  }
  
  public boolean l(ChatMessage paramChatMessage)
  {
    if ((!(paramChatMessage instanceof MessageForText)) && (!(paramChatMessage instanceof MessageForLongMsg)) && (!(paramChatMessage instanceof MessageForStructing)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : not MessageForText and MessageForLongMsg and MessageFlashChat, return false;");
      }
      return false;
    }
    if ((paramChatMessage instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : messageForText");
      }
    }
    for (;;)
    {
      return true;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "checkMsgType : MessageForLongMsg");
        }
      }
      else if (((paramChatMessage instanceof MessageForStructing)) && (QLog.isColorLevel())) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : MessageForStructing");
      }
    }
  }
  
  public boolean m(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if (paramChatMessage != null) {
        break label36;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "msg type is MessageForStructing, strctMsg is null");
      }
    }
    return false;
    label36:
    return paramChatMessage instanceof AbsShareMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnf
 * JD-Core Version:    0.7.0.1
 */