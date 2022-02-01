import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.List;

class apfe
  extends smq.f
{
  apfe(apfd paramapfd) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "[" + this.a.coy + "] onReqDownloadResult isSuccess:false  errCode:" + paramInt1);
      this.a.a.resultCode = 2;
      this.a.e(true, apue.a.dVY, apue.a.dWx, 103);
      return;
    }
    apef.b.i("TroopZipInnerFileDownloadWorker", apef.b.USR, "[" + this.a.coy + "] onReqDownloadResult isSuccess:true  int32_ret_code:" + paramInt1);
    if ((paramInt1 == 0) || ((TextUtils.isEmpty(paramString3)) && (paramInt2 == 0)))
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "[" + this.a.coy + "] onReqDownloadResult. no host");
      this.a.a.resultCode = 1;
      this.a.a.dTI = 101;
      this.a.e(true, apue.a.dVZ, apue.a.dWu, 1);
      return;
    }
    paramString1 = ahav.e(paramByteStringMicro1);
    if (TextUtils.isEmpty(paramString1))
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "[" + this.a.coy + "] onReqDownloadResult. no string_download_url");
      this.a.a.resultCode = 1;
      this.a.a.dTI = 102;
      this.a.e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    paramString2 = aurr.encodeUrl(this.a.c.zipInnerPath);
    paramByteStringMicro1 = (QQAppInterface)this.n.get();
    if ((paramByteStringMicro1 != null) && (apsv.bS(paramByteStringMicro1)) && (apsv.bT(paramByteStringMicro1)) && (paramBundle != null))
    {
      paramByteStringMicro1 = paramBundle.getString("strHttpsDomain");
      if (!TextUtils.isEmpty(paramByteStringMicro1))
      {
        this.a.mIsHttps = true;
        this.a.aEL = paramByteStringMicro1;
        int i = (short)paramBundle.getInt("httpsPort", 0);
        paramInt1 = i;
        if (i != 0) {}
      }
    }
    for (paramInt1 = 443;; paramInt1 = 0)
    {
      if (this.a.mIsHttps) {}
      for (;;)
      {
        this.a.coA = ("/ftn_compress_getfile/rkey=" + paramString1 + "&filetype=" + this.a.c.zipType + "&path=" + paramString2 + "&mType=Other");
        paramString1 = paramString3 + ":" + paramInt1;
        this.a.mUrlList.add(paramString1);
        if (paramInt2 != 0)
        {
          paramString2 = this.a.d(paramInt2) + ":" + paramInt1;
          this.a.mUrlList.add(paramString2);
        }
        if (this.a.mIsHttps) {
          paramString1 = "https://" + paramString1 + this.a.coA;
        }
        for (;;)
        {
          this.a.c.PreviewUrl = paramString1;
          try
          {
            paramString1 = new URL(paramString1);
            this.a.c.DownloadIp = paramString1.getHost();
            apef.b.i("TroopZipInnerFileDownloadWorker", apef.b.USR, "[" + this.a.coy + "] onReqDownloadResult. str_download_dns:" + paramString3 + " int32_server_ip:" + paramInt2 + " int32_server_port:" + paramInt3 + " mUrlParm:" + this.a.coA + " port:" + paramInt1 + " isHttps:" + this.a.mIsHttps + " httpsDomain:" + this.a.aEL);
            this.a.startDownload();
            return;
            paramString1 = "http://" + paramString1 + this.a.coA;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
        }
        paramInt1 = paramInt3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfe
 * JD-Core Version:    0.7.0.1
 */