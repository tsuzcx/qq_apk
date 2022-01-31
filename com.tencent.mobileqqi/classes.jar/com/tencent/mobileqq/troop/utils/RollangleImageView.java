package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import gxi;

public class RollangleImageView
  extends ImageView
{
  public static final int a = 50;
  public static Bitmap a;
  public static Bitmap b;
  AsyncTask jdField_a_of_type_AndroidOsAsyncTask = null;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  public String b;
  
  public RollangleImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RollangleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RollangleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static Bitmap a(String paramString)
  {
    if ((jdField_a_of_type_AndroidGraphicsBitmap == null) || (jdField_b_of_type_AndroidGraphicsBitmap == null))
    {
      localObject = BaseApplication.getContext().getResources();
      jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource((Resources)localObject, 2130838417);
      jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource((Resources)localObject, 2130838416);
    }
    Object localObject = ImageUtil.a(new BitmapFactory.Options(), paramString, 128);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (paramString == null) {
        return null;
      }
      int i = paramString.getWidth();
      int j = paramString.getHeight();
      int k = Math.max(i, j);
      localObject = new Rect(0, 0, k, k);
      Bitmap localBitmap = Bitmap.createBitmap(k, k, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      Rect localRect1 = new Rect(0, 0, jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      localCanvas.drawBitmap(jdField_a_of_type_AndroidGraphicsBitmap, localRect1, (Rect)localObject, localPaint);
      localRect1 = new Rect();
      localRect1.left = ((k - i) / 2);
      localRect1.top = ((k - j) / 2);
      localRect1.right = (localRect1.left + i);
      localRect1.bottom = (localRect1.top + j);
      Rect localRect2 = new Rect(0, 0, i, j);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramString, localRect2, localRect1, localPaint);
      localRect1 = new Rect(0, 0, jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
      localPaint.setXfermode(null);
      localCanvas.drawBitmap(jdField_b_of_type_AndroidGraphicsBitmap, localRect1, (Rect)localObject, localPaint);
      paramString.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  private Bitmap a(boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (paramBoolean) {
        return RollangleImageView.ImageCache.a().b(this.jdField_b_of_type_JavaLangString, this);
      }
      return RollangleImageView.ImageCache.a().a(this.jdField_b_of_type_JavaLangString, this);
    }
    return RollangleImageView.ImageCache.a().a(this.jdField_a_of_type_JavaLangString);
  }
  
  private void a()
  {
    try
    {
      setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), FileManagerUtil.b(this.jdField_a_of_type_JavaLangString)));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void b(boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (paramBoolean) {}
      for (Bitmap localBitmap = RollangleImageView.ImageCache.a().b(this.jdField_b_of_type_JavaLangString, this); localBitmap != null; localBitmap = RollangleImageView.ImageCache.a().a(this.jdField_b_of_type_JavaLangString, this))
      {
        setImageBitmap(localBitmap);
        return;
      }
    }
    a();
  }
  
  public static void setSuspendLoad(boolean paramBoolean)
  {
    RollangleImageView.ImageCache.a().a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null)
    {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
      this.jdField_a_of_type_AndroidOsAsyncTask = null;
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new gxi(this).execute(new Boolean[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setParams(String paramString1, String paramString2)
  {
    if ((TroopFileUtils.a(paramString1, this.jdField_a_of_type_JavaLangString)) && (TroopFileUtils.a(paramString2, this.jdField_b_of_type_JavaLangString))) {
      return;
    }
    if (RollangleImageView.ImageCache.a().jdField_a_of_type_Boolean)
    {
      setParamsOnScrolling(paramString1, paramString2);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    a(true);
  }
  
  public void setParamsOnScrolling(String paramString1, String paramString2)
  {
    if ((TroopFileUtils.a(paramString1, this.jdField_a_of_type_JavaLangString)) && (TroopFileUtils.a(paramString2, this.jdField_b_of_type_JavaLangString))) {
      return;
    }
    Bitmap localBitmap = RollangleImageView.ImageCache.a().a(paramString2, this);
    if (localBitmap == null) {}
    for (paramString1 = RollangleImageView.ImageCache.a().a(paramString1);; paramString1 = localBitmap)
    {
      setImageBitmap(paramString1);
      return;
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView
 * JD-Core Version:    0.7.0.1
 */