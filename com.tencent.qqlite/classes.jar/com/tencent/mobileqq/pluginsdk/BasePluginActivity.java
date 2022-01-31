package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import mqq.app.BaseActivity;

public class BasePluginActivity
  extends BaseActivity
  implements IPluginActivity, SkinnableActivityProcesser.Callback, PluginInterfaceHelper.OnPluginInterfaceLoadedListener
{
  private static Boolean sIsLiquid = null;
  private static boolean sSkilEngineInit = false;
  private Activity mActivity = null;
  protected String mApkFilePath = "";
  private PluginConfig mConfig = new PluginConfig();
  public View mContentView = null;
  private Context mContext = null;
  private ClassLoader mDexClassLoader = null;
  boolean mFinished = false;
  protected boolean mIsRunInPlugin = false;
  protected boolean mIsTab = false;
  protected Activity mOutActivity = null;
  protected PackageInfo mPackageInfo;
  protected String mPluginID;
  protected boolean mUseQqResources;
  protected boolean mUseSkinEngine = false;
  View mViewShadow;
  SkinnableActivityProcesser processer;
  
  public static final Bitmap getDrawableBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
    } while (!(paramDrawable instanceof SkinnableBitmapDrawable));
    return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
  }
  
  private void initIsLiquid()
  {
    if (sIsLiquid == null) {}
    try
    {
      Build.VERSION.class.getField("LIQUID");
      sIsLiquid = Boolean.valueOf(true);
      return;
    }
    catch (Exception localException)
    {
      sIsLiquid = Boolean.valueOf(false);
    }
  }
  
  private void setNightMaskVisible(boolean paramBoolean)
  {
    int i = 0;
    Object localObject;
    if (this.mViewShadow != null)
    {
      localObject = this.mViewShadow;
      if (paramBoolean) {
        ((View)localObject).setVisibility(i);
      }
    }
    do
    {
      do
      {
        return;
        i = 8;
        break;
      } while (paramBoolean != true);
      localObject = new ImageView(this);
      ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
      ((ImageView)localObject).setPadding(0, this.mConfig.titleHeight, 0, 0);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.mViewShadow = ((View)localObject);
    } while (this.mViewShadow == null);
    getWindow().addContentView(this.mViewShadow, this.mViewShadow.getLayoutParams());
  }
  
  public boolean IDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public void IFinish()
  {
    finish();
  }
  
  public View IGetContentView()
  {
    return this.mContentView;
  }
  
  public Handler IGetInHandler()
  {
    return null;
  }
  
  public Resources IGetResource()
  {
    if (this.mContext != null) {
      return this.mContext.getResources();
    }
    return this.mActivity.getResources();
  }
  
  /* Error */
  public void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: getstatic 214	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   3: ifeq +47 -> 50
    //   6: ldc 216
    //   8: new 218	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   15: ldc 221
    //   17: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 227
    //   26: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 230	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: ldc 227
    //   36: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 7
    //   41: invokevirtual 230	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 238	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 55	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mIsRunInPlugin	Z
    //   55: aload_0
    //   56: aload 4
    //   58: putfield 73	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mDexClassLoader	Ljava/lang/ClassLoader;
    //   61: aload_0
    //   62: aload_3
    //   63: putfield 57	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mOutActivity	Landroid/app/Activity;
    //   66: aload_0
    //   67: aload_1
    //   68: putfield 240	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginID	Ljava/lang/String;
    //   71: aload_0
    //   72: aload_2
    //   73: putfield 69	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mApkFilePath	Ljava/lang/String;
    //   76: aload_0
    //   77: aload 5
    //   79: putfield 242	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPackageInfo	Landroid/content/pm/PackageInfo;
    //   82: aload_0
    //   83: iload 7
    //   85: putfield 244	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mUseQqResources	Z
    //   88: aload_0
    //   89: getfield 59	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   92: ifnonnull +33 -> 125
    //   95: iload 7
    //   97: ifeq +335 -> 432
    //   100: aload_0
    //   101: new 246	com/tencent/mobileqq/pluginsdk/PluginContext
    //   104: dup
    //   105: aload_3
    //   106: iconst_0
    //   107: aload_0
    //   108: getfield 69	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mApkFilePath	Ljava/lang/String;
    //   111: aload_0
    //   112: getfield 73	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mDexClassLoader	Ljava/lang/ClassLoader;
    //   115: aload_3
    //   116: invokevirtual 201	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   119: invokespecial 249	com/tencent/mobileqq/pluginsdk/PluginContext:<init>	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/ClassLoader;Landroid/content/res/Resources;)V
    //   122: putfield 59	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 59	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   130: invokevirtual 252	com/tencent/mobileqq/pluginsdk/BasePluginActivity:attachBaseContext	(Landroid/content/Context;)V
    //   133: aload_0
    //   134: iload 6
    //   136: putfield 71	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mUseSkinEngine	Z
    //   139: getstatic 47	com/tencent/mobileqq/pluginsdk/BasePluginActivity:sSkilEngineInit	Z
    //   142: ifne +289 -> 431
    //   145: iload 6
    //   147: ifeq +284 -> 431
    //   150: iconst_1
    //   151: ifeq +280 -> 431
    //   154: aload_0
    //   155: getfield 244	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mUseQqResources	Z
    //   158: ifne +328 -> 486
    //   161: new 218	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   168: aload 5
    //   170: getfield 257	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   173: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 259
    //   179: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_1
    //   188: aload 4
    //   190: new 218	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   197: aload_3
    //   198: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 261
    //   204: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokevirtual 267	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   213: astore_2
    //   214: aload_2
    //   215: astore_1
    //   216: aconst_null
    //   217: astore_2
    //   218: aload 4
    //   220: new 218	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   227: aload_3
    //   228: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 269
    //   234: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 267	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   243: astore_3
    //   244: aload_3
    //   245: astore_2
    //   246: iconst_0
    //   247: istore 10
    //   249: iload 10
    //   251: istore 8
    //   253: aload_1
    //   254: ifnull +77 -> 331
    //   257: aload_1
    //   258: invokevirtual 273	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   261: astore_3
    //   262: aload_3
    //   263: arraylength
    //   264: istore 11
    //   266: iconst_0
    //   267: istore 9
    //   269: iload 10
    //   271: istore 8
    //   273: iload 9
    //   275: iload 11
    //   277: if_icmpge +54 -> 331
    //   280: aload_3
    //   281: iload 9
    //   283: aaload
    //   284: astore 4
    //   286: aload 4
    //   288: invokevirtual 279	java/lang/reflect/Field:getModifiers	()I
    //   291: bipush 25
    //   293: iand
    //   294: bipush 25
    //   296: if_icmpne +162 -> 458
    //   299: aload 4
    //   301: invokevirtual 283	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   304: getstatic 289	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   307: invokevirtual 295	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +148 -> 458
    //   313: aload 4
    //   315: aconst_null
    //   316: invokevirtual 299	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   319: istore 8
    //   321: iload 8
    //   323: bipush 16
    //   325: ishr
    //   326: bipush 16
    //   328: ishl
    //   329: istore 8
    //   331: iconst_0
    //   332: istore 11
    //   334: iload 11
    //   336: istore 10
    //   338: aload_2
    //   339: ifnull +77 -> 416
    //   342: aload_2
    //   343: invokevirtual 273	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   346: astore_3
    //   347: aload_3
    //   348: arraylength
    //   349: istore 12
    //   351: iconst_0
    //   352: istore 9
    //   354: iload 11
    //   356: istore 10
    //   358: iload 9
    //   360: iload 12
    //   362: if_icmpge +54 -> 416
    //   365: aload_3
    //   366: iload 9
    //   368: aaload
    //   369: astore 4
    //   371: aload 4
    //   373: invokevirtual 279	java/lang/reflect/Field:getModifiers	()I
    //   376: bipush 25
    //   378: iand
    //   379: bipush 25
    //   381: if_icmpne +88 -> 469
    //   384: aload 4
    //   386: invokevirtual 283	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   389: getstatic 289	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   392: invokevirtual 295	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   395: ifeq +74 -> 469
    //   398: aload 4
    //   400: aconst_null
    //   401: invokevirtual 299	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   404: istore 10
    //   406: iload 10
    //   408: bipush 16
    //   410: ishr
    //   411: bipush 16
    //   413: ishl
    //   414: istore 10
    //   416: aload_0
    //   417: aload_1
    //   418: iload 8
    //   420: aload_2
    //   421: iload 10
    //   423: aconst_null
    //   424: invokestatic 305	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   427: iconst_1
    //   428: putstatic 47	com/tencent/mobileqq/pluginsdk/BasePluginActivity:sSkilEngineInit	Z
    //   431: return
    //   432: aload_0
    //   433: new 246	com/tencent/mobileqq/pluginsdk/PluginContext
    //   436: dup
    //   437: aload_3
    //   438: iconst_0
    //   439: aload_0
    //   440: getfield 69	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mApkFilePath	Ljava/lang/String;
    //   443: aload_0
    //   444: getfield 73	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mDexClassLoader	Ljava/lang/ClassLoader;
    //   447: invokespecial 308	com/tencent/mobileqq/pluginsdk/PluginContext:<init>	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/ClassLoader;)V
    //   450: putfield 59	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   453: goto -328 -> 125
    //   456: astore 4
    //   458: iload 9
    //   460: iconst_1
    //   461: iadd
    //   462: istore 9
    //   464: goto -195 -> 269
    //   467: astore 4
    //   469: iload 9
    //   471: iconst_1
    //   472: iadd
    //   473: istore 9
    //   475: goto -121 -> 354
    //   478: astore_1
    //   479: invokestatic 312	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   482: invokevirtual 315	com/tencent/theme/SkinEngine:unInit	()V
    //   485: return
    //   486: ldc_w 317
    //   489: invokestatic 320	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   492: ldc_w 322
    //   495: iconst_1
    //   496: anewarray 96	java/lang/Class
    //   499: dup
    //   500: iconst_0
    //   501: ldc 195
    //   503: aastore
    //   504: invokevirtual 326	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   507: invokestatic 332	mqq/app/MobileQQ:getMobileQQ	()Lmqq/app/MobileQQ;
    //   510: iconst_1
    //   511: anewarray 291	java/lang/Object
    //   514: dup
    //   515: iconst_0
    //   516: aload_0
    //   517: aastore
    //   518: invokevirtual 338	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   521: pop
    //   522: iconst_1
    //   523: putstatic 47	com/tencent/mobileqq/pluginsdk/BasePluginActivity:sSkilEngineInit	Z
    //   526: return
    //   527: astore_1
    //   528: aload_1
    //   529: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   532: return
    //   533: astore 4
    //   535: goto -77 -> 458
    //   538: astore 4
    //   540: goto -71 -> 469
    //   543: astore_3
    //   544: goto -298 -> 246
    //   547: astore_2
    //   548: goto -332 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	551	0	this	BasePluginActivity
    //   0	551	1	paramString1	String
    //   0	551	2	paramString2	String
    //   0	551	3	paramActivity	Activity
    //   0	551	4	paramClassLoader	ClassLoader
    //   0	551	5	paramPackageInfo	PackageInfo
    //   0	551	6	paramBoolean1	boolean
    //   0	551	7	paramBoolean2	boolean
    //   251	168	8	i	int
    //   267	207	9	j	int
    //   247	175	10	k	int
    //   264	91	11	m	int
    //   349	14	12	n	int
    // Exception table:
    //   from	to	target	type
    //   313	321	456	java/lang/IllegalArgumentException
    //   398	406	467	java/lang/IllegalArgumentException
    //   416	431	478	java/lang/Exception
    //   486	526	527	java/lang/Exception
    //   313	321	533	java/lang/IllegalAccessException
    //   398	406	538	java/lang/IllegalAccessException
    //   218	244	543	java/lang/ClassNotFoundException
    //   188	214	547	java/lang/ClassNotFoundException
  }
  
  public boolean IIsWrapContent()
  {
    return true;
  }
  
  public void IOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void IOnConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
  }
  
  public void IOnCreate(Bundle paramBundle)
  {
    onCreate(paramBundle);
  }
  
  public boolean IOnCreateOptionsMenu(Menu paramMenu)
  {
    return onCreateOptionsMenu(paramMenu);
  }
  
  public void IOnDestroy()
  {
    onDestroy();
  }
  
  public boolean IOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean IOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean IOnKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean IOnMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public void IOnNewIntent(Intent paramIntent)
  {
    onNewIntent(paramIntent);
  }
  
  public boolean IOnOptionsItemSelected(MenuItem paramMenuItem)
  {
    return onOptionsItemSelected(paramMenuItem);
  }
  
  public void IOnPause()
  {
    onPause();
  }
  
  public boolean IOnPrepareOptionsMenu(Menu paramMenu)
  {
    return onPrepareOptionsMenu(paramMenu);
  }
  
  public void IOnRestart()
  {
    onRestart();
  }
  
  public void IOnRestoreInstanceState(Bundle paramBundle) {}
  
  public void IOnResume()
  {
    onResume();
  }
  
  public void IOnSaveInstanceState(Bundle paramBundle) {}
  
  public void IOnSetTheme() {}
  
  public void IOnStart()
  {
    onStart();
  }
  
  public void IOnStop()
  {
    onStop();
  }
  
  public boolean IOnTouchEvent(MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent);
  }
  
  public void IOnUserInteraction()
  {
    onUserInteraction();
  }
  
  public void IOnWindowFocusChanged(boolean paramBoolean)
  {
    onWindowFocusChanged(paramBoolean);
  }
  
  public void ISetIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
  }
  
  public void ISetIsTab()
  {
    this.mIsTab = true;
  }
  
  public void ISetOutHandler(Handler paramHandler) {}
  
  public void ISetParent(BasePluginActivity paramBasePluginActivity)
  {
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("setParent", new Class[] { Activity.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[] { paramBasePluginActivity });
      return;
    }
    catch (Exception paramBasePluginActivity) {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (sIsLiquid == null) {
      initIsLiquid();
    }
    if ((sIsLiquid == null) || (!sIsLiquid.booleanValue())) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0) {
      onUserInteraction();
    }
    if (getWindow().superDispatchTouchEvent(paramMotionEvent)) {
      return true;
    }
    return onTouchEvent(paramMotionEvent);
  }
  
  public View findViewById(int paramInt)
  {
    if ((this.mIsRunInPlugin) && (this.mContentView != null))
    {
      View localView2 = this.mContentView.findViewById(paramInt);
      View localView1 = localView2;
      if (localView2 == null) {
        localView1 = super.findViewById(paramInt);
      }
      return localView1;
    }
    return super.findViewById(paramInt);
  }
  
  public void finish()
  {
    int j;
    Object localObject3;
    int i;
    if (this.mIsRunInPlugin)
    {
      j = 0;
      localObject3 = null;
      i = j;
      try
      {
        localObject1 = Activity.class.getDeclaredField("mResultCode");
        i = j;
        ((Field)localObject1).setAccessible(true);
        i = j;
        j = ((Integer)((Field)localObject1).get(this)).intValue();
        i = j;
        localObject1 = Activity.class.getDeclaredField("mResultData");
        i = j;
        ((Field)localObject1).setAccessible(true);
        i = j;
        localObject1 = (Intent)((Field)localObject1).get(this);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = localObject3;
          j = i;
          if (DebugHelper.sDebug)
          {
            DebugHelper.log("PluginDebug", "BasePluginActivity.finish", localException);
            localObject1 = localObject3;
            j = i;
          }
        }
      }
      finally {}
      this.mOutActivity.setResult(j, (Intent)localObject1);
      this.mOutActivity.finish();
      this.mFinished = true;
      return;
    }
    super.finish();
  }
  
  public Context getApplicationContext()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getApplicationContext();
    }
    return super.getApplicationContext();
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.applicationInfo;
    }
    return super.getApplicationInfo();
  }
  
  public int getChangingConfigurations()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getChangingConfigurations();
    }
    return super.getChangingConfigurations();
  }
  
  public Resources getHostResources()
  {
    return this.mOutActivity.getResources();
  }
  
  public LayoutInflater getLayoutInflater()
  {
    if (this.mContext != null) {
      return LayoutInflater.from(this.mContext);
    }
    return LayoutInflater.from(this.mActivity);
  }
  
  public Activity getOutActivity()
  {
    return this.mOutActivity;
  }
  
  public Resources getOutResources()
  {
    if (this.mIsRunInPlugin == true) {
      return this.mOutActivity.getResources();
    }
    return this.mActivity.getResources();
  }
  
  public PackageInfo getPackageInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo;
    }
    return null;
  }
  
  public String getPackageName()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.packageName;
    }
    return super.getPackageName();
  }
  
  public Object getSystemService(String paramString)
  {
    if (("window".equals(paramString)) || ("search".equals(paramString)))
    {
      if (this.mIsRunInPlugin) {
        return this.mOutActivity.getSystemService(paramString);
      }
      return super.getSystemService(paramString);
    }
    if (this.mContext != null) {
      return this.mContext.getSystemService(paramString);
    }
    return super.getSystemService(paramString);
  }
  
  public Window getWindow()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getWindow();
    }
    return super.getWindow();
  }
  
  public WindowManager getWindowManager()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getWindowManager();
    }
    return super.getWindowManager();
  }
  
  public boolean isFinishing()
  {
    if (this.mIsRunInPlugin) {
      return this.mFinished;
    }
    return super.isFinishing();
  }
  
  public boolean isShadow()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mIsRunInPlugin) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onConfig(PluginConfig paramPluginConfig) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    if (this.mIsRunInPlugin)
    {
      this.mActivity = this.mOutActivity;
      onConfig(this.mConfig);
      if (this.processer != null) {}
    }
    try
    {
      this.processer = new SkinnableActivityProcesser(this, this);
      label43:
      PluginStatic.add(this);
      super.onCreate(paramBundle);
      if (getIntent().getBooleanExtra("params_remote_connect_at_launch", false)) {
        readyPluginInterface(this.mOutActivity, this);
      }
      return;
      super.onCreate(paramBundle);
      this.mActivity = this;
      return;
    }
    catch (Exception localException)
    {
      break label43;
    }
  }
  
  protected void onDestroy()
  {
    if (this.mIsRunInPlugin)
    {
      if (this.processer != null)
      {
        this.processer.destory();
        this.processer = null;
      }
      this.mDexClassLoader = null;
      PluginStatic.remove(this);
      super.onDestroy();
      return;
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (this.mIsRunInPlugin)
    {
      super.onPause();
      return;
    }
    super.onPause();
  }
  
  public void onPluginInterfaceLoaded(PluginInterface paramPluginInterface)
  {
    onPluginInterfaceReady(paramPluginInterface);
  }
  
  protected void onPluginInterfaceReady(PluginInterface paramPluginInterface) {}
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  protected void onRestart()
  {
    if (this.mIsRunInPlugin)
    {
      super.onRestart();
      return;
    }
    super.onRestart();
  }
  
  protected void onResume()
  {
    if (this.mIsRunInPlugin)
    {
      super.onResume();
      return;
    }
    super.onResume();
  }
  
  protected void onStart()
  {
    if (this.mIsRunInPlugin)
    {
      super.onStart();
      if ((IPluginAdapterProxy.getProxy().isNightMode()) && (this.mConfig.enableNight))
      {
        setNightMaskVisible(true);
        return;
      }
      setNightMaskVisible(false);
      return;
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.mIsRunInPlugin)
    {
      super.onStop();
      return;
    }
    super.onStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (this.mIsRunInPlugin) {
      return;
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void openOptionsMenu()
  {
    if (this.mIsRunInPlugin)
    {
      this.mOutActivity.openOptionsMenu();
      return;
    }
    super.openOptionsMenu();
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    if (this.mIsRunInPlugin)
    {
      this.mActivity.overridePendingTransition(paramInt1, paramInt2);
      return;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
  }
  
  protected final void readyPluginInterface(Context paramContext, PluginInterfaceHelper.OnPluginInterfaceLoadedListener paramOnPluginInterfaceLoadedListener)
  {
    PluginInterfaceHelper.getPluginInterface(paramContext, paramOnPluginInterfaceLoadedListener);
  }
  
  public void setContentView(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mContentView = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      if (!this.mIsTab) {
        this.mActivity.setContentView(this.mContentView);
      }
      return;
    }
    super.setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    if (this.mIsRunInPlugin)
    {
      this.mContentView = paramView;
      if (!this.mIsTab) {
        this.mActivity.setContentView(this.mContentView);
      }
      return;
    }
    super.setContentView(paramView);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    super.setRequestedOrientation(paramInt);
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mOutActivity.setTheme(paramInt);
      return;
    }
    super.setTheme(paramInt);
  }
  
  public void setTitle(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mActivity.setTitle(paramInt);
      return;
    }
    super.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.mIsRunInPlugin)
    {
      this.mActivity.setTitle(paramCharSequence);
      return;
    }
    super.setTitle(paramCharSequence);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
        bool1 = paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      }
      while (!bool1)
      {
        this.mActivity.startActivityForResult(paramIntent, paramInt);
        return;
        Object localObject = paramIntent.getComponent();
        bool1 = bool2;
        if (localObject != null)
        {
          if (this.mOutActivity.getPackageName().equals(((ComponentName)localObject).getPackageName()))
          {
            localObject = this.mActivity.getPackageManager().queryIntentActivities(paramIntent, 65536);
            if ((localObject == null) || (((List)localObject).size() == 0)) {}
            for (bool1 = true;; bool1 = false) {
              break;
            }
          }
          bool1 = bool2;
          if (getPackageName().equals(((ComponentName)localObject).getPackageName())) {
            bool1 = true;
          }
        }
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
      this.mActivity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public static class PluginConfig
  {
    public boolean enableNight = true;
    public int titleHeight = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.BasePluginActivity
 * JD-Core Version:    0.7.0.1
 */