import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter.2;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter.3;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class apuz
  extends BaseAdapter
  implements advm.a, URLDrawableDownListener
{
  public static final int[] oN = { 0, 480, 480 };
  protected List<MediaPreviewInfo> Iu;
  protected advm a;
  protected Gallery b;
  protected boolean cSy = true;
  protected SparseArray<WeakReference<URLDrawable>> dJ;
  protected Context mContext;
  public Drawable mFailedDrawable;
  protected LayoutInflater mInflater;
  
  public apuz(Context paramContext, Gallery paramGallery)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.b = paramGallery;
    this.mFailedDrawable = paramContext.getResources().getDrawable(2130838158);
    this.dJ = new SparseArray();
    paramContext = (advr)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(180);
    if (paramContext == null) {}
    this.a = paramContext.a();
    this.a.a(this);
  }
  
  public MediaPreviewInfo a(int paramInt)
  {
    if ((this.Iu != null) && (paramInt < getCount())) {
      return (MediaPreviewInfo)this.Iu.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, ImageView paramImageView, File paramFile, String paramString) {}
  
  protected void a(int paramInt, MediaPreviewInfo paramMediaPreviewInfo, apuz.a parama)
  {
    long l = System.currentTimeMillis();
    if ((parama == null) || (paramMediaPreviewInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "loadVideo() mediaInfo = " + paramMediaPreviewInfo);
    }
    parama.EM.setVisibility(8);
    File localFile;
    boolean bool2;
    if (!TextUtils.isEmpty(paramMediaPreviewInfo.videoLocalPath))
    {
      localFile = new File(paramMediaPreviewInfo.videoLocalPath);
      bool2 = localFile.exists();
      if (bool2) {
        a(paramInt, parama.I, localFile, paramMediaPreviewInfo.imageUrl);
      }
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.e("MediaPreviewAdapter", 2, "loadVideo() videoFileExsits = " + bool2 + ", videoLocalPath = " + paramMediaPreviewInfo.videoLocalPath);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(paramMediaPreviewInfo.videoUrl))
        {
          bool1 = advm.lj(paramMediaPreviewInfo.videoUrl);
          if (bool1)
          {
            localFile = advm.h(paramMediaPreviewInfo.videoUrl);
            a(paramInt, parama.I, localFile, paramMediaPreviewInfo.imageUrl);
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("MediaPreviewAdapter", 2, "loadVideo() videoFileExsits = " + bool1 + ", videoUrl = " + paramMediaPreviewInfo.videoUrl);
            bool2 = bool1;
          }
        }
      }
      if (!bool2)
      {
        if (TextUtils.isEmpty(paramMediaPreviewInfo.videoUrl)) {
          break label411;
        }
        parama.I.setImageDrawable(b(paramMediaPreviewInfo.imageUrl));
        if (aqiw.isWifiEnabled(this.mContext)) {
          break label393;
        }
        parama.EM.setVisibility(0);
        parama.EM.setOnClickListener(new apva(this, parama, paramMediaPreviewInfo));
      }
      while (QLog.isColorLevel())
      {
        QLog.e("MediaPreviewAdapter", 2, "loadVideo() videoFileExsits = " + bool2 + ", videoUrl = " + paramMediaPreviewInfo.videoUrl + ", costTime = " + (System.currentTimeMillis() - l));
        return;
        label393:
        parama.EM.setVisibility(8);
        b(paramMediaPreviewInfo, parama);
        continue;
        label411:
        parama.I.setImageDrawable(this.mFailedDrawable);
        if (QLog.isColorLevel()) {
          QLog.e("MediaPreviewAdapter", 2, "loadVideo() error startDownloadDynamicAvatar: " + paramMediaPreviewInfo.videoUrl);
        }
      }
      break;
    }
  }
  
  protected void a(URLDrawable paramURLDrawable, boolean paramBoolean) {}
  
  public void a(MediaPreviewInfo paramMediaPreviewInfo, apuz.a parama)
  {
    if ((parama == null) || (paramMediaPreviewInfo == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MediaPreviewAdapter", 2, "loadBigImage() mediaInfo = " + paramMediaPreviewInfo);
      }
      try
      {
        paramMediaPreviewInfo = paramMediaPreviewInfo.imageUrl;
        Object localObject = Uri.parse(paramMediaPreviewInfo).getScheme();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || ((!((String)localObject).equals("http")) && (!((String)localObject).equals("https")))) {}
        for (paramMediaPreviewInfo = new File(paramMediaPreviewInfo).toURL();; paramMediaPreviewInfo = new URL(paramMediaPreviewInfo))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AppSetting.displayWidth;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AppSetting.bAd;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
          if (this.cSy) {
            ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          }
          a(parama.c);
          parama.EM.setVisibility(8);
          paramMediaPreviewInfo = URLDrawable.getDrawable(paramMediaPreviewInfo, (URLDrawable.URLDrawableOptions)localObject);
          parama.I.setImageDrawable(paramMediaPreviewInfo);
          parama.I.setTag(parama);
          parama.I.setURLDrawableDownListener(this);
          return;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (MalformedURLException paramMediaPreviewInfo) {}
    }
    QLog.i("MediaPreviewAdapter", 2, paramMediaPreviewInfo.toString());
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public Drawable b(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected void b(MediaPreviewInfo paramMediaPreviewInfo, apuz.a parama)
  {
    long l = System.currentTimeMillis();
    if (this.a != null) {
      this.a.li(paramMediaPreviewInfo.videoUrl);
    }
    b(parama.c, 0);
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "startDownloadVideo: " + paramMediaPreviewInfo.videoUrl + ", costTime = " + (System.currentTimeMillis() - l));
    }
  }
  
  public void b(ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    if (paramImageProgressCircle == null) {
      return;
    }
    if (paramImageProgressCircle.getVisibility() != 0) {
      paramImageProgressCircle.setVisibility(0);
    }
    paramImageProgressCircle.setProgress(paramInt);
  }
  
  public void bH(boolean paramBoolean, int paramInt)
  {
    if (this.dJ == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MediaPreviewAdapter", 2, "pauseOtherVideos() release = " + paramBoolean + ", specialPosition = " + paramInt);
      }
      int j = this.dJ.size();
      int i = 0;
      if (i < j)
      {
        int k = this.dJ.keyAt(i);
        URLDrawable localURLDrawable = (URLDrawable)((WeakReference)this.dJ.get(k)).get();
        if (paramInt == k) {
          x(localURLDrawable);
        }
        for (;;)
        {
          i += 1;
          break;
          a(localURLDrawable, paramBoolean);
        }
      }
    } while (!paramBoolean);
    this.dJ.clear();
  }
  
  public void doOnDestory()
  {
    bH(true, -1);
    if (this.a != null) {
      this.a.b(this);
    }
  }
  
  public void ei(String paramString, int paramInt)
  {
    Object localObject = this.b.getSelectedView().getTag();
    MediaPreviewInfo localMediaPreviewInfo = a(this.b.getSelectedItemPosition());
    if ((localMediaPreviewInfo != null) && (paramString.equals(localMediaPreviewInfo.videoUrl)) && ((localObject instanceof apuz.a)))
    {
      b(((apuz.a)localObject).c, paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("MediaPreviewAdapter", 2, "onDownloadUpdate progress: " + paramInt);
      }
    }
  }
  
  public int getCount()
  {
    if (this.Iu != null) {
      return this.Iu.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.mInflater.inflate(2131559532, null);
      paramView = new apuz.a();
      paramView.I = ((URLImageView)localView.findViewById(2131368820));
      paramView.c = ((ImageProgressCircle)localView.findViewById(2131368926));
      paramView.EM = ((ImageView)localView.findViewById(2131378697));
      localView.setTag(paramView);
      a(paramView.c);
      localObject = (MediaPreviewInfo)this.Iu.get(paramInt);
      if (((MediaPreviewInfo)localObject).type != 1) {
        break label152;
      }
      a((MediaPreviewInfo)localObject, paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (apuz.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label152:
      if (((MediaPreviewInfo)localObject).type == 2) {
        a(paramInt, (MediaPreviewInfo)localObject, paramView);
      }
    }
  }
  
  public void j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "onDownloadFinish() isSuccess = " + paramBoolean1 + ", url = " + paramString);
    }
    Object localObject = this.b.getSelectedView().getTag();
    int i = this.b.getSelectedItemPosition();
    MediaPreviewInfo localMediaPreviewInfo = a(i);
    if ((localMediaPreviewInfo != null) && (paramString.equals(localMediaPreviewInfo.videoUrl)) && ((localObject instanceof apuz.a)))
    {
      localObject = (apuz.a)localObject;
      boolean bool = false;
      paramBoolean2 = bool;
      if (paramBoolean1)
      {
        paramBoolean2 = bool;
        if (advm.lj(localMediaPreviewInfo.videoUrl))
        {
          File localFile = advm.h(localMediaPreviewInfo.videoUrl);
          ((apuz.a)localObject).I.post(new MediaPreviewAdapter.2(this, (apuz.a)localObject, i, localFile, localMediaPreviewInfo));
          paramBoolean2 = true;
        }
      }
      if (!paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MediaPreviewAdapter", 2, "onDownloadFinish() finalSuc = " + paramBoolean2 + ", url = " + paramString);
        }
        ((apuz.a)localObject).I.post(new MediaPreviewAdapter.3(this, (apuz.a)localObject));
      }
    }
  }
  
  public void mV(List<MediaPreviewInfo> paramList)
  {
    this.Iu = paramList;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (paramView = paramURLDrawable.getURL().toString();; paramView = "")
    {
      if (paramThrowable == null) {}
      for (paramURLDrawable = "";; paramURLDrawable = paramThrowable.getMessage())
      {
        if (QLog.isColorLevel()) {
          QLog.i("MediaPreviewAdapter", 2, "onLoadFailed() urlStr = " + paramView + ", errorMsg = " + paramURLDrawable);
        }
        return;
      }
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    b(((apuz.a)paramView.getTag()).c, paramInt);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (apuz.a)paramView.getTag();
    a(paramView.c);
    paramView.I.setImageDrawable(paramURLDrawable);
    String str = "";
    paramView = str;
    if (paramURLDrawable != null)
    {
      paramView = str;
      if (paramURLDrawable.getURL() != null) {
        paramView = paramURLDrawable.getURL().toString();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "onLoadSuccessed() urlStr = " + paramView);
    }
  }
  
  public void x(URLDrawable paramURLDrawable) {}
  
  public class a
  {
    ImageView EM;
    public URLImageView I;
    public ImageProgressCircle c;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apuz
 * JD-Core Version:    0.7.0.1
 */