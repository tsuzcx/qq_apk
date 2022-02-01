import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.BaseView;
import com.tencent.richmediabrowser.view.BrowserBaseAdapter.URLImageView2;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.page.Gallery;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class amda
  extends amcu
{
  public amea a;
  
  public static void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
      return;
    }
    AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
    amcs localamcs = new amcs();
    File localFile = localamcs.a(localAIOPictureData, 4);
    if (localFile == null) {
      localFile = localamcs.a(localAIOPictureData, 2);
    }
    for (int i = 0;; i = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localamcs.a(localAIOPictureData, 1));
      if ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData))
      {
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        localamcs = new amcs();
        if (i == 0) {
          break label255;
        }
      }
      for (int j = 4;; j = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localamcs.a(paramRichMediaBrowserInfo, j));
        if (localFile == null) {
          break;
        }
        try
        {
          localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (i != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", amdj.a(localAIOPictureData));
          if (localAIOPictureData.EP == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras(localBundle);
          ahgq.f(paramActivity, paramRichMediaBrowserInfo, paramInt);
          return;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          label255:
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramRichMediaBrowserInfo);
          return;
        }
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,cache path is null");
      return;
    }
  }
  
  public static Intent b(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
      return null;
    }
    AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
    amcs localamcs = new amcs();
    File localFile = localamcs.a(localAIOPictureData, 4);
    if (localFile == null) {
      localFile = localamcs.a(localAIOPictureData, 2);
    }
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localamcs.a(localAIOPictureData, 1));
      if ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData))
      {
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        localamcs = new amcs();
        if (paramInt == 0) {
          break label249;
        }
      }
      for (int i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localamcs.a(paramRichMediaBrowserInfo, i));
        if (localFile == null) {
          break;
        }
        try
        {
          localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (paramInt != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", amdj.a(localAIOPictureData));
          if (localAIOPictureData.EP == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras(localBundle);
          return paramRichMediaBrowserInfo;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          label249:
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramRichMediaBrowserInfo);
          return null;
        }
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,cache path is null");
      return null;
    }
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "TYPE_ORIGINAL_IMAGE result = " + paramInt3 + ", resultStr = " + paramString);
    Object localObject;
    if (paramInt3 == 1)
    {
      localObject = paramString;
      a(paramLong, paramInt1, paramInt2, (String)localObject);
      if (paramInt3 == 1)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        paramString = null;
      }
    }
    else
    {
      try
      {
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
        localURLDrawable = URLDrawable.getFileDrawable(((AIOPictureData)paramRichMediaBrowserInfo.baseData).aVX, null);
        if (localURLDrawable == null) {
          break label195;
        }
        localURLDrawable.downloadImediatly();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localURLDrawable;
        label125:
        localObject = URLDrawable.getDrawable(new amcs().a((AIOPictureData)paramRichMediaBrowserInfo.baseData, 4), (URLDrawable.URLDrawableOptions)localObject);
        paramString = (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        GalleryUrlImageView localGalleryUrlImageView;
        do
        {
          for (;;)
          {
            URLDrawable localURLDrawable;
            localThrowable.printStackTrace();
          }
          localGalleryUrlImageView = (GalleryUrlImageView)this.a.galleryView.findViewById(2131368820);
        } while (localGalleryUrlImageView == null);
        localGalleryUrlImageView.setGalleryImageListener(new amdb(this, paramString, paramRichMediaBrowserInfo));
        localGalleryUrlImageView.setImageDrawable(paramString);
        this.a.hu = wja.a(this.a.Di, paramString);
        return;
      }
      if (paramString == null) {
        QQToast.a(this.a.mContext, this.a.mContext.getString(2131697153), 0).show();
      }
    }
    label195:
    while ("TroopFileError".equals(paramString))
    {
      return;
      localObject = "I:E";
      break;
      localURLDrawable = URLDrawable.getFileDrawable(((AIOPictureData)paramRichMediaBrowserInfo.baseData).aVW, null);
      if (localURLDrawable == null) {
        break label125;
      }
      localURLDrawable.downloadImediatly();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localURLDrawable;
      break label125;
    }
    QQToast.a(this.a.mContext, this.a.mContext.getString(2131697153), 0).show();
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
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public Intent a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (AIOPictureData.class.isInstance(paramRichMediaBrowserInfo.baseData)))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((localAIOPictureData.istroop == 1) && (localAIOPictureData.bjg))
      {
        if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
        {
          paramRichMediaBrowserInfo = RichMediaBrowserManager.getInstance().getProvider().getForwardData(localAIOPictureData.msgId, localAIOPictureData.subId, 0);
          if (paramRichMediaBrowserInfo == null)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "forwardPicToFriend getForwardData is null!");
            return null;
          }
          paramRichMediaBrowserInfo.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
          if (localAIOPictureData.istroop == 1) {}
          for (boolean bool = true;; bool = false) {
            return amdk.a(paramActivity, paramRichMediaBrowserInfo, bool);
          }
        }
      }
      else {
        return a(paramRichMediaBrowserInfo, paramActivity, 0);
      }
    }
    return null;
  }
  
  public Intent a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    int i = amcj.a().IB();
    AIOPictureData localAIOPictureData;
    amcs localamcs;
    if ((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 6))
    {
      if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
        return null;
      }
      localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      localamcs = new amcs();
      paramRichMediaBrowserInfo = localamcs.a(localAIOPictureData, 4);
      if (paramRichMediaBrowserInfo != null) {
        break label381;
      }
      paramRichMediaBrowserInfo = localamcs.a(localAIOPictureData, 2);
    }
    label381:
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localamcs.a(localAIOPictureData, 1));
      if (paramInt != 0) {}
      for (i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localamcs.a(localAIOPictureData, i));
        if (paramRichMediaBrowserInfo == null) {
          break;
        }
        try
        {
          localBundle.putString("forward_filepath", paramRichMediaBrowserInfo.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (paramInt != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOPictureData);
          localBundle.putBoolean("key_help_forward_pic", true);
          localBundle.putBoolean("key_allow_multiple_forward_from_limit", false);
          if (!TextUtils.isEmpty(localAIOPictureData.templateId))
          {
            localBundle.putBoolean("forward_send_template_pic", true);
            localBundle.putString("widgetinfo", localAIOPictureData.templateId);
            localBundle.putString("key_camera_material_name", localAIOPictureData.templateName);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras(localBundle);
          return paramRichMediaBrowserInfo;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramRichMediaBrowserInfo.getMessage());
          return null;
        }
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,cache path is null");
      return null;
      return b(paramRichMediaBrowserInfo, paramActivity, paramInt);
    }
  }
  
  public void a(AIOPictureData paramAIOPictureData)
  {
    if ((paramAIOPictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "dealSaveOriginalImage");
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramAIOPictureData.msgId, paramAIOPictureData.subId, 24);
    }
  }
  
  protected void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt1, amda.a parama, int paramInt2, String paramString)
  {
    int i = amcj.a().IB();
    if ((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 6))
    {
      if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
        return;
      }
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      amcs localamcs = new amcs();
      paramInt1 = 1;
      Object localObject = localamcs.a(localAIOPictureData, 4);
      paramRichMediaBrowserInfo = (RichMediaBrowserInfo)localObject;
      if (localObject == null)
      {
        paramRichMediaBrowserInfo = localamcs.a(localAIOPictureData, 2);
        paramInt1 = 0;
      }
      localObject = new Bundle(paramActivity.getIntent().getExtras());
      ((Bundle)localObject).putInt("forward_type", 1);
      ((Bundle)localObject).putBoolean("forward_urldrawable", true);
      ((Bundle)localObject).putString("forward_urldrawable_thumb_url", localamcs.a(localAIOPictureData, 1));
      if (paramInt1 != 0) {}
      for (i = 4;; i = 2)
      {
        ((Bundle)localObject).putString("forward_urldrawable_big_url", localamcs.a(localAIOPictureData, i));
        if (paramRichMediaBrowserInfo == null) {
          break;
        }
        try
        {
          ((Bundle)localObject).putString("forward_filepath", paramRichMediaBrowserInfo.getAbsolutePath());
          ((Bundle)localObject).putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (paramInt1 != 0) {
            ((Bundle)localObject).putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          ((Bundle)localObject).putParcelable("FORWARD_MSG_FOR_PIC", localAIOPictureData);
          ((Bundle)localObject).putBoolean("key_help_forward_pic", true);
          ((Bundle)localObject).putBoolean("key_allow_multiple_forward_from_limit", false);
          if (!TextUtils.isEmpty(localAIOPictureData.templateId))
          {
            ((Bundle)localObject).putBoolean("forward_send_template_pic", true);
            ((Bundle)localObject).putString("widgetinfo", localAIOPictureData.templateId);
            ((Bundle)localObject).putString("key_camera_material_name", localAIOPictureData.templateName);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras((Bundle)localObject);
          if ((parama == null) || (parama.action != 72)) {
            break label444;
          }
          paramRichMediaBrowserInfo.putExtra("key_req", ForwardRecentActivity.bGS);
          paramRichMediaBrowserInfo.putExtra("key_direct_show_uin_type", parama.uinType);
          paramRichMediaBrowserInfo.putExtra("key_direct_show_uin", parama.uin);
          ahgq.a(paramActivity, paramRichMediaBrowserInfo, ForwardRecentTranslucentActivity.class, 19005, paramInt2, paramString);
          return;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramRichMediaBrowserInfo.getMessage());
          return;
        }
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,cache path is null");
      return;
      label444:
      ahgq.a(paramActivity, paramRichMediaBrowserInfo, 19005, paramInt2, paramString);
      return;
    }
    a(paramRichMediaBrowserInfo, paramActivity, paramInt1);
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, amda.a parama, int paramInt, String paramString)
  {
    boolean bool = false;
    AIOPictureData localAIOPictureData;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (AIOPictureData.class.isInstance(paramRichMediaBrowserInfo.baseData)))
    {
      localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((localAIOPictureData.istroop != 1) || (!localAIOPictureData.bjg)) {
        break label154;
      }
      if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
      {
        paramRichMediaBrowserInfo = RichMediaBrowserManager.getInstance().getProvider().getForwardData(localAIOPictureData.msgId, localAIOPictureData.subId, 0);
        if (paramRichMediaBrowserInfo != null) {
          break label120;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "forwardPicToFriend getForwardData is null!");
      }
    }
    return;
    label120:
    paramRichMediaBrowserInfo.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    if (localAIOPictureData.istroop == 1) {
      bool = true;
    }
    amdk.a(paramActivity, paramRichMediaBrowserInfo, bool, paramInt, paramString);
    return;
    label154:
    a(paramRichMediaBrowserInfo, paramActivity, 0, parama, paramInt, paramString);
  }
  
  public boolean avH()
  {
    boolean bool = aeex.agz();
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "isImmersionOpen:" + bool);
    return bool;
  }
  
  public void b(int paramInt, View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof BrowserBaseAdapter.URLImageView2))
    {
      paramView = (BrowserBaseAdapter.URLImageView2)paramView;
      Object localObject1 = getItem(paramInt);
      if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOPictureData)))
      {
        Object localObject2 = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
        Object localObject3 = new amcs();
        if ((paramBoolean) && (((amcs)localObject3).a((AIOPictureData)localObject2, 8) != null))
        {
          localObject1 = paramView.getDrawable();
          localObject2 = ((amcs)localObject3).a((AIOPictureData)localObject2, 8);
          localObject2 = (String)localObject2 + "#" + "DISPLAY";
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
          localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          paramView.setDecodingDrawble((URLDrawable)localObject1);
          ((URLDrawable)localObject1).startDownload();
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "updateDisplayView(): Update dp image, position=" + paramInt);
          a().dLD();
        }
      }
    }
  }
  
  public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    Object localObject = b(paramLong1, paramInt1);
    AIOPictureData localAIOPictureData;
    int i;
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOPictureData)))
    {
      localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      i = 0;
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localAIOPictureData.status = i;
      localAIOPictureData.progress = paramInt3;
      ((RichMediaBrowserInfo)localObject).baseData = localAIOPictureData;
      updateItem((RichMediaBrowserInfo)localObject);
      localObject = getSelectedItem();
      if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOPictureData)))
      {
        localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
        if ((((AIOPictureData)localObject).msgId == paramLong1) && (((AIOPictureData)localObject).subId == paramInt1) && (this.a != null))
        {
          this.a.updateUI();
          if ((paramBoolean) && (paramInt2 == 2) && (this.a.galleryView != null)) {
            b(getSelectedIndex(), this.a.galleryView, true);
          }
        }
      }
      return;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = b(paramLong, paramInt1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData.getType() == 100) && ((localRichMediaBrowserInfo.baseData instanceof AIOPictureData)))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)localRichMediaBrowserInfo.baseData;
      localAIOPictureData.status = 0;
      localAIOPictureData.progress = 0;
      localRichMediaBrowserInfo.baseData = localAIOPictureData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((this.a != null) && (localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOPictureData)) && (((AIOPictureData)localRichMediaBrowserInfo.baseData).msgId == paramLong) && (((AIOPictureData)localRichMediaBrowserInfo.baseData).subId == paramInt1))
    {
      if (paramInt2 != 2) {
        break label350;
      }
      if (paramInt3 != 1) {
        break label343;
      }
      paramInt2 = a(paramLong, paramInt1, paramInt2, paramString);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "notifyImageResult(): TYPE_LARGE_IMAGE Gallery position is " + paramInt2);
      paramString = b(paramLong, paramInt1);
      if ((paramString != null) && (paramString.baseData != null) && (paramString.baseData.getType() == 100) && (paramInt3 == 1))
      {
        paramString = (AIOPictureData)paramString.baseData;
        if ((!paramString.bjf) && (new File(paramString.aVW + "_hd").exists())) {
          paramString.aVW += "_hd";
        }
      }
      onLoadFinish(paramInt2, true);
      this.a.updateView(paramInt2, paramBoolean);
    }
    for (;;)
    {
      this.a.updateUI();
      return;
      label343:
      paramString = "I:E";
      break;
      label350:
      if (paramInt2 == 24)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "save pic result = " + paramInt3 + ", resultStr = " + paramString);
        if (paramInt3 == 1) {
          QQToast.a(this.a.mContext, this.a.mContext.getString(2131718933), 0).show();
        } else {
          QQToast.a(this.a.mContext, this.a.mContext.getString(2131718929), 0).show();
        }
      }
      else if (paramInt2 == 4)
      {
        b(paramLong, paramInt1, paramInt2, paramInt3, paramString, localRichMediaBrowserInfo);
      }
    }
  }
  
  public void dMu()
  {
    if ((this.a != null) && (this.c != null) && (this.c.b != null) && (this.c.a() != null))
    {
      this.gM.clear();
      if (!ayxa.isLiuHaiUseValid()) {
        break label108;
      }
      this.c.a().setMarginTop((int)wja.a(ayxa.sNotchHeight, this.a.mContext.getResources()) + 40);
    }
    for (;;)
    {
      this.c.a().clear();
      this.c.a().cWC();
      this.c.b.dMQ();
      return;
      label108:
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
    if ((paramBaseView instanceof amea)) {
      this.a = ((amea)paramBaseView);
    }
  }
  
  public void t(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.a != null))
    {
      if (getGallery() != null) {
        this.a.updateCache(paramURLDrawable, getGallery().getSelectedItemPosition());
      }
      notifyDataSetChanged();
      if (getGallery() != null) {
        getGallery().reset();
      }
    }
  }
  
  public static class a
  {
    public int action;
    public String uin;
    public int uinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amda
 * JD-Core Version:    0.7.0.1
 */