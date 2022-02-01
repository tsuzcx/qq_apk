package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import acfp;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import ram;
import rfr;
import rgl;
import rgn;
import rin;
import riq;
import riw;

public class NormalFaceAdapter
  extends riq<rin>
  implements View.OnClickListener
{
  public NormalFaceAdapter(Context paramContext)
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
    for (Object localObject = new NormalItemLayout(this.context, paramViewGroup.getWidth(), ((rin)this.c).tu(), ((rin)this.c).az(), this);; localObject = (NormalItemLayout)paramView)
    {
      ((NormalItemLayout)localObject).a((rin)this.c, paramInt, getCount());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    ImageView localImageView = (ImageView)paramView;
    int j = ((Integer)localImageView.getTag(2131379225)).intValue();
    rin localrin = (rin)this.c;
    Object localObject3 = Uri.parse(localrin.cc(j));
    Object localObject1 = ((Uri)localObject3).getPath();
    String str = new File((String)localObject1).getName();
    try
    {
      localObject1 = Drawable.createFromPath((String)localObject1);
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        try
        {
          j = ((RelativeLayout.LayoutParams)((ListView)paramView.getParent().getParent()).getLayoutParams()).leftMargin;
          i = j;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            float f2;
            float f3;
            float f4;
            float f5;
            int k;
            Object localObject2;
            ram.e("NormalFaceAdapter", "get marginLeft error : %s", localException);
            continue;
            float f1 = (i - (k + (i - j) / 2) * 2) / i;
          }
        }
        localObject3 = (NormalItemLayout)paramView.getParent();
        j = (int)rfr.getY((View)localObject3);
        f2 = rfr.getX(paramView);
        f3 = paramView.getWidth() / 2;
        f4 = i;
        f5 = ((NormalItemLayout)localObject3).getHeight() / 2 + j;
        i = ((Drawable)localObject1).getIntrinsicWidth();
        j = localImageView.getWidth();
        k = localImageView.getPaddingLeft();
        if (j > i)
        {
          f1 = (((j - i) / 2 - k) * 2 + i) / i;
          localObject1 = new rgl(localrin.name, str, (Drawable)localObject1);
          this.b.a((rgl)localObject1, f4 + (f2 + f3), f5, f1 * 1.2F);
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ram.e("NormalFaceAdapter", "createFromPath error", localOutOfMemoryError);
        localObject2 = null;
        continue;
        ram.e("NormalFaceAdapter", "can create drawable from uri:" + localException);
      }
    }
  }
  
  static class NormalItemLayout
    extends LinearLayout
  {
    private int bsd;
    private int mCount;
    private View.OnClickListener mListener;
    private int mPadding;
    private int mParentWidth;
    
    public NormalItemLayout(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener)
    {
      super();
      this.mListener = paramOnClickListener;
      this.mParentWidth = paramInt1;
      this.mCount = paramInt2;
      paramInt1 /= this.mCount;
      this.mPadding = ((int)(paramInt1 * paramFloat));
      this.bsd = (paramInt1 - this.mPadding * 2);
      buQ();
    }
    
    private void buQ()
    {
      int i = 0;
      setOrientation(0);
      setGravity(17);
      int j = this.mParentWidth / this.mCount;
      while (i < this.mCount)
      {
        ImageView localImageView = new ImageView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        if (i == 0) {
          localLayoutParams.leftMargin = riw.dip2px(getContext(), 7.0F);
        }
        if (i == this.mCount - 1) {
          localLayoutParams.rightMargin = riw.dip2px(getContext(), 7.0F);
        }
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setPadding(this.mPadding, this.mPadding, this.mPadding, this.mPadding);
        addView(localImageView);
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
    
    public void a(rin paramrin, int paramInt1, int paramInt2)
    {
      int i = paramInt1 * this.mCount;
      if (paramInt1 == paramInt2 - 1) {}
      for (paramInt1 = paramrin.getFaceCount();; paramInt1 = this.mCount + i)
      {
        xB(paramInt1 - i);
        paramInt2 = i;
        while (paramInt2 < paramInt1)
        {
          ImageView localImageView = (ImageView)getChildAt(paramInt2 - i);
          localImageView.setOnClickListener(this.mListener);
          String str = paramrin.cc(paramInt2);
          localImageView.setTag(2131379238, str);
          localImageView.setTag(2131379225, Integer.valueOf(paramInt2));
          localImageView.setContentDescription(acfp.m(2131709144) + paramInt2);
          rgn.a().a(getContext(), localImageView, str, this.bsd, this.bsd, null);
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter
 * JD-Core Version:    0.7.0.1
 */