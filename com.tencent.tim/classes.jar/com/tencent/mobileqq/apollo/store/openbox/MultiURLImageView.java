package com.tencent.mobileqq.apollo.store.openbox;

import abtn;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import java.util.Iterator;
import java.util.List;

public class MultiURLImageView
  extends LinearLayout
{
  private List<a> wA;
  
  public MultiURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.wA != null)
    {
      Iterator localIterator = this.wA.iterator();
      paramInt1 = 0;
      paramInt2 = 0;
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        int i;
        if (super.getOrientation() == 1)
        {
          i = locala.mHeight;
          paramInt2 = Math.max(paramInt2, locala.mWidth);
          paramInt1 += i;
        }
        for (;;)
        {
          break;
          i = locala.mWidth;
          int j = locala.bAr;
          paramInt1 = Math.max(paramInt1, locala.mHeight);
          paramInt2 += i + j;
        }
      }
      super.setMeasuredDimension(paramInt2, paramInt1);
    }
  }
  
  public void setOrientation(int paramInt)
  {
    super.setOrientation(paramInt);
    if (paramInt == 1)
    {
      super.setGravity(1);
      return;
    }
    super.setGravity(16);
  }
  
  public void setViewLayoutDatas(List<a> paramList)
  {
    this.wA = paramList;
    int i;
    a locala;
    Object localObject;
    if (this.wA != null)
    {
      i = 0;
      if (i < this.wA.size())
      {
        locala = (a)this.wA.get(i);
        if (!TextUtils.isEmpty(locala.mUrl)) {}
      }
      else
      {
        if (super.getChildCount() <= this.wA.size()) {
          break label253;
        }
        i = this.wA.size();
        while (i < super.getChildCount())
        {
          super.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
      localObject = locala.bhU;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label266;
      }
      localObject = Utils.Crc64String(locala.mUrl);
    }
    label266:
    for (;;)
    {
      if (super.getChildCount() > i)
      {
        paramList = super.getChildAt(i);
        if (!(paramList instanceof URLImageView)) {}
      }
      for (paramList = (URLImageView)paramList;; paramList = null)
      {
        if (paramList == null)
        {
          paramList = new URLImageView(super.getContext());
          super.addView(paramList);
        }
        for (;;)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramList.getLayoutParams();
          localLayoutParams.width = locala.mWidth;
          localLayoutParams.height = locala.mHeight;
          localLayoutParams.leftMargin = locala.bAr;
          localObject = abtn.a((String)localObject, null, locala.mUrl);
          ((URLDrawable)localObject).startDownload();
          paramList.setImageDrawable((Drawable)localObject);
          paramList.setScaleType(locala.mScaleType);
          paramList.setVisibility(0);
          i += 1;
          break;
          label253:
          super.requestLayout();
          return;
        }
      }
    }
  }
  
  public static class a
  {
    public int bAr;
    public String bhU;
    public int mHeight;
    public ImageView.ScaleType mScaleType = ImageView.ScaleType.CENTER_INSIDE;
    public String mUrl;
    public int mWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.MultiURLImageView
 * JD-Core Version:    0.7.0.1
 */