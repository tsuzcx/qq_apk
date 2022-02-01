package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class QQGamePubAccountFloatView
  extends RelativeLayout
  implements Handler.Callback
{
  private ImageView Av;
  private ImageView Aw;
  public boolean cio;
  public int dbj;
  private View.OnClickListener mListener;
  private Handler mUiHandler = new Handler(Looper.getMainLooper(), this);
  public int maxHeight;
  public int minHeight;
  private int offsetY = 3;
  private View pB;
  public boolean showButton;
  public int widthSize;
  
  public QQGamePubAccountFloatView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QQGamePubAccountFloatView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQGamePubAccountFloatView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.cio = true;
      this.showButton = true;
      invalidate();
      return false;
    }
    this.cio = true;
    this.showButton = false;
    invalidate();
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.cio) {
      requestLayout();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.widthSize == 0)
    {
      this.widthSize = View.MeasureSpec.getSize(paramInt1);
      this.minHeight = this.widthSize;
      this.maxHeight = ((int)(this.widthSize * 1.7D));
      this.dbj = this.minHeight;
    }
    if (this.cio)
    {
      if (!this.showButton) {
        break label116;
      }
      if (this.maxHeight < this.dbj) {
        break label100;
      }
      this.dbj += this.offsetY;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.dbj, View.MeasureSpec.getMode(paramInt2)));
      return;
      label100:
      this.pB.setVisibility(0);
      this.cio = false;
      continue;
      label116:
      if (this.dbj >= this.minHeight)
      {
        this.dbj -= this.offsetY;
      }
      else
      {
        this.pB.setVisibility(8);
        this.cio = false;
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mListener = paramOnClickListener;
    if (this.Av != null) {
      this.Av.setOnClickListener(paramOnClickListener);
    }
    if (this.Aw != null) {
      this.Aw.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGamePubAccountFloatView
 * JD-Core Version:    0.7.0.1
 */