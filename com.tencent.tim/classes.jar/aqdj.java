import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecodeTask.a;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class aqdj
  extends aqcr
  implements FaceDecodeTask.a
{
  aqdj.a a;
  RectF an = new RectF();
  FaceInfo c;
  boolean cbQ = false;
  boolean mCancelled;
  Paint mMaskPaint;
  
  protected aqdj(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, aqdj.a parama, boolean paramBoolean2)
  {
    super(paramDrawable1, paramDrawable2);
    long l1 = System.currentTimeMillis();
    setApp(paramAppInterface);
    this.a = parama;
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      paramInt3 = 1;
    }
    this.c = new FaceInfo(paramInt1, paramString, false, paramByte, aqdm.c((byte)paramInt3), paramBoolean1, paramInt2, paramBoolean2, paramInt4);
    if ((paramInt1 == 4) && (!apuh.ra(paramString))) {
      this.c.aRY = 113;
    }
    if ((this instanceof aqeh))
    {
      paramAppInterface = aG();
      if (paramAppInterface == null) {
        break label271;
      }
      this.mCurState = 1;
      this.fP = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramAppInterface);
      this.fP.setVisible(isVisible(), true);
      this.fP.setBounds(getBounds());
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.onLoadingStateChanged(-1, this.mCurState);
      }
      this.mMaskPaint = new Paint();
      this.mMaskPaint.setAntiAlias(true);
      this.mMaskPaint.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "time cost FaceDrawable:" + (l2 - l1));
      }
      return;
      paramAppInterface = d(true);
      break;
      label271:
      this.mCurState = 0;
      aBV();
    }
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    Drawable localDrawable = g(paramInt1, paramInt2);
    return a(paramAppInterface, paramInt1, paramString, paramInt2, localDrawable, localDrawable);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    int i = c(paramInt);
    Drawable localDrawable = g(paramInt, i);
    return a(paramAppInterface, paramInt, paramString, i, localDrawable, localDrawable);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    int i = c(paramInt1);
    Drawable localDrawable = g(paramInt1, i);
    return a(paramAppInterface, paramInt1, paramString, i, localDrawable, localDrawable, paramInt2);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, null);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt3)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, null);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, aqdj.a parama)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, parama, false);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, aqdj.a parama, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", type=" + paramInt1 + ",appIntf=" + paramAppInterface);
      }
    }
    do
    {
      return null;
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new aqdk(paramAppInterface, paramInt1, 200, paramString, (byte)0, paramInt2, 100, false, paramDrawable1, paramDrawable2, parama, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new aqeh(paramAppInterface, paramInt1, 200, paramString, (byte)1, paramInt2, false, paramDrawable1, paramDrawable2, parama, paramBoolean);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, aqdj.a parama)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, parama, false);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, aqdj.a parama, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt1 + ",appIntf=" + paramAppInterface + ",shape=" + paramInt2);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = g(32, paramInt2);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new aqdk(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, 100, true, localDrawable, localDrawable, parama, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new aqeh(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, parama, paramBoolean);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt1 + ",appIntf=" + paramAppInterface + ",shape=" + paramInt2);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = g(32, paramInt2);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new aqdk(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, 100, true, localDrawable, localDrawable, null, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new aqeh(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, null, paramBoolean);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    return a(paramAppInterface, paramInt, paramString, paramBoolean, false);
  }
  
  public static aqdj a(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt + ",appIntf=" + paramAppInterface);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = g(32, 1);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new aqdk(paramAppInterface, 32, paramInt, paramString, (byte)1, 1, 100, paramBoolean1, localDrawable, localDrawable, null, paramBoolean2);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new aqeh(paramAppInterface, 32, paramInt, paramString, (byte)1, 1, paramBoolean1, localDrawable, localDrawable, null, paramBoolean2);
  }
  
  public static aqdj a(AppInterface paramAppInterface, String paramString, byte paramByte)
  {
    Drawable localDrawable = g(1, paramByte);
    return a(paramAppInterface, 1, paramString, paramByte, localDrawable, localDrawable);
  }
  
  public static aqdj b(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, false);
  }
  
  public static aqdj b(AppInterface paramAppInterface, String paramString, byte paramByte)
  {
    Drawable localDrawable = g(11, paramByte);
    return a(paramAppInterface, 11, paramString, paramByte, localDrawable, localDrawable);
  }
  
  public static String bT(String paramString1, String paramString2)
  {
    return "https://q.qlogo.cn/qqapp/" + paramString2 + "/" + paramString1 + "/100";
  }
  
  private static byte c(int paramInt)
  {
    byte b = 1;
    if (paramInt == 115) {
      b = 2;
    }
    return b;
  }
  
  public static Drawable g(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {
      return aqhu.aV();
    }
    if ((paramInt1 == 113) || (paramInt1 == 101) || (paramInt1 == 1001)) {
      return aqhu.aX();
    }
    if (paramInt1 == 115) {
      return aqhu.c(true);
    }
    if (paramInt2 == 1) {
      return new ColorDrawable(Color.parseColor("#ebe9e9"));
    }
    return aqhu.at();
  }
  
  public void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((this.mCancelled) || (paramFaceInfo == null) || (this.c == null) || (!paramFaceInfo.equals(this.c))) {
      return;
    }
    edv();
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDrawable", 2, "onDecodeTaskCompleted.faceInfo=" + paramFaceInfo + ", avatrar=" + paramBitmap);
    }
    if ((this.mCancelled) || (paramFaceInfo == null) || (this.c == null) || (!paramFaceInfo.equals(this.c))) {
      return;
    }
    paramFaceInfo = null;
    int j = 0;
    if (paramBitmap != null) {
      paramFaceInfo = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramBitmap);
    }
    int i;
    if (paramFaceInfo != null)
    {
      this.fP = paramFaceInfo;
      i = 1;
      label107:
      if (i == 0) {
        break label247;
      }
      i = this.mCurState;
      if (this.fP == null) {
        break label249;
      }
      this.mCurState = 1;
      if (this.mAlpha != -1) {
        this.fP.setAlpha(this.mAlpha);
      }
      if (this.mColorFilter != null) {
        this.fP.setColorFilter(this.mColorFilter);
      }
      this.fP.setVisible(isVisible(), true);
      this.fP.setBounds(getBounds());
    }
    for (;;)
    {
      invalidateSelf();
      if ((i == this.mCurState) || (this.a == null)) {
        break;
      }
      this.a.onLoadingStateChanged(i, this.mCurState);
      return;
      i = j;
      if (this.fP != null) {
        break label107;
      }
      i = j;
      if (this.mCurState == 2) {
        break label107;
      }
      i = 1;
      break label107;
      label247:
      break;
      label249:
      this.mCurState = 2;
      if (this.fQ != null)
      {
        if (this.mAlpha != -1) {
          this.fQ.setAlpha(this.mAlpha);
        }
        if (this.mColorFilter != null) {
          this.fQ.setColorFilter(this.mColorFilter);
        }
        this.fQ.setVisible(isVisible(), true);
        this.fQ.setBounds(getBounds());
      }
    }
  }
  
  protected abstract boolean aBV();
  
  protected abstract Bitmap aG();
  
  public void cancel()
  {
    if (!this.mCancelled)
    {
      this.mCancelled = true;
      this.c = null;
      this.fQ = null;
      this.fP = null;
      this.mLoadingDrawable = null;
      setCallback(null);
      this.a = null;
      setApp(null);
    }
    super.cancel();
  }
  
  protected abstract Bitmap d(boolean paramBoolean);
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.cbQ) && (auvj.isNightMode()))
    {
      this.an.set(getBounds());
      if ((this.c != null) && (this.c.shape == 1))
      {
        super.draw(paramCanvas);
        paramCanvas.drawRoundRect(this.an, aqhu.dZk, aqhu.dZk, this.mMaskPaint);
        return;
      }
      super.draw(paramCanvas);
      paramCanvas.drawRoundRect(this.an, this.an.centerX(), this.an.centerY(), this.mMaskPaint);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected abstract void edv();
  
  protected abstract void setApp(AppInterface paramAppInterface);
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.cbQ = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void onLoadingStateChanged(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdj
 * JD-Core Version:    0.7.0.1
 */