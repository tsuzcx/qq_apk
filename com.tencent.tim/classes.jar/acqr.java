import android.content.res.Resources;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class acqr
  extends tnu
{
  public acqr(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, tom paramtom)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramtom);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, tnt.a parama)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:" + paramMessageRecord);
    }
    Map localMap = parama.gH;
    Object localObject = parama.jdField_a_of_type_Acxw;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = anaz.gQ();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    int k = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = ((acxw)localObject).a(str1, paramMessageRecord.istroop);
    localObject = null;
    ajdr localajdr = parama.jdField_a_of_type_Ajdr;
    String str2;
    aozx localaozx;
    if (localajdr != null)
    {
      str2 = str1 + "&" + 3000;
      localaozx = localajdr.a(str2);
      if (localaozx == null) {
        break label640;
      }
      if (localaozx.ho() == paramMessageRecord.shmsgseq) {
        break label583;
      }
      localaozx = null;
      localObject = localaozx;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:not the same msg:" + str2);
        localObject = localaozx;
      }
    }
    int i;
    if ((localObject != null) && (((aozx)localObject).aAH()))
    {
      i = ((aozx)localObject).Lc();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord, bizType" + i + "|ru.msgType:" + localRecentUser.msgType);
      }
      if (aozx.bq(i, localRecentUser.msgType))
      {
        localRecentUser.msgType = i;
        localRecentUser.msg = apnt.a(this.app, str1, (aozx)localObject, localRecentUser.msg, paramMessageRecord, false);
        localMap.put(top.u(str1, k), localRecentUser);
      }
    }
    if (localMap.containsKey(top.u(localRecentUser.uin, localRecentUser.getType()))) {}
    for (localObject = (RecentUser)localMap.get(top.u(localRecentUser.uin, localRecentUser.getType()));; localObject = localRecentUser)
    {
      if (!top.fz(paramMessageRecord.msgtype)) {}
      for (i = 1;; i = 0)
      {
        int j = i;
        if (paramMessageRecord.isLongMsg())
        {
          j = i;
          if (this.app.a().aQ(paramMessageRecord))
          {
            i = 0;
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
              j = i;
            }
          }
        }
        if (j != 0)
        {
          ((RecentUser)localObject).uin = str1;
          ((RecentUser)localObject).setType(k);
          boolean bool = true;
          if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
            bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.ciF;
          }
          if ((l > ((RecentUser)localObject).lastmsgtime) && (bool))
          {
            ((RecentUser)localObject).lastmsgtime = l;
            localMap.put(top.u(str1, k), localObject);
          }
        }
        super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, parama);
        paramEntityManager = aobw.a.a(this.app);
        paramEntityManager.aD(paramMessageRecord);
        paramEntityManager.schedule();
        return;
        label583:
        localObject = localaozx;
        if (!paramMessageRecord.isread) {
          break;
        }
        localajdr.b(str2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:readed msg been removed:" + str2);
        }
        localObject = null;
        break;
        label640:
        localObject = localaozx;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:msgInfo == null " + str2);
        localObject = localaozx;
        break;
      }
    }
  }
  
  public String at(String paramString1, String paramString2)
  {
    if (this.app.getCurrentAccountUin().equals(paramString1)) {
      return this.app.getApp().getResources().getString(2131695694);
    }
    return aqgv.m(this.app, paramString2, paramString1);
  }
  
  protected String au(String paramString1, String paramString2)
  {
    return at(paramString1, paramString2);
  }
  
  public void bL(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt);
    }
    super.bL(paramString, paramInt);
    ProxyManager localProxyManager = this.app.a();
    paramString = localProxyManager.a().a(paramString, paramInt);
    if (paramString.shouldShowInRecentList(this.app))
    {
      paramString.cleanMsgAndMsgData(paramString.msgType);
      localProxyManager.a().e(paramString);
    }
  }
  
  protected void j(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    super.j(paramString, paramInt, paramLong);
    l(paramString, paramInt, paramLong);
  }
  
  public void k(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    if (this.app.a().A(paramString, paramInt) > 0) {
      l(paramString, paramInt, paramLong);
    }
    super.k(paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqr
 * JD-Core Version:    0.7.0.1
 */