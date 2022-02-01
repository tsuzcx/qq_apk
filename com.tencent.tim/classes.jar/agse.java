import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.ProGallery.b;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.List;

public class agse
  extends BaseAdapter
  implements ProGallery.b
{
  private List<aguk.a> BE;
  private Drawable eQ;
  private SparseArray<URLDrawable> mActiveDrawable = new SparseArray();
  private Context mContext;
  private Drawable mLoadingDrawable;
  private int mTargetDensity;
  
  public agse(Context paramContext)
  {
    this.mContext = paramContext;
    this.mTargetDensity = this.mContext.getResources().getDisplayMetrics().densityDpi;
    this.eQ = paramContext.getResources().getDrawable(2130851853);
    this.mLoadingDrawable = paramContext.getResources().getDrawable(2130839657);
  }
  
  private void updateRotation(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      paramInt = 0;
      if (paramURLDrawable.isAnim()) {
        break;
      }
    }
    for (;;)
    {
      paramView.setTag(2131296390, Boolean.valueOf(bool));
      if (bool) {
        paramView.setTag(2131296389, Integer.valueOf(paramInt));
      }
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      bool = false;
    }
  }
  
  public int getCount()
  {
    if (this.BE != null) {
      return this.BE.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.BE != null) {
      return this.BE.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131561066, null);
      paramView = new agse.a(null);
      paramView.aB = ((URLImageView)localView.findViewById(2131368820));
      paramView.SA = ((TextView)localView.findViewById(2131379724));
      paramView.progressBar = ((ProgressBar)localView.findViewById(2131373668));
      localView.setTag(paramView);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (aguk.a)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      paramView.aB.setImageDrawable(this.eQ);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (agse.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    URL localURL = ((aguk.a)localObject1).c();
    int i = ((aguk.a)localObject1).getImageType();
    if (localURL != null)
    {
      Object localObject2 = this.mLoadingDrawable;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
      localURLDrawableOptions.mFailedDrawable = this.eQ;
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseExifOrientation = false;
      localObject2 = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      ((URLDrawable)localObject2).setTargetDensity(this.mTargetDensity);
      paramView.aB.setImageDrawable((Drawable)localObject2);
      if (((aguk.a)localObject1).isLoading())
      {
        paramView.progressBar.setVisibility(0);
        label246:
        updateRotation(localView, (URLDrawable)localObject2, ((aguk.a)localObject1).getOrientation());
        if ((i != 1) || (!AsyncImageView.c(localURL)) || (!ahbj.isFileExists(((aguk.a)localObject1).aw()))) {
          break label321;
        }
        ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
        this.mActiveDrawable.put(paramInt, localObject2);
      }
    }
    for (;;)
    {
      break;
      paramView.progressBar.setVisibility(4);
      break label246;
      label321:
      this.mActiveDrawable.remove(paramInt);
      continue;
      paramView.aB.setImageDrawable(this.eQ);
      if (!((aguk.a)localObject1).ca())
      {
        paramView.SA.setVisibility(0);
        localView.setTag(2131296386, Float.valueOf(1.0F));
      }
    }
  }
  
  public void kK(List<aguk.a> paramList)
  {
    this.BE = paramList;
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
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
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (paramView != null) {
      paramView.updateRegionBitmap(paramRegionDrawableData);
    }
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  class a
  {
    TextView SA;
    URLImageView aB;
    ProgressBar progressBar = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agse
 * JD-Core Version:    0.7.0.1
 */