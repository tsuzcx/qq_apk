import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.1;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.3;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class akbr
  extends sxy
{
  public PicInfo a;
  int cutValue;
  protected Context mContext;
  
  public akbr(Context paramContext, PicInfo paramPicInfo)
  {
    this.mContext = paramContext;
    this.a = paramPicInfo;
  }
  
  public void MF(boolean paramBoolean) {}
  
  public View a(int paramInt, Handler paramHandler, akbr.a parama)
  {
    File localFile = null;
    URL localURL = null;
    URLDrawable localURLDrawable = null;
    boolean bool2 = true;
    URLImageView localURLImageView = new URLImageView(this.mContext);
    if (this.a == null) {
      return localURLImageView;
    }
    Object localObject1;
    Object localObject3;
    label258:
    long l;
    if (!TextUtils.isEmpty(this.a.localPath))
    {
      localObject1 = URLDrawable.getDrawable(new File(this.a.localPath), null);
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.mContext.getResources().getDisplayMetrics().widthPixels;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.mContext.getResources().getDisplayMetrics().heightPixels;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = this.a;
      if (!TextUtils.isEmpty(this.a.localPath)) {
        localObject1 = localURLDrawable;
      }
    }
    else
    {
      try
      {
        localFile = new File(this.a.localPath);
        localObject1 = localURLDrawable;
        localURL = localFile.toURL();
        localObject1 = localURLDrawable;
        localURLDrawable = URLDrawable.getDrawable(new URL("nearbylocalimage", localURL.getAuthority(), localURL.getFile()), (URLDrawable.URLDrawableOptions)localObject3);
        localObject1 = localURLDrawable;
        localURLImageView.setImageDrawable(localURLDrawable);
        localObject1 = localURLDrawable;
        if (!localFile.exists()) {
          break label441;
        }
        localObject1 = localURLDrawable;
        bool1 = localFile.isFile();
        if (!bool1) {
          break label441;
        }
        bool1 = true;
        localObject1 = localURLDrawable;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        for (;;)
        {
          label315:
          if (QLog.isDevelopLevel()) {
            localMalformedURLException1.printStackTrace();
          }
          bool1 = false;
        }
      }
      if ((localObject1 == null) || (((URLDrawable)localObject1).getStatus() == 1) || (((URLDrawable)localObject1).getStatus() == 2) || (((URLDrawable)localObject1).getStatus() == 4)) {
        break label627;
      }
      localURLImageView.setURLDrawableDownListener(new akbs(this, parama, paramInt));
      if (!bool1) {
        break label619;
      }
      l = 1000L;
      paramHandler.postDelayed(new PicBrowserImage.3(this, (URLDrawable)localObject1, parama, paramInt), l);
    }
    for (;;)
    {
      label441:
      Object localObject2;
      for (;;)
      {
        return localURLImageView;
        if (!TextUtils.isEmpty(this.a.thumbUrl))
        {
          String str = this.a.thumbUrl.replaceFirst("http", "nearbyimage");
          if (aoiz.hasFile(str))
          {
            localObject3 = URLDrawable.getDrawable(str, null);
            localObject1 = localObject3;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("PicBrowser", 2, "PicBrowserGalleryAdapter getView loadingDrawble is: " + str);
            localObject1 = localObject3;
            break;
          }
          localObject1 = aoop.TRANSPARENT;
          break;
        }
        localObject1 = aoop.TRANSPARENT;
        break;
        bool1 = false;
        localObject1 = localURLDrawable;
        break label258;
        localObject2 = localURL;
        if (!TextUtils.isEmpty(this.a.bSZ))
        {
          localObject1 = localFile;
          try
          {
            localObject2 = aomc.l(this.a.bSZ);
            localObject1 = localFile;
            this.a.bSZ = ((URL)localObject2).toString();
            localObject1 = localFile;
            localObject2 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
            localObject1 = localObject2;
            ((URLDrawable)localObject2).setDownloadListener(new ajpe(this.mContext, "actNearbyPicBrowser"));
            localObject1 = localObject2;
            localURLImageView.setImageDrawable((Drawable)localObject2);
            localObject1 = localObject2;
            bool1 = aoiz.hasFile(this.a.bSZ);
            localObject1 = localObject2;
          }
          catch (MalformedURLException localMalformedURLException2)
          {
            localObject2 = localObject1;
            if (QLog.isDevelopLevel())
            {
              localMalformedURLException2.printStackTrace();
              localObject2 = localObject1;
            }
          }
        }
      }
      bool1 = false;
      localObject1 = localObject2;
      break label258;
      label619:
      l = 300L;
      break label315;
      label627:
      if (localObject1 != null) {
        break label643;
      }
      parama.onLoadFinish(paramInt, false);
    }
    label643:
    if (((URLDrawable)localObject1).getStatus() == 1) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      parama.onLoadFinish(paramInt, bool1);
      break;
    }
  }
  
  public void a(View paramView, int paramInt, akbr.a parama)
  {
    paramView = (URLImageView)paramView;
    URLDrawable localURLDrawable = (URLDrawable)paramView.getDrawable();
    if (localURLDrawable == null) {
      return;
    }
    if ((localURLDrawable.getStatus() != 1) && (localURLDrawable.getStatus() != 2))
    {
      int i = localURLDrawable.getProgress();
      if (i > 0) {
        parama.onLoadProgressUpdate(paramInt, i / 100);
      }
      paramView.setMinimumHeight(10);
      paramView.setMinimumWidth(10);
      return;
    }
    if (localURLDrawable.getStatus() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      parama.onLoadFinish(paramInt, bool);
      break;
    }
  }
  
  public Drawable getAnimationDrawable()
  {
    if (this.a == null) {
      return null;
    }
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = this.a;
    if (!TextUtils.isEmpty(this.a.localPath)) {}
    for (;;)
    {
      Object localObject4;
      Object localObject2;
      try
      {
        localObject1 = URLDrawable.getDrawable(new File(this.a.localPath).toURL(), (URLDrawable.URLDrawableOptions)localObject1);
        localObject4 = getThumbRect();
        if ((localObject1 == null) || (localObject4 == null)) {
          break;
        }
        this.cutValue = getCutValue((Rect)localObject4, (Drawable)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("PicBrowser", 2, "getAnimationDrawable ,cutValue = " + this.cutValue);
        }
        return localObject1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        if (QLog.isDevelopLevel()) {
          localMalformedURLException1.printStackTrace();
        }
        localObject2 = null;
        continue;
      }
      if (!TextUtils.isEmpty(this.a.thumbUrl)) {
        try
        {
          localObject4 = new URL(this.a.thumbUrl);
          localObject4 = new URL("nearbyimage", ((URL)localObject4).getAuthority(), ((URL)localObject4).getFile());
          if (aoiz.hasFile(((URL)localObject4).toString()))
          {
            localObject2 = URLDrawable.getDrawable((URL)localObject4, (URLDrawable.URLDrawableOptions)localObject2);
            continue;
          }
          localObject4 = new URL(this.a.bSZ);
          localObject2 = URLDrawable.getDrawable(new URL("nearbyimage", ((URL)localObject4).getAuthority(), ((URL)localObject4).getFile()), (URLDrawable.URLDrawableOptions)localObject2);
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          if (QLog.isDevelopLevel()) {
            localMalformedURLException2.printStackTrace();
          }
        }
      } else {
        Object localObject3 = null;
      }
    }
  }
  
  public int getCutValue()
  {
    return this.cutValue;
  }
  
  public void onPause() {}
  
  public void preload()
  {
    Object localObject;
    if (this.a != null) {
      localObject = this.a.bSZ;
    }
    try
    {
      localObject = aomc.l((String)localObject);
      if (localObject != null)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mExtraInfo = this.a;
        localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).setDownloadListener(new ajpe(this.mContext));
        ThreadManager.postImmediately(new PicBrowserImage.1(this, (URLDrawable)localObject), null, true);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static abstract interface a
  {
    public abstract void AY(int paramInt);
    
    public abstract void onLoadFinish(int paramInt, boolean paramBoolean);
    
    public abstract void onLoadProgressUpdate(int paramInt1, int paramInt2);
    
    public abstract void onLoadStart(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbr
 * JD-Core Version:    0.7.0.1
 */