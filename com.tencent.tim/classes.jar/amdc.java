import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.BaseView;
import java.io.File;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class amdc
  extends amcu
  implements INetInfoHandler
{
  private amem a;
  public MqqHandler b = new amdd(this);
  public ConcurrentHashMap<Integer, URLDrawable> mActiveThumbDrawable = new ConcurrentHashMap();
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3)
  {
    return ((paramMessageForShortVideo.videoFileStatus == 1002) || (paramMessageForShortVideo.videoFileStatus == 2002)) && (paramMessageForShortVideo.videoFileStatus == paramInt1) && (paramInt2 - paramInt3 < 10);
  }
  
  public static Drawable getCoverDrawable(String paramString, int paramInt1, int paramInt2)
  {
    afei localafei = new afei(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localafei, localafei);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + "exception = " + localException.getMessage());
      }
    }
    return localafei;
  }
  
  public long R(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).aiy;
    }
    return 0L;
  }
  
  public void Up(int paramInt)
  {
    try
    {
      this.mActiveThumbDrawable.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public AIOVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return (AIOVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public ztn a(AIOVideoData paramAIOVideoData)
  {
    if (paramAIOVideoData == null) {
      return null;
    }
    Object localObject = new File(paramAIOVideoData.aWp);
    long l = 0L;
    boolean bool;
    if (((File)localObject).exists())
    {
      l = ((File)localObject).length();
      if (paramAIOVideoData.mBusiType == 1) {
        bool = false;
      }
    }
    for (;;)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "getVideoPlayMedioInfo longvideo GetUrlAction =" + bool);
      if (bool)
      {
        localObject = amdm.a().a(paramAIOVideoData.msgId);
        if ((localObject != null) && (((amdm.b)localObject).isValid()))
        {
          ztn localztn = new ztn();
          localztn.btf = true;
          localztn.cJ = ((amdm.b)localObject).mUrls;
          localztn.playUrl = paramAIOVideoData.aWp;
          localztn.l = ((amdm.b)localObject).l;
          localztn.fileType = ((amdm.b)localObject).fileType;
          localztn.id = paramAIOVideoData.msgId;
          localztn.subid = paramAIOVideoData.subId;
          return localztn;
          if (l < paramAIOVideoData.size)
          {
            bool = true;
            continue;
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
            bool = true;
          }
        }
        else
        {
          return null;
        }
      }
      else
      {
        localObject = new ztn();
        ((ztn)localObject).btf = false;
        ((ztn)localObject).id = paramAIOVideoData.msgId;
        ((ztn)localObject).subid = paramAIOVideoData.subId;
        ((ztn)localObject).playUrl = paramAIOVideoData.aWp;
        ((ztn)localObject).ap = l;
        return localObject;
      }
      bool = false;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.a.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(AIOVideoData paramAIOVideoData)
  {
    if ((paramAIOVideoData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "dealSaveVideo");
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramAIOVideoData.msgId, paramAIOVideoData.subId, 256);
    }
  }
  
  public boolean agC()
  {
    Object localObject = getSelectedItem();
    if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)))
    {
      localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
      return (this.gM.get(Long.valueOf(((AIOBrowserBaseData)localObject).shmsgseq)) != null) && (((Set)this.gM.get(Long.valueOf(((AIOBrowserBaseData)localObject).shmsgseq))).size() > 0);
    }
    return false;
  }
  
  public void ao(int paramInt, long paramLong)
  {
    Object localObject = a(a());
    MessageForShortVideo localMessageForShortVideo;
    if (localObject != null) {
      localMessageForShortVideo = ((ztn)localObject).l;
    }
    for (int j = ((ztn)localObject).fileType;; j = -1)
    {
      if ((localMessageForShortVideo == null) || (paramInt == -1)) {}
      do
      {
        int k;
        do
        {
          int i;
          do
          {
            return;
            k = 0;
            i = k;
            if (paramLong > 0L)
            {
              i = k;
              if (localMessageForShortVideo.videoFileSize > 0) {
                i = (int)(100L * paramLong / localMessageForShortVideo.videoFileSize);
              }
            }
            if (localMessageForShortVideo.videoFileProgress < 0) {
              localMessageForShortVideo.videoFileProgress = 0;
            }
          } while (a(localMessageForShortVideo, paramInt, i, localMessageForShortVideo.videoFileProgress));
          if ((j != 6) && (j != 17) && (j != 9))
          {
            k = i;
            if (j != 20) {}
          }
          else
          {
            if ((paramInt == 2002) && (paramLong > 0L)) {
              localMessageForShortVideo.transferedSize = ((int)paramLong);
            }
            k = i;
            if (paramInt == 2003)
            {
              localMessageForShortVideo.transferedSize = 0;
              k = 100;
            }
          }
        } while (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramInt == 1002) || (paramInt == 2002)));
        localMessageForShortVideo.videoFileStatus = paramInt;
        localMessageForShortVideo.fileType = j;
        if (k > 0) {
          localMessageForShortVideo.videoFileProgress = k;
        }
        localObject = ShortVideoUtils.e(localMessageForShortVideo);
        if ((paramInt == 2003) && (!aqmr.isEmpty((String)localObject))) {
          localMessageForShortVideo.lastModified = new File((String)localObject).lastModified();
        }
      } while (this.c.a() == null);
      this.c.a().i(localMessageForShortVideo);
      return;
      localMessageForShortVideo = null;
    }
  }
  
  public boolean avH()
  {
    boolean bool = aeex.agA();
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "isImmersionOpen:" + bool);
    return bool;
  }
  
  public void ay(long paramLong, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).cCk = paramBoolean;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void b(int paramInt, File paramFile)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      if (str != null) {
        anot.a(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      str = ShortVideoUtils.zL();
      if (rox.saveVideoToAlbum(BaseApplication.getContext(), paramFile.getAbsolutePath(), str)) {
        QQToast.a(this.a.mContext, 2, acfp.m(2131702301), 0).show();
      }
      break;
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      return;
      str = "0X8007A24";
      break;
      str = "0X8007A25";
      break;
      QQToast.a(this.a.mContext, 1, acfp.m(2131702302), 0).show();
    }
  }
  
  public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData.getType() == 101) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)))
    {
      AIOVideoData localAIOVideoData = (AIOVideoData)localRichMediaBrowserInfo.baseData;
      if (paramInt2 == 256) {
        localAIOVideoData.status = 2;
      }
      localAIOVideoData.progress = paramInt3;
      localRichMediaBrowserInfo.baseData = localAIOVideoData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (((AIOVideoData)localRichMediaBrowserInfo.baseData).msgId == paramLong1)) {
      this.a.updateUI();
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData.getType() == 101) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)))
    {
      AIOVideoData localAIOVideoData = (AIOVideoData)localRichMediaBrowserInfo.baseData;
      localAIOVideoData.status = 0;
      localAIOVideoData.progress = 0;
      localRichMediaBrowserInfo.baseData = localAIOVideoData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (((AIOVideoData)localRichMediaBrowserInfo.baseData).msgId == paramLong))
    {
      this.a.updateUI();
      if (paramInt2 != 256) {
        break label225;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "save video result resultStr = " + paramString);
      if (paramInt3 != 1) {
        break label195;
      }
      QQToast.a(this.a.mContext, 2, this.a.mContext.getString(2131718933), 0).show();
    }
    label195:
    label225:
    while ((paramInt2 != 1) && (paramInt2 != 0))
    {
      return;
      QQToast.a(this.a.mContext, 1, this.a.mContext.getString(2131718961), 0).show();
      return;
    }
    if (paramInt3 == 1) {}
    for (;;)
    {
      a(paramLong, paramInt1, paramInt2, paramString);
      this.a.updateView(getSelectedIndex(), this.a.galleryView, paramBoolean);
      return;
      paramString = "I:E";
    }
  }
  
  public void b(AIOVideoData paramAIOVideoData)
  {
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramAIOVideoData.msgId, paramAIOVideoData.subId, 1);
    }
  }
  
  public void buildPresenter()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.a.mContext, this);
  }
  
  public boolean cC(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).cCk;
    }
    return false;
  }
  
  public boolean cD(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).isMutePlay;
    }
    return false;
  }
  
  public void dMu()
  {
    if ((this.c != null) && (this.c.b != null) && (this.c.a() != null))
    {
      if (!ayxa.isLiuHaiUseValid()) {
        break label94;
      }
      this.c.a().setMarginTop((int)wja.a(ayxa.sNotchHeight, this.a.mContext.getResources()) + 46);
    }
    for (;;)
    {
      this.c.a().cWB();
      this.c.a().clear();
      this.c.b.dMQ();
      return;
      label94:
      this.c.a().setMarginTop(46);
    }
  }
  
  public long fs()
  {
    if ((this.a != null) && (this.a.mVideoView != null)) {
      return this.a.mVideoView.getCurPlayingPos();
    }
    return 0L;
  }
  
  public void ld(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).isAutoPlay = false;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void le(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).isMutePlay = false;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public boolean lg(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).isAutoPlay;
    }
    return false;
  }
  
  public void loadShortVideoCover(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.j(paramString);
      if (paramString != null)
      {
        paramString = getCoverDrawable(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.mActiveThumbDrawable.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
      }
    }
    else
    {
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "url  is null");
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
    amdm.a().clearCache();
  }
  
  public void onNetMobile2None()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetMobile2Wifi s = " + paramString);
    amdm.a().clearCache();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetNone2Mobile s = " + paramString);
    this.a.ceK();
    amdm.a().clearCache();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetNone2Wifi s = " + paramString);
    amdm.a().clearCache();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2Mobile s = " + paramString);
    this.a.ceK();
    amdm.a().clearCache();
  }
  
  public void onNetWifi2None()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2None");
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof amem)) {
      this.a = ((amem)paramBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdc
 * JD-Core Version:    0.7.0.1
 */