import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class agka
  extends agie
{
  agka(agjz paramagjz) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    paramList = agjz.a(this.this$0, paramLong2, false);
    if (paramList == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "onUpdateGetOfflineDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(paramLong2) + "]");
      this.this$0.a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if ((TextUtils.isEmpty(paramList.h.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
      paramList.h.strFileMd5 = paramString6;
    }
    ahav.a(paramList.h, this.this$0.app, null);
    if (paramLong1 != 0L)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(paramLong1) + "],retMsg[" + String.valueOf(paramString1) + "]");
      if (paramLong1 == -100001L) {}
      for (;;)
      {
        this.this$0.app.a().b(false, 51, new Object[] { paramList.h, Integer.valueOf(paramList.thumbSize) });
        this.this$0.jn(paramLong2);
        this.this$0.a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
        return;
        if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
        {
          paramList.h.status = 16;
          this.this$0.app.a().u(paramList.h);
        }
      }
    }
    if ((paramString3 == null) || (paramByteStringMicro == null))
    {
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "]  get DiscdownLoad info Url is null ");
      if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
      {
        paramList.h.status = 16;
        this.this$0.app.a().u(paramList.h);
      }
      this.this$0.jn(paramLong2);
      this.this$0.a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if ((TextUtils.isEmpty(paramList.h.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
      paramList.h.strFileMd5 = paramString6;
    }
    paramString1 = (String)agjz.a(this.this$0).get(paramList.thumbSize, "");
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] unknow thumbSize!!!info:" + paramList.toString());
      this.this$0.app.a().b(false, 51, new Object[] { paramList.h, Integer.valueOf(paramList.thumbSize) });
      this.this$0.jn(paramLong2);
      this.this$0.a(paramLong2, false, paramString3, paramShort, paramString4, null, paramString2, false, null, (short)0, null);
      return;
    }
    paramString4 = paramString4 + paramString1;
    paramBoolean1 = false;
    short s1 = 0;
    if ((agmx.aH(this.this$0.app)) && (paramBundle != null))
    {
      paramByteStringMicro = paramBundle.getString("strHttpsDomain");
      if (!TextUtils.isEmpty(paramByteStringMicro))
      {
        paramBoolean2 = true;
        short s2 = paramBundle.getShort("httpsPort", (short)0);
        paramBoolean1 = paramBoolean2;
        paramString1 = paramByteStringMicro;
        s1 = s2;
        if (s2 == 0)
        {
          s1 = 443;
          paramString1 = paramByteStringMicro;
          paramBoolean1 = paramBoolean2;
        }
      }
    }
    for (;;)
    {
      paramByteStringMicro = "";
      if (paramBundle != null) {
        paramByteStringMicro = paramBundle.getString("IPv6Dns");
      }
      this.this$0.a(paramLong2, true, paramString3, paramShort, paramString4, null, paramString2, paramBoolean1, paramString1, s1, paramByteStringMicro);
      return;
      paramString1 = null;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    paramString2 = agjz.a(this.this$0, paramLong2, false);
    if (paramString2 == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "OnDiscDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(paramLong2) + "]");
      ahav.a(this.this$0.app, 0L, "actFileDiscThumb", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      ahav.a(this.this$0.app, 0L, "actFileDiscThumbDetail", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      this.this$0.a(paramLong2, false, null, 0, null, null, paramString5, false, null, (short)0, null);
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(paramLong1) + "],retMsg[" + String.valueOf(paramString1) + "]");
      long l = 0L;
      if (paramLong1 == -100001L) {
        l = 9043L;
      }
      for (;;)
      {
        ahav.a(this.this$0.app, paramString2.h.nSessionId, "actFileDiscThumb", paramString2.startTime, "", paramString2.h.peerUin, paramString2.h.Uuid, paramString2.h.strFileMd5, l, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        ahav.a(this.this$0.app, paramString2.h.nSessionId, "actFileDiscThumbDetail", paramString2.startTime, "", paramString2.h.peerUin, paramString2.h.Uuid, paramString2.h.strFileMd5, l, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        this.this$0.app.a().b(false, 50, new Object[] { paramString2.h, Integer.valueOf(paramString2.thumbSize) });
        this.this$0.jn(paramLong2);
        this.this$0.a(paramLong2, false, null, 0, null, null, paramString5, false, null, (short)0, null);
        return;
        if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
        {
          paramString2.h.status = 16;
          this.this$0.app.a().u(paramString2.h);
        }
        else
        {
          l = 9045L;
        }
      }
    }
    paramString2.strCookie = paramString5;
    paramString1 = (String)agjz.a(this.this$0).get(paramString2.thumbSize, "");
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = "http://" + paramString3 + ":" + String.valueOf(paramInt1) + "/ftn_handler/" + paramString4;
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] unknow thumbSize!!!info:" + paramString2.toString());
      this.this$0.app.a().b(false, 50, new Object[] { paramString2.h, Integer.valueOf(paramString2.thumbSize) });
      ahav.a(this.this$0.app, paramString2.h.nSessionId, "actFileDiscThumb", paramString2.startTime, paramString1, paramString2.h.peerUin, paramString2.h.Uuid, paramString2.h.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      ahav.a(this.this$0.app, paramString2.h.nSessionId, "actFileDiscThumbDetail", paramString2.startTime, paramString1, paramString2.h.peerUin, paramString2.h.Uuid, paramString2.h.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      this.this$0.jn(paramLong2);
      this.this$0.a(paramLong2, false, paramString3, paramInt1, "/ftn_handler/" + paramString4, null, paramString5, false, null, (short)0, null);
      return;
    }
    paramString4 = "/ftn_handler/" + paramString4 + paramString1;
    paramBoolean = false;
    short s1 = 0;
    if ((agmx.aL(this.this$0.app)) && (paramBundle != null))
    {
      paramString2 = paramBundle.getString("strHttpsDomain");
      if (!TextUtils.isEmpty(paramString2))
      {
        boolean bool = true;
        short s2 = paramBundle.getShort("httpsPort", (short)0);
        paramBoolean = bool;
        paramString1 = paramString2;
        s1 = s2;
        if (s2 == 0)
        {
          s1 = 443;
          paramString1 = paramString2;
          paramBoolean = bool;
        }
      }
    }
    for (;;)
    {
      paramString2 = "";
      if (paramBundle != null) {
        paramString2 = paramBundle.getString("IPv6Dns");
      }
      this.this$0.a(paramLong2, true, paramString3, paramInt1, paramString4, null, paramString5, paramBoolean, paramString1, s1, paramString2);
      return;
      paramString1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agka
 * JD-Core Version:    0.7.0.1
 */