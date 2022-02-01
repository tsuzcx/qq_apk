package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aoop;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.a;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;
import ram;
import rim;
import rim.a;
import riq;
import riw;

public class LocationFaceAdapter
  extends riq<rim>
  implements View.OnClickListener
{
  public LocationFaceAdapter(Context paramContext)
  {
    super(paramContext);
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
    for (Object localObject = new LocationItemLayout(this.context, paramViewGroup.getWidth(), ((rim)this.c).tu(), ((rim)this.c).az(), this);; localObject = (LocationItemLayout)paramView)
    {
      ((LocationItemLayout)localObject).a((rim)this.c, paramInt, getCount());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131379225)).intValue();
    rim.a locala = (rim.a)((rim)this.c).items.get(i);
    ImageView localImageView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)localImageView.getTag(2131379203);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      locala.dj = localImageView.getDrawable();
      this.b.c(locala);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ram.d("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
  
  static class LocationItemLayout
    extends LinearLayout
  {
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
      this.mItemWidth = (this.mParentWidth / this.mCount);
      buQ();
    }
    
    private void buQ()
    {
      setOrientation(0);
      setGravity(17);
      int j = riw.dip2px(getContext(), 3.0F);
      int k = (int)((this.mItemWidth - j * 2) * this.nr);
      int i = 0;
      while (i < this.mCount)
      {
        View localView = LayoutInflater.from(getContext()).inflate(2131561882, null);
        localView.setLayoutParams(new ViewGroup.LayoutParams(this.mItemWidth - j * 2, this.mItemWidth - j * 2));
        ((ImageView)localView.findViewById(2131370851)).setPadding(k, k, k, k);
        addView(localView);
        i += 1;
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
    
    public void a(rim paramrim, int paramInt1, int paramInt2)
    {
      int i = paramInt1 * this.mCount;
      label31:
      Object localObject3;
      URLImageView localURLImageView;
      TextView localTextView;
      Object localObject2;
      String str;
      Object localObject1;
      if (paramInt1 == paramInt2 - 1)
      {
        paramInt1 = paramrim.getFaceCount();
        xB(paramInt1 - i);
        paramInt2 = i;
        if (paramInt2 >= paramInt1) {
          return;
        }
        localObject3 = getChildAt(paramInt2 - i);
        localURLImageView = (URLImageView)((View)localObject3).findViewById(2131370851);
        localTextView = (TextView)((View)localObject3).findViewById(2131370863);
        localObject2 = (ProgressBar)((View)localObject3).findViewById(2131370861);
        str = paramrim.getCategory(paramInt2);
        localObject1 = paramrim.cc(paramInt2);
        if (localObject1 != null) {
          break label137;
        }
        ram.e("LocationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", new Object[] { paramrim.toString() });
      }
      for (;;)
      {
        paramInt2 += 1;
        break label31;
        paramInt1 = this.mCount + i;
        break;
        label137:
        ((View)localObject3).setContentDescription(str);
        localTextView.setText(str);
        localURLImageView.setOnClickListener(this.mListener);
        localURLImageView.setTag(2131379225, Integer.valueOf(paramInt2));
        localObject3 = (Boolean)localURLImageView.getTag(2131379203);
        if ((localObject3 != null) && (((Boolean)localObject3).booleanValue()) && (((String)localObject1).equals(localURLImageView.getTag(2131379238))))
        {
          ((ProgressBar)localObject2).setVisibility(4);
        }
        else
        {
          localURLImageView.setTag(2131379238, localObject1);
          localURLImageView.setTag(2131379203, Boolean.valueOf(false));
          ((ProgressBar)localObject2).setVisibility(0);
          localObject2 = new LocationFaceAdapter.a((String)localObject1, localURLImageView, (ProgressBar)localObject2);
          localURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject2);
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = aoop.TRANSPARENT;
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = aoop.TRANSPARENT;
          ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
          if (((URLDrawable)localObject1).getStatus() == 1) {
            ((LocationFaceAdapter.a)localObject2).onLoadSuccessed(localURLImageView, (URLDrawable)localObject1);
          }
          localURLImageView.setImageDrawable((Drawable)localObject1);
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter
 * JD-Core Version:    0.7.0.1
 */