package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.mobileqq.widget.AutoBgFrameLayout;
import com.tencent.mobileqq.widget.RoundImageView;

public class SmallColorNoteItem
  extends LinearLayout
{
  private AutoBgFrameLayout a;
  private boolean bTh;
  private RoundImageView f;
  private RelativeLayout jN;
  private TextView kn;
  private View mRoot;
  private TextView mTitle;
  
  public SmallColorNoteItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SmallColorNoteItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public SmallColorNoteItem(Context paramContext, boolean paramBoolean, ViewGroup paramViewGroup)
  {
    super(paramContext);
    b(paramBoolean, paramViewGroup);
  }
  
  private void b(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    this.bTh = paramBoolean;
    if (paramBoolean) {}
    for (this.mRoot = LayoutInflater.from(getContext()).inflate(2131559015, paramViewGroup, false);; this.mRoot = LayoutInflater.from(getContext()).inflate(2131559014, paramViewGroup, false))
    {
      paramViewGroup = this.mRoot;
      this.jN = ((RelativeLayout)paramViewGroup.findViewById(2131365397));
      this.a = ((AutoBgFrameLayout)paramViewGroup.findViewById(2131372488));
      this.f = ((RoundImageView)paramViewGroup.findViewById(2131372489));
      this.mTitle = ((TextView)paramViewGroup.findViewById(2131372505));
      this.kn = ((TextView)paramViewGroup.findViewById(2131372503));
      return;
    }
  }
  
  public void cWn()
  {
    if (this.f != null) {
      this.f.setVisibility(4);
    }
  }
  
  public void cWo()
  {
    if (this.mTitle != null) {
      this.mTitle.setVisibility(4);
    }
    if (this.kn != null) {
      this.kn.setVisibility(4);
    }
  }
  
  public void cWp()
  {
    if (this.mTitle != null) {
      this.mTitle.setVisibility(0);
    }
    if (this.kn != null) {
      this.kn.setVisibility(0);
    }
  }
  
  public void hI(int paramInt1, int paramInt2)
  {
    Object localObject = new ViewGroup.LayoutParams(-1, paramInt1);
    this.mRoot.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((ViewGroup.LayoutParams)localObject).height = paramInt1;
    float f1 = 1.0F * paramInt1 / paramInt2;
    paramInt1 = (int)(aqcx.dip2px(getContext(), 6.0F) * f1);
    localObject = this.jN;
    int i;
    if (this.bTh)
    {
      paramInt2 = 0;
      if (!this.bTh) {
        break label291;
      }
      i = paramInt1;
      label73:
      ((RelativeLayout)localObject).setPadding(paramInt2, paramInt1, i, paramInt1);
      this.f.setmRadius((int)(aqcx.dip2px(getContext(), 3.0F) * f1), false);
      localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(aqcx.dip2px(getContext(), 20.0F) * f1));
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(aqcx.dip2px(getContext(), 20.0F) * f1));
      this.mTitle.setTextSize((int)(8.0F * f1));
      this.kn.setTextSize((int)(f1 * 6.0F));
      localObject = (RelativeLayout.LayoutParams)this.mTitle.getLayoutParams();
      paramInt1 = Math.max(aqcx.dip2px(getContext(), 2.0F), (int)(aqcx.dip2px(getContext(), 4.0F) * f1));
      if (!this.bTh) {
        break label297;
      }
      paramInt2 = 0;
      label224:
      ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
      if (!this.bTh) {
        break label302;
      }
      paramInt2 = paramInt1;
      label239:
      ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt2;
      localObject = (RelativeLayout.LayoutParams)this.kn.getLayoutParams();
      if (!this.bTh) {
        break label307;
      }
      paramInt2 = 0;
      label266:
      ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
      if (!this.bTh) {
        break label312;
      }
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
      return;
      paramInt2 = paramInt1;
      break;
      label291:
      i = 0;
      break label73;
      label297:
      paramInt2 = paramInt1;
      break label224;
      label302:
      paramInt2 = 0;
      break label239;
      label307:
      paramInt2 = paramInt1;
      break label266;
      label312:
      paramInt1 = 0;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAttachLeft(boolean paramBoolean)
  {
    this.bTh = paramBoolean;
  }
  
  public void setSubTitle(String paramString)
  {
    if (this.kn != null) {
      this.kn.setText(paramString);
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.mTitle != null) {
      this.mTitle.setText(paramString);
    }
  }
  
  public void showCover()
  {
    if (this.f != null) {
      this.f.setVisibility(0);
    }
  }
  
  public View y()
  {
    return this.mRoot;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.SmallColorNoteItem
 * JD-Core Version:    0.7.0.1
 */