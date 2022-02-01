package com.tencent.mobileqq.vas.wallpaper;

import android.app.WallpaperColors;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.SurfaceHolder;
import aqtb.a;
import aqtb.b;
import aqte;
import aqth;
import aqti;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public final class WallpaperHelper
{
  private aqtb.b jdField_a_of_type_Aqtb$b;
  private aqte jdField_a_of_type_Aqte;
  private VipWallpaperService.c jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$c;
  private ReTryRunnable jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable = new ReTryRunnable(this);
  private boolean cVQ;
  private boolean isReleased;
  
  /* Error */
  private aqtb.a a(aqtb.b paramb, VipWallpaperService.c paramc)
  {
    // Byte code:
    //   0: new 32	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: getfield 38	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$c:imgPath	Ljava/lang/String;
    //   8: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 5
    //   13: ldc 43
    //   15: iconst_1
    //   16: new 45	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   23: ldc 48
    //   25: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 56	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$c:toString	()Ljava/lang/String;
    //   32: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 58
    //   37: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 5
    //   42: invokevirtual 62	java/io/File:exists	()Z
    //   45: invokevirtual 65	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_2
    //   55: getfield 75	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$c:itemId	Ljava/lang/String;
    //   58: ldc 77
    //   60: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifne +301 -> 364
    //   66: invokestatic 89	aese:d	()Laesd;
    //   69: invokevirtual 94	aesd:ahv	()Z
    //   72: ifeq +286 -> 358
    //   75: aload_1
    //   76: invokeinterface 99 1 0
    //   81: ifeq +277 -> 358
    //   84: invokestatic 104	aqsj:a	()Laqsj;
    //   87: aload_2
    //   88: getfield 107	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$c:videoPath	Ljava/lang/String;
    //   91: invokevirtual 111	aqsj:r	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   94: astore 4
    //   96: aload 4
    //   98: astore_3
    //   99: aload 4
    //   101: ifnonnull +49 -> 150
    //   104: aload 4
    //   106: astore_3
    //   107: invokestatic 89	aese:d	()Laesd;
    //   110: invokevirtual 114	aesd:ahx	()Z
    //   113: ifeq +37 -> 150
    //   116: aload 4
    //   118: astore_3
    //   119: aload_1
    //   120: invokeinterface 99 1 0
    //   125: ifeq +25 -> 150
    //   128: invokestatic 104	aqsj:a	()Laqsj;
    //   131: aload_2
    //   132: getfield 38	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$c:imgPath	Ljava/lang/String;
    //   135: new 116	android/os/Handler
    //   138: dup
    //   139: invokestatic 122	com/tencent/mobileqq/app/ThreadManagerV2:getFileThreadLooper	()Landroid/os/Looper;
    //   142: invokespecial 125	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   145: iconst_0
    //   146: invokevirtual 128	aqsj:a	(Ljava/lang/String;Landroid/os/Handler;Z)Landroid/graphics/drawable/Drawable;
    //   149: astore_3
    //   150: aload_3
    //   151: ifnonnull +202 -> 353
    //   154: aload 5
    //   156: invokestatic 134	com/tencent/mobileqq/model/ChatBackgroundManager:isApngFile	(Ljava/io/File;)Z
    //   159: ifeq +194 -> 353
    //   162: aload_0
    //   163: getfield 136	com/tencent/mobileqq/vas/wallpaper/WallpaperHelper:cVQ	Z
    //   166: ifne +19 -> 185
    //   169: invokestatic 141	aqqv:a	()Laqqv;
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 144	aqqv:isLoaded	()Z
    //   177: ifeq +114 -> 291
    //   180: aload_0
    //   181: iconst_1
    //   182: putfield 136	com/tencent/mobileqq/vas/wallpaper/WallpaperHelper:cVQ	Z
    //   185: aload_0
    //   186: getfield 136	com/tencent/mobileqq/vas/wallpaper/WallpaperHelper:cVQ	Z
    //   189: ifeq +164 -> 353
    //   192: new 146	com/tencent/image/ApngDrawable
    //   195: dup
    //   196: aload 5
    //   198: aconst_null
    //   199: invokespecial 149	com/tencent/image/ApngDrawable:<init>	(Ljava/io/File;Landroid/content/res/Resources;)V
    //   202: astore_1
    //   203: aload_1
    //   204: checkcast 146	com/tencent/image/ApngDrawable
    //   207: invokevirtual 153	com/tencent/image/ApngDrawable:getImage	()Lcom/tencent/image/ApngImage;
    //   210: iconst_0
    //   211: invokevirtual 159	com/tencent/image/ApngImage:setSupportGlobalPasued	(Z)V
    //   214: aload_1
    //   215: ifnonnull +135 -> 350
    //   218: aload_2
    //   219: getfield 38	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$c:imgPath	Ljava/lang/String;
    //   222: invokestatic 165	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   225: astore_2
    //   226: aload_2
    //   227: ifnull +123 -> 350
    //   230: new 167	android/graphics/drawable/BitmapDrawable
    //   233: dup
    //   234: aload_2
    //   235: invokespecial 170	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   238: astore_1
    //   239: aload_1
    //   240: ifnonnull +107 -> 347
    //   243: invokestatic 176	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService:ba	()Landroid/graphics/drawable/Drawable;
    //   246: astore_1
    //   247: aload_1
    //   248: ifnull +85 -> 333
    //   251: ldc 43
    //   253: iconst_1
    //   254: new 45	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   261: ldc 48
    //   263: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 180	java/lang/Object:getClass	()Ljava/lang/Class;
    //   270: invokevirtual 185	java/lang/Class:getName	()Ljava/lang/String;
    //   273: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: new 187	aqtc
    //   285: dup
    //   286: aload_1
    //   287: invokespecial 190	aqtc:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   290: areturn
    //   291: aload_1
    //   292: invokevirtual 193	aqqv:Qu	()Z
    //   295: ifeq -110 -> 185
    //   298: aload_0
    //   299: aload_1
    //   300: invokevirtual 196	aqqv:aF	()Z
    //   303: putfield 136	com/tencent/mobileqq/vas/wallpaper/WallpaperHelper:cVQ	Z
    //   306: goto -121 -> 185
    //   309: astore 4
    //   311: aload_3
    //   312: astore_1
    //   313: aload 4
    //   315: astore_3
    //   316: aload_3
    //   317: invokevirtual 199	java/lang/Throwable:printStackTrace	()V
    //   320: goto -106 -> 214
    //   323: astore_2
    //   324: aload_2
    //   325: invokevirtual 199	java/lang/Throwable:printStackTrace	()V
    //   328: aconst_null
    //   329: astore_2
    //   330: goto -104 -> 226
    //   333: ldc 43
    //   335: iconst_1
    //   336: ldc 201
    //   338: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aconst_null
    //   342: areturn
    //   343: astore_3
    //   344: goto -28 -> 316
    //   347: goto -100 -> 247
    //   350: goto -111 -> 239
    //   353: aload_3
    //   354: astore_1
    //   355: goto -141 -> 214
    //   358: aconst_null
    //   359: astore 4
    //   361: goto -265 -> 96
    //   364: aconst_null
    //   365: astore_1
    //   366: goto -127 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	WallpaperHelper
    //   0	369	1	paramb	aqtb.b
    //   0	369	2	paramc	VipWallpaperService.c
    //   98	219	3	localObject1	Object
    //   343	11	3	localThrowable1	java.lang.Throwable
    //   94	23	4	localDrawable	android.graphics.drawable.Drawable
    //   309	5	4	localThrowable2	java.lang.Throwable
    //   359	1	4	localObject2	Object
    //   11	186	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   192	203	309	java/lang/Throwable
    //   218	226	323	java/lang/Throwable
    //   203	214	343	java/lang/Throwable
  }
  
  private aqtb.b a(SurfaceHolder paramSurfaceHolder)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return new aqti(paramSurfaceHolder);
    }
    return new aqth(paramSurfaceHolder);
  }
  
  private void a(VipWallpaperService.c paramc, boolean paramBoolean)
  {
    if (this.isReleased) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.d = null;
        }
      } while (paramc.equals(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$c));
      eft();
      aqtb.a locala = a(this.jdField_a_of_type_Aqtb$b, paramc);
      if (locala != null)
      {
        this.jdField_a_of_type_Aqte = new aqte(locala, this.jdField_a_of_type_Aqtb$b);
        this.jdField_a_of_type_Aqte.start();
        this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$c = paramc;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$c = null;
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.a(paramc);
    } while (!paramBoolean);
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable, 3000L);
  }
  
  private void eft()
  {
    if (this.jdField_a_of_type_Aqte != null)
    {
      this.jdField_a_of_type_Aqte.release();
      this.jdField_a_of_type_Aqte = null;
    }
  }
  
  protected void a(Context paramContext, SurfaceHolder paramSurfaceHolder)
  {
    this.isReleased = false;
    this.jdField_a_of_type_Aqtb$b = a(paramSurfaceHolder);
    paramContext = VipWallpaperService.getSharedPreferences(paramContext);
    paramContext.registerOnSharedPreferenceChangeListener(new a(this));
    a(VipWallpaperService.a(paramContext), true);
  }
  
  protected WallpaperColors onComputeColors()
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      Color localColor = Color.valueOf(Color.parseColor("#ff000000"));
      QLog.i("VipWallpaper", 1, "onComputeColors " + localColor.toString());
      return new WallpaperColors(localColor, localColor, localColor);
    }
    return null;
  }
  
  protected void onSurfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Aqte != null) && (!this.isReleased)) {
      this.jdField_a_of_type_Aqte.onSizeChange(paramInt2, paramInt3);
    }
  }
  
  protected void onSurfaceDestroyed()
  {
    eft();
    this.isReleased = true;
  }
  
  protected void onVisibilityChanged(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aqte == null)
    {
      if (paramBoolean)
      {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
        ThreadManagerV2.getUIHandlerV2().post(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
      }
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aqte.resume();
      return;
    }
    this.jdField_a_of_type_Aqte.pause();
  }
  
  static class ReTryRunnable
    implements Runnable
  {
    VipWallpaperService.c d;
    WeakReference<WallpaperHelper> ix;
    
    public ReTryRunnable(WallpaperHelper paramWallpaperHelper)
    {
      this.ix = new WeakReference(paramWallpaperHelper);
    }
    
    public void a(VipWallpaperService.c paramc)
    {
      this.d = paramc;
    }
    
    public void run()
    {
      WallpaperHelper localWallpaperHelper = (WallpaperHelper)this.ix.get();
      if ((localWallpaperHelper != null) && (this.d != null)) {
        WallpaperHelper.a(localWallpaperHelper, this.d, false);
      }
    }
  }
  
  static class a
    implements SharedPreferences.OnSharedPreferenceChangeListener
  {
    private VipWallpaperService.c b;
    private final WeakReference<WallpaperHelper> weakReference;
    
    a(WallpaperHelper paramWallpaperHelper)
    {
      this.weakReference = new WeakReference(paramWallpaperHelper);
    }
    
    public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
    {
      paramString = (WallpaperHelper)this.weakReference.get();
      if (paramString != null)
      {
        paramSharedPreferences = VipWallpaperService.a(paramSharedPreferences);
        if ((this.b == null) || (!this.b.equals(paramSharedPreferences)))
        {
          this.b = paramSharedPreferences;
          ThreadManagerV2.getUIHandlerV2().post(new WallpaperHelper.ConfigChangeListener.1(this, paramString, paramSharedPreferences));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper
 * JD-Core Version:    0.7.0.1
 */