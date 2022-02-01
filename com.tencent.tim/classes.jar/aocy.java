import android.content.Context;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.1;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.2;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class aocy
  implements Manager
{
  private List<MessageRecord> GS = new ArrayList();
  private aoct jdField_a_of_type_Aoct;
  private aocx jdField_a_of_type_Aocx;
  public long aoU = 0L;
  private int cM = -1;
  private QQAppInterface mApp;
  
  public aocy(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Aocx = new aocx(paramQQAppInterface);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, String paramString1, String paramString2, String paramString3, aetr.b paramb)
  {
    if (!this.jdField_a_of_type_Aocx.azv())
    {
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "last insert time less");
      }
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("DataLineMessageSpreadManager", 1, "insertGaryTips:" + paramString1 + " link:" + paramString2);
    }
    this.jdField_a_of_type_Aocx.i(paramDataLineMsgRecord);
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new DataLineMessageSpreadManager.2(this, paramDataLineMsgRecord, paramString1, paramb, paramString2, paramString3), 1000L);
  }
  
  private boolean d(DataLineMsgRecord paramDataLineMsgRecord)
  {
    int i = this.jdField_a_of_type_Aocx.getLocalCount();
    int j = aets.a().getMaxCount();
    if (j == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "config is max: 0, return");
      }
    }
    do
    {
      return false;
      if (i <= j) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("DataLineMessageSpreadManager", 1, "file count over[" + i + "], return");
    return false;
    return true;
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord, Context paramContext)
  {
    paramDataLineMsgRecord = paramDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_msg_uiniseq");
    try
    {
      l = Long.parseLong(paramDataLineMsgRecord);
      i = DataLineMsgRecord.getDevTypeBySeId(l);
      paramDataLineMsgRecord = this.mApp.b().a(i).a(l);
      if (paramDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DataLineMessageSpreadManager", 1, "garyTips not find fileMsg");
        }
        return;
      }
    }
    catch (Exception paramDataLineMsgRecord)
    {
      long l;
      int i;
      for (;;)
      {
        QLog.e("DataLineMessageSpreadManager", 1, paramDataLineMsgRecord.toString());
        l = 0L;
      }
      anot.a(this.mApp, "dc00898", "", "", "0X80098F8", "0X80098F8", 0, 0, "", "", "", "");
      paramDataLineMsgRecord = paramDataLineMsgRecord.trans2Entity();
      if (paramDataLineMsgRecord == null)
      {
        QLog.e("DataLineMessageSpreadManager", 1, "query Entity is nyll!!!, uniseq[" + l + "]");
        return;
      }
      aoag.a(paramDataLineMsgRecord, paramContext, this.mApp, 6, i);
    }
  }
  
  public void d(aetr paramaetr)
  {
    this.jdField_a_of_type_Aocx.b(paramaetr);
  }
  
  public void g(MessageRecord paramMessageRecord, int paramInt)
  {
    this.cM = paramInt;
    if (paramMessageRecord == null)
    {
      QLog.e("DataLineMessageSpreadManager", 1, ahav.ti());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DataLineMessageSpreadManager", 1, "send file:" + paramMessageRecord.msgUid);
    }
    ThreadManager.getUIHandler().postDelayed(new DataLineMessageSpreadManager.3(this), 1000L);
    try
    {
      this.GS.add(paramMessageRecord);
      this.aoU = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "lastInsertTime[" + this.aoU + "],lstCache size[" + this.GS.size() + "]");
      }
      return;
    }
    finally {}
  }
  
  public void j(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (QLog.isDebugVersion())
    {
      QLog.i("DataLineMessageSpreadManager", 4, "ready to post to SubThread Process， msgUid[" + paramDataLineMsgRecord.msgUid + "], hashCode:" + paramDataLineMsgRecord.hashCode());
      if (paramDataLineMsgRecord.msgUid == 0L) {
        ahav.ti();
      }
    }
    ThreadManager.executeOnSubThread(new DataLineMessageSpreadManager.1(this, paramDataLineMsgRecord));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocy
 * JD-Core Version:    0.7.0.1
 */