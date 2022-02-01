package com.tencent.mobileqq.hotpic;

import acfp;
import ahzr;
import aonh;
import aoql.a;
import aoql.a.l;
import aoql.b.n;
import aoqm;
import aoqm.a;
import aqhs;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HotVideoData
  extends HotPicData
  implements URLDrawable.DownloadListener
{
  public static final int PREVIEWIMAGE_TYPE = 1;
  public static final String TAG = "HotVideoData";
  public static final int UNKNOW_TYPE = 0;
  public static final int VIDEO_TYPE = 2;
  public String mCertificatedIcon;
  public String mPreviewUUID;
  public String mVideoUUID;
  WeakReference<URLDrawable.DownloadListener> mWeakPreviewDownloadListener = null;
  public long videoLength;
  public String videoSource;
  
  private void GetURLByTypeAsync(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, a parama)
  {
    if (parama == null) {
      return;
    }
    for (;;)
    {
      try
      {
        b localb = new b();
        localb.dcN = paramInt2;
        if (paramInt2 == 1)
        {
          str1 = this.mPreviewUUID;
          if (paramInt2 != 1) {
            break label92;
          }
          str2 = this.md5;
          requestUrlByUuid(paramQQAppInterface, str1, str2, paramInt1, paramInt2, paramString, new ahzr(this, localb, parama));
          break;
        }
      }
      finally {}
      String str1 = this.mVideoUUID;
      continue;
      label92:
      String str2 = this.originalMD5;
    }
  }
  
  private static boolean isIpv6()
  {
    return true;
  }
  
  private void requestUrlByUuid(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, aoqm.a parama)
  {
    aoql.a locala = new aoql.a();
    aoql.a.l locall = new aoql.a.l();
    locall.seq = Calendar.getInstance().get(5);
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoData", 2, "sendGetUrlReq()----busiReq.seq : " + locall.seq);
    }
    locall.selfUin = paramString3;
    locall.peerUin = paramQQAppInterface.getCurrentUin();
    locall.cmC = paramString3;
    locall.uinType = paramInt1;
    locall.dRn = 0;
    if (locall.uinType == 0)
    {
      locall.chatType = 0;
      if ((locall.uinType != 0) && (1008 != locall.uinType)) {
        break label281;
      }
    }
    label281:
    for (locall.troopUin = null;; locall.troopUin = locall.peerUin)
    {
      locall.clientType = 2;
      locall.fileId = paramString1;
      locall.md5 = aqhs.hexStr2Bytes(paramString2);
      locall.busiType = 0;
      locall.subBusiType = 0;
      locall.fileType = paramInt2;
      locall.dRl = 1;
      locall.IH = 1;
      locala.b = parama;
      locala.cmy = "short_video_dw";
      locala.He.add(locall);
      locala.a = paramQQAppInterface.getProtoReqManager();
      aoqm.c(locala);
      return;
      if (1 == locall.uinType)
      {
        locall.chatType = 1;
        break;
      }
      if (3000 == locall.uinType)
      {
        locall.chatType = 2;
        break;
      }
      locall.chatType = 3;
      break;
    }
  }
  
  public boolean CheckIsNeedBlurBackground()
  {
    return this.width / this.height + 0.1F < 1.777778F;
  }
  
  public void GetPreviewURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, a parama)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 1, parama);
  }
  
  public void GetVideoURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, a parama)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 2, parama);
  }
  
  public void SetPreviewDownloadListener(URLDrawable.DownloadListener paramDownloadListener)
  {
    if ((paramDownloadListener == null) || (paramDownloadListener == this))
    {
      this.mWeakPreviewDownloadListener = null;
      return;
    }
    this.mWeakPreviewDownloadListener = new WeakReference(paramDownloadListener);
  }
  
  public URLDrawable.DownloadListener TryGetPreviewDownloadListener()
  {
    if (this.mWeakPreviewDownloadListener == null) {
      return null;
    }
    return (URLDrawable.DownloadListener)this.mWeakPreviewDownloadListener.get();
  }
  
  public int getDataType()
  {
    return 2;
  }
  
  public String getVideoLengthString()
  {
    return new SimpleDateFormat("mm:ss").format(new Date(this.videoLength));
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    URLDrawable.DownloadListener localDownloadListener = TryGetPreviewDownloadListener();
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadFailed(paramInt);
    }
  }
  
  public void onFileDownloadStarted()
  {
    URLDrawable.DownloadListener localDownloadListener = TryGetPreviewDownloadListener();
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadStarted();
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    URLDrawable.DownloadListener localDownloadListener = TryGetPreviewDownloadListener();
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadSucceed(paramLong);
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("hotvideo:");
    localStringBuffer.append("version:").append(this.version).append(" ");
    localStringBuffer.append("md5:").append(this.md5).append(" ");
    localStringBuffer.append("fileSize:").append(this.fileSize).append(" ");
    localStringBuffer.append("width:").append(this.width).append(" ");
    localStringBuffer.append("height:").append(this.height).append(" ");
    localStringBuffer.append("mPreviewUUID:").append(this.mPreviewUUID).append(" ");
    localStringBuffer.append("picIndex:").append(this.picIndex).append(" ");
    localStringBuffer.append("iconUrl:").append(this.iconUrl).append(" ");
    localStringBuffer.append("jumpUrl:").append(this.jumpUrl).append(" ");
    localStringBuffer.append("name:").append(this.name).append(" ");
    localStringBuffer.append("videoSource:").append(this.videoSource).append(" ");
    localStringBuffer.append("videoLength:").append(this.videoLength).append(" ");
    localStringBuffer.append("originalWidth:").append(this.originalWidth).append(" ");
    localStringBuffer.append("originalHeight:").append(this.originalHeight).append(" ");
    localStringBuffer.append("mVideoUUID:").append(this.mVideoUUID).append(" ");
    localStringBuffer.append("originalMD5:").append(this.originalMD5).append(" ");
    localStringBuffer.append("mCertificatedIcon:").append(this.mCertificatedIcon).append(" ");
    localStringBuffer.append("oringinalSize:").append(this.oringinalSize).append(" ");
    localStringBuffer.append("tag:").append(this.tag).append(" ");
    return localStringBuffer.toString();
  }
  
  public static abstract interface a
  {
    public abstract void a(HotVideoData.b paramb);
  }
  
  public static class b
  {
    public String bMt;
    public int dcN;
    public String mDomain;
    public String mMessage;
    public boolean mResult;
    public ArrayList<aonh> xp;
    
    public void a(aoql.b.n paramn)
    {
      int i = 0;
      StringBuilder localStringBuilder;
      if (HotVideoData.access$000())
      {
        this.xp = paramn.xp;
        if ((this.xp != null) && (this.xp.size() <= 0)) {}
        if (paramn.result != 0) {
          break label200;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("onBusiProtoResp() cdn ---- mIpListSize:");
          if (this.xp != null) {
            break label189;
          }
        }
      }
      for (;;)
      {
        QLog.d("HotVideoData", 2, i + " mHostType:" + paramn.dRr + " domain:" + paramn.mDomain + " url:" + paramn.mUrl);
        QLog.d("HotVideoData", 2, "onBusiProtoResp() cdn ---- downResp.previewMd5:" + HexUtil.bytes2HexStr(paramn.md5));
        this.bMt = paramn.mUrl;
        this.mResult = true;
        return;
        this.xp = paramn.Bw;
        if ((this.xp == null) || (this.xp.size() > 0)) {
          break;
        }
        break;
        label189:
        i = this.xp.size();
      }
      label200:
      this.mResult = false;
      if (-5100026 == paramn.errCode)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 安全打击");
        }
        this.mMessage = acfp.m(2131707282);
        return;
      }
      if ((-9527 == paramn.errCode) && ((paramn.errStr.equals("H_400_-5103017")) || (paramn.errStr.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + paramn.errCode);
        }
        this.mMessage = acfp.m(2131707283);
        return;
      }
      this.mMessage = acfp.m(2131707284);
    }
    
    public String wM()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.xp.size() > 0)
      {
        aonh localaonh = (aonh)this.xp.get(0);
        localStringBuilder.append("http://");
        localStringBuilder.append(localaonh.mIp);
        if (localaonh.port != 80)
        {
          localStringBuilder.append(":");
          localStringBuilder.append(localaonh.port);
        }
        localStringBuilder.append("/");
      }
      for (;;)
      {
        localStringBuilder.append(this.bMt);
        return localStringBuilder.toString();
        if (!this.mDomain.startsWith("http://")) {
          localStringBuilder.append("http://");
        }
        localStringBuilder.append(this.mDomain);
        if (!this.mDomain.endsWith("/")) {
          localStringBuilder.append("/");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoData
 * JD-Core Version:    0.7.0.1
 */