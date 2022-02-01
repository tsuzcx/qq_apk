package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import atau.a;
import auvj;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncImageView
  extends URLThemeImageView
{
  private Path I;
  private Path J;
  private Context context;
  private float[] cy;
  private Drawable defaultDrawable;
  private int mCornerRadius;
  private int mHeight = 128;
  private Paint mPaint;
  private int mWidth = 128;
  private Xfermode mXfermode;
  private RectF u;
  
  public AsyncImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rI);
    this.mCornerRadius = paramContext.getDimensionPixelOffset(0, 0);
    this.I = new Path();
    if (Build.VERSION.SDK_INT <= 26) {}
    for (this.mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);; this.mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT))
    {
      this.a.setMaskShape(auvj.euL);
      this.J = new Path();
      this.cy = new float[8];
      this.mPaint = new Paint();
      dmu();
      dmv();
      paramContext.recycle();
      return;
    }
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString, paramInt1, paramInt2, paramFile, paramBoolean1, paramBoolean2, false);
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, File paramFile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = 0L;
    if (paramFile != null) {
      l = paramFile.lastModified();
    }
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l + "|1";
    if (paramBoolean1)
    {
      paramString = paramString + "|1";
      if (!paramBoolean2) {
        break label174;
      }
      paramString = paramString + "|1";
      label111:
      if (!paramBoolean3) {
        break label197;
      }
    }
    for (paramString = paramString + "|1";; paramString = paramString + "|0")
    {
      try
      {
        paramString = new URL("fileassistantimage", "", paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        label174:
        label197:
        if (!QLog.isColorLevel()) {
          break label238;
        }
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
      paramString = paramString + "|0";
      break;
      paramString = paramString + "|0";
      break label111;
    }
    label238:
    return null;
  }
  
  public static boolean c(URL paramURL)
  {
    if (paramURL == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramURL = paramURL.getProtocol();
        if (paramURL != null)
        {
          boolean bool = paramURL.equals("filegalleryorigimage");
          if (bool) {
            return true;
          }
        }
      }
      catch (Exception paramURL) {}
    }
    return false;
  }
  
  private void dmu()
  {
    if (this.u == null) {
      this.u = new RectF();
    }
    this.u.set(0.0F, 0.0F, getWidth(), getHeight());
  }
  
  private void dmv()
  {
    if (this.mCornerRadius > 0)
    {
      int i = 0;
      while (i < this.cy.length)
      {
        this.cy[i] = (this.mCornerRadius / 2.0F);
        i += 1;
      }
    }
  }
  
  public static URL g(String paramString)
  {
    try
    {
      paramString = new URL("filegalleryorigimage", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  private void setDefaultDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.mCornerRadius <= 0)
    {
      super.onDraw(paramCanvas);
      return;
    }
    paramCanvas.saveLayer(this.u, null, 31);
    super.onDraw(paramCanvas);
    this.mPaint.reset();
    this.I.reset();
    this.J.reset();
    this.I.addRoundRect(this.u, this.cy, Path.Direction.CCW);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setXfermode(this.mXfermode);
    if (Build.VERSION.SDK_INT <= 26) {
      paramCanvas.drawPath(this.I, this.mPaint);
    }
    for (;;)
    {
      this.mPaint.setXfermode(null);
      paramCanvas.restore();
      return;
      this.J.addRect(this.u, Path.Direction.CCW);
      this.J.op(this.I, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(this.J, this.mPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    dmu();
  }
  
  public void setApkIconAsyncImage(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Object localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      try
      {
        int i = getWidth();
        int j = getHeight();
        if ((i > 0) && (j > 0))
        {
          this.mWidth = i;
          this.mHeight = j;
        }
        setAdjustViewBounds(false);
        paramString = a(paramString, this.mWidth, this.mHeight, (File)localObject, false, true);
        if (paramString == null) {
          break label162;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.mWidth;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.mHeight;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.defaultDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.defaultDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = 6.0F;
        paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        if (paramString != null)
        {
          setImageDrawable(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        setDefaultDrawable(this.defaultDrawable);
        return;
      }
      setDefaultDrawable(this.defaultDrawable);
      return;
      label162:
      setDefaultDrawable(this.defaultDrawable);
      return;
    }
    setDefaultDrawable(this.defaultDrawable);
  }
  
  public void setAsyncClipSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.mWidth = paramInt1;
    }
    if (paramInt2 > 0) {
      this.mHeight = paramInt2;
    }
  }
  
  public void setAsyncImage(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      File localFile = new File(paramString);
      if (!localFile.exists()) {
        break label97;
      }
      try
      {
        setAdjustViewBounds(false);
        paramString = a(paramString, this.mWidth, this.mHeight, localFile, false, false);
        if (paramString != null)
        {
          paramString = URLDrawable.getDrawable(paramString, this.mWidth, this.mHeight, this.defaultDrawable, this.defaultDrawable, true);
          if (paramString == null)
          {
            setDefaultDrawable(this.defaultDrawable);
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        setDefaultDrawable(this.defaultDrawable);
        return;
      }
    }
    setImageDrawable(paramString);
    return;
    label97:
    setDefaultDrawable(this.defaultDrawable);
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.mCornerRadius = paramInt;
    dmu();
    dmv();
    invalidate();
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.defaultDrawable = this.context.getResources().getDrawable(paramInt);
    setImageDrawable(this.defaultDrawable);
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setUrlIconAsyncImage(String paramString)
  {
    if (paramString == null)
    {
      setDefaultDrawable(this.defaultDrawable);
      return;
    }
    try
    {
      paramString = new URL(paramString);
      if (paramString == null)
      {
        setDefaultDrawable(this.defaultDrawable);
        return;
      }
    }
    catch (Exception paramString)
    {
      setDefaultDrawable(this.defaultDrawable);
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, this.mWidth, this.mHeight, this.defaultDrawable, this.defaultDrawable, true);
    if (paramString == null)
    {
      setDefaultDrawable(this.defaultDrawable);
      return;
    }
    setImageDrawable(paramString);
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */