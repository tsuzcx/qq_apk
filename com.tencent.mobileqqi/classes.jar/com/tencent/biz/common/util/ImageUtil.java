package com.tencent.biz.common.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import bnw;
import bnx;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImageUtil
{
  protected static int a = 0;
  public static long a = 0L;
  public static Bitmap a;
  public static Handler a;
  public static LoadedCallBack a;
  public static Runnable a;
  protected static String a;
  protected static List a;
  protected static int b = 0;
  public static String b;
  protected static List b;
  protected static final int c = 410;
  public static String c;
  protected static final int d = 140;
  public static String d;
  public static final int e = 6;
  public static String e;
  private static final int f = -1;
  private static int g;
  
  static
  {
    jdField_a_of_type_Int = 7;
    jdField_b_of_type_Int = 10;
    jdField_b_of_type_JavaLangString = "ImageUtil";
    jdField_a_of_type_AndroidOsHandler = new bnw();
    jdField_a_of_type_JavaLangRunnable = new bnx();
  }
  
  public static final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = b(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      paramInt1 = 1;
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i) {
          break;
        }
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i + 7) / 8 * 8;
    return paramInt2;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    int i;
    if (((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))) || ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) || ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))))
    {
      a(SubString.a(paramString2, jdField_a_of_type_Int), SubString.a(paramString3, jdField_b_of_type_Int));
      i = 1;
    }
    do
    {
      do
      {
        return i;
        if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
          return 2;
        }
        i = j;
      } while (!TextUtils.isEmpty(paramString1));
      if (!TextUtils.isEmpty(paramString2)) {
        break;
      }
      i = j;
    } while (TextUtils.isEmpty(paramString3));
    a(SubString.a(paramString2, jdField_a_of_type_Int + 3), SubString.a(paramString3, jdField_b_of_type_Int + 4));
    return 3;
  }
  
  public static Bitmap a()
  {
    Bitmap localBitmap = Bitmap.createBitmap(410, 140, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(g);
    localPaint.setTextSize(32.0F);
    Iterator localIterator;
    int i;
    if (jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "drawType3 listTitleSeq:" + jdField_a_of_type_JavaUtilList.toString());
      }
      localIterator = jdField_a_of_type_JavaUtilList.iterator();
      i = 28;
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localCanvas.drawText((String)localIterator.next(), 0, i, localPaint);
        i += 38;
      }
    }
    int j = 28;
    if (jdField_b_of_type_JavaUtilList != null)
    {
      localPaint.setColor(Color.rgb(138, 138, 138));
      localPaint.setTextSize(24.0F);
      localIterator = jdField_b_of_type_JavaUtilList.iterator();
      i = j - 4;
      while (localIterator.hasNext())
      {
        localCanvas.drawText((String)localIterator.next(), 0, i, localPaint);
        i += 30;
      }
    }
    localCanvas.save(31);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int j = 0;
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(410, 140, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    paramBitmap = a(paramBitmap, 140, 140, 2, 6);
    int i = paramBitmap.getWidth();
    if (i == 140)
    {
      i = 0;
      localCanvas.drawBitmap(paramBitmap, i, 0.0F, null);
      localPaint.setColor(g);
      localPaint.setTextSize(32.0F);
      if (jdField_a_of_type_JavaUtilList != null) {
        break label182;
      }
      label107:
      if (jdField_a_of_type_JavaUtilList == null) {
        break label202;
      }
      paramBitmap = jdField_a_of_type_JavaUtilList.iterator();
      i = 28;
      label125:
      k = i;
      if (!paramBitmap.hasNext()) {
        break label205;
      }
      localCanvas.drawText((String)paramBitmap.next(), '', i, localPaint);
      if (j != 3) {
        break label194;
      }
      i += 50;
    }
    for (;;)
    {
      break label125;
      i = (140 - i) / 2;
      break;
      label182:
      j = jdField_a_of_type_JavaUtilList.size();
      break label107;
      label194:
      i += 38;
    }
    label202:
    int k = 28;
    label205:
    if (jdField_b_of_type_JavaUtilList != null)
    {
      localPaint.setColor(Color.rgb(138, 138, 138));
      localPaint.setTextSize(24.0F);
      paramBitmap = jdField_b_of_type_JavaUtilList.iterator();
      i = k - 4;
      if (paramBitmap.hasNext())
      {
        localCanvas.drawText((String)paramBitmap.next(), '', i, localPaint);
        if (j < 2) {
          i += 35;
        }
        for (;;)
        {
          break;
          i += 30;
        }
      }
    }
    localCanvas.save(31);
    return localBitmap;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject;
    if (paramBitmap == null)
    {
      localObject = null;
      return localObject;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    if (j > k) {}
    for (int i = j;; i = k)
    {
      localObject = paramBitmap;
      if (i <= paramInt) {
        break;
      }
      float f1 = paramInt / i;
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f1);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, j, k, (Matrix)localObject, true);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return localObject;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i1 = paramInt1 - paramInt3 * 2;
    int n = paramInt2 - paramInt3 * 2;
    paramInt2 = paramBitmap.getWidth();
    paramInt1 = paramBitmap.getHeight();
    int j;
    int i;
    int m;
    int k;
    if (((paramInt1 > n) || (paramInt2 > i1)) && (paramInt2 != paramInt1)) {
      if (paramInt2 > paramInt1)
      {
        j = paramInt2 / 2 - paramInt1 / 2;
        i = paramInt2 / 2 + paramInt1 / 2;
        m = 0;
        k = paramInt1;
      }
    }
    for (;;)
    {
      if (paramInt2 > i1)
      {
        paramInt2 = i1;
        label85:
        if (paramInt1 <= n) {
          break label382;
        }
        paramInt1 = n;
      }
      label382:
      for (;;)
      {
        Object localObject = new Rect(j, m, i, k);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "srcRect:" + ((Rect)localObject).toString());
        }
        Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt1, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, paramInt2, paramInt1);
        RectF localRectF = new RectF(localRect);
        float f1 = paramInt4;
        localPaint.setAntiAlias(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-12434878);
        localCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(paramBitmap, (Rect)localObject, localRect, localPaint);
        paramBitmap = Bitmap.createBitmap(paramInt3 * 2 + paramInt2, paramInt3 * 2 + paramInt1, Bitmap.Config.ARGB_8888);
        localObject = new Canvas(paramBitmap);
        ((Canvas)localObject).drawBitmap(localBitmap, localRect, new Rect(paramInt3, paramInt3, paramInt2 + paramInt3, paramInt1 + paramInt3), null);
        ((Canvas)localObject).save(31);
        localBitmap.recycle();
        return paramBitmap;
        k = paramInt1 / 2;
        m = paramInt2 / 2;
        i = paramInt1 / 2;
        j = paramInt2 / 2;
        m = k - m;
        k = i + j;
        j = 0;
        i = paramInt2;
        break;
        break label85;
      }
      j = 0;
      m = 0;
      k = paramInt1;
      i = paramInt2;
    }
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (new File(paramString).exists()) {
        localObject1 = BitmapFactory.decodeFile(paramString);
      }
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.w(jdField_b_of_type_JavaLangString, 2, "readImg OOM, fileName=" + paramString, localThrowable);
    }
    return null;
  }
  
  public static final Bitmap a(String paramString, int paramInt)
  {
    int i = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int j = localOptions.outWidth;
    paramInt = Math.max(localOptions.outHeight, j) / paramInt;
    if (paramInt < 0) {
      paramInt = i;
    }
    for (;;)
    {
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = paramInt;
      return BitmapFactory.decodeFile(paramString, localOptions);
    }
  }
  
  public static String a(Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    try
    {
      jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString();
      label18:
      String str = jdField_a_of_type_JavaLangString + "/tmp/";
      try
      {
        Object localObject = new File(str);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
        localObject = MD5.toMD5(a(paramBitmap));
        localObject = "share_qq_" + (String)localObject + ".png";
        str = str + (String)localObject;
        localObject = new File(str);
        if (((File)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "saveFile:file.exists");
          }
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "generated file length:" + ((File)localObject).length());
            return str;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "saveFile:new image");
          }
          BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject));
          paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localBufferedOutputStream);
          localBufferedOutputStream.flush();
          localBufferedOutputStream.close();
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "generated file length:" + ((File)localObject).length());
            return str;
          }
        }
      }
      catch (IOException paramBitmap)
      {
        paramBitmap.printStackTrace();
        return "";
      }
    }
    catch (Exception localException)
    {
      break label18;
      return localException;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, LoadedCallBack paramLoadedCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "====makeImage:imgUrl:" + paramString1 + ", title:" + paramString2 + ",summary:" + paramString3);
    }
    d = paramString2;
    e = paramString3;
    jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack = paramLoadedCallBack;
    g = paramInt;
    jdField_a_of_type_Long = System.currentTimeMillis();
    try
    {
      jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString();
      label85:
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "imgUrl:" + paramString1 + ",ALBUM_PATH:" + jdField_a_of_type_JavaLangString);
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (paramString1.contains(jdField_a_of_type_JavaLangString))) {}
      for (c = paramString1;; c = "")
      {
        jdField_a_of_type_JavaUtilList = null;
        jdField_b_of_type_JavaUtilList = null;
        if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2)) || (!TextUtils.isEmpty(paramString3))) {
          break;
        }
        paramLoadedCallBack.a(null);
        return;
      }
      new Thread(jdField_a_of_type_JavaLangRunnable).start();
      return;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, LoadedCallBack paramLoadedCallBack)
  {
    a(paramString1, paramString2, paramString3, -16777216, paramLoadedCallBack);
  }
  
  protected static void a(List paramList1, List paramList2)
  {
    int i = 1;
    switch (paramList1.size())
    {
    default: 
      if (paramList1.size() <= 3) {
        break;
      }
    }
    for (;;)
    {
      int j = paramList1.size();
      while (j > 3)
      {
        paramList1.remove(j - 1);
        j -= 1;
      }
      paramList1 = new ArrayList();
      if (paramList2.size() > 4)
      {
        paramList1.add(paramList2.get(0));
        paramList1.add(paramList2.get(1));
        paramList1.add(paramList2.get(2));
        paramList2 = (String)paramList2.get(3);
        paramList1.add(paramList2.substring(0, paramList2.length() - 3) + "...");
      }
      for (;;)
      {
        jdField_b_of_type_JavaUtilList = paramList1;
        return;
        paramList1.addAll(paramList2);
      }
      ArrayList localArrayList = new ArrayList();
      if (paramList2.size() > 2)
      {
        localArrayList.add(paramList2.get(0));
        paramList2 = (String)paramList2.get(1);
        localArrayList.add(paramList2.substring(0, paramList2.length() - 3) + "...");
      }
      for (;;)
      {
        jdField_a_of_type_JavaUtilList = paramList1;
        jdField_b_of_type_JavaUtilList = localArrayList;
        return;
        localArrayList.addAll(paramList2);
      }
      localArrayList = new ArrayList();
      if (paramList2.size() > 3)
      {
        localArrayList.add(paramList2.get(0));
        localArrayList.add(paramList2.get(1));
        paramList2 = (String)paramList2.get(2);
        localArrayList.add(paramList2.substring(0, paramList2.length() - 3) + "...");
      }
      for (;;)
      {
        jdField_a_of_type_JavaUtilList = paramList1;
        jdField_b_of_type_JavaUtilList = localArrayList;
        return;
        localArrayList.addAll(paramList2);
      }
      i = 0;
    }
    if (i != 0)
    {
      paramList2 = (String)paramList1.remove(paramList1.size() - 1);
      paramList1.add(paramList2.substring(0, paramList2.length() - 3) + "...");
    }
    jdField_a_of_type_JavaUtilList = paramList1;
  }
  
  public static byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 == -1)
    {
      i = 1;
      if (paramInt1 != -1) {
        break label60;
      }
      j = 128;
      label31:
      if (j >= i) {
        break label84;
      }
    }
    label60:
    label84:
    do
    {
      return i;
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      if ((paramInt2 == -1) && (paramInt1 == -1)) {
        return 1;
      }
    } while (paramInt1 == -1);
    return j;
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    new Paint().setAntiAlias(true);
    paramBitmap = a(paramBitmap, 400, 400, 2, 6);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    localCanvas.save(31);
    return localBitmap;
  }
  
  public static final Bitmap b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((localOptions.mCancel) || (localOptions.outWidth == -1) || (localOptions.outHeight == -1)) {
      return null;
    }
    if (i > j) {}
    Bitmap localBitmap;
    for (;;)
    {
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      if (i > paramInt) {
        localOptions.inSampleSize = a(localOptions, -1, paramInt * paramInt);
      }
      localOptions.inJustDecodeBounds = false;
      localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      if (localBitmap != null) {
        break;
      }
      return null;
      i = j;
    }
    i = localOptions.outWidth;
    j = localOptions.outHeight;
    if (i > j) {}
    for (;;)
    {
      paramString = localBitmap;
      if (i <= paramInt) {
        break;
      }
      return a(localBitmap, paramInt);
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.ImageUtil
 * JD-Core Version:    0.7.0.1
 */