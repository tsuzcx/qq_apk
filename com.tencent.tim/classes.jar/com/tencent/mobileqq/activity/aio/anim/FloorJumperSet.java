package com.tencent.mobileqq.activity.aio.anim;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MainService;
import wno;
import wnq;

@TargetApi(11)
public class FloorJumperSet
  extends AIOAnimationConatiner.a
{
  @SuppressLint({"NewApi"})
  public static final long FRAME_DELAY;
  public static final int MAX_COUNT;
  Animator a;
  ArrayList<wno> qk = new ArrayList(MAX_COUNT);
  private long uS;
  
  static
  {
    long l;
    if (VersionUtils.isHoneycomb())
    {
      l = ValueAnimator.getFrameDelay();
      FRAME_DELAY = l;
      if (!VersionUtils.isHoneycomb()) {
        break label35;
      }
    }
    label35:
    for (int i = 16;; i = 1)
    {
      MAX_COUNT = i;
      return;
      l = 16L;
      break;
    }
  }
  
  public FloorJumperSet(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  protected void Cp(int paramInt)
  {
    Iterator localIterator = this.qk.iterator();
    while (localIterator.hasNext())
    {
      wno localwno = (wno)localIterator.next();
      localwno.y += paramInt;
      localwno.bPF += paramInt;
    }
    this.c.offsetChildrenTopAndBottom(paramInt);
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.qk.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (((wno)localIterator.next()).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) {
        bool = true;
      }
      for (;;)
      {
        break;
        localIterator.remove();
      }
    }
    if (!bool)
    {
      stop();
      bZL();
      return bool;
    }
    this.c.invalidate();
    return bool;
  }
  
  protected boolean c(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloorJumperSet", 2, "[start], args.len:" + paramVarArgs.length);
    }
    if ((paramVarArgs != null) && (paramVarArgs.length >= 3) && (((Integer)paramVarArgs[2]).intValue() == 1) && (this.c.a != null)) {
      this.c.a.bZP();
    }
    if (this.qk.size() < MAX_COUNT)
    {
      int i;
      if (MainService.sPwdPacketTime != 0L)
      {
        long l = System.currentTimeMillis() - MainService.sPwdPacketTime;
        if ((l < 60000L) && (l > 0L)) {
          if (this.qk.size() <= MAX_COUNT / 3) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          wno localwno = new wno(this.priority, this.c, this.l);
          if ((paramVarArgs != null) && (paramVarArgs.length >= 3)) {
            localwno.businessId = ((Integer)paramVarArgs[2]).intValue();
          }
          this.qk.add(localwno);
          if (paramVarArgs != null) {
            localwno.c(paramVarArgs);
          }
        }
        if (this.a == null)
        {
          this.a = new Animator(null);
          if (this.uS == 0L) {
            this.l.postDelayed(this.a, FRAME_DELAY);
          }
        }
        return true;
        i = 0;
        continue;
        MainService.sPwdPacketTime = 0L;
        i = 1;
      }
    }
    return false;
  }
  
  protected boolean gp(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected void resume()
  {
    this.uS = 0L;
    Iterator localIterator = this.qk.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((wno)localIterator.next()).as(false)) {
        i = 1;
      }
      for (;;)
      {
        break;
        localIterator.remove();
      }
    }
    if ((i != 0) && (this.a != null))
    {
      this.l.post(this.a);
      return;
    }
    bZL();
  }
  
  protected void stop()
  {
    if (this.a != null)
    {
      this.l.removeCallbacks(this.a);
      this.a = null;
    }
  }
  
  class Animator
    implements Runnable
  {
    private Animator() {}
    
    public void run()
    {
      Iterator localIterator = FloorJumperSet.this.qk.iterator();
      long l1 = -1L;
      if (localIterator.hasNext())
      {
        Object localObject = (wno)localIterator.next();
        long l2 = ((wno)localObject).en();
        if (l2 >= 0L)
        {
          if (l1 < 0L) {}
          for (l1 = l2;; l1 = Math.min(l1, l2)) {
            break;
          }
        }
        localIterator.remove();
        if (QLog.isColorLevel()) {
          QLog.d("FloorJumperSet", 2, "removed businessId:" + ((wno)localObject).businessId);
        }
        if (((wno)localObject).businessId == 1)
        {
          localObject = FloorJumperSet.this.qk.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (((wno)((Iterator)localObject).next()).businessId != 1);
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (FloorJumperSet.this.c.a != null)) {
          FloorJumperSet.this.c.a.bZQ();
        }
        break;
        if (l1 >= 0L)
        {
          if (FloorJumperSet.a(FloorJumperSet.this) == 0L) {
            FloorJumperSet.this.l.postDelayed(this, l1);
          }
          FloorJumperSet.this.c.invalidate();
        }
        do
        {
          return;
          FloorJumperSet.this.bZL();
          FloorJumperSet.this.c.invalidate();
        } while (FloorJumperSet.this.c.a == null);
        FloorJumperSet.this.c.a.bZQ();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumperSet
 * JD-Core Version:    0.7.0.1
 */