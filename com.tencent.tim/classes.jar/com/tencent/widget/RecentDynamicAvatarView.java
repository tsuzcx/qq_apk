package com.tencent.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import aqcu;
import autv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RecentDynamicAvatarView
  extends DynamicAvatarView
  implements autv
{
  private static boolean dkT = false;
  protected float CQ = -1.0F;
  protected float CR = -1.0F;
  protected float CS;
  protected Paint cV;
  protected Rect dc;
  protected boolean dkr;
  protected Bitmap gX;
  protected Paint mMaskPaint;
  protected long mTroopCreditLevel = 5L;
  protected boolean oO;
  
  static
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("isShow_setting", 4);
    if (localSharedPreferences != null) {
      dkT = localSharedPreferences.getBoolean("isShow", false);
    }
  }
  
  public RecentDynamicAvatarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecentDynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecentDynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected static Bitmap f(long paramLong)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = null;
    long l = System.currentTimeMillis();
    int i = -1;
    Object localObject = "";
    if (paramLong == 1L)
    {
      i = 2130851448;
      localObject = "StatusIcon_TroopPermanentBlockStatusBigIconKey";
      if (i >= 0) {
        break label58;
      }
      localObject = localBitmap1;
    }
    label58:
    do
    {
      return localObject;
      if (paramLong != 2L) {
        break;
      }
      i = 2130851450;
      localObject = "StatusIcon_TroopTmpBlockStatusBigIcon";
      break;
      if (BaseApplicationImpl.sImageCache != null) {
        localBitmap2 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject);
      }
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        localBitmap2 = aqcu.f(BaseApplicationImpl.getApplication().getResources(), i);
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put(localObject, localBitmap2);
            localBitmap1 = localBitmap2;
          }
        }
      }
      localObject = localBitmap1;
    } while (!QLog.isColorLevel());
    QLog.i("FixSizeImageView", 2, "getTroopCreditStatusIcon:" + (System.currentTimeMillis() - l));
    return localBitmap1;
  }
  
  public static void setNeedRequestLayout(boolean paramBoolean)
  {
    dkT = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i;
    int j;
    if (this.oO)
    {
      if ((this.CQ == -1.0F) || (this.CR == -1.0F))
      {
        i = getWidth() - getPaddingLeft() - getPaddingRight();
        this.CQ = (getPaddingLeft() + i * 0.5F);
        j = getHeight() - getPaddingTop() - getPaddingBottom();
        this.CR = (getPaddingTop() + j * 0.5F);
        this.CS = (Math.max(i, j) / 2);
      }
      if (this.mMaskPaint == null)
      {
        this.mMaskPaint = new Paint();
        this.mMaskPaint.setAntiAlias(true);
        this.mMaskPaint.setColor(Color.parseColor("#B2000000"));
      }
      paramCanvas.drawCircle(this.CQ, this.CR, this.CS, this.mMaskPaint);
    }
    if (this.dkr)
    {
      if (this.cV == null)
      {
        this.cV = new Paint();
        this.cV.setAntiAlias(true);
        this.cV.setFilterBitmap(true);
      }
      if (this.gX != null)
      {
        if (this.dc == null)
        {
          i = getWidth() - getPaddingRight();
          j = getHeight() - getPaddingBottom();
          this.dc = new Rect(i - this.gX.getWidth(), j - this.gX.getHeight(), i, j);
        }
        paramCanvas.drawBitmap(this.gX, null, this.dc, this.cV);
      }
    }
  }
  
  public void nx(long paramLong)
  {
    if (this.mTroopCreditLevel == paramLong) {
      return;
    }
    this.mTroopCreditLevel = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FixSizeImageView", 2, "showTroopCreditStatus:" + paramLong);
    }
    if ((paramLong == 2L) || (paramLong == 1L))
    {
      this.oO = true;
      this.dkr = true;
    }
    for (this.gX = f(paramLong);; this.gX = null)
    {
      invalidate();
      return;
      this.oO = false;
      this.dkr = false;
    }
  }
  
  public void requestLayout()
  {
    if (dkT) {
      super.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.RecentDynamicAvatarView
 * JD-Core Version:    0.7.0.1
 */