package com.tencent.mobileqq.filemanager.core;

import agib.b;
import agkf;
import agkh;
import agkv;
import aglc;
import agll;
import agmx;
import agoy;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class OfflineSendWorker$4
  implements Runnable
{
  public OfflineSendWorker$4(agll paramagll, agib.b paramb, boolean paramBoolean, String paramString, List paramList1, List paramList2, int paramInt) {}
  
  public void run()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.this$0.c.nSessionId) + "] onUpdateSendOfflineFile,retCode[" + String.valueOf(this.a.retCode) + "] bUseHttps:" + this.ceb + " httpsDomain:" + this.bHZ);
    if ((this.a.retMsg != null) && (this.a.retMsg.length() > 0))
    {
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "id[" + String.valueOf(this.this$0.c.nSessionId) + "] will show taost, retCode[" + String.valueOf(this.a.retCode) + "], retMsg:" + this.a.retMsg);
      this.this$0.mApp.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 4, null, this.a.retCode, this.a.retMsg);
    }
    if ((this.a.uuid != null) && (this.a.uuid.length > 0))
    {
      this.this$0.c.Uuid = new String(this.a.uuid);
      this.this$0.c.bUseMediaPlatform = this.a.bUseMediaPlatform;
      if ((!this.a.fileExist) || ((!this.a.bUseMediaPlatform) && (this.this$0.c.fileSize > 104857600L))) {
        break label480;
      }
      this.this$0.cdZ = true;
      QLog.d("OfflineSendWorker<FileAssistant>", 1, "=_= ^! nSessionID[" + String.valueOf(this.this$0.c.nSessionId) + "] onUpdateSendOfflineFile: miaochuan bUseMediaPlatform " + this.a.bUseMediaPlatform);
      if (this.a.bUseMediaPlatform) {
        this.this$0.c.fileIdCrc = this.a.bHi;
      }
      agll.a(this.this$0);
    }
    label480:
    do
    {
      return;
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "=_= ^! nSessionID[" + String.valueOf(this.this$0.c.nSessionId) + "]!!!!!Server Return the UUID is null!!!!!");
      break;
      this.this$0.c.status = 0;
      this.this$0.mApp.a().u(this.this$0.c);
      this.this$0.c.status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(this.this$0.c.nSessionId) + "]");
      }
      if ((agmx.ceo) && (!this.ceb))
      {
        this.Bg.clear();
        this.Bg.add(0, "14.17.29.27:" + this.a.ag);
      }
      String str = HexUtil.bytes2HexStr(this.a.key);
      if (this.this$0.alF())
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.this$0.c.nSessionId) + "] upload file use comstom uploader");
        this.this$0.a = this.this$0.a(this.a, this.Bh, this.cXG, this.ceb, this.bHZ);
      }
      for (;;)
      {
        if (this.this$0.a != null)
        {
          agll.a(this.this$0, false);
          this.this$0.a.a(this.this$0);
          if (!this.this$0.a.cd(0L))
          {
            agll.a(this.this$0, 1005);
            this.this$0.mApp.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 15, null, 0, "");
            agll.a(this.this$0, this.this$0.c.fileSize, 9045, "sendFile error");
            agll.b(this.this$0, this.this$0.c.fileSize, 9045, "sendFile error");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + this.this$0.c.nSessionId + "],sendFile return false");
            return;
            if (1 == this.a.cXe)
            {
              str = "/?ver=2&ukey=" + str + "&filekey=" + agll.a(this.this$0) + "&filesize=" + this.this$0.c.fileSize;
              this.this$0.c.strServerPath = ("http://" + (String)this.Bg.get(0) + str);
              this.this$0.a = agkv.a(this.this$0.mApp, this.this$0.c.nSessionId, this.this$0.c.peerType, 0, this.this$0.c.getFilePath(), this.Bg, str);
              continue;
            }
            if (2 == this.a.cXe)
            {
              if (this.ceb)
              {
                this.this$0.c.strServerPath = ("https://" + (String)this.Bg.get(0) + "/ftn_handler");
                this.this$0.c.httpsDomain = this.bHZ;
              }
              for (;;)
              {
                this.this$0.c.bombData = str.getBytes();
                if (this.a.sha != null)
                {
                  this.this$0.c.strFileSHA = agoy.t(this.a.sha);
                  this.this$0.dhE();
                }
                this.this$0.a = agkv.a(this.this$0.mApp, this.this$0.c.nSessionId, this.this$0.c.peerType, 0, this.this$0.c.getFilePath(), str, this.this$0.c.strFileSHA, this.Bg, "/ftn_handler", this.ceb, this.bHZ);
                break;
                this.this$0.c.strServerPath = ("http://" + (String)this.Bg.get(0) + "/ftn_handler");
              }
            }
            QLog.w("OfflineSendWorker<FileAssistant>", 1, "onUpdateSendOfflineFile httpsvrApiVer[" + this.a.cXe + "] not recognized");
            continue;
          }
          this.this$0.jq(System.currentTimeMillis());
          return;
        }
      }
      agll.a(this.this$0, 1005);
      this.this$0.mApp.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 15, null, this.a.retCode, this.a.retMsg);
      agll.a(this.this$0, this.this$0.c.fileSize, 9045, "upload param error");
      agll.b(this.this$0, this.this$0.c.fileSize, 9045, "upload param error");
    } while (!QLog.isColorLevel());
    QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + this.this$0.c.nSessionId + "],retCode[" + this.a.retCode + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineSendWorker.4
 * JD-Core Version:    0.7.0.1
 */