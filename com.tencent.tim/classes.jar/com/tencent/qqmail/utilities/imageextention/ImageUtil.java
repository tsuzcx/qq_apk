package com.tencent.qqmail.utilities.imageextention;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import moai.core.utilities.Utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ImageUtil
{
  private static final int JPEG_COMPRESS_RATIO = 85;
  private static final String TAG = "ImageUtil";
  
  public static byte[] Bitmap2Bytes(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (paramString.equalsIgnoreCase("png")) {
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    }
    for (;;)
    {
      paramBitmap = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        return paramBitmap;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return paramBitmap;
      }
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    }
  }
  
  public static void CompressImage(ComposeMailUI paramComposeMailUI)
  {
    if (paramComposeMailUI == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramComposeMailUI.getAddAttachInfoList();
    } while (localObject == null);
    ComposeMailUI.ImageScaleDegree localImageScaleDegree = paramComposeMailUI.getImageScale();
    String str2 = paramComposeMailUI.getComposeCacheFilePath() + File.separator + CommUtils.COMPOSE_CACHE + File.separator;
    Iterator localIterator = ((ArrayList)localObject).iterator();
    label63:
    AttachInfo localAttachInfo;
    File localFile;
    Bitmap localBitmap;
    boolean bool;
    if (localIterator.hasNext())
    {
      localAttachInfo = (AttachInfo)localIterator.next();
      if ((!localAttachInfo.isImage()) || (!paramComposeMailUI.needCompressImage())) {
        break label350;
      }
      String str1 = str2 + localAttachInfo.hashAttachPath() + "_compress" + localImageScaleDegree.getDegree();
      localFile = new File(str1);
      localObject = str1;
      if (!localFile.exists())
      {
        localBitmap = memSafeScaleImage(localAttachInfo.getAttachPath(), 1, ComposeMailUI.ImageScaleDegree.getRatio(localImageScaleDegree));
        localObject = str1;
        if (localBitmap != null)
        {
          if (!"png".equalsIgnoreCase(localAttachInfo.getAttachPostFix())) {
            break label331;
          }
          bool = writeBitmapToLocation(localBitmap, Bitmap.CompressFormat.JPEG, 85, localFile.getAbsolutePath());
          label209:
          localObject = str1;
          if (!bool) {
            localObject = localAttachInfo.getAttachPath();
          }
          localBitmap.recycle();
        }
      }
    }
    for (;;)
    {
      localAttachInfo.uploadDataPath = (str2 + QMAttachUtils.getOriginAttachName(localAttachInfo));
      if ((localObject != null) && (!((String)localObject).equals("")) && (!localAttachInfo.uploadDataPath.equals(localObject))) {
        FileUtil.copyFile(new File((String)localObject), new File(localAttachInfo.uploadDataPath));
      }
      if (new File(localAttachInfo.uploadDataPath).exists()) {
        break label63;
      }
      localAttachInfo.uploadDataPath = "";
      break label63;
      break;
      label331:
      bool = writeBitmapToLocation(localBitmap, Bitmap.CompressFormat.JPEG, 85, localFile.getAbsolutePath());
      break label209;
      label350:
      localObject = localAttachInfo.getAttachPath();
    }
  }
  
  public static void CompressImage(CopyOnWriteArrayList<FtnUploadInfo> paramCopyOnWriteArrayList, ComposeMailUI.ImageScaleDegree paramImageScaleDegree)
  {
    if ((paramCopyOnWriteArrayList == null) || (paramCopyOnWriteArrayList.size() == 0) || (paramImageScaleDegree == ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin)) {
      return;
    }
    for (;;)
    {
      FtnUploadInfo localFtnUploadInfo;
      File localFile;
      Bitmap localBitmap;
      try
      {
        String str1 = FileUtil.getAttachDownloadDir() + "compress/";
        FileUtil.tryMkdirs(new File(str1));
        paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
        if (!paramCopyOnWriteArrayList.hasNext()) {
          break;
        }
        localFtnUploadInfo = (FtnUploadInfo)paramCopyOnWriteArrayList.next();
        String str2 = localFtnUploadInfo.getSha() + "_compress_" + paramImageScaleDegree.getDegree();
        str2 = str1 + str2;
        localFile = new File(str2);
        if (!localFile.exists()) {
          localFile.mkdir();
        }
        str2 = str2 + "/" + localFtnUploadInfo.getName();
        localFile = new File(str2);
        if ((localFile.exists()) && (localFile.length() == localFtnUploadInfo.getFileSize()))
        {
          if (!localFile.delete()) {
            QMLog.log(6, CommUtils.TAG, "Compress image fail (size is equal original), try to delete local file fail!");
          }
        }
        else
        {
          if (localFile.exists()) {
            break label376;
          }
          localBitmap = fixImageOrientationDirection(memSafeScaleImage(localFtnUploadInfo.getAbsolutePath(), 1, ComposeMailUI.ImageScaleDegree.getRatio(paramImageScaleDegree)), getImageOrientation(null, localFtnUploadInfo.getAbsolutePath()));
          if (localBitmap == null) {
            continue;
          }
          if (!FileUtil.getFileNameSuffix(localFtnUploadInfo.getName()).equals("png")) {
            break label357;
          }
          bool = writeBitmapToLocation(localBitmap, Bitmap.CompressFormat.PNG, 85, localFile.getAbsolutePath());
          if (bool)
          {
            localFtnUploadInfo.setAbsolutePath(str2);
            localFtnUploadInfo.setFileSize(localFile.length());
          }
          localBitmap.recycle();
          continue;
        }
        QMLog.log(4, CommUtils.TAG, "Compress image fail (size is equal original), try to delete local file succ!");
      }
      catch (Exception paramCopyOnWriteArrayList)
      {
        paramCopyOnWriteArrayList.printStackTrace();
        return;
      }
      continue;
      label357:
      boolean bool = writeBitmapToLocation(localBitmap, Bitmap.CompressFormat.JPEG, 85, localFile.getAbsolutePath());
      continue;
      label376:
      localFtnUploadInfo.setAbsolutePath(localFile.getAbsolutePath());
      localFtnUploadInfo.setFileSize(localFile.length());
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    paramOptions = new DisplayMetrics();
    ((WindowManager)QMApplicationContext.sharedInstance().getSystemService("window")).getDefaultDisplay().getMetrics(paramOptions);
    int k = paramOptions.widthPixels;
    int m = paramOptions.widthPixels;
    if ((i >= m * 2) || (j >= k * 2)) {
      if (j > i) {
        i = Math.round(i / k);
      }
    }
    for (;;)
    {
      return Math.min(32, Math.max(1, i));
      i = Math.round(j / m);
      continue;
      i = 1;
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static Bitmap captureWebViewVisibleArea(WebView paramWebView)
  {
    paramWebView.destroyDrawingCache();
    paramWebView.setDrawingCacheEnabled(true);
    return paramWebView.getDrawingCache();
  }
  
  public static String checkPathSuffix(String paramString)
  {
    String str = paramString;
    if (Build.VERSION.SDK_INT <= 10)
    {
      str = paramString;
      if (!FileUtil.isImageSuffix(paramString))
      {
        Bitmap localBitmap = memSafeScaleImage(paramString, 1, 1.0F);
        str = paramString + ".jpg";
        writeBitmapToLocation(localBitmap, Bitmap.CompressFormat.JPEG, 85, str);
      }
    }
    return str;
  }
  
  public static Bitmap compressUploadImage(Bitmap paramBitmap)
  {
    int i = 960;
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    double d = j / k;
    if (d >= 1.0D)
    {
      if (j > 960) {}
      for (;;)
      {
        j = (int)(i / d);
        k = i;
        i = j;
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, k, i, true);
        if (localBitmap != paramBitmap) {
          paramBitmap.recycle();
        }
        return localBitmap;
        i = j;
      }
    }
    if (k > 960) {}
    for (;;)
    {
      k = (int)(i * d);
      break;
      i = k;
    }
  }
  
  public static boolean createOrientedImage(long paramLong, AttachInfo paramAttachInfo)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2;
    if (!FileUtil.hasSdcard()) {
      bool2 = bool3;
    }
    for (;;)
    {
      return bool2;
      String str = paramAttachInfo.genPreviewPath();
      bool2 = bool3;
      if (new File(str).exists()) {
        continue;
      }
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Bitmap localBitmap = null;
      Object localObject1 = localObject4;
      Object localObject3 = localObject5;
      Object localObject2 = localObject6;
      try
      {
        if (needFixedOrientation(paramAttachInfo.getAttachPath()))
        {
          localObject1 = localObject4;
          localObject3 = localObject5;
          localObject2 = localObject6;
          localBitmap = fixLengthLimitedImageOrientation(paramAttachInfo.getAttachPath(), paramLong);
          localObject1 = localBitmap;
          localObject3 = localBitmap;
          localObject2 = localBitmap;
          if (!"png".equals(paramAttachInfo.getAttachPostFix())) {
            break label163;
          }
          localObject1 = localBitmap;
          localObject3 = localBitmap;
          localObject2 = localBitmap;
          bool1 = writeBitmapToLocation(localBitmap, Bitmap.CompressFormat.PNG, 100, str);
        }
        for (;;)
        {
          bool2 = bool1;
          if (localBitmap == null) {
            break;
          }
          localBitmap.recycle();
          return bool1;
          label163:
          localObject1 = localBitmap;
          localObject3 = localBitmap;
          localObject2 = localBitmap;
          bool1 = writeBitmapToLocation(localBitmap, Bitmap.CompressFormat.JPEG, 100, str);
          localObject1 = localBitmap;
          localObject3 = localBitmap;
          localObject2 = localBitmap;
          FileUtil.copyFile(new File(str), new File(paramAttachInfo.getAttachPath()));
        }
      }
      catch (OutOfMemoryError paramAttachInfo)
      {
        localObject2 = localObject1;
        System.gc();
        bool2 = bool3;
        return false;
      }
      catch (Exception paramAttachInfo)
      {
        bool2 = bool3;
        return false;
      }
      finally
      {
        if (localObject2 != null) {
          ((Bitmap)localObject2).recycle();
        }
      }
    }
  }
  
  public static Bitmap createThumbnailImage(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return createThumbnailImage(paramBitmap, paramInt1, paramInt2, true);
  }
  
  public static Bitmap createThumbnailImage(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    float f2 = 0.0F;
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = i / j;
    float f3 = paramInt1 / paramInt2;
    float f4;
    if (f1 >= 1.0F)
    {
      f4 = j * f3;
      f3 = (i - f4) / 2.0F;
      f1 = j;
    }
    for (;;)
    {
      i = (int)f3;
      j = (int)f2;
      int k = (int)f4;
      int m = (int)f1;
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, i, j, k, m);
        if ((paramBoolean) && (paramBitmap != localBitmap)) {
          paramBitmap.recycle();
        }
        return localBitmap;
        f1 = i / f3;
        f2 = (j - f1) / 2.0F;
        f4 = i;
        f3 = 0.0F;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          QMLog.log(6, CommUtils.TAG, "createthumbnailimage, OOE: " + paramInt1 + ", " + paramInt2);
          Object localObject = null;
          System.gc();
        }
      }
    }
  }
  
  public static void cutPhotoAndSave(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null)
    {
      QMLog.log(6, "ImageUtil", "cut photo. bitmap is null.");
      return;
    }
    if ((paramString == null) || (paramString.equals("")))
    {
      QMLog.log(6, "ImageUtil", "cut photo. email not valid : " + paramString);
      return;
    }
    Bitmap localBitmap1 = resizeImage(paramBitmap, QMUIKit.dpToPx(68), QMUIKit.dpToPx(112));
    Bitmap localBitmap2 = resizeImage(paramBitmap, QMUIKit.dpToPx(68), QMUIKit.dpToPx(68));
    Bitmap localBitmap3 = resizeImage(paramBitmap, QMUIKit.dpToPx(44), QMUIKit.dpToPx(44));
    paramBitmap = resizeImage(paramBitmap, QMUIKit.dpToPx(30), QMUIKit.dpToPx(30));
    Object localObject = FileUtil.getEmailIconDirPath() + paramString + File.separator;
    paramString = (String)localObject + 1;
    String str1 = (String)localObject + 2;
    String str2 = (String)localObject + 3;
    String str3 = (String)localObject + 4;
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    writeBitmapToLocation(localBitmap1, Bitmap.CompressFormat.PNG, 100, paramString);
    writeBitmapToLocation(localBitmap2, Bitmap.CompressFormat.PNG, 100, str1);
    writeBitmapToLocation(localBitmap3, Bitmap.CompressFormat.PNG, 100, str2);
    writeBitmapToLocation(paramBitmap, Bitmap.CompressFormat.PNG, 100, str3);
    ImageDownloadManager.shareInstance().removeMemoryCache(paramString);
    ImageDownloadManager.shareInstance().removeMemoryCache(str1);
    ImageDownloadManager.shareInstance().removeMemoryCache(str2);
    ImageDownloadManager.shareInstance().removeMemoryCache(str3);
  }
  
  public static Bitmap decodeSampledBitmapFromDisk(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  public static Bitmap decodeSampledBitmapFromInputStream(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    try
    {
      paramInputStream = ((FileInputStream)paramInputStream).getFD();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFileDescriptor(paramInputStream, null, localOptions);
      localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
      localOptions.inJustDecodeBounds = false;
      return BitmapFactory.decodeFileDescriptor(paramInputStream, null, localOptions);
    }
    catch (IOException paramInputStream)
    {
      Log.i("ImageUtil", "decodeSampledBitmapFromInputStream fail");
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt2, paramInt3);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static Bitmap fixImageOrientation(Bitmap paramBitmap, String paramString)
  {
    return fixImageOrientationDirection(paramBitmap, getImageOrientation(null, paramString));
  }
  
  public static Bitmap fixImageOrientation(String paramString)
  {
    return mendImageOrientation(paramString, null);
  }
  
  public static Bitmap fixImageOrientationDirection(Bitmap paramBitmap, int paramInt)
  {
    if ((paramBitmap == null) || (!needFixedOrientation(paramInt))) {
      return paramBitmap;
    }
    Object localObject = getFixExifMatrix(paramInt);
    try
    {
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QMLog.log(6, CommUtils.TAG, "fixImageOrientationDirection, OOE!");
      System.gc();
    }
    return paramBitmap;
  }
  
  public static Bitmap fixImageOrientationRecursively(Bitmap paramBitmap, String paramString, int paramInt)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = memSafeScaleImage(paramString, paramInt, 1.0F);
    }
    return fixImageOrientation(localBitmap, paramString);
  }
  
  public static Bitmap fixLengthLimitedImageOrientation(String paramString, long paramLong)
  {
    return fixImageOrientation(getLengthLimitedImage(paramString, paramLong), paramString);
  }
  
  public static Bitmap getBitmapFromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @TargetApi(12)
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    if (Utils.hasHoneycombMR1()) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private static Matrix getFixExifMatrix(int paramInt)
  {
    Matrix localMatrix = new Matrix();
    switch (paramInt)
    {
    default: 
      return localMatrix;
    case 2: 
      localMatrix.setScale(-1.0F, 1.0F);
      return localMatrix;
    case 3: 
      localMatrix.setRotate(180.0F);
      return localMatrix;
    case 4: 
      localMatrix.setRotate(180.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      return localMatrix;
    case 5: 
      localMatrix.setRotate(90.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      return localMatrix;
    case 6: 
      localMatrix.setRotate(90.0F);
      return localMatrix;
    case 7: 
      localMatrix.setRotate(-90.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      return localMatrix;
    }
    localMatrix.setRotate(-90.0F);
    return localMatrix;
  }
  
  public static BitmapFactory.Options getImageOpts(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return localOptions;
  }
  
  public static int getImageOrientation(Context paramContext, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    for (;;)
    {
      return 1;
      paramContext = new File(paramString);
      try
      {
        paramContext = new ExifInterface(paramContext.getAbsolutePath());
        if (paramContext == null) {
          continue;
        }
        return paramContext.getAttributeInt("Orientation", 1);
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
      }
    }
  }
  
  public static Bitmap getLengthLimitedImage(String paramString, long paramLong)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramLong <= 0L)) {}
    long l;
    do
    {
      return null;
      l = new File(paramString).length();
    } while (l <= 0L);
    if (l > paramLong) {}
    for (double d = l / paramLong;; d = 1.0D)
    {
      int i = (int)Math.ceil(Math.sqrt(d));
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      try
      {
        localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        paramString = (String)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          QMLog.log(6, CommUtils.TAG, "getlengthlimitedimage, OOE: " + paramString + ", byte: " + paramLong);
          paramString = null;
          System.gc();
        }
      }
      return paramString;
    }
  }
  
  public static Bitmap getRoundColorRimBitmap(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + paramInt1, paramBitmap.getHeight() + paramInt1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(paramInt2);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    localCanvas.drawBitmap(getRoundCornerBitmap(paramBitmap, paramFloat), localRect, new Rect(paramInt1, paramInt1, paramBitmap.getWidth() - paramInt1, paramBitmap.getHeight() - paramInt1), localPaint);
    return localBitmap;
  }
  
  public static Bitmap getRoundCornerBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public static Bitmap imageThumbSelfCompress(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      return null;
    }
    return ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(paramString), paramContext.getResources().getDimensionPixelSize(paramInt1), paramContext.getResources().getDimensionPixelOffset(paramInt2), 2);
  }
  
  public static Bitmap imageWithURL(String paramString)
    throws Exception
  {
    paramString = new DefaultHttpClient().execute(new HttpGet(paramString));
    paramString.getStatusLine().getStatusCode();
    Object localObject1 = paramString.getEntity();
    paramString = null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      localObject1 = ((HttpEntity)localObject1).getContent();
      paramString = (String)localObject1;
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        paramString = (String)localObject1;
        int i = ((InputStream)localObject1).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramString = (String)localObject1;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      if (localByteArrayOutputStream == null) {
        break label118;
      }
    }
    finally
    {
      if (localByteArrayOutputStream != null) {
        localByteArrayOutputStream.close();
      }
      if (paramString != null) {
        paramString.close();
      }
    }
    localByteArrayOutputStream.close();
    label118:
    if (localObject2 != null) {
      localObject2.close();
    }
    paramString = localByteArrayOutputStream.toByteArray();
    return BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
  }
  
  public static Bitmap memSafeScaleImage(String paramString, int paramInt, float paramFloat)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    if ((paramInt < 1) || (paramInt > 32)) {
      throw new IllegalArgumentException("sample out of range: " + paramInt);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int j = calculateInSampleSize(localOptions);
    int i = paramInt;
    if (j > paramInt) {
      i = j;
    }
    localOptions.inJustDecodeBounds = false;
    while (i <= 32)
    {
      localOptions.inSampleSize = i;
      try
      {
        Bitmap localBitmap = scaleImage(paramString, localOptions, paramFloat);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QMLog.log(6, CommUtils.TAG, " cyz memsafescaleimage, OOE: " + paramString + ", sample: " + i + ", " + paramFloat);
        System.gc();
        i += 1;
      }
    }
    return null;
  }
  
  /* Error */
  public static Bitmap memSafeScaleImageWithFactor(String paramString, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: ldc 171
    //   6: aload_0
    //   7: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: iload_1
    //   16: iconst_1
    //   17: if_icmplt +11 -> 28
    //   20: iload_1
    //   21: istore_3
    //   22: iload_1
    //   23: bipush 32
    //   25: if_icmple +88 -> 113
    //   28: new 720	java/lang/IllegalArgumentException
    //   31: dup
    //   32: new 70	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 722
    //   42: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_1
    //   46: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 723	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: astore 4
    //   58: bipush 6
    //   60: getstatic 230	com/tencent/qqmail/utilities/common/CommUtils:TAG	Ljava/lang/String;
    //   63: new 70	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 739
    //   73: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc_w 733
    //   83: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: iload_3
    //   87: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: ldc_w 389
    //   93: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: fload_2
    //   97: invokevirtual 736	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   100: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 238	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   106: invokestatic 377	java/lang/System:gc	()V
    //   109: iload_3
    //   110: iconst_1
    //   111: iadd
    //   112: istore_3
    //   113: iload_3
    //   114: bipush 32
    //   116: if_icmpgt -103 -> 13
    //   119: aload_0
    //   120: iload_3
    //   121: fload_2
    //   122: invokestatic 742	com/tencent/qqmail/utilities/imageextention/ImageUtil:scaleImageWithFactor	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
    //   125: astore 4
    //   127: aload 4
    //   129: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramString	String
    //   0	130	1	paramInt	int
    //   0	130	2	paramFloat	float
    //   21	100	3	i	int
    //   56	1	4	localOutOfMemoryError	OutOfMemoryError
    //   125	3	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   119	127	56	java/lang/OutOfMemoryError
  }
  
  public static Bitmap mendImageOrientation(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    File localFile = new File(paramString);
    long l = 0L;
    if (localFile != null) {
      l = localFile.length();
    }
    int i;
    if (l > 1048576L) {
      i = 4;
    }
    for (;;)
    {
      return fixImageOrientationRecursively(paramBitmap, paramString, i);
      if (l > 524288L) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public static boolean needFixedOrientation(int paramInt)
  {
    boolean bool = true;
    if ((paramInt <= 1) || (paramInt > 8)) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean needFixedOrientation(String paramString)
  {
    return needFixedOrientation(getImageOrientation(null, paramString));
  }
  
  public static Bitmap resizeImage(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    int j = 1;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    if (localByteArrayOutputStream.toByteArray().length / 1024 > 1024)
    {
      localByteArrayOutputStream.reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
    paramBitmap = new BitmapFactory.Options();
    paramBitmap.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(localByteArrayInputStream, null, paramBitmap);
    paramBitmap.inJustDecodeBounds = false;
    int i = paramBitmap.outWidth;
    int k = paramBitmap.outHeight;
    if ((i > k) && (i > paramFloat1)) {
      i = (int)(paramBitmap.outWidth / paramFloat1);
    }
    for (;;)
    {
      if (i <= 0) {
        i = j;
      }
      for (;;)
      {
        paramBitmap.inSampleSize = i;
        localByteArrayInputStream = new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
        paramBitmap = BitmapFactory.decodeStream(localByteArrayInputStream, null, paramBitmap);
        try
        {
          localByteArrayOutputStream.close();
          localByteArrayInputStream.close();
          return paramBitmap;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return paramBitmap;
        }
        if ((i >= k) || (k <= paramFloat2)) {
          break label214;
        }
        i = (int)(paramBitmap.outHeight / paramFloat2);
        break;
      }
      label214:
      i = 1;
    }
  }
  
  public static Bitmap resizeImage(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  public static void saveToGallery(Context paramContext, Bitmap paramBitmap)
  {
    String str = "QQmail_mark_" + System.currentTimeMillis() + ".jpg";
    paramBitmap = MediaStore.Images.Media.insertImage(paramContext.getContentResolver(), paramBitmap, str, "QQmail mark");
    QMLog.log(4, "ImageUtil", "saveToGallery storedUrl = " + paramBitmap);
    if (paramBitmap != null) {
      paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(paramBitmap)));
    }
  }
  
  public static void saveToGallery(Context paramContext, String paramString)
    throws FileNotFoundException
  {
    String str = System.currentTimeMillis() + ".jpg";
    str = MediaStore.Images.Media.insertImage(paramContext.getContentResolver(), paramString, str, "QQmail qrcode");
    Log.d("ImageUtil", "saveToGallery filePath: " + paramString + ", storedUrl:" + str);
    if (str != null) {
      paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(str)));
    }
  }
  
  public static Bitmap scale(Bitmap paramBitmap, float paramFloat)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, paramFloat);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static Bitmap scale(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat1, paramFloat2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static Bitmap scaleImage(String paramString, BitmapFactory.Options paramOptions, float paramFloat)
  {
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
    if (localBitmap == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      int i = localBitmap.getWidth();
      int j = localBitmap.getHeight();
      if ((i <= 0) || (j <= 0)) {
        return null;
      }
      paramString = new DisplayMetrics();
      ((WindowManager)QMApplicationContext.sharedInstance().getSystemService("window")).getDefaultDisplay().getMetrics(paramString);
      if ((i >= paramString.widthPixels * 2) || (j >= paramString.heightPixels * 2)) {
        paramFloat = Math.min(1.0F, Math.min(paramString.widthPixels * 2.0F / i, paramString.heightPixels * 2.0F / j));
      }
      if (Math.abs(paramFloat - 1.0F) < 0.0001D) {
        return localBitmap;
      }
      paramString = new Matrix();
      float f = i * paramFloat;
      paramFloat = j * paramFloat;
      paramString.postScale(f, paramFloat);
      if ((f <= 1.0F) || (paramFloat <= 1.0F)) {
        return null;
      }
      paramOptions = Bitmap.createScaledBitmap(localBitmap, (int)f, (int)paramFloat, true);
      paramString = paramOptions;
    } while (localBitmap == paramOptions);
    localBitmap.recycle();
    return paramOptions;
  }
  
  public static Bitmap scaleImageWithFactor(String paramString, int paramInt, float paramFloat)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      paramInt = localBitmap.getWidth();
      int i = localBitmap.getHeight();
      paramString = new DisplayMetrics();
      ((WindowManager)QMApplicationContext.sharedInstance().getSystemService("window")).getDefaultDisplay().getMetrics(paramString);
      if (Math.abs(paramFloat - 1.0F) < 0.0001D) {
        return localBitmap;
      }
      paramString = new Matrix();
      float f = paramInt * paramFloat;
      paramFloat = i * paramFloat;
      paramString.postScale(f, paramFloat);
      localObject = Bitmap.createScaledBitmap(localBitmap, (int)f, (int)paramFloat, true);
      paramString = (String)localObject;
    } while (localBitmap == localObject);
    localBitmap.recycle();
    return localObject;
  }
  
  /* Error */
  public static boolean writeBitmapToLocation(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: iload 4
    //   8: istore 5
    //   10: aload_0
    //   11: ifnull +24 -> 35
    //   14: iload 4
    //   16: istore 5
    //   18: aload_3
    //   19: ifnull +16 -> 35
    //   22: ldc 171
    //   24: aload_3
    //   25: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +10 -> 38
    //   31: iload 4
    //   33: istore 5
    //   35: iload 5
    //   37: ireturn
    //   38: new 830	java/io/FileOutputStream
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 831	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   46: astore 8
    //   48: aload 8
    //   50: astore 7
    //   52: aload_0
    //   53: aload_1
    //   54: iload_2
    //   55: aload 8
    //   57: invokevirtual 43	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   60: istore 5
    //   62: iload 5
    //   64: istore 4
    //   66: aload 8
    //   68: ifnull +12 -> 80
    //   71: aload 8
    //   73: invokevirtual 832	java/io/FileOutputStream:close	()V
    //   76: iload 5
    //   78: istore 4
    //   80: iload 4
    //   82: istore 5
    //   84: iload 4
    //   86: ifne -51 -> 35
    //   89: aload_3
    //   90: invokestatic 835	com/tencent/qqmail/utilities/fileextention/FileUtil:delFile	(Ljava/lang/String;)Z
    //   93: pop
    //   94: iload 4
    //   96: ireturn
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: astore 7
    //   103: iconst_4
    //   104: ldc 11
    //   106: new 70	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 837
    //   116: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_3
    //   120: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 839
    //   126: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 842	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   133: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 238	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   142: iload 6
    //   144: istore 4
    //   146: aload_0
    //   147: ifnull -67 -> 80
    //   150: aload_0
    //   151: invokevirtual 832	java/io/FileOutputStream:close	()V
    //   154: iload 6
    //   156: istore 4
    //   158: goto -78 -> 80
    //   161: astore_0
    //   162: iload 6
    //   164: istore 4
    //   166: goto -86 -> 80
    //   169: astore_0
    //   170: aconst_null
    //   171: astore 7
    //   173: aload 7
    //   175: ifnull +8 -> 183
    //   178: aload 7
    //   180: invokevirtual 832	java/io/FileOutputStream:close	()V
    //   183: aload_0
    //   184: athrow
    //   185: astore_0
    //   186: iload 5
    //   188: istore 4
    //   190: goto -110 -> 80
    //   193: astore_1
    //   194: goto -11 -> 183
    //   197: astore_0
    //   198: goto -25 -> 173
    //   201: astore_1
    //   202: aload 8
    //   204: astore_0
    //   205: goto -105 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramBitmap	Bitmap
    //   0	208	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	208	2	paramInt	int
    //   0	208	3	paramString	String
    //   4	185	4	bool1	boolean
    //   8	179	5	bool2	boolean
    //   1	162	6	bool3	boolean
    //   50	129	7	localObject	Object
    //   46	157	8	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   38	48	97	java/lang/Exception
    //   150	154	161	java/io/IOException
    //   38	48	169	finally
    //   71	76	185	java/io/IOException
    //   178	183	193	java/io/IOException
    //   52	62	197	finally
    //   103	142	197	finally
    //   52	62	201	java/lang/Exception
  }
  
  public static Bitmap zoomBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramInt1 / i, paramInt2 / j);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.ImageUtil
 * JD-Core Version:    0.7.0.1
 */