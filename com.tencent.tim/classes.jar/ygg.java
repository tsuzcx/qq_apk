import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.qphone.base.util.QLog;

public class ygg
  implements Handler.Callback, GestureDetector.OnGestureListener
{
  private static boolean bmz;
  private long JT;
  private final ygg.a a;
  private String aUG = "chat_item_for_sticker40";
  private int bYR;
  private int bYS;
  private int bYT;
  private int bYU = -1;
  private boolean bmA;
  private boolean bmx;
  private boolean bmy;
  private final View mBaseView;
  private final GestureDetector mGestureDetector;
  private final Handler mHandler;
  private float qH;
  private float qI;
  
  public ygg(ygg.a parama, View paramView, boolean paramBoolean)
  {
    this.a = parama;
    this.mBaseView = paramView;
    this.mGestureDetector = new GestureDetector(paramView.getContext(), this);
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.bmA = paramBoolean;
  }
  
  private void DT(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "finishSendingAction: " + paramInt);
    }
    this.bYU = -1;
    this.a.fN(paramInt, this.bYT);
    this.mHandler.sendEmptyMessageDelayed(2, 3000L);
    this.bmy = true;
    bmz = false;
  }
  
  private boolean aa(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) && (this.bYU > -1) && (this.a.D(paramMotionEvent.getX(), paramMotionEvent.getY())))
    {
      DT(this.bYU);
      return true;
    }
    return false;
  }
  
  private boolean ab(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "handleActionUp: " + paramMotionEvent);
      }
      if (this.bYU <= -1) {
        break label80;
      }
      DT(this.bYU);
    }
    label80:
    for (bool1 = bool2;; bool1 = false)
    {
      this.a.cif();
      return bool1;
    }
  }
  
  private void cig()
  {
    int[] arrayOfInt = new int[2];
    this.mBaseView.getLocationInWindow(arrayOfInt);
    this.bYR = arrayOfInt[0];
    this.bYS = arrayOfInt[1];
  }
  
  public void cih()
  {
    if (this.bYU > -1) {
      DT(this.bYU);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
      } while (this.bYU != ((Integer)paramMessage.obj).intValue());
      if (this.bYT >= this.a.wG())
      {
        DT(this.bYU);
        return true;
      }
      this.bYT += 1;
      this.a.a(this.qH, this.qI, this.bYU, this.bYT);
      if (this.bmA) {
        HapticManager.a().h(this.aUG, 2);
      }
      for (;;)
      {
        if ((this.bYT > 2) && (!this.bmx))
        {
          this.a.Um();
          this.bmx = true;
        }
        if (this.bmy)
        {
          this.mHandler.removeMessages(2);
          this.bmy = false;
        }
        paramMessage = this.mHandler.obtainMessage(1, paramMessage.obj);
        this.mHandler.sendMessageDelayed(paramMessage, 80L);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("StickerBubbleGesture", 2, "handleMessage isTouchEffectSupport = " + this.bmA);
        }
      }
    } while (!this.bmy);
    this.a.cie();
    this.bmy = false;
    this.bmx = false;
    return true;
  }
  
  public boolean n(MotionEvent paramMotionEvent)
  {
    boolean bool2 = ab(paramMotionEvent);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = aa(paramMotionEvent);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onDown: " + paramMotionEvent);
    }
    this.a.I(paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onFling: " + paramFloat1 + " / " + paramFloat2);
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    int i = this.a.e(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onLongPress: " + paramMotionEvent + " on idx: " + i);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onScroll: " + paramFloat1 + " / " + paramFloat2);
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    int i = this.a.e(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onShowPress: " + paramMotionEvent + " on idx: " + i);
    }
    if ((i > -1) && (!bmz))
    {
      if (this.bYU > -1) {
        DT(this.bYU);
      }
      this.bYU = i;
      cig();
      this.qH = (paramMotionEvent.getX() + this.bYR);
      this.qI = (paramMotionEvent.getY() + this.bYS);
      this.a.a(this.qH, this.qI, i, 1);
      if (!this.bmA) {
        break label205;
      }
      HapticManager.a().h(this.aUG, 2);
    }
    for (;;)
    {
      this.bYT = 1;
      this.mHandler.removeMessages(1);
      bmz = true;
      paramMotionEvent = this.mHandler.obtainMessage(1, Integer.valueOf(i));
      this.mHandler.sendMessageDelayed(paramMotionEvent, 80L);
      return;
      label205:
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "onShowPress isTouchEffectSupport = " + this.bmA);
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    long l = SystemClock.uptimeMillis();
    int i;
    if (l - this.JT > 300L)
    {
      i = this.a.e(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "onSingleTapUp: " + paramMotionEvent + " on idx: " + i);
      }
      if (i > -1)
      {
        cig();
        this.a.a(paramMotionEvent.getX() + this.bYR, paramMotionEvent.getY() + this.bYS, i, 1);
        if (!this.bmA) {
          break label154;
        }
        HapticManager.a().h(this.aUG, 2);
      }
    }
    for (;;)
    {
      this.a.fN(i, 1);
      this.JT = l;
      return true;
      label154:
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "onSingleTapUp isTouchEffectSupport = " + this.bmA);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean D(float paramFloat1, float paramFloat2);
    
    public abstract void I(float paramFloat1, float paramFloat2);
    
    public abstract void Um();
    
    public abstract void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
    
    public abstract void cie();
    
    public abstract void cif();
    
    public abstract int e(float paramFloat1, float paramFloat2);
    
    public abstract void fN(int paramInt1, int paramInt2);
    
    public abstract int wG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygg
 * JD-Core Version:    0.7.0.1
 */