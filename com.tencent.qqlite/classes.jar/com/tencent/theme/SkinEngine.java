package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinEngine
{
  public static final String ACTION_THEME_INVALIDATE = "com.tencent.qqlite.qplus.THEME_INVALIDATE";
  public static final String ACTION_THEME_UPDATE = "com.tencent.qqlite.qplus.THEME_UPDATE";
  public static final String ASSET_PATH = "/asset/";
  public static boolean DEBUG = false;
  public static boolean IS_PROBLEM_CM11 = false;
  public static boolean IS_PROBLEM_MIUI = false;
  public static final String KEY_PENDING_THEME = "pending_theme_root";
  public static final String KEY_PENDING_THEME_RESOURCES_IS_COMPLIED = "pending_theme_resources_complied";
  public static final String KEY_RESOURCES_IS_COMPLIED = "complied";
  public static final String KEY_THEME = "theme_root";
  public static final String PREFERENCE_NAME = "theme";
  public static boolean SWITCH_DEBUG = false;
  public static final String TAG = "SkinEngine";
  public static final String TAG_SWITCH = "SkinEngine.switch";
  public static final int TYPE_FILE = 16777215;
  public static final int TYPE_RESOURCES = 3;
  static boolean a;
  static final String[][] c;
  static final int[][] d;
  static int e;
  static int f;
  static int g;
  static int h;
  static int i;
  private static SkinEngine l;
  public static Field mComposedIconInfoOfCM;
  public static Integer mIconResourceID;
  public static Field mIconsOfCM;
  final TypedValue b = new TypedValue();
  SkinEngineHandler j;
  BroadcastReceiver k = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateReceiver.onReceive ACTION_THEME_UPDATE");
      }
      try
      {
        new SkinEngine.a(SkinEngine.this, null).execute(new Context[] { paramAnonymousContext });
        return;
      }
      catch (RejectedExecutionException paramAnonymousContext) {}
    }
  };
  private boolean m = false;
  public Resources mResources;
  private boolean n = true;
  private final LongSparseArray<WeakReference<b>> o = new LongSparseArray();
  private final LongSparseArray<WeakReference<SkinnableColorStateList>> p = new LongSparseArray();
  private String q;
  private String r;
  private int s = g;
  private g t;
  private d u;
  private e v;
  private HashMap<String, Object> w;
  private HashMap<String, Object> x;
  
  static
  {
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23)) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      IS_PROBLEM_MIUI = false;
      mIconsOfCM = null;
      mComposedIconInfoOfCM = null;
      IS_PROBLEM_CM11 = false;
      mIconResourceID = null;
      String[] arrayOfString1 = { "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
      String[] arrayOfString2 = { "drawable-ldpi/", "drawable-mdpi/", "drawable-hdpi/", "drawable-xhdpi/", "drawable/" };
      String[] arrayOfString3 = { "drawable-xxhdpi", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
      c = new String[][] { arrayOfString1, { "drawable-hdpi/", "drawable-xhdpi/", "drawable-mdpi/", "drawable/" }, { "drawable-mdpi/", "drawable/", "drawable-hdpi/", "drawable-xhdpi/" }, arrayOfString2, arrayOfString3 };
      d = new int[][] { { 320, 240, 160, 160 }, { 240, 320, 160, 160 }, { 160, 160, 240, 320 }, { 120, 160, 240, 320, 160 }, { 480, 320, 240, 160, 160 } };
      e = 0;
      f = 1;
      g = 2;
      h = 3;
      i = 4;
      return;
    }
  }
  
  private static int a(Resources paramResources)
  {
    switch (paramResources.getDisplayMetrics().densityDpi)
    {
    default: 
      return g;
    case 320: 
      return e;
    case 240: 
      return f;
    case 120: 
      return h;
    }
    return i;
  }
  
  private XmlResourceParser a(int paramInt, TypedValue paramTypedValue)
    throws IOException
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    if (paramTypedValue.type == 3) {
      return this.mResources.getAssets().openXmlResourceParser(paramTypedValue.assetCookie, paramTypedValue.string.toString());
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(paramTypedValue.type) + " is not valid");
  }
  
  /* Error */
  private b a(int paramInt, Resources paramResources, j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 171	com/tencent/theme/SkinEngine:b	Landroid/util/TypedValue;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: new 270	android/graphics/Rect
    //   12: dup
    //   13: invokespecial 271	android/graphics/Rect:<init>	()V
    //   16: astore 9
    //   18: aload_3
    //   19: getfield 275	com/tencent/theme/j:b	Ljava/lang/String;
    //   22: astore 7
    //   24: aload 7
    //   26: ifnull +252 -> 278
    //   29: aload 7
    //   31: ldc_w 277
    //   34: invokevirtual 281	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   37: istore 4
    //   39: iload 4
    //   41: ifne +237 -> 278
    //   44: aload_0
    //   45: aload_2
    //   46: aload 7
    //   48: invokespecial 284	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   51: astore 6
    //   53: new 286	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 287	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore 10
    //   62: aload 10
    //   64: aload_3
    //   65: getfield 289	com/tencent/theme/j:c	I
    //   68: putfield 292	android/graphics/BitmapFactory$Options:inDensity	I
    //   71: aload_2
    //   72: aconst_null
    //   73: aload 6
    //   75: aload_3
    //   76: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   79: aload 10
    //   81: aload 9
    //   83: aload_0
    //   84: getfield 175	com/tencent/theme/SkinEngine:n	Z
    //   87: invokestatic 299	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   90: astore 5
    //   92: aload 6
    //   94: invokevirtual 304	java/io/InputStream:close	()V
    //   97: aload 5
    //   99: ifnull +179 -> 278
    //   102: aload 8
    //   104: monitorexit
    //   105: aload 5
    //   107: areturn
    //   108: astore 5
    //   110: aload_0
    //   111: getfield 306	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   114: ifnull +842 -> 956
    //   117: aload_0
    //   118: getfield 306	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   121: aload 5
    //   123: aload_3
    //   124: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   127: iconst_1
    //   128: invokeinterface 312 4 0
    //   133: ifeq +823 -> 956
    //   136: aload 6
    //   138: invokevirtual 304	java/io/InputStream:close	()V
    //   141: aload_0
    //   142: aload_2
    //   143: aload 7
    //   145: invokespecial 284	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   148: astore 6
    //   150: aload_2
    //   151: aconst_null
    //   152: aload 6
    //   154: aload_3
    //   155: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   158: aload 10
    //   160: aload 9
    //   162: aload_0
    //   163: getfield 175	com/tencent/theme/SkinEngine:n	Z
    //   166: invokestatic 299	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   169: astore 5
    //   171: goto -79 -> 92
    //   174: astore 5
    //   176: aload_0
    //   177: getfield 306	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   180: aload 5
    //   182: aload_3
    //   183: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   186: iconst_1
    //   187: invokeinterface 315 4 0
    //   192: ifeq +42 -> 234
    //   195: aload 10
    //   197: iconst_1
    //   198: putfield 318	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   201: aload_0
    //   202: aload_2
    //   203: aload 7
    //   205: invokespecial 284	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   208: astore 6
    //   210: aload_2
    //   211: aconst_null
    //   212: aload 6
    //   214: aload_3
    //   215: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   218: aload 10
    //   220: aload 9
    //   222: aload_0
    //   223: getfield 175	com/tencent/theme/SkinEngine:n	Z
    //   226: invokestatic 299	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   229: astore 5
    //   231: goto -139 -> 92
    //   234: aload 5
    //   236: athrow
    //   237: astore 5
    //   239: getstatic 99	com/tencent/theme/SkinEngine:DEBUG	Z
    //   242: ifeq +36 -> 278
    //   245: ldc 43
    //   247: new 241	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 320
    //   257: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 7
    //   262: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 322
    //   268: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 327	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   277: pop
    //   278: aload_3
    //   279: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   282: ldc_w 277
    //   285: invokevirtual 281	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   288: istore 4
    //   290: iload 4
    //   292: ifeq +190 -> 482
    //   295: aload_0
    //   296: iload_1
    //   297: aload_0
    //   298: getfield 171	com/tencent/theme/SkinEngine:b	Landroid/util/TypedValue;
    //   301: invokespecial 329	com/tencent/theme/SkinEngine:a	(ILandroid/util/TypedValue;)Landroid/content/res/XmlResourceParser;
    //   304: astore 6
    //   306: aload 7
    //   308: ifnull +86 -> 394
    //   311: aload_0
    //   312: getfield 175	com/tencent/theme/SkinEngine:n	Z
    //   315: ifeq +71 -> 386
    //   318: new 331	com/tencent/theme/a
    //   321: dup
    //   322: invokespecial 332	com/tencent/theme/a:<init>	()V
    //   325: astore 5
    //   327: new 334	java/io/FileInputStream
    //   330: dup
    //   331: aload 7
    //   333: invokespecial 335	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   336: astore 7
    //   338: aload 5
    //   340: aload 7
    //   342: ldc_w 337
    //   345: invokeinterface 343 3 0
    //   350: aload_2
    //   351: aload 6
    //   353: aload 5
    //   355: aload_0
    //   356: getfield 175	com/tencent/theme/SkinEngine:n	Z
    //   359: invokestatic 346	com/tencent/theme/i:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/b;
    //   362: astore_2
    //   363: aload 7
    //   365: invokevirtual 347	java/io/FileInputStream:close	()V
    //   368: aload 6
    //   370: invokeinterface 350 1 0
    //   375: aload 8
    //   377: monitorexit
    //   378: aload_2
    //   379: areturn
    //   380: astore_2
    //   381: aload 8
    //   383: monitorexit
    //   384: aload_2
    //   385: athrow
    //   386: invokestatic 356	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   389: astore 5
    //   391: goto -64 -> 327
    //   394: aload_2
    //   395: aload 6
    //   397: aconst_null
    //   398: aload_0
    //   399: getfield 175	com/tencent/theme/SkinEngine:n	Z
    //   402: invokestatic 346	com/tencent/theme/i:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/b;
    //   405: astore_2
    //   406: aload 6
    //   408: invokeinterface 350 1 0
    //   413: aload 8
    //   415: monitorexit
    //   416: aload_2
    //   417: areturn
    //   418: astore_2
    //   419: getstatic 99	com/tencent/theme/SkinEngine:DEBUG	Z
    //   422: ifeq +55 -> 477
    //   425: new 239	android/content/res/Resources$NotFoundException
    //   428: dup
    //   429: new 241	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 358
    //   439: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_3
    //   443: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   446: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: ldc_w 360
    //   452: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload_1
    //   456: invokestatic 254	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   459: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokespecial 262	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   468: astore_3
    //   469: aload_3
    //   470: aload_2
    //   471: invokevirtual 364	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   474: pop
    //   475: aload_3
    //   476: athrow
    //   477: aload 8
    //   479: monitorexit
    //   480: aconst_null
    //   481: areturn
    //   482: getstatic 127	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   485: istore 4
    //   487: iload 4
    //   489: ifeq +100 -> 589
    //   492: getstatic 123	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   495: iconst_1
    //   496: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   499: getstatic 123	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   502: aload_0
    //   503: getfield 207	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   506: aconst_null
    //   507: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   510: getstatic 125	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   513: iconst_1
    //   514: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   517: getstatic 125	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   520: aload_0
    //   521: getfield 207	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   524: aconst_null
    //   525: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   528: getstatic 123	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   531: iconst_1
    //   532: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   535: getstatic 125	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   538: iconst_1
    //   539: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   542: getstatic 123	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   545: aload_0
    //   546: getfield 207	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   549: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   552: ifnull +37 -> 589
    //   555: getstatic 125	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   558: aload_0
    //   559: getfield 207	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   562: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   565: astore 5
    //   567: aload 5
    //   569: ifnull +20 -> 589
    //   572: aload 8
    //   574: monitorexit
    //   575: aconst_null
    //   576: areturn
    //   577: astore_2
    //   578: aload 8
    //   580: monitorexit
    //   581: aconst_null
    //   582: areturn
    //   583: astore_2
    //   584: aload 8
    //   586: monitorexit
    //   587: aconst_null
    //   588: areturn
    //   589: aload_0
    //   590: getfield 171	com/tencent/theme/SkinEngine:b	Landroid/util/TypedValue;
    //   593: astore 10
    //   595: aload_2
    //   596: iload_1
    //   597: aload 10
    //   599: invokevirtual 382	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   602: astore 6
    //   604: aload 10
    //   606: getfield 225	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   609: invokeinterface 231 1 0
    //   614: astore 11
    //   616: aload 6
    //   618: astore 5
    //   620: new 286	android/graphics/BitmapFactory$Options
    //   623: dup
    //   624: invokespecial 287	android/graphics/BitmapFactory$Options:<init>	()V
    //   627: astore 12
    //   629: aload 6
    //   631: astore 5
    //   633: aload_2
    //   634: aload 10
    //   636: aload 6
    //   638: aload 11
    //   640: aload 12
    //   642: aload 9
    //   644: iconst_1
    //   645: invokestatic 299	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   648: astore 7
    //   650: aload 7
    //   652: astore_2
    //   653: aload 6
    //   655: astore 5
    //   657: aload 6
    //   659: invokevirtual 304	java/io/InputStream:close	()V
    //   662: aload_2
    //   663: ifnonnull +33 -> 696
    //   666: aload 6
    //   668: astore 5
    //   670: aload_0
    //   671: getfield 306	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   674: ifnull +22 -> 696
    //   677: aload 6
    //   679: astore 5
    //   681: aload_0
    //   682: getfield 306	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   685: aload_3
    //   686: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   689: iconst_0
    //   690: invokeinterface 386 3 0
    //   695: pop
    //   696: aload 8
    //   698: monitorexit
    //   699: aload_2
    //   700: areturn
    //   701: astore_2
    //   702: aload 8
    //   704: monitorexit
    //   705: aconst_null
    //   706: areturn
    //   707: astore 7
    //   709: aload 6
    //   711: astore 5
    //   713: aload_0
    //   714: getfield 306	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   717: ifnull +234 -> 951
    //   720: aload 6
    //   722: astore 5
    //   724: aload_0
    //   725: getfield 306	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   728: aload 7
    //   730: aload_3
    //   731: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   734: iconst_0
    //   735: invokeinterface 312 4 0
    //   740: ifeq +211 -> 951
    //   743: aload 6
    //   745: astore 5
    //   747: aload 6
    //   749: invokevirtual 304	java/io/InputStream:close	()V
    //   752: aload 6
    //   754: astore 5
    //   756: aload_2
    //   757: iload_1
    //   758: aload 10
    //   760: invokevirtual 382	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   763: astore 6
    //   765: aload 6
    //   767: astore 5
    //   769: aload_2
    //   770: aload 10
    //   772: aload 6
    //   774: aload 11
    //   776: aload 12
    //   778: aload 9
    //   780: iconst_1
    //   781: invokestatic 299	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   784: astore 7
    //   786: aload 7
    //   788: astore_2
    //   789: goto -136 -> 653
    //   792: astore 7
    //   794: aload 6
    //   796: astore 5
    //   798: aload_0
    //   799: getfield 306	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   802: aload 7
    //   804: aload_3
    //   805: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   808: iconst_0
    //   809: invokeinterface 315 4 0
    //   814: ifeq +49 -> 863
    //   817: aload 6
    //   819: astore 5
    //   821: aload 12
    //   823: iconst_1
    //   824: putfield 318	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   827: aload 6
    //   829: astore 5
    //   831: aload_2
    //   832: iload_1
    //   833: aload 10
    //   835: invokevirtual 382	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   838: astore 6
    //   840: aload 6
    //   842: astore 5
    //   844: aload_2
    //   845: aload 10
    //   847: aload 6
    //   849: aload 11
    //   851: aload 12
    //   853: aload 9
    //   855: iconst_1
    //   856: invokestatic 299	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   859: astore_2
    //   860: goto -207 -> 653
    //   863: aload 6
    //   865: astore 5
    //   867: aload 7
    //   869: athrow
    //   870: astore_2
    //   871: getstatic 99	com/tencent/theme/SkinEngine:DEBUG	Z
    //   874: ifeq +72 -> 946
    //   877: new 239	android/content/res/Resources$NotFoundException
    //   880: dup
    //   881: new 241	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   888: ldc_w 358
    //   891: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: aload_3
    //   895: getfield 294	com/tencent/theme/j:d	Ljava/lang/String;
    //   898: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: ldc_w 360
    //   904: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: iload_1
    //   908: invokestatic 254	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   911: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: ldc_w 388
    //   917: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload 5
    //   922: invokevirtual 392	java/lang/Object:getClass	()Ljava/lang/Class;
    //   925: invokevirtual 397	java/lang/Class:getName	()Ljava/lang/String;
    //   928: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   934: invokespecial 262	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   937: astore_3
    //   938: aload_3
    //   939: aload_2
    //   940: invokevirtual 364	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   943: pop
    //   944: aload_3
    //   945: athrow
    //   946: aload 8
    //   948: monitorexit
    //   949: aconst_null
    //   950: areturn
    //   951: aconst_null
    //   952: astore_2
    //   953: goto -300 -> 653
    //   956: aconst_null
    //   957: astore 5
    //   959: goto -867 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	this	SkinEngine
    //   0	962	1	paramInt	int
    //   0	962	2	paramResources	Resources
    //   0	962	3	paramj	j
    //   37	451	4	bool	boolean
    //   90	16	5	localb1	b
    //   108	14	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   169	1	5	localb2	b
    //   174	7	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   229	6	5	localb3	b
    //   237	1	5	localIOException	IOException
    //   325	633	5	localObject1	Object
    //   51	813	6	localObject2	Object
    //   22	629	7	localObject3	Object
    //   707	22	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   784	3	7	localb4	b
    //   792	76	7	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   4	943	8	localTypedValue	TypedValue
    //   16	838	9	localRect	Rect
    //   60	786	10	localObject4	Object
    //   614	236	11	str	String
    //   627	225	12	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   71	92	108	java/lang/OutOfMemoryError
    //   150	171	174	java/lang/OutOfMemoryError
    //   44	71	237	java/io/IOException
    //   71	92	237	java/io/IOException
    //   92	97	237	java/io/IOException
    //   110	150	237	java/io/IOException
    //   150	171	237	java/io/IOException
    //   176	231	237	java/io/IOException
    //   234	237	237	java/io/IOException
    //   9	24	380	finally
    //   29	39	380	finally
    //   44	71	380	finally
    //   71	92	380	finally
    //   92	97	380	finally
    //   102	105	380	finally
    //   110	150	380	finally
    //   150	171	380	finally
    //   176	231	380	finally
    //   234	237	380	finally
    //   239	278	380	finally
    //   278	290	380	finally
    //   295	306	380	finally
    //   311	327	380	finally
    //   327	375	380	finally
    //   375	378	380	finally
    //   381	384	380	finally
    //   386	391	380	finally
    //   394	413	380	finally
    //   413	416	380	finally
    //   419	477	380	finally
    //   477	480	380	finally
    //   482	487	380	finally
    //   492	528	380	finally
    //   528	567	380	finally
    //   572	575	380	finally
    //   578	581	380	finally
    //   584	587	380	finally
    //   589	595	380	finally
    //   595	604	380	finally
    //   604	616	380	finally
    //   620	629	380	finally
    //   633	650	380	finally
    //   657	662	380	finally
    //   670	677	380	finally
    //   681	696	380	finally
    //   696	699	380	finally
    //   702	705	380	finally
    //   713	720	380	finally
    //   724	743	380	finally
    //   747	752	380	finally
    //   756	765	380	finally
    //   769	786	380	finally
    //   798	817	380	finally
    //   821	827	380	finally
    //   831	840	380	finally
    //   844	860	380	finally
    //   867	870	380	finally
    //   871	946	380	finally
    //   946	949	380	finally
    //   295	306	418	java/lang/Exception
    //   311	327	418	java/lang/Exception
    //   327	375	418	java/lang/Exception
    //   386	391	418	java/lang/Exception
    //   394	413	418	java/lang/Exception
    //   492	528	577	java/lang/Exception
    //   528	567	583	java/lang/Exception
    //   595	604	701	java/lang/Exception
    //   633	650	707	java/lang/OutOfMemoryError
    //   769	786	792	java/lang/OutOfMemoryError
    //   620	629	870	java/io/IOException
    //   633	650	870	java/io/IOException
    //   657	662	870	java/io/IOException
    //   670	677	870	java/io/IOException
    //   681	696	870	java/io/IOException
    //   713	720	870	java/io/IOException
    //   724	743	870	java/io/IOException
    //   747	752	870	java/io/IOException
    //   756	765	870	java/io/IOException
    //   769	786	870	java/io/IOException
    //   798	817	870	java/io/IOException
    //   821	827	870	java/io/IOException
    //   831	840	870	java/io/IOException
    //   844	860	870	java/io/IOException
    //   867	870	870	java/io/IOException
  }
  
  private String a(Resources paramResources, String paramString)
  {
    paramString = this.q + "color/" + paramString;
    try
    {
      if (paramString.startsWith("/asset/"))
      {
        paramResources.getAssets().open(paramString.substring("/asset/".length())).close();
        return paramString;
      }
      boolean bool = new File(paramString).exists();
      if (bool) {
        return paramString;
      }
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        if (DEBUG) {
          Log.w("SkinEngine", paramResources);
        }
      }
    }
    return null;
    return paramString;
  }
  
  private HashMap<String, Object> a(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i1;
    do
    {
      i1 = paramXmlPullParser.next();
    } while ((i1 != 2) && (i1 != 1));
    if (i1 != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    String str1 = paramXmlPullParser.getName();
    HashMap localHashMap = new HashMap();
    if (str1.equals("resources"))
    {
      i1 = paramXmlPullParser.getDepth();
      for (;;)
      {
        int i2 = paramXmlPullParser.next();
        if ((i2 == 1) || ((paramXmlPullParser.getDepth() < i1 + 1) && (i2 == 3))) {
          break;
        }
        if (i2 == 2)
        {
          String str2 = paramXmlPullParser.getName();
          str1 = paramXmlPullParser.getAttributeValue(null, "name");
          if ("color".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Color.parseColor(paramXmlPullParser.nextText())));
          }
          else if ("dimen".equals(str2))
          {
            str2 = paramXmlPullParser.nextText();
            if (str2.endsWith("dp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("dip")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 3)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("sp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(2, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("px")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(0, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            }
          }
          else if ("bool".equals(str2))
          {
            localHashMap.put(str1, Boolean.valueOf("true".equalsIgnoreCase(paramXmlPullParser.nextText())));
          }
          else if ("integer".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Integer.parseInt(paramXmlPullParser.nextText())));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(Resources paramResources, TypedValue paramTypedValue, String paramString, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i1 = 0;
    while (i1 < paramArrayOfInt.length) {
      try
      {
        String str = this.q + paramArrayOfString[i1] + paramString;
        if (str.startsWith("/asset/"))
        {
          paramResources.getAssets().open(str.substring("/asset/".length())).close();
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
        if (new File(str).exists())
        {
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
      }
      catch (IOException localIOException)
      {
        if (DEBUG) {
          Log.w("SkinEngine", localIOException);
        }
        i1 += 1;
      }
    }
    paramTypedValue.string = null;
    paramTypedValue.density = 0;
  }
  
  /* Error */
  private void a(Resources paramResources, Class paramClass1, int[] paramArrayOfInt, int paramInt1, Class paramClass2, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +12 -> 13
    //   4: aload_2
    //   5: ifnull +90 -> 95
    //   8: iload 4
    //   10: ifeq +85 -> 95
    //   13: ldc 193
    //   15: ldc_w 528
    //   18: invokevirtual 532	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   21: astore 8
    //   23: aload 8
    //   25: iconst_1
    //   26: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   29: aload 8
    //   31: aload_1
    //   32: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: astore 9
    //   37: aload 9
    //   39: instanceof 184
    //   42: ifeq +292 -> 334
    //   45: aload_3
    //   46: ifnull +245 -> 291
    //   49: aload_0
    //   50: new 534	com/tencent/theme/g
    //   53: dup
    //   54: aload_0
    //   55: aload_1
    //   56: aload_3
    //   57: aload 7
    //   59: iconst_1
    //   60: anewarray 184	android/util/LongSparseArray
    //   63: dup
    //   64: iconst_0
    //   65: aload 9
    //   67: checkcast 184	android/util/LongSparseArray
    //   70: aastore
    //   71: invokespecial 537	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   74: putfield 539	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   77: aload 8
    //   79: aload_1
    //   80: new 541	com/tencent/theme/h
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: getfield 539	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   89: invokespecial 544	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   92: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   95: aload 5
    //   97: ifnull +64 -> 161
    //   100: iload 6
    //   102: ifeq +59 -> 161
    //   105: ldc 193
    //   107: ldc_w 546
    //   110: invokevirtual 532	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   113: astore_2
    //   114: aload_2
    //   115: iconst_1
    //   116: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   119: aload_2
    //   120: aload_1
    //   121: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 184	android/util/LongSparseArray
    //   127: astore_3
    //   128: getstatic 119	com/tencent/theme/SkinEngine:a	Z
    //   131: ifeq +314 -> 445
    //   134: aload_0
    //   135: new 548	com/tencent/theme/f
    //   138: dup
    //   139: aload_0
    //   140: aload_1
    //   141: aload_3
    //   142: aload 5
    //   144: iload 6
    //   146: invokespecial 551	com/tencent/theme/f:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   149: putfield 553	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   152: aload_2
    //   153: aload_1
    //   154: aload_0
    //   155: getfield 553	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   158: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   161: aload_1
    //   162: invokevirtual 392	java/lang/Object:getClass	()Ljava/lang/Class;
    //   165: astore_2
    //   166: aload_2
    //   167: invokevirtual 397	java/lang/Class:getName	()Ljava/lang/String;
    //   170: ldc_w 555
    //   173: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifeq +40 -> 216
    //   179: aload_2
    //   180: ldc_w 557
    //   183: invokevirtual 532	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   186: astore_2
    //   187: aload_2
    //   188: iconst_1
    //   189: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   192: aload_2
    //   193: aload_1
    //   194: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   197: ifnonnull +19 -> 216
    //   200: aload_2
    //   201: aload_1
    //   202: new 559	android/util/SparseArray
    //   205: dup
    //   206: invokespecial 560	android/util/SparseArray:<init>	()V
    //   209: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   212: iconst_1
    //   213: putstatic 121	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   216: aload_1
    //   217: invokevirtual 392	java/lang/Object:getClass	()Ljava/lang/Class;
    //   220: ldc_w 562
    //   223: invokevirtual 532	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   226: putstatic 123	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   229: getstatic 123	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   232: iconst_1
    //   233: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   236: getstatic 123	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   239: aload_1
    //   240: aconst_null
    //   241: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   244: getstatic 123	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   247: iconst_0
    //   248: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   251: aload_1
    //   252: invokevirtual 392	java/lang/Object:getClass	()Ljava/lang/Class;
    //   255: ldc_w 564
    //   258: invokevirtual 532	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   261: putstatic 125	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   264: getstatic 125	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   267: iconst_1
    //   268: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   271: getstatic 125	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   274: aload_1
    //   275: aconst_null
    //   276: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   279: getstatic 125	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   282: iconst_0
    //   283: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   286: iconst_1
    //   287: putstatic 127	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   290: return
    //   291: aload_0
    //   292: new 534	com/tencent/theme/g
    //   295: dup
    //   296: aload_0
    //   297: aload_1
    //   298: aload_2
    //   299: iload 4
    //   301: aload 7
    //   303: iconst_1
    //   304: anewarray 184	android/util/LongSparseArray
    //   307: dup
    //   308: iconst_0
    //   309: aload 9
    //   311: checkcast 184	android/util/LongSparseArray
    //   314: aastore
    //   315: invokespecial 567	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Ljava/lang/Class;ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   318: putfield 539	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   321: goto -244 -> 77
    //   324: astore_1
    //   325: new 520	com/tencent/theme/UnSupportPlatformException
    //   328: dup
    //   329: aload_1
    //   330: invokespecial 570	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   333: athrow
    //   334: aload 9
    //   336: instanceof 572
    //   339: ifeq -244 -> 95
    //   342: aload 9
    //   344: checkcast 572	[Landroid/util/LongSparseArray;
    //   347: checkcast 572	[Landroid/util/LongSparseArray;
    //   350: astore 8
    //   352: aload_3
    //   353: ifnull +59 -> 412
    //   356: aload_0
    //   357: new 534	com/tencent/theme/g
    //   360: dup
    //   361: aload_0
    //   362: aload_1
    //   363: aload_3
    //   364: aload 7
    //   366: aload 8
    //   368: invokespecial 537	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   371: putfield 539	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   374: goto +251 -> 625
    //   377: iload 4
    //   379: aload 8
    //   381: arraylength
    //   382: if_icmpge -287 -> 95
    //   385: aload 8
    //   387: iload 4
    //   389: new 541	com/tencent/theme/h
    //   392: dup
    //   393: iload 4
    //   395: aload_0
    //   396: getfield 539	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   399: invokespecial 544	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   402: aastore
    //   403: iload 4
    //   405: iconst_1
    //   406: iadd
    //   407: istore 4
    //   409: goto -32 -> 377
    //   412: aload_0
    //   413: new 534	com/tencent/theme/g
    //   416: dup
    //   417: aload_0
    //   418: aload_1
    //   419: aload_2
    //   420: iload 4
    //   422: aload 7
    //   424: aload 8
    //   426: invokespecial 567	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Ljava/lang/Class;ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   429: putfield 539	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   432: goto +193 -> 625
    //   435: astore_1
    //   436: new 520	com/tencent/theme/UnSupportPlatformException
    //   439: dup
    //   440: aload_1
    //   441: invokespecial 570	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   444: athrow
    //   445: aload_0
    //   446: new 574	com/tencent/theme/d
    //   449: dup
    //   450: aload_0
    //   451: aload_1
    //   452: aload_3
    //   453: aload 5
    //   455: iload 6
    //   457: invokespecial 575	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   460: putfield 553	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   463: goto -311 -> 152
    //   466: astore_2
    //   467: ldc 193
    //   469: ldc_w 577
    //   472: invokevirtual 532	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   475: astore_3
    //   476: aload_3
    //   477: iconst_1
    //   478: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   481: aload_3
    //   482: aload_1
    //   483: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   486: astore 7
    //   488: aload 7
    //   490: instanceof 559
    //   493: ifeq +47 -> 540
    //   496: aload_0
    //   497: new 579	com/tencent/theme/e
    //   500: dup
    //   501: aload_0
    //   502: aload_1
    //   503: aload 7
    //   505: checkcast 559	android/util/SparseArray
    //   508: aload 5
    //   510: iload 6
    //   512: invokespecial 582	com/tencent/theme/e:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/SparseArray;Ljava/lang/Class;I)V
    //   515: putfield 584	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/e;
    //   518: aload_3
    //   519: aload_1
    //   520: aload_0
    //   521: getfield 584	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/e;
    //   524: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   527: goto -366 -> 161
    //   530: astore_1
    //   531: new 520	com/tencent/theme/UnSupportPlatformException
    //   534: dup
    //   535: aload_1
    //   536: invokespecial 570	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   539: athrow
    //   540: aload 7
    //   542: instanceof 184
    //   545: ifeq +37 -> 582
    //   548: aload_0
    //   549: new 574	com/tencent/theme/d
    //   552: dup
    //   553: aload_0
    //   554: aload_1
    //   555: aload 7
    //   557: checkcast 184	android/util/LongSparseArray
    //   560: aload 5
    //   562: iload 6
    //   564: invokespecial 575	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   567: putfield 553	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   570: aload_3
    //   571: aload_1
    //   572: aload_0
    //   573: getfield 553	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   576: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   579: goto -418 -> 161
    //   582: new 520	com/tencent/theme/UnSupportPlatformException
    //   585: dup
    //   586: aload_2
    //   587: invokespecial 570	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   590: athrow
    //   591: astore_2
    //   592: getstatic 99	com/tencent/theme/SkinEngine:DEBUG	Z
    //   595: ifeq +13 -> 608
    //   598: ldc 43
    //   600: ldc_w 586
    //   603: aload_2
    //   604: invokestatic 589	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   607: pop
    //   608: iconst_0
    //   609: putstatic 121	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   612: goto -396 -> 216
    //   615: astore_1
    //   616: aconst_null
    //   617: putstatic 123	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   620: aconst_null
    //   621: putstatic 125	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   624: return
    //   625: iconst_0
    //   626: istore 4
    //   628: goto -251 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	SkinEngine
    //   0	631	1	paramResources	Resources
    //   0	631	2	paramClass1	Class
    //   0	631	3	paramArrayOfInt	int[]
    //   0	631	4	paramInt1	int
    //   0	631	5	paramClass2	Class
    //   0	631	6	paramInt2	int
    //   0	631	7	paramFile	File
    //   21	404	8	localObject1	Object
    //   35	308	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	45	324	java/lang/IllegalArgumentException
    //   49	77	324	java/lang/IllegalArgumentException
    //   77	95	324	java/lang/IllegalArgumentException
    //   105	152	324	java/lang/IllegalArgumentException
    //   152	161	324	java/lang/IllegalArgumentException
    //   291	321	324	java/lang/IllegalArgumentException
    //   334	352	324	java/lang/IllegalArgumentException
    //   356	374	324	java/lang/IllegalArgumentException
    //   377	403	324	java/lang/IllegalArgumentException
    //   412	432	324	java/lang/IllegalArgumentException
    //   445	463	324	java/lang/IllegalArgumentException
    //   467	527	324	java/lang/IllegalArgumentException
    //   540	579	324	java/lang/IllegalArgumentException
    //   582	591	324	java/lang/IllegalArgumentException
    //   13	45	435	java/lang/NoSuchFieldException
    //   49	77	435	java/lang/NoSuchFieldException
    //   77	95	435	java/lang/NoSuchFieldException
    //   105	152	435	java/lang/NoSuchFieldException
    //   152	161	435	java/lang/NoSuchFieldException
    //   291	321	435	java/lang/NoSuchFieldException
    //   334	352	435	java/lang/NoSuchFieldException
    //   356	374	435	java/lang/NoSuchFieldException
    //   377	403	435	java/lang/NoSuchFieldException
    //   412	432	435	java/lang/NoSuchFieldException
    //   445	463	435	java/lang/NoSuchFieldException
    //   467	527	435	java/lang/NoSuchFieldException
    //   540	579	435	java/lang/NoSuchFieldException
    //   582	591	435	java/lang/NoSuchFieldException
    //   105	152	466	java/lang/Exception
    //   152	161	466	java/lang/Exception
    //   445	463	466	java/lang/Exception
    //   13	45	530	java/lang/IllegalAccessException
    //   49	77	530	java/lang/IllegalAccessException
    //   77	95	530	java/lang/IllegalAccessException
    //   105	152	530	java/lang/IllegalAccessException
    //   152	161	530	java/lang/IllegalAccessException
    //   291	321	530	java/lang/IllegalAccessException
    //   334	352	530	java/lang/IllegalAccessException
    //   356	374	530	java/lang/IllegalAccessException
    //   377	403	530	java/lang/IllegalAccessException
    //   412	432	530	java/lang/IllegalAccessException
    //   445	463	530	java/lang/IllegalAccessException
    //   467	527	530	java/lang/IllegalAccessException
    //   540	579	530	java/lang/IllegalAccessException
    //   582	591	530	java/lang/IllegalAccessException
    //   161	216	591	java/lang/Exception
    //   216	290	615	java/lang/Exception
  }
  
  private void a(b paramb)
  {
    Object localObject1 = paramb.f;
    Object localObject2 = ((j)localObject1).b;
    if (this.q != null)
    {
      a(this.mResources, this.b, ((j)localObject1).d, c[this.s], d[this.s]);
      if (this.b.string != null)
      {
        ((j)localObject1).b = this.b.string.toString();
        ((j)localObject1).c = this.b.density;
        if ((localObject2 != null) || (((j)localObject1).b != null) || (((j)localObject1).d.endsWith(".xml"))) {
          break label127;
        }
      }
    }
    label127:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ((j)localObject1).b = null;
            break;
            ((j)localObject1).b = null;
            break;
            if (!(paramb instanceof SkinnableBitmapDrawable.a)) {
              break label345;
            }
            paramb = (SkinnableBitmapDrawable.a)paramb;
            localObject2 = a(((j)localObject1).a, this.mResources, (j)localObject1);
            if (localObject2 != null) {
              break label207;
            }
          } while (!DEBUG);
          throw new NullPointerException("loadImage failed, file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
          if ((DEBUG) && ((localObject2 instanceof SkinnableNinePatchDrawable.a))) {
            throw new IllegalArgumentException("error image, the resource Image is Bitmap, but the skin Image is 9-path, file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
          }
          localObject1 = (SkinnableBitmapDrawable.a)localObject2;
          paramb.i = ((SkinnableBitmapDrawable.a)localObject1).i;
          paramb.g = ((SkinnableBitmapDrawable.a)localObject1).g;
          paramb.h = ((SkinnableBitmapDrawable.a)localObject1).h;
        } while ((!paramb.p) && (!((SkinnableBitmapDrawable.a)localObject1).p));
        paramb.k = ((SkinnableBitmapDrawable.a)localObject1).k;
        paramb.l = ((SkinnableBitmapDrawable.a)localObject1).l;
        paramb.m = ((SkinnableBitmapDrawable.a)localObject1).m;
        paramb.n = ((SkinnableBitmapDrawable.a)localObject1).n;
        paramb.p = true;
        return;
      } while (!(paramb instanceof SkinnableNinePatchDrawable.a));
      paramb = (SkinnableNinePatchDrawable.a)paramb;
      localObject2 = a(((j)localObject1).a, this.mResources, (j)localObject1);
      if (localObject2 != null) {
        break label425;
      }
    } while (!DEBUG);
    label207:
    label345:
    throw new NullPointerException("loadImage failed, file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
    label425:
    if ((DEBUG) && ((localObject2 instanceof SkinnableBitmapDrawable.a))) {
      throw new IllegalArgumentException("error image, the resource Image is 9-path, but the skin Image is Bitmap, did you compiled the 9-pathflie to apk and un-zip it? file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
    }
    localObject1 = (SkinnableNinePatchDrawable.a)localObject2;
    paramb.h = ((SkinnableNinePatchDrawable.a)localObject1).h;
    paramb.i = ((SkinnableNinePatchDrawable.a)localObject1).i;
    paramb.k = paramb.j;
    paramb.j = ((SkinnableNinePatchDrawable.a)localObject1).j;
    paramb.o = ((SkinnableNinePatchDrawable.a)localObject1).o;
    paramb.g = ((SkinnableNinePatchDrawable.a)localObject1).g;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.w == null) {}
    try
    {
      XmlResourceParser localXmlResourceParser = this.mResources.getAssets().openXmlResourceParser("res/xml/theme_config.xml");
      this.w = a(localXmlResourceParser);
      localXmlResourceParser.close();
      if (this.x == null)
      {
        if (this.q == null) {
          this.x = new HashMap();
        }
      }
      else {
        return;
      }
    }
    catch (XmlPullParserException localXmlPullParserException1)
    {
      localObject = new Resources.NotFoundException("wrong xml config file: res/xml/theme_config.xml");
      ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException1);
      throw ((Throwable)localObject);
    }
    catch (IOException localIOException1)
    {
      Object localObject;
      for (;;)
      {
        this.w = new HashMap();
      }
      if (paramBoolean) {}
      try
      {
        a locala = new a();
        localObject = new FileInputStream(new File(this.q, "xml/theme_config.xml"));
        locala.setInput((InputStream)localObject, "UTF-8");
        this.x = a(locala);
        ((FileInputStream)localObject).close();
        return;
      }
      catch (XmlPullParserException localXmlPullParserException2)
      {
        for (;;)
        {
          localObject = new Resources.NotFoundException("wrong theme xml config file: xml/theme_config.xml");
          ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException2);
          throw ((Throwable)localObject);
          XmlPullParser localXmlPullParser = Xml.newPullParser();
        }
      }
      catch (IOException localIOException2)
      {
        this.x = new HashMap();
      }
    }
  }
  
  private SkinnableColorStateList b(int paramInt, Resources paramResources, j paramj)
  {
    Object localObject;
    synchronized (this.b)
    {
      localObject = paramj.b;
      if (localObject != null)
      {
        bool = ((String)localObject).endsWith(".xml");
        if (bool)
        {
          try
          {
            SkinnableColorStateList localSkinnableColorStateList = i.a(this, paramResources, new File((String)localObject), this.n);
            return localSkinnableColorStateList;
          }
          catch (Exception localException)
          {
            if (!DEBUG) {
              break label126;
            }
          }
          paramResources = new Resources.NotFoundException("File " + (String)localObject + " from Skin ColorState resource ID #0x" + Integer.toHexString(paramInt));
          paramResources.initCause(localException);
          throw paramResources;
        }
      }
    }
    label126:
    paramj = paramj.d;
    boolean bool = paramj.endsWith(".xml");
    if (bool) {
      try
      {
        localObject = a(paramInt, this.b);
        paramResources = SkinnableColorStateList.createFromXml(this, paramResources, (XmlPullParser)localObject, true);
        ((XmlResourceParser)localObject).close();
        return paramResources;
      }
      catch (Exception paramResources)
      {
        paramj = new Resources.NotFoundException("File " + paramj + " from Skin ColorList list resource ID #0x" + Integer.toHexString(paramInt));
        paramj.initCause(paramResources);
        throw paramj;
      }
    }
    throw new Resources.NotFoundException("File " + paramj + " from Skin ColorList resource ID #0x" + Integer.toHexString(paramInt) + ": .xml extension required");
  }
  
  private InputStream b(Resources paramResources, String paramString)
    throws IOException, FileNotFoundException
  {
    if (paramString.startsWith("/asset/"))
    {
      paramString = paramString.substring("/asset/".length());
      return paramResources.getAssets().open(paramString);
    }
    return new FileInputStream(new File(paramString));
  }
  
  @TargetApi(16)
  private void b(Context paramContext)
  {
    paramContext = this.b;
    int i1 = 0;
    for (;;)
    {
      j localj;
      try
      {
        if (i1 >= this.p.size()) {
          break label150;
        }
        SkinnableColorStateList localSkinnableColorStateList = (SkinnableColorStateList)((WeakReference)this.p.valueAt(i1)).get();
        if (localSkinnableColorStateList == null) {
          break label153;
        }
        localj = localSkinnableColorStateList.skinData;
        String str1 = localj.b;
        if (this.q != null)
        {
          String str2 = a(this.mResources, localj.d);
          if (str2 != null)
          {
            localj.b = str2;
            if ((str1 != null) || (localj.b != null)) {
              break label128;
            }
            break label153;
          }
          localj.b = null;
          continue;
        }
        localj.b = null;
      }
      finally {}
      continue;
      label128:
      localObject.a(b(localj.a, this.mResources, localj));
      break label153;
      label150:
      return;
      label153:
      i1 += 1;
    }
  }
  
  @TargetApi(16)
  private void c(Context arg1)
  {
    for (;;)
    {
      int i1;
      synchronized (this.b)
      {
        ArrayList localArrayList = new ArrayList();
        i1 = 0;
        if (i1 < this.o.size())
        {
          b localb = (b)((WeakReference)this.o.valueAt(i1)).get();
          if (localb == null) {
            break label126;
          }
          if (localb.f.d.endsWith(".xml")) {
            localArrayList.add(localb);
          } else {
            a(localb);
          }
        }
      }
      Iterator localIterator = localObject.iterator();
      while (localIterator.hasNext()) {
        a((b)localIterator.next());
      }
      return;
      label126:
      i1 += 1;
    }
  }
  
  public static SkinEngine getInstances()
  {
    try
    {
      if (l == null) {
        l = new SkinEngine();
      }
      SkinEngine localSkinEngine = l;
      return localSkinEngine;
    }
    finally {}
  }
  
  public static void init(Context paramContext, Class paramClass1, int paramInt1, Class paramClass2, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.s = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.k, new IntentFilter("com.tencent.qqlite.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    localSkinEngine.a(localResources, paramClass1, null, paramInt1, paramClass2, paramInt2, paramFile);
    paramContext = paramContext.getSharedPreferences("theme", 4);
    localSkinEngine.q = paramContext.getString("theme_root", null);
    localSkinEngine.n = paramContext.getBoolean("complied", true);
  }
  
  public static void init(Context paramContext, int[] paramArrayOfInt, Class paramClass, int paramInt, File paramFile)
    throws UnSupportPlatformException
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.s = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.k, new IntentFilter("com.tencent.qqlite.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    localSkinEngine.a(localResources, null, paramArrayOfInt, 0, paramClass, paramInt, paramFile);
    paramContext = paramContext.getSharedPreferences("theme", 4);
    localSkinEngine.q = paramContext.getString("theme_root", null);
    localSkinEngine.n = paramContext.getBoolean("complied", true);
  }
  
  public static void invalidateAll(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i2;
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      localObject = (ViewGroup)paramView;
      i2 = ((ViewGroup)localObject).getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        invalidateAll(((ViewGroup)localObject).getChildAt(i1));
        i1 += 1;
      }
    }
    Object localObject = paramView.getBackground();
    Rect localRect;
    if (localObject != null)
    {
      if (!(localObject instanceof DrawableContainer)) {
        break label270;
      }
      localRect = new Rect();
      ((Drawable)localObject).getPadding(localRect);
      if ((localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
      {
        SkinnableActivityProcesser.a((Drawable)localObject);
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
      }
    }
    else
    {
      if ((paramView instanceof SkinnableView)) {
        ((SkinnableView)paramView).onThemeChanged();
      }
      if (!(paramView instanceof ImageView)) {
        break label428;
      }
      localObject = ((ImageView)paramView).getDrawable();
      SkinnableActivityProcesser.a((Drawable)localObject);
      ((ImageView)paramView).setImageDrawable(null);
      ((ImageView)paramView).setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView.destroyDrawingCache();
      paramView.refreshDrawableState();
      paramView.invalidate();
      paramView.requestLayout();
      return;
      i1 = paramView.getPaddingTop();
      i2 = paramView.getPaddingBottom();
      int i3 = paramView.getPaddingLeft();
      int i4 = paramView.getPaddingRight();
      SkinnableActivityProcesser.a((Drawable)localObject);
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      paramView.setPadding(i3, i1, i4, i2);
      break;
      label270:
      if ((localObject instanceof SkinnableNinePatchDrawable))
      {
        localRect = new Rect();
        if ((((SkinnableNinePatchDrawable)localObject).a(localRect)) && (localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
        {
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject);
          break;
        }
        i1 = paramView.getPaddingTop();
        i2 = paramView.getPaddingBottom();
        i3 = paramView.getPaddingLeft();
        i4 = paramView.getPaddingRight();
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
        paramView.setPadding(i3, i1, i4, i2);
        break;
      }
      if (!(localObject instanceof SkinnableBitmapDrawable)) {
        break;
      }
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      break;
      label428:
      if ((paramView instanceof TextView))
      {
        localObject = ((TextView)paramView).getCompoundDrawables();
        if ((localObject[0] != null) || (localObject[1] != null) || (localObject[2] != null) || (localObject[3] != null))
        {
          ((TextView)paramView).setCompoundDrawables(null, null, null, null);
          ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(localObject[0], localObject[1], localObject[2], localObject[3]);
        }
      }
    }
  }
  
  public static void isSupportPlatform(Context paramContext, Resources paramResources)
    throws UnSupportPlatformException
  {
    try
    {
      localObject = Resources.class.getDeclaredField("sPreloadedDrawables");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramResources);
      if ((!(localObject instanceof LongSparseArray)) && (!(localObject instanceof LongSparseArray[]))) {
        throw new UnSupportPlatformException("sPreloadedDrawables is not LongSparseArray");
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      Object localObject;
      throw new UnSupportPlatformException(paramContext);
      try
      {
        localObject = Resources.class.getDeclaredField("sPreloadedColorStateLists");
        ((Field)localObject).setAccessible(true);
        if (!(((Field)localObject).get(paramResources) instanceof LongSparseArray)) {
          throw new UnSupportPlatformException("sPreloadedColorStateLists is not LongSparseArray");
        }
      }
      catch (Exception localException)
      {
        Field localField = Resources.class.getDeclaredField("mPreloadedColorStateLists");
        localField.setAccessible(true);
        paramResources = localField.get(paramResources);
        boolean bool = paramResources instanceof SparseArray;
        if (bool) {}
        while (l.a(paramContext, "ro.lewa.version").equalsIgnoreCase("LeWa_OS6.0_14.10.22"))
        {
          throw new UnSupportPlatformException("lewa is not supported");
          if (!(paramResources instanceof LongSparseArray)) {
            throw new UnSupportPlatformException(localException);
          }
        }
      }
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new UnSupportPlatformException(paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new UnSupportPlatformException(paramContext);
    }
  }
  
  @TargetApi(16)
  Drawable.ConstantState a(int paramInt)
  {
    synchronized (this.b)
    {
      Object localObject1 = (WeakReference)this.o.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = (Drawable.ConstantState)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          return localObject1;
        }
        this.o.delete(paramInt);
      }
      boolean bool = IS_PROBLEM_CM11;
      if (bool) {
        try
        {
          mIconsOfCM.setAccessible(true);
          mIconsOfCM.set(this.mResources, null);
          mComposedIconInfoOfCM.setAccessible(true);
          mComposedIconInfoOfCM.set(this.mResources, null);
          this.mResources.getValue(paramInt, this.b, true);
        }
        catch (Exception localException1)
        {
          try
          {
            mIconsOfCM.setAccessible(true);
            mComposedIconInfoOfCM.setAccessible(true);
            if (mIconsOfCM.get(this.mResources) == null) {
              break label159;
            }
            localObject1 = mComposedIconInfoOfCM.get(this.mResources);
            if (localObject1 == null) {
              break label159;
            }
            return null;
          }
          catch (Exception localException2)
          {
            return null;
          }
          localException1 = localException1;
          return null;
        }
      }
      label159:
      Object localObject3 = this.b.string.toString();
      j localj = new j();
      localj.a = paramInt;
      localj.d = ((String)localObject3).substring(((String)localObject3).lastIndexOf("/") + 1);
      if (this.q != null)
      {
        a(this.mResources, this.b, localj.d, c[this.s], d[this.s]);
        if (this.b.string != null)
        {
          localj.b = this.b.string.toString();
          localj.c = this.b.density;
        }
      }
      localObject3 = a(paramInt, this.mResources, localj);
      if (localObject3 != null)
      {
        ((b)localObject3).f = localj;
        this.o.put(paramInt, new WeakReference(localObject3));
      }
      return localObject3;
    }
  }
  
  void a(Context paramContext)
  {
    boolean bool = true;
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "update start");
    }
    this.m = true;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    String str = localSharedPreferences.getString("pending_theme_root", null);
    if (str != null) {
      bool = localSharedPreferences.getBoolean("pending_theme_resources_complied", true);
    }
    synchronized (this.b)
    {
      this.r = this.q;
      this.q = str;
      this.n = bool;
      c(paramContext);
      b(paramContext);
      localSharedPreferences.edit().putString("theme_root", str).putBoolean("complied", this.n).commit();
      this.m = false;
      this.r = null;
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "update done");
      }
      return;
    }
  }
  
  public final void addDrawableResource(int paramInt)
  {
    this.t.a(this.mResources, paramInt);
  }
  
  @TargetApi(16)
  SkinnableColorStateList b(int paramInt)
  {
    synchronized (this.b)
    {
      Object localObject1 = (WeakReference)this.p.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = (SkinnableColorStateList)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          return localObject1;
        }
        this.p.delete(paramInt);
      }
      this.mResources.getValue(paramInt, this.b, true);
      Object localObject3 = this.b.string.toString();
      if (((String)localObject3).endsWith(".xml"))
      {
        localObject1 = new j();
        ((j)localObject1).a = paramInt;
        ((j)localObject1).d = ((String)localObject3).substring(((String)localObject3).lastIndexOf("/") + 1);
        if (this.q != null) {
          ((j)localObject1).b = a(this.mResources, ((j)localObject1).d);
        }
        localObject3 = b(paramInt, this.mResources, (j)localObject1);
        ((SkinnableColorStateList)localObject3).skinData = ((j)localObject1);
        this.p.put(paramInt, new WeakReference(localObject3));
        return localObject3;
      }
    }
    return null;
  }
  
  public int getColor(int paramInt)
  {
    synchronized (this.b)
    {
      TypedValue localTypedValue2 = this.b;
      this.mResources.getValue(paramInt, localTypedValue2, true);
      if ((localTypedValue2.type >= 16) && (localTypedValue2.type <= 31))
      {
        paramInt = localTypedValue2.data;
        return paramInt;
      }
      if (localTypedValue2.type == 3)
      {
        paramInt = b(paramInt).getDefaultColor();
        return paramInt;
      }
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(localObject.type) + " is not valid");
  }
  
  public String getSkinRootPath()
  {
    if (this.m) {
      return this.r;
    }
    return this.q;
  }
  
  public Object getThemeConfig(String paramString, Object paramObject)
  {
    for (;;)
    {
      Object localObject1;
      synchronized (this.b)
      {
        a(this.n);
        Object localObject2 = this.x.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = this.w.get(paramString);
          break label63;
          return paramObject;
        }
      }
      label63:
      while (localObject1 != null)
      {
        paramObject = localObject1;
        break;
      }
    }
  }
  
  @TargetApi(16)
  public void getValue(int paramInt, TypedValue paramTypedValue)
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    Object localObject;
    if (this.q != null)
    {
      localObject = (WeakReference)this.o.get(paramInt);
      if (localObject == null) {
        break label83;
      }
      localObject = (b)((WeakReference)localObject).get();
      if (localObject == null) {
        break label74;
      }
      if (((b)localObject).f.b == null) {
        break label83;
      }
      paramTypedValue.type = 16777215;
      paramTypedValue.string = ((b)localObject).f.b;
    }
    label74:
    label83:
    TypedValue localTypedValue;
    do
    {
      return;
      this.o.delete(paramInt);
      localObject = paramTypedValue.string.toString();
      localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
      localTypedValue = new TypedValue();
      a(this.mResources, localTypedValue, (String)localObject, c[this.s], d[this.s]);
    } while (localTypedValue.string == null);
    paramTypedValue.type = 16777215;
    paramTypedValue.string = localTypedValue.string;
  }
  
  public void setSkinEngineHandler(SkinEngineHandler paramSkinEngineHandler)
  {
    this.j = paramSkinEngineHandler;
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString)
  {
    return setSkinRootPath(paramContext, paramString, true);
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (this.m)
    {
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "[setSkinRootPath] mSkinUpdating is true");
      }
      return false;
    }
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "[setSkinRootPath] start");
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    if (paramString == null) {
      localSharedPreferences.edit().remove("pending_theme_root").remove("pending_theme_resources_complied").commit();
    }
    for (;;)
    {
      paramContext.sendBroadcast(new Intent("com.tencent.qqlite.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify");
      if (SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "[setSkinRootPath] sendBroadcast(ACTION_THEME_UPDATE)");
        Log.d("SkinEngine.switch", "[setSkinRootPath] done");
      }
      return true;
      String str = paramString;
      if (!paramString.endsWith("/")) {
        str = paramString + "/";
      }
      if (str.startsWith("/asset/"))
      {
        localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
      }
      else
      {
        paramString = new File(str);
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
        else
        {
          if (DEBUG) {
            Log.w("SkinEngine", "[setSkinRootPath] wrong skinPath: " + str);
          }
          localSharedPreferences.edit().remove("pending_theme_root").putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
      }
    }
  }
  
  /* Error */
  public void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 539	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   4: ifnull +39 -> 43
    //   7: ldc 193
    //   9: ldc_w 528
    //   12: invokevirtual 532	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   15: astore_1
    //   16: aload_1
    //   17: iconst_1
    //   18: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   21: aload_1
    //   22: invokevirtual 1017	java/lang/reflect/Field:getDeclaringClass	()Ljava/lang/Class;
    //   25: invokevirtual 1020	java/lang/Class:isArray	()Z
    //   28: ifeq +54 -> 82
    //   31: aload_1
    //   32: aconst_null
    //   33: aload_0
    //   34: getfield 539	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   37: getfield 1022	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   40: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: ldc 193
    //   45: ldc_w 546
    //   48: invokevirtual 532	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   51: astore_1
    //   52: aload_1
    //   53: iconst_1
    //   54: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 207	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   62: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 184	android/util/LongSparseArray
    //   68: astore_2
    //   69: aload_1
    //   70: aconst_null
    //   71: aload_0
    //   72: getfield 553	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   75: getfield 1024	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   78: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   81: return
    //   82: aload_1
    //   83: aconst_null
    //   84: aload_0
    //   85: getfield 539	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   88: getfield 1022	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   91: iconst_0
    //   92: aaload
    //   93: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   96: goto -53 -> 43
    //   99: astore_1
    //   100: getstatic 99	com/tencent/theme/SkinEngine:DEBUG	Z
    //   103: ifeq -22 -> 81
    //   106: ldc 43
    //   108: ldc_w 1026
    //   111: aload_1
    //   112: invokestatic 589	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   115: pop
    //   116: return
    //   117: astore_1
    //   118: ldc 193
    //   120: ldc_w 577
    //   123: invokevirtual 532	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   126: astore_1
    //   127: aload_1
    //   128: iconst_1
    //   129: invokevirtual 370	java/lang/reflect/Field:setAccessible	(Z)V
    //   132: aload_1
    //   133: aload_0
    //   134: getfield 207	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   137: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: astore_2
    //   141: aload_2
    //   142: instanceof 559
    //   145: ifeq +16 -> 161
    //   148: aload_1
    //   149: aconst_null
    //   150: aload_0
    //   151: getfield 584	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/e;
    //   154: getfield 1029	com/tencent/theme/e:b	Landroid/util/SparseArray;
    //   157: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   160: return
    //   161: aload_2
    //   162: instanceof 184
    //   165: ifeq -84 -> 81
    //   168: aload_1
    //   169: aconst_null
    //   170: aload_0
    //   171: getfield 553	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   174: getfield 1024	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   177: invokevirtual 374	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   180: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	SkinEngine
    //   15	68	1	localField1	Field
    //   99	13	1	localException1	Exception
    //   117	1	1	localException2	Exception
    //   126	43	1	localField2	Field
    //   68	94	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	43	99	java/lang/Exception
    //   82	96	99	java/lang/Exception
    //   118	160	99	java/lang/Exception
    //   161	180	99	java/lang/Exception
    //   43	81	117	java/lang/Exception
  }
  
  public void writeCacheFile(File paramFile)
    throws IOException
  {
    this.t.a(paramFile);
  }
  
  private class a
    extends AsyncTask<Context, Void, Context>
  {
    private a() {}
    
    protected Context a(Context... paramVarArgs)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground start");
      }
      SkinEngine.this.a(paramVarArgs[0]);
      System.gc();
      Thread.yield();
      System.gc();
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground done");
      }
      return paramVarArgs[0];
    }
    
    protected void a(Context paramContext)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute start");
      }
      SkinEngine.a(SkinEngine.this, null);
      SkinEngine.a(SkinEngine.this, SkinEngine.a(SkinEngine.this));
      Intent localIntent = new Intent("com.tencent.qqlite.qplus.THEME_INVALIDATE");
      localIntent.putExtra("pid", Process.myPid());
      paramContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      if (SkinEngine.SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute sendBroadcast(ACTION_THEME_INVALIDATE)");
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute done");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.theme.SkinEngine
 * JD-Core Version:    0.7.0.1
 */