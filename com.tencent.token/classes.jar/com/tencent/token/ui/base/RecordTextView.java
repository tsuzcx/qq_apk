package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.token.global.g;

public class RecordTextView
  extends TextView
{
  private boolean a;
  private Paint b = new Paint();
  private int c;
  private a d;
  private int e;
  private boolean f;
  private int g = 20;
  private int h;
  private int i;
  private int j;
  private boolean k;
  private int l;
  private Handler m = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = RecordTextView.this;
      boolean bool;
      if (!RecordTextView.a(RecordTextView.this))
      {
        bool = true;
        RecordTextView.a(paramAnonymousMessage, bool);
        if (!RecordTextView.b(RecordTextView.this)) {
          break label81;
        }
        RecordTextView.c(RecordTextView.this);
        RecordTextView.this.invalidate();
        if (RecordTextView.d(RecordTextView.this) >= 10) {
          break label81;
        }
        RecordTextView.e(RecordTextView.this).sendEmptyMessageDelayed(0, 70L);
      }
      label81:
      do
      {
        return;
        bool = false;
        break;
        if (RecordTextView.f(RecordTextView.this) < RecordTextView.this.getWidth())
        {
          RecordTextView.a(RecordTextView.this, RecordTextView.f(RecordTextView.this) + RecordTextView.this.getWidth() / 10);
          RecordTextView.this.invalidate();
          RecordTextView.e(RecordTextView.this).sendEmptyMessageDelayed(0, 70L);
          return;
        }
      } while (RecordTextView.g(RecordTextView.this) == null);
      g.c("onAniEnd");
      RecordTextView.g(RecordTextView.this).a(RecordTextView.h(RecordTextView.this));
    }
  };
  
  public RecordTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b.setAntiAlias(true);
    this.h = paramContext.getResources().getColor(2131493009);
    this.i = paramContext.getResources().getColor(2131493010);
    this.j = paramContext.getResources().getColor(2131493011);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a)
    {
      this.b.setColor(this.h);
      paramCanvas.drawRect(0.0F, getTop(), this.c, getTop() + getHeight(), this.b);
      if (!this.k) {
        break label109;
      }
      this.b.setColor(this.i);
    }
    for (;;)
    {
      paramCanvas.drawRect(this.c, getTop(), this.c + this.g, getTop() + getHeight(), this.b);
      return;
      label109:
      this.b.setColor(this.j);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.RecordTextView
 * JD-Core Version:    0.7.0.1
 */