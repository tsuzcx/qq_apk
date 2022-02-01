import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.BaseView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.page.Gallery;
import java.util.concurrent.ConcurrentHashMap;

public class amcw
  extends amcu
{
  public amdr a;
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject;
    String str;
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null))
    {
      if (paramInt3 == 1)
      {
        localObject = paramString;
        a(paramLong, paramInt1, paramInt2, (String)localObject);
      }
    }
    else
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
      if (paramInt3 != 1) {
        break label411;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      str = new amco().a((AIOFilePictureData)paramRichMediaBrowserInfo.baseData, 20);
      if (!TextUtils.isEmpty(str)) {
        break label159;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "null url");
    }
    label159:
    do
    {
      return;
      localObject = "I:E";
      break;
      paramString = null;
      URLDrawable localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePictureData)paramRichMediaBrowserInfo.baseData).aVX, null);
      if (localURLDrawable != null)
      {
        localURLDrawable.downloadImediatly();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localURLDrawable;
      }
      for (;;)
      {
        try
        {
          localObject = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject);
          paramString = (String)localObject;
        }
        catch (Throwable localThrowable)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 4, "URLDrawable.getDrawable failed : " + localThrowable.getMessage());
          continue;
          GalleryUrlImageView localGalleryUrlImageView = (GalleryUrlImageView)this.a.galleryView.findViewById(2131368820);
          if (localGalleryUrlImageView == null) {
            break label386;
          }
          localGalleryUrlImageView.setGalleryImageListener(new amcx(this, paramString, paramRichMediaBrowserInfo));
          localGalleryUrlImageView.setImageDrawable(paramString);
          this.a.hu = wja.a(this.a.Di, paramString);
        }
        if (paramString != null) {
          continue;
        }
        QQToast.a(this.a.mContext, this.a.mContext.getString(2131697153), 0).show();
        return;
        localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePictureData)paramRichMediaBrowserInfo.baseData).aVW, null);
        if (localURLDrawable != null)
        {
          localURLDrawable.downloadImediatly();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localURLDrawable;
        }
      }
    } while (a().cCe);
    label386:
    a().dMn();
    a().dMm();
    return;
    label411:
    if (!"TroopFileError".equals(paramString))
    {
      if (!this.a.mContext.getString(2131694128).equals(paramString)) {
        break label467;
      }
      QQToast.a(this.a.mContext, paramString, 0).show();
    }
    for (;;)
    {
      this.a.OS(true);
      return;
      label467:
      QQToast.a(this.a.mContext, this.a.mContext.getString(2131697153), 0).show();
    }
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
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public Intent a(AIOFilePictureData paramAIOFilePictureData, Activity paramActivity)
  {
    boolean bool = true;
    if ((paramAIOFilePictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Intent localIntent = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOFilePictureData.msgId, paramAIOFilePictureData.subId, 0);
      if (localIntent != null)
      {
        if (paramAIOFilePictureData.istroop == 1) {}
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
  
  public AIOFilePictureData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFilePictureData)) && (localRichMediaBrowserInfo.baseData.getType() == 102)) {
      return (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public boolean avH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFilePicPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isImageEnable() = " + aeex.agz());
    }
    return aeex.agz();
  }
  
  public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = c(paramLong1);
    AIOFilePictureData localAIOFilePictureData;
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 102))
    {
      localAIOFilePictureData = (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
      int i = 0;
      paramInt1 = i;
      switch (paramInt2)
      {
      default: 
        paramInt1 = i;
      }
    }
    for (;;)
    {
      localAIOFilePictureData.status = paramInt1;
      localAIOFilePictureData.progress = paramInt3;
      localRichMediaBrowserInfo.baseData = localAIOFilePictureData;
      updateItem(localRichMediaBrowserInfo);
      localRichMediaBrowserInfo = getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).msgId == paramLong1)) {
        this.a.updateUI();
      }
      return;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject1 = c(paramLong);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 102))
    {
      localObject2 = (AIOFilePictureData)((RichMediaBrowserInfo)localObject1).baseData;
      ((AIOFilePictureData)localObject2).status = 0;
      ((AIOFilePictureData)localObject2).progress = 0;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      updateItem((RichMediaBrowserInfo)localObject1);
    }
    Object localObject2 = getSelectedItem();
    if ((localObject2 != null) && (((RichMediaBrowserInfo)localObject2).baseData != null) && (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject2).baseData).msgId == paramLong))
    {
      if (paramInt2 != 18) {
        break label250;
      }
      if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null))
      {
        if (paramInt3 != 1) {
          break label243;
        }
        localObject1 = paramString;
        paramInt1 = a(paramLong, paramInt1, paramInt2, (String)localObject1);
        if ((paramInt3 == 2) && (!TextUtils.isEmpty(paramString))) {
          new amco().b((AIOFilePictureData)((RichMediaBrowserInfo)localObject2).baseData, paramInt2, paramString);
        }
        this.a.updateView(paramInt1, this.a.galleryView, paramBoolean);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "notifyImageResult(): Gallery position is " + paramInt1);
      }
    }
    for (;;)
    {
      this.a.updateUI();
      return;
      label243:
      localObject1 = "I:E";
      break;
      label250:
      if (paramInt2 == 20) {
        a(paramLong, paramInt1, paramInt2, paramInt3, paramString, (RichMediaBrowserInfo)localObject2);
      }
    }
  }
  
  public void dMu()
  {
    if ((this.c != null) && (this.c.b != null) && (this.c.a() != null))
    {
      this.gM.clear();
      if (!ayxa.isLiuHaiUseValid()) {
        break label101;
      }
      this.c.a().setMarginTop((int)wja.a(ayxa.sNotchHeight, this.a.mContext.getResources()) + 40);
    }
    for (;;)
    {
      this.c.a().clear();
      this.c.a().cWC();
      this.c.b.dMQ();
      return;
      label101:
      this.c.a().setMarginTop(40);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a.hu != null) {
      this.a.Di.removeCallbacks(this.a.hu);
    }
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof amdr)) {
      this.a = ((amdr)paramBaseView);
    }
  }
  
  public void t(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.a != null))
    {
      if (getGallery() != null) {
        this.mActiveDrawable.put(Integer.valueOf(getGallery().getSelectedItemPosition()), paramURLDrawable);
      }
      notifyDataSetChanged();
      if (getGallery() != null) {
        getGallery().reset();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcw
 * JD-Core Version:    0.7.0.1
 */