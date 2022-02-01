import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class agpq
  extends agie
{
  agpq(agpp paramagpp, ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (this.a.isStop())
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= vk [CS Replay]id[" + String.valueOf(agpp.a(this.a).nSessionId) + "] but isStoped");
      return;
    }
    this.a.a.diP();
    if (!paramBoolean1)
    {
      this.a.a.jG(paramLong1);
      this.a.j(null, 0);
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      agpp.a(this.a).diF();
      this.a.j(null, 0);
      return;
    }
    this.b.fileSize = agpp.a(this.a).fileSize;
    this.b.isSupportHttps = false;
    paramInt = paramShort;
    if (agmx.aF(agpp.a(this.a)))
    {
      paramInt = paramShort;
      if (paramBundle != null)
      {
        paramString6 = paramBundle.getString("strHttpsDomain");
        short s = paramBundle.getShort("httpsPort", (short)0);
        paramInt = paramShort;
        if (!TextUtils.isEmpty(paramString6))
        {
          paramShort = s;
          if (s == 0) {
            paramShort = 443;
          }
          this.b.isSupportHttps = true;
          this.b.sslCName = paramString6;
          paramInt = paramShort;
        }
      }
    }
    this.a.cea = this.b.isSupportHttps;
    this.a.a.Ju(this.a.cea);
    if ((TextUtils.isEmpty(paramString3)) || (paramByteStringMicro == null))
    {
      if ((paramLong1 == -6101L) || (paramLong1 == -7003L)) {
        agpp.a(this.a).status = 16;
      }
      if (paramLong1 == 0L)
      {
        this.a.a.a.ZB = 9048L;
        this.a.a.a.ZA = 2L;
        this.a.a.Oq(5);
        this.a.a.Js(false);
      }
      for (;;)
      {
        this.a.j(null, (int)paramLong1);
        return;
        this.a.a.jH(paramLong1);
      }
    }
    if ((paramLong1 != 0L) && (paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(agpp.a(this.a).nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
      agpp.a(this.a).a().a(agpp.a(this.a).uniseq, agpp.a(this.a).nSessionId, agpp.a(this.a).peerUin, agpp.a(this.a).peerType, 4, null, (int)paramLong1, paramString1);
    }
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = new ArrayList();
    }
    paramString1.add(0, paramString3);
    paramByteStringMicro = "";
    if (paramBundle != null) {
      paramByteStringMicro = paramBundle.getString("IPv6Dns", "");
    }
    if ((!TextUtils.isEmpty(paramByteStringMicro)) && (agke.a().l(agpp.a(this.a), 1)))
    {
      QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. is config enable IPv6. domain[" + paramByteStringMicro + "]");
      paramByteStringMicro = new agke.a(paramByteStringMicro, paramInt);
      paramByteStringMicro = agke.a().a(agpp.a(this.a), paramByteStringMicro, 1);
      if ((paramByteStringMicro != null) && (!paramByteStringMicro.alz()))
      {
        if (agke.alt())
        {
          QLog.d("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. debugIsDisableIPv4OnDoubleStack");
          paramString1.clear();
        }
        agke.a(paramByteStringMicro.Bb, paramString1, true, true);
        agpp.a(this.a, 2);
        if (paramByteStringMicro.cXn == 1) {
          agpp.a(this.a, 3);
        }
        QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv6. iplist:" + paramByteStringMicro.toString());
      }
    }
    for (;;)
    {
      this.a.a.Oo(agpp.a(this.a));
      QLog.i("C2CFileDownloader<FileAssistant>", 1, "get lstUrl size:" + paramString1.size());
      paramByteStringMicro = new ArrayList();
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext()) {
        paramByteStringMicro.add(new ExcitingTransferHostInfo((String)paramString1.next(), paramInt));
      }
      agpp.a(this.a, 1);
      QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv4");
      continue;
      agpp.a(this.a, 1);
    }
    this.b.mHosts = ((ExcitingTransferHostInfo[])paramByteStringMicro.toArray(new ExcitingTransferHostInfo[paramByteStringMicro.size()]));
    this.b.strCookie = ("Cookie:t=0;v=" + AppSetting.getAppId() + ";" + paramString2 + ";\r\n");
    this.b.serverPath = paramString4;
    this.b.strTempFilePath = this.a.getTmpFilePath();
    this.b.strFileName = paramString5;
    this.b.strSaveFileDir = agpp.a(this.a).vZ();
    agpp.a(this.a).bUseMediaPlatform = paramBoolean2;
    agpp.a(this.a).status = 2;
    this.a.a.diQ();
    agpp.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpq
 * JD-Core Version:    0.7.0.1
 */