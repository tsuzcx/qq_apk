package com.tencent.mobileqq.dinifly.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImageAssetManager
{
  private static final Object bitmapHashLock = new Object();
  private final Context context;
  @Nullable
  private ImageAssetDelegate delegate;
  private final Map<String, LottieImageAsset> imageAssets;
  private String imagesFolder;
  
  public ImageAssetManager(Drawable.Callback paramCallback, String paramString, ImageAssetDelegate paramImageAssetDelegate, Map<String, LottieImageAsset> paramMap)
  {
    this.imagesFolder = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (this.imagesFolder.charAt(this.imagesFolder.length() - 1) != '/')) {
      this.imagesFolder += '/';
    }
    if (!(paramCallback instanceof View))
    {
      Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
      this.imageAssets = new HashMap();
      this.context = null;
      return;
    }
    this.context = ((View)paramCallback).getContext();
    this.imageAssets = paramMap;
    setDelegate(paramImageAssetDelegate);
  }
  
  private Bitmap putBitmap(String paramString, @Nullable Bitmap paramBitmap)
  {
    synchronized (bitmapHashLock)
    {
      ((LottieImageAsset)this.imageAssets.get(paramString)).setBitmap(paramBitmap);
      return paramBitmap;
    }
  }
  
  @Nullable
  public Bitmap bitmapForId(String paramString)
  {
    Object localObject1 = (LottieImageAsset)this.imageAssets.get(paramString);
    if (localObject1 == null) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject2 = ((LottieImageAsset)localObject1).getBitmap();
      if (localObject2 != null) {
        return localObject2;
      }
      if (this.delegate == null) {
        break;
      }
      if (((LottieImageAsset)localObject1).hasCache()) {
        return this.delegate.fetchBitmap((LottieImageAsset)localObject1);
      }
      localObject2 = this.delegate.fetchBitmap((LottieImageAsset)localObject1);
      localObject1 = localObject2;
    } while (localObject2 == null);
    putBitmap(paramString, (Bitmap)localObject2);
    return localObject2;
    Object localObject2 = ((LottieImageAsset)localObject1).getFileName();
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inScaled = true;
    ((BitmapFactory.Options)localObject1).inDensity = 320;
    if ((((String)localObject2).startsWith("data:")) && (((String)localObject2).indexOf("base64,") > 0)) {
      try
      {
        localObject2 = Base64.decode(((String)localObject2).substring(((String)localObject2).indexOf(',') + 1), 0);
        return putBitmap(paramString, BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length, (BitmapFactory.Options)localObject1));
      }
      catch (IllegalArgumentException paramString)
      {
        Log.w("LOTTIE", "data URL did not have correct base64 format.", paramString);
        return null;
      }
    }
    try
    {
      if (TextUtils.isEmpty(this.imagesFolder)) {
        throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
      }
    }
    catch (IOException paramString)
    {
      Log.w("LOTTIE", "Unable to open asset.", paramString);
      return null;
    }
    localObject2 = this.context.getAssets().open(this.imagesFolder + (String)localObject2);
    localObject1 = BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject1);
    if (localObject2 != null) {}
    try
    {
      ((InputStream)localObject2).close();
      return putBitmap(paramString, (Bitmap)localObject1);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public boolean hasSameContext(Context paramContext)
  {
    return ((paramContext == null) && (this.context == null)) || (this.context.equals(paramContext));
  }
  
  public void recycleBitmaps()
  {
    Iterator localIterator = this.imageAssets.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((LottieImageAsset)localEntry.getValue()).getBitmap() != null) {
        ((LottieImageAsset)localEntry.getValue()).getBitmap().recycle();
      }
      localIterator.remove();
    }
  }
  
  public void setDelegate(@Nullable ImageAssetDelegate paramImageAssetDelegate)
  {
    this.delegate = paramImageAssetDelegate;
  }
  
  @Nullable
  public Bitmap updateBitmap(String paramString, @Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      paramString = (LottieImageAsset)this.imageAssets.get(paramString);
      paramBitmap = paramString.getBitmap();
      paramString.setBitmap(null);
      return paramBitmap;
    }
    Bitmap localBitmap = ((LottieImageAsset)this.imageAssets.get(paramString)).getBitmap();
    putBitmap(paramString, paramBitmap);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.manager.ImageAssetManager
 * JD-Core Version:    0.7.0.1
 */