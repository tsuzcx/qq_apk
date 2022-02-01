package com.tencent.mobileqq.dating.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class InputBar
  extends LinearLayout
{
  private View BG;
  private a a;
  private ListView b;
  private boolean bXw;
  private int cQt;
  private int cQu;
  private int cQv;
  private int cQw;
  private int mBottom;
  private int mItemHeight;
  private int mLastTop;
  private int mPosition;
  
  public InputBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public InputBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mBottom == 0) {
      this.mBottom = paramInt4;
    }
    do
    {
      do
      {
        while (!this.bXw)
        {
          return;
          if ((paramInt4 == this.mBottom) && (this.a != null)) {
            this.a.cYx();
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.e("InputBar", 4, "inputBar onLayout top is: " + paramInt2 + "changed is: " + paramBoolean);
        }
      } while (paramInt2 <= 0);
      if (this.mLastTop <= 0)
      {
        this.mLastTop = paramInt2;
        this.cQw = paramInt2;
        return;
      }
      if ((paramInt2 != this.mLastTop) && (paramInt2 == this.cQw))
      {
        if (this.BG != null) {
          this.b.removeFooterView(this.BG);
        }
        this.mLastTop = paramInt2;
        return;
      }
    } while ((paramInt2 == this.mLastTop) || (paramInt2 == this.cQw));
    getHandler().post(new InputBar.1(this, paramInt2));
    this.mLastTop = paramInt2;
  }
  
  public void setmCallback(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cYx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.InputBar
 * JD-Core Version:    0.7.0.1
 */