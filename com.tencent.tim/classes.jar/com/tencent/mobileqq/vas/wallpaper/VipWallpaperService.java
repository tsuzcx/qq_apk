package com.tencent.mobileqq.vas.wallpaper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.service.wallpaper.WallpaperService;
import android.service.wallpaper.WallpaperService.Engine;
import android.view.SurfaceHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class VipWallpaperService
  extends WallpaperService
{
  private b a = new b(null);
  
  public static c a(Context paramContext, boolean paramBoolean)
  {
    if ((!paramBoolean) || (b.ch(paramContext))) {
      return a(getSharedPreferences(paramContext));
    }
    return new c();
  }
  
  static c a(SharedPreferences paramSharedPreferences)
  {
    return new c(paramSharedPreferences.getString("wallpaper_item_id", ""), paramSharedPreferences.getString("wallpaper_path_img", ""), paramSharedPreferences.getString("wallpaper_path_video", ""));
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void a(Activity paramActivity, c paramc, AtomicBoolean paramAtomicBoolean)
  {
    QLog.i("VipWallpaper", 1, "set wallpaper = " + paramc.toString());
    getSharedPreferences(paramActivity).edit().putString("wallpaper_item_id", paramc.itemId).putString("wallpaper_path_img", paramc.imgPath).putString("wallpaper_path_video", paramc.videoPath).commit();
    if ((paramc.itemId != null) && (!paramc.itemId.equals("0"))) {
      a(paramActivity, paramAtomicBoolean);
    }
  }
  
  private static void a(Activity paramActivity, AtomicBoolean paramAtomicBoolean)
  {
    if (!b.ch(paramActivity))
    {
      localIntent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
      localIntent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(paramActivity, VipWallpaperService.class));
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
      paramActivity.startActivity(localIntent);
      if (paramAtomicBoolean != null) {
        paramAtomicBoolean.set(true);
      }
    }
    while (paramAtomicBoolean == null)
    {
      Intent localIntent;
      return;
    }
    paramAtomicBoolean.set(false);
  }
  
  public static Drawable ba()
  {
    try
    {
      QLog.i("VipWallpaper", 1, "use system wallpaper");
      Drawable localDrawable = ((WallpaperManager)BaseApplicationImpl.getApplication().getSystemService("wallpaper")).getDrawable();
      return localDrawable;
    }
    catch (Exception localException) {}
    return null;
  }
  
  static SharedPreferences getSharedPreferences(Context paramContext)
  {
    return paramContext.getApplicationContext().getSharedPreferences("qqvip_wallpaper", 4);
  }
  
  private static File i(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "vas/wallpaper");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a.fI(getBaseContext());
    QLog.i("VipWallpaper", 1, "onCreate");
  }
  
  public WallpaperService.Engine onCreateEngine()
  {
    return new a(null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.efs();
    QLog.i("VipWallpaper", 1, "onDestroy");
  }
  
  class a
    extends WallpaperService.Engine
  {
    private final WallpaperHelper jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper = new WallpaperHelper();
    
    private a()
    {
      super();
    }
    
    public WallpaperColors onComputeColors()
    {
      return this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper.onComputeColors();
    }
    
    public void onOffsetsChanged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
    {
      super.onOffsetsChanged(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2);
    }
    
    public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onSurfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper.onSurfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    }
    
    public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      super.onSurfaceCreated(paramSurfaceHolder);
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper.a(VipWallpaperService.this, paramSurfaceHolder);
    }
    
    public void onSurfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      super.onSurfaceDestroyed(paramSurfaceHolder);
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper.onSurfaceDestroyed();
    }
    
    public void onSurfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
    {
      super.onSurfaceRedrawNeeded(paramSurfaceHolder);
    }
    
    public void onVisibilityChanged(boolean paramBoolean)
    {
      super.onVisibilityChanged(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper.onVisibilityChanged(paramBoolean);
    }
  }
  
  static class b
  {
    private FileOutputStream o;
    
    /* Error */
    static boolean ch(Context paramContext)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: iconst_0
      //   3: istore_2
      //   4: aload_0
      //   5: invokestatic 26	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$b:k	(Landroid/content/Context;)Ljava/io/File;
      //   8: astore_0
      //   9: aload_0
      //   10: invokevirtual 32	java/io/File:exists	()Z
      //   13: istore_3
      //   14: iload_3
      //   15: ifne +24 -> 39
      //   18: iconst_0
      //   19: ifeq +11 -> 30
      //   22: new 34	java/lang/NullPointerException
      //   25: dup
      //   26: invokespecial 35	java/lang/NullPointerException:<init>	()V
      //   29: athrow
      //   30: iload_2
      //   31: ireturn
      //   32: astore_0
      //   33: aload_0
      //   34: invokevirtual 38	java/io/IOException:printStackTrace	()V
      //   37: iconst_0
      //   38: ireturn
      //   39: new 40	java/io/FileOutputStream
      //   42: dup
      //   43: aload_0
      //   44: invokespecial 43	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   47: astore 4
      //   49: aload 4
      //   51: astore_0
      //   52: aload 4
      //   54: invokevirtual 47	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
      //   57: invokevirtual 53	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
      //   60: astore 5
      //   62: aload 5
      //   64: ifnull +32 -> 96
      //   67: aload 4
      //   69: astore_0
      //   70: aload 5
      //   72: invokevirtual 58	java/nio/channels/FileLock:release	()V
      //   75: iload_1
      //   76: istore_2
      //   77: aload 4
      //   79: ifnull -49 -> 30
      //   82: aload 4
      //   84: invokevirtual 61	java/io/FileOutputStream:close	()V
      //   87: iload_1
      //   88: ireturn
      //   89: astore_0
      //   90: aload_0
      //   91: invokevirtual 38	java/io/IOException:printStackTrace	()V
      //   94: iload_1
      //   95: ireturn
      //   96: iconst_1
      //   97: istore_1
      //   98: goto -23 -> 75
      //   101: astore 5
      //   103: aload 4
      //   105: astore_0
      //   106: aload 5
      //   108: invokevirtual 38	java/io/IOException:printStackTrace	()V
      //   111: goto -36 -> 75
      //   114: astore 5
      //   116: aload 4
      //   118: astore_0
      //   119: aload 5
      //   121: invokevirtual 62	java/io/FileNotFoundException:printStackTrace	()V
      //   124: aload 4
      //   126: ifnull -96 -> 30
      //   129: aload 4
      //   131: invokevirtual 61	java/io/FileOutputStream:close	()V
      //   134: iconst_0
      //   135: ireturn
      //   136: astore_0
      //   137: aload_0
      //   138: invokevirtual 38	java/io/IOException:printStackTrace	()V
      //   141: iconst_0
      //   142: ireturn
      //   143: astore 4
      //   145: aconst_null
      //   146: astore_0
      //   147: aload_0
      //   148: ifnull +7 -> 155
      //   151: aload_0
      //   152: invokevirtual 61	java/io/FileOutputStream:close	()V
      //   155: aload 4
      //   157: athrow
      //   158: astore_0
      //   159: aload_0
      //   160: invokevirtual 38	java/io/IOException:printStackTrace	()V
      //   163: goto -8 -> 155
      //   166: astore 4
      //   168: goto -21 -> 147
      //   171: astore 5
      //   173: aconst_null
      //   174: astore 4
      //   176: goto -60 -> 116
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	179	0	paramContext	Context
      //   1	97	1	bool1	boolean
      //   3	74	2	bool2	boolean
      //   13	2	3	bool3	boolean
      //   47	83	4	localFileOutputStream	FileOutputStream
      //   143	13	4	localObject1	Object
      //   166	1	4	localObject2	Object
      //   174	1	4	localObject3	Object
      //   60	11	5	localFileLock	java.nio.channels.FileLock
      //   101	6	5	localIOException	IOException
      //   114	6	5	localFileNotFoundException1	java.io.FileNotFoundException
      //   171	1	5	localFileNotFoundException2	java.io.FileNotFoundException
      // Exception table:
      //   from	to	target	type
      //   22	30	32	java/io/IOException
      //   82	87	89	java/io/IOException
      //   52	62	101	java/io/IOException
      //   70	75	101	java/io/IOException
      //   52	62	114	java/io/FileNotFoundException
      //   70	75	114	java/io/FileNotFoundException
      //   106	111	114	java/io/FileNotFoundException
      //   129	134	136	java/io/IOException
      //   4	14	143	finally
      //   39	49	143	finally
      //   151	155	158	java/io/IOException
      //   52	62	166	finally
      //   70	75	166	finally
      //   106	111	166	finally
      //   119	124	166	finally
      //   4	14	171	java/io/FileNotFoundException
      //   39	49	171	java/io/FileNotFoundException
    }
    
    private static File k(Context paramContext)
    {
      return new File(VipWallpaperService.j(paramContext), ".statuslock");
    }
    
    void efs()
    {
      if (this.o != null) {}
      try
      {
        this.o.close();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    
    /* Error */
    void fI(Context paramContext)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_1
      //   3: invokestatic 26	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$b:k	(Landroid/content/Context;)Ljava/io/File;
      //   6: astore_1
      //   7: aload_1
      //   8: invokevirtual 32	java/io/File:exists	()Z
      //   11: ifne +8 -> 19
      //   14: aload_1
      //   15: invokevirtual 78	java/io/File:createNewFile	()Z
      //   18: pop
      //   19: aload_0
      //   20: new 40	java/io/FileOutputStream
      //   23: dup
      //   24: aload_1
      //   25: invokespecial 43	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   28: putfield 73	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$b:o	Ljava/io/FileOutputStream;
      //   31: aload_0
      //   32: getfield 73	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$b:o	Ljava/io/FileOutputStream;
      //   35: invokevirtual 47	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
      //   38: invokevirtual 53	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
      //   41: astore_1
      //   42: aload_1
      //   43: ifnull +5 -> 48
      //   46: iconst_1
      //   47: istore_2
      //   48: iload_2
      //   49: ifne +43 -> 92
      //   52: aload_0
      //   53: getfield 73	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$b:o	Ljava/io/FileOutputStream;
      //   56: invokevirtual 61	java/io/FileOutputStream:close	()V
      //   59: aload_0
      //   60: aconst_null
      //   61: putfield 73	com/tencent/mobileqq/vas/wallpaper/VipWallpaperService$b:o	Ljava/io/FileOutputStream;
      //   64: return
      //   65: astore_1
      //   66: aload_1
      //   67: invokevirtual 38	java/io/IOException:printStackTrace	()V
      //   70: goto -22 -> 48
      //   73: astore_1
      //   74: aload_1
      //   75: invokevirtual 62	java/io/FileNotFoundException:printStackTrace	()V
      //   78: return
      //   79: astore_1
      //   80: aload_1
      //   81: invokevirtual 38	java/io/IOException:printStackTrace	()V
      //   84: goto -25 -> 59
      //   87: astore_1
      //   88: aload_1
      //   89: invokevirtual 38	java/io/IOException:printStackTrace	()V
      //   92: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	93	0	this	b
      //   0	93	1	paramContext	Context
      //   1	48	2	i	int
      // Exception table:
      //   from	to	target	type
      //   31	42	65	java/io/IOException
      //   2	19	73	java/io/FileNotFoundException
      //   19	31	73	java/io/FileNotFoundException
      //   31	42	73	java/io/FileNotFoundException
      //   52	59	73	java/io/FileNotFoundException
      //   59	64	73	java/io/FileNotFoundException
      //   66	70	73	java/io/FileNotFoundException
      //   80	84	73	java/io/FileNotFoundException
      //   52	59	79	java/io/IOException
      //   2	19	87	java/io/IOException
      //   19	31	87	java/io/IOException
      //   59	64	87	java/io/IOException
      //   66	70	87	java/io/IOException
      //   80	84	87	java/io/IOException
    }
  }
  
  public static class c
  {
    public final String imgPath;
    public final String itemId;
    public final String videoPath;
    
    public c()
    {
      this.itemId = "0";
      this.imgPath = "";
      this.videoPath = "";
    }
    
    public c(String paramString1, String paramString2, String paramString3)
    {
      this.itemId = paramString1;
      this.imgPath = paramString2;
      this.videoPath = paramString3;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (c)paramObject;
      return this.imgPath.equals(paramObject.imgPath);
    }
    
    public String toString()
    {
      return "WallpaperConfig{itemId='" + this.itemId + '\'' + ", imgPath='" + this.imgPath + '\'' + ", videoPath='" + this.videoPath + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.VipWallpaperService
 * JD-Core Version:    0.7.0.1
 */