package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.map.sdk.engine.jni.models.IconImageInfo;
import com.tencent.tencentmap.io.QStorageManager;
import java.io.Closeable;
import java.io.InputStream;

public final class pq
  implements lz
{
  private Context a;
  private final float b;
  private String c;
  
  public pq(Context paramContext, String paramString)
  {
    this.a = paramContext.getApplicationContext();
    this.b = pz.a(this.a);
    this.c = paramString;
  }
  
  private Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject2 = on.b(QStorageManager.getInstance(this.a).getConfigPath(this.c) + paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = on.b(QStorageManager.getInstance(this.a).getAssetsLoadPath(this.c) + paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = on.b(QStorageManager.getInstance(this.a).getAssetsDynamicPath() + paramString);
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (gd.a == null) {
        break label209;
      }
      localObject1 = gd.a(this.a, gd.a + paramString);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = gd.a(this.a, "tencentmap/mapsdk_vector/", paramString);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = gd.a(this.a, paramString);
      }
      if (localObject1 == null) {
        break;
      }
      paramString = BitmapFactory.decodeStream((InputStream)localObject1);
      on.a((Closeable)localObject1);
      return paramString;
      label209:
      localObject1 = localObject2;
      if (gd.b != null) {
        localObject1 = on.b(gd.b + paramString);
      }
    }
  }
  
  public final void a(String paramString, IconImageInfo paramIconImageInfo)
  {
    Bitmap localBitmap = oi.a(paramString);
    if (localBitmap == null)
    {
      localBitmap = fy.b.a(paramString);
      if (this.a != null) {
        break label41;
      }
    }
    label41:
    while (localBitmap != null)
    {
      return;
      paramIconImageInfo.bitmap = localBitmap;
      paramIconImageInfo.scale = this.b;
      break;
    }
    try
    {
      if ((paramString.startsWith("poi_icon")) || (paramString.startsWith("mapcfg_"))) {
        localBitmap = a(nl.b(paramString) + "@2x.png");
      }
      if (localBitmap != null)
      {
        paramIconImageInfo.bitmap = localBitmap;
        paramIconImageInfo.scale = 2.0F;
        return;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return;
    }
    paramIconImageInfo.bitmap = a(paramString);
    if (paramString.equals("compass.png"))
    {
      paramIconImageInfo.scale = this.b;
      return;
    }
    paramIconImageInfo.scale = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pq
 * JD-Core Version:    0.7.0.1
 */