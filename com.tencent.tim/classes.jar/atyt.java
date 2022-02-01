import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.List;

public class atyt
  extends BaseAdapter
{
  private List<atzy.a> BE;
  private Drawable eQ;
  private Context mContext;
  private Drawable mLoadingDrawable;
  private int mTargetDensity;
  
  public atyt(Context paramContext)
  {
    this.mContext = paramContext;
    this.mTargetDensity = this.mContext.getResources().getDisplayMetrics().densityDpi;
    this.mTargetDensity *= 2;
    this.eQ = paramContext.getResources().getDrawable(2130851853);
    this.mLoadingDrawable = paramContext.getResources().getDrawable(2130839657);
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
      paramView = new atyt.a(null);
      paramView.aB = ((URLImageView)localView.findViewById(2131368820));
      paramView.SA = ((TextView)localView.findViewById(2131379724));
      paramView.progressBar = ((ProgressBar)localView.findViewById(2131373668));
      localView.setTag(paramView);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (atzy.a)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      paramView.aB.setImageDrawable(this.eQ);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (atyt.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject2 = ((atzy.a)localObject1).c();
    ((atzy.a)localObject1).getImageType();
    if (localObject2 != null)
    {
      Drawable localDrawable = this.mLoadingDrawable;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = this.eQ;
      localURLDrawableOptions.mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
      ((URLDrawable)localObject2).setTargetDensity(this.mTargetDensity);
      paramView.aB.setImageDrawable((Drawable)localObject2);
      if (((atzy.a)localObject1).isLoading()) {
        paramView.progressBar.setVisibility(0);
      }
    }
    for (;;)
    {
      break;
      paramView.progressBar.setVisibility(4);
      continue;
      paramView.aB.setImageDrawable(this.eQ);
      if (!((atzy.a)localObject1).ca())
      {
        paramView.SA.setVisibility(0);
        localView.setTag(2131296386, Float.valueOf(1.0F));
      }
    }
  }
  
  public void kK(List<atzy.a> paramList)
  {
    this.BE = paramList;
  }
  
  class a
  {
    TextView SA;
    URLImageView aB;
    ProgressBar progressBar = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyt
 * JD-Core Version:    0.7.0.1
 */