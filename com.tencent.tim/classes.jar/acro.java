import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class acro
  extends tnt
{
  public acro(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, tom paramtom)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramtom);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, tnt.a parama)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = anaz.gQ();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    a(paramMessageRecord, true, 1);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle) {}
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded uin=" + paramString + ",type=" + paramInt1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : uin=null");
      }
    }
    for (;;)
    {
      return;
      if (!acbn.bku.equals(paramString)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : clean all");
      }
      paramString = (anxr)this.app.getManager(61);
      if (paramString != null)
      {
        paramString = paramString.dK().iterator();
        while (paramString.hasNext())
        {
          String str = (String)paramString.next();
          if (!TextUtils.isEmpty(str)) {
            e(str, paramInt1, paramBoolean1, paramBoolean1);
          }
        }
      }
    }
    e(paramString, paramInt1, paramBoolean1, paramBoolean2);
  }
  
  public long b(MessageRecord paramMessageRecord)
  {
    return 0L;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb) {}
  
  public void bL(String paramString, int paramInt)
  {
    super.bL(paramString, paramInt);
    aeoa localaeoa = (aeoa)aeif.a().o(607);
    if ((localaeoa == null) || (localaeoa.bVj)) {
      return;
    }
    this.app.a().E(paramString, paramInt, 0);
  }
  
  public void e(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.app.a().A(paramString, paramInt) > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded clean one uin = " + paramString);
      }
      localMessageRecord = this.app.a(paramInt).a(paramString, paramInt);
      localtog = this.app.a();
      if (localMessageRecord != null)
      {
        l = b(localMessageRecord);
        localtog.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
        bL(paramString, paramInt);
        this.b.as(this.b.a(paramString, paramInt));
      }
    }
    while (this.app.a().B(paramString, paramInt) <= 0) {
      for (;;)
      {
        MessageRecord localMessageRecord;
        tog localtog;
        return;
        long l = 0L;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setTroopReaded clean one uin = " + paramString);
    }
    bL(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acro
 * JD-Core Version:    0.7.0.1
 */