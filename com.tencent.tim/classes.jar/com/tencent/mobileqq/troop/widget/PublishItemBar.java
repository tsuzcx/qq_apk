package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqho;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PublishItemBar
  extends LinearLayout
  implements View.OnClickListener
{
  private boolean cSC;
  private boolean cSD;
  private boolean cSE;
  private Handler dF;
  private Handler dG;
  private Handler mHandler;
  private Handler mVideoHandler;
  
  public PublishItemBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void Gs(int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt & 0x1) == 1)
    {
      bool1 = true;
      this.cSC = bool1;
      if ((paramInt & 0x2) != 2) {
        break label304;
      }
    }
    label304:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.cSD = bool1;
      bool1 = bool2;
      if ((paramInt & 0x4) == 4) {
        bool1 = true;
      }
      this.cSE = bool1;
      if (getChildCount() > 0) {
        removeAllViews();
      }
      ImageButton localImageButton;
      if (this.cSC)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(1));
        localImageButton.setImageResource(2130843363);
        localImageButton.setContentDescription(getResources().getString(2131699486));
        a(localImageButton);
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(5));
        localImageButton.setImageResource(2130843359);
        localImageButton.setContentDescription(getResources().getString(2131699481));
        a(localImageButton);
      }
      if (this.cSD)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(2));
        localImageButton.setImageResource(2130843354);
        localImageButton.setContentDescription(getResources().getString(2131699472));
        a(localImageButton);
      }
      if (this.cSE)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(4));
        localImageButton.setImageResource(2130843361);
        localImageButton.setContentDescription(getResources().getString(2131699483));
        a(localImageButton);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(ImageButton paramImageButton)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    paramImageButton.setPadding(0, 0, (int)aqho.convertDpToPixel(getContext(), 24.0F), 0);
    paramImageButton.setBackgroundResource(2130851770);
    paramImageButton.setLayoutParams(localLayoutParams);
    addView(paramImageButton);
  }
  
  public void kd(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramInt2 != 1)) {}
    int j;
    int i;
    do
    {
      return;
      j = getChildCount();
      i = 0;
    } while (i >= j);
    Object localObject2 = getChildAt(i);
    Object localObject1 = ((View)localObject2).getTag();
    if (((localObject1 instanceof Integer)) && ((localObject2 instanceof ImageButton)))
    {
      localObject2 = (ImageButton)localObject2;
      if (((Integer)localObject1).intValue() != paramInt1) {
        break label121;
      }
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      i += 1;
      break;
      ((ImageButton)localObject2).setSelected(false);
      continue;
      ((ImageButton)localObject2).setSelected(true);
      continue;
      label121:
      ((ImageButton)localObject2).setSelected(false);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && (this.mHandler != null)) {
      switch (((Integer)localObject).intValue())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.mHandler.sendEmptyMessage(2);
      if (this.dG != null)
      {
        this.dG.sendEmptyMessage(2);
        continue;
        this.mHandler.sendEmptyMessage(4);
        if (this.dF != null)
        {
          this.dF.sendEmptyMessage(4);
          continue;
          this.mHandler.sendEmptyMessage(1);
          continue;
          this.mHandler.sendEmptyMessage(5);
          continue;
          this.mHandler.sendEmptyMessage(3);
          if (this.mVideoHandler != null) {
            this.mVideoHandler.sendEmptyMessage(3);
          }
        }
      }
    }
  }
  
  public void setAudioCallback(Handler paramHandler)
  {
    this.dG = paramHandler;
  }
  
  public void setAudioEnable(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ImageButton))
      {
        if (!paramBoolean) {
          break label54;
        }
        ((ImageButton)localView).setImageResource(2130844587);
      }
      for (;;)
      {
        i += 1;
        break;
        label54:
        ((ImageButton)localView).setImageResource(2130844586);
      }
    }
  }
  
  public void setCallback(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public void setMusicCallback(Handler paramHandler)
  {
    this.dF = paramHandler;
  }
  
  public void setVideoCallback(Handler paramHandler)
  {
    this.mVideoHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemBar
 * JD-Core Version:    0.7.0.1
 */