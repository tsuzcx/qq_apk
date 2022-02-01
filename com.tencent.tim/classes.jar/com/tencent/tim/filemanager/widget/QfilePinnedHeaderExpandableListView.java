package com.tencent.tim.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import atpn;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedHeaderExpandableListView;

public class QfilePinnedHeaderExpandableListView
  extends PinnedHeaderExpandableListView
{
  private final String TAG = "QfilePinnedHeaderExpandableListView<FileAssistant>";
  private a b;
  private int cZt = -1;
  private int cZu = -1;
  private int cZv = -1;
  private int cZw = -1;
  private int cZx;
  private boolean cgg;
  private boolean cgh;
  private boolean cgi;
  private float mLastMotionX;
  private float mLastMotionY;
  private float mTouchSlop;
  
  public QfilePinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    setNeedCheckSpringback(true);
    ep(paramContext);
    setTouchSlop(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ep(paramContext);
    setTouchSlop(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ep(paramContext);
    setTouchSlop(paramContext);
  }
  
  private void ep(Context paramContext)
  {
    setSelector(2131167595);
    setGroupIndicator(paramContext.getResources().getDrawable(2130839740));
  }
  
  public atpn a(int paramInt1, int paramInt2)
  {
    int i = getFirstVisiblePosition();
    Object localObject = (ViewGroup)getChildAt(pointToPosition(paramInt1, paramInt2) - i);
    if (localObject == null) {
      return null;
    }
    paramInt2 = ((ViewGroup)localObject).getChildCount();
    if (this.cZx == 0) {
      return null;
    }
    if (paramInt1 > this.cZx * paramInt2) {
      paramInt1 = paramInt2 - 1;
    }
    for (;;)
    {
      localObject = ((ViewGroup)localObject).getChildAt(paramInt1);
      if (localObject != null) {
        break;
      }
      return null;
      paramInt1 /= this.cZx;
    }
    localObject = ((View)localObject).getTag();
    if ((localObject != null) && ((localObject instanceof atpn))) {
      return (atpn)localObject;
    }
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.cgh)
    {
      i = paramMotionEvent.getAction();
      if ((i != 2) || (!this.cgi)) {}
    }
    boolean bool;
    do
    {
      for (;;)
      {
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        switch (i & 0xFF)
        {
        default: 
        case 2: 
        case 0: 
          while (!this.cgi)
          {
            return super.onInterceptTouchEvent(paramMotionEvent);
            float f3 = Math.abs(f1 - this.mLastMotionX);
            if ((f3 > Math.abs(f2 - this.mLastMotionY) * 1.73F) && (f3 > this.mTouchSlop))
            {
              this.cgi = true;
              this.mLastMotionX = f1;
              this.mLastMotionY = f2;
              continue;
              this.mLastMotionX = f1;
              this.mLastMotionY = f2;
              atpn localatpn = a((int)f1, (int)f2);
              if (localatpn != null)
              {
                i = localatpn.cWI;
                this.cZv = i;
                this.cZt = i;
                i = localatpn.position;
                this.cZw = i;
                this.cZu = i;
              }
            }
          }
        }
      }
      bool = this.cgi;
      this.cgi = false;
      this.cZv = -1;
      this.cZt = -1;
      this.cZw = -1;
      this.cZu = -1;
      this.cgg = false;
    } while (!bool);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        if (!this.cgh) {
          continue;
        }
        i = paramMotionEvent.getAction();
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        switch (i & 0xFF)
        {
        }
      }
      catch (Exception paramMotionEvent)
      {
        float f1;
        float f2;
        float f3;
        atpn localatpn;
        if (!QLog.isColorLevel()) {
          break label506;
        }
        QLog.e("QfilePinnedHeaderExpandableListView<FileAssistant>", 2, " " + paramMotionEvent);
        return true;
        this.b.IV(true);
        continue;
        this.cZv = j;
        this.cZw = i;
        if (this.b == null) {
          continue;
        }
        this.b.Q(this.cZt, this.cZu, this.cZv, this.cZw);
        continue;
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        continue;
        boolean bool = this.cgi;
        if (this.b == null) {
          continue;
        }
        if (!this.cgi) {
          continue;
        }
        this.b.ah(this.cZv, this.cZw);
        this.b.IV(false);
        this.cZv = -1;
        this.cZt = -1;
        this.cZw = -1;
        this.cZu = -1;
        this.cgi = false;
        this.cgg = false;
        if (!bool) {
          continue;
        }
        return true;
        bool = super.onTouchEvent(paramMotionEvent);
        return bool;
        int i = -1;
        int j = -1;
        continue;
        continue;
      }
      if (!this.cgi) {
        continue;
      }
      return true;
      if (!this.cgi)
      {
        f3 = Math.abs(f1 - this.mLastMotionX);
        if ((f3 <= Math.abs(f2 - this.mLastMotionY) * 1.73F) || (f3 <= this.mTouchSlop)) {
          continue;
        }
        this.cgi = true;
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
      }
      if (this.cgi)
      {
        if ((!this.cgg) && (this.cZt != -1) && (this.cZu != -1))
        {
          if (this.b != null) {
            this.b.ag(this.cZt, this.cZu);
          }
          this.cgg = true;
        }
        localatpn = a((int)f1, (int)f2);
        if (localatpn == null) {
          continue;
        }
        j = localatpn.cWI;
        i = localatpn.position;
        if ((j != -1) && (i != -1))
        {
          if (this.cgg) {
            continue;
          }
          this.cZv = j;
          this.cZt = j;
          this.cZw = i;
          this.cZu = i;
          if (this.b != null) {
            this.b.ag(this.cZt, this.cZu);
          }
          this.cgg = true;
        }
      }
    }
    label506:
    return true;
  }
  
  public void setGridSize(int paramInt)
  {
    this.cZx = paramInt;
  }
  
  public void setOnIndexChangedListener(a parama)
  {
    this.b = parama;
  }
  
  public void setTouchSlop(Context paramContext)
  {
    this.mTouchSlop = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 15);
  }
  
  public void setWhetherImageTab(boolean paramBoolean)
  {
    this.cgh = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void IV(boolean paramBoolean);
    
    public abstract void Q(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void ag(int paramInt1, int paramInt2);
    
    public abstract void ah(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */