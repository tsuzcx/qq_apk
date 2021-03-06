import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.IOException;
import mqq.util.WeakReference;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ajns
  extends Drawable
  implements Handler.Callback, URLDrawable.URLDrawableListener
{
  WeakReference<ajns.a> aO;
  int alpha = 255;
  String bRL = "";
  int bZm = 0;
  int direction = 0;
  int djT = 42;
  int djU = 102;
  URLDrawable e;
  Drawable eV;
  Drawable eW;
  Handler handler;
  
  public ajns(Context paramContext, int paramInt)
  {
    this.eV = paramContext.getResources().getDrawable(paramInt);
  }
  
  public ajns(Context paramContext, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    localColorDrawable.setBounds(0, 0, 0, this.djT);
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    this.e = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    int i = paramContext.getResources().getDisplayMetrics().densityDpi / 2;
    this.e.setTargetDensity(i);
    this.e.setURLDrawableListener(this);
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkIconProxyDrawable", 2, "MutualMarkIconProxyDrawable density : " + i);
    }
  }
  
  private Drawable aL()
  {
    if (this.eW != null) {
      return this.eW;
    }
    if (this.e != null) {
      return this.e;
    }
    if (this.eV != null) {
      return this.eV;
    }
    return null;
  }
  
  public void ME(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      dyy();
    }
    do
    {
      return;
      if (this.handler != null) {
        this.handler = new Handler(Looper.getMainLooper(), this);
      }
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.bRL)) && (!paramString.equals(this.bRL))) {
        dyz();
      }
      this.bRL = paramString;
    } while ((this.handler == null) || (this.handler.hasMessages(0)));
    this.handler.sendEmptyMessage(0);
  }
  
  public void applyTheme(@NonNull Resources.Theme paramTheme)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      aL().applyTheme(paramTheme);
    }
    super.applyTheme(paramTheme);
  }
  
  public boolean canApplyTheme()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      return aL().canApplyTheme();
    }
    return super.canApplyTheme();
  }
  
  public void clearColorFilter()
  {
    if (aL() != null) {
      aL().clearColorFilter();
    }
    super.clearColorFilter();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (aL() != null) {
      aL().draw(paramCanvas);
    }
  }
  
  public void dyy()
  {
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler.removeMessages(1);
    }
    setAlpha(this.djU);
  }
  
  public void dyz()
  {
    this.alpha = 255;
    this.direction = 0;
    this.bZm = 0;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler.removeMessages(1);
    }
    setAlpha(this.alpha);
  }
  
  public int getAlpha()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (aL() != null)) {
      return aL().getAlpha();
    }
    return super.getAlpha();
  }
  
  @Nullable
  public Drawable.Callback getCallback()
  {
    if (aL() != null)
    {
      Drawable.Callback localCallback = aL().getCallback();
      if (localCallback != null) {
        return localCallback;
      }
    }
    return super.getCallback();
  }
  
  public int getChangingConfigurations()
  {
    if (aL() != null) {
      return aL().getChangingConfigurations();
    }
    return super.getChangingConfigurations();
  }
  
  @Nullable
  public ColorFilter getColorFilter()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      return aL().getColorFilter();
    }
    return super.getColorFilter();
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    if (aL() != null) {
      return aL().getConstantState();
    }
    return super.getConstantState();
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    if (aL() != null) {
      return aL().getCurrent();
    }
    return super.getCurrent();
  }
  
  @NonNull
  public Rect getDirtyBounds()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      return aL().getDirtyBounds();
    }
    return super.getDirtyBounds();
  }
  
  public void getHotspotBounds(@NonNull Rect paramRect)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (aL() != null))
    {
      aL().getHotspotBounds(paramRect);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (aL() != null)
    {
      int i = aL().getIntrinsicHeight();
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkIconProxyDrawable", 2, "getIntrinsicHeight height : " + i + " limitHeight=" + this.djT);
      }
      return this.djT;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (aL() != null)
    {
      int j = aL().getIntrinsicWidth();
      int k = aL().getIntrinsicHeight();
      int i = j;
      if (k > 0)
      {
        i = j;
        if (j > 0) {
          i = j * this.djT / k;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkIconProxyDrawable", 2, "getIntrinsicWidth width : " + i);
      }
      return i;
    }
    return super.getIntrinsicWidth();
  }
  
  public int getLayoutDirection()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (aL() != null)) {
      return aL().getLayoutDirection();
    }
    return super.getLayoutDirection();
  }
  
  public int getMinimumHeight()
  {
    if (aL() != null)
    {
      int i = aL().getMinimumHeight();
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkIconProxyDrawable", 2, "getMinimumHeight height : " + i);
      }
      return i;
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (aL() != null)
    {
      int i = aL().getMinimumWidth();
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkIconProxyDrawable", 2, "getMinimumWidth width : " + i);
      }
      return i;
    }
    return super.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(@NonNull Outline paramOutline)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null))
    {
      aL().getOutline(paramOutline);
      return;
    }
    super.getOutline(paramOutline);
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    if (aL() != null) {
      return aL().getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  @NonNull
  public int[] getState()
  {
    if (aL() != null) {
      return aL().getState();
    }
    return super.getState();
  }
  
  @Nullable
  public Region getTransparentRegion()
  {
    if (aL() != null) {
      return aL().getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.handler == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.alpha <= 0)
      {
        this.direction = 0;
        label50:
        if (this.direction != 0) {
          break label170;
        }
        this.alpha += 5;
        if (this.alpha >= 255) {
          this.alpha = 255;
        }
      }
      for (;;)
      {
        setAlpha(this.alpha);
        invalidateSelf();
        if (this.alpha != 0) {
          break label195;
        }
        this.bZm += 1;
        if ((this.bZm < 3) || (this.alpha < this.djU)) {
          break label195;
        }
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessage(1);
        break;
        if (this.alpha < 255) {
          break label50;
        }
        this.direction = 1;
        break label50;
        label170:
        this.alpha -= 5;
        if (this.alpha <= 0) {
          this.alpha = 0;
        }
      }
      label195:
      if (this.handler.hasMessages(0)) {
        this.handler.removeMessages(0);
      }
      this.handler.sendEmptyMessageDelayed(0, 20);
      continue;
      setAlpha(102);
      invalidateSelf();
    }
  }
  
  public void inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet)
    throws IOException, XmlPullParserException
  {
    if (aL() != null) {
      aL().inflate(paramResources, paramXmlPullParser, paramAttributeSet);
    }
    super.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public void inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      aL().inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    super.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public void invalidateSelf()
  {
    if (aL() != null) {
      aL().invalidateSelf();
    }
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (aL() != null)) {
      return aL().isAutoMirrored();
    }
    return super.isAutoMirrored();
  }
  
  public boolean isFilterBitmap()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (aL() != null)) {
      return aL().isFilterBitmap();
    }
    return super.isFilterBitmap();
  }
  
  public boolean isStateful()
  {
    if (aL() != null) {
      return aL().isStateful();
    }
    return super.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    if (aL() != null) {
      aL().jumpToCurrentState();
    }
    super.jumpToCurrentState();
  }
  
  @NonNull
  public Drawable mutate()
  {
    Drawable localDrawable = aL();
    if (localDrawable != null)
    {
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        this.eW = ((SkinnableBitmapDrawable)aL()).mutate2();
      }
      while (!(localDrawable instanceof URLDrawable)) {
        return this;
      }
      this.eW = localDrawable.mutate();
      return this;
    }
    return super.mutate();
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (aL() != null)) {
      return aL().onLayoutDirectionChanged(paramInt);
    }
    return super.onLayoutDirectionChanged(paramInt);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    int k = paramURLDrawable.getIntrinsicWidth();
    int m = paramURLDrawable.getIntrinsicHeight();
    int j = m;
    int i = k;
    if (m > 0)
    {
      j = m;
      i = k;
      if (k > 0)
      {
        i = k * this.djT / m;
        j = this.djT;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkIconProxyDrawable", 2, "onLoadSuccessed width : " + i + " height:" + j);
    }
    if ((i > 0) && (j > 0))
    {
      setBounds(0, 0, i, j);
      invalidateSelf();
      if ((getCallback() != null) && ((getCallback() instanceof View)))
      {
        ((View)getCallback()).invalidate();
        ((View)getCallback()).requestLayout();
      }
      if (this.aO != null)
      {
        paramURLDrawable = (ajns.a)this.aO.get();
        if (paramURLDrawable != null) {
          paramURLDrawable.dyA();
        }
      }
    }
  }
  
  public void scheduleSelf(@NonNull Runnable paramRunnable, long paramLong)
  {
    if (aL() != null) {
      aL().scheduleSelf(paramRunnable, paramLong);
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    if (aL() != null) {
      aL().setAlpha(paramInt);
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (aL() != null)) {
      aL().setAutoMirrored(paramBoolean);
    }
    super.setAutoMirrored(paramBoolean);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkIconProxyDrawable", 2, "setBounds [left, top right, bottom] : " + new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    if (aL() != null) {
      aL().setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(@NonNull Rect paramRect)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkIconProxyDrawable", 2, "setBounds bounds : " + paramRect);
    }
    if (aL() != null) {
      aL().setBounds(paramRect);
    }
    super.setBounds(paramRect);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (aL() != null) {
      aL().setChangingConfigurations(paramInt);
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, @NonNull PorterDuff.Mode paramMode)
  {
    if (aL() != null) {
      aL().setColorFilter(paramInt, paramMode);
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    if (aL() != null) {
      aL().setColorFilter(paramColorFilter);
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (aL() != null) {
      aL().setDither(paramBoolean);
    }
    super.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (aL() != null) {
      aL().setFilterBitmap(paramBoolean);
    }
    super.setFilterBitmap(paramBoolean);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      aL().setHotspot(paramFloat1, paramFloat2);
    }
    super.setHotspot(paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      aL().setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(@NonNull int[] paramArrayOfInt)
  {
    if (aL() != null) {
      return aL().setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
  
  public void setTint(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      aL().setTint(paramInt);
    }
    super.setTint(paramInt);
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      aL().setTintList(paramColorStateList);
    }
    super.setTintList(paramColorStateList);
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (aL() != null)) {
      aL().setTintMode(paramMode);
    }
    super.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (aL() != null) {
      return aL().setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(@NonNull Runnable paramRunnable)
  {
    if (aL() != null) {
      aL().unscheduleSelf(paramRunnable);
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  public static abstract interface a
  {
    public abstract void dyA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajns
 * JD-Core Version:    0.7.0.1
 */