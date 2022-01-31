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
  protected int mPluginResourcesType;
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
  public void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: getstatic 214	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   3: ifeq +49 -> 52
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
    //   39: aload_0
    //   40: getfield 232	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   43: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 243	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 56	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mIsRunInPlugin	Z
    //   57: aload_0
    //   58: aload 4
    //   60: putfield 74	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mDexClassLoader	Ljava/lang/ClassLoader;
    //   63: aload_0
    //   64: aload_3
    //   65: putfield 58	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mOutActivity	Landroid/app/Activity;
    //   68: aload_0
    //   69: aload_1
    //   70: putfield 245	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginID	Ljava/lang/String;
    //   73: aload_0
    //   74: aload_2
    //   75: putfield 70	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mApkFilePath	Ljava/lang/String;
    //   78: aload_0
    //   79: aload 5
    //   81: putfield 247	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPackageInfo	Landroid/content/pm/PackageInfo;
    //   84: aload_0
    //   85: iload 7
    //   87: putfield 232	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   90: aload_0
    //   91: getfield 60	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   94: ifnonnull +32 -> 126
    //   97: aload_0
    //   98: new 249	com/tencent/mobileqq/pluginsdk/PluginContext
    //   101: dup
    //   102: aload_3
    //   103: iconst_0
    //   104: aload_0
    //   105: getfield 70	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mApkFilePath	Ljava/lang/String;
    //   108: aload_0
    //   109: getfield 74	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mDexClassLoader	Ljava/lang/ClassLoader;
    //   112: aload_3
    //   113: invokevirtual 201	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   116: aload_0
    //   117: getfield 232	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   120: invokespecial 252	com/tencent/mobileqq/pluginsdk/PluginContext:<init>	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/ClassLoader;Landroid/content/res/Resources;I)V
    //   123: putfield 60	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   126: aload_0
    //   127: aload_0
    //   128: getfield 60	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mContext	Landroid/content/Context;
    //   131: invokevirtual 255	com/tencent/mobileqq/pluginsdk/BasePluginActivity:attachBaseContext	(Landroid/content/Context;)V
    //   134: aload_0
    //   135: iload 6
    //   137: putfield 72	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mUseSkinEngine	Z
    //   140: getstatic 48	com/tencent/mobileqq/pluginsdk/BasePluginActivity:sSkilEngineInit	Z
    //   143: ifne +298 -> 441
    //   146: iload 6
    //   148: ifeq +293 -> 441
    //   151: iconst_1
    //   152: ifeq +289 -> 441
    //   155: aload_0
    //   156: getfield 232	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   159: iconst_1
    //   160: if_icmpeq +312 -> 472
    //   163: aload_0
    //   164: getfield 232	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mPluginResourcesType	I
    //   167: iconst_2
    //   168: if_icmpeq +304 -> 472
    //   171: new 218	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   178: aload 5
    //   180: getfield 260	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   183: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 262
    //   189: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore_3
    //   196: aconst_null
    //   197: astore_1
    //   198: aload 4
    //   200: new 218	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   207: aload_3
    //   208: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc_w 264
    //   214: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokevirtual 270	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   223: astore_2
    //   224: aload_2
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_2
    //   228: aload 4
    //   230: new 218	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   237: aload_3
    //   238: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc_w 272
    //   244: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokevirtual 270	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   253: astore_3
    //   254: aload_3
    //   255: astore_2
    //   256: iconst_0
    //   257: istore 9
    //   259: iload 9
    //   261: istore 7
    //   263: aload_1
    //   264: ifnull +77 -> 341
    //   267: aload_1
    //   268: invokevirtual 276	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   271: astore_3
    //   272: aload_3
    //   273: arraylength
    //   274: istore 10
    //   276: iconst_0
    //   277: istore 8
    //   279: iload 9
    //   281: istore 7
    //   283: iload 8
    //   285: iload 10
    //   287: if_icmpge +54 -> 341
    //   290: aload_3
    //   291: iload 8
    //   293: aaload
    //   294: astore 4
    //   296: aload 4
    //   298: invokevirtual 282	java/lang/reflect/Field:getModifiers	()I
    //   301: bipush 25
    //   303: iand
    //   304: bipush 25
    //   306: if_icmpne +138 -> 444
    //   309: aload 4
    //   311: invokevirtual 286	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   314: getstatic 292	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   317: invokevirtual 298	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   320: ifeq +124 -> 444
    //   323: aload 4
    //   325: aconst_null
    //   326: invokevirtual 302	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   329: istore 7
    //   331: iload 7
    //   333: bipush 16
    //   335: ishr
    //   336: bipush 16
    //   338: ishl
    //   339: istore 7
    //   341: iconst_0
    //   342: istore 10
    //   344: iload 10
    //   346: istore 9
    //   348: aload_2
    //   349: ifnull +77 -> 426
    //   352: aload_2
    //   353: invokevirtual 276	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   356: astore_3
    //   357: aload_3
    //   358: arraylength
    //   359: istore 11
    //   361: iconst_0
    //   362: istore 8
    //   364: iload 10
    //   366: istore 9
    //   368: iload 8
    //   370: iload 11
    //   372: if_icmpge +54 -> 426
    //   375: aload_3
    //   376: iload 8
    //   378: aaload
    //   379: astore 4
    //   381: aload 4
    //   383: invokevirtual 282	java/lang/reflect/Field:getModifiers	()I
    //   386: bipush 25
    //   388: iand
    //   389: bipush 25
    //   391: if_icmpne +64 -> 455
    //   394: aload 4
    //   396: invokevirtual 286	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   399: getstatic 292	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   402: invokevirtual 298	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   405: ifeq +50 -> 455
    //   408: aload 4
    //   410: aconst_null
    //   411: invokevirtual 302	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   414: istore 9
    //   416: iload 9
    //   418: bipush 16
    //   420: ishr
    //   421: bipush 16
    //   423: ishl
    //   424: istore 9
    //   426: aload_0
    //   427: aload_1
    //   428: iload 7
    //   430: aload_2
    //   431: iload 9
    //   433: aconst_null
    //   434: invokestatic 308	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   437: iconst_1
    //   438: putstatic 48	com/tencent/mobileqq/pluginsdk/BasePluginActivity:sSkilEngineInit	Z
    //   441: return
    //   442: astore 4
    //   444: iload 8
    //   446: iconst_1
    //   447: iadd
    //   448: istore 8
    //   450: goto -171 -> 279
    //   453: astore 4
    //   455: iload 8
    //   457: iconst_1
    //   458: iadd
    //   459: istore 8
    //   461: goto -97 -> 364
    //   464: astore_1
    //   465: invokestatic 312	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   468: invokevirtual 315	com/tencent/theme/SkinEngine:unInit	()V
    //   471: return
    //   472: ldc_w 317
    //   475: invokestatic 320	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   478: ldc_w 322
    //   481: iconst_1
    //   482: anewarray 97	java/lang/Class
    //   485: dup
    //   486: iconst_0
    //   487: ldc 195
    //   489: aastore
    //   490: invokevirtual 326	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   493: aconst_null
    //   494: iconst_1
    //   495: anewarray 294	java/lang/Object
    //   498: dup
    //   499: iconst_0
    //   500: aload_0
    //   501: aastore
    //   502: invokevirtual 332	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   505: pop
    //   506: iconst_1
    //   507: putstatic 48	com/tencent/mobileqq/pluginsdk/BasePluginActivity:sSkilEngineInit	Z
    //   510: return
    //   511: astore_1
    //   512: aload_1
    //   513: invokevirtual 335	java/lang/Exception:printStackTrace	()V
    //   516: return
    //   517: astore 4
    //   519: goto -75 -> 444
    //   522: astore 4
    //   524: goto -69 -> 455
    //   527: astore_3
    //   528: goto -272 -> 256
    //   531: astore_2
    //   532: goto -306 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	BasePluginActivity
    //   0	535	1	paramString1	String
    //   0	535	2	paramString2	String
    //   0	535	3	paramActivity	Activity
    //   0	535	4	paramClassLoader	ClassLoader
    //   0	535	5	paramPackageInfo	PackageInfo
    //   0	535	6	paramBoolean	boolean
    //   0	535	7	paramInt	int
    //   277	183	8	i	int
    //   257	175	9	j	int
    //   274	91	10	k	int
    //   359	14	11	m	int
    // Exception table:
    //   from	to	target	type
    //   323	331	442	java/lang/IllegalArgumentException
    //   408	416	453	java/lang/IllegalArgumentException
    //   426	441	464	java/lang/Exception
    //   472	510	511	java/lang/Exception
    //   323	331	517	java/lang/IllegalAccessException
    //   408	416	522	java/lang/IllegalAccessException
    //   228	254	527	java/lang/ClassNotFoundException
    //   198	224	531	java/lang/ClassNotFoundException
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
            DebugHelper.log("plugin_tag", "BasePluginActivity.finish", localException);
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
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      super.startActivity(paramIntent);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      startActivityForResult(paramIntent, -1);
    }
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