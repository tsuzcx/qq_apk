package com.tencent.token.ui;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.token.global.e;

final class nw
  extends BaseAdapter
{
  private JianLingActivity a;
  private LayoutInflater b;
  
  public nw(JianLingActivity paramJianLingActivity)
  {
    this.a = paramJianLingActivity;
    this.b = LayoutInflater.from(paramJianLingActivity);
  }
  
  public final int getCount()
  {
    if (this.a.mLiBaoImgs != null) {
      return this.a.mLiBaoImgs.length;
    }
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    e.c("jl activity gallery " + paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.b.inflate(2130903109, paramViewGroup, false);
    }
    paramView = this.a.mLiBaoImgs[paramInt];
    if (paramView == null) {
      return localView;
    }
    paramViewGroup = (ImageView)localView.findViewById(2131296716);
    if (IndexActivity.S_DENSITY <= 1.0F)
    {
      paramViewGroup.setAdjustViewBounds(true);
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams((int)(paramView.getWidth() * 0.7F), (int)(paramView.getHeight() * 0.65F)));
    }
    paramViewGroup.setImageBitmap(paramView);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nw
 * JD-Core Version:    0.7.0.1
 */