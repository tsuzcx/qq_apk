package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.b;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igd;
import ijn;
import ilg;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jhd;

public abstract class ZimuView
  extends RelativeLayout
{
  protected ilg a;
  protected final List<jhd> fj = new ArrayList();
  protected float hY;
  protected VideoAppInterface mApp;
  private Rect mDstRect;
  protected long mLastRenderTime;
  private Paint mPaint;
  protected int mScreenHeight;
  protected int mScreenWidth;
  private Rect mSrcRect;
  protected Typeface mTypeface;
  protected long px;
  
  public ZimuView(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mApp = paramVideoAppInterface;
    this.px = (System.currentTimeMillis() - 100L);
    this.mPaint = new Paint(2);
    this.mSrcRect = new Rect();
    this.mDstRect = new Rect();
    paramVideoAppInterface = (WindowManager)paramContext.getSystemService("window");
    this.mScreenWidth = paramVideoAppInterface.getDefaultDisplay().getWidth();
    this.mScreenHeight = paramVideoAppInterface.getDefaultDisplay().getHeight();
    paramContext = new DisplayMetrics();
    paramVideoAppInterface.getDefaultDisplay().getMetrics(paramContext);
    this.hY = paramContext.density;
    setId(2131374269);
    this.a = ((ilg)this.mApp.a(0));
    paramVideoAppInterface = getID();
    this.a.d(paramLong, paramVideoAppInterface);
  }
  
  private long w(long paramLong)
  {
    long l1 = 0L;
    long l2 = l1;
    if (this.mLastRenderTime != 0L)
    {
      l2 = paramLong - this.mLastRenderTime;
      if (l2 <= 500L) {
        break label80;
      }
    }
    for (;;)
    {
      igd.aJ("ZimuView", " Render Interval: " + l1 + "|" + (paramLong - this.mLastRenderTime));
      l2 = l1;
      this.mLastRenderTime = paramLong;
      return l2;
      label80:
      l1 = l2;
    }
  }
  
  protected abstract List<jhd> a(ijn paramijn, boolean paramBoolean);
  
  protected void a(ijn paramijn, boolean paramBoolean)
  {
    setContentDescription(paramijn.l);
    Iterator localIterator = this.fj.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      jhd localjhd = (jhd)localIterator.next();
      j = i;
      if (!localjhd.a.isEnd())
      {
        j = i;
        if (localjhd.a.uin.equals(paramijn.uin))
        {
          j = 1;
          localjhd.a(paramijn);
        }
      }
    }
    if (i == 0)
    {
      paramijn = a(paramijn, paramBoolean);
      if (paramijn != null) {
        this.fj.addAll(paramijn);
      }
    }
    requestRender();
  }
  
  protected void a(jhd paramjhd) {}
  
  protected void anO()
  {
    String str;
    Object localObject;
    if ((this.mTypeface == null) && (this.a != null))
    {
      str = getID();
      localObject = (ZimuItem)this.a.a(str);
      if (localObject != null)
      {
        localObject = this.a.b((EffectConfigBase.b)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new File((String)localObject + "font.ttf");
          if (!((File)localObject).exists()) {
            break label135;
          }
        }
      }
    }
    label135:
    while (!AudioHelper.aCz()) {
      try
      {
        this.mTypeface = Typeface.createFromFile((File)localObject);
        return;
      }
      catch (Exception localException)
      {
        while (!AudioHelper.aCz()) {}
        QLog.w("ZimuView", 1, "createTypeface, Exception, id[" + str + "]", localException);
        return;
      }
    }
    QLog.w("ZimuView", 1, "createTypeface, 不存在, file[" + localException.getAbsolutePath() + "], id[" + str + "]");
  }
  
  abstract void awr();
  
  void aws()
  {
    String str1 = getContext().getResources().getString(mz());
    String str2 = getContext().getResources().getString(2131697677);
    a(new ijn(this.mApp.getAccount(), str1, str2, 2), true);
  }
  
  void awt()
  {
    Iterator localIterator = this.fj.iterator();
    while (localIterator.hasNext()) {
      ((jhd)localIterator.next()).setRecycle(false);
    }
  }
  
  public void b(ijn paramijn)
  {
    if ((paramijn == null) || (TextUtils.isEmpty(paramijn.l)) || (TextUtils.isEmpty(paramijn.uin)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramijn == null) {}
      for (paramijn = null;; paramijn = paramijn.toString())
      {
        igd.aL("ZimuView", paramijn);
        return;
      }
    }
    igd.aL("ZimuView", "updateText :" + paramijn.toString());
    if (!this.a.tP())
    {
      awt();
      this.a.X("updateText2", true);
    }
    a(paramijn, false);
  }
  
  protected void b(jhd paramjhd)
  {
    paramjhd.recycle();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    long l1 = System.currentTimeMillis();
    long l2 = w(l1);
    Iterator localIterator = this.fj.iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      jhd localjhd = (jhd)localIterator.next();
      localjhd.x(l2);
      if (!localjhd.isValidate())
      {
        if (localjhd.isRecycle())
        {
          igd.aJ("ZimuView", "recycle barrage:" + localjhd);
          localjhd.recycle();
          b(localjhd);
        }
      }
      else
      {
        boolean bool2 = true;
        bool1 = bool2;
        if (!localjhd.isVisible()) {
          continue;
        }
        Bitmap localBitmap = localjhd.I();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          paramCanvas.save();
          int i = localjhd.getCurrentX();
          int j = localjhd.mu();
          int k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          paramCanvas.clipRect(i, j, i + k, j + m);
          paramCanvas.translate(i, j);
          this.mSrcRect.set(0, 0, k, m);
          this.mDstRect.set(0, 0, k, m);
          paramCanvas.drawBitmap(localBitmap, this.mSrcRect, this.mDstRect, this.mPaint);
          paramCanvas.restore();
        }
        igd.aJ("ZimuView", "onDraw: " + localjhd.toString());
        bool1 = bool2;
        continue;
      }
      igd.aJ("ZimuView", "remove barrage:" + localjhd);
      localIterator.remove();
      a(localjhd);
      localjhd.release();
    }
    l2 = System.currentTimeMillis();
    igd.aJ("ZimuView", "onDraw needRefresh: " + bool1 + "|" + (l2 - l1));
    if (bool1) {
      awr();
    }
  }
  
  public abstract String getID();
  
  public abstract int getViewHeight();
  
  public void init()
  {
    if (!this.a.tP()) {
      aws();
    }
  }
  
  public void kO(boolean paramBoolean)
  {
    if (paramBoolean) {
      recycle();
    }
  }
  
  protected int mz()
  {
    return 2131697676;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeAllView();
    this.mTypeface = null;
    this.mApp.kI(0);
  }
  
  public void recycle() {}
  
  void removeAllView()
  {
    Iterator localIterator = this.fj.iterator();
    while (localIterator.hasNext())
    {
      jhd localjhd = (jhd)localIterator.next();
      localIterator.remove();
      localjhd.release();
    }
  }
  
  public void requestRender()
  {
    super.invalidate();
    long l = System.currentTimeMillis();
    igd.aJ("ZimuView", "Refresh interval:" + (l - this.px));
    this.px = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuView
 * JD-Core Version:    0.7.0.1
 */