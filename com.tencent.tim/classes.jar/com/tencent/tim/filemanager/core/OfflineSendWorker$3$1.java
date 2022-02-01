package com.tencent.tim.filemanager.core;

import agib.b;
import attf;
import atti;
import attu;
import atud;
import atue;
import atvz;
import atwx;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class OfflineSendWorker$3$1
  implements Runnable
{
  public OfflineSendWorker$3$1(atue paramatue, agib.b paramb, List paramList) {}
  
  public void run()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId) + "],retCode[" + String.valueOf(this.jdField_a_of_type_Agib$b.retCode) + "]");
    if ((this.jdField_a_of_type_Agib$b.retMsg != null) && (this.jdField_a_of_type_Agib$b.retMsg.length() > 0))
    {
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "id[" + String.valueOf(atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId) + "] will show taost, retCode[" + String.valueOf(this.jdField_a_of_type_Agib$b.retCode) + "], retMsg:" + this.jdField_a_of_type_Agib$b.retMsg);
      atud.a(this.jdField_a_of_type_Atue.this$0).a().a(atud.a(this.jdField_a_of_type_Atue.this$0).uniseq, atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId, atud.a(this.jdField_a_of_type_Atue.this$0).peerUin, atud.a(this.jdField_a_of_type_Atue.this$0).peerType, 4, null, this.jdField_a_of_type_Agib$b.retCode, this.jdField_a_of_type_Agib$b.retMsg);
    }
    if ((this.jdField_a_of_type_Agib$b.uuid != null) && (this.jdField_a_of_type_Agib$b.uuid.length > 0))
    {
      atud.a(this.jdField_a_of_type_Atue.this$0).Uuid = new String(this.jdField_a_of_type_Agib$b.uuid);
      if ((!this.jdField_a_of_type_Agib$b.fileExist) || (this.jdField_a_of_type_Agib$b.fileSize > 104857600L)) {
        break label374;
      }
      atud.b(this.jdField_a_of_type_Atue.this$0);
    }
    label374:
    do
    {
      return;
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "=_= ^! nSessionID[" + String.valueOf(atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId) + "]!!!!!Server Return the UUID is null!!!!!");
      break;
      atud.a(this.jdField_a_of_type_Atue.this$0).status = 0;
      atud.a(this.jdField_a_of_type_Atue.this$0).a().u(atud.a(this.jdField_a_of_type_Atue.this$0));
      atud.a(this.jdField_a_of_type_Atue.this$0).status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId) + "]");
      }
      if (atvz.ceo)
      {
        this.Bg.clear();
        this.Bg.add(0, "14.17.29.27:" + this.jdField_a_of_type_Agib$b.ag);
      }
      String str = HexUtil.bytes2HexStr(this.jdField_a_of_type_Agib$b.key);
      if (1 == this.jdField_a_of_type_Agib$b.cXe)
      {
        str = "/?ver=2&ukey=" + str + "&filekey=" + atud.a(this.jdField_a_of_type_Atue.this$0) + "&filesize=" + atud.a(this.jdField_a_of_type_Atue.this$0).fileSize;
        atud.a(this.jdField_a_of_type_Atue.this$0).strServerPath = ("http://" + (String)this.Bg.get(0) + str);
        atud.a(this.jdField_a_of_type_Atue.this$0, attu.a(atud.a(this.jdField_a_of_type_Atue.this$0), atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId, atud.a(this.jdField_a_of_type_Atue.this$0).peerType, 0, atud.a(this.jdField_a_of_type_Atue.this$0).getFilePath(), this.Bg, str));
      }
      for (;;)
      {
        if (atud.a(this.jdField_a_of_type_Atue.this$0) == null) {
          break label1234;
        }
        atud.b(this.jdField_a_of_type_Atue.this$0, false);
        atud.a(this.jdField_a_of_type_Atue.this$0).a(this.jdField_a_of_type_Atue.this$0);
        if (atud.a(this.jdField_a_of_type_Atue.this$0).cd(0L)) {
          break;
        }
        atud.a(this.jdField_a_of_type_Atue.this$0, 1005);
        atud.a(this.jdField_a_of_type_Atue.this$0).a().a(atud.a(this.jdField_a_of_type_Atue.this$0).uniseq, atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId, atud.a(this.jdField_a_of_type_Atue.this$0).peerUin, atud.a(this.jdField_a_of_type_Atue.this$0).peerType, 15, null, 0, "");
        atud.a(this.jdField_a_of_type_Atue.this$0, atud.a(this.jdField_a_of_type_Atue.this$0).fileSize, 9045, "sendFile error");
        atud.b(this.jdField_a_of_type_Atue.this$0, atud.a(this.jdField_a_of_type_Atue.this$0).fileSize, 9045, "sendFile error");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId + "],sendFile return false");
        return;
        if (2 == this.jdField_a_of_type_Agib$b.cXe)
        {
          atud.a(this.jdField_a_of_type_Atue.this$0).strServerPath = ("http://" + (String)this.Bg.get(0) + "/ftn_handler");
          atud.a(this.jdField_a_of_type_Atue.this$0).bombData = str.getBytes();
          if (this.jdField_a_of_type_Agib$b.sha != null)
          {
            atud.a(this.jdField_a_of_type_Atue.this$0).strFileSHA = atwx.t(this.jdField_a_of_type_Agib$b.sha);
            atud.a(this.jdField_a_of_type_Atue.this$0, true);
          }
          atud.a(this.jdField_a_of_type_Atue.this$0, attu.a(atud.a(this.jdField_a_of_type_Atue.this$0), atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId, atud.a(this.jdField_a_of_type_Atue.this$0).peerType, 0, atud.a(this.jdField_a_of_type_Atue.this$0).getFilePath(), str, atud.a(this.jdField_a_of_type_Atue.this$0).strFileSHA, this.Bg, "/ftn_handler"));
        }
        else
        {
          QLog.w("OfflineSendWorker<FileAssistant>", 1, "onUpdateSendOfflineFile httpsvrApiVer[" + this.jdField_a_of_type_Agib$b.cXe + "] not recognized");
        }
      }
      atud.a(this.jdField_a_of_type_Atue.this$0, 1005);
      atud.a(this.jdField_a_of_type_Atue.this$0).a().a(atud.a(this.jdField_a_of_type_Atue.this$0).uniseq, atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId, atud.a(this.jdField_a_of_type_Atue.this$0).peerUin, atud.a(this.jdField_a_of_type_Atue.this$0).peerType, 15, null, this.jdField_a_of_type_Agib$b.retCode, this.jdField_a_of_type_Agib$b.retMsg);
      atud.a(this.jdField_a_of_type_Atue.this$0, atud.a(this.jdField_a_of_type_Atue.this$0).fileSize, 9045, "upload param error");
      atud.b(this.jdField_a_of_type_Atue.this$0, atud.a(this.jdField_a_of_type_Atue.this$0).fileSize, 9045, "upload param error");
    } while (!QLog.isColorLevel());
    label1234:
    QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + atud.a(this.jdField_a_of_type_Atue.this$0).nSessionId + "],retCode[" + this.jdField_a_of_type_Agib$b.retCode + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.OfflineSendWorker.3.1
 * JD-Core Version:    0.7.0.1
 */