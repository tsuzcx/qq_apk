import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.BaseView;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class amcy
  extends amcu
{
  public amdw b;
  public MqqHandler b;
  
  public amcy()
  {
    this.jdField_b_of_type_MqqOsMqqHandler = new amcz(this);
  }
  
  public void Up(int paramInt)
  {
    try
    {
      this.mActiveDrawable.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public Intent a(AIOFileVideoData paramAIOFileVideoData, Activity paramActivity)
  {
    boolean bool = true;
    if ((paramAIOFileVideoData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Intent localIntent = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOFileVideoData.msgId, paramAIOFileVideoData.subId, 0);
      if (localIntent != null)
      {
        if (paramAIOFileVideoData.istroop == 1) {}
        for (;;)
        {
          amdk.a(paramActivity, localIntent, bool);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
          return localIntent;
          bool = false;
        }
      }
    }
    return null;
  }
  
  public AIOFileVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
      return (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.jdField_b_of_type_Amdw.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle);
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    IProvider localIProvider = RichMediaBrowserManager.getInstance().getProvider();
    if (localIProvider == null)
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleUnDownloadVideo failed : provider null");
      return;
    }
    localIProvider.onFileVideoStatusChange(paramAIOFileVideoData.msgId, 11, null);
  }
  
  public boolean avH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoPresenterXOXO", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + aeex.agA());
    }
    return aeex.agA();
  }
  
  public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      localAIOFileVideoData.aix = ((paramInt3 / 10000.0F * (float)localAIOFileVideoData.size));
      localRichMediaBrowserInfo.baseData = localAIOFileVideoData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData)) && (((AIOFileVideoData)localRichMediaBrowserInfo.baseData).msgId == paramLong1)) {
      this.jdField_b_of_type_Amdw.updateUI();
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    AIOFileVideoData localAIOFileVideoData;
    if ((paramInt2 == 269484034) && (localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      QLog.i("AIOFileVideoPresenterXOXO", 1, "-----------> recv download finish:" + paramLong);
      if (paramInt3 == 1)
      {
        if (!TextUtils.isEmpty(paramString)) {
          localAIOFileVideoData.mFilePath = paramString;
        }
        localAIOFileVideoData.bit = true;
        localAIOFileVideoData.isAutoPlay = false;
        if (!localAIOFileVideoData.aZm) {
          break label258;
        }
        localAIOFileVideoData.status = 6;
        label123:
        paramBoolean = localAIOFileVideoData.aZm;
        localRichMediaBrowserInfo.baseData = localAIOFileVideoData;
        updateItem(localRichMediaBrowserInfo);
      }
    }
    for (;;)
    {
      if (paramInt2 == 269484034)
      {
        paramString = getSelectedItem();
        if ((paramString != null) && ((paramString.baseData instanceof AIOBrowserBaseData)) && (((AIOBrowserBaseData)paramString.baseData).msgId == paramLong)) {
          if (paramBoolean)
          {
            if (paramInt3 != 1) {
              break label267;
            }
            QQToast.a(this.jdField_b_of_type_Amdw.mContext, 2, this.jdField_b_of_type_Amdw.mContext.getString(2131718933), 0).show();
          }
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Amdw.updateUI();
        QLog.i("AIOFileVideoPresenterXOXO", 1, "-----------> recv download finish set playing!");
        return;
        if (paramInt3 != 2) {
          break;
        }
        localAIOFileVideoData.bit = false;
        break;
        label258:
        localAIOFileVideoData.status = 5;
        break label123;
        label267:
        if (paramInt3 == 2) {
          QQToast.a(this.jdField_b_of_type_Amdw.mContext, 1, this.jdField_b_of_type_Amdw.mContext.getString(2131718961), 0).show();
        }
      }
      paramBoolean = false;
    }
  }
  
  public void b(AIOFileVideoData paramAIOFileVideoData)
  {
    IProvider localIProvider = RichMediaBrowserManager.getInstance().getProvider();
    if (localIProvider == null)
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "cancelDownload failed : provider null");
      return;
    }
    localIProvider.onFileVideoStatusChange(paramAIOFileVideoData.msgId, 12, paramAIOFileVideoData.bundle);
  }
  
  public void c(AIOFileVideoData paramAIOFileVideoData)
  {
    IProvider localIProvider = RichMediaBrowserManager.getInstance().getProvider();
    if (localIProvider == null)
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
      return;
    }
    localIProvider.onFileVideoStatusChange(paramAIOFileVideoData.msgId, 10, paramAIOFileVideoData.bundle);
  }
  
  public void d(AIOFileVideoData paramAIOFileVideoData)
  {
    IProvider localIProvider = RichMediaBrowserManager.getInstance().getProvider();
    if (localIProvider == null)
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
      return;
    }
    localIProvider.onFileVideoStatusChange(paramAIOFileVideoData.msgId, 14, paramAIOFileVideoData.bundle);
  }
  
  public void dMu()
  {
    if ((this.c != null) && (this.c.b != null) && (this.c.a() != null))
    {
      boolean bool = false;
      AIOFileVideoData localAIOFileVideoData = a();
      if (localAIOFileVideoData != null) {
        bool = aqhq.fileExistsAndNotEmpty(localAIOFileVideoData.mFilePath);
      }
      if (bool)
      {
        if (!ayxa.isLiuHaiUseValid()) {
          break label117;
        }
        this.c.a().setMarginTop((int)wja.a(ayxa.sNotchHeight, this.jdField_b_of_type_Amdw.mContext.getResources()) + 46);
      }
    }
    for (;;)
    {
      this.c.a().clear();
      this.c.a().cWC();
      this.c.b.dMQ();
      return;
      label117:
      this.c.a().setMarginTop(46);
    }
  }
  
  public long fs()
  {
    return 0L;
  }
  
  public void ld(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).isAutoPlay = false;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void le(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).isMutePlay = false;
      updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public boolean lg(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
      return ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).isAutoPlay;
    }
    return false;
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof amdw)) {
      this.jdField_b_of_type_Amdw = ((amdw)paramBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcy
 * JD-Core Version:    0.7.0.1
 */