import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class auab
  extends BroadcastReceiver
{
  auab(auaa paramauaa) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.c.b();
    if (paramIntent == null) {}
    Object localObject;
    label420:
    label452:
    label505:
    do
    {
      do
      {
        boolean bool;
        int i;
        do
        {
          long l1;
          do
          {
            do
            {
              for (;;)
              {
                return;
                localObject = paramIntent.getAction();
                if (localObject != null)
                {
                  if (!((String)localObject).equals("com.dataline.mpfile.download_progress")) {
                    break;
                  }
                  if (paramIntent.getLongExtra("token_task_id", 0L) == paramContext.uniseq)
                  {
                    l1 = paramIntent.getLongExtra("token_current_size", 0L);
                    l2 = paramIntent.getLongExtra("token_total_size", 0L);
                    paramContext.status = 2;
                    if (l2 != 0L) {
                      paramContext.setfProgress((float)l1 / (float)l2);
                    }
                    while (this.a.a != null)
                    {
                      this.a.a.aO(paramContext.getfProgress());
                      return;
                      paramContext.setfProgress(1.0F);
                    }
                  }
                }
              }
              if (!((String)localObject).equals("com.dataline.mpfile.download_completed")) {
                break;
              }
              l1 = paramIntent.getLongExtra("token_task_id", 0L);
            } while (l1 != paramContext.uniseq);
            auaa.a(this.a, NetConnInfoCenter.getServerTimeMillis());
            long l2 = paramIntent.getLongExtra("token_current_size", 0L);
            bool = paramIntent.getBooleanExtra("token_is_success", false);
            j = paramIntent.getIntExtra("token_http_code", 0);
            QLog.d("MPcFileModel", 2, "BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:" + l2 + ",isSucceed:" + bool + ",http_code:" + j);
            paramIntent = new ReportItem();
            paramIntent.uSessionID = l1;
            paramIntent.uChannelType = 6;
            paramIntent.bSend = false;
            paramIntent.uNotifyTime = auaa.a(this.a);
            paramIntent.uFileSize = l2;
            paramIntent.bFileExist = false;
            paramIntent.uStartPos = 0L;
            paramIntent.uTaskStart = auaa.a(this.a);
            paramIntent.uTaskEnd = auaa.b(this.a);
            paramIntent.uDuration = (auaa.b(this.a) - auaa.a(this.a));
            paramIntent.bUserRetry = false;
            paramIntent.sSuffix = "";
            if (bool)
            {
              i = 2;
              paramIntent.emResult = i;
              paramIntent.nFailCode = 0;
              paramIntent.nUserCode = j;
              localObject = ((acde)this.a.mAppInterface.getBusinessHandler(8)).a().a();
              if (localObject == null) {
                break label631;
              }
              paramIntent.dwServerIP = ct.k(((avip)localObject).serverIp);
              paramIntent.wServerPort = ((short)((avip)localObject).serverPort);
              paramIntent.dwClientIP = ct.k(ct.K());
              localObject = this.a.mAppInterface;
              if (paramContext.peerDin != 0L) {
                break label644;
              }
              i = dt.dM;
              dt.a((QQAppInterface)localObject, paramIntent, i);
              if (bool) {
                break label737;
              }
              paramContext.status = 3;
              if ((j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 8)) {
                break label651;
              }
              auds.OS(2131696023);
              if (this.a.a != null) {
                this.a.a.djH();
              }
            }
            for (;;)
            {
              ((acde)this.a.mAppInterface.getBusinessHandler(8)).a().a(paramContext.strDataLineMPFileID);
              if (auaa.b(this.a)) {
                break label841;
              }
              paramContext.mContext = "needMPFileC2C";
              QLog.d("MPcFileModel", 2, "mConnPCSuc:" + auaa.b(this.a) + ",create mEntity.mContext");
              return;
              if (auaa.a(this.a))
              {
                i = 32;
                break;
              }
              i = 41;
              break;
              paramIntent.dwServerIP = 0;
              paramIntent.wServerPort = 0;
              break label420;
              i = dt.dO;
              break label452;
              if (j == 1)
              {
                auds.OS(2131696021);
                break label505;
              }
              if (j == 1004)
              {
                auds.OS(2131696022);
                break label505;
              }
              if (j == 11)
              {
                QLog.d("MPcFileModel", 2, "cancel file download!");
                break label505;
              }
              if (j == 12)
              {
                QLog.d("MPcFileModel", 2, "cancel file predownload!");
                break label505;
              }
              auaa.a(this.a, j + 2100);
              break label505;
              paramContext.status = 1;
              paramIntent = ((acde)this.a.mAppInterface.getBusinessHandler(8)).a().ae();
              if (paramIntent == null) {
                if (QLog.isColorLevel()) {
                  QLog.d("MPcFileModel", 2, "doDownload , plugin service not started");
                }
              }
              for (;;)
              {
                if (this.a.a == null) {
                  break label839;
                }
                this.a.a.djG();
                break;
                paramContext.setFilePath(String.format("%s/%s", new Object[] { paramIntent, paramContext.fileName }));
                paramContext.setCloudType(3);
              }
            }
            QLog.d("MPcFileModel", 2, "mConnPCSuc:" + auaa.b(this.a) + "mEntity.mContext = null");
            paramContext.mContext = null;
            return;
            if (!avin.cKW.equalsIgnoreCase((String)localObject)) {
              break;
            }
            paramContext = paramIntent.getExtras();
            l1 = paramIntent.getLongExtra(avin.cKY, 0L);
            i = paramContext.getInt(avin.cKX);
            j = paramContext.getInt("result");
            if ((i == 0) && (j == 0)) {
              auaa.a(this.a, true);
            }
            QLog.d("MPcFileModel[MPFile]", 1, "mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:" + i);
          } while (auaa.c(this.a) != l1);
          if (i != 0) {
            break;
          }
          i = paramContext.getInt("result");
          paramIntent = paramContext.getByteArray("bytes_json");
          int j = paramContext.getInt("power");
          auaa.b(this.a, j);
          bool = paramContext.getBoolean("inputPwdError", false);
          switch (i)
          {
          default: 
            QLog.d("MPcFileModel", 1, "andorid 6.3.0 accept valid C2C response:" + i);
            return;
          case 0: 
            this.a.djK();
            return;
          case 1: 
          case 2: 
          case 3: 
          case 4: 
            auaa.a(this.a, i + 2000);
          }
        } while (this.a.e == null);
        this.a.e.ar(false);
        return;
        this.a.b(paramIntent, bool);
        return;
        this.a.p(paramIntent);
        return;
        this.a.fL();
        return;
        this.a.fM();
        return;
        if (i == 1013)
        {
          auds.OS(2131696012);
          return;
        }
        if (i == 1014)
        {
          auds.OS(2131696038);
          return;
        }
        auaa.a(this.a, i);
      } while (this.a.e == null);
      this.a.e.ar(false);
      return;
    } while (!avin.cKZ.equalsIgnoreCase((String)localObject));
    label631:
    auaa.a(this.a, false);
    label644:
    label651:
    label737:
    QLog.d("MPcFileModel[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
    label839:
    label841:
    auds.OS(2131696022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auab
 * JD-Core Version:    0.7.0.1
 */