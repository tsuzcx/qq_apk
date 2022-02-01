package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import auvk;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import rpq;

public class VideoListLayout
  extends ViewGroup
{
  private StoryNickNameView a;
  private int boM;
  private int boN;
  private int boO;
  private int boP;
  private int boQ;
  private int boR;
  private int boS;
  private int boT;
  private int boU;
  private int boV;
  private int boW;
  private QQStoryAutoPlayView c;
  private StoryHomeHorizontalListView d;
  private LinearLayout eW;
  @Deprecated
  private ImageView mZ;
  private int marginLeft;
  private int marginTop;
  private TextView time;
  @Deprecated
  private TextView xY;
  
  public VideoListLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    brJ();
    brK();
  }
  
  private void brJ()
  {
    this.boN = rpq.dip2px(getContext(), 15.0F);
    this.boO = this.boN;
    this.boT = rpq.dip2px(getContext(), 2.0F);
    this.marginLeft = getContext().getResources().getDimensionPixelSize(2131298952);
    this.marginTop = rpq.dip2px(getContext(), 10.0F);
    this.boP = rpq.dip2px(getContext(), 205.0F);
    this.boQ = rpq.dip2px(getContext(), 332.0F);
    this.boM = rpq.dip2px(getContext(), 252.0F);
    this.boR = rpq.dip2px(getContext(), 10.0F);
    this.boS = rpq.dip2px(getContext(), 2.0F);
    this.boU = rpq.dip2px(getContext(), 7.0F);
    this.boW = rpq.dip2px(getContext(), 10.0F);
    this.boV = rpq.dip2px(getContext(), 3.0F);
  }
  
  private void brK()
  {
    auvk.traceBegin("VideoListLayout.init");
    this.xY = ((TextView)LayoutInflater.from(getContext()).inflate(2131561843, this, false));
    this.mZ = new ImageView(getContext());
    this.mZ.setImageResource(2130847613);
    addView(this.mZ);
    addView(this.xY);
    this.xY.setVisibility(8);
    this.mZ.setVisibility(8);
    this.time = ((TextView)LayoutInflater.from(getContext()).inflate(2131561851, this, false));
    addView(this.time);
    this.a = ((StoryNickNameView)LayoutInflater.from(getContext()).inflate(2131561851, this, false));
    addView(this.a);
    this.c = ((QQStoryAutoPlayView)LayoutInflater.from(getContext()).inflate(2131561846, this, false));
    addView(this.c);
    this.d = ((StoryHomeHorizontalListView)LayoutInflater.from(getContext()).inflate(2131561853, this, false));
    addView(this.d);
    auvk.traceEnd();
  }
  
  public TextView B()
  {
    return this.xY;
  }
  
  public TextView C()
  {
    return this.time;
  }
  
  public QQStoryAutoPlayView a()
  {
    return this.c;
  }
  
  public StoryHomeHorizontalListView a()
  {
    return this.d;
  }
  
  public StoryNickNameView a()
  {
    return this.a;
  }
  
  protected void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = this.marginLeft;
    paramInt4 = this.marginTop;
    if ((this.mZ != null) && (this.mZ.getVisibility() != 8))
    {
      paramInt3 = paramInt2 + this.boN;
      paramInt1 = this.boO + paramInt4;
      this.mZ.layout(paramInt2, paramInt4, paramInt3, paramInt1);
    }
    for (;;)
    {
      if ((this.xY != null) && (this.xY.getVisibility() != 8))
      {
        paramInt3 += this.boS;
        int i = this.boT;
        int j = this.xY.getMeasuredWidth();
        this.xY.layout(paramInt3, paramInt4 - i, j + paramInt3, paramInt1);
      }
      if ((this.c != null) && (this.c.getVisibility() != 8))
      {
        paramInt3 = paramInt1;
        if (this.mZ != null)
        {
          if (this.mZ.getVisibility() == 8) {
            paramInt3 = paramInt1;
          }
        }
        else
        {
          paramInt1 = this.boP;
          paramInt4 = this.boQ + paramInt3;
          this.c.layout(paramInt2, paramInt3 + 0, paramInt1 + paramInt2, paramInt4);
          if (this.d != null) {
            this.d.layout(0, 0, 0, 0);
          }
          paramInt3 = paramInt4 + this.boU;
          if ((this.time == null) || (this.time.getVisibility() == 8)) {
            break label522;
          }
          paramInt4 = paramInt2 + this.time.getMeasuredWidth();
          paramInt1 = this.time.getMeasuredHeight() + paramInt3;
          this.time.layout(paramInt2, paramInt3, paramInt4, paramInt1);
          paramInt2 = paramInt4;
        }
      }
      for (;;)
      {
        if ((this.a != null) && (this.a.getVisibility() != 8))
        {
          paramInt2 = this.boV + paramInt2;
          paramInt4 = this.a.getMeasuredWidth();
          this.a.layout(paramInt2, paramInt3, paramInt4 + paramInt2, paramInt1);
        }
        label331:
        if ((this.eW != null) && (this.eW.getVisibility() != 8))
        {
          paramInt1 = getMeasuredWidth() - this.boW;
          paramInt2 = this.eW.getMeasuredWidth();
          paramInt3 = this.eW.getMeasuredHeight();
          this.eW.layout(paramInt1 - paramInt2, 0, paramInt1, paramInt3);
        }
        label493:
        while (this.eW == null)
        {
          return;
          paramInt3 = paramInt1 + this.boR;
          break;
          if ((this.d == null) || (this.d.getVisibility() == 8)) {
            break label331;
          }
          paramInt2 = paramInt1;
          if (this.mZ != null) {
            if (this.mZ.getVisibility() != 8) {
              break label493;
            }
          }
          for (paramInt2 = paramInt1;; paramInt2 = paramInt1 + this.boR)
          {
            paramInt1 = getMeasuredWidth();
            paramInt3 = this.boM;
            this.d.layout(0, paramInt2 + 0, paramInt1, paramInt3 + paramInt2);
            if (this.c == null) {
              break;
            }
            this.c.layout(0, 0, 0, 0);
            break;
          }
        }
        this.eW.layout(0, 0, 0, 0);
        return;
        label522:
        paramInt1 = paramInt3;
      }
      paramInt1 = paramInt4;
      paramInt3 = paramInt2;
    }
  }
  
  protected void dW(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    paramInt1 = this.marginTop;
    paramInt2 = paramInt1;
    if (this.mZ != null)
    {
      paramInt2 = paramInt1;
      if (this.mZ.getVisibility() != 8)
      {
        this.mZ.measure(View.MeasureSpec.makeMeasureSpec(this.boN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.boO, 1073741824));
        paramInt2 = paramInt1 + this.boO + this.boR;
      }
    }
    if ((this.xY != null) && (this.xY.getVisibility() != 8)) {
      this.xY.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    if ((this.c != null) && (this.c.getVisibility() != 8))
    {
      paramInt2 = paramInt2 + this.boQ + this.boU;
      this.c.measure(View.MeasureSpec.makeMeasureSpec(this.boP, 1073741824), View.MeasureSpec.makeMeasureSpec(this.boQ, 1073741824));
      if (this.time.getVisibility() != 8) {
        this.time.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
      }
      if (this.a.getVisibility() != 8) {
        this.a.measure(View.MeasureSpec.makeMeasureSpec(this.boP, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
      }
      if (this.time.getVisibility() != 0)
      {
        paramInt1 = paramInt2;
        if (this.a.getVisibility() != 0) {}
      }
      else
      {
        paramInt1 = paramInt2 + this.time.getMeasuredHeight();
      }
    }
    for (;;)
    {
      if ((this.eW != null) && (this.eW.getVisibility() != 8)) {
        this.eW.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648));
      }
      setMeasuredDimension(i, paramInt1);
      return;
      paramInt1 = paramInt2;
      if (this.d != null)
      {
        paramInt1 = paramInt2;
        if (this.d.getVisibility() != 8)
        {
          this.d.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(this.boM, 1073741824));
          paramInt1 = paramInt2 + this.boM;
        }
      }
    }
  }
  
  public LinearLayout h()
  {
    if (this.eW == null)
    {
      this.eW = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131561838, this, false));
      addView(this.eW);
    }
    return this.eW;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    auvk.traceBegin("VideoListLayout.onLayout");
    try
    {
      b(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (Exception localException)
    {
      throw new Error("do you know ,this is an error:" + localException);
    }
    finally
    {
      auvk.traceEnd();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    auvk.traceBegin("VideoListLayout.onMeasure");
    try
    {
      dW(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      throw new Error("do you know ,this is an error:" + localException);
    }
    finally
    {
      auvk.traceEnd();
    }
  }
  
  public void setAddGroupGuide(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (!paramBoolean)
    {
      if (this.eW != null) {
        this.eW.setVisibility(8);
      }
      return;
    }
    if (this.eW == null)
    {
      this.eW = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131561838, this, false));
      addView(this.eW);
    }
    this.eW.setVisibility(0);
    this.eW.setOnClickListener(paramOnClickListener);
  }
  
  public void setFailedTxt(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (!paramBoolean)
    {
      this.xY.setVisibility(8);
      this.mZ.setVisibility(8);
      return;
    }
    this.mZ.setVisibility(0);
    this.xY.setVisibility(0);
    this.xY.setOnClickListener(paramOnClickListener);
  }
  
  public void setHorizontalViewHeight(int paramInt)
  {
    this.boM = paramInt;
  }
  
  public void setMarginTop(int paramInt)
  {
    this.marginTop = paramInt;
  }
  
  public void setSingleVideoSize(int paramInt1, int paramInt2)
  {
    this.boP = paramInt1;
    this.boQ = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout
 * JD-Core Version:    0.7.0.1
 */