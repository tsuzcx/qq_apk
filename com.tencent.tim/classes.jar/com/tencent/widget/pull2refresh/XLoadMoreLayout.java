package com.tencent.widget.pull2refresh;

import acfp;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import auws;
import ppf;

public class XLoadMoreLayout
  extends FrameLayout
  implements auws
{
  protected View LD;
  protected String aBR;
  protected String aBS;
  protected String aBT;
  protected String aBU;
  protected String aBV;
  protected ProgressBar mProgressBar;
  protected int mState = -1;
  protected TextView mTextView;
  
  public XLoadMoreLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public XLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public XLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void acY()
  {
    this.aBR = acfp.m(2131716989);
    this.aBT = acfp.m(2131716990);
    this.aBU = acfp.m(2131716991);
    this.aBS = ppf.getString(2131701937);
    this.aBV = acfp.m(2131716992);
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
      this.LD.setVisibility(0);
      continue;
      this.mProgressBar.setVisibility(0);
      this.mTextView.setText(this.aBT);
      this.LD.setVisibility(0);
      continue;
      this.LD.setVisibility(8);
      continue;
      this.mProgressBar.setVisibility(0);
      this.mTextView.setText(this.aBS);
      this.LD.setVisibility(0);
      continue;
      this.LD.setVisibility(8);
      continue;
      this.mProgressBar.setVisibility(8);
      this.mTextView.setText(this.aBV);
      this.LD.setVisibility(0);
    }
  }
  
  private void init()
  {
    acY();
    initView();
  }
  
  private void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131560564, this, true);
    this.LD = findViewById(2131373841);
    this.mProgressBar = ((ProgressBar)this.LD.findViewById(2131373845));
    this.mTextView = ((TextView)this.LD.findViewById(2131373846));
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
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.LD.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XLoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */