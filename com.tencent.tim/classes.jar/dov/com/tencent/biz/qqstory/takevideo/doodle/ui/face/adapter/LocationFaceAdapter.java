package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import aoop;
import axqg;
import axwb;
import axwb.a;
import aynd;
import aynd.a;
import aynh;
import ayom;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import java.lang.ref.WeakReference;
import java.util.List;
import ram;

public class LocationFaceAdapter
  extends aynh<aynd>
  implements View.OnClickListener
{
  public LocationFaceAdapter(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.c == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new LocationItemLayout(this.context, paramViewGroup.getWidth(), ((aynd)this.c).tu(), ((aynd)this.c).az(), this);; localObject = (LocationItemLayout)paramView)
    {
      ((LocationItemLayout)localObject).a((aynd)this.c, paramInt, getCount(), aQR());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131370851);
    int i = ((Integer)((ImageView)localObject1).getTag(2131379225)).intValue();
    aynd.a locala = (aynd.a)((aynd)this.c).items.get(i);
    Object localObject2 = (Boolean)((ImageView)localObject1).getTag(2131379203);
    int j;
    int k;
    float f;
    if ((localObject2 != null) && (((Boolean)localObject2).booleanValue()))
    {
      locala.dj = ((ImageView)localObject1).getDrawable();
      localObject2 = locala.dj;
      if (localObject2 != null)
      {
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        i = ((Drawable)localObject2).getIntrinsicWidth();
        j = ((ImageView)localObject1).getWidth();
        k = ((ImageView)localObject1).getPaddingLeft();
        if (j <= i) {
          break label206;
        }
        f = (((j - i) / 2 - k) * 2 + i) / i;
        f = (float)(f * ((aynd)this.c).scale);
        localObject1 = axwb.a();
        this.f.a(locala, ((axwb.a)localObject1).x, ((axwb.a)localObject1).y, f);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label206:
      f = (i - (k + (i - j) / 2) * 2) / i;
      break;
      ram.d("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
  
  static class LocationItemLayout
    extends LinearLayout
  {
    private final int eKH = 5;
    private int mCount;
    private int mItemWidth;
    private View.OnClickListener mListener;
    private int mParentWidth;
    private float nr;
    
    public LocationItemLayout(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener)
    {
      super();
      this.mListener = paramOnClickListener;
      this.mParentWidth = paramInt1;
      this.mCount = paramInt2;
      this.nr = paramFloat;
      paramInt1 = ayom.dip2px(getContext(), 6.0F);
      this.mItemWidth = ((this.mParentWidth - paramInt1 * ((this.mCount - 1) * 2)) / this.mCount);
      buQ();
    }
    
    private void buQ()
    {
      setOrientation(0);
      setGravity(17);
      int j = ayom.dip2px(getContext(), 12.0F);
      int k = (int)((this.mItemWidth - j * 2) * this.nr);
      int i = 0;
      if (i < this.mCount)
      {
        View localView = LayoutInflater.from(getContext()).inflate(2131559261, null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemWidth);
        if (i == 0) {
          localLayoutParams.setMargins(0, j, j / 2, 0);
        }
        for (;;)
        {
          localView.setLayoutParams(localLayoutParams);
          ((ImageView)localView.findViewById(2131370851)).setPadding(k, k, k, k);
          addView(localView);
          i += 1;
          break;
          if (this.mCount - 1 == i) {
            localLayoutParams.setMargins(j / 2, j, 0, 0);
          } else {
            localLayoutParams.setMargins(j / 2, j, j / 2, 0);
          }
        }
      }
    }
    
    private void xB(int paramInt)
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = paramInt;
        if (i >= paramInt) {
          break;
        }
        j = paramInt;
        if (i >= getChildCount()) {
          break;
        }
        getChildAt(i).setVisibility(0);
        i += 1;
      }
      while ((j < this.mCount) && (j < getChildCount()))
      {
        getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    
    public void a(aynd paramaynd, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = paramInt1 * this.mCount;
      label31:
      URLImageView localURLImageView;
      ProgressBar localProgressBar;
      String str;
      if (paramInt1 == paramInt2 - 1)
      {
        paramInt1 = paramaynd.getFaceCount();
        xB(paramInt1 - i);
        paramInt2 = i;
        if (paramInt2 >= paramInt1) {
          return;
        }
        localObject1 = getChildAt(paramInt2 - i);
        localObject2 = ((View)localObject1).findViewById(2131370862);
        localURLImageView = (URLImageView)((View)localObject1).findViewById(2131370851);
        localObject3 = (TextView)((View)localObject1).findViewById(2131370863);
        localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131370861);
        str = paramaynd.getCategory(paramInt2);
        localObject1 = paramaynd.cc(paramInt2);
        if (localObject1 != null) {
          break label146;
        }
        ram.e("LocationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", new Object[] { paramaynd.toString() });
      }
      for (;;)
      {
        paramInt2 += 1;
        break label31;
        paramInt1 = this.mCount + i;
        break;
        label146:
        ((TextView)localObject3).setText(str);
        ((View)localObject2).setOnClickListener(this.mListener);
        localURLImageView.setTag(2131379225, Integer.valueOf(paramInt2));
        if (paramBoolean) {
          break label193;
        }
        localProgressBar.setVisibility(4);
        localURLImageView.setImageDrawable(null);
      }
      label193:
      localURLImageView.setTag(2131379238, localObject1);
      localURLImageView.setTag(2131379203, Boolean.valueOf(false));
      localProgressBar.setVisibility(0);
      Object localObject2 = new LocationFaceAdapter.a((String)localObject1, localURLImageView, localProgressBar);
      localURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject2);
      Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
      Object localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
      if (((URLDrawable)localObject1).getStatus() == 1) {
        ((LocationFaceAdapter.a)localObject2).onLoadSuccessed(localURLImageView, (URLDrawable)localObject1);
      }
      if (paramBoolean) {}
      for (;;)
      {
        localURLImageView.setImageDrawable((Drawable)localObject1);
        break;
        localObject1 = null;
      }
    }
  }
  
  static class a
    implements URLDrawableDownListener
  {
    private final WeakReference<ImageView> de;
    private final WeakReference<ProgressBar> df;
    private final String url;
    
    public a(@NonNull String paramString, @NonNull ImageView paramImageView, @NonNull ProgressBar paramProgressBar)
    {
      this.url = paramString;
      this.de = new WeakReference(paramImageView);
      this.df = new WeakReference(paramProgressBar);
    }
    
    private boolean b(ImageView paramImageView)
    {
      paramImageView = (String)paramImageView.getTag(2131379238);
      return (!TextUtils.isEmpty(paramImageView)) && (paramImageView.equals(this.url));
    }
    
    public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
    {
      ram.d("LocationFaceAdapter", "onLoadCanceled,url:" + this.url);
      paramView = (ImageView)this.de.get();
      paramURLDrawable = (ProgressBar)this.df.get();
      if ((paramView != null) && (paramURLDrawable != null) && (b(paramView)))
      {
        paramURLDrawable.setVisibility(4);
        paramView.setTag(2131379203, Boolean.valueOf(false));
        return;
      }
      ram.d("LocationFaceAdapter", "onLoadCanceled error.");
    }
    
    public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      ram.d("LocationFaceAdapter", "onLoadFialed,url:" + this.url);
      paramView = (ImageView)this.de.get();
      paramURLDrawable = (ProgressBar)this.df.get();
      if ((paramView != null) && (paramURLDrawable != null) && (b(paramView)))
      {
        paramURLDrawable.setVisibility(0);
        paramView.setTag(2131379203, Boolean.valueOf(false));
        return;
      }
      ram.d("LocationFaceAdapter", "onLoadFialed error.");
    }
    
    public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
    
    public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
    {
      ram.d("LocationFaceAdapter", "onLoadProgressed,url:" + this.url);
      paramView = (ImageView)this.de.get();
      paramURLDrawable = (ProgressBar)this.df.get();
      if ((paramView != null) && (paramURLDrawable != null) && (b(paramView)))
      {
        paramURLDrawable.setVisibility(0);
        paramView.setTag(2131379203, Boolean.valueOf(false));
        return;
      }
      ram.d("LocationFaceAdapter", "onLoadProgressed error.");
    }
    
    public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
    {
      ram.d("LocationFaceAdapter", "onLoadSuccessed,url:" + this.url);
      paramView = (ImageView)this.de.get();
      paramURLDrawable = (ProgressBar)this.df.get();
      if ((paramView != null) && (paramURLDrawable != null) && (b(paramView)))
      {
        paramURLDrawable.setVisibility(4);
        paramView.setTag(2131379203, Boolean.valueOf(true));
        return;
      }
      ram.d("LocationFaceAdapter", "onLoadSuccessed error.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter
 * JD-Core Version:    0.7.0.1
 */