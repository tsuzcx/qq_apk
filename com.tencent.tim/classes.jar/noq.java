import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class noq
  extends Drawable
  implements ReadInJoyUserInfoModule.a, Sizeable, URLDrawable.URLDrawableListener
{
  private static String TAG = "AggregateAvatarUrlDrawable";
  private RectF I;
  private RectF J;
  private Rect aA;
  private Rect az;
  private int baH = 1;
  private Bitmap cf;
  private Bitmap cg;
  private Bitmap ch;
  private volatile Bitmap ci;
  private Resources d;
  private URLDrawable k;
  private Paint mPaint;
  private final float mScale = 0.48F;
  private int mSize;
  private long mUin;
  
  public noq(Bitmap paramBitmap, int paramInt1, Resources paramResources, String paramString, int paramInt2)
  {
    a(paramBitmap, paramInt1, paramResources, paramInt2);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.mSize = paramInt1;
      this.d = paramResources;
      try
      {
        this.mUin = Long.parseLong(paramString);
        if (this.mUin <= 0L) {
          continue;
        }
        paramBitmap = ReadInJoyUserInfoModule.a(this.mUin, this);
        QLog.d(TAG, 1, "[AggregateAvatarUrlDrawable] load aggregate avatar from 0xb81 userinfo success, uin:" + this.mUin);
        if (paramBitmap == null) {
          continue;
        }
        oo(ReadInJoyUserInfoModule.a(paramBitmap));
        return;
      }
      catch (NumberFormatException paramBitmap)
      {
        for (;;)
        {
          QLog.d(TAG, 2, paramBitmap.getMessage());
        }
      }
    }
  }
  
  public noq(Bitmap paramBitmap, String paramString, int paramInt1, Resources paramResources, int paramInt2)
  {
    a(paramBitmap, paramInt1, paramResources, paramInt2);
    oo(paramString);
  }
  
  private void aZN()
  {
    QLog.d(TAG, 2, "initAggregateIcon mode : " + this.baH);
    if ((this.ci == null) || (this.cf == null))
    {
      QLog.d(TAG, 2, "has error !");
      return;
    }
    Bitmap localBitmap3;
    try
    {
      localBitmap3 = BitmapFactory.decodeResource(this.d, 2130845850);
      if (localBitmap3 == null)
      {
        QLog.e(TAG, 2, "initAggregateIcon: mask is null");
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e(TAG, 2, "initAggregateIcon: ", localOutOfMemoryError);
      return;
    }
    Bitmap localBitmap2;
    if (this.baH == 1) {
      localBitmap2 = this.cf;
    }
    for (Bitmap localBitmap1 = this.ci;; localBitmap1 = this.cf)
    {
      this.cg = aqeq.a(localBitmap2, localBitmap3, 0.0F, 1.0F);
      this.az = new Rect(0, 0, this.cg.getWidth(), this.cg.getHeight());
      this.I = new RectF(0.0F, 0.0F, this.mSize * 0.75F, this.mSize * 0.75F);
      this.ch = localBitmap1;
      this.aA = new Rect(0, 0, this.ch.getWidth(), this.ch.getHeight());
      this.J = new RectF(this.mSize * 0.52F, this.mSize * 0.52F, this.mSize, this.mSize);
      return;
      localBitmap2 = this.ci;
    }
  }
  
  private void oo(String paramString)
  {
    try
    {
      int i = this.mSize;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      float f2 = i;
      if (this.baH == 1) {}
      for (float f1 = 0.52F;; f1 = 0.48F)
      {
        f1 *= f2;
        localURLDrawableOptions.mRequestWidth = Math.round(f1);
        localURLDrawableOptions.mRequestHeight = Math.round(f1);
        this.k = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        this.k.setURLDrawableListener(this);
        this.k.setDecodeHandler(aqbn.b);
        this.k.startDownload();
        if ((this.k.getStatus() == 1) && (this.k.getCurrDrawable() != null))
        {
          this.ci = aqhu.g(this.k.getCurrDrawable());
          aZN();
        }
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.k = null;
      this.ci = null;
    }
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, Resources paramResources, int paramInt2)
  {
    this.cf = paramBitmap;
    this.mSize = paramInt1;
    this.d = paramResources;
    this.baH = paramInt2;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setFilterBitmap(true);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.ci != null)
    {
      if ((this.ch == null) || (this.cg == null)) {
        aZN();
      }
      if ((this.ch != null) && (this.cg != null))
      {
        paramCanvas.drawBitmap(this.cg, this.az, this.I, this.mPaint);
        paramCanvas.drawBitmap(this.ch, this.aA, this.J, this.mPaint);
        return;
      }
      paramCanvas.drawBitmap(this.cf, 0.0F, 0.0F, this.mPaint);
      return;
    }
    paramCanvas.drawBitmap(this.cf, 0.0F, 0.0F, this.mPaint);
  }
  
  public int getByteSize()
  {
    return Bitmap.createBitmap(this.mSize, this.mSize, Bitmap.Config.ARGB_8888).getByteCount();
  }
  
  public int getOpacity()
  {
    if (this.k != null) {
      return this.k.getOpacity();
    }
    return 0;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d(TAG, 2, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d(TAG, 2, "onLoadFailed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d(TAG, 2, "onLoadSuccessed");
    this.ci = aqhu.g(paramURLDrawable.getCurrDrawable());
    aZN();
    invalidateSelf();
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d(TAG, 2, "onLoadUserInfoFailed");
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((!TextUtils.equals(paramString, String.valueOf(this.mUin))) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    oo(ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    if (this.k != null) {
      this.k.setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    if (this.k != null) {
      this.k.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     noq
 * JD-Core Version:    0.7.0.1
 */