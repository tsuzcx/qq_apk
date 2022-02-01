import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.GalleryItemVideo.1;
import com.tencent.mobileqq.nearby.picbrowser.GalleryItemVideo.2;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class akbj
  extends akbr
  implements advm.a
{
  boolean NW = false;
  advm a;
  advr b;
  WeakReference<akbr.a> ht;
  WeakReference<URLImageView> mImageView;
  Handler mUIHandler = new Handler(Looper.getMainLooper());
  int position;
  int progress = 0;
  int status = 0;
  
  public akbj(Context paramContext, PicInfo paramPicInfo)
  {
    super(paramContext, paramPicInfo);
    paramContext = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface)) {
      this.b = ((advr)paramContext.getManager(180));
    }
    for (;;)
    {
      if (this.b == null) {}
      this.jdField_a_of_type_Advm = this.b.a();
      this.jdField_a_of_type_Advm.a(this);
      return;
      if ((paramContext instanceof NearbyAppInterface)) {
        this.b = ((advr)paramContext.getManager(180));
      }
    }
  }
  
  @NonNull
  private URLDrawable.URLDrawableOptions a(Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mUseMemoryCache = false;
    localURLDrawableOptions.mMemoryCacheKeySuffix = "GalleryItemVideo";
    paramDrawable = new VideoDrawable.VideoDrawableParams();
    paramDrawable.mPlayVideoFrame = true;
    paramDrawable.mPlayAudioFrame = true;
    paramDrawable.mEnableAntiAlias = true;
    paramDrawable.mEnableFilter = true;
    localURLDrawableOptions.mUseMemoryCache = false;
    localURLDrawableOptions.mExtraInfo = paramDrawable;
    return localURLDrawableOptions;
  }
  
  private URLDrawable c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString.replaceFirst("http", "nearbyimage");
      localObject1 = localObject2;
      if (aoiz.hasFile(str))
      {
        paramString = URLDrawable.getDrawable(str, null);
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          QLog.i("GalleryItemVideo", 2, "PicBrowserGalleryAdapter getView loadingDrawble is: " + str);
          localObject1 = paramString;
        }
      }
    }
    return localObject1;
  }
  
  public void MF(boolean paramBoolean)
  {
    if (!paramBoolean) {
      pauseAudio();
    }
  }
  
  public View a(int paramInt, Handler paramHandler, akbr.a parama)
  {
    this.position = paramInt;
    URLImageView localURLImageView = new URLImageView(this.mContext);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo == null) {
      return localURLImageView;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GalleryItemVideo", 2, "getView pos:" + paramInt);
    }
    this.mImageView = new WeakReference(localURLImageView);
    this.ht = new WeakReference(parama);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
    paramHandler = c(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.bSZ);
    int i;
    label148:
    label186:
    boolean bool2;
    if (paramHandler != null)
    {
      i = 1;
      if (i == 0)
      {
        paramHandler = c(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.thumbUrl);
        if (paramHandler == null) {
          break label456;
        }
        i = 1;
        if (i == 0)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.thumbUrl)) {
            break label462;
          }
          paramHandler = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.thumbUrl.replaceFirst("http", "nearbyimage"), (URLDrawable.URLDrawableOptions)localObject);
        }
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoLocalPath)) {
        break label523;
      }
      localObject = new File(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoLocalPath);
      bool2 = ((File)localObject).exists();
      bool1 = bool2;
      if (bool2) {
        localURLImageView.setImageDrawable(URLDrawable.getDrawable((File)localObject, a(paramHandler)));
      }
    }
    label523:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl))
        {
          bool1 = advm.lj(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl);
          bool2 = bool1;
          if (bool1)
          {
            localURLImageView.setImageDrawable(URLDrawable.getDrawable(advm.h(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl), a(paramHandler)));
            bool2 = bool1;
          }
        }
      }
      if (!bool2) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl))
        {
          this.status = 0;
          localURLImageView.setImageDrawable(paramHandler);
          paramHandler = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (this.jdField_a_of_type_Advm.li(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl)) {
            this.progress = 0;
          }
          parama.onLoadStart(paramInt, this.progress);
          label396:
          if (QLog.isColorLevel()) {
            QLog.i("GalleryItemVideo", 2, "fileNotExsits progress:" + this.progress + " url:" + this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl);
          }
        }
      }
      for (;;)
      {
        return localURLImageView;
        i = 0;
        break;
        label456:
        i = 0;
        break label148;
        label462:
        paramHandler = aoop.TRANSPARENT;
        break label186;
        localURLImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
        this.status = 2;
        parama.onLoadFinish(paramInt, false);
        break label396;
        this.progress = 0;
        this.status = 1;
        parama.onLoadFinish(paramInt, true);
      }
    }
  }
  
  public void a(View paramView, int paramInt, akbr.a parama)
  {
    boolean bool2 = true;
    paramView = (URLImageView)paramView;
    Drawable localDrawable = paramView.getDrawable();
    if ((localDrawable == null) || (!(localDrawable instanceof URLDrawable))) {
      return;
    }
    if ((this.status != 1) && (this.status != 2) && (this.status != 3) && (this.status != 4))
    {
      if (QLog.isColorLevel()) {
        QLog.i("GalleryItemVideo", 2, "updateProgressOnSelected:" + this.progress);
      }
      if (this.progress > 0) {
        parama.onLoadProgressUpdate(paramInt, this.progress / 100);
      }
      paramView.setMinimumHeight(10);
      paramView.setMinimumWidth(10);
      return;
    }
    boolean bool1 = bool2;
    if (this.status != 1) {
      if (this.status != 4) {
        break label165;
      }
    }
    label165:
    for (bool1 = bool2;; bool1 = false)
    {
      parama.onLoadFinish(paramInt, bool1);
      break;
    }
  }
  
  public void ei(String paramString, int paramInt)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl))
    {
      this.progress = paramInt;
      if ((this.ht != null) && (this.ht.get() != null)) {
        ((akbr.a)this.ht.get()).onLoadProgressUpdate(this.position, paramInt);
      }
    }
  }
  
  public Drawable getAnimationDrawable()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo == null) {
      localObject2 = null;
    }
    for (;;)
    {
      return localObject2;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
      localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
      localObject2 = c(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.bSZ);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = c(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.thumbUrl);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      try
      {
        localObject1 = new URL(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.thumbUrl);
        localObject1 = URLDrawable.getDrawable(new URL("nearbyimage", ((URL)localObject1).getAuthority(), ((URL)localObject1).getFile()), localURLDrawableOptions);
        localObject2 = getThumbRect();
        if ((localObject1 != null) && (localObject2 != null))
        {
          this.cutValue = getCutValue((Rect)localObject2, (Drawable)localObject1);
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("GalleryItemVideo", 2, "getAnimationDrawable ,cutValue = " + this.cutValue);
          return localObject1;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isDevelopLevel())
          {
            localMalformedURLException.printStackTrace();
            localObject1 = localObject2;
          }
        }
      }
    }
    return null;
  }
  
  public void j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl)) {
      if (!paramBoolean1) {
        break label90;
      }
    }
    label90:
    for (int i = 1;; i = 2)
    {
      this.status = i;
      if (QLog.isColorLevel()) {
        QLog.i("GalleryItemVideo", 2, "onDownloadFinish pos:" + this.position + " suc:" + paramBoolean1);
      }
      if ((this.ht != null) && (this.mImageView != null)) {
        break;
      }
      return;
    }
    Object localObject = (akbr.a)this.ht.get();
    paramString = (URLImageView)this.mImageView.get();
    if (localObject != null)
    {
      ((akbr.a)localObject).onLoadFinish(this.position, paramBoolean1);
      ((akbr.a)localObject).AY(this.position);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onDownloadFinish onloadli=null:");
      if (localObject != null) {
        break label303;
      }
    }
    label303:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      QLog.i("GalleryItemVideo", 2, paramBoolean2);
      if (paramString == null) {
        break;
      }
      i = j;
      if (paramBoolean1)
      {
        i = j;
        if (advm.lj(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl))
        {
          localObject = URLDrawable.getDrawable(advm.h(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl), a(paramString.getDrawable()));
          this.mUIHandler.post(new GalleryItemVideo.1(this, paramString, (URLDrawable)localObject));
          i = 1;
        }
      }
      if (i != 0) {
        break;
      }
      localObject = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158);
      this.mUIHandler.post(new GalleryItemVideo.2(this, paramString, (Drawable)localObject));
      return;
    }
  }
  
  public void onPause()
  {
    this.NW = true;
    pauseAudio();
    super.onPause();
  }
  
  public void pauseAudio()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GalleryItemVideo", 2, "pause audio:" + this.position);
    }
    if (this.mImageView != null)
    {
      Object localObject = (URLImageView)this.mImageView.get();
      if (localObject != null)
      {
        localObject = ((URLImageView)localObject).getDrawable();
        if ((localObject != null) && ((localObject instanceof URLDrawable)))
        {
          localObject = (URLDrawable)localObject;
          if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable)) {
            ((VideoDrawable)((URLDrawable)localObject).getCurrDrawable()).stopAudio();
          }
        }
      }
    }
  }
  
  public void preload()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl))
    {
      if (QLog.isColorLevel()) {
        QLog.i("GalleryItemVideo", 2, "preload:" + this.position);
      }
      if (!advm.lj(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl)) {
        this.jdField_a_of_type_Advm.li(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.videoUrl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbj
 * JD-Core Version:    0.7.0.1
 */