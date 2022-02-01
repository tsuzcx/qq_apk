import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1.2;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.concurrent.Executor;

public class agkm
  extends agie
{
  long HO = 0L;
  final int cXw = 1000;
  
  agkm(agkl paramagkl) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (this.this$0.isStop())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay], SessionId[" + this.this$0.nSessionId + "], working stop!");
      return;
    }
    if ((TextUtils.isEmpty(this.this$0.c.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
      this.this$0.c.strFileMd5 = paramString6;
    }
    this.this$0.c.bUseMediaPlatform = paramBoolean2;
    ahav.a(this.this$0.c, this.this$0.app, null);
    if (!paramBoolean1)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay]id[" + String.valueOf(this.this$0.nSessionId) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramInt);
      this.this$0.setStatus(2005);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == -100001L) {}
      for (paramLong2 = 9043L;; paramLong2 = 9045L)
      {
        ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, paramLong2, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.a(this.this$0), "server ret error", null);
        ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, paramLong2, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.b(this.this$0), "server ret error", null);
        return;
      }
    }
    this.this$0.bHM = paramString2;
    if (paramString5 != null) {
      this.this$0.strFilePath = this.this$0.aX(this.this$0.strUin, paramString5);
    }
    Object localObject;
    int i;
    if ((agmx.aF(this.this$0.app)) && (paramBundle != null))
    {
      localObject = paramBundle.getString("strHttpsDomain");
      i = paramBundle.getShort("httpsPort", (short)0);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.this$0.cdQ = true;
        this.this$0.aEL = ((String)localObject);
        if (i == 0) {
          i = 443;
        }
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          localArrayList.add((String)localObject + ":" + i);
        }
      }
      localObject = null;
      paramList = (List<String>)localObject;
      if (paramString3 != null)
      {
        paramList = (List<String>)localObject;
        if (paramByteStringMicro != null)
        {
          localObject = paramString3 + ":" + i;
          paramList = (List<String>)localObject;
          if (agmx.ceo)
          {
            paramList = (List<String>)localObject;
            if (!this.this$0.cdQ) {
              paramList = "113.108.29.146:" + paramShort;
            }
          }
          localArrayList.add(0, paramList);
          paramList = "";
          if (paramBundle != null) {
            paramList = paramBundle.getString("IPv6Dns", "");
          }
          if ((TextUtils.isEmpty(paramList)) || (!agke.a().l(this.this$0.app, 1))) {
            break label1557;
          }
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. is config enable IPv6. domain[" + paramList + "]");
          paramList = new agke.a(paramList, i);
          paramList = agke.a().a(this.this$0.app, paramList, 1);
          if ((paramList == null) || (paramList.alz())) {
            break label1537;
          }
          if (agke.alt())
          {
            QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. debugIsDisableIPv4OnDoubleStack");
            localArrayList.clear();
          }
          agke.a(paramList.Bb, localArrayList, false, false);
          this.this$0.cXp = 2;
          if (paramList.cXn == 1) {
            this.this$0.cXp = 3;
          }
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv6. iplist:" + localArrayList.toString());
          agkl.a(this.this$0, new aglb(this.this$0.app, localArrayList, paramString4));
          if (!this.this$0.cdQ) {
            break label1568;
          }
          agkl.a(this.this$0).Jj(true);
          label1073:
          paramList = agkl.a(this.this$0).vg();
        }
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_V6SelectType", this.this$0.cXp);
      ((Bundle)localObject).putInt("param_ipAddrType", agkl.c(this.this$0));
      int j;
      if (this.this$0.cdQ)
      {
        j = 1;
        label1137:
        ((Bundle)localObject).putInt("param_ishttps", j);
        if (paramList != null) {
          break label1591;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay]id[" + String.valueOf(this.this$0.nSessionId) + "] get offlinefile info Url is null, IP is null too");
        this.this$0.setStatus(2005);
        if ((paramLong1 == -6101L) || (paramLong1 == -7003L)) {
          this.this$0.c.status = 16;
        }
        this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 12, null, (int)paramLong1, paramString1);
        if (paramLong1 != 0L) {
          break label1588;
        }
        paramLong1 = 9048L;
      }
      label1537:
      label1557:
      label1568:
      label1588:
      for (;;)
      {
        ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, paramLong1, String.valueOf(paramInt), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.a(this.this$0), "ip url error", null, (Bundle)localObject);
        ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, paramLong1, String.valueOf(paramInt), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.b(this.this$0), "ip url error", null, (Bundle)localObject);
        this.this$0.app.a().u(this.this$0.c);
        return;
        this.this$0.cXp = 1;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv4");
        break;
        this.this$0.cXp = 1;
        break;
        agkl.a(this.this$0).Jj(false);
        break label1073;
        j = 0;
        break label1137;
      }
      label1591:
      this.this$0.serverPath = paramList;
      agkl.a(this.this$0, this.this$0.serverPath);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]nSessionID[" + String.valueOf(this.this$0.nSessionId) + "],retCode[" + String.valueOf(paramLong1) + "] mUseHttps:" + this.this$0.cdQ + " mHttpsDomain:" + this.this$0.aEL + " downloadPort:" + i);
      if ((paramLong1 != 0L) && (paramString1 != null) && (paramString1.length() > 0))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.this$0.nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
        this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 4, null, (int)paramLong1, paramString1);
      }
      if (-1L != this.this$0.uniseq) {
        this.this$0.app.b().b(this.this$0.strUin, 0, this.this$0.uniseq);
      }
      paramList = MD5.toMD5(this.this$0.bHK);
      this.this$0.bHJ = (this.this$0.bHI + paramList);
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.this$0.nSessionId) + "] no network! return!");
        this.this$0.setStatus(2005);
        this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 1, null, 2, null);
        ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.a(this.this$0), "net", null, (Bundle)localObject);
        ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.b(this.this$0), "net", null, (Bundle)localObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.this$0.nSessionId) + "], strTmp[" + this.this$0.bHJ + "]");
      }
      this.this$0.YD = ahav.getFileSizes(this.this$0.bHJ);
      if (this.this$0.YD == this.this$0.nFileSize)
      {
        this.this$0.c.setCloudType(3);
        this.this$0.setStatus(2003);
        this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 11, new Object[] { this.this$0.strFilePath, Long.valueOf(this.this$0.nFileSize), Boolean.valueOf(true), this.this$0.serverPath }, 0, null);
        this.this$0.c.fileName = ahav.getFileName(this.this$0.strFilePath);
        if (this.this$0.c.fileName.getBytes().length > 250)
        {
          this.this$0.c.fileName = ahav.kY(this.this$0.c.fileName);
          this.this$0.strFilePath = this.this$0.aX(this.this$0.strUin, this.this$0.c.fileName);
        }
        if (aqhq.fileExists(this.this$0.strFilePath)) {
          this.this$0.strFilePath = ahav.kW(this.this$0.strFilePath);
        }
        ahav.b(new VFSFile(this.this$0.bHJ), new VFSFile(this.this$0.strFilePath));
        this.this$0.c.fileName = ahav.getFileName(this.this$0.strFilePath);
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.this$0.nSessionId) + "] is exist, and filesize is right!");
        ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, 0L, this.this$0.serverPath, this.this$0.strUin, this.this$0.serverPath, this.this$0.c.strFileMd5, 0L, 0L, this.this$0.nFileSize, agkl.b(this.this$0), null, (Bundle)localObject);
        return;
      }
      if (this.this$0.nFileSize > this.this$0.YD)
      {
        long l = this.this$0.nFileSize - this.this$0.YD;
        if (this.this$0.jdField_a_of_type_Ahaf.gc() < l)
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.this$0.nSessionId) + "] not enought space! ProcessNewPath");
          paramList = new ArrayList();
          paramList.addAll(localArrayList);
          agkl.a(this.this$0, l, new agkn(this, paramBoolean1, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, paramList, paramInt, paramString5, paramString6, paramString7, paramLong2, paramBundle));
          return;
        }
      }
      ahav.a.getExecutor().execute(new FileManagerRSWorker.1.2(this));
      return;
      continue;
      i = paramShort;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (this.this$0.isStop())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay] id[" + this.this$0.nSessionId + "]OnDiscDownloadInfo, network error");
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay]id[" + String.valueOf(this.this$0.nSessionId) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramInt2);
      this.this$0.setStatus(2005);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == -100001L) {}
      for (paramLong2 = 9043L;; paramLong2 = 9045L)
      {
        ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.a(this.this$0), "ret error", null);
        ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.b(this.this$0), "ret error", null);
        return;
      }
    }
    Object localObject1;
    if ((agmx.aJ(this.this$0.app)) && (paramBundle != null))
    {
      localObject1 = paramBundle.getString("strHttpsDomain");
      int j = paramBundle.getShort("httpsPort", (short)0);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.this$0.cdQ = true;
        this.this$0.aEL = ((String)localObject1);
        i = j;
        if (j != 0) {}
      }
    }
    for (int i = 443;; i = paramInt1)
    {
      if (paramBundle != null) {}
      for (localObject1 = paramBundle.getString("IPv6Dns", "");; localObject1 = "")
      {
        ArrayList localArrayList = null;
        Object localObject2 = localArrayList;
        if (paramString3 != null)
        {
          localObject2 = localArrayList;
          if (paramString4 != null)
          {
            String str = paramString3 + ":" + i;
            localObject2 = agkl.b(this.this$0, paramString4);
            localArrayList = new ArrayList(1);
            localArrayList.add(str);
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (agke.a().l(this.this$0.app, 5)))
            {
              QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. is config enable IPv6. domain[" + (String)localObject1 + "]");
              localObject1 = new agke.a((String)localObject1, i);
              localObject1 = agke.a().a(this.this$0.app, (agke.a)localObject1, 5);
              if ((localObject1 == null) || (((agke.c)localObject1).alz())) {
                break label1201;
              }
              if (agke.alt())
              {
                QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download.debugIsDisableIPv4OnDoubleStack");
                localArrayList.clear();
              }
              agke.a(((agke.c)localObject1).Bb, localArrayList, false, false);
              QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv6. hostlist:" + localArrayList.toString());
            }
            agkl.a(this.this$0, new aglb(this.this$0.app, localArrayList, (String)localObject2));
            if (!this.this$0.cdQ) {
              break label1213;
            }
            agkl.a(this.this$0).Jj(true);
            label850:
            localObject2 = agkl.a(this.this$0).vg();
          }
        }
        if (localObject2 == null)
        {
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay]id[" + String.valueOf(this.this$0.nSessionId) + "] get DiscdownLoad info Url is null");
          this.this$0.setStatus(2005);
          this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 12, null, (int)paramLong1, paramString1);
          if (paramLong1 == 0L) {
            paramLong1 = 9048L;
          }
          for (;;)
          {
            ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, paramLong1, String.valueOf(paramInt2), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.a(this.this$0), "ip url error", null);
            ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, paramLong1, String.valueOf(paramInt2), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.b(this.this$0), "ip url error", null);
            return;
            label1201:
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv4");
            break;
            label1213:
            agkl.a(this.this$0).Jj(false);
            break label850;
          }
        }
        this.this$0.serverPath = ((String)localObject2);
        agkl.a(this.this$0, this.this$0.serverPath);
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Disc Download Replay]nSessionID[" + String.valueOf(this.this$0.nSessionId) + "],retCode[" + String.valueOf(paramLong1) + "]downLoadUrl[" + String.valueOf(this.this$0.serverPath) + "] mUseHttps:" + this.this$0.cdQ + " mHttpsDomain:" + this.this$0.aEL + " downloadPort:" + i);
        if ((paramString1 != null) && (paramString1.length() > 0))
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.this$0.nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
          this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 4, null, (int)paramLong1, paramString1);
        }
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSeseeId[" + String.valueOf(this.this$0.nSessionId) + "]renamed[" + String.valueOf(paramString2) + "]");
          }
          this.this$0.strFilePath = this.this$0.aX(this.this$0.strUin, paramString2);
        }
        if (this.this$0.c.getCloudType() == 1) {
          this.this$0.strFilePath = ahav.kW(this.this$0.strFilePath);
        }
        this.this$0.bHJ = (this.this$0.bHI + "dsc-" + String.valueOf(this.this$0.c.Uuid.replace("/", "")));
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          this.this$0.setStatus(2005);
          this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 1, null, 2, null);
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.this$0.nSessionId) + "], NetWork Error, notify UI!");
          ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.a(this.this$0), "net", null);
          ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.b(this.this$0), "net", null);
          return;
        }
        this.this$0.app.a().ap(this.this$0.nSessionId, this.this$0.strFilePath);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.this$0.nSessionId) + "], strTmp[" + this.this$0.bHJ + "]");
        }
        this.this$0.YD = ahav.getFileSizes(this.this$0.bHJ);
        if (this.this$0.YD == this.this$0.nFileSize)
        {
          this.this$0.c.setCloudType(3);
          this.this$0.setStatus(2003);
          this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 11, new Object[] { this.this$0.strFilePath, Long.valueOf(this.this$0.nFileSize), Boolean.valueOf(true), this.this$0.serverPath }, 0, null);
          this.this$0.c.fileName = ahav.getFileName(this.this$0.strFilePath);
          if (this.this$0.c.fileName.getBytes().length > 250)
          {
            this.this$0.c.fileName = ahav.kY(this.this$0.c.fileName);
            this.this$0.strFilePath = this.this$0.aX(this.this$0.strUin, this.this$0.c.fileName);
          }
          if (aqhq.fileExists(this.this$0.strFilePath)) {
            this.this$0.strFilePath = ahav.kW(this.this$0.strFilePath);
          }
          ahav.b(new VFSFile(this.this$0.bHJ), new VFSFile(this.this$0.strFilePath));
          this.this$0.c.fileName = ahav.getFileName(this.this$0.strFilePath);
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.this$0.nSessionId) + "], fileExisted, notify UI!");
          ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, 0L, this.this$0.serverPath, this.this$0.strUin, this.this$0.serverPath, this.this$0.c.strFileMd5, 0L, 0L, this.this$0.nFileSize, agkl.b(this.this$0), null);
          return;
        }
        if (this.this$0.nFileSize > this.this$0.YD)
        {
          long l = this.this$0.nFileSize - this.this$0.YD;
          if (this.this$0.jdField_a_of_type_Ahaf.gc() < l)
          {
            agkl.a(this.this$0, l, new agko(this, paramBoolean, paramLong1, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2, paramBundle));
            return;
          }
        }
        ahav.a.getExecutor().execute(new FileManagerRSWorker.1.4(this, paramString5));
        return;
      }
    }
  }
  
  public void as(long paramLong1, long paramLong2)
  {
    this.this$0.c.fProgress = ((float)paramLong1 / (float)paramLong2);
    this.this$0.c.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.HO >= 1000L)
    {
      this.HO = paramLong1;
      this.this$0.c.setCloudType(3);
      this.this$0.app.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 4, "Id[" + String.valueOf(this.this$0.c.nSessionId) + "]Notify UI Progress! and send continue!");
      }
    }
  }
  
  protected void b(boolean paramBoolean, agib.b paramb, achq.a parama)
  {
    super.b(paramBoolean, paramb, parama);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] id[" + this.this$0.nSessionId + "]onDownloadFileSuc");
    if ((paramBoolean) && ((paramb.cXd == 2) || (paramb.cXd == 0)) && (!this.this$0.c.bSend))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramb.retCode + "],retMsg[" + paramb.retMsg + "],retStat[" + paramb.cXd + "]. need to send file receipt");
      if (this.this$0.c.strSrcName != null)
      {
        this.this$0.app.a().a(this.this$0.strUin, this.this$0.c.strSrcName, this.this$0.c.Uuid, this.this$0.nFileSize, this.this$0.c.uniseq);
        return;
      }
      this.this$0.app.a().a(this.this$0.strUin, this.this$0.c.fileName, this.this$0.c.Uuid, this.this$0.nFileSize, this.this$0.c.uniseq);
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramb.retCode + "],retMsg[" + paramb.retMsg + "],retStat[" + paramb.cXd + "]. don't need to send file receipt");
  }
  
  protected void b(boolean paramBoolean, agib.b paramb, achq.a parama, List<String> paramList)
  {
    if ((paramb.retCode == 0) && (!this.this$0.isStop))
    {
      if (this.this$0.jdField_a_of_type_Agzu != null) {
        this.this$0.jdField_a_of_type_Agzu.stop();
      }
      this.this$0.clearTask();
      if ((paramb.uuid == null) || (paramb.uuid.length <= 0)) {
        break label272;
      }
      this.this$0.bHK = new String(paramb.uuid);
      this.this$0.c.Uuid = this.this$0.bHK;
    }
    for (;;)
    {
      this.this$0.YG = System.currentTimeMillis();
      this.this$0.endTime = System.currentTimeMillis();
      ahav.jR(this.this$0.c.nSessionId);
      this.this$0.app.a().a(this.this$0.c, 5, this.this$0.serverPath);
      this.this$0.app.a().a(this.this$0.c, this.this$0.selfUin, this.this$0.strUin, this.this$0.c.Uuid, agkl.a(this.this$0));
      paramb = new ahau.a();
      paramb.bJE = "send_file_suc";
      paramb.cYX = 1;
      ahau.a(this.this$0.app.getCurrentAccountUin(), paramb);
      this.this$0.c.status = 1;
      this.this$0.app.a().u(this.this$0.c);
      return;
      label272:
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
  }
  
  public void dgt()
  {
    this.this$0.dhv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agkm
 * JD-Core Version:    0.7.0.1
 */