package com.tencent.mobileqq.apollo.barrage;

import abjr;
import abjt;
import abjv;
import abjw;
import abjx;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import auru;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

public class BarrageView
  extends View
  implements abjw, Handler.Callback
{
  private long NI;
  private abjr jdField_a_of_type_Abjr;
  private abjx jdField_a_of_type_Abjx;
  private boolean bDu;
  private int cpr = 0;
  private auru e;
  
  public BarrageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BarrageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void cCv()
  {
    this.e.removeMessages(259);
    this.e.sendEmptyMessage(259);
  }
  
  private void init()
  {
    this.jdField_a_of_type_Abjr = new abjt();
    this.jdField_a_of_type_Abjx = new abjx();
    this.e = new auru(Looper.getMainLooper(), this);
  }
  
  public void DI(boolean paramBoolean)
  {
    auru localauru;
    if (this.jdField_a_of_type_Abjx.isDrawing())
    {
      localauru = this.e;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 0)
    {
      localauru.obtainMessage(258, i, 0).sendToTarget();
      return;
    }
  }
  
  public abjr a()
  {
    return this.jdField_a_of_type_Abjr;
  }
  
  public void af(List<abjv> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new PrebuildCacheTask(paramList, this));
  }
  
  public void cCw()
  {
    this.e.removeMessages(259);
    this.bDu = true;
  }
  
  public void destroy()
  {
    this.e.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Abjx.DH(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 256: 
      List localList = (List)paramMessage.obj;
      if (paramMessage.arg1 > 0) {
        this.jdField_a_of_type_Abjx.DH(false);
      }
      this.jdField_a_of_type_Abjx.ac(localList);
      this.cpr = 0;
      super.setVisibility(0);
      cCv();
      this.bDu = false;
      return false;
    case 257: 
      paramMessage = (abjv)paramMessage.obj;
      this.jdField_a_of_type_Abjx.a(paramMessage);
      this.cpr = 0;
      cCv();
      this.bDu = false;
      return false;
    case 258: 
      if (paramMessage.arg1 > 0) {
        this.cpr = 1;
      }
      for (;;)
      {
        this.NI = System.currentTimeMillis();
        cCv();
        this.bDu = false;
        return false;
        this.jdField_a_of_type_Abjx.DH(false);
        super.setVisibility(8);
      }
    }
    this.e.removeMessages(259);
    invalidate();
    this.bDu = false;
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f = 1.0F;
    System.currentTimeMillis();
    super.onDraw(paramCanvas);
    if (this.cpr == 1)
    {
      f = (float)(System.currentTimeMillis() - this.NI) / 500.0F;
      if (f < 1.0F) {
        f = 1.0F - f;
      }
    }
    else
    {
      if (!this.jdField_a_of_type_Abjx.a(paramCanvas, f)) {
        break label94;
      }
      if (!this.bDu) {
        super.invalidate();
      }
    }
    label94:
    do
    {
      return;
      this.cpr = 0;
      this.jdField_a_of_type_Abjx.DH(false);
      this.e.sendEmptyMessageDelayed(259, 20L);
      return;
      super.setVisibility(8);
    } while (!QLog.isColorLevel());
    QLog.d("BarrageView", 2, "BarrageView setVisibility(GONE)");
  }
  
  public int zA()
  {
    return super.getWidth();
  }
  
  public int zB()
  {
    return super.getHeight();
  }
  
  static class PrebuildCacheTask
    implements Runnable
  {
    private WeakReference<BarrageView> mViewRef;
    private List<abjv> wh;
    
    PrebuildCacheTask(List<abjv> paramList, BarrageView paramBarrageView)
    {
      this.mViewRef = new WeakReference(paramBarrageView);
      this.wh = paramList;
    }
    
    public void run()
    {
      long l = System.currentTimeMillis();
      if (this.mViewRef == null) {}
      do
      {
        BarrageView localBarrageView;
        do
        {
          return;
          localBarrageView = (BarrageView)this.mViewRef.get();
        } while ((localBarrageView == null) || (BarrageView.a(localBarrageView) == null));
        List localList = this.wh;
        if ((localList != null) && (!localList.isEmpty()))
        {
          int i = localList.size() - 1;
          while (i >= 0)
          {
            ((abjv)localList.get(i)).cCu();
            i -= 1;
          }
          BarrageView.a(localBarrageView).obtainMessage(256, 1, 0, localList).sendToTarget();
        }
      } while (!QLog.isColorLevel());
      QLog.d("BarrageView", 2, "BarrageView PreBuild use->" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageView
 * JD-Core Version:    0.7.0.1
 */