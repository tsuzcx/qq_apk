package com.tencent.mobileqq.filemanager.app;

import agir;
import agir.i;
import agir.j;
import agir.k;
import agnn;
import ahav;
import android.text.TextUtils;
import anot;
import aqiw;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class QFileMsgForwardManager$1
  implements Runnable
{
  public QFileMsgForwardManager$1(agir paramagir, agnn paramagnn) {}
  
  public void run()
  {
    boolean bool = aqiw.isNetworkAvailable(null);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "isNetworkAvailable:" + bool);
    }
    String str1 = this.a.vk();
    String str2 = this.a.vl();
    int i = this.a.Ew();
    HashMap localHashMap = this.a.J();
    if ((localHashMap == null) || (localHashMap.isEmpty()))
    {
      this.a.b(0, new ArrayList(), new ArrayList());
      return;
    }
    agir.k localk = new agir.k(this.this$0, str1, this.a, localHashMap);
    Iterator localIterator1 = localHashMap.keySet().iterator();
    long l1 = 0L;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localHashMap.get((String)localIterator1.next())).iterator();
      long l2 = l1;
      for (;;)
      {
        l1 = l2;
        if (!localIterator2.hasNext()) {
          break;
        }
        Object localObject = (MessageRecord)localIterator2.next();
        if ((ahav.ax((MessageRecord)localObject)) && (agir.a(this.this$0, (MessageRecord)localObject)))
        {
          agir.i locali = agir.a(this.this$0, str2, i, str1, (MessageRecord)localObject);
          if (locali == null) {
            break label301;
          }
          localk.a(locali);
          if (!bool) {
            locali.b.ch("", true);
          }
          localObject = ((MessageRecord)localObject).getExtInfoFromExtStr("_m_ForwardSize");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            l2 += Long.valueOf((String)localObject).longValue();
          }
        }
      }
      label301:
      QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : createUploadTask failed. forwardMsgSeq[" + str1 + "] toUin[" + str2 + "] toType[" + i + "] ");
      this.a.b(1, new ArrayList(), new ArrayList());
      return;
    }
    if (localk.getTaskCount() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : forwardMsgSeq[" + str1 + "] toUin[" + str2 + "] toType[" + i + "] uploadCount[" + localk.getTaskCount() + "]");
      }
      str2 = new DecimalFormat("0.00").format(l1 / 1024.0D / 1024.0D);
      anot.a(agir.a(this.this$0), "dc00898", "", "", "0X8009ABE", "0X8009ABE", 0, 0, "", "", str2, "");
      agir.a(this.this$0).put(str1, localk);
      localk.start();
      return;
    }
    this.a.b(0, new ArrayList(), new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.1
 * JD-Core Version:    0.7.0.1
 */