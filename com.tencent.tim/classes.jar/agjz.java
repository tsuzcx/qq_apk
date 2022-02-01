import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.1;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.2;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.3;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agjz
  extends agjw
{
  private SparseArray<String> cA = new SparseArray();
  private agie d = new agka(this);
  
  public agjz(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    dhh();
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
  
  private agjz.a a(long paramLong, boolean paramBoolean)
  {
    agjw.a locala = a(paramLong);
    if (locala == null) {
      return null;
    }
    if ((locala instanceof agjz.a)) {
      return (agjz.a)locala;
    }
    QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  private void a(int paramInt, agjz.a parama, agly.a parama1)
  {
    switch (paramInt)
    {
    }
    label333:
    label483:
    label499:
    do
    {
      return;
      Object localObject2 = this.app;
      long l1 = parama.h.nSessionId;
      long l2 = parama.startTime;
      Object localObject3 = parama1.strUrl;
      String str1 = parama.h.peerUin;
      String str2 = parama.h.Uuid;
      String str3 = parama.h.strFileMd5;
      long l3 = parama1.Zc;
      long l4 = parama1.Zb;
      long l5 = parama.thumbSize;
      String str4 = parama1.strUrl;
      Object localObject1;
      if (parama1.d != null)
      {
        localObject1 = parama1.d.cuw;
        ahav.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)localObject3, str1, str2, str3, 9004L, "no network", l3, l4, l5, str4, (String)localObject1, parama1.retryTimes, "no network", "");
        localObject1 = this.app;
        l1 = parama.h.nSessionId;
        l2 = parama.startTime;
        localObject2 = parama1.strUrl;
        localObject3 = parama.h.peerUin;
        str1 = parama.h.Uuid;
        str2 = parama.h.strFileMd5;
        l3 = parama1.Zc;
        l4 = parama1.Zb;
        l5 = parama.thumbSize;
        str3 = parama1.strUrl;
        if (parama1.d == null) {
          break label333;
        }
      }
      for (parama = parama1.d.cuw;; parama = "respose null")
      {
        ahav.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, (String)localObject3, str1, str2, 9004L, "no network", l3, l4, l5, str3, parama, parama1.cXK, "no network", "");
        return;
        localObject1 = "respose null";
        break;
      }
      ahav.a(this.app, parama.h.nSessionId, "actFileDiscThumb", parama.startTime, parama1.strUrl, parama.h.peerUin, parama.h.Uuid, parama.h.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, parama1.strUrl, "", 0, "FileNotFoundException", "");
      ahav.a(this.app, parama.h.nSessionId, "actFileDiscThumbDetail", parama.startTime, parama1.strUrl, parama.h.peerUin, parama.h.Uuid, parama.h.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, parama1.strUrl, "", 0, "size error", "");
      return;
      long l6;
      String str5;
      if (parama1.d != null)
      {
        paramInt = parama1.d.errCode;
        if (parama1.d == null) {
          break label800;
        }
        localObject1 = parama1.d.getErrorString();
        localObject3 = this.app;
        l1 = parama.h.nSessionId;
        l2 = parama.startTime;
        str1 = parama1.strUrl;
        str2 = parama.h.peerUin;
        str3 = parama.h.Uuid;
        str4 = parama.h.strFileMd5;
        l3 = paramInt;
        l4 = parama1.Zc;
        l5 = parama1.Zb;
        l6 = parama1.thumbSize;
        str5 = parama1.strUrl;
        if (parama1.d == null) {
          break label807;
        }
        localObject2 = parama1.d.cuw;
        ahav.a((QQAppInterface)localObject3, l1, "actFileDiscThumb", l2, str1, str2, str3, str4, l3, (String)localObject1, l4, l5, l6, str5, (String)localObject2, parama1.retryTimes, (String)localObject1, "");
        localObject3 = this.app;
        l1 = parama.h.nSessionId;
        l2 = parama.startTime;
        str1 = parama1.strUrl;
        str2 = parama.h.peerUin;
        str3 = parama.h.Uuid;
        str4 = parama.h.strFileMd5;
        l3 = paramInt;
        l4 = parama1.Zc;
        l5 = parama1.Zb;
        l6 = parama1.thumbSize;
        str5 = parama1.strUrl;
        if (parama1.d == null) {
          break label814;
        }
      }
      for (localObject2 = parama1.d.cuw;; localObject2 = "respose null")
      {
        ahav.a((QQAppInterface)localObject3, l1, "actFileDiscThumbDetail", l2, str1, str2, str3, str4, l3, (String)localObject1, l4, l5, l6, str5, (String)localObject2, parama1.cXK, (String)localObject1, "");
        if (parama.h == null) {
          break;
        }
        parama.h.thumbInvalidCode = 2;
        return;
        paramInt = 0;
        break label483;
        localObject1 = "http resp err";
        break label499;
        localObject2 = "respose null";
        break label598;
      }
      ahav.a(this.app, parama.h.nSessionId, "actFileDiscThumb", parama.startTime, parama1.strUrl, parama.h.peerUin, parama.h.Uuid, parama.h.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, parama1.strUrl, "", 0, "noRs", "");
      ahav.a(this.app, parama.h.nSessionId, "actFileDiscThumbDetail", parama.startTime, parama1.strUrl, parama.h.peerUin, parama.h.Uuid, parama.h.strFileMd5, 9005L, "noRs", parama1.Zc, parama1.Zb, parama1.thumbSize, parama1.strUrl, "", 0, "noRs", "");
      return;
      localObject2 = this.app;
      l1 = parama.h.nSessionId;
      l2 = parama.startTime;
      localObject3 = parama1.strUrl;
      str1 = parama.h.peerUin;
      str2 = parama.h.Uuid;
      str3 = parama.h.strFileMd5;
      l3 = parama1.Zb;
      l4 = parama1.thumbSize;
      str4 = parama1.strUrl;
      if (parama1.d != null)
      {
        localObject1 = parama1.d.cuw;
        ahav.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)localObject3, str1, str2, str3, 9003L, "revStream write Exception", 0L, l3, l4, str4, (String)localObject1, parama1.retryTimes, "revStream write Exception", "");
        localObject1 = this.app;
        l1 = parama.h.nSessionId;
        l2 = parama.startTime;
        localObject2 = parama1.strUrl;
        localObject3 = parama.h.peerUin;
        str1 = parama.h.Uuid;
        str2 = parama.h.strFileMd5;
        l3 = parama1.Zb;
        l4 = parama1.thumbSize;
        str3 = parama1.strUrl;
        if (parama1.d == null) {
          break label1226;
        }
      }
      for (parama = parama1.d.cuw;; parama = "respose null")
      {
        ahav.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, (String)localObject3, str1, str2, 9003L, "revStream write Exception", 0L, l3, l4, str3, parama, parama1.cXK, "revStream write Exception", "");
        return;
        localObject1 = "respose null";
        break;
      }
      localObject2 = this.app;
      l1 = parama.h.nSessionId;
      l2 = parama.startTime;
      localObject3 = parama1.strUrl;
      str1 = parama.h.peerUin;
      str2 = parama.h.Uuid;
      str3 = parama.h.strFileMd5;
      l3 = parama1.Zc;
      l4 = parama1.Zb;
      l5 = parama1.thumbSize;
      str4 = parama1.strUrl;
      if (parama1.d != null)
      {
        localObject1 = parama1.d.cuw;
        ahav.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)localObject3, str1, str2, str3, 9003L, "rename error", l3, l4, l5, str4, (String)localObject1, parama1.retryTimes, "rename error", "");
        localObject1 = this.app;
        l1 = parama.h.nSessionId;
        l2 = parama.startTime;
        localObject2 = parama1.strUrl;
        localObject3 = parama.h.peerUin;
        str1 = parama.h.Uuid;
        str2 = parama.h.strFileMd5;
        l3 = parama1.Zc;
        l4 = parama1.Zb;
        l5 = parama1.thumbSize;
        str3 = parama1.strUrl;
        if (parama1.d == null) {
          break label1512;
        }
      }
      for (parama = parama1.d.cuw;; parama = "respose null")
      {
        ahav.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, (String)localObject3, str1, str2, 9003L, "rename error", l3, l4, l5, str3, parama, parama1.cXK, "rename error", "");
        return;
        localObject1 = "respose null";
        break;
      }
    } while (parama.h == null);
    label598:
    label1512:
    parama.h.thumbInvalidCode = 1;
    label800:
    label807:
    label814:
    label1226:
    return;
  }
  
  private void a(agjz.a parama, String paramString, agly.a parama1)
  {
    ahav.a(this.app, parama.h.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - parama.startTime, parama1.strUrl, parama.h.peerUin, parama.h.Uuid, parama.h.strFileMd5, parama1.Zc, parama1.Zb, parama1.thumbSize, parama1.retryTimes, null);
    if (parama.thumbSize == 7)
    {
      parama.h.strLargeThumPath = paramString;
      ahav.K(parama.h);
      ThreadManager.post(new DiscPicThumbDownloader.3(this, parama), 8, null, false);
    }
    for (;;)
    {
      this.app.a().u(parama.h);
      return;
      if (parama.thumbSize == 5)
      {
        parama.h.strMiddleThumPath = paramString;
        ahav.K(parama.h);
        if (ahbh.u(parama.h)) {
          ThreadManager.post(new DiscPicThumbDownloader.4(this, parama), 8, null, false);
        }
      }
      else
      {
        parama.h.strThumbPath = paramString;
      }
    }
  }
  
  private void dhh()
  {
    this.cA.put(0, "?pictype=scaled&size=16*16");
    this.cA.put(1, "?pictype=scaled&size=32*32");
    this.cA.put(2, "?pictype=scaled&size=64*64");
    this.cA.put(3, "?pictype=scaled&size=128*128");
    this.cA.put(4, "?pictype=scaled&size=320*320");
    this.cA.put(5, "?pictype=scaled&size=384*384");
    this.cA.put(6, "?pictype=scaled&size=640*640");
    this.cA.put(7, "?pictype=scaled&size=750*750");
    this.cA.put(8, "?pictype=scaled&size=1024*1024");
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt)
  {
    Object localObject = a(paramLong, false);
    if ((localObject != null) && (((agjz.a)localObject).h != null))
    {
      int i;
      if (((agjz.a)localObject).h.peerType == 3000) {
        i = 5;
      }
      while ((!TextUtils.isEmpty(paramString)) && (agke.a().l(this.app, i)))
      {
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] image thumb. is config enable IPv6. domain[" + paramString + "] busiType:" + i);
        paramString = new agke.a(paramString, paramInt);
        localObject = agke.a().a(this.app, paramString, i);
        if ((localObject != null) && (!((agke.c)localObject).alz()))
        {
          paramString = new ArrayList();
          localObject = ((agke.c)localObject).Bb.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              agke.b localb = (agke.b)((Iterator)localObject).next();
              paramString.add(localb.mIp + ":" + localb.mPort);
              continue;
              i = 1;
              break;
            }
          }
          QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] image thumb. use IPv6. hostlist:" + paramString.toString());
          return paramString;
        }
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] image thumb. use IPv4:");
      }
    }
    return null;
  }
  
  public void a(long paramLong, int paramInt, agly.a parama)
  {
    parama = a(paramLong, false);
    if (parama == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    this.app.a().b(true, 52, new Object[] { parama.h, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, agly.a parama)
  {
    Object localObject = a(paramLong, false);
    if (localObject == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    int i;
    String str1;
    label78:
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
        break label229;
      }
      str1 = parama.d.getErrorString();
      localQQAppInterface = this.app;
      paramLong = ((agjz.a)localObject).h.nSessionId;
      l1 = ((agjz.a)localObject).startTime;
      str2 = parama.strUrl;
      str3 = ((agjz.a)localObject).h.peerUin;
      str4 = ((agjz.a)localObject).h.Uuid;
      str5 = ((agjz.a)localObject).h.strFileMd5;
      l2 = i;
      l3 = parama.Zc;
      l4 = parama.Zb;
      l5 = parama.thumbSize;
      str6 = parama.strUrl;
      if (parama.d == null) {
        break label237;
      }
    }
    label229:
    label237:
    for (localObject = parama.d.cuw;; localObject = "respose null")
    {
      ahav.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, parama.cXK, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label78;
    }
  }
  
  public void a(long paramLong, aqog paramaqog)
  {
    agjz.a locala = a(paramLong, false);
    if (locala == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    paramaqog.busiType = 3000;
    paramaqog.setRequestProperty("Cookie", locala.strCookie);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, agly.a parama)
  {
    agjz.a locala = a(paramLong, false);
    if (locala == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean) {
      a(locala, paramString, parama);
    }
    for (;;)
    {
      this.app.a().b(paramBoolean, 50, new Object[] { locala.h, Integer.valueOf(locala.thumbSize) });
      super.a(paramLong, paramBoolean, paramInt, paramString, parama);
      return;
      a(paramInt, locala, parama);
    }
  }
  
  public boolean a(long paramLong, agly.a parama)
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
      this.app.a().a(paramLong, parama.h.Uuid, parama.h.fileIdCrc, parama.h.bSend, this.d);
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
    String str = ahaf.a().wb() + D(paramInt, atad.toMD5(paramFileManagerEntity.Uuid));
    if ((!ahbj.fileExistsAndNotEmpty(str)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))) {
      str = ahaf.a().wb() + D(paramInt, atad.toMD5(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (aqhq.fileExistsAndNotEmpty(str) == true)
      {
        if (paramInt == 7)
        {
          paramFileManagerEntity.strLargeThumPath = str;
          if (ahbh.u(paramFileManagerEntity)) {
            ThreadManager.post(new DiscPicThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
          }
        }
        for (;;)
        {
          this.app.a().u(paramFileManagerEntity);
          this.app.a().b(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
          QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
          ahav.a(this.app, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
          return str;
          if (paramInt == 5)
          {
            paramFileManagerEntity.strMiddleThumPath = str;
            if (ahbh.u(paramFileManagerEntity)) {
              ThreadManager.post(new DiscPicThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
            }
          }
          else
          {
            paramFileManagerEntity.strThumbPath = str;
          }
        }
      }
      agjz.a locala = new agjz.a(paramFileManagerEntity);
      locala.thumbSize = paramInt;
      a(locala, str);
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + locala.sessionid + "]");
      return null;
    }
  }
  
  public void b(long paramLong, agly.a parama) {}
  
  public static class a
    extends agjw.a
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agjz
 * JD-Core Version:    0.7.0.1
 */