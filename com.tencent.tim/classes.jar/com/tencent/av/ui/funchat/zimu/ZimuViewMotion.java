package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import java.lang.ref.WeakReference;

public abstract class ZimuViewMotion
  extends ZimuView
{
  int azU = 92;
  final int azV = 4;
  Handler mHandler = new a(this);
  long py;
  
  public ZimuViewMotion(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
  }
  
  protected int L(int paramInt1, int paramInt2)
  {
    int j = getViewHeight();
    int i = (this.azU - paramInt2) / 2 + paramInt1;
    if (i < 0) {
      i = 0;
    }
    while (paramInt1 + paramInt2 <= j) {
      return i;
    }
    return j - paramInt2;
  }
  
  void awr()
  {
    requestRender();
  }
  
  public int getViewHeight()
  {
    return this.azU * 4;
  }
  
  public void init()
  {
    this.azU = ((int)(0.48F * this.hY * this.azU));
    super.init();
  }
  
  static final class a
    extends Handler
  {
    WeakReference<ZimuViewMotion> bN;
    
    a(ZimuViewMotion paramZimuViewMotion)
    {
      this.bN = new WeakReference(paramZimuViewMotion);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        paramMessage = (ZimuViewMotion)this.bN.get();
      } while (paramMessage == null);
      paramMessage.requestRender();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewMotion
 * JD-Core Version:    0.7.0.1
 */