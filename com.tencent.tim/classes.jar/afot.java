import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.ProGallery.b;
import com.tencent.mobileqq.emoticonview.EmotionPreviewInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class afot
  extends BaseAdapter
  implements ProGallery.b
{
  private int imageHeight;
  private List<EmotionPreviewInfo> jl;
  private SparseArray<URLDrawable> mActiveDrawable = new SparseArray();
  private Context mContext;
  private Drawable mDefaultPhotoDrawable;
  
  public afot(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDefaultPhotoDrawable = this.mContext.getResources().getDrawable(2130848704);
    this.imageHeight = wja.dp2px(207.0F, this.mContext.getResources());
  }
  
  private URL getFileUrl(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = paramFile.toURI().toURL();
      return paramFile;
    }
    catch (MalformedURLException paramFile) {}
    return null;
  }
  
  public EmotionPreviewInfo a(int paramInt)
  {
    if ((this.jl != null) && (paramInt < this.jl.size())) {
      return (EmotionPreviewInfo)this.jl.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.jl != null) {
      return this.jl.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView != null) {
      localObject1 = paramView;
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = new URLImageView(this.mContext);
      localObject2 = a(paramInt);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((EmotionPreviewInfo)localObject2).path))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotionPreviewAdapter", 2, "getView Path is empty. position " + paramInt + ", size " + getCount());
      }
      ((URLImageView)localObject1).setImageDrawable(aoop.TRANSPARENT);
    }
    Object localObject3 = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (localObject3 != null) {
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    for (;;)
    {
      ((URLImageView)localObject1).setContentDescription("照片" + paramInt);
      break;
      Object localObject4 = new File(((EmotionPreviewInfo)localObject2).path);
      localObject2 = null;
      if (((File)localObject4).exists())
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.imageHeight;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.imageHeight;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.mDefaultPhotoDrawable;
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        localObject4 = getFileUrl((File)localObject4);
        if (localObject4 != null)
        {
          localObject3 = URLDrawable.getDrawable((URL)localObject4, (URLDrawable.URLDrawableOptions)localObject3);
          localObject2 = localObject3;
          if (localObject3 != null)
          {
            localObject2 = localObject3;
            switch (((URLDrawable)localObject3).getStatus())
            {
            default: 
              ((URLDrawable)localObject3).setTag(Integer.valueOf(1));
              ((URLDrawable)localObject3).startDownload();
              localObject2 = localObject3;
            }
          }
        }
        if (localObject2 != null)
        {
          ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
          this.mActiveDrawable.put(paramInt, localObject2);
        }
        else
        {
          ((URLImageView)localObject1).setImageDrawable(this.mDefaultPhotoDrawable);
        }
      }
      else
      {
        ((URLImageView)localObject1).setImageDrawable(this.mDefaultPhotoDrawable);
      }
    }
  }
  
  public void kw(List<EmotionPreviewInfo> paramList)
  {
    this.jl = paramList;
    notifyDataSetChanged();
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          paramView = a(paramInt);
          if ((paramView != null) && (!TextUtils.isEmpty(paramView.path))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("EmotionPreviewAdapter", 2, "onCreateView Path is empty. position " + paramInt + ", size " + getCount());
        return null;
        paramViewGroup = new File(paramView.path);
      } while (!paramViewGroup.exists());
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = this.imageHeight;
      paramView.mRequestHeight = this.imageHeight;
      paramView.mLoadingDrawable = aoop.TRANSPARENT;
      paramView.mPlayGifImage = true;
      paramViewGroup = getFileUrl(paramViewGroup);
    } while (paramViewGroup == null);
    paramView = URLDrawable.getDrawable(paramViewGroup, paramView);
    paramView.setTag(Integer.valueOf(1));
    paramView.startDownload();
    this.mActiveDrawable.put(paramInt, paramView);
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.mActiveDrawable.remove(paramInt);
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afot
 * JD-Core Version:    0.7.0.1
 */