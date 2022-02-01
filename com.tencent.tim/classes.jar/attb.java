import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.DiscPicThumbDownloader.1;
import com.tencent.tim.filemanager.core.DiscPicThumbDownloader.2;
import com.tencent.tim.filemanager.core.DiscPicThumbDownloader.3;
import com.tencent.tim.filemanager.core.DiscPicThumbDownloader.4;

public class attb
  extends atsy
{
  private agie d = new attc(this);
  
  public attb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String D(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  private attb.a a(long paramLong, boolean paramBoolean)
  {
    atsy.a locala = a(paramLong);
    if (locala == null) {
      return null;
    }
    if ((locala instanceof attb.a)) {
      return (attb.a)locala;
    }
    QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  public void a(long paramLong, int paramInt, atuq.a parama)
  {
    parama = a(paramLong, false);
    if (parama == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    this.app.a().b(true, 52, new Object[] { parama.h, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, aqog paramaqog)
  {
    attb.a locala = a(paramLong, false);
    if (locala == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    paramaqog.busiType = 3000;
    paramaqog.setRequestProperty("Cookie", locala.strCookie);
  }
  
  public void a(long paramLong, atuq.a parama)
  {
    Object localObject = a(paramLong, false);
    if (localObject == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    int i;
    String str1;
    label76:
    QQAppInterface localQQAppInterface;
    long l1;
    String str2;
    String str3;
    String str4;
    String str5;
    long l2;
    long l3;
    long l4;
    long l5;
    String str6;
    if (parama.d != null)
    {
      i = parama.d.errCode;
      if (parama.d == null) {
        break label227;
      }
      str1 = parama.d.getErrorString();
      localQQAppInterface = this.app;
      paramLong = ((attb.a)localObject).h.nSessionId;
      l1 = ((attb.a)localObject).startTime;
      str2 = parama.strUrl;
      str3 = ((attb.a)localObject).h.peerUin;
      str4 = ((attb.a)localObject).h.Uuid;
      str5 = ((attb.a)localObject).h.strFileMd5;
      l2 = i;
      l3 = parama.Zc;
      l4 = parama.Zb;
      l5 = parama.thumbSize;
      str6 = parama.strUrl;
      if (parama.d == null) {
        break label234;
      }
    }
    label227:
    label234:
    for (localObject = parama.d.cuw;; localObject = "respose null")
    {
      audx.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, parama.cXK, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label76;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, atuq.a parama)
  {
    attb.a locala = a(paramLong, false);
    if (locala == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      audx.a(this.app, locala.h.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - locala.startTime, parama.strUrl, locala.h.peerUin, locala.h.Uuid, locala.h.strFileMd5, parama.Zc, parama.Zb, parama.thumbSize, parama.retryTimes, null);
      if (locala.thumbSize == 7)
      {
        locala.h.strLargeThumPath = paramString;
        audx.K(locala.h);
        ThreadManager.post(new DiscPicThumbDownloader.3(this, locala), 8, null, false);
        this.app.a().u(locala.h);
      }
    }
    for (;;)
    {
      this.app.a().b(paramBoolean, 50, new Object[] { locala.h, Integer.valueOf(locala.thumbSize) });
      super.a(paramLong, paramBoolean, paramInt, paramString, parama);
      return;
      if (locala.thumbSize == 5)
      {
        locala.h.strMiddleThumPath = paramString;
        audx.K(locala.h);
        if (!auef.u(locala.h)) {
          break;
        }
        ThreadManager.post(new DiscPicThumbDownloader.4(this, locala), 8, null, false);
        break;
      }
      locala.h.strThumbPath = paramString;
      break;
      switch (paramInt)
      {
      }
    }
    Object localObject1 = this.app;
    long l1 = locala.h.nSessionId;
    long l2 = locala.startTime;
    Object localObject2 = parama.strUrl;
    String str2 = locala.h.peerUin;
    String str3 = locala.h.Uuid;
    String str4 = locala.h.strFileMd5;
    long l3 = parama.Zc;
    long l4 = parama.Zb;
    long l5 = parama.thumbSize;
    String str5 = parama.strUrl;
    if (parama.d != null)
    {
      str1 = parama.d.cuw;
      label462:
      audx.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, parama.retryTimes, "rename error", "");
      localObject1 = this.app;
      l1 = locala.h.nSessionId;
      l2 = locala.startTime;
      localObject2 = parama.strUrl;
      str2 = locala.h.peerUin;
      str3 = locala.h.Uuid;
      str4 = locala.h.strFileMd5;
      l3 = parama.Zc;
      l4 = parama.Zb;
      l5 = parama.thumbSize;
      str5 = parama.strUrl;
      if (parama.d == null) {
        break label1973;
      }
    }
    label1160:
    label1959:
    label1973:
    for (String str1 = parama.d.cuw;; str1 = "respose null")
    {
      audx.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, parama.cXK, "rename error", "");
      break;
      localObject1 = this.app;
      l1 = locala.h.nSessionId;
      l2 = locala.startTime;
      localObject2 = parama.strUrl;
      str2 = locala.h.peerUin;
      str3 = locala.h.Uuid;
      str4 = locala.h.strFileMd5;
      l3 = parama.Zc;
      l4 = parama.Zb;
      l5 = locala.thumbSize;
      str5 = parama.strUrl;
      if (parama.d != null)
      {
        str1 = parama.d.cuw;
        label765:
        audx.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, parama.retryTimes, "no network", "");
        localObject1 = this.app;
        l1 = locala.h.nSessionId;
        l2 = locala.startTime;
        localObject2 = parama.strUrl;
        str2 = locala.h.peerUin;
        str3 = locala.h.Uuid;
        str4 = locala.h.strFileMd5;
        l3 = parama.Zc;
        l4 = parama.Zb;
        l5 = locala.thumbSize;
        str5 = parama.strUrl;
        if (parama.d == null) {
          break label968;
        }
      }
      label968:
      for (str1 = parama.d.cuw;; str1 = "respose null")
      {
        audx.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, parama.cXK, "no network", "");
        break;
        str1 = "respose null";
        break label765;
      }
      audx.a(this.app, locala.h.nSessionId, "actFileDiscThumb", locala.startTime, parama.strUrl, locala.h.peerUin, locala.h.Uuid, locala.h.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, parama.strUrl, "", 0, "FileNotFoundException", "");
      audx.a(this.app, locala.h.nSessionId, "actFileDiscThumbDetail", locala.startTime, parama.strUrl, locala.h.peerUin, locala.h.Uuid, locala.h.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, parama.strUrl, "", 0, "size error", "");
      break;
      int i;
      label1142:
      long l6;
      String str6;
      if (parama.d != null)
      {
        i = parama.d.errCode;
        if (parama.d == null) {
          break label1477;
        }
        str1 = parama.d.getErrorString();
        localObject2 = this.app;
        l1 = locala.h.nSessionId;
        l2 = locala.startTime;
        str2 = parama.strUrl;
        str3 = locala.h.peerUin;
        str4 = locala.h.Uuid;
        str5 = locala.h.strFileMd5;
        l3 = i;
        l4 = parama.Zc;
        l5 = parama.Zb;
        l6 = parama.thumbSize;
        str6 = parama.strUrl;
        if (parama.d == null) {
          break label1485;
        }
        localObject1 = parama.d.cuw;
        label1272:
        audx.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, parama.retryTimes, str1, "");
        localObject2 = this.app;
        l1 = locala.h.nSessionId;
        l2 = locala.startTime;
        str2 = parama.strUrl;
        str3 = locala.h.peerUin;
        str4 = locala.h.Uuid;
        str5 = locala.h.strFileMd5;
        l3 = i;
        l4 = parama.Zc;
        l5 = parama.Zb;
        l6 = parama.thumbSize;
        str6 = parama.strUrl;
        if (parama.d == null) {
          break label1492;
        }
      }
      label1477:
      label1485:
      label1492:
      for (localObject1 = parama.d.cuw;; localObject1 = "respose null")
      {
        audx.a((QQAppInterface)localObject2, l1, "actFileDiscThumbDetail", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, parama.cXK, str1, "");
        break;
        i = 0;
        break label1142;
        str1 = "http resp err";
        break label1160;
        localObject1 = "respose null";
        break label1272;
      }
      audx.a(this.app, locala.h.nSessionId, "actFileDiscThumb", locala.startTime, parama.strUrl, locala.h.peerUin, locala.h.Uuid, locala.h.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, parama.strUrl, "", 0, "noRs", "");
      audx.a(this.app, locala.h.nSessionId, "actFileDiscThumbDetail", locala.startTime, parama.strUrl, locala.h.peerUin, locala.h.Uuid, locala.h.strFileMd5, 9005L, "noRs", parama.Zc, parama.Zb, parama.thumbSize, parama.strUrl, "", 0, "noRs", "");
      break;
      localObject1 = this.app;
      l1 = locala.h.nSessionId;
      l2 = locala.startTime;
      localObject2 = parama.strUrl;
      str2 = locala.h.peerUin;
      str3 = locala.h.Uuid;
      str4 = locala.h.strFileMd5;
      l3 = parama.Zb;
      l4 = parama.thumbSize;
      str5 = parama.strUrl;
      if (parama.d != null)
      {
        str1 = parama.d.cuw;
        label1761:
        audx.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, parama.retryTimes, "revStream write Exception", "");
        localObject1 = this.app;
        l1 = locala.h.nSessionId;
        l2 = locala.startTime;
        localObject2 = parama.strUrl;
        str2 = locala.h.peerUin;
        str3 = locala.h.Uuid;
        str4 = locala.h.strFileMd5;
        l3 = parama.Zb;
        l4 = parama.thumbSize;
        str5 = parama.strUrl;
        if (parama.d == null) {
          break label1959;
        }
      }
      for (str1 = parama.d.cuw;; str1 = "respose null")
      {
        audx.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, parama.cXK, "revStream write Exception", "");
        break;
        str1 = "respose null";
        break label1761;
      }
      str1 = "respose null";
      break label462;
    }
  }
  
  public boolean a(long paramLong, atuq.a parama)
  {
    parama = a(paramLong, false);
    if (parama == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    if (parama.h.peerType == 3000) {
      this.app.a().a(paramLong, parama.h.fileName, Long.parseLong(parama.h.peerUin), parama.h.Uuid, this.d);
    }
    for (;;)
    {
      return true;
      this.app.a().a(paramLong, parama.h.Uuid, parama.h.bSend, this.d);
    }
  }
  
  public String b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (TextUtils.isEmpty(paramFileManagerEntity.Uuid))
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.app.a().b(false, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
      return null;
    }
    dhg();
    if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("uuid is null!!!");
    }
    String str = audn.a().wb() + D(paramInt, atad.toMD5(paramFileManagerEntity.Uuid));
    if ((!aueh.fileExistsAndNotEmpty(str)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))) {
      str = audn.a().wb() + D(paramInt, atad.toMD5(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (aqhq.fileExistsAndNotEmpty(str) == true)
      {
        if (paramInt == 7)
        {
          paramFileManagerEntity.strLargeThumPath = str;
          if (auef.u(paramFileManagerEntity)) {
            ThreadManager.post(new DiscPicThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
          }
        }
        for (;;)
        {
          this.app.a().u(paramFileManagerEntity);
          this.app.a().b(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
          QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "download discFile Thumb existed,nSession[" + String.valueOf(paramFileManagerEntity.nSessionId) + "],discUin[" + String.valueOf(paramFileManagerEntity.peerUin) + "],path[" + str + "]");
          audx.a(this.app, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
          return str;
          if (paramInt == 5)
          {
            paramFileManagerEntity.strMiddleThumPath = str;
            if (auef.u(paramFileManagerEntity)) {
              ThreadManager.post(new DiscPicThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
            }
          }
          else
          {
            paramFileManagerEntity.strThumbPath = str;
          }
        }
      }
      paramFileManagerEntity = new attb.a(paramFileManagerEntity);
      paramFileManagerEntity.thumbSize = paramInt;
      a(paramFileManagerEntity, str);
      return null;
    }
  }
  
  public void b(long paramLong, atuq.a parama) {}
  
  public static class a
    extends atsy.a
  {
    long startTime;
    String strCookie;
    int thumbSize;
    
    public a(FileManagerEntity paramFileManagerEntity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     attb
 * JD-Core Version:    0.7.0.1
 */