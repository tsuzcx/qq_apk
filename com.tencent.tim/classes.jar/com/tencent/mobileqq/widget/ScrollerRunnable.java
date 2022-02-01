package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewConfiguration;
import apat;
import aqgz;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import wki;

public class ScrollerRunnable
  implements Runnable
{
  private static long avT;
  private View JE;
  protected int TITLE_BAR_HEIGHT;
  @Nullable
  private apat a;
  private long avS = -1L;
  protected boolean beF = true;
  int cuw = 0;
  protected boolean dby;
  protected boolean dbz;
  protected int eib;
  protected int eic = -1;
  protected int eid;
  public int eie = -1;
  protected Runnable hZ;
  protected boolean isInit;
  protected ListView m;
  protected final int mExtraScroll;
  protected int mFrom;
  protected int mLastSeenPos;
  protected int mMode;
  protected int mScrollDuration;
  protected int mTargetPos;
  HashMap<Integer, Integer> pJ = new HashMap();
  public MqqHandler uiHandler;
  
  public ScrollerRunnable(ListView paramListView)
  {
    this.m = paramListView;
    this.mExtraScroll = ViewConfiguration.get(this.m.getContext()).getScaledFadingEdgeLength();
    if (aqgz.getSystemTotalMemory() / 1048576L > 512L) {}
    for (;;)
    {
      this.beF = bool;
      this.TITLE_BAR_HEIGHT = ((int)(this.m.getContext().getResources().getDimension(2131299627) + 0.5D));
      return;
      bool = false;
    }
  }
  
  private boolean aGF()
  {
    if (this.a != null) {
      return this.a.lX(this.eie);
    }
    return false;
  }
  
  public int MM()
  {
    return this.eie;
  }
  
  public void TQ(boolean paramBoolean)
  {
    this.dby = paramBoolean;
  }
  
  /* Error */
  public void YM(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 140
    //   10: iconst_2
    //   11: new 142	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   18: ldc 145
    //   20: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: iload_1
    //   34: ifne +28 -> 62
    //   37: aload_0
    //   38: getfield 63	com/tencent/mobileqq/widget/ScrollerRunnable:pJ	Ljava/util/HashMap;
    //   41: invokevirtual 163	java/util/HashMap:isEmpty	()Z
    //   44: ifne +18 -> 62
    //   47: aload_0
    //   48: getfield 63	com/tencent/mobileqq/widget/ScrollerRunnable:pJ	Ljava/util/HashMap;
    //   51: invokevirtual 166	java/util/HashMap:clear	()V
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 168	com/tencent/mobileqq/widget/ScrollerRunnable:eib	I
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: getfield 63	com/tencent/mobileqq/widget/ScrollerRunnable:pJ	Ljava/util/HashMap;
    //   66: iload_1
    //   67: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokevirtual 178	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   73: ifeq -14 -> 59
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 168	com/tencent/mobileqq/widget/ScrollerRunnable:eib	I
    //   81: aload_0
    //   82: getfield 63	com/tencent/mobileqq/widget/ScrollerRunnable:pJ	Ljava/util/HashMap;
    //   85: iload_1
    //   86: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokevirtual 182	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 170	java/lang/Integer
    //   95: invokevirtual 185	java/lang/Integer:intValue	()I
    //   98: isub
    //   99: putfield 168	com/tencent/mobileqq/widget/ScrollerRunnable:eib	I
    //   102: goto -43 -> 59
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	ScrollerRunnable
    //   0	110	1	paramInt	int
    //   105	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	105	finally
    //   37	59	105	finally
    //   62	102	105	finally
  }
  
  public void YN(int paramInt)
  {
    this.eid = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, int paramInt4)
  {
    this.eie = paramInt1;
    a(paramInt2, paramInt3, paramRunnable, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, MqqHandler paramMqqHandler, int paramInt4)
  {
    this.uiHandler = paramMqqHandler;
    a(paramInt1, paramInt2, paramInt3, paramRunnable, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable, int paramInt3)
  {
    stop();
    this.eic = paramInt2;
    this.mTargetPos = paramInt1;
    this.hZ = paramRunnable;
    if (QLog.isColorLevel()) {
      QLog.d("ScrollerRunnable", 2, new Object[] { "start, from:", Integer.valueOf(paramInt3), "aniPos:", Integer.valueOf(paramInt2), "mTargetPos:", Integer.valueOf(this.mTargetPos) });
    }
    this.mFrom = paramInt3;
    this.m.post(this);
  }
  
  public void ax(int paramInt, long paramLong)
  {
    this.eic = paramInt;
    this.m.postDelayed(new ScrollerRunnable.1(this), paramLong);
  }
  
  public void b(@Nullable apat paramapat)
  {
    this.a = paramapat;
  }
  
  public void eiP()
  {
    this.TITLE_BAR_HEIGHT = 0;
  }
  
  protected void eiQ()
  {
    if (this.hZ != null)
    {
      this.hZ.run();
      this.hZ = null;
    }
    this.m.post(new ScrollerRunnable.2(this));
  }
  
  public void eiR()
  {
    if (this.JE != null)
    {
      this.JE.setBackgroundColor(0);
      this.JE = null;
    }
  }
  
  protected void eiS()
  {
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - avT < 1000L) {}
    int j;
    do
    {
      return;
      if (this.eic != -1) {
        avT = l;
      }
      j = this.m.getFirstVisiblePosition() - this.m.getHeaderViewsCount();
    } while (this.eic < j);
    Object localObject;
    int k;
    int i;
    if ((this.eie == 5) && (this.avS > 0L))
    {
      localObject = this.m.getAdapter();
      if ((localObject instanceof wki))
      {
        localObject = ((wki)localObject).getList();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          k = ((List)localObject).size();
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < k)
      {
        if (((ChatMessage)((List)localObject).get(i)).uniseq == this.avS) {
          this.eic = i;
        }
      }
      else
      {
        if (this.eic == -1) {
          break;
        }
        localObject = this.m.getChildAt(this.eic - j);
        if (localObject == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ScrollerRunnable", 2, "FlushMessageItem:" + localObject.hashCode() + "," + ((View)localObject).getParent());
        }
        if (this.eid != 1) {
          break label268;
        }
        ((View)localObject).post(new ScrollerRunnable.3(this, (View)localObject));
        return;
      }
      i += 1;
    }
    label268:
    ((View)localObject).post(new ScrollerRunnable.4(this, (View)localObject));
  }
  
  /* Error */
  public void kA(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/tencent/mobileqq/widget/ScrollerRunnable:pJ	Ljava/util/HashMap;
    //   6: iload_1
    //   7: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokevirtual 178	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 168	com/tencent/mobileqq/widget/ScrollerRunnable:eib	I
    //   26: iload_2
    //   27: iadd
    //   28: putfield 168	com/tencent/mobileqq/widget/ScrollerRunnable:eib	I
    //   31: aload_0
    //   32: getfield 63	com/tencent/mobileqq/widget/ScrollerRunnable:pJ	Ljava/util/HashMap;
    //   35: iload_1
    //   36: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: iload_2
    //   40: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: invokevirtual 322	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq -32 -> 18
    //   53: ldc 140
    //   55: iconst_2
    //   56: new 142	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 324
    //   66: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload_1
    //   70: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc_w 326
    //   76: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload_2
    //   80: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: goto -71 -> 18
    //   92: astore 4
    //   94: aload_0
    //   95: monitorexit
    //   96: aload 4
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	ScrollerRunnable
    //   0	99	1	paramInt1	int
    //   0	99	2	paramInt2	int
    //   13	2	3	bool	boolean
    //   92	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	92	finally
    //   21	89	92	finally
  }
  
  public void mj(long paramLong)
  {
    this.avS = paramLong;
  }
  
  public void run()
  {
    int i;
    int j;
    if (!this.isInit)
    {
      this.isInit = true;
      this.cuw = 0;
      if (this.dby)
      {
        i = Math.max(0, this.m.getFirstVisiblePosition() - this.m.getHeaderViewsCount());
        if (!this.dby) {
          break label184;
        }
        j = this.m.getChildCount() + i - this.m.getFooterViewsCount() - 1;
        label71:
        if (this.mTargetPos > i) {
          break label199;
        }
        i = i - this.mTargetPos + 1;
        this.mMode = 2;
        label93:
        if (i <= 0) {
          break label236;
        }
        this.mScrollDuration = (1000 / i);
        label106:
        this.mLastSeenPos = -1;
      }
    }
    else
    {
      k = this.m.getHeight();
      if (!this.dby) {
        break label246;
      }
      j = Math.max(0, this.m.getFirstVisiblePosition() - this.m.getHeaderViewsCount());
      label146:
      switch (this.mMode)
      {
      }
    }
    label184:
    label199:
    label236:
    label246:
    View localView;
    label392:
    label412:
    label464:
    do
    {
      do
      {
        return;
        i = this.m.getFirstVisiblePosition();
        break;
        j = this.m.getChildCount() + i - 1;
        break label71;
        if (this.mTargetPos >= j)
        {
          i = this.mTargetPos - j + 1;
          this.mMode = 1;
          break label93;
        }
      } while (!aGF());
      eiS();
      return;
      this.mScrollDuration = 1000;
      break label106;
      j = this.m.getFirstVisiblePosition();
      break label146;
      if (this.dbz) {}
      int n;
      for (i = this.m.getChildCount() - 1 - this.m.getFooterViewsCount();; i = this.m.getChildCount() - 1)
      {
        n = j + i;
        if (i < 0) {
          break;
        }
        if (n != this.mLastSeenPos) {
          break label412;
        }
        if (this.cuw <= 10) {
          break label392;
        }
        this.m.setSelection(this.mTargetPos + 1);
        if (n != this.mTargetPos) {
          this.m.smoothScrollBy(-this.TITLE_BAR_HEIGHT, this.mScrollDuration);
        }
        eiQ();
        if (this.eib == 0) {
          break;
        }
        this.m.smoothScrollBy(this.eib, this.mScrollDuration);
        YM(0);
        return;
      }
      this.m.post(this);
      this.cuw += 1;
      return;
      localView = this.m.getChildAt(i);
      int i1 = localView.getHeight();
      int i2 = localView.getTop();
      int i3 = this.m.getPaddingBottom();
      if (n < this.m.getCount() - 1)
      {
        j = this.mExtraScroll;
        if (!this.beF) {
          break label592;
        }
        this.m.smoothScrollBy(j + (i1 - (k - i3 - i2)), this.mScrollDuration);
      }
      for (;;)
      {
        this.mLastSeenPos = n;
        if (n < this.mTargetPos) {
          this.m.post(this);
        }
        if (aGF()) {
          eiS();
        }
        if (n < this.mTargetPos) {
          break;
        }
        this.m.setSelection(this.mTargetPos + 1);
        if (n != this.mTargetPos) {
          this.m.smoothScrollBy(-this.TITLE_BAR_HEIGHT, this.mScrollDuration);
        }
        eiQ();
        return;
        j = this.m.getPaddingBottom();
        break label464;
        if (n < this.mTargetPos) {
          this.m.setSelection(i);
        }
      }
      if (j == this.mLastSeenPos)
      {
        if (this.cuw > 10)
        {
          this.m.setSelection(this.mTargetPos + 1);
          this.m.smoothScrollBy(-this.TITLE_BAR_HEIGHT, this.mScrollDuration);
          eiQ();
          return;
        }
        this.cuw += 1;
        this.m.post(this);
        return;
      }
      this.cuw = 0;
      if (j <= this.mTargetPos)
      {
        this.m.setSelection(this.mTargetPos + 1);
        this.m.smoothScrollBy(-this.TITLE_BAR_HEIGHT, this.mScrollDuration);
        eiQ();
        return;
      }
      localView = this.m.getChildAt(0);
    } while (localView == null);
    label592:
    int k = localView.getTop();
    if (j > this.mTargetPos)
    {
      i = this.mExtraScroll;
      label764:
      if (!this.beF) {
        break label824;
      }
      this.m.smoothScrollBy(k - i, this.mScrollDuration);
    }
    for (;;)
    {
      this.mLastSeenPos = j;
      if (j <= this.mTargetPos) {
        break;
      }
      this.m.post(this);
      return;
      i = this.m.getPaddingTop() + this.eib;
      break label764;
      label824:
      if (j > this.mTargetPos) {
        this.m.setSelection(0);
      }
    }
  }
  
  public void start(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0, null, paramInt2);
  }
  
  public void stop()
  {
    this.m.removeCallbacks(this);
    this.isInit = false;
    this.hZ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable
 * JD-Core Version:    0.7.0.1
 */