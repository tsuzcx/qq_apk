package com.tencent.biz.qqstory.view.widget;

import acfp;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import auws;
import ppf;

public class LoadMoreLayout
  extends FrameLayout
  implements auws
{
  protected String aBR;
  protected String aBS;
  protected String aBT;
  protected String aBU;
  protected String aBV;
  protected LinearLayout fc;
  protected Context mContext;
  protected ProgressBar mProgressBar;
  protected int mState = -1;
  protected TextView mTextView;
  
  public LoadMoreLayout(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    acY();
    initView();
  }
  
  public LoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    acY();
    initView();
  }
  
  public LoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    acY();
    initView();
  }
  
  private void acY()
  {
    this.aBR = acfp.m(2131707885);
    this.aBT = acfp.m(2131707887);
    this.aBU = acfp.m(2131707884);
    this.aBS = ppf.getString(2131701937);
    this.aBV = acfp.m(2131707886);
  }
  
  private boolean ao(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return true;
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4)) {
                break;
              }
            } while (paramInt2 != 5);
            return true;
            if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4)) {
              break;
            }
          } while (paramInt2 != 5);
          return true;
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 4)) {
            break;
          }
        } while (paramInt2 != 5);
        return true;
        if ((paramInt2 == 0) || (paramInt2 == 1)) {
          break;
        }
      } while (paramInt2 != 3);
      return true;
      if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {
        break;
      }
    } while (paramInt2 != 3);
    return true;
  }
  
  private boolean eX(int paramInt)
  {
    if (!ao(this.mState, paramInt)) {
      return false;
    }
    this.mState = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      this.mProgressBar.setVisibility(8);
      this.mTextView.setText(this.aBR);
      this.fc.setVisibility(0);
      continue;
      this.mProgressBar.setVisibility(0);
      this.mTextView.setText(this.aBT);
      this.fc.setVisibility(0);
      continue;
      this.fc.setVisibility(8);
      continue;
      this.mProgressBar.setVisibility(0);
      this.mTextView.setText(this.aBS);
      this.fc.setVisibility(0);
      continue;
      this.fc.setVisibility(8);
      continue;
      this.mProgressBar.setVisibility(8);
      this.mTextView.setText(this.aBV);
      this.fc.setVisibility(0);
    }
  }
  
  private void initView()
  {
    this.fc = ((LinearLayout)LayoutInflater.from(this.mContext).inflate(2131562048, null));
    this.mProgressBar = ((ProgressBar)this.fc.findViewById(2131373668));
    this.mTextView = ((TextView)this.fc.findViewById(2131379401));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    super.addView(this.fc, localLayoutParams);
    eX(0);
  }
  
  public boolean eO(int paramInt)
  {
    return ao(this.mState, paramInt);
  }
  
  public boolean eW(int paramInt)
  {
    return eX(paramInt);
  }
  
  public int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */