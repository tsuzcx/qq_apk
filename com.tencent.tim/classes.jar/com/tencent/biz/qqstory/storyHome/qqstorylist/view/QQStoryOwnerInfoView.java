package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import auvk;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import rpq;

public class QQStoryOwnerInfoView
  extends ViewGroup
{
  private CharSequence A = "";
  private CharSequence B = "";
  private int BT;
  StoryQIMBadgeView a;
  private int aOw;
  ImageView avatar;
  private int avatarWidth;
  StoryUserBadgeView b;
  private int boA;
  private int boB;
  private int boC;
  private int boD;
  private int boE;
  private int boF;
  private int boG;
  private int boH;
  private int boI;
  private int boJ;
  private int boz;
  Button cp;
  private int height = -1;
  private int marginRight;
  TextView name;
  private int titleMargin;
  private int width = -1;
  TextView xW;
  TextView xX;
  private CharSequence y = "";
  private CharSequence z = "";
  
  public QQStoryOwnerInfoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQStoryOwnerInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQStoryOwnerInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    brH();
    brG();
  }
  
  private void brG()
  {
    auvk.traceBegin("QQStoryInfoView.init");
    this.avatar = new ImageView(getContext());
    this.avatar.setId(2131375138);
    addView(this.avatar);
    this.a = new StoryQIMBadgeView(getContext());
    addView(this.a);
    this.name = ((TextView)LayoutInflater.from(getContext()).inflate(2131561850, this, false));
    addView(this.name);
    this.xW = ((TextView)LayoutInflater.from(getContext()).inflate(2131561849, this, false));
    addView(this.xW);
    this.b = new StoryUserBadgeView(getContext());
    addView(this.b);
    this.xX = ((TextView)LayoutInflater.from(getContext()).inflate(2131561849, this, false));
    addView(this.xX);
    this.cp = ((Button)LayoutInflater.from(getContext()).inflate(2131561848, this, false));
    this.cp.setId(2131362166);
    addView(this.cp);
    auvk.traceEnd();
  }
  
  private void brH()
  {
    this.avatarWidth = getContext().getResources().getDimensionPixelSize(2131298951);
    this.boz = this.avatarWidth;
    this.boB = getContext().getResources().getDimensionPixelSize(2131298956);
    this.boA = getContext().getResources().getDimensionPixelSize(2131298952);
    this.aOw = getContext().getResources().getDimensionPixelSize(2131298953);
    this.BT = this.aOw;
    this.titleMargin = getContext().getResources().getDimensionPixelSize(2131298955);
    this.boC = getContext().getResources().getDimensionPixelSize(2131298950);
    this.boD = this.boC;
    this.boF = getContext().getResources().getDimensionPixelSize(2131298949);
    this.boE = getContext().getResources().getDimensionPixelSize(2131298948);
    this.boJ = rpq.dip2px(getContext(), 2.0F);
    this.boI = rpq.dip2px(getContext(), 10.0F);
    this.marginRight = rpq.dip2px(getContext(), 15.0F);
    this.boH = getContext().getResources().getDimensionPixelSize(2131298954);
    this.boG = 0;
  }
  
  private void dW(int paramInt1, int paramInt2)
  {
    this.avatar.measure(View.MeasureSpec.makeMeasureSpec(this.avatarWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.boz, 1073741824));
    if ((this.a != null) && (this.a.getVisibility() != 8)) {
      this.a.measure(View.MeasureSpec.makeMeasureSpec(this.aOw, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BT, 1073741824));
    }
    int i = paramInt1 - this.boA - this.boB - this.avatarWidth - this.marginRight;
    paramInt1 = paramInt1 - this.boA - this.boB - this.avatarWidth - this.marginRight;
    TextPaint localTextPaint;
    int j;
    float f;
    if ((this.cp != null) && (this.cp.getVisibility() != 8))
    {
      localTextPaint = this.cp.getPaint();
      this.A = this.cp.getText();
      this.boG = ((int)localTextPaint.measureText(this.A, 0, this.A.length()) + this.cp.getPaddingLeft() + this.cp.getPaddingRight());
      this.cp.measure(View.MeasureSpec.makeMeasureSpec(this.boG, 1073741824), View.MeasureSpec.makeMeasureSpec(this.boH, 1073741824));
      i = i - this.boG - this.marginRight - this.boI;
      paramInt1 = paramInt1 - this.boG - this.marginRight - this.boI;
      j = i;
      if (this.b.getVisibility() != 8)
      {
        j = i - this.boC - this.boE;
        this.b.measure(View.MeasureSpec.makeMeasureSpec(this.boC, 1073741824), View.MeasureSpec.makeMeasureSpec(this.boD, 1073741824));
      }
      localTextPaint = this.name.getPaint();
      this.y = this.name.getText();
      f = localTextPaint.measureText(this.y, 0, this.y.length());
      if (f <= j) {
        break label564;
      }
      this.name.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    for (;;)
    {
      i = paramInt1;
      if (this.xX != null)
      {
        i = paramInt1;
        if (this.xX.getVisibility() != 8)
        {
          localTextPaint = this.xX.getPaint();
          this.B = this.xX.getText();
          j = (int)localTextPaint.measureText(this.B, 0, this.B.length());
          i = paramInt1 - j - this.boJ;
          this.xX.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
        }
      }
      if (this.xW.getVisibility() != 8)
      {
        localTextPaint = this.xW.getPaint();
        this.z = this.xW.getText();
        f = localTextPaint.measureText(this.z, 0, this.z.length());
        if (f <= i) {
          break label587;
        }
        this.xW.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
      }
      return;
      this.boG = 0;
      break;
      label564:
      this.name.measure(View.MeasureSpec.makeMeasureSpec((int)f, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    label587:
    this.xW.measure(View.MeasureSpec.makeMeasureSpec((int)f, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
  }
  
  public TextView A()
  {
    return this.xX;
  }
  
  @NonNull
  public Button a()
  {
    return this.cp;
  }
  
  @NonNull
  public StoryQIMBadgeView a()
  {
    return this.a;
  }
  
  @NonNull
  public StoryUserBadgeView a()
  {
    return this.b;
  }
  
  protected void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = this.boA;
    paramInt4 = (this.height - this.boz) / 2;
    paramInt1 = this.avatarWidth + paramInt3;
    paramInt2 = this.boz + paramInt4;
    this.avatar.layout(paramInt3, paramInt4, paramInt1, paramInt2);
    if ((this.a != null) && (this.a.getVisibility() != 8))
    {
      paramInt3 = this.aOw;
      paramInt4 = this.BT;
      this.a.layout(paramInt1 - paramInt3, paramInt2 - paramInt4, paramInt1, paramInt2);
    }
    paramInt2 = paramInt1 + this.boB;
    if (this.xW.getVisibility() == 8) {}
    for (paramInt1 = (this.height - this.name.getMeasuredHeight()) / 2;; paramInt1 = (this.height - this.name.getMeasuredHeight() - this.xW.getMeasuredHeight() - this.titleMargin) / 2)
    {
      paramInt4 = this.name.getMeasuredWidth() + paramInt2;
      paramInt3 = this.name.getMeasuredHeight() + paramInt1;
      this.name.layout(paramInt2, paramInt1 + 0, paramInt4, paramInt3);
      if ((this.b != null) && (this.b.getVisibility() != 8))
      {
        paramInt4 += this.boE;
        paramInt1 += this.boF;
        int i = this.b.getMeasuredWidth();
        int j = this.b.getMeasuredHeight();
        this.b.layout(paramInt4, paramInt1, i + paramInt4, j + paramInt1);
      }
      if (this.xW.getVisibility() != 8)
      {
        paramInt1 = this.titleMargin + paramInt3;
        paramInt3 = this.xW.getMeasuredWidth() + paramInt2;
        paramInt4 = this.xW.getMeasuredHeight();
        this.xW.layout(paramInt2, paramInt1, paramInt3, paramInt4 + paramInt1);
        if ((this.xX != null) && (this.xX.getVisibility() != 8))
        {
          paramInt2 = this.boJ + paramInt3;
          paramInt3 = this.xX.getMeasuredWidth();
          paramInt4 = this.xX.getMeasuredHeight();
          this.xX.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
        }
      }
      if ((this.cp != null) && (this.cp.getVisibility() != 8))
      {
        paramInt1 = this.width - this.marginRight;
        paramInt2 = this.boG;
        paramInt3 = (this.height - this.boH) / 2;
        paramInt4 = this.boH;
        this.cp.layout(paramInt1 - paramInt2, paramInt3, paramInt1, paramInt4 + paramInt3);
      }
      return;
    }
  }
  
  public ImageView m()
  {
    return this.avatar;
  }
  
  public TextView o()
  {
    return this.name;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    auvk.traceBegin("QQStoryInfoView.onLayout");
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
    auvk.traceBegin("QQStoryInfoView.onMeasure");
    try
    {
      this.width = View.MeasureSpec.getSize(paramInt1);
      this.height = View.MeasureSpec.getSize(paramInt2);
      dW(this.width, this.height);
      setMeasuredDimension(this.width, this.height);
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
  
  public void setAvatar(@NonNull Drawable paramDrawable)
  {
    this.avatar.setImageDrawable(paramDrawable);
  }
  
  public void setBadge(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageDrawable(paramDrawable);
  }
  
  public void setButtonTxt(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.A = "";
      this.cp.setVisibility(8);
      return;
    }
    this.A = paramString;
    this.cp.setVisibility(0);
    this.cp.setText(paramString);
  }
  
  public void setName(@NonNull String paramString)
  {
    this.y = paramString;
    this.name.setText(paramString);
    this.name.setVisibility(0);
  }
  
  public void setOwnerInfoOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.avatar.setOnClickListener(paramOnClickListener);
  }
  
  public void setQIMIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (this.a != null) {
        this.a.setVisibility(8);
      }
      return;
    }
    if (this.a == null)
    {
      this.a = new StoryQIMBadgeView(getContext());
      addView(this.a);
    }
    this.a.setVisibility(0);
    this.a.setImageDrawable(paramDrawable);
  }
  
  public void setSubTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.z = "";
      if (this.xW != null) {
        this.xW.setVisibility(8);
      }
      return;
    }
    this.z = paramString;
    this.xW.setText(paramString);
    this.xW.setVisibility(0);
  }
  
  public void setSubTitleSuffix(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.B = "";
      this.xX.setVisibility(8);
      return;
    }
    this.B = paramString;
    this.xX.setText(paramString);
    this.xX.setVisibility(0);
  }
  
  public TextView z()
  {
    return this.xW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.QQStoryOwnerInfoView
 * JD-Core Version:    0.7.0.1
 */